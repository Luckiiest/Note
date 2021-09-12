# Es6

## 概述

- 介绍：
  - `ES2015`年退出`JavaScript`新版本也叫`ES2015`
  - 现在已经`ES7（2016）`，`ES8（2017）`，`ES9（2018）`很多新增内容仍是填
  - 普遍使用的依然是`ES6`，`ES7`部分内容
  - `ES7`及后面版本浏览器或node环境未完全支持，但已有`babel`工具可对其进行编译支持（转成`ES5`）
  - 所以：新版本语言只是在原有基础上新增了一些语法糖，执行时还会转换为`ES5`
- **ECMAScript**、**JavaScript**、**NodeJs**，它们的区别是什么？
  - `ECMAScript`：简称`ES`，是一个语言标准（循环、判断、变量、数组等数据类型）
  - `JavaScript`：运行在浏览器端的语言，该语言使用`ES`标准，`ES + web api = JavaScript`
  - `NodeJs`：运行在服务器端的语言，该语言使用`ES`标准，`ES + node api = JavaScript`
- **ECMAScript**有哪些关键的版本？
  - `ES3.0`：`1999`
  - `ES5.0`：`2009`
  - `ES6.0`：`2015`，从该版本不再使用数字作为编号，而使用年份，也叫`ES2015`
  - `ES7.0`：`2016`
- 为什么**ES6**如此重要？
  - `ES6`解决`JS`无法开发大型应用的语言层面的问题。
- 为什么要学习`ES6`？
  - `ES6`引入的语言新特性，更具规范性，易读性，方便操作，简化了大型项目开发的复杂程度、降低了出错概率，提升了开发效率
  - 大部分公司（不代表所有，代表着一个趋势）都在用`ES6`开发，已成为开发，求职必会内容

## 块级绑定

### babel本地使用

- 用`Babel`工具做对比`ES6`->低级语法

