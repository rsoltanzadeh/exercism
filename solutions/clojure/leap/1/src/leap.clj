(ns leap)

(defn leap-year?
  "Determine if a year is a leap year"
  [year]
  ;; function body
  (or (= (mod year 400) 0)
      (and (= (mod year 4) 0)
           (not= (mod year 100) 0))))
