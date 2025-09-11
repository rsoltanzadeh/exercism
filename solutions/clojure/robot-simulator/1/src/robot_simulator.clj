(ns robot-simulator
  (:require [clojure.string :as str]))

(defn robot
  "Creates a robot at the given coordinates, facing the given direction."
  [coordinates direction]
  {:coordinates coordinates
    :bearing direction})

(defn turn
  [robot direction]
  (let [current-direction (:bearing robot)]
    (assoc robot :bearing (if (= direction "R")
                            (cond
                              (= current-direction :north) :east
                              (= current-direction :east)  :south
                              (= current-direction :south) :west
                              (= current-direction :west)  :north)
                            (cond
                              (= current-direction :north) :west
                              (= current-direction :east)  :north
                              (= current-direction :south) :east
                              (= current-direction :west)  :south)))))
    

(defn move
  [robot instruction]
  (cond
    (= instruction "R") (turn robot "R")
    (= instruction "L") (turn robot "L")
    (= instruction "A") (let [current-direction (:bearing robot)]
                          (cond
                            (= current-direction :west) (assoc-in robot [:coordinates :x]  (dec (get-in robot [:coordinates :x])))
                            (= current-direction :east) (assoc-in robot [:coordinates :x]  (inc (get-in robot [:coordinates :x])))
                            (= current-direction :north) (assoc-in robot [:coordinates :y] (inc (get-in robot [:coordinates :y])))
                            (= current-direction :south) (assoc-in robot [:coordinates :y] (dec (get-in robot [:coordinates :y])))))))

(defn simulate
  "Simulates the robot's movements based on the given instructions
  and updates its state."
  [instructions robot-state]
  (loop [ins instructions
         state robot-state]
    (if (str/blank? ins)
      state
      (recur (apply str (rest ins)) 
             (move state (str (first ins)))))))
