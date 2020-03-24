# [mini-program-cljs(ClojureScript微信小程序库)](https://github.com/chanshunli/wechat-clj/tree/master/mini-program-cljs)开发者的示例项目和文档

- [mini-program-cljs(ClojureScript微信小程序库)开发者的示例项目和文档](#mini-program-cljsclojurescript%E5%BE%AE%E4%BF%A1%E5%B0%8F%E7%A8%8B%E5%BA%8F%E5%BA%93%E5%BC%80%E5%8F%91%E8%80%85%E7%9A%84%E7%A4%BA%E4%BE%8B%E9%A1%B9%E7%9B%AE%E5%92%8C%E6%96%87%E6%A1%A3)
    - [1. git clone本项目和wechat-clj下来到本地,第一次用微信开发者工具打开本项目(即导入本项目到开发者工具), 并打开安全设置, 然后完全关闭微信开发者工具(请确保进程关闭)](#1-git-clone%E6%9C%AC%E9%A1%B9%E7%9B%AE%E5%92%8Cwechat-clj%E4%B8%8B%E6%9D%A5%E5%88%B0%E6%9C%AC%E5%9C%B0%E7%AC%AC%E4%B8%80%E6%AC%A1%E7%94%A8%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91%E8%80%85%E5%B7%A5%E5%85%B7%E6%89%93%E5%BC%80%E6%9C%AC%E9%A1%B9%E7%9B%AE%E5%8D%B3%E5%AF%BC%E5%85%A5%E6%9C%AC%E9%A1%B9%E7%9B%AE%E5%88%B0%E5%BC%80%E5%8F%91%E8%80%85%E5%B7%A5%E5%85%B7-%E5%B9%B6%E6%89%93%E5%BC%80%E5%AE%89%E5%85%A8%E8%AE%BE%E7%BD%AE-%E7%84%B6%E5%90%8E%E5%AE%8C%E5%85%A8%E5%85%B3%E9%97%AD%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91%E8%80%85%E5%B7%A5%E5%85%B7%E8%AF%B7%E7%A1%AE%E4%BF%9D%E8%BF%9B%E7%A8%8B%E5%85%B3%E9%97%AD)
    - [2. 填入下面配置到deps.edn文件](#2-%E5%A1%AB%E5%85%A5%E4%B8%8B%E9%9D%A2%E9%85%8D%E7%BD%AE%E5%88%B0depsedn%E6%96%87%E4%BB%B6)
    - [3. 执行安装模拟器](#3-%E6%89%A7%E8%A1%8C%E5%AE%89%E8%A3%85%E6%A8%A1%E6%8B%9F%E5%99%A8)
    - [4. 启动开发者的模拟器](#4-%E5%90%AF%E5%8A%A8%E5%BC%80%E5%8F%91%E8%80%85%E7%9A%84%E6%A8%A1%E6%8B%9F%E5%99%A8)
    - [5. Emacs打开`src/mini_program_cljs_example/core.cljs`,并在该文件buffer下执行下面命令](#5-emacs%E6%89%93%E5%BC%80srcmini_program_cljs_examplecorecljs%E5%B9%B6%E5%9C%A8%E8%AF%A5%E6%96%87%E4%BB%B6buffer%E4%B8%8B%E6%89%A7%E8%A1%8C%E4%B8%8B%E9%9D%A2%E5%91%BD%E4%BB%A4)
    - [6. 启动Repl开发: `C-x C-e`执行`src/mini_program_cljs_example/core.cljs`中的代码,确认mini-program-cljs能正常连接到mini-program-cljs-example的repl来](#6-%E5%90%AF%E5%8A%A8repl%E5%BC%80%E5%8F%91-c-x-c-e%E6%89%A7%E8%A1%8Csrcmini_program_cljs_examplecorecljs%E4%B8%AD%E7%9A%84%E4%BB%A3%E7%A0%81%E7%A1%AE%E8%AE%A4mini-program-cljs%E8%83%BD%E6%AD%A3%E5%B8%B8%E8%BF%9E%E6%8E%A5%E5%88%B0mini-program-cljs-example%E7%9A%84repl%E6%9D%A5)
    - [evaluate-args 使用: 和微信开发者工具的控制台是完全联通的,但是不能用cljs.core方法在里面测试(因为goog导入不了)](#evaluate-args-%E4%BD%BF%E7%94%A8-%E5%92%8C%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91%E8%80%85%E5%B7%A5%E5%85%B7%E7%9A%84%E6%8E%A7%E5%88%B6%E5%8F%B0%E6%98%AF%E5%AE%8C%E5%85%A8%E8%81%94%E9%80%9A%E7%9A%84%E4%BD%86%E6%98%AF%E4%B8%8D%E8%83%BD%E7%94%A8cljscore%E6%96%B9%E6%B3%95%E5%9C%A8%E9%87%8C%E9%9D%A2%E6%B5%8B%E8%AF%95%E5%9B%A0%E4%B8%BAgoog%E5%AF%BC%E5%85%A5%E4%B8%8D%E4%BA%86)
    - [基于S表达式Postwalk分离出来三种不同的代码执行环境: 关于evaluate-args(微信控制台环境) 和 wx.* 的环境 还有 current-page内部, 三者的开发环境的Repl开发打通方案](#%E5%9F%BA%E4%BA%8Es%E8%A1%A8%E8%BE%BE%E5%BC%8Fpostwalk%E5%88%86%E7%A6%BB%E5%87%BA%E6%9D%A5%E4%B8%89%E7%A7%8D%E4%B8%8D%E5%90%8C%E7%9A%84%E4%BB%A3%E7%A0%81%E6%89%A7%E8%A1%8C%E7%8E%AF%E5%A2%83-%E5%85%B3%E4%BA%8Eevaluate-args%E5%BE%AE%E4%BF%A1%E6%8E%A7%E5%88%B6%E5%8F%B0%E7%8E%AF%E5%A2%83-%E5%92%8C-wx-%E7%9A%84%E7%8E%AF%E5%A2%83-%E8%BF%98%E6%9C%89-current-page%E5%86%85%E9%83%A8-%E4%B8%89%E8%80%85%E7%9A%84%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83%E7%9A%84repl%E5%BC%80%E5%8F%91%E6%89%93%E9%80%9A%E6%96%B9%E6%A1%88)

*本文档适用于: MacOS和Emacs开发者, Linux微信开发者工具基于Wine编译小程序速度太慢*

[Youtube 演示视频](https://www.youtube.com/watch?v=Rmq3hCjdI6M)

### 1. git clone本项目和[wechat-clj](https://github.com/chanshunli/wechat-clj)下来到本地,第一次用微信开发者工具打开本项目(即导入本项目到开发者工具), 并打开安全设置, 然后完全关闭微信开发者工具(请确保进程关闭)

![Youtube演示视频](https://github.com/chanshunli/mini-program-cljs-example/raw/master/security_settings.png)

### 2. 填入下面配置到deps.edn文件

```clojure
;; deps.edn 需要填入你本地的mini-program-cljs库的路径
mini-program-cljs      {:local/root "/Users/clojure/CljPro/wechat-clj/mini-program-cljs"}

```

### 3. 执行安装模拟器

``` shell
# 需要填入mini-program-cljs-example的项目路径
./npm_build.sh ~/WeChatProjects/mini-program-cljs-example

```

### 4. 启动开发者的模拟器

``` shell
# 需要填入mini-program-cljs-example的项目路径
./open_cli_ws.sh ~/WeChatProjects/mini-program-cljs-example
```

### 5. Emacs打开`src/mini_program_cljs_example/core.cljs`,并在该文件buffer下执行下面命令

``` shell
M-x cider-jack-in-cljs => 选择 shadow-cljs => 选择 node-repl

;; 如需开发宏,在cljs的cider repl下执行:
M-x cider-connect-sibling-clj
```

### 6. 启动Repl开发: `C-x C-e`执行`src/mini_program_cljs_example/core.cljs`中的代码,确认mini-program-cljs能正常连接到mini-program-cljs-example的repl来

``` clojure

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

```

### evaluate-args 使用: 和微信开发者工具的控制台是完全联通的,但是不能用cljs.core方法在里面测试(因为goog导入不了)

* 传入cljs的函数作为参数进去会变成字符串,编译后的cljs代码的字符串
* 传入js的函数,会变成native code的字符串

``` clojure
(evaluate-args @mini-program
  (fn [arg]
    (js/console.log "---"
      (let [pages (js/getCurrentPages)
            len (.-length pages)
            current-page (aget pages (dec len))]
        current-page)
      )
    )
  #js [1 2 3])
;;=> 打印出来 page对象了

(evaluate-args @mini-program
  (fn [arg]
    (js/console.log "---"
      (let [app (js/getApp)]
        (.-globalData app)
        )
      )
    )
  #js [])
;;=> 打印出来app.globalData


;;变量共享: 可以在控制台上看到这个变量
(evaluate-args @mini-program
  (fn [arg1]
    (js/console.log "---"
      (set! js/aabb arg1)
      )
    )
  #js [1 2 3])

;; this使用: 下面代码会打印出来`window {...}`
(evaluate-args @mini-program
  (fn [arg1]
    (js/console.log "---"
      (this-as this
        this)
      )
    )
  #js [])

```

* 成功设置好的开发环境如下截图

![](https://github.com/chanshunli/mini-program-cljs-example/raw/master/mini-program-cljs-example.png)

### 基于S表达式Postwalk分离出来三种不同的代码执行环境: 关于evaluate-args(微信控制台环境) 和 wx.* 的环境 还有 current-page内部, 三者的开发环境的Repl开发打通方案

* 三个环境的混合wx,page内部,控制台, 通过错误分析来S表达式分开来分别执行后组合起来
* evaluate-args内部没有cljs的执行环境,所以如果catch到cljs未定义的错误,那么就分离出来需要cljs的部分和不需要cljs的部分, 不需要cljs的部分执行结束后保存到中间变量里面, 将结果传递出来给cljs的代码处理
* S表达式解析和Postwalk新的cljs解释器的构建,分离出来代码需要不同的执行环境,执行并且返回结果最终组合起来: repl一个本地环境模拟出来三种环境才是对的选择,解耦甚至可以脱离微信开发者工具你的开发的解释工具还能解释所有情况,那么这就是一个合格的开发环境了
