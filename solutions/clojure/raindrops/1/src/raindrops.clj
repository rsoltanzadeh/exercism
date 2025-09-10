(ns raindrops)

(defn divisible-by?
  [divisor number]
  (zero? (mod number divisor)))

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num]
  (cond-> nil
    (divisible-by? 3 num) (str "Pling")
    (divisible-by? 5 num) (str "Plang")
    (divisible-by? 7 num) (str "Plong")
    :always               (or (str num))))
