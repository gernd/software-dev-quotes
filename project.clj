(defproject my-ring-app "0.1.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring "1.8.0"]
                 [environ "1.1.0"]
                 [hiccup "1.0.5"]
                 ]
  :main ^:skip-aot software-dev-quotes.core
  :uberjar-name "software-dev-quotes.jar"
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :main my-ring-app.core}})
