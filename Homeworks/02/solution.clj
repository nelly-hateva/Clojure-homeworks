(defn game [player0 player1]
  [0 0])

(defn first-last-three-rule [player]
  (let [vectors (vectors-player player)
        cartesian-product (for [v1 vectors v2 vectors]
                            (if-not (identical? v1 v2)
                              (cons v1 v2)))
    ;take 3 
    ;take-last 3 

(defn vectors-player [player]
  (filter vector? (vals player)))
    
