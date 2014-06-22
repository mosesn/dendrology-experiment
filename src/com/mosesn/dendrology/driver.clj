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
  (peek (io-number tree 0)))

(defn bfs-number [trees idx]
  (cond
   (empty? trees) clojure.lang.PersistentQueue/EMPTY
   :else (let [head (peek trees)]
           (match head
                  {:name name
                   :left left
                   :right right} (let [result (bfs-number (conj (conj (pop trees) left) right) (inc idx))]
                                   (conj (pop (pop result)) {:name
[name idx]
                                                             :left (peek (pop result))
                                                             :right (peek result)}))
                   name (conj (bfs-number (pop trees) (inc idx)) [name idx])))))

(defn bfs-order [tree]
  (peek (bfs-number (conj clojure.lang.PersistentQueue/EMPTY tree) 0)))

(defn tests []
  ; In-order twice
  (pretty-print (in-order (in-order (construct-rand-tree))))

  ; Bfs-order twice
  (pretty-print (bfs-order (bfs-order (construct-rand-tree))))

  ; In-order then bfs-order
  (pretty-print (bfs-order (in-order (construct-rand-tree))))
)

(defn -main [& args]
  (tests))
