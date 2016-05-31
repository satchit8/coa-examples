(ns org.example.basic.main
  (:require [neko.activity :refer [defactivity]]
            [neko.threading :refer [on-ui]]
  )
  (:import android.widget.TextView
  )
)

(defactivity org.example.basic.MainActivity

  (onCreate [this bundle]
    (.superOnCreate this bundle)
    (on-ui
      (.setContentView this
        (doto (TextView. this)
          (.setText "Hi there!")
          (.setTextSize (float 64)))))
  )

)
