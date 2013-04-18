(def counter (atom 0))

(defn devNum [sum position]
  (let [denominations [1, 2, 5, 10, 20, 50, 100]]
      (loop [p 7]
        (when (pos? p)
          (let [k (nth denominations (dec p))]
            (if (> n k)
                mp[pos] = k
                if mp[ps] <= mp[pos-1]
                  (recur (- n k) (inc pos)))
            (else if (= n k)
                mp[pos]=k
                if mp[pos] <= mp[pos-1]
                    (swap! atom inc)))))))

(defn count-change [sum]
  (future (devNum sum 1))
  @counter)
