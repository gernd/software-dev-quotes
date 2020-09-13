(ns software-dev-quotes.core
  (:use ring.adapter.jetty)
  (:use hiccup.core)
  (:use ring.middleware.content-type)
  (:use clojure.tools.trace)
  (:require [environ.core :refer [env]])
  (:gen-class))

(def quotes [{:quote "The real problem is that programmers have spent far too much time worrying about efficiency
             in the wrong places and at the wrong times; premature optimization is the root of all evil
             (or at least most of it) in programming." :from "Donald Knuth"}
             {:quote "Any fool can write code that a computer can understand.
              Good programmers write code that humans can understand." :from "Martin Fowler"}])

(defn get-random-quote []
  "Returns a random quote from the available quotes"
  (nth quotes (rand-int (count quotes))))

(defn my-handler
  [request]
  (let [random-quote (get-random-quote)]
    {:status  200
     :headers {"Content-Type" "text/html; charset=UTF-8"}
     :body    (html [:html
                     [:head
                      [:title "Software Development quotes"]
                      [:meta {:charset "utf-8"}]
                      [:link {:href "https://fonts.googleapis.com/css?family=Press+Start+2P" :rel "stylesheet"}]
                      [:link {:href "https://unpkg.com/nes.css@2.3.0/css/nes.min.css" :rel "stylesheet"}]]
                     [:body [:h1 "Hello folks from the software dev quotes app"]
                      [:div.nes-container.with-title.is-centered
                       [:p.title "Random quote"]
                       [:p.nes-balloon.from-left (str (:quote random-quote) " - " (:from random-quote))]]
                      [:a {:href "https://github.com/gernd/software-dev-quotes"} [:i.nes-icon.github.is-small] " Contribute on github"]]])}))

(defn -main
  "Fires up the Ring app"
  [& args]
  (let [port (Integer. (or (env :port) 5000))]
    (run-jetty my-handler {:port port})))
