(ns darts)

(defn distance
  "Calculates the distance from center"
  [x y]
  (clojure.math/sqrt (+ (* x x)
                        (* y y))))

(defn score
  "Calculates the score of a dart throw"
  [x y]
  ;; function body
  (cond 
    (<= (distance x y) 1) 10
    (<= (distance x y) 5) 5
    (<= (distance x y) 10) 1
    :else 0))

