(ns com.mosesn.dendrology.driver)
(use '[clojure.core.match :only (match)])
(load "print")

(defn make-tree [size]
  (case size
    0 :leaf
    (let [next (- size 1)
          half (quot next 2)]
      {:name :inner
       :left (make-tree (- next half)),
       :right (make-tree half)})))

(defn construct-rand-tree []
  (let [size (+ 25 (rand-int 25))]
    (make-tree size)))

(defn io-number [tree number]
  (match tree
         {:name name
          :left left
          :right right} (let [[left-num new-left] (io-number left (inc number))
                              [right-num new-right] (io-number right (inc left-num))]
                          [right-num {:name [name number]
                               :left new-left
                               :right new-right}])
          :else [number [tree number]]))

(defn in-order [tree]
  (io-number tree 0))

(defn -main [& args]
  (print-bfs (nth (in-order (construct-rand-tree)) 1)))
;  (pretty-print (nth (in-order (construct-rand-tree)) 1)))
