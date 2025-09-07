(ns rna-transcription)

(defn to-rna-single
  [foo]
  (cond
    (= \G foo) "C"
    (= \C foo) "G"
    (= \T foo) "A"
    (= \A foo) "U"
    :else ""))

(defn to-rna
  "Returns the RNA complement of the given DNA string sequence."
  [dna]
  ;; function body
  (apply str (map to-rna-single dna)))

