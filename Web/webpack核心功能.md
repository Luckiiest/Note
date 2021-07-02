## webpack核心功能

### webpack的安装和使用

安装：

推荐本地安装

安装命令：`$ npm i -D webpack webpack-cli`

 

运行webpack命令：`$ npx webpack`

也可以在package.json文件里的`"scripts"`里添加`"build":webpack`，就可以直接使用命令：`$ npm run build`来运行webpack。

 

如果不告知运行环境，则默认生产环境

`$ npx webpack --mode=development`   开发环境

`$ npx webpack --mode=production`      生产环境

### 编译结果分析

代码如下：

```
//合并两个模块
//  ./src/a.js
//  ./src/index.js

(function (modules) {
    var moduleExports = {}; //用于缓存模块的导出结果
    //require函数相当于是运行一个模块，得到模块导出结果
    function __webpack_require(moduleId) { //moduleId就是模块的路径
        if (moduleExports[moduleId]) {
            //检查是否有缓存
            return moduleExports[moduleId];
        }
        var func = modules[moduleId]; //得到该模块对应的函数
        var module = {
            exports: {}
        }
        func(module, module.exports, __webpack_require); //运行模块
        var result = module.exports; //得到模块导出的结果
        moduleExports[moduleId] = result; //缓存起来
        return result;
    }
    //执行入口模块
    return __webpack_require("./src/index.js"); //require函数相当于是运行一个模块，得到模块导出结果
})({ //该对象保存了所有的模块，以及模块对应的代码
    "./src/a.js": function (module, exports) {
        eval("console.log(\"module a\")\nmodule.exports = \"a\";\n //# sourceURL=webpack:///./src/a.js")
    },
    "./src/index.js": function (module, exports, __webpack_require) {
        eval("console.log(\"index module\")\nvar a = __webpack_require(\"./src/a.js\")\na.abc();\nconsole.log(a)\n //# sourceURL=webpack:///./src/index.js")
    }
});
```

创建一个对象用于存放每个模块，并且将每个模块的路径作为该模块对应的id即属性值，每个属性的属性值为一个函数该函数就是用来执行模块中的代码的，对于commonJs来说每个函数传入的三个参数module, exports, require, 在main.js中由一个立即执行函数将创建的模块对象作为参数传入到该立即执行函数中，并用modules接收， 这样做的目的是防止modules污染全局变量，在立即执行函数中定义已缓存的模块和require函数。

### 配置文件

webpack的默认文件为webpack.config.js,当然也可以手动修改，通过`npx webpack --config 文件名`来指定配置文件,并且在配置文件中需要通过commonjs导出一个配置对象.

**注意**: 在配置文件中只能使用commonjs和规范的node代码

当配置文件中的设置与命令行冲突时以命令行为基准，例如配置文件中设置的`mode: production;` 而当我们通过命令行打包的时候使用的命令是`npx webpack --mode development`, 这种时候是以命令行为准



**为什么?不是说webpack可以识别各种模块化标准吗?**

一定要彻底理解打包的过程，首先webpack打包的过程是在node环境下的，通过读取入口文件来分析依赖关系，也就是说我们在src中写的所有功能代码在打包的过程中都不会执行，只是被当作文件读取，而配置文件则是在打包过程中要执行的，webpack通过分析配置文件导出的配置信息打包，所以在配置文件中只能使用commonjs和使用node代码，否则在打包的过程中就会报错，而且是在命令行中报错，而我们写的功能代码就算有错误在打包的时候也不会报错，而是在执行最后打包完成之后的出口文件时报错，所以，最后打包完成时形成的js文件就跟我们的代码和文件目录和模块没有任何关系了，就是一个独立出来的js代码，放到哪都可以执行。

### 基本配置

- mode: development/production，设置打包之后的js文件是在开发环境下的格式还是运行环境下的格式
- entry: 设置入口文件，对象，默认情况下是src文件夹下的index.js文件
- output: 设置出口文件，对象，默认是在dist文件夹下的main.js 文件

### devtool配置

使用source map来解决调试问题

配置值：

- none: 在生产环境中默认为none，即没有源码地图，报错在最终生成的压缩文件中，给生产环境配置为none则生产环境生成的文件中每个模块的代码不会被放到eval中去
- eval: 在开发环境中默认为eval 还有很多，要用的时候去看一下文档

