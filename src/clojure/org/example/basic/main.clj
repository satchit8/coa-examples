(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.log :as log]
            [neko.resource :refer [import-all]]
            [neko.threading :refer [on-ui]]
  )
)

(import-all)

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
          [:image-view {:image R$drawable/splash_circle}]
        ))
    ) ;

  )

)
