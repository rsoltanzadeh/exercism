(ns largest-series-product)

(defn parseint
  [scoll]
  (map #(Integer/parseInt (str %)) scoll))

(defn largest-product
  "Returns the largest product of any consecutive digits of length span in the string s."
  [span s]
  ;; function body
  (cond
    (> span (count s)) 
    (throw (IllegalArgumentException. "span must not exceed string length"))
    
    (not (re-matches #"^\d+$" s)) 
    (throw (NumberFormatException. "digits input must only contain digits"))
    
    (< span 0) 
    (throw (IllegalArgumentException. "span must not be negative"))
    
    :else (->> s
            (partition span 1)
            (map parseint)
            (map #(reduce * %))
            (reduce max))))


