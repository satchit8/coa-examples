(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.log :as log]
            [neko.notify :refer [cancel
                                 fire
                                 notification]]
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
                           :layout-width :fill
                           :orientation :vertical}
           [:button {:on-click
                     (fn [_]
                       (fire :open-settings
                         (notification
                           {:ticker-text "Tada!"
                            :content-title "Awesome Title"
                            :content-text "Some important text"
                            :action [:activity Settings/ACTION_SETTINGS]})))
                     :text "Notify"
                     :text-size (float 32)}]
           [:button {:on-click (fn [_]
                                 (cancel :open-settings))
                     :text "Cancel"
                     :text-size (float 32)}]
          ]
        ))
    ) ;

  )

)
