(ns triangle)

(defn triangle?
  "Is it a valid triangle?"
  [a b c]
  (and
     (>= (+ a b) c)
     (>= (+ a c) b)
     (>= (+ b c) a)
     (> a 0)
     (> b 0)
     (> c 0)))

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral; otherwise, returns false"
  [a b c]
  (and 
    (= a b c)
    (triangle? a b c)))

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles; otherwise, returns false"
  [a b c]
  (and 
    (or
     (= a b)
     (= a c)
     (= b c))
    (triangle? a b c)))

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene; otherwise, returns false"
  [a b c]
    (and (triangle? a b c) (not (isosceles? a b c))))
