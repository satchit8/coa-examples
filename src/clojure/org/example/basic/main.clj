(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.notify :refer [toast]]
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
          [:button {:on-click (fn [_]
                                (toast "Hi there!" :long))
                    :text "Press Me"
                    :text-size (float 32)}
          ]
        ))
    ) ;

  )

)
