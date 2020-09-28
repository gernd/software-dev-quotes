(ns software-dev-quotes.core-test
  (:require [clojure.test :refer :all]
            [software-dev-quotes.core :refer :all]))

(deftest get-latest-quotes-not-empty
  (testing "Get latest quotes does not return an empty collection"
    (is (not (empty? (get-latest-quotes))))))

(deftest get-random-quote-not-empty
  (testing "Get random quote does not return nil"
    (is (not (nil? (get-random-quote))))))

(deftest my-handler-returns-200
  (testing "My handler returns status code 200"
    (is (= 200 (:status (my-handler nil))))))
