# ES6

**ECMAScript、JavaScript、NodeJs，它们的区别是什么？**

- ECMAScript：简称ES，是一个语言标准（循环、判断、变量、数组等数据类型）
- JavaScript：运行在浏览器端的语言，该语言使用ES标准。 ES + web api = JavaScript
- NodeJs：运行在服务器端的语言，该语言使用ES标准。 ES + node api = JavaScript

无论JavaScript，还是NodeJs，它们都是ES的超集（super set）

#### 声明变量的问题

**使用var声明变量**

1. 允许重复的变量声明：导致数据被覆盖

2. 变量提升：怪异的数据访问、闭包问题

3. 全局变量挂载到全局对象：全局对象成员污染问题

**使用****let****声明变量**

ES6不仅引入let关键字用于解决变量声明的问题，同时引入了块级作用域的概念

块级作用域：代码执行时遇到花括号，会创建一个块级作用域，花括号结束，销毁块级作用域

声明变量的问题

1. 全局变量挂载到全局对象：全局对象成员污染问题

   let声明的变量不会挂载到全局对象

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609294638948-60f1b824-e2f0-4d82-b8fa-6799e2b7b228.png)

2. 允许重复的变量声明：导致数据被覆盖

   let声明的变量，不允许当前作用域范围内重复声明

   在块级作用域中用let定义的变量，在作用域外不能访问

补充：在之前js中，作用域就只分为全局作用域和函数作用域，而在es6中一个大括号就相当于一个块级作用域

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609294638960-9c40369a-5267-43fe-a68e-e5e71917754f.png)

3. 变量提升：怪异的数据访问、闭包问题

使用let不会有变量提升，因此，不能在定义let变量之前使用它

底层实现上，let声明的变量实际上也会有提升，但是，提升后会将其放入到“暂时性死区”，如果访问的变量位于暂时性死区，则会报错：“Cannot access 'a' before initialization”。当代码运行到该变量的声明语句时，会将其从暂时性死区中移除。

在循环中，用let声明的循环变量，会特殊处理，每次进入循环体，都会开启一个新的作用域，并且将循环变量绑定到该作用域（每次循环，使用的是一个全新的循环变量）。在循环中使用let声明的循环变量，在循环结束后会销毁。

#### 使用const声明常量

const和let完全相同，仅在于用const声明的变量，必须在声明时赋值，而且不可以重新赋值。

实际上，在开发中，应该尽量使用const来声明变量，以保证变量的值不会随意篡改，原因如下：

1. 根据经验，开发中的很多变量，都是不会更改，也不应该更改的。

2. 后续的很多框架或者是第三方JS库，都要求数据不可变，使用常量可以一定程度上保证这一点。

注意的细节：

1. 常量不可变，是指声明的常量的内存空间不可变，并不保证内存空间中的地址指向的其他空间不可变。

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609294639015-f0a412aa-d6e8-41ec-a0d6-cb1cc3a0e13c.png)

 

2. 常量的命名
- 特殊的常量：该常量从字面意义上，一定是不可变的，比如圆周率（PI）、月地距地（MOON_EARTH_DISTANCE）或其

​      他一些绝不可能变化的配置。

​      通常，该常量的名称全部使用大写，多个单词之间用下划线分割

- 普通的常量：使用和之前一样的命名即可，小驼峰式。

- 在for循环中，循环变量不可以使用const声明。可以使用for in

#### 更好的Unicode支持

​    早期，由于存储空间宝贵，Unicode使用16位二进制来存储文字。我们将一个16位的二进制编码叫做一个码元（Code Unit）。

​    后来，由于技术的发展，Unicode对文字编码进行了扩展，将某些文字扩展到了32位（占用两个码元），并且，将某个文字对应的二进制数字叫做码点（Code Point）。

​    ES6为了解决这个困扰，为字符串提供了方法：codePointAt，根据字符串码元的位置得到其码点。

​    同时，ES6为正则表达式添加了一个flag: u，如果添加了该配置，则匹配时，使用码点匹配

#### 更多的字符串API

以下均为字符串的实例（原型）方法

- includes

判断字符串中是否包含指定的子字符串

\- startsWith

判断字符串中是否以指定的字符串开始

\- endsWith

判断字符串中是否以指定的字符串结尾

\- repeat

将字符串重复指定的次数，然后返回一个新字符串。

**[扩展]正则中的粘连标记**

标记名：y

含义：匹配时，完全按照正则对象中的lastIndex位置开始匹配，并且匹配的位置必须在lastIndex位置。

#### 模板字符串(` `)

ES6之前处理字符串繁琐的两个方面：

1. 多行字符串

2. 字符串拼接

