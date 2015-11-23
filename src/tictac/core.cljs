(ns tictac.core
  (:require
   [reagent.core :as r])
  (:require-macros
   [devcards.core :refer [defcard-rg defcard-doc deftest]]
   [cljs.test :refer [is]]))

(enable-console-print!)

(defcard-doc
  "# Tic Tac Toe
   Happy hacking!")

;; Logic
;; Hier kommt side-effect-freie Logik hin


;; State
;; Hier wird der app-state verwaltet


;; Components
;; Hier definieren wir reagent-components


;; Tests
;; Platz für ein paar Unit tests


;; Cards
;; Hier die devcards

(defcard-rg hallo
  [:p "Hallo Welt"])
