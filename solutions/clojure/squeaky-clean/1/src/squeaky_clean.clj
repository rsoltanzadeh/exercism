(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn step-1 [s] (str/replace s " " "_"))

(defn step-2 [s] (str/replace s #"[\u0000-\u001F\u007F-\u009F]" "CTRL"))

(defn step-3 [s]
  (let [[h & t] (str/split s #"-")]
    (apply str h (map #(str (str/upper-case (first %)) (rest %)) t))))

(defn step-4 [s]
  (str/replace s #"[^\p{L}\p{M}_]" ""))

(defn step-5 [s]
  (str/replace s #"[α-ω]" ""))

(defn clean
  "TODO: add docstring"
  [s]
  (->> s
    (step-1)
    (step-2)
    (step-3)
    (step-4)
    (step-5)))
