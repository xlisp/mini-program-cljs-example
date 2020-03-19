# [mini-program-cljs(ClojureScript微信小程序库)](https://github.com/chanshunli/wechat-clj/tree/master/mini-program-cljs)开发者的示例项目和文档

*本文档适用于: MacOS和Emacs开发者*

### 1. git clone本项目和wechat-clj(https://github.com/chanshunli/wechat-cl)下来到本地,第一次用微信开发者工具打开, 打开安全设置, 然后完全关闭微信开发者工具(请确保进程关闭)

![](https://github.com/chanshunli/mini-program-cljs-example/raw/master/security_settings.png)

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

* 成功设置好的开发环境如下截图

![](https://github.com/chanshunli/mini-program-cljs-example/raw/master/mini-program-cljs-example.png)
