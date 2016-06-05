(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.find-view :refer [find-view]]
            [neko.log :as log]
            [neko.notify :refer [toast]]
            [neko.threading :refer [on-ui]]
  )
)

(defactivity org.example.basic.MainActivity
  :key :main

  (onCreate [this bundle]
    (log/d "onCreate")
    (.superOnCreate this bundle)
    (let [
          this (*a)
          label-text-a "A Nice Label"
          label-text-b "THE Nice Label"
         ]
      (on-ui
        (set-content-view! this
          [:linear-layout {:gravity :center
                           :layout-height :fill
                           :layout-width :fill
                           :orientation :vertical}
           [:text-view {:id ::a-tv
                        :text label-text-a
                        :text-size (float 32)}]
           [:button {:on-click (fn [_]
                                 (when-let [a-tv (find-view this ::a-tv)]
                                   (.setText a-tv
                                     (if (= (.getText a-tv)
                                           label-text-a)
                                       label-text-b
                                       label-text-a))))
                     :text "Press Me"
                     :text-size (float 32)}]
          ]
        ))
    ) ;

  )

)
