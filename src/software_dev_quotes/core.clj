(ns software-dev-quotes.core
  (:use ring.adapter.jetty)
  (:use hiccup.core)
  (:use ring.middleware.content-type)
  (:require [environ.core :refer [env]])
  (:gen-class))

(defn my-handler
  [request]
  {
   :status  200
   :headers {"Content-Type" "text/html; charset=UTF-8"}
   :body    (html [:html
                   [:head
                    [:title "Software Development quotes"]
                    [:meta {:charset "utf-8"}]
                    ]
                   [:body [:p "Hello from the software dev quotes app"]]])
   }
  )

(defn -main
  "Fires up the Ring app"
  [& args]
  (let [port (Integer. (or (env :port) 5000))]
    (run-jetty my-handler {:port port})))
