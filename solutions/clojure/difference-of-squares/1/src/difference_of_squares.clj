(ns difference-of-squares)

(defn square
  [n]
  (* n n))

(defn square-of-sum
  "Returns the square of the sum of the numbers up to the given number"
  [n]
  ;; function body
  (square (reduce + (range 1 (+ n 1)))))

(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to the given number"
  [n]
  ;; function body
  (reduce +
          (map square (range 1 (+ n 1)))))

(defn difference
  "Returns the difference between the square of the sum of numbers up to a given number and the sum of the squares of those numbers"
  [n]
  ;; function body
  (- (square-of-sum n) (sum-of-squares n)))