在ES6中，提供了模板字符串的书写，可以非常方便的换行和拼接，要做的，仅仅是将字符串的开始或结尾改为 ` 符号

如果要在字符串中拼接js表达式，只需要在模板字符串中使用```${JS表达式}```

**[扩展]模板字符串标记**

在模板字符串书写之前，可以加上标记:

\```js

标记名`模板字符串`

\```

标记是一个函数，函数参数如下：

1. 参数1：被插值分割的字符串数组

2. 后续参数：所有的插值

#### arguments的缺陷：

1. 如果和形参配合使用，容易导致混乱

2. 从语义上，使用arguments获取参数，由于形参缺失，无法从函数定义上理解函数的真实意图

 

ES6的剩余参数专门用于收集末尾的所有参数，将其放置到一个形参数组中。

```
function test(a, b, ...args) {
    console.log(args);
}
test(1, 32, 46, 7, 34);
```


![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295056735-3f74194e-5b8a-411d-8e6c-fee95180d5c8.png)

**语法:**

```
function (...形参名){}
```

**细节：**

\1. 一个函数，仅能出现一个剩余参数。即形参中只能有一个`...``args`

\2. 一个函数，如果有剩余参数，剩余参数必须是最后一个参数。不能写为function test(a,...args，b)

#### 展开运算符

使用方式：...要展开的东西

- 对数组展开 ES6

```
const arr1 = [3, 67, 8, 5];
const arr2 = [0, ...arr1, 1];
console.log(arr2, arr1 === arr2);
```

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295111065-3f10ad71-21b9-4edf-865e-b0648ce8fb5f.png)

例2

```
// 对所有数字求和
function sum(...args) {
    let sum = 0;
    for (let i = 0; i < args.length; i++) {
        sum += args[i];
    }
    return sum;
}

//获取一个指定长度的随机数组成的数组
function getRandomNumbers(length) {
    const arr = [];
    for (let i = 0; i < length; i++) {
        arr.push(Math.random());
    }
    return arr;
}
const numbers = getRandomNumbers(10);

//将数组的每一项展开，依次作为参数传递，而不是把整个数组作为一个参数传递
console.log(sum(...numbers))//相当于传递了10个参数。输出10个随机数的和。
```



- 对对象展开 ES7

```
const obj1 = {
    name: "小明",
    age: 18,
    love: "milk",
    address: {
        country: "中国",
        province: "黑龙江"
    }
}
// 浅克隆到obj2
const obj2 = {
    ...obj1,
    name: "李华"
};
console.log(obj2)
```

 ![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295111015-1ff2f0c2-87de-447d-a79d-b407e8ec7f99.png)

如果需要在克隆address的同时在obj2的address里添加属性及属性值，就在obj2里添加：

```
address:{
        ...obj1.address,
        city:"哈尔滨"
    }