- 在线`Babel`工具(https://babeljs.io/repl)（https://babeljs.cn）

- `npm`本地下载工具（用于生产环境）

  - `npm init -y` ：初始化

  - `npm install @babel/core @babel/cli @babel/preset-env`：安装**Babel**

  - `npx babel xxx.js(需要被转换的文件名称) -o xxx.js(转换完成的文件名称) --watch`：编译`ES6`格式的`js`文件，`--watch`是时刻监控(更新)

  - **babel**配置文件：

    - **.babelrc**文件，严格`json`

    - ```js
      {
          "presets": [
              "@babel/preset-env"
          ],
          "plugins": [
      
          ],
          ……
      }
      ```

### 声明变量的问题

- 使用`var`声明变量
- 允许重复的变量声明：导致数据被覆盖
- 变量提升：怪异的数据访问、闭包问题
- 全局变量挂载到`window`全局对象：全局对象成员污染问题

### 使用let声明变量

- 加强了对作用域的控制

`ES6`不仅引入`let`关键字用于解决变量声明的问题，同时引入了块级作用域的概念

块级作用域：代码执行时遇到花括号，会创建一个块级作用域，花括号结束，销毁块级作用域

- 特点
  - `let`声明的变量不会挂载到全局对象
  - `let`声明的变量，不允许当前作用域范围内重复声明
  - 在块级作用域中用`let`定义的变量，在作用域外不能访问
  - 使用`let`不会有变量提升，因此，不能在定义`let`变量之前使用它

底层实现上，`let`声明的变量实际上也会有提升，但是，提升后会将其放入到“暂时性死区”，如果访问的变量位于暂时性死区，则会报错：`“Cannot access 'a' before initialization”`。当代码运行到该变量的声明语句时，会将其从暂时性死区中移除。

在循环中，用`let`声明的循环变量，会特殊处理，每次进入循环体，都会开启一个新的作用域，并且将循环变量绑定到该作用域（每次循环，使用的是一个全新的循环变量）

在循环中使用`let`声明的循环变量，在循环结束后会销毁

```javascript
//临时死区
let a = 10;
{
    console.log(a);
    //Cannot access 'a' before initialization
    let a = 20;
}

//闭包
var arr = [];
//let声明会销毁块级作用域
for (let i = 0; i < 10; i++) {
	arr[i] = function(){ 
		console.log(i);
	}
}
arr[0]();
arr[4]();
arr[7]();
```



### 使用const声明常量

>  `const`和`let`完全相同，仅在于用`const`声明的变量，必须在声明时赋值，而且不可以重新赋值。

- 实际上，在开发中，应该尽量使用`const`来声明变量，以保证变量的值不会随意篡改，原因如下：

1. 根据经验，开发中的很多变量，都是不会更改，也不应该更改的。

2. 后续的很多框架或者是第三方`JS`库，都要求数据不可变，使用常量可以一定程度上保证这一点。

3. 注意的细节：

   1. 常量不可变，是指声明的常量的内存空间不可变，并不保证内存空间中的地址指向的其他空间不可变。

      1. ```js
         const PI = {};
         PI.name = 20;
         //PI = 20;
         ```

   1. 常量的命名
      1. 特殊的常量：该常量从字面意义上，一定是不可变的，比如圆周率、月地距地或其他一些绝不可能变化的配置。通常，**该常量的名称全部使用大写，多个单词之间用下划线分割**
      2. 普通的常量：使用和之前一样的命名即可
   2. 在`for`循环中，循环变量不可以使用常量

## 字符串和正则表达式

### 更好的Unicode支持

- 早期，由于存储空间宝贵，`Unicode`使用`16`位二进制来存储文字。我们将一个`16`位的二进制编码叫做一个码元（`Code Unit`）。

- 后来，由于技术的发展，`Unicode`对文字编码进行了扩展，将某些文字扩展到了`32`位（占用两个码元），并且，将某个文字对应的二进制数字叫做码点（`Code Point`）。

- `ES6`为了解决这个困扰，为字符串提供了方法：`codePointAt`，根据字符串码元的位置得到其码点。

- 同时，`ES6`为正则表达式添加了一个`flag: u`，如果添加了该配置，则匹配时，使用码点匹配

- ```js
  const text = '𠮷';
  
  console.log("字符串长度：", text.length);
  console.log("使用正则测试：", /^.$/u.test(text));
  console.log("得到第一个码元：", text.charCodeAt(0));
  console.log("得到第二个码元：", text.charCodeAt(1));
  
  //𠮷：\ud842\udfb7
  console.log("得到第一个码点：", text.codePointAt(0));
  console.log("得到第二个码点：", text.codePointAt(1));
  
  /**
   * 判断字符串char，是32位，还是16位
   * @param {*} char 
   */
  function is32bit(char, i) {
      //如果码点大于了16位二进制的最大值，则其是32位的
      return char.codePointAt(i) > 0xffff;
  }
  
  /**
   * 得到一个字符串码点的真实长度
   * @param {*} str 
   */
  function getLengthOfCodePoint(str) {
      var len = 0;
      for (let i = 0; i < str.length; i++) {
          //i在索引码元
          if (is32bit(str, i)) {
              //当前字符串，在i这个位置，占用了两个码元
              i++;
          }
          len++;
      }
      return len;
  }
  
  console.log("𠮷是否是32位的：", is32bit("𠮷", 0))
  console.log("ab𠮷ab的码点长度：", getLengthOfCodePoint("ab𠮷ab"))
  ```

### 更多的字符串API

- 以下均为字符串的实例（原型）方法

- **includes**：判断字符串中是否包含指定的子字符串

- **startsWith**：判断字符串中是否以指定的字符串开始

- **endsWith**：判断字符串中是否以指定的字符串结尾

- **repeat**：将字符串重复指定的次数，然后返回一个新字符串。

- ```js
  const text = "成哥是狠人";
  
  console.log("是否包含“狠”：", text.includes("狠"));
  console.log("是否以“成哥”开头：", text.startsWith("成哥"));
  console.log("是否以“狠人”结尾：", text.endsWith("狠人"));
  console.log("重复4次：", text.repeat(4));
  ```

### 模板字符串

- `ES6`之前处理字符串繁琐的两个方面：
  - 多行字符串
  - 字符串拼接

- 在`ES6`中，提供了模板字符串的书写，可以非常方便的换行和拼接，要做的，仅仅是将字符串的开始或结尾改为 **`** 符号

- 如果要在字符串中拼接`js`表达式，只需要在模板字符串中使用```${JS表达式}```

- ```js
  let val = "我是"
  var text = `${val}人` 
  //等同于
  var text = "我是" + "人";
  //${表达式}，表达式可以是任何表达式
  ```



## 函数

### 参数默认值

- 使用

  - 在书写形参时，直接给形参赋值，附的值即为默认值

  - 这样一来，当调用函数时，如果没有给对应的参数赋值（给它的值是`undefined`），则会自动使用默认值。

  - ```js
    function sum(a, b = 1, c = 2) {
        return a + b + c;
    }
    console.log(sum(10, undefined, undefined))
    console.log(sum(11))
    console.log(sum(1, undefined, 5))
    ```

- [扩展]对**arguments**的影响

  - 只要给函数加上参数默认值，该函数会自动变量严格模式下的规则：arguments和形参脱离

  - ```js
    function getContainer() {
        console.log("abc");
        return document.getElementById("container");
    }
    
    /**
     * 创建一个元素
     * @param {*} name 元素的名称 
     * @param {*} container 元素的父元素
     * @param {*} content 元素的内容 
     */
    function createElement(name = "div", container = getContainer(), content = "") {
        const ele = document.createElement(name)
        if (content) {
            ele.innerHTML = content;
        }
        container.appendChild(ele);
    }
    
    createElement(undefined, undefined, "手动阀手动阀十分")
    createElement(undefined, undefined, "234242342424")
    createElement(undefined, document.getElementById("container"), "234242342424")
    ```

- [扩展]留意暂时性死区

  - 形参和`ES6`中的`let`或`const`声明一样，具有作用域，并且根据参数的声明顺序，存在暂时性死区。

  - ```js
    function test(a, b = 1) {
        console.log("arugments", arguments[0], arguments[1]);
        console.log("a:", a, "b:", b);
        a = 3;
        console.log("arugments", arguments[0], arguments[1]);
        console.log("a:", a, "b:", b);
    }
    
    test(1, 2);
    ```

### 剩余参数

- **arguments**的缺陷：

  - 如果和形参配合使用，容易导致混乱
  - 从语义上，使用`arguments`获取参数，由于形参缺失，无法从函数定义上理解函数的真实意图

- **ES6**的剩余参数专门用于手机末尾的所有参数，将其放置到一个形参数组中。

  - 语法:

  - ```js
    function (...形参名){
    
    }
    ```

- 实例

  - ```js
    function test(a, b, ...args) {
        
    }
    
    test(1, 32, 46, 7, 34); 
    ```

  - ```js
    function sum(...args) {
        //args收集了所有的参数，形成的一个数组
        let sum = 0;
        for (let i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }
    
    console.log(sum())
    console.log(sum(1))
    console.log(sum(1, 2))
    console.log(sum(1, 2, 3))
    console.log(sum(1, 2, 3, 4))
    ```

  - ```js
    function test(...args1, ...args2) {
        console.log(args1)
        console.log(args2)
    }
    
    test(1, 32, 46, 7, 34);
    ```

- **细节：**
  - 一个函数，仅能出现一个剩余参数
  - 一个函数，如果有剩余参数，剩余参数必须是最后一个参数

### 展开运算符

使用方式：```  ...要展开的东西  ```

- 对数组展开 **ES6**

  - ```js
    const arr1 = [3, 67, 8, 5];
    
    //克隆arr1数组到arr2
    
    const arr2 = [0, ...arr1, 1];
    
    console.log(arr2, arr1 === arr2)
    ```

- 对对象展开 **ES7**

  - ```js
    const obj1 = {
        name: "成哥",
        age: 18,
        love: "邓嫂",
        address: {
            country: "中国",
            province: "黑龙江",
            city: "哈尔滨"
        }
    }
    
    // 浅克隆到obj2
    
    const obj2 = {
        ...obj1,
        name: "邓哥"
    };
    
    console.log(obj2)
    
    console.log(obj1.address === obj2.address)
    ```

- 实例

  - ```js
    const obj1 = {
        name: "成哥",
        age: 18,
        loves: ["邓嫂", "成嫂1", "成嫂2"],
        address: {
            country: "中国",
            province: "黑龙江",
            city: "哈尔滨"
        }
    }
    
    // 浅克隆到obj2
    const obj2 = {
        ...obj1,
        name: "邓哥",
        address: {
            ...obj1.address
        },
        loves: [...obj1.loves, "成嫂3"]
    };
    
    console.log(obj2)
    
    console.log(obj1.loves === obj2.loves)
    ```

  - ```js
    /**
     * 对所有数字求和
     * @param  {...any} args 
     */
    function sum(...args) {
        let sum = 0;
        for (let i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }
    
    /**
     * 获取一个指定长度的随机数组成的数组
     * @param {*} length 
     */
    function getRandomNumbers(length) {
        const arr = [];
        for (let i = 0; i < length; i++) {
            arr.push(Math.random());
        }
        return arr;
    }
    
    const numbers = getRandomNumbers(10);
    //将数组的每一项展开，依次作为参数传递，而不是把整个数组作为一个参数传递
    // sum(numbers)
    
    console.log(sum(...numbers))//相当于传递了10个参数
    console.log(sum(1, 3, ...numbers, 3, 5))

### 确函数的双重用途

> `ES6`提供了一个特殊的`API`，可以使用该`API`在函数内部，判断该函数是否使用了`new`来调用

```js
new.target 
//该表达式，得到的是：如果没有使用new来调用函数，则返回undefined
//如果使用new调用函数，则得到的是new关键字后面的函数本身
```

- ```js
  function Person(firstName, lastName) {
      //判断是否是使用new的方式来调用的函数
  
      // //过去的判断方式
      // if (!(this instanceof Person)) {
      //     throw new Error("该函数没有使用new来调用")
      // }
  
      if (new.target === undefined) {
          throw new Error("该函数没有使用new来调用")
      }
      this.firstName = firstName;
      this.lastName = lastName;
      this.fullName = `${firstName} ${lastName}`;
  }
  
  const p1 = new Person("袁", "进");
  console.log(p1)
  
  
  
  const p2 = Person("袁", "进");
  console.log(p2);
  
  const p3 = Person.call(p1, "袁", "进")
  console.log(p3);
  ```

### 箭头函数

- 回顾：`this`指向
  - 通过对象调用函数，`this`指向对象
  - 直接调用函数，`this`指向全局对象
  - 如果通过`new`调用函数，`this`指向新创建的对象
  - 如果通过`apply`、`call`、`bind`调用函数，`this`指向指定的数据
  - 如果是`DOM`事件函数，`this`指向事件源
- 特点
  - 不用写`function`关键字
  - 只能作为函数使用不能`new`为构造函数，没有原型
  - 参数不能重复命名
  - 返回值可以不写`return`，但是有时需要配合`{}`
  - 内部`arguments`、`this` 由定义时外围最接近一层的非箭头函数的`arguments`和`this`决定其值

- 使用语法
  - 箭头函数是一个函数表达式，理论上，任何使用函数表达式的场景都可以使用箭头函数

  - 完整语法：

    - ```js
      (参数1, 参数2, ...)=>{
          //函数体
      }
      
      const isOdd = (num) => {
          return num % 2 !== 0;
      }
      ```

  - 如果参数只有一个，可以省略小括号

    - ```js
      参数 => const print = num => {console.log("给我的数字是：", num)}
      ```

  - 如果箭头函数只有一条返回语句，可以省略大括号，和`return`关键字

    - ```js
      参数 => 返回值
      ```

  - 注意细节

    - 箭头函数中，不存在`this`、`arguments`、`new.target`，如果使用了，则使用的是函数外层的对应的`this`、`arguments`、`new.target`
    - 箭头函数没有原型
    - 箭头函数不能作用构造函数使用

- 应用场景

  - 临时性使用的函数，并不会可以调用它，比如：
  - 事件处理函数
  - 异步处理函数
  - 其他临时性的函数
  - 为了绑定外层this的函数
  3. 在不影响其他代码的情况下，保持代码的简洁，最常见的，数组方法中的回调函数

- 实例

  - ```js
    //原来的函数
    function sum(a,b) {
        return a + b;
    }
    
    //箭头函数
    //求和,可以不写return，但是函数体需要在箭头后面
    let sum = (a,b) => a + b;
    
    //对象,如果想返回对象，则需要将对象变为函数表达式，大括号外面加一层括号,({})
    let sum = (a,b) => ({a:a,b:b});
    ```

  - 例：高阶函数

    - ```js
      //高阶函数：如果一个函数接受一个参数以后，如果返回一个函数的话就是高阶函数，或者这个函数能够接受一个参数，这个参数是一个函数的话也是高阶函数
      
      //普通形式
      function sum(x) {
      	return function(y) {
              return function (z) {
                  return x + y + z;
              }
          }
      }
      var sum1 = sum(1);
      var sum2 = sum1(2);
      console.log(sum2(3));
      
      //箭头函数形式
      let sum = (x) => {
          return (y) => {
              return (z) => {
                  return x + y + z;
              }
          }
      }
      //当去掉return时就变为下面的形式了
      //当箭头函数的形参只有一个时，是可以去掉参数的括号，但是当形参有一个以上的情况下，需要括上括号
      let sum = (x) => (y) => (z) => x + y + z;
      sum(1)(2)(3);
      ```

  - 不能`new`

    - ```js
      let sum = () => {
          this.a = 10;
      }
      
      new sum();//会报错
      //arrow.js:33 Uncaught TypeError: sum is not a constructor at arrow.js:33
      //sum.prototype => undefined
      ```

  - 形式区分：

    - ```js
      //函数形式
      let sum = () => {
          
      };
      sum();
      
      //对象形式
      let obj = {
          fn: () => {
              
          }
      }
      obj.fn();
      
      //数组形式
      let arr = [() => {}]
      arr[0()];
      
      //同时也可以返回值也可以是箭头函数
      return () => {}
      ```

  - **arguments**特点

    - ```js
      //内部arguments、this 由定义时外围最接近一层的非箭头函数的arguments和this决定其值，也就是说箭头函数的外围不是箭头函数才会有arguments
      
      function outer() {
          //arguments
          //9 10 11
          let sum = (a,b) => {
              console.log(arguments,a,b);
              //这个输出的argument就是outer的arguments，箭头函数本身没有arguments
          };
          sum(1,2);
      }
      outer(9,10,11);
      
      
      //当函数需要返回外围函数的arguments时，可以使用箭头函数
      
      function Curry() {
          /* 
          var arg = arguments;
          return function() {
             console.log(arg,arguments)
          	//如果不使用箭头函数，这个arguments就是这个函数本身的arguments，就需要外围声明一个变量储存arguments
          } 
          */
          return () => {
              console.log(arguments);
          }
      }
      Curry(1,2,3);
      ```

  - **this**特点

    - ```js
      //当箭头函数外围没有非箭头函数时，则this等于window
      var a = 'outerObj';
      let obj = {
          a:"innserObj",
          fn: () => {
              // this => window
              console.log(this.a);//outerObj
          }
      }
      obj.fn();
      ```

    - ```js
      var a = 'outerObj';
      let obj = {
          a: 'innerObj',
          //fn() {}就相当于fn: function(){}
          fn() {
              let sum = () => {
                  //this => window，这时外围就有了非箭头函数了，this指向也就变味了obj
                  console.log(this.a); //innserObj
              }
              return sum;
          }
      }
      let outerSum = obj.fn();
      outerSum();
      ```

    - ```js
      let obj = {
          ms: 'abc',
          fn() {
              // var self = this;
              setTimeout(() => {
                  console.log(this.ms);
              },500)
          }
      };
      obj.fn();
      ```

## 对象

### 新增的对象字面量语法

- 成员速写
  - 如果对象字面量初始化时，成员的名称来自于一个变量，并且和变量的名称相同，则可以进行简写

- 方法速写

  - 对象字面初始化时，方法可以省略冒号和`function`关键字

- 计算属性名

  - 有的时候，初始化对象时，某些属性名可能来自于某个表达式的值，在`ES6`，可以使用中括号来表示该属性名是通过计算得到的。

- ```js
  const prop1 = "name2";
  const prop2 = "age2";
  const prop3 = "sayHello2";
  
  const user = {
      [prop1]: "姬成",
      [prop2]: 100,
      // 方法可以省略冒号和关键字
      [prop3](){
          console.log(this[prop1], this[prop2])
      }
  }
  
  user[prop3]();
  
  console.log(user)
  ```

### Object的新增API

- **Object.is**
  - 用于判断两个数据是否相等，基本上跟严格相等（===）是一致的，除了以下两点：
  - `NaN`和`NaN`相等
  - `+0`和`-0`不相等
- **Object.assign**
  - 用于混合对象
- **Object.getOwnPropertyNames** 的枚举顺序
  - `Object.getOwnPropertyNames`方法之前就存在，只不过，官方没有明确要求，对属性的顺序如何排序，如何排序，完全由浏览器厂商决定。
  - `ES6`规定了该方法返回的数组的排序方式如下：
    - 先排数字，并按照升序排序
    - 再排其他，按照书写顺序排序
- **Object.setPrototypeOf**
  - 该函数用于设置某个对象的隐式原型
  - 比如： `Object.setPrototypeOf(obj1, obj2)`，相当于：  ` obj1.__proto__ = obj2 `

- 实例

  - ```js
    console.log(NaN === NaN); // false
    console.log(+0 === -0);  // true
    
    console.log(Object.is(NaN, NaN)) //true
    console.log(Object.is(+0, -0)) // false
    ```

  - ```js
    const obj1 = {
        a: 1
    }
    const obj2 = {
        b: 2
    }
    
    // obj1.__proto__ = obj2
    Object.setPrototypeOf(obj1, obj2)
    console.log(obj1)
    ```

### Object.defineProperty

- 简介

  - `ES5`规范开始后续版本迭代，也在致力于做一件事，就是把`js`底层已有的功能，提供给开发者使用。`Object.defineProperty`就是其中一个，此方法会可直接在一个对象上定义一个新的具有详细描述的属性，或者修改一个对象的现有属性，并返回这个对象。
  - 在一个对象上定义一个新的具有详细描述的属性，或者修改一个对象的现有属性。

- 使用：

  - **Object.defineProperty**(对象,属性,描述符);

  - 描述符对象的属性的进行详细描述：

    - 数据描述符：

      - **value**：`'xxx'` 属性值。默认~(空)

      - **writable**：`true` 是否可写。默认`false`

      - **configurable**：`true` 是否可配置。默认`false`

      - **enumerable**：`true` 是否可枚举。默认`false`

      - ```js
        let obj = {
            name: 'cst'
        }
        
        //value,对象中的值
        console.log(obj.name);
        //writable true(可写)
        obj.name = 'yz'
        //configurable true,delete对象(可配置)
        delete obj.name
        //enumerable true,枚举(可枚举)
        for(var prop in obj) {
            console.log(prop);
        }
        
        
        //writable false(不可写)
        Function.prototype
        //configurable false(不可配置)
        var a = 10; window.a;//window全局变量不可被删
        //enumerable false(不可枚举)
        Object.prototype
        ```

    - 存取描述符

      - **set**：`function(){}` 属性访问器 进行写操作时调用该方法

        - ```js
          var obj = {
              tempValue: 'duyi',
              //set更改时需要传入value，进行更改
              set name(value) {
                 this.tempValue = value;
                  //将原属性更改为value
              }
          }
          obj.name = 10;//传入value
          ```

      - **get**：`function(){}` 属性访问器 进行读操作时调用该方法

        - ```js
          var obj = {
              tempValue: 'duyi',
              get name() {
                  return this.tempValue;
                  //get取出的是方法返回的值
              }
          }
          ```

    - 注意：

      - 如果描述中同时出现`value`、`writable`和`set`、`get`两组的话，会出现异常，切记不要同时使用

    - 作用：

      - 双向数据绑定的核心方法，主要做数据劫持操作（监控属性变化），同时是后期`ES6`中很多语法糖底层实现的核心方法

  - 实例

    - ```js
      var obj = {
      
      };
      
      var tempValue = '';
      
      Object.defineProperty(obj,'name',{
          //value: 'cst', //value
          //writable: false, //不可写
          configurable: true, //可配置
          enumerable: true, //可枚举
          //有get和set就不能有value和writable，二者取其一
          get: function() {
              return tempValue;
          },
          set: function(value) {
              tempValue = value;
          }
      });
      
      obj.name = 10;
      ```

### 数据劫持

- `VUE`双向数据绑定核心功能由 `Observer`、`Compile`、`Watcher`三部分实现，其中`Observer`部分功能实现有`Object.defineProperty`实现

  - `Observer`:检测数据变化进行相应回调（数据劫持）
  - 实现一个简单的数据劫持，作为`Object.defineProperty`的练习。从而引出`Proxy`&`Reflect`

- ```js
  <input type="text" id="demo">
  <div id="show"></div>
  
  var oDiv = document.getElementById('show'),
      oInput = document.getElementById('demo');
  
  var oData = {
      valueObj: {
          value:'cc'
      },
      value: 'duyi'
  };
  
  oInput.oninput = function() {
      oData.value = this.value;
  }
  
  //更新显示函数
  function upDate() {
      oDiv.innerText = oData.value;
      // oDiv.innerText = oData.valueObj.value; //监控对象中的对象
  }
  upDate();
  
  
  //监控对象的某个属性是否发生改变
  function Observer(data) {
      //判断是否是对象
      if(!data || typeof data != 'object') {
          return data;
      };
      //循环判断
      // for(var prop in data) {}
      //Object.keys(data)，可以将对象中的每个属性都放到数组中
      Object.keys(data).forEach(function(key) {
          defineRective(data,key,data[key]);
      })
  }
  
  //监控函数
  function defineRective(data,key,val) {
      //AO
      Observer(val);
      Object.defineProperty(data,key,{
          get () {
              return val;
          },
          set (newValue) {
              if(newValue == val) return;
              val = newValue;
              upDate();
          }
      })
  }
  
  Observer(oData);
  ```

### proxy & reflect

- 简介
  - 植入代理模式的思想，以简洁易懂的方式控制对外部对象的访问
  - **new Proxy**(对象,描述符);
  - **Proxy**是一个构造函数，需要用变量接受
- 描述符对象的属性的进行详细描述：
  - 数据描述符：
    - **value**：`'xxx'` 属性值。默认~(空)
    - **writable**：`true` 是否可写。默认`false`
    - **configurable**：`true` 是否可配置。默认`false`
    - **enumerable**：`true` 是否可枚举。默认`false`
  - 存取描述符
    - **set**：`function(target,key,value,receiver){}` 属性访问器 进行写操作时调用该方法
      - `target`：对象
      - `key`：属性
      - `value`：传入的值
      - `receiver`：代理函数
    - **get**：`function(target,key,receiver){}` 属性访问器 进行读操作时调用该方法
      - `target`：对象
      - `key`：属性
      - `receiver`：代理函数
    - **has**:`function(target,key){}`
      - `target`：对象
      - `key`：属性
      - `has`对应`in`操作符，返回`true`/`false`，通常用来隐藏自己的私密属性
- 总结
  - 利用内置的`set`、`get`方法控制属性的读写功能用处比较大，其余`has`、`deleProperty`...等方法不太在工作开发中使用，但是兼容性不太好

- ```js
  //初始对象
  let oData = {
      val: 'duyi',
      _val: 'zzz'
  }
  
  //代理函数,oProxyData
  let oProxyData = new Proxy(oData,{
      //进行参数读写控制
      set (target,key,value,receiver) {
          //传入参数
          Reflect.set(target.key,value);
          upData();
      },
      get (target,key,value,receiver) {
          //获取对象并获取其中的属性值
          Reflect.get(target,key);
      },
      has (target,key) {
          //判断属性是否有_，如果有则为false，否则key in oData
          return key.indexOf('_') != -1 ? false : key in oData;
      }
  })
  
  //读写 控制
  console.log('_val' in oProxy);
  //读
  console.log(oProxy.val);
  //写
  oProxy.val = 10;
  
  function upData() {
      console.log('更新了');
  }
  ```

### 面向对象简介

- 面向对象：一种编程思想，跟具体的语言

- 对比面向过程：

  - 面向过程：思考的切入点是功能的步骤
  - 面向对象：思考的切入点是对象的划分

  - 面向过程目的在于把功能拆分成步骤，一环扣一环的完成，但是需求复杂到一定程度后，对开发者能力的挑战也是越来越强
  - 面向对象目的在于前期把功能拆分并抽象成不同的对象，聚焦于每个对象的能力和他们之间的配合，项目复杂后相对于面向过程来讲较为轻松一些
  - 举个例子：【大象装冰箱】
  - 面向对象的编程语言需要具备封装、继承、多态，`js`不是面向对象的语言，而是基于对象的语言，`js`中基本上一切皆是对象
  - 前端变成需要面向对象的思想
    - 相对于复杂业务为了做到功能复用，降低项目开发的复杂度，需要这种思想，比如，前端校验和写一个校验器，而不是面向过程每次需要验证都一条线的下来编写
    - 目前前端主流框架`vue`、`react`都是采用面向对象的方式来做，以及进入公司进行高级开发，组件研发，制作功能模块，也需要采取这样的思想做事

- ```js
  /**
   * 大象
   */
  function Elephant() {
  
  }
  
  /**
   * 冰箱
   */
  function Frige() {
  
  }
  
  Frige.prototype.openDoor = function () {
  
  }
  
  Frige.prototype.closeDoor = function () {
  
  }
  
  Frige.prototype.join = function(something){
      this.openDoor();
      //装东西
  
      this.closeDoor();
  }
  
  //1. 冰箱门打开
  // var frig = new Frige();
  // frig.openDoor();
  
  // //2. 大象装进去
  // var ele = new Elephant();
  // frig.join(ele);
  
  // //3. 冰箱门关上
  // frig.closeDoor();
  
  var frig = new Frige();
  
  frig.join(new Elephant());
  ```

### 类-Class

#### 类：构造函数的语法糖

- 传统的构造函数的问题
  - 属性和原型方法定义分离，降低了可读性
  - 原型成员可以被枚举
  - 默认情况下，构造函数仍然可以被当作普通函数使用

- 类的特点

  - 类声明不会被提升，与 `let` 和 `const` 一样，存在暂时性死区
  - 类中的所有代码均在严格模式下执行
  - 类的所有方法都是不可枚举的
  - 类的所有方法都无法被当作构造函数使用
  - 类的构造器必须使用 `new` 来调用

- ```js
  // 类 class
  // 不可以 var、let，它是一个语法糖，本质还是function
  class Animal {
      // 私有属性 cunstructor
      constructor(type, name, age, sex) {
          this.type = type;
          this.name = name;
          this.age = age;
          this.sex = sex;
      }
  
      // 公有属性（相当于给原型添加属性）
      print() {
          console.log(`【种类】：${this.type}`);
          console.log(`【名字】：${this.name}`);
          console.log(`【年龄】：${this.age}`);
          console.log(`【性别】：${this.sex}`);
      }
  }
  
  const a = new Animal("狗", "旺财", 3, "男");
  a.print();
  
  for (const prop in a) {
      console.log(prop)
  }
  ```

#### 类的其他书写方式

- 可计算的成员名
- **getter**和**setter**
  - **Object.defineProperty** 可定义某个对象成员属性的读取和设置
  - 使用`getter`和`setter`控制的属性，不在原型上
- 静态成员
  - 构造函数本身的成员
  - 使用`static`关键字定义的成员即静态成员
- 字段初始化器（**ES7**）
  - 注意：
  - 使用`static`的字段初始化器，添加的是静态成员
  - 没有使用`static`的字段初始化器，添加的成员位于对象上
  - 箭头函数在字段初始化器位置上，指向当前对象
- 类表达式

- 实例

  - ```js
    // getter setter
    
    const printName = "print";
    
    class Animal {
        constructor(type, name, age, sex) {
            this.type = type;
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
    
        //创建一个age属性，并给它加上getter，读取该属性时，会运行该函数
        get age() {
            return this._age + "岁";
        }
    
        //创建一个age属性，并给它加上setter，给该属性赋值时，会运行该函数
        set age(age) {
            if (typeof age !== "number") {
                throw new TypeError("age property must be a number");
            }
            if (age < 0) {
                age = 0;
            }
            else if (age > 1000) {
                age = 1000;
            }
            this._age = age;
        }
    
        [printName]() {
            console.log(`【种类】：${this.type}`);
            console.log(`【名字】：${this.name}`);
            console.log(`【年龄】：${this.age}`);
            console.log(`【性别】：${this.sex}`);
        }
    }
    
    var a = new Animal("狗", "旺财", 3, "男");
    ```

  - ```js
    // static 静态属性
    
    class Chess {
        constructor(name) {
            this.name = name;
        }
    	// static 静态属性
        static width = 50;
        static height = 50;
        static method() {
    
        }
    }
    
    console.log(Chess.width)
    console.log(Chess.height)
    
    Chess.method();
    ```

  - ```js
    // 类表达式
    
    const A = class { //匿名类，类表达式
        a = 1;
        b = 2;
    }
    
    const a = new A();
    console.log(a)
    ```

#### 类的继承

- 如果两个类`A`和`B`，如果可以描述为：`B` 是 `A`，则，`A`和`B`形成继承关系
- 如果`B`是`A`，则：
  - `B`继承自A
  - `A`派生`B`
  - `B`是`A`的子类
  - `A`是`B`的父类
- 如果`A`是`B`的父类，则`B`会自动拥有`A`中的所有实例成员。

- 新的关键字：
  - **extends**：继承，用于类的定义
  - **super**
    - 直接当作函数调用，表示父类构造函数
    - 如果当作对象使用，则表示父类的原型

- 注意：`ES6`要求，如果定义了`constructor`，并且该类是子类，则必须在`constructor`的第一行手动调用父类的构造函数

- 如果子类不写`constructor`，则会有默认的构造器，该构造器需要的参数和父类一致，并且自动调用父类构造器

- 【冷知识】
  - 用`JS`制作抽象类
    - 抽象类：一般是父类，不能通过该类创建对象
  - 正常情况下，`this`的指向，`this`始终指向具体的类的对象

- ```js
  // ES5构造函数
  function Animal(type, name, age, sex) {
      this.type = type;
      this.name = name;
      this.age = age;
      this.sex = sex;
  }
  Animal.prototype.print = function () {
      console.log(`【种类】：${this.type}`);
      console.log(`【名字】：${this.name}`);
      console.log(`【年龄】：${this.age}`);
      console.log(`【性别】：${this.sex}`);
  }
  
  function Dog(name, age, sex) {
      //借用父类的构造函数
      Animal.call(this, "犬类", name, age, sex);
  }
  
  Object.setPrototypeOf(Dog.prototype, Animal.prototype);
  
  const d = new Dog("旺财", 3, "公");
  d.print();
  console.log(d);
  ```

- ```js
  // ES6 class
  class Animal {
      constructor(type, name, age, sex) {
          if (new.target === Animal) {
              throw new TypeError("你不能直接创建Animal的对象，应该通过子类创建")
          }
          this.type = type;
          this.name = name;
          this.age = age;
          this.sex = sex;
      }
  
      print() {
          console.log(`【种类】：${this.type}`);
          console.log(`【名字】：${this.name}`);
          console.log(`【年龄】：${this.age}`);
          console.log(`【性别】：${this.sex}`);
      }
  
      jiao() {
          throw new Error("动物怎么叫的？");
      }
  }
  
  // 类Dog的prototype继承类Animal的prototype 
  class Dog extends Animal {
      constructor(name, age, sex) {
          // 调用父类的私有属性
          super("犬类", name, age, sex);
          // 子类特有的属性
          this.loves = "吃骨头";
      }
  
      print() {
          // 调用父类的print
          super.print();
          // 自己特有的代码
          console.log(`【爱好】：${this.loves}`);
      }
  
  
      //同名方法，会覆盖父类
      jiao() {
          console.log("旺旺！");
      }
  }
  
  //下面的代码逻辑有误
  const a = new Dog("旺财", 3, "公")
  a.print();
  ```

#### Decorator(装饰器)

- ```js
  class Test {
  
      @Obsolete
      print() {
          console.log("print方法")
      }
  }
  
  function Obsolete(target, methodName, descriptor) {
      // function Test
      // print
      // { value: function print(){}, ... }
      // console.log(target, methodName, descriptor);
      const oldFunc = descriptor.value
      descriptor.value = function (...args) {
          console.warn(`${methodName}方法已过时`);
          oldFunc.apply(this, args);
      }
  }
  ```

- ```js
  //面向对象
  //张三
  let oInput = document.getElementById('inp'),
      oBtn = document.getElementById('btn');
  
  @Skin //修饰类
  class Search {
      //静态属性
          //ES6规范 static num() {return 10;}
          //ES7规范 static num = 10;
      //私有属性
      constructor() {
          this.keyValue = '';
      }
      //装饰器
      // @名称
      @myReadOnly //修饰url属性，给url加了装饰器
      //私有属性
      url = 'urlA-';
      
      @dealData('张三') //修饰原型属性，给getContent加了装饰器
      //原型属性
      getContent (a, b) {
          console.log('向' + this.url + '发送网络请求，数据：' + this.keyValue,a,b);
          return 10;
      }
  }
  
  //target：类本身
  function Skin(target) {
      target.aa = 10;
  }
  
  let oS = new Search();
  
  oInput.oninput = function () {
      oS.keyValue = this.value;
  };
  
  oBtn.onclick = function () {
      oS.getContent();
  };
  
  
  //李四
  //装饰器
  //修饰私有属性的描述符属性
      //configurable
       //enumerable
       //initializer
       //writable
  //装饰原型上的属性的描述符属性
      //configurable
      //enumerable
      //initializer
      //writable
  
  //装饰私有属性
  //参数：原型 修饰属性名称 描述符属性
  function myReadOnly(proto,key,descriptor) {
      //
      // console.log(proto,key,descriptor);
      //可不可写
      descriptor.writable = false;
      //initializer()的返回值决定了属性url的值
      descriptor.initializer = function() {
          return "urlA-";
      };
       //描述符属性：
       //configurable
       //enumerable
       //initializer
       //writable
  }
  //修饰原型属性
  function dealData (ms) {
      return function (proto,key,descriptor) {
          // console.log(proto,key,descriptor);
          let oldValue = descriptor.value;
          //代理思想
          descriptor.value = function() {
      
              var urlB = 'urlB-';
              console.log("向" + urlB + "发送网络请求，数据：" + this.keyValue + " 发送人 " + ms);
      
              //先把本来的getContent函数执行一遍，将arguments传给this（oS对象）
              return oldValue.apply(this,arguments);
          }
          //原型描述符属性：
           //configurable
           //enumerable
           //value
           //writable
      }
  }
  
  
  
  // //面向过程
  // // 张三
  // var keyValue = '';
  // oInput.oninput = function () {
  //     keyValue = this.value
  // }
  // oBtn.onclick = function () {
  //     newGetContent(keyValue)
  // }
  
  // function getContent (data) {
  //     //模拟发送网络请求
  //     var url = 'urlA-';
  //     console.log('向' + url + '发送网络请求，数据：' + data);
  // }
  
  // //代理
  // var newGetContent = dealFunc(getContent);
  
  // //李四
  // function dealFunc(func) {
  //     return function(data) {
  //         //
  //         var urlB = 'urlB-';
  //         console.log('向' + urlB + '发送网络请求，数据：' + data)
  //         return func.apply(this,arguments);
  //     }
  // }
  ```

#### ES7之Class提案属性

- 新特性

  - **static property = xxx**：静态属性
  - **property = xxx**：私有属性
  - **@decorator**：装饰器

- 提案特性需要下载

  - `npm install @babel/plugin-proposal-decorators`

- 需要配置

  - ```js
    {
        "plugin": [
            ["@babel/plugin-proposal-decorators",{"legacy":true}]
            ["@babel/plugin-proposal-class-properties",{"loose":true}]
        ]
    }
    ```

- 实例

  - ```js
    class Search {
        //静态属性
        //ES6规范
            // static num() {
            //     return 10;
            // }
        //ES7规范
        static num = 10;
    
        //私有属性
        constructor () {
            //私有属性
            this.keyValue = '';
        }
        //装饰器
        // @readOnly
        //私有属性
        url = 'urlA-';
        //原型属性
        getCount () {
            console.log('发送请求');
        }
    }
    
    var oS = new Search();
    ```

#### 使用ES5模拟ES6中class

- ```js
  //class 关键字，不可以var、let，它是一个语法糖，本质还是function
  
  //使用class类，相当于Es5的构造函数，不用写function
  //私有属性constructor
  //公有属性(原型属性) 
  //静态属性(函数本身属性)
  class Plane {
      //静态属性,ES6不支持非方法的静态属性，ES7支持
      //静态属性在Plane中定义时，它就成为了Plane本身的方法
      static alive () {
          return true;
      }
      //私有属性
      constructor (name) {
          this.name = name || '普通飞机';
          this.blood = 100;
      }
      //如果想给原型添加方法，则在constructor的同级下添加函数
      fly () {
          console.log('fly');
      }
      //ES7 私有属性
      // name = 10;
  }
  
  //target extend origin：target的prototype继承Plane的prototype
  class AttackPlane extends Plane{
      constructor (name) {
          // Plane.call(this,name);
          super(name);
          //super就相当于把Plane的私有属性call了一下，将私有属性全部call到了constructor中
          this.logo = 'l';
      }
      //公有属性
      dan () {
          console.log('biubiubiu');
      }
  }
  
  oAp = new AttackPlane('战斗机');
  
  
  // ES5
  
  // 1.must be new
  // 2.class Plane.prototype 不能枚举
  // 3.静态属性要放到Plane函数上，非原型
  ```

- `ES5`实现模拟`ES6`之`Class`

- ```js
  //判断是否以new的方式构造出来的
  function _classCallCheck(_this,_constructor) {
      //判断_this沿着原型链寻找，是否可以找到_this,如果不能则抛出错误，instanceof 运算符用来检测 constructor.prototype 是否存在于参数 _this 的原型链上。
      if (!(_this instanceof _constructor)) {
          throw "TypeError: Class constructor Plane cannot be invoked without 'new'"
      }
  }
  
  //设置公有属性和静态属性
  function _defineProperties(target,props) {
      //Object.defineProperty
      props.forEach(function(ele) {
          //ele.key ele.value
          Object.defineProperty(target,ele.key,{ 
              value: ele.value,
              writable: true, //可写
              configurable: true//可配置
          })
      })
  }
  
  //处理公有属性和静态属性
  //参数：原型、原型属性，静态属性
  function _createClass (_constructor,_prototypeProperties,_staticProperties){
      //如果传_prototypeProperties数组的话，给原型上赋值
      if (_prototypeProperties) {
          _defineProperties(_constructor.prototype, _prototypeProperties)
      }
      //如果传_staticProperties数组的话，给函数本身上赋值
      if (_staticProperties) {
          _defineProperties(_constructor,_staticProperties);
      }
  }
  
  var Plane = (function() {
      function Plane(name) {
          //判断是否以new的方式来执行
          _classCallCheck(this,Plane);
          //把私有属性 公有属性 静态属性赋给Plane
          this.name = name || "普通飞机";
          this.blood = 100;
      }
  
      //创建自身属性和静态属性
      _createClass(Plane,[
          //自身方法
          {
              key: 'fly',
              value: function() {
                  console.log('fly');
              }
          },
      ],[
          //静态属性
          {
              key: 'alive',
              value: function() {
                  return true;
              }
          }
      ])
  
      return Plane;
  }())
  
  var oP = new Plane("yzl&战斗机");
  
  //原型继承方法
  function _inherit(sub,sup) {
      Object.setPrototypeOf(sub.prototype,sup.prototype);
  }
  
  var AttackPlane = (function(Plane) {
  
      _inherit(AttackPlane,Plane);
  
      function AttackPlane (name) {
          _classCallCheck(this,Plane);
          this.logo = 'lll';
          var _this = this;
          var that = Plane.call(this,name);
          if(typeof that == 'object') {
              _this.that;
          }
          _this.logo = 'duyi';
          return _this;
      };
      //创建自身属性和静态属性
      _createClass(AttackPlane,[
          //自身方法
          {
              key: 'dan',
              value: function() {
                  console.log('biubiubiu');
              }
          },
      ],[
          //静态属性
          {
              key: 'alive',
              value: function() {
                  return true;
              }
          }
      ])
      return AttackPlane;
  }(Plane))
  
  var oAp = new AttackPlane();
  ```

## Set、Map

### Set

- **set介绍**
  - 简介：`Set`是`ES6`提供给我们的构造函数，能够造出一种新的存储数据的结构
  - 特点：只有属性值，成员值唯一（不重复）
  - 用途：可以转成数组，其本身具备去重、交集、并集，差集的作用等

- **set基本使用**

  - `add(prop)`：添加属性值

  - `delete(prop)`：删除属性值

  - `clear()`：清空`Set`所有属性

  - `has(prop)`：判断`Set`中是否有`prop`

  - `forEach()`：遍历属性

  - ```js
    //Set Map Proxy
    //兼容性不是很好
    
    // 参数必须具有迭代接口，[] '' arguments NodeList
    let oS = new Set([1,2,3,[1,2],true,{name: 'yzl'},1,2]);
    
    let oS2 = new Set('abcabd');
    
    oS.add(1);
    oS.add([1,2]);
    oS.add(true);
    
    oS.forEach(val => {
        console.log(val);
    })
    //ES6新增for循环 for of，循环条件需要有迭代接口
    for(let prop of oS) {
        console.log(prop);
    }
    
    
    //Set -> []，Set转换数组
    let arr = [1,2,2,3,3];
    let oS = new Set(arr);
    //两种方法
    // ... ，可以拓展任何一个具有迭代接口的值
    // Array.from()，ES6新规定的数组静态方法，把类数组及具有迭代接口的数据转换为数组
    console.log(Array.from(oS))
    console.log([...oS]);
    
    ```

- **set应用场景**

  - ```js
    //去重，缺陷：对象并不会按照属性值去重
    let o = {name:'cst'}
    let arr = [1,2,3,4,o,5,1,o,2,3,{name:'cg'}];
    let obj = {};
    let newArr = []; //新数组
    for(var i = 0;i < arr.length; i++) {
        if(!obj[arr[i]]) {
            newArr.push(arr[i]);
            obj[arr[i]] = true;
        }
    }
    
    // Set去重,弥补缺陷
    let o = {name:'cst'}
    let arr = [1,2,3,4,o,5,1,o,2,3,{name:'cg'}];
    let oS = new Set(arr);//就会去重返回到oS中
    
    
    // 并集 交集 差集
    // 集合
    // arr obj set map 都是集合，存储形式不一样
    //并集
    let arr1 = [1,2,3,4,2,3,9];
    let arr2 = [3,2,3,2,5];
    let oS = new Set([...arr1,...arr2]);
    //交集
    let arr1 = [1,2,3,4,2,3,9];
    let arr2 = [3,2,3,2,5];
    let oS1 = new Set(arr1);
    let oS2 = new Set(arr2);
    //当oS1的ele与oS2的ele相同时则，则返回当前ele
    let newArr = [...oS1].filter(ele => oS2.has(ele))
    //差集
    let arr1 = [1,2,3,4,2,3];
    let arr2 = [3,2,3,2,5];
    let oS1 = new Set(arr1);
    let oS2 = new Set(arr2);
    let newArr = [...oS1].filter(ele => !oS2.has(ele))
    let newArr1 = [...oS2].filter(ele => !oS1.has(ele))
    let newArr2 = [...newArr,...newArr1];
    ```



### Map

- 简介：
  - `Map`是`ES6`提供给我们的构造函数，能够造出一种新的存储数据的解构。本质上是键值对的集合
- 特点
  - `key`对应`value`，`key`和`value`唯一，任何值都可以当属性
- 用途
  - 可以让对象当属性，去重等
- 原理实现
  - 链接链表、`hash`算法、桶
- **api**：
  - `set(key,value)`：添加值
  - `get(key)`：获取值
  - `delete(key)`：删除值
  - `keys()`：将`value`单独提取出来
  - `entries()`：`key`对`value`，和开始基本一样

- 基本使用

  - ```js
    //初始化
    //数组，每个元素都是一个数组,key,value
    //对象
    let oMp = new Map([['name','cst'],['age',18],['sex',true],[{},'----']]);
    
    
    //api
    let oMp1 = new Map();
    // 添加值 oMp1.set(key,value);
    oMp1.set('name','cst');
    oMp1.set('age',18);
    var obj = {};
    oMp1.set(obj,'---');
    oMp1.set({},'+++');
    // 获取值 oMp1.get(key)
    oMp1.get(obj);
    // 删除值 oMp1.delete(key)
    oMp1.delete('name');
    // keys(),属性值单独提取了出来
    oMp1.keys();
    // entries() 属性名对属性值，和开始基本一样
    oMp1.entries();
    // has(key)
    
    
    // oMp1.forEach((ele,key,self) => {
    //     console.log(ele,key,self);
    // })
    
    // for(let val of oMp1) {
    //     console.log(val);
    // }
    ```

- 存储原理分析

  - ```js
    //链表，将每一个对象关联起来
    // {} {} {} {} {}
    let node3 = {
        key: 'name3',
        value: '2',
        next: null
    };
    
    let node2 = {
        key: 'name2',
        value: '2',
        next: node3
    };
    
    let node1 = {
        key: 'name',
        value: '1',
        next: node2
    }
    
    
    let oMp = new Map([['name1','1'],['name2','2']]);
    
    // hash算法 -> 将一个不定范围的值转换成一个特定范围的值来输出
    // 在存值的时候，key值是不一定的，可能是对象，数组，字符串，数组，NaN
    // hash 特定范围的值
    
    //桶有8个位置，0 - 8
    [
        {
            //如果你输入值的时候，会将你的值根据hash算法添加到桶的某个序号中，然后在特定属性next中添加你的下一个对象值
            key:'name1',
            value:'1',
            next: {
                key:'name2',
                value:'2'
            }
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {}
    ]
    ```

- 模拟实现**Map**

  - ```js
    //原生Map特性
    //1.不重复
    //2.属性不只是字符串，还可以是 {} null [] function number
    //3.实现方法 delete set get has clear 
    
    function myMap() {
        //桶长度 = 8
        this.bucketLength = 8;
        this.init();
    }
    
    //初始化
    myMap.prototype.init = function() {
        //初始化 桶 长度8
        this.bucket = new Array( this.bucketLength );
        //循环遍历桶添加初始化值
        for(var i = 0;i < this.bucket.length; i++) {
            this.bucket[i] = {
                type: 'bucket' + i,
                next: null
            }
        }
    }
    
    //hash算法
    //1. [0,8]
    //2. 重复算值固定
    myMap.prototype.makeHash = function(key) {
        let hash = 0;
        // key 可能是 string number boolean null  NaN [] {} function(){} undefine
        if(typeof key !== 'string') {
            //如果为数字，hash直接等于key
            if(typeof key == 'number') {
                //number NaN
                //判断key是否等于NaN
                hash = Object.is(key,NaN) ? 0 : key;
            } else if(typeof key == 'object') {
                //null {} [] 
                hash = 1;
            } else if(typeof key == 'boolean') {
                //true 1  |  false 0
                hash += key;
            } else {
                //undefine function() {}
                hash = 2;
            }
        } else {
            //string
            //'a' 'ab' '....很多个字符'
            //长度大于等于3，取字符串前三个字符的ascii，累加 取余 变为0-8（规则由自己定义）
            //长度不大于3时，就取长度位数进行计算
            for(let i = 0;i < 3; i++) {
                //判断如果字符没有第三位时返回0，有时就返回该位的ascii码
                hash += key[i] ? key[i].charCodeAt(0) : 0;
            }
        }
        return hash % 8; //生成0-8范围
    }
    
    //set方法
    myMap.prototype.set = function(key,value) {
        //获取hash
        let hash = this.makeHash(key);
        //获取桶的序号
        let oTempBucket = this.bucket[hash];
        //循环条件，oTempBucket.next是否有值
        while(oTempBucket.next) {
            //如果next中的值与传入的值相同，那么就让next的value等于传入的value
            if (oTempBucket.next.key == key) {
                oTempBucket.next.value = value;
                return;
            //如果在key不等于next.key，就让oTempBucket自己等于自己的下一个，再次循环比较
            } else {
                oTempBucket = oTempBucket.next;
            }
        };
        //给最后一个oTempBucket添加值
        oTempBucket.next = {
            key: key,
            value: value,
            next: null
        }
    }
    
    //get方法
    myMap.prototype.get = function(key) {
        //获取hash
        let hash = this.makeHash(key);
        //获取桶的序号
        let oTempBucket = this.bucket[hash];
        //循环条件，oTempBucket.next是否有值
        while(oTempBucket.next) {
            //如果next中的值与传入的值相同，那么就返回next中的value
            if(oTempBucket.next.key == key) {
                return oTempBucket.next.value;
            //如果在key不等于next.key，就让oTempBucket自己等于自己的下一个，再次循环比较
            } else {
                oTempBucket = oTempBucket.next;
            }
        }
    
        //如果oTempBucket.next没有值，直接返回undefine
        return undefined;
    }
    
    //delete方法
    myMap.prototype.delete = function(key) {
        //获取hash
        let hash = this.makeHash(key);
        //获取桶的序号
        let oTempBucket = this.bucket[hash];
        //循环条件，oTempBucket.next是否有值
        while (oTempBucket.next) {
            //如果next中的值与传入的值相同，那么就将next的指向改变为next.next
            if(oTempBucket.next.key == key) {
                oTempBucket.next = oTempBucket.next.next;
                return true;
            //如果传入的key不等于next.key，就让oTempBucket自己等于自己的下一个，再次循环比较
            } else {
                oTempBucket = oTempBucket.next;
            }
        }
    
        return false;
    }
    
    //has方法
    myMap.prototype.has = function(key) {
        //获取hash
        let hash = this.makeHash(key);
        //获取桶的序号
        let oTempBucket = this.bucket[hash];
    
        while(oTempBucket.next) {
            if(oTempBucket.next.key == key) {
                return true
            } else {
                oTempBucket = oTempBucket.next;
            }
        }
    
        return false;
    }
    
    //clear方法
    myMap.prototype.clear = function(key) {
        this.init();
    }
    
    let oMp = new myMap();
    let obj = {name:'yzl'};
    oMp.set('name','yzl');
    oMp.set('name1','yzl');
    oMp.set(obj,'----');
    oMp.set(function(){},'----');
    ```

## 解构(destructuring)

- 什么是解构
  - 使用`ES6`的一种语法规则，将一个对象或数组的某个属性提取到某个变量中
  - **解构不会对被解构的目标造成任何影响**
  - 解构过程中，具备赋值和变量声明两个功能
  - 目的在于把等号左右长得相似的两个东西内部的值取出来

  - 对象数组都可以参与解构


- 在解构中使用默认值

```js
{同名变量 = 默认值}
```

- 非同名属性解构

```js
{属性名:变量名}
```

### 对象解构

- ```js
  const user = {
      name: "kevin",
      age: 11,
      sex: "男",
      address: {
          province: "四川",
          city: "成都"
      }
  }
  
  // let name, age, sex, address;
  // name = user.name;
  // age = user.age;
  // sex = user.sex;
  // address = user.address;
  
  // let name, age, sex, address, abc;
  // ({ name, age, sex, address } = user);
  
  // 先定义5个变量，然后从对象中读取同名属性，放到变量中
  let { name, age, sex, address, abc = 123 } = user
  
  console.log(name, age, sex, address, abc)
  ```

- ```js
  const user = {
      name: "kevin",
      age: 11,
      sex: "男",
      address: {
          province: "四川",
          city: "成都"
      }
  }
  // 先定义4个变量：name、age、gender、address
  // 再从对象user中读取同名属性赋值（其中gender读取的是sex属性）
  let { name, age, sex: gender = 123, address } = user
  
  console.log(name, age, gender, address)
  ```

- ```js
  const user = {
      name: "kevin",
      age: 11,
      sex: "男",
      address: {
          province: "四川",
          city: "成都"
      }
  }
  //解构出user中的name、province
  //定义两个变量name、province
  //再解构
  const { name, address: { province } } = user;
  
  console.log(name, address, province)
  ```

### 数组解构

- ```js
  const numbers = ["a", "b", "c", "d"];
  
  // const {
  //     0: n1,
  //     1: n2
  // } = numbers;
  
  // let n1, n2;
  // ([n1, n2] = numbers);
  
  // 只获得数组前两位
  const [n1, n2] = numbers;
  
  console.log(n1, n2) // a b
  ```

- ```js
  const numbers = ["a", "b", "c", "d"];
  
  const [n1, , , n4, n5 = 123] = numbers;
  
  console.log(n1, n4, n5) // a d 123
  ```

- ```js
  // const numbers = ["a", "b", "c", "d", [1, 2, 3, 4]];
  
  // // 得到numbers下标为4的数组中的下标为2的数据，放到变量n中
  // const [, , , , [, , n]] = numbers;
  
  // console.log(n)
  
  const numbers = ["a", "b", "c", "d", {
      a: 1,
      b: 2
  }];
  
  //得到numbers下标为4的数组的属性a，赋值给变量A
  // const [, , , , { a: A }] = numbers;
  
  const { a: A } = numbers[4];
  
  console.log(A)
  ```

- ```js
  const user = {
      name: "kevin",
      age: 11,
      sex: "男",
      address: {
          province: "四川",
          city: "成都"
      }
  }
  
  //解构出name，然后，剩余的所有属性，放到一个新的对象中，变量名为obj
  // name: kevin
  // obj : {age:11, sex:"男", address:{...}}
  
  const { name, ...obj } = user;
  
  console.log(name, obj)
  ```

- ```js
  const numbers = [324, 7, 23, 5, 3243];
  
  // 得到数组前两项，分别放到变量a和b中，然后剩余的所有数据放到数组nums
  
  // const [a, b, ...nums] = numbers;
  
  const a = numbers[0], b = numbers[1], nums = numbers.slice(2);
  
  console.log(a, b, nums);
  ```

### 参数结构

- ```js
  // function ajax(options) {
  //     const defaultOptions = {
  //         method: "get",
  //         url: "/"
  //     }
  //     const opt = {
  //         ...defaultOptions,
  //         ...options
  //     }
  //     console.log(opt)
  // }
  
  function ajax({
      method = "get",
      url = "/"
  } = {}) {
      console.log(method, url)
  }
  
  ajax()
  ```

- ```js
  // function print(user) {
  //     console.log(`姓名：${user.name}`)
  //     console.log(`年龄：${user.age}`)
  //     console.log(`性别：${user.sex}`)
  //     console.log(`身份：${user.address.province}`)
  //     console.log(`城市：${user.address.city}`)
  // }
  
  function print({ name, age, sex, address: {
      province,
      city
  } }) {
      console.log(`姓名：${name}`)
      console.log(`年龄：${age}`)
      console.log(`性别：${sex}`)
      console.log(`身份：${province}`)
      console.log(`城市：${city}`)
  }
  
  const user = {
      name: "kevin",
      age: 11,
      sex: "男",
      address: {
          province: "四川",
          city: "成都"
      }
  }
  print(user)
  ```



## 符号



### 普通符号

- 符号是`ES6`新增的一个数据类型，它通过使用函数 ```Symbol(符号描述)``` 来创建

- 符号设计的初衷，是为了给对象设置私有属性

- 私有属性：只能在对象内部使用，外面无法使用

- 符号具有以下特点：

- 没有字面量
  - 使用 `typeof` 得到的类型是 symbol
  - **每次调用 Symbol 函数得到的符号永远不相等，无论符号名是否相同**
  - 符号可以作为对象的属性名存在，这种属性称之为符号属性
    - 开发者可以通过精心的设计，让这些属性无法通过常规方式被外界访问
    - 符号属性是不能枚举的，因此在 for-in 循环中无法读取到符号属性，Object.keys 方法也无法读取到符号属性
    - `Object.getOwnPropertyNames` 尽管可以得到所有无法枚举的属性，但是仍然无法读取到符号属性
    - `ES6` 新增 `Object.getOwnPropertySymbols` 方法，可以读取符号
  - 符号无法被隐式转换，因此不能被用于数学运算、字符串拼接或其他隐式转换的场景，但符号可以显式的转换为字符串，通过 `String` 构造函数进行转换即可，`console.log` 之所以可以输出符号，是它在内部进行了显式转换

- 创建一个符号

  - ```js
    // 创建一个符号
    const syb1 = Symbol();
    const syb2 = Symbol("abc");
    console.log(syb1, syb2);
    // typeof类型
    console.log(typeof syb1 === "symbol", typeof syb2 === "symbol")
    
    // 创建一个符号
    const syb1 = Symbol("这是随便写的一个符号");
    const syb2 = Symbol("这是随便写的一个符号");
    console.log(syb1, syb2);
    console.log(syb1 === syb2)
    ```

  - ```js
    //创建一个符号
    
    const syb1 = Symbol("这是用于对象的一个属性");
    
    const obj = {
        a: 1,
        b: 2,
        [syb1]: 3  //符号属性
    }
    
    console.log(obj);
    ```

- 实例

  - ```js
    // const hero = (function () {
    //     const getRandom = Symbol();
    
    //     return {
    //         attack: 30,
    //         hp: 300,
    //         defence: 10,
    //         gongji() { //攻击
    //             //伤害：攻击力*随机数（0.8~1.1)
    //             const dmg = this.attack * this[getRandom](0.8, 1.1);
    //             console.log(dmg);
    //         },
    //         [getRandom](min, max) { //根据最小值和最大值产生一个随机数
    //             return Math.random() * (max - min) + min;
    //         }
    //     }
    // })()
    
    // console.log(hero);
    
    const Hero = (() => {
        const getRandom = Symbol();
    
        return class {
            constructor(attack, hp, defence) {
                this.attack = attack;
                this.hp = hp;
                this.defence = defence;
            }
    
            gongji() {
                //伤害：攻击力*随机数（0.8~1.1)
                const dmg = this.attack * this[getRandom](0.8, 1.1);
                console.log(dmg);
            }
    
            [getRandom](min, max) { //根据最小值和最大值产生一个随机数
                return Math.random() * (max - min) + min;
            }
        }
    })();
    
    const h = new Hero(3, 6, 3);
    console.log(h);
    ```

  - ```js
    const syb = Symbol();
    
    const obj = {
        [syb]: 1,
        a: 2,
        b: 3
    }
    
    for (const prop in obj) {
        console.log(prop)
    }
    
    console.log(Object.keys(obj))
    console.log(Object.getOwnPropertyNames(obj))
    //得到的是一个符号属性的数组
    const sybs = Object.getOwnPropertySymbols(obj);
    console.log(sybs, sybs[0] === syb)
    ```

  - ```js
    const Hero = (() => {
        const getRandom = Symbol();
    
        return class {
            constructor(attack, hp, defence) {
                this.attack = attack;
                this.hp = hp;
                this.defence = defence;
            }
    
            gongji() {
                //伤害：攻击力*随机数（0.8~1.1)
                const dmg = this.attack * this[getRandom](0.8, 1.1);
                console.log(dmg);
            }
    
            [getRandom](min, max) { //根据最小值和最大值产生一个随机数
                return Math.random() * (max - min) + min;
            }
        }
    })();
    
    const h = new Hero(3, 6, 3);
    const sybs = Object.getOwnPropertySymbols(Hero.prototype);
    const prop = sybs[0];
    console.log(h[prop](3, 5))
    ```

### 共享符号

- 根据某个符号名称（符号描述）能够得到同一个符号

```js
Symbol.for("符号名/符号描述")  //获取共享符号
```

- 实例

  - ```js
    const obj = {
        a: 1,
        b: 2,
        [Symbol.for("c")]: 3
    }
    
    console.log(obj[Symbol.for("c")]);
    ```

  - ```js
    const syb1 = Symbol.for("abc");
    const syb2 = Symbol.for("abc");
    console.log(syb1 === syb2)
    const obj1 = {
        a: 1,
        b: 2,
        [syb1]: 3
    }
    
    const obj2 = {
        a: "a",
        b: "b",
        [syb2]: "c"
    }
    
    console.log(obj1, obj2);
    ```

  - ```js
    const SymbolFor = (() => {
        const global = {};//用于记录有哪些共享符号
        return function (name) {
            console.log(global)
            if (!global[name]) {
                global[name] = Symbol(name);
            }
            console.log(global);
            return global[name];
        }
    })();
    
    const syb1 = SymbolFor("abc");
    
    const syb2 = SymbolFor("abc");
    
    console.log(syb1 === syb2);
    ```

### 知名（公共、具名）符号

> 知名符号是一些具有特殊含义的共享符号，通过 `Symbol` 的静态属性得到
>
> `ES6` 延续了 `ES5` 的思想：减少魔法，暴露内部实现！
>
> 因此，`ES6` 用知名符号暴露了某些场景的内部实现

#### Symbol.hasInstance

- 该符号用于定义构造函数的静态成员，它将影响 `instanceof` 的判定

  ```js
  obj instanceof A
  //等效于
  A[Symbol.hasInstance](obj) // Function.prototype[Symbol.hasInstance]
  ```

- ```js
  function A() {
  
  }
  
  Object.defineProperty(A, Symbol.hasInstance, {
      value: function (obj) {
          return false;
      }
  })
  
  const obj = new A();
  
  console.log(obj instanceof A);
  // console.log(A[Symbol.hasInstance](obj));
  ```

#### Symbol.isConcatSpreadable

- 该知名符号会影响数组的 `concat` 方法

- ```js
  const arr = [3];
  const arr2 = [5, 6, 7, 8];
  
  arr2[Symbol.isConcatSpreadable] = false;
  
  const result = arr.concat(56, arr2)
  
  //  [3, 56, [5,6,7,8]]
  //  [3, 56, 5, 6, 7, 8]
  
  console.log(result)
  ```

- ```js
  const arr = [1];
  const obj = {
      0: 3,
      1: 4,
      length: 2,
      [Symbol.isConcatSpreadable]: true
  }
  
  const result = arr.concat(2, obj)
  
  console.log(result)
  ```

#### Symbol.toPrimitive

- 该知名符号会影响类型转换的结果

- ```js
  class Temperature {
      constructor(degree) {
          this.degree = degree;
      }
  
      [Symbol.toPrimitive](type) {
          if (type === "default") {
              return this.degree + "摄氏度";
          }
          else if (type === "number") {
              return this.degree;
          }
          else if (type === "string") {
              return this.degree + "℃";
          }
      }
  }
  
  const t = new Temperature(30);
  
  console.log(t + "!");
  console.log(t / 2);
  console.log(String(t));
  ```

#### Symbol.toStringTag
  - 该知名符号会影响 `Object.prototype.toString` 的返回值

  - ```js
    class Person {
    
        [Symbol.toStringTag] = "Person"
    }
    
    const p = new Person();
    
    const arr = [32424, 45654, 32]
    
    console.log(Object.prototype.toString.apply(p));
    console.log(Object.prototype.toString.apply(arr))
    ```
#### 其他知名符号

## 异步处理

### [回顾]事件循环

- `JS`运行的环境称之为宿主环境。

- 执行栈：`call stack`，一个数据结构，用于存放各种函数的执行环境，每一个函数执行之前，它的相关信息会加入到执行栈。函数调用之前，创建执行环境，然后加入到执行栈；函数调用之后，销毁执行环境。

- `JS`引擎永远执行的是执行栈的最顶部。

- 异步函数：某些函数不会立即执行，需要等到某个时机到达后才会执行，这样的函数称之为异步函数。比如事件处理函数。异步函数的执行时机，会被宿主环境控制。

- 浏览器宿主环境中包含**5**个线程：
  - `JS`引擎：负责执行执行栈的最顶部代码
  - `GUI`线程：负责渲染页面 
  - 事件监听线程：负责监听各种事件
  - 计时线程：负责计时
  - 网络线程：负责网络通信

- 当上面的线程发生了某些事请，如果该线程发现，这件事情有处理程序，它会将该处理程序加入一个叫做事件队列的内存。当`JS`引擎发现，执行栈中已经没有了任何内容后，会将事件队列中的第一个函数加入到执行栈中执行。

- `JS`引擎对事件队列的取出执行方式，以及与宿主环境的配合，称之为事件循环。

- 事件队列在不同的宿主环境中有所差异，大部分宿主环境会将事件队列进行细分。在浏览器中，事件队列分为两种：
  - 宏任务（队列）：`macroTask`，计时器结束的回调、事件回调、`http`回调等等绝大部分异步函数进入宏队列
  - 微任务（队列）：`MutationObserver`，`Promise`产生的回调进入微队列

> `MutationObserver`函数用于监听某个`DOM`对象的变化

- 当执行栈清空时，`JS`引擎首先会将微任务中的所有任务依次执行结束，如果没有微任务，则执行宏任务。

- 实例

  - ```js
    function a() {
        console.log("a")
        b();
    }
    
    function b() {
        console.log("b");
        c();
    }
    
    function c() {
        console.log("c")
    }
    
    console.log("global");
    a();
    // global a b c
    ```

  - ```js
    console.log("a")
    
    setTimeout(() => {
        console.log("b")
    }, 0);
    
    for (let i = 0; i < 1000; i++) {
        console.log("c")
    }
    // a c*1000 b
    ```

  - ```js
    <ul id="container"></ul>
    <button id="btn">点击</button>
    
    let count = 1;
    const ul = document.getElementById("container");
    document.getElementById("btn").onclick = function A() {
        setTimeout(function C() {
            console.log("添加了一个li")
        }, 0);
        var li = document.createElement("li")
        li.innerText = count++;
        ul.appendChild(li);
    }
    
    //监听ul
    const observer = new MutationObserver(function B() {
        //当监听的dom元素发生变化时运行的回调函数
        console.log("ul元素发生了变化")
    })
    //监听ul
    observer.observe(ul, {
        attributes: true, //监听属性的变化
        childList: true, //监听子元素的变化
        subtree: true //监听子树的变化
    })
    //取消监听
    // observer.disconnect();
    ```

### 事件和回调函数的缺陷

- 我们习惯于使用传统的回调或事件处理来解决异步问题

- 事件：某个对象的属性是一个函数，当发生某一件事时，运行该函数

```js
dom.onclick = function(){

}
```

- 回调：运行某个函数以实现某个功能的时候，传入一个函数作为参数，当发生某件事的时候，会运行该函数。

```js
dom.addEventListener("click", function(){

})
```

- 本质上，事件和回调并没有本质的区别，只是把函数放置的位置不同而已。

- 一直以来，该模式都运作良好。

- 直到前端工程越来越复杂...

- 目前，该模式主要面临以下两个问题：

  - 回调地狱：某个异步操作需要等待之前的异步操作完成，无论用回调还是事件，都会陷入不断的嵌套
  - 异步之间的联系：某个异步操作要等待多个异步操作的结果，对这种联系的处理，会让代码的复杂度剧增

- 回调地狱实例

  - ```js
    const btn1 = document.getElementById("btn1"),
          btn2 = document.getElementById("btn2"),
          btn3 = document.getElementById("btn3");
    btn1.addEventListener("click", function() {
        //按钮1的其他事情
        btn2.addEventListener("click", function() {
            //按钮2的其他事情
            btn3.addEventListener("click", function() {
                alert("hello");
            })
        })
    })
    ```

  - ```js
    /*
    邓哥心中有三个女神
    有一天，邓哥决定向第一个女神表白，如果女神拒绝，则向第二个女神表白，直到所有的女神都拒绝，或有一个女神同意为止
    用代码模拟上面的场景
    */
    function biaobai(god, callback) {
        console.log(`邓哥向女神【${god}】发出了表白短信`);
        setTimeout(() => {
            if (Math.random() < 0.1) {
                //女神同意拉
                //resolve
                callback(true);
            } else {
                //resolve
                callback(false);
            }
        }, 1000);
    }
    
    biaobai("女神1", function(result) {
        if (result) {
            console.log("女神1答应了，邓哥很开心!")
        } else {
            console.log("女神1拒绝了，邓哥表示无压力，然后向女神2表白");
            biaobai("女神2", function(result) {
                if (result) {
                    console.log("女神2答应了，邓哥很开心!")
                } else {
                    console.log("女神2十分感动，然后拒绝了邓哥，邓哥向女神3表白");
                    biaobai("女神3", function(result) {
                        if (result) {
                            console.log("女神3答应了，邓哥很开心!")
                        } else {
                            console.log("邓哥表示生无可恋!!");
                        }
                    })
                }
            })
        }
    })
    ```

  - ```js
    /*
        邓哥心中有二十个女神，他决定用更加高效的办法
        他同时给二十个女神表白，如果有女神同意，就拒绝其他的女神
        并且，当所有的女神回复完成后，他要把所有的回复都记录到日志进行分析
        用代码模拟上面的场景
    */
    
    function biaobai(god, callback) {
        console.log(`邓哥向女神【${god}】发出了表白短信`);
        setTimeout(() => {
            if (Math.random() < 0.05) {
                //女神同意拉
                callback(true);
            } else {
                callback(false);
            }
        }, Math.floor(Math.random() * (3000 - 1000) + 1000));
    }
    let agreeGod = null; //同意邓哥的第一个女神
    const results = []; //用于记录回复结果的数组
    for (let i = 1; i <= 20; i++) {
        biaobai(`女神${i}`, result => {
            results.push(result);
    
            if (result) {
                console.log(`女神${i}同意了`)
                if (agreeGod) {
                    console.log(`邓哥回复女神${i}: 不好意思，刚才朋友用我手机，乱发的`)
                } else {
                    agreeGod = `女神${i}`;
                    console.log(`邓哥终于找到了真爱`);
                }
            } else {
                console.log(`女神${i}拒绝了`)
            }
    
    
            if (results.length === 20) {
                console.log("日志记录", results)
            }
        })
    }
    ```

### 异步处理的通用模型

- `ES`官方参考了大量的异步场景，总结出了一套异步的通用模型，该模型可以覆盖几乎所有的异步场景，甚至是同步场景。

- 值得注意的是，为了兼容旧系统，`ES6` 并不打算抛弃掉过去的做法，只是基于该模型推出一个全新的 `API`，使用该`API`，会让异步处理更加的简洁优雅。

- 理解该 `API`，最重要的，是理解它的异步模型

1. `ES6` 将某一件可能发生异步操作的事情，分为两个阶段：**unsettled** 和 **settled**
   1. ![](./ES6/2019-10-18-17-28-30.png)
   2. **unsettled**： 未决阶段，表示事情还在进行前期的处理，并没有发生通向结果的那件事
   3. **settled**：已决阶段，事情已经有了一个结果，不管这个结果是好是坏，整件事情无法逆转
   4. 事情总是从 未决阶段 逐步发展到 已决阶段的。并且，未决阶段拥有控制何时通向已决阶段的能力。
2. **ES6**将事情划分为三种状态： **pending**、**resolved**、**rejected**
   1. **pending**: 挂起，处于未决阶段，则表示这件事情还在挂起（最终的结果还没出来）
   2. **resolved**：已处理，已决阶段的一种状态，表示整件事情已经出现结果，并是一个可以按照正常逻辑进行下去的结果
   3. **rejected**：已拒绝，已决阶段的一种状态，表示整件事情已经出现结果，并是一个无法按照正常逻辑进行下去的结果，通常用于表示有一个错误

- 既然未决阶段有权力决定事情的走向，因此，未决阶段可以决定事情最终的状态！
- 我们将 把事情变为`resolved`状态的过程叫做：**resolve**，推向该状态时，可能会传递一些数据
- 我们将 把事情变为`rejected`状态的过程叫做：**reject**，推向该状态时，同样可能会传递一些数据，通常为错误信息

**始终记住，无论是阶段，还是状态，是不可逆的！**

![](./ES6/2019-10-18-18-10-18.png)

3. 当事情达到已决阶段后，通常需要进行后续处理，不同的已决状态，决定了不同的后续处理。
   1. **resolved**状态：这是一个正常的已决状态，后续处理表示为 **thenable**
   2. **rejected**状态：这是一个非正常的已决状态，后续处理表示为 **catchable**

后续处理可能有多个，因此会形成作业队列，这些后续处理会按照顺序，当状态到达后依次执行

![](./ES6/2019-10-18-18-10-38.png)

4. 整件事称之为**Promise**

![](./ES6/2019-10-18-18-15-52.png)

**理解上面的概念，对学习Promise至关重要！**

### Promise

#### Promise的基本使用

```js
const pro = new Promise((resolve, reject)=>{
    // 未决阶段的处理
    // 通过调用resolve函数将Promise推向已决阶段的resolved状态
    // 通过调用reject函数将Promise推向已决阶段的rejected状态
    // resolve和reject均可以传递最多一个参数，表示推向状态的数据
})

pro.then(data=>{
    //这是thenable函数，如果当前的Promise已经是resolved状态，该函数会立即执行
    //如果当前是未决阶段，则会加入到作业队列，等待到达resolved状态后执行
    //data为状态数据
}, err=>{
    //这是catchable函数，如果当前的Promise已经是rejected状态，该函数会立即执行
    //如果当前是未决阶段，则会加入到作业队列，等待到达rejected状态后执行
    //err为状态数据
})
```

**细节**

- 未决阶段的处理函数是同步的，会立即执行
- `thenable`和`catchable`函数是异步的，就算是立即执行，也会加入到事件队列中等待执行，并且，加入的队列是微队列
- `pro.then`可以只添加`thenable`函数，`pro.catch`可以单独添加`catchable`函数
- 在未决阶段的处理函数中，如果发生未捕获的错误，会将状态推向`rejected`，并会被`catchable`捕获
- 一旦状态推向了已决阶段，无法再对状态做任何更改
- **Promise并没有消除回调，只是让回调变得可控**

- 实例

```js
function biaobai(god) {
    return new Promise(resolve => {
        console.log(`邓哥向${god}发出了表白短信`);
        setTimeout(() => {
            if (Math.random() < 0.1) {
                //女神同意拉
                resolve(true)
            } else {
                //resolve
                resolve(false);
            }
        }, 3000);
    })
}

biaobai("女神1").then(result => {
    console.log(result);
})
```

```js
// 辅助函数,把传进来的对象拼接成url的字符串
function toData(obj) {
    if (obj === null) {
        return obj;
    }
    let arr = [];
    for (let i in obj) {
        let str = i + "=" + obj[i];
        arr.push(str);
    }
    return arr.join("&");
}
// 封装Ajax
function ajax(obj) {
    return new Promise((resolve, reject) => {
        //指定提交方式的默认值
        obj.type = obj.type || "get";
        //设置是否异步，默认为true(异步)
        obj.async = obj.async || true;
        //设置数据的默认值
        obj.data = obj.data || null;
        // 根据不同的浏览器创建XHR对象
        let xhr = null;
        if (window.XMLHttpRequest) {
            // 非IE浏览器
            xhr = new XMLHttpRequest();
        } else {
            // IE浏览器
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        // 区分get和post,发送HTTP请求
        if (obj.type === "post") {
            xhr.open(obj.type, obj.url, obj.async);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            let data = toData(obj.data);
            xhr.send(data);
        } else {
            let url = obj.url + "?" + toData(obj.data);
            xhr.open(obj.type, url, obj.async);
            xhr.send();
        }
        // 接收返回过来的数据
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status >= 200 && xhr.status < 300 || xhr.status == 304) {
                    resolve(JSON.parse(xhr.responseText))
                } else {
                    reject(xhr.status)
                }
            }
        }
    })
}

ajax({
    url: "./data/students.json?name=李华"
}).then(resp => {
    console.log(resp)
}, err => {
    console.log(err)
})
```

```js
// const pro = new Promise((resolve, reject) => {
//     console.log("未决阶段")
//     resolve(123);
// })
// pro.then(data => {
//     // pro的状态是resolved
//     console.log(data);
// })

const pro = new Promise((resolve, reject) => {
    console.log("未决阶段")
    setTimeout(() => {
        resolve(123);
    }, 3000);
})
pro.then(data => {
    // pro的状态是pending
    console.log(data);
})
pro.then(data => {
    // pro的状态是pending
    console.log(data);
})
pro.then(data => {
    // pro的状态是pending
    console.log(data);
})
```

```js
const pro = new Promise((resolve, reject) => {
    console.log("未决阶段")
    setTimeout(() => {
        if (Math.random < 0.5) {
            resolve(123)
        } else {
            reject(new Error("asdfasdf"));
        }
    }, 3000);
})
pro.then(data => {
    console.log(data);
}, err => {
    console.log(err)
})
```

```js
const pro = new Promise((resolve, reject) => {
    console.log("a")
    resolve(1);
    setTimeout(() => {
        console.log("b")
    }, 0);
})
//pro: resolved
pro.then(data => {
    console.log(data)
})
pro.catch(err => {
    console.log(err)
})
console.log("c")
```

```js
const pro = new Promise((resolve, reject) => {
    throw new Error("123"); // pro: rejected
})
pro.then(data => {
    console.log(data)
})
pro.catch(err => {
    console.log(err)
})
```

```js
const pro = new Promise((resolve, reject) => {
    throw new Error("abc");
    resolve(1); //无效
    reject(2); //无效
    resolve(3); //无效
    reject(4); //无效
})
pro.then(data => {
    console.log(data)
})
pro.catch(err => {
    console.log(err)
})
```

#### Promise的串联

当后续的Promise需要用到之前的`Promise`的处理结果时，需要`Promise`的串联

`Promise`对象中，无论是`then`方法还是`catch`方法，它们都具有返回值，返回的是一个全新的`Promise`对象，它的状态满足下面的规则：

1. 如果当前的`Promise`是未决的，得到的新的Promise是挂起状态
2. 如果当前的`Promise`是已决的，会运行响应的后续处理函数，并将后续处理函数的结果（返回值）作为`resolved`状态数据，应用到新的`Promise`中；如果后续处理函数发生错误，则把返回值作为`rejected`状态数据，应用到新的`Promise`中。

**后续的Promise一定会等到前面的Promise有了后续处理结果后，才会变成已决状态**

如果前面的`Promise`的后续处理，返回的是一个`Promise`，则返回的新的`Promise`状态和后续处理返回的`Promise`状态保持一致。

- 实例

```js
const pro1 = new Promise((resolve, reject) => {
            throw 1;
        })
        const pro2 = pro1.then(result => {
            return result * 2
        }, err => {
            return err * 3;
        });
        pro1.catch(err => {
            return err * 2;
        })
        //pro2类型：Promise对象
        //pro2的状态：
        pro2.then(result => console.log(result * 2), err => console.log(err * 3))

//输出：6
```

```js
const pro1 = new Promise((resolve, reject) => {
    resolve(1);
})

const pro2 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(2);
    }, 3000);
})

pro1.then(result => {
    console.log("结果出来了，得到的是一个Promise")
    return pro2;
}).then(result => {
    console.log(result)
}).then(result => {
    console.log(result)
})
```

```js
function biaobai(god) {
    return new Promise(resolve => {
        console.log(`邓哥向${god}发出了表白短信`);
        setTimeout(() => {
            if (Math.random() < 0.3) {
                //女神同意拉
                resolve(true)
            } else {
                //resolve
                resolve(false);
            }
        }, 500);
    })
}

/*
邓哥心中有三个女神
有一天，邓哥决定向第一个女神表白，如果女神拒绝，则向第二个女神表白，直到所有的女神都拒绝，或有一个女神同意为止
用代码模拟上面的场景
*/
const gods = ["女神1", "女神2", "女神3", "女神4", "女神5"];
let pro;
for (let i = 0; i < gods.length; i++) {
    if (i === 0) {
        pro = biaobai(gods[i]);
    }
    pro = pro.then(resp => {
        if (resp === undefined) {
            return;
        } else if (resp) {
            console.log(`${gods[i]}同意了`)
            return;
        } else {
            console.log(`${gods[i]}拒绝了`)
            if (i < gods.length - 1) {
                return biaobai(gods[i + 1]);
            }
        }
    })
}
```

#### Promise的其他api

- 原型成员 (实例成员)
  - **then**：注册一个后续处理函数，当`Promise`为`resolved`状态时运行该函数
  - **catch**：注册一个后续处理函数，当`Promise`为`rejected`状态时运行该函数
  - **finally**：[`ES2018`]注册一个后续处理函数（无参），当`Promise`为已决时运行该函数

- 构造函数成员 （静态成员）

- **resolve**(数据)：该方法返回一个`resolved`状态的`Promise`，传递的数据作为状态数据
  - 特殊情况：如果传递的数据是`Promise`，则直接返回传递的`Promise`对象
- **reject**(数据)：该方法返回一个`rejected`状态的`Promise`，传递的数据作为状态数据
- **all(iterable)**：这个方法返回一个新的`promise`对象，该`promise`对象在`iterable`参数对象里所有的`promise`对象都成功的时候才会触发成功，一旦有任何一个`iterable`里面的`promise`对象失败则立即触发该`promise`对象的失败。这个新的`promise`对象在触发成功状态以后，会把一个包含`iterable`里所有promise返回值的数组作为成功回调的返回值，顺序跟`iterable`的顺序保持一致；如果这个新的`promise`对象触发了失败状态，它会把`iterable`里第一个触发失败的`promise`对象的错误信息作为它的失败错误信息。`Promise.all`方法常被用于处理多个`promise`对象的状态集合。
- **race(iterable)**：当`iterable`参数里的任意一个子`promise`被成功或失败后，父`promise`马上也会用子`promise`的成功返回值或失败详情作为参数调用父`promise`绑定的相应句柄，并返回该`promise`对象
- 例

- ```js
  // const pro = new Promise((resolve, reject) => {
  //     resolve(1);
  // })
  //等效于：
  // const pro = Promise.resolve(1);
  
  // const pro = new Promise((resolve, reject) => {
  //     reject(1);
  // })
  //等效于：
  // const pro = Promise.reject(1);
  
  const p = new Promise((resolve, reject) => {
      resolve(3);
  })
  // const pro = Promise.resolve(p);
  //等效于
  const pro = p;
  console.log(pro === p)
  ```

- ```js
  function getRandom(min, max) {
      return Math.floor(Math.random() * (max - min)) + min;
  }
  const proms = [];
  for (let i = 0; i < 10; i++) {
      proms.push(new Promise((resolve, reject) => {
          setTimeout(() => {
              if (Math.random() < 0.5) {
                  console.log(i, "完成");
                  resolve(i);
              } else {
                  console.log(i, "失败")
                  reject(i);
              }
          }, getRandom(1000, 5000));
      }))
  }
  //等到所有的promise变成resolved状态后输出: 全部完成
  const pro = Promise.all(proms)
  pro.then(datas => {
      console.log("全部完成", datas);
  })
  pro.catch(err => {
      console.log("有失败的", err);
  })
  console.log(proms);
  ```

- ```js
  function getRandom(min, max) {
      return Math.floor(Math.random() * (max - min)) + min;
  }
  const proms = [];
  for (let i = 0; i < 10; i++) {
      proms.push(new Promise((resolve, reject) => {
          setTimeout(() => {
              if (Math.random() < 0.5) {
                  console.log(i, "完成");
                  resolve(i);
              } else {
                  console.log(i, "失败")
                  reject(i);
              }
          }, getRandom(1000, 5000));
      }))
  }
  //等到所有的promise变成resolved状态后输出: 全部完成
  const pro = Promise.race(proms)
  pro.then(data => {
      console.log("有人完成了", data);
  })
  pro.catch(err => {
      console.log("有人失败了", err);
  })
  console.log(proms);
  ```

- ```js
  /*
  邓哥心中有二十个女神，他决定用更加高效的办法
  他同时给二十个女神表白，如果有女神同意，就拒绝其他的女神
  并且，当所有的女神回复完成后，他要把所有的回复都记录到日志进行分析
  用代码模拟上面的场景
  */
  function biaobai(god) {
      return new Promise((resolve, reject) => {
          console.log(`邓哥向女神【${god}】发出了表白短信`);
          setTimeout(() => {
              if (Math.random() < 0.05) {
                  //女神同意拉
                  console.log(god, "同意")
                  resolve(true);
              } else {
                  console.log(god, "拒绝")
                  resolve(false);
              }
          }, Math.floor(Math.random() * (3000 - 1000) + 1000));
      })
  }
  const proms = [];
  let hasAgree = false; //是否有女神同意
  
  for (let i = 1; i <= 20; i++) {
      const pro = biaobai(`女神${i}`).then(resp => {
          if (resp) {
              if (hasAgree) {
                  console.log("发错了短信，邓哥很机智的拒绝了")
              } else {
                  hasAgree = true;
                  console.log("邓哥很开心，终于成功了！");
              }
          }
          return resp;
      })
      proms.push(pro);
  }
  
  Promise.all(proms).then(results => {
      console.log("日志记录", results);
  })
  ```

- ```js
  // Promise.all可以将多个Promise实例包装成一个新的Promise实例
  // 同时，成功和失败的返回值是不同的，成功的时候返回的是一个结果数组
  // 而失败的时候则返回最先被reject失败状态的值
  
  function test(x) {
      return new Promise((reason,reject) => {
          setTimeout(() => {
              Math.random() * 100 > 50 ? reason(x) : reject(x)
          },100)
      })
  }
  
  let oP = Promise.all([test('a'),test('b'),test('c')]);
  oP.then((val) => {
      console.log(val);
  },(reason) => {
      console.log(reason);
  });
  
  
  // 顾名思义：Promise.race就是赛跑的意思，意思就是说
  // Promise.race([p1,p2,p3])里那个结果获得的快，就返回那个结果
  // 不管结果本身是成功状态还是失败状态
  Promise.race([test('a'),test('b'),test('c')]).then((val) =>{
      console.log(val,'ok')
  },(reason) => {
      console.log(reason,'no');
  });
  ```

#### [扩展手写Promise]

##### ES6之手写Promise

```js
const MyPromise = (() => {
    const PENDING = "pending",
        RESOLVED = "resolved",
        REJECTED = "rejected",
        PromiveValue = Symbol("PromiseValue"), //状态数据
        PromiseStatus = Symbol("PromiseStatus"),
        thenables = Symbol("thenables"), //thenable
        catchables = Symbol("catchbles"), //catchables
        changeStatus = Symbol("changeStatus"),//当前状态
        settleHandle = Symbol("settleHandle"), //后续处理的通用函数
        linkPromise = Symbol("linkPromise");  //创建串联的Promise

    return class MyPromise {

        /**
         * 改变当前Promise的状态
         * @param {*} newStatus 
         * @param {*} newValue 
         * @param {*} queue 执行的作业队列
         */
        [changeStatus](newStatus, newValue, queue) {
            if (this[PromiseStatus] !== PENDING) {
                //状态无法变更
                return;
            }
            this[PromiseStatus] = newStatus;
            this[PromiveValue] = newValue;
            //执行相应队列中的函数
            queue.forEach(handler => handler(newValue));
        }

        /**
         * 
         * @param {*} executor 未决阶段（pending状态）下的处理函数
         */
        constructor(executor) {
            this[PromiseStatus] = PENDING;
            this[PromiveValue] = undefined;
            this[thenables] = []; //后续处理函数的数组 -> resolved
            this[catchables] = []; //后续处理函数的数组 -> rejected

            const resolve = data => {
                this[changeStatus](RESOLVED, data, this[thenables]);
            }

            const reject = reason => {
                this[changeStatus](REJECTED, reason, this[catchables]);
            }
            try {
                executor(resolve, reject)
            }
            catch (err) {
                reject(err);
            }
        }

        /**
         * 处理 后续处理函数
         * @param {*} handler 后续处理函数
         * @param {*} immediatelyStatus 需要立即执行的状态
         * @param {*} queue 作业队列
         */
        [settleHandle](handler, immediatelyStatus, queue) {
            if (typeof handler !== "function") {
                return;
            }
            if (this[PromiseStatus] === immediatelyStatus) {
                //直接运行
                setTimeout(() => {
                    handler(this[PromiveValue]);
                }, 0);
            }
            else {
                queue.push(handler);
            }
        }

        [linkPromise](thenalbe, catchable) {
            function exec(data, handler, resolve, reject) {
                try {
                    const result = handler(data); //得到当前Promise的处理结果
                    if (result instanceof MyPromise) {
                        result.then(d => {
                            resolve(d)
                        }, err => {
                            reject(err);
                        })
                    }
                    else {
                        resolve(result);
                    }
                }
                catch (err) {
                    reject(err);
                }
            }

            return new MyPromise((resolve, reject) => {
                this[settleHandle](data => {
                    exec(data, thenalbe, resolve, reject);
                }, RESOLVED, this[thenables])

                this[settleHandle](reason => {
                    exec(reason, catchable, resolve, reject);
                }, REJECTED, this[catchables])
            })
        }

        then(thenable, catchable) {
            return this[linkPromise](thenable, catchable);
        }

        catch(catchable) {

            return this[linkPromise](undefined, catchable);
        }


        static all(proms) {
            return new Promise((resolve, reject) => {
                const results = proms.map(p => {
                    const obj = {
                        result: undefined,
                        isResolved: false
                    }
                    p.then(data => {
                        obj.result = data;
                        obj.isResolved = true;
                        //判断是否所有的全部完成
                        const unResolved = results.filter(r => !r.isResolved)
                        if (unResolved.length === 0) {
                            //全部完成
                            resolve(results.map(r => r.result));
                        }
                    }, reason => {
                        reject(reason);
                    })
                    return obj;
                })
            })
        }

        static race(proms) {
            return new Promise((resolve, reject) => {
                proms.forEach(p => {
                    p.then(data => {
                        resolve(data);
                    }, err => {
                        reject(err);
                    })
                })
            })
        }

        static resolve(data) {
            if (data instanceof MyPromise) {
                return data;
            }
            else {
                return new MyPromise(resolve => {
                    resolve(data);
                })
            }
        }

        static reject(reason) {
            return new MyPromise((resolve, reject) => {
                reject(reason);
            })
        }
    }
})();
```

##### ES5之手写Promise

```js
// 原生Promise特性
//new
// 参数：executor 同步执行，executor中要有两个参数(resolve,reject)
// 触发Fulfilled Rejected状态（成功，失败），没有触发之前是pending等待状态

// 异步操作
// 链式操作
// then异步执行，抛出错误
// 空then
// 返回值是对象时

function MyPromise(executor) {
    // 将self事先等于window
    var self = this;

    // 状态：一开始为进行中pending
    self.status = 'pending';

    // 为了then可以调用函数的参数，为self声明两个参数来接收两个函数的参数
    self.resolveValue = null;
    self.rejectReason = null;

    // 回调数组，当注册函数时不执行，先存入数组，当真正执行函数时，在执行
    self.ResolveCallBackList = [];
    self.RejectCallBackList = [];

    // 成功函数
    function resolve(value) {
        //只有状态===pending时才可以转换状态
        if (self.status === 'pending') {
            self.status = 'Fulfilled'; //成功
            //将value赋值给self的resolveValue，以便then使用
            self.resolveValue = value;
            // 执行回调函数中的函数
            self.ResolveCallBackList.forEach(function (ele) {
                ele();
            });
        }
    }

    //失败函数
    function reject(reason) {
        //只有状态===pending时才可以转换状态
        if (self.status === 'pending') {
            self.status = 'Rejected'; //失败
            // 将reason赋值给self的rejectReason，以便then使用
            self.rejectReason = reason;
            // 执行回调函数中的函数
            self.RejectCallBackList.forEach(function (ele) {
                ele();
            });
        }
    }

    // 使用try{}catch{}判断错误，当executor抛出错误时，执行reject()来打印错误
    try {
        executor(resolve, reject);
    } catch (e) {
        reject(e);
    }
}

// 处理返回值函数
function ResolutionReturnPromise(nextPromise, returnValue, res, rej) {
    // 如果返回值是Promise对象时
    if (returnValue instanceof MyPromise) {
        returnValue.then(
            function (val) {
                res(val);
            },
            function (reason) {
                rej(reason);
            }
        );

    // 如果返回值不是Promise对象时，执行res
    } else {
        res(returnValue);
    }
}

// then函数，参数：onFulfilled,onRejected两个函数参数，分别代表完成、拒绝
MyPromise.prototype.then = function (onFulfilled, onRejected) {
    // 空then处理方法：
    //若没有onFulfilled时则返回参数val
    //若onRejected则抛出参数reason错误
    if (!onFulfilled) {
        onFulfilled = function (val) {
            return val;
        };
    }
    if (!onRejected) {
        onRejected = function (reason) {
            throw new Error(reason);
        };
    }

    // 将self事先等于window
    var self = this;

    // 链式操作
    // 拿到上一次函数返回结果，用于下一次then的参数
    var nextPromise = new MyPromise(function (res, rej) {
        // 当状态为Fulfilled时，执行onFulfilled完成
        if (self.status === 'Fulfilled') {
            //异步方式执行操作：setTimeout
            setTimeout(function () {
                // 在then中抛出错误时，在下一个then中的reject函数中打印
                try {
                    //拿到此次函数的返回结果，用于下一次then的参数
                    var nextResolveValue = onFulfilled(self.resolveValue);

                    // 处理返回值函数
                    ResolutionReturnPromise(nextPromise, nextResolveValue, res, rej);

                    /* 
                    //拿到此次函数的返回结果，用于下一次then的参数
                    var nextResolveValue = onFulfilled(self.resolveValue);
                    
                    //执行下一次函数时，使用上一次函数返回结果作为参数
                    res(nextResolveValue); */
                } catch (e) {
                    rej(e);
                }
            }, 0);
        }

        // 当状态为Rjected时，执行onRejected拒绝
        if (self.status === 'Rejected') {
            setTimeout(function () {
                try {
                    var nextRejectValue = onRejected(self.rejectReason);
                    ResolutionReturnPromise(nextPromise, nextRejectValue, res, rej);
                } catch (e) {
                    rej(e);
                }
            }, 0);
        }

        // 异步操作实现
        if (self.status === 'pending') {
            // 将函数推入回调函数
            self.ResolveCallBackList.push(function () {
                setTimeout(function () {
                    try {
                        var nextResolveValue = onFulfilled(self.resolveValue);
                        ResolutionReturnPromise(nextPromise, nextResolveValue, res, rej);
                    } catch (e) {
                        rej(e);
                    }
                }, 0);
            });

            self.RejectCallBackList.push(function () {
                setTimeout(function () {
                    try {
                        var nextRejectValue = onRejected(self.rejectReason);
                        ResolutionReturnPromise(nextPromise, nextRejectValue, res, rej);
                    } catch (e) {
                        rej(e);
                    }
                }, 0);
            });
        }
    });

    return nextPromise;
};

// 静态方法 race
MyPromise.race = function (promiseArr) {
    return new MyPromise(function (resolve, reject) {
        if (promiseArr.length == 0) return;
        promiseArr.forEach(function (ele, index) {
            resolve(ele).then(
                function (res) {
                    resolve(res);
                    return;
                },
                function (err) {
                    reject(err);
                    return;
                }
            );
        });
    });
};

// 静态方法 all
MyPromise.all = function (promiseArr) {
    let results = [], //执行数组
        promiseArrCount = 0, //计算函数总执行次数
        promiseArrLength = promiseArr.length; //函数参数总长度
    return new MyPromise(function (resolve, reject) {
        promiseArr.forEach(function (ele, index) {
            resolve(ele).then(
                function (res) {
                    promiseArrCount++;
                    results.push(res);
                    //当所有函数都正确执行了，resolve执行输出所有结果
                    if (promiseArrCount === promiseArrLength) {
                        return resolve(results);
                    }
                },
                function (err) {
                    return reject(err);
                }
            );
        });
    });
};
```

### 生成器

#### Iterator

##### Interator简介

- 迭代模式：
  - 提供一种方法可以顺序获得聚合对象的各个元素，是一种最简单也最常见的设计模式，它可以让用户透过特定的接口寻访集合中的每一个元素而不用了解底层的实现
- 迭代器简介
  - 依照与迭代模式的思想而实现，分为内部迭代器和外部迭代器
  -  内部迭代器：
    - 本身是函数，该函数内部定义好迭代规则，完全接手整个迭代过程，外部迭代只需要一次初始调用
    - ` Array.prototype.forEach`，`jQuery.each`内部迭代器
  - 外部迭代器：
    - 本身是函数，执行返回迭代对象，迭代下一个元素必须显示调用，调用复杂度增加，但灵活性增加
    - `function outerIterator() {}` 外部迭代器
- 迭代器目的：
  - 从迭代模式思想中可以看出，就是要标准化迭代操作
  - 举个例子：服务端提供数组数据给前端，前端for循环遍历，但由于业务变化，使得数据结构发生变化，返回对象或者`set`、`map`，导致前端遍历代码大量重写
  - 解决方案
    - `ES6`引入`Interator`，部署在`NodeList`、`arguments`、`Array`、`Set`、Map、字符串上等数据的Symbol。iterator属性
    - `使得这些数据``iterable`可迭代了，能进行`for of`、`...`、、`Array.from`等操作

##### iterator接口

- **iterator**实现规则：`next`、`value`、`done`

- 对象中部署**iterator**

  - ```js
    // ES6规范：interator
    let obj = {
        0: 'a',
        1: 'b',
        2: 'c',
        length: 3,
        // 部署iterator，然后就可以被迭代了
        [Symbol.iterator]: function() {
            let curIndex = 0
            let next = () => {
                return {
                    value: this[curIndex],
                    done: this.length == curIndex++,
                }
            }
            return {
                next
            }
        }
    };
    
    console.log(...obj); //a b c
    
    for(let prop of obj) {
        console.log(prop); //a b c
    }
    ```

#### Generator

##### 简介

- **Generator**简介

  - 生成器，本身是函数，执行后返回迭代对象，函数内部要配合`yield`使用`Generator`函数会分段执行，遇到`yield`即暂停

- 特点

  - `function`和函数名之间要带`*`星号
  - 函数体内部`yield`表达式，产出不同的内部状态（值）
  - 遇到`yield`即暂停

- 演示

  - ```js
    // 生成器函数
    // 再function和函数名中间任意位置添加一个*号，代表生成器函数
    function * test() {
        // yield，当执行到yield时，会停止执行，直到再执行next时，再继续下一步
        yield 'a';
        console.log('1');
        yield 'b';
        console.log('2');
        yield 'c';
        console.log('3');
        return 'd';
    }
    
    let oG = test();
    // {value: 'a',done: false}
    // oG.next();
    ```

  - ```js
    function * test() {
        // 执行方式：蛇形方式，每次先执行yield，然后停止，再给value赋值，直到再遇到yield停止
        // value的值不是在于yield中的值，而是在于下一次执行next中传入的值
    
        // 先执行yield 'a'，停止，下一次时再给value赋值(传参)
        let value1 = yield 'a';
        console.log(value1);
    
        let value2 = yield 'b';
        console.log(value2);
    
        let value3 = yield 'c';
        console.log(value3);
        return 'd';
    }
    
    let oG = test();
    
    console.log(oG.next());
    // 传入的A，那么value1就是A
    console.log(oG.next('A'));
    console.log(oG.next('B'));
    console.log(oG.next('C'));
    ```

##### Generator改写

- ```js
  // Generator改写Iterator
  let obj = {
      0: 'a',
      1: 'b',
      2: 'c',
      length:3,
      [Symbol.iterator]: function *() {
          let currIndex = 0;
          while(currIndex != this.length) {
              yield this[currIndex];
              currIndex ++;
          }
      }
  }
  
  console.log([...obj])
  ```

- ```js
  // Generator改写回调地狱
  
  let fs = require('fs');
  function readFile(path) {
      return new Promise((res,rej) => {
          fs.readFile(path,'utf-8',(err,data) => {
              if(data) {
                  res(data);
              } else {
                  rej(err);
              }
          })
      })
  }
  
  //Generator 函数
  function * read() {
      let val1 = yield readFile('./number.txt');
      let val2 = yield readFile(val1);
      let val3 = yield readFile(val2);
      return val3;
  }
  let oG = read();
  
  //第一种优化方法，但是使用这种方法还不如直接使用Promise
  // let {value,done} = oG.next();
  // value.then((val) => {
  //     let {value,done} = oG.next(val);
  //     value.then((val) => {
  //         let {value,done} = oG.next(val);
  //         value.then((val) => {
  //            console.log(val);
  //         })
  //     })
  // })
  
  // 递归优化，第二种优化方法
  // 其实是一个库，一个叫做TJ的大神写的库，可以是使用npm来下载
  // TJ 写的库 express koa node
  function Co(oIt) {
      return new Promise((res,rej) => {
          let next = (data) => {
              let {value,done} = oIt.next(data);
              if(done) {
                  res(value);
              } else {
                  value.then((val) => {
                      next(val)
                  ,rej})
              }
          }
          next();
      })
  }
  
  Co(read()).then((val) => {
      console.log(val);
  })
  ```

### async 和 await

- `async`函数，是`Generator`语法糖，通过`babel`编译后可以看出它就是`Generator+promise+Co`思想实现的，配合`await`使用

- 目的：优雅的解决异步操作问题


> `async` 和 `await` 是 `ES2016` 新增两个关键字，它们借鉴了 `ES2015` 中生成器在实际开发中的应用，目的是简化 `Promise api` 的使用，并非是替代 `Promise`。

##### async

- 目的是简化在函数的返回值中对Promise的创建

- **async** 用于修饰函数（无论是函数字面量还是函数表达式），放置在函数最开始的位置，被修饰函数的返回结果一定是 **Promise** 对象。

```js
async function test(){
    console.log(1);
    return 2;
}

//等效于

function test(){
    return new Promise((resolve, reject)=>{
        console.log(1);
        resolve(2);
    })
}

```

##### await

- **await关键字必须出现在async函数中！！！！**

- **await**用在某个表达式之前，如果表达式是一个**Promise**，则得到的是**thenable**中的状态数据。

```js

async function test1(){
    console.log(1);
    return 2;
}

async function test2(){
    const result = await test1();
    console.log(result);
}

test2();
```

等效于

```js

function test1(){
    return new Promise((resolve, reject)=>{
        console.log(1);
        resolve(2);
    })
}

function test2(){
    return new Promise((resolve, reject)=>{
        test1().then(data => {
            const result = data;
            console.log(result);
            resolve();
        })
    })
}

test2();

```

如果`await`的表达式不是`Promise`，则会将其使用`Promise.resolve`包装后按照规则运行

- 实例

  - ```js
    function biaobai(god) {
        return new Promise(resolve => {
            console.log(`邓哥向${god}发出了表白短信`);
            setTimeout(() => {
                if (Math.random() < 0.3) {
                    //女神同意拉
                    resolve(true)
                } else {
                    //resolve
                    resolve(false);
                }
            }, 500);
        })
    }
    
    /*
                邓哥心中有三个女神
                有一天，邓哥决定向第一个女神表白，如果女神拒绝，则向第二个女神表白，直到所有的女神都拒绝，或有一个女神同意为止
                用代码模拟上面的场景
            */
    (async () => {
        const gods = ["女神1", "女神2", "女神3", "女神4", "女神5"];
        for (let i = 0; i < gods.length; i++) {
            const g = gods[i];
            // 当前循环等待的Promise没有resolve，下一次循环不运行
            const result = await biaobai(g);
            if (result) {
                console.log(`${g}同意了，不用再表白了！！！`);
                break;
            } else {
                console.log(`${g}没有同意`)
            }
        }
    })()
    ```

  - ```js
    async function getPromise() {
        if (Math.random() < 0.5) {
            return 1;
        } else {
            throw 2;
        }
    }
    
    async function test() {
        try {
            const result = await getPromise();
            console.log("正常状态", result)
        } catch (err) {
            console.log("错误状态", err);
        }
    }
    
    test();
    ```

  - ```js
    function delay(duration) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                resolve();
            }, duration);
        })
    }
    
    async function biaobai(god) {
        console.log(`邓哥向${god}发出了表白短信`);
        await delay(500);
        return Math.random() < 0.3;
    }
    ```

##### promise函数化

```js
let fs = require('fs');

// 当使用NodeJs开始时，使用promise为中心的开发方式，带来的好处是大家都使用promise进行异步方案的解决，不用考虑回调callback，但是还是有一些库没有用promise来实现，所以就需要使用一个函数来把那些库要使用的函数来进行promise实现，不过promisify只可以把一个函数来进行promise转换
function promisify(func) {
	return function(...arg) {
		return new Promise((res,rej) => {
			// 在node中参数基本上都是error-firstb标准形式，所以基本可以写成(err,data)形式
			func(...arg, (err,data) => {
				if(err) {
					rej(err);
				} else {
					res(data);
				}
			})
		})
	}
}

// let readFile = promisify(fs.readFile);
// readFile('./number.txt','utf-8').then((val) => {
// 	console.log(val);
// })




// promisifyAll 函数可以把一个库中所有的函数都promise化并添加成另外一个函数，
// promisifyAll 函数可以为一个方法中的所有函数另外添加一个Async（promise化）的函数，可以
function promisifyAll(obj) {
	for (let key in obj) {
		let fn = obj[key];
		if(typeof fn === 'function') {
			obj[key + 'Async'] = promisify(fn)
		}
	}
}
promisifyAll(fs);
// fs.readFile -> readFileAsync
// fs.writeFile -> readFileAsync

fs.readFileAsync('./number.txt','utf-8').then((val) => {
	console.log(val);
})

// bluebird库中有这个promisify函数和promisifyArr函数
// let bluebird = require('bluebird');
// bluebird.promisify(fs.readFile);
```

## FetchApi

### Fetch Api 概述

- **XMLHttpRequest的问题**
  - 所有的功能全部集中在同一个对象上，容易书写出混乱不易维护的代码
  - 采用传统的事件驱动模式，无法适配新的 `Promise Api`

- **Fetch Api 的特点**
  - 并非取代 `AJAX`，而是对 `AJAX` 传统 `API` 的改进
  - 精细的功能分割：头部信息、请求信息、响应信息等均分布到不同的对象，更利于处理各种复杂的 `AJAX` 场景
  - 使用 `Promise Api`，更利于异步代码的书写
  - `Fetch Api` 并非 `ES6` 的内容，属于 `HTML5` 新增的 `Web Api`
  - 需要掌握网络通信的知识

### 基本使用

> 请求测试地址：http://101.132.72.36:5100/api/local
>
> ​			[jsonplaceholder.typicode.com/posts](http://jsonplaceholder.typicode.com/posts)

使用 ```fetch``` 函数即可立即向服务器发送网络请求

#### 参数

该函数有两个参数：

1. 必填，字符串，请求地址
2. 选填，对象，请求配置

**请求配置对象**

- **method**：字符串，请求方法，默认值`GET`
- **headers**：对象，请求头信息
- **body**: 请求体的内容，必须匹配请求头中的 `Content-Type`
- **mode**：字符串，请求模式
  - **cors**：默认值，配置为该值，会在请求头中加入 `origin` 和 `referer`
  - **no-cors**：配置为该值，不会在请求头中加入 `origin` 和 `referer`，跨域的时候可能会出现问题
  - **same-origin**：指示请求必须在同一个域中发生，如果请求其他域，则会报错
- **credentials**: 如何携带凭据（`cookie`）
  - **omit**：默认值，不携带`cookie`
  - **same-origin**：请求同源地址时携带`cookie`
  - **include**：请求任何地址都携带`cookie`
- **cache**：配置缓存模式
  - **default**: 表示`fetch`请求之前将检查下`http`的缓存.
  - **no-store**: 表示`fetch`请求将完全忽略`http`缓存的存在. 这意味着请求之前将不再检查下`http`的缓存, 拿到响应后, 它也不会更新`http`缓存.
  - **no-cache**: 如果存在缓存, 那么`fetch`将发送一个条件查询`request`和一个正常的`request`, 拿到响应后, 它会更新`http`缓存.
  - **reload**: 表示fetch请求之前将忽略`http`缓存的存在, 但是请求拿到响应后, 它将主动更新`http`缓存.
  - **force-cache**: 表示`fetch`请求不顾一切的依赖缓存, 即使缓存过期了, 它依然从缓存中读取. 除非没有任何缓存, 那么它将发送一个正常的`request`.
  - **only-if-cached**: 表示`fetch`请求不顾一切的依赖缓存, 即使缓存过期了, 它依然从缓存中读取. 如果没有缓存, 它将抛出网络错误(该设置只在mode为”`same-origin`”时有效).

#### 返回值

**fetch** 函数返回一个 **Promise** 对象

- 当收到服务器的返回结果后，Promise 进入resolved状态，状态数据为 Response 对象
- 当网络发生错误（或其他导致无法完成交互的错误）时，Promise 进入 rejected 状态，状态数据为错误信息

**Response对象**

- **ok**：`boolean`，当响应消息码在`200~299`之间时为`true`，其他为`false`
- **status**：`number`，响应的状态码
- **text()**：用于处理文本格式的 `Ajax` 响应。它从响应中获取文本流，将其读完，然后返回一个被解决为 `string` 对象的 `Promise`。
- **blob()**：用于处理二进制文件格式（比如图片或者电子表格）的 `Ajax` 响应。它读取文件的原始数据，一旦读取完整个文件，就返回一个被解决为 `blob` 对象的 `Promise`。
- **json()**：用于处理 `JSON` 格式的 `Ajax` 的响应。它将 `JSON` 数据流转换为一个被解决为 `JavaScript` 对象的promise。
- **redirect()**：可以用于重定向到另一个 `URL`。它会创建一个新的 `Promise`，以解决来自重定向的 `URL` 的响应。

```js
<button>获得信息</button>

async function getProvinces() {
    const url = "http://jsonplaceholder.typicode.com/posts";
    const resp = await fetch(url)
    const result = await resp.json();
    console.log(result)
}

document.querySelector("button").onclick = function() {
    getProvinces();
}
```

### Request 对象

除了使用基本的`fetch`方法，还可以通过创建一个`Request`对象来完成请求（实际上，`fetch`的内部会帮你创建一个`Request`对象）

```js
new Request(url地址, 配置)
```

注意点：

尽量保证每次请求都是一个新的`Request`对象

```js
<button>获得信息</button>

let req;
function getRequestInfo() {
    if (!req) {
        const url = "http://jsonplaceholder.typicode.com/posts";
        req = new Request(url, {});
        console.log(req);
    }
    return req.clone(); //克隆一个全新的request对象，配置一致
}

async function getProvinces() {
    const resp = await fetch(getRequestInfo())
    const result = await resp.json();
    console.log(result)
}

document.querySelector("button").onclick = function() {
    getProvinces();
}
```

### Response 对象

```js
<button>得到所有的省份数据</button>

let req;
function getRequestInfo() {
    if (!req) {
        const url = "http://jsonplaceholder.typicode.com/posts";
        req = new Request(url, {});
        console.log(req);
    }
    return req.clone(); //克隆一个全新的request对象，配置一致
}

async function getProvinces() {
    // const resp = await fetch(getRequestInfo())

const resp = new Response(`[
    {"id":1, "name":"北京"},
    {"id":2, "name":"天津"}
]`, {
        ok: true,
        status: 200
    })
    const result = await getJSON(resp);
    console.log(result)
}

async function getJSON(resp) {
    const json = await resp.json();
    return json;
}

document.querySelector("button").onclick = function() {
    getProvinces();
}
```

### Headers 对象

> 在**Request**和**Response**对象内部，会将传递的请求头对象，转换为**Headers**

**Headers**对象中的方法：

- **has(key)**：检查请求头中是否存在指定的key值
- **get(key)**: 得到请求头中对应的key值
- **set(key, value)**：修改对应的键值对
- **append(key, value)**：添加对应的键值对
- **keys()**：得到所有的请求头键的集合
- **values()**：得到所有的请求头中的值的集合
- **entries()**：得到所有请求头中的键值对的集合

```js
<button>获得信息</button>

let req;
function getCommonHeaders() {
    return new Headers({
        a: 1,
        b: 2
    })
}

function printHeaders(headers) {
    const datas = headers.entries();
    for (const pair of datas) {
        console.log(`key: ${pair[0]}，value: ${pair[1]}`);
    }
}

function getRequestInfo() {
    if (!req) {
        const url = "http://jsonplaceholder.typicode.com/posts";
        const headers = getCommonHeaders();
        headers.set("a", 3)
        req = new Request(url, {
            headers
        });
        printHeaders(headers);
    }
    return req.clone(); //克隆一个全新的request对象，配置一致
}

async function getProvinces() {
    const resp = await fetch(getRequestInfo())
    printHeaders(resp.headers);
    const result = await getJSON(resp);
    console.log(result)
}

async function getJSON(resp) {
    const json = await resp.json();
    return json;
}

document.querySelector("button").onclick = function() {
    getProvinces();
}
```

### 文件上传

流程：

1. 客户端将文件数据发送给服务器
2. 服务器保存上传的文件数据到服务器端
3. 服务器响应给客户端一个文件访问地址

> 测试地址：http://101.132.72.36:5100/api/upload
> 键的名称（表单域名称）：**imagefile**

请求方法：`POST`
请求的表单格式：`multipart` / `form-data`
请求体中必须包含一个键值对，键的名称是服务器要求的名称，值是文件数据

> `HTML5`中，`JS`仍然无法随意的获取文件数据，但是可以获取到`input`元素中，被用户选中的文件数据
> 可以利用`HTML5`提供的`FormData`构造函数来创建请求体

```js
<img src="" alt="" id="imgAvatar">
<input type="file" id="avatar">
<button>上传</button>

async function upload() {
    const inp = document.getElementById("avatar");
    if (inp.files.length === 0) {
        alert("请选择要上传的文件");
        return;
    }
    const formData = new FormData(); //构建请求体
    formData.append("imagefile", inp.files[0]);
    const url = "http://101.132.72.36:5100/api/upload"
    const resp = await fetch(url, {
        method: "POST",
        body: formData //自动修改请求头
    });
    const result = await resp.json();
    return result;
}

document.querySelector("button").onclick = async function() {
    const result = await upload();
    const img = document.getElementById("imgAvatar")
    img.src = result.path;
}
```

