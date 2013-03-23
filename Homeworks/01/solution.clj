(defn bisect [f neg-point pos-point close-enough?]
  (let [middle-point (/ (+ neg-point pos-point) 2)]
  (cond
    (close-enough? neg-point pos-point) middle-point
    (= (f middle-point) 0) middle-point
    (> (f middle-point) 0) (bisect f neg-point middle-point close-enough?)
    :else (bisect f middle-point pos-point close-enough?))))

(defn abs [n]
  (if (neg? n) (- n) n))

(defn make-bisector [tolerance]
  (fn [f a b]
    (cond
      (> (* (f a) (f b)) 0) nil
      (< (f a) 0) (bisect f a b #(< (abs (- %1 %2)) tolerance))
      :else (bisect f b a #(< (abs (- %1 %2)) tolerance)))))

(defn make-queue [])
(defn push-to-queue [q x]
  (conj q x))
(defn peek-at-queue [q]
  (first q))
(defn pop-from-queue [q]
  (vec (rest q)))
(defn empty-queue? [q]
  (if (= (seq q) nil) true))
