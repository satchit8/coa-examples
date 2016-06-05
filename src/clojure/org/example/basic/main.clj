(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.intent :as intent]
            [neko.log :as log]
            [neko.threading :refer [on-ui]]
  )
  (:import android.provider.Settings
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
                           :layout-width :fill}
           [:button {:on-click (fn [_]
                                 (.startActivity this
                                   (intent/intent Settings/ACTION_SETTINGS
                                     {})))
                     :text "Press Me"
                     :text-size (float 32)}]
          ]
        ))
    ) ;

  )

)