具体的配置见文档：https://www.webpackjs.com/configuration/devtool/

### 编译过程

webpack 的作用是将源代码编译（构建、打包）成最终代码

整个过程大致分为三个步骤

1. 初始化
2. 编译
3. 输出

**初始化**

此阶段，webpack会将**CLI参数**、**配置文件**、**默认配置**进行融合，形成一个最终的配置对象。

对配置的处理过程是依托一个第三方库`yargs`完成的

此阶段相对比较简单，主要是为接下来的编译阶段做必要的准备

目前，可以简单的理解为，初始化阶段主要用于产生一个最终的配置

**编译**

1. **创建chunk**

chunk是webpack在内部构建过程中的一个概念，译为`块`，它表示通过某个入口找到的所有依赖的统称。

根据入口模块（默认为`./src/index.js`）创建一个chunk

![img]()![2020-01-09-11-54-08.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293030702-ac748c8c-677d-44c5-b536-dd14b2349af2.png)

每个chunk都有至少两个属性：

- name：默认为main
- id：唯一编号，开发环境和name相同，生产环境是一个数字，从0开始

1. **构建所有依赖模块**

![img]()![2020-01-09-12-32-38.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293067061-a8e2c17b-e563-4393-a7ca-10140237655e.png)

> AST在线测试工具：https://astexplorer.net/

简图

![2020-01-09-12-35-05.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293117094-9c567a58-fb52-4e0b-a948-5fb3b03e29cc.png)

1. **产生chunk assets**

在第二步完成后，chunk中会产生一个模块列表，列表中包含了**模块id**和**模块转换后的代码**

接下来，webpack会根据配置为chunk生成一个资源列表，即`chunk assets`，资源列表可以理解为是生成到最终文件的文件名和文件内容

![2020-01-09-12-39-16.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293148709-8c9a8f4d-4efb-41a6-ba61-818f4d9289d1.png)

> chunk hash是根据所有chunk assets的内容生成的一个hash字符串
>
> hash：一种算法，具体有很多分类，特点是将一个任意长度的字符串转换为一个固定长度的字符串，而且可以保证原始内容不变，产生的hash字符串就不变

简图

![2020-01-09-12-43-52.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293180988-1d45f19f-7493-4ac6-a6e1-720c0b22ebe1.png)

1. **合并chunk assets**

将多个chunk的assets合并到一起，并产生一个总的hash

![img]()![2020-01-09-12-47-43.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293202302-6527e25a-72d3-4d55-9036-87ec9720778a.png)

**输出**

此步骤非常简单，webpack将利用node中的fs模块（文件处理模块），根据编译产生的总的assets，生成相应的文件。

![img]()![2020-01-09-12-54-34.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293248114-9b93b848-6048-4a66-82a2-af06c6018501.png)

**总过程**

![img]()![2020-01-09-15-51-07.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293265956-e1dc7b95-1e61-4f22-b124-d52c9a93a7cb.png)

![2020-01-09-12-32-38.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293277352-1e67e31b-7e7c-4f09-86e8-88b9afa58c01.png)![img]()

**涉及术语**

1. module：模块，分割的代码单元，webpack中的模块可以是任何内容的文件，不仅限于JS
2. chunk：webpack内部构建模块的块，一个chunk中包含多个模块，这些模块是从入口模块通过依赖分析得来的
3. bundle：chunk构建好模块后会生成chunk的资源清单，清单中的每一项就是一个bundle，可以认为bundle就是最终生成的文件
4. hash：最终的资源清单所有内容联合生成的hash值
5. chunkhash：chunk生成的资源清单内容联合生成的hash值
6. chunkname：chunk的名称，如果没有配置则使用main
7. id：通常指chunk的唯一编号，如果在开发环境下构建，和chunkname相同；如果是生产环境下构建，则使用一个从0开始的数字进行编号

### 入口和出口

**前提node知识：**

1. "./":

1. 1. 模块化代码中代表当前js文件所在的目录
   2. 路径处理中表示当前js所在的node执行目录，也就是在那通过node命令执行./就表示在哪个目录

