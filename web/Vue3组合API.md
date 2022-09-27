---
title: Vue3组合API
date: 2022-05-17 08:07:41
tags:
  - Vue3
categories:
  - Vue
---

<!--more-->

# Vue3 组合API

## 使用 vite 构建 Vue

```js
npm init vite-app <project-name>
```

```js
cd <project-name>
```

```js
npm install
```

```js
npm run dev
```

## 组合API

通过创建 Vue 组件，我们可以将界面中重复的部分连同其功能一起提取为可重用的代码段。仅此一项就可以使我们的应用在可维护性和灵活性方面走得相当远。然而，我们的经验已经证明，光靠这一点可能并不够，尤其是当你的应用变得非常大的时候——想想几百个组件。处理这样的大型应用时，共享和重用代码变得尤为重要。

![Vue 选项式 API: 按选项类型分组的代码](https://v3.cn.vuejs.org/images/options-api.png)

这是一个大型组件的示例，其中**逻辑关注点**按颜色进行分组。

这种碎片化使得理解和维护复杂组件变得困难。选项的分离掩盖了潜在的逻辑问题。此外，在处理单个逻辑关注点时，我们必须不断地“跳转”相关代码的选项块。

如果能够将同一个逻辑关注点相关代码收集在一起会更好。而这正是组合式 API 使我们能够做到的。

### setup()

> 新的 `setup` 选项在组件被创建**之前**执行，一旦 `props` 被解析完成，它就将被作为组合式 API 的入口。

> `setup` 选项是一个接收 `props` 和 `context` 的函数， `setup` 返回的所有内容都暴露给组件的其余部分 (计算属性、方法、生命周期钩子等等) 以及组件的模板。

> `setup`中应该避免使用this，因为它找不到组件实例。`setup` 的调用发生在 `data` property、`computed` property 或 `methods` 被解析之前

#### 参数

使用`setup`时，它接受了两个参数`props`和`context`

- props
  - 就是用来接收外部传入的props属性值，来进行操作

```js
import { toRefs } from 'vue'

setup(props) {
  const { title } = toRefs(props)
  console.log(title.value)
}
```

- context
  - context是一个普通的对象，用来操作在setup中有用的值

```js
export default {
  setup(props, context) {
    // Attribute (非响应式对象，等同于 $attrs)
    console.log(context.attrs)

    // 插槽 (非响应式对象，等同于 $slots)
    console.log(context.slots)

    // 触发事件 (方法，等同于 $emit)
    console.log(context.emit)

    // 暴露公共 property (函数)
    console.log(context.expose)
  }
}
```

#### 访问组件的property

- 执行setup时，只可以访问以下prop
  - `props`
  - `attrs`
  - `slots`
  - `emit`
- 无法访问以下组件
  - `data`
  - `computed`
  - `methods`
  - `refs`

#### 渲染操作

Vue2操作数据时的操作

```vue
<template>
  <div>
    <h1 @click="changeEvent">计数；{{count}}</h1>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      count: 0
    }
  },
  methods: {
    changeEvent () {
      this.count++;
    }
  },
  watch:{
      count(){
          console.log(this.count + "watch")
      }
  },
  computed:{
	change:{
        get(){
            console.log(this.count + "get")
        },
        set(value){
            console.log(this.count + "set")
        }
    }
  }
}
// 使用vue2操作数据时一旦数据繁杂之后就会很复杂，不容易维护
</script>
```

Vue3使用setup时
```vue
<template>
    <div>
        <h1 @click="changeNum">计数；{{num}}</h1>
        <h1>{{username}}</h1>
        <h1>{{age}}</h1>
        <h1>{{reverseAge}}</h1>
    </div>
</template>

<script>
  import { ref,toRefs,reactive,computed,watch} from 'vue'

  export default {
    setup () {
      const num = ref(0);
       // 在setup中声明函数
      function changeNum () {
        num.value += 10;
      }
        
        
      // 如果setup需要返回一个对象，使用reactive来进行响应式绑定
      const user = reactive({
          username: "小鱼！",
          age:18,
          // 使用computed属性来进行监听
          reverseAge: computed(() => {
            return user.type.split("").reverse().join("");
          })
      })
      
      
      // 使用watch监听单个数据,并返回两个参数（新val，旧val）
      watch(num,(newVal,prevVal) => {
          console.log(newVal,prevVal)
      })
        
      // 使用watch监听多个数据，使用数组包裹
      watch([num,user],(newVal,prevVal) =>{
          console.log(newVal,prevVal)
      })
      
      
      // 通过return返回回去之后可以访问
      // 使用...Refs后可以重构user对象，直接访问其中的属性
      return { num, changeNum,...toRefs(user),}
    },
  }
</script>
```

### Vue3生命周期钩子

Vue3中生命周期在Vue2的生命周期前加了on

同时Vue3生命周期函数接收一个回调函数

当组件被调用时执行，Vue3生命周期中`beforeCreate`与`created`被`setup`代替

Vue3使用生命周期函数的时候需要先引用

| 选项式API       | Hook inside setup   | 功能                                                         |
| --------------- | ------------------- | ------------------------------------------------------------ |
| beforeCreate    | Not needed* setup() |                                                              |
| created         | Not needed* setup() | 在 beforeCreate 和 created 之前执行，创建的是 data 和 method |
| beforeMount     | onBeforeMount       | 组件挂载到节点上之前执行的函数                               |
| mounted         | onMounted           | 组件挂载完成后执行的函数                                     |
| beforeUpdate    | onBeforeUpdate      | 组件更新之前执行的函数                                       |
| updated         | onUpdated           | 组件更新完成之后执行的函数                                   |
| beforeUnmount   | onBeforeUnmount     | 组件卸载之前执行的函数                                       |
| unmounted       | onUnmounted         | 组件卸载完成后执行的函数                                     |
| errorCaptured   | onErrorCaptured     | 当捕获一个来自子孙组件的异常时激活钩子函数                   |
| renderTracked   | onRenderTracked     | 跟踪虚拟DOM重新渲染时调用,钩子接收debugger event作为参数,此事件告诉你哪个操作跟踪了组件以及该操作的目标对象和键。 |
| renderTriggered | onRenderTriggered   | 当虚拟DOM重新渲染被触发时调用,和renderTracked类似,接收debugger event作为参数,此事件告诉你是什么操作触发了重新渲染,以及该操作的目标对象和键。 |
| activated       | onActivated         | 被包含在 <keep-alive> 中的组件，会多出两个生命周期钩子函数，被激活时执行； |
| deactivated     | onDeactivated       | 比如从 A 组件，切换到 B 组件，A 组件消失时执行               |

```js
import {onBeforeMount,onMounted,onBeforeUpdate,onUpdated,onBeforeUnmount,onUnmounted} from 'vue'
export default {
  setup () {
    onBeforeMount(() => {
      console.log('beforeMounte: 挂在渲染之前');
    })
    onMounted(() => {
      console.log('mounted：挂载渲染之后');
    })
    onBeforeUpdate(() => {
      console.log('beforeUpdate：更新之前');
    })
    onUpdated(() => {
      console.log('updated：更新之后');
    })
    onBeforeUnmount(() => {
      console.log('beforeDestory:销毁之前');
    })
    onUnmounted(() => {
      console.log('destoryed:销毁之后');
    })
  },
}
```

### Provide & inject

> Provide和inject一般用于父组件传递给子组件数据

- provide有两个参数
  - name: <String>类型
  - value: 数据
- inject
  - name: <String>类型

```vue
<!-- Father.vue -->
<template>
	<!--使用组件标签-->
    <Son />
</template>

<script>

// 引入Provide与reactive   
import { reactive, provide } from "vue"
// 引入子组件
import Son from "./components/Son.vue"

export default {
  components: {
    Son
  },
  setup () {
    // 在setup中使用reactive创建响应对象
    const student = reactive({
      name: "小小",
      age: 18
    })

    // 使用provide进行传输数据
    provide("student", student)
  }
}
</script>
```

子组件

```vue
<!-- Son.vue -->
<template>
  <div>
    <h1>学生</h1>
    <h1>用户名：{{name}}</h1>
    <h1>年龄：{{age}}</h1>
  </div>
</template>

<script>
// 引入inject
import { inject } from 'vue'

export default {
  setup (props, context) {
    // 使用inject来获取provide传输的数据
    const student = inject("student")
    // 返回数据并解构
    return { ...student }
  }
}
</script>
```

## 



