(let [swt (symbol (str
           "org.eclipse/swt"
           "-" (let [name (System/getProperty "os.name")]
                 (cond
                  (.startsWith name "Windows") "win32-win32"
                  (= name "Mac OS X") "cocoa-macosx"))
           "-" (System/getProperty "os.arch")))
      target (if
               (= *command-line-args* '("uberjar" "applet"))
               (symbol "bertin.applet")
               (symbol "bertin.core"))]
  (defproject bertin "1.0.0-SNAPSHOT"
    :description "Semiology of Graphics"
    :dependencies [[org.clojure/clojure "1.2.1"]
                   [org.clojure/clojure-contrib "1.2.0"]
                   [~swt "3.5.2"]]
    :main ~target))
