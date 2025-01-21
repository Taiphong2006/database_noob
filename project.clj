(defproject database-noob "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [com.github.seancorfield/next.jdbc "1.3.981"]
                 [org.postgresql/postgresql "42.7.4"]
                 [cheshire "5.13.0"]
                 [ring/ring-core "1.13.0"]
                 [ring/ring-jetty-adapter "1.8.2"]
                 [javax.xml.bind/jaxb-api "2.3.1"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler database-noob.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})


