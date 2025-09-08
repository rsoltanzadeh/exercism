(ns resistor-color)


(def color->number
  {"black" 0
   "brown" 1
   "red" 2
   "orange" 3
   "yellow" 4
   "green" 5
   "blue" 6
   "violet" 7
   "grey" 8
   "white" 9})

(def colors ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"]

  )

(defn color-code
  "Returns the numerical value associated with the given color"
  [color]
  (get color->number (clojure.string/lower-case color)))
