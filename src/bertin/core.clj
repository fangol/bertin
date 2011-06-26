(ns bertin.core
  (:gen-class)
  (:require clojure.contrib.repl-utils)
  (:import (org.eclipse.swt SWT)
           (org.eclipse.swt.widgets Display Shell)
           (org.eclipse.swt.layout FillLayout)
           (org.eclipse.swt.browser Browser)))

(defn -main [& args]
  (let [display (Display.)
        shell (Shell. display)
        browser (Browser. shell SWT/NONE)]
    (.setLayout shell (FillLayout.))
    (.open shell)
    (loop []
      (if (.isDisposed shell)
        (.dispose display)
        (do
          (if (not (.readAndDispatch display))
            (.sleep display))
          (recur))))))
