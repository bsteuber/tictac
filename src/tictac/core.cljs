(ns tictac.core
  (:require
   [cljs.test :refer-macros [is]]
   [devcards.core :refer-macros [defcard-rg
                                 defcard-doc
                                 deftest
                                 start-devcard-ui!]]
   [reagent.core :as r]))

(enable-console-print!)

(defcard-doc
  "# Tic Tac Toe
   Happy hacking!")

(defcard-rg hallo
  [:p "Hallo Welt"])

(deftest example
  (is (= 3 (+ 1 2))))

(start-devcard-ui!)
