(defproject bertin "1.0.0-SNAPSHOT"
  :description "Semiology of Graphics"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [org.eclipse/swt-cocoa-macosx-x86_64 "3.5.2"]]
  :jvm-opts ["-Xmx1g" "-XstartOnFirstThread"]
  :main bertin.core)
