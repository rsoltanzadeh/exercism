(ns two-fer)

(defn two-fer
  "Return what you will say as you give away the extra cookie"
  ([name]
  ;; function body
  (str "One for " name ", one for me."))
  
  ([]
  (two-fer "you")))
