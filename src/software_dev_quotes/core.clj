(ns software-dev-quotes.core
  (:use ring.adapter.jetty)
  (:require [environ.core :refer [env]])
  (:gen-class))


(defn my-handler
  [request]
  {
   :status  200
   :headers {"Content-Type" "text/plain"}
   :body    "Hello from Software dev quotes"
   }
  )

(defn -main
  "Fires up the Ring app"
  [& args]
  (let [port (Integer. (or (env :port) 5000))]
    (run-jetty my-handler {:port port})))
