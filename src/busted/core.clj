(ns busted.core
  (:require [cheshire.core :refer :all]
            [org.httpkit.client :as http]
            [clj-time.core :as clj-time]
            [clj-time.coerce :as coerce]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn parse-long
  "Parses the string and returns the first number"
  [s]
  (Long/valueOf (re-find #"[0-9]+" s)))

(defn arrival-times
  "Returns a promise with the arrival times of buses at stop"
  [stop]
  (http/get (str "http://api.maxx.co.nz/RealTime/v2/Departures/Stop/" stop "?hours=1")))

(defn parse-arrival
  "Parses the response from the bus api and returns the Movements key as a map"
  [response]
  (:Movements (parse-string (:body @response) true)))

(defn parse-bus-date
  "Parses the date format used by the Maxx api"
  [s]
  (coerce/from-long (parse-long s)))

(defn update-dates
  [map]
  (into map (for [k [:ActualArrivalTime :ActualDepartureTime]] [k (parse-bus-date (map k))])))


