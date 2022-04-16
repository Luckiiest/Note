---
title: Vue2基础
date: 2022-02-09 16:48:33
tags:
  - Vue
categories:
  - 框架
---

# Vue

## 前导

- 什么会影响到Web应用的性能？
  - 操作DOM影响性能，因为操作DOM是十分昂贵的
- 为什么操作DOM非常昂贵
  - JS和DOM是两种东西，每次连接都需要耗费性能
  - 操作DOM会导致重排和重绘
- JS与DOM的关系
  - DOM是一种独立于语言的，用于操作XML和HTML文档的程序接口（API）。在浏览器中主要用于与HTML文档打交道，并且使用DOM API用来访问文档中的数据
  - DOM是个与语言无关的API，他在浏览器中的接口却是用JavaScript来实现的。客户端脚本编程大多数都是在底层文档打交道，DOM就成为现在JS编码的重要部分
  - 浏览器通常会把DOM和Javascript独立实现
- DOM的位置和JavaScript的位置
  - 在IE中，JavaScript的实现名为JScript，位于`jscript.dll`文件总，DOM的实现则存在另一个库中，名为`mshtml.dll`（内部称为trident）
  - safari中的DOM和渲染是使用`webkit`中的`webcore`实现，JavaScript部分是由独立的`SquirelFish`引擎来实现
  - google chrome 使用`webkit`中的`webCore`库来渲染页面，但JavaScript引擎是他们自己研发的，名为V8
  - firefox的JavaScript引擎名为`TraceMonkey`，与名为`Gecko`的渲染引擎相互独立
- 浏览器渲染过程
  - 浏览器下载完页面的所有组件：HTML、JavaScript、CSS、图片后，开始渲染过程
  - 解析HTML，构建DOM树
  - 解析CSS，生成CSS规则树
  - 合并DOM树和CSS规则树，生成render树
  - 布局render树，负责各元素尺寸、位置的计算（占用CPU计算）
  - 绘制render树，绘制页面像素信息
  - 浏览器会将各层的信息发送给GPU，GPU将各层合成（占用GPU计算）

- 重排重绘
  - 当DOM的变化影响了元素的几何属性（宽和高），浏览器需要重新计算元素的几何属性，同样其他元素的几何属性和位置也会因此受到影响。浏览器会使渲染树中受到影响的部分失效，并重新构造渲染树。这个过程称为**重排**，完成重排后，浏览器会重新绘制受影响的部分到屏幕中，该过程称为**重绘**。
