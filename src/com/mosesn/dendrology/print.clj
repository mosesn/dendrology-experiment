(ns com.mosesn.dendrology.driver)
(use '[clojure.core.match :only (match)])

(defn tabify [i]
  (clojure.string/join (repeat i "\t")))

(defn position [i word]
  (str (tabify i) word))

(defn s-rec [tree depth]
  (match tree
    {:name name
     :left left
     :right right} (do
                     (s-rec left (inc depth))
                     (println (position depth name))
                     (s-rec right (inc depth)))
     :else (println (position depth tree))))

(defn pretty-print [tree]
  (s-rec tree 0))

; TODO add in depth information
(defn breadth-first [trees]
  (cond
    (empty? trees) (println "finished")
    :else (let [head (peek trees)]
            (match head
                   [{:name name
                    :left left
                    :right right} depth] (do
                                    (println (position depth name))
                                    (breadth-first (conj (conj (pop trees) [left (inc depth)]) [right (inc depth)])))
                    [h depth] (do
                            (println (position depth h))
                            (breadth-first (pop trees)))))))

(defn print-bfs [tree]
  (breadth-first (conj clojure.lang.PersistentQueue/EMPTY [tree 0])))
