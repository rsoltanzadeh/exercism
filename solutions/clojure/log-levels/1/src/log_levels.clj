(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (clojure.string/trim (clojure.string/join " " (drop 1 (clojure.string/split s #" ")))))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (->>
    (clojure.string/split s #" ")
    (first)
    (drop 1)
    (drop-last 2)
    (apply str)
    (clojure.string/lower-case)
    (clojure.string/trim)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s)
       " ("
       (log-level s)
       ")"))
