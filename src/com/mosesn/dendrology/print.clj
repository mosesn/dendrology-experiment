(ns com.mosesn.dendrology.driver)
(use '[clojure.core.match :only (match)])

(defn tabify [i]
  (clojure.string/join (repeat i "\t")))

(defn position [i word]
  (str (tabify i) word))

; TODO: this is recursive
(defn s-rec [tree depth]
  (match tree
    {:name name
     :left left
     :right right} (do
                     (s-rec left (+ depth 1))
                     (println "\n")
                     (println (position depth name))
                     (println "\n")
                     (s-rec right (+ depth 1)))
     :else (println (position depth tree))))

(defn pretty-print [tree]
  (s-rec tree 0))
