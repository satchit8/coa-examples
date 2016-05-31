(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.threading :refer [on-ui]]
  )
)

(defactivity org.example.basic.MainActivity
  :key :main

  (onCreate [this bundle]
    (.superOnCreate this bundle)
    (let [
          this (*a)
         ]
      (on-ui
        (set-content-view! this
          [:text-view {:text "Hi there!"
                       :text-size (float 64)}]))
    ) ;

  )

)
