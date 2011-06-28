(ns bertin.core
  (:gen-class)
  (:import (org.eclipse.swt SWT)
           (org.eclipse.swt.widgets Display Shell)
           (org.eclipse.swt.layout FillLayout)
           (org.eclipse.swt.browser Browser BrowserFunction)))

(defn -main [& args]
  (let [display (Display.)
        shell (Shell. display)
        browser (Browser. shell SWT/NONE)
        func (proxy
                 [BrowserFunction]
                 [browser "clj"]
               (function [arguments] (eval (read-string (aget arguments 0)))))]
    (.setLayout shell (FillLayout.))
    (.open shell)
    (.setUrl browser (str "file://" (.getCanonicalPath (clojure.java.io/file "." "bertin.html"))))
    (loop []
      (if (.isDisposed shell)
        (.dispose display)
        (do
          (if (not (.readAndDispatch display))
            (.sleep display))
          (recur))))))
