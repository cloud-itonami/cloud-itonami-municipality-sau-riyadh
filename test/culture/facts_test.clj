(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest riyadh-has-culture-basis
  (let [sb (facts/spec-basis "riyadh")]
    (is (= 8 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "riyadh" (:culture/municipality %)) sb))
    (is (every? #(= "SAU" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "jeddah")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["riyadh" "jeddah"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["jeddah"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "riyadh" :dish))))
  (is (= ["riyadh.beverage.arabic-coffee"]
         (mapv :culture/id (facts/by-kind "riyadh" :beverage))))
  (is (empty? (facts/by-kind "riyadh" :craft)))
  (is (empty? (facts/by-kind "jeddah" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
