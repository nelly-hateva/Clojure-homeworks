(defn count-element [element coll]
  (count (filter #(= element %) coll)))

(defn histogram [coll]
  (vec (map-indexed (fn [index element] (count-element index coll))
         (repeat (+ 1 (apply max coll)) 0))))
