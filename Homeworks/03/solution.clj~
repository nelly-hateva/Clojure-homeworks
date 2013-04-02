(def ^:dynamic *counter* (atom 0))
(defn reset-counter! []
  (reset! *counter* 0))
(defn count! []
  (swap! *counter* inc))
(defn get-count []
  @*counter*)


(def mapping (atom {}))
(defn add-metrics [func fkey]
  (do
    (swap! mapping conj {fkey (atom {})})
    (fn [& args]
      (if (not= nil (@(@mapping fkey) args))
        (swap! (@mapping fkey) update-in [args] inc)
        (swap! (@mapping fkey) conj [args 1]))
      (apply func args))))

(defn calls [fkey & args]
  (let [count-calls (get @(@mapping fkey) args)]
    (if (not= nil count-calls)
      count-calls
      0)))


(def ^:dynamic *before*)
(def ^:dynamic *after*)
(def result (atom 0))
(defn add-events [fun fkey]
  (fn [& args]
    (do
      (if (thread-bound? #'*before*)
        (if (not= nil (*before* fkey))
          (apply (*before* fkey) args)))
      (reset! result (apply fun args))
      (if (thread-bound? #'*after*)
        (if (not= nil (*after* fkey))
          (apply (*after* fkey) @result args))))))


(def ^:dynamic *cache-hit*)
(defn cache [func]
  (let [lookup-table (atom {})]
    (fn [& args]
	  (if-let [hit (find @lookup-table args)]
	    (do
	      (if (thread-bound? #'*cache-hit*)
	        (set! *cache-hit* true))
	      (val hit))
	    (let [result (apply func args)]
	      (if (thread-bound? #'*cache-hit*)
	        (set! *cache-hit* false))
	      (swap! lookup-table assoc args result)
	      result)))))


(defn annotated [fvar]
  (let [meta-data (meta fvar)
        cached (meta-data :cached)
        events (meta-data :events)
        metrics (meta-data :metrics)]
    (cond-> fvar
            (= cached true) (cache )
            (not= nil events) (add-events events)
            (not= nil metrics) (add-metrics metrics))))
