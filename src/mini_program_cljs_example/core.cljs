(ns mini-program-cljs-example.core
  (:require-macros
   [mini-program-cljs.macro
    :refer [call-promise-1 wx-fun-dev wx-fun evaluate-args c-log]])
  (:require
   ;; 开发mini-program-cljs库时需要引用miniprogram-automator模拟器
   [miniprogram-automator :as automator]
   [mini-program-cljs.core :as mini-cljs]
   [mini-program-cljs.js-wx :refer
    [mini-program current-page] :as jswx]))

;; 1. 初始化mini-program变量: 操作微信开发者工具的模拟器的变量mini-program
(jswx/reset-mini-program automator)

;; 2. 初始化current-page变量: 当前微信小程序的页面
(jswx/reset-current-page)

;; mini-program 成功获取的样子
;; => #object[cljs.core.Atom {:val #object[MiniProgram [object Object]]}]

;; current-page 成功获取的样子
;; => #object[cljs.core.Atom {:val #object[Page [object Object]]}]#object[cljs.core.Atom {:val #object[Page [object Object]]}];; => #object[cljs.core.Atom {:val #object[Page [object Object]]}]

;; 打印日志到微信开发者控制台
(c-log @mini-program "aaaa" "bbb" "cccc"
  #js {:aaa 111 :bb "222dsadsa" :cc #js {:ooo 11 :bb "33"}})

;; 日志弹窗到页面
(jswx/log #js {:aa 11} #js {:bb 22 :cc 33})

;; 万能的eval
(evaluate-args @mini-program
  (fn [arg1 arg2]  (js/console.log arg1 "," arg2))
  "Hi, " #js {:name "mini-program-cljs"})
