(ns perfect-numbers)

(defn factors
  ([num]
  (factors num 1))
  
  ([num divisor]
  (if (< (clojure.math/sqrt num) divisor)
    #{}
    (concat 
     (if (= 0 (mod num divisor))
       (set [divisor (/ num divisor)])
       #{})
     (factors num (+ 1 divisor))))))

(defn factors2 [num]
  (loop [div 1
         acc #{}]
    (if (> div (Math/sqrt num))
      acc
      (recur (inc div)
             (if (zero? (mod num div))
               (cond-> acc
                 true (conj div)
                 (not= div (/ num div)) (conj (/ num div)))
               acc)))))

(defn classify
  "Classifies the given number as perfect, abundant, or deficient."
  [num]
  ;; function body
  
  (let [foo (- (reduce + (factors2 num)) num)]
    (cond 
      (= foo num) :perfect
      (< foo num) :deficient
      :else :abundant)))

