(ns culture.facts
  "Regional-culture catalog for Riyadh -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"riyadh"
   [{:culture/id "riyadh.dish.kabsa"
     :culture/name "Kabsa"
     :culture/name-local "كبسة"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :dish
     :culture/summary "Arab mixed rice dish of rice, meat, vegetables and aromatic spices, commonly regarded as a national dish in the Gulf Cooperation Council countries including Saudi Arabia."
     :culture/url "https://en.wikipedia.org/wiki/Kabsa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "riyadh.dish.harees"
     :culture/name "Harees"
     :culture/name-local "هريس"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :dish
     :culture/summary "Dish of boiled cracked wheat mixed with meat, spices and butter, commonly eaten in the Arabian Peninsula and Gulf region, particularly during Ramadan."
     :culture/url "https://en.wikipedia.org/wiki/Harees"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "riyadh.dish.tharid"
     :culture/name "Tharid"
     :culture/name-local "ثريد"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :dish
     :culture/summary "Arab bread soup of crumbled flatbread moistened in broth or stew, originating from Mecca in Saudi Arabia and commonly served during Ramadan; a national rather than Riyadh-specific dish."
     :culture/url "https://en.wikipedia.org/wiki/Tharid"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "riyadh.beverage.arabic-coffee"
     :culture/name "Arabic coffee"
     :culture/name-local "قهوة عربية"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :beverage
     :culture/summary "Traditional brew of Coffea arabica beans typically flavored with cardamom; light roasting is common in Saudi Arabia, and it is recognized by UNESCO as an Intangible Cultural Heritage of Arab states."
     :culture/url "https://en.wikipedia.org/wiki/Arabic_coffee"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "riyadh.festival.riyadh-season"
     :culture/name "Riyadh Season"
     :culture/name-local "موسم الرياض"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :festival
     :culture/summary "Annual series of entertainment, cultural and sporting events held in Riyadh, organized to support tourism and Saudi Vision 2030."
     :culture/url "https://en.wikipedia.org/wiki/Riyadh_Season"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "riyadh.heritage.masmak-fortress"
     :culture/name "Masmak Fortress"
     :culture/name-local "قصر المصمك"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :heritage
     :culture/summary "Historic clay-and-mudbrick fort in Riyadh, central to the 1902 Battle of Riyadh and now a museum."
     :culture/url "https://en.wikipedia.org/wiki/Masmak_Fortress"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "riyadh.heritage.diriyah"
     :culture/name "Diriyah"
     :culture/name-local "الدرعية"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :heritage
     :culture/summary "Town on the northwestern outskirts of Riyadh, capital of the first Saudi state (1727-1818); its At-Turaif District was declared a UNESCO World Heritage Site in 2010."
     :culture/url "https://en.wikipedia.org/wiki/Diriyah"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "riyadh.heritage.murabba-palace"
     :culture/name "Murabba Palace"
     :culture/name-local "قصر المربع"
     :culture/municipality "riyadh"
     :culture/country "SAU"
     :culture/kind :heritage
     :culture/summary "Historic palace in the al-Murabba neighborhood of Riyadh, official residence and workplace of King Abdulaziz from 1938 to 1953, now a museum."
     :culture/url "https://en.wikipedia.org/wiki/Murabba_Palace"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-sau-riyadh culture catalog "
                 "(ADR-2607171400): " (count (get catalog "riyadh"))
                 " Riyadh entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
