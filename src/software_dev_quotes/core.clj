(ns software-dev-quotes.core
  (:use ring.adapter.jetty)
  (:use hiccup.core)
  (:use ring.middleware.content-type)
  (:require [environ.core :refer [env]])
  (:gen-class))

(def quotes [{:quote "The real problem is that programmers have spent far too much time worrying about efficiency
             in the wrong places and at the wrong times; premature optimization is the root of all evil
             (or at least most of it) in programming." :from "Donald Knuth"}])

(defn my-handler
  [request]
  {:status  200
   :headers {"Content-Type" "text/html; charset=UTF-8"}
   :body    (html [:html
                   [:head
                    [:title "Software Development quotes"]
                    [:meta {:charset "utf-8"}]
                    [:link {:href "https://fonts.googleapis.com/css?family=Press+Start+2P" :rel "stylesheet"}]
                    [:link {:href "https://unpkg.com/nes.css@2.3.0/css/nes.min.css" :rel "stylesheet"}]]
                   [:body [:p "Hello folks from the software dev quotes app"]
                    [:div.nes-container.with-title.is-centered
                     [:p.title "Random quote"]
                     [:p.nes-balloon.from-left "This is a very clever quote. - someone"]
                     [:p [:i.nes-icon.is-small.like]]
                     [:p "Good morning. Thou hast had a good night's sleep, I hope."]]
                    [:a {:href "https://www.github.com"} [:i.nes-icon.github.is-small] " Contribute on github"]]])})

(defn -main
  "Fires up the Ring app"
  [& args]
  (let [port (Integer. (or (env :port) 5000))]
    (run-jetty my-handler {:port port})))
