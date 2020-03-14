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

### 6. `C-x C-e`执行`src/mini_program_cljs_example/core.cljs`,确认mini-program-cljs能正常连接到mini-program-cljs-example的repl来

``` clojure
;; 开发mini-program-cljs库时需要引用miniprogram-automator模拟器
(ns mini-program-cljs.core
   (:require [miniprogram-automator :as automator]))

(reset-mini-program automator)

(wx-fun-dev @mini-program checkSession)

(call-promise-1
  (fn [res] (prn "=====" res))  ;;=> "=====" #js {:errMsg "checkSession:ok"}
  (wx-check-session :success (fn [res] res)))

```
