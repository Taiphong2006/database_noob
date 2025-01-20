(ns database-noob.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [next.jdbc :as jdbc]
            [cheshire.core :as json]
            [ring.util.response :as response]))


(defn -main
  [& args]
  (println "Hello, World!"))


(def db
  {:dbtype "postgres"
   :dbname "datanoob"
   :port "5432"
   :password "postgres"
   :user "postgres"
   :host "127.0.0.1"})


(def ds (jdbc/get-datasource db))

(defn customer-data
  [ds]
  (jdbc/execute! ds ["select * from customer"]))

(json/generate-string(customer-data ds))

(defroutes app-routes
  (GET "/" [] "<h1>Hello World</h1>")
  (GET "/customers" [] (->  (customer-data ds)
                            (json/generate-string)
                            (response/response)
                            (response/content-type "application/json")))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))







