```

ES6提供了一个特殊的API，可以使用该API在函数内部，判断该函数是否使用了new来调用：**new.target** 

该表达式得到的是：如果没有使用new来调用函数，则返回undefined

如果使用new调用函数，则得到的是new关键字后面的函数本身


![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295214081-47aa8ad6-1e5b-4415-8b61-ab87fc780c60.png)

#### 箭头函数：

在js中的this指向

1. 通过对象调用函数，this指向对象

\2. 直接调用函数，this指向全局对象

\3. 如果通过new调用函数，this指向新创建的对象

\4. 如果通过apply、call、bind调用函数，this指向指定的数据

\5. 如果是DOM事件函数，this指向事件源

**使用语法**

箭头函数是一个函数表达式，理论上，任何使用函数表达式的场景都可以使用箭头函数

完整语法：

(参数1, 参数2, ...)=>{

   //函数体

}

```
const isOdd = (num) => {
    return num % 2 !== 0;
}
```

如果参数只有一个，可以省略小括号：

参数 => {

}

```
const print = num => {
    console.log("给我的数字是：", num)
}
```

如果箭头函数只有一条返回语句，可以省略大括号，和return关键字：

参数 => 返回值

```
const isOdd = num => num % 2 !== 0;
```

如果要返回一个对象的话，返回的对象需要用（）包裹起来：

```
const sum = (a, b) => ({
    a: a,
    b: b
});
```

**注意细节**

\- 箭头函数中，不存在`this`、`arguments`、`new.target`，如果使用了，则使用的是函数外层的对应的`this`、`arguments`、`new.target`

\- 箭头函数没有原型

\- 箭头函数不能作用构造函数使用

**应用场景**

\1. 临时性使用的函数，并不会可以调用它，比如：

  \1. 事件处理函数：页面事件（onload页面加载事件（页面打开后执行），onunload页面卸载事件（页面关闭时执行）），鼠标事件，键盘事件，其他事件（多用于表单）。

  \2. 异步处理函数

  \3. 其他临时性的函数

\2. 为了绑定外层this的函数

\3. 在不影响其他代码的情况下，保持代码的简洁，最常见的，数组方法中的回调函数。

#### ES6新增的对象字面量语法：

\1. 成员速写

如果对象字面量初始化时，成员的名称来自于一个变量，并且和变量的名称相同，则可以进行简写（语法糖）

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295336927-bd43b802-9848-4be7-97ea-7b2acf60d597.png)

\2. 方法速写

对象字面初始化时，方法可以省略冒号和function关键字。（语法糖）

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295334888-115a8626-e79c-4ea4-9991-3c0204a81d86.png)

\3. 计算属性名

有的时候，初始化对象时，某些属性名可能来自于某个表达式的值，在ES6，可以使用中括号来表示该属性名是通过计算得到的。

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295341524-ac2723e5-9ca2-4ec3-b693-29de16808ece.png)

 

#### Object的新增API

\1. `Object.is`

用于判断两个数据是否相等，基本上跟严格相等（===）是一致的，除了以下两点：

1) NaN和NaN相等

2) +0和-0不相等

\2. `Object.assign`

用于混合对象

\3. `Object.getOwnPropertyNames `的枚举顺序

`Object.getOwnPropertyNames`方法之前就存在，只不过，官方没有明确要求，对属性的顺序如何排序，如何排序，完全由浏览器厂商决定。

ES6规定了该方法返回的数组的排序方式如下：

\- 先排数字，并按照升序排序

\- 再排其他，按照书写顺序排序

\4. `Object.setPrototypeOf`

该函数用于设置某个对象的隐式原型

比如： `Object.setPrototypeOf(obj1, obj2)`，

相当于： `obj1.__proto__ = obj2`

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295343546-a6e51022-44fc-4c8b-abe5-c76720d7192c.png)

#### 类：构造函数的语法糖

传统的构造函数的问题

\1. 属性和原型方法定义分离，降低了可读性

\2. 原型成员可以被枚举

\3. 默认情况下，构造函数仍然可以被当作普通函数使用![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295335567-d1b94b4d-971c-4fd2-8ff2-82a9f1308d95.png)

类的特点

\1. 类声明不会被提升，与 let 和 const 一样，存在暂时性死区

\2. 类中的所有代码均在严格模式下执行

\3. 类的所有方法都是不可枚举的

\4. 类的所有方法都无法被当作构造函数使用

\5. 类的构造器必须使用 new 来调用

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295344551-5aa2b1a2-8998-4922-81ca-5e5d98930004.png)

 

**类的其他书写方式**

\1. 可计算的成员名

\2. getter和setter

`Object.defineProperty` 可定义某个对象成员属性的读取和设置

使用getter和setter控制的属性，不在原型上

\3. 静态成员

构造函数本身的成员

使用static关键字定义的成员即静态成员

\4. 字段初始化器（ES7）

注意：

1). 使用static的字段初始化器，添加的是静态成员

2). 没有使用static的字段初始化器，添加的成员位于对象上

3). 箭头函数在字段初始化器位置上，指向当前对象

\5. 类表达式

```
const A = class { 
    a = 1;
    b = 2;
}
```

\6. [扩展]装饰器（ES7）(Decorator)

横切关注点

装饰器的本质是一个函数

**类的继承**

如果两个类A和B，如果可以描述为：B 是 A，则，A和B形成继承关系

如果B是A，则：

\1. B继承自A

\2. A派生B

\3. B是A的子类

\4. A是B的父类

如果A是B的父类，则B会自动拥有A中的所有实例成员。

新的关键字：

\- extends：继承，用于类的定义

\- super

  \- 直接当作函数调用，表示父类构造函数

  \- 如果当作对象使用，则表示父类的原型

注意：ES6要求，如果定义了constructor，并且该类是子类，则必须在constructor的第一行手动调用父类的构造函数

```
class Dog extends Animal {
    constructor(name, age, sex) {
        super("犬类", name, age, sex);
}
```

相当于之前写法的

```
function Dog(name, age, sex) {
    Animal.call(this, "犬类", name, age, sex);
}
```

如果子类不写constructor，则会有默认的构造器，该构造器需要的参数和父类一致，并且自动调用父类构造器

默认：

```
class Dog extends Animal {
    constructor(type,name, age, sex) {
        super(type, name, age, sex);
}
```

#### 对象解构

使用ES6的一种语法规则，将一个对象或数组的某个属性提取到某个变量中

**解构不会对被解构的目标造成任何影响**

1.解构

```
//从中取属性，之前 var name = user.name;
// 先定义5个变量，然后从对象中读取同名属性，放到变量中
let { name, age, sex, other } = user;
console.log(name, age, sex, other);
//Rich Brain 21 男 {country: "Indonesia", identity: "rapper"}
```

2.给属性添加默认值

```
let { name, age, sex, value = "cute", other } = user;
console.log(name, age, sex, value, other);
//Rich Brain 21 男 cute {country: "Indonesia", identity: "rapper"}
```

3.给sex添加同名属性，这时输出sex会报错no defind

```
let {name,age,sex:gender,other} = user;
console.log(name,age,gender,other);
//Rich Brain 21 男 {country: "Indonesia", identity: "rapper"}
```

4.给同名属性赋值，前提是原属性名中没有值

```
let {name:nickname = "七哥",age,sex,other} = user;
console.log(nickname,age,sex,other);
//七哥 21 男 {country: "Indonesia", identity: "rapper"}
```

5.解构other里的属性

```
let {name,other:{identity}} = user;
console.log(name,identity);//Rich Brain rapper
```

####  数组解构

数组解构与对象解构类似

1.解构

```
const numbers = ["a", "b", "c", "d"];
const [n1, n2] = numbers;
console.log(n1, n2);//a b
```

2.解构数组中的数组

```
// 得到numbers下标为4的数组中的下标为2的数据，放到变量n中
const numbers = ["a", "b", "c", "d", [1, 2, 3, 4]];
const [, , , , [, , n]] = numbers;
console.log(n);//3
```

3.给数组某个索引位添加默认值

```
const numbers = ["a", "b", "c", "d"];
const [n1, , , n4, n5 = 123] = numbers;
console.log(n1, n4, n5);//a b 123const numbers = ["a", "b", "c", "d"];
const [n1, , , n4, n5 = 123] = numbers;
console.log(n1, n4, n5);//a b 123
```

4.解构数组里的某几个值，然后剩余值放到新的数组里

```
const numbers = [324, 7, 23, 5, 3243];
// 得到数组前两项，分别放到变量a和b中，然后剩余的所有数据放到数组nums
const [a, b, ...nums] = numbers;
// const a = numbers[0], b = numbers[1], nums = numbers.slice(2);//以前的写法
console.log(a, b, nums);//324 7 (3) [23, 5, 3243]
```

5.解构数组里的对象

```
const numbers = ["a", "b", "c", "d", {
    a: 1,
    b: 2
}];
//得到numbers下标为4的数组的属性a，赋值给变量A
const [, , , , { a: A }] = numbers;//方法1
const { a: A } = numbers[4];//方法2
console.log(A)//1
```

6.解构对象里的某个属性，然后剩余属性放到新的对象里
///

```
let {name,...obj} = user;
console.log(name,obj);//Rich Brain {age: 21, sex: "男", other: {…}}
```

7.交换值

```
let a = 1, b = 2;
[b, a] = [a, b]
console.log(a, b);//2 1
```



#### 参数解构

```
//之前的写法
// function print(user) {
//     console.log(`姓名：${user.name}`)
//     console.log(`年龄：${user.age}`)
//     console.log(`性别：${user.sex}`)
//     console.log(`国家：${user.other.country}`)
//     console.log(`身份：${user.other.identity}`)
// }
function print({ name, age, sex, other: {
     country,
     identity
} }) {
     console.log(`姓名：${name}`)
     console.log(`年龄：${age}`)
     console.log(`性别：${sex}`)
     console.log(`国家：${country}`)
     console.log(`身份：${identity}`)
     }
print(user);//记得把要解构的对象传进去
```



此方法可用于ajax

![image.png](https://cdn.nlark.com/yuque/0/2020/png/2951169/1609295351614-6440dad3-255a-4990-9271-55c4e28a5b8b.png)

 

#### 普通符号

符号是ES6新增的一个数据类型，它通过使用函数 ```Symbol(符号描述)``` 来创建

符号设计的初衷，是为了给对象设置私有属性

私有属性：只能在对象内部使用，外面无法使用

**符号具有以下特点**：

\- 没有字面量

\- 使用 typeof 得到的类型是 symbol

\- 每次调用 Symbol 函数得到的符号永远不相等，无论符号名是否相同

\- 符号可以作为对象的属性名存在，这种属性称之为符号属性

  \- 开发者可以通过精心的设计，让这些属性无法通过常规方式被外界访问

  \- 符号属性是不能枚举的，因此在 for-in 循环中无法读取到符号属性，Object.keys 方法也无法读取到符号属性

  \- Object.getOwnPropertyNames 尽管可以得到所有无法枚举的属性，但是仍然无法读取到符号属性

  \- ES6 新增 Object.getOwnPropertySymbols 方法，可以读取符号

\- 符号无法被隐式转换，因此不能被用于数学运算、字符串拼接或其他隐式转换的场景，但符号可以显式的转换为字符串，通过 String 构造函数进行转换即可，console.log 之所以可以输出符号，是它在内部进行了显式转换。

 

#### 共享符号

根据某个符号名称（符号描述）能够得到同一个符号

`Symbol.for`("符号名/符号描述")  //获取共享符号**
**