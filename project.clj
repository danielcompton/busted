(defproject busted "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clojurewerkz/cassaforte "1.3.0-beta7"]
                 [http-kit "2.1.16"]
                 [cheshire "5.3.1"]
                 [clj-time "0.6.0"]]
  :main ^:skip-aot busted.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
