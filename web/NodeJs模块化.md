---
title: NodeJs模块化
date: 2022-04-11 18:41:15
tags: NodeJs
categories:
  - NodeJs
---

# NodeJs模块化

- 第一部分
  - 后端的规范与思想
- 第二部分
  - 基础的API
- 第三部分
  - 常用的框架
- 第四部分（Web项目）
  - 接收Web请求
  - 处理业务逻辑
  - 文件操作
  - 数据库（MySql，MongoDB）
  - 反向代理服务器（IP哈希，轮询）

<!--more-->

## 后端的规范与思想

1. 分层
   1. Web层（接收和发送Http请求，判断，传给服务层，封装），又叫controller层
   2. 业务逻辑层（服务层，进行比较信息，XXXService）
   3. DAO层（数据访问对象）
      1. DataBase(DB):存数据
      2. 业务：对对象进行操作
      3. 如果要存储：对象转为数据
      4. 如果要读取：数据转为对象
   4. 持久层：存在磁盘上
      1. 文件，数据库
   5. Domain：实体层

2. 模块化
   1. ES6:支持导入和导出,ES3、ES5缺点：缺少模块化概念
   2. Js规范缺乏管理机制
   3. NPM

## node模块化

### node的导入与导出

导入

```js
require("模块")
```

导出

```js
module.exports = ...
exports = ...

//exports是module.exports的简写,都可以使用,但当二者遇到时,优先导出module.exports
```

示例

```js
// test.js

var a = 123
var b = 'abcd'

exports = a
module.exports = b
// 但当exports.a = a和module.exports.b = b这样使用时则module.export不会覆盖exports
```

```js
// index.js

const test = require("./test.js")
console.log(test) // abcd
```

注意: NodeJs是运行在一个函数中的，并不是一个全局函数

```js
// Nodejs的模块是运行在一个函数中的
// 把这些东西当作参数传入到函数中
// 函数名不知道是什么
// 同时参数顺序如下，可以通过console.log(arguments)查看
function xyz(exports, require, module, __filename, __dirname) {
  //---
  // 中间的内容是我们写的nodejs的代码
  //---
  // NodeJs的模块试运行在一个函数中的
}
```

```js
// console.log(arguments)
[Arguments] {
  '0': {}, //exports
  '1': [Function: require] {...}, // require
  '2': Module {}, //module
  '3': 'd:\\**\\filename.js', //__filename
  '4': 'd:\\**\\**\\dirname' //__dirname
}
```

## NodeAPI

### Net