1. __dirname: 在所有情况下都表示当前js所在目录，并且是绝对路径
2. path内置模块，`require('path')`返回一个对象，该对象中提供了很多处理路径的方法，期中一个`path.resolve('./', 'a', 'b')`可以连接多段路径，在路径处理中./表示当前js的执行目录，所以该方法可以方便的获取绝对路径

**出口、入口**

```
//在配置文件webpack.config.js中
module.exports = {
    mode: 'development',
    entry: {
        main: './src/index.js',
        a: ['./src/a.js', './src/index.js'] //这时就是有两个chunk
        /*为一个chunk设置多个入口文件*/
    },
    output: {
        path: path.resolve(__dirname, 'target'),//必须是一个绝对路径，表示最终的asset放置的文件夹，默认是dist文件夹
        filename: "bundle.js", //静态设定 //配置每一个chunk中生成的资源中的js文件的规则
        filename: "[name].js" //动态规则，[name]表示每个chunk的name
        /* [hash:5]表示总资源的hash，冒号表示取前多少位数字，
        常用于处理浏览器缓存，浏览器一般第一次加载文件的时候都会缓存，
        但是如果在浏览器缓存之后我们又修改了代码那么因为文件名没有变化，
        浏览器就不会请求了直接使用上一次缓存的文件，所以使用hash，
        只要当内容改变就会产生一个完全不一样的hash，文件名就会发生改变，
        这样浏览器就会重新请求*/
        /*[chunkhash] 表示每一个chunk中的hash
    }
}
```

- **入口其实配置的是chunk，每一个属性就是一个chunk，属性名为chunk名，属性值为chunk的入口文件，并不是一个入口文件对应一个chunk，一个chunk可以有多个入口文件，但是即使有多个入口文件一个chunk最后也只有一个资源**

**出口**

这里的出口是针对资源列表的文件名或路径的配置

出口通过output进行配置

**入口**

**入口真正配置的是chunk**

入口通过entry进行配置

规则：

- name：chunkname
- hash: 总的资源hash，通常用于解决缓存问题
- chunkhash: 使用chunkhash
- id: 使用chunkid，不推荐

### 出口、入口最佳实践

- webpack打包后的文件中，每个文件都有一段重复代码会带来什么影响？

> 首先明白什么情况下会出现公共代码，比如一些第三方库，我们可能在很多个页面中都要使用，那么这时候每个页面打包出来的文件就会有这些公共代码，但是这些公共代码并不会给我们的维护带来影响，因为这些公共代码一般都是些第三方库，我们是不需要维护这些代码的。其实这些公共代码带来的影响就是会增加浏览器请求负担。

下面是一些经典场景

**一个页面一个JS**

![img]()![2020-01-10-12-00-28.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293578413-7e26d29f-66cc-4cf3-8c31-ff09c994ee3d.png)

源码结构

```
|—— src
    |—— pageA   页面A的代码目录
        |—— index.js 页面A的启动模块
        |—— ...
    |—— pageB   页面B的代码目录
        |—— index.js 页面B的启动模块
        |—— ...
    |—— pageC   页面C的代码目录
        |—— main1.js 页面C的启动模块1 例如：主功能
        |—— main2.js 页面C的启动模块2 例如：实现访问统计的额外功能
        |—— ...
    |—— common  公共代码目录
        |—— ...
```

webpack配置

```
module.exports = {
    entry:{
        pageA: "./src/pageA/index.js",
        pageB: "./src/pageB/index.js",
        pageC: ["./src/pageC/main1.js", "./src/pageC/main2.js"]
    },
    output:{
        filename:"[name].[chunkhash:5].js"
    }
}
```

这种方式适用于页面之间的功能差异巨大、公共代码较少的情况，这种情况下打包出来的最终代码不会有太多重复

**一个页面多个JS**

![img]()![2020-01-10-12-38-03.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293594615-f5ef999a-32fc-4808-bffa-f78257ab0103.png)

源码结构

```
|—— src
    |—— pageA   页面A的代码目录
        |—— index.js 页面A的启动模块
        |—— ...
    |—— pageB   页面B的代码目录
        |—— index.js 页面B的启动模块
        |—— ...
    |—— statistics   用于统计访问人数功能目录
        |—— index.js 启动模块
        |—— ...
    |—— common  公共代码目录
        |—— ...
```

