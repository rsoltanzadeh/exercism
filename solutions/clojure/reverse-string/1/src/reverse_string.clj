(ns reverse-string)

(defn reverse-string
  "Reverses the given string"
  [s]
  ;; function body
  (clojure.string/join "" (reverse s)))
