(use 'clojure.test)

(load-file "solution.clj")

(deftest sample-test
  (testing "bank operations"
      (is (= (-> (make-account) (deposit 10) (withdraw 6) balance) 4))))

(run-tests)