> `net` 模块提供了异步的网络 API，用于创建基于流的 TCP 或 [IPC](http://nodejs.cn/api/net.html#ipc-support) 服务器 ([`net.createServer()`](http://nodejs.cn/api/net.html#netcreateserveroptions-connectionlistener)) 和客户端 ([`net.createConnection()`](http://nodejs.cn/api/net.html#netcreateconnection))。

`Net`模块可用于创建Socket服务器或Socket客户端。NodeJS 的数据通信，最基础的两个模块是 Net 和 Http，前者是基于 Tcp 的封装，后者本质还是 Tcp 层，只不过做了比较多的数据封装，我们视为表现层

![image-20220421102836497](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202204211035533.png)

- 使用

```js
const net = require('net')
```

- 创建Server层

```js
const server = net.createServer()
```

- 创建Client层

```js
const socket = net.createConnection(port，host)
或
const socket = net.connect(port，host)
```

- 在server端监听端口

```js
server.listen(port，host)
```

#### Server

##### 事件

- **listening**
  - 在调用 [`server.listen()`](http://nodejs.cn/api/net.html#serverlisten) 后绑定服务器时触发。

```js
server.on('listening', function () {
  console.log('服务已启动')
})
// 使用on绑定
```

- **connection**
  - 建立新连接时触发。 `socket` 是 `net.Socket` 的实例。
  - 当有client连接socket时触发

```js
// 参数socket,当连接时返回socket
server.on('connection', function(socket) {
  console.log('有新的连接')
})
```

- **close**
  - 当server端关闭时触发

```js
server.on('close',function() {})
```

- **error**
  - 当出现错误是触发

##### 方法

- **listen**
  - 在server端监听端口

```js
server.listen(port，host)
```

- **close**
  - 关闭server端

```js
server.close()
// 基本上不适用close关闭
```

- **address**
  - 返回server的地址

```js
console.log(server.address())
// { address: '127.0.0.1', family: 'IPv4', port: 3366 }
```

#### Socket

##### 事件

- **connect**
  - 当成功建立与server连接时触发。 

```js
// socket.js
socket.on('connect', function () {
  console.log('已连接到服务器')
})
```

- **data**

  - 接收到数据时触发。 参数 `data` 将是 `Buffer` 或 `String`。 数据的编码由 [`socket.setEncoding()`](http://nodejs.cn/api/net.html#socketsetencodingencoding) 设置。

    如果 `Socket` 触发 `'data'` 事件时没有监听器，则数据将丢失。

```js
// socket.js
var net = require('net')
var socket = net.connect(3366, '127.0.0.1')

// 接收server返回的消息
socket.on('data', function (data) {
  console.log(data.toString())
})

// 给server端发送数据
socket.write('你好，server端')
```

```js
// server.js
var net = require('net')
var server = net.createServer()

server.listen(3366, '127.0.0.1')

server.on('connection', function (socket) {
  // 连接后接收消息，返回socket端消息
  socket.on('data', function (data) {
    console.log(data.toString())
    socket.write('hello client')
  })
})
```

- **end**
  - 当连接传输结束时触发
- **timeout**
  - 当socket空闲超时触发，仅是表明socket已经空闲。用户必须手动关闭连接。
- **error**
  - 发生错误时触发。 `'close'` 事件将在此事件之后直接调用。

- **close**
  - 当socket端关闭时触发

##### 属性

- **remoteAddress**
  - 服务器地址

- **remotePort**
  - 服务器端口

- **localAddress**
  - 本地地址

- **localPort**
  - 本地端口

```js
// socket.js
socket.on('connect', function () {
  console.log('已连接到服务器')
  console.log(socket.remoteAddress)
  console.log(socket.remotePort)
  console.log(socket.localAddress)
  console.log(socket.localPort)
})

127.0.0.1 // 服务器地址
3366	  // 服务器端口
127.0.0.1 // 本地地址
51672	  // 本地端口
```




##### 方法

- **setTimeout**
  - socket闲置时间超过`timeout`毫秒后 ，将socket设置为超时。
  - 触发空闲超时事件时，socket将会收到`'timeout'`事件，但是连接不会被断开。用户必须手动调用`end()`或`destroy()`这个socket。
  - 如果`timeout`= 0，那么现有的闲置超时会被禁用
  - 可选的callback参数将会被添加成为'timeout'事件的一次性监听器。

- **write**
  - 向server端发送数据或向socket端返回数据
- **setEncoding**
  - 设置socket的编码为可读流。
- **end**
  - 关闭socket端服务方法

#### 获取响应头，返回数据

可以通过Net来进行浏览器之间的数据交互，在浏览器上进行访问server地址:端口来进行访问server，通过server端的操作来进行获取响应头以及返回数据

```js
const { Socket } = require('dgram')
var net = require('net')

var server = net.createServer()

// 端口12306,地址为127.0.0.1
server.listen(12306, '127.0.0.1')

server.on('listening', function () {
  console.log('服务已启动')
})

// 连接时进行触发
server.on('connection', function (socket) {
  console.log('有新的连接')
  // 当浏览器访问时返回Http报文
  socket.on('data', function (data) {
    console.log(data.toString())
    // 获取响应报文的url，进行split分割
    var request = data.toString().split('\r\n')
    // 获取数组中第一位进行分割获取url页面地址
    var url = request[0].split(' ')[1]
    console.log(url)
   	// 获取Http报文后，可以进行返回响应报文
    socket.write(`HTTP 200OK\r\n
    			  Content-type:text/html\r\n
    			  ServerDWS/1.1\r\n
    			  <html><body>hello</body></html>`)
  })
})

// 浏览器端输入127.0.0.1:12306/abc
// 后面的abc是为了查看报文可以进行交互
```

### fs

> `fs` 模块支持以标准 POSIX 函数建模的方式与文件系统进行交互。

#### 写入文件

- fs.writeFileSync
  - 同步

```js
import fs from "fs";

try {
   fs.writeFileSync('message.txt',data) 
} catch(e) {
    throw e;
}
```

- fs.writeFile
  - 异步

```js
import fs from 'fs';

fs.writeFile('message.txt', data, (err,data) => {
  if (err) throw err;
  console.log(data);
});
```

- fs.appendFile
  - 可读可写

```js
import fs from 'fs';

fs.appendFile(fileName, data + '\n', { flag: 'a' }, function (err,data) {
    if(err) throw err;
    console.log(data)
})
```

#### fs.open

> 打开文件

```js
/**
 * [open 打开文件]
 * path      [path 文件路径]
 * flags     [flags 文件打开行为]
 * mode      [mode 设置文件模式(权限)，文件创建默认权限为 0666(可读，可写)。]
 * callback  [callback 回调函数]
 */
fs.open(path, flags[, mode], callback)
```

- flags参数为以下值

| Flag | 描述                                           | 可读 | 可写 | 可创建 | 可追加 |
| :--- | :--------------------------------------------- | :--: | :--: | :----: | :----: |
| r    | 以读取模式打开文件，如果文件不存在则抛出异常   |  √   |      |        |        |
| r+   | 以读写模式打开文件，如果文件不存在则抛出异常   |  √   |  √   |        |        |
| rs   | 以同步的方式读取文件                           |  √   |      |        |        |
| rs+  | 以同步方式读取和写入文件                       |  √   |  √   |        |        |
| w    | 以写入模式打开文件，如果文件不存在则创建       |      |  √   |   √    |        |
| wx   | 类似'w'，但是如果文件路径存在，则文件写入失败  |      |  √   |   √    |        |
| w+   | 以读写模式打开文件，如果文件不存在则创建       |  √   |  √   |   √    |        |
| wx+  | 类似'w+'，如果文件路径存在，则写入失败         |  √   |  √   |        |        |
| a    | 以追加模式打开文件，如果文件不存在则创建       |      |  √   |   √    |   √    |
| ax   | 类似'a',但如果文件路径存在，则文件追加失败     |      |  √   |   √    |   √    |
| a+   | 以读取追加模式打开文件，如果文件不存在则创建   |  √   |  √   |   √    |   √    |
| ax+  | 类似'a+'，如果文件路径存在，则文件读取追加失败 |  √   |  √   |   √    |   √    |

```js
var fs = require('fs')

//异步打开文件
fs.open("message.txt","r+",function(err,fd) {
    if(err) throw err
    console.log("打开成功")
})
```



