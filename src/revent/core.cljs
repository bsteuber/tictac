(ns revent.core
  (:require [reagent.core :as r]))

(defn log [& objs]
  (let [s (pr-str-with-opts objs (assoc (pr-opts) :readably false))]
    (.log js/console s))
  (last objs))

(defn make-system [& {:keys [init-state] :as system}]
  (merge system
         {:state (r/atom init-state)
          :event-log (r/atom [])}))

(defn handle [system event]
  (let [ {:keys [handlers event-log]} system
        [type & args] event]
    (swap! event-log conj event)
    (if-let [handler (handlers type)]
      (apply handler system args)
      (if (= type :unhandled-event)
        (log "unhandled event:" (:event event))
        (handle system {:type :unhandled-event
                        :event event})))))

(defn query [system query]
  (let [{:keys [queries state]} system
        [key & args] query
        query-fn (key queries)]
    (if query-fn
      (apply query-fn state args)
      (log "no query fn for key:" key))))
