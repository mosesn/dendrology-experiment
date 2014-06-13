(ns com.mosesn.dendrology.driver)
(use '[clojure.core.match :only (match)])

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
          :right right} (let [[left-num new-left] (io-number left (+ number 1))
                              [right-num new-right] (io-number right (+ left-num 1))]
                          [right-num {:name [name number]
                               :left new-left
                               :right new-right}])
          :else [number [tree number]]))

(defn in-order [tree]
  (io-number tree 0)
  )

(defn tabify [i]
  (clojure.string/join (repeat i "\t")))

(defn position [i word]
  (clojure.string/join [(tabify i) word]))

(defn s-rec [tree depth]
  (match tree
    {:name name
     :left left
     :right right} (clojure.string/join [(s-rec left (+ depth 1)) "\n" (position depth name) "\n" (s-rec right (+ depth 1))])
     :else (position depth tree)))

(defn pretty-print [tree]
  (println (s-rec tree 0)))

(defn -main [& args]
  (pretty-print (nth (in-order (construct-rand-tree)) 1))
  )
