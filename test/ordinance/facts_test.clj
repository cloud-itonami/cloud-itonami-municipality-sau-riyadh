(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest riyadh-has-spec-basis
  (let [sb (facts/spec-basis "riyadh")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://") sb))
    (is (every? :ordinance/number sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "jeddah")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["riyadh" "jeddah"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["jeddah"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["riyadh.cabinet-decision-717-1974-development-authority"]
         (mapv :ordinance/id (facts/by-topic "riyadh" :urban-planning))))
  (is (empty? (facts/by-topic "riyadh" :labor)))
  (is (empty? (facts/by-topic "jeddah" :urban-planning))))
