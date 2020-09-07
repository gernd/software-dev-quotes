(defproject software-dev-quotes "0.1.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.1"]
                 [environ "1.2.0"]
                 [hiccup "1.0.5"]
                 [org.clojure/tools.trace "0.7.10"]
                 ]
  :plugins [
            [lein-ring "0.12.5"]
            [lein-ancient "0.6.15"]
            [lein-cljfmt "0.6.6"]
            [lein-cloverage "1.1.2"]
            ]
  :ring {:handler software-dev-quotes.core/my-handler}
  :main ^:skip-aot software-dev-quotes.core
  :uberjar-name "software-dev-quotes.jar"
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :main software-dev-quotes.core}})