webpack配置

```
module.exports = {
    entry:{
        pageA: "./src/pageA/index.js",
        pageB: "./src/pageB/index.js",
        statistics: "./src/statistics/index.js"
    },
    output:{
        filename:"[name].[chunkhash:5].js"
    }
}
```

这种方式适用于页面之间有一些**独立**、相同的功能，专门使用一个chunk抽离这部分JS有利于浏览器更好的缓存这部分内容。

> **为什么不使用多启动模块的方式？**
>
> 答：这种方式是可以的，但是导致增加传输量，浏览器没法缓存公共的代码。

**单页应用**

所谓单页应用，是指整个网站（或网站的某一个功能块）只有一个页面，页面中的内容全部靠JS创建和控制。 vue和react都是实现单页应用的利器。

![img]()![2020-01-10-12-44-13.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609293618982-97ecb9cc-6ef1-4cb0-a38b-0e7dd3aa2e4a.png)

源码结构

```
|—— src
    |—— subFunc   子功能目录
        |—— ...
    |—— subFunc   子功能目录
        |—— ...
    |—— common  公共代码目录
        |—— ...
    |—— index.js
```

webpack配置

```
module.exports = {
    entry: "./src/index.js",
    output:{
        filename:"index.[hash:5].js"
    }
}
```

### loader

> loader的本质其实就是一个函数，该函数接收源码字符串，然后返回一个处理后的代码字符串，所以loader作用的时候是在读取文件后生成AST树之前

**全流程：**

![img]()![2020-01-13-09-28-52.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609294003216-541e627b-6c04-47e5-8fe0-40acb544f129.png)

**chunk中解析模块的流程：**

![img]()![2020-01-13-09-29-08.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609294009496-0ffbdec5-48b0-4e42-9eb9-1509dbdf7d1e.png)

**chunk中解析模块的更详细流程：**

![img]()![2020-01-13-09-35-44.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609294016813-1184e4ce-7ae0-4942-ad21-c9407f4ba70e.png)

**处理loaders流程：**

![img]()![2020-01-13-10-29-54.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609294022277-841f7914-922e-45eb-ac83-df92fe6ba85f.png)

**loader配置**

```
module.exports = {
    module: {
        rules: [
            {
                test: ,/*test是一个正则表达式，用来匹配符合条件的模块路径，
                即能被该正则表达式匹配到的路径对应的模块会使用该规则中的loaders进行解析*/
                use: [
                    {
                        loader: //加载器的路径
                        options:{
                            //更多配置，可以通过第三方库loader-utils来获取options中的内容
                        }
                    }
                ]//use就是匹配成功之后需要使用的loaders
            },//规则1
            {}//规则2
        ] //模块的匹配规则,其中每一个规则是一个对象
    }
}
```

**简化配置**

```
module.exports = {
    module: { //针对模块的配置，目前版本只有两个配置，rules、noParse
        rules: [ //模块匹配规则，可以存在多个规则
            { //每个规则是一个对象
                test: /\.js$/, //匹配的模块正则
                use: ["模块路径1", "模块路径2"]//loader模块的路径，该字符串会被放置到require中
            }
        ]
    }
}
```

**同一个文件匹配到多个规则时从上往下匹配，每匹配到一个规则中的use数组就把里面的loader加入到一个数组中，然后在真正执行loader的时候从数组的后面往前面运行**

**use中的loader路径最终其实是被require读取的**

### plugin

loader的功能定位是转换代码，而一些其他的操作难以使用loader完成，比如：

- 当webpack生成文件时，顺便多生成一个说明描述文件
- 当webpack编译启动时，控制台输出一句话表示webpack启动了
- 当xxxx时，xxxx

这种类似的功能需要把功能嵌入到webpack的编译流程中，而这种事情的实现是依托于plugin的

![2020-01-15-12-45-16.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609333854057-9d86051a-010a-4c0d-9788-b38c7aa463cc.png)

plugin的**本质**是一个带有apply方法的对象

```
var plugin = {
    apply: function(compiler){
        
    }
}
```

通常，习惯上，我们会将该对象写成构造函数的模式

```
class MyPlugin{
    apply(compiler){
    }
}
var plugin = new MyPlugin();
```



要将插件应用到webpack，需要把插件对象配置到webpack的plugins数组中，如下：

