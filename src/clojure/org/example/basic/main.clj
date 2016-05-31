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
          [:button {:on-click (fn [_]
                                (log/d "toasting!")
                                (toast "Hi there!" :long))
                    :text "Press Me"
                    :text-size (float 32)}
          ]
        ))
    ) ;

  )

  (onResume [this]
    (log/d "onResume")
    (.superOnResume this)
  )

  (onPause [this]
    (log/d "onPause")
    (.superOnPause this)
  )

  (onStart [this]
    (log/d "onStart")
    (.superOnStart this)
  )

  (onStop [this]
    (log/d "onStop")
    (.superOnStop this)
  )

  (onDestroy [this]
    (log/d "onDestroy")
    (.superOnDestroy this)
  )

)
