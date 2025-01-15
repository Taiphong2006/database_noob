(ns database-noob.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [next.jdbc :as jdbc]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))


(def db
  {:dbtype "postgres"
   :dbname "datanoob"
   :port "5432"
   :password "postgres"
   :user "postgres"
   :host "127.0.0.1"})

(def ds (jdbc/get-datasource db))

(defn handle-str
[s]
(if (string? s)
(str "'" s "'")
s))

(defn find_customer
  [ds params]
  (jdbc/execute-one! ds [(str "select * from customer where " (name (first (keys params))) " = " (handle-str (first (vals params))) " and " (name (last (keys params))) " = " (handle-str (last (vals  params))))]))






































