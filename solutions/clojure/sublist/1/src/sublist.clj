(ns sublist)

(defn classify
  [coll1 coll2]
  (cond
    (= coll1 coll2) :equal
    (clojure.set/subset? coll2 coll1) :superlist
    (clojure.set/subset? coll1 coll2) :sublist
    :else :unequal)
  )
