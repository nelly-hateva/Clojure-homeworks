(defn make-account []
  (atom 0 :validator integer?))

(defn balance [account]
  @account)

(defn deposit [account amount]
  (swap! account + amount)
  account)

(defn withdraw [account amount]
  (deposit account (- amount)))
