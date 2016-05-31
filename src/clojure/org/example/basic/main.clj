(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.threading :refer [on-ui]]
  )
  (:import android.widget.TextView
  )
)

(defactivity org.example.basic.MainActivity

  (onCreate [this bundle]
    (.superOnCreate this bundle)
    (on-ui
      (set-content-view! this
        [:text-view {:text "Hi there!"
                     :text-size (float 64)}]))
  )

)
