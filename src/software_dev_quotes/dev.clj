(ns software-dev-quotes.dev
  "Functionality for developing using the REPL"
  (:require [clojure.test :refer :all]
            [software-dev-quotes.core-test :refer :all]
            [clojure.test :refer :all]))

(defn reload-and-run-tests
  "Reloads and runs all tests"
  []
  (load "core_test")
  (run-tests 'software-dev-quotes.core-test))