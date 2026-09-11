(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Riyadh -- the
  THIRTY-NINTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok, -are-abu-dhabi,
  -vnm-hanoi, -idn-jakarta, -phl-manila, -egy-cairo, -tur-ankara,
  -nga-abuja for the first thirty-eight) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). The axis's second Gulf
  entry (after Abu Dhabi, tick 98) and the first for Saudi Arabia, the
  largest Arab economy.

  Riyadh is Saudi Arabia's stable capital, with no ongoing ambiguity.

  alriyadh.gov.sa's own homepage offered only a portal/navigation hub
  with no specific regulation numbers or founding dates.
  balady.gov.sa's (Ministry of Municipal and Rural Affairs and
  Housing's official domain) own hosted PDF of the national Law of
  Municipalities and Villages rendered entirely illegible via
  Arabic-script font-subsetting (a new variant of this session's
  recurring PDF-illegibility pattern, here affecting Arabic text
  specifically rather than Latin/Cyrillic/Turkish scripts).

  Law of Municipalities and Villages (Royal Decree No. M/5/1397, 10
  February 1977 / 21 Safar 1397H) -- title, decree number, and both
  Gregorian and Hijri dates directly confirmed via the Lexis Middle
  East legal database (lexismiddleeast.com, the same category of
  established legal-database source used elsewhere this session for
  WIPO Lex / ECOLEX citations). The national founding-charter law for
  municipal governance, matching the pattern used for other
  municipalities when the city's own domain lacked specific detail.

  Establishment of the Supreme Authority of Riyadh Development (Cabinet
  Decision No. 717, 20 June 1974 / 29 Safar 1394H) -- directly
  confirmed via rcrc.gov.sa's (the Royal Commission for Riyadh City's
  own official domain, the body's current name after a 2018/2019
  reorganization) 'Establishment and evolution' page, which states
  verbatim: 'The Supreme Authority of Riyadh Development \"The Royal
  Commission for Riyadh City\" was established by cabinet decision No.
  717 on 20 June 1974 (29/05/1394H)'.

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"riyadh"
   [{:ordinance/id "riyadh.royal-decree-m5-1397-law-of-municipalities-and-villages"
     :ordinance/title "Law of Municipalities and Villages"
     :ordinance/municipality "riyadh"
     :ordinance/country "SAU"
     :ordinance/kind :local-act
     :ordinance/number "Royal Decree No. M/5/1397"
     :ordinance/url "https://www.lexismiddleeast.com/law/SaudiArabia/RoyalDecree_M5_1397/en"
     :ordinance/url-provenance :lexismiddleeast-legal-database
     :ordinance/enacted-date "1977-02-10"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}
    {:ordinance/id "riyadh.cabinet-decision-717-1974-development-authority"
     :ordinance/title "Establishment of the Supreme Authority of Riyadh Development (now Royal Commission for Riyadh City)"
     :ordinance/municipality "riyadh"
     :ordinance/country "SAU"
     :ordinance/kind :local-act
     :ordinance/number "Cabinet Decision No. 717"
     :ordinance/url "https://www.rcrc.gov.sa/en/establishment_and_evolution/"
     :ordinance/url-provenance :official-rcrc-gov-sa
     :ordinance/enacted-date "1974-06-20"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:urban-planning}}]})

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
      :note (str "cloud-itonami-municipality-sau-riyadh Wave 0 (ADR-2607141700): "
                 (count (get catalog "riyadh")) " Riyadh entries seeded "
                 "with lexismiddleeast.com/rcrc.gov.sa citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
