(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
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
         ]
      (on-ui
        (set-content-view! this
          [:linear-layout {:gravity :center
                           :layout-height :fill
                           :layout-width :fill
                           :orientation :vertical}
           [:text-view {:text "A Nice Label"
                        :text-size (float 32)}]
           [:button {:on-click (fn [_]
                                 (toast "Smile?" :long))
                     :text "Press Me"
                     :text-size (float 32)}]
          ]
        ))
    ) ;

  )

)