- 什么时候触发重排？
  - 当页面布局和几何属性改变时就需要重排：
  - 添加或删除可见的DOM元素
  - 元素位置改变
  - 元素尺寸改变（外边距、内边距、边框厚度、宽度、高度等）
  - 内容改变，例：文本改变或图片被另一个不同尺寸的图片替代
  - 页面渲染器初始化
  - 浏览器窗口尺寸改变
  - 各css属性对于重排重绘的影响：[CSS 触发器 (csstriggers.com)](https://csstriggers.com/)
- 关于GPU
  - GPU分类：
  - 家用GPU（不适合画图型）
  - 专业GPU（适合画图型）
  - DOM操作却都是要求画图型的，但是我们用的都是家用GPU，画图型耗费的性能是专业GPU的几十倍
- 为什么vue的性能会更好？
  - Vue的核心是虚拟DOM，使用虚拟DOM可以减少DOM的操作，从而提升应用的性能
- 什么是虚拟DOM
  - 虚拟dom：virtual dom（也称为vdom）
  - 所谓虚拟dom，即为伪dom，假的dom，他不是一个真是的dom，而是由JS来模拟出来的具有真实dom结构的一个树形结构
- 为什么要用JS来模拟dom结构
  - 在前端的三种语言中（html、css、js）中，只有js是一种编程语言，只有js能做到判断、循环、递归、能够实现各种逻辑、实现各种算法
  - dom的操作是昂贵的，js的运行效率更高，将dom对比放在js层，减少dom操作，效率更高
  - JS模拟DOM结构

```js
<div id="container">
    <h1 class="title">为师者</h1>
	<p class="content">当传道授业解惑</p>
</div>

const vDom = {
    tag: 'div',
    attrs: {
        id: 'container',
    },
    children[
    	{
			tag: 'h1',
    		attrs: {
				class: 'title',
    			children: ['为师者']
             }
        }
        {
			tag: 'p',
    		attrs: {
				class: 'content',
    			children: ['当传道授业解惑']
             }
        }
    ]
}
```

- 为什么要使用vue？
  - 性能更好
  - 视图、数据分离
  - 维护成本低
- 什么是vue？
  - 是一个渐进式的框架（MVVM）
  - MVVM
    - M：Model
    - V：View
    - VM：ViewModel
  - ![image-20220211104817260](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202202111048740.png)

## 创建一个Vue实例

```html
<div id="app">
    {{ name }} <!-- 绑定data中的数据，使用{{data}}来包裹住值 -->
    <a :href="url">VUE</a> <!-- 绑定事件可以不用{{data}}包裹 -->
    <p v-html="tag"></p>
    <button @click="changeName">点击</button>
</div>

<script>
    // v-bind:href => :href(简写)   用于绑定属性里面的值
    // v-on:click => @click(简写)   v-on相当于js中on，事件为click
    // v-html == innerHTML
    // v-text == innerText
    // element 元素
    new Vue({
        // 用于绑定某个标签
        el: '#app', // el => element
        // 数据，el绑定的标签可以直接访问
        data: {
            name: 'shan',
            url: 'https://vuejs.bootcss.com/guide/',
            tag: '<span>我是一个span标签</span>'
        }, 
        // 用来书写方法的
        methods: {
            changeName() {
                this.name = this.name + '1';
            }
        }
    })
</script>
```

## 计算属性和侦听器

在`method`中，每次如果重新触发渲染时，则调用的方法将会再次执行函数，无论渲染的数据是不是与函数有关，都会再次执行函数，下面的**describe**函数，如果`age`改变之后，`describe`也会再次触发一次，而`age`改变时`describe`函数本不应该触发

```html
<div id="app">
    {{describe}} {{age}}
</div>


<script>
    const vm = new Vue({
        el: "#app",
        data: {
            name: "Long",
            looks: "beautiful",
            age: 18,
        },
        methods: {
            describe() {
                return this.name + ' ' + this.looks;
            }
        }, 
    })
</script>
```

使用`watch`侦听`name`和`looks`之后，不会随着其他属性的改变而触发name和looks函数，`name()`和`looks()`会观察`name`和`looks`属性，随着它们的改变而改变，但是容易滥用`watch`

```html
<div id="app">
     {{describe}} {{age}}
</div>

<script>
    const vm = new Vue({
        el: "#app",
        data: {
            name: "Long",
            looks: "beautiful",
            age: 18,
            describe: name + ' ' + looks
        },
        // watch侦听name和looks属性
        watch: {
            name() {
                this.describe = this.name + ' ' + this.looks;
            },
            looks() {
                this.describe = this.name + ' ' + this.looks;
            }
        }
    })
</script>
```

然而更好的方式是使用计算机属性而不是滥用`watch`，上面的代码重复性很高，下面的代码看起来更好

```html
<div id="app">
    {{describe}} {{age}}
</div>


<script>
    const vm = new Vue({
        el: "#app",
        data: {
            name: "Long",
            looks: "beautiful",
            age: 18,
            // describe: "Long beautiful"
        },
        // 计算机属性
        computed: {
            // 默认只有getter，没有setter，如果需要时，可以自己提供setter，如下
            /*describe() {
                console.log('--computed--');
                return this.name + " " + this.looks;
            } */
            describe : {
                // getter 读
                get() {
                    return this.name + " " + this.looks
                },
                // setter 写
                set( value ) {
                    const arr = value.split(" ");
                    this.name = arr[0];
                    this.looks = arr[1];
                    if(arr[0] == 'yzl') {
                        this.age = 18;
                    }
                }
            }
        }
    })
</script>
```

## Class与Style绑定

Class绑定

```html
<div id="app">
    <p  :class="{active:activeBool}  [active,action]" 
		@click="changeColor">
        Leg
    </p>
</div>

<script>
    // class 拥有两个参数，对象和数组 "{} / []"
    
    // 对象中拥有两个值，name和value，name为类名，value是一个布尔值，判断显不显示，{key,value,……}
    // {} => key -> name/value -> blue
    
    // 数组中每一项都是name，name就是类名，[classname,classname,……]
    // [] => 每一项都是类名 class name
        
    new Vue({
        el: '#app',
        data: {
            activeBool: false,
            active: "active",
            action: "action",
        },
        methods: {
            changeColor() {
                this.activeBool = !this.activeBool;
            }
        }
    })
</script>
```

Style绑定

```html
<div id="app">
            <p :style = "{width:'200px'}"
               :style = "[styleObj,colorStyleObj]"
               @click="changeColor">
                Leg
            </p>

        </div>

<script>
    // style
    
    // 对象中key和value分别对应着属性和属性值,{width: '100px'},如line-height变换为小驼峰命名法或加上单引号
    // {} => {key/value}
    
    // 数组中是一个又一个对象组成
    // [] => [{},{}]

    new Vue({
        el: '#app',
        data: {
            activeBool: false,
            styleObj: {
                width: '200px',
                lineHeight: '200px'
            },
            colorStyleObj: {
                backgroundColor: "yellow"
            }
        }
    })
    
</script>
```

## 条件渲染

`v-if`、`v-else-if`、`v-else`条件渲染，它们之间不可以出现第三者，必须紧跟其后

```html
<!--
	v-if ==> if(){}
	true -> 显示
	false -> 隐藏
-->

<div id="app">
	<button @click="showOrHiden">显示隐藏</button>
    <p v-if="show ==1">
        显示1
    </p>
    <p v-else-if="show == 2">
        显示2
    </p>
    <p v-else>
        隐藏了
    </p>
</div>

<script>
    new Vue({
        el: '#app',
        data: {
            show: "1",
            count: 0;
        },
        methods: {
            showOrHiden() {
                if(show == '1') {
                    show = "2";
                } else if(show == '2') {
                    show = "3";
                } else {
                    show = '1'
                }
            }
        }
    })
</script>
```

Vue 会尽可能高效地渲染元素，通常会复用已有元素而不是从头开始渲染。这么做除了使 Vue 变得非常快之外，还有其它一些好处。例如，如果你允许用户在不同的登录方式之间切换。但是如果在不同得输入框之间 将会非常有很严重得问题，所以要给不复用的元素添加`key`值

```html
<div id='app'>
    <div v-if="show">
        <span>用户名</span>
        <input type="text" key="username">
    </div>

    <div v-else>
        <span>密码</span>
        <input type="text" key="password">
    </div>
</div>

<script>
    new Vue({
        el: '#app',
        data: {
            show: true
        },
        methods: {
            showOrHiden() {
                this.show = !this.show
            }
        }
    })
</script>
```

`v-show`条件渲染，v-show和v-if不同的是，`v-show`渲染的元素总是被保留在DOM中，通过切换元素CSS属性来渲染，`v-if`渲染的元素都是销毁之后再重新渲染，如果需要频繁的切换，使用`v-show`比较好

```html

<div id='app'>
    <!--总是通过CSS property dislay 来切换-->
    <p v-show="show">
        显示1
    </p>
</div>

<script>
    new Vue({
        el: '#app',
        data: {
            show: true
        },
        methods: {
            showOrHiden() {
                this.show = !this.show
            }
        }
    })
</script>
```

## 列表渲染

**v-for**

### 数组列表渲染

```html
使用v-for来渲染列表，item是别名，newList是数据源，使用v-for时，还需要给每个节点添加一个key值，让性能提升

<div id="app">
    <ul>
        <li v-for="item in newList" :key="item.id">
            <p>{{item.title}}</p>
            <span v-if="item.new">新</span>
        </li>
    </ul>
</div>

<script>
    // v-for
    // v-bind:key => :key 
    const vm = new Vue({
        el: '#app',
        data: {
            newList: [
                {
                    title: "第三胎生父",
                    new: true,
                    id: 0
                },
                {
                    title: "第一胎生父",
                    new: false,
                    id: 1
                },
                {
                    title: "第二胎生父",
                    new: false,
                    id: 2
                },
                {
                    title: "第四胎生父",
                    new: false,
                    id: 3
                },
                {
                    title: "第七胎生父",
                    new: true,
                    id: 4
                },
            ]
        },
    })
</script>
```

变更方法，它们会触发视图更新

- **push**
- **pop**
- **shift**
- **unshift**
- **splice**
- **sort**
- **reverse**

非变更方法，它们不会变更原始数组，总是返回一个新数组，当使用时，总是替换旧数组

- **filter**
- **concat**
- **slice**

### 对象列表渲染

对象如果想要更新列表视图的话可以直接对对象中的值进行改变，不过不可以添加新的在值

```html
对象可以列表渲染可以找到key、value、index属于对象的三个值

<div id="app">
	<div v-for="(value,key,index) in userInfo">
    	{{key}} --- {{value}} --- {{index}}
    </div>
</div>

<script>
    // v-for
    // v-bind:key => :key 
    const vm = new Vue({
        el: '#app',
        data: {
            userInfo: {
                name: '数理逻辑士大夫',
                age: 18
            },
        },
    })
</script>
```

### 注意事项

`Vue.set` 和 `vm.$set`

Vue.set是一个全局变量，vm.set是一个局部的，vm就是用一个变量接受了一个Vue实例，他们两个使用方法是一样的

它们两个可以触发视图更新，和数组的一些方法一样，它可以处理对象和数组两种方式

数组：`Vue.set(vm.数组, 索引,对象)`

```js
Vue.set(vm.newList, 6, {
    title: "第八胎生父",
    new: true,
    id: 7
},)
```

对象：`Vue.set(vm.对象, key, 属性值)`

```js
Vue.set(vm.userInfo, 'age',18)
```

**v-for 如果和 v-if 一起使用的话，v-for的优先级更高**

## 事件处理

- 监听事件
  - 使用`v-on`或`@`来监听DOM事件，并在触发时，运行JS代码，和JS事件相同

### 事件修饰符

- `.stop`：阻止单击事件继续传播

```html
<a v-on:click.stop="doThis"></a>
```

- `.prevent`

```html
<!--提交事件不在重载页面-->
<form v-on:submit.prevent="onSubmit"></form>
```

```html
<!-- 修饰符可以串联 -->
<a v-on:click.stop.prevent="doThat"></a>
```

```html
<!-- 只有修饰符 -->
<form v-on:submit.prevent></form>
```

- `.capture`

```html
<!-- 添加事件监听器时使用事件捕获模式 -->
<!-- 即内部元素触发的事件先在此处理，然后才交由内部元素进行处理 -->
<div v-on:click.capture="doThis">...</div>
```

- `.self`

```html
<!-- 只当在 event.target 是当前元素自身时触发处理函数 -->
<!-- 即事件不是从内部元素触发的 -->
<div v-on:click.self="doThat">...</div>
```

- `.once`

```html
<!-- 点击事件将只会触发一次 -->
<a v-on:click.once="doThis"></a>
```

- `passive`

```html
<!-- 滚动事件的默认行为 (即滚动行为) 将会立即触发 -->
<!-- 而不会等待 `onScroll` 完成  -->
<!-- 这其中包含 `event.preventDefault()` 的情况 -->
<div v-on:scroll.passive="onScroll">...</div>
```

### 按键修饰符

```html
<!-- 只有在 `key` 是 `Enter` 时调用 `submit()` -->
<input v-on:keyup.enter="submit">
```

使用按键码也是可以的

```js
<input v-on:keyup.13="submit">
```

也可以通过全局`config.keyCodes`对象自定义按键修饰符别名

```js
// 可以使用 v-on:keyup.f1
Vue.config.keyCodes.f1 = 112
```

Vue提供了大多数常用的按键码的别名

- `.enter`
- `.tab`
- `delete`：删除键和退格键
- `.esc`
- `.space`
- `.up`
- `.down`
- `.left`
- `.right`

### 系统修饰符

按下相应按键触发鼠标或键盘事件的监听器

- `.ctrl`
- `.alt`
- `.shift`
- `.meta` :对应键盘上的Window徽标键
- `.exact`：允许控制键盘键组合触发的事件

```html
<!-- 即使 Alt 或 Shift 被一同按下时也会触发 -->
<button v-on:click.ctrl="onClick">A</button>

<!-- 有且只有 Ctrl 被按下的时候才触发 -->
<button v-on:click.ctrl.exact="onCtrlClick">A</button>

<!-- 没有任何系统修饰符被按下的时候才触发 -->
<button v-on:click.exact="onClick">A</button>
```

鼠标按钮修饰符

- 仅响应特定的鼠标按钮

- `.left`
- `.right`
- `.middle`

### 表单输入绑定

- `v-model`：双向绑定数据

- 修饰符
- `.lazy`：在每次**input**事件后将输入框的值与数据进行同步

```html
<!-- 在change时而非input时更新 -->
<input v-model.lazy='msg'>
```

- `.number`：将输入的值转换为**number**类型

```html
<input v-model.number="age" type="number">
```

- `.trim`：过滤用户输入的空白字符

```html
<input v-model.trim="msg">
```

**例子**：todoList

```html
<div id="app">
    <div>
        <input type="text" v-model.trim="inputValue" @keyup.enter="addTask">
        <button @click="addTask">提交</button>
        <span> {{propmt}} </span>
        <ul>
            <li v-for="(item,index) in todoList" :key="item">
                {{item}}
                <button @click="completeTask(index)">X</button>
            </li>
        </ul>
    </div>
    <div>
        <h4>已完成任务</h4>
        <ul>
            <li v-for="item in completeList" :key="item">
                {{item}}
            </li>
        </ul>
    </div>
</div>


<script>
    const vm = new Vue({
        el: "#app",
        data: {
            inputValue: "", //input的value
            propmt: '', // 警告消息
            todoList: [], // 发布的任务
            completeList: [], //完成任务数组
        },
        methods: {
            addTask() {
                if(this.inputValue == '') {
                    this.propmt = "不能输入空任务";
                }else if(this.todoList.includes(this.inputValue)) {
                    this.propmt = "不能输入相同的任务";
                } else {
                    this.todoList.push(this.inputValue);
                    this.inputValue = '';
                }
            },
            // 将索引为index的值裁剪下来，push到completeList中
            completeTask(index) {
                const task = this.todoList.splice(index,1);

                this.completeList.push(...task);
            }
        },
    })
</script>
```

## 组件

>  组件就是可复用的实例

组件分为全局组件和局部组件

### 全局组件&局部组件

全局组件

```html
<list></list>  <!--将list作为组件-->
<list></list>  <!--组件可以重复使用-->

<script>
	Vue.component("list", {
        data: function() {
            return {
                count: 0
            }
        },
        template: `<button @click="count++">提交{{count}}<button>`
    })
</script>
```

局部组件

```html
<div id="app">
    <!--使用v-bind事件来绑定list属性值-->
    <list :list="courseList"></list>
</div>

<script>
	const list = {
        // 通过props向子组件传递数据
        props: {
        	// 用来接受父组件的数据
		   list: {
                type: Array, //类型
               	default: [], // 默认数据
               	required: true // 必填的
            }			
        },
        data: function() {
            return {
                ...
            }
        },
        template: `<button @click="count++">提交{{count}}<button>`,
        method: {
            // 方法
        }
    }

    const vm = new Vue({
        el: "#app",
        components: {
        	List: list, // 将List代表list组件，声明为局部组件
        },
        data: {
            // 数据
            courseList: [...],
        },
        methods: {
            // 方法
        }
    })
</script>
```

- 注意事项：
  - 组件可以重复使用
  - 组件中的`data`必须是一个函数，因为如果多个实例使用该组件则各自返回的数据是独立的

### 监听子组件事件

> 当我们使用组件时，避免不了使用事件来和父级组件进行交互沟通。

当我们使用组件时，想利用点击事件来和父级组件进行交互，则使用`native`属性

```html
<div id="app">
    <List :list="courseList"  @click.native="onClick"></List>
    <!--使用native属性可以进行调用父级组件中的方法-->
</div>

<script>
    const course = {
        props: {},
        data() { },
        template: ``,
        methods: {}
    };

    const vm = new Vue({
        el: '#app',
        components: {
            List: course,
        },
        data: {},
        methods: {
            onClick() {
                console.log(1);
            }
        }
    });
</script>
```

### 自定义事件

#### $emit

**$emit("事件名")**

原生事件绑定到组件

如果多次想要在一个组件的根元素上直接监听一个原生事件。这时，你可以使用 `v-on` 的 `.native` 修饰符：

```html
<div id="app">
    <!--这样就直接绑定了原生onClick事件-->
    <List @click.native="onClick"></List>
</div>

<script>
    const list = {
        props: {},
        data() {},
        template: `<input
                      type="checkbox"
                      v-bind:checked="checked"
                      v-on:change="$emit('change', $event.target.checked)"
                    >`,
        methods: {}
    };

    const vm = new Vue({
        el: '#app',
        components: {
            List: list
        },
        data: {},
        methods: {
            onClick() {
                console.log(1);
            }
        }
    });
</script>
```

不过在你尝试监听一个类似 `<input>` 的非常特定的元素时，这并不是个好主意。比如上述的组件可能做了如下重构，所以根元素实际上是一个 `<label>` 元素：这时，父级的 `.native` 监听器将静默失败。它不会产生任何报错，但是 `click` 处理函数不会如你预期地被调用。

```html
<label>
  {{ label }}
  <input
    v-bind="$attrs"
    v-bind:value="value"
    v-on:input="$emit('input', $event.target.value)"
  >
</label>
```

为了解决这个问题，Vue提供了`$listeners` property，它是一个对象，里面包含了作用在这个组建的所有监视器，如

```js
{
  focus: function (event) { /* ... */ }
  input: function (value) { /* ... */ },
}
```

有了`$listeneres` property，就可以配合`v-on:$listeners`，将所有的事件监听器执行这个组件的某个特定的子元素，所以，为了这些监听器创建一个下述的`inputListeners`属性是非常有用的

```js
Vue.component("base-input",{
    inheritAttrs:false, // 
    props: ['label', 'value'],
    computed: {
        inputListeners: function() {
            var vm = this;
            return Object.assign({}, // 将所有的对象合并成一个新对象
             	 // 从父级添加所有的监听器
				this.$listeners,
                                 
			   // 然后我们添加自定义监听器，
        		// 或覆写一些监听器的行为
			   {
                	// 这里确保组件配合 `v-model` 的工作
                	input: function(event) {
                        vm.$emit('input', event.target.value)
                    }
            	}
			)
        }
    },
    template: `
        <label>
          {{ label }}
          <input
            v-bind="$attrs"
            v-bind:value="value"
            v-on="inputListeners"
          >
        </label>
      `
})
```

#### .sync

我们可能需要对一个 prop 进行“双向绑定”。不幸的是，真正的双向绑定会带来维护上的问题，因为子组件可以变更父组件，且在父组件和子组件两侧都没有明显的变更来源。

所以使用`update:myPropName`的模式来触发事件取而代之

```html
<!--1-->
<text-document
  v-bind:title="doc.title"
  v-on:update:title="doc.title = $event"
></text-document>

<!--2-->
<text-document v-bind:title.sync="doc.title"></text-document>
```

> 使用`.sync`修饰符的`v-bind`不可以使用表达式，只可以提供想要绑定的property名

### 插槽

> `<slot></slot>`插槽可以将一些数据写在组件内部，替换组件中的某些数据

以下就是简单的插槽的应用，可以在组件中写

```html
<div id="app">
    <cmp-two :list="list">
        我是一个简单的插槽！
    </cmp-two> 
</div>

<script>
    const cmpTwo = {
        props: {
            list: {
                type: Array,
                required: true,
                default: [],
            }
        },
        template: `<div>
					<slot></slot> 
                    </div>`
        // <slot></slot> 就是一个插槽，可以用来存放数据
    }

    const vm = new Vue({
        el: '#app',
        components: {
            cmpTwo,
        },
        data: {},
        methods: {}
    })

</script>
```

#### 具名插槽

有时我们需要多个插槽，来存放不同的内容，所有我们要给每一个插槽一个名字，例如如下模板的`<cmp-one>`组件

但是我们在向具名插槽提供内容的时候，我们要在一个`template`元素上使用`v-solt`指令，并在`v-slot`后面一参数的形式提供`slot`名称

`v-slot:`指令可以简写成`#`号，例如`v-slot:header`可以重写为`#header`

```html
<div id="app">
    <cmp-one v-if="showOne">
        <!-- 要向具名插槽中提供您内容时，要使用template元素并使用v-slot指令 -->
        <template v-slot:before> before <template>
        <template v-slot:after> after </template>
    </cmp-one>
</div>

<!-- <slot></slot> 插槽 -->
<!-- <slot name=''></slot> 具名插槽 -->

<script>
    const cmpOne = {
        // 组件中有两个slot，第一个name为before,第二个name为after
        template: `<div> cmp-one组件：
                        <slot name='before'></slot>
                        <input type="value">
                        <slot name='after'></slot>
    			  </div>`
    }

    const vm = new Vue({
        el: '#app',
        components: {
            cmpOne,
        },
        data: {},
        methods: {}
    })
</script>
```

#### 作用域插槽

有时我们想要将插槽里面的内容可以访问组件里面的数据，那么可以使用作用域插槽

需要使用`v-list-property="data"`来绑定作用于插槽绑定的数据

```html
<!-- 
	在这里使用cmp-two组件时，绑定list，在template元素中使用v-slot-prop="data"获取作用域插槽绑定的数据 ，然后再插槽中使用绑定的数据
-->

<div id="app">
    <cmp-two :list="list">
        <template v-slot:default="list">
            <li>{{list.item}} - {{list.index}}</li>
        </template>
    </cmp-two> 

    <cmp-two :list="list">
        <template v-slot:default="list">
            <li>{{list.index}} - {{list.item}}</li>
        </template>
    </cmp-two> 
</div>

<script>
    const cmpTwo = {
        props: {
            list: {
                type: Array,
                required: true,
                default: [],
            }
        },
        // slot来v-for循环了list数组，绑定了list中的item和index
        template: `<div>组件2：
                        <input type="value">
                        <ul>
                        	<slot 
							v-for="(item,index) in list"
							:item='item'
							:index='index'>
								{{item}} - {{index}}
                            </slot>
    				   </ul>
    			   </div>`
    }

    const vm = new Vue({
        el: '#app',
        components: {
            cmpTwo,
        },
        data: {
            list: [1,2,3,4,5],
        },
        methods: {}
    })
</script>
```

- 注意：
  - `v-list-default`的缩写默认为`v-list`
  - `v-list`不可以和具名插槽同时使用，容易造成作用域不明确
  - 如果出现多个插槽，那么给所有的插槽都使用`<template></template>`元素

#### 注意事项

- 后备内容
  - 插槽在没有提供内容的时候被渲染，如果提供了内容就渲染提供的数据

```html
<button type="submit">
  <slot>Submit</slot>
</button>

<!--
	slot中的Submit就是提供的后备内容，如果我使用组件时没有传入插槽数据，则就使用Submit

	<submit-button>
      Save
    </submit-button>
	但是当我像上面提供了数据，那么slot插槽中的数据就变成了Save
-->
```

- [动态指令参数](https://cn.vuejs.org/v2/guide/syntax.html#动态参数)也可以用在 `v-slot` 上，来定义动态的插槽名

```html
<base-layout>
  <template v-slot:[dynamicSlotName]>
    ...
  </template>
</base-layout>
```

### 动态组件

动态组件就是在一个多标签的界面中使用`is`属性来切换不同的组件

```html
<div id="app">
    <!--通过点击按钮赋值-->
    <button @click="changeCmp">切换</button>

    <cmp-one></cmp-one>
    <cmp-two></cmp-two>
    
    <!--通过component元素来实现动态组件，通过is属性实现切换组件-->
    <component :is="type"></component>

</div>

<!-- <slot></slot> 插槽 -->
<!-- <slot name=''></slot> 具名插槽 -->

<script>

    const cmpOne = {
        template: `<div>组件1：
                        组件one
    			  </div>`
    }

    const cmpTwo = {
        props: {
            list: {
                type: Array,
                required: true,
                default: [],
            }
        },
        template: `<div>组件two</div>`
    }

    const vm = new Vue({
        el: '#app',
        components: {
            cmpOne,
            cmpTwo,
        },
        data: {
            type:'cmp-one',
        },
        methods: {
            // 使用方法来进行变换组件赋值
            changeCmp() {
                this.type = this.type == 'cmp-one' ? 'cmp-two' : 'cmp-one'
            }
        }
    })

</script>
```

在动态组件中使用`keep-alive`，我们使用动态组件来回切换的时候总是不会保存状态，会回到初始状态，我们更希望那些标签的组件实例在创建的时候缓存下来，这时候就可以用`keep-alive`包裹住

```html
<!--component中切换的组件就会被缓存下来-->
<keep-alive>
    <component :is="type"></component> 
</keep-alive>
```

## 小知识点

### 挂载元素方式

挂载元素不仅仅只有`el`可以，也可以使用`vm.$mount("dom")`来挂载**dom**元素

- `$mount("dom")`
- `el："dom"`

```js
const vm = new Vue({
    el:"#app",
})

// vm.#mount("#app");
```

### template

> `template:String -> AST({}) -> render -> vNode -> 真实的dom`

`template`是一个字符串，vue通过一个操作，解析成一个抽象语法树`AST`，`AST`相当于一个对象，然后把`AST`把`ASP`传入到一个函数里面，叫做`render`函数，通过`render`函数得到一个虚拟节点`vNode`，通过`vNode`得到一个真实的DOM

```js

const vm = new Vue({
    // el: '#app',
    components: {

    },
    data: {
        msg: "Hello World",
        red:false,
        green: true
    },
    methods: {

    },
    // template优先级比el高，有template就不会找el或者$mount
    template: "<div>我是一个模板</div>",
})

vm.$mount("#app");
           
```

### render

使用`vue`时，刚开始会进行初始化，初始化完成之后会检查有没有`el`元素，如果有`el`时，会检查有没有`template`模板，如果有，那么会进行`template`操作，如果没有`el`时，会判断是否调用`$mount`方法，如果两个都没有实例就会结束，如果有`$mount`则会检查`template`是否存在，如果存在则会进行`template`操作，如果没有`template`，那么会找到挂载的元素，然后拿到挂载元素的`outerHTML`，然后把`outerHTML`作为一个模板进行一系列的处理![image-20220217151145881](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202202171511088.png)

```js
const vm = new Vue({
    // el: '#app',
    components: {

    },
    data: {
        msg: "Hello World",
        red:false,
        green: true
    },
    methods: {

    },
    // template优先级比el高，有template就不会找el或者$mount
    template: "<div>我是一个模板</div>",
    // render函数优先级比template高，如果有render函数则先执行render函数
    // render函数的参数是一个函数
    render( createElement ) {
        return createElement("p", {
            style: {
                color: 'red',
                fontSize: '18px'
            },
            // class: ["red",'green'],
            class: {
                red: this.red,
                green: this.green
            },
            // domProps优先级高于createElement第三个参数
            // domProps: {
            //     innerHTML: "222"
            // } 
        },[
            createElement('h1',{},'h1'),
            createElement('h2',{},'h2'),
            createElement('h3',{},'h3')
        ]);
    }
})

// vm.$mount("#app");
```

### Vue生命周期

![Vue 实例生命周期](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202202171540126.png)

```js
const vm = new Vue({
    el: "#app",
    data: {
        msg: "hello",
    },
    methods: {
        a() {
            console.log('aaa');
        },
        change() {
            this.msg = 'iiiii';
        },
        destroy() {
            this.$destroy();
        }
    },
    // 第一个生命周期函数,表示实例完全被创建出来之前,会执行它
	// 注意:在 beforeCreate 生命周期函数执行的时候, data 和 methods 中的 数据都还没有初始化
    beforeCreate() {
        console.log("----beforeCreate----");
        console.log(this.msg);
        console.log(this.a);
        alert("beforeCreate")
    },
    
    // 第二个生命周期函数
    // 在 created 中,data 和 methods 都已经被初始化好了!
    // 如果要调用 methods 中的方法,或者操作 data 中的数据,最早,只能在 created 中操作	
    created() {
        console.log("----Create----");
        console.log(this.msg);
        this.a();
        alert("Create")
    },
    
    // 第3个生命周期函数,表示 模板已经在内存中编辑完成了,但是尚未把模板渲染到 页面中
	// 在 beforeMount 执行的时候,页面中的元素,还没有被真正替换过来,只是之前写的一些模板字符串
    beforeMount() {
        alert("beforeMount");
    },
    
    // 第4个生命周期函数,表示,内存中的模板,已经真实的挂载到了页面中,用户已经可以看到渲染好的页面了
	// 注意:mounted 是实例创建期间的最后一个生命周期函数,当执行完 mounted 就表示,实例已经被完全创建好了,
	// 此时,如果没有其它操作的话,这个实例,就静静的 躺在我们的内存中,一动不动
    mounted() {
        alert("mounted");
    },
    
    // 第五个生命周期函数，当执行的时候，页面显示的数据还是旧的，此时data的数据是最新的，页面尚未和最新的数据同步
    beforeUpdate() {
        alert("beforeUpdate");
    },
    
    // 第六个生命周期函数，执行updated时候，则页面和data数据已经保持同步了，都是最新的
    updated() {
        alert("updated");
    },
    
    // 第七个生命周期函数
    // 当执行beforeDestroy时，Vue实例就从运行阶段进入到了销毁阶段；
    // 当执行beforeDestroy时，实例上所有的data和所有的methods，以及过滤器、指令……都处于可用状态，此时还没有真正执行销毁的过程
    beforeDestroy() {
        alert("beforeDestroy");
    },
    
    // 第八个生命周期函数
    // 当执行到destroyed函数的时候，组件已经被完全销毁了，此时，组件中所有的数据、方法、指令、过滤器……都已经不可用了
    destroyed() {
        alert("destroy");
    }
})
```

## 路由

### 初始路由

路由`Vue Router`可以一个单页面应用程序跳转不刷新，更加的自然

如果只是想用一下简单的路由，不引入一个完成的`vue-Router`库，可以动态渲染一个页面的组件

```js
const NotFound = { template: '<p>Page not found</p>' }
const Home = { template: '<p>home page</p>' }
const About = { template: '<p>about page</p>' }

const routes = {
  '/': Home,
  '/about': About
}

new Vue({
  el: '#app',
  data: {
    currentRoute: window.location.pathname
  },
  computed: {
    ViewComponent () {
      return routes[this.currentRoute] || NotFound
    }
  },
  render (h) { return h(this.ViewComponent) }
})
```

**使用vue-cli创建项目使用**

App.vue使用

```html
<!-- 引入script可以使用路由，也可以使用vue-cli创建脚手架后使用npm进行vue add router下载router引入使用 -->

<div id="app">
  <h1>Hello App!</h1>
  <p>
    <!-- router-link是一个vue自定义组件来创建链接，让vue router再不加载页面的情况下更改url -->
    <!--使用 router-link 组件进行导航 -->
    <!--通过传递 `to` 来指定路径链接 -->
    <!--`<router-link>` 将呈现一个带有正确 `href` 属性的 `<a>` 标签-->
    <!--`<router-link to='/'>` 和 `<a href='/'>` 是一样的，但是如果使用a标签还是会刷新-->
    <router-link to="/">Go to Home</router-link>
    <router-link to="/about">Go to About</router-link>
  </p>
  <!-- 路由出口 router-view是与url对应的自定义组件，可以放在任何地方，适应布局-->
  <!-- 路由匹配到的组件将渲染在这里 -->
  <!-- 将使用路由的组件渲染到页面 -->
  <router-view></router-view>
</div>
```

**router.js**

```js
// 定义路由组件.
// 从可以在这里面写
import Vue from 'vue' // 引用的vue文件
import VueRouter from 'vue-router' // 引用的vue-router文件
import HomeView from '../views/HomeView.vue' // 引用的HomeView组件
/*
<template>
	<h1>This is an Home page</h1>
</template>
*/
import AboutView from '../views/AboutView.vue'
/*
<template>
	<h1>This is an about page</h1>
</template>
*/

// 确保 _use_ 路由实例使
// 整个应用支持路由。
Vue.use(VueRouter)

// 定义一些路由
// 每个路由都需要映射到一个组件。
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView
    // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

// 创建路由实例并传递 `routes` 简单配置
const router = new VueRouter({
  routes,
  mode: 'history' // 将导航中的/#/消除
})

export default router // 导出路由，现在就可以全局使用了
```

**main.js**

```js
import Vue from 'vue' //引入vue
import App from './App.vue' // 引入HTML
import router from './router' // 引入上面创建的router文件

new Vue({
  router, //使用router
  render: h => h(App) //
}).$mount('#app') //挂载到#app上面
```

### 嵌套路由

一些应用程序的UI是由多层组件嵌套组成的，这种情况下，

![image-20220220190014773](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202202201900277.png)

通过`vue-Router`可以使用嵌套路由来表达这种嵌套关系

只需要在需要被嵌套的页面下配置`childeren`

Router.js

```js
import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

// Home页面下面的嵌套路由
import HomeFile from '../components/HomeView/HomeFile.vue'
import Download from '../components/HomeView/HomePosts.vue'

const routes = [
  {
    path: '/home',
    name: 'home',
    component: HomeView,
    // HomeView的子页面，配置children就可以实现嵌套路由，children的配置方式和routes一样
    children: [
        {
          path: '/home/homefile',
          component: HomeFile,
          name: 'homefile'
        },
        {
        	path: '/home/homeposts',
          	component: HomePosts,
          	name: 'homeposts'
        }
    ]
  },
]
```

Home页面

```html
<div>
    <div class="nav">
        <router-link :to="{name: 'homefile'}">文件</router-link>
        <router-link :to="{name: 'homeposts'}">邮件</router-link>
    </div> 
    <router-view />
</div>

<style>
    /*
    	vue路由内置类名，用于路由被选中状态
    	.router-link-active {}
    	.router-link-exact-active {}
    */
    
</style>
```

其他配置都一样

### 动态路由

很多时候，我们需要将给定匹配模式的路由映射到同一个组件。例如，我们可能有一个`Question`组件，它应该对所有用户进行渲染，但用户 ID 不同。在 Vue Router 中，我们可以在路径中使用一个动态字段来实现，我们称之为 *路径参数* 

router.js

```js
import Question from '../components/Question.vue' //question组件
import Err from '../components/Err.vue' //404组件

// community页面下面的路由
import Academic from '../components/community/Academic.vue'

import Vue from 'vue'
import VueRouter from 'vue-router'
import Community from '../views/Community.vue'

const routes = [
  {
    path: '/community',
    name: 'community',
    component: Community, //组件
    redirect: '/community/academic', //重定向,当到达这个路径的时候，重定向到另外一个路径下去
    children:[
      {
        path: 'academic', // 当path不写/号的时候可以直接写名字，代表是父路径下面的
        name: 'academic',
        component: Academic
      },
    ]
  },
  // 动态路由匹配
  {
    path: '/question/:id', // :id就是一个动态字段
    name: 'question',
    component: Question
  },
  {
     path: '/err.html', // :id就是一个动态字段
     name: 'err',
     component: Err
  }
]
```

Academic.vue

```html
<template>
  <ul>
    <!--
		tag: 代表渲染成li
		:to 相当于href,
			{name:'question'} 就是router.js中配置name为question的组件，
			{params: {id: item.questionId}} 当一个路由被匹配到的时候，他的params的值将在每个组件中以this.$route.params的形式暴露出来。因此，我们可以通过id来传输给打开的组件页面
	-->
    <router-link
        tag="li"
        :to="{name: 'question', params:{id: item.questionId}}"
        v-for="item in questionList" 
        :key="item.questionList">
        {{item.title}}
    </router-link>
  </ul>
</template>

<script>
export default {
  data() {
    return {
      // 数据
      questionList: [
        {
          questionId: 202202,
          title: '到底什么是es6中的clss（类）？怎么实现class类'
        },
        {
          questionId: 202203,
          title: '到底什么是es6箭头函数？与普通函数主要区别在哪里？到底该不该使用箭头函数'
        },
        {
          questionId: 202204,
          title: '什么是es6的解构赋值，每次都创建一个对象吗？会加重GC的负担吗？为什么'
        },
      ]
    }
  }
}
</script>
```

Question.vue

```html
<template>
  <div>
      问题:{{ question }}
  </div>

  
</template>

<script>
export default {

  created() {
    // 获取参数id
    const questionId = this.$route.params.id;
    // findIndex 返回当前值与数据匹配的第一个索引
    const index = this.questionList.findIndex(
      (item) => item.questionId == questionId
    );

    // 找不到页面时返回-1，则跳转到err（404页面）
    if(index == -1){
        // 跳转
        // this.$router.go(-1);

        // replace 替换，[a>b>c>d]四个页面 使用repleace之后，变成了[a>b>c>e]
        this.$router.replace({name: 'err'})

        // push 添加，[a>b>c>d]四个页面 使用push之后,变成了[a>b>c>d>e]
        // this.$router.push({naem: 'err'})
    }else {
        // 根据获取的index索引来获取数据中的第index个数据中的title
        this.question = this.questionList[index].title;
    } 
  },

  data() {
    return {
      // 用来存储每个id的title
      question: "",
      // 数据，模拟网络请求
      questionList: [
        {
          questionId: 202202,
          title: "到底什么是es6中的clss（类）？怎么实现class类",
        },
        {
          questionId: 202203,
          title:
            "到底什么是es6箭头函数？与普通函数主要区别在哪里？到底该不该使用箭头函数",
        },
        {
          questionId: 202204,
          title:
            "什么是es6的解构赋值，每次都创建一个对象吗？会加重GC的负担吗？为什么",
        },
      ],
    };
  },
};
</script>
```

### router-view复用

```js
// router.js

const routes = [
{
  path: '/home',
  name: 'home',
// 组件可以进行对象管理，默认显示为HomeView组件，如果router-view使用'academic'，则使用Academic组件
  components: {
    default: HomeView,
    'academic': Academic
  }
}
```

```html
<!-- 路由视图 -->
<!-- 默认显示为default -->
<router-view class="router-view" />

<!-- 如果属性中添加name，则显示name为academic的组件 -->
<router-view name="academic" class="router-view" />
```

### 路由重定向和别名

- 重定向

路由重定向也是在`router.js`中配置的，重定向的目标也可以是一个别名，或者方法

```js
const routes = [
  {
    path: "*", // *除了配置过之外的页面都是*
	redirect: '/home' // 重定向到/home组件
  }
]
```

```js
const routes = [
  {
    path: '*', // *除了配置过之外的页面都是*
      
    // 方法接收目标路由作为参数
    // return 重定向的字符串路径/路径对象
    redirect(to) {
      if(to.path == '/') {
        return '/home'
      } else {
        return {name:'err'}
      }
    }
  }
]
```

- 别名

重定向是指当用户访问 `/home` 时，URL 会被 `/` 替换，然后匹配成 `/`。那么什么是别名呢？

**将 `/` 别名为 `/home`，意味着当用户访问 `/home` 时，URL 仍然是 `/home`，但会被匹配为用户正在访问 `/`。**

```js
const routes = [
  {
     path: "/",
     name: "home",
     components: {
     default: HomeView,
       academic: Academic,
     },
     // 别名
     alias: '/home'
  },
]
```

通过别名，你可以自由地将 UI 结构映射到一个任意的 URL，而不受配置的嵌套结构的限制。使别名以 `/` 开头，以使嵌套路径中的路径成为绝对路径。你甚至可以将两者结合起来，用一个数组提供多个别名：

```js
const routes = [
  {
    path: '/home',
    component: UsersLayout,
    children: [
      // 为这 3 个 URL 呈现 UserList
      // - /home
      // - /home/list
      // - /people
      { path: '', component: UserList, alias: ['/people', 'list'] },
    ],
  },
]
```

如果路由有参数，请确保在任何绝对别名中包含他们

```js
const routes = [
  {
    path: '/home/:id',
    component: UsersByIdLayout,
    children: [
      // 为这 3 个 URL 呈现 UserDetails
      // - /home/24
      // - /home/24/profile
      // - /24
      { path: 'profile', component: UserDetails, alias: ['/:id', ''] },
    ],
  },
]
```

### 导航守卫

> 导航守卫，`vue-router`提供的导航首位主要用来通过跳转或取消的方式守卫导航。路由导航有好几种方式，分别为全局所有的、单个路由所有的、单个组件所有的

#### 全局守卫

##### 全局前置守卫

创建一个全局前置导航守卫

当一个导航触发时，全局前置守卫按照创建顺序调用。守卫是异步解析执行，此时导航在所有守卫 resolve 完之前一直处于等待中。

```js
const router = new VueRouter({...});

router.beforeEach((to, from, next) => {
    // to: 要到哪里去，即将要进入的目标页面
    // from：从哪里来，当前导航正要离开的路由页面
    // next(): 通过   
    // next(false)不通过,返回false不通过
    
	
    // 判断目标路径是否是academic
    if (to.path === '/community/academic') {
        const answer = confirm("你还没有登陆，要登陆后才能浏览信息，要登陆吗？");
        // 如果是，则导航name为:personal的路由
        if (answer) {
            next({ name: 'personal' })
        } else {
            // 返回false取消导航
            next(false);
        }
    } else {
        next();
    }
}) 
```

##### 全局解析守卫

`router-beforeResolve`注册一个全局解析守卫，这和`router.beforeEach`类似，因为它没导航时都触发，但是确保在导航被确认之前，**同时在所有组件内守卫和异步路由组件被解析之后，解析守卫就被正确调用**。这里有一个例子，确保用户可以访问[自定义 meta](https://router.vuejs.org/zh/guide/advanced/meta.html) 属性 `requiresCamera` 的路由：

```js
router.beforeResolve(async to => {
  if (to.meta.requiresCamera) {
    try {
      await askForCameraPermission()
    } catch (error) {
      if (error instanceof NotAllowedError) {
        // ... 处理错误，然后取消导航
        return false
      } else {
        // 意料之外的错误，取消导航并把错误传给全局处理器
        throw error
      }
    }
  }
})
```

`router.beforeResolve` 是获取数据或执行任何其他操作（如果用户无法进入页面时你希望避免执行的操作）的理想位置。

##### 全局后置钩子

全局后置钩子，和守卫不同的是，这些钩子不会接受 `next` 函数也不会改变导航本身

```js
router.afterEach((to, from) => {
  sendToAnalytics(to.fullPath)
})
```

它们对于分析、更改页面标题、声明页面等辅助功能以及许多其他事情都很有用。

它们也反映了 [navigation failures](https://router.vuejs.org/zh/guide/advanced/navigation-failures.html) 作为第三个参数

```js
router.afterEach((to, from, failure) => {
  if (!failure) sendToAnalytics(to.fullPath)
})
```

#### 路由独享守卫

直接在路由配置中配置`beforeEnter`守卫

`beforeEnter`守卫只在进入路由时触发，不会在`params`、`query`、`hash`等改变时触发，例如`/community/download`进入到`/community/academic`，或`/community/personal`进入到`/community/academic`。`beforeEnter`只会在从一个不同的路由导航时才会触发

```js
const router = [
  {
    path: "/community/academic",
    name: "academic",
    component: Academic,
    // 2.路由独享守卫
    beforeEnter (to, from, next) {
	  // 参数和全局守卫一样
      const answer = confirm("你还没有登陆，要登陆后才能浏览信息，要登陆吗？");
      if (answer) {
      	next({ name: 'personal' })
      } else {
        next(false);
	  }
	}
  },
]
```

你也可以将一个函数数组传递给 `beforeEnter`，这在为不同的路由重用守卫时很有用

```js
function removeQueryParams(to) {
  if (Object.keys(to.query).length)
    return { path: to.path, query: {}, hash: to.hash }
}

function removeHash(to) {
  if (to.hash) return { path: to.path, query: to.query, hash: '' }
}

const routes = [
  {
    path: '/users/:id',
    component: UserDetails,
    beforeEnter: [removeQueryParams, removeHash],
  },
  {
    path: '/about',
    component: UserDetails,
    beforeEnter: [removeQueryParams],
  },
]
```

#### 组件内守卫

组件内守卫可用配置API：`beforeRouteEnter`、`beforeRouteUpdate`、`beforeRouteLeave`

```js
const Details = {
  template: `...`,
  beforeRouteEnter (to, from, next) {
    // 在渲染该组件的对应路由被验证前调用
    // 不能获取组件实例 `this` ！
    // 因为当守卫执行时，组件实例还没被创建！
  },
  beforeRouteUpdate (to, from, next) {
    // 在当前路由改变，但是该组件被复用时调用
    // 举例来说，对于一个带有动态参数的路径 `/users/:id`，在 `/users/1` 和 `/users/2` 之间跳转的时候，
    // 由于会渲染同样的 `UserDetails` 组件，因此组件实例会被复用。而这个钩子就会在这个情况下被调用。
    // 因为在这种情况发生的时候，组件已经挂载好了，导航守卫可以访问组件实例 `this`
  },
  beforeRouteLeave (to, from, next) {
    // 在导航离开渲染该组件的对应路由时调用
    // 与 `beforeRouteUpdate` 一样，它可以访问组件实例 `this`
  },
}
```

`beforeRouteEnter`守卫不可以访问`this`，因为守卫在导航确认前被调用，因此即将登场的新组件还没被创建

可以通过传一个回调给`next`来访问实例，在被确认的时候执行回调，把组件实例作为参数，或者使用`to`参数来代替`this`

```js
// 1.通过回调next访问实例
beforeRouteEnter (to, from, next) {
  next(vm = {
  	// 通过vm访问组件实例 
  })
}

// 2.通过to访问实例
beforeRouteEnter (to, from, next) {
    const Flag = to.matched[0].meta.login;
}
```

注意 `beforeRouteEnter` 是支持给 `next` 传递回调的唯一守卫。对于 `beforeRouteUpdate` 和 `beforeRouteLeave` 来说，`this` 已经可用了，所以*不支持* 传递回调，因为没有必要了

```js
beforeRouteUpdate (to, from) {
  // just use `this`
  this.name = to.params.name
}
```

这个 **离开守卫** 通常用来预防用户在还未保存修改前突然离开。该导航可以通过返回 `false` 来取消。

```js
beforeRouteLeave (to, form, next) {
    const answer = confirm("确定要离开吗");
    if (answer) {
      next();
    } else {
      next(false)
    }
  }
```

#### 完整的导航解析流程

1. 导航被触发。
2. 在失活的组件里调用 `beforeRouteLeave` 守卫。
3. 调用全局的 `beforeEach` 守卫。
4. 在重用的组件里调用 `beforeRouteUpdate` 守卫(2.2+)。
5. 在路由配置里调用 `beforeEnter`。
6. 解析异步路由组件。
7. 在被激活的组件里调用 `beforeRouteEnter`。
8. 调用全局的 `beforeResolve` 守卫(2.5+)。
9. 导航被确认。
10. 调用全局的 `afterEach` 钩子。
11. 触发 DOM 更新。
12. 调用 `beforeRouteEnter` 守卫中传给 `next` 的回调函数，创建好的组件实例会作为回调函数的参数传入。

#### 路由元信息

有时候我们希望把一些信息附加到路由上，方便路由之间调用，如登陆信息，过渡名称，这些事情可以通过接受路由属性对象的`meta`属性来实现，并且它可以在路由地址和导航守卫上都可以被访问到。定义路由时也可以配置`meta`字段

```js
const routes = [
  {
    path: '/posts',
    component: PostsLayout,
	// 只有经过身份验证的用户才能创建帖子
    meta: { requiresAuth: true },
    children: [
      {
        path: 'new',
        component: PostsNew,
       
      },
      {
        path: ':id',
        component: PostsDetail
      }
    ]
  }
]
```

那么如何访问这个 `meta` 字段呢？

首先，我们称呼 `routes` 配置中的每个路由对象为 **路由记录**。路由记录可以是嵌套的，因此，当一个路由匹配成功后，它可能匹配多个路由记录。

例如，根据上面的路由配置，`/posts/new` 这个 URL 将会匹配父路由记录 (`path: '/posts'`) 以及子路由记录 (`path: 'new'`)。

一个路由匹配到的所有路由记录会暴露为 `$route` 对象(还有在导航守卫中的路由对象)的`$route.matched` 数组。我们需要遍历这个数组来检查路由记录中的 `meta` 字段，但是 Vue Router 还为你提供了一个 `$route.meta` 方法，它是一个非递归合并**所有 `meta`** 字段的（从父字段到子字段）的方法。这意味着你可以简单地写

```js
router.beforeEach((to, from) => {
  // 而不是去检查每条路由记录
  // to.matched.some(record => record.meta.requiresAuth)
  if (to.meta.requiresAuth && !auth.isLoggedIn()) {
    // 此路由需要授权，请检查是否已登录
    // 如果没有，则重定向到登录页面
    return {
      path: '/login',
      // 保存我们所在的位置，以便以后再来
      query: { redirect: to.fullPath },
    }
  }
})
```

### 路由懒加载

当打包构建应用时，JavaScript 包会变得非常大，影响页面加载。如果我们能把不同路由对应的组件分割成不同的代码块，然后当路由被访问的时候才加载对应组件，这样就会更加高效。

我们平时加载路由习惯用`import`加载页面了，但是这会让浏览器一股脑全加载进来，不会按需加载，所以就需要路由懒加载，把`import`放入到函数中去，访问到函数时在进行`import`加载

```js
// 将这样引入 
// import HomeView from "../views/HomeView.vue";
// 替换为
const HomeView = () => import("../views/HomeView.vue");
```

## 非父子组件传值

我们很多时候会遇到非父子组件传值的情况，如兄弟组件要传值，这时有几种方法来解决：

1. 通过点击事件进行传递：子组件($emit触发事件) — 父组件 —props — 子组件
2. 通过总线/Bus/发布订阅模式/观察者模式来解决
3. 通过Vue官方提供的数据框架—vuex，安装方法：vue add vuex

### 点击事件传递

子组件一

```html


<template>
  <div>
    添加学生：
    <input type="text"
           v-model="name">
    <button @click="add">确认添加</button>
  </div>
</template>

<script>
    export default {
      data () {
        return {
          name: '',
        }
      },
      methods: {
        add () {
          // 通过v-model来双向绑定数据，然后使用$emit来传值给父组件
          this.$emit('add', this.name);
        }
      }
    }
</script>
```

父组件

```html
<template>
  <div>
    <!-- 学员展示 -->
    <!-- 使用add方法来获取参数 -->
    <add-student @add="add"></add-student>
    <!-- 把studentList数组绑定studentList组件 -->
    <student-list :student-list="studentList"></student-list>
  </div>
</template>

<script>
import AddStudent from "@/components/student/AddStudent";
import StudentList from "@/components/student/StudentList";

export default {
  components: {
    AddStudent,
    StudentList
  },
  data () {
    return {
      // 先声明参数数组，进行存放
      studentList: [],
    }
  },
  methods: {
    // add方法，如果点击则存放参数数组
    add (name) {
      this.studentList.push(name);
    }
  }
}
</script>
```

子组件二

```html
<template>
  <div>
    学生列表
    <ul>
      <li v-for="(item, index) in studentList"
          :key="index+item">
        {{item}}
      </li>
    </ul>
  </div>
</template>

<script>
// vuex  vue add vuex

export default {
  // props获取数据
  props: ['student-list'],
  data () {
    return {
      studentList: []
    }
  }
}
</script>
```

### 总线/Bus/发布订阅模式/观察者模式传递

通过`bus`来传值就不用给父级传值再传值给子级了

main.js

```js
Vue.config.productionTip = false;

// 创建一个Bus原型来进行传值
// 在Vue 的 prototype上挂载了一个bus的属性，该 bus 属性指向一个 Vue 的实例。在之后，只要调用 new.Vue 或者创建组件时，每个组件上都会有 bus 这个属性（为什么？因为每个Vue实例和组件都是通过 Vue 这个类进行创建，而在Vue的 prototype 挂载一个 bus 的属性，都指向同一个 Vue 的实例）
Vue.prototype.bus = new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
```

组件1

```html
<template>
  <div>
    添加学生：
    <input type="text"
           v-model="name">
    <button @click="add">确认添加</button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      name: '',
    }
  },
  methods: {
    add () {
      // 通过bus来进行传递事件，和参数
      // this.bus 指的就是 Vue.prototype.bus = new Vue () 上挂载的 bus ，同时 bus 作为Vue实例，有其方法，这里为 $emit ,以此 向外触发事件并同时 携带要传递的 内容数据
      this.bus.$emit('add', this.name);
    }
  }
}
</script>
```

组件2

```html
<template>
  <div>
    学生列表
    <ul>
      <li v-for="(item, index) in studentList"
          :key="index+item">
        {{item}}
      </li>
    </ul>
  </div>
</template>

<script>
// vuex  vue add vuex

export default {
  // props: ['student-list'],
  data () {
    return {
      studentList: []
    }
  },
  // 借助生命周期钩子来监听
  created () {
    // 向外触发事件之后，其他组件将通过 监听 的方式接收数据
    this.bus.$on("add", name => {
      this.studentList.push(name);
    })
  }
}
</script>
```

## vuex

安装：

```js
<script src="/path/to/vuex.js"></script>

vue add 'vuex' || npm install vuex@next --save
```

每一个 Vuex 应用的核心就是 store（仓库）。“store”基本上就是一个容器，它包含着你的应用中大部分的**状态 (state)**。Vuex 和单纯的全局对象有以下两点不同：

1. Vuex 的状态存储是响应式的。当 Vue 组件从 store 中读取状态的时候，若 store 中的状态发生变化，那么相应的组件也会相应地得到高效更新。

2. 你不能直接改变 store 中的状态。改变 store 中的状态的唯一途径就是显式地**提交 (commit) mutation**。这样使得我们可以方便地跟踪每一个状态的变化，从而让我们能够实现一些工具帮助我们更好地了解我们的应用。

### 创建一个store

```js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 公共数据池
    name: 'shan',
    age: 18,
    look: 'beautiful',
    studentList: [],
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
```

### State

Vuex使用单一状态数树，用一个对象就包含了全部的应用层级状态，意味和他是一个唯一数据源，每一个应用仅仅包含一个store实例

怎么再Vue组件中获得State呢，Vuex通过Vue将store从根组件中注入到所有的子组件中，子组件可以通过`this.$store`访问到

```html
<template>
  <div>
    <input type="text"
           v-model="name">
    <button @click="add">确认添加</button>
  </div>
</template>

<script>

  export default {
    data () {
      return {
        name: '',
      }
    },
    methods: {
      add () {
        // 执行函数时更改store中state里面的studnetList数组
        this.$store.state.studentList.push(this.name);
      }
    }
  }

</script>
```

```js
const Counter = {
  template: `<div>{{ count }}</div>`,
  computed: {
    count () {
      // 访问store中state的数据
      return this.$store.state.count
    }
  }
}
```

**当我们使用的状态多的时候，都使用computed声明会非常的重复和冗余，如：**

```html
<template>
  <div>
    添加学生：
    <input type="text"
           v-model="name">
    <button @click="add">确认添加</button>
  </div>
</template>

<script>
    export default {
      data () {
        return {
          name: '',
        }
      },
      // 将状态值都声明为了computed，这样会非常的冗余，而且每一个组件中使用的话还需要再复制一份，这样很麻烦
      computed:{
        storeName () {
          return this.$store.state.name;
        },
        storeAge () {
          return this.$store.state.age;
        },
        storeLook() {
      	  return this.$store.state.look;
        }
      }
      methods: {
        add () {
          this.$store.state.studentList.push(this.name);
        }
      }
    }
</script>
```

**像上面的代码，把状态都声明成computed，看起来很不好，而且用起来很麻烦，所以就有了mapState方法**

**mapState**辅助函数

- 返回值是一个对象，对象中有一些`key`和`value`，`key`的`value`都是函数 

- 当一个组件需要获取多个状态的时候，将这些状态都声明为计算属性会有些重复和冗余。为了解决这个问题，我们可以使用 `mapState` 辅助函数帮助我们生成计算属性，让你少按几次键：

```js
import { mapState } from 'vuex'

export default {
  // mapState(['name', 'age', 'look']),
  computed: {
      // 为什么要加入...展开符，因为mapState返回的是一个对象，如果不展开是访问不到的，所以需要用...来展开mapState对象，混入computed对象
      ...mapState({
          // 通过箭头函数访问
          name: state => state.name,
          // 传入字符串 'name' 就相当于 state => state.name
          nameAlias: 'name'
          // 为了能够使用 `this` 获取局部状态，必须使用常规函数
          namePlusLocalState (state) {
      	  	return state.name + this.localName
          }
        }),
  }
}
```

- 当映射的计算属性的名称与 state 的子节点名称相同时，我们也可以给 `mapState` 传一个字符串数组。

```js
computed: {
    mapState([
      // 映射 this.name 为 store.state.name
      'name'
    ])
}
```

### Getter

`getters`相当于vue中的计算属性，通过一些操作将`state`中的值过滤并计数，`getters`就是`store`自己的计算属性

```js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    studentList: ["shen","hao","zhe"],
  },
  getters: {
    // 相当于计算属性，通过数据池中进行更改得到一个新的值
    // Getter第一个参数就是state，第二个参数就是自己，方便自己调用自身的函数
    newStudent (state, getters) {
      return state.studentList.map((item, index) => {
        if (index == 0) {
          return '**' + item + getters.acorn;
        } else if (index < 3) {
          return item + '**';
        } else {
          return "++" + item + "++";
        }
      })
    },

    acorn () {
      return '1111'
    }
  },
})

```

**mapGetters辅助函数**

- `mapGetters` 辅助函数仅仅是将 store 中的 getter 映射到局部计算属性，就和`mapState`一样

```js
import { mapGetters } from 'vuex'

export default {
    computed: {
        // 使用对象展开运算符将 getter 混入 computed 对象中
        ...mapGetters({
          student: 'newStudent'
        })
        // ...mapGetters(['newStudent']),
    },
}
```

### Mutation

更改 Vuex 的 store 中的状态的唯一方法是提交 mutation。Vuex 中的 mutation 非常类似于事件：每个 mutation 都有一个字符串的**事件类型 (type)\**和一个\**回调函数 (handler)**。这个回调函数就是我们实际进行状态更改的地方，并且它会接受 state 作为第一个参数，同时也可以传入额外的参数，第二个参数用对象来传入，这样可以包含多个参数

```js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    studentList: [],
  },
  mutations: {
    // store中只有mutations中才可以更改state里面的值
    changeStudent (state, { name, number }) {
      state.studentList.push(name + number);
    }
  }
})
```

**提交方式**

```js
// 1. 提交方式使用commit来提交mutation函数，并且需要加入函数和其的参数
this.$store.commit('changeStudent', {name: 'lll', number: 10})

// 2. 提交 mutation 的另一种方式是直接使用包含 type 属性的对象
this.$store.commit({
    type: 'changeStudent',
    name: 'lll',
    number: 10,
})

// 3. 我们提交的时候也可以使用mapAction来提交
import { mapState, mapActions } from 'vuex'
export default {
 // ...
  methods: {
    ...mapMutation({
      changeStudent: 'changeStudent'
    }),
      
    ...mapMutation([
      'changeStudent',
    ]),
  }
}
// <button @click="changeStudent({ name, number: 1 })">确认添加</button>
```

**Mutation中必须是同步函数，不可以是异步函数**：具体可见[详情](https://vuex.vuejs.org/zh/guide/mutations.html#mutation-%E5%BF%85%E9%A1%BB%E6%98%AF%E5%90%8C%E6%AD%A5%E5%87%BD%E6%95%B0)

### Action

Mutation不可以进行异步函数的执行，那么就可以使用Action来提交Mutation，不是变更状态，是提交Mutation

Action可以包含任何异步操作

```js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    studentList: [],
  },
  mutations: {
    changeStudent (state, { name, number }) {
      state.studentList.push(name + number);
    }
  },
  actions: {
    // 执行异步操作
    changeStudent (context, { name, number }) {
      // context看作是一个上下文对象，是与store实例具有相同方法和属性的对象，但不是store对象
      setTimeout(function () {
        // 然后使用context.commit提交一个mutation
        context.commit("changeStudent", { 
            name, number 
        });
      }, 1000)
    }
  },
})
```

**提交Action方法**

乍一眼看上去感觉多此一举，我们直接分发 mutation 岂不更方便？实际上并非如此，还记得 **mutation 必须同步执行**这个限制么？Action 就不受约束！我们可以在 action 内部执行**异步**操作：

```js
// 1. 提交方式使用dispath来提交mutation函数，并且需要加入函数和其的参数
store.dispatch('changeStudent')

// 2. 以对象形式分发
store.dispatch({
  type: 'changeStudent',
  name: 'lll'
  number: 10
})

// 3. 使用mapActions分发
import { mapState, mapActions } from 'vuex'

export default {
  // ...
  methods: {
    ...mapActions({
      changeStudent: 'changeStudent'
    }),
  }
}
// <button @click="changeStudent({ name, number: 1 })">确认添加</button>
```

Action 通常是异步的，那么如何知道 action 什么时候结束呢？更重要的是，我们如何才能组合多个 action，以处理更加复杂的异步流程？

首先，你需要明白 `store.dispatch` 可以处理被触发的 action 的处理函数返回的 Promise，并且 `store.dispatch` 仍旧返回 Promise

```js
actions: {
  // {{commit}} 使用ES2015中的方法解构
  actionA ({ commit }) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        commit('someMutation')
        resolve()
      }, 1000)
    })
  },
      
  actionB ({ dispatch, commit }) {
    return dispatch('actionA').then(() => {
      commit('someOtherMutation')
    })
  }
}
```

调用多个组合`actions`

```js
store.dispatch('actionA').then(() => {
  // ...
})
```

使用async / await进入组合

```js
// 假设 getData() 和 getOtherData() 返回的是 Promise

actions: {
  async actionA ({ commit }) {
    commit('gotData', await getData())
  },
  async actionB ({ dispatch, commit }) {
    await dispatch('actionA') // 等待 actionA 完成
    commit('gotOtherData', await getOtherData())
  }
}
```

一个 `store.dispatch` 在不同模块中可以触发多个 action 函数。在这种情况下，只有当所有触发函数完成后，返回的 Promise 才会执行。

### Module

#### 模块局部状态

我们平时使用Store时，把所有的数据放进去会集中到一个比较大的对象，当应用逐渐增大的时候，store对象就会变得十分的臃肿

为了解决这些问题，Vue可以将store分割成一个一个的模块（module）。每个模块都拥有着自己的state、mutation、action、getter和嵌套字模块

```js
const moduleA = {
  // 命名空间
  namespaced: true,
  state: () => ({ ... }),
  mutations: { ... },
  actions: { 
	// 这里的 `state` 对象是模块的局部状态
	// 对于模块内部的 action，局部状态通过 context.state 暴露出来，根节点状态则为 context.rootState
                
	// 再开启命名空间后，getter中的getters就别局部化了，可以使用第四个参数来调用rootGetters
	incrementIfOddOnRootSum ({ state, commit, rootState, rootGetters }) {
      if ((state.count + rootState.count) % 2 === 1) {
        commit('increment')
      }
    }
  },
  getters: { 
    // 对于模块内部的 getter，根节点rootState状态会作为第三个参数暴露出来
      
    // 再开启命名空间后
    // 在这个模块中， dispatch 和 commit 也被局部化了
    // 他们可以接受 `root` 属性以访问根 dispatch 或 commit
  	sumWithRootCount (state, getters, rootState, rootGetters) {
      return state.count + rootState.count
    }
  }
}

const moduleB = {
  state: () => ({ ... }),
  mutations: { ... },
  actions: { ... }
}

const store = createStore({
  modules: {
    a: moduleA,
    b: moduleB
  }
})

store.state.a // -> moduleA 的状态
store.state.b // -> moduleB 的状态
```

#### 命名空间

默认情况下，模块内部的 action 和 mutation 仍然是注册在**全局命名空间**的——这样使得多个模块能够对同一个 action 或 mutation 作出响应。Getter 同样也默认注册在全局命名空间，但是目前这并非出于功能上的目的（仅仅是维持现状来避免非兼容性变更）。必须注意，不要在不同的、无命名空间的模块中定义两个相同的 getter 从而导致错误。

如果希望你的模块具有更高的封装度和复用性，你可以通过添加 `namespaced: true` 的方式使其成为带命名空间的模块。当模块被注册后，它的所有 getter、action 及 mutation 都会自动根据模块注册的路径调整命名

```js
const store = createStore({
  modules: {
    account: {
      // 命名空间
      namespaced: true,

      // 模块内容（module assets）
      state: () => ({ ... }), // 模块内的状态已经是嵌套的了，使用 `namespaced` 属性不会对其产生影响
      getters: {
        isAdmin () { ... } // -> getters['account/isAdmin']
      },
      actions: {
        login () { ... } // -> dispatch('account/login')
      },
      mutations: {
        login () { ... } // -> commit('account/login')
      },

      // 嵌套模块
      modules: {
        // 继承父模块的命名空间
        myPage: {
          state: () => ({ ... }),
          getters: {
            profile () { ... } // -> getters['account/profile']
          }
        },

        // 进一步嵌套命名空间
        posts: {
          namespaced: true,

          state: () => ({ ... }),
          getters: {
            popular () { ... } // -> getters['account/posts/popular']
          }
        }
      }
    }
  }
})
```

启用了命名空间的 getter 和 action 会收到局部化的 `getter`，`dispatch` 和 `commit`。换言之，你在使用模块内容（module assets）时不需要在同一模块内额外添加空间名前缀。更改 `namespaced` 属性后不需要修改模块内的代码。

**再开启命名空间的模块中注册全局action**

可以添加`root:true`

```js
{
  actions: {
    someOtherAction ({dispatch}) {
      dispatch('someAction')
    }
  },
  modules: {
    foo: {
      namespaced: true,

      actions: {
        someAction: {
          root: true,
          handler (namespacedContext, payload) { ... } // -> 'someAction'
        }
      }
    }
  }
}
```

怎么在组件中使用带有命名空间独立的模块，将模块的名称作为第一个字符串传递给`mapStatte`等参数，这样就会访问到该模块了

```js
computed: {
  ...mapState('模块名', {
    a: state => state.a,
    b: state => state.b
  })
},
methods: {
  ...mapActions('模块名', [
    'foo', // -> this.foo()
    'bar' // -> this.bar()
  ])
}
// ...mapState('course', ['courseList'])
```

也可以使用`createNamespacedHelpers`中创建某个命名空间的模块，返回的是一个对象

```js
import { createNamespacedHelpers } from 'vuex'

const { mapState, mapActions } = createNamespacedHelpers('some/nested/module')

export default {
  computed: {
    // 在 `some/nested/module` 中查找
    ...mapState({
      a: state => state.a,
      b: state => state.b
    })
  },
  methods: {
    // 在 `some/nested/module` 中查找
    ...mapActions([
      'foo',
      'bar'
    ])
  }
}
```

#### 模块动态注册

在 store 创建**之后**，你可以使用 `store.registerModule` 方法注册模块：

```js
import { createStore } from 'vuex'

const store = createStore({ /* 选项 */ })

// 注册模块 `myModule`
store.registerModule('myModule', {
  // ...
})
// 注册嵌套模块 `nested/myModule`
store.registerModule(['nested', 'myModule'], {
  // ...
})
```

之后就可以通过 `store.state.myModule` 和 `store.state.nested.myModule` 访问模块的状态。

模块动态注册功能使得其他 Vue 插件可以通过在 store 中附加新模块的方式来使用 Vuex 管理状态。例如，[`vuex-router-sync`](https://github.com/vuejs/vuex-router-sync) 插件就是通过动态注册模块将 Vue Router 和 Vuex 结合在一起，实现应用的路由状态管理。

你也可以使用 `store.unregisterModule(moduleName)` 来动态卸载模块。注意，你不能使用此方法卸载静态模块（即创建 store 时声明的模块）。

注意，你可以通过 `store.hasModule(moduleName)` 方法检查该模块是否已经被注册到 store。需要记住的是，嵌套模块应该以数组形式传递给 `registerModule` 和 `hasModule`，而不是以路径字符串的形式传递给 module。

#### 保留 state

[保留-state](https://vuex.vuejs.org/zh/guide/modules.html#保留-state)

在注册一个新 module 时，你很有可能想保留过去的 state，例如从一个服务端渲染的应用保留 state。你可以通过 `preserveState` 选项将其归档：`store.registerModule('a', module, { preserveState: true })`。

当你设置 `preserveState: true` 时，该模块会被注册，action、mutation 和 getter 会被添加到 store 中，但是 state 不会。这里假设 store 的 state 已经包含了这个 module 的 state 并且你不希望将其覆写。

