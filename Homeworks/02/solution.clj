(defn game [player0 player1]
  [0 0])

(defn first-three [vector]
  (if (< (count vector) 3)
      []
      (subvec vector 0 3)))

(defn last-three [vector]
  (if (< (count vector) 3)
      []
      (subvec vector (- (count vector) 3))))

(defn vectors-player [player]
  (filter vector? (vals player)))

(defn count-element [element coll]
  (count (filter #(= element %) coll)))
    