```
module.exports = {
    plugins:[
        new MyPlugin()
    ]
}
```

apply函数会在初始化阶段，创建好Compiler对象后运行。

compiler对象是在初始化阶段构建的，整个webpack打包期间只有一个compiler对象，后续完成打包工作的是compiler对象内部创建的compilation

apply方法会在初始化阶段**创建好compiler对象后调用**，并向方法传入一个compiler对象

> **compiler对象和compilation对象有什么区别？**
>
> 答：compiler对象内部创建的compilation，具体的打包过程是由compilation来完成的。当文件发生变化时，也就是说当webpack启动监听文件变化时，compilation将重新创建，也就是说compiler只有一个，而compilation可以有多个。

![img]()![2020-01-15-12-49-26.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609333867152-fd53ee1f-91c5-412e-acb1-62f8edfb084f.png)

compiler对象提供了大量的钩子函数（hooks，可以理解为事件），plugin的开发者可以注册这些钩子函数，参与webpack编译和生成。

你可以在apply方法中使用下面的代码注册钩子函数:

```
class MyPlugin{
    apply(compiler){
        //在这里注册时间，类似于window.onload $(function(){})
        compiler.hooks.事件名称.事件类型(name, function(compilation){
            //事件处理函数
        })
    }
}
```

**事件名称**

即要监听的事件名，即钩子名，所有的钩子：https://www.webpackjs.com/api/compiler-hooks

**事件类型**

这一部分使用的是 Tapable API，这个小型的库是一个专门用于钩子函数监听的库。

它提供了一些事件类型：

- tap：注册一个同步的钩子函数，函数运行完毕则表示事件处理结束
- tapAsync：注册一个基于回调的异步的钩子函数，函数通过调用一个回调表示事件处理结束
- tapPromise：注册一个基于Promise的异步的钩子函数，函数通过返回的Promise进入已决状态表示事件处理结束

**处理函数**

处理函数有一个事件参数`compilation`

### 区分环境

### 其他细节配置

**context**

```
context：path.resolve(``__dirname,``"app")
```

该配置会影响入口和loaders的解析，入口和loaders的相对路径会以context的配置作为基准路径，这样，你的配置会独立于CWD（current working directory 当前执行路径）

**output**

**1.library**

```
library``:`` ``"abc"
```

这样一来，打包后的结果中，会将自执行函数的执行结果暴露给abc

**2.libraryTarget**

```
libraryTarget``:`` ``"var"
```

该配置可以更加精细的控制如何暴露入口包的导出结果

其他可用的值有：

- var：默认值，暴露给一个普通变量
- window：暴露给window对象的一个属性
- this：暴露给this的一个属性
- global：暴露给global的一个属性
- commonjs：暴露给exports的一个属性
- 其他：https://www.webpackjs.com/configuration/output/#output-librarytarget

**target**

target:"web" //默认值

设置打包结果最终要运行的环境，常用值有

- web: 打包后的代码运行在web环境中
- node：打包后的代码运行在node环境中
- 其他：https://www.webpackjs.com/configuration/target/

**module.noParse**

noParse: /jquery/

不解析正则表达式匹配的模块，通常用它来忽略那些大型的单模块库，以提高**构建性能**

**resolve**

resolve的相关配置主要用于控制模块解析过程

**modules**

`modules``:`` ``[``"node_modules"``]`  //默认值

当解析模块时，如果遇到导入语句，`require("test")`，webpack会从下面的位置寻找依赖的模块

1. 当前目录下的`node_modules`目录
2. 上级目录下的`node_modules`目录
3. ...

**extensions**

`extensions``:`` ``[``".js"``,`` ``".json"``]``  `//默认值

当解析模块时，遇到无具体后缀的导入语句，例如`require("test")`，会依次测试它的后缀名

- test.js
- test.json

**alias**

```
alias: {
  "@": path.resolve(__dirname, 'src'),
  "_": __dirname
}
```

有了alias（别名）后，导入语句中可以加入配置的键名，例如`require("@/abc.js")`，webpack会将其看作是`require(src的绝对路径+"/abc.js")`。

在大型系统中，源码结构往往比较深和复杂，别名配置可以让我们更加方便的导入依赖

**externals**

