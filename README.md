## 成为mini-program-cljs开发者的示例项目和文档(MacOS和Emacs开发者)

### 1. git clone本项目下来到本地,第一次用微信开发者工具打开

### 2. 填入本示例项目的deps.edn, shadow-cljs.edn 和 package.json

```clojure
;; deps.edn 需要填入你本地的mini-program-cljs库的路径
mini-program-cljs      {:local/root "/Users/clojure/CljPro/wechat-clj/mini-program-cljs"}

```

### 3. 执行安装模拟器

``` shell
./npm_build.sh

```

### 4. 启动开发者的模拟器

``` shell
./open_cli_ws.sh
```

### 5. 打开`src/mini_program_cljs_example/core.cljs`,并执行下面命令

``` shell
M-x cider-jack-in-cljs => 选择 shadow-cljs => 选择 node-repl

;; 如需开发宏,在cljs的cider repl下执行:
M-x cider-connect-sibling-cljs
```

### 6. 启动Repl开发: `C-x C-e`执行`src/mini_program_cljs_example/core.cljs`,确认mini-program-cljs能正常连接到mini-program-cljs-example的repl来

``` clojure
;; 开发mini-program-cljs库时需要引用miniprogram-automator模拟器
(ns mini-program-cljs.core
   ...
   (:require [miniprogram-automator :as automator]))

;; 获取模拟器的变量mini-program
(reset-mini-program automator)

;; mini-program 成功获取的样子
;; => #object[cljs.core.Atom {:val #object[MiniProgram [object Object]]}]

;; 测试模拟器变量是否正常
(.callWxMethod @mini-program
    "showToast"
    #js {:title "Hello, mini-program-cljs-example!"
         :icon "none"
         :mask false
         :duration 10000})
```

* 成功设置好的开发环境如下截图

![](https://github.com/chanshunli/mini-program-cljs-example/raw/master/mini-program-cljs-example.png)
