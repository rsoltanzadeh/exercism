(ns coordinate-transformation)

(defn translate2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y]
    [(+ dx x) (+ dy y)])
  )

(defn scale2d 
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y]
    [(* sx x) (* sy y)])
  )

(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [& args]
    (apply g (apply f args)))
  )

(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call,
   the memoized result is returned."
  [f]
  (let [previous (atom {:args nil :value nil})]
    (fn [& args]
      (do
        (when (not= args (:args @previous))
          (reset! previous {:args args :value (apply f args)}))  
        (:value @previous))))
  )
