---
title: JavaScript
date: 2021-11-08 15:35:53
tags: 
  - JavaScript
categories:
  - JavaScript
---

# JavaScript 历史及历程

## web 发展史

Mosaic,是互上第一个获普遍使用和能够显示图片的网页浏览器。于 1993 年问世。

1994 年 4 月，马克.安德森和 Silicon Graphics（简称为 SGI，中译为“视算科技”或“硅图”）公司的创始人吉姆·克拉克（Jim Clark）在美国加州设立了“Mosaic CommunicationCorporation”。

Mosaic 公司成立后，由于伊利诺伊大学拥有 Mosaic 的商标权，且伊利诺伊大学已将技术转让给 Spy Glass 公司，开发团队必须彻底重新撰写浏览器程式码，且浏览器名称更改为 NetscapeNavigator，公司名字于 1994 年 11 月改名为“NetscapeCommunication Corporation”，此后沿用至今，中译为“网景”。

微软的 Internet Explorer 及 Mozilla Firefox 等，其早期版本皆以 Mosaic 为基础而开发。微软随后买下 Spy Glass 公司的技术开发出 Internet Explorer 浏览器，而 Mozilla Firefox则是网景通讯家开放源代码后所衍生出的版本。

## JS 历史

JavaScript 作为 Netscape Navigator 浏览器的一部分首次出现在 1996 年。它最初的设计目标是改善网页的用户体验。

作者：Brendan Eich

期初 JavaScript 被命名为 LiveScript，后因和 Sun 公司合作，因市场宣传需要改名,JavaScript。后来 Sun 公司被 Oracle 收购，JavaScript 版权归 Oracle 所有。

## 浏览器组成

1. shell 部分——用户能操作部分(壳)

2. 内核部分——用户看不到的部分

   1 ) 渲染引擎（语法规则和渲染）

   2 ) JS 引擎

   3 ) 其他模块（如异步)

<!--more-->

## JS 引擎

2001 年发布 ie6，首次实现对 JS 引擎的优化。

2008 年 Google 发布最新浏览器 Chrome，它是采用优化后的 javascript 引擎，引擎代号 V8，因能把 JS 代码直接转化为机械码来执行，进而以速度快而闻名。

后 Firefox 也推出了具备强大功能的 JS 引擎

Firefox3.5 TraceMonkey（对频繁执行的代码做了路径优化）

Firefox4.0 JeagerMonkey

## JS 的逼格（特有特色）

```js
编译型语言: 通篇翻译后，生成翻译完的文件，程序执行翻译后的文件
代表语言 : C,C++
优点 : 快(常用于系统，游戏)
缺点 : 移植性不好（不跨平台，window 和 Linux 不能混用）

解释性语言 看一行翻译一行，不生成特定文件
代表语言 : JS,PHP，python 带尖角号
优点 : 可以跨平台
缺点 : 稍微慢点
```

```js
主流浏览器（必须有独立内核）市场份额大于 3%

// 内核名称:
IE ：trident

chrome ： webkit / blink

firefox ： gecko

opera ： presto / Blink

safari ： webkit
```

1、JS 是解释性语言：(不需要编译成文件）跨平台

java 先通过 javac，编译成.class 文件，通过 jvm（Java 虚拟机）进行解释执行
.java→java→ 编译 →.class→jvm→ 解释执行（java 可以跨平台）（java 是 oak 语言）

`<link rel = "">` 是异步加载

2、单线程：同一时间只能做一件事——JS 引擎是单线程（同一时间做很多事叫多线程）

ECMA（欧洲计算机制造联合会）标注：为了取得技术优势，微软推出了 JScript，

CEnvi 推出 ScriptEase，与 JavaScript 同样可在浏览器上运行。为了统一规格 JavaScript

兼容于 ECMA 标准，因此也称为 ECMAScript。

# 开始学习 JS

> JS 三大部分 ECMAScript、DOM、BOM`

## 如何引入 JS

1、页面内嵌`<script></script>`标签,写 head 里面也行,写 body 里面也行

```html
例:
<body>
  <script type="text/javascript">
    //告诉浏览器我们是 js
  </script>
</body>
```

2、外部 JS 文件，引入`<script src=“location.js”></script>`

例如：以 lesson.js 保存文件，再引入到 html 中,为符合 web 标准（w3c 标准中的一项）结构（html）、行为（js）、样

式（css）相分离，通常会采用外部引入。

一个文件中可以包括多个 css，js——不混用特殊写页面，大部分写在外部——不混用,如果同时写了内部的 js 和外部的 js，那么是外部的 js 文件显示出来

# js 变量

## 变量(variable)

HTML，css 不是编程语言，是计算机语言，编程语言需要有变量和函数
变量是存放东西，方便后续使用的框

## 1）变量声明

1、 声明、赋值分解

```js
 var a; //这个叫变量声明。我们向系统中申请了 var 这个框，命名叫 a,给 a 赋值 100，写作 a =100，这里不是等号是赋值

var a ；a =100；可以简化写成 var a=100；
```

2、 单一 var 声明法

```js
var a,b,c,d;————单一 var 模式

// var a = 100;                                            var a = 100;
// var a = 200;        var a,b,c,d,e;                          b = 100;
// var a = 300;   >                       >   标准写法:         c = 100;
// var a = 400;        a = 100;                                d = 100;
// var a = 500;                                                e = 100;

如写做：var a = 10；a=20;那么后面的 20 就会覆盖掉前面的 10
```

## 命名规则（用接近的英文单词）———— 起变量名一定要以英文语义化

1. 变量名必须以英文字母、\_、\$ 开头
2. 变量名可以包括英文字母、\_、\$、数字
3. 不可以用系统的关键字、保留字作为变量名

# 关键字和保留字

## 关键字（有特殊语法含义的字）

```js
    break       else        new         var
    case        finally     return      void
    catch       for         switch      while
    default     if          throw       delete
    in          try         do          instanceof
    typeof
```

## 保留字（未来可能当做关键字的词）

```js
    abstract    enum        int         short
    Boolean     export      interface   static
    byte        extends     long        super
    char        final       native      synchronize
    class       float       package     throws
    const       goto        private     transient
    debugger    implements  pritected   volatile
    double      import      public
```

# 基本语法

```js
// 下面是变量

    var a = 10;
    var b = 20;
    var c;
    c = a + b;
```

先运算等号右边的 a+b，运算完后，再赋值给左边 c
先取值，再赋值

> 运算大于赋值的优先级

js 是动态语言，动态语言基本上都是解释性语言，解释性语言基本上都是脚本语言

js 是浮点型语言（带小数点）

## 值类型（数据类型）

1、不可改变的原始值（栈数据）栈 stack
Number String Boolean undefined null
已经放进去的值不可改变，只会改房间编号为 null(硬盘原理)

```js
// Number 数字类型
var a = 123; String

// 字符串类型,语言放双引号里
例: var a=”语言”，““是空串

// Boolean 布尔数字
就两个值，false，true

// undefined：
是没有定义的，表示还没赋值,仅一个值 underfined

// null
代表空，占位用，用空值来覆盖
```

## 栈、堆

array、Object、function、...date、RegExp

原始值存于 stack(栈) 里面的

引用值存于 heap(堆) 里面的;

```js
例:
    var a =10;
    var b = a;
    a = 20;
    document.write(b);

    答案：10
    原始值是我把一个值放到另一个值里面，改了第一个值，第二个值不变
```

2、引用值（堆数据）大致上放堆 heap 里面

> array 数组, Object, function ... data,RegExp 正则

var arr = [1,2,3,4,5,false,”abc”]; //这是数组

```js

    例:
    var arr = [1];
    var arr1 = arr;
    arr.push(2);
    document.write(arr1);

    答案：arr 是 1,2。arr1 是 1,2

    引用值是把第一个值放到第二个值里面，改第一个值，第二个值也改变
    js 由值决定类型。原始值和引用值唯一的不同是赋值形式不同
```

1、 栈 stack

`先进去的东西最后出来，有底没有顶。`

> 在栈内存里面放东西，先放在底部

2、 堆 heap

> 怎么放怎么拿，散列结构

```js
    var a = 10;var b = a；是 a 先取出 10，copy 一份放到 b 里面，改变 a 的值，b 的值是不变的，再把 a=20;时 b 的值还是 10，不发生改变

    var arr = [1,2];
    var arr1 =arr;
    arr.push(3);
    答案：这往[1,2]放 3，arr 和 arr1 都是[1,2,3]

    引用值是在栈内存里面放堆的地址，拷贝的也是地址，所以改变 arr，arr1 也改变了

    var arr = [1,2];
    var arr1 =arr;
    arr = [1,3];
    document.write(arr1);
    答案：arr = [1,3];是新建了一个新的房间。arr1 是 1,2,现在是插入新引入值”房间”,
```

## js 语句基本规则

1. 语句后面要用分号结束“；”但 function test(){}，for(){}，if(){}后面都不用加分号

2. js 语法错误会引发后续代码终止，但不会影响其它 js 代码块

错误分为两种:

1. 低级错误（语法解析错误），不能写中文

2. 逻辑错误（标准错误，情有可原，错的那个执行不了）

3. 书写格式要规范，“= + / -”两边都应该有空格

## js 输出

console.log();是把信息展示（输出）在控制台

document.write();是把信息（输出）展示到网页

# js 运算符

## 一、运算操作符

### “-”，“\*”，“/“，“%”，”=“，“()”

> 运算符除了 + 号两边的是转换为字符串，其他的运算符全部是转换为 Number 数字类型的

#### +（加号）

1. “+”作用：数学运算、字符串链接

> 任何数据类型加字符串都等于字符串

```js
例 var a = “a”+ true + 1; //打印 atrue1
例 var a = 1 + “a” + 1 + 1; //打印 1a11
例 var a = 1 + 1 + “a” + 1 + 1; //打印 2a11，从左向右运算
例 var a = 1 + 1 + “a” +( 1 + 2); //打印 2a3
```

#### - \* /（减号、乘号、除号）

```js
例 var a = 0 – 1； //等于-1
例 var a = 2 * 1； //等于 2
例 var a = 0 / 0； //答案是 NaN，应该得出一个数字类型的数，但是没法表达，
就用 NaN (NaN 是 Not a Number 非数，不是数，但是是数字类型
例 var a = 1 / 0; //是 infinity
例 var a = -1 / 0; //是-infinity(无穷)
```

#### %，（摩尔，模，是取余数的意思）

```js
例 var a =5%2 //5%2 是五除二的余数，商二余一
例 var a =5%1 //是五除一的余数，结果是 0
例 var num = 1 % 5; //意思是 1 除以 5 的余数。商 0 余 1
例 var a =4%6 //是四除六的余数，结果是 4
例 var a = 4;a % = 5;document.write(a); // 4
例 var a = 0;a % = 5;document.write(a); //0
例 var a = 10;a %= 2;document.write(a); //0
例 var a = 3;a % = 4; //4
```

`优先级”=“最弱【赋值符号优先级最低】，”()”优先级较高`

### “++”，“- -”，”+=“，“-=”，“/=“，“\*=”，“%=”

#### ++（加加）

```js
例 var a = 10; a = a + 1; //结果 11
例 var a = 1;
a = a + 1;写成 a ++是一种简化形式 “++”，是自身加一，再赋值给自身
a ++ 是 a = a + 1 的简化形式

例 var a =10；document.write(++a );document.write(a); //答案 11；11
是先执行++，再执行本条语句 document.write(++a)

例 var a =1；document.write(a ++);document.write(a); //答案 1；2。是先执行
语句(document.write(a))，再++，所以第一次打印的还是 a，第二次打印 a++后的值

例 var a =10；var b=++a -1+a++;document.write(b + “ ” + a) //答案 21 12
先++a，这个时候 a=11，再-1，再加 a，b 就是 21，最后++，a 就是 12
赋值的顺序自右向左，计算的顺序自左向右（按数学来）

例 var a =1；var b = a ++ + 1；document.write(b)； //答案 2，先执行 var b =a+1，
再 a++
例 var a =1；var b = a ++ + 1；document.write(a)；document.write(b)； //答案 2，2
例 var a =1；var b = ++a + 1；document.write(a)；document.write(b)； //答案 2，3
例 var i = 1;var a = i++; //答案 a = 1; 此时 i 先将值 1 赋给 a,然后自己+1，i=2;
var b = ++i; //答案 b = 3；此时 i 先自己+1 为 3.再给 b 赋值，b=3;
```

#### --（减减）

`“--”，是自身减一，在赋值给自身`

```js
例 var a = 1;var b = a-- + -- a;document.write(b); //答案 0，先执行--a;此时 a 变成
0，然后第一个 a 也变成 0，那么 b = 0-- + --a
例 var a = 1;var b = --a + --a;document.write(b); //答案-1
例 var a = 1;document.write(a++);document.write(a); //答案 1；2
例 var a = 1;document.write(++a);document.write(a); //答案 2；2
例 var a =1; var b = a ++ +1;document.write(b); //答案 2
```

a 写在后面就后运行，先计算 a+1=2 赋值给 b 后再++

```js
例 var a = 1;var b = ++a + 1;document.write(a);document.write(b); //答案 2；3
```

#### += ， -=（加等于、减等于）

```js
例 var a =10;a ++;a ++;a ++;加十个      简化写法：a +=10;也是 a = a+10;
例 var a =10;a += 10 + 1; //答案 21
例 var a = 1;a = a + 10;等于 a+=10
a++是 a +=1 的写法
```

#### /=（除等于）

```js
例: var a = 10;
a /= 2; //答案 5，是除二赋给自身的意思
```

#### \*=（乘等于）

```js
例 var a =10;a *=2; //答案：20，是乘二赋给自身的意思
```

#### %=（模等于）

```js
例 var a=10;a%=2; //答案：0， 10 能整除 2,余数是 0,取余，余数赋给自身。
例 var a=3;a%=4; //答案：3，3 除以 4，余数为 3，余数赋给自身。
例 var a=0;a%=4; //答案：0，0 除以 4，余数为 0，余数赋给自身。
例 var a = 1;a% =10; //答案：1，1 除以 10，余数为 1，余数赋给自身。
```

**作业：**

```js
1、写出打印结果
    var a =(10 * 3 – 4 / 2 + 1)%2,b=3;b %= a + 3;
    document.write(a++);
    document.wtite(“<br>”);
    document.write(--b);
2、var a =123; var b =234;经过计算交换 a，b 的值

作业答案
1、 document.write(a++);是 1（先打出 1 再++）
    document.write(--b);是 2
    b % =a + 3,的模等于 4，除不开再赋值给 b，b 还是 3

2、 方法一普通方法：var c = a; a = b; b = c;document.write(a ,b);

    方法二 a = a + b; b = a – b; a = a – b; document.write(a ,b);
```

## 二、比较运算符

> “>”，”<”，”==”，“>=”，“<=”，”!=”比较结果为 boolean 值

但凡是运算符，都是要有运算的

用到布尔值，true 或 false

字符串的比较，比的是 ASCII 码（七位二进制 0000000）

### >， <（大于、小于）

```js
例 var a = "a">"b";document.write(a); //答案是 false
例 var a = 1 > 2;document.write(a); //答案是 false
例 var a = 1 < 2;document.write(a); //答案是 true
例 var a = "1">"8";document.write(a); //答案是 false
例 var a = "10">"8";document.write(a); //答案 false，不是十和八比，是字符串一
零和八比，先用开头的一和八比，比不过就不看第二位了；一样的就拿零和八比
例:
    var a = 123;document.write(a); //答案 false
    运算结果为真实的值
```

### ==，等于

```js
例 var a = 1 == 2; //答案是说 1 等不等于 2，因为 1 肯定不等于 2，所以值为 false
例 var a = NaN == NaN; //答案是 false，NaN 不等于任何东西，包括他自己
例 var a = undefined == underfined; //答案是 true
例 var a = infinity == infinity; //答案是 true
例 var a = NaN == NaN; //答案是 false。非数 NaN 是不等于自己的
```

> **NaN 得不出数，又是数字类型，就是 NaN**

### >=、<=、!=（大于等于、小于等于、非等于）

```js
比较结果为 boolean 值：true 和 false
```

## 三、逻辑运算符：“&&”，“||”，“!“运算结果为真实的值

### “&&”与运算符（与、并且）

> 两个表达式：先看第一个表达式转换成布尔值的结果是否为真，如果结果为真，那么它会看第二个表达式转换为布尔值的结果，然后如果只有两个表达式的话，只看第二个表达式，就可以返回该表达式的值了，如果第一位布尔值为 false，不看后面的，返回第一个表达式的值就可以了

`运算符就是要求结果`

```js
例 var a = 1 && 2;  //答案 2，如果第一位 1 为真，结果就为第二位的值 2
例 var a = 1 && 2 + 2; //答案 4，如果 1 为真，结果就为 4
例 var a = 0 && 2 + 2; //答案 0
例 var a = 1 && 1 && 8; //答案 8，先看第一个是否为真，为真再看第二个，

中途如果遇到 false，那就返回 false 的值

例 var a =1 + 1 && 1 – 1;document.write(a); //答案 0

```

`如果是三个或多个表达式，会先看第一个表达式是否为真，如果为真，就看第二个表达式，如果第二个也为真，就看第三个表达式（如果为真就往后看，一旦遇到假就返回到假的值），如果第三个是最后一个表达式，那就直接返回第三个的结果`

> 如果第一个是假，就返回第一个值，当是真的时候就往后走，一旦遇到假，就返回被认定为 false(假) 的值：转换为布尔值会被认定为 false 的值 undefined， null， NaN， “”（空串）， 0， false

```js
2 > 1 && document.write(‘成哥很帅’) //意思是如果 2 大于 1，那么就打印成哥很帅，如果前面真才能执行后面的（相当于短路语句使用）
&& 与 运算符是有中断作用的，当短路语句使用(如果。。那么。。)

var data = ...; //执行一个语句，会用到 data
data&&执行一个语句全用到 data
data && function(data);
```

### &与运算 我们一般不用

```js
例 var num = 1 & 2;document.write(num); //答案 0
例 var num = 1 & 1;document.write(num); //答案 1
例 var num = 1 & 3;document.write(num); //答案 1
```

1. 上下一与，不同为 0，相同为 1

- 在二进制中，是 1（为了对齐补的 0） 0 1
- 在二进制中，是 11 1 1
- 运算结果 0 1

### “||”或运算符（或者）

```js
例 var num = 1 || 3; //答案 1
例 var num = 0 || 3; //答案 3
例 var num = 0 || false; //答案是 false
```

`看第一个表达式是否为真，如果为真，则返回第一个值，碰到真就返回`

`如果第一个表达式是假，就看第二个表达式，如果第二个是最后一个，就返回第二个的值`

`关注真假的说法：全假才为假，有一个真就为真`

```js
例 var num = 0 || false || 1; document.write(num); //答案 1
例:
    div .onclick = function(e){
    非 IE 浏览器直接取 e 值

    var event = e;
    IE 浏览器存在 window.event;
    }

    写成下面这样就解决了兼容性。在所有的浏览器中都好使
    div .onclick = function(e){var event = e || window.event;}
```

### “!“非运算符，否的意思

先转成布尔值，再取反

```js
例 var a = !123; document.write(a); //答案 false。123 的布尔值是 true，取反是 false
例 var a = !"";  document.write(a); //答案 true。空串””布尔值是 false，取反是 true
例 var a = !!""; document.write(a); //答案 false，取反后，再反过来，结果不变
例 var a = true; a =!a; document.write(a) //答案 false，自身取反，再赋值给自身
```

`!=（非等于）是表达它们不等于`

`被认定为 false 的值：转换为布尔值会被认定为 false 的值 undefined， null， NaN，""（空串）， 0， false`

## , （逗号）操作符

```js
var a = (1 - 1, 1 + 1);
答案：2；

逗号操作符，这种情况，会先看一眼1，再看一眼2，然后返回2，就是2
var f = (
    function f(){
        return '1';
    },
    function g(){
        return 2;
    }
)();
typeof f;
// 在控制器中输出：
// >  1,2
// <· 2

// >  var num = (1,2);
// <· 2

，逗号 是一个运算符，由于有 括号() 的加持，所以先执行 (，逗号运算符)

逗号 操作符的意思是先看前面的表达式，如果前面的表达式需要‘计算’的话，可以先计算，然后在计算后面的表达式(如果后面的表达式用计算的话)，都计算完之后，把后面的表达式计算结果返回回去。
```

# 条件语句

## 一、If 语句 if、if else if if <—> && 转换

`if(条件判断){ 当条件成立时，执行里面的执行语句 } 当 if() 中的条件成立时，才能执行{}内的语句 当条件转化为布尔值，如果为 true 就执行；如果为 false 就不执行`

### **|| 放在 if 中是或者的意思，有一个是真就可以了**

```js
例 if(1 < 2){document.write(“老邓很丑”);}
例 if ( 1 > 0 && 8 > 9){}
```

### **&&放在 if 中的，全真才为真，&&是并且的意思**

```js
例 if ( 1 > 0 || 8 > 9){}
```

### **if 和&&的互相转化**

```js

```

```html
<!--
    90一100       alibaba
    80一90        tencent toutiao meituan 滴滴
    70一80        baidu eleme xiecheng 58赶集
    60一70        蘑菇街
    60以下        你肯定不是我教的!!!
-->

<script type="text/javascript">
  var score = parseInt(window.prompt("input"));

  if (score > 90 && score <= 100) {
    document.write("alibaba");
  }
  if (score > 80 && score <= 90) {
    document.write("tencent");
  }
  if (score > 70 && score <= 80) {
    document.write("baidu");
  }
  if (score > 60 && score <= 70) {
    document.write("mogujie");
  }
  if (score < 60) {
    document.write("Oh my god!!! ");
  }
</script>
```

`不能写 (90 < score < 100),这样写会先比 90 < score,等于 true 以后再跟 100 比`

`else if 满足了第一条就不看第二条了，用 else if 要满足条件与条件之间互斥，不能有交叉点。除了上面所有以外的。else if 除了这个以外，满足第一个就不看了，不满足就看后面的`

```html
<!--
    else if 除了这以外在看这个满不满足。满足条件后就不看了，上面的写法不够简洁
    下面 是 上面这个条件的补集
 -->

<script type="text/javascript">
  var score = parseInt(window.prompt("input"));

  if (score > 90 && score <= 100) {
    document.write("alibaba");
  } else if (score > 80 && score <= 90) {
    document.write("tencent");
  } else if (score > 70 && score <= 80) {
    document.write("baidu");
  } else if (score > 60 && score <= 70) {
    document.write("mogujie");
  } else if (score < 60) {
    document.write("Oh my god!!! ");
  }
</script>
```

### **&&和 || 比较常用在条件判断中**

```js
    if(1 > 2){
        document.write('a');
    }

    上面与右边效果完全一样 1 > 2 && document.write('a');
```

## 二、for 循环(for 循环不固定，非常灵活)

> 格式 for (var i = 0; i < 10; i++) { }

`for 是关键字，（）括号里面三个语句用两个分号隔开，{}里面是循环体`

```js
// 打印十个 a，写成：

for (var i = 0; i < 10; i++) {
  document.write("a");
  document.write("a");
  document.write("a");
  document.write("a");
  document.write("a");
  document.write("a");
  document.write("a");
  document.write("a");
  document.write("a");
  document.write("a");
}
```

`执行顺序如下`

```js
1) var i = 0;

2) if(i < 10){
    document.write(‘a’)
}
// 把条件判断放到 if 里面,条件判断成立，就执行{}中间的执行体

3) i ++
// 看 i++，此时 i 变成 1，i = 1；

4) if(i < 10){
    document.write(‘a’)
}
// 把条件判断放到 if 里面,条件判断成立，就执行{}中间的执行体

5) i ++
// 看 i++，此时 i 变成 1，i=1；
——————如此反复
```

```js
先执行一遍(1)，
判断(2)执行语句成不成立，条件成立就执行(3),
判断(2)执行语句成不成立，条件成立就执行(3),
......当有一次判断不成立，就停止
```

> 因为看的是执行顺序，写外面也可以，执行顺序是一样，打印十个 a，也可以写成：

```js
var i = 0;
for (; i < 10; ) {
  document.write("a");
  i++;
}
```

```js
// 打印十个 a 也可以写成:
// 1.
var i = 1;
var cout = 0;
for (; i; ) {
  document.write("a");
  count++;
  if (count == 10) {
    i = 0;
  }
}

// 2.
var i = 1;
for (; i; ) {
  document.write("a");
  i++;
  if (i == 11) {
    i = 0;
  }
}
```

```js
// 例:打印 0-9:

for (var i = 0; i < 10; i++) {
  document.write(i);
}
```

```js
// 求 0-9 的和

var count = 0;
for (var i = 0; i < 10; i++) {
  count += i;
  document.write(count + " ");
}
```

```js
// 打印 100 以内能被 3 整除，或者能被 5 整除，或者能被 7 整除的数：

var i = 1;
var count = 0;
for (i = 0; i < 10; i++) {
  if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
    document.write("i" + " ");
  }
}
```

```js
// 用 for 循环打印一百个数

for (var i = 0; i < 100; i++) {
  document.write(i + " ");
}
```

```js
// for 循环中的三句只能写一句，打印 100 个数：

var i = 0;
for (; i < 100; ) {
  document.write(i + " ");
  i++;
}
```

```js
// for 循环中的函数体里面只能写一句，打印 100 个数：

var i = 100;
for (; i--; ) {
  document.write(i + " ");
}
```

## 三、while, do while

### while 循环

`while 循环是 for 循环的简化版 for( ； ； ){}，while 循环底层机制是 for 循环。`

`for ( ; 只在这一部分写，前后不写 ; ){}`

```js
var i = 0;
for (i = 0; i < 10; i++) {
  document.write(i + " ");
}

上下这两个完全相等;

var i = 0;
while (i < 10) {
  document.write(i + " ");
  i++;
}
```

```js
// 死循环 never-ending loop 无限循环

while (1) {
  document.write(i);
  i++;
}
```

```js
// 例打印一百以内，7 的倍数就输出

var i = 0;
while (i <= 100) {
  if (i % 7 == 0) {
    document.write("i" + " ");
  }
  i++;
}
```

```js
// 例打印一百以内，7 的倍数或逢 7 就输出

var i = 0;
while (i <= 100) {
  if (i % 7 == 0 || i % 10 == 7) {
    document.write(i + " ");
  }
  i++;
}
```

### do while 循环

`do while 是不管满不满足条件都会先执行一次，再判断成不成立，如果成立才会执行 第二次，不成立就停止, 一般没人用`

```js
do {
  document.write("a");
  i++;
} while (i < 10);
```

## 作业

- （先找规律，再写出来） 提示：var n = parseIn(window.prompt('input'));

- JS 可以进行浮点计算

1. 计算 2 的 n 次幂，n 可输入，n 为自然数。
2. 计算 n 的阶乘，n 可输入。即 5！=5*4*3*2*1，最好写个 if
3. 著名的斐波那契额数列(这个数列从第 3 项开始，每一项都等于前两项之和) 1 1 2 3 5 8 输出第 n 项
4. 编写一程序，输入一个三位数的正整数，输出时反向输出。如：输入 456,输出 654
5. 输入 a,b,c 三个数字，打印出最大的。
6. 打印出 100 以内的质数（从 1 除到他本身，只能有两个因数）

## 作业答案

1、原有结果 \* 2,mul 是存上一个数的结果

```js
<script type="text/javascript">
    var n = parseInt(window.promt("input"));
    var mul = 1;
    for(i = 0;i < n;i ++){
        mul *= 2;
    }
    document.write(mul);
</script>
```

2、计算 n 的阶乘，n 可输入。即 5！=5*4*3*2*1，最好写个 if

```js
<script type="text/javascript">
    var n = parseInt(window.promt("input"));
    var mul = 1;
    for(i = 1;i <= n; i ++){
        mul *= i;
    }
    document.write(mul);
</script>
```

3、斐不那契数列 第六位是四次运算，第七位是五次运算（第三位=第一位+第二位） 第一次计算的完整过程是把第一位和第二位相加，等于第三位，并且把游标向后挪 一位。下面 for（里面的 i 是控制循环圈数的）

```js
<script type="text/javascript">
    var n = parseInt(window.prompt("input"));
    var first = 1;
        second = 1;
        third;
    if(n > 2){
        for(var i = 0; i < n - 2; i ++){
            third = first + second;
            first = second;
            second = third;
        }
        document.write(third);
    }else{
        document.write(1);
    }
</script>
```

4、取模除减。先把 456 提出出来，再反过来。6 是取模除减%10 余 6。再用 456 减 6， 剩下 450；450%100 是 50，50 除以 10，取出 5，450-50 剩下 400；400%100，再反着乘一遍，十位乘以 10，百位乘以 100。（中间的位数其实可以不动）

5、输入 a,b,c 三个数字，打印出最大的。

```js
var a = parseInt(window.prompt("input"));
var b = parseInt(window.promot("input"));
var c = pars0eInt(window.prompt("input"));

if (a > b) {
  if (a > c) {
    document.write(a);
  } else {
    document.write(c);
  }
} else {
  if (b > c) {
    document.write(b);
  } else {
    document, write(c);
  }
}
```

6、有一个判断质数的算法,看看每一个 i 是不是质数,从自身开始除一直除到 1，只能被自己和 1 整除，只能整除 2 次

```js
var count = 0;
for (var i = 1; i < 100; i++) {
  // 看一看每一个 i 是否是质数
  for (j = 1; j <= i; j++) {
    if (i % j == 0) {
      count++;
    }
  }
  if (count == 2) {
    document.write(i + " ");
  }
  count = 0;
}
```

`以下是最简单的方法：从 1 到 10 能整除，除平方数以下的`

```js
var count = 0;
for (var i = 1; i < 100; i++) {
  // 看一看每一个 i 是否是质数
  for (j = 1; j <= Math.sqrt(i); j++) {
    if (i % j == 0) {
      count++;
    }
  }
  if (count == 1) {
    document.write(i + " ");
  }
  count = 0;
}
```

# 条件语句补充

## 一、switch case 条件判断语句

```js

if(条件判断)

switch(条件){
    case 写条件：里面判是否相符：
        如果相符合就执行 case 后面的语句比如 console.log(‘a’)
}
```

`switch 不负责任，如果判断了 a 是符合条件的，也会把后面的连带打印出来`

`加个 break，就可以终止语句`

```js

    <script type="text/javascript">
        var n = 2;
        switch(n){
            case "a":
                console.log("a");
            case 2:
                condole.log("b");
            case true:
                condole.log("c");
        }
    </script>
```

`switch 找到满足要求的语句后，后面的语句虽然不判断了，但是也会执行出来`

`加个 break，就可以终止 swich case 语句`

```js


    <script type="text/javascript">
        var n = 2;
        switch(n){
            case "a":
                console.log("a");
                break;
            case 2:
                condole.log("b");
                break;
            case true:
                condole.log("c");
                break;
        }
    </script>
```

> 例 if( score == 90){}else if ( score == 100){}

```js


    <script type="text/javascript">
        var date = window.prompt("input");
        switch(date){
            case "monday":
                console.log("working");
                break;
            case "tuesday":
                console.log("working");
                break;
            case "wednesday":
                console.log("working");
                break;
            case "thursday":
                console.log("working");
                break;
            case "friday":
                console.log("working");
                break;
            case "周六":
                condole.log("relaxing");
                break;
            case "周日":
                condole.log("relaxing");
                break;
        }
    </script>
```

> 简化写法:

```js

    <script type="text/javascript">
        var date = window.prompt("input");
        switch(date){
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
                console.log("working");
                break;
            case "周六":
            case "周日":
                condole.log("relaxing");
                break;
        }
    </script>
```

## 二、break 的标准定义是终止循环，break 必须要放在循环里面，switch, for,while 都是循环

```js

    var i = 0;

    while(1){
        i ++;
        console.log(i);
        if(i > 100){
            break;
        }
    }
```

`break 终止的是 while，对 if 没有影响`

```js
从 0 开始加，加到 100 以上就停止

var i = 0;
var sum = 0;
for(var i = 0; i < 100; i++){
    sum += i;
    console.log(i);
    if(sum > 100){
        break;
    }
}
```

## 三、continue 继续、终止本次循环，来进行下一次循环

终止本次循环，后面的都不执行了，来进行下一次的循环

js 里面是没有 goto 的，c 语言里面有

```js
例:
当 i 是 7 的倍数，或尾数是 7 的时候，不打印
for ( var i = 0; i < 100; i++){
    if( i % 7 == 0 || i % 10 == 7){
    }else{
        console.log(i);
    }
}
```

> 下面写法更好

```js
例: for (var i = 0; i < 100; i++) {
  if (i % 7 == 0 || i % 10 == 7) {
    continue;
  }
  console.log(i);
}
```

# 初识引用值

## 一、数组（下面方括号的），arr =也是数组

```js
例
var arr = [1,2,3,4,5,6,7,”abc”,undefined];
arr [0] 代表查数组的第一位，因为数字是从 0 开始的算的
arr [0] = 3; 是指把数组的第一位改成 3，显示 3,2,3,4,5,6,7, ”abc”,undefined
arr.length;是数组的长度，有多少位就有多少
console.log(arr.length); //答案是 8 位
```

1.**利用 for 循环把数组中的每一位都拿出来——遍历**

```js
var arr = [1, 2, 3, 45, 5, 7, "abc", undefined];

for (var i = 0; i < arr.letter; i++) {
  console.log(arr[i]);
}
```

2.**把数组中的每一位都改成 1**

```js
var arr = [1, 2, 3, 45, 5, 7, "abc", undefined];

for (var i = 0; i < arr.length; i++) {
  arr[i] = 1;
}
```

3.**把数组中的每一位都加 1**

```js
var arr = [1, 2, 3, 4, , 5, 9, 10];

for (var i = 0; i < arr.length; i++) {
  arr[i] += 1;
}
```

## 二、对象 object

> 面向对象的编程方法

```js
var obj = {
    里面存属性和方法
    key 属性名：value 属性值;
}
```

`在{}面用。属性与属性之间用逗号隔开`

`属性值可以双引号或单引号；属性名是为了方便找到他，只是一个辅助`

```js

    var deng = {
        lastName : "Deng",
        age : 40,
        sex : undefined,
        wife : "xiaoliu",
        father : "dengdaye",
        son : "xiaodeng",
        handsome :false
    }
    console.log(deng.lastName); //取值方式 deng.lastName
赋值 deng.lastName = “old deng”;
    console.log(deng.lastName);
```

# 编程形式的区别

`面向过程，如 c (第一步干嘛，第二步干嘛)`

`面向对象（对象 object） （现在 js 是一半面向过程，一半面向对象，前面学的都是面向过程）`
``

# typeof 操作符

> typeof 能返回的六种数据类型（区分数字类型）

`number、string、boolean、undefined、object、function`

```js
例 var num = 123;console.log(typeof(num)); //返回 number
```

`写成 console.log(typeof num );也可以,不过最好加括号`

```js
例 var num = {}; console.log(typeof(num)); //泛泛的引入值都返回 object
例 var num = [];console.log(typeof(num)); //泛泛的引入值都返回 object
例 var num = null;console.log(typeof(num)); //答案 null 返回 object，最早是代替空对象的
例 var num = undefined;console.log(typeof(num)); //答案返回 undefined
例 var num = fuction(){};console.log(typeof(num)); // 答案返回 function
```

# 类型转换

```js

例 var num = 1 +“1”; //显示 11
例 var num = 1 *“1”;console.log(typeof(num) + “:” + num); //显示 number:1
例 var num = 1 -“1”;console.log(typeof(num) + “:” + num); //显示 number:0
例 var num = “2” -“1”;console.log(typeof(num) + “:” + num); //显示 number:1
例 var num = “2” *“1”;console.log(typeof(num) + “:” + num); //显示 number:2
```

> 以上例子说明 js 有类型转换

## 一、显示类型转换

### Number(mix) 是想把里面的东西转换成数字

```js

例:
    var num = Number(‘123’);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:123，把字符串类型的 123 转换成了 number 类型
例:
    var demo = “123”;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:123，上面那一行的 Number 是为了把()里面转换成数字类型
例:
    var demo = true;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:1
例:
    var demo = false;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:0
例:
    var demo = null;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:0
例:
    var demo = undefined;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:NaN
例:
    var demo = “abc”;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:NaN
例:
    var demo = “-123”;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:-123
例:
    var demo = “123abc”;
    var num = Number(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 Number:NaN
```

### parseInt(string,radix)

> parse 是转化，Int 是整型，整数，目的是把里面转换成整数

```js
例:
    var demo =”123”;
    var num = parseInt(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number:123
例:
    var demo = true;
    var num = parseInt(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: NaN
例:
    var demo = false;
    var num = parseInt(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: NaN
例:
    var demo = 123.9;
    var num = parseInt(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 123，此处是直接去掉小数，不是四舍五入
例:
    var demo = “10”;
    var num = parseInt(demo ,16);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 16
```

> var num = parseInt(demo ,radix); //radix 是基底的意思

**radix 写成 16，系统会认为是以 16 进制为基底， 10（一零）是 16 进制的一零，是
以 16 进制为基底，把他转成为 10 进制的数字（就是 16），上面是以目标进制为基底，
转换成十进制（radix 范围是 2-36）**

```js
例
    var demo = “3”;
    var num = parseInt(demo ,2);
    console.log(typeof(num) + “:” + num);
    答案显示 number: NaN
例
    var demo = “b”;
    var num = parseInt(demo ,16);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 11
例
    var demo = “123abc”;
    var num = parseInt(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 123
例
    var demo = “100px”;
    var num = parseInt(demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 100
```

> parseInt 从数字类开始看，看到非数字类为止，返回原来的数

### parseFloat(string)

> parseFloat(string)转换成浮点数字，就是正常小数

```js
例:
    var demo = “100.2”;
    var num = parseFloat (demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 100.2
例:
    var demo = “100.2.3”;
    var num = parseFloat (demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 100.2
例:
    var demo = “100.2abc”;
    var num = parseFloat (demo);
    console.log(typeof(num) + “:” + num);
    答案显示 number: 100.2
```

> parseFloat 从数字类开始看，看到除了第一个点以外的非数字类为截止，返回前面的数

### toString

> 把 谁 变成字符串类型 (以 10 为基底转换为目标进制)（undefined 和 null 不可以用 toString 方法）；

```js
例
    var demo = 123;
    var num = demo.toString();
    console.log(typeof(num) + “:” + num);
    答案显示 string: 123。相当于把 123 转换字符串。
```

> 想把谁转换成字符串，就写成谁.toString，上面是想把 demo 转换成 toString，写成 demo.toString

```js
例:
    var demo = undefined;
    var num = demo.toString();
    console.log(typeof(num) + “:” + num);
    答案显示报错，undefined 和 null 不能用 toString
例:
    var demo = 123;
    var num = demo.toString(8);
    console.log(typeof(num) + “:” + num);
    答案 173，把 123 转成为八进制
```

> 这里的 radix 意思是以十进制为基底，转换成目标进制（即 8 进制）

```js
例:
    var demo = 10;
    var num = demo.toString(8);
    console.log(typeof(num) + “:” + num);
    答案 12
例:
    var demo = 20;
    var num = demo.toString(8);
    console.log(typeof(num) + “:” + num);
    答案 24。以十进制为基底，把 20 转换成 8 进制，就是 24
例:
    给你一个二进制的数，转换成十六进制，是先从二进制到十进制再到十六进制
    var num = 10101010;
    var test = parseInt(num, 2);
    console.log(test.toString(16));
    答案 aa
例:
    var num = 10000;
    var test = parseInt(num, 2);
    console.log(test.toString(16));
    答案 10
```

### String(mix)

> String(mix)转换成字符串，写什么都成了字符串

```js
例:
    var demo = 123.234;
    var num = String (demo);
    console.log(typeof(num) + “:” + num);
    答案显示 string: 123.234

例:
    var demo = undefined;
    var num = String (demo);
    console.log(typeof(num) + “:” + num);
    答案显示 string: undefined
```

### Boolean()

> Boolean()转换成布尔值 false 和 true

```js
例:
    var demo = “”;
    var num = String (demo);
    console.log(typeof(num) + “:” + num);
    答案显示 boolean: false
```

### toFixed

> toFixed 就是保留小数点几位

```js

var var num = 123.456789
console.log(num.toFixed(3));
效果：
num = 123.457(四舍五入)

```

## 二、隐式类型转换

1. 隐式类型转换是跟你转换了也不知道

2. 隐式类型转换内部隐式调用的是显示的方法

3. 隐式类型转换包括 isNaN () ，++，--， +/-（一元正负），+，\*，% ，，&&，|| ，！，<，>，<= ，>= ，== ，!=

### isNaN ();

> isNaN ();当你把一个数放到()里，它能判断是不是 NaN，先比括号里面的放到 number 里面转换，然后返回来

```js
例 console.log(isNaN(NaN); //答案 true
例 console.log(isNaN(“123”); //答案 false
例 console.log(isNaN(“abc”); //答案 true。会调用 number，先把“abc”
```

> 放 number 里面转换，通过 number 的转换再和 NaN 比对，如果相等就是 true

```js
例 console.log(isNaN(null); //答案 false，在 number 里面放 null 是 0，不是 NaN
例 console.log(isNaN(undefined); //答案 true
```

### ++/--（加加减减） +/-（一元正负）

1. ++/--（加加减减）

```js
例:
    var a = “123”;
    a ++;
    答案 124，++这个符号放到这里，还没运算之前，先把前面的 a 转换成 number 的 123
例:
    var a = “abc”;
    a ++;
    答案 NaN
```

2. +/-（一元正负）

> +a;-a;正 a 和负 a 都会变换成数字

```js
例 var a =+"abc";
console.log(a + “:” + typeof(a));
答案 NaN:number。
```

> 尽管转换不成数字，也会转换成数字类型，因为里面隐式的调用了一个 number

### +

> +隐式类型会转换成 string，当加号两侧有一个是字符串，就用调用 string，把两个都变成字符串

```js
例 var a = "a" +1
console.log(a + ":" + typeof(a));
```

### \* , %

> \*和% 乘和模都会转换成 number

```js
例:
    var a = "1" *1; console.log(a + ":" + typeof(a));
    答案 1：number
例:
    var a = ":" *1; console.log(a + ":" + typeof(a));
    答案 1：number，先是 number("a")的结果乘以 number(1)的结果，最后是 NaN*1，还是 NaN，但是数据类型是 number
```

### && || !

> 与或非，都是有类型转换的，不过是返回的是表达式的值，不是隐式类型转换的值，但是判断是一个类型转换的值

### < ， > ， <= ， >=

```js
例:
    var a =1 > “2”; console.log(a + “:” + typeof(a));
    答案 false:boolean，有数字相比较的，就会隐士类型转换成数字类型
例:
    var a =”3” > “2”; console.log(a + “:” + typeof(a));
    答案这个没类型转换，这个比的是 ASCⅡ
例:
    var a =”3” > 2; console.log(a + “:” + typeof(a));
    答案 true：boolean 会转换成数字，因为数字优先
```

### == ， ! ， =

```js
例:
    var a = 1 == “1”; console.log(a + “:” + typeof(a));
    答案 true:boolean，也有隐士类型转换
例:
    var a = 1 == true; console.log(a + “:” + typeof(a));
    答案相等
```

！= 也是这样
特殊东西，在控制台操作

```js
例: false > true; //答案 false，会先转换成数字，0>1 当然是错的
例: 2 > 1 > 3; //答案 false
例: 2 > 3 < 1; //答案 true
例: 10 > 100 > 0; //答案 false
例: 100 > 10 > 0; //答案 true
```

> 以上都是挨个算的，先看前面的是 true 还是 false，再和后面的比，不是顺着下来

```js
例: undefined > 0; //答案 false
例: undefined == 0; //答案 false
例: undefined < 0; //答案 false
例: null > 0; //答案 false
例: null == 0; //答案 false
例: null < 0; //答案 false
例: undefined == null; //答案 true
例: NaN == NaN; //答案 false，NaN 是唯一一个连自己都不等于的
```

## 三、不发生类型转换

### ===绝对等于（三个等号） !==绝对不等于

```js

例 1 === 1 //答案 true
例 1 === “1” //答案 false
例 1 !== “1” //答案 true
例 1 !== 1 //答案 false
例 NaN =NaN //答案 false 特殊的
例 console.log(a); //如果定量没定义就直接访问，就 a is not defined 报错；
```

> 有一种特殊情况，当且仅当把未定义的变量放到 console.log(typeof(a));里面就访问，
> 不报错，返回 undefined

```js

例 console.log(typeof(a)); //答案 undefined，这个 undefined 是字符串
例 console.log(typeof(typeof(a))); //答案 string。console.log(typeof(typeof(a)));
```

`可以先解析成 console.log(typeof(“undefined”));再返回一次就是 string 字符串`

`上面考的是 typeof(a)返回的六种类型的值（number、string、boolean、undefined、object、function）都是 undefined 字符串`

```js
作业
例 alert(typeof(a)); //返回 string
例 alert(typeof(undefined)); //返回 string，undefined
例 alert(typeof(NaN)); //返回 number
例 alert(typeof(null)); //返回 object
例 var a = “123abc”; //返回 string
例 alert(typeof(+a)); //返回 number，NaN
例 alert(typeof(!!a)); //返回 boolean
例 alert(typeof(a + “”)); //返回 string
例 alert(1 == “1”); //显示 true
例 alert(NaN == NaN); //显示 false
例 alert(NaN == undefined); //显示 false
例 alert( “11” + 11); //显示 1111
例 alert( 1 === “1”); //显示 false
例 alert(parseInt(“123abc”)); //显示 123【parseInt 是截断数字】
例 typeof(typeof(a)); //返回 string
例 var num = 123123.345789;alert(num.toFixed(3));
答案 123123.346【toFixed(3)是保留三位小数的意思，四舍五入】

提示：
alert(‘a’);就是弹出框，相当于 console.log
```

# 函数 function

> function 随便起个名(){}

```js
例: if (1 > 0) {
  function test() {
    document.write("a");
    document.write("a");
    document.write("b");
    document.write("b");
    document.write("c");
    document.write("c");
  }
}
if (2 > 0) {
  document.write("a");
  if (1 > 0) {
    document.write("b");
    test();
    document.write("c");
  }
}
if (2 > 0) {
  if (3 > 0) {
    test();
    document.write("a");
  }
  document.write("b");
  document.write("c");
}
```

1. **以上情况就是偶合，偶合度非常高，偶合代码就是低效代码**
2. **编程讲究高内聚，弱偶合**
3. 右上方是简便写法：可以用 test 调用执行，写几个 test 就调用执行几次

```js
<script type="text/javascript">
    function test(){
        var a = 123;
        var b = 234;
        var c = a + b;
        document.write(c);
    }

    test()
</script>

答案 357。写了一个 test（）；就执行了一遍函数语句，如果不写 test（）；就相当于
有一个框来存东西，但是不执行
```

```js

例:
    function test (){
    document.write(‘hello world’);
    }
    test();
```

> 函数 function 可以先定义功能，之后再去用

## 一、定义

### 函数声明

> 定义一个函数可以先写一个 function,函数就是另一个类型的变量

我声明一个函数 test,test 是函数名。写成下面

```js
function test() {
  函数体;
}
```

> 函数名起名：开发规范要求，函数名和变量名如果由多个单词拼接，必须符合小驼峰原则（第一个单词首字母小写，后面的首字母大写）

```js

例 function theFirstName(){}
document.write(theFirstName);
答案 function theFirstName(){}。打印出来的是函数体
```

> 这与 c 语言和 c++，他们打印指针，会输出指针的地址，而 js 这种弱数据语言（解释性语言）永远不输出地址，输出地址指向房间

### **函数表达式**

```js

例:
    var test = fuction test (){
    document.write(‘a’);
    }
    test();
答案 a。这种方式像定义一个变量
```

> 上面这种方式，可以演变成第三种，匿名表达式【不写 test 这种函数名】

#### **命名函数表达式**

```js

例 var demo = fuction abc(){
document.write(‘a’);
}
```

- 上面这个函数的函数名 name 是 abc

- 在控制台 console 直接输出 test 就会出现 →

- 在控制台 console 直接输出 abc 会报错，表达式就会忽略他的名字 abc。

- 在上面例子中，fuction abc(){document.write(‘a’);}这一部分叫表达式，是会忽略 abc 这个地方的名字，会变成匿名函数表达式，不如直接写成匿名函数

#### **匿名函数表达式（常用，一般说的函数表达式就是匿名函数表达式）**

```js
function test() {}
```

## 二、组成形式

### 函数名称

function test(){}其中 function 是函数关键字，test 是函数名，必须有(){}，参数可有可
没有，参数是写在()括号里面的。

如果写成 function test(a，b){}，相当于隐式的在函数里面 var a，var b 申明了两个变
量，（）括号里面不能直接写 var

```js
例 function test(a, b){
 document.write(a + b)
}
test(1, 2)
答案 3。
```

> 上面这个例子，1 就会到 a 里面去，2 就会到 b 里面去，这是传参的形式

### 参数(可有可没有，但是高级编程必有)

`形参（形式参数）：指的是 function sum（a，b）{}括号里面的 a 和 b`

`实参（实际参数）：指的是 sum（1，2）；里面的 1，2`

`天生不定参，形参可以比实参多，实参也可以比形参多`

```js

    function sum(a,b){
        var c = a + b;
        document.write(c);
    }
    sum(1,2);
    sum(3,4);

答案 37，参数把函数抽象了，可以组成很多形式
```

```js
例:
    如果第一个实参的数大于 10，就减第二个数的运算结果；如果第一个实参的数小于 10，就加第二个数的运算结果
    //function test(){}
    // 形式参数 ———— 形参
    funtion sum(a,b){
        if(a > 10){
            document.write(a - b);
        }else if(a < 10){
            document.write(a + b);
        }else{
            document.write(10);
        }
    }

    // 实际参数 ———— 实参
    sum(1,2）
    答案：3

    上面改成sum(11,2)    //答案 9


    function sum(a,b){
    document.write(a);
    }
    sum(11, 2, 3)
答案 11


    function test(a, b, c,d) {
    document.write(a);
    document.write(d);
    }
    sum(11, 2, 3)
答案 11,undefined，上面这道题是形参多，实参少
```

js 参数不限制数量，天生不定参数

在每一个函数里面都有一个隐式的东西 arguments 这个是实参列表

```js
例:
    function test(a) {
        console.log(arguments);
        console.log(arguments.length);
    }
    sum(11, 2, 3)
答案[11, 2, 3]，3

例:
    function test(a) {
        for(var i = 0; i < argument.length; i++){
        console.log(arguments[i]);
        }
    }
    sum(11, 2, 3)
答案 11,2,3
```

```js
function sum(a,b,c,d){
    if(sum.length >arguments.length){
        console.log("形参多了")
    }else if(sum.length < arguments.length){
        console.log("实参多了")
    }else{
        console.log("相等")
    }
}

// 实际参数 ———— 实参
sum(11,undefined.3,"abc")


    形参长度求法
    function sum(a, b, c, d) {
        console.log(sum.length);
    }
    sum(11, 2, 3)
    答案 4
```

```js

例:
任意个数求和(不定参才能求出来)

    funtion sum(){
        // arguments [1,2,3,4,5,6,7];
        var result = 0;
        for(var i = 0; i < arguments.length;i ++){
            result += arguments[i];
        }
        console.log(result);
    }

sum(1,2,3,4,5,6,7,8,9);
```

> 形参永远有尽头，要实现任意的数求和，无法定义形参。

```js

    function sum(a,b){
        // arguments [1,2]
        // var a = 1;
        a = 2;
        console.log(arguments[0]);
    }
sum(1,2);
答案是 2。a 变，arguments 跟着变化。有一个映射的关系。


    function sum(a,b){
        // arguments [1,2]
        // var a = 1;
        a = 2;
        arguments[0] = 3;
        console.log(argument[0]);
    }
    sum(1,2);
答案 3。arguments 里面一个变，一个跟着变，但是[1,2]是两个独立的人，相当于映射关系。
```

```js

例:当形参两个，实参一个

    function sum(a, b){
    //arguments[1]没值
    b = 2;
    console.log(arguments[1]);
    }
    sum(1);
答案: undefined，实参列表出生时有几个，就有几个，在写 b=2，也不加在 arguments[1]里面了，此处的 b 就当变量用，他和实参不映射。

形参实参完全对应上才相互映射

例:
    function sum(a, b){
        //arguments[1]没值
        a = 2;
        console.log(arguments[0]);
    }
    sum(1);
答案 2
```

### 返回值 return

`结束条件和返回值 return，return 有终止函数的功能`

`没写 return，实际上是加上了一个隐式的 return`

```js
例:
    function sum(a, b){
    console.log(‘a’);
    console.log(‘b’);
    return;
    }
    答案 a，b

例:
    function sum(a, b){
    console.log(‘a’);
    return;
    console.log(‘b’);
    }
    答案 a
```

> return 最常用的是返回值。本意是把一个值返回到函数以外

```js
自己定义的函数也能返回,return 空格 123

例:
    function sum(){
    return 123;
    console.log(‘a’);
    }
    var num = sum();
    答案这里的 num 就是 123，而且 console.log(‘a’);无效，这里的 return 又终止函数，又返回变量

例:
    把 target 转成数字
    function myNumber(target){
    return + target; //利用+隐式的转换成了数字类型
    }
    var num = myNumber(‘123’);
    console.log(typeof(num) + “” + num);
    答案 number 123
```

1. 一般函数处理完一个参数，是为了返回

2. typeof()也是返回值，也是函数

3. typeof(123)也可以写成 typeof 123【typeof 空格 123】，只是看起来不方便

### **练习**

1. 写一个函数，功能是告知你所选定的小动物的叫声。
2. 写一个函数，实现加法计数器。
3. 定义一组函数，输入数字，逆转并输出汉字形式。
4. 写一个函数，实现 n 的阶乘。
5. 写一个函数，实现斐波那契数列。

一、写一个函数，功能是告知你所选定的小动物的叫声。

```js
function scream(animal) {
  switch (animal) {
    case "dog":
      document.write("wang");
      return;
    case "cat":
      document.write("miao!");
      return;
    case "fish":
      document.write("o~o~o~");
      return;
  }
}
```

> 此处可以用 break , 也可以用 return

二、写一个函数，实现加法计数器。

```js

任意个数求和(不定参才能求出来)

    funtion sum(){
        // arguments [1,2,3,4,5,6,7];
        var resule = 0;
        for(var i = 0; i < arguments.length;i ++){
            result += arguments[i];
        }
        console.log(result);
    }

    sum(1,2,3,4,5,6,7,8,9);
```

三、定义一组函数，输入数字，逆转并输出汉字形式。

```js
function reverse() {
  var num = window.prompt("input");
  var str = "";
  for (var i = num.length - 1; i >= 0; i--) {
    str += transfer(num[i]);
  }
  document.write(str);
}
reverse();

function transfer(target) {
  switch (target) {
    case "1":
      return "壹";
    case "2":
      return "贰";
    case "3":
      return "叁";
    case "4":
      return "肆";
    case "5":
      return "伍";
    case "6":
      return "陆";
    case "7":
      return "柒";
    case "8":
      return "捌";
    case "9":
      return "玖";
  }
}
```

```js
属性补充：

str.charAt(0)意思是字符串的第零位

for(var i = num.length - 1; i >= 0)这是倒着拿的意思

一个字符串长度是 3，他的第三位字符串是 2


可以把第二个 function 放第一个里面，但是一般单独写，因为 transfer 是转换

str += transfer(num[i]);是先执行后面的 transfer(num[i])，再赋值给前面
```

## 递归

`写一个函数，实现 n 的阶乘。`

```js
方法一: function jc(n) {
  //n 的阶乘
  var num = 1;
  for (var i = 1; i <= n; i++) {
    num *= i;
  }
}

方法二: function mul(n) {
  if (n == 1 || n == 0) {
    return 1;
  }
  return n * mul(n - 1);
}
```

方法二叫递归

1、找规律，

2、找出口（找停的点）

> 递归的优点是代码简洁，但是运行慢

```js
导图: return 5 * mul(5 - 1);
return (5 - 1) * mul(5 - 2);
return 3 * mul(5 - 3);
return (5 - 3) * mul(5 - 4);
return 1;
```

5、拿递归写斐波那契数列 fb(n)==fb(n - 1) + fb(n - 2);

```js
function fb(n){
    if(n == 1 || n== 2){
    return 1;
    }
    return fb(n - 1) + fb(n - 2);
}

fb(5) == > fb(4) + fb(3);
fb(4) == > fb(3) + fb(2);
fb(3) == > fb(2) + fb(1);
fb(2) == > fb(1) + fb(0);
fb(1) == > fb(1) + fb(0);
```

> 递归返回的顺序：先执行的最后被返回，最后执行完（等最底层的一层层返回）

## 立即执行函数

> 定义：此类函数没有声明，在一次执行过后即释放（被销毁）。适合做初始化工作。

```js
针对初始化功能的函数：只想让它执行一次的函数

立即执行的函数也有参数，也有返回值，有预编译
```

```js
例:
    (function (){
                 //写成(function abc(){}())也调用不到
        var a = 123;
        var b = 234;
        console.log(a + b);

    }())

例:
    (function (a, b, c){

        console.log(a + b + c * 2);

    }(1, 2, 3))         //这一行里面的(1,2,3)是实参


例:
    var num = (function (a, b, c){
        var d = a + b + c * 2 – 2;
        return d;
    }(1, 2, 3))

答案 num = 7
```

### 立即执行函数的五种写法

```js
标准写法:

1. (function (){}()); //在 W3C 建议使用这一种

```

```js
2. (function (){})();

(function test(){console.log(‘a’);})()

这个被()包起来的 function 函数声明变表达式了，就能被外面的最后的()执行

(function test(){
    console.log(‘a’);
}())

最外面的大括号是数学运算符号，是最先被执行，其余的括号都是有语法意义的，就把函数变表达式了

()也是数学执行符，能打印 a，但是执行 test 就报错，所以干脆就不写 test
```

```js

3. var num = function (){}();

    var num = function () {
    console.log("a");
    }();
```

只有表达式才能被执行符号执行

能被执行符号执行的表达式，这个函数的名字就会被自动忽略（放弃名字）

能被执行符号执行的表达式基本上就是立即执行函数

函数声明和函数表达式是两个东西，虽然都能定义函数

函数声明：function test ( ){}

函数表达式：var test = function( ){}

`其中 = function (){}把 function 赋到 num 里面去叫表达式，var num 是声明在执行时，会放弃这个函数储存到 test 里面的储存引用，让这个 test 恢复到被声明的状态`

```js
4. +、-、！ function num(){}();

    + function test(){
        console.log('a');
    }()

    - function test(){
        console.log('a');
    }()

    ! function test(){
        console.log('a');
    }()
```

>加了个"正"，在趋势上要把他转换成数字，就是表达式了，既然是表达式就能被执行，就会放弃名字，此时 console.log (test)，就会报错；这就是立即执行函数，同样放了正号，负号，！就会放弃函数名字，转换成表达式；但是*和/不行，&&||前面放东西也行

```js
5. function test(a,b,c,d){console.log(a + b + c + d)}(1,2,3,4);

例:
    function test(a,b,c,d){
        console.log(a + b + c + d);
    }(1, 2, 3, 4)
```

>理论上坚决不能执行，如果括号里面没有数字的话,系统会认为这是一个执行符号，但是如果在里面写上数字，系统就不会给你当成执行符号，它会当成这样写：

```js
例:
    function test(a,b,c,d){
        console.log(a + b + c + d);
    }
    (1, 2, 3, 4);
```

>这样就不会报错了，因为 逗号（,）也是一个运算符，它会后面的位返回。所以它也是一个正常语法。但是它也不会执行,也不会报错,test还是函数体。

### 要点:

```js
例1.1:

先定义一个 10 位数的数组，就是在 var arr = [function () {console.log(i);}有十个[]并且把数组返回

function test (){ //定义个函数 test
    var arr = []; //定义一个空数组
    for (var i = 0; i < 10; i ++){
    //丰满空数组，让空数组添加十条数组
        // 每一条都是一个 function(){}
        arr[i] = function () { //随着 for 循环 i 变，
        // 数组 i 也变，arr 每一次都等于一个全新的函数体
        document.write(i + " ");
        }

    }
    return arr; //把 arr 返回到外部
}
var myArr = test();
for (var j = 0; j < 10; j ++){
    //分别执行十个函数体，函数体里面定义了 document.write
    myArr[j]();
}

// 答案 10 10 10 10 10 10 10 10 10 10
```

第二个 for 是为了打印这个数组，麻烦写法 myArr[0](); myArr[1](); 。。。myArr[9]();

过程 for (var i = 0; i < 10; i ++){}执行了十次，产生了十个彼此独立的函数。并且把这十个函数放在数组里面去，还把数组返回了，这十个函数和 test 一起产生了一个闭包。

既然是闭包，那么访问 test 里面的变量时，实际上访问的是同一套，而 test 产生了
arr 和 i 变量（写在 for 循环里面的 i 变量），而这十个函数在外边要访问 i 变量，其实访问的是同一个 i。

什么时候访问的？在 test 执行完以后，在下面 for(j)访问的第一个 i=0，转到 9 的时候，i ++变 10 终止 for 循环，结束的时候 i=10，结束之后把return arr 返回，arr；

这十个函数都是为了打印 i 的，在外部访问 i 的时候 i=10，所以打印的是 10

```js
arr[i] = function () {
    document.write( i + “ ”);
}
```

理解过程：

在这个函数体中，当`arr[0]`时`document.write(i)`的`i`是不变的，还是`i`，等函数保存到外部之后，等执行的时候，才会去找` i`的值。

这个赋值语句中`arr[0] = 函数;`把一个函数体或者说是一个函数引用赋给数组的当前位，数组的当前位需要马上被索取出来的（数组现在当前第几位，我们是知道的，因为这个是执行语句），当`for(var i = 0)`时，`arr[i]`会变成`arr[0]`但是这个 i 跟函数体里面的`document.write(i + " "）`里面的`i`是没有关系的，因为函数体 function(){}不是现在执行，不会在意函数里面写的是什么，不是现在执行那么里面的`document.write`不会变成现实的值，不是现在执行就是函数引用（函数引用就是被折叠起来的，系统不知道里面写的是什么）

在执行`myArr[j]();`的时候，系统才会读`document.write(i + "")`里面的语句

在定义函数的时候是不看里面的，在执行的时候才看

### 要点2:

```js
例1.2:
我们让上面这个变成打印 0,1,2,3,4,5,6,7,8,9，用立即执行函数解决

function test (){
    var arr = [];
    for (var i = 0; i < 10; i ++){
        (function (j) {
            arr[j] = function () {
            document.write( j + “ ”);
        }
    }(i));
    return arr;
}
var myArr = test();

for (var j = 0; j < 10; j ++){
 myArr[j]();
}
```

理解过程：

相当于在 for 循环里面有十个立即执行函数`function(j){}`
在第一圈 i 是 0，j 也是 0，`function(){document.write( j + “ ”)}`拿着`j=0`进行循环的第二圈 `i `是 1，又有了一个新的 `j` 是 1，反复循环,形成了十个立即执行函数，有十个` j `对应

```js
例
for(var i = 0; i < 10; i ++){
    console.log(i);
}
答案 0,1,2,3,4,5,6,7,8,9

例
for(var i = 0; i < 10; i ++){
    (function(){}())
}

中间 function 这个会执行 10 次
```

# 作用域初探

> **作用域定义：变量（变量作用于又称上下文）和函数生效（能被访问）的区域**

全局、局部变量

作用域的访问顺序

作用域:函数里面的可以访问外面的全局变量



```js


var a = 123;
// 全局变量
function test(){
    var b = 123;
    function demo(){
        var c = 234;
        document.write(b);
        document.write(a);
    }
    demo();
    document.write(c);
}
test();
```

> 函数外面不能用函数里面的。里面的可以访问外面的，外面的不能访问里面的，彼此独立的区间不能相互访问

- test{}和 demo{}不能互相访问，但是可以访问外面的全局变量

```js
例:

彼此独立的区间不能相互访问 全局变量都可以访问

function test(){
    var a = 123;
    function demo(){
        var b = 234;
    document.write(a);
    }
    demo();
    document.write(b);

上面的 document.write(b);不能访问 var b ;
上面的 document.write(a);可以访问 a ;
}
```

> 外层函数不能访问里层的，里层的可以访问外层的，越往里权限越大

```js
作业:

要求输入一串低于 10 位的数字，输入这串数字的中文大写。

例如：input :10000     output:壹万 ;

例如：input :1001010   output:壹佰万壹仟零壹拾 ;

千分位如果是 0必须读零 ;
```

# js 运行三部曲(预编译)

> 语法分析 → 预编译 → 解释执行

## 预编译前奏

```js

例:

function test(){
    console.log(‘a’);
}
test();
上面能执行

例:

test();
function test(){
    console.log(‘a’);
}
也能执行，因为有预编译的存在

例:

var a = 123;
console.log(a);
答案 123

例:

console.log(a);
var a = 123;
答案 undefined

例:

只写 console.log(a);就会报错
```

> 函数声明整体提升：函数不管写到哪里，都会被提到逻辑的最前面。所以不管在哪里调用，本质上都是在后面调用变量 声明提升：把 var a 提升到最前面

- var a = 123;这是变量声明再赋值。

> 变量声明提升是把他拆分成 var a; a = 123;然后把 var a 提升到最前面
> 上面这两句话没办法解决下面例子(全部)的问题

```js
例: function a(a) {
  var a = 234;
  var a = function() {};
  a();
}
var a = 123;
```

> imply global 暗示全局变量：即任何变量，如果变量未经声明就赋值，此变量就为全局对象(就是 window)所有。

`全局对象是 window`

例 window.a = 10;

例 a = 10; ===> windows.a = 10;

eg: var a = b = 123;

> 一切声明的全局变量，全是 window 的属性。

例 var a = 123; ===> window.a = 123;

> window 就是全局的域

如果在全局变量在 var a = 123；那么就会返回到 window

例 var a = 123
console.log(a) ===> console.log(window.a)

```js
例

var a = b = 234;
是把 234 的值赋给 b，在把 b 的值赋给 a

例 :
function test(){
    var a = b = 123;
    console.log(window.a);
    答案：undefined;
    console.log(window.b);
    答案：123；
}
test()

写 test()代表执行 test，赋值是自右向左的，上面先把 123 赋给 b 的时候，b 未经声明，然后再声明 a，再 b 的值赋给 a，导致 b 未经声明，所以 b 归 window 所有访问 window.a 是 undefined，访问 window.b 是 123
```

```js
例:

function test(){
    var b = 123;
}
test();
console.log(window.b);
答案 undefined

window 就是全局

例:
var a = 123;
console.log(a); ==> console.log(window.a);

例:
var a = 123;
var b = 234;
var c = 345;

window{
 a : 123,
 b : 234,
 c : 345
}
如果 var a 对应会有 window.a,在window中也会有a = 123,b = 234,c = 345;
```

## 预编译（解决执行顺序问题）

```js
例 function fn(a){
        console.log(a);

        var a = 123;
        console.log(a);

        function a (){}
        console.log(a);

        var b = function (){}
        console.log(b);

        function d() {}
}
fn(1);

答案是 function a(){} 、123 、123 、function b(){}

这个例子的形参是（a），变量声明也是 a



上面的例子按四部曲变化如下:

1.创建AO对象

AO{}

2. 找形参和变量声明，将变量和形参(a)名作为 AO 属性名，值为 undefined

AO{
    a : undefined,
    b : undefined,
}

3. 把实参值传到形参里

AO{
    a : 1,
    b : undefined,
}

4. 在函数体里面找函数声明，值赋予函数体

function a () {}和 function d () {}都是函数声明，但是 var b = function (){}不是。

AO{
    a : function a () {},
    b : undefined,
    d : function d () {}
}

执行第一行 console.log(a);时，用的是
AO{
    a : function a () {},
    b : undefined,
    d : function d () {}
}

执行 var a =123;改变的是
AO{
    a : 123,
    b : undefined,
    d : function d () {}
}

在 b = function (){}时
AO{
    a : 123,
    b : function () {},
    d : function d () {}
}

```

> 预编译发生在函数即将执行的前一刻

## （函数）预编译的四部曲

```js

1. 创建 AO 对象 Activation Object(执行期上下文，作用是函数解的作用域，函数产生的执行空间库)

2. 找形参和变量声明，将变量和形参名作为 AO 属性名，值为 undefined,相当于

AO{
    a : undefined,
    b : undefined
}

3. 将实参值和形参统一（把实参值传到形参里）

4. 在函数体里面找函数声明，值赋予函数体（先看自己的 AO，再看全局的 GO）

```

```js
例:
function test (a, b){
    console.log(a);
    c = 0;
    var c;
    a = 3;
    b = 2;
    console.log(b);
    function b (){};
    function d (){};
    console.log(b);
}
test(1);


答题过程：

找形参和变量声明，将变量和形参名作为 AO 属性名，值为 undefined

AO{
    a : 1,
    b : undefined,
    c : undefined
}

函数声明 function b(){}和 function d(){}，AO{
    a : 1,
    b : function b(){},
    c : undefined,
    d : function d(){}
}

执行 console.log(a);答案是 1

执行 c = 0;变
AO{
    a : 1,
    b : function b(){},
    c : 0,
    d : function d(){}
}
var c 不用管，因为 c 已经在 AO 里面了

执行 a = 3;改
AO{
 a : 3,
 b : function b(){},
 c : 0,
 d : function d(){}
}

执行 b = 2;改
AO{
 a : 3,
 b : 2,
 c : 0,
 d : function d(){}
}

执行 console.log(b);答案是 2

function b () {}和 function d(){}已经提过了，不用管执行 console.log(b);答案是 2

```

```js
例:

function test(a , b){
    console.log(a); // function a(){}
    console.log(b); // undefined

    var b = 234;
    console.log(b); // 234

    a = 123;
    console.log(a); // 123

    function a (){}
    var a;
    b = 234;
    var b = function(){}
    console.log(a); // 123
    console.log(b); // function b(){}
}
test(1);

答题过程：

1. 将变量和形参名作为 AO 属性名
AO{
    a : undefined,
    b : undefined
}

2. 将实参值和形参统一
AO{
    a : 1,
    b : undefined
}

3. 找函数声明 function a (){}
AO{
    a : function a (){},
    b : undefined
}

执行 console.log(a);答案是 function a (){}
执行 console.log(b);答案是 undefined

执行 var b = 234;变
AO{
    a : function a (){},
    b : 234
}

执行 console.log(b);答案是 234

执行 a = 123;变
AO{
    a : 123,
    b : 234
}

执行 console.log(a);答案是 123
然后 function a (){};var a ;都可以不看了

执行 b = 234，b 值还是 234，不变
执行 var b = function (){}，变
AO{
    a : 123,
    b : function (){}
}

执行 console.log(a);答案是 123
执行 console.log(b);答案是 function (){}
```

> 一旦有重名的，一但有 a 变量又有 a 函数【如 function a (){}】，又在第一条访问的是 a，一定是函数答题过程： 将变

```js
下面开始讲全局的预编译

例:
    console.log(a);
    var a = 123;
答案 undefined;

例:
    console.log(a);
    var a = 123;
    function a (){}
答案是打印 a 是 function a (){}

```

## 全局的预编译三部曲

1. 生成了一个 GO 的对象 Global Object（window 就是 GO）

2. 找形参和变量声明，将变量和形参名作为 GO 属性名，值为 undefined

3. 在函数体里面找函数声明，值赋予函数体

```js
例:
console.log(a);
var a = 123;
console.log(a);
function a (){}

答案过程:

1. GO{
    a : undefined
}

2. 函数声明 GO{
    a : function a (){}
}

3. 执行 var a = 123;变 GO{
    a : 123
}
执行 console.log(a);就是 123
```

> GO === window， GO 和 window 是一个东西

console.log(a);和 console.log(window.a);和 console.log(go.a);是一样

> 任何全局变量都是 window 上的属性 , 没有声明变量就赋值了，归 window 所有，就是在 GO 里面预编译

```js
例:
function test(){
    var a = b = 123;
    console.log(window.b);
}
test();

答案 window.a 是 undefined，window.b 是 123

先生成 GO{
 b : 123
}
再有 AO{
a : undefined
}
```

1. 先生成 GO 还是 AO

2. 想执行全局，先生成 GO，在执行 test 的前一刻生成 AO

3. 在几层嵌套关系，近的优先，从近的到远的，有 AO 就看 AO，AO 没有再看 GO

```js
例:
console.log(test);

function test(test){
    console.log(test);
    var test = 234;
    console.log(test);
    function test(){
    }
}
test(1);
var test = 123;

答题过程:

1. 想执行全局,先有 GO,

GO{
    test : undefined
}
2. 发现有函数声明

 GO{
    test : function (){..... }
}
执行 console.log(test),


1. 执行 test(1)之前生成

AO{
    test : function (){}
 }

2. 执行 var test = 234;变成

AO{
    test : 234;
 }
```

> AO 上面有就用 AO 的，没有就看 GO 的

```js
例:

var global = 100;
function fn(){
    console.log(global);
}
fn();

答题过程

GO{
    global : undefined,
    fn : function(){.....}
 }

执行 var global = 100;变

GO{
    global : 100,
    fn : function(){.....}
}

不看 function fn(){...}里面的东西
执行 fn()之前

AO{
 访问 GO的 global
}
```

```js
global = 100;

function fn(){
    console.log(global);
    global = 200;
    console.log(global);
    var global = 300
}
fn();
var global;


答题过程:

GO{
    global : undefined
    fn : undefined(没用可以不写)
}

变:

GO{
    global : 100,
    fn : undefined
 }

执行 fn()之前，

AO{
    global : undefined
}

执行结果是 undefined，200
```

```js

function test(){
    console.log(b); //undefined
    if(a){
        var b = 100;
    }
    console.log(b); //undefined
    c = 234;
    console.log(c); //234
}

var a;
test();
a = 10;
console.log(c); //234

过程

GO{
    a : undefined,
    test:undefined
}

AO{
    b : undefined //不管 if(a){}，可以提出 var b的
}

执行到 c=234，
GO{
    a : undefined,
    c : 234,
    test:undefined
}

执行到 a=10，

GO{
    a : 10
    c : 234
    test:function test(){}

}
```

```js
例:

function bar(){
    return foo;
    foo = 10;
    function foo(){}
    var foo = 11;
}
console.log(bar());

答案：function foo(){}
如果在第一行 return foo，下面有 foo 这个函数，一定打印这个函数;
```

```js
例:
console.log(bar());
function bar(){
    foo = 10;
    function foo(){}
    var foo = 11;
    return foo;
}
答案 11

例:
console.log(b);
var b = function (){}
答案是 undefined // 因为var b = undefined 是函数表示，不是函数声明;
```

```js
例:

现在因为语法的改变 在 if 里面定义函数声明 function 是不允许的，但是过去可以，下面就是过去的旧题，可以按着来做一下

a = 100;
function demo(e){
    function e(){}
    arguments[0] = 2;
    document.write(e);
    if(a){
        var b = 123;
        function c(){
            //......
        }
    }
    var c;
    a = 10;
    var a;
    document.write(b);
    f = 123;
    document.write(c);
    document.write(a);
}
var a;
demo(1);
document.write(a);
document.write(f);

GO{
    a : undefined
    demo : function (){}
}

开始执行 a=100，
GO{
    a : 100，
    demo : function (){}
}
AO{
    e : undefined,
    b : undefined,
    c : undefined,
    a : undefined
}
形参实参相统一，AO{
    e : 1,
    b : undefined,
    c : undefined,
    a : undefined
}
赋值 AO{
    e : function e (){},
    b : undefined,
    c : undefined, //------旧规则里面可以提出 function(){}
    a : undefined
}
执行 arguments[0] = 2;实参列表和传参是否相映射，变
AO{
    e : 2,
    b : undefined,
    c : undefined,
    a : undefined
}

执行 console.log(e);答案 2
if(a)由于 a 在 AO 里面是 undefined，所以不运行

执行 a = 10;变
AO{
    e : 2,
    b : undefined,
    c : undefined,
    a : 10
}

执行 console.log(b)，答案 undefined

执行 f = 123，变
GO{
    a : 100,
    demo : function (){},
    f : 123
}

执行 console.log(c); 之前打印 function(){}，改语法后打印 undefined
执行 console.log(a); 答案 10
执行 console.log(a); 因为在外面是全局的，答案 100
执行 console.log(f); 答案 123
```

```js
1.  var str = false + 1;
    document.write(str);

2.  var demo = false == 1;
    document.write(demo);

3.  if(typeof(a) && -true + (-undefined) + ""){
        document.write('基础扎实')
    }

4.  if(11 + "11" * 2 == 33){
        document.write("基础扎实")
    }

5.  ！！" " + !!"" - !!false || document.write("你觉得可以打印，你就是猪")

答题:

1. false + 1 因为有 +，两边都不是字符串，就转换成数字,0 + 1 = 1
// 1

2. false 是 0 ，false false == 1，false 肯定不等于 1，所以把 false 再赋给 demo
// false

3.
(1) typeof(a) 是 "undefined" ;

(2) -true 转换成数字是-1;
	+undefined 显示“NaN”
    -1 + NaN = NaN
    -1 + NaN + "" = "NaN"
//"undefined" &&  "NaN" 转换成 boolean，就都是 true
//因为两边都是字符串，所以是true;

4. "11" * 2 是*把两边转换成了数字，所以 11 + "11" * 2 = 33，33 == 33
// 两边相等

5.
(1) !! 非非 就是 正
    " " 这不是空串，是空格字符串
    !!" " 转换成 Boolean 为 true

(2) !!"" 非非空串，转换为 Boolean 为 false

(3) !!false 就是 false

(4) true + false - false = 1 + 0 – 0 = 1

(5) 1 || document.write(‘你觉得能打印？’)

// || 运算符 遇到真就停，1 为真，所以返回 1
```

```js
例:
(window.foo || (window.foo = ‘bar’));

求 window.foo

答案”bar”

这道题要先看

(window.foo = ‘bar’)这一边的，再看左边的 window.foo

因为运算符的顺序问题，让这道题错误的读法（从左到右）也是 bar，所以怎样读，都是正确答案 : bar

(window.foo || window.foo = ‘bar’);这么写就报错;
// 因为 ||或 运算符优先级高于 =等号 运算符 , 而 ()括号 运算符 则大于一切运算符
所以，必须要写成：
(window.foo || (window.foo = "bar"));
```

# 作用域精解

每个 javascript 函数都是一个对象，对象中有些属性我们可以访问，但有些不可以，这些属性仅供 javascript 引擎存取，**[[scope]]**就是其中一个。**[[scope]]**指的就是我们所说的作用域,其中存储了运行期上下文的集合。

**作用域链**：[[scope]]中所存储的执行期上下文对象的集合，这个集合呈链式链接，我们把这种链式链接叫做作用域链。

**运行期上下文**:当函数在执行的前一刻，会创建一个称为执行期上下文的内部对象。
一个执行期上下文定义了一个函数执行时的环境，函数每次执行时对应的执行上下文都是独一无二的，所以多次调用一个函数会导致创建多个执行上下文，当函数执行完毕，执行上下文被销毁。

**查找变量**：在哪个函数里面查找变量，就从哪个函数作用域链的顶端依次向下查找函数类对象

我们能访问 test.name

> test.[[scope]]隐式属性——作用域

```js
例:
function test (){
    …………
}

第一次执行 test(); → AO{} //AO 是用完就不要的
第二次执行 test(); → AO{} //这是另外的 AO
```

```js
function a() {
    function b() {
        var b = 234;
    }
    var a = 123;
    b();
}
var glob = 100;
a();

0 是最顶端，1 是次顶端，查找顺序是从最顶端往下查
```

执行顺序：

```js
1. a 函数刚刚被被定义时，它的[[scope]]就已经存入了信息，发生了以下过程

                                    |   Global      Object    |
                                  / ———————————————————————————
    a               scope chain  /  |    this    |   window   |
————————           —————————————/   ———————————————————————————
[[scope]]             0  |          |   window   |  (object)  |
                                    ———————————————————————————
                                    |  document  |  (object)  |
                                    ———————————————————————————
                                    |     a      | (function) |
                                    ———————————————————————————
                                    |   global   |     100    |
                                    ———————————————————————————
                                    |            |            |
                                    ———————————————————————————
```

```js
2. a 函数被执行时，[[scope]]发生了以下过程
                                    | Activation     Object   |
                                  / ———————————————————————————
    a               scope chain  /  |    this    |   window   |
————————           —————————————/   ———————————————————————————
[[scope]]             0  |          |  arguments |     []     |
                   —————————————    ———————————————————————————
                      1  |          |      a     |     123    |
                   ————————————\    ———————————————————————————
                                \   |      b     | (function) |
                                 \  ———————————————————————————
                                  \
                                   \
                                    |   Global     Object     |
                                    ———————————————————————————
                                    |    this    |   window   |
                                    ———————————————————————————
                                    |   window   |  (object)  |
                                    ———————————————————————————
                                    |  document  |  (object)  |
                                    ———————————————————————————
                                    |     a      | (function) |
                                    ———————————————————————————
                                    |   global   |     100    |
                                    ———————————————————————————
```

```js
3. b 函数被创建并且被定义的时候，[[scope]]发生了以下的过程

                                    | Activation     Object   |
                                  / ———————————————————————————
    b               scope chain  /  |    this    |   window   |
————————           —————————————/   ———————————————————————————
[[scope]]             0  |          |  arguments |     []     |
                   —————————————    ———————————————————————————
                      1  |          |      a     |     123    |
                   ————————————\    ———————————————————————————
                                \   |      b     | (function) |
                                 \  ———————————————————————————
                                  \
                                   \
                                    |   Global     Object     |
                                    ———————————————————————————
                                    |    this    |   window   |
                                    ———————————————————————————
                                    |   window   |  (object)  |
                                    ———————————————————————————
                                    |  document  |  (object)  |
                                    ———————————————————————————
                                    |     a      | (function) |
                                    ———————————————————————————
                                    |   global   |     100    |
                                    ———————————————————————————
```

```js
4. b 函数被执行的时候，[[scope]]发生了以下的过程

                                        | Activation     Object   |
                                      / ———————————————————————————
                                     /  |    this    |   window   |
                                    /   ———————————————————————————
                                   /    |  arguments |     []     |
                                  /     ———————————————————————————
    b               scope chain  /      |      b     |     234    |
————————           —————————————/       ———————————————————————————
[[scope]]             0  |             |            |            |
                   —————————————        ———————————————————————————
                      1  |      \
                   ————————————— \
                      2  |        \     | Activation     Object   |
                     /             \    ———————————————————————————
                    /               \   |    this    |   window   |
                   /                 \  ———————————————————————————
                  /                   \ |  arguments |     []     |
                 /                     \———————————————————————————
                /                       |     a      |     123    |
               /                        ———————————————————————————
              /                         |     b      | (function) |
             /                          ———————————————————————————
            /
        |   Global     Object     |
        ———————————————————————————
        |    this    |   window   |
        ———————————————————————————
        |   window   |  (object)  |
        ———————————————————————————
        |  document  |  (object)  |
        ———————————————————————————
        |     a      | (function) |
        ———————————————————————————
        |   global   |     100    |
        ———————————————————————————
```

```js

    function a(){
        function b(){
            var bb = 234;
            aa = 0;
        }
        var aa = 123;
        b();
        console.log(a);
    }
    var global = 100;
    a();

答案：0;
```

>理解过程：
bb 的 AO 是拿到 aa 的 AO，就是同一个 AO，bb 只是引用了 aa 的 AO，GO 也都是同一个。function b(){}执行完，干掉的是 b 自己的 AO（销毁执行期上下文）（去掉连接线），下次 function b 被执行时，产生的是新的 b 的 AO。b 执行完只会销毁自己的 AO，不会销毁 a 的 AO。function a(){}执行完，会把 a 自己的 AO 销毁【会把 function b 也销毁】，只剩 GO（回归到 a 被定义的时候），等下次 function a再次被执行时，会产生一个全新的 AO，里面有一个新的 b 函数。。。。。。周而复始

```js
function a() {
    function b() {
        funcion c() {}
        c();
    }
    b();
}
a();

理解过程：

a 被定义 a.[[scope]] → 0 : GO{}

a 被执行 a.[[scope]] → 0 : a.AO{}
                       1 : GO{}

b 被定义 b.[[scope]] →  0 : a.AO{}
                        1 : GO{}

b 被执行 b.[[scope]] → 0 : b.AO{}
                       1 : a.AO{}
                       2 : GO{}

c 被定义 c.[[scope]] → 0 : b.AO{}
                       1 : a.AO{}
                       2 : GO{}

c 被执行 c.[[scope]] → 0 : c.AO{}
                       1 : b.AO{}
                       2 : a.AO{}
                       3 : GO{}


当 c 执行完后，会干掉自己的 cAO，回到 c 被定义的状态，当 c 再被执行时，会生成一个新的 newcAO{}，其余都一样，因为基础都是 c 的被定义状态 c 被执行

c.[[scope]] → 0 : new c.AO{}
              1 : b.AO{}
              2 : a.AO{}
              3 : GO{}
```

如果`function a`不被执行，下面的`function b`和`function c`都是看不到的（也不会被执行，被折叠）。只有`function a`被执行，才能执行`function a 里面的内容`a()`; 如果不执行，根本看不到`function a (){}`里面的内容;

```js

    function a(){
        var aa = 345;
        function b(){
            var bb = 234;
            function c(){
                cc = 123;
            }
            c();
        }
        b();
    }
    a();

执行过程：

先执行 function a(){ var aa = 345;function b (){}b();}
想要执行完上面的 b();就需要执行完 function b(){var bb = 234; function c(){}c();}，
想要执行 c();就要先执行完 function c(){var cc =123;},
b();是一个复合语句，执行完 b 里面的每一句话，才能执行 b();

销毁顺序：

哪个先被执行完，哪个先被销毁
当 c 执行完，先销毁 c 自己的执行期的上下文，
当 c();执行完，那么 b 也执行完了，就销毁 b 的执行期上下文；
当 b();执行完，那么 a 也执行完了，就销毁 a 的执行期上下文
```

# 闭包

> 当内部函数被保存到外部时，将会生成闭包。闭包会导致原有作用域链不释放，造成内存泄露。

`内存泄漏就是内存占用，内存被占用的越多，内存就变得越来越少了，就像内存被泄露了一样`

```js

    function a(){
        function b(){
            console.log(aaa);
        }
        var aaa = 123;
        return b;
    }
    var demo = a();
    demo();

return b 以后，就返回出去，再销毁 fn a。

答案：123;。因为没有 b();此时 b 还是被定义的状态，和 a 执行的状态是一样的。function a(){}是在 return b 之后才执行完，才销毁。return b 让 a 执行时的 AO 被保存到了外面。


       a执行                    | Activation     Object   |
                              / ———————————————————————————
    a           scope chain  /  |    this    |   window   |
————————       —————————————/   ———————————————————————————
[[scope]]         0  |     /    |  arguments |     []     |
               —————————————    ———————————————————————————
                  1  |          |    aaa     |     123    |
               —————————\———   / ———————————————————————————
                         \    / |      b     | (function) |
                          \  /  ———————————————————————————
                           \/
                           /\
                          /  \      |   Global     Object     |
                         /    \    /———————————————————————————
    b被定义，并被保存出来./      \  / |    this    |   window   |
                       /        \/  ———————————————————————————
                      /         /\  |   window   |  (object)  |
   b           scope chain     /  \ ———————————————————————————
—————————     —————————————   /     |  document  |  (object)  |
[[scope]]        0  |        /      ———————————————————————————
              ————————————— /       |     a      | (function) |
                 1  |      /        ———————————————————————————
              —————————————         |   global   |     100    |
                                    ———————————————————————————
                                    |    demo    | (function) |
                                    ———————————————————————————
```

`return b`是把`b（包括 a 的 AO`保存到外部了（放在全局）
当 a 执行完砍掉自己的`AO`时，b 依然可以访问到`a`的`AO(因为 return b)`

> 但凡是内部的函数被保存到外部，一定生成闭包

```js
例:
    function a(){
        var = 100;
        function b(){
            num ++;
            console.log(num);
        }
        return b;
    }
    var demo = a();
    demo();
    demo();

答案 101,102

理解过程:

    a 被执行 0 : a.AO: num = 100;
             1 : GO: demo = a();

    b 被执行 0 : b.AO :
             1 : a.AO : num = 100;
             2 : GO: demo = a();
```

在第一次执行`function b`时，`num ++`就把`aAO`变成`{num : 101}`，当 `function b`执行完毕时，剪断的是`bAO`，而`aAO`不变，当执行`function a`的`return b`时就把`aAO,GO`都存在了外部，执行完`a`销毁`scope`时去掉 `a`的连接线，但是因为`return b`把`aAO,GO`存在了外部，所以依然还是可以访问值

在第二次执行`function b`时，`aAO{num : 101}`，`在`num ++`就是`102`


## 闭包的作用

### 一、实现公有变量

```js
函数累加器：

    function add(){
        var count = 0;
        function demo(){
            count ++;
            console.log(count);
        }
        return demo;
    }
    var counter = add();
    counter();
    counter();
    counter();
    counter();
    counter();

每回调用 counter 就会在原有基础上加一次
```

### 二、可以做缓存（存储结构）

> eg:eater。缓存是外部不可见的，但是确实有存储结构

```js
例1：
    fnction test(){
        var num = 100;
        function a(){
            num ++;
            console.log(num);
        }
        function b(){
            num --;
            console.log(num);
        }
        return [a,b];
    }
    myArr = test();
    myArr[0]();
    myArr[1]();

答案 101 和 100，思考过程：说明两个用的是一个 AO

test doing test[[scope]] 0 : test.AO
                         1 : GO
a defined a.[[scope]]    0 : test.AO
                         1 : GO
b defined b.[[scope]]    0 : test.AO
                         1 : GO

当执行 myArr[1]();时:

b doing b.[[scope]] 0 : b.AO
                    1 : a 运行后的 test.AO
                    2 : GO

a 运行后的 test.AO， 与 a doing 里面的 test.AO 一模一样
a 和 b 连线的都是 test 环境，对应的一个闭包
```

`function a`和`function b`是并列的，不过因为`function a`在前，所以先执行`num ++`，在执行`num --`

`myArr[0]`是数组第一位的意思，即`a`，`myArr[0]()`;就是执行函数`a`的意思;

`myArr[1]`是数组第二位的意思，即`b`，`myArr[1]()`; 就是执行函数`b`的意思;

```js
例2:
    function eater(){
        var food = "";
        var obj = {
            eat : function(){
                console.log('I am eating' + food);
                food = "";
            },
            push : function(myFood){
                food = myFood;
            }
        }
        return obj;
    }
    var eater1 = eater();

    eater1.push('banner');
    eater1.eat();

答案: I am eating banana，eat 和 push 操作的是同一个 food;
```

在`function eater(){里面的 food}`就相当于一个隐式存储的机构`obj`对象里面是可以有`function`方法的,也可以有属性，方法就是函数的表现形式

### 三、可以实现封装，属性私有化

`例为什么在外部执行的 divorce 能用内部的变量？能换成 xiaozhang`

`因为 this.divorce 在对象上，由于对象被返回了，这个方法也被返回了。
因为闭包。这个函数被储存到了外部，所以储存了这个函数的执行期上下文。`

`所以可以用这个闭包。所以 var prepareWife 被下面的 this=fn 三个函数共用，这三个函数分别与 fn Deng 形成了闭包，共同用 Deng 的 AO,所以可以在外部随意存取。`

```js
例:
     function Deng(name,wife){
         var prepareWife = 'xiaozhang';

         this.name = name;
         this.wife = wife;
         this.divorce = function (){
             this.wife = prepareWife;
         }
         this.changePrepareWife = funtion(target){
             prepareWife = target;
         }
         this.sayPrapreWife = function(){
             console.log(prepareWife);
         }
     }
     var deng = new Deng('Deng','xiaoliu');

    //  从控制器输出:

    // >  deng
    // <· Deng
    //     > changePrepareWife(target)
    //     > divorce:()
    //         name : "deng"
    //     > sayPrapreWife:()
    //         wife : 'xiaoliu'
    //     > __proto__ : Object

    // >  deng.divorce()
    // <· undefined
    // >  deng.wife
    // <· 'xiaozhang'
    // >  deng.prepareWife
    // <· undefined
```

deng.prepareWife 是 undefined 的，表面上看起来不是自己的，但是`实际上只有对象自己通过对象自己设置的方法可以去操作他，外部用户通过对象，prepareWife 是看不到的`，只有自己能看到，就是闭包的私有化运用。

```js
例: var inherit = (function() {
  var F = function() {};
  return function(Target, Origin) {
    F.prototype = Origin.prototype;
    Target.prototype = new F();
    Target.prototype.constructor = Target;
    Target.prototype.uber = Origin.prototype;
  };
})();
// 执行完是这个样子
var inherit = function(Target, Origin) {
  F.prototype = Origin.prototype;
  Target.prototype = new F();
  Target.prototype.constructor = Target;
  Target.prototype.uber = Origin.prototype;
};
```

`上面的 var F 这个 F 形成了闭包，成为了这个函数的私有化变量，而且变成私有化变量就更好`

### 四、模块化开发，防止污染全局变量

## 闭包的防范

> 闭包会导致多个执行函数共用一个公有变量，如果不是特殊需要，应尽量防止这种情况发生。

# 对象，包装类

## 对象

### 1.用已学的知识点，描述一下你心目中的对象

```js

例:

    var mrDeng  = {
        name : 'MrDeng',
        age : 40,
        sex : 'male',
        health : 100,
        smoke : function (){
            console.log('I am smoking ! cool !!! ');
            mrDeng.health --;
        }
        dring : function (){
            console.log('I am drink');
            mrDeng.health ++;
        }
    }

    // 在控制台返回

    // >  mrDeng.health
    // <· 100

    // >  mrDeng.drink()
    //  I am drink
    // <· undefined

    // >  mrDeng.drink()
    //  I am dring
    // <· undefined

    // >  mrDeng.health
    // <· 102

    // >  mrDeng.smoke()
    //  I am smiking ! cool !!!
    // <· undefined

    // >  mrDeng.health
    // <· 99

    // >  mrDeng.dring()
    //  I am dring
    // <· undefined
```

> 灰色的 undefined 是返回值，因为没有设置返回值，所以就是灰色的 undefined

#### 代表函数引用

> 改 mrDeng.health 为 this.health，此处 this 指代的是自己，是第一人称，指的就是 mrDeng。因为 this 是在一个方法里面，所以指的这个方法。

```js

smoke : function (){
    console.log(‘I am good’)
    this.health --;
},
```

### 2.属性的增、删、改、查

```js
例

在上面的基础上 mrDeng.wife = 'xiaoliu'

也可以在控制台操作

=''等号后面的引号里面需要有值才可以

删除必须借助 delete mrDeng.sex

```

#### 增加一个属性

给一个对象增加属性和方法，就直接给一个对象添加，如下:

> （对象.属性名 = 属性值） 如 ： mrDeng.wife = 'xiaoliu'

`例 ：mrDeng.wife = "xiaoliu"`

#### 查看一个属性

> 对象名.属性名

#### 修改一个属性

> 直接在对象名外面或控制器里面写 （对象名.属性名 = "属性值"）

```js
例: var mrDeng = {
  sex: "male"
};

mrDeng.sex = "female";
```

#### 删除一个属性

删除一个属性，需要添加一个属性‘delete’,

> delete 对象名.属性名

这样就会删除对应的属性

```js
例: var mrDeng = {
  sex: "male",
  health: 100,
  fring: function() {
    console.log("I am dring");
  }
};

delete mrDeng.sex;
```

### 3.对象的创建方法

#### 1. var obj = {} `对象字面量 / 对象直接量 plainObject`

#### 2. 构造函数 `系统自带的构造函数 Object() new Object(); Array(); Number(); Boolean(); Date();`

一、系统自带的构造函数

> Object()可以批量生成对象，每一个对象都一样，但是彼此相互独立。

```js
在 Object()前面加个 new，变成 new Object()的执行，就会真正的返回一个对象，通过 return 返回，拿变量接受。var obj = new Object();

var obj = new Object();和 var obj = {};这样写区别不大
```

```js
例:
    var obj = new Object();
        obj.name = ‘abc’;
        obj.sex = “male”;

```
**双引号和单引号都是表示的字符串，写双引号也可以写单引号，但是为了跟后端 php 配合最好写单引号。如果要打印一个单个的引号，用正则表达式转义字符`/* \' */`注意 等号 和 冒号 的用法 `obj.say = function(){} var obj = { name : 'abc'}`**

二、自定义

> Object.create(原型)方法

```js

例:
    function Person(){}

    Person 是可以随便写的，也是构造函数
    构造函数跟函数结构上没有任何区别

例:
    var person1 = new person();

```

> 必须用 new 这个操作符，才能构造出对象

`构造函数必须要按照大驼峰式命名规则，但凡是构造函数就要大写，例如 TheFirNa`

```js

    function Car(){
        this.name = 'BMW';
        this.height = '1400';
        this.lang = '4900';
        this.weight = 1000;
        this.health = 100;
        this.run = function (){
            this.health --;
        }
    }

    var car = new Car();
    var car1 = new Car();

    car.name = 'Maserati';
    car1.name = 'Merz';

    // 在控制台输出时。显示

    // >  car
    // <· Car {name : 'Maserati',height : '1400',lang : '4900',weight : 1000}

    // >  car1
    // <· Car {name : 'Merz',height : '1400',lang : '4900',weight : 1000}
```

`car1 和 car 是长得一样，但是是不同的两个 car。方法名和对象名尽量不一样`

`a 和 A 变量是两个变量，var car = new Car 里面 car 和 Car 是两个变量`

```js
例: function Car(color) {
  this.color = color;
  this.name = "BMW";
  this.height = "1400";
  this.lang = "4900";
  this.weight = 1000;
  this.health = 100;
  this.run = function() {
    this.health--;
  };
}

var car = new Car("red");
var car1 = new Car("green");

// 第一行的 color 可以和上面的参数重复，通过参数，使参数发生变化，变成自定义
```

```js
例: function Student(name, age, sex) {
  this.name = name;
  this.age = age;
  this.sex = sex;
  this.grade = 2017;
}

var student = new Student("zhangsan", 18, "male");
```

### 构造函数内部原理

> 前提必须要加 new，以下三步都是隐式的：

1. 在函数体最前面隐式的加上 var this = {} 空对象

2. 执行 this.xxx = xxx;

3. 隐式的返回 return this

```js
例: function Student(name, age, sex) {
  // var this{
  // name : "";
  // age : "";
  // };
  this.name = name;
  this.age = age;
  this.sex = sex;
  this.grade = 2017;

  //return this;
}

var student = new Student("zhangsan", 18, "male");
```

```js
例:
    function Person(name, height){
        //隐式的 var this = {}，下面正常执行 this
        this.name = name;
        this.height = height;
        this.say = funtion (){
            console.log(this.say);
            //此处的 this 和外面的 this 不同
        }
        // 隐式的 return this;
    }
    console.log(new Person(‘xiaowang’, 180).name);
```

```js
例;
// 也可以这样显式的写出来
function Person(name, height) {
  var that = {}; //显式写出来
  that.name = name;
  that.height = height;
  return that; //显式写出来
}
```

```js
例: function Person(name, height) {
  // var this = {}
  this.name = name;
  this.height = height;
  this.say = function() {
    console.log(this.say);
  };
  return 123;
  // return this;
}

var person = new Person("xiaowang", 180);
var person1 = new Person("xiaozhang", 175);

// 在控制台输出时。显示

// >  person
// <· Person{name : 'xiaowang',height : 180}

// >  person1
// <· Person{name : 'xiaozhang',height : 175}

// 答案现在的 peson 和 person1 都是 Object{}
// 如果 return 写成 return 123，会使 return 失效，如上
```

> 有 new 了以后就不能返回原始值，例如 123

## 包装类

`new String(); new Boolean(); new Number();`

```js
var num =123;  →  原始值数字

只有原始值数字是原始值，原始值不能有属性和方法
```

> 属性和方法只有对象有，包括对象自己，数组，function

```js
例:

    var num = new Number(123);

    // 在控制台输出。显示

    // >  num
    // <· Number{[[PrimitiveValue]]:123}

    // >  num.abc = 'a'
    // <· 'a'

    // >  num.abc
    // <· 'a'

    // >  num
    // <· Number{abc:'a',[[primitiveValue]]:123}

    var num = new Number(123); ——> 构造函数。是对象123，不是原始数字

    // >  num
    // <· Number{[[PrimitiveValue]]:123}

    // >  num * 2
    // <· 246
```
**数字的对象如果参与运算，就会变回原始值，但如果不参与运算，加属性和方法，又可以当对象用，字符串 和`Boolean`类型完全一致。**

### 字符串类型的对象

1. var num = new Nunber(123); `数字类型对象`

2. var str = new String(‘abcd’); `字符串类型对象`

3. var bol = new Boolean(‘true’); `布尔类型对象`

```js
// >  num
// <· Number{[[PrimitiveValue]]:123}

// >  str
// <· String{[[PrimitiveValue]]:abcd}

// >  Boolean
// <· Boolean{[[PrimitiveValue]]:true}
```

> undefined 和 null 不可以有属性

`不能写成 undefined.abc = 123;会报错`

```js
例:
    原始值不可能有属性和方法，但经过了包装类(加隐式)可以调用一些属性与方法

    var num = 4；
    num.len = 3;
    //系统隐式的加上 new Number(4).len = 3; 然后 delete

    console.log(num.len);

    //系统隐式的加上 new Number(4).len; 但是这个 new Number 和上面的 new Number不是同一个，所以返回 undefined

    而上面这些隐式的过程就是包装类


例:
    var str = 'abcd';
    str.length = 2;
    //隐式的加上 new string(‘abcd’).length = 2; 然后delete

    console.log(str);
    console.log(str.length);

    答案是 abcd，4


例:
    var str = 'abc';
    str += 1;
    var test = typeof(str);
    if(test.length == 6){
        test.sign = 'typeof的返回结果可能是 Strings';
    }
    console.log(test.sign);

理解过程:
    str += 1; //abc1

    var test = typeof(str); //test == “string”，返回 string，string 长度是 6

    if(test.length == 6){
        test.sign = “typeof 的返回结果可能为 String”;
        //这是原始值,原始值要赋属性值需要调用包装类，赋了跟没赋值是一样的，new String(test).sign=’xxx’;
    }

    conlogo.log(test.sign); //new String(test).sign
    答案 undefined
```

```js
例题1:
    // 分析一下javasript代码段
    function emproyee(name,code){
        this.name = 'wangli';
        this.code = 'Aoo1';
    }
    var newemp = new emproyee('zhangming',A002);
    document.write('雇员姓名' + newemp.name + '<br>');
    document.write('雇员代号' + newemmp.code + '<br>');

    // 输出结果是（）

    // A. 雇员姓名：wangli 雇员代号 A001
    // B. 雇员姓名：zhangming 雇员代号 A002
    // C. 雇员姓名：null 雇员代号 null
    // D. 输出错误，无输出结果

    答案 A，里面并没有用参数，被写死了，传参不成功


例题2:
    function Person(name,age,sex){
        var a = 0;
        this.name = name;
        this.age = age;
        this.sex = sex;
        function sss(){
            a ++;
            document.write(a);
        }
        this.say = sss;
    }

    var oPerson = new Person();
    oPerson.say();
    oPerson.say();
    var oPerson1 = new Person();
    oPerson1.say();

    // 答案 ：1，2，1


例题3:
    var x = 1,y = z = 0;

    function add(n){
        return n = n + 1;
    }
    y = add(x);
    function add(n){
        return n = n + 3;
    }
    z = add(x);
    // x  y  z

    // 答案: 1, 4, 4


例题4:
    // 下面代码中 console.log 的结果是[1,2,3,4,5]的选项是

    // A.
    function foo(x){
        console.log(arguments);
        return x;
    }
    foo(1,2,3,4,5)

    // B.
    function foo(x){
        console.log(arguments);
        return x;
    }(1,2,3,4,5)

    // C
    (function foo(x){
        console.log(arguments);
        return x;
    })(1,2,3,4,5);

    // D
    function foo(){bar.apply(null,arguments)}
    function bar(x){console.log(arguments)}
    foo(1,2,3,4,5)

    // 答案: ACD


例题5:
    // 请问一下表达式的结果是什么？

    parseInt(3,8);
    parseInt(3,2);
    parseInt(3,0);

    答案:3,NaN，3(有的浏览器遇到 0 进制 是报 NaN)


例题6:
    // 一下那些是 javascript 语言 typeof 可能返回的结果

    A.string     B. array    C.object    D.null

    答案: A、C


例题7:
    // 看看下面 alert 的结果是什么？
    function b (x, y, a) {
        arguments[2] = 10;
        alert( a );
    }
    b(1, 2, 3);
    // 如果函数体改成下面，结果又会是什么？
    a = 10；
    alert(arguments[ 2 ]);

    答案 10，10


例题8:
    写一个方法，求一个字符串的字节长度。(提示：字符串有一个方法 charCodeAt(); 一个中文占两个字节，一个英文占一个字节。)

    定义和用法:
    charCodeAt(); 方法可返回指定位置的字符的 Uncode 编码，这个返回值是0 - 65535 之间的整数。(当返回值是 <=255时为英文，当返回值 >255时为中文)

    语法:
    stringObject.charCodeAt(index)

    eg:
    <script type = 'javascrip/text'>

        var str = "Hello word"
        document.write(str.charCodeAt(1))  //输出101

        var str = 'hello world 邓哥身体好';
        str.charCoeAt(0); // 输出 104

        var str = 'hello world 邓哥身体好';
        for(var i = 0;i < str.length; i ++){
            console.log(str.charCodeAt(i));
        }

    </script>

    解题

    方式1:
        var str = '1111111111111';

        function bytesLength(str){
            var count = 0;
            for(var i = 0;i < str.length; i++){
                if(str.charCodeAt(i) > 255){
                    count += 2;
                }else{
                    count ++;
                }
            }
            return count; // 闭包
        }
        var Str = bytesLength(str); //Str 接受闭包

    方式2:
        var str = "222222222222";

        function bytesLength(str){
            var count = str.length;
            for(var i = 0; i < str.length; i++){
                if(str.charCodeAt(i) > 255){
                    count ++;
                }
            }
            return count; // 闭包
        }
        var Str = bytesLength(str); //Str 接受闭包

小于等于 255 是一个字节，
大于是两个字节
返回值大于 255 是中文
上面 是两种方法 → Unicode 编码涵盖 asc 码
```

# 原型

1. 定义：原型是 function 对象的一个属性，它定义了构造函数制造出的对象的公共祖先。通过该构造函数产生的对象，可以继承该原型的属性和方法。原型也是对象。

2. 利用原型特点和概念，可以提取共有属性。

3. 对象属性的增删和原型上属性增删改查。

4. 对象如何查看原型 ==> 隐式属性 __proto__。

5. 对象如何查看对象的构造函数 ==> constructor。

## prototype

> 原型，一种继承关系，出生（一开始）就被定义好了

```js
例:
person.prototype //原型（描述一种继承关系），出生时就被定义好了

person.prototype = {} //是祖先

// Person.prototype  ————>  原型
// Person.prototype  ————>  祖先（原型）
Person.prototyp.name = 'hehe';
function Person(){

}
var person = new Person();
var person1 = new Person();


// 在控制台输出:

// >  person
// <· Person{}

// >  person.name
// <· 'hehe'

右上的 person 和 person1 都有一个共有的祖先 Person.prototype
```

```js
     // Person.prototype  ————>  原型
例1: // Person.prototype  ————>  祖先（原型）
Person.prototype.LastName = "Deng";
Person.prototype.say = function() {
  console.log("hehe");
};
function Person() {
  this.LastName = "Ji";
}
var person = new Person();
var person1 = new Person();

// 在控制台输出:

// >  person.LastName
// <· 'Ji'
```

```js
     // person.prototype  ————>  原型
例2: // Person.prototype  ————>  祖先（原型）
Person.prototype.LastName = "Deng";
Person.prototype.say = function() {
  console.log("hehe");
};
function Person(name, age, sex) {
  this.name = name;
  this.age = age;
  this.sex = sex;
}
var person = new Person("xuming", 35, "male");

// 在控制台输出:

// >  person
// <· Person{name:'xuming',age:35,sex:'male'}

// >  person.name
// <· 'xuming'

// >  person.LastName
// <· 'Deng'
```

> 自己身上有需要的属性，原型上也有属性，取近的，用自己的

```js
例:
  1)
    // person.prototype  ————>  原型
    // Person.prototype  ————>  祖先（原型）
    function Car(color,owner){
        this.carName = 'BMW';
        this.height = 1400;
        this.lang = 4900;
        this.owner = owner;
        this.color = color;
    }

    var car = new Car('red','prof.ji');

// 将 1) 上面代码提取出来放在原型里面就如 2)

  2)
    // person.prototype  ————>  原型
    // Person.prototype  ————>  祖先（原型）
    Car.prototype.height = 1400;
    Car.prototype.lang = 4900;
    Car.prototype.carName = 'BMW';
    function Car(color,owner){

        this.owner = owner;
        this.color = color;
    }

    var car = new Car('red','prof.ji');
    var car = new Car('green','laodeng');
```

```js
// person.prototype  ————>  原型
例: // Person.prototype  ————>  祖先（原型）
Person.prototype.lastName = "Deng";
function Person(name) {
  this.name = name;
}
var person = new Person("xuming");

// 在控制台打印:

// >  person.lastName = 'James';
// <· 'James'

// >  person
// <· Person{name : 'xuming',lastName : 'James'}

// >  person.lastName
// <· 'James'
```

> 上面通过对象（后代）改原型（祖先）是不行的，在对象里面修改，只是作用给自己的，给自己加了一个属性。改原型都不行，增加肯定也不行。对象可以删除属性

```js
例:
  1)
    // person.prototype  ————>  原型
    // Person.prototype  ————>  祖先（原型）
    Person.prototype.height = 1400;
    Person.prototype.lang = 4900;
    Person.prototype.carName = 'BMW';
    function Car(){

    }
    var pereson = new Person('xuming');

// 1) 的简化写法见 2):

  2)
    // person.prototype  ————>  原型
    // person.prototype  ————>  祖先（原型）
    Car.prototype = {
        height : 1400,
        lang : 4900,
        carName : BMW
    }

    function Car(){

    }
    var car = new Car();
```

## constructor

`constructor 是构造的意思`

> 原型内部自带 constructor，指的是 Car。通过 constructor 能找的谁构造的自己

```js
7例1:
    function Car(){

    }
    var car = new Car();

    // 在控制台中输出:

    // >  car.constructor
    // <· function Car(){}

    // >  Car.prototype
    // <· Object{
    //        constructor:Car()  ————>  粉色字体
    //        __proto__:Object   ————>  粉色字体
    //    }

construnctor 是构造的意思(隐式是浅粉色)

例2:
    //Person.prototype  ————> 原型
    //Person.prototype  ————> 祖先（原型）
    Car.prototype.abc = '123';
    function Car(){

    }
    var car = new Car();

    // 在控制台中输出:

    // >  Car.prototype
    // <· Object{
    //      abc : '123'  ————>  紫色字体
    //      constructor:Car()  ————>  粉色字体
    //      __proto__:Object   ————>  粉色字体
    //    }

粉红色是系统帮你设置的，深紫色是自己设置的
```

> 在原型内部自带 constructor，指的是 Car。通过 constructor 能找的谁构造的自己，也可以通过 constructor 来改变自己的构造对象

```js
例:
    // Person.prototype  ————>  原型
    // Person.prototype={}  ————>  祖先(原型)

    function Person(){

    }
    Car.prototype = {
        constructor : Person
    }
    function Car(){}
    var car = new Car();

    // 在控制台输出:

    // >  car.constructor
    // <· function Person(){
    // }

// car的构造对象本来是 function Car(){} 但是经过 constructor属性 的更改，car的构造对象变成了 function Person(){}, constructor属性也可以，找构造函数所对应的构造对象。

constructor 可以被人工手动更改
```

## **proto**

```js
例: Person.prototype.name = "abc";
function Person() {
  //var this = {
  // __proto__: Person.prototype
  // }

}

var person = new Person();

// 在控制台输出:

// >  person
// <· Person{
//      __proto__ : Object{
//          constructor:Person()
//          __protot__:Object
//      }
// }

// >  person.__proto__
// <· Object{
//          constructor : Person()  ————> 粉色字体
//          name : 'abc'            ————> 紫色字体
//          __proto__ : Object      ————> 粉色字体
//      }
// }
```

```js
浅粉色的__proto__是系统的隐式的属性,前面两个_后面两个_，可以修改，尽量不改。

在开发的时候，如果很私人可以写成_private，告诉同事别动。

上面的__proto__放的是原型。__proto__存的对象的原型

上面的 var this ={__proto__:person.prototype};这个对象并不是空的，这个 proto，当你访问这个对象的属性时，如果对象没有这个属性，那么就会访问 proto 索引，看看有没有。有一个连接的关系，原型和自己连接到一起
```

```js
例: Person.prototype.name = "abc";
function Person() {
  //var this = {
  // __proto__ : Person.prototype
  //}
}
var obj = {
  name: "sunny"
};
var person = new Person();
person.__proto__ = obj;

// 在控制台输出:

// >  person.__proto__
// <· Object{name : 'abc'}

// >  person.__proto__ = obj
// <· Object{name : 'sunny'}

// >  person.name
// <· 'sunny'
```

> Person 的原型是可以被修改的

## 补充

```js
例: Person.prototype.name = "sunny";
function Person() {}
var person = new Person();
Person.prototype.name = "cherry";

// 从控制器输出:

// > person.name
//<· 'cherry'
```

```js
例: Person.prototype.name = "sunny";
function Person() {}
Person.prototype.name = "cherry";
var person = new Person();

// 从控制器输出:

// > person.name
//<· 'cherry'
```

```js
例: Person.prototype.name = "sunny";
function Person() {
  //var this = {__proto : Person.prototype}
}
var person = new Person();
Person.prototype = {
  name: "cherry"
};

// 从控制器输出:

// > person.name
//<· 'sunny'
```

```js
Person.prototype.name 这种.的写法是在原有的基础上把值改了。改的是属性，也就是房间里面的东西。

而 Person.prototype={name:'cherry'}是把原型改了，换了新的对象。改了个房间。

上面在 new 的时候 var this = {__proto__:Person.prototype}里面的指向 Person，此时Person.prototype 与__proto__指向的是一个空间，把他返回给 var person。

先 new 再 Person.prototype={name:'cherry'}已经晚了

在 Person.prototype={name:'cherry'}时，Person.prototype 空间改了，但是__proto指向的空间不变。
```

```js
上面的步骤实际（简化）上是→

    Person.prototype = {name : 'a'};
    __proto__ = Person.prototype;
    Person.prototype = {name : 'b'};
```

```js
例: var obj = { name: "a" };
    var obj1 = obj;
    obj = { name: "b" };

// 从控制台输出:

// >  obj1
// <· Object{name:'a'}

// >  obj
// <· Object{name:'b'}
```

```js
例:
    Person.prototype.name = 'sunny';
    function Person(){
        //var this = {__proto : Person.prototype}
    }
    Person.prototype = {
        name : 'cherry'
    }
    var person = new Person();

    上面这种思考过程：程序执行顺序

1.先把 function Person(){}在预编译的过程中提到最上面
2.再执行 Person.prototype.name = 'sunny'这一样行
3.再执行 Person.prototype = {name:'cherry'}
4.最后执行 var person = new Person();执行到 new 的时候，才会发生    //var this={__proto__:Person.prototype}
5.下面的把上面的覆盖了
6.答案是 cherry
```

> 铺垫原型链

```js
例: function Person() {}

// 从控制台输出:

// >  Person.prototype
// <· Object
//     > constructor : Person()
//     > __proto__ : Object

// 这说明原型里面有原型
```

```js
例: 原型链

Grand.prototype.lastName = "Deng";
function Grand() {}
var grand = new Grand();

Father.prototype = grand;
function Father() {
  this.name = "xuming";
}

var father = new Father();

Son.prototype = father;
function Son() {
  this.hobbit = "smoke";
}
var son = new Son();

// 从控制台输出时:

// >  son.hobbit
// <· 'smoke'
// >  son.name
// <· 'xuming'
// >  son.lastName
// <· 'Deng'

// >  Grand.prototype
// <· Object
//     ·> constructor : Gran()
//         lastName : 'Deng'
//     ·> __proto__ : Object
//         ·> __defineGetter__;
//         ·> __defineSetter__;
//         ·> __lookupGetter__;

// >  Object.prototype
// <· Object{}
// >  Object.prototype.__proto__
// <· null
```

```js
执行 son.toString //返回 function toString( ){ [native code] }，这里返回的是原型链终端的 toString

Grand.prototype.__proto__ = Object.prototype // Object.prototype 是原型链的终端
```

## 原型链

```js
1、如何构成原型链?(如下)

原型链

    Grand.prototype.lastName = 'Deng';
    function Grand(){

    }
    var grand = new Grand();

    Father.prototype = grand;
    function Father(){
        this.name = 'xuming';
    }

    var father = new Father();

    Son.prototype = father;
    function Son(){
        this.hobbit = 'smoke';
    }
    var son = new Son();


    // 从控制台输出时:

    // >  son.hobbit
    // <· 'smoke'
    // >  son.name
    // <· 'xuming'
    // >  son.lastName
    // <· 'Deng'

    // >  Grand.prototype
    // <· Object
    //     ·> constructor : Gran()
    //         lastName : 'Deng'
    //     ·> __proto__ : Object
    //         ·> __defineGetter__;
    //         ·> __defineSetter__;
    //         ·> __lookupGetter__;

    // >  Object.prototype
    // <· Object{}
    // >  Object.prototype.__proto__
    // <· null

2、原型链上属性的增删改查，原型链上的增删改查和原型基本上是一致的。只有本人有的权限，子孙是没有的。

3、谁调用的方法内部 this 就是谁-原型案例

4、绝大多数对象的最终都会继承自 Object.prototype

5、Object.create(原型);

6、原型方法上的重写
```

```js
例:
     Grand.prototype.lastName = 'Deng';
    function Grand(){

    }
    var grand = new Grand();

    Father.prototype = grand;
    function Father(){
        this.name = 'xuming'
        this.fortune = {
            card1 : 'visa'
        }
    }
    var father = new Father();

    Son.prototype = father;
    function Son(){
        this.hobbit = 'smoke';
    }
    var son = new Son();


    // 从控制台输出:

    // >  son.fortune
    // <· Object{card1 : 'visa'}
    // >  son.fortune = 200;
    // <· 200
    // >  son
    // <· Son{hobbit : 'smoke',fortune : 200}
    // >  father.fortune
    // <· Object{card1 : 'visa'}
    // >  son.fortune.card2 = 'master'
    // <· 'master'
    // >  son
    // <· Son{hobbit : 'smoke'}
    // >  father
    // <· Grand{name : 'xuming',fortune : Object}
    //     ·> fortune : Object
    //         card1 : 'visa'
    //         card2 : 'master'
    //         __proto__ : Object
    //         name : 'xuming'
    //     ·> __proto__ : Grand

son.fortune.card2='master'这种改，这是引用值自己的修改。属于 fortune.name 给自己修改，这是一种调用方法的修改
```

```js
例:
    Grand.prototype.lastName = 'Deng';
    function Grand(){

    }
    var grand = new Grand();

    function Fahter(){
        this.name = 'xuming';
        this.fortune = {
            card1 : 'visa'
        };
        this.num = 100;
    }

    var father = new Father();

    Son.prototype = father;
    function Son(){
        this.hobbit = 'smoke'
    }
    var son = new Son();


    // 从控制台输出

    // >  son.num++
    // <· 100

    // >  father.num
    // <· 100

    // >  son.num
    // <· 101

son.num++ 是 son.num = son.num+1，是先把父级的取过来再赋值+1，所以父级的没变
```

```js
例: Person.prototype = {
  name: "a",
  sayName: function() {
    console.log(this.name);
  }
};
function Person() {}
var person = new Pereson();

// 从控制台输出:

// >  person.sayName()
//    a
// <· undefined

console.log(this.name); //如果写成 name 就会错，没有这个变量
```

```js
例:
    Person.prototype = {
        name : 'a';
        sayName : function(){
            console.log(this.name);
        }
    }

    function Pereson(){
        this.name = 'b';
    }
    var person = new Person();

    // 从控制台输出

    // >  person.sayName()
    //    b
    // <· undefined

    // >  person.prototype.sayName()
    //    a
    // <· undefined


a.sayName() 方法调用，就是 sayName 里面的 this 指向，是谁调用的这个方法，this 就指向谁
```

```js
例:
  1)
    Person.prototype = {
        height : 100
    }

    function Person(){
        this.eat = function(){
            this.height ++;
        }
    }
    var person = new Person();

    // 控制台输出:

    // >  person.eat()
    // <· undefined

    // >  person
    // <· Person{height : 101}

    // >  person.__proto__
    // <· Object{height : 100}


this.height ++; //这后面默认有一个 return undefined

  2)
    Person.prototype = {
        height : 100
    }

    function Person(){
        this.eat = function(){
            this.height ++;
            return 123;
        }
    }

    var person = new Person();

    // 控制器输出:

    // >  person.eat()
    // <· 123
```

```js
例:
    var obj = {}；也是有原型的
    var obj = {}; 与 var obj1 = new Object(); 的效果是一样的
    写 var obj = {}; 系统会在内部来一个 new Object();
    obj1.__proto__  ————>  Object.prototype;
    但是在构造对象的时候，能用对象自变量 var obj = {}; 就不要用 var obj1 = new Object();

  1)
    Person.prototype = {}  ————>  Object.prototype
    funtion Person(){

    }
    对象自变量的原型就是 Object.prototype;
```

## Object.create 原型

`var obj = Object.create(原型)`

> Object.create 也能创建对象。var obj = Object.create(这里必须要有原型)

```js
//var obj = Object.create(原型)
例: var obj = { name: "sunny", age: 123 };
var obj1 = Object.create(obj);

// 从控制台输出:

// >  obj1
// <· Object {}

// >  obj1.name
// <· 'sunny'
```

```js
例:
    //var obj = Object.create(原型)
    Person.prototype.name = 'sunny';
    function Person(){

    }
    var person = Object.create(Person.prototype);


绝大多数对象的最终都会继承自 Object.prototype


// 如: 控制台输出

// html 里面没有添加任何东西，这样就会报错
//     >  Object.create()
//     <· 报错


// html里面没有添加任何东西，只在控制台加上null
//     >  Object.create(null)
//     <· Object
//         No Properties


// var obj = Object.create(null);
//     >  obj.name = 123;
//     <· 123
//     >  obj
//     <· Object
//         name : 123
//     >  obj.__proto__ = {name : 'sunny'}
//     <· Object{name : 'sunny'}
//     >  obj
//     <· Object{}
//     >  obj.name
//     <· undefined

//     >  obj.toString()
//     <· 报错
```

`原型是隐式的内部属性，你加是没有用的`

```js
例:
    //var obj = Object.create(原型)
    var obj = Object.create(123); // 在控制台中会报错


Object.create() 在括号里面只能放 null 或者 Object,其余会报错
undefined 和 null 没有原型，也就不可能有 toString 方法,如下:

    // 控制器输出

    // >  undefined.toString()
    // <· 报错
    // >  null.toString()
    // <· 报错
```

```js
例1:
下面 123.toString 首先会识别成浮点型，所以在后面直接加.toString 是不行的

    // >  true.toString()
    // <· 'true'

    // >  123.toString()
    // <· 报错

    // >  var num = 123;
    // <· undefined
    // >  num.toString()
    // <· '123'

    // >  var obj = {}
    // <· undefined
    // >  obj.toString()
    // <· '[object Object]'


数字想用 toString 方法，要经过包装类包装 new Number(num) 然后.toString

例2:加深上面的理解
    var num = 123;
    //num.toString(); ————>  new Number(num).toString();
    Number.prototype.toString = function(){

    }
    //Number.prototype.__proto__ = Object.prototype

而 new Number(num). toString 的原型是 Nunber.prototype，而 Number.prototype 上面有一个.toString 方法，Number.prototype 也有原型 Number.prototype.__proto__，原型是Object.prototype

假如 new Number 上面的 prototype 上面有这个 toString，那么就不用Object.prototype的 toString。而这个 number 上面有这个 toString。

然后 number 上面的 toString 调用的是自己重写的 toString。

原型上有这个方法，我自己又写了一个和原型上同一名字，但不同功能的方法，叫做重写（同一名字的函数，不同重写方式）

通过返回值，形参列表不同传参

同样的名实现不同功能的，就是重写

    var num = 123;
    // num.toString();  ————>  new Number(num).toString();
    Number.prototype.toString = function(){

    }
    // Number.prototype.__proto__ = Object.prototype
    // Object.prototype.toString = function(){}
```

```js
例:
  1)
    // var obj = Object.create(原型)
    // Object.prototype.toString = function(){

    // }
    Person.prototype = {

    }
    function Person(){

    }
    var person = new Person();

    // 控制台输出:

    // >  person.toString()
    // <· '[object Object]'

和原型链上终端方法名字一样，但实现不同的功能，叫做方法的重写。也就是覆盖

  2)
    // var obj = Object.create(原型);
    //Object.prototype.toString = function(){

    // }
    Person.prototype = {
        toString : function(){
            return 'hehe';
        }
    }
    function Person(){

    }
    var pereson = new Person();

    // 控制台输出:

    >  person.toString()
    <· 'hehe'

下面这个也是重写:

  3)
    // var obj = Object.create(原型);

    object.prototype.toString = function(){
        return 'haha';
    }
    Person.prototype = {

    }
    function Person(){

    }
    var person = new Person();

    // 控制器输出:

    >  person.toString()
    <· 'haha'
```

```js


让上面的 1)、2)、3) 中的 object 上面的 toString 重写了。
所以num.toString()调用的是 number.prototype.toString。

    Object.prototype.toString
    Number.prototype.toString
    Array.prototype.toString
    Boolean.prototype.toString
    String.prototype.toString


    // 控制器输出:
    // >  var num = 123;
    // <· undefined
    // >  num.toString()
    // <· '123'

如果调用的是 object. prototype.toString 结果会不一样。

    // >  Object.prototype.toString.call(123)
    // <· '[object Number]'
    // >  Object.prototype.toStrin.call(true)
    // <· '[object Boolean]'
```

```js
例:
  1)
    Number.prototype.toString = function(){
        return '老大身体好';
    }

    // 控制台输出:

    // >  var num = 123;
    // <· undefined
    // >  num.toString()
    // <· '老邓身体好'

  2)
     var obj = 123;
     document.write(obj);
// 答案:123

  3)
    var obj = {};
    document.write(obj);
// 答案:[object Object]

  4)
    var obj = Object.create(null);
    document.write(obj);
//  答案:报错
// 解析: document.write 会隐式的调用 toString 方法，其实打印的是 toString的结果

    var obj = Object.create(null);
    document.write(obj.toString());

// 没有原型就不能 toString

  5)
    var obj = Object.create(null);
    obj.toString = function (){
        return '老大身体好'；
    }
    document.write(obj);
// 答案: 老邓身体好
```

> 上面这个例子表示：我要打印的是 obj，实际上打印出来的是 toString 方法，也证明了 document.write 调用的是 toString 方法

## call / apply

> 作用，改变 this 指向。 `区别，后面传的参数不一样`

```js
toFixed 是保留两位有效数字

例:有一个 bug,在控制台 0.14 * 100
// 答案 : 1400000000000002,是js开发精度不精准

例:向上取整 Math.ceil(123.234)
// 答案 124

例:向下取整 Math.floor(123.999)
// 答案 123

例: Math.random()是产生一个 0 到 1 区间的开区间 随机数

例: for(var i = 0; i < 10;i ++){
    var num = Math.random().toFixed(2) * 100;
    console.log(num);
}//所以一般在这种情况下，我们不用 toFixed，因为精度不准确

例:用这种方法取整更好，就不会精度不准确
    for(var i = 0;i < 10; i++){
        var num = Math.floor(Math.random() * 100);
        console.log(num);
    }

注意：之前 js 在小数点后面最多能容纳 15-17 位，但是升级后能用科学计数法表示
如 2e-17（是 2 乘以 10 的负 17 次方）
而小数点前面只能容纳 16 位的运算， 可正常计算的范围是小数点前后 16 位
```

```js
// 任何一个方法都可以 .call ,.call 才是一个方法执行的真实面目

例: function Persom(name, age) {
  // this == obj
  this.name = name;
  this.age = age;
}
var person = new Person("deng", 100);
var obj = {};
Person.call(obj, "Yu", 300);

// test() ————> test.call()
```

```js
直接执行 Person.call ( )和 Person ( )没有区别

Person.call( );括号里面可以传东西

如果 Person.call( obj );里面的 call 让 person 所有的 this 都变成 obj

不 new 的话，this 默认指向 window。call 的使用必须要 new

call 的第一位参数用于改变 this 指向，第二位实参（对应第一个形参）及以后的参数都当做正常的实参，传到形参里面去借用别人的方法，实现自己的功能。
```

> 例写 test（）和写 test.call（）是一样的

```js
例:
    function Person(name,age,sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    function Student(name,age,sex,tel,grade){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.grae = grade;
    }
    var student = new Student('sunny',123,'male',139,2019);

call 改变 this 指向，借用别人的函数，实现自己的功能。
只能在你的需求完全涵盖别人的时候才能使用
如果不想要 age 这个，就不能使用这种方法：如下

    function Person(name,age,sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    function Student(name,age,sex,tel,grade){
        //var this = {name : '',age : '',sex : ''};
        Person.call(this,name,age,sex);
        this.tel = tel;
        this.grade = grade;
    }

    var student = new Studnet('sunny',123,'male',139,2019);

Person.call(this, name, age, sex);里面的 this 现在是 new 了以后的 var this={}
利用 Person 方法，实现了 Student 自己的封装
```

```js

    function Wheel(wheelSize,style){
        this.style = style;
        this.wheelSize = wheelSize;
    }
    function Sit(c,sitColor){
        this.c = c;
        this.sitColor = sitColor;
    }
    function Model(height,widht,len){
        this.height = height;
        this.widht = widht;
        this.len = len;
    }

    function Car(wheelSize,style,c,sitColor,height,widht,len){
        Wheel.call(this,wheelSize,style);
        Sit.call(this,c,sitColor);
        Model.call(this,height,widht,len);
    }
    var car = new Car(100,'花里胡哨','真皮','red',1800,1900,4900);
```

`apply 也是改变 this 指向的，只是传参列表不同，第一位也是改变 this 指向的人，第二位，apply 只能传一个实参，而且必须传数组 argunments`

`call 需要把实参按照形参的个数传进去`

`new以后才有意义`

```js
function Wheel(wheelSize,style){
        this.style = style;
        this.wheelSize = wheelSize;
    }
    function Sit(c,sitColor){
        this.c = c;
        this.sitColor = sitColor;
    }
    function Model(height,widht,len){
        this.height = height;
        this.widht = widht;
        this.len = len;
    }

    function Car(wheelSize,style,c,sitColor,height,widht,len){
        Wheel.apply(this.[wheelSize,style]);
        Sit.apply(this,[c,sitColor]);
        Model.apply(this,[height,widht,len]);
    }
    var car = new Car(100,'花里胡哨','真皮','red',1800,1900,4900);
```

## 继承发展史

### 一、 传统形式 ==> 原型链

```js
例: Grand.prototype.lastName = "Ji";
function Grand() {}
var grand = new Grand();

Father.prototype = grand;
function Father() {
  this.name = "hehe";
}

var father = new Father();

Son.prototype = father;
function Son() {}
var son = new Son();
```

### 二、借用构造函数 ==> 利用 call、apply

`所以不算标准的集成模式`

`1）不能继承借用构造函数的原型`

`2）每次构造函数都要多走一个函数 ==> 浪费效率`

this 放进去的前提，这个函数必须是 new 来的

```js
例: function Person(name, age, sex) {
  this.name = name;
  this.age = age;
  this.sex = sex;
}
function Student(name, age, sex, grade) {
  Person.call(this, name, age, sex);
  this.grade = grade;
}
var student = new Student();
```

### 三、共享原型（比较好的继承方法，不能随便改动自己的原型）

```js
例: Father.prototype.lastName = "Deng";
function Father() {}
function Son() {}
Son.prototype = Father.prototype;
var son = new Son();
var father = new Father();

// 从控制台输出:

// >  son.lastName
// <· 'Deng'

// >  father.lastName
// <· 'Deng'
```

`例:可以用上面的方式封装函数，实现一个继承`

`extend 和 inherit 都是继承的意思`

`inherit 是 css 的一个值，也是继承的意思。`

`文字类属性都有要给传递的特性:子元素没有设置文字类属性，子元素默认继承父元素的属性。`

`font-size:inherit(我没有继承父亲的)`

`在 inherit（Target，Origin）里面传进去的值是构造函数，需要大驼峰式书写，origin是（原始）的意思，让 target（目标）继承 origin`

```js
例:
    Father.prototype.lastName = 'Deng';
    function Father(){

    }
    function Son(){

    }
    function inherit(Target,Origin){
        Target.prototype = Orign.prototype
    }
    inherit(Son,Father);
    var son = new Son();
    var father = new Father();

    // 从控制台输出:
    // >  son.lastName
    // <· 'Deng'

// 上面这种方式，让 son 里面有了 father 原型的属性
// 应该是inherit继承，后使用
// 下面这种情况就是先继承了，后改变原型已经晚了，因为他继承的还是原来的空间


    Father.prototype.lastName = 'Deng';
    function Father(){

    }
    function Son(){

    }
    function inherit(Target,Origin){
        Target.prototype = Origin.prototype;
    }
    var father = new Father();
    var son = new Son();
    inherit(Son,Father);

// 下面这种写法，son.prototype 和 father.prototype 指向的是一个房间，改 son 就改了father。我们希望 son 用的 father 的原型，但是改变 son 自己的属性不影响 father


    Father.prototype.lastName = 'Deng';
    function Father(){

    }
    function Son(){

    }
    function inherit(Target,Origin){
        Target.prototype = Origin.prototype;
    }
    inherit(Son,Father);
    var son = new Son();
    var father = new Fahter();

    // 从控制台输出:
    // >  son.sex
    // <· 'male'
    // >  father.sex
    // <· 'male'
```

### 四、圣杯模式

`圣杯模式是在方法三的共有原型的基础上有所改变`

`共享原型是：son.prototype = father.prototype`

圣杯模式是：另外加个构造函数 function F(){} 当作中间层，然后让 F 和 father 共有一个原型 F.prototype = father.prototype,然后 son.prototype = new F();使用原型链形成了继承关系，现在改 son.prototype 就不会影响 father.prototype

```js
// Father.prototype

function F(){}
F.prototype  = Father.prototype;

Son.prototype = new F();
```

```js
例:
    function inherit(Target, Origin) {
        function F() {}
        F.prototype = Origin.prototype;
        Target.prototype = new F();
    }
    Father.prototype.lastName = "Deng";
    function Father() {}
    function Son() {}

    inherit(Son, Father);
    var son = new Son();
    var father = new Father();

// 从控制台输出：
// > father.lastName
// <· 'Deng'
// > son.lastName
// <· 'Deng'

// > Son.prototype.sex = 'male';
// <· 'male'
// > son.sex
// <· 'male'
// > father.sexx
// <· undefined
// > Father.prototype
// <· Object{lastName:'Deng'}
```

`son.__proto__ --> new F().__proto__ --> Father.prototype`

```js
例:
    原型上默认有个 constructor，constructor 默认值指向他的构造函数，son.constructor 应该指向 Son

    // > son.constructor
    // <· function Father(){}

    所以指向了 father 就是混乱了，所以指一下，如下:

例:
    function inherit(Target,Origin){
        function F(){};
        F.prototype = Origin.prototype;
        Target.prototype = new F();
        Target.prototype.constructor = Target; //----> 让它的 constructor 可以指向自己
        Target.prototype.uber = Origin.prototype; //----> 让它可以知道自己继承自谁
    }
    Father.prototype.lastName = 'Deng';
    function Father(){}
    function Son(){}
    inherit(Son,Father);
    var father = new Fahter();
    var son = new Son();

// Target.prototype.uber = Origin.prototype;
```
**我们希望我们构造出的对象，能找到自己的超类，超级父级（究竟继承自谁）应该起名为super 但这个是保留字，我们就以 uber 命名。**

```js
// 左下这种方法就不好使了，相当于右下。还是原型指向有问题，new 的时候用的是原来的原型，再 F.prototype =father.prototype 没用，son.prototype 没发生改变

例:
function inherit(Target, Origin) {
    function F() {}
    F.prototype = Origin.prototype();
    Target.prototype = new F();
    Target.prototype.constructor = Target;
    Target.prototype.uber = Origin.prototype;
}
Father.prototype.lastName = "Deng";

function Father() {}

function Son() {}
inherit(Son, Father);
var son = new Son();
var father = new Father();
```

```js
// 例，在雅虎时代，封装了 YUI3 库来解决方法三的不足，与圣杯模式相似。现在不用
// YUI3 库，现在用 jquery

// 正常：
function inherit(Target,Origin){
    function F(){};
    F.prototype = Origin.prototype;
    Target.prototype = new F();
    Target.prototype.constructor = Target;
    Target.prototype.uber = Origin.prototype;
}
// 雅虎：
var inherit = (function (){
    var F = function ()'{};
    return function (Target,Origin){
        F.prototype = Origin.prototype;
        Target.prototype = new F();
        Target.prototype.constructor = Target;
        Target.prototype.uber = Origin.prototype;
    }
}())

// 上面的 var inherit 与右边的 var inherit 是一样的意思,建议写上面的这种

var inherit = (function(){
    var F = function (){};
    function demo(Target,Origin){
        F.prototype = Origin.prototype;
        Target.prototype = new F();
        Target.prototype.constructor = Target;
        Target.prototypu.uber = Origin.prototype;
    }
    return demo;
}())
```

### 闭包、属性私有化、封装

```js
例为什么在外部执行的 divorce 能用内部的变量？能换成 xiaozhang？

因为 this.divorce 在对象上，由于对象被返回了，这个方法也被返回了。
因为闭包。这个函数被储存到了外部，所以储存了这个函数的执行期上下文。

所以可以用这个闭包。所以 var prepareWife 被下面的 this = fn 三个函数共用，这三个函数分别与 fn Deng 形成了闭包，共同用 Deng 的 AO,所以可以在外部随意存取。
```

```js
例:
     function Deng(name,wife){
         var prepareWife = 'xiaozhang';

         this.name = name;
         this.wife = wife;
         this.divorce = function (){
             this.wife = prepareWife;
         }
         this.changePrepareWife = funtion(target){
             prepareWife = target;
         }
         this.sayPrapreWife = function(){
             console.log(prepareWife);
         }
     }
     var deng = new Deng('Deng','xiaoliu');

    //  从控制器输出:

    // >  deng
    // <· Deng
    //     > changePrepareWife(target)
    //     > divorce:()
    //         name : "deng"
    //     > sayPrapreWife:()
    //         wife : 'xiaoliu'
    //     > __proto__ : Object

    // >  deng.divorce()
    // <· undefined
    // >  deng.wife
    // <· 'xiaozhang'
    // >  deng.prepareWife
    // <· undefined
```

deng.prepareWife 是 undefined 的，表面上看起来不是自己的，但是`实际上只有对象自己通过对象自己设置的方法可以去操作他，外部用户通过对象，prepareWife 是看不到的`，只有自己能看到，就是闭包的私有化运用。

```js
例: var inherit = (function() {
  var F = function() {};
  return function(Target, Origin) {
    F.prototype = Origin.prototype;
    Target.prototype = new F();
    Target.prototype.constructor = Target;
    Target.prototype.uber = Origin.prototype;
  };
})();
// 执行完是这个样子
var inherit = function(Target, Origin) {
  F.prototype = Origin.prototype;
  Target.prototype = new F();
  Target.prototype.constructor = Target;
  Target.prototype.uber = Origin.prototype;
};
```

`上面的 var F 这个 F 形成了闭包，成为了这个函数的私有化变量，而且变成私有化变量就更好`

# 命名空间（对象模块化开发,其实就是对象）

> 管理变量，防止污染全局，适用于模块化开发

`多人开发，对象命名容易重复，就要解决命名空间的问题`

```js
以前的命名空间老旧的解决方法，如下：

    var org = {
        department1 : {
            jicheng : {
                name : 'abc',
                age : 123
            },
            xuming : {

            }
        }，
        departmeng2 : {
            zhangsan : {

            },
            lisi : {

            }
        }
    }

// 这是用的写法
    var jicheng = org.department1.jicheng;
    jicheng.name
```

`下面是现在公司最常见的方法：用闭包来解决（也可用 webpack），返回方法的调用。init 是初始化，入口函数，入口名字。init 调用了这个函数的功能`

```js

    var name = 'bcd';

    var init = (function(){
        var name = 'abc';
        function callName(){
            console.log(name);
        }
        return function(){
            callName();
        }
    }())

    var initDeng = (function(){
        var name = 123;
        function callName(){
            console.log(name);
        }
        return function (){
            callName();
        }
    })

    init();
    initDeng();

    // 从控制台输出:
    // >  init()
    //    abc
    // <· undefined

    // >  initDeng()
    // <· 报错

    // >  initDeng()
    //    123
    // <· undefined
```

# 思考问题（连续调用）

> 如何实现调用模式（模仿 jquery）

`obj.eat().smoke().drink().eat().sleep;`

```html

<div></div>
<script>
  $("div")
    .css("background-color", "red")
    .width(100)
    .height(100)
    .html(123)
    .css("postion", "absolute")
    .css("left", "100px")
    .css("top", "100px");
</script>
```

```js
例:
    var deng = {
        smoke : function(){
            console.log('Smoke,…… xuan cool!!!');
        },
        drink : function(){
            console.log('drinking……,ye cool!');
        },
        perm : function(){
            console.log('preming……，cool');
        }
    }
    deng.smoke();
    deng.drink();
    deng.prem();

// 不能连续调用 deng.smoke().drink();

上面改成下面的写法:用return this，就可以连续调用和执行了。deng.smoke().drink()


    var deng = {
        smoke : function(){
            console.log('Smoke,... xuan cool!!!');
            return this;
        },
        drink : function(){
            console.log('drinking...,ye cool!');
            return this;
        },
        prem : function(){
            console.log('preming..., cool!');
            return this;
        }
    }
    deng.smoke().drink().perm().smoke().drink();

// 上面使用 return this 连续的调用
```

# 属性的表示方法（查看属性）

`obj.prop 查看就用 .prop`

`obj["prop"] 中括号也是访问属性的方法`

```js
想要传出去序号几，就会调用几

// 下面的是老旧办法


    var deng = {
        wife1 : {name : 'xioaliu'},
        wife2 : {name : 'xiaozhang'},
        wife3 : {name : 'xiaomeng'},
        wife4 : {name : 'xiaowang'},
        sayWife : function(num){
            switch(num){
                case 1:
                    return this.wife1;
                case 2:
                    return this.wife1;
                case 3:
                    return this.wife1;
                case 4:
                    return this.wife1;
            }
        }
    }
    deng.switch(1);

// 上面用 switch 的方法不是很好，下面的方法比较完善一些

// var obj = {name : 'abc'}

// 用方括号来访问属性也是一样的（里面必须是字符串）

// 这两种基本上完全相同 obj.name  --->   obj['name']

// 想要实现属性名的拼接，只能用方括号的形式
    // >  obj.name
    // <· 'abc'
    // >  obj['name']
    // <· 'abc'


    var deng = {
        wife1 : {name : 'xiaoliu'},
        wife2 : {name : 'xiaozhang'},
        wife3 : {name : 'xiaomeng'},
        wife4 : {name : 'xiaownag'},
        sayWife : function(num){
            return this['wife' + num];
        }
    }

```

# 对象的枚举（enumeration）

`for in 循环（简化版 for 循环），目的是遍历对象，通过对象属性的个数来控制循环圈数，这个对象有多少属性循环多少圈，而且在每一圈的时候，都把对象的属性名放到 Prop 里面，在枚举面前，一定要写成 obj[prop]不能加字符串`

`1. hasOwnProperty`

`2. in`

`3. instanceof`

> 枚举也就是遍历，挨个知道信息的过程就叫这个数据组的遍历

## for(变量 in 对象)

```js
例1: var arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
// 遍历 枚举 enumeration
for (var i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}
//for( in ) 循环
例2: var obj = {
  name: "13",
  age: 123,
  sex: "male",
  height: 180,
  weight: 75
};
for (var prop in obj) {
  console.log(prop + " " + typeof prop);
}

// name     string
// age      string
// sex      string
// height   string
// weight   string
```

`上面就是 for in 循环，就是遍历用的。通过对象的属性个数来控制循环圈数，有多少个属性就会循环多少圈。`

`for（var prop in obj）在循环每一圈的时候，他会把对象的属性名放在 prop 里面。`

`想遍历谁就 in 谁，prop 可以写别的，obj 就是我们想要遍历的对象。`

`for(XX in XX) 的格式是固定的。`

```js
// var 也可以写在外面，写成 var key; for(key in obj1) 效果是一样的

var obj1 = {
    a : 123,
    b : 234,
    c : 345
}
var key;
for(key in obj1){
    obj.key ++;
}

写成下面会出错


    var obj = {                         var obj = {
        name : '13',                        name : '13',
        age : 123,                          age : 123,
        sex : 'male',                       sex : 'male',
        height : 180,                       height : 180,
        weight : 75                         weight : 75
                                            prop : 123
    }
    for(var prop in obj){               for(var prop in obj){
        console.log(obj.prop);              console.log(obj.prop);
    }                                   }
    // 答案：undefined * 5              答案：123*6

// 上面的 console.log(obj.prop); 系统以为我们写的是 console.log(obj['prop']);，系统会以为我们是在让他访问 prop 这个属性，不会把 prop 当成一个变量来使用。写成 obj[prop]就可以成功访问了。


    var obj = {
        name : '13',
        age : 123,
        sex : 'male',
        height : 180,
        weight : 75
    }
    for(var prop in obj){
        // console.log(obj.prop  ---->   obj['prop']);
        console.log(obj[prop]);
    }

// 写对象时用方括号的形式不容易犯错


    var obj = {
        name : '13',
        age : 123,
        sex : 'male',
        height : 180,
        weight : 75,
        __proto__ : {
            lastName : 'Deng'
        }
    }
    for(var prop in obj){
        console.log(obj[prop])
    }

    // 答案：13、123、male、180、75、deng
```

## hasOwnProperty

`如果在遍历的时候，我们不想把原型上面的属性拿出来，可以用 hasOwnProperty,一般与 for in 循环成套出现`

`hasOwnProperty 是一个方法，来判断这个对象是你自己的还是原型的，任何要给对象里面都有 hasOwnProperty，里面是需要传参的，把属性传进去（如 prop），下面达到了如果不是自己的属性，是原型上的属性，就不会返回`

```js
例:
    var obj = {
        name : '13',
        age : 123,
        sex : 'male',
        height : 180,
        weight : 75,
        __proto__ : {
            lastName : 'deng'
        }
    }
    for(var prop in obj){
        if(obj.hasOwnProperty(prop)){
            console.log(obj[prop]);
        }
    }
// 答案:  13、123、male、180、75

// 注明：for in 循环理论上可以返回原型和原型链上的东西，一旦这个原型链延展到了的 object.prototype 上，不会打印系统的，只会打印自带的。

var obj = {
    __proto__:{
        lastName : 'deng',
        __proto__ : Object.prototype    // 不会打印这个 object.prototype
    }
}

加 Object.prototype.abc = '123'; 加个 ！变成只有不是它的才打印
    var obj = {
        name : '13',
        age : 123,
        sex : 'male',
        height : 180,
        weight : 75,
        __proto__ : {
            lastName : 'deng'
        }
    }
    for(var prop in obj){
        if(!obj.hasOwnProperty(prop)){
            console.log(obj[prop]);
        }
    }
```

## in

`in 操作符：很少用`

> in 操作符，你的也是你的，你父亲的也是你的，只能判断这个对象能不能访问到这个属性，包括原型上，不是判断属性属不属于这个对象的

```js

    var obj = {
        name : '13',
        age : 123,
        sex : 'male',
        height : 180,
        weight : 75,
        __proto__ : {
            lastName : 'deng'
        }
    }
    for(var prop in obj){
        if(!obj.hasOwnProperty(prop)){
            console.log(obj[prop]);
        }
    }

    // 从控制台输出：
    >  height in obj
    <· 报错
    >  'height' in obj
    <· true
    >  'lastName' in obj
    <· true

// 判断一个属性属不属于这个对象的只能用 hasOwnProperty
```

## instanceof

> instanceof 操作符类似于 in，但是完全不同

`A instanceof B 的意思是 A 的对象是不是 B 构造函数构造函数构造出来的，记住是：看 Ａ 对象的原型链上有没有 B 的原型`

```js
// 解决了
例1：
    function Person(){

    }
    var person = new Person();

    // 从控制器输出 :
    // >  pereson instanceof Object
    // <· true
    // >  [] instanceof Array
    // <· true
    // >  [] instanceof Object
    // <· true

例2：
    function Person(){

    }
    var person = new Person();
    var obj = {};

    // 从控制台输出：
    // >  obj instanceof Person
    // <· false
    // >  typeof([])
    // <· 'object'
    // >  typeof({})
    // <· 'object'

例:区别传的变量是数组还是对象的方法：一是 constructor，二是 instanceof
    var arr = {};//[]

    // 从控制台输出:
    // >  obj.constructor
    // <· function Object(){[native code]}
    // >  [] instanceof Array
    // <· true

    // >  var obj = {};
    // <· undefined
    // >  obj instanceof Array
    // <· false


例:第三种区分数组还是对象的方法：想让数组调用他的 toString 方法
    Object.prototype.toString.call([]);    //[] 会替换this
    Object.prototype.toString = function(){
        // 识别this(谁调的它，这个 this 就是谁）就返回相应的及如果)
    }
    obj.toString();

    // 从控制台输出:
    >  Object.prototype.toString.call([]);
    <· '[object Array]'
    >  Object.prototype.toString.call(123);
    <· '[object Number]'
    >  Object.prototype.toString.call({});
    <· '[object Object]'
```

# this,笔试真题,进制

## 进制

`十六进制 0 1 2 3 4 5 6 7 8 9 a b c d e f`

`十六进制的中 10 是十进制的 16， 1f = 16 + 15`

`二进制中的 10是十进制的 2，11 是十进制的3`

```js
|    在十进制中：    |    在二进制中：   |
————————————————————————————————————————
|  1 = 1            |   1 = 1          |
————————————————————————————————————————
|  10 = 10          |   10 = 2         |
————————————————————————————————————————
|  100 = 10 ^ 2     |   100 = 2 ^ 2    |
————————————————————————————————————————
|  1000 = 10 ^ 3    |   1000 = 2 ^ 3   |
————————————————————————————————————————
|  10000 = 10 ^ 4   |   10000 = 2 ^ 4  |
————————————————————————————————————————
```

## this

`函数预编译过程 this ---> 指向 window`

```js

    function test(c){
        // var this = Object.creat(test.prototype);
        //{
            // __proto__ : test.prototype
        // }
        var a = 123;
        function b(){}
    }
    // AO{
    //     arguments : [1],
    //     this : window,
    //     c : 1,
    //     a : undefined,
    //     b : function(){}
    // }

    test(1);
    new test();
    // 前面的 var this = Object.creat(test.prototype);是最标准的写法
    // new test();就会让 var this = Object.creat(test.prototype);如果不 new this 就会指向 window

例:
    function test(){
        console.log(this);
    }
    test();
    // >  window
    // <· Window{
        // .........
    // }
```

`全局作用域里 this ---> 指向 window`

```js
>  this

<· Window{......}
```

1. `call / apply 可以改变函数运行时的 this 指向`

2. `obj.func(); func()里面的 this 就指向谁`

> 总结

```js
例:
    var name : '222';
    var a = {
        name : '111',
        say : function(){
            console.log(this.name);
        }
    }
    var fun = a.say;
    fun() // 222
    a.say() // 111

    var b = {
        name : '333',
        say : function(fun){
            fun();
        }
    }
    b.say(a.say); // 222
    b.say = a.say;
    b.say(); // 333

    // 分析：
        // a.say 是 function 函数体
        function(fun){
            // this  -->   b
            // console.log(this) --> b
            fun();
        }
        // fun()空执行，走预编译
        // 在 b.say(a.say)中
        // a.say 当作参数传进来了
```

```js

    var obj = {
        a : function(){
            console.log(this.name);
        },
        name : 'abc'
    }
    obj.a();
```

## 笔试真题

```js
例1：下面这段代码执行完毕后，x,y,z的值分别是多少？
    var x = 1, y = z = 0;
    function add(n){
        return n = n + 1;
    }
    y = add(x);
    function add(n){
        return n = n + 3;
    }
    z = add(x);
// 答案：1，4，4; 同一个函数，后面的肯定会覆盖前面的，因为预编译会覆盖


例2：下面代码中 console.log 的结果是[1,2,3,4,5]的选项是：
    A. function foo(x){
            console.log(arguments);
            return x;
        }
        foo(1,2,3,4,5);

    B. function foo(x){
            console.log(arguments);
            return x
        }(1,2,3,4,5)

    C. (function foo(x){
            console.log(arguments);
            return x;
        })(1,2,3,4,5)

    D. function foo(){
            bar.apply(null,arguments);
        }
        function bar(x){
            console.log(arguments);
        }
        foo(1,2,3,4,5)
// 答案：A、C、D 其中b执行不了，但是不报错，bar里面传了一下参数。bar.apply(null,arguments); 写成 bar(arguments);


例3：一行文本，水平垂直居中
    // 答案：height = line height;     text-align:center


例4：请问以下表达式的结果是什么？
    parseInt(3,8)       parseInt(3,2)       parseInt(3,0)
    A.3,3,3     B.3,3,NaN     C.3,NaN,NaN     D.other
    // 答案:C 或 D（有的浏览器 0 进制报错，有的不报错）


例5：以下那些是 javascript 语言 typeof 可能返回的结果
    A. string   B.array    C.object    D.null
    //答案：A、C (typeof 只能返回 number、string、undefined、boolean、object、function)


例6：javascript 的 call 和 apply 方法是做什么的？两者有什么区别

    Wheel.apply(this,[wheelSize,style]);
    Wheel.call(this,wheelSize,style);

    //答案：call 和 apply 的作用都是改变 this 指向的，不过两个的传参列表不同，apply 只能传一个实参，而且必须传数组 arguments


例7：看看下面 alert 的结果是什么？
    function b(x,y,a){
        arguments[2] = 10;
        alert(a);
    }
    b(1,2,3);
    // 如果函数体改成下面，结果会是怎么样
    a = 10;
    alert(arguments[2]);
    //答案：10，10


例8：逗号操作符，这种情况，会先看一眼1，再看一眼2，然后返回2，就是2
    var f = (
        function f(){
            return '1';
        },
        function g(){
            return 2;
        }
    )();
    typeof f;
    // 在控制器中输出：
    // >  1,2
    // <· 2

    // >  var num = (1,2);
    // <· 2


例9：
    var x = 1;
    if(function f(){
        x += typeof f;
    })
    console.log(x);
    // 分析：用括号把 function f(){} 转换成一个表达式，就会被立即执行了，就找不到了，因为 function f() {} 肯定是 true，所以会执行 {}，但是 typeof 中的 f 已经找不到了
    // 答案：1undefined


例10：以下哪些表达式的结果为true的
    A.undefined == null     B.undefined === null     C.isNaN('100')     D.parseInt('1a') == 1
    // 答案：A、C、D    isNaN('100')意思是这个数经过 number 转换后是不是NaN

    C。function myIsNaN(num){
        var ret = Number(num);
        ret += '';
        if(ret == 'NaN'){
            return true;
        }else{
            return false;
        }
    }
    // 从控制台输出：
    // >  myIsNaN('123')
    // <· false

    // >  myIsNaN('NaN')
    // <· true


例10：引用值比的是地址
    >  {} == {}
    <· false

    >  var obj = {}
    <· undefined

    >  var obj1 = obj
    <· undefined

    >  obj1 == obj
    <· true

    >  obj1 == obj
    <· true


例11：
    var foo = '123';
    function print(){
        var foo = '456';
        this.foo = '789';
        console.log(foo);
    }
    print();
    // 456

    // 把上面的题变形

    var foo = 123;
    function print(){
        this.foo = 234;
        console.log(foo);
    }
    print();
    // 答案打印 234，要 console.log(foo);是全局的 foo，但是这里 this.foo 的 this是指向全局 window 的，相当于就把外面的 123 改成了 234

    // 在变形一下

    var foo = 123;
    function print(){
        // var this = Object.creat(print.prototype)
        this.foo = 234;
        console.logf(foo);
    }
    new print();
    // 答案:123
    //，new 了以后，隐式 var this = Object.create(print.prototype)这时候 this.foo 不 再指向 window，转而指向 var this，所以打印的时候找不到 234，就到全局找到 123


例12：运行 test() 和 new test() 的结果分别是什么？
    var a = 5;
    function test(){
        a = 0;
        alert(a);
        alert(this.a);
        var a;
        alert(a);
    }
    test();
    // 答案：0，5，0
    // new test() 之后是 0，undefined，0

    // 分析: 【之前其中 this.a 指代的是 window，所以是 0，5，0】
    //       【之后，因为 this 上没有 a ,所以打印 undefined】


例13：
    function print(){
        console.log(foo);
        var foo = 2;
        console.log(foo);
        console.log(hello);
    }
    print();
    // 答案：undefiend,2,hello is no defined(报错，因为hello 没有被定义，所以报错)


例14：
    function print(){
        var test;
        test();
        function test(){
            console.log(1);
        }
    }
    print();
    // 答案 1


例15：
    function print(){
        var x= 1;
        if(x == '1'){
            console.log('One!')
        }
        if(x === '1'){
            console.log('Two!')
        }
    }
    // 答案：One


例16：
    function print(){
        var marty = {
            name : 'marty',
            printName : function(){
                console.log(this.name);
            },
        }
        var test1 = {name : "test1"};
        var test2 = {name : 'test2'};
        var test3 = {name : 'test3'};
        test3.printName = marty.printName;
        var printName2 = marty.printName.bind({name:123});//做不了
        marty.printName.call(test1);
        marty.printName.apply(test2);
        marty.printName();
        printName2();
        test3.printName();
    }
    print();
    // 答案：test1，test2，marty，做不了有bind，test3


例17：
    var bar = {a : '002'};
    function print(){
        bar.a = 'a';
        Object.prototype.b = 'b';
        return function inner(){
            console.log(bar.a);
            console.log(bar.b);
        }
    }
    print()();
    // 答案：a,b
    // print()() 第一个括号返回的是一个函数，第二个再来函数执行
```

# arguments.callee、function.caller

`arguments.callee 指向函数的引用(函数自己)`

`function.caller 返回本执行程序的坏境名称`

## 一、callee

```js
例1：
    function test(){
        console.log(arguments.callee);
    }
    test();
    // 答案：test

例2：
    function test(){
        console.log(arguments.callee == test);
    }
    test();
    // 答案:true

例3：我们要初始化数据，是100以内的阶乘，用立即执行函数找自己的引用来解决
    var num = (function(n){
        if(n == 1){
            return 1;
        }
        return n * arguemtns.callee(n - 1);
    })(100)

例4：
    function test(){
        console.log(arguments.callee);
        function demo(){
            console.log(arguemtns.callee);
        }
        demo(); // demo
    }
    test(); // test
    // 在那个函数里面的 argument.callee 就指代了哪个函数
```

## 二、caller

`caller 是他在哪个环境执行，就返回哪个环境的名字，不能再arguments里面`

```js

    function test(){
        demo();
    }
    function demo(){
        console.log(demo.caller);
    }
    test();

    // demo 被调用的环境是 test
    // 所以这个 caller 指代的 test
```

# 克隆

`浅层克隆`

`深层克隆`

```js
例1：这个是做的浅层克隆
    var obj = {
        name : 'abc',
        age : 123,
        sex : 'female'
    }
    var obj1 = {}
    function clone(origin,target){
        for(var prop in origin){
            target[prop] = origin[prop];
        }
    }
    clone(obj,obj1);
    // 在控制台输出：
    // >  obj
    // <· Object{name : 'abc',age : 123,sex : 'female'}

    // >  obj1
    // <· Object{name : 'abc',age : 123,sex : 'female'}

把上面的改一下，写一个兼容性的写法，为了防止用户不传 target（容错），给了参数就直接用，不给就当空对象，见下方：

    var obj = {
        name : 'abc',
        age : 123,
        sex : 'female'
    }
    var obj1 = {}
    function clone(origin,target){
        var target = target || {};
        for(var prop in origin){
            target[prop] == origin[prop];
        }
        return target;
    }
    clone(obj,obj1);
    // 在控制台输出：
    // >  obj
    // <· Object{name : 'abc',age : 123,sex : 'female'}

    // >  obj1
    // <· Object{name : 'abc',age : 123,sex : 'female'}

    // >  obj.name = 'bcd';
    // <· 'bcd'

    // >  obj1.name
    // <· 'abc'


例2：
    var obj = {
        name : 'abc',
        age : 123,
        sex : 'female',
        card : ['visa','unionpay']
    }
    var obj1 = {}

    function clone(origin,target){
        var target = target || {};
        for(var prop in origin){
            target[prop] == origin[prop];
        }
        return target;
    }
    clone(obj,obj1);

    // 在控制台输出：
    // >  obj1
    // <· Object{name : 'abc',age : 123,sex : 'female'}
    //    card : Array[2]

    // >  obj1.card.push('master')
    // <· 3

    // >  obj1.crad
    // <· {'visa','unionpay','master'sss}

    // >  obj
    // <· Object{name : 'abc',age : 123,sex : 'female',card : Array[3]}

    // >  obj.card
    // <· ['visa','unionpay','master']

现在我们想实现深度克隆（只考虑数组和对象），copy过去后，我改，但是你不会改， 引用值不能直接拷贝
```

`思考上一道题做深度克隆，分析它是什么，建立是什么，收尾需要要给递归，提示：`

```js
例: obj = {
  card: ["visa", "unionpay", [1, 2]]
};

var obj1 = {
  card: [obj.card[0], obj.card[1], []]
};
```

`作业：做一个深度克隆（copy后，各自独立，互不影响）`

`思路：需要一个分析环节，分析是什么，是原始值就按原来的方法拷贝过来，是引 用值就分析是数组还是对象。如果是数组，就新建一个数组；如果是对象，就新建一个对象。再一层层看，里面有一个递归。引用值不能直接拷贝，引用值拷贝的是 地址`

```js
var obj = {
    name : 'abc',
    age : 123,
    card : ['visa','master'],
    wife : {
        name : 'bcd',
        son : {
            name : 'aaa'
        }
    }
}
var obj1 = {}

function deepClone(origin, target) {
    var target = target || {}, // 有就用你的，没有就用后面的
        toStr = Object.prototype.toString, // 引用，目的是简化
        arrStr = '[Object Array]'; // 引用，目的是简化比对
    for (var prop in origin) { // 从原始 origin 拷贝到 target
        if (origin.hasOwnProperty(prop)) { // 先判断是不是原型上的属性，如果是 false 就是原型上的
            if (typeof (origin[prop]) !== 'null' && typeof (origin[prop]) == 'object') {
                if ((toStr.call(origin[prop])) == arrStr) {
                    target[prop] = [];
                } else {
                    target[prop] = {};
                }
                deepClone(origin[prop], target[prop]);
            } else { // else 后面是原始值
                target[prop] = origin[prop];
            }
        }
    }
    return target;
}

// 分析：
var obj = {
    name : 'abc',
    agfe : 123,
    card : ['visa','master'] //原始对象
    wife : {
        name : 'bcd',
        son : {
            name : 'aaa'
        }
    }
}
var obj1 = {
    name : 'abc',
    age : 123,
    card : [obj.card[0],obj.card[1]],
    // 要拷贝的对象，进行 obj 里面的数组，对这个数组的拷贝再一次拷贝
    wife : {
        name : 'bcd',
        son : {
            name : 'aaa'
        }
    }
}
```

```js
深度克隆的步骤：

    1. 先把所有的值都遍历一遍（看是引用值和原始值）
       用for(var prop in obj),对象和数组都可以使用

    2. 判断是原始值，还是引用值？用typeof判断是不是object
        1) 如果是原始值就直接拷贝
        2) 如果是引用值，判断是数组还是对象

    3. 判断是数组还是对象？（方法 intanceof 【看 a 的原型链上有没有 b 的原型链】、toString、constructor,建议用 toString，另外两个有个小 bug ———— 跨父子域不行）
        1）如果是数组，就新建一个空数组
        2）如果是对象，就新建一个空对象

    4. 建立了数组以后，如果是挨个看原始对象里面是什么，都是原始值就可以直接拷过来了；或者，建立了对象以后，挨个判断对象里面的每一个值，看是原始值还是引用值

    5. 递归
```

# 三目运算符

`形式：?（问号）前面是一个条件判断，判断true就执行:（冒号）前面的；false就执行:（冒号）后面的，并且返回值`

`条件判断 ? 是 : 否 并且会返回值`

`三木运算符是 简化 版的if（条件判断）{是在这里}else{否在这里}`

```js

    var num = 1 > 0 ? 2 + 2 : 1 + 1;
    // 答案：4

    var num = 1 < 0 ? 2 + 2 : 1 + 1;
    // 答案：2

    var num = 1 > 0 ? ('10' > 9 ? 1 : 0) : 2;
    // 答案：1

    var num = 1 > 0 ? ('10' > '9' ? 1 : 0) : 2;
    // 答案：0

    // 分析：因为 '10' > '9' 比的是 ASCII 码，一位位比，10（一零）小于 9 ，先用 1 和 9 比，在 ASCII 码里面 1 小于 9；

    // 当“10” >  9 字符串和数字比，会先转换成数字再比较
```

```js

    // 可利用三木运算符简化克隆代码

    var obj = {
        name : 'yu',
        age : 18,
        card : ['visa','master'],
        wife : {
            name : 'Long',
            age : 18,
            son : {
                lastName : 'YU'
            }
        }
    }

    var obj1 = {}

    function deepClone(origin,target){
        var target = target || {},
            toStr = Object.prototype.toString,
            arrStr = '[Object Array]'

        for(var prop in origin){
            if(origin.hasOwnProperty(prop)){
                if(origin[prop] !== 'null' && typeof(origin[prop]) == 'object'){
                    target[prop] = (toStr.call(origin[prop]) == arrStr) ? [] : {};
                    deepClone(target[prop],origin[prop]);
                }else{
                    target[prop] = origin[prop];
                }
            }
        }
        return target;
    }
    deepClone(obj,obj1);
```

# (数组)预习

`定义对象方式：自变量，构造函数，自定义的构造函数，Object.create`

```js
定义数组的方式：

  1. var arr = [];   数组自变量（自定义）；

  2. var arr = new Array();  系统提供

    两者区别就只一位数的情况

    数组能用的方法来源于 Array.prototype
```

```js

    var arr = [];
    如果写出 var arr = [1,,1],出来就是 1,undefined*1,1
    数组不是每一位都有值，稀疏数组


    var arr = [1,2,3,4,5];
    var arr = new Array(1,2,3,4,5);和自定义数组显示效果一样


    // 系统提供的数组和自定义的数组有一点不同，如下
    var arr = new Array(10);
    长度为10的稀疏数组，括号里面只有一位数，就代表着长度，并且里面每一位都没有值，console 里面会是 undefined * 10。并且里面不能写小数，会报错。
```

`数组的读和写，基本上没有报错的情况，除非是引用了没有的方法`

`js数组是基于对象的，数组是一种特殊的对象`

```js
>  arr[10] = 'abc'
<  'abc'

>  arr
<  [undefined * 10,'abc']

>  arr.length
<  11
```

# 数组

## 一、数组的定义（来源于 Array.prototype）

`1）系统提供 new Array(length / content) var arr = new Array(1,2,3,4,5)`

`2）自变量 var arr = [1,2,3,4,5];`

## 二、数组的 ‘读’ 和 ‘写’

`arr[num] // 不可以溢出读，结果 undefiend`

`arr[num] = XXX; // 不可以溢出读`

`arr[num] = xxx; // 可以溢出读`

```js
es3.0 最标准最基础

es5.0  es6.0，最新的 es7.0还没有普及，今天讲的都是 es3.0

对象的定义方式

1 自变量
2 构造函数
3 自定义构造函数
4 object.create 数组是一种特殊的对象，在本质上两者没有太大的区别
```

```js
可以写 var arr = [,]    // 稀松数组，相当于定义了两个位置，console(控制台 结果是 undefiend)

var arr = [1,2,,,,3,4];
    // 答案[1, 2, undefiend * 3, 3, 4]
    // arr.length = 7

var arr = []; 和 var arr = new Array(); 唯一的区别实在 var arr = new Array(); 只传了一个参数的情况下，会被当成长度，并且成为一个稀松数组

    var arr = new Array(10); // [undefined * 10]
    var arr = [10]; // [10]

    如果传进去一个小数，就非法：var arr = new Array(10.2); // 报错


    var arr = [];
    // >  arr[10]
    // <· undefined

    // >  arr[10] = 'abc'
    // <· 'abc'

    // >  arr
    // <· [undefined * 10, 'abc']

    // >  arr.length
    // <· 11
```

## 数组的常用方法

### 一、改变原数组（在原来数组基础上去改变）

`1）reverse，sort，push，pop，unshift，shift`

`2）splice`

#### push

```js
`push`

`push 在数组的最后一位添加数据，可以添加一个，也可以添加很多个`

例1：
    var arr = [];

    // 在控制台操作：
    // >  arr.push(10)
    // <· 1

    // >  arr
    // <· [10]

    // >  arr.push(11)
    // <· 2

    // >  arr
    // <· [10,11]

    // >  arr.push(9)
    // <· 3

    // >  arr
    // <· [10,11,9]

    // >  arr.push(1,2,3,4,5,6,7)
    // <· 7

    // >  arr
    // <· [1,2,3,4,5,6,7]

例2：
    // 说明能重写
    var arr = [];
    Array.prototype.push = function(){
        return 'haha';
    }

    // 在控制台操作：
    // >  arr.push()
    // <· 'haha'

例3：数组有三位，想在数组的最后一位添加东西
    var arr = [1,2,3]; 如果在第四位加东西写成 arr = [3]  // length - 1 位添加东西

    var arr = [1,2,3];
    Array.prototype.push = function(){
        for(var i = 0;i < arguments.length; i ++){
            this[this.length] = arguments[i];
        }
        return this.length;
    }

    // 在控制台操作：
    // >  arr.push(4,5,6)
    // <· 6
    // >  arr
    // <· [1,2,3,4,5,6]

`Array.prototype.push = function(){}    不能写形参`
```

#### pop

```js
`pop`

`pop 是剪切方法（把最后一位数剪切出去）。在 pop() 括号里面不能传参，写了会忽略`

例1：
    var arr = [1,2,3];

    // 在控制台操作：
    // >  arr.pop()
    // <· 3

    // >  arr
    // <· [1,2]

    // >  arr.pop()
    // <· 2

    // >  arr
    // <· [1]

    // 在控制台操作：
    // >  var num = arr.pop()
    // <· undefined

    // >  num
    // <· 3

    // 在控制台操作：
    // >  arr.pop(2)
    // <· 3

    // >  arr
    // <· [1,2]
```

#### unshift

```js
`unshift`

`unshift 是从第一位加东西`


    var arr = [1,2,3];

    // 从 console 操作：
    // >  arr.unshift(0)
    // <· 4

    // >  arr
    // <· [0,1,2,3]

    // >  arr.unshift(-1,0)
    // <· 5

    // >  arr
    // <· [-1,0,1,2,3]
```

#### shift

```js
`shift`

`shift 是从第一位减东西`

例1：
    var arr = [1,2,3];

    // 从 console 操作：
    // >  arr.shife()
    // <· 1

    // >  arr
    // <· [2,3]

例2：数组不能从 -1 位插入东西
    // 从 console 操作：
    // >  arr[-1] = 0
    // <· 0

    // >  arr
    // <· [1,2,3]
    // 可以用两个数组拼接成一个数组的方式添加东西
```

#### reverse

```js
`reverse`

`reverse 逆反`


    var arr = [1,2,3];

    // 从 consolel 操作
    // >  arr.reverse()
    // <· [3,2,1]

    // >  arr.reverse()
    // <· [1,2,3]

    // >  arr
    // <· [1,2,3]
```

#### splice
```js

> 把类数组转换成数组的时候经常用

`'splice':Array.prototype.splice`

`splice`

`splice 一种剪切，切片`

`arr.splice(从第几位开始，截取多少长度，传参在切口处添加新的数据)`

例1：
    var arr = [1,1,2,2,3,3];
    arr.splice(1,2) //从第 1 位开始截取 2 位，传参可以不填
    // 截取的是[1,2]

    // 从 consolel 操作
    // >  arr.splice(1,2)
    // <· [1,2]

    // >  arr
    // <· [1,2,3,4]

    // >  arr.splice(0,3)
    // <· [1,1,2]

    // >  arr
    // <· [2,3,3]

    // >  arr.splice(1,1,0,0,0)
    // <· [1]

    // 从 consolel 操作
    // >  arr.splice(0.3)
    // <· [1,0,0,0,2,2,3,3]

例2：
    arr.splice(1,1,0,0,0);
    //意思是从第 1 位起截取 1 位，然后加上0，0，0这三个数

例3：
    var arr = [1,2,3,5];   //1是第0位，2是第1位, 3是第2位，5是第3位
    arr.splice(3,0,4);
    // 答案：[1,2,3,4,5];

例4：
    var arr = [1,2,3,4];
    arr.splice(-1,1);   // 这里的 -1 是倒数第一位，数组一般的方法都可以带负数
    // 答案：[1,2,3];

例5：下面是系统内部解决附属问题的兼容
    var arr = [1,2,3,4];

    splice = function (pos){
        pos += pos > 0 ? 0 : this.length;
    }
    // -1 + 4 = 3

例6：
    function(i){
        var len = this.length,
        j = +i + (i < 0 ? len : 0);
        return this.pushStack(j >= && j < len ? [this [j] ]d : [])
    }
    // splice = function (pos){
        // pos += pos > 0 ? 0 : this.length;
        pos >= 0 || pos <
    // }
```

#### sort

```js
`sort`

`sort 给数组排序，（按照从小到大），改变原数组`

例1：
    var = [1,3,4,0,-1,9];

    // 从 consolel 操作
    // >  arr.sotr()
    // <· [-1,0,1,3,4,9]

    // 在sort后面加 reversve 就是降序
    // >  arr.sotr().reverse()
    // <· [9,4,3,1,0,-1]

例2：下面这个按照 ASCII 码排序的
    var arr = [1,3,5,4,10];

    // 从 consolel 操作
    // >  arr.sotr()
    // <· [-1,10,3,4,5]


`所以给我们留了一个接口，如下

1 必须写两形参

2 看返回值 return
    1）当返回值为负数时，那么前面的数放在前面，
    2）当返回值为正数时，那么后面的数在前，
    3）为0，不动
`

例1：
    var arr = [1,3,5,4,10];

    arr.sort(function(a,b){
        if(a > b){
            return 1;
        }else{
            return -1;
        }
    });

    return 1;    //此处的 1代表返回正的 return -1;
    return -1    //此处的-1 代表返回负的

`
思维方式:上面就控制了升序

这个函数第一次调动时，会把数组的第一位和第二位传进来，也就是 a=1，b=3，然 后通过规则比较，当你把返回值返回为正，为负，为 0。

传参的顺序（但是这个顺序是位置的顺序，不是按数字比），第一次是1,3，第二次 1,5,第三次1,4,第四次 1,10，第五次 3,5,第六次3,4,第七次 3,10，第八次 5,4，第九次 5,10，第十次 4,10；依次传参（符合冒号排序的算法）

是以换位置的方式改变顺序
`

例2：var arr = [2,13,19,4];   // 到 13 这一位的时候，换位置变成了[2,4,19,13]

例3：下面变成了降序
    var arr = [2,10,20,13,4,8,9];

    arr.sort(function(a,b){
        if(a < b){
            return 1;
        }else{
            return -1;
        }
    })

例4：
    `升序简化版`
    var arr = [20,2,10,13,4,8,9];

    arr.sort(function(a,b){
        if(a - b > 0){
            return a - b;
        }else{
            return a - b;
        }
    })

    `再简化版`
    var arr = [20,2,10,13,4,8,9];

    arr.sort(function(a,b){
        return a - b;
    })

`升序 return a - b`

`降序 return b - a`

例5：直接调用 arr.sort() 比的是 ASCII 码，要在里面填函数才可以
    var arr = [20,2,10,13,4,,8,9];

    arr.sort(function(a,b){
        // return a - b; 升序
        // return b - a; 降序
        return b - a;
    })
    // 从 consolel 操作
    // >  arr
    // <· [20,13,10,9,8,4,2];
    // >  arr.sort(function(){})

例6：给一个有序的数组，让它乱序，当我们没规律可以遵循的时候，返回时是随机的
    var arr= [1,2,3,4,5,6,7];
    arr.sort(function(){
        return Math.random() - 0.5;
    });

    // Math.random() 回生成一个 0 到 1 （包括 0，但是不包括 1）的随机数

例7：给以下按照年龄排序
    var cheng = {
        name : 'cheng',
        age : 18,
        sex : 'male',
        face : 'handsome'
    }
    var deng = {
        name : 'deng',
        age : 40,
        sex : undefined,
        face : 'amazing'
    }
    var zhang = {
        name : 'zhang',
        age : 20,
        sex : 'male',
    }

    var arr = [cheng,deng,zhang];
    arr.sort(function(a,b){
        if(a.age > b.age){
            return 1;
        }else{
            return -1;
        }
    })
    // 简化
    var arr = [cheng,deng,zhang];
    arr.sort(function(a,b){
        return a.age - b.age;
    })

例7：按照字符串长度排序
    var arr = ['ab','abcde','abcd','abcdefg',,'abcdef''abc'];

    arr.sort(function(a,b){
        return a.length - b.length;
    })

例8：按照字节长度排序
    function retBytes(str){
        var num = str.length;
        for(var i = 0; i < str.length; i ++){
            if(str.charCode(i) > 255){
                num ++;
            }
        }
        return num;
    }

    var arr = ['ac','alkdjf于lkajsd','aksd泽jfk','iuwe龙oiru','dddd','aaa'];

    arr.sort(function(a,b){
        return retBytes(a) - retBytes(b);
    })
```

### 二、不改变原数组

`1）forEach，filter，map，reduce，reduceRight`

`2）slice，concat，join ————> split，toString`

#### concat

```js
`concat``concat 连接，把后面的数组拼接到前面，并成立一个新的数组，不影响之前的两个数组，不能改变原数组`;

例: var arr = [1, 2, 3, 4, 5, 6];
var arr1 = [7, 8, 9];

// 从 console 操作：
// >  var result = arr.concat(arr1)
// <· [1,2,3,4,5,6,7,8,9]

// >  arr
// <· [1,2,3,4,5,6]

// >  arr1
// <· [7,8,9]

// >  result
// <· [1,2,3,4,5,6,7,8,9,10]
```

#### toString

```js
`toString`

`toString 是把数组当作字符串展示出来`


    var arr = [1,2,3,4,5,6]

    // 从 console 操作：
    // >  arr.toString()
    // <· '1,2,3,4,5,6
```

#### slice

```js
`slice`

`slice 从该位开始截取，截取到该位，并不改变原数组，这里也可以写负数`


    var arr = [1,2,3,4,5,6];
    // slice(从改位开始截取，截取到该位)

    // 从 console 操作：
    // >  arr.slice(1,2)
    // <· [2]

    // >  arr
    // <· [1,2,3,4,5,6]

    `slice 并不改变原数组，slice完了以后需要有东西接受，不然没有意义`

    var arr = [1,2,3,4,5,6];
    // slice(从改位开始截取，截取到该位)
    var newArr = arr.slice(1,3);

    // 从 console 操作：
    // >  newArr
    // <· [2,3]
// 从 console 操作：
    // >  newArr
    // <· [2,3]
`
slice 里面可以填 0 个参数，也可以填 1 个参数，也可以填两个参数

1. 如果填两个参数，slice（从该位开始截取，截取到该位）

   如：arr.slice(1,2)，从第一位开始截取，截取到第二位

2. 如果填一个参数，从第几位开始截取，一直截取到最后。

    如：arr.slice(1)，从第 1 位开始截取，截取到最后一位

3. 不写参数就是整个截取数组`
```

#### join

```js
`join`

`join 括号里面需要用字符串形式（标准语法规定），就会用加的东西连接起来数组`


    var arr = [1,2,3,4,5,6];

    // 从 console 操作：
    // >  arr.join('-')
    // <· [1-2-3-4-5-6]

    // >  arr.join('!')
    // <· [1!2!3!4!5!6]

    // >  arr.join('~')
    // <· [1~2~3~4~5~6]
```

#### split

```js
`split`

`split() 是string字符串方法 是 join() 方法的可逆方法，join方法是输入什么连接什么，split是输入什么拆分什么`


    var arr = [1,2,3,4,5,6];
    var str = arr.join('-');

    // 从 console 操作：
    // >  str.split('4')
    // <· ['1-2-3-' , '-5-6']

    // >  str
    // <· '1-2-3-4-5-6'

    // >  str.split('-')
    // <· ['1','2','3','4','5','6']

`split 按照什么拆分为数组。用什么拆，什么就没了，按 - 拆就去掉了，按 4 拆就去掉了4.

split 可以返回数组，数组可以返回字符串`

把下面啊字符串拼到一起
    var str = 'alibaba';
    var str1 = 'baidu';
    var str2 = 'tencent';
    var str3 = 'toutiao';
    var str4 = 'wangyi';
    var str5 = 'xiaowang';
    var str6 = 'nv';

// 下面这种写法不好，字符串是在栈内存里面的，先进后出

    var str Final = '';
    var arr = [str,str1,str2.str3,str4];
    for(var i = 0;i < arr.length; i ++){
        strFinal += arr[i];
    }

// 用下面这种方式更好，join 里面不传参默认用逗号连接，传空串如下图

    // 散列
    var arr = [str,str1,str2,str3,str4,str5,str6];
    console.log(arr.join(''));
```

#### forEach() -- 循环遍历数组

`forEach(function(ele,index,array){}) -- 循环遍历数组`

**参数：**

**ele** : 循环遍历的每一个当前元素对象 `（第 1 个参数，什么变量都可以）`

**index** : 相当于for循环的那个 i，当前在表中操作的当前项的索引。，遍历第一遍：0，第二遍：1 `（第 2 个参数，什么变量都可以）`

**array** : 当前元素所属的数组对象。相当于this，就是调用的是那个数组，一般用不到 `（第 3 个参数，什么变量都可以）`

```js
var personArr = [
    {name: '王港', src:'./img/3.png',des:'颈椎不好',sex:'m'},
    {name: '刘莹', src:'./img/5.png',des:'我是谁',sex:'f'},
    {name: '王秀莹', src:'./img/4.png',des:'我很好看',sex:'f'},
    {name: '刘金雷', src:'./img/1.png',des:'陌生的脸',sex:'m'},
    {name: '刘飞翔', src:'./img/2.png',des:'六六六',sex:'m'},
]

personArr.forEach(function(ele,index,array){
// ele : 循环遍历的每一个元素对象
// index : 相当于for循环的那个 i，代表索引，遍历第一遍：0，第二遍：1
// array : 相当于this，就是调用的是那个数组，一般用不到
    console.log(ele); // 打印出循环遍历的每一位
})
```

```js
forEach的源码剖析：

Array.prototype.myForEach = function(func){
    for(var i = 0;i < this.length;i ++){
        func(this[i],i,this);
    }
}
// break不能使用，因为break在源码中不是写到for循环里面，而是写到了func函数里面

// return不能使用，因为return的话，就只是在return的那个遍历的对象不执行了，直接跳到下一个遍历对象执行
```

#### filter -- 筛选元素

`fliter 筛选，和 forEach 一样会遍历循环，也有三个参数，不过筛选出来的值由 return 来决定`

`filter 循环遍历筛选，返回判断是 true 的值，然后 return 出来，false，丢掉`

`filter(function(ele,index,array){}) -- 循环遍历筛选数组`

**参数：**

**ele** : 循环遍历的每一个当前元素对象 `（第 1 个参数，什么变量都可以）`

**index** : 相当于for循环的那个 i，当前在表中操作的当前项的索引。，遍历第一遍：0，第二遍：1 `（第 2 个参数，什么变量都可以）`

**array** : 当前元素所属的数组对象。相当于this，就是调用的是那个数组，一般用不到 `（第 3 个参数，什么变量都可以）`

> 意思是现在循环遍历的数组，如果循环遍历的返回值是true的话，就留下,如果说 返回如果循环遍历的返回值是false的话，就不要了。并且把所有返回true的数组（元素）放到到一个新的数组里面，所以说 filter 会有返回一个结果，这个结果就是 filter 筛选出来的元素组合成的一个新的数组。

```js
var personArr = [
    {name: '王港', src:'./img/3.png',des:'颈椎不好',sex:'m'},
    {name: '刘莹', src:'./img/5.png',des:'我是谁',sex:'f'},
    {name: '王秀莹', src:'./img/4.png',des:'我很好看',sex:'f'},
    {name: '刘金雷', src:'./img/1.png',des:'陌生的脸',sex:'m'},
    {name: '刘飞翔', src:'./img/2.png',des:'六六六',sex:'m'},
]

var newArr = personArr.filter(function(ele,index){
// ele : 循环遍历的每一个元素对象
// index : 相当于for循环的那个 i，代表索引，遍历第一遍：0，第二遍：1
// array : 相当于this，就是调用的是那个数组，一般用不到
    return true;// 这个返回的可以是任何东西，只要转换完成之后不是 空 就可以。
    // 意思是现在循环遍历的数组，如果循环遍历的返回值是true的话，就留下
    // 如果说 返回如果循环遍历的返回值是false的话，就不要了。
    // 并且把所有返回true的数组（元素）放到到一个新的数组里面
})
console.log(newArr);
// 打印筛选的元素组成的新数组
```

```js
判断false和true:

var personArr = [
    {name: '王港', src:'./img/3.png',des:'颈椎不好',sex:'m'},
    {name: '刘莹', src:'./img/5.png',des:'我是谁',sex:'f'},
    {name: '王秀莹', src:'./img/4.png',des:'我很好看',sex:'f'},
    {name: '刘金雷', src:'./img/1.png',des:'陌生的脸',sex:'m'},
    {name: '刘飞翔', src:'./img/2.png',des:'六六六',sex:'m'},
]

var newArr = personArr.filter(function(ele,index,array){
    if(ele.sex == 'f'){ // 可以来判断true和false
        return true;
    }else{
        return false;
    }
})
console.log(newArr); // [{…}, {…}]，两个女生
```

```js
filter源码剖析：
Array.prototype.myfilter = function(func){
    var arr = [];
    for(var i = 0;i < this.length;i ++){
        if(func(this[i],i,this)){
            arr.push(this[i]);
        }
    }
    return arr;
}
```

#### map -- 循环遍历数组，返回一个新的数组

`map 就是直接返回一个新的数组，你可以在map里面判断条件，也可以不判断条件，可以用任何条件，来返回旧的数组里面的数据`

`map 直接由 return 返回出来的值来返回，把当前 return 返回的值放到新的数组当中`

`map 返回结果，和 forEach和filter 一样会遍历循环，也有三个参数，功能也一样，不过筛选出来的值由 return 返回出来的结果来决定，就是 return 每一次返回的值是什么，就返回什么每一次的结果`

`map(function(ele,index,array){}) -- 循环遍历筛选数组`

**参数：**

**ele** : 循环遍历的每一个当前元素对象 `（第 1 个参数，什么变量都可以）`

**index** : 相当于for循环的那个 i，当前在表中操作的当前项的索引。，遍历第一遍：0，第二遍：1 `（第 2 个参数，什么变量都可以）`

**array** : 当前元素所属的数组对象。相当于this，就是调用的是那个数组，一般用不到 `（第 3 个参数，什么变量都可以）`

```js
var personArr = [
    {name: '王港', src:'./img/3.png',des:'颈椎不好',sex:'m'},
    {name: '刘莹', src:'./img/5.png',des:'我是谁',sex:'f'},
    {name: '王秀莹', src:'./img/4.png',des:'我很好看',sex:'f'},
    {name: '刘金雷', src:'./img/1.png',des:'陌生的脸',sex:'m'},
    {name: '刘飞翔', src:'./img/2.png',des:'六六六',sex:'m'},
]
// 给男生加上一个 girF = true，给女生加一个boyF = true;
var newArr = personArr.map(function(ele,index){
    if(ele.sex == 'm'){
        ele.girlF = 'true';
        return ele;
    }else{
        ele.boyF = 'true';
        return ele;
    }
})
console.log(newArr); //(5) [{…}, {…}, {…}, {…}, {…}]，五个对象
// newArr 和 personArr 的对象来自通过一个地址，你改我也改
```

```js
`map的源码剖析，浅拷贝`：
Array.prototype.myMap = function(func){
    var arr = [];
    for(var i = 0;i < this.length;i ++){
        arr.push(func(this[i],i));
    }
    return arr;
}
```

```js
`map的源码剖析，深度拷贝（配合深度克隆来解决）`：
Array.prototype.myMap = function (func) {
    var arr = [];
    for (var i = 0; i < this.length; i++) {
        if(this[i] && typeof this[i] == 'object'){
            var newObj = {};
            deepClone(ownObj,this[i]);
            arr.push(func(newObj,i));
        }else{
            arr.push(func(this[i], i));
        }
    }
    return arr;
}

`深度拷贝（深度克隆）`：
function deepClone(target, origin) {
    var prop,
        src,
        copy;
    if (target !== null) {
        for (prop in origin) {
            src = target[prop];
            copy = origin[prop];
            if (copy && typeof copy == 'object') {
                if (Object.prototype.toString.call(copy) == '[object Array]') {
                    src = [];
                } else {
                    src = {};
                }
                target[prop] = deepClone(src, copy);
            } else {
                target[prop] = copy;
            }
        }
    }
    return target;
}

var obj1 = {};
var obj2 = {
    name: 'aimee',
    hobby: {
        sing: 'good',
        dance: 'well'
    }
}
deepClone(obj1, obj2);
// 这是一个深拷贝的过程，谁改变自己里面的东西，都和另一个对象没有关系
```

#### reduce -- 累加器（从左向右执行）

`reduce 从左向右循环遍历数组，累加器（就是把之前遍历的数组），取出来的值只有一个。效率及其高`

`该方法应用一个函数是"累加器"，并处理列表的每个值（从左到右），以便将其减少到单个值。`

`reduce 返回结果，一样会遍历循环，有四个参数，它是会等全部循环遍历完成之后，然后在取那个 return 的值，意思就是取最后return出来的那个结果`

**参数：**

**preValue** : 代表上一次回调函数调用返回的值 `（第 1 个参数）`

**ele** : 循环遍历的每一个当前元素对象 `（第 2 个参数，什么变量都可以）`

**index** : 相当于for循环的那个 i，当前在表中操作的当前项的索引。，遍历第一遍：0，第二遍：1 `（第 3 个参数，什么变量都可以）`

**array** : 当前元素所属的数组对象。相当于this，就是调用的是那个数组，一般用不到 `（第 4 个参数，什么变量都可以）`

```js
var arr = [1,2,3,4,5];
arr.reduce(function(preValue,ele,index,array){
    console.log(preValue);
    return ele;
},10) // 实参，如果这里不给preValue值的话，preValue就会直接取数组的第一位，ele就取的第二位
```

```js
累加器:
// 为什么说要用 reduce 做累加器呢，因为效率比for循环高
var arr = [1,2,3,4,5];
var value = arr.reduce(function(preValue,ele,index){
    return preValue + ele;
}) // 实参，如果这里不给preValue值的话，preValue就会直接取数组的第一位，ele就取的第二位
console.log(value);
```

```js
reduce 源码剖析：

Array.prototype.myReduce = function (func, init) {
    var previous = init,
        k = 0;
    if (init == undefined) {
        previous = this[0];
        k = 1;
    }
    for (k; k < this.length; k++) {
        previous = func(previous, this[k], k);
    }
    return previous;
}
```

#### reduceRight 累加器（从右向左）

`reduce 从右向左循环遍历数组，累加器（就是把之前遍历的数组），取出来的值只有一个。效率及其高`

`该方法应用一个函数是"累加器"，并处理列表的每个值（从左到右），以便将其减少到单个值。`

`reduceRight 返回结果，一样会遍历循环，有四个参数，它是会等全部循环遍历完成之后，然后在取那个 return 的值，意思就是取最后return出来的那个结果`

**参数：**

**preValue** : 代表上一次回调函数调用返回的值 `（第 1 个参数）`

**ele** : 循环遍历的每一个当前元素对象 `（第 2 个参数，什么变量都可以）`

**index** : 相当于for循环的那个 i，当前在表中操作的当前项的索引。，遍历第一遍：0，第二遍：1 `（第 3 个参数，什么变量都可以）`

**array** : 当前元素所属的数组对象。相当于this，就是调用的是那个数组，一般用不到 `（第 4 个参数，什么变量都可以）`

```js
var arr = [1,2,3,4,5];
arr.reduce(function(preValue,ele,index,array){
    console.log(preValue);
    return ele;
},10) // 实参，如果这里不给preValue值的话，preValue就会直接取数组的第一位，ele就取的第二位
```

```js
累加器:
// 为什么说要用 reduce 做累加器呢，因为效率比for循环高
var arr = [1,2,3,4,5];
var value = arr.reduce(function(preValue,ele,index){
    return preValue + ele;
}) // 实参，如果这里不给preValue值的话，preValue就会直接取数组的第一位，ele就取的第二位
console.log(value);
```

```js
reduce 源码剖析：

Array.prototype.myReduce = function (func, init) {
    var previous = init,
        k = this.length - 1;
    if (init == undefined) {
        previous = this[0];
        k = this.length - 2;
    }
    for (k; k > this.length; k --) {
        previous = func(previous, this[k], k);
    }
    return previous;
}
```

## 类数组

`1. 可以利用属性名模拟数组的特性`

`2. 可以动态的增长 length 属性`

`3. 如果强行让类数组调用 push 方法，则会根据 length 属性值的位置进行属性的扩充`

```js
这个看着像数组，但是数组有的方法，他全部都没有，所以他是类数组
    function test(){
        concole.log(arguments);
        argumetns.push(7);
    }
    test(1,2,3,5,6,7);
    // 从控制台输出：
    // >  [1,2,3,5,6,7]
    // <· 报错

`类数组长得很像数组，但是没有数组所拥有的方法`。

    var obj = {
        '0' : 'a',
        '1' : 'b',
        '2' : 'c'
    }
    var arr = ['a','b','c']
    // 从控制台输出：
    // >  obj[0]
    // <· 'a'
    // >  obj[0]
    // <· 'a'
```

```js
`下面就是类数组的基本形态`

   var obj = {
        '0' : 'a',
        '1' : 'b',
        '2' : 'c',
        'length' : 3,
        'push' : Array.prototype.push
    }
    // 从控制台输出：
    // >  obj.push('d')
    // <· 4
    // >  obj
    // <· Object{0:'a',1:'b',2:'c',3:'d',length:4}
// 分析：在控制台 push('d') 以后，obj的object多了一个 3 : d,长度也变成了 4

`类数组：属性要为索引（数字）属性，必须要有 length 属性，最好加上 push 方法。`

如果给一个对象加上 splice 方法，那么这个对象就长得像数组了。但是他仍探视对象，但是可以当作数组来用，需要自己添方法。
    var obj = {
        '0' : 'a',
        '1' : 'b',
        '2' : 'c',
        'length' : 3,
        'push' : Array.prototype.push,
        'splice' : Array.prototype.splice // 可以把类数组变成数组
    }
    Array.prototype.push = function(target){
        this[this.length] = target;
        this.length ++;
    }

    `如果对象 obj 调用这个方法，那么 this 变成了 obj`

    Array.prototype.push = function(target){
        obj[obj.length] = target;
        obj.length ++;
    }

阿里巴巴题目，问这个 obj 长什么样子？
    var obj = {
        '2' : 'a',
        '3' : 'b',
        'length' : 2，
        'push' : Array.prototype.push
    }
    obj.push('c');
    obj.push('d');
    // 答案：
    // obj
    // Object{2:'c',3:'d',length:4}

`关键点在 length 上面，根据 length 改变而改变，走一下length，既：`

    Array.prototype.push = function(taret){
        this[obj.length] = target;
        this.length ++;
    }
    var obj = {
        '1' : 'a',
        '2' : 'c',
        '3' : 'd',
        'length' : 3,
        'push' : Array.prototype.push
    }
    obj.push('b');
    // 答案：“ 1”：“a”，“2”：“ c”，“ 3”：“b”，“ length”： 4


    var obj = {
        '0' : 'a',
        '1' : 'b',
        '2' : 'c',
        name : 'abc',
        age : 123,
        length : 3,
        push : Array.prototype.push,
        splice : Array.prototype.splice
    }
    // 从 console 输出:
    // >  obj
    // <· ['a','b','c']
    // >  obj.name
    // <· 'abc'
    // >  obj.age
    // <· 123
    // >  obj.length
    // <· 3
    // >  for(var prop in obj){console.log(obj[prop])}
    // <· a
    // <· b
    // <· c
    // <· abc
    // <· 123
    // <· 3
    // <· function push(){[native code]}
    // <· function splice(){[native code]}
    // <· undefined
```

## 作业，练习

```js
1. 封装 type 方法达到下面的效果
    // 封装 type
    typeof([]) -- array
    typeof({}) -- object
    typeof(function) -- object
    typeof(new Number()) -- number Object
    typeof(123) -- number

// console 输出
    // >  Object.prototype.toString.call(new Number(123))
    // <· '[object Number]'
    // >  Object.prototype.toSTring.call(123)
    // <· '[object Number]'
;

答案:
    1. 封装 type （这个方法是一个工具类方法，可以存放在库里面），区分 typeof 方法

        1）先分类，原始值，引用值

        2）区分引用值，先判断是不是 null

    数组，对象，包装类（new number）会返回 object，通过 Object.prototype.toString;

 1. function type(target){
        var template = {
            '[object Array]' : 'array',
            '[object Object]' : 'object',
            '[object Number]' : 'number - object',
            '[object Boolean]' : 'boolean - object',
            '[object String]' : 'string - object'
        }
        if(target === null){
            return null;
        }
        if(typeof(target) == 'function'){
            return 'function';
        }else if(typeof(target) == 'object'){
            var str = Object.prototype.toString.call(target);
            return template(str);
        }else{
            return typeof(target);
        }
    }

`简化之后`

 2. function type(target){
     var template = {
        '[object Array]' : 'array',
        '[object Object]' : 'object',
        '[object Number]' : 'number - object',
        '[object Boolean]' : 'boolean - object',
        '[object String]' : 'string - object'
     }
     if(target === null){
         return null;
     }
     if(typeof(target)){
         var str = Object.prototype.toString.call(target);
         return template[str];
     }else{
         return typeof(target);
     }
 }

 `进一步简化`

 function type(target){
     var ret = typeof(target);
     var temp = {
        '[object Array]' : 'array',
        '[object Object]' : 'object',
        '[object Number]' : 'number - object',
        '[object Boolean]' : 'boolean - object',
        '[object String]' : 'string - object'
     }
     if(target === null){
         return null;
     }else if(ret = 'object'){
         var str = Object.prototype.toString.call(target);
         return temolate[str];
     }else{
         return ret;
     }
 }

```

```js
2. 数组去重
    // 数组去重
    var arr = [1,1,1,1,2,2,2,0,0,0,'a','a','b','b']
    arr.unique() --> [1,2,0,'a','b']

`数组去重(利用对象的特性做数组去重，去重就是去掉重复)

思路：写一个对象，把数组的每一位当做对象的属性名。利用对象的特性（同一属性名不可以出现两次），先把第一位当作属性名添加进去，属性值随便写个，在看第一二位，如果第二位在对象里面有属性名，就看下一位，如果对象没有属性名，就把这个值添加进去当属姓名，只看对象的属性名，就去重了，这个方法叫 hash
`
答案：
    Array.prototype.unique = function(){
        var temp = {},
            arr = [],
            len = this.length;
        for(var i = 0;i < len; i ++){
            if(!temp[this[i]]){
                temp[this[i]] = 'abc';
                arr.push(this[i]);
            }
        }
        return arr;
    }

`每一圈循环都要 this.length; 写成 var len = this.length;这样直接放值能少一些运算。 [this[i]]代表数组的第几位。 “abc”可以随便填值（要求是字符串，但是不为 false）， 但是填[this[i]]= [this[i]];在数组有 0 的时候就会有 bug。

if 里面取到值什么都不敢，取到 undefined才开始操作，所以写非！，没有值，才处理 `
```

# 复习

## 复习包装类

`引用值就是一种对象（泛泛的概括类对象），包括数组，函数，对象。在内存里面存储。原始值不能有属性和方法，引用之才可以有，但是经过包装类后，原始值就能有属性和方法。`

`通过原始值访问属性和方法，系统为了让语法好用，不报错，系统会帮我们进行一个 js 内部机制包装类`

```js

    var str = 'abc';
    // new String('abc').length
    console.log(str.length);

`思路：即隐式的 new String构造出一个字符串对象，然后把字符串内容与原来保持一 致 new String (‘abc’)，因为我们进行了 str.length 操作，那么他也加上.length，变成 了隐式 new String (‘abc’).length。这里虽然写的是 console.log(str.length)，实际上执 行的是 console.log(new String (‘abc’).length)  这样隐式的执行过程就是包装类。`


    var num = 123;
    num.abc = 'abc';
    // new Number(num).abc = 'abc'; --> delete

    // new Number(num).abc;
    console.log(num.abc);

`答案 undefined思路：当num.abc = “abc”时，系统会进行包装类，隐式的 new Number(num).abc = “abc”；执行完这一步以后就会delet 掉这个隐式的值，并不保 留。等下一步又遇到 num.abc 时，又隐式的 new了一个 number。但是这个和上一个 是两个 new Number，是两个彼此独立的对象。`

`new.Number(123).abc 和 var num = new Number(123); num.abc 是一样的`
```

## 复习原型

```js
`任何函数都有原型，包括构造函数，这是一个构造函数，原型需要基于构造函数，没有原型的构造函数没有意义，任何一个函数都有 prototype`
    Person.prototype.lastName = 'deng';
    function Pereson(){
        var this = {
            __proto__ : Person.prototype
        }
    }
    var person = new Person();
    console.log(person.lastName);
```

## 复习 creat

`Object.creat(); 是创造的对象，对象必须要有原型，Object.creat();需要指定创建对象的原型是谁，括号里面就要填谁（所以括号里面一定要估值）`

```js

    var demo = {
        lastName : 'deng'
    }
    var obj = Object.creat(demo);
    obj = {
        __proto__ : demo
    }

`Object.creat(prototype.definedProperty)还能填第二个参数。第一个填的 prototype 表示你的原型是谁，第二个参数 definedProperty 是特性.(可读可写都是特性)`


    var num = 123;

    // 从 console 中控制：
    // >  delete num
    // <· false
    // >  delete widnow.num
    // <· false
`这个 nun 算是 window 的苏醒。写在全局的属性，一旦经历了 var 的操作，所得出的属性 window，这种属性叫做不可配置的属性，不可配置的属性，delete不掉。

直接增加的属性卡叫做可配置属性，delete 只能删除可配置的属性`


    var obj = {}
    obj.num;
    // 从 console 中控制：
    // >  delete obj.num
    // <· true
    // >  obj
    // <· Object {}

直接在控制台操作对比，发现 var 过的属性是不可配置的属性,delete不掉
    // 从 console 中控制：
    // >  window.num = 123
    // <· 123
    // >  delete window.num
    // <· true
    // >  window.num
    // <· undefined

    // >  var num = 123;
    // <· undefined
    // >  window.num
    // <· 123
    // >  delete window.num
    // <· false
    // >  window.num
    // <· 123

```

## 复习 this & call

`1. 预编译 this --> window`

`2. 谁调用的，this 指向谁`

`3. call 和 apply 能改变 this 的指向`

`4. 全局 this --> window`

```js
注释掉的是预编译的过程
    function test(){
        var num = 123;
        function a(){

        }
    }
    // test() --> AO{
    //     arguments : {}，
    //     this : window,
    //     num : undefined,
    //     a : function(){}
    // }

test();完全是等于 test.call();执行，其实 test() 执行会内部转换成 test.call();执行

    function test(){
        console.log(this);
    }
    test.call();
    // Window

如果我们在 test.call();里面传值，第一个值就会作为函数执行时的 this 环境
    function test(){
        console.log(this);
    }
    // test();
    test.call({name : 'deng'}); // Object{name : 'deng'}
    // test() --> AO{
    //         arguments : {},
    //         this : {name : 'deng'},
    //         num : undefined,
    //         a : function(){}
    // }


    var name = 'window';
    var obj = {
        name : 'obj',
        say : function(){
            name : 'obj',
            console.log(this.name);
        }
    }
    obj.say();
    //  obj

    var name = 'window';
    var obj = {
        name : 'obj',
        say : function(){
            name : 'obj',
            console.log(this.name);
        }
    }
    obj.say.call(window);
    //  window
`obj.say.call(window);有 call 就打破一切规则，call() 里面传的是谁，就是谁`


    var name = 'window';
    var obj = {
        naem : 'obj'm
        say : function(){
            console.log(this.name);
        }
    }
    var fun = obj.say;
    fun(); //--> 只能走预编译

`var fun = obj.say 先当与 var fun = say : function(){} 里面的函数体`

`fun(); 相当于让 say : function 在这函数在全局范围内自调用，不是谁调用的，就只能走预编译，this 就是 window`


    var name = 'window';
    var obj = {
        name : 'obj',
        say : function(){
            console.log(this.name);
        }
    }
    var fun = obj.say;
    fun.call(obj);
    // obj

想让 Person 实现 Student 的功能
    function Person(name,age){
        this.name = name;
        this.age = age;
    }
    function Student(name,age,sex){
        // var this = Object.creat(Student.prototype);
        this.name = name;
        this.age = age; // 简化为 Person.call(this,name,age);
        this.sex = sex;
    }
    var student = new Student('long',18,'male');
```

## 复习闭包

`闭包表象：一个函数套着另外一个函数，你把被嵌套的函数保存到套他的函数外面（a 套着 b，你把 b 弄出 a 里面），就形成了闭包（不一定要 return）`

```js
下面两种都可以实现闭包
  1)function a(){
        function b(){

        }
        return b;
    }
    a();

  2)var obj = {}
    function a(){
        function b(){

        }
        obj.fun = b;
    }
    a();
    // 123


    var a = 123;
    // this call
    go {
        a : 123
    }
    ao {
        a : undefined
    }
    function test(){
        a = 1;
        var a;
    }
    test();
```

## 复习构造函数

`通过构造函数构造对象的时候用 new,我执行函数的时候就不用 new`

`构造对象必须是 new 加上构造函数执行（如 person();）才能构造出对象`

`有了 new 之后，才会发生两步隐式变化（var this = {}； return this）`

```js

    function Person(){
        // var this = {}
        this.name = 'abc';
        this.age = 123;
        // return this;
    }
    var pereson = new Person();
// 没有 var person = new Person(); 只 Person 会走预编译，此时 this 指向 window

私有化属性看不到 Var money = 100; 外部看不到 var money,就是闭包
    function Person(name){
        // var this = {
            // makeMoney : function(){}
            // offer : function(){}
        // }
        var money = 100;
        this.name = name;
        this.makeMoney = function(){
            money ++;
        }
        this.offer = function(){
            money --;
        }
        // return this;
    }
    var person = new Person();


    var inherit = (function(){
        var F = function(){};
        return function(Target,Origin){
            F.prototype = Origin.prototype;
            Target.prototype = new F();
        }
    }())
    `立即执行函数执行完就成下面这样了`
    var inherit = function(Target,Origin){
        F.prototype = Origin.prototype;
        Target.prototype = new F();
    }

引用值也可以进行类型转换

`数组不等于数组，因为里面的地址不一样`

    // 从控制台输出
    >  [] + ''
    <· ''
    >  [] + 2
    <· '2'
    >  Number([])
    <· 0
    >  [] == []
    <· false
    >  String([]) + 1
    <· '1'
```

## 复习克隆

```js

    var obj = {
        naem : 'abc'
    }               // 浅克隆
    var obj1 = {    // 当拷贝引用值的收就不行了

    }
    for(var prop in prop){
        obj1[prop] = obj[prop];
    }
`这样浅度克隆，克隆的是地址，缺点是你改我也改`

`深度克隆解决的就是引用值`

`null 和 undefined 不能和数字进行比较，不会进行类型转换，他们不作为比较值存在`
```

## 复习题

```js
私有化变量
    function Person(name,age,sex){
        var a = 0;
        this.name = name;
        this.age = age;
        this.sex = sex;
        function sss(){
            a ++;
            documents.write(a);
        }
        this.say = sss;
    }
    bst oPrtrdon = mre Person();
    oPerson.say();
    oPerson.say();
    var oPerson1 = new Person();
    oPerson1.say();
    // 打印 1，2，1


    (function(x){
        delete x;
        return x;
    }(1));
    // 答案 1，删不掉x，该是什么是什么


    function test(){
        console.log(typeof(arguments));
    }
    test();
    // 返回 object


    var h = function a(){
        return 23;
    }
    console.log(typeof a());
    // error : a is not a defined
    // 报错

选择你熟悉的一种方式实现JavaScript 对象的继承
    // 案：声明模式

实现 object 类型的 clone()方法
    // 答案：深度克隆

尝试优化以下代码，让代码看起来更优雅
    function getDay(day){
        switch(day){
            case 1:
                documents.wirte('Monday');
                break;
            case 2:
                documents.wirte('Tuesday');
                break;
            case 3:
                documents.wirte('Wednesday');
                break;
            case 4:
                documents.wirte('Thursday');
                break;
            case 5:
                documents.wirte('Friday');
                break;
            case 6:
                documents.wirte('Saturday');
                break;
            case 7:
                documents.wirte('Sunday');
                break;
            case default:
                documents.wirte('Error');
                break;
        }
    }
    // 答案：
        function retDate(date){
            var arr = ['1','2','3'];
            var ret = arr[date - 1];
            if(ret === undefined){
                return 'error';
            }else{
                return ret;
            }
        }

`SEO 是搜索引擎优化`

HTML布局实现：头和尾固定，中间自适应。
// 答案：三栏布局，头尾是指左右

在页面中增加一个 div（宽度 400px，高度400px，背景颜色蓝色，边框颜色红 色），该 div要求在页面中居中显示。
简单画图描述CSS盒模型

css中的选择器有哪些？
// 答案：id 选择器是 xxx，先说类型在举例

JavaScript 中有哪些数据类型？
// 答案：原始值里面有 XXX，引用值里面有 XXXX

什么是 rem布局？
html 顶部的DOCTYPE 有什么作用？有什么影响？
Display的参数值及其含义

描述一下盒模型
// 答案：需要讲两种才满分

css3可用伪类都有那些？
position属性有哪些值，有什么区别？
如何创建一个 div，并添加到页面里。
写一个正则表达式，检验字符串首尾是否含有数字
跨域请求数据的方法都有哪些？
编写一个类和类继承，类名为Person，含有属性 name，age，含有方法$。一个 student 类，继承自Person，自由属性 score，自有方法 study
（类指的就是构造函数）

`一个字符串[a - z]组成，请找出该字符串第一只出现一次的字母。`

`字符串去重`
```

# try...catch

`防止我们报错的`

`try花括号{里面会正常执行，但是遇到 b 报错时 b 就执行不出来，后面的代码 c 就不执行了，但是外面的代码 d 还能执行}catch(e),这个 e 是可以随便写的，写 abc 都可以，也是一个形参`

```js

    try{
        console.log('a');
        console.log(b);
        console.log('c');
    }catch(e){

    }
    console.log('d');
`报错后，不执行后续的代码，但是依然可以执行外面的d`
```

`在 try 里面发生的错误，不会执行错误后的 try 的里面的代码`

`catch`

```js

    try{
        console.log('a');
        console.log('b');
        console.log('c');
    }catch(e){
        console.log('e');
    }
    console.log('d');
`如果 try里面的代码不出错，在 catch 里面的代码就不执行；`


    try{
        console.log('a');
        console.log(b);
        console.log('c');
    }catch(e){
        console.log('e');
    }
    console.log('d');
`如果 try里面的代码出错，catch 负责补抓到错误信息封装到里面（error.massage    error.name）， 错误对象只有 message 和 name。 `


    try{
        console.log('a');
        console.log(b);
        console.log('c');
    }catch(e){// error   error.message error.name --> error
        onsole.log(e.message + " " + e.name);
    }
    console.log('d');

    // 从控制台输出：
    // a
    // b is not defined ReferenceError
    // d


    try{
        console.log('a');
        console.log(b);
        console.log('c');
    }catch(e){
        console.log(e.name + ' : ' + e.message);
    }
    console.log('d');
    // 从控制台输出：
    // a
    // ReferenceError : b is not defined
    // d

`try{}catch(e)finally{}`
```

# Error.name 的六种值对应的信息

`Error.name : 前面是错误名称，后面是错误信息`

`1. EvalError : eval() 使用与定义不一致不一致（eval 是不允许被使用的）`

`2. RangeError : 数值越界`

`3. ReferenceError : 非法或不能识别的引用数值（未经声明就使用，未经定义就使用）`

`4. SyntaxError : 操作数类型错误`

`5. TypeError : 操作数类型错误`

`6. URIError : URI处理函数使用不当（引用地址错误）`

> 大部分都是 3 和 4 这种错误，

`伪代码也可以写，就比如 var 老于 = 123; 这就是伪代码`

`var str = avs ==> ReferenceError`

# es5.0 严格模式

`（这一章就是讲 es3.0 和 es5.0产生冲突的部分）`

`浏览器是基于 es3.0 和 es5.0 的新增方法使用的。`

`如果两种发生了冲突，就用 es3.0。`

`es5.0 严格模式是指 es3.0 和 es5.0 产生冲突发部分就是用 es5.0，否则就用 es3.0`

`es5.0 严格模式的启动方式，在页面逻辑最顶端写 'use strict'`

`用法在整个页面的最顶端写 'use strict',可以写在全局的最顶端，也可以写在 某函数（局部）的最顶端，推荐使用局部的`

```js
es5.0 不能用 argument.callee,但是 es3.0 可以用
    // es5.0 严格模式的启动

    'use strict';
    function test(){
        console.log(argumetns.callee);
    }
    test();
    // 报错：es5.0模式下不能用 callee 和 caller

function test(){} 里面加 'use strict'; 是局部启动严格模式
    function demo(){
        console.log(arguments.callee);
    }
    demo();

    function test(){
        'use strict';
        console.log(arguments.callee);
    }
    // function demo(){
    //     console.log(arguments.callee)
    // }
    // 报错
```

`'use strict'`

>不在兼容 es3.0 的一些不规则语法。使用全新的 es5.0 规范。两种用法：

`一、全局严格模式`

`局部函数内严格模式（推荐）`

`就是一行字符串，不会对不兼容严格模式的浏览器产生影响。`

`不支持 with，argumetns.callee，function.caller，变量赋值前必须声明，局部 this 必须被赋值（Perosn.call(null/unfined)) 赋值什么就是什么，拒绝重复属性和参数`

```js

    'use strict'
    浏览器升级到 es5.0 才好用
    写成 strice();就有风险
    写成 'use strict'; 就有一个向后兼容的作用
```

```js
es5.0 严格模式下不能用 with
    with 可以改变作用域链
    with()括号里面的代码会按照正常顺序执行，但是如果在括号里面添加了对象，就会把对象当作 with 要执行的代码体的作用域链的最顶端（最直接的最近的 AO）
```

```js
下面这个 with 看到的就是 var obj 的 name （with 改变作用域链）
    var obj = {
        name : 'obj',
        age = 234
    }
    var name = 'window';
    function test(){
        var age = 123;
        var name = 'spoce';
        with(obj){
            console.log(name);
            console.log(age);
        }
    }
    // obj,234
```

```js
命名空间应该像下面这样用的，with 可以简化代码
    var org = {
        dp1 : {
            jc : {
                name : 'abc',
                age : 123
            },
            deng : {
                name : 'xiaodeng',
                age : 234
            }
        },
        dp2 : {

        }
    }
    with(org.dp1.jc){
        console.log(name);
    }


    with(document){
        write('a');
    }
`这也是 with 的运用方式，用with 表示 document.write();`
```

> with 过于强大，可以改变作用域链，失去效率，所以es5.0不能用

`argumetns.callee`

```js

    function test(){
        console.log(argumetns.callee);
    }
    test();
    // 报错 -- TypeError ：'caller','callee'
```

```js
arguments.callee 在 es5.0 严格模式下报错
    'use strice';
    function test(){
        console.log(test.caller);
    }
    function demo(){
        test();
    }
    demo();
    // 报错 -- TypeError ：'caller','callee'
```

`es5.0 严格模式下：变量赋值前必须声明，局部 this 必须被赋值`

`（Person.call(null/undefined) 赋值什么就是什么），拒绝重复属性和参数（this 不在指向 window）`

```js

    var a = b = 3;
    // 报错
    a = 3;
    // 报错
```

```js
局部 this 必须被赋值 (Person.call(null/undefined)赋值什么就是什么)
    'use strict';
    function test(){
        console.log(this);
    }
    test();
    // undefined
```

```js
该对象的 constructor是 Test
    'use strict';
    function Test(){
        console.log(this);
    }
    new Test();
    // Test{}

    'use strict';
    function Test(){
        console.log(this);
    }
    new Test.call({});
    // Object{}

    'use strict';
    function Test(){
        console.log(this);
    }
    new Test.call(123);
    // 123
```

```js
`在 es3.0 里面是不能这样的`

    function Test(){
        console.log(this);
    }
    Test.call(123);
    // Number{[[PrimitiveValue]]:123}
    // >  new Number(123) 这是包装类的显示形式
    // <· Number{[[PrimitiveValue]]:123}
```

```js
在 es5.0 中全局的 this 还是指向 window
    'use strict';
    console.log(this);  //--全局范围
    // Window
```

```js
拒绝重复属性和参数（this 不在指向 window）
    function test(name,name){
        console.log(name);
    }
    test(1);
    // undefined

    function test(name,name){
        console.log(name);
    }
    test(1,2);
    // 2
```

```js
`在 es3.0 里面重复的参数是不报错的，但是在 es5.0 里面是会报错的`

    'use strict';
    function test(name,name){
        console.log(name);
    }
    test(1,2);
    // SyntaxError:Duplicate  -- 报错

`重复的属性名在 es5.0 也不行，但是不报错（后面会覆盖前面的）`

    'use strict';
    var obj = {
        name : '123',
        name : '234'
    }
```

`eval 很强大，能把字符串当成代码来执行`

`但是约定俗成在 es3.0 中都不能使用 eval。eval是魔鬼，因为会改变作用域`

```js

    'use strict';
    var a = 123;
    eval('console.log(a)');

// es3.0 都不能 eval();eval 是魔鬼
    var global = 100;
    function test(){
        global = 200;
        eval('console.log(global)');
    }
    test();
```

```js
如果改变 global，他改变的是全局的

当情况不同，eval 改变的作用域是不同的

eval 还有自己独立的作用域

理解：可以把回调函数理解为先定义好了函数，执行的时候再回头调用
```

# 什么是DOM

1. DOM  --->    Document Object Model（文档对象模型

2. DOM 定义了表示和修改文档所需的方法（对象，这些对象的行为和属性以及这些对象之间的关系。）DOM 对象即为宿主对象，有浏览器厂商定义，用来操作 html 和 xml 功能的一类对象的集合。

`也有人称 DOM 是对 HTML 以及 XML 的标准编程接口`

`xml ==> xhtml ==> html`

`xml 是最早的版本，xml里面的标签是可以自己定义的，被 js 里面的 jeson 取代了，dom 不能改变 css 样式表，但是可以简介改变行间样式的 css`

```js
说的是改变不了 css 是指改变不了 css 的样式表，但是可以通过间接方式改变 html 的行间样式来改变

    <body>
        <div></div>
        <script>
            var div = document.getElementsByTagName('div')[0];
            div.style.widht = '100px';
            div.style.height = '100px';
            div.style.backgroundColor = 'red';
        </script>
    </body>

`1. 找到 html 的方法：如 document。getElementsByTagName('div')就能把所有的 div 都选出来。

如果想要拿到第一个 div ，写成 document.getElementByTagName('div') 后面就要加一个[0];就可以实现了

2. div.style 选出来代表行间样式，选出来的就是 dom 对象

3. js 不能写 -(号) ，只能用小驼峰方法写。如 background-color 写成 bakgroundColor
`
```

```js

    有 dom 操作以后就变成动态交互可以操作的了（你动一下，他给你一个反应）
    div.onclick 是一个交互效果的事件监听

    <body>
        <div></div>
        <script>
            var div = document.getElementsByTagName('div')[0];
            div.style.widht = '100px';
            div.style.height = '100px';
            div.sytle.backgroundColor = 'red';

            div.onclick = function(){
                this.style.backgroundColor = 'green';
                this.style.widht = '200px';
                this.style.height = ' 50px;';
                this.style.borderRadius = '50%';
            }
        </script>
    </body>
```

```js
实现点击一下改变一下颜色
    <div></div>
    <script>
        var div = document.getElementsByTagName('div')[0];
        div.style.widht = 100px;
        div.style.height = '100px';
        div..style.backgroundColor = 'red';

        var count = 0;
        div.onlick = function(){
            count ++;
            if(count % 2 == 1){
                this.style.backgroundColor = 'green';
            }else{
                this.style.backgroundColor = 'red'
            }
        }
    </script>
```

```js
选项卡
`写个选项卡，点第一个按钮出现第一对应的信息，点第二个按钮，第一个消失，第二个显示`

    <head>
        <style>
            .content{
                display:none;
                width:200px;
                height:200px;
                border:2px solid red;
            }
            .active{
                background-color:yellow;
            }
        </style>
    </head>

    <body>
        <div class="wrapper">
            <button class="active">111</button>
            <button>222</button>
            <button>333</button>
            <div class="content" style="display:block">1111</div>
            <div class="content">2222</div>
            <div class="content">3333</div>
        </div>

        <script>
            var btn = document.ElementsByTagName('button');
            var div = document.ElementsByClassName('content');
            for(var i = 0; i < btn.length; i ++){
                (function(n){
                    btn[i].onlick = function(){
                    for(var j = 0;j < btn.length; j ++){
                        btn[i].className = '';
                        div[i].style.display = 'none';
                    }
                    this.className = 'active';
                    div[i].style.display = 'block';
                    }
                }(i))
            }
        </script>
    </body>
```

```js
小方块应用
`document.body.appendChild(div); -- 意思是在body里面放一个 div`

`setInterval(function(){},100) -- 是一个定时器功能，意思是每隔 100毫秒 就执行一次`
    var div = document.createElement('div');

    document.body.appendChild(div);
    div.style.width = '100px';
    div.style.height = '100px';
    div.style.backgroundColor = 'red';
    div.style.position = 'absolute';
    div.style.left = '0';
    div.style.top = '0';

    setInterval(function(){
        div.style.left = parseInt(div.style.left) + 2 + 'px';
        div.style.top = parseInt(div.style.left) + 2 + 'px';
    },50)

    `把上面的 setInterval(function(){}) 改成下面样式`

    var speed = 1;
    setInterval(function(){
        speed += speed / 7;
        div.style.left = parseInt(div.style.left) + speed + 'px';
        div.style.top = parseInt(div.style.top) + speed + 'px';
    },10)

    `把上面的 setInterval(function(){}) 改成以下样式，可以让定时器停止`

    var speed = 1;
    var timer = setInterval(function(){
        speed += speed / 20;
        div.style.left = parseInt(div.style.left) + speed + 'px';
        div.style.top = parseInt(div.style.top) + speed + 'px';
        if(parseInt(div.style.top) > 200 && parseInt(div.style.left) > 200){
            clearInterval(timer)
        }
    },10);
```

```js
实现键盘控制小方块
    var div = document.createElement('div');
    document.body.appendChild(div);
    div.style.widht = '100px';
    div.style.height = '100px';
    div.style.background = 'red';
    div.style.position = 'absolute';
    div.style.left = '0';
    div.style.top = '0';

    document.onkeydown = function(e){
        switch(e.which){
            case 38:
                div.style.top = parseInt(div.style.top) - 5 + 'px';
                break;
                // 向下
            case 40:
                div.style.top =  parseInt(div.style.top) + 5 + 'px';
                break;
                // 向上
            case 37:
                div.style.left = parseInt(div.style.left - 5 + 'px');
                break;
                // 向右
            case 39:
                div.style.left = parseInt(div.style.left) + 5 + 'px';
                break;
                // 向左
        }
    }
```

```js
点击运动加速

`思路：每一次按下的时候都记录一个新的时间片段，都减去上一个执行的时间 片段，如果时间片段都小于一定的毫秒数的话，我们让一个计数器去++，当连续小 于的时候，就让计数器连续++,如果++到一定数的时候，我们认为是连续按了，再按 就加速了，让每一次按的时候都判断一下,如果时间间隔过大的话，就让计数器重新 归 0`

`按住加速：就是这一次按下与下一次按下的速度间隔时间十分短暂，就认为他加速 了。`
    <body>
            <button style="
            width: 100px;height: 50px;
            background:linear-gradient(to left,#999,#000,#432,#fcc);position: fixed;right:0;top:50%;
            text-align: center;line-height: height;color: #fff;
            font-size: 25px;font-family: Arial;">
            加速</button>

            <script>
            var btn = document.getElementsByTagName('button')[0];
            var div = document.createElement('div');
            document.body.appendChild(div);
            div.style.width = '100px';
            div.style.height = '100px';
            div.backgroundColor = 'red';
            div.style.position = 'absolute';
            div.style.left = '0';
            div.style.top = '0';

            var speed = 5;
            btn. = function () {
                speed++;
            }
            document.onkeydown = function (e) {
                switch (e.which) {
                    case 38:
                        div.style.top = parseInt(div.style.top) - speed + 'px';
                        break;
                    case 40:
                        div.style.top = parseInt(div.style.top) + speed + 'px';
                        break;
                    case 37:
                        div.style.left = parseInt(div.style.left) - speed + 'px';
                        break;
                    case 39:
                        div.style.left = parseInt(div.style.left) + speed + 'px';
                        break;
                }
            }
        </script>
    </body>
```

```js
划过出现颜色
`box-sizing:border-box -- 启动了另外一种盒模型（IE盒模型）`
    <head>
        * {
            margin: 0;
            padding: 0;
        }

        li {
            width: 10px;
            height: 10px;
            /* border: 1px solid black; */
            float: left;
            list-style-type: none;
            box-sizing: border-box;
        }

        ul {
            width: 200px;
            height: 200px;
        }
    </head>

    <body>
        <ul> <li img-data='0'></li> * 400 </ul>

    <script>
        var ul = document.getElementsByTagName('ul')[0];
        ul.onmouseover = function (e) {
            var event = e || window.evnet;
            var target = event.target || event.srcElement;

            target.style.backgroundColor = 'rgb(0,255, '+ target.getAttribute('img-data') + ')'
            target.setAttribute('img-data',parseInt(target.getAttribute('img-data')) + 6)
        }
    </script>
    </body>
```

# DOM 基本操作 ①（大部分都是类数组）—— 方法类选中操作

`对节点的增删改查`

() 号里面都不用写 . 或 #

查，查看元素节点

document：代表整个文档（如果给 html 标签上面再套一层标签就是 document）

## （Id）getElementById

`元素 id 在 Ie8 以下的浏览器，不区分 id 大小写，而且也返回 name 属性的元素，通过 id 标识我们来选择这个元素，一一对应`

`getElementById`

```js
<div name='only'>123</div>
<script>
    var div = document.getElementId('only');
</script>
```

除了 id 以外，其余选择出来的都是一组，很少用 id 选择器

## （标签）getElementsByTagName

`标签名，这是一个类数组，最主流的用法，经常用`

`getElementsByTagName`

```js
把页面里面的所有的 div 都选择出来
<div id='only'></div>
<script>
    var div = document.getElementsTagName('div');
</script>
// 从控制台输出
// >  div
// <· [div#only]
// >  div.push(1)
// <· 报错
从 dom 开始，我们所学的一切系统给我们生成数组的东西，基本上都是类数组
```

```js
加个 [0] 就选中了第一个 div，如果不加 0 ，那个 div 表示的是一个数组，设置背景颜色就会报错
<div id='only'></div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>
```

## （name）getElementsByName

`IE不支持需注意，只有部分标签 name 可生效（表单，表单元素，img，iframe）不是在所有的浏览器都能用——开发一般不用`

`getElementsByName`

```js
<input name="fruit">
<script>
    var div = document.getElementsByName('frult')
</script>
```

```js
把下面所有的 div 都拿出来
<div></div>
<div></div>
<div></div>
<p></p>
<script>
    var div = document.getElementsByTagName('div')
</script>
```

只拿出第二个 div，加上[1],或在控制台上打 div[1]

```js
选择第一个 p 的方式如下
<div>
    <p></p>
</div>
<script>
    var p = document.getElementsByTagName('p')[0];
</script>
```

## （Class）getElementsByClassName

`类名 ->缺点： ie8和ie8 以下的 ie 版本中没有，可以多个 class 一起，不是所有浏览器都能用`

`getElementsByClassName`

```js
只选择 .demo 的 p 标签 写法如下：
<div>
    <p class='demo'></p>
</div>
<script>
    var p = document.getElementsByClassName('demo')[0]
</script>

注意哪怕整个文只有一个 demo，也要加 [0],不然选出来的就是一个组
```

## （CSS）.querySelector()   <>  .querySelectorAll()

`.querySelector -- css选择器，只能选择一个，在 ie7 和 ie7 以下的版本中没有`

`.querySelectorAll -- css选择器，全选，选一组，在 ie7 和 ie7 以下的版本中没有`

`.querySelectorAll()和.querySelector()选出来的元素不是实时的（是静态的），所以一般不用，其他的再怎么修改，跟原来的没有关系 id 选择器不能太依赖，一般当顶级框架使用，在 css 中一般用 class 选择器`

`query 是一个词条`

```js
.querySelector()和.querySelectorAll()选出来的元素不是实时的，是静态的，是副本

<body>
    <div>
        <strong>123</strong>
    </div>
    <div>
        <span>
            <strong class='demo'></strong>
        </span>
    </div>
    <script>
        var strong = document.querySelector('div > span strong.demo');
        var strong1 = document.querySelectorAll('div > span strong.demo');
    </script>
</body>
// 从控制器输出：
// >  strong
// <· <strong class='demo'>123<strong>
// >  strong1
// <· [strong.demo]
```

```js
`下面的都是实时的`
<body>
    <div></div>
    <div class='demo'></div>
    <div></div>
    <script>
        var div = document.getElementsByTagName('div');
        var demo = document.getElementsByClassName('demo')[0]
        var newDiv = document.createElement('div');
        document.body.appendChild(newDiv);
    </script>
</body>
// 从控制器输出：
// >  div
// <· [div,div.demo,div,div]
```

```js
.querySelectorAll()选中了所有的 div，但是实时操作不能实时反馈
<body>
    <div></div>
    <div class='demo'></div>
    <div></div>
    <script>
        var div = document.querySelectorAll('div');
        var demo = document.getElementsByClassName('demo')[0];
        var newDiv = document.createElement('div);
        document.body.appendChild(newDiv);
    </script>
</body>
```

# DOM基本操作 ② --- 非方法类的节点操作

## 遍历节点树

`遍历节点树：（灵活，兼容好）--- 关系类的选择`

parentNode ——> 父节点（最顶端的 parentNode 为 #document）

childNodes ——> 子节点们（直接的节点数）节点包括文本节点，属性节点

firstChild ——> 第一个子节点

lastChild ——> 最后一个子节点

nextSibling ——> 后一个兄弟节点

previousSibling ——> 前一个兄弟节点

### parentNode --> 父节点

```js
<div>
    <strong>
        <span></span>
    </strong>
    <div>
        <p></p>
    </div>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从控制器输出：
// >  strong.parentNode
// <· <div></div>
// >  strong.parentNode.parentNode
// <· <body></body>
// >  strong.parentNode.parentNode.parentNode
// <· <html lang='en'><head></head><body></body></html>
// >  strong.parentNode.parentNode.parentNode.parentNode
// <· #document
// >  strong.parentNode.parentNode.parentNode.parentNode.parentNode
// <· null
```

### childNodes --> 子节点

```js
<div>
    <strong>
        <span>1</span>
    </strong>
    <span></span>
    <em></em>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从控制器输出：
// >  div.childNodes
// <· [text,strong,text,span,text,em,text]
// >  div.childNodes.length
// <· 7

// 解释：
    // 为什么是7个节点？
    第一个节点是 <div> 后面的文本节点（空格回车），第二个节点是元素节点 <strong></span>1</span></strong>,第三个节点是跟着的文本节点（空格回车），第四个节点是 <span></span> 第五个是跟着的文本节点（空格回车）第六个是 <em></em>，第七个是跟着的文本节点（空格回车）
```

### firstChild & lastChild --> 第一个子节点，最后一个子节点

```js
<div>
    123
    <!-- This si comment -->
    <strong></strong>
    <span></span>
</div>
<sctipt>
    var div = document.getElementsByTagName('div')[0];
</sctipt>
// 从控制器输出：
// >  div.firstChild
// <· "123"
// >  div.lastChild
// <· #text
```

### previousSibling & nextSibling --> 前一个兄弟节点，后一个兄弟节点

`previousSibling   前一个兄弟节点`

`nextSibling  后一个兄弟节点`

```js
<div>
    <!-- This is comment -->
    <strong></strong>
    <span></span>
</div>
<script>
    var strong = document.getElementsByTagName('strong')[0];
</sctipt>

// 从控制器输出：
// >  strong.nextSibling
// <· #text
// >  strong.nextSibling.nextSibling
// <· <span></span>
// >  strong.nextSibling.nextSibling.nextSibling
// <· #text
// >  strong.nextSibling.nextSibling.nextSibling.nextSibling
// <· null

// >  strong.previousSibling
// <· #text
// >  strong.previousSibling.previousSibling
// <· comment
// >  strong.previousSibling.previousSibling.previousSibling
// <· #text
```

## 基于元素节点树的遍历 -- 不包含文本节点

parentElement -- 遍历元素父节点

children -- 遍历元素子节点

childElementCount -- 查看元素子节点的个数

firstElementChild -- 第一个元素子节点

lastElementChild -- 最后一个元素子节点

previousElementSibling -- 前一个兄弟节点

nextElementSibling -- 后一个兄弟节点

`除 children 外，其余的 ie9 及以下不兼容`

### parentElement --> 返回当前元素的父元素节点 -- IE不兼容

```js
<div>
    123
    <!-- This is comment -->
    <strong></strong>
    <span></span>
</div>
<sctipt>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从控制器输出：
// >  div.parentElement
// <· <body></body>
// >  div.parentElement.parentElement
// <· <html lang='en'><head></head><body></body></html>
// >  div.parentElement.parentElement.parentElement
// <· null
```

### children --> 只返回当前元素的元素子节点

```js
<div>
    123
    <!-- This is comment -->
    <strong></strong>
    <span></span>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从控制器输出：
// >  div.children
// <· [strong,span]
```

### childElementCount -- 当前元素节点的子元素节点个数

`childElementCount === children.length  当前元素节点的子元素节点个数（IE 不兼容）———— 基本不用，因为与 length 相等`

```js
<div>
    123
    <!-- This is comment -->
    <strong></strong>
    <span></span>
<div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从控制器输出：
// >  div.childElementCount
// <· 2
// >  div.children.length
// <· 2
```

### firstElementChild & lastElementChild --> 第一个元素节点，最后一个元素节点

`firstElementChild --> 返回的是第一个元素节点（IE不兼容）`

`lastElementChild --> 返回的是最后一个元素节点（IE不兼容）`

```js
<div>
    123
    <!-- This is comment -->
    <strong></strong>
    <span></span>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从控制器输出：
// >  div.firstElementChild
// <· <strong></strong>
// >  div.lastElementChild
// <· <span></span>
```

### previousElementSibling & nextElementSibling --> 前一个兄弟元素节点，后一个兄弟元素

`previousElementSibling --> 前一个兄弟元素节点`

`nextElementSibling --> 后一个兄弟元素`

```js
<div>
    123
    <!-- This si comment -->
    <strong></strong>
    <span></span>
    <em></em>
    <i></i>
    <b></b>
</div>
<script>
    var strong = document.getElementsByTagName('strong')[0];
</script>

// 从控制器输出：
// >  strong.nextElementSibling
// <· <span></span>
// >  strong.nexElementSibling.nextElementSibling
// <· <em></em>
// >  strong.nextElementSibling.nextElementSibling.nextElementSibling
// <· <i></i>

// >  strong.previousElementSibling
// <· null
```

`除 children 外，parentElement、node.childElementCount、firstElementChild、lastElementChild、nextElementSibling、previousElementSibling 在 ie9 及以下不兼容`

`真正常用的就是 children，兼容性好`

## 每一个节点的四个属性

nodeName -- 节点标签名

nodeValue -- 文本注释节点

nodeType -- 查看节点类型

attributes -- 属性节点

hasChildNodes -- 判断有没有子节点

### nodeName -- 节点标签名

`元素的标签名，以大写形式表示，只读，不可写`

```js
<div>
    123
    <!-- This si comment -->
    <strong></strong>
    <span></span>
    <em></em>
    <i></i>
    <b></b>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// >  从控制器输出：
// >  div.childNodes[1].nodeName
// <· '#comment'
// >  div.childNodes[3].nodeName = 'abc'
// <· 'abc'
// >  divchildNodes[3].nodeName
// <· 'strong'
```

### nodeValue -- 文本/注释节点

`Text 文本节点或 Comment 注释节点的文本内容，可读写`

```js
<div>
    123
    <!-- This is comment -->
    <strong></strong>
    <span></span>
    <em></em>
    <i></i>
    <b></b>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 控制台输出：
// >  div.childNodes[0].nideValue
// <· '123'
// >  div.chidlNodes[0].nodeValue = 234
// <· 234
// >  div.childNodes[0].nodeValue
// <· '234'
// >  div.childNodes[0]
// <· '234'

// >  div.childNodes[1].nodeValue
// <· 'This si comment'
// >  div.childNodes[1].nodeValue = 'That si comment'
// <· 'That si comment'
// >  div.childNodes[1]
// <· >!-- That is comment -->
```

### nodeType（最有用） -- 节点类型

`该节点的类型，只读返回这个 div 的所有的元素节点`

```js
数字是调用 nodeType 返回的数字，代表着每一个节点的类型

元素节点 —— 1
属性节点 —— 2
文本节点 —— 3
注释节点 —— 8
document —— 9
DocumentFragment —— 11

<div>
    123
    <!-- This is comment -->
    <strong></strong>
    <span></span>
    <em></em>
    <i></i>
    <b></b>
</div>

// 控制台输出：
// >  div.childNodes[0].nodeType
// <· 3(文本节点)
// >  div.childNodes[3].nodeType
// <· 1(元素节点)
```

```js
把 div 下面所有的直接子元素节点挑出来，放在数组里面返回，不能用 children

<div>
    123
    <!-- This is comment -->
    <strong></strong>
    <span></span>
    <em></em>
    <i></i>
    <b></b>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];

    function retElementChild(node){
        // no children
        var temp = {
            length : 0,
            push : Array.prototype.push,
            splice : Array.prototype.splice
            },
            child = node.childNodes,
            len = child.length;
        for(var i = 0; i < len;i ++){
            if(child[i].node.length === 1){
                temp.push(child[i]);
            }
        }
        return temp;
    }
    console.log(retElementChild(div));
</script>
// [strong，span，em，i，b]
```

### attributes -- 属性节点

`Element 节点的属性集合`

```js
<div id="only" class="demo"></div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从控制台输出：
// >  div.attributes
// <· NamedNodeMap{0: id,1: class,length: 2}
// >  div.attributes[0]
// <· id='only'
// >  div.attributes[0].nodeType
// <· 2
// >  div.attributes[0].value
// <· 'only'
// >  div.attributes[0].name
// <· 'id'
// >  div.attributes[0].value = 'abc'
// <· 'abc'
// >  div
// <· <div id='abc' class='demo'></div>
```

属性名不能改，属性值可以，但是我们一般不会用这种方法

我们一般用 getAttribute 和 setAttribute 去取

### hasChildNodes -- 判断有没有子节点

`节点的一个方法 Node.hasChildNodes(); -- 他有没有子节点，返回值是 true 或 false`

```js
<div id="only" class="demo">
    <span></span>
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从console输出：
// div.hasChildNodes()
// true
```

```js
<div id="only" class="demo">
    <!-- this is comment -->
</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从console输出：
// div.hasChildNodes()
// true
```

```js
<div id="only" class="demo">

</div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从console输出：
// div.hasChildNodes()
// true
```

```js
当这种情况下是 false （没有空格，没有回车）

<div id="only" class="demo"></div>
<script>
    var div = document.getElementsByTagName('div')[0];
</script>

// 从console输出：
// div.hasChildNodes()
// false
```

```js
属性的节点是 div 上面的，不是 div 里面的

<div>
    <p></p>
    </span></span>
    <!-- thsi is comment -->
</div>
```

# DOM接口/结构树

`dom 结构树代表的是一系列继承关系`

![DOM结构树](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111120958101.png)

```js
`Document 和 document的关系`

>  Document
<· function Document(){[native code]}

>  Document.prototype.abc = 'abc';
<· 'abc'

>  document.abc
<· 'abc'
```

`document --> HTMLDocument.prototype --> Document.prototype`

document 继承自 HTMLDocument.prototype

HTMLDocument.prototype 继承自 Document.prototype

```js
圆形是不是一个对象？

HTMLDocument.prototype = {
    __proto__ : Document.prototype
}

例：
    document --> HTMLDocument.prototype --> Document.prototype

// console输出：
    // >  HTMLDocument.prototype.bcd = '123'
    // <· '123'
    // >  document
    // <· #document
    // >  document..bcd
    // <· '123'

    // >  Document.prototype.bcd = '123'
    // <· '123'
    // >  HTMLDocument.prototype.bcd = '234'
    // <· '234'
    // >  document.bcd
    // <· '234'
```

DOM 结构树中，Node也是构造函数，comment 是注释

HTMLDocument 和 HTMLElement 实际上并列了对应的 XML，但是因为不用了 XML 就省略了，HTMLHeadElement 就是 head 标签，其余类推

```js
例：
    HTMLBodyElement.protootype.abc='demo';
    var body = document.getElementsByTagName('body')[0];
    var head = document.getElementsByTagName('head')[0];

// console输出
    // >  body.abc
    // <· 'demo'
    // >  head..bcd
    // <· undefiend

`如果使用 HTMLElement.prototype.abc="demo"; 定义，则body和head都可以使用`
```

```js
看一看一层一层返回的是什么东西

// console输出
    // >  document.__proto__
    // <· HTMLDocument{Symbol{symbol.toStringTag}:'HTMLDocument'}

    // >  document.__proto__.__proto__
    // <· Document{Symbol{Symbol.toStringTag}:'Document',Symbol{symbol.unscopables}:Object}

    // >  document.__proto__.__proto__.__proto__
    // <· Node {ELEMENT_NODE: 1, ATTRIBUTE_NODE: 2, TEXT_NODE: 3, CDATA_SECTION_NODE: 4, ENTITY_REFERENCE_NODE: 5, …}

    // >  document.__proto__.__proto__.__proto__.__proto__
    // <· EventTarget {Symbol(Symbol.toStringTag): "EventTarget", : ƒ, removeEventListener: ƒ, dispatchEvent: ƒ, constructor: ƒ}

    // >  document.__proto__.__proto__.__proto__.__proto__.__proto__
    // <· Object{}

    // >  document.body
    // <· <body>…</body>

    // >  document.body.toString()
    // <· '[object HTMLBodyElement]'
```

**思路：** 绘制`dom`树，符合深度优先（纵向）原则，比如先看`head → title → meta →
body → div → strong → span`

`dom`树是节点解析，`dom`树解析完毕代表`dom`数所有的节点解析完毕，不代表加载
（下载完毕）完毕。如看到`img`标签就放到`dom`树上，然后同时下载。

`dom`树形成完了以后，就等`css`树形成【`cssTree`也是深度优先原则。】。

`domTree + cssTree = randerTree，randerTree`形成以后才，渲染引擎才会绘制页面，
`domTree`改变，`randerTree`也会改变，会重排，影响效率,要尽量避免重排。

`randerTree`触发重排`（reflow）`的情况：`dom`节点的删除，添加，`dom`节点的宽高变
化，位置变化，`display none ==> block，offsetWidth，offsetLeft`

`repaint`重绘：效率也比较低，效率影响较小。触发情况：改颜色，图片

# DOM 基本操作 - 定义方法 ③

## 定义方法

一、`getElementById`方法定义在`Document.prototype`上，即`Element`节点上不能使

二、`getElementsByName`定义在`HTMLDocument.prototype`上，既非`html`中的`document`以外不能使用`（xml document,Element）`

三、`getElementsByTagName`方法定义在`Document.prototype`和`Element.prototype`上

```js
例:选取 div 里面的 span
    <div>
        <span>1</span>
    </div>
    <span></span>
    <script>
        var div = document.getElementsByTagName('dib')[0];
        var span = document.getElementsByTagName('span')[0];
    </script>

    // >  span
    // <· <span>1</span>

`开发中，经常利用先选择的父级，在他父级里面再次选什么元素来定位一个元素`
```

`var div = document.getElementsByTagName('*');  选择所有`

四、`HTMLDocument.prototype`定义了一些常用的属性，`body、head`分别指代`HTML`文档中的`<body>、<head>`标签

```js
例：
    // >  document.body
    // <· <body></body>

    // >  document.head
    // <· <head></head>
```

五、`Document.prototype`定义了`documentElement`属性，指代文档的根元素，在`HTML`文档中，他总是指代`<html>`元素

```js
例：
    // >  document.documentElement
    // <· <html lang='en'>
    //         <head></head>
    //         <body></body>
    //    </html>
```

六、`getElementsByClassName、querySelectorAll、querySelector`在`Document,Element`类中均有定义`div.getElementsByClassName('')`

## 作业练习

### 一、遍历元素节点数，要求不用 children 属性（在原型链上编程）

```js
<div>
    <p></p>
    <span>
        <strong></strong>
        <b></b>
    </span>
</div>

低级方法，给一个父节点，把子节点全部遍历出来，并打印

高级方法：打印树形结构 → 分层打印出来 先看 div 再看子元素节点， 再挨个判断
```

### 二、封装函数，返回元素 e 的第 n 层祖先元素

```js
<body>
    <div>
        <strong>
            <span>
                <i></i>
            </span>
        </strong>
    </div>
</body>
<script>
    function retParent(elem,n){
        while(elem & n){
            elem = elem.parentElement;
            n--;
        }
        return elem;
    }
    var i = document.getElementsByTagName('i')[0];
</script>

// 从console输出
    >  retParent(i,1)
    <· <span></span>

    >  retParent(i,2)
    <· <strong></strong>

```

### 三、封装函数，返回元素 e 的第 n 个兄弟节点，n为证，返回后面的兄弟节点，n 为负，返回前面的，n 为 0，返回自己

```js
<div>
    <span></span>
    <p></p>
    <strong></strong>
    <!-- this is comment -->
    <i></i>
    <address></address>
</div>
<script>
    function retSibling(e,n){
        while(e && n){
            if(n > 0){
            e = e.nextElementSibling;
            n--;
            }else{
            e = e.previousElementSibling;
            n++;
            }
        }
        return e;
        }
    var strong = document.getElmentsByTagName('strong')[0];
</script>

// 从console输出
    // >  retSibling(strong,1)
    // <· <i>​</i>​
    // >  retSibling(strong,2)
    // <· <address>​</address>​
    // >  retSibling(strong,3)
    // <· null
    // >  retSibling(strong,1000)
    // <· null
    // >  retSibling(strong,-1)
    // <· <p>​</p>​
    // >  retSibling(strong,-2)
    // <· <span>​</span>​
    // >  retSibling(strong,-3)
    // <· null
    // >  retSibling(strong,-300)
    // <· null
    // >  retSibling(strong,0)
    // <· <strong>​</strong>​
```

上面的 ie9 不兼容，考虑到兼容性，可以按照下面思路写

```js
function retSibling(e,n){
    while(e && n){
        if(n > 0){
            if(e.nextElementSibling){
                e = e.nextElementSibling;
            } else {
                for(e = e.nextSibling; e && e.nodeType !== 1; e = e.nextSibling);
            }
            n --;
        } else {
            if (e.previousElementSibling) {
                e = e.previousElementSibling;
            } else {
                for (e = e.previousSibling; e && e.nodeType !== 1;e = e.previousSibling);
            }
            n++;
        }
    return e;
    }
}

`如果 for 循环执行体是空的，那么可以不写{}`
```

### 四、编辑函数，封装 children功能，解决以前部分浏览器的兼容问题

```js
<div>
      <b></b>
      abc
      <!-- this is comment -->
      <strong>
        <span>
          <i></i>
        </span>
      </strong>
    </div>

<script>
Element.prototype.myChildren = function(){
    var child = this.childNodes;
    var len = child.length;
    var arr = [];
    for(var i = 0;i < len;i ++){
        if(child[i].nodeType == 1){
            arr.push(child[i]);
        }
    }
    return arr;
}
var div = document.getElementsByName('div')[0];
</script>
```

### 五、自己封装 hasChildren()方法，不可以用children属性

```js
<script>
    var i = document.getElementsByTagName('i')[0];
    var div = document.getElementsByTagName('div')[0];

    Element.prototype.myHasChildNodes = function(){
        var child = this.childNodes;
        var len = child.length;
        for(var i = 0;i < len; i++){
            if(child[i].nodeType == 1){
                return true;
            }
        }
        return flase;
    }
</script>
```

# DOM 基本操作 - 增|插|删|替④

## 增

### document.createElement(); --- 增加或创建元素节点（标签） -- 常用

### document.createTextNode(); --- 创建文本节点

### document.createComment(); --- 创建注释节点

### document.createDocumentFragment(); --- 创建文档碎片节点

## 插 --- 剪切操作

```js
.appendChild()可以理解为.push

insertBefore(a,b)一定是先insert a，before b，就是拿 a 插入到 b 的前面

insertAfter(a,b)就是拿 a 插入到 b 的后面
```

### appendChild()

`.appendChild()`可以理解为`.push`

```js
例：把 span 插入到 div 里面
    <body>
        <div></div>
        <span></span>
    </body>
    <script>
        var div = document.getElementsByTagName('div')[0];
        var span = document.getElementsByTagName('span')[0];
        div.appendChild(span);  // -- 把 span 插入到 div 里面
    </script>
```

```js
把目标节点内部的节点上顺序逆序
    Element.prototype.invertedChild = function(){
        var child = this.children,
            len = child.length;
        for(var i = len - 2;i >= 0;i --){
          this.appendChild(child[i]);
        }
        return this;
    }
    var div = document.getElementsByTagName('div')[0];
    div.invertedChild();
```

### insertBefore(a,b)

`insertBefore(a,b)`一定是先`insert a，before b`，就是拿 a 插入到 b 的前面

```js
例：把 strong 插入到 span 的前面
    <body>
        <div></div>
        <span></span>
    </body>
    <script>
        var div = document.getElementsByTagName('div')[0];
        var span = document.getElementsByTagName('span')[0];
        var strong = document.createElement('strong');
        div.insertBefore(strong,span);  // -- 把 strong 插入到 span 前面
    </script>
```

### insertAfter(a,b)

`insertAfter(a,b)`一定是先`insert a，before b`，就是拿 a 插到 b 的后面

```js
`insertAfter 系统没有定义，所以是自己利用 insertBefore 来写的一个相反的方法`

<body>
    <div>
        <i></i>
        <b></b>
        <span></span>
    </div>
</body>
<script>
    Element.prototype.insertAfter(targetNode,afterNode){
        var beforeNode = afterNode.nextElementSibling;
        if(beforeNode == null){
            this.appendChild(targetNode);
        }else{
            this.insertBefore(targetNode,beforeNode);
        }
    }

    var div = document.getElementsByTagName('div')[0];
    var b = document.getElementsByTagName('b')[0];
    var span = document.getElementsByTagName('span')[0];
    var p = document.createElement('p');
</script>
```

## 删

### removeChild()

就是被剪切出来了

```js
<body>
    <div></div>
    <span></span>
</body>
<script>
    var div = document.getElementsByTagName('div')[0];
    var span = document.getElementsByTagName('span')[0];
    var strong = document.createElement('strong');
    var i = document.create('i');
    div.insertBefore(strong,span);
    div.insertBefore(i,strong);
</script>

// 从console输出：
    // >  div.removeChild(i);
    // <· <i></i>

    // >  var ii = div.removeChild(i);
    // <· undefined
    // >  ii
    // <· <i></i>
```

### remove()

```js
<body>
    <div></div>
    <span></span>
</body>
<script>
    var div = document.getElementsByTagName('div')[0];
    var span = document.getElementsByTagName('span')[0];
    var strong = document.createElement('strong');
    var i = document.create('i');
    div.insertBefore(strong,span);
    div.insertBefore(i,strong);
</script>

// 从console输出：
    // >  i.remove()
    // <· undefined
    // >  strong.remove();
    // <· undefined
    // >  span.remove()
    // <· undefined
```

## 替换

### replaceChild(new,origin)

`replaceChild(new,origin); 用新的 new 去置换旧的 origin`

```js
<body>
    <div></div>
    <span></span>
</body>
<script>
    var div = document.getElementsByTagName('div')[0];
    var span = document.getElementsByTagName('span')[0];
    var strong = document.createElement('strong');
    var i = document.create('i');
    div.insertBefore(strong,span);
    div.insertBefore(i,strong);
    var p = document.createElement('p');
</script>

// 从console输出：
    // >  div
    // <· <div>
    //       <i></i>
    //       <strong></strong>
    //       <span></span>
    //    </div>

    // >  div.replaceChild(p,strong)
    // <· <strong></strong>

    // >  div
    // <· <div>
    //       <i></i>
    //       <p></p>
    //       <span></span>
    //    </div>
```

# DOM 基础操作 - Element节点的方法|属性⑤

## Element 节点的一些属性

### innerHTML \ innerText

`innerHTML`  --> 给 HTML文档赋值  --  可取，可写，可赋值，赋值之后覆盖原来的内容

```js
取：
<div>
    <span>123</span>
    <strong>234</strong>
</div>

// 从console输出：
    // >  div.innerHTML
    // <· "
    //         <span>123</span>
    //         <strong>234</strong>
    //     "

写：
<div>
    <span>123</span>
    <strong>234</strong>
</div>

// 从console输出：
    // >  div.innerHTML = '123'
    // <· '123'
    // >  div
    // <· '123' -- 覆盖
```

`innerText`  --> 给HTML文档添加文本  --  可取，可赋值（老版本火狐不兼容）/ textContent（火狐使用这个，老版本 IE 不好使）

```js
<div>
    <span>234</span>
</div>

// 从console输出：

    // >  div
    // <· <div><span>234</span</div>

    // >  div.innerText = 123
    // <· 123

    // >  div
    // <· <div>123</div>  --  赋值要谨慎，因为赋值会把原来的文本覆盖
```

## Element 节点的一些方法

### setAttribute \ getAttribute

`setAttribute` 设置，往元素里面写值（class，id）等等,比如：

```js
demo.setAttribute('属性名','属性值'); // 我们可以自己添加属性和属性值
```

`getAttribute` 取元素的值

```js
<div>
    <span>234</span>
</div>

// 从console输出
    // >  div.setAttribute('class','demo');  --  添加 类.class
    // <· undefined
    // >  div
    // <· <div class='demo'>…</div>

    // >  div.setAttribute('id','only');  --  添加 id
    // <· undefined
    // >  div
    // <· <div class='demo' id='only'>…</div>

    // >  div.getAttribute('id','only');  --  取 id 值
    // <· undefined
    // >  div.getAttribute('id');
    // <· 'only'
```

```js
通过 div.setAttribute('id','only')动态的去改div的值

<head>
    <style>
        #only{
            font-size: 20px;
            color:fff;
            background-color: orange;
        }
    </style>
</head>

<body>
    <div>
        <span>234</span>
    </div>
</body>

<script>
    var div = document.getElementsByTagName('div')[0];
    div.onclick = function(){
        this.setAttribute('id','only')
    }
</script>
```

### data-log

当满足一定条件时，if就可以动态操作了，配合事件连成整体操作 这个行间属性可以设置系统没有的。`data-log`是打点，点击率，这是人工设置的行间 属性，不是系统定义的

```js
如何去取这个 data-log？
    <div>
        <a href='#' data-log='0'>hehe</a>
    </div>
    <script>
        var div = document.getElementsByTagName('div')[0];
        var a = document.getElementsByTagName('a')[0];
        a.onclick = function(){
            console.log(this.getAttribute('data-log'));
        }
    </script>
```

```js
给三个标签，让他们行间有一个属性 this-name，比如第一个 div，第二个span
    <div></div>
    <span></span>
    <strong></strong>
    <script>
        var all = document.getElementsByTagName('*');
        for(var i = 0;i < all.length; i++){
            all[i]setAttribute('this-item',all[i].nodeName);
        }
    </script>
```

# 日期对象 Date()   ---   就是一种对象，是系统提供好的

`var date = new Date()`大写的`Date`是系统提供的一个构造函数，通过`new Date`的方法会给我们返回一个对象，这个对象就是一个日期对象。日期对象有很多属性和方法。小的`date`代表此时此刻的时间。用小的`date`调用方法，如`date.getDate()`

## Date 对象属性（不够标准）

* 属性           : 描述

* `constructor    : 返回对创建对象的 `Date`函数的引用。原型上的属性

* `prototype      : 使您有能力向对象添加属性和方法。`prototype`是构造函数的属性

## Date 对象方法

* `方法                 ：描述

* `Date()`———：返回当日的日期和时间

* `getDate()`———：制作出对象，从 ``Date`` 对象返回一个月中的某一天`（1 ~ 31）`

* `getDay()`——：今天是一周的第几天，如果是 2 是星期二，但是是指第三天（第一天是周日，也就是 0）。从 ``Date`` 对象返回一周中的某一天（1 ~ 6）

* `getMonth()`——：一月份返回值是 0，从 `Date` 对象返回月份（0 ~ 11）

* `getFullYear()`——：从 `Date` 对象以四位数字返回年份

* `getYear()`——：已废弃。请使用 getFullYear()` 方法代替

* `getHours()`——：返回 `Date` 对象的小时（0 ~ 23）

* `getMinutes()`——：返回 `Date` 对象的分钟（0 ~ 59）

* `getSeconds()`——：返回 `Date` 对象的秒钟（0 ~ 59）

* `getMilliseconds()`——：返回 `Date` 对象的毫秒（0 ~ 999）

* `getTime()`——：返回 1970 年 1 月 1 日（纪元时刻）至今的毫秒数。经常用于项目的计算时间。获取`时间戳`

* `setDate()`——：设置 `Date` 对象中月的某一天（1 ~ 31）

* `setMonth()`——：设置 `Date` 对象中月份（0 ~ 11）

* `setFullYear()`——：设置 `Date` 对象中的年份（四位数字）

* `setYear()`——：已废弃，请使用 setFullYea()方法代替

* `setHours()`——：设置 `Date` 对象中的小时（0 ~ 23）

* `setMinutes()`——：设置 `Date` 对象中的分钟（0 ~ 59）

* `setSeconds()`——：设置 `Date` 对象中的秒钟（0 ~ 59）

* `setMilliseconds()`——：设置 `Date` 对象中的毫秒（0 ~ 999）

* `setTime()`———：以毫秒设置 `Date` 对象。机械之间交换时间

* `toSource()`——：返回该对象的源代码

* `toString()`——：把 `Date` 对象转换为字符串

* `toTimeString()`——：把 `Date` 对象的时间部分转换为字符串

* `to`Date`String()`——：把 `Date` 对象的日期部分转换为字符换

`getUTC` 一类，`parse()` 的没用，不放表格里面，可以在 w3school date 中查看全部

在控制台调用 `date.getSeconds` 就是 `date` 创建时间的毫秒数，是静止的，不是动态的。这个 `date` 对象记录的是出生的那一刻的时间，不是实时的。

```js
例：利用 getTime() 计算程序计算的毫秒数

var firstTime = new Date().getTime();
for(var i = 0;i < 1000000;i ++){}
var lastTime = new Date().getTime();
console.log(lastTime - firstTime);
```

```js
例：setDate()

>  date.setDate(26)
<· 1580021359911
>  date
<· Sun Jan 26 2020 14:49:19 GMT+0800 (中国标准时间)
```

```js
例：循环执行用 setInterval

var date = new Date();
date.setMinutes(54);
setInterval(function(){
    if(new Date.getTime() - date.getTime() > 1000){
        console.log('什么什么什么！！！')
    }
},1000)
```

```js
例：setTime()

>  date.setTime(12345678900)
<· 12345678900
>  date
<· Sun May 24 1970 05:21:18 GMT+0800 (中国标准时间)
```

```js
例：toString() 和 toTimeString() 和 toDateString()

>  date.toString
<· "Sun May 24 1970 05:21:18 GMT+0800 (中国标准时间)"
>  date.toTimeString()
<· "05:21:18 GMT+0800 (中国标准时间)"
>  date.toDateString()
<· "Sun May 24 1970"
```

作业：封装函数，打印当前是何年何月何日何时，几分几秒

## js 定时器

### 一、setInterval() ---- 定时循环器

`注意：setInterval("func()",1000);定时循环器`

```js
例：setInterval(function(){},1000);定时器，意思是 1000 毫秒执行一次这个函数

var time = 1000;
setInterval(function(){
    console.log('a');
},time)
var time = 2000;

`time = 2000 不能改变函数里面的时间，只能执行写在 time 的时间数`

`如果先定义 1000 毫秒，在后面改成 2000 毫秒，程序仍按 1000 毫秒执行，因为他只识别一次，不能通过改变 time 改变 setInterval 的快慢 `
```

```js
例：查数

var i = 0；

setInterval(function(){
    i ++;
    console.log(i);
},1000)
```

```js
例：判断定时器准确不准确？

var firstTime = new Date().getTime();
setInterval(function(){
    var lastTime = new Date().getTime();
    console.log(lastTime - firstTime);
    firstTime = lastTime;
},1000);

`setInterval() 计算时间非常不准确`

注意：`setInterval(); 是 window 的方法，在全局上就算不写 window.setInterval(); 他也会上全局的 GO 里面查找，所以不写 window 也行`

·每一个 setInterval(); 都会返回一个一个数字，作为唯一的标识，有唯一标识就可以把他清除掉（利用 clearInterval() 清除）`
```

```js
例：每一个 setInterval 都有着返回值，timer 是逐一罗列放下排序

var timer = setInterval(function(){},1000);
var timer2 = setInterval(function(){},1000);

// 从 console.log 输出：
// >  timer
// <· 1
// >  timer2
// <· 2
```

### 二、clearInterval() ---- 停止定时循环器（setInterval()）

```js
例：一般写了 setInterval() 就要写 clearInterval()

// clearInterval();
var i = 0;
var timer = setInterval(function(){
    console.log(i ++);
    if(i > 10){
        clearInterval(timer);
    }
},10)
```

### 三、setTimeout() ---- 真正的定时器,隔了一段时间后再执行（起推迟作用），并且 只执行一次

```js
例：隔了 1000 毫秒才执行，并且只执行一次

setTimeout(function(){
    console.log('a');
},1000);

`常应用于电影试看 5 分钟`
```

### 四、clearTimeout() ---- 清除 setTimeout(); 让他停止执行

```js
例：这种写法，setTimeout();还没执行就被清除了，就执行不了了

var timer = setTimeout(function(){
    console.log('a');
},1000)

clearTimeout(timer);
```

```js
例：这个 timer = setTimeout();返回的唯一标识和 setInterval 返回的唯一标识是不会重叠的，他们两个是依次的

var timer = setTimeout(function(){
    console.log('a');
},1000)

var timer2 = setInterval(function(){},1000);

clearTimeout(timer);

// 从 console 输出
>  timer
<· 1
>  timer2
<· 2
```

`setInterval(); setTimeout(); clearInterval(); clearTimeout();`这四个都是全局对象，都是`window`上的方法，内部函数`function`里面的`this`指向 `window`

```js
例：setInterval("function()",1000) 和 setTimeout(); 都有另一种形式展现，里面可以写成字符串，例如"console.log('a');"。但是一般用 function(){}

setInterval(function(){},1000);  ---  标准形式
setInterval("console.log('a');",1000);  ---  特殊形式，一般不这样写，意思是 1000 毫秒执行一次console.log
```

### 计时器作业

`计时器，到三分钟停止`

`定时器要计数，计完数以后要填到结构里面，下面的起的两个变量 minutes 和 seconds 用于计数，计完数以后要填到 dom 结构里面（元素标签最正确的说法是 dom结构， 因为他可以被 dom操作）`

```js
input{
    border: 1px solid black;
    text-align: right;
    font-size: 20px;
    font-weight: bold;
}

minutes:<input type="text" value='0'>
seconds:<input type='text' value='0'>

var minutesNode = document.getElementsTagName = ('input')[0];
var secondsNode = document.getElementsTagName = ('input')[1];

var minutes = 0,
    seconds = 0;

var timer = seInterval(function(){
    var seconds = 0;
    if(seconds == 60){
        minutes ++;
        seconds = 0;
    }
    minutesNode.value = minutes;
    secondsNode.value = seconds;
    if(minutes = 3){
        clearInterval(timer);
    }
},10)
```

# DOM / BOM 基本操作

## 一、查看滚动条的滚动距离

1. **`window.pageXOffset`（横向）/ `pageYOffset`（纵向）**

    IE8及IE8以下不兼容（IE9部分不兼容）IE9以上能用

    ```js
    例：滚动条往下滚动了 400px，求浏览器最顶端到滚动条滚动的位置的像素

    答：400px + 首屏像素（此时这个屏幕的底端距离整个网页的最顶端也是这样算的）
    ```

2. **IE8及IE8以下的使用兼容方法**

    1)`document.body.scrollLeft / scrollTop` ---- document.body.横向 / 纵向

    2)`document.documentElement.scrollLeft / scrollTop` ---- document.documentEle2ment.横向 / 纵向

    `上面两个兼容性比较混乱，其中一个有值，另外一个的值一定是 0，这两个最好的用法是取两个值相加，因为不可能存在两个同时有值`

    `例如：document.body.scrollLeft + document.documentElementscrollLeft`

3. **封装兼容方法（那个浏览器都好用），求滚动轮滚动距离 getScrollOffset()**

    ```js
    function getScrollOffset(){
        if(window.pageXOffset){
            return {
                x : window.pageXOffset,
                y : window.pageYOffset
            }
        }else{
            return {
                x : document.body.scrollLeft + document.documentElement.scrollLeft,
                y : document.bodu.scrollTop + document.documentElement.scrollTop
            }
        }
    }
    ```

## 二、查看视口的尺寸

`可视区窗口就是编写的 html 文档可以看到的部分，不含菜单栏、地址栏、控制台`

注意渲染模式：

```js
1. 渲染模式 : <! DOCTYPE html> 是 html5 的（在 emmet 插件下 html:5 就出来了）

2. 怪异/混杂模式 : 试图去兼容之前的语法，去掉<!DOCTYPE html>这一行即可开启（向后兼容）

例：document.compatMode是判断是怪异模式还是标准模式

    CSS1Compat -- 标准模式

    BackCompat -- 怪异模式向后兼容
```

1. **`window.innerWidth` / `innerHeight` 可视区域的宽高（加上 滚动条的宽度 / 高度）**

    ```js
    IE8 及 IE8 以下不兼容

    如果窗口放大页面了，页面的尺寸也会拉伸了，尺寸就会变小
    ```

2. **`document.documentElement.clientWidth` / `clientHeight`**

   `标准模式下，任意浏览器都兼容`

3. **`document.body.clientWidth` / `clientHeight`**

    `适用于怪异渲染模式的浏览器`

4. **封装兼容性方法，返回浏览器视口尺寸 `getViewportOffset()`**

    ```js
    `例：document.compatMode`是判断是怪异模式还是标准模式
    
    CSS1Compat -- 标准模式
    
    BackCompat -- 怪异模式向后兼容
    ```

    ```js
    function getViewportOffset(){
        if(window.innerWidth){
            return {
                w : window.innerWidth,
                h : window.innerHeight
            }
        }else{
            if(document.compatMode == 'CSS1Compat'){
                return {
                    w : document.documentElement.clienWidth,
                    h : document.documentElement.clienHeight
                }
            }else{
                return {
                    w : document.body.clienWidth,
                    h : document.body.clienHeight
                }
            }
        }
    }
    ```

## 三、查看元素的几何尺寸

1. **domEle.getBoundingClientRect() -- 查看元素的几何尺寸**

   1. `domEle.getBoundingClientRect()` 这是 es5.0 的方法，但只用了解

       ```js
       例：
           >  div.getBoundingClientRect();
           <· ClientRect
               bottom : 200
               height : 100
               left : 100
               right : 200
               top : 100
               widht : 100
               > __proto__ : ClientRect
       ```

       `求的是四个边和窗口之间的像素距离，right 是右边离 document 的边有 200px，也可以理解成求的是左上点和右下点的位置`

   2. 兼容性很好

   3. 该方法返回一个对象，对象里面有`left,top,right,bottom`等属性。`left`和`top`代表该元素左上角的`X`和`Y`坐标，`right`和`bottom`代表元素右下角的`X`和`Y`坐标

   4. `height` 和 `width` 属性老版本`IE`并未实现

   1. 在老版本的IE里面，利用右侧边`right`减左侧面`left`解决

   5. 返回的结果并不是实时的

2. **dom.offsetWidth , dom.offsetHeight -- 查看元素的宽/高**

   1. `dom.offsetWidth` 元素的宽

   2. `dom.offsetHeight` 元素的高

   `求的值是包括 padding 的`

   `dom.offsetWidth`和`domEle.getBoundingClientRect()`出现的值是一样的，求的值是一样的，求的值都是`padding + content`（视觉尺寸），可以被代替。

## 四、查看元素的位置

1. **dom.offsetLeft，dom.offsetTop -- 查看元素的 x , y 轴位置**

   1. `dom.offsetLeft` 元素的 x 轴位置

   2. `dom.offsetTop` 元素的 y 轴位置

   `对于无定位父级的元素，返回的是相对于文档的坐标`

   `对于有定位父级的元素，返回相对于最近的有定位的父级的坐标（无论是 left 还是 margin-left 等都是距离）`

2. **dom.offsetParent -- 返回最近的有定位的父级**

    `返回最近的有定位的父级，如无，返回body，body.offsetParent 返回 null`

    这个方法能求有定位的父级

    ```js
    例：求元素相对于文档的坐标，以`getElementPosition()`命名
    
    思路：先看有没有有定位的父级，如果有，先求他与有定位父级的距离，然后把视角换到他有定位的父级上，这他这个有定位的父级上还有没有有定位的父级，一段一段的加，一直加到最后，是一个循环递归的过程
    
    // 求元素相对于文档的坐标
    function getElementPosition(elem){
        if(!elem || !elem.offsetLeft){
            return null;
        }
        var actualLeft = elem.offsetLeft,
            actualTop = elem.offsetTop,
            current = elem.offsetParent; // 取得元素的 offsetParent
        while(current !== null){
            actualLeft += current.offsetLeft;
            actualTOp += current.offestTop;
            current = current.offsetParent;
        }
        return {
            left : actualLeft,
            top : actualTop
        }
    }
    ```

    ```js
    // 相对于父级的位置坐标
    function getElementPosition(ele){
        if(ele.offsetParent.nodeName = 'BODY'){
            return {
                left : ele.offsetLeft,
                top : ele.offsetTop
            }
        }else{
            return {
                left : ele.offsetLeft + getElementPosition(ele.offsetParent).left,
                top : ele.offsetTop + getElementPosition(ele.offsetParent).top
            }
        }
    }
    ```

## 让滚动条滚动

1. **window 上有三个方法 scroll(),scrollTo(),两个功能一样，scrollBy();累加滚动距离**

    `window.scroll(x,y),scrollTo(x,y)`功能是一样的，里面能填两个参数

    `window.sroll`(x 轴滚动的距离，y 轴滚动的距离)，里面的 xy 可以填负数

    `window.scrollBy(x,y)`是累加滚动距离，填负数就往上滚动

2. **三个方法功能类似，用法都是将 `x,y` 坐标传入。即实现让滚动轮滚动到当前的位置**

3. **区别 : `scrollBy()` 会在之前的数据基础之上做累加**

    eg : `可以利用scrollBy()做快速阅读的功能`

    ```js
    例:
    start = document.getElementsByTagName('div')[0];
    stop = document.getElementsByTagName('div')[1];
    
    var timer = 0;
    var key = true;
    
    start.onclick = function(){
        if(key){
            timer = setInterval(function(){
                window.scrollBy(0,10)
            },100)
            key = false;
        }
    }
    stop.onclick = function(){
        clearsetInterval(timer);
        key = true;
    }
    ```

# 脚本化 CSS

`dom`不能操作`css`,是间接操作`css`,这一部分需要记下

## 一、读写元素 css 属性（间接控制） -- dom.style.prop

**dom.style.prop;**

`只有这个是可读可写的，其他属性都是只能读`

1）**可读写行间样式，没有兼容性问题，碰到`float`这样的关键字属性，前面应该加`css`（行间样式意外没有用）**

**eg:flaot  ————>  cssFloat**,因为`float`属性在`js`里面是`保留字`，所以一般如果想要用`float`的话就用`cssFloat`

2）**复合属性必须拆解（建议），组合单词变成小驼峰写法**

3）**写入的值必须是字符串格式**

4）**dom.style.prop 只能操作 css 行间样式**

5）**dom.style 属性。能拿，能写（通过写间接改变了 css 属性）**

```js
例：
    >  div.style
    <· CSSStyleDeclaration {alignContent: "", alignItems: "",alignSelf: "", alignmentBaseline: "", all: "", …}

    `CSSstyleDeclaration`是`css`样式表声明（类数组，有索引类的属性），把你能够用的所有的`css`都展示出来，里面不填写就是没有值是空串。

    可以用`div.style['width']`拿出属性，也可以用`div.style.width`,效果一样。

    在`js`访问属性的时候没有`-杠`的形式，不能写`background-color`，要写小驼峰。

    不在`html`文件里面写的值也可以利用js调用，如`div.style.borderRadius="50"`
```

## 二、查询计算样式 -- window.getComputedStyle(ele,null)

**window.getComputedStyle(ele,null);**

**可以选取伪元素，并获取:**`window.getComputedStyle(ele,null);括号里面要填两个东西，第一个ele是填的你要获取谁，第二个先填写null（null解决的就是伪元素的问题，它可以填写伪元素，填null只是用于平常元素，在null的地方写入伪元素，就可以选择获取伪元素，用它可以获取伪元素的样式表）`

1）**window.getComputedStyle(ele,null);**  `原生底层方法，展示权重最高的`

2）**计算样式只读，不可以写入**

3）**返回的样式都是经过计算的，并且都是绝对值，没有相对单位，相对值会转换成绝对值显示**

4）**_IE8及IE8以下不兼容_**

5）**dom.style.prop 是取行间样式的值，取一个元素显示样式的值，window.getComputedStyle()更准**

```js
在控制台操作就能有一个 css 样式表（类数组）

>  window.getComputedStyle(div,null)
<· CSSStyleDeclaration {0: "animation-delay", 1: "animation-direction",2: "animation-duration", 3: "animation-fill-mode", 4: "animation-iteration-count", 5: "animation-name", 6: "animation-play-state"……
```

`window.getComputedStyle 不管填不填值都有值，这里的值都是默认的，这回获取的是这个当前元素所展现出的 css 属性的显示值都是页面中展现的最终效果的值`

```js
<head>
    <style>
        div{
            font-size:10em; // 1em = 16px
        }
    </style>
</head>
<body>
    <div style='float:left;height:100px;background-color:red'></div>
    <script>
        var div = document.getElementsByTagName('div')[0];
    </script>
</body>

// 从console输出：
>  window.getComputedStyle(div,null).width
<· 160px; // 10em = 160px

>  window.getComputedStyle(div,null).backgroundColor
<· "rgb(255,0,0))" // red = rgb(255,0,0)
```

`返回的样式都是经过计算的，并且都是绝对值，没有相对单位，相对值会转换成绝对值显示`

## 三、查询样式 -- ele.currentStyle

**ele.currentStyle;**

1）**ele.currentStyle**  `展示权重最高的`

2）**计算样式只读，不可以写入**

3）**返回的计算样式的值不是经过转换的值，是原封不动的值**

4）**_IE独有的属性，只能用于IE_**

```js
例：['width']写成`.width`也可以，推荐写`点 .`

div.currentStyle['width'] == div.currentStyle.width
```

## 总结

### 封装兼容性查询计算css样式方法 getStyle()

```js
function getStyle(elem,prop){
    if(window.getComputedStyle){
        return window.getComputedStyle(elem,null)[prop];// 必须填写中括号
    }else{
        return elem.currentStyle(prop); // 必须填写中括号
    }
}

`function getStyle`(elem,prop){}
// elem 是指获取谁的（dom 元素），prop 是获取的是什么属性
```

### 详细介绍获取伪元素方法，改变伪元素

例：_理解 window.getComputedStyle(ele,null);第二个值是 null_

**获取伪元素的方法**：`window.getComputedStyle(ele,null);`括号里面要填两个东西，第一 个`ele`是填的是你要获取谁，第二个先填写`null`（`null`解决的就是伪元素的问题，用它可以获取伪元素的样式表）

```js
<head>
    <style>
        div::after{
            content:"";
            width:50px;
            height:50px;
            background-color:green;
            display:inline-block;
        }
    </style>
</head>
<body>
    <div style="float:left;height:100px;width:100px;background-color:red"></div>
    <script>
        var div = document.getElementsByTagName('div')[0];
        window.getComputedStyle(div,"after");
    </script>
</body>

window.getComputedStyle(div,“after”);就获取了伪元素的样式表，在控制台操作
>  window.getComputedStyle(div,'after').width
<· '50px'
```

**怎么改变伪元素;**

_改变伪元素并不一定要改变样式，可以改变 class_;

```js
<head>
    <style>
        .green::after{
            content:"";
            width:50px;
            height:50px;
            background-color:green;
            display:inline-block;
        }
        .yellow::after{
            content:"";
            width:50px;
            height:50px;
            background-color:yelllow;
            display:inline-block;
        }
    </style>
</head>
<body>
    <div class="green" style="float:left;height:100px;width:100px;background-color:red"></div>
    <script>
        var div = document.getElementsByTagName('div')[0];
        var count = 0;
        div.onclick = function(){
            count ++;
            if(count % 2 == 1){
                div.className = 'yellow';
            }else{
                div.className = 'green';   // class 是保留字，所以用className
            }
        }
    </script>
</body>

// 如上
`虽然我们通常用style改变css样式，但我们也可以通过改变class改变css样式`

`通过改变 class 来实现改变，改变状态位的操作`

`class 是保留字，所以要避开，用className`
```

### 小练习，让方块运动

**小方块持续运动;**

```js
function getStyle(elem,prop){
    if(window.getComputedStyle){
        return window.getComputedStyle(elem,null)[prop];
    }else{
        return elem.currentStyle[prop];
    }
}

var div = var document.getElementsByTagName('div')[0];
setInterval(function(){
    div.style.left = parseInt(getStyle(div,'left')) + 10 + 'px'
},100)
```

**加速运动,设置到一个时候就停止了;**

```js
function getStyle(elem,prop){
    if(window.getComputedStyle){
        return window.getComputedStyle(elem,null)[prop];
    }else{
        return elem.currentStyle[prop];
    }
}

var div = document.getElementsByTagName('div');

var speed = 3;
var timer = setInterval(function(){
    div.style.left = parentInt(getStyle(div,'left')) + speed + 'px';
    if(parentInt(div.style.left) > 500){
        clearInterval(timer);
    }
},100)
```

# 事件

## 什么是事件

1）document.styleSheets

2）该属性存储了一个 html 文档里面的所有 css 样式表的集合事件（所有事件都是用的小写）

`交互是你对页面动一下，页面给你一个反馈`

1. 何为事件？ -- 就是一个动作，没有效果也是事件

2. 重要吗？ -- 交互体验的核心功能

```js
演示 demo -- 点击事件

<div style="width: 100px;height: 100px;background-color:red"></div>

<script>
    var div = document.getElementsByTagName('div')[0];
    div.onclick = function(){
        console.log('a'); // 点击之后控制台出现 a
    }
</script>
```

## 绑定事件方法

### 一、句柄绑定方式：'on'  + type（事件类型）

**句柄绑定方式：elem.'on' + 事件类型 = function(event){};**

`只可以用function来绑定事件，若绑定匿名函数，则无法解除`

`打个比方：click 点击事件`

`例：div.'on' + click = function(){}  == div.onclick = function(){}`

1. **兼容性很好，但是一个元素只能绑定一个事件处理程序:**

    ```js
    `例：div.onclick = function(){}`

    div.onclick 就叫做可以被点击的事件（绑定事件类型），`function(){}`是反馈，一旦事件被触发，就要执行`function`里面的函数（绑定的是一个事件处理函数）

    div.onclick = function(){
        console.log('a');
    }// b 覆盖了 a，这是赋值的原因
    div.onclick = function(){
        console.log(b);
    }
    ```

2. **基本等同于写在 HTML 行间上，如下:**

    ```js
    1. <div onclick="console.log('a')"></div>
    
    2. div.onclick = function(){
        console.log('a');
    }
    
    1 和 2 的效果是一样的，只是书写方式不一样
    ```

`onclick='console.log("a")' 是句柄的绑定方式，写在行间不用写function(){}`

### 二、常用写法：()

**elem.addEventListener(type,function(){},false);**

`IE9 以下不兼容，可以为一个事件绑定多个处理程序`

`dom.addEventListener('事件类型',处理函数,false);`

```js
例：
<div style="widht:100px;height:100px;background-color:red;"></div>

<script>
    var div = document.getElementsByTagName('div');
    div.addEventListener('click',function(){
        console.log('a');
    },false)
</sript>
```

```js
div.addEventListener('click',test,false);

function(){} 是函数引用，和外面定义一个 function(){} 直接写 test 是一样的

例：
<div style="widht:100px;height:100px;background-color:red"></div>

<script>
    var div = document.getElementsByTagName('div')[0];
    div.addEventListener('click',test,false);
    function test(){
        console.log('a');
    }
</script>
```

**时间有一个事件监听机制:**

```js
例：一个事件绑定了两个处理函数

<div style="widht:100px;height:100px;background:red;"></div>

<script>
    var div = document.getElementsByTagName('div')[0];
    div.addEventListener('click',function(){
        console.log('a');
    },false);
    div.addEventListener('click',function(){
        console.log('b');
    },false)

`console.log 打印出来是两个函数结果，这是两个处理函数，是两个地址，所以可以输出两个结果`
</script>
```

```js
例：下面只执行一个函数，这种写法是一个地址，一个人

<div style="widht:100px;height:100px;background:red;"></div>

<script>
    var div = document.getElementsByTagName('div')[0];
    div.addEventListener('click',test,false);
    div.addEventListener('click',test,false);

    function test(){
        console.log('a');
    }

`elem.addEventListener 不能给同一个函数绑定多次，重复的绑定一个函数就不可以用了,只能输出一个结果`
</script>
```

### 三、IE专用：attachEvent()

div.attachEvent('on' + click' + function(){});

`IE 独有，一个事件可以绑定多个处理程序，同一个函数绑定多次都可以`

`div.attachEvent('on' + 事件类型，处理函数);`

_`div.attachEvent('onclick',function(){})`_

```js
例：
 var div = document.getElementsByTagName('div')[0];
    div.attachEvent('onclick',test,false);
    div.attachEvent('onclick',test,false);

    function test(){
        console.log('a');
    }
```

```js
例：想给三个 li 都绑定这个事件

<ul>
    <li></li>
    <li></li>
    <li></li>
</ul>

<script>
    var liCol = document.getElementsByTagName('div')[0],
        len = li.length;

    (function(i){
        for(var i = 0;i < len; i++){
           liCol[i].addEventListener('click',function(){
                console.log(i);
            },false)
        }
    }(i))
</script>
```

### 事件处理程序的运行环境

1. elem.onclick = function(){}
   1. 程序`this`指向是`dom`元素本身（指向自己）

2. elem.addEventListener(type,fn,false)
   1. 程序`this`指向是`dom`元素本身（指向自己）

3. elem.attachEvent('on' + type,fn)
   1. 程序`this`指向`window`
   2. 可以通过`call`来指向自己

```js
div.attachEvent('onclick',function(){
    handle.call('div');
})
function handle(){
    console.log('a');
}
```

### 封装绑定事件函数

```js
function addEvent(elem, type, handle) {
    if (elem.addEventListener) {
        elem.addEventListener(type, handle, false);
    } else if (elem.attachEvent) {
        elem['on' + type] = function () {
            handle.call(elem);
        }
    } else {
        elem["on" + type] = handle;
    }
}
```

## 解除事件绑定方法

### 一、句柄方式解除绑定：elem.'on' + type（事件类型） = false/null

`elem.'on' + type = false/null;     ==>     就是解除 elem.'on' + type = function(e)){}`

```js
例：用 div.onclick = null; 解除事件

<div style="width:100px;height:100px;background-color:red"></div>

<script>
`直接解除事件，不可以再执行`
    var div = document.getElementsByTagName('div')[0];
    div.onclick = function(){
        console.log('a');
    }
    div.onclick = null;

`只能执行一次的事件的写法`
    var div = document.getElementsByTagName('div')[0];
    div.onclick = function(){
        console.log('a');
        this.onclick = null;
    }
</script>
```

### 二、常用方式解除绑定：elem.removeEventListener(type,fn,false)

**elem.removeEventListener(type,function(){},false);**

`div.removeEventListener('事件类型',处理函数,false);`

```js
例：elem.removeEventListener(type,fn,false);

var div = document.getElementsByTagName('div')[0];
div.addEventListener('click',test,false);
function test(){
    console.log('a');
    this.removeEventListener('click',test,false);
}

`test`如果填别的function(){},就找不到他了，就没有办法清除，所以函数体一般要写在外面
```

### 三、IE专用方式解除：elem.detachEvent('on' + type,fn)

**elem.detachEvent('on' + click' + function(){});**

`elem.detachEvent('on' + 事件类型，处理函数);`

```js
例：div.detachEvent('onclick',test)

var div = document.getElementsByTagName('div')[0];
    div.attachEvent('onclick',test,false);
    div.attachEvent('onclick',test,false);

    function test(){
        console.log('a');
        this.detachEvent('onclick',test,false);
    }
```

### 封装解除绑定函数

```js
function removeEvent(elem, type, handle) {
    if (elem.removeEventListener) {
        elem.removeEventListener(type, handle, false);
    } else {
        elem.detachEvent('on' + type, handle);
    }
}
```

## 事件处理模型 -- 事件冒泡、捕获

事件处理的两个模型：事件冒泡、捕获（不能同时存在）

```js
<head>
    <style>
        .wrapper{
            width:300px;
            height:300px;
            background-color:red;
        }
        .content{
            width:200px;
            height:200px;
            bakground-color:green;
        }
        .box{
            width:100px;
            height:100px;
            background-color:orange;
        }
    </style>
</head>
<body>

<div class="wrapper">
    <div class="content">
        <div class="box"></div>
    </dvi>
</div>
    <script>
        var wrapper = document.getElementsByClassName('wrapper')[0];
        var content = document.getElementsByClassName('content')[0];
        var box = document.getElementsByClassName('box')[0];

        wrapper.addEventListener('click',function(){
            console.log('wrapper');
        },false)
        content.addEventListener('click',function(){
            console.log('content');
        },false)
        box.addEventListener('click',function(){
            console.log('content');
        },false)
    </script>
</body>

// 从控制台输出：
// > box
//   content
//   wrapper
`只是点了黄色区域，但是出现了 box，content，wrapper 三个结果，往下漏了，这就是事件冒泡`
```

### 事件冒泡

**结构上（非视觉上）嵌套关系的元素，会存在事件冒泡的功能，及同一事件，自子元素冒泡向父元素（自底向上）;**

`结构上存在父子关系的元素，如果点击到子元素，会一级一级向父元素传递这个事件（从代码的角度是自底向上一层一层冒泡的）`

```js
例：加了 margin，只点黄色方块，还是出现了 box，content，wrapper。所以与视觉无关

<div class="wrapper">
    <div class="content">
        <div class="box"></div>
    </dvi>
</div>

var wrapper = document.getElementsByClassName('wrapper')[0];
var content = document.getElementsByClassName('content')[0];
var box = document.getElementsByClassName('box')[0];

wrapper.addEventListener('click',function(){
    console.log('wrapper');
},false)
content.addEventListener('click',function(){
    console.log('content');
},false)
box.addEventListener('click',function(){
    console.log('content');
},false)

// 从控制台输出：
// > box
//   content
//   wrapper
`加了 margin，只点黄色区域，还是出现了 box，content，wrapper 三种结果，所以与视觉无关`
```

### 事件捕获

**1）结构上（非视觉上）嵌套关系的元素，会存在事件捕获的功能，及同一事件，自父元素捕获至子元素（事件源元素）（自顶向下）;**

**2）IE 没有捕获事件;**

`一个对象的一个事件类型，只能存在一个事件处理模型（冒泡或捕获）`

`elem.addEventListener(type,fn,true);第三个参数就是事件捕获，把false改为true`

```js
例：把 false改成 true，就变成了事件捕获，只把 false 改成 true 就变成事件捕获了

<div class="wrapper">
    <div class="content">
        <div class="box"></div>
    </dvi>
</div>

var wrapper = document.getElementsByClassName('wrapper')[0];
var content = document.getElementsByClassName('content')[0];
var box = document.getElementsByClassName('box')[0];

wrapper.addEventListener('click',function(){
    console.log('wrapper');
},true)
content.addEventListener('click',function(){
    console.log('content');
},true)
box.addEventListener('click',function(){
    console.log('content');
},true)

// 从控制台输出：
// > wrapper
//   content
//   box
```

`结果和事件冒泡结果反了过来，先红色区域捕获事件并且执行，再绿色区域捕获事件并且实行，最后只执行事件黄色区域。`_捕获是把结构的最外面先抓住_。**最外面先捕获，再一层层向里面捕获，最里面的是按常规执行**

**思考**：同一个对象的同一个事件类型，上面绑定了两个事件处理函数，一个符合冒泡，一个符合捕获，点一个元素后，是先捕获，还是先冒泡？

**3）触发顺序，先捕获，后冒泡;**

`同一个对象的一个事件处理类型，上面绑定了两个事件处理，分别执行事件冒泡和时间执行`

```js
// 沿用上面代码
wrapper.addEventListener('click',function(){
    console.log('wrapper');
},true)
content.addEventListener('click',function(){
    console.log('content');
},true)
box.addEventListener('click',function(){
    console.log('content');
},true)

wrapper.addEventListener('click',function(){
    console.log('wrapper');
},false)
content.addEventListener('click',function(){
    console.log('content');
},false)
box.addEventListener('click',function(){
    console.log('content');
},false)

// 从控制台输出
// wrapper
// content
// box
// boxBubble
// contentBubble
// wrapperBubble

`先捕获，后冒泡`
```

```js
// 改变一下冒泡，捕获的顺序
wrapper.addEventListener('click',function(){
    console.log('wrapper');
},false)
content.addEventListener('click',function(){
    console.log('content');
},false)
box.addEventListener('click',function(){
    console.log('content');
},false)

wrapper.addEventListener('click',function(){
    console.log('wrapper');
},true)
content.addEventListener('click',function(){
    console.log('content');
},true)
box.addEventListener('click',function(){
    console.log('content');
},true)

// 从控制台输出
// wrapper
// content
// boxBubble
// box
// contentBubble
// wrapperBubble
```

`顺序是先捕获红色，在捕获绿色，boxBubble黄色区域执行，box黄色区域执行，冒泡到绿色，冒泡到红色（谁先绑定，谁先执行，boxBubble 先绑定，所以先执行）`

**4）focus，blur，change，submit，reset，select 等事件不冒泡;**

## 取消冒泡和阻止默认事件

```js
例：给 div 绑定一个事件，也给document绑定一个事件（点击div，也冒泡到document）

<div style="width:100px;height:100px;background-color:red;"></div>

document.onclick = function(){
    console.log('你闲的啊！')
}
var div = document.getElementsByTagName('div')[0];
div.onclick = function(){
    this.style.background = 'green';
}
```

`在每一个事件处理函数中【div.onclick = function(){}】,我们可以写一个形参（如e），系统可以传递` **事件对象（记载了数据发生时的状态和信息）** `到这个参数里面去`

### 一、取消冒泡

#### 1）W3C标准：event.stopPropagation()

> event.stopPropagation(); -- 但不支持 ie9  以下版本

```js
例：事件对象上有一个 event.stopPropagation() 取消冒泡事件

<div style="width:100px;height:100px;background-color:red;"></div>

document.onclick = function(){
    console.log('你闲的啊啊');
}
var div = document.getElementsByTagName('div')[0];
div.onclick = function(e){
    e.stopPropagation();
    this.tyle.background='green';
}
```

#### 2）IE专用：event.cancelBubble = true

```js
例：ie 里面事件对象上有一个 event.cancelBubble = true;能取消冒泡事件

<div style="width:100px;height:100px;background-color:red;"></div>

document.onclick = function(){
    console.log('你闲的啊啊');
}
var div = document.getElementsByTagName('div')[0];
div.onclick = function(e){
    e || window.event; // 解决 ie 兼容问题
    e.cancelBubble = true;
    this.style.background='green';
}
```

#### 封装取消冒泡函数 stopBubble(event)

```js
function stopBubble(event){
    event || window.event;
    if(event.stopPropagation){
        event.stopPropagation();
    }else{
        event.cancelBubble = true;
    }
}
```

### 二、阻止默认事件

#### 什么是默认事件 -- 表单提交，a 标签跳转，右键菜单等

```js
例：浏览器点击右键出菜单，是一个事件（默认事件）

document.oncontextmenu = function(){
    console.log('a'); // 在网页中鼠标右键控制台打印 'a'
}
```

#### 1）句柄阻止默认事件方式：return false

_`兼容性非常好，以对象属性的方式注册的事件才生效（这是句柄的方式阻止默认事件，只有句柄的方式绑定事件才好使）;`_

> return false 是只有句柄绑定方式才可以用的阻止默认事件方式

```js
例：
document.oncontextmenu = function(){
    console.log('a');
    return false; // 在网页右键点击的时候不会出现菜单了，但还在控制台打印 'a'
}
```

#### 2）W3C标准：event.preventDefault()

> event.preventDefault();  W3C标注，IE9以下不兼容

```js
例：

document.oncontextmenu = function(e){
    console.log('a');
    e.preventDefault();
}
```

#### 3）兼容IE：event.returnValue = false

> event.returnValue = false  ---  兼容IE

```js
document.oncontextmenu = function(e){
    e = e || window.event; // 兼容IE
    console.log('a');
    e.returnValue = false;
}
```

#### 封装阻止默认事件的函数 cancelHandler(event)

```js
function cancelHandler(event){
    if(event && event.preventDefault){
        event.preventDefault();
    }else{
        widnow.event.returnValue = false;
    }
}
```

```js
例：a 标签有一个跳转的默认事件

a.onclick = function(){
    return false; // 句柄阻止方式
}

a.addEventListener(e){
    e.preventDefault();  // w3c 标准阻止方式
}

a.addEventListener(e){
    window.e.returnValue = false; // IE阻止方式
}

<a href='javascript:void(false)'></a> // 直接在 a 标签加入也可以
```

## 事件对象

`非 ie 浏览器会把事件对象（记载了数据发生时的状态和信息）打包传到参数里面去`

`ie 浏览器在 window.evnet 里面储存事件对象`

```js
例：

<div style="widht:100px;height:100px;background-color:red"></div>

var div = document.getElementsByTagName('div')[0];
div.onclick = function(e){
    console.log(e); // 非 ie 浏览器会记录事件对象
}
```

### 一、event || window.event 用于IE兼容

**`window.event 用于IE，event 只能用于非 ie 浏览器`**

```js
例：这是储存事件对象的兼容性写法

var div = document.getElementsByTagName('div')[0];
div.onclick = function(e){
    var event = e || window.event;
    console.log(event);
}

// 从控制台输出：
// MouseEvent {isTrusted: true, screenX: 966, screenY: 174, clientX: 86, clientY: 36, …}

// clientX : 76
// clientY : 77
// 鼠标坐标点，可以用这个来记录鼠标坐标点
```

> 事件对象上有个专门的信息是存储事件源的。就是 srcElement 属性，可以查看事件源

```js
例：

<div class="wrapper" style="width:100px;height:100px;background-color:red;">
    <div class="box" style="width:50px;height:50px;background-color:green;"></div>
</div>

var wrapper = document.getElementsByClassName('wrapper')[0];
var box = document.getElementsByClassName('box')[0];

wrapper.onclick = function(e){
    var event = e || window.event;
    console.log(event);
}
```

`点红色会执行，点绿色会冒泡执行。点红色是点击到他自己来执行;点绿色身上，触发事件的点在绿色身上，是绿色传递的，我们把` **触发事件的地方叫做事件源。**

### 事件源对象（找事件源对象的方法）

**event.target**  --  _火狐独有的;_

**event.srcElement**  --  _IE独有的;_

**这俩 chrome 都有;**

```js
例：时间源对象的兼容性写法

<div class="wrapper" style="width:100px;height:100px;background-color:red;">
    <div class="box" style="width:50px;height:50px;background-color:green;"></div>
</div>

var wrapper = document.getElementsByClassName('wrapper')[0];
var box = document.getElementsByClassName('box')[0];

wrapper.onclick = function(e){
    var event = e || window.event;
    var target = event.target || event.srcElement;
    console.log(target);
}
```

## 事件委托

```js
例：我们给每个 li 绑定事件，要求点那个 li 就输出那个内容，这不涉及闭包问题

<ul>
    <li>1</li>
    <li>2</li>
    <li>3</li>
    <li>4</li>
    <li>5</li>
    <li>6</li>
    <li>7</li>
    <li>8</li>
    <li>9</li>
    <li>10</li>
</ul>

var li = document.getElementsByTagName('li');
var len = li.length;
for(var i = 0;i < len;i ++){
    li[i].onclick = function(){
        console.log(this.innerText);
    }
}

// 上面的写法不是很好（如果是三千亿个li就没有效率了）不能动态，要用事件源和事件冒泡解决
```

**事件委托：利用事件冒泡，和事件源对象进行处理;**

**优点：**

1. _`性能 不需要循环所有的子元素一个一个绑定事件`_

2. _`灵活 当有新的子元素不需要重新绑定事件`_

```js
例：给每个 li 绑定事件，再增加 li 也能使用
<ul>
    <li>1</li>
    <li>2</li>
    <li>3</li>
    <li>4</li>
    <li>5</li>
    <li>6</li>
    <li>7</li>
    <li>8</li>
    <li>9</li>
    <li>10</li>
</ul>

var ul = document.getElementsByTagName('ul')[0];
ul.onclick = function(e){
    var event = e || window.event;
    var target = event.target || event.srcElement;
    console.log(target.innerText);
}
```

**面试问题：**

_**什么是事件捕获，一个是冒泡，一个是捕获，第二种捕获不是事件处理模型，而是一种真实的事件获取的过程，用于解决拖拽出方块的问题**_

_`第二种捕获仅在 IE 好使，利用 div.setCapture(); 会捕获页面上发生的所有事情，都获取到自己身上。对应的用 div.releaseCapture();释放。但是方法比较老旧，一般不用。`_

## 事件分类

### 鼠标事件

> 不需要小驼峰和大驼峰

**W3C 标准规定：click 事件只能监听左键，只能通过 mousedown 和 mouseup 来判断鼠标键;**

**如何解决 mousedown 和 click 的冲突;**

**移动端 onmousedown 不能用，只能用 touchstart，touchmove，touchend;**

```js
onclick       | 鼠标点击事件

onmousedown   | 鼠标按键被按下时执行函数

onmouseup     | 鼠标按键被松开时执行函数

onmousemove   | 鼠标移动到指定元素上移动时执行函数

contextmenu   | 右键取消菜单事件

onmouseover   | 鼠标指针移动到元素上执行函数 -- 支持冒泡

onmouseout    | 鼠标在移出指针时执行函数 -- 支持冒泡

onmouseenter  | 鼠标指针移动到元素上执行函数 - 不支持冒泡 - html5

onmouseleave  | 鼠标在移出指针时执行函数 - 不支持冒泡 - html5

ondblclick    | 当用户双击某个对象时触发
```

**click = mousedown + mousemove;**

```js
例：click = mousedown + mousemove

document.onclick = function(){
    console.log('click');
}
document.onmousedown = function(){
    console.log('mousedown');
}
document.onmouseup = function(){
    console.log('mouseup');
}
// mousedown
// mouseup
// click

`触发顺序是：mousedown、mouseup、click`
```

**用 button 来区分鼠标的按键;**

只有 `mouseup、mousedown`两个事件可以区分鼠标左右键

_`button返回值：右键：2，左键：0，滚轮：1`_

```js
document.onmousedown = function (e) {
    if (e.button == 2) {
        console.log('2,right');
    } else if (e.button == 0) {
        console.log('0,left');
    } else if (e.button == 1){
        console.log('1,middle');
    }
}
```

### 键盘事件

> 触发顺序是 keydown > keypress > keyup

```js
onkeydown    | 事件会在用户按下一个键盘按键时发生

onkeyup      | 事件会在键盘按键被松开时发生

onkeypress   | 事件会在键盘按键被按下并释放一个键时发生
```

**1）keydown 和 keypress 的区别:**

**i ：keydown 可以响应任意键盘按键，keypress 只可以响应字符类键盘按键;**

检测字符不准确，`keypress` 检测字符很准确。但是 `keydown` 能监控所有，包括上下左右都能监控，但是 `keypress` 只能监控字符。

`用法：如果你想监控字符类按键，并想区分大小写，就用 keypress，如果是操作类按键的话，就用 keydown 上的 which 属性来区分按键（which：39 是给按键牌号 39，不是 ascii 码）`

**ii ：keypress 返回的 ASCII 码，可以转换为相应字符;**

```js
例：连续按键盘的时候就是连续触发 keydown 和 keypress，松开触发 keyup

document.onkeypress = function(){
    console.log('keypress');
}
document.onkeydown = function(){
    console.log('keydown');
}
document.onkeyup = function(){
    console.log('keyup');
}

// keydown
// keypress
// keyup

注意：游戏触发设置在 keydown 上，机械键盘抬起速度快反馈力量大，对游戏没用
```

**charCode：获取按下的键盘按键 Unicode 编码值;**

**静态 String.fromCharCode() 方法返回由指定的 Unicode 编码转换为输入的键;**

```js
例：利用下面，把 Unicode 编码转成对应值

document.onkeypress = function(e){
    console.log(String.fromCharCode(e.charCode));
}
```

### 表单事件

```js
oninput    | 在用户输入时触发（有变化（增删改）都会触发 input 事件）

onchange   | 事件会在输入的内容改变时触发（点击别的物体时触发）

onfocus    | 事件在对象获得焦点时发生

onblur     | 事件会在对象失去焦点时发生

onreset    | 表单重置时触发

onsearch   | 用户向搜索域输入文本时触发 (<input="search">)

onselect   | 用户选取文本时触发 (<input> 和 <textarea>)

onsubmit   | 表单提交时触发

onfocusin  | 元素即将获取焦点时触发

onfocusout | 元素即将失去焦点时触发
```

**input:**

```js
例如：input 框里面所以有变化（增删改）都会触发 input 事件

<input type="text/css">

var input = document.getElementsByTagName('div')[0];
input.oninput = function(e){
    console.log(this.value);
}
```

**change:**

```js
例：change 对比鼠标聚焦，或失去焦点时，两个状态是否发生改变，如果两个状态没有改变就不触发，如果发生改变就触发

<input type="text/css">

var input = document.getElementsByTagName('input')[0];
input.onchange = function(e){
    console.log(this.value);
}
```

**focus，blur:**

```js
<input type="text/css" value="请输入用户名" style="color:#999" onfocus="if(this.value == '请输入用户名'){this.value = '';this.style.color='#424242'}" onblur="if(this.value == ''){this.value = '请输入用户名';this.style.color='#999'}">
```

### 鼠标键盘事件对象属性

```js
altKey          | 返回当事件被触发时，"ALT" 是否被按下。

button          | 返回当事件被触发时，哪个鼠标按钮被点击。

clientX         | 返回当事件被触发时，鼠标指针的水平坐标。

clientY         | 返回当事件被触发时，鼠标指针的垂直坐标。

ctrlKey         | 返回当事件被触发时，"CTRL" 键是否被按下。

Location        | 返回按键在设备上的位置

charCode        | 返回onkeypress事件触发键值的字母代码。

key             | 在按下按键时返回按键的标识符。

keyCode         | 返回onkeypress事件触发的键的值的字符代码，或者 onkeydown 或 onkeyup 事件的键的代码。

which           | 返回onkeypress事件触发的键的值的字符代码，或者 onkeydown 或 onkeyup 事件的键的代码。

metaKey         | 返回当事件被触发时，"meta" 键是否被按下。

relatedTarget   | 返回与事件的目标节点相关的节点。

screenX         | 返回当某个事件被触发时，鼠标指针的水平坐标。

screenY         | 返回当某个事件被触发时，鼠标指针的垂直坐标。

shiftKey        | 返回当事件被触发时，"SHIFT" 键是否被按下。
```

### 窗体操作类（window 上的事件）onscroll，onload

```js
onload    |  事件会在页面或图像加载完成后立即发生（所有页面加载完毕，才能执行）

onscroll  |  事件在元素滚动条在滚动时触发
```

**onscroll:**

```js
例：scroll 当滚动条一滚动，scroll 事件就触发了

window.onscroll = function(){
    console.log(window.pageXOffset + " " + window.pageYOffset);
}
```

`ie6`没有fixed定位，就用`position`的`top = 原来的 top + 滚动条的位置`来写。`absolute`定位相对于文档定位，就用`absolute`定位模拟`fixed`定位，挪动距离加载`absolute`的`top`上读到`js`的时候就阻断页面，所以必须把`js`写在下面才能把上面的东西读出来

**onload:**

```js
例：load重要但是不用。window.onload 发生在什么时候

window.onload = function(){
    var div = document.getElementsByTagName('div')[0];
    console.log(div);
    div.style.width = '100px';
    div.style.height = '100px';
    div.style.backgroundColor = 'red';
}
```

利用了 onload 就能操作写在下面的 div 了，但是我们不能这样用

> 理由：html 和 css 是一起解析的，在解析的时候会有 html 有 domTree，css 有 cssTree 生成（树形图的顶底是 document，然后是html，然后是 head，body） ，两个树拼在 一起是 renderTree

`什么时候把节点放在树里？dom节点解析，如确定是 img 标签就把他放到树里。（先 解析完 img，同时开启一个线程异步的去下载里面的内容，后下载完）`

`我们把 js 的 script 标签写在最下面的好处是，这些刚刚解析完 js 就能操作页面了， 就更快了。而 window.onload 要等整个页面解析完，下载完才能操作 js，才能触发事 件（效率很差） onload 能提醒我们什么时候整个页面解析完毕。在设计广告时，就 要用 onload，等整个页面下载完了才开始用，但是onload 绝对用于主程序里面`

## 练习总结

### 一、封装拖拽元素函数（不兼容）

```js
function drag(elem) {
    elem.addEventListener('mousedown', function (e) {
        var e = e || window.event;
        var diX = e.clientX - elem.offsetLeft;
        var diY = e.clientY - elem.offsetTop;
        elem.addEventListener('mousemove', mouseMove, false);
        elem.addEventListener('mouseup', mouseUp, false);
    },false);
    function mouseMove(e) {
        var e = e || widow.event;
        var left = e.clientX - diX;
        var top = e.clientY - diY;
        if (left < 0) {
            left = 0;
        } else if (left > window.innerWidth - elem.offsetWidth) {
            left = window.innerWidth - elem.offsetWidth;
        }
        if (top < 0) {
            top = 0;
        } else if (top > window.innerHeight - elem.offsetHeight) {
            top = window.innerHeight - elem.offsetHeight;
        }
        elem.style.left = left + 'px'
        elem.style.top = top + 'px'
    }
    function mouseUp(e) {
        var e = e || window.event;
        elem.removeEventListener('click', mouseMove, false);
        elem.removeEventListener('click', mouseUp, false);
    }
}
```

### 二、输入框功能完善

```js
<input type="text" value="请输入用户名" style="color:#999"
onfocus="if(this.value == '请输入用户名'){this.value = '';this.style.color = '#424242'}"
onblur="if(this.value == ''){this.value = '请输入用户名';this.style.color = '#999'}">
```

### 三、提取密码框的密码

```js
var input = document.getElementsByTagName('input')[0];
input.onkeypress = function(e){
    var e = e || window.event;
    var test = String.fromCharCode(e.charCode);
    console.log(test);
}
```

### 四、轮播图

### 五、贪吃蛇游戏

### 六、扫雷游戏

# JSON和异步加载js

## JSON

**JSON是一种传输数据的格式（以对象为样板，本质上就是对象，但用途有区别，对象就是本地用的，json是用来传输的）**

1. `JSON.parse();    JSON ————> String`

2. `JSON.stringify();   String ————> JSON`

```js
例如：json的属性名必须加双引号（传的是二进制文本）

`json 格式`

{
    "name" : "deng",
    "age" : 123
}
```

```js
var obj = {
    "name" : "abc",
    "age" : 123
}

// JSON.string(obj)
// "{"name":"abc","age":"123"}"
```

```js
var obj = {
    "name" : "abc",
    "age" : 123
}

var str = JSON.stringify(obj);

// str
// "{"name":"abc","age":"123"}"

// JSON.parse(str)
// Object {name: "abc", age: 123}
```

## 异步加载Js

> js是单线程的，会阻断 HTML，css 加载（因为js会修改 html 和 css 一起加载会乱），所以是同步加载 js。先下载 js，在下载 HTML 和 css。**常规来说 js 是同步加载的，所以我们讲讲 js 异步加载的情况;**

**js加载的缺点：加载工具方法没必要阻塞文档，过的 js 加载会影响页面效率，一旦网速不好，那么整个网站将等待 js 加载而不进行后续渲染等工作;**

**有些工具方法需要按需加载，用到再加载，不用不加载;**

javascript 异步加载的三种方案

### 一、IE专用 defer

`defer`**异步加载，但要等到 dom 文档全部解析完成（dom 树生成完）才会被执行。只有 IE 能用**

```js
<script type="text/javascript" scr="xxx" defer="defer"></script>

<script type="text/javascript" scr="xxx" defer="defer">
    console.log('a');
</script>

`两种方法,可以在内部用，也可以再外部用`
```

### 二、w3c标准 async

`async` **异步加载，加载完就执行，async 只能加载外部脚本，不能把 js 写在 script 标签里，ie9 以上可以用，w3c 标准**

```js
<script type="text/javascript" scr="xxx" async="async"></script>

`只有一种方法,只能加载外部脚本`
```

### 三、创建 script

创建`script`，插入到 DOM 中，加载完毕后`callBack`（按需加载，方便） -->  常用

```js
例：
var script = document.createElement('script');
script.type = 'text/javascript';
script.src = 'tools.js';
document.head.appendChild(script); // 如果不写这一段，就是只加载，不执行，像这样写了执行以后才执行
setTimeout(function(){
    test(); // 这个test函数是 tools.js 里面的函数，执行的是tools.js的函数
},1000)
```

> 为什么要用 setTimeout（定时器）呢？因为还没有下载完成，因为程序执行时非常快的，当程序读到 document.head 读到 test(); 时，上面的 script.type 和 script.src 还没有下载完，所以执行不了。所以，能不能有一个东西提示我们，他下载完了我们再用?

#### 方法一

`用 onload 方法`

非 `ie` 方法，`script.onload = function(){}`,触发 `script.onload` 事件就代表他下载完了，当他们下载完了再执行 `test`.

```js
var script = document.createElement('script');
script.type = 'text/javascript';
script.src = 'tools.js';
script.onload = function() {
    test(); // test 函数是 tools.js 的函数，执行的也是 tools.js 的函数
}
document.head.appendChild(script);
```

#### 方法二

`ie 上有一个状态码，script.readyState，功能与 script.onlaod 相似。`

**script.readyState = 'loading'; 最开始的值;**

**script.readyState = 'complete' 或 'loaded' 表示加载完成;**

```js
我们封装一个函数：

function loadScript(url,callback){
    var script = document.createElement('script');
    script.type = 'text/javascript';
    if(script.readyState){
        script.onreadystatechenge = function () {
            if(script.readyState == 'complete' || script.readyState == 'loaded'){
                callback();
            }
        }
    }else{
        script.onload = function () {
            callback();
        }
    }
    script.src = url;
    document.head.appendChild(script);
}
```

> 时间里面有一个绑定的事件处理函数，当满足一定执行条件才执行的函数叫做回调函数，回调函数叫 callback

```js
function loadScript(url,callback){…}

loadScript('tools.js',test); // test 是 tools.js 里面的函数，调用的是 tools.js 的函数
// 从控制台输出：报错

执行顺序：先 function loadScript(){}【不会看里面的代码是什么】
再 loadScript() 【这一步的时候不知道 test 是什么】
然后执行`function`里面的内容，为了解决上面的问题，如下例：

function loadScript(url,callback){…}

loadScript('tools.js',function () {
    test();
});

这样，用一个`function`来做第二个参数，而`function`里面则执行函数，这样也没有问题
```

# js时间线

`js加载时间线：依据 js 出生的那一刻起，记录了一系列浏览器按照顺序做的事情（就是一个执行顺序）`

**时间线步骤（创建 document 对象 ==> 文档解析完 ==> 文档解析完加载完执行完）:**

1. 创建`Document`对象，开始解析`web`页面。解析`HTML`元素和他们的文本内容后添加`Element`对象和`Text`节点到文档中。这个阶段`document.readyState = 'loading'`。

2. 遇到`link`外部`css`创建线程，进行异步加载，并继续解析文档。

3. 遇到`script`外部`js`,并且没有设置`async`、`defer`,浏览器同步加载，并阻塞，等待 js 加载完成并执行该脚本，然后继续解析文档。

4. 遇到`script`外部 `js`，并且设置有`async、defer`，浏览器创建线程异步加载，并继续解析文档。对于`async`属性的脚本，脚本加载完成后立即执行。（异步禁止使用 document.write()`，`因为当你整个文档解析到差不多，再调用`document.write()`会把之前所有的文档流都清空，用里面的文档代替）

5. 遇到`img`等（带有`src`），先正常解析 dom 结构，然后浏览器异步加载`src`，并继续解析文档。看到标签直接生产`dom`树，不用等着`img`加载完`src`。

6. 当文档解析完成（`domTree`建立完毕，不是加载完毕），`document.readyState = 'interactive'`。

7. 文档解析完成后，所有设置有 defer 的脚本会按照顺序执行。（注意与`async`的不同，但同样禁止使用`document.write()`）;

8. `document`对象触发`DOMContentLoaded`事件，这也标志着程序执行从同步脚本执行阶段，转化为事件驱动阶段。

9. 当所有`async`的脚本加载完成并执行后、`img`等加载完成后（页面所有的都执行加载完之后），`document.readyState = 'complete'，'window'`对象触发`load` 事件。

10. 从此，以异步响应方式处理用户输入、网络事件等。

```js
例：异步加载禁止使用 document.write()

<div style="width:100px;height:100px;bakground-color:red"></div>
// 用window.onload 会等整个页面执行加载完才执行，消除文档流（把自己都给删了）
<script>
    window.onload = function () {
        document.write('a');
    }
</script>
```

```js
例：执行到 document.readyState 时，整个 dom 树还没有解析完成，所以不会是 interactive

<div style="width:100px;height:100px;bakground-color:red"></div>

<script>
    console.log(document.readyState);
</script>
<script>
    console.log(document.readyState);
</script>

// 从控制台输出：
// > loading
// > loading
```

```js
例：我们就利用 window.onload 事件，看到的是 complete,代表执行加载完

<div style="width:100px;height:100px;bakground-color:red"></div>
// 用window.onload 会等整个页面执行加载完才执行，消除文档流（把自己都给删了）
<script>
    console.log(document.readyState);
    window.onload = function () {
        console.log(document.readyState);
    }
</script>

// 从控制台输出：
// > loading
// > complete
```

```js
例：如果想要看到 interactive，就用 onreadystatechenge 事件。

<div style="width:100px;height:100px;bakground-color:red"></div>

<script>
    console.log(document.readyState);
    document.onreadystatechenge = function () { // 所有事件都是用小写
        console.log(document.readayState);
    }
</script>

// 从控制台输出：
// > loading
// > interactive
// > complete
```

```js
例：DOMContentloadend 事件只能用在 addEventListener 事件绑定上面

<div style="width:100px;height:100px;bakground-color:red"></div>

<script>
    console.log(document.readyState);

    document.onreadystatechange = function () {
        console.log(document.readyState);
    }
    document.addEventListener('DOMContentloaded',function(){
        console.log('a');
    },false);
</script>

// 从控制台输出：
// > loading
// > interactive
// > a
// > complete
```

```js
通用写法是把 JS 的 script 写在最下面，为什么我们要把他写在最下面？

写在最下面意味着上面的 dom 已经处理完毕了。window.onload 是整个页面加载完才执行，慢等 dom 解析完毕等执行完就执行，比较快。如下

window.onload // : 区别：慢，只要有一个图片没有加载完，window.onload 就不能用，所以效率非常低下

script 标签写在上面。既能操作 div，又能 dom 解析完就处理，效率很高。但是最好还是写在最下面
<script type='text/javascript'>
    document.addEventListener('DOMContentLoad',function () {
        var div = document.getElementsByTagName('div')[0];
        console.log(div);
    },false);
```

# RegExp 正则表达式

**正则表达式的作用**：匹配特殊字符或有特殊搭配原则的字符的最佳选择

`RegExp`对象表示正则表达式，它是对字符串执行模式匹配的强大工具（判断字符串满不满要求）。正则表达式其他语言也有，规则是一样的，在这个基础上，`js`增加了自己独特的方法

## 创建正则表达式的方法

### 第一种方法：正则表达式字面量 //

**正则表达式字面量：**`var 变量 = /表达式/;`

```js
例:
var reg = /abc/;
var str = 'abcd';
console.log(reg.test(str));
// > true
```

```js
例：意思是正则表达式测验一下字符串含不含有我规定的片段
var reg = /abc/; // 我规定的片段
var str = 'abcd'; // 声明一个变量
console.log(reg.test(str));
// 我测验一下 str 里面有没有我规定片段的片段，如果有返回 true，如果没有 false
// > true

var reg = /abce/;
var str = 'abcd';
console.log(reg.test(str));
// > false,顺序不对或者没有挨着，都是不算的
```

```js
例：像下面这种，虽然都有 abce，但是没挨着，或者排序不对，都不算
var reg = /abce/;
var str = 'abcde';
console.log(reg.test(str));
// false, 顺序不对

var reg = /ab/;
var str = 'abababab';
console.log(str.match(reg));
// ['ab'], match 是 str 的方法，可以查看 str 匹配 reg 的内容
```

### 第二种方法：new RegExp()

**new RegExp方法：**`var reg = new RegExp('pattern')`

```js
例：括号里面写的规则
var str = 'abcd';
var reg = new RegExp('abc');
console.log(reg.test(str));
// > true
```

```js
下面是给正则表达式增加属性的方法
var str = 'abcd';
var reg = new RegExp('abc','m');
```

## 正则表达式 3种 属性（修饰符）

* `i` 忽视大小写的意思

* `g` 全局匹配

* `m` 执行多行匹配

**`i`** _是 ignoreCase的缩写，是_**忽视大小写的意思**，例如:`var reg = /abce/i;`

```js
例：
var reg = /abce/i;
var str = 'ABCEd';
console.log(reg.test(str));
// true
```

**`g`** **是全局匹配的意思，**_选择全部的东西，例如：_`var reg = /abce/g;`

```js
例：
var reg = /ab/;
var str = 'ababababab';
console.log(str.match(reg));
// ['ab']

例：
var reg = /ab/g;
var str = 'ababababab';
console.log(str.match(str));
// ['ab','ab','ab','ab','ab']
```

**`m` 是执行多行匹配**_，例如：_`var reg = /abce/m;`

```js
例：^a 的意思是必须是 a 开头的
var reg = /^a/gm; // g是全局匹配，选择全部的东西
var str = 'abcde\na'; // \n 是换行的意思，转义字符,就是实际上已经是两行了
console.log(str.match(reg));
// ['a','a'];
```

## 正则表达式的表达式

* `reg.test()`**只能判断这个字符有没有符合要求的判断，返回的结果只有**`true`**和**`false`

* `str.match()`**可以把所有的东西匹配出来，返回给你，比上一种方法更直观，还能告诉你返回了多少个**

```js
例：想把一、二、三位都是数字都匹配出来，不同，可变化的数字，可以用 [] 来写，
一个 [] 可以代表一个数，[] 里面放的是范围，是一个区间，如 [1234567890] ，
如下图：

var reg = /[1234567890][1234567890][1234567890]/g;
// 里面放了3个[],就代表可以匹配3个数字
var str = '123adsf654as8df56d4f';
console.log(str.match(reg));
// ['123','654'];
```

```js
例：
var reg = /[ab][cd][d]/g;
var str = 'abcd';
console.log(str.match(reg));
// ['bcd']，指的是和 ab、cd、d匹配的数字
```

```js
例：0-9 是指 0 到 9，A-Z 是指大 A 到 Z，a-z 是指小 a - z
var reg = /[0-9A-Za-z][cd][d]/g;
var str = 'abcd'
// 就相当于字符和数字全部匹配了，也可以 A-z,直接从大A到小z
// 这是按 ASCII 码排序的，从大写到小可以写成 A-z
var reg = /[0-9A-z][cd][d]/g;
var str = 'ab1cd';
console.log(str.match(reg));
// [1cd]
```

```js
例：^ 在正则表达式里面和外面的意思不一样，在正则表达式里面是 非 的意思
var reg = /[^a][^b]/g;
var str = 'ab1cd';
console.log(str.match(reg));
// ['b1','cd']，就是打印出不是 a 开头的和 b 开头的东西
```

```js
例：| 在正则表达式种是 或 的意思
var reg = /(abc|bcd)/g;
var str = 'abc';
console.log(str.match(reg));
// ['abc']

var reg = /(abc|bcd)[0-9]/g;
var str = 'bcd2';
console.log(str.match(reg));
// ['bcd2']
```

## 正则表达式的元字符

**正则表达式的元字符和表达式是要给东西;**

**元字符（Metacharacter）是拥有特殊含义的字符;**

```js
字符             | 描述

\               | 将下一个字符标记为一个特殊字符、或一个原义字符、或一个 向后引用、或一个八进制转义符

()              | 标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)

[]              | 标记一个中括号表达式的开始。要匹配 [，请使用 \[

{}              | 标记限定符表达式的开始。要匹配 {，请使用 \{

^               | 以什么什么开头，匹配输入字符串的开始位置。如果设置了 RegExp 对象的 Multiline 属性，^ 也匹配 '\n' 或 '\r' 之后的位置。

n$              | 以什么什么结尾，匹配任何结尾为 n 的字符串。 匹配输入字符串的结束位置。如果设置了RegExp 对象的 Multiline 属性，$ 也匹配 '\n' 或 '\r' 之前的位置。

$n              | 代表第几个子表达式的内容，比如：$1 代表第一个子表达式的内容

n*              | 匹配任何包含零个或多个 n 的字符串。这个变量可以出现 0 到无数次。 匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}

n+              | 匹配任何包含至少一个 n 的字符串。这个变量可以出现 1 到无数次。 匹配前面的子表达式一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}

n?              | 匹配任何包含零个或一个 n 的字符串。这个变量 0或 1 个一匹配。匹配前面的子表达式零次或一次。例如，"do(es)?" 可以匹配 "do" 或 "does" 中的"do" 。? 等价于 {0,1}。

n{X}            | 匹配包含 X 个 n 的序列的字符串。n 是一个非负整数。匹配确定的 n 次。例如，'o{2}' 不能匹配 "Bob" 中的 'o'，但是能匹配 "food" 中的两个 o。

n{X,}           | 匹配包含至少 X 个 n 的序列的字符串。n 是一个非负整数。至少匹配n 次。例如，'o{2,}' 不能匹配 "Bob" 中的 'o'，但能匹配 "foooood" 中的所有 o。'o{1,}' 等价于 'o+'。'o{0,}' 则等价于 'o*'。

n{X,Y}          | 匹配包含 X 至 Y 个 n 的序列的字符串。m 和 n 均为非负整数，其中n <= m。最少匹配 n 次且最多匹配 m 次。例如，"o{1,3}" 将匹配 "fooooood" 中的前三个 o。'o{0,1}' 等价于 'o?'。请注意在逗号和两个数之间不能有空格。

n?              | 匹配任何包含零个或一个 n 的字符串。这个变量 0 或 1 个一匹配。 当该字符紧跟在任何一个其他限制符 (*, +, ?, {n}, {n,}, {n,m}) 后面时，匹配模式是非贪婪的。非贪婪模式尽可能少的匹配所搜索的字符串，而默认的贪婪模式则尽可能多的匹配所搜索的字符串。例如，对于字符串 "oooo"，'o+?' 将匹配单个 "o"，而 'o+' 将匹配所有 'o'。

.               | 查找单个字符，除了换行和行结束符。匹配除 "\n" 和 "\r" 之外的任何单个字符。要匹配包括 '\n' 和 "\r" 在内的任何字符，请使用象 '[.\n\r]' 的模式。

(?:pattern)     | 匹配 pattern 但不获取匹配结果，也就是说这是一个非获取匹配，不进行存储供以后使用。这在使用 "或" 字符 (|) 来组合一个模式的各个部分是很有用。例如， 'industr(?:y|ies)' 就是一个比 'industry|industries' 更简略的表达式。

(?=n)           | 匹配任何其后紧接指定字符串 n 的字符串。正向预查，在任何匹配 n 的字符串开始处匹配查找字符串。这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。例如，'Windows (?=95|98|NT|2000)' 能匹配 "Windows 2000" 中的 "Windows" ，但不能匹配 "Windows 3.1" 中的 "Windows"。预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。

(?!n)           | 匹配任何其后没有紧接指定字符串 n 的字符串。后面不跟着 n 负向预查，在任何不匹配 n 的字符串开始处匹配查找字符串。这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。例如'Windows (?!95|98|NT|2000)' 能匹配 "Windows 3.1" 中的 "Windows"，但不能匹配 "Windows 2000" 中的 "Windows"。预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。

x|y             | 形容或。匹配 x 或 y。例如，'z|food' 能匹配 "z" 或 "food"。'(z|f)ood' 则匹配 "zood" 或 "food"。

[^a-z]          | 形容非，负值字符范围。匹配任何不在指定范围内的任意字符。例如，'[^a-z]' 就是匹配任何不在 'a' 到 'z' 范围内的任意字符。

\cx             | 匹配由 x 指明的控制字符。例如， \cM 匹配一个 Control-M 或回车符。x 的值必须为 A-Z 或 a-z 之一。否则，将 c 视为一个原义的 'c' 字符。

\b              | 匹配一个单词边界，也就是指单词和空格间的位置。例如， 'er\b' 可以匹配"never" 中的 'er'，但不能匹配 "verb" 中的 'er'。

\B              | 匹配非单词边界。'er\B' 能匹配 "verb" 中的 'er'，但不能匹配 "never" 中的 'er'。

\s              | 匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [ \f\n\r\t\v]。

    \n              | 匹配一个换行符。等价于 \x0a 和 \cJ。
    \f              | 匹配一个换页符。等价于 \x0c 和 \cL。
    \v              | 匹配一个垂直制表符。等价于 \x0b 和 \cK。
    \r              | 匹配一个回车符。等价于 \x0d 和 \cM。
    \t              | 匹配一个制表符。等价于 \x09 和 \cI

\S              | 匹配任何非空白字符。等价于 [^ \f\n\r\t\v]

\d              | 匹配一个数字字符。等价于 [0-9]。

\D              | 匹配一个非数字字符。等价于 [^0-9]。

\w              | 匹配包括下划线的任何单词字符。就是于'[A-Za-z0-9_]'

    [a-z]           | 字符范围。匹配指定范围内的任意字符。例如，'[a-z]' 可以匹配 'a' 到 'z' 范围内的任意小写字母字符。

    [A-Z]           | 字符范围。匹配指定范围内的任意字符。例如，'[A-A]' 可以匹配 'A' 到 'Z' 范围内的任意小写字母字符。

    [0-9]           | 字符范围。匹配指定范围内的任意字符。例如，'[0-9]' 可以匹配 '0' 到 '9' 范围内的任意小写字母字符。

\W              | 匹配任何非单词字符。等价于 '[^A-Za-z0-9_]'。

\n              | 标识一个八进制转义值或一个向后引用。如果 \n 之前至少 n 个获取的子表达式，则 n 为向后引用。否则，如果 n 为八进制数字 (0-7)，则 n 为一个八进制转义值。

\uxxxx          | 查找以十六进制数 xxxx 规定的 Unicode 字符。 匹配 xxxx，其中 xxxx 是一个用四个十六进制数字表示的 Unicode 字符。例如， \u00A9 匹配版权符号 (?)

贪婪匹配         | 贪婪匹配。变成贪婪匹配（能少就不多），在量词后面加个'？'号。例如：var reg = /a+?/g;

懒惰性           | 懒惰性则是正则在成功捕获一次后不管后边的字符串有没有符合条件的都不再捕获。如果想捕获目标中所有符合条件的字符串的话，我们可以用标识符g来标明是全局捕获
```

**运算符的优先级：**

```js
`从左到右进行运算,不同优先级的运算先高后低:`

运算符                      | 描述

\                          | 转义符

(), (?:), (?=), []          | 圆括号和方括号

*, +, ?, {n}, {n,}, {n,m}   | 限定符

^, $, \任何元字符、任何字符    | 定位点和序列（即：位置和顺序）

|                           | 替换，"或"操作字符具有高于替换运算符的优先级，使得"m|food"匹配"m"或"food"。若要匹配"mood"或"food"，请使用括号创建子表达式，从而产生"(m|f)ood"。
```

## RegExp 对象方法、属性

**RegExp 对象方法属性（FF是火狐浏览器，IE 的 ie 浏览器，从哪个版本开始兼容）;**

```js
属性        | 描述

global      | RegExp 对象是否具有标志 g，进行全局匹配

ignoreCase  | RegExp 对象是否具有标志 i，不区分大小写

input       | 被匹配的串

lastIndex   | 一个整数，标示开始下一次匹配的字符位置

lastParen   | 被最后一个括号括起来的子串

lastContent | 最近一次匹配以左的子串

multiline   | RegExp 对象是否具有标志 m，进行多行匹配

source      | 正则表达式的源文本
```

```js
方法        | 描述

compile     | 编译正则表达式

exec        | 检索字符串中指定的值。返回找到的值，并确定位置

test        | 检索字符串中指定的值，返回Boolean值（true & false）

match       | 找到一个或多个正则表达式的匹配

search      | 检索与正则表达式相匹配的值，返回的不是 -1 都匹配成功了，返回的是匹配这个东西的位置

split       | 把字符串分割为字符串数组

replace     | 替换和正则表达式匹配的字符串，replace 的精华是正则表达式
```

## 注意

1. *？意思是能取 0，就不取多

2. 想匹配空格，直接写，就可以了

3. 想把选中的字符替换成$，直接写$是不行的，需要加上转义字符$

    由于在替换文本里面$有了特殊的含义（$代表反向引用），如果想要是替换 $ 这个字符的话，需要写成 $$，充当转义字符

4. 正则表达式要匹配一个反向引用的东西，写\\

    ```js
    var str = 'aa\\aaaa';
    var reg = /\\/g;
    console.log(str.match(reg));
    // ['\']
    ```

5. 在正则表达式里面要匹配问号？写\? 其余*+-()星号加号减号都类似

```js
var str = 'aa?aaaa';
var reg = /\?/g;
console.log(str.match(reg));
// ['?']
```

```js
例：下面是想去重，变成 abc，先匹配一串，再取一
var str = 'aaaaaaaaaaaabbbbbbbbbccccccccc';
var reg = /(\w)\1*/g;
console.log(str.replace(reg,$1));
// abc
```

```js
百度招聘 14 年最后一题:
给 var str = '100000000000'; 这个数字科学计数法，每隔三位打点
思路：找规律，从后往前查，每三位打个点，换个空进去【什么样的空？后面的数 一定是 3 的倍数，(\d{3})+是 3 的倍数位个数字，这里面的东西一到多个，第一个/ 后面的空后面加上正向预查，后面是3 的倍数位个数字，$以什么结尾】空的后面跟 着 3 的倍数位个数字并且以这个结尾。\B 非单词边界

答案：
var str = '1000000000000';
var reg = /(?=(\B)(\d{3}))+$/g;
console.log(str.replace(reg,'.'));
```

## 相关面试题
>  1.  正则表达式实现aabb的形式变成bbaa
>  2.  给10000000000三位打点 变成 10.000.000.000
>  3.  字符串去重 aaaaaaaaaaaaaaaaaaaaaabbbbbbbbcccccccccc变成abc
>  4.  把the-first-name转换成小驼峰式theFirstName
>  5.  匹配结尾的数字
>  6.  统一空格数
>  7.  判断字符串是不是由数字构成
>  8.  删除字符串中的空格
>  9.  身份证号匹配
> 10.  将字符串"select student.\*,result.\* from student inner join result on student.id = result.studentid" 和字符串"select * from student "中的student替换成key值

# BOM

**`BOM`** 是 **`brower object model`** 的缩写，简称浏览器对象模型，主要处理浏览器窗口和框架，描述了与浏览器进行交互的方法和接口，可以对浏览器窗口进行访问和操作，譬如可以弹出新的窗口，回退历史记录，获取url……。

## 一、BOM 与 DOM（Document Object Model）的关系

`javascript`是通过访问`BOM`对象来访问、控制、修改浏览器

`window`是BOM的属性，也就是说`BOM`的`window`包含了`document`，因此通过`window`对象的`document`属性就可以访问、检索、修改文档内容与结构

`document`对象又是`DOM`模型的根节点。因此，`BOM`包含了`DOM`，浏览器提供出来给予访问的是`BOM`对象，从BOM对象再访问到`DOM`对象，从而js可以操作浏览器以及浏览器读取到的文档

`DOM`的大部分内容都是`W3c`标准规范，所以兼容性很好，不需要太多的兼容性代码，而`BOM`则不一样，`BOM`没有`W3c`规范，每个浏览器厂家的规范也就不一样了。

## 二、BOM对象包含的对象

**不是说BOM下面只包含了一个window对象吗？其实BOM对象下面只有一个window对象，但是因为了解清除，所以其他四个也是比较重要的对象了;**

```js
Window      | Javascript 层级中的顶层对象，表示浏览器窗口

Navigator   | 包含客户端浏览器的信息。（比如浏览器的版本号）

History     | 包含了浏览器窗口访问过的URL（比如历史记录，前进、后退）

Location    | 包含了当前URL的信息（地址栏中的信息）

Screen      | 包含了客户端显示屏的信息（返回一些屏幕信息，基本上用不到）
```

### Window 对象

**`Window`对象表示一个浏览器窗口或一个框架，在客户端JavaScript中，`Window`对象是全局对象，所有的表达式都在当前的环境中计算，也就是说，要引用当前窗口根本不需要特殊的语法，可以把那个窗口的属性作为全局变量来使用。例如，可以只写`document`，而不必写`window.document`；**

#### window 对象属性

```js
`closed`        | 返回窗口是否已被关闭，例：window.closed;

defaultStatus   | 设置或返回窗口状态栏中的默认文本。（仅Opera支持）

document        | 对 Document 对象的只读引用，请参阅 Document 对象

`history`       | 对 History 对象的只读引用。请参数 History 对象

`innerHeight`   | 返回窗口的文档显示区的高度

`innerWidth`    | 返回窗口的文档显示区的宽度

length          | 设置或返回窗口中的框架数量

`location`      | 用于窗口或框架的 Location 对象，请参阅 Location 对象

name            | 设置或返回窗口的名称

`Navigator`     | 对 Navigator 对象的只读引用，请参阅 Navigator 对象

opener          | 返回对创建此窗口的窗口的引用

outerheight     | 返回窗口的外部高度

outerwidth      | 返回窗口的外部宽度

`pageXoffset`   | 设置或返回当前页面相对于窗口显示区左上角的 X 位置

`pageYoffset`   | 设置或返回当前页面相对于窗口显示区左上角的 Y 位置

parent          | 返回父窗口

`Screen`        | 对 Screen 对象的只读引用，请参数 Screen 对象

self            | 返回对当前窗口的引用，等价于 Window 属性

status          | 设置窗口状态栏的文本（默认只支持 Opera）

top             | 返回最顶层的先辈窗口

window          | window 属性等价于 self 属性，它包含了对窗口自身的引用

`screenLeft`    | 返回窗口相对于屏幕的 X 坐标。

`screenTop`     | 返回窗口相对于屏幕的 Y 坐标。

`screenX`       | 返回窗口相对于屏幕的 X 坐标。

`screenY`       | 返回窗口相对于屏幕的 Y 坐标。
```

#### window 对象方法

```js
`alert()`           | 显示或弹出带有一段消息和一个确认按钮的警告框

blur()              | 把键盘焦点从顶层窗口移开

focus()             | 把键盘焦点给予一个窗口

`setInterval()`     | 按照指定的周期（以毫秒来调用函数或计算表达式），定时器

`setTimerout()`     | 在指定的毫秒数后调用函数或计算表达式，定时器，只执行一次

`clearInterval()`   | 取消由setInterval设置的定时器tiemout

`clearTimeout()`    | 取消由setTimeout设置的定时器tiemout

`close(`)           | 关闭浏览器窗口

`confirm()`         | 显示或弹出带有一段消息以及确认按钮和取消按钮的对话框，确认返回true，取消返回false

createPopup()       | 创建一个弹出窗口，只有ie支持（不包括ie11）

moveBy(x,y)         | 可相对窗口的当前坐标把它移动指定的像素，moveBy(100,100)中的100就代表100像素，可以配合 open()来时使用

moveTO()            | 把窗口的左上角移动到要给指定的坐标

`open()`            | 打开一个新的浏览器窗口或查找一个已命名的窗口，window.open(URL,name（窗口的名称）,features,replace),例如：open('url','name（窗口的名称）','属性')

print()             | 打印（就是打印当前页面）当前窗口内容

`prompt()`          | 显示可提示用户输入的对话框

`resizeBy()`        | 按照指定的像素调整窗口的大小

`resizeTo()`        | 把窗口的大小调整到指定宽度和高度

`scrollBy()`        | 按照指定的像素值来滚动内容

`scrollTo()`        | 把内容滚动到指定的坐标
```

### Navigator 对象

**`Navigator`对象包含的属性描述了正在使用的浏览器。可以使用这些属性进行平台专用的配置。虽然这个对象的名称显而易见的是`Netscape`的`Navigator`浏览器，但其他实现了`JavaScript`的浏览器也支持这个对象**

#### Navigator 对象属性

```js
appCodeName      | 返回浏览器的代码名。以 Netscape 代码为基础的浏览器中，它的值是"Mozila"。为兼容Microsoft也是

appMinorVersion  | 返回浏览器的次级版本。（IE4、Opera支持）

appName          | 返回浏览器的名称

appVersion       | 返回浏览器的平台和版本信息

browserLanguage  | 返回当前浏览器的语言（IE 和 Opera 支持）

`cookieEnabled`  | 返回指明浏览器中是否启用 cookie 的布尔值

cpuClass         | 返回浏览器系统的 CPU 等级（IE支持）

`onLina`         | 返回执行系统是否处于脱机模式的布尔值（连没连网）

platform         | 返回运行浏览器的操作系统平台

systemLanguage   | 返回当前系统的默认语言。（IE支持）

`userAgent`      | 返回有客户机发送服务器的 user-agent 头部的值。

userLanguage     | 返回操作系统设定的自然语言。（IE 和 Opera 支持）

plugins          | 返回包含客户端安装的所欲插件的数组
```

#### Navigator 对象方法

```js
javaEnabled()     | 规定浏览器是否支持并启用了 Java

taintEnabled()    | 规定浏览器是否启用数据污点（data tainting）
```

### History

**History 对象包含用户（在浏览器窗口中）访问过的URL;**

#### History 对象属性

```js
length      | 返回浏览器历史列表中的 URL 数量
```

#### History 对象方法

```js
back()      | 加载 history 列表中的前一个 URL

forward()   | 加载 history 列表中的下一个 URL

go()        | 加载 history 列表中的某个具体页面,例如 history.go(-2)
```

### Location 对象

**Location 对象包含有关当前 URL 的信息;**

#### Location 对象属性

```js
`hash`        | 设置或返回从井号（#）开始的 URL（锚）。

`host`        | 加载 history 列表中的下一个 URL

hostname      | 加载 history 列表中的某个具体页面,例如 history.go(-2)

`href`        | 设置或返回完整的 URL

`pathname`    | 设置或返回当前 URL 的路径部分

port          | 设置或返回当前 URL 的端口号

`protocol`    | 设置或返回当前 URL 的协议

`search`      | 设置或返回从问号（？）开始的 URL(查询部分)
```

#### Location 对象方法

```js
`assign()`          | 加载新的文档

`reload('force')`   | 重新加载当前文档，参数可选，不填或填 false 则取浏览器缓存的文档

`replace()`         | 用新的文档替换当前文档
```

### Screen 对象

> `Screen`对象包含有关客户端显示屏幕的信息。每个`Window`对象的`screen`属性都引用一个`Screen`对象。`Screen`对象中存放着有关显示浏览器屏幕的信息。`Javascript`程序将利用这些信息来优化它们的输出，以达到用户的显示要求。例如，一个程序可以根据显示器的尺寸选择使用大图像还是使用小图像，它还可以根据显示器的颜色深度选择使用`16`位色还是使用`8`位色的图形。另外，`JavaScript`程序还能根据有关屏幕尺寸的信息将新的浏览器窗口定位在屏幕中间

#### Screen 对象属性

```js
availHeight            | 返回显示屏的高度（除 Windows 任务栏之外）

availWidth             | 返回显示屏的宽度（除 Windows 任务栏之外）

bufferDepth            | 设置或返回调色板的比特深度（仅 IE 支持）

colorDepth             | 返回目标设备或缓冲器上的调色板的比特深度

deviceXDPI             | 返回显示屏幕的每英寸水平点数（仅 IE 支持）

deviceYDPI             | 返回显示屏幕的每英寸垂直点数（仅 IE 支持）

fontSmoothingEnabled   | 返回用户是否在显示控制面板中启用了字体平滑（仅 IE 支持）

height                 | 返回显示屏幕的高度

logicaIXDPI            | 返回显示屏幕每英寸的水平方向的常规点数（仅 IE 支持）

logicaIYDPI            | 返回显示屏幕每英寸的垂直方向的常规点数（仅 IE 支持）

pixelDepth             | 返回显示器的颜色分辨率（比特每像素）
```

# Js运动

## 加速运动

```js
var oWrapper = document.getElementsByClassName('wrapper')[0];
var timer;
oWrapper.onclick = function () {
    startMove(this, 300); // this就是obj对象，300就是运动距离
}
function startMove(obj,target) { // obj 是DOM对象,target是距离
    clearInterval(timer);
    var iSpeed; // 速度
    var timer = setInterval(function() {
        iSpeed = (target - obj.offsetLeft) / 8; // 速度-DOM对象的offsetLeft，查看还有多少距离，当距离达到300就停止，除8 是因为数字太大
        iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed); // 当 iSpeed 大于0时，使用ceil向上取整，否则floor向下取整
        if(obj.offsetLeft == target) { // 停止条件
            clearInterval(timer);
            obj.offsetLeft = target;
        } else { // 不等于300时执行下面程序
            obj.style.left = obj.offsetLeft + iSpeed + 'px';
        }
    },30)
}
```

## 悬浮拉伸

```js
var oWrapper = document.getElementsByClassName('wrapper')[0];
// oWrapper 是一个父元素，可以添加一个子元素，延伸到外面，使用冒泡触发
var timer;
oWrapper.onmouseenter = function () {
    startMove(this, 0);
}
oWrapper.onmouseleave = function () {
    startMove(this, -400);
}
function startMove(obj, target) { // this就是对象，300就是运动距离
    clearInterval(timer); // 如果不停止，它会累加每次的速度
    var iSpeed; // 速度
    timer = setInterval(function () {
        iSpeed = (target - obj.offsetLeft) / 8; //速度-DOM对象的offsetLeft，查看还有多少距离
        iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
        if (obj.offsetLeft === target) {// 停止条件
            clearInterval(timer);
        } else {// 不等于300时执行下面程序
            obj.style.left = obj.offsetLeft + iSpeed + 'px';
        }
    }, 30)
}
```

## 链式运动框架

### 透明运动函数

```js
var oWrapper = document.getElementsByClassName('wrapper')[0];
var timer;
oWrapper.onclick = function () {
        startMove(this, 50);
}
function getStyle(obj, prop) {
    if (obj.currentStyle) {
        return obj.currentStyle[prop];
    } else {
        return window.getComputedStyle(obj, null)[prop];
    }
}
function startMove(obj, target) {
    clearInterval(timer);
    var iSpeed, iCur;
    timer = setInterval(function () {
        iCur = parseFloat(getStyle(obj,'opacity')) * 100;
        iSpeed = (target - iCur) / 7;
        iSpeed += iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
        if(iCur == target){
            clearInterval(timer);
        } else {
            obj.style.opacity = (iCur + iSpeed) / 100;
        }
    },30)
}
```

### 链式运动框架

```js
function animate(obj,json,callback) { // obj是DOM对象，json是参数对象，callback是回调函数（可以重复调动）
    clearInterval(obj.timer);
    var iSpeed,iCur; // iSpeed 为速度，iCur 是DOM元素的原参数
    obj.timer = setInterval(function() {
        var bStop = true;
        for(var attr in json) {
            if(attr == 'opacity') {
                iCur = parseFloat(getStyle(obj,attr)) * 100;
            } else {
                iCur = parseInt(getStyle(obj,attr));
            }
            iSpeed = (json[attr] - iCur) / 7; // 传进去的参数 - 原来的参数，查看还有多少，越来越小就代表越来越接近传进来的参数设置，就会停止，/7是因为数字太大，可以除任何一个数字
            iSpeed += iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed); //当 iSpeed 大于0时，使用ceil向上取整，否则floor向下取整，为了让iSpeed最后可以完美接近传进来的参数
            if(attr == 'opacity') {
                obj.style.opacity = (iCur + iSpeed) / 100; // iCur 是原来提取的样式，iSpeed是速度，不断向传进来的参数靠近，越来越小，最终停止
            } else {
                obj.style[attr] = (iCur + iSpeed) + 'px';
            }
        }
        if(iCur != json[attr]) {
            bStop = false;
        }
        if(bStop) {
            clearInterval(obj.timer);
            typeof callback == 'function' ? callback() : '';
        }
    },30)
}
```

## 弹性运动

### 初级弹性运动
```js
var oNav = document.getElementsByTagName('div')[0];
oDiv.onclick = function () {
    startMove(this,300)
}
function startMove(obj,target){
    clearInterval(obj.timer);
    var iSpeed = 40,a,u = 0.8;
    obj.timer = setInterval(function(){
        a = (target - obj.offsetLeft) / 8;
        iSpeed += a;
        iSpeed *= u;
        if(Math.abs(iSpeed) < 1 && Math.abs(300 - obj.offsetLeft) < 1){
            clearInterval(obj.timer);
        } else {
            obj.style.left = obj.offsetLeft + iSpeed + 'px';
        }
    },30)
}
```

### 横向弹性导航
```js
var LiArr = Array.prototype.slice.call(document.getElementsByClassName('nav'),0); // 把ul下的li选中变成数组，好用forEach方法
var oBg = document.getElementsByClassName('bg')[0]; // 选中ul下面的第一个li，让它独立出来，不给位置，作为背景色 // 自己悬浮
LiArr.forEach(function(ele,index) {
    ele.onmouseenter = function() { // 自己悬浮
            var newLeft = this.offsetLeft; // 自己的offstLeft属性
            startMove(oBg,newLeft);
    }
})
function startMove(obj, target) {
    clearInterval(obj.timer);
    var iSpeed = 40, // 初速度
        a, u = 0.75; // a为接近速度，u为摩擦力
    obj.timer = setInterval(function() {
        a = (target - obj.offsetLeft) / 7;
        iSpeed += a;
        iSpeed *= u;
        if (Math.abs(iSpeed) <= 1 && Math.abs(target - obj.offsetLeft) <= 1) {
            clearInterval(obj.timer);
            obj.style.left = target + 'px';
        } else {
            obj.style.left = obj.offsetLeft + iSpeed + 'px';
        }
    }, 30)
}
```

### 扔球的函数
```js
function throwBall(obj) {
    obj.onmousedown = function(e) {
        var e = e || window.event, // 兼容IE
            timer, //定时器
            disX, //鼠标X、Y轴位置
            disY,
            lastX = obj.offsetLeft,
            lastY = obj.offsetTop,
            iSpeedX = 0, // 鼠标向X、y轴施的力
            iSpeedY = 0,
            that = this; // 代表this一直为obj
        disX = e.clientX - this.offsetLeft; // 现在的鼠标X，Y轴位置
        disY = e.clientY - this.offsetTop;
        document.onmousemove = function(e) {
            var e = e || window.event;
            var newLeft = e.clientX - disX; // 移动时的位置
            var newTop = e.clientY - disY;
            clearInterval(that.timer); // 每次移动都要停止之前的定时器，要不然会不受控
            iSpeedX = newLeft - lastX; // 更新X，Y轴施力
            iSpeedY = newTop - lastY;
            lastX = newLeft; // 更新X，Y轴位置
            lastY = newTop;
            that.style.left = newLeft + 'px';
            that.style.top = newTop + 'px';
        }
        document.onmouseup = function() {
            document.onmousemove = null;
            document.onmouseup = null;
            startMoveTwo(that, iSpeedX, iSpeedY);
        }
    }
    }
function startMoveTwo(obj,iSpeedX,iSpeedY) {
    	// 每次开始前就清空以前的计时器
        clearInterval(obj.timer);
    	// g为初始力
        var g = 6;
        obj.timer = setInterval(function () {
            iSpeedY += g;
            newLeft = obj.offsetLeft + iSpeedX;
            newTop = obj.offsetTop + iSpeedY;
            if (newTop >= document.documentElement.clientHeight - obj.offsetHeight) {
                // 当弹到左右两边的时候 *-1 反转弹回来
                iSpeedY *= -1;
                // 每次 *0.8 是摩擦力，让它可以停下来
                iSpeedX *= 0.8;
                iSpeedY *= 0.8;
                newTop = document.documentElement.clientHeight - obj.offsetHeight;
            }
            if (newTop <= 0) {
                iSpeedY *= -1;
                iSpeedX *= 0.8;
                iSpeedY *= 0.8;
                newTop = 0;
            }
            if (newLeft >= document.documentElement.clientWidth - obj.offsetWidth) {
                iSpeedX *= -1;
                iSpeedX *= 0.8;
                iSpeedY *= 0.8;
                newLeft = document.documentElement.clientWidth - obj.offsetHeight;
            }
            if (newLeft <= 0) {
                iSpeedX *= -1;
                iSpeedX *= 0.8;
                iSpeedY *= 0.8;
                newLeft = 0;
            }
            // 结束条件
            if (Math.abs(iSpeedX) <= 1 && Math.abs(iSpeedY) <= 1 && newTop == document.documentElement
                .clientHeight - obj.clientHeight) {
                iSpeedX = 0;
                iSpeedY = 0;
                clearInterval(obj.timer);
                console.log('over');
            }
            obj.style.left = newLeft + 'px';
            obj.style.top = newTop + 'px';
        }, 30)
    }
}
```

## tab菜单切换 \ 手风琴菜单

### tab菜单

```js
var tabs = document.getElementsByClassName('tab'); // 标题
var goods = document.getElementsByClassName('good'); // 内容
for (var i = 0; i < tabs.length; i++) {
    tabs[i].index = i;
    tabs[i].onclick = function () {
        for (var j = 0; j < goods.length; j++) {
            goods[j].style.display = 'none';
        }
        goods[this.index].style.display = 'block';
    }
}
```

### 手风琴菜单

```js
var oInfos = document.getElementsByClassName('info-con'); // li，包裹着图片的，用js加载图片，要先写好样式   // 包裹li外面的ul标签给css样式是
var len = oInfos.length // li数量，也是图片的数量
for (var i = 0; i < len; i++) {
    oInfos[i].style.backgroundImage = "url(images/" + (i + 1) + '.png)'; // 加载图片，用字符串串联起来
    oInfos[i].onmousemove = function() {
        for (var j = 0; j < len; j++) {
            startMove(oInfos[j], {
                    width: 100
                }) // 鼠标悬浮的时候其他的图片宽度都改为100
        }
        startMove(this, {
                width: 900
            }) // 鼠标悬浮时选中的图片宽度为900，看具体图片宽度多少
    }
    oInfos[i].onmouseout = function() {
        for (var i = 0; i < len; i++) {
            startMove(oInfos[i], {
                width: 240
            }); // 鼠标离开的时候全部回归正常宽度，看你css给li多少宽度，240是我给的，看具体情况
        }
    }
}
```

# JavaScript 必会知识点（琐碎、相互独立）

1. **属性映射 HTML属性，映射到Element;**

2. **cdn（缓存服务器）;**

3. **断点调试（debugger;）;**

4. **typeof(new Array).__proto__.constructor();;**

## 渲染模式

>在多年以前（IE6诞生以前），各大浏览器都处于各自比较封闭的发展中（基本没有兼容性可谈）。随着web的发展，兼容性问题的解决越来越显得迫切，随即，各浏览器厂商发布了按照标准模式（遵循各厂商制定的统一标准）工作的浏览器，比如IE6就是其中之一。但是考虑到以前建设的网站并不支持标准模式，所以各大浏览器在加入标准模式的同时也保留了混杂模式（即以前那种未按照统一标准工作的模式，也叫怪异模式）

```js
DOCTYPE // 三种标准模式的写法

1. <!DOCTYPE html>

2. <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

3. <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

如果当<!DOCTYPE html>不写，或者写错了，都会进入到怪异渲染模式中
```

1. **渲染模式 : <! DOCTYPE html> 是 html5 的，写三种的任何一种都是可以的，都是正常渲染模式**

2. **怪异/混杂模式 : 试图去兼容之前的语法，去掉<!DOCTYPE html>这一行即可开启（向后兼容）**

**document.compatMode**是判断是怪异模式还是标准模式

**CSS1Compat -- 标准模式;**

**BackCompat -- 怪异模式向后兼容;**

`怪异模式不是说对所有的浏览器都管用，主要是针对IE6及以下的浏览器版本的。`

`怪异模式下盒模型会变成IE盒模型，行盒也会可以改变宽高`

**IE盒模型：box-sizing:border-box;**

**属性**：_content-box;_

元素的宽高 = 边框 + 内边距 + 内容宽高

**属性**：_border-box;_

元素的宽高 = width/height的宽高

**W3c标准盒模型：**

宽度 = 左外边距 + 左边框 + 左内边距 + width + 右内边距 + 右边框 + 右外边距

高度 = 上外边距 + 上边框 + 上内边距 + height + 下内边距 + 下边框 + 下外边距

## img图片预加载 \ 图片懒加载

**图片预加载:**

```js
// 图片预加载，就是在全部内容加载完之后再加载图片
var OImg = new Image();
OImg.src = '图片地址';
OImg.onload = function () {
    document.body.appendChild(OImg);
}
```

**图片懒加载:**

```js
// 图片懒加载，我需要你的时候在加载，不需要你的时候就不要加载
<button> getTime </button>
var oBtn = document.getElementsByTagName('button')[0];
OBtn.onclick = function(){
    var OImg = new Image();
    OImg.src = '图片地址';
    document.body.appendChild(OImg);
}
```

## 文档碎片

```js
<ul></ul>

var Oul = document.getElementsByTagName("ul")[0];
for (var i = 0; i < 10000; i++){
    var Oli = document.createElement("li");
    Oli.innerHTML = i;
    Oul.appendChild(Oli);
}
```

> 但是， 如果当我们要向document中添加大量数据时(比如1w条)， 如果像上面的代码一样， 逐条添加节点， 这个过程就可能会十分缓慢。
当然, 你也可以建个新的节点, 比如说div, 先将oP添加到div上, 然后再将div添加到body中.但这样要在body中多添加一个 < div > < /div>.但文档碎片不会产生这种节点.

```js
<ul></ul>

var OUl = document.getElementsByTagName("ul")[0];
var ODiv = document.createElement("div");
for (var i = 0; i < 10000; i++){
    var OLi = document.createElement("li");
    OLi.innerHTML = i;
    ODiv.appendChild(OLi);
}
OUl.appendChild(ODiv);
```

> 为了解决这个问题， 我们可以引入createDocumentFragment() 方法， 它的作用是创建一个文档碎片， 把要插入的新节点先附加在它上面， 然后再一次性添加到document中。 代码如下：

代码如下:

```js
<ul></ul>
//先创建文档碎片
var oFragmeng = document.createDocumentFragment();
var OUl = document.getElementsByTagName("ul")[0];
for (var i = 0; i < 10000; i++) {
    var OLi = document.createElement("li");
    OLi.innerHTML = i;
    //先附加在文档碎片中
    oFragmeng.appendChild(OLi);
}
//最后一次性添加到document中
OUl.appendChild(oFragmeng);
//这就是文档碎片
```

```js
//当然，还有一种方法:用字符串拼接也可以
<ul></ul>
var OUl = document.getElementsByTagName('ul')[0];
var str = ''; // 声明一个空字符串
for(var i = 0;i < 1000;i ++){
    str += '<li>' + i + '</li>'; // 让标签用字符串＋起来
}
OUl.innerHTML = str; // 最后用innerHTML插入到ul里面
```

## byClassName（封装函数，兼容性vrey Good!）

```js
document.prototype.getByClassName = function(classname){
    var allDomArr = Array.prototype.slice.call(document.getElementsByTagName('8'),0);
    var filterArr = [];
    function dealClass(dom){
        var reg = /\s+/g;
        var arrClassName = dom.className.replace(reg,' ').trim();
        return arrClassName;
    }
    allDomArr.forEach(function(ele,index){
        var itemClassArr = dealClass(ele).split(' ');
        for(var i = 0;i < itemClassArr.length;i ++){
            if(itemClassArr[i] == className){
                filterArr.push(ele);
                break;
            }
        }
    })
    return filterArr;
}
```

## Math 对象

* `Math.abs(num)` : 返回`num`的绝对值

* `Math.acos(num)` : 返回`num`的反余弦值

* `Math.asin(num)` : 返回`num`的反正弦值

* `Math.atan(num)` : 返回`num`的反正切值

* `Math.atan2(y,x)` : 返回`y`除以`x`的商的反正切值

* `Math.ceil(num)` : 返回大于`num`的最小整数

* `Math.cos(num)` : 返回`num`的余弦值

* `Math.exp(x)` : 返回以自然数为底,x次幂的数

* `Math.floor(num)` : 返回小于`num`的最大整数

* `Math.log(num)` : 返回`num`的自然对数

* `Math.max(num1,num2)` : 返回`num1`和`num2`中较大的一个

* `Math.min(num1,num2)` : 返回`num1`和`num2`中较小的一个

* `Math.pow(x,y)` : 返回`x`的`y`次方的值

* `Math.random()` : 返回`0`到`1`之间的一个随机数

* `Math.round(num)` : 返回`num`四舍五入后的值

* `Math.sin(num)` : 返回`num`的正弦值

* `Math.sqrt(num)` : 返回`num`的平方根

* `Math.tan(num)` : 返回`num`的正切值

* `Math.E` : 自然数(`2.718281828459045`)

* `Math.LN2` : `2`的自然对数(`0.6931471805599453`)

* `Math.LN10` : `10`的自然对数(`2.302585092994046`)

* `Math.LOG2E` : `log 2` 为底的自然数(`1.4426950408889634`)

* `Math.LOG10E` : `log 10` 为底的自然数(`0.4342944819032518`)

* `Math.PI` : `π(3.141592653589793)`

* `Math.SQRT1_2` : `1/2`的平方根(`0.7071067811865476`)

* `Math.SQRT2` : `2`的平方根(`1.4142135623730951`)

### Math.random()

_**生成一个随机数，生成一个 0 ~ 1 之间的一个随机数。**_

```js
例：
var arr = ['a','b','c','d','e'];
var str = '';
for(var i = 0;i < 3;i ++){
    str = arr[Math.floor(Math.random() * 5)];
}
console.log(str);
// 可以取一个数组中任意三个字母
```

```js
例：
var arr = ['a','b','c','d','e'];
var str = '';
for(var i = 0;i < 3;i ++){
    str = arr[Math.floor(Math.random() * 3 + 2)];
}
console.log(str);
// 可以取数组中2 ~ 5中的任意三个字母;
就比如：我想让随机数在 2 ~ 5 之间取一个随机数，就例如：
Math.random() * 3 + 2 // 3是2到5之间的一个数字，2就是5-3=2；
```

```js
例：抽奖
var num = Math.random() * 10;
if(num < 0.001){
    console.log('一等奖');
}else if(num < 0.01){
    console.log('二等奖')
}else if(num < 0.1){
    console.log('三等奖')
}else{
    console.log('特等奖')
}
```

## String 对象

### `String` 对象属性

* `constructor` 对创建该对象的函数的引用

* `length`字符串的长度

* `prototype`允许您向对象添加属性和方法

### `String` 对象方法

* `charAt(n)` ：返回在指定位置的字符，字符串的索引，第n位

* `charCodeAt()` ：返回在指定的位置的字符的`Unicode`编码。这个返回值是`0 - 65535`之间的整数。(当返回值是`<=255`时为英文，当返回值`>255`时为中文)

* `concat()` ：连接两个或更多字符串，并返回新的字符串。

* `fromCharCode()` ：将 Unicode 编码转为字符。

* `indexOf()` ：返回某个指定的字符串值在字符串中首次出现的位置，如果没有找到匹配的字符串则返回 -1。

* `includes()` ：查找字符串中是否包含指定的子字符串。

* `lastIndexOf()` ：从后向前搜索字符串，并从起始位置（0）开始计算返回字符串最后出现* 的位置。

* `match()` ：查找找到一个或多个正则表达式的匹配。

* `repeat()` ：复制字符串指定次数，并将它们连接在一起返回。

* `replace()` ：在字符串中查找匹配的子串， 并替换与正则表达式匹配的子l串。

* `search()` ：查找与正则表达式相匹配的值。

* `slice(a,b)` ：提取字符串的片断，并在新的字符串中返回被提取的部分，剪切，从`a`剪切到`b`。

* `split()` ：把字符串分割为字符串数组。

* `startsWith()` ：查看字符串是否以指定的子字符串开头。

* `substr()` ：从起始索引号提取字符串中指定数目的字符。

* `substring()` ：提取字符串中两个指定的索引号之间的字符。

* `toLowerCase()` ：把字符串转换为小写。

* `toUpperCase()` ：把字符串转换为大写。

* `trim()` ：去除字符串两边的空白

* `toLocaleLowerCase()` ：根据本地主机的语言环境把字符串转换为小写。

* `toLocaleUpperCase()` ：根据本地主机的语言环境把字符串转换为大写。

* `valueOf()` ：返回某个字符串对象的原始值。

* `toString()` ：返回一个字符串。

* `String HTML`：包装方法

* `HTML` ：返回包含在相对应的 HTML 标签中的内容。

**以下方法并非标准方法，所以可能在某些浏览器下不支持。**

* `anchor()`：创建 HTML 锚。

* `big()`：用大号字体显示字符串。

* `blink()`：显示闪动字符串。

* `bold()`：使用粗体显示字符串。

* `fixed()`：以打字机文本显示字符串。

* `fontcolor()`：使用指定的颜色来显示字符串。

* `fontsize()`：使用指定的尺寸来显示字符串。

* `italics()`：使用斜体显示字符串。

* `link()`：将字符串显示为链接。

* `small()`：使用小字号来显示字符串。

* `strike()`：用于显示加删除线的字符串。

* `sub()`：把字符串显示为下标。

* `sup()`：把字符串显示为上标。

# javaScript书写规范：

## 命名规范

```js
常量名
    全部大写并单词间用下划线分隔
    如：CSS_BTN_CLOSE、TXT_LOADING
对象的属性或方法名
    小驼峰式（little camel-case）
    如：init、bindEvent、updatePosition
    示例：Dialog.prototype = {
                init: function () {},
                bindEvent: function () {},
                updatePosition: function () {}
                …
                };
类名（构造器）
    -->小驼峰式但首字母大写
    -->如：Current、DefaultConfig
函数名
    -->小驼峰式
    -->如：current()、defaultConfig()
变量名
    -->小驼峰式
    -->如：current、defaultConfig
私有变量名
    -->小驼峰式但需要用_开头
    -->如：_current、_defaultConfig
变量名的前缀
    -->续
```

代码格式

```js
"()"前后需要跟空格
"="前后需要跟空格
","后面需要跟空格
JSON对象需格式化对象参数
if、while、for、do语句的执行体用"{}"括起来
```

“{}”格式如下

```js
if (a==1) {
    //代码
};
```

避免额外的逗号

`var arr = [1,2,3,];`

> for-in循环体中必须用hasOwnProperty方法检查成员是否为自身成员，避免来自原型链上的污染。 长语句可考虑断行

```js
TEMPL_SONGLIST.replace('{TABLE}', da['results'])
    .replace('{PREV_NUM}', prev)
    .replace('{NEXT_NUM}', next)
    .replace('{CURRENT_NUM}', current)
    .replace('{TOTAL_NUM}', da.page_total);
```

为了避免和JSLint的检验机制冲突，“.”或“+”这类操作符放在行尾

```js
TEMPL_SONGLIST.replace('{TABLE}', da['results']).
  replace('{PREV_NUM}', prev).
  replace('{NEXT_NUM}', next).
  replace('{CURRENT_NUM}', current).
  replace('{TOTAL_NUM}', da.page_total);
```

如果模块代码中，使用其它全局变量想跳过JSLint的检查，可以在该文件中加入/global/声明。

`/*global alert: true, console: true, top: true, setTimeout: true */`

使用严格的条件判断符。用===代替==，用!==代替!=，避免掉入==造成的陷阱,在条件判断时，这样的一些值表示`false`

```js
null
undefined与null相等
字符串''
数字0
NaN
```

在==时，则会有一些让人难以理解的陷阱

```js
(function () {
    var undefined;
    undefined == null; // true
    1 == true; //true
    2 == true; // false
    0 == false; // true
    0 == ''; // true
    NaN == NaN;// false
    [] == false; // true
    [] == ![]; // true
})();
```

对于不同类型的 == 判断，有这样一些规则，顺序自上而下

```js
undefined与null相等
一个是number一个是string时，会尝试将string转换为number
尝试将boolean转换为number
0或1
尝试将Object转换成number或string
```

而这些取决于另外一个对比量，即值的类型，所以对于0、空字符串的判断，建议使用=== ===会先判断两边的值类型，类型不匹配时为false。 下面类型的对象不建议用new构造

```js
new Number
new String
new Boolean
new Object //用{}代替
new Array //用[]代替
```

引用对象成员用obj.prop代替obj[“prop”]，除非属性名是变量。 从number到string的转换。

```js
/** 推荐写法*/
var a = 1;
typeof(a); //"number"
console.log(a); //1
var aa=a+'';
typeof(aa); //"string"
console.log(aa); //'1'
/** 不推荐写法*/
new String(a)或a.toString()
```

从string到number的转换，使用parseInt，必须显式指定第二个参数的进制。

```js
/** 推荐写法*/
var a = '1';
var aa = parseInt(a,10);
typeof(a); //"string"
console.log(a); //'1'
typeof(aa); //"number"
console.log(aa); //1
```

从float到integer的转换

```js
/** 推荐写法*/
Math.floor/Math.round/Math.ceil
/** 不推荐写法*/
parseInt
```

字符串拼接应使用数组保存字符串片段，使用时调用join方法。避免使用+或+=的方式拼接较长的字符串，每个字符串都会使用一个小的内存片段，过多的内存片段会影响性能。

```js
/**推荐的拼接方式array的push、join*/
var str=[],
    list=['测试A','测试B'];
for (var i=0 , len=list.length; i < len; i++) {
    str.push( '<div>'+ list[i] + '</div>');
};
console.log(str.join('')); //<div>测试A</div><div>测试B</div>
/** 不推荐的拼接方式+=*/
var str = '',
    list=['测试A','测试B'];
for (var i = 0, len = list.length; i< len; i++) {
    str+='<div>' + list[i] + '</div>';
};
console.log(str); //<div>测试A</div><div>测试B</div>
```

尽量避免使用存在兼容性及消耗资源的方法或属性

`不要使用with，void，evil，eval_r，innerText`

注重HTML分离, 减小reflow, 注重性能

## 图片规范

命名应用小写英文、数字、_组合，便于团队其他成员理解

```js
header_btn.gif
header_btn2.gif
```

* 页面元素类图片均放入img文件夹,
* 测试用图片放于img/testimg文件夹，psd源图放入img/psdimg文件夹。
* 图片格式仅限于gif、png、jpg等。
* 用png图片做图片时,要求图片格式为png-8格式,若png-8实在影响图片质量或其中有半透明效果,请为ie-6单独定义背景，并尽量避免使用半透明的png图片。
* 背景图片请尽可能使用sprite技术, 减小http请求


## 注释规范：

> JAVASCRIPT、CSS文件注释需要标明作者、文件版本、创建/修改时间、重大版本修改记录、函数描述、文件版本、创建或者修改时间、功能、作者等信息。

`/* * 注释块 */`

中间可添加如下信息

```js
@file 文件名
@addon 把一个函数标记为另一个函数的扩张，另一个函数的定义不在源文件中
@argument 用大括号中的自变量类型描述一个自变量
@author 函数/类作者的姓名
@base 如果类是继承得来，定义提供的类名称
`@class`用来给一个类提供描述，不能用于构造器的文档中
@constructor 描述一个类的构造器
@deprecated 表示函数/类已被忽略
@exception 描述函数/类产生的一个错误
@exec @extends 表示派生出当前类的另一个类
@fileoverview 表示文档块将用于描述当前文件，这个标签应该放在其它任何标签之前
@final 指出函数/类
@ignore 让jsdoc忽视随后的代码
@link 类似于@link标签，用于连接许多其它页面
@member 定义随后的函数为提供的类名称的一个成员
@param 用大括号中的参数类型描述一个参数
@private 表示函数/类为私有，不应包含在生成的文档中
@requires 表示需要另一个函数/类
@return 描述一个函数的返回值
@see 连接到另一个函数/类
@throws 描述函数/类可能产生的错误
@type 指定函数/成员的返回类型
@version 函数/类的版本号
```

# 你不知道的js

## 原理篇

* `js`引擎线程（解释执行`js`代码、用户输入、网络请求）

* `GUI`线程（绘制用户界面、与`js`主线程是互斥的）

    * `JS 可以操作DOM元素，进而会影响到GUI的渲染结果，因此JS引擎线程与GUI渲染线程是互斥的。也就是说当JS引擎线程处于运行状态时，GUI渲染线程将处于冻结状态`

    * `js单线程-同一时间只能做一件事`

    * `js设计出来就是为了与用户交互，处理DOM，假如js是多线程，同一时间一个线程想要修改DOM，另一个线程想要删除DOM，问题就变得复杂多了，浏览器不知道听谁的，如果引入“锁”的机制，这不就又回到了被其他语言尴尬的困境了吗`

    * `单线程计算能力有限，大量数据需要计算渲染的话，我们可以配合后端进行操作，比如我们后期进阶班的VUE与node.js配合，也就是传说中的SSR技术`

* `http`网络请求线程（处理用户的`get、post`等请求，等返回结果后将回调函数推入任务队列）

* 定时触发器线程（`setTimeout、setInterval`等待时间结束后把执行函数推入任务队列中）

* 浏览器事件处理线程（将`click、mouse`等交互事件发生后将这些事件放入事件队列中）

### js运行机制

`JavaScript是基于单线程运行的，同时又可以异步执行的，一般来说这种即是单线程又是异步的语言都是基于事件来驱动的，恰好浏览器就给JavaScript提供了这么一个环境`

```js
                        任务进行执行栈
                             ｜
                             ｜
                             ｜
          ------------同步任务还是异步任务-----------
         ｜                                      ｜
         同步                                    异步
         ｜                                      ｜
         ｜                                      ｜
       主线程                                Event Table
         ｜                                      ｜
         ｜                                      ｜
         ｜                                  注册回调函数
    任务全部执行完毕                                ｜
         ｜                                       ｜
         |                                   Event Queue
         |                                        |
         |                                        |
         |     ___________________________________|
         |     |
读取任务队列中的结果，进入主线程执行
```

上面要表示的内容用文字来表述的话：

1. 同步和异步的任务分别进入不同的执行“场所”，同步的进入主线程，异步的进入`Event Table`并注册函数

2. 当指定的事情完成时，`Event Table`会将这个函数移入`Event Queue`

3. 主线程内的任务执行完毕为空，回去`Event Queue`读取对应的函数，进入主线程执行。

上述过程会不断的重复，也就是常说的`Event Loop`（事件循环）

### call、apply的模拟实现

```js
call的封装函数实现

Function.prototupe.newCall = function() {
    var ctx = arguments[0] || window;
    ctx.fn = this;
    var args = [];
    for(var i = 1;i < arguments.length;i ++) {
        args.push('arguments[' + i + ']');
    }
    var result = eval('ctx.fn(' + args.join(',') + ')')
    delete ctx.fn;
    return result;
}
```

```js
apply的封装函数实现

Function.prototype.newApply = function(ctx,arr) {
    var ctx = ctx || window;
    ctx.fn = this;
    if(!arr) {
        var result = ctx.fn();
        delete ctx.fn;
        return result;
    } else {
        var args = [];
        for(var i = 1;i < arr.length;i ++){
            args.push('arguments[' + i + ']');
        }
        var result = eval('ctx.fn(' + args.join(',') + ')')
        delete ctx.fn;
        return result;
    }
}
```