```
externals: {
    jquery: "$",
    lodash: "_"
}
```

从最终的bundle中排除掉配置的配置的源码，例如，入口模块是

```
//index.js
require("jquery")
require("lodash")
```

生成的bundle是：

```
(function(){
    ...
})({
    "./src/index.js": function(module, exports, __webpack_require__){
        __webpack_require__("jquery")
        __webpack_require__("lodash")
    },
    "jquery": function(module, exports){
        //jquery的大量源码
    },
    "lodash": function(module, exports){
        //lodash的大量源码
    },
})
```

但有了上面的配置后，则变成了

```
(function(){
    ...
})({
    "./src/index.js": function(module, exports, __webpack_require__){
        __webpack_require__("jquery")
        __webpack_require__("lodash")
    },
    "jquery": function(module, exports){
        module.exports = $;
    },
    "lodash": function(module, exports){
        module.exports = _;
    },
})
```

这比较适用于一些第三方库来自于外部CDN的情况，这样一来，即可以在页面中使用CDN，又让bundle的体积变得更小，还不影响源码的编写

**stats**

stats控制的是构建过程中控制台的输出内容

## 常用扩展

### 清除输出目录

先进行安装：`$ npm i -D ``clean-webpack-plugin`

把 build或dist (就是放生产环境用的文件) 目录里的文件先清除干净，再生成新的。

用法：

```
var {CleanWebpackPlugin} = require("clean-webpack-plugin")
module.exports = {
  mode:"development",
  devtool:"source-map",
  output:{
    filename:"[name].[chunkhash:5].js"  //输出的文件名
  },
  plugins:{
    new CleanWebpackPlugin();
  }
}
```

### 自动生成页面

先进行安装：`$ npm i -D ``html-webpack-plugin`

生成html文件

代码：

```
var {CleanWebpackPlugin} = require("clean-webpack-plugin")
var HtmlWebpackPlugin = require("html-webpack-plugin")
module.exports = {
  ......
  plugins:{//这里可以写多个，顺序无所谓
    new CleanWebpackPlugin(),
    new HtmlWebpackPlugin()
  }
}
```

### 复制静态资源

安装：`$ npm i -D ``cope-webpack-plugin`

复制指定文件夹下的内容到dist文件夹里

代码：

```
var CopyPlugin = require("copy-webpack-plugin")
module.exports = {
  ......
  plugins:{
    new CopyPlugin([
        {from:"./public",to:"./"}//复制规则
        //意思是说将public文件夹里的内容放进dist目录里。
        //如果to写"./dist",则会在dist里面生成一个dist文件夹
    ]);
  }
}
```

### 开发服务器

在**开发阶段**，目前遇到的问题是打包、运行、调试过程过于繁琐，回顾一下我们的操作流程：

1. 编写代码
2. 控制台运行命令完成打包
3. 打开页面查看效果
4. 继续编写代码，回到步骤2

并且，我们往往希望把最终生成的代码和页面部署到服务器上，来模拟真实环境

为了解决这些问题，webpack官方制作了一个单独的库：**webpack-dev-server**

它**既不是plugin也不是loader**

先来看看它怎么用

1. 安装`$ npm i -D webpack-dev-server`
2. 执行`webpack-dev-server`命令

`webpack-dev-server`命令几乎支持所有的webpack命令参数，如`--config`、`-env`等等，你可以把它当作webpack命令使用

这个命令是专门为开发阶段服务的，真正部署的时候还是得使用webpack命令

当我们执行`webpack-dev-server`命令后，它做了以下操作：

1. 内部执行webpack命令，传递命令参数
2. 开启watch
3. 注册hooks：类似于plugin，webpack-dev-server会向webpack中注册一些钩子函数，主要功能如下：

1. 1. 将资源列表（aseets）保存起来
   2. 禁止webpack输出文件

1. 用express开启一个服务器，监听某个端口，当请求到达后，根据请求的路径，给予相应的资源内容

**配置**

针对webpack-dev-server的配置，参考：https://www.webpackjs.com/configuration/dev-server/

常见配置有：

- port：配置监听端口
- proxy：配置代理，常用于跨域访问
- stats：配置控制台输出内容

## CSS工程化

## JS兼容性

## 性能优化

## 补充和案例