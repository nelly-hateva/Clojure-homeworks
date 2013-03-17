(use 'clojure.test)

(load-file "solution.clj")

(deftest sample-test
  (testing "count-element"
      (is (= 3 (count-element 3 [1 2 3 1 2 3 1 2 3])))
      (is (= 0 (count-element 8 [1 2 3 1 2 3 1 2 3])))
      (is (= 0 (count-element 3 [])))
      (is (= 1 (count-element 3 [1 2 3 1 2 1 2])))
      (is (= 3 (count-element 1 [1 2 3 1 2 3 1 2 3]))))
  (testing "histogram"
      (is (= [4 0 2] (histogram [0 0 0 0 2 2])))
      (is (= [0 3 0 0 1] (histogram '(1 1 1 4))))
      (is (= [1] (histogram [0])))
      (is (= [0 2 2 2 0 0 0 0 0 0 1] (histogram [1 2 3 1 2 3 10])))))

(run-tests)
