(ns bob
  (:require [clojure.string :as str]))

(defn yelling? [s] 
  (and 
   (= s (str/upper-case s))
   (some Character/isLetter s)))

(defn question? [s] (str/ends-with? s "?"))

(defn response-for [s]
  (let [q (str/trim s)]  
    (cond
      (and 
       (yelling? q) 
       (question? q)) "Calm down, I know what I'm doing!"
      (yelling? q)    "Whoa, chill out!"
      (question? q)   "Sure."
      (str/blank? q)  "Fine. Be that way!"
      :else           "Whatever.")))
