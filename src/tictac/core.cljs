(ns tictac.core
  (:require
   [devcards.core :refer-macros [defcard-rg
                                 defcard-doc
                                 deftest
                                 start-devcard-ui!]]
   [reagent.core :as r]))

(enable-console-print!)

(defcard-doc
  "# Tic Tac Toe
   Happy hacking! Test card...")

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

(start-devcard-ui!)
