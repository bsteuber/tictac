(ns revent.cards
  (:require [cljs.test     :refer-macros [is]]
            [devcards.core :refer-macros [defcard-rg defcard-doc deftest]]
            [reagent.ratom :refer-macros [reaction]]
            [revent.core   :as e :refer [log]]))

(enable-console-print!)

(defn inc-handler [{:keys [state]}]
  (swap! state update :counter inc))

(defn plus-handler [{:keys [state]} x]
  (swap! state update :counter + x))

(defn counter-query [state]
  (reaction (:counter @state)))

(deftest handle
  (let [sys (e/make-system
             :init-state {:counter 0}
             :handlers {:plus plus-handler
                        :inc inc-handler})]
    (e/handle sys [:plus 4])
    (is (= @(:state sys)
           {:counter 4}))
    (e/handle sys [:inc])
    (is (= @(:state sys)
           {:counter 5}))
    (is (= @(:event-log sys)
           [[:plus 4] [:inc]]))))

(deftest query
  (let [sys (e/make-system
             :init-state {:counter 0}
             :handlers {:inc inc-handler}
             :queries {:counter counter-query})
        counter (e/query sys [:counter])]
    (is (= 0 @counter))
    (e/handle sys [:inc])
    (is (= 1 @counter))))

(defn counter-component [sys]
  (let [counter (e/query sys [:counter])]
    (fn []
      [:p "Count: " @counter])))

(defn counter-system []
  (let [sys (e/make-system
             :init-state {:counter 0}
             :handlers {:tick inc-handler}
             :queries {:counter counter-query})]
    (js/setInterval #(e/handle sys [:tick])
                    1000)
    [counter-component sys]))

(defcard-rg counter
  counter-system)
