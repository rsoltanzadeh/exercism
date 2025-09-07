(ns flatten-array)

(defn safe-flatten
  [val]
  (if (coll? val)
    (mapcat safe-flatten val)
    [val]))

(defn flatten
  "Flattens the given sequential collection.
  Nil values are excluded from the result."
  ([coll]
   (remove nil? (safe-flatten coll))))
