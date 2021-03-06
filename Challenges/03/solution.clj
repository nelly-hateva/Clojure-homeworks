(defn interesting? [something]
  (let [meta-data (meta something)]
    (and (not= nil meta-data) (not= nil (meta-data :interesting)))))

(defn is-fn? [meta-map]
  (not= nil (meta-map :arglists)))

(defn one-arg? [function-meta]
  (let [arg-lists (function-meta :arglists)]
    (and (= 1 (count arg-lists))
         (= 1 (count (first arg-lists))))))

(defn inspect [name-space]
  (let [map-names (ns-map name-space)
        interesting-stuff (filter interesting? (vals map-names))
        interesting-values (mapv deref interesting-stuff)
        interesting-integers (filter integer? interesting-values)
        interesting-functions-meta (filter is-fn? (mapv meta interesting-stuff))
        interesting-functions (mapv :name interesting-functions-meta)]
    {:vectors (set (filter vector? interesting-values))
     :integers (set interesting-integers)
     :funcs (set interesting-functions)
     :positive (set (map :name interesting-functions-meta))
     :strings (set (filter string? interesting-values))}))
