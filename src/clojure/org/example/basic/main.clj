(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity
                                   set-content-view!]]
            [neko.debug :refer [*a]]
            [neko.dialog.alert :refer [alert-dialog-builder]]
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
                           :layout-width :fill}
           [:button {:on-click
                     (fn [_]
                       (.showDialog this 0))
                     :text "Press Me"
                     :text-size (float 32)}]
          ]
        ))
    ) ;

  )

  ;; XXX: but deprecated?
  (onCreateDialog [this id _]
    (-> (alert-dialog-builder this
          {:cancelable true
           :message "Decide?"
           :negative-text "Cancel"
           :negative-callback (fn [dialog res]
                                (toast "No!" :short))
           :positive-text "OK"
           :positive-callback (fn [dialog res]
                                (toast "Yes!" :short))})
      .create)
  )

)
