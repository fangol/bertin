(let [options (let [platform (System/getProperty "os.name")]
                (cond
                 (.startsWith platform "Windows")
                 {:os "win32-win32"
                  :jvm-opts ["-Xmx1g"]}
                 (= platform "Mac OS X")
                 {:os "cocoa-macosx"
                  :jvm-opts ["-Xmx1g" "-XstartOnFirstThread"]}))
      swt (symbol
           (str
            "org.eclipse/swt-"
            (:os options)
            "-"
            (System/getProperty "os.arch")))
      target (if
              (= *command-line-args* '("uberjar" "applet"))
              (symbol "bertin.applet")
              (symbol "bertin.core"))]
  (defproject bertin "1.0.0-SNAPSHOT"
    :description "Semiology of Graphics"
    :dependencies [[org.clojure/clojure "1.2.1"]
                   [org.clojure/clojure-contrib "1.2.0"]
                   [~swt "3.5.2"]]
    :jvm-opts ~(:jvm-opts options)
    :main ~target))
