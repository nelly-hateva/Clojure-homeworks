(use 'clojure.test)

(load-file "solution.clj")

(deftest sample-test
  (testing "count-change"
    (is (= 1 (count-change 1)))
    (is (= 3 (count-change 4)))
    (is (= 6 (count-change 7)))))

(run-tests)
