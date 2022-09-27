---
title: HTML5 & CSS3
date: 2021-11-08 15:35:53
tags: 
  - HTML and CSS
categories:
  - HTML and CSS
---

# HTML5

## HTML5结构
---

- `HTML5` 是新一代的 `HTML`
- `DTD`声明改变	`<!DOCTYPE html>`
  
    - 新的结构标签			
    

```html
  <!--文档申明 文档类型申明，html代表html5的文档类型-->
  <!DOCTYPE html>
  <html>
  <!--字符编码，charset='utf-8'-->
    <meta charset='utf-8'>
  <!--
  	版本兼容
  
  		1.省略引号，当属性值（<、>、=、单引号、双引号、空字符串）时，属性两边的引号可以省略，如<input type=text>
  
  		2.省略属性值，具有布尔值的属性，比如disabled，readonly，致谢属性值代表true，如：<input type=checkbox checked>
  -->
    <head>
    </head>
    <body>
    </body>
  </html>
  		
```

<!--more-->


### 常用的一些新的结构标签

---

- 结构标签：（块状标签）有意义的`div`
  - `header`：标记定义一个页面或一个区域的头部
  - `footer`：标记定义一个页面或一个区域的底部
  - `nav`：标记定义导航链接
  - `article`：标记定义一篇文章
  - `section`：标记定义一个区域
  - `aside`：侧边栏导航
  - `hgroup`：标记定义文件中一个区块的相关信息
  - `flgure`：标记定义一组媒体内容以及它们的标题（图像）
  - `figcaption`：标签定义`figure`元素的标题
- 多媒体交互标签
  - `video`：标记定义一个视频
  - `audio`：标记定义音频内容
  - `source`：标记定义媒体资源
  - `canvas`：标记定义画布（图片）
  - `embed`：标记定义外部的可交互的内容或插件，比如`flash`
- 特殊样式标签
  - `mark`：突出显示文字
  - `meter`：刻度百分占比
  - `progress`：进度条
  - `wbr`：长单词换行位置

- 兼容性不是很好的标签
  - `dialog`：定义一个对话框
  - `bdi`：单独设置文字播放方式（`dir='rti' dir='ltr'`）
  - `details / summary`：描述部分的详情`summary`为`details`的标题
  - `wbr`：长单词换行位置
  - `datalist`

- 补充说明
  - `small` 这个元素表示边栏评论，如附属细则
  - `cite`这个元素可用于显示作品标题（图书、电影、诗歌等）
  - `adress`这个元素显示`article`或整个文档的合同信息，且位于`footer`这个元素之中
  - `time`显示人和机器可读的日期和时间，而且机器可读的时间戳是属性`datetime`的值第二个可选的是`pubtime`用于表示出版日期值

### 删除的`HTML`标签
---

- 纯表现的元素：
    - `basefont`
    - `big`
    - `center`
    - `font`
    - `s`
    - `strike`
    - `tt`
    - `u`
- 对可用性产生负面影响的元素：
    - `frame`
    - `frameset`
    - `noframes`
  - 产生混淆的元素：
    - `acronym`
    - `applet`
    - `isindex`
    - `dir`
- **重新定义的`HTML`标签**
  - `<b>`  代表内联文本，通常是粗体，没有传递表示重要的意思
  - `<i> ` 代表内联文本，通常是斜体，没有传递表示重要的意思
  - `<dd>` 可以同`details`与`figure`一同使用，定义包含文本，`ialog`也可用
  - `<dt>` 可以同`details`与`figure`一同使用，汇总细节，`dialog`也可用
  - `<hr> `表示主题结束，而不是水平线，虽然显示相同
  - `<menu>` 重新定义用户界面的菜单，配合`commond`或者`menuitem`使用
  - `<small>` 表示小字体，例如打印注释或者法律条款
  - `<strong>` 表示重要性而不是强调符号

- 崭新新的页面布局

![传统的布局](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111700992.jpg)

![实例-from-dunitian](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111700528.png)

![草图--from-dunitian](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111700486.png)

## HTML5智能表单
---

### HTML4.01 form表单复习
---

- `input`表单`type`属性值
    - `type="text"  `          单行文本输入框
    - `type="password" `  密码（`maxlength=""`）
    - `type="radio"   `       单项选择（`checked="checked"`）
    - `type="checkbox" `  多项选择
    - `type="button" `     按钮
    - `type="submit"`	     提交
    - `type="file"`           上传文件
    - `type="reset"	 `    重置

### HTML5智能表单
---

- `input`表单`type`属性值：
    - `type="email" ` 限制用户输入必须为`Email`类型
    - `type="url"`	      限制用户输入必须为`URL`类型
    - `type="date" `     限制用户输入必须为日期类型
    - `type="datetime"` 显示完整日期 含时区
    - `type="datetime-local" ` 显示完整日期 不含时区
    - `type="time"  `    限制用户输入必须为时间类型
    - `type="month" `  限制用户输入必须为月类型
    - `type="week" `    限制用户输入必须为周类型
    - `type="number"` 限制用户输入必须为数字类型
    - `type="range"`    生成一个滑动条
    - `type="search"`  具有搜索意义的表单`results="n"`属性
    - `type="color" `    生成一个颜色选择表单
    - `type="tel" `    显示电话号码


### Input 类型 - Date Pickers（日期选择器）
---

- **`HTML5` 拥有多个可供选取日期和时间的新输入类型：
- `date` 选取日、月、年
- `month` 选取月、年
- `week`  选取周和年
- `time `  选取时间（小时和分钟）

- 以下两个没有作用
    - `datetime`  选取时间、日、月、年（UTC 时间）
    - `datetime-local`  选取时间、日、月、年（本地时间）

### HTML5新增表单属性
---
- `required:` `required `内容不能为空
- `placeholder:` 表单提示信息
- `autofocus:`自动聚焦
- `pattern:` 正则表达式  输入的内容必须匹配到指定正则范围
- `autocomplete:`是否保存用户输入值
   - 默认为`on`，关闭提示选择`off`
- `formaction:` 在`submit`里定义提交地址
- `datalist:` 输入框选择列表配合`list`使用 ` list`值为`datalist`的`id`值
- `output:` 计算或脚本输出

### 表单验证
---

- `validity`对象，通过下面的`valid`可以查看验证是否通过，如果八种验证都返回`true`,一种验证失败返回`false`

    - `oText.addEventListener("invalid",fn1,false)`
    - `ev.preventDefault()`: 阻止默认事件
    - `valueMissing`: 当输入值为空的时候，返回`true`
    - `typeMismatch`: 控件值与预期不吻合，返回`true`
    - `patternMismatch`: 输入值不满足`pattern`正则，返回`true`
    - `cusomError`
      - `setCustomValidity()`

## audio/video

- 视频音频格式的简单介绍
  - 常见的视频格式
    - 视频的组成部分：画面、音频、编码格式
    - 视频编码：`H.264`、`Theora`、`VP8`(`google`开源)
  - 常见的音频格式
    - 视频编码：`ACC`、`MP3`、`Vorbis`

- `HTML5`能在完全脱离插件的情况下播放音视频,但是不是所有格式都支持。

- **支持的视频格式：**
  - `Ogg=`带有`Theora`视频编码`+Vorbis`音频编码的`Ogg`文件
  - `MEPG4=`带有`H.264`视频编码`+AAC`音频编码的`MPEG4`文件
  - `WebM=`带有`VP8`视频编码`+Vorbis`音频编码的`WebM`格式

### 基础用法

- 单独用法

  - `<audio id="audio" src="./成都.mp3"></audio>`
  - `<video id="video" src="./成都.mp4"></video>`
  - 注意：`video`和`audio`的方法属性和事件是共有的

- 多类型资源，兼容方法


```html
<audio id='music'>
    <source src='./成都.mp3' type='audio/mpeg'>
    <source src='成都.ogg' type='audio/ogg'>
    您的浏览器暂不支持audio标签。播放音乐
</audio>

<video controls="controls"  width="300">
    <source src='./成都.mp4' type='video/mpeg'>
    <source src='成都.avi' type='video/ogg'>
    您的浏览器暂不支持video标签。播放视频
</video>
```

### 标签属性

- 例：`<video id="video" src="./成都.mp4" 属性1 属性2 属性……></video>`

- `autoplay` ：播放

- `controls`：显示控件

- `preload(none/metadata/auto)`：预加载

  - `node`：不需要加载数据
  - `metadata`：元数据，诸如时长、比特率、帧大小这样的原数据而不是媒体内容需要加载的
  - `auto`：浏览器应当加载它认为适量的媒体内容
  - `<video id="video" src="***.mp4" preload='auto'></video>`

- `loop`：是否循环播放视频

- `poster（video独有）`：当视频不可用时，使用一张图片替代，否则是空白

  - `<video src="成都.mp4" poster="***.jpg" controls></video>`

- 脚本化


```js
var audio = document.getElementById('audio');
var audio = new Audio('./laojie.mp3');
var video= document.createElement('video');

//audio可以通过new来创建，video不可以通过new来创建
```

- 设置属性值

  - `controls = true`
  - `loop = 'loop'`
  - `preload = 'none/metadata/auto'`
  - `autoplay = true`
  - `currentSrc = '媒体数据的url地址'`

### 方法

- `play()`：播放方法，方法运行后播放

- `pause()`：暂停方法，方法运行后暂停

- `load()`：重新加载视频/音频，用于在更改来源或其他设置后对音频/视频元素进行更新

- `addTextTrack()`：向音频/视频添加新的文本轨道

- `canPlayType()`

  - 检测浏览器是否能播放指定的音频/视频类型


```js
var a = new Audio();
if(a.canPlayType("audio/mp3")){
    a.src="./成都.mp3";
    a.play();
}
```

### 属性

- **playbackRate**
  - 播放速率，用于指定媒体播放的速度，该属性值为`1.0`表示正常速度，大于`1`则表示快进，`0~1`之间表示慢放，负值表示回放
  - 每个浏览器实现的会有差别，具体看浏览器实现
- **volume**：
  - 调整音量大小，介于`0`（静音）——`1`（最大音量）之间，默认为`1`，将`muted`属性设置为`true`则会进入静音模式，设置为`false`则会恢复之前指定音量继续播放
  - 超过范围会报错`[0,1]`
- **currentTIme / duration**

  - `currentTime`：设置或返回音频/视频播放的时间位置
  - `duration`：返回当前音频/视频的时长（`window.onload`），单位：秒
- **played / buffered / seekable**

  - `played`：返回已经播放的时间段
  - `buffered`：返回当前已经缓冲的时间段
    - 确定当前缓存内容的百分比
    - `Math.floor(song.buffered.end(0) / song.duration*100);`
  - `seekable`：返回用户可以跳转的时间段
  - *注意：*这三个属性都是`TImeRanges`对象，每个对象都有一个`length`属性以及`start()`和`end()`方法，`length`属性表示当前的一个时间段，`start()`与`end()`分别返回当前时间段的起始时间点和结束时间点（单位是秒，起始参数是`0`）
- **paused / seeking / ended**

  - `paused`：为`true`表示播放器暂停
  - `seeking`：为`true`表示播放器正在调到一个新的播放点，它是一个事件
  - `ended`：如果播放器播放完并且停下来，则属性为`true`
- **preload**：是否预加载视频/音频
- [更多属性](https://techbrood.com/tagsref?p=ref-av-dom)


### 事件

- 事件是当达到某个条件的时候会触发这个事件
- `play`：开始播放的时候触发事件
- `pause`：暂停播放的时候触发事件
- `loadedmetadata`：浏览器获取完媒体的元数据触发
- `loadeddata`：浏览器已经加载完当前帧数据，准备播放时触发，注意兼容`IE8`
- `ended`：当前播放结束后触发
- `readyState`：音频当前就绪状态
  - 表示音频元素的当前网络状态
  - `0 = NETWORK_EMPTY - 音频尚未初始化`
  - `1 = NETWORK_lDLE - 音频是活动的且选取资源，但并未使用网络`
  - `2 = NETWORK_LOADING - 浏览器正在下载数据`
  - `3 = NETWORK_NO_SOURCE - 未找到音频来源`
- `error`：在音频/视频`(audio/video)`加载发生错误时触发
  - `MediaError`对象的`code`属性返回一个数字值，它表示音频 / 视频的错误状态
  - `1 = MEDIA_ERR_ABORTED - 取回过程被用户中止`
  - `2 = MEDIA_ERR_NETWORK - 当下载时发生错误`
  - `3 = MEDIA_ERR_DECODE - 当解码时发生错误`
  - `4 = MEDIA_ERR_SRC_NOT_SUPPORTED - 不支持音频/视频`
- [更多事件](

## canvas

- 标签 `<canvas>`
  - 不支持`canvas` 的浏览器可以看到的内容
  - 注意：`canvas`宽高需要设置在标签中 否则绘制的东西可能出错

- `canvas`的应用场景
  - 游戏
  - 图表
  - 动画
  - `codepen.io`(`HTML5`动效)
- `canvas`发展历史
  - 最早在`apple`的`safari1.3`中引入
  - ie9之前的浏览器不支持`canvas`
  - http://caniuse.com/

### 使用canvas

- `canvas`标签（画布）
  
  - `<canvas width='' height=''></canvas>`
  
- 获取`canvas`元素
  - `var canvas = document.getElementsById('mycanvas')`

- 获得`canvas`上下文对象（画笔）
  - `var ctx = canvas.getContext('2d');`
  - 因为`canvas`是画`2d`图形的
  - `WebGL`绘图是画`3d`图形的
  
- 注意：
  - 元素对象（`canvas`元素）和上下文对象（通过`getContext('2d')`⽅方法获取到的`CanvasRenderingContext2D`对象）
  - 元素对象相当于我们的画布，上下文对象相当于画笔，我们接下来的所有操作是基于上下文对象的

- `ctx`是画笔，就是`canvas`的上下文对象


```javascript
<!-- 画布 -->
<canvas id='myCanvas' width='' height=''></canvas>

<script>
    var myCanvas = document.getElementById('myCanvas'); //获取canvas对象
	var ctx = myCanvas.getContext('2d'); //获取mycanvas的上下文对象
</script>
```

### 线段

- `moveTo(x,y)`：起始坐标点`x，y`（将触笔移动到`x,y`点）
- `lineTo(x,y)`：从起始点绘制到`x,y`点
- `stroke()`：触笔方法 画线  默认为黑色
- `closePath()`：闭合当前路径，和回到起始点的区别
- `fill()`：填充方法
- `fillStyle = color`：更改填充颜色
- `strokeStyle = color`：更改线段颜色
- `lineWidth = size`：设置线段宽度
- `beginPath()`：结束路径，开启一段新的路径
- `save()`：保存当前画布
- `restore()`：释放`save()`保存的画布
- 重点
  - `fill`和`stroke`方法都是作用在当前的所有子路径
  - 完成一条路径后要重新开始另一条路径时必须使用`beginPath()`方法, `betinPath`开始子路径的一个新的集合

### 矩形

- `rect(x,y,w,h)`：创建一个矩形
  - `x,y`代表起始点，`w,h`代表宽高
- `fillRect(x,y,w,h)`：绘制填充的矩形
- `strokeRect(x,y,w,h)`：绘制空心矩形（无填充）
- `clearRect(x,y,w,h)`：擦除当前矩形区域
  - `x,y`代表起始点，`w,h`代表宽高
- 注意：
  - `fillRect`和`strokeRect`都会自动结束路径

### 曲线

#### 弧度

- `arc(起始x位置,起始y位置,半径,起始弧度,结束弧度,弧形的方向)`：弧度
  - `ctx.arc(250,250,100,0,Math.PI()/2,0)`
  - 弧度的方向，`0`顺时针`1`逆时针
- `arcTo(x1,y1,x2,y2,r)`：画布上创建介于两个切线之间的弧/曲线
  - `x1`,`y1` 坐标一  
  - `x2`,`y2`坐标二   
  - `r`：圆弧半斤
  - 绘制的弧线与当前点和`x1,y1`连线，`x1,y1`和`x2,y2`连线都相切

#### 贝塞尔曲线

- `quadraticCurveTo(x1,y1,ex,ey)`：二次贝塞尔曲线
  - `x1,y1`：控制点
  - `ex,ey`：结束点
- `bezierCurveTo(x1,y1,x2,y2,ex,ey)`：三次贝塞尔曲线
  - `x1,y1,x2,y2`：控制点
  - `ex,ey`：结束点

### 坐标轴转换

- `translate(x,y)`：重新映射画布上的(0,0)位置
  - 移动整张画布的位置
- `scale(sx,sy)`：缩放当前`canvas`绘图
- `rotate(Math.PI)`：旋转当前的绘图，`弧度公式=角度*PI/180`
- `setTransform(a,b,c,d,e,f)`：先重置画布再转换
  - 参数：`setTransform(水平旋转,水平倾斜,垂直倾斜,垂直缩放,水平移动,垂直移动)`
- `transform(a,b,c,d,e,f)`：不重置画布转换，和`setTransfrom`差不多

### 填充图案

- `createPattern(image,'repeat|repeat-x|repeat-y|no-repeat')`

- 不止可以添加`img`元素，还可以添加`canvas`元素


```javascript
img元素(image对象),canvas元素，video元素（有图型的）

<canvas id="canvas1" width="500" height="500"></canvas>

var oCanvas1 = document.getElementById('canvas1');
var ctx = oCanvas1.getContext('2d');
var w = oCanvas1.width; //画布的宽
var h = oCanvas1.height; //画布的高

var oImg = new Image();
oImg.src = '图片的路径';

oImg.onload = function() {
    var fill = ctx.createPattern(oImg,'repeat');//oImg元素和是否重复
    ctx.fillStyle = fill;
    ctx.fillRect(0,0,w,h); //坐标点和宽高
}
```

### 渐变

- `createLinearGradient(x1,y1,x2,y2)`：线性渐变

  - `x1`,`y1`起始坐标点
  - `x2`,`y2`结束坐标点
  - 线性渐变，必须在填充渐变的区域里定义渐变，否则没有效果

- `createRedialGradient(x1,y1,r1,x2,y2,r2)`：径向渐变

  - `x1`,`y1`,`r1`内圆坐标及半径

  - `x2`,`y2`,`r2`外圆坐标及半径

  - `addColorStop`(位置,颜色)  位置:渐变点  `0-1`之间 可多个

  - `bg.addColorStop(p,color)` ：添加颜色


```javascript
//线性渐变
<canvas id="canvas1" width="500" height="500"></canvas>

var oCanvas1 = document.getElementById('canvas1');
var ctx = oCanvas1.getContext('2d');
var w = oCanvas1.width; //画布的宽
var h = oCanvas1.height; //画布的高
var bg = ctx.createLinearGradient(0,0,0,h); //背景渐变

bg.addColorStop(0,'red'); 
bg.addColorStop(1,'green');
ctx.fillStyle = bg;
ctx.fillRect(0,0,w,h);

//径向渐变
<canvas id="canvas1" width="500" height="500"></canvas>

var oCanvas1 = document.getElementById('canvas1');
var ctx = oCanvas1.getContext('2d');
var w = oCanvas1.width; //画布的宽
var h = oCanvas1.height; //画布的高
var bg = ctx.createRadialGradient(250,250,50,250,250,100);

bg.addColorStop(0,'red');
bg.addColorStop(0.5,'green');
bg.addColorStop(1,'white');
ctx.fillStyle = bg;
ctx.fillRect(0,0,500,500);
```

### 阴影

- `ctx.shadowColor = color`：阴影颜色，默认颜色：`rgba(0,0,0,0);`
- `ctx.shadowOffsetX = x`：阴影`x`轴偏移量
- `ctx.shadowOffsetY = y`：阴影`y`轴偏移量
- `ctx.shadowBlur`：阴影模糊程度
- 这里的阴影偏移量不受坐标系变幻的影响

### 文本

- `ctx.fillText(text,x,y,[,maxWidth])`：文本填充
  - 参数值：`text`:文本，`x,y`为坐标轴，`[,maxWidth]`:最大文本宽度
- `ctx.strokeText(text,x,y,[,maxWidth])`：描边字体（空心文本）
  - 参数值：`text`:文本，`x,y`为坐标轴，`[,maxWidth]`:最大文本宽度
- `ctx.measureText(text)`：测量文本尺寸
  - `text`：文字
- `ctx.font = '字体大小 字体类型'`：尺寸、字体缺一不可
- 文本对齐方式
  - `ctx.textBaseline`：垂直方向
  - `ctx.textAline`：水平方向
  - 下图中小圆点就是x,y轴的起始位置，可以用`textBaseline`和`textAlign`更改圆点的位置
  - `x,y`轴从字体的左下角开始
  - ![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111700800.jpg)

### 线段样式

- `lineCap`：端点样式
  - `butt`(默认值),`round`(圆角),`square`(高度多出线宽一半)
- `lineJoin`：边界连接点样式
  - 属性：`miter`(默认值),`round`(圆角),`bevel`(斜角)

- ![样式](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111700725.jpg)

- `ctx.miterLimit;`
  - 当`lineJoin`是`miter`时，用于控制斜接部分的长度
  - 如果斜接长度超过 `miterLimit` 的值，变成`bevel`
  - 注:实际运算是大于`limit*lineWidth/2`的值，了解就好

### 裁剪

- `ctx.clip()`：当前路径外的区域不再绘制


```javascript
var oCanvas1 = document.getElementById('canvas1');
var ctx = oCanvas1.getContext('2d');

ctx.beginPath()
ctx.arc(200,200,50,0,Math.PI*2,0);
ctx.closePath();
ctx.clip();
ctx.fillRect(100,100,300,300);
```

- 注：可在`clip()` 前用 `save()` 方法保存，后续通过 `restore()` 方法恢复

### 合成

- `ctx.globalAlpha = 0-1`：全局透明度
- `ctx.globalCompositeOperation = 'source-over'`：新像素和原像素的合并方式
  - `11`种值，默认`source-over`，`w3c`标准

- ```javascript
  var oCanvas1 = document.getElementById('canvas1');
  var ctx = oCanvas1.getContext('2d');
  
  ctx.fillStyle = 'red';
  ctx.fillRect(100,100,100,100);
  ctx.globalCompositeOperation = 'source-in'; //需要放在新像素和旧像素之间
  ctx.fillStyle = 'green';
  ctx.arc(180,180,50,0,Math.PI*2);
  ctx.fill();
  
- | 属性值             | 作用                                                         |
  | ------------------ | ------------------------------------------------------------ |
  | `source-over`      | 默认值，将新图形画在旧图形之上                               |
  | `destination-over` | 将新图形画在旧图形之下                                       |
  | `source-in`        | 只保留新的，旧图形重叠的新图形区域，其余皆变透明             |
  | `destination-in`   | 只保留新，旧图形重叠的旧图形区域，其余皆变为透明             |
  | `source-out`       | 只保留新，旧图形非重叠的新图形区域，其余皆变为透明           |
  | `destination-out`  | 只保留新，旧图形非重叠的旧图形区域，其余皆变透明             |
  | `source-atop`      | 新图形只放置在新，旧图形重叠的新图形区域，然后盖在旧图形之上 |
  | `destination-atop` | 旧图形只保留在新，旧图形重叠的旧图形区域，然后盖在新图形之上 |
  | `lighter`          | 新旧图形重叠区域的颜色，由新，旧图形的颜色码相加而得         |
  | `darker`           | 新旧图形重叠区域的颜色，由新，旧图形的颜色代码相减而得       |
  | `xor`              | 新旧图形重叠区域设置透明                                     |
  | `copy`             | 移除其他图形，只保留新图形                                   |

### 绘制图片

- `ctx.drawImage();` 

  - 第1个参数是`img(Image/canvas/video)` 注：`onload`调用
  - 填2、3个参数 `(x, y)`：起始点坐标
  - 填4、5个参数 `(x, y, dx, dy)` ：起始点坐标及图片所存区域的宽高
  - 填2-9个参数 `(x1, y1, dx1, dy1, x2, y2, dx2, dy2)` 
    -  前四个为控制所绘制目标元素的起始点和宽高
    -  前四个写完之后，可以插入后面四个参数写的区域里面
    -  后四个为控制`canvas`绘制的起始点和大小


```js
<img src="./demo/js/slideBox/carousel/img/2.jpg" alt="" id="myImg">

<script>
    var myCanvas = document.getElementById('myCanvas');
    var ctx = myCanvas.getContext('2d');

    var myImg = document.getElementById('myImg');
    myImg.onload = function() {
        ctx.drawImage(myImg,80,80,80,80,300,300,200,200);
        //ctx.drawImage(图片，x坐标轴，y坐标轴，宽，高，canvas的x标轴，canvas的y轴，宽，高)
    }
</script>
```

- 设置背景
  - `createPattern(img,平铺方式)`
  - 平铺方式:`repeat`,`repeat-x`,`repeat-y`,`no-repeat`

### 将canvas内容导出

- `canvas.toDataURL()`

- 是`canvas`自身的方法不是上下文对象

- 将`canvas`的内容抽取成一张图片， `base64`编码格式

- 注：同源策略的显示

- 将`canvas`的内容放入`img`元素里


```js
var myCanvas = document.getElementById('myCanvas');
var ctx = myCanvas.getContext('2d');

var oImg = new Image(); //声明了图片对象

ctx.arc(250,250,50,0,Math.PI*2,0);
ctx.fillStyle = 'red';
ctx.fill();
ctx.closePath();
ctx.stroke();

var data = myCanvas.toDataURL(); //把canvas转换为base64编码格式的图片信息

oImg.src = data; //让img图片的src等于data数据
document.body.appendChild(oImg);
```

### 获取canvas像素信息

- `ctx.getImageData(x,y,w,h)`：返回`ImageData`对象

  - `getImageData()`方法返回`ImageData`对象，该对象为画布上指定的矩形复制像素数据。
  - 参数：
    - `x`：开始左上角`x`坐标
    - `y`：开始左上角`y`坐标
    - `w`：返回的矩形区域的宽度
    - `h`：返回的矩形区域的高度
  - 对于 `ImageData` 对象中的每个像素，都存在着四方面的信息，即 `RGBA` 值：
    - **R** - 红色 `(0-255)`
    - **G** - 绿色 `(0-255)`
    - **B** - 蓝色 `(0-255)`
    - **A** - alpha 通道 `(0-255; 0 是透明的，255 是完全可见的)`

- `ctx.createImageData(w,h)`：创建新的空白`ImageData`对象

- `ctx.putImageData(imgData,x,y)`：将图像数据放回画布上

  - 一般将处理完成的`getImageData()`数据放回`canvas`中


```js
//白色变成灰色
var myCanvas = document.getElementById('myCanvas');
var ctx = myCanvas.getContext('2d');

ctx.fillRect(0,0,500,500);
var pixel = ctx.getImageData(0,0,10,10);//获取画布的像素数据
var row = pixel.width;
var col = pixel.height;
var d = pixel.data;

for(var i = 0;i < row; i++){
    var c = i * col * 4;
    for(var j = 0;j < col; j++){
        d[c + j * 4 + 3] = 100;
    }
}
//将处理过的数据放回canvas
ctx.putImageData(pixel,10,10);
```

### 命中检测

- `ctx.isPointInPath(x,y)`：检测是否在区域内，`chrome`与`safari`的区别

- `ctx.isPointInStroke(x,y)`：检测是否在线上

- 还可以通过检测当前点的像素值，如果为透明，则该点不在路径上


```javascript
var myCanvas = document.getElementById('myCanvas');
var ctx = myCanvas.getContext('2d');

ctx.moveTo(100,100);
ctx.lineTo(200,100);
ctx.lineTo(200,200);
ctx.closePath();
ctx.stroke();

console.log(ctx.isPointInPath(180,120));
console.log(ctx.isPointInStroke(200,200));
```

### 非零绕数准则

- 判断点`p`是否在多边形内，从点`p`向外做一条射线（可以任意方向），多边形的边从左到右经过射线时环绕数减`1`，多边形的边从右往左经过射线时环绕数加`1`，最后环数不为`0`，即表示在多边形内部。  

![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111701073.jpg)

### 如何解决canvas高分屏模糊问题

- 在分辨率比较高的屏幕，例如`ip6/6s/mac`等机器上，因为`canvs`绘制的是位图，所以会导致模糊，解决方法是根据屏幕分辨率修改`canvas`样式代码中的宽和高与`canvas`的`width`和`height`属性的比例


- 扩展阅读
	- [canvas学习之API整理笔记（一）](http://luckykun.com/work/2016-09-01/canvas-study01.html)
	- [HTML5 API大盘点](http://jartto.wang/2016/07/25/make-an-inventory-of-html5-api/)

## svg

- `Scalable Vector Graphics`：可缩放矢量图形
- 应用场景
  - 图表
  - 图标`icon`
  - 动效
  - 矢量图

### 使用svg

- 方式一：

```html
<?xml version="1.1" encoding="utf-8"?>
<!DOCTYPE svg 
PUBLIC "-//W3C//DTD SVG 1.1//EN"  "http://www.w3.org/
Graphics/SVG/1.1/DTD/svg11.dtd">
<svg xmlns="http://www.w3.org/2000/svg"></svg> 
```

- 方式二：
  - 图片、背景、框架
- 方式三: 
  - `html`页面中添加`svg`

```html
<svg width='500' height='500'>
    <line></line>
    ···
</svg>
```

### 形状标签

> > 所有的线段和路径都需要使用stroke属性来添加颜色

- **line：线条**
  - `<line></line>`
  - `x1`，`y1`：起始`x、y`点
  - `x2`，`y2`：终点`x、y`点
  - 例：`<line x1=100 y1=100 x2=200 y2=100></line>`

- **rect：矩形**
  - `<rect></rect>`
  - `x，y`：起始点
  - `width，height`：宽高
  - `rx，ry`：`x，y`轴上面的圆角
  - 例：`<rect x=200 y=200 width=100 height=100 rx=10 ry=30></rect>`
- **circle：圆形**
  - `<circle></circle>`
  - `r`:圆的半径
  - `cx，cy`:`x，y`的坐标点，圆的中心点
  - 例：`<circle r=50 cx=250 cy=250></circle>`
- **ellipse：椭圆**
  - `<ellipse></ellipse>`
  - `rx，ry`：圆在`x，y`轴的半径
  - `cx，cy`：`x，y`的坐标点，圆的中心点
  - 例：`<ellipse rx=50 ry=100 cx=250 cy=250></ellipse>`
- **polyline：折线**
  - `<polyline></polyline>`
  - `points`:点坐标（`x1 y1 x2 y2...`）或(`x1,y1,x2,y2....`)	
  - `x`代表起始点，`y`代表终止点
  - 点和点连接起来，形成一条折线
  - 例：`<polyline points="60 50, 75 35, 100 50, 125 35, 150 50,175 35, 190 50"></polyline>`
- **polygon：多边形**
  - `<polygon></polygon>`
  - `points`:点坐标（`x1 y1 x2 y2...`）或(`x1,y1,x2,y2....`)	
  - `x`代表起始点，`y`代表终止点
  - 折线闭合  `fill-rule:evenodd/nonzero`;
  - 点和点连接起来，形成一条折线，最后一个点和第一个点闭合，形成多边形
  - 例：`<polygon points="60 50, 75 35, 100 50, 125 35, 150 50,175 35, 190 50"></polygon>`
- **text：文本**
  - `<text></text>`
  - `x，y`：起始点，在`x，y`的那个点进行书写
  - 例：`<text x=100 y=100></text>`
- **g：组合对象的容器**
  - 添加到`g`元素上的变换会应用到其所有的子元素上。添加到`g`元素的属性会被其所有的子元素继承。此外，`g`元素也可以用来定义复杂的对象，之后可以通过`use`元素来引用它们

### 样式属性

> > 所有的样式属性要在css进行设置
> >
> > > 所有的线段和路径都需要使用stroke属性来添加描边颜色

- **fill**：填充颜色
- **stroke**：描边颜色
- **stroke-width**：描边宽度
- **stroke-opacity**：描边透明度
- **stroke-dasharray**：描边虚线
  - `<path stroke-dasharray="10,10" d="M 5 40 l 215 0" />`
- **stroke-dashoffset**：描边向左右缩进
- **fill-opacity**：填充透明度
- **stroke-linecap**：线的两端样式
  - `butt`：默认值
  - `round`：多出来线宽的一半变成半圆
  - `square`：两端多出来线宽的一半
- **stroke-lineJoin**：边界连接点样式
  - `bevel`：斜角
  - `round`：圆角
  - `miter`：默认值

### path元素

- **路径的意思**

  > 指令也区分大小写，大写的指令是绝对定位，小写的指令是相对定位，相对于元素进行多少个像素进行移动
  >
  > > path元素使用d属性来控制路径，如：<path d=""></path>
  > >
  > > > 所有的指令大写的指令为绝对坐标（具体的坐标位置）
  > > >
  > > > 小写的指令为相对位置（相对于起始坐标点的具体长度）

#### M和L指令

- `M`指令：`moveTo`的意思，画笔初始的位置
- `L`指令：`lineTo`的意思，画笔要画到的位置
  - 每两个值是一个`x，y`坐标，L后面可以一直写`x，y`坐标
- 例：`<path d="M 100 100 L 200 100 200 200"></path>`

#### H和V指令

- `H`指令：`horizontal lineto`的意思
  - `x`轴移动到的位置
  - 绘制水平线
- `V`指令：`vertical lineto`的意思
  - `y`轴移动到的位置
  - 绘制垂直线
- 例：`<path d='M 100 100 H 200 V 200'>`，把线移动到`x`轴`200`的位置，`y`轴`200`的位置

#### Z指令

- `z`指令：`closePath`的意思，闭合指令
- 不区分大小写
- 例：`<path d='M 100 100 H 200 V 200 z'>`

#### A指令

- `A`指令：`elliptical Arc`的意思，圆弧指令
- 参数
  - `rx，ry`圆弧的`x`轴半径和`y`轴半径
  - `x-axis-rotation`：圆弧相对于x轴的旋转角度，默认是顺时针，可以设置负值
  - `large-arc-flag`：表示圆弧路径是大圆弧还是小圆弧，`1`代表大圆弧，`0`代表小圆弧
  - `sweep-flag`：表示从起点到终点是顺时针还是逆时针，`1`表示顺时针，`0`表示逆时针
  - `x，y`：表示终点坐标
- 例：`<path d='M 100 100 A 70 120 90 1 1 150 200'></path>`

#### 贝塞尔曲线

##### Q和T指令

- **二次贝塞尔曲线**

![二次贝塞尔曲线](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111701232.GIF)

- **Q指令**
  - `x1，y1`：起始控制点
  - `x，y`：终止点
  - 例：`<path d="M 100 200 Q 200 100 300 300"></path>`
- **T指令**
  - 二次贝塞尔曲线的延申
  - `x，y`：后面添加的两个终止点
  - 例：`<path M 100 200 Q 200 100 300 300 T 500 400></path>`

##### C和S指令

- **三次贝塞尔曲线**

![三次贝塞尔曲线](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111701361.GIF)

- **C指令**
  - `x1，y1`：起始控制点
  - `x2，y2`：过渡控制点
  - `x，y`：终止点
  - 例：`<path d="M 0 200 C 100 100 200 100 300 400"></path>`

- **S指令**
  - 三次贝塞尔曲线的延申
  - `x2，y2`：过渡控制点
  - `x，y`：终止点
  - 例：`<path d="M 0 200 C 100 100 200 100 300 400 S 500 500 500 0"></path>`

#### 获取长度和坐标方法

- **getTotalLength**：获取路径总长度
- **getPointAtLength(x)**：获取路径上距离起始点距离`x`长度的点的坐标
- 注：严格来说上面两方法只适用于`path`元素，但各个浏览器实现起来都会有一点区别。例如谷歌浏览器也能获取到`line`元素的路径长度。

### 自动生成路径

- Method Draw：http://editor.method.ac/

### svg渐变

- `defs`标签，定义以后需要重复使用的图形元素

- 线性渐变

  - `linearGradient`：线性渐变标签

    - 属性值
    - `id`：代表这个渐变的名字，方便其他标签调用
    - `x1，y1`：起始点
    - `x2，y2`：终止点，起始点和终止点可以改变渐变方向

  - `stop`：颜色节点，设置几个颜色节点就代表几个颜色

    - 属性值
    - `offset`：颜色节点的位置，定义渐变色开始和结束
    - `stop-color`：颜色节点的颜色


```html
<defs>
    <linearGradient id="bg1" x1="0" y1="0" x2="0" y2 ="100%">
    	<stop offset="0%" style="stop-color:rgb(255,255,0);"></stop>
        <stop offset="100%" style="stop-color:rgb(255,0,0);"></stop>
    </linearGradient>
</defs>

<rect x="0" y="0" width="500" height="500" style="fill:url(#bg1)"></rect>
```


- 径向渐变

  - `radialGradient`：径向渐变标签

    - 属性值
    - `id`：代表这个渐变的名字，方便其他标签调用
    - `cx，cy`：圆的中心点，此属性定义径向渐变的结束圆的`x，y`坐标。
    - `r`：圆的半径
    - `fx，fy`：圆的扩散范围，此属性定义径向渐变的起始圆的`x，y`坐标。

  - `stop`：颜色节点，设置几个颜色节点就代表几个颜色

    - 属性值
    - `offset`：颜色节点的位置，定义渐变色开始和结束
    - `stop-color`：颜色节点的颜色

```html
<defs>
	<radialGradient id="bg2" cx="50%" cy="50%" r="50%" fx="50%" fy="50%">
		<stop offset="0%" style="stop-color:green;"/>
		<stop offset="100%" style="stop-color:red;"/>
	</radialGradient>
</defs>

<rect x="0" y="0" width="500" height="500" style="fill:url(#bg2)"/>
```

### svg滤镜

- 高斯滤镜

```html
<defs>
    <filter id="Gaussian_Blur">
        <feGaussianBlur in="SourceGraphic" stdDeviation="20"/>
    </filter>
</defs>

<rect x="0" y="0" width="500" height="500" fill="yellow" style="filter:url(#Gaussian_Blur)"/>
```

- 其他滤镜

  - http://www.w3school.com.cn/svg/svg_filters_intro.asp

### svg路径动画

- **stroke-dasharray：--px**
- **stroke-dashoffset：--px;**

- 动画实现原理理，通过修改`stroke-dashoffse`t的值让路路径慢慢地展现出来

```css
path{
    stroke: orange;
    fill: none;
    stroke-width: 20px;
    stroke-dasharray:20px;
    stroke-dashoffset: 15px;
    animation:move 3s linear infinite;
}
@keyframes move {
    0% {
    	stroke-dashoffset: 10px;
    }
    100% {
    	stroke-dashoffset: 500px;
    }
}

<body>
	<svg width=500 height=500>
		<path d="M 0 100 L 500 100"></path>
	</svg>
</body>
```

### ViewBox

- **ViewBox**

  - `viewBox`属性允许指定一个给定的一组图形伸展以适应特定的容器元素。

  - `viewBox`属性的值是一个包含4个参数的列表 `min-x`, `min-y`, `width` and `height`， 以空格或者逗号分隔开，`viewBox`的四个参数分别代表：最小X轴数值，最小y轴数值，宽度，高度。


```html
<svg width=400 height=300 viewBox="0,0,40,30"></svg>

ViewBox后两个参数的意思是，虽然在画布设置的宽有400，高有300，但实际的单位宽只有40个单位宽，高只有30单位高，也就是说设置上ViewBox之后，虽然你设置的宽不管有多大，最后都是要按照ViewBox设置的宽高来决定比例的
```

- **preserveAspectRatio**对齐、填充方式

  - `xMin`、`xMid`、`xMax`：`x`轴-左中右对齐
  - `YMin`、`YMid`、`YMax`：`y`轴-上中下对齐
  - `meet`、`slice`、`none`：撑开、撑满、形变（设置填充方式）
  - 例：`svg.setAttribute("preserveAspectRatio", "xMinYMin slice")`

### 用JS生成svg元素

- 创建`svg`元素需要制定命名空间

- `svg`元素对象一般通过调用`setAttribute()`方法来设定属性值


```javascript
var char = 'http://www.w3.org/2000/svg', 
    //命名空间的名称，固定好的
    svg = document.createElementNS(char,'svg');

svg.setAttribute('width',500);
svg.setAttribute('height',500);
svg.setAttribute('viewBox','0 0 500 500');

var rect = document.createElementNS(char,'rect');

rect.setAttribute('x',100);
rect.setAttribute('y',100);
rect.setAttribute('width',100);
rect.setAttribute('height',100);
rect.setAttribute('fill','#0fc');
svg.appendChild(rect);
document.body.appendChild(svg);
```



### 练习

```html
输入数字，进度条占用
<style>
    svg {
        border: 1px solid black;
    }
    path{
        fill: none;
        stroke-width:10px;
        stroke-linecap: round;
    }
    #path1 {
        stroke:#ccc;
    }
    #path2{
        stroke:orange;
        stroke-dasharray:1000px;
        stroke-dashoffset:1000px;
    }
    .active {
        transition:  all 1s linear;
    }
</style>
</head>
<body>

    <input id="btn" type="text">
    <svg width=500 height=500>
        <path id="path1" d="M 200 300 A 100 100 0 1 1 300 300"></path>
        <path id="path2" d="M 200 300 A 100 100 0 1 1 300 300"></path>
    </svg>

    <script>
        //获取path长度
        var len = path2.getTotalLength();

        btn.onblur = function() {
            var value = this.value;
            var total = len * value / 100; //变成百分比
            path2.classList.add('active'); //单独设置动画class类名
            path2.style.strokeDashoffset = 1000 - total + 'px';
        }
        btn.onfocus = function() {
            path2.classRemove('active');//失去焦点之后删除class，立即消失
            path2.style.strokeDashOffset='1000px';
        }
    </script>
</body>
```

```html
loading效果
<style>
    	svg {
    		border: 1px solid black;
    	}
    	circle,path {
    		fill:transparent;
    		stroke:#ff6700;
    		stroke-width:10px;
    		stroke-linecap: round;
    	}
    	circle {
    		stroke: rgba(255,150,0,.5);
    	}
    </style>
</head>
<body>
	<svg width=100 height=100>
		<circle r=40 cx=50 cy=50></circle>
		<path d="M 10 50 A 40 40 0 0 1 50 10">
			<animateTransform attributeName="transform" type="rotate" from='0 50 50' to='360 50 50' dur='0.5s' repeatCount='indefinite'>/</animateTransform>
		</path>
	</svg>
</body>
```

```html
叮当猫
<head>
    <style>
    	svg {
    		border: 1px solid black;
    	}
    	.face {
    		fill: white;
    	}

    	.eye{
    		fill: white;
    	}

		.line-black {
			stroke: black;
		}
		.fill-blue {
			fill:#2E87FD;
		}
		.mouth {
			fill: none;
		}
		.nose {
			fill: #FD0100;
		}
		.nose-light {
			fill: white;
		}
		.sling {
			stroke-width: 20px;
			stroke: red;
			stroke-linecap: round;
		}
		.bell {
			fill: #cece1b;
			fill-opacity: .7;;
		}
		.body {
			stroke: black;
		}
		.fist {
			fill: white;
		}
		.pocket {
			fill: white;
		}
		.pocket-line {
			fill: none;
		}
		.foot {
			stroke: black;
			fill: white;
		}
		.foot-y {
			fill: white;
		}
    </style>
</head>
<body>
	<svg width='510' height=510>
		<!-- 头部蓝色背景 -->
		<path class='line-black fill-blue head-back' d="M 150 300 A 160 160 0 1 1 350 300"></path>
		<!-- 脸部白色背景 -->
		<ellipse rx=130 ry=110 cx=250 cy=220 class="face line-black "></ellipse>
		<!-- 眼睛-右 -->
		<ellipse rx=35 ry=45 cx=215 cy=110 class="eye line-black "></ellipse>
		<!-- 眼睛-左 -->
		<ellipse rx=35 ry=45 cx=285 cy=110 class="eye line-black "></ellipse>
		<!-- 眼珠-右 -->
		<ellipse rx=8 ry=10 cx=225 cy=120></ellipse>
		<!-- 眼珠-左 -->
		<ellipse rx=8 ry=10 cx=275 cy=120></ellipse>
		<!-- 胡须-右 -->
		<path d="M 150 180 L 210 190" class="line-black "></path>
		<path d="M 145 205 L 210 205" class="line-black "></path>
		<path d="M 150 230 L 210 220" class="line-black "></path>
		<!-- 胡须-左 -->
		<path d="M 280 190 L 350 180" class="line-black "></path>
		<path d="M 280 205 L 345 205" class="line-black "></path>
		<path d="M 280 220 L 350 230" class="line-black "></path>
		<!-- 嘴巴 -->
		<line class="mouth line-black " x1=250 y1=165 x2=250 y2=270></line>
		<path class="mouth line-black " d="M 180 240 A 80 50 0 0 0 325 240"></path>
		<!-- 鼻子 -->
		<ellipse class="nose line-black " rx=15 ry=15 cx=250 cy=160></ellipse>
		<ellipse class="nose-light line-black " rx=5 ry=7 cx=257 cy=155></ellipse>
		<!-- 身体背景 -->
		<rect class="body fill-blue" x=150 y=300 width=200 height=170></rect>
		<!-- 左胳膊 -->
		<path class="arm fill-blue" d="M 90 290 L 180 330 170 365 90 330 90 290"></path>
		<ellipse class="line-black fist" rx=22 ry=22 cx=97 cy=312></ellipse>
		<!-- 右胳膊 -->
		<path class="arm fill-blue" d="M 320 330 L 410 305 410 340 320 365 320 360"></path>
		<ellipse class="line-black fist" rx=22 ry=22 cx=410 cy=320></ellipse>
		<!-- 口袋 -->
		<path class="pocket" d="M 180 310 A 80 85 0 1 0 320 310"></path>
		<path class="line-black pocket-line" d="M 200 370 A 40 40 0 1 0 300 370 z"></path>
		<!-- 挂绳 -->
		<path class="sling" d="M 150 300 L 350 300"></path>
		<!-- 铃铛 -->
		<ellipse class="bell line-black " rx=20 ry=20 cx=250 cy=315></ellipse>
		<ellipse rx=7 ry=7 cx=250 cy=325></ellipse>
		<path class="line-black" d="M 250 325 L 250 335"></path>
		<!-- 脚 -->
		<ellipse class="foot-y" rx=15 ry=20 cx=255 cy=480></ellipse>
		<!-- 左脚 -->
		<ellipse class="foot" rx=60 ry=20 cx=190 cy=480></ellipse>
		<!-- 右脚 -->
		<ellipse class="foot" rx=60 ry=20 cx=320 cy=480></ellipse>
    </svg>
</body>
```

## 客户端存储

### storage

- **localstorage**：永久存储（可以手动删除数据）

- **seesionstorage**：`session`临时回话，从页面打开到页面关闭的时间段窗口的临时存储，页面关闭，本地存储消失

- 存储数据


```javascript
localStorage.name = 'aimee';
localStorage.info = `JSON.stringify({
	name:'aimee',
	company:'diyi'
})`
```

- 取出数据


```javascript
localStorage.name
localStorage.info
```

- 作用域

  - `localStorage`：文档源限制、同源策略限制
  - `sessionStorage`：文档源限制、同源策略限制、窗口

- 特点：

  - 存储量限制 ( `5M` )
  - 客户端完成，不会请求服务器处理
  - `sessionStorage`数据是不共享、 `localStorage`共享

- **API**

  - `setItem(name,val)`：设置数据，(`key`,`value`)类型，类型都是字符串，可以用获取属性的形式操作
  - `getItem(name)`：获取数据，通过`key`来获取到相应的`value`
  - `removeItem(name)`：删除数据，通过key来删除相应的`value`
  - `clear()`：删除全部存储的值

- 存储事件

  - 当数据有修改或者删除的情况下就会触发`storage`事件
  - 在对数据进行改变的窗口对象上是不会触发的
  - `Key`：修改或删除的`key`值，如果调用`clear(),key()为null`
  - `newValue`  :  新设置的值，如果调用`removeStorage()`,`key`为`null`
  - `oldValue` :  调用改变前的`value`值
  - `storageArea` : 当前的`storage`对象
  - `url` :  触发该脚本变化的文档的`url`
  - 注：`session`同窗口才可以,例子：`iframe`操作

### cookie

- 存储信息到用户的设备上，数据量较小，`4k`左右

- `navigator.cookieEnabled`：检测是否启用了`cookie`

- 设置**cookie**值

  - `document.cookie = "name=aimee"`
  - 每次只能设置一个值，因为浏览器会认为后面的键值对是这个`cookie`的属性

- 获得**cookie**值

  - `document.cookie`
  - 不建议出现分号，逗号，空格的奇怪符号

- 设置**cookie**存储期限

  - `document.cookie = 'name=scott;max-age=1000'`

- **expires**：当前时间加上保存时间

  - ```js
    var timestamp = (new Date()).getTime() + 10000;
    var expires = new Date(timestamp).toGMTString();
    document.cookie = “name=scott;expires=“+expires;
    ```

- 删除**cookie**

  - 需要带上键值对，`max-age=0`
  - `document.cookie = 'name=scott;max-age=0'`

- **domain**：跨域，设置相同的域

- **path**：路径

- ![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111702969.png)

- `encodeURIComponent()`：函数可把字符串作为 `URI` 组件进行编码。

- `decodeURIComponent()`：函数可对 `encodeURIComponent()` 函数编码的 `URI` 进行解码。

## 地位位置信息、重力感应、方向感应

### geolocation（地理位置信息）

---

> **geolocation**：获取地理位置信息

- 经度  :   南北极的连接线
- 纬度  :   东西连接的线
- 位置信息从何而来
    - `IP`地址
    - `GPS`全球定位系统
    - `Wi-Fi`无线网络
    - 基站

- https://dev.w3.org/geo/api/spec-source.html#position_error_interface
- `window.navigator.geolocation`：`navigator`对象下面的属性
  - ![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111702834.png)

#### getCurrentPosition

> getCurrentPosition(success,error,options)
>
> 获取当前的位置信息

- `success`：获取成功的回调函数（必须）

- `error`：失败的回调函数

- `options`：一些参数，来辅助

  - `enableHighAccuracy`：是否需要高精度位置，默认`false`,`true/false`
  - `timeout`：请求超时的时间，单位`ms`，默认`infinity`
  - `maximumAge`：单位`ms`，`watchPosition`方法不停的取用户的地理位置信息，不停的更新用户的地理位置信息，位置信息过期时间设置为`0`就是无条件获取新的地理位置信息，默认为`0`

- 需要翻墙才可以使用

- ```js
  例：
  //pos就是地理位置信息
  //成功的回调函数
  function suc(pos) {
      console.log(pos);
  }
  //失败的回调函数
  function err(err) {
      console.log(err);
  }
  //options参数
  var options = {
      enableHighAccuracy: true,
      timeout: 2000,
      maximumAge: 300000 //五分钟
  }
  window.navigator.geolocation.getCurrentPosition(suc,err)
  ```

- 成功和失败返回回来的值

  - 成功之后返回回来的地理位置信息(`GeolocationPosition`)
    - ![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111702482.png)
    - 经度 :  `coords.longitude`
    - 纬度 :  `coords.latitude`
    - 准确度 :  `coords.accuracy`
    - 海拔 : ` coords.altitude`
    - 海拔准确度 :  `coords.altitudeAcuracy`
    - 行进方向 :  `coords.heading`
    - 地面速度 :  `coords.speed`
    - 请求的时间: `new Date(position.timestamp)`
  - 失败之后返回回来的值(`PositionError`)
    - 用户拒绝：`code=1`
    - 获取不到：`code=2`
    - 连接超时：`code=3`，一般测试不出来，可以设置`timeout`
    - ![用户拒绝](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111702571.png)
    - ![获取不到](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111702730.png)
    - ![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111703276.png)

#### watchPosition/clearWatch

>watchPosition(fn)
>
>用于注册监听器，在设备的地理位置发生改变的时候自动被调用
>
>> 参数与getCurrentPosition相同

- **watchPosition**
  - `success`：获取成功的回调函数（必须）
  - `error`：失败的回调函数
  - `options`：一些参数，来辅助
    - `enableHighAccuracy`：是否需要高精度位置，默认`false`,`true/false`
    - `timeout`：请求超时的时间，单位`ms`，默认`infinity`
    - `maximumAge`：单位`ms`，`watchPosition`方法不停的取用户的地理位置信息，不停的更新用户的地理位置信息，位置信息过期时间设置为`0`就是无条件获取新的地理位置信息，默认为`0`
- **clearWatch(id)**：清除`watchPosition`监听


- **examp01**

```javascript
<button id="btn">请求位置信息</button>
<div id="box"></div>

var btn = document.getElementById("btn");
var box = document.getElementById("box");
		
btn.onclick = function(){
			navigator.geolocation.getCurrentPosition(function(position){
				box.innerHTML +="经度："+position.coords.longitude + "<br>";
				box.innerHTML +="纬度："+position.coords.latitude + "<br>";
				box.innerHTML +="海拔："+position.coords.accuracy + "<br>";
				box.innerHTML +="海拔的准确度："+position.coords.altitudeAccuracy + "<br>";
				box.innerHTML +="地面速度"+position.coords.speed + "<br>";
				box.innerHTML +="行进方向"+position.coords.heading + "<br>";
				box.innerHTML +="请求时间"+new Date(position.timestamp) + "<br>";
			},function(err){
				alert(err.code);
			},{
				enableHighAccuracy:false,//精确请求
				timeout:5000,//设置超时
				maximumAge:1000//缓存时间
			});
		}
```

[在线演示](http://codepen.io/poetries/pen/RKPWMg)


- **examp02 **

```javascript
var btn = document.getElementById("btn");
var box = document.getElementById("box");
		
btn.onclick = function(){
			navigator.geolocation.watchPosition(function(position){
				box.innerHTML +="经度："+position.coords.longitude + "<br>";
				box.innerHTML +="纬度："+position.coords.latitude + "<br>";
				box.innerHTML +="海拔："+position.coords.accuracy + "<br>";
				box.innerHTML +="海拔的准确度："+position.coords.altitudeAccuracy + "<br>";
				box.innerHTML +="地面速度"+position.coords.speed + "<br>";
				box.innerHTML +="行进方向"+position.coords.heading + "<br>";
				box.innerHTML +="请求时间"+new Date(position.timestamp) + "<br>";
			},function(err){
				alert(err.code);
			},{
				enableHighAccuracy:false,//精确请求
				timeout:5000,//设置超时
				maximumAge:1000//缓存时间
			});
		}
```
[在线演示](http://codepen.io/poetries/pen/zNGvjY)

- **example03 高德地图应用**

```html
#container {
    width:600px; 
    height: 300px;
    margin:40px auto;
    border:1px solid red;
} 

<div id="container"></div>  
<script type="text/javascript" 
src="http://webapi.amap.com/maps?v=1.3&key=278b7b8b4728ba302b7e566fc2a97b36">
</script>

<script>
    var map = new AMap.Map('container');
</script>
```
[在线演示](http://codepen.io/poetries/pen/qRdOKZ)

- **examp04  搜索城市**

```css
#container {width:500px; height:500px; margin:100px auto;}  
.menu{
	width:100px;
	box-shadow: 0 0 5px #000;
	margin:auto;
	background:#fff;
}
.menu ul li{
	list-style:none;
	line-height:30px;
	text-align:center;
	cursor:pointer;
}
#box{
	width:400px;
	height:40px;
	position:absolute;
	top:150px;
	left:50%;
	margin-left:-200px;
	background:#fff;
	box-shadow:0 0 10px #000;
}
input{
	height:38px;
	width:300px;
	border:none;
	outline:none;
}
#btn{
	width:80px;
}


<div id="container"></div> 
<div id="box">
	<input type="text" id="city" placeholder="请输入城市...">
	<input type="button" value="搜索" id="btn">
</div>
<script type="text/javascript" 
src="http://webapi.amap.com/maps?v=1.3&key=278b7b8b4728ba302b7e566fc2a97b36">
</script>

<script>
    var btn = document.getElementById("btn");
    var city = document.getElementById("city");
    var map = new AMap.Map('container');
    var toolBar,mouseTool,contextMenu;
    //在地图中添加操作toolBar插件、mouseTool插件
    map.plugin(["AMap.ToolBar","AMap.MouseTool"],function(){
        toolBar = new AMap.ToolBar();
        map.addControl(toolBar);
        mouseTool = new AMap.MouseTool(map);
    });
    var menuContext = document.createElement("div");
    menuContext.innerHTML = "<div class=menu><ul><li onclick='zoomMenu(0)'>缩小</li>
    <li onclick='zoomMenu(1)'>放大</li>
    <li onclick='distanceMeasureMenu()'>距离量测</li>
    <li onclick = 'addMarkerMenu()'>添加标记</li></ul></div>";
    //创建一个自定义的右键菜单
    contextMenu = new AMap.ContextMenu({isCustom:true,content:menuContext});
    //给地图绑鼠标右键功能弹出右键菜单
    AMap.event.addListener(map,"rightclick",function(e){
        contextMenu.open(map,e.lnglat);//e.lnglat鼠标点击的经纬度
        contextMenuPosition = e.lnglat;
    })
    //右键菜单缩放地图
    function zoomMenu(n){
        if(n === 0){map.zoomOut();}
        if(n === 1){map.zoomIn();}
        contextMenu.close();
    }
    contextMenu.close();
    //测量距离功能
    function distanceMeasureMenu(){
        mouseTool.rule();
        contextMenu.close();
    }
    //添加标注功能
    function addMarkerMenu(){
        mouseTool.close();
        var marker = new AMap.Marker({
            map: map,
            position: contextMenuPosition, //基点位置
            offset: {x:-5,y:-10} //相对于基点位置
        });
        contextMenu.close();
    }
    //搜索城市
    btn.onclick = function(){
        var val = city.value;
        map.setCity(val);
    }
</script>
```
[在线演示](http://codepen.io/poetries/pen/xgGwaZ)

### devicemotion（监听加速度变化）

> **devicemotion**：监听加速度变化，当你的设备疯狂摇摆时，可以监听到是加速还是在减速，需要陀螺仪支持

```js
window.addEventListener('devicemotion', function(e){
       console.log(e);
});
```

- 包含的属性

  - `accelerationIncludingGravity`：包括重心引力，`z`轴方向加了`9.8`，再`x,y`方向上的值两者相同，重力加速度
  - `acceleration`：重力加速度（需要陀螺仪支持）
  - `rotationRate(alpha,beta,gamma)`：旋转速率
  - `interval`：获取的时间间隔
  - 注意：都是只读属性


```js
//重力感应
window.addEventListener('devicemotion',function(e) {
    		item.innerHTML = e.accelerationIncludingGravity.x + '-' +e.accelerationIncludingGravity.y + '-' + e.accelerationIncludingGravity.z;
    	})
```

```js
微信摇一摇
var SHAKE_THRESHOLD = 800; //基准值800
        var last_update = 0; //上一次更新的时间为0
		//当前x,y,z和上一次的x,y,z
        var x, y, z, last_x=0, last_y=0, last_z=0;
        function deviceMotionHeadler(eventData) {
        	// 加速度
            var acceleration = eventData.accelerationIncludingGravity;
            //时间戳
            var curTime = new Date().getTime();
            //300毫秒判断一次，300毫秒执行一次
            if((curTime - last_update) > 300) {
                var diffTime = curTime - last_update;
                last_update = curTime;
                x = acceleration.x;
                y = acceleration.y;
                z = acceleration.z;
                
                var speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;
                if(speed > SHAKE_THRESHOLD) {
                    alert('shaked~!');
                    var div = document.createElement('div');
                    div.innerText = '11';
                    document.body.appendChild(div);
                }
                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
        //监听加速度的变化，当加速度变化时，执行deviceMotionHeadler函数
        window.addEventListener('devicemotion', deviceMotionHeadler, false);
```

### deviceorientation（监听方向变化）

> deviceorientation：监听设备在方向上的变化

```js
window.addEventListener(deviceorientation,function(event) {
    console.log(event);
})
```

- 包含的属性

  - `alpha`：表示设备沿z轴上的旋转角度，范围为`0~360`
  - `beta`表示设备再X轴上的旋转角度，范围为`-180~180`。它描述的是设备由前向后旋转的情况
  - `gamma`表示设备在`y`轴上的旋转角度，范围为`-90~90`。它描述的是设备由左向右旋转的情况
  - ![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111704446.png)


```html
<p>旋转：<span id="alpha">0</span></p>
<p>前后：<span id="beta">0</span></p>
<p>扭转：<span id="gamma">0</span></p>


<script>
    function DeviceOrientationHandler(event){
        var alpha = event.alpha,
            beta = event.beta,
            gamma = event.gamma,
            webkitCompassHeading = event.webkitCompassHeading;

        if(alpha != null || beta != null || gamma != null){
            //判断屏幕方向
            var html = "";
            if( gamma > 0 ){
                html = "向右倾斜" + gamma;
            }else{
                html = "向左倾斜" + gamma;
            }
            document.getElementById("gamma").innerHTML = html;

            var str = '';
            if( beta > 0 ){
                str = "向前倾斜" + beta;
            }else{
                str = "向后倾斜" + beta;
            }

            var head = '';
            var headNum = Math.round(Math.round(webkitCompassHeading/45) + 7)%8;
            switch (headNum) {
                case 0:
                    head = '东北';
                    break;
                case 1:
                    head = '东';
                    break;
                case 2:
                    head = '东南';
                    break;
                case 3:
                    head = '南';
                    break;
                case 4:
                    head = '西南';
                    break;
                case 5:
                    head = '西';
                    break;
                case 6:
                    head = '西北';
                    break;
                case 7:
                    head = '北';
            }

            document.getElementById("beta").innerHTML = str;
            document.getElementById("alpha").innerHTML = alpha;
            document.getElementById('heading').innerHTML = head + '   ' + webkitCompassHeading;
        }else{
            document.body.innerHTML = "当前浏览器不支持DeviceOrientation";
        }
    }
    //判断有没有这个事件，如果有的话才监听
    if(window.DeviceOrientationEvent){
        window.addEventListener('deviceorientation',DeviceOrientationHandler, false);
    }else{
        alert("您的浏览器不支持DeviceOrientation");
    }
</script>
```

- `webkitCompassHeading`：与正北方向的角度差值。正北为`0`度，正东为`90`度，正南为`180`度，正西为`270`度。因为`0`度是正北，所以叫指北针。

- `webkitCompassAccuracy`：指北针的精确度，表示偏差为正负多少度。一般是`10`。

## 动画函数、历史记录、线程管理

### requestAnimationFrame(动画函数)

> 实现动画的API，让浏览器更加流畅的实现动画

- 由于`JavaScript`是单线程的，所以定时器的实现是在当前任务队列完成后再执行定时器的回调的，假如当前队列任务执行时间大于定时器设置的延迟时间，那么定时器就不是那么可靠了

- 动画是由浏览器按照一定的频率一帧一帧的绘制的，由`css`实现的动画的优势就是浏览器知道动画的开始及每一帧的循环间隔，能够在恰当的时间刷新`UI`，给用户一种流畅的体验，而`setInterval`或`setTimeout`实现的`JavaScript`动画就没有这么可靠了，因为浏览器压根就无法保证每一帧渲染的时间间隔，一般情况下，每秒平均刷新次数能够达到60帧，就能够给人流畅的体验，即每过 `1000/60` 毫秒渲染新一帧即可，这一点单靠定时器是无法保证的。 为此，`requestAnimationFrame`应运而生，其作用就是让浏览器流畅的执行动画效果。可以将其理解为专门用来实现动画效果的`api`，通过这个`api`,可以告诉浏览器某个`JavaScript`代码要执行动画，浏览器收到通知后，则会运行这些代码的时候进行优化，实现流畅的效果，而不再需要开发人员烦心刷新频率的问题了。

- 大多数电脑显示器的刷新频率是`60Hz`，大概相当于每秒钟重绘`60`次。大多数浏览器都会对重绘操作加以限制，不超过显示器的重绘频率，因为即使超过那个频率用户体验也不会有提升。因此，最平滑动画的最佳循环间隔是`1000ms/60`，约等于`16.7ms`，所以屏幕一般`16.7ms`才会刷新一次

- 特点

  - `requestAnimationFrame`会把每一帧中的所有`DOM`操作集中起来，在一次重绘或回流中就完成，并且重绘或回流的时间间隔紧紧跟随浏览器的刷新频率，在隐藏或不可见的元素中，`requestAnimationFrame`将不会进行重绘或回流，这当然就意味着更少的`CPU`、`GPU`和内存使用量
  - `requestAnimationFrame`是由浏览器专门为动画提供的`API`，在运行时浏览器会自动优化方法的调用，并且如果页面不是激活状态下的话，动画会自动暂停，有效节省了`CPU`开销
  - `requestAnimationFrame`会在浏览器每次刷新前执行，因为屏幕刷新率一般是`16.7ms`，所以一般`16.7ms`执行一次
  - `requestAnimationFrame`的用法与`setTimeout`很相似，只是不需要设置时间间隔而已。`requestAnimationFrame`使用一个回调函数作为参数，这个回调函数会在浏览器重绘之前调用。它返回一个整数，表示定时器的编号，这个值可以传递给`cancelAnimationFrame`用于取消这个函数的执行。
  - 兼容性存在问题，因为是`HTML5`新提供的`API`，只可以在`IE10`以上的浏览器

- `requestAnimationFrame`：设置动画

- `canvelAnimationFrame`：取消动画


```js
//简单兼容
//设置AnimationFrame
window.requestAnimFrame = (function(){ 
	return window.requestAnimationFrame || 
        window.webkitRequestAnimationFrame || 
        window.mozRequestAnimationFrame || 
        function(callback) {
            window.setTimeout(callback,1000/60);
        };
})();

//取消AnimationFrame
window.cancelAnimFrame = (function() {
    return window.cancelAnimationFrame ||
        window.webkitCancelAnimationFrame ||
        window.mozCancelAnimationFrame ||
        function(id) {
            window.clearTimeout(id);
        }
})();
```

```js
// 完美兼容
(function() {
    var lastTime = 0;
        var vendors = ['webkit', 'moz'];
        for(var x = 0; x < vendors.length && !window.requestAnimationFrame; ++x) {
            window.requestAnimationFrame = window[vendors[x] + 'RequestAnimationFrame'];
            window.cancelAnimationFrame = window[vendors[x] + 'CancelAnimationFrame'] ||    // Webkit中此取消方法的名字变了
                                          window[vendors[x] + 'CancelRequestAnimationFrame'];
        }
    if (!window.requestAnimationFrame) {
        window.requestAnimationFrame = function(callback, element) {
            var currTime = new Date().getTime();
            var timeToCall = Math.max(0, 16.7 - (currTime - lastTime));
            var id = window.setTimeout(function() {
                callback(currTime + timeToCall);
            }, timeToCall);
            lastTime = currTime + timeToCall;
            return id;
        };
    }
    if (!window.cancelAnimationFrame) {
        window.cancelAnimationFrame = function(id) {
            clearTimeout(id);
        };
    }
}());
```

```js
例：

<div id="btn"></div>

//requestAnimationFrame兼容函数
window.requestAnimationFrame = (function() {
    return window.requestAnimationFrame || 
        window.webkitRequestAnimationFrame || 
        window.mozRequestionAnimationFrame || 
        function(callback) {
            window.setTimeout(callback,1000/60);
        }
})();
//cancelAnimationFrame兼容函数
window.cancelAnimationFrame = (function() {
    return window.cancelAnimationFrame ||
        window.webkitCancelAnimationFrame || 
        window.mozCancelAnimationFrame || 
        function(id) {
            window.clearTimeout(id);
        }
})();

var req; //标识

function move() {
    btn.style.left = btn.offsetLeft + 10 + 'px';
    if(btn.offsetLeft >= 300) {
        // clearTimeout(timer);
        cancelAnimationFrame(req);
        btn.style.left = '300px';
    } else {
        // req = setTimeout(function() {
        // 	move();
        // },10)
        req = requestAnimationFrame(move);
    }
}
move();
```

### history(历史记录)

- 属性
  - `history.length()`：返回浏览器当前标签页历史列表中的 `URL` 数量
  - `history.back()`：加载浏览器当前标签页`history` 列表中的前一个 `URL`
  - `history.forward()`：加载浏览器当前标签页`history` 列表中的下一个 `URL`
  - `history.go()`：加载 history 列表中的某个具体页面,例如 `history.go(-2)`
- 为什么要管理历史记录
  - 为了给用户更方便的操作，更方便回退
- `history api`的作用，为了我们更方便管理历史记录，不用非要用户点击操作
- **SPA**：单页面应用
- 修改事件实现历史记录管理
  - `pushState`
    - `history.pushState(state,title,url);` 添加一条历史记录
  - `repalceState`
    - `history.replaceState(state,title,url)`：替换当前的历史记录
  - 参数：
    - `state`：一个与指定网址相关的状态对象，`popstate`事件触发时，该对象会传入回调函数中，如果不需要这个对象，可以填`null`
    - `title`：新页面的标题，但是所有浏览器目前都忽略这个值，因此这里可以填`null`
    - `url`：新的网址，必须与当前页面处在同一个域，浏览器的地址栏将显示在这个网址

- 事件
  - `popstate`：历史记录发生改变时触发
    - 调用`history.pushState()或者history.replaceState()不会触发popstate事件`
  - `hashchange`：当页面的`hash`值改变的时候触发，常用于构建单页面应用

### worker(线程管理)

- 简介
  - `Web Worker` (工作线程) 是 `HTML5` 中提出的概念，分为两种类型，专用线程（`Dedicated Web Worker`） 和共享线程（`Shared Web Worker`）。专用线程仅能被创建它的脚本所使用（一个专用线程对应一个主线程），而共享线程能够在不同的脚本中使用（一个共享线程对应多个主线程）。
  - 专用线程可以看做是默认情况的 `Web Worker`，其加上修饰词的目的是为了与共享线程进行区分。本文会较为严格地区分两者，可能较为累赘，但个人认为这是必要的。如果单纯以 `Web Worker` 字样出现的地方指的是两者都会有的情况。

- 用途
  - `Web Worker` 的意义在于可以将一些耗时的数据处理操作从主线程中剥离，使主线程更加专注于页面渲染和交互。
  - 懒加载
  - 文本分析
  - 流媒体数据处理
  - `canvas` 图形绘制
  - 图像处理
  - ...

- 需要注意的点
  - 有同源限制
  - 无法访问 `DOM` 节点
  - 运行在另一个上下文中，无法使用`Window`对象
  - `Web Worker` 的运行不会影响主线程，但与主线程交互时仍受到主线程单线程的瓶颈制约。换言之，如果 Worker 线程频繁与主线程进行交互，主线程由于需要处理交互，仍有可能使页面发生阻塞
  - 共享线程可以被多个浏览上下文（`Browsing context`）调用，但所有这些浏览上下文必须同源（相同的协议，主机和端口号）

- 浏览器支持度
  - 根据 `CanI Use` 网站的统计，目前约有 `93.05%` 的浏览器支持专用线程。

- 线程创建

  - 值得注意的是，因为 `Web Worker` 有同源策略限制，所以在本地调试的时候也需要通过启动本地服务器的方式访问，使用 `file://` 协议直接打开的话将会抛出异常。

  - 专用线程


```js
//专用线程由 Worker()方法创建，可以接收两个参数，第一个参数是必填的脚本的位置，第二个参数是可选的配置对象，可以指定 type、credentials、name 三个属性。

专用线程
var worker = new Worker('worker.js')//worker.js是自己的js文件
// var worker = new Worker('worker.js', { name: 'dedicatedWorker'})
```

- 共享线程


```js
//共享线程使用 Shared Worker() 方法创建，同样支持两个参数，用法与 Worker() 一致。
var sharedWorker = new SharedWorker('shared-worker.js')//shared-worker.js是自己的js文件
```

- 数据传递

  - **postMessage**()：发送消息事件

  - **onmessage**：接收消息事件

  - `Worker` 线程和主线程都通过 `postMessage()` 方法发送消息，通过 `onmessage` 事件接收消息。在这个过程中数据并不是被共享的，而是被复制的。值得注意的是 `Error` 和 `Function` 对象不能被结构化克隆算法复制，如果尝试这么做的话会导致抛出 `DATA_CLONE_ERR` 的异常。另外，`postMessage()` 一次只能发送一个对象， 如果需要发送多个参数可以将参数包装为数组或对象再进行传递。


```js
// 主线程
//创建一个worker
var worker = new Worker('worker.js')
//worker postMessage
worker.postMessage(10)
//给worker绑定message事件
worker.onmessage = function(e) {
    console.log(e.data)
}

// Worker.js 线程
//绑定onmessage事件
onmessage = function(e) {
    console.log(e.data);
    //向主线程发送数据
    postMessage(deal(e.data));
}

function deal(data) {
    return data * data;
}
```

- 在 `Worker` 线程中，`self` 和 `this` 都代表子线程的全局对象。对于监听 message 事件，以下的四种写法是等同的。


```js
// 写法 1
self.addEventListener('message', function (e) {
    // ...
})

// 写法 2
this.addEventListener('message', function (e) {
    // ...
})

// 写法 3
addEventListener('message', function (e) {
    // ...
})

// 写法 4
onmessage = function (e) {
    // ...
}
```

- 主线程通过 `MessagePort` 访问专用线程和共享线程。专用线程的 `port` 会在线程创建时自动设置，并且不会暴露出来。与专用线程不同的是，共享线程在传递消息之前，端口必须处于打开状态。`MDN` 上的 `MessagePort` 关于 `start()` 方法的描述是：

  - > Starts the sending of messages queued on the port (only needed when using EventTarget.addEventListener; it is implied when using MessagePort.onmessage.)
    >
    > 开始发送在端口上排队的消息（仅在使用EventTarget.addEventListener时需要）；当使用MessagePort.onmessage时，它是隐含的。）

  - 这句话经过试验，可以理解为 `start()` 方法是与 `addEventListener` 配套使用的。如果我们选择 `onmessage` 进行事件监听，那么将隐含调用 `start()` 方法。


```js
// 主线程
var sharedWorker = new SharedWorker('shared-worker.js')
sharedWorker.port.onmessage = function(e) {
    // 业务逻辑
}

var sharedWorker = new SharedWorker('shared-worker.js')
sharedWorker.port.addEventListener('message', function(e) {
    // 业务逻辑
}, false)
sharedWorker.port.start() // 需要显式打开
```

- 在传递消息时，`postMessage()` 方法和 `onmessage` 事件必须通过端口对象调用。另外，在 `Worker` 线程中，需要使用 `onconnect` 事件监听端口的变化，并使用端口的消息处理函数进行响应。


```js
// 主线程
sharedWorker.port.postMessage([10, 24])
sharedWorker.port.onmessage = function (e) {
    console.log(e.data)
}

// Worker 线程
onconnect = function (e) {
    let port = e.ports[0]

    port.onmessage = function (e) {
        if (e.data.length > 1) {
            port.postMessage(e.data[1] - e.data[0])
        }
    }
}
```

- 关闭 **Worker**

  - **close()**：在`worker`作用域中调用，自己关闭
    
  - **terminate()**：在`worker`对象上调用(主进程的`worker`对象上`worker.terminate`)，上级关闭`worker`
    
  - 可以在主线程中使用 `terminate()` 方法或在 `Worker` 线程中使用 `close()` 方法关闭 `worker`。这两种方法是等效的，但比较推荐的用法是使用 `close()`，防止意外关闭正在运行的 `Worker` 线程。`Worker` 线程一旦关闭 `Worker` 后 `Worker` 将不再响应。


```js
// 主线程
worker.terminate()

// Dedicated Worker 线程中
self.close()

// Shared Worker 线程中
self.port.close()
```

- 错误处理

  - 可以通过在主线程或 `Worker` 线程中设置 `onerror` 和 `onmessageerror` 的回调函数对错误进行处理。其中，`onerror` 在 `Worker` 的 `error` 事件触发并冒泡时执行，`onmessageerror` 在 `Worker` 收到的消息不能进行反序列化时触发(本人经过尝试没有办法触发 `onmessageerror` 事件，如果在 `worker` 线程使用 `postMessage` 方法传递一个 Error 或 Function 对象会因为无法序列化优先被 `onerror` 方法捕获，而根本不会进入反序列化的过程)


```js
// 主线程
worker.onerror = function () {
    // ...
}

// 主线程使用专用线程
worker.onmessageerror = function () {
    // ...
}

// 主线程使用共享线程
worker.port.onmessageerror = function () {
    // ...
}

// worker 线程
onerror = function () {

}
```

- 加载外部脚本

  -  `importScripts()` ：能够将外部脚本文件加载到 `Worker` 中

  - `worker`只是`window`的子集，只能实现部分功能，不能获取到`window`，`documennt`，所以这里不要引入`jquery`，可以引入一些计算的库


```js
importScripts('script1.js')
importScripts('script2.js')

// 以上写法等价于
importScripts('script1.js', 'script2.js')
```

- 子线程

  - `Worker` 可以生成子 `Worker`，但有两点需要注意。
  - 子 `Worker` 必须与父网页同源
  - 子 `Worker` 中的 `URI` 相对于父 `Worker` 所在的位置进行解析

- 嵌入式 **Worker**

  - 目前没有一类标签可以使 `Worker` 的代码像 `<script>` 元素一样嵌入网页中，但我们可以通过 `Blob()` 将页面中的 `Worker` 代码进行解析。


```js
<script id="worker" type="javascript/worker">
// 这段代码不会被 JS 引擎直接解析，因为类型是 'javascript/worker'

// 在这里写 Worker 线程的逻辑
</script>
<script>
    var workerScript = document.querySelector('#worker').textContent
    var blob = new Blob(workerScript, {type: "text/javascript"})
    var worker = new Worker(window.URL.createObjectURL(blob))
</script>
```

- 关于 **postMessage**

  - `Web Worker` 中，`Worker` 线程和主线程之间使用结构化克隆算法（`The structured clone algorithm`）进行数据通信。结构化克隆算法是一种通过递归输入对象构建克隆的算法，算法通过保存之前访问过的引用的映射，避免无限遍历循环。这一过程可以理解为，在发送方使用类似 `JSON.stringfy()` 的方法将参数序列化，在接收方采用类似 `JSON.parse()` 的方法反序列化。

  - 但是，一次数据传输就需要同时经过序列化和反序列化，如果数据量大的话，这个过程本身也可能造成性能问题。因此， `Worker` 中提出了 `Transferable Objects` 的概念，当数据量较大时，我们可以选择在将主线程中的数据直接移交给 `Worker` 线程。值得注意的是，这种转移是彻底的，一旦数据成功转移，主线程将不能访问该数据。这个移交的过程仍然通过 `postMessage` 进行传递。


```js
postMessage(message, transferList)
```

- 例如，传递一个 `ArrayBuffer` 对象


```js
var aBuffer = new ArrayBuffer(1)
worker.postMessage({ data: aBuffer }, [aBuffer])
```

- 上下文，作用域

  - `Worker` 工作在一个 `WorkerGlobalDataScope` 的上下文中。每一个 `WorkerGlobalDataScope` 对象都有不同的 `event loop`。这个 `event loop` 没有关联浏览器上下文（`browsing context`），它的任务队列也只有事件（`events`）、回调（`callbacks`）和联网的活动（`networking activity`）。
  - 每一个 `WorkerGlobalDataScope` 都有一个 closing 标志，当这个标志设为 true 时，任务队列将丢弃之后试图加入任务队列的任务，队列中已经存在的任务不受影响（除非另有指定）。同时，定时器将停止工作，所有挂起（`pending`）的后台任务将会被删除。

- **Worker** 中可以使用的函数和类

  - 由于 `Worker` 工作的上下文不同于普通的浏览器上下文，因此不能访问 window 以及 window 相关的 `API`，也不能直接操作 `DOM`。`Worker` 中提供了 `WorkerNavigator` 和 `WorkerLocation` 接口，它们分别是 `window` 中 `Navigator` 和 `Location` 的子集。除此之外，`Worker` 还提供了涉及时间、存储、网络、绘图等多个种类的接口，以下列举了其中的一部分，更多的接口可以参考 `MDN` 文档。

- 时间相关

  - `clearInterval()`
  - `clearTimeout()`
  - `setInterval()`
  - `setTimeout()`

- **Worker** 相关

  - `importScripts()`
  - `close()`
  - `postMessage()`

- 存储相关

  - `Cache`
  - `IndexedDB`

- 网络相关

  - `Fetch`
  - `WebSocket`
  - `XMLHttpRequest`：可以发送`ajax`对象

- 作用域**globalWorkerScope**

  - `navigator`：可以使用`navigator`中的一些对象
  - 可以在`worker`文件中继续生成`worker`对象（`chrome`暂时不支持，浏览器支持情况不好）

## 拖拽/ 读取文件 / WebSocket

### drag & drop（拖拽）

- 常用于各种拖动操作中
- 创建可拖动元素
  - `<div> id='drag' draggable='true'></div>`

- 相关事件

  - `dragstart`：被拖拽元素，开始被拖拽时触发
  - `dragend`：被拖拽元素，拖拽完成时触发
  - `dragenter`：目标元素，拖拽元素进入目标元素触发
  - `dragover`：目标元素，拖拽元素在目标元素上移动触发
  - `drop`：目标元素，被拖拽的元素在目标元素上同时鼠标放开触发
  - 注意：需要阻止`dragover`的默认行为才会触发`drop`事件

- **DragEvent**事件对象

  - 传值
    - `e.dataTransfer.setData("data",e.target.id)`
  - 取值
    - `e.dataTransfer.getData("data")`

- 案例1：把元素拖入到目标元素


```html
<style>
	#item1{
        width: 100px;
        height: 100px;
        background:red;
    }
    #item2{
        width: 100px;
        height: 100px;
        background:green;
    }
    #wrapper{
        width:500px;
        height: 500px;
        background: orange;
    }
</style>

<div id="item1" draggable='true'></div>
<div id="item2" draggable='true'></div>
<div id="wrapper"></div>

<script>
    //被拖拽对象
    var oItem1 = document.getElementById("item1");
    var oItem2 = document.getElementById("item2");
    //目标对象
    var oWrapper = document.getElementById("wrapper");
    oItem1.addEventListener('dragstart',function(e){
        e.dataTransfer.setData('data',this.id);

    },false);

    oItem2.addEventListener('dragstart',function(e){
        e.dataTransfer.setData('data',this.id);
    },false);

    //阻止dragover的默认行为
    oWrapper.addEventListener('dragover',function(e){
        e.preventDefault();
    })

    oWrapper.addEventListener('drop', function(e){
        //调用PreventDefault()来避免浏览器对数据的默认处理（drop事件的默认行为是以链接形式打开）
        e.preventDefault();
        //获取得到的对象，插入到目标对象
        var data = e.dataTransfer.getData('data');
        oWrapper.appendChild(document.getElementById(data));
    }, false)
</script>
```

- 案例2：拖拽插入、[**删除元素**]()


```html
<style>
    *{
        padding: 0;
        margin: 0;
        list-style: none;
    }
    ul{
        margin: 35px;
    }
    li{
        width: 200px;
        height: 30px;
        margin: 10px;
        background:#ccc;
        text-align: center;
        line-height: 30px;
        font-size: 25px;
    }
    .wrapper{
        width:300px;
        height: 300px;
        background: black;
    }
</style>


<ul>
    <li draggable='true'>1</li>
    <li draggable='true'>2</li>
    <li draggable='true'>3</li>
    <li draggable='true'>4</li>
    <li draggable='true'>5</li>
</ul>
<div class="wrapper"></div>

<script>
    var oLi = document.getElementsByTagName('li'),
        oUl = document.getElementsByTagName('ul')[0],
        len = oLi.length,
        oWrapper = document.getElementsByClassName('wrapper')[0];

    function bindLiEvent(){
        for(var i = 0;i < len;i ++){
            oLi[i].addEventListener('dragstart',function(e){
                //根据当前dom元素的顺序重新获取i值
                var index = getIndex(this);
                //添加参数
                e.dataTransfer.setData('data',index);
            },false);

            oLi[i].addEventListener('dragover',function(e){
                //取消dragover默认事件，让drop生效
                e.preventDefault();
            },false);

            oLi[i].addEventListener('drop',function(e){
                //取出参数i,把第i个元素插入到目标元素的前面
                var i = e.dataTransfer.getData('data');
                console.log(i);
                oUl.insertBefore(oLi[i], this);
            },false);
        }  
    }

    //查找当前这个元素拖拽的索引值
    function getIndex(dom){
        for(var i = 0;i < len;i++){
            if(oLi[i] == dom){
                return i;
            }
        }
    }
    bindLiEvent();

    //删除元素
    function removeLi(){
        oWrapper.addEventListener('dragover',function(e){
            e.preventDefault();
        },false);
        oWrapper.addEventListener('drop',function(e){
            var index = e.dataTransfer.getData('data');
            oLi[index].remove();
        },false);
    }
    removeLi();
</script>
```

- 案例3，拖拽上传文件


```javascript
var ele = document.getElementsByClassName('wrapper')[0];

ele.addEventListener('dragover',function(e){
e.preventDefault();
},false);

ele.addEventListener('drop',function(e){
    e.preventDefault();
    console.log(e);
    var dt = e.dataTransfer;
    var files = dt.files;
    console.log(files);
},false);
```

[在线演示](http://codepen.io/poetries/pen/XpbEOW)

### FileReader（读取文件）

> 用于读取文件

- 方法：

  - `abort()`：终止读取
  - `readAsBinaryString(file)`：将文件读取为二进制编码
  - `readAsDataURL(file)`：将文件读取为二进制编码
  - `readAsText(file,[encoding])`：将文件读取为文本
  - `readAsArrayBuffer(file)`：将文件读取为`arraybuffer`

- 事件：

  - `loadstart`：读取开始时触发
  - `progress`：读取中
  - `loadend`： 读取中完成触发，无论成功或失败
  - `load`：文件读取成功完成时触发
  - `abort`：中断时触发
  - `error`：出错时触发

- 获取读取的结果


```js
fr.onload = function(){
    this.result;
}
```

### Web Socket

>*WebSocket*对象提供了一组*API*，用于创建和管理*WebSocket*连接，以及通过连接发送和接收数据。
>
>*WebSocket*其实是一个新协议，跟*HTTP*协议基本没有关系，只是为了兼容现有浏览器的握手规范而已，借用了*HTTP*的协议来完成握手
>
>>  ![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111704365.png)

- 产生原因
  - 在`HTTP/1.0`中，大多实现为每个请求/响应交换使用新的连接
  - 在`HTTP/1.1`中，一个连接可用于一次或多次请求/响应交换
  - `HTTP`协议中，服务端不能主动联系客户端，只能有客户端发起
  - `WebSocket`服务器和客户端均可主动发送数据
- 建立连接的握手
  - 当`Web`应用程序调用`new WebSocket(url)`接口时，`Browser`就开始了与地址为`url`的`WebServer`建立握手链接的过程
  - 1.`Browser`与`WebSocket`服务器通过`TCP`握手建立连接，如果这个建立连接失败，那么后面的过程就不会执行，`Web`应用程序将收到错误消息通知
  - 2.在`TCP`建立连接成功后，`Browser`通过`http`协议传送`WebSocket`支持的版本号，协议的字版本号，原始地址，主机地址等等一些列字段给服务器
  - 3.`WebSocket`服务器收到`Browser`发送来的请求后，如果数据包数据和格式正确，客户端和服务器端协议版本号匹配等等，就接受本次握手链接，并给出相应的数据回复，同样回复的数据也是采用`http`协议传输
  - 4.`Browser`收到服务器回复的数据包后，如果数据包内容、格式都没有问题的话，就表示本次连接成功，触发`onopen`消息，此时`Web`开发者就可以在此时通过`send`接口向服务器发送数据。否则，握手连接失败，`Web`应用程序会受到`onerror`消息，并且能知道连接失败的原因
- 三次握手
  - 第一次握手：建立连接时，客户端`A`发送`SYN`包`（SYN=j）`到服务器`B`，并进入`SYN_SEND`状态，等待服务器`B`确认。
  - 第二次握手：服务器`B`收到`SYN`包，必须确认客户`A`的`SYN（ACK=j+1）`，同时自己也发送一个`SYN`包`（SYN=k）`，即`SYN+ACK`包，此时服务器B进入`SYN_RECV`状态。
  - 第三次握手：客户端`A`收到服务器`B`的`SYN＋ACK`包，向服务器`B`发送确认包`ACK（ACK=k+1）`，此包发送完毕，客户端`A`和服务器`B`进入`ESTABLISHED`状态，完成三次握手。
  - 完成三次握手，客户端与服务器开始传送数据
  - `WebSocket`请求头/响应头
    - ![请求头](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111704765.png)
    - ![响应头](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111704159.png)
  - `HTTP`请求头/响应头
    - ![请求头](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111705946.png)
    - ![响应头](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111705105.png)
  
- 创建**WebSocket**
  - `var Socket = new WebSocket(url);`

- 方法

  - | 方法             | 方法         | 作用                 |
    | ---------------- | ------------ | -------------------- |
    | `Socket.send()`  | `send(data)` | 使用连接传输数据     |
    | `Socket.close()` | `close()`    | 用于终止任何现有连接 |

- 事件

  - | 事件      | 事件处理程序       | 描述                         |
    | --------- | ------------------ | ---------------------------- |
    | `open`    | `Socket.onopen`    | 建立socket连接时触发这个事件 |
    | `message` | `Socket.onmessage` | 客户端从服务器接收数据时触发 |
    | `error`   | `Socket.onerror`   | 连接发生错误时触发           |
    | `close`   | `Socket.onclose`   | 连接被关闭时触发             |

- **WebSocket**的优点

  - 客户端与服务器都可以主动传送数据给对方
  - 不用频率创建`TCP`请求及销毁请求，减少网络带宽资源的占用，同时也节省服务器资源

- 注:`WebSocket.org`提供了一个专门用来测试`WebSocket`的服务器`ws://echo.websocket.org`


```javascript
//ws://echo.websocket.org是一个测试websocket的服务器接口，就是你发送什么，它返回什么
var Socket = new WebSocket("ws://echo.websocket.org");

Socket.onopen = function() {
    Socket.send('Hello');
}

Socket.onmessage = function(e) {
    console.log('message');
    console.log(e);
    console.log(e.data);
    Socket.close(); //发送完之后需要关闭连接，否则会报错
}

Socket.onclose = function(e) {
    console.log('close');
    console.log(e);
}

Socket.onerror = function() {
    console.log('error')
}
```

## HTML5新增JS方法

---


![H5在JavaScript中新增的方法一览](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111705422.png)


- **新增选择器**
    - `document.querySelector() ` 选择单个元素
    - `document.querySelectorAll() ` 选择所有的
    - `document.getElementsByClassName()` 通过类名选择

- **延迟加载JS**

    - `JS`的加载会影响后面的内容加载
      - 很多浏览器都采用了并行加载JS，但还是会影响其他内容
    - `Html5`的`defer`和`async`
      - `defer=“defer ”`: 延迟加载，会按顺序执行，在`onload`执行前被触发
      - `async =“async”`: 异步加载，加载完就触发，有顺序问题
    - 浏览器兼容性：`Labjs`库

```javascript
/**
* 动态加载script文件 （推荐方法） 只需请求一次 可加载多个JavaScript文件，减少请求次数以及页面的加载阻塞
*/
function loadScript(url,callback){
	var script = document.createElement("script");
	script.type = "text/javascript";
	if(script.readyState){//IE
		script.onreadystatechange = function(){
			if(script.readyState == "loaded" || script.readyState == "complete"){
				onreadystatechange = null;
				callback();
			}
		}
		
	}else {
		script.onload = function(){
			callback();
		}
	}
	script.src = url;
	document.getElementsByTagName("head")[0].appendChild(script);
}
loadScript("js/defer.js",function(){
	console.log("加载成功");
      //  加载成功回调
});
loadScript("js/async.js",function(){
	console.log("加载成功");
   //  加载成功回调
});
```

- **获取`class`列表属性**
    - `classList`
        - `length` :  `class`的长度
        - `add() ` :  添加`class`方法
        - `remove()`  :  删除`class`方法
        - `toggle()` :  切换`class`方法 
        - `contains()` : 判断类名是否存在返回`bool`值

- **`JSON`的新方法**
  - `parse()` : 把字符串转成`json`
    - 字符串中的属性要严格的加上引号
  - `stringify()` : 把`json`转化成字符串
    - 会自动的把双引号加上

  - 与`eval`的区别
    - `eval()`：对任何的字符串进行解析变成js
    - `parse()`：字符串中的属性要严格的加上引号
  - 其他浏览器兼容
    - [去下载json2.js](http://www.json.org/)

- **历史管理**
  - `onhashchange` ：改变`hash`值来管理

## 跨文档操作

---

- **跨文档请求**

- 同域跨文档
  - `iframe`内页：
    - 父页面操作子页面：`contentWindow`
    - 子页面操作父页面：`window.top`(找到最顶级的父页面)/`parent`(第一父页面)
    - 新窗口页：
      - 父页面操作子页面：`window.open`
      - 子页面操作父页面：`window.opener`

- **不同域跨文档**
  - `postMessage（“发送的数据”,”接收的域”）`
    - `message`事件监听
    - `ev.origin `发送数据来源的域
    - `ev.data ` 发送的数据
  - 通过判断发送的数据来执行相应的需求

- **ajax跨域**

  - `XMLHttpRequest` 新增功能
    - 跨域请求：修改服务端头信息
      - I`E`兼容：`XDomaiRequest`

  - 进度事件：
    - `upload.onprogress(ev) ` 上传进度(实现文件上传进度条)
      - `ev.total`  发送文件的总量
      - `ev.loaded` 已发送的量
    - `FormData`  构建提交二进制数据

- 拓展阅读
  
  - [HTML5 API 大盘点](http://mp.weixin.qq.com/s?__biz=MzI0ODA2ODU2NQ==&mid=2651130595&idx=2&sn=3d0f546f1867992729b3ace5d03766fc&chksm=f257ca59c520434f08e215b3bdcec3764712f73301b738c18163359e5aa5e949ff019616ffca&mpshare=1&scene=23&srcid=11289XUSBAQzrCp3Io55aoS1#rd)
## 附录二　HTML5速查表

---

  - [可以查阅支持H5+CSS3的属性](http://caniuse.com/#search=canvas)
  - [HTML5 标签含义之元素周期表](http://www.html5star.com/manual/html5label-meaning/)
  - [HTML5标签速查表](https://raw.sevencdn.com/Luckiiest/Note/master/Web/H5C3/15.png)
  - [展示 flexbox 属性的作用--推荐](chrome-extension://ikhdkkncnoglghljlkmcimlnlhkeamad/pdf-viewer/web/viewer.html?file=http%3A%2F%2Fjonibologna.com%2Fcontent%2Fimages%2Fflexboxsheet.pdf)
  - [Flexbox 视觉指南--更好更容易地理解 Flexbox 某个属性的作用](https://demos.scotch.io/visual-guide-to-css3-flexbox-flexbox-playground/demos/)

# CSS3

## 简介

- `CSS3`发展史简介
  
  - `HTML`的诞生 20世纪90年代初
  - `1996`年底，	`CSS`第一版诞生
  - `1998`年`5`月 	`CSS2`正式发布
  - `2004`年 	`CSS2.1`发布
  - `CSS3`的发布	`2002 ` `2003`  `2004` `2005`  `2007` `2009` `2010`
  
- **what is CSS3？**

  - CSS3是CSS2的升级版本，3只是版本号，它在CSS2.1的基础上增加了很多强大的新功能。目前主流浏览器chrome、safari、firefox、opera、甚至360、QQ浏览器都已经支持了CSS3的大部分功能了，IE10以后也开始全面支持CSS3了。
  - 标准写法：

  | 前缀     | 浏览器          |
  | -------- | --------------- |
  | -webkit- | chrome / safari |
  | -moz-    | firefox         |
  | -ms-     | IE              |
  | -o-      | opera-          |


- **CSS的功能**
- 提供了更加强大且精准的选择器，提供多种背景填充方案，可以实现渐变颜色，可以改变元素的形状、角度等，可以加阴影效果，报纸布局，弹性盒子，ie6混杂模式的盒模型，新的计量单位，动画效果等等……
  - 但是css3的兼容性的问题同样也显得格外重要，并不是所有的css3属性都通过了w3c标准，所以……我们需要全面性的查阅兼容性手册
    - http://www.runoob.com/cssref/css3-browsersupport.html
    - https://caniuse.com/
- **模块化开发**
- `CSS1` 中定义了网页的基本属性：
    - 字体、颜色、基本选择器等
  - `CSS2`中在`CSS1`的基础上添加了高级功能
    - 浮动和定位、高级选择器等(子选择器、相邻选择器、通用选择器)
  - `CSS3`遵循的是模块化开发。发布时间并不是一个时间点，而是一个时间段

## 选择器

- **伪元素选择器：**
	- `::first-line` ：匹配文本块的首行
	- `::first-letter` ：选择文本块的首字母
	- `::selection `：鼠标光标选择元素内容
	- `::user-selection:none`：不让用户选中


- **CSS3结构选择器**

    - `nth-child(n)`：父元素下的第n个子元素
    - `nth-child(odd)`：奇数子元素同`nth-child(2n-1)`
    - `nth-child(even)`：偶数子元素同`nth-child(2n)`
    - `nth-child(an+b)`：公式
    - `nth-last-child(n)`：倒数第n个子元素
    - `first-of-type`：父元素下指定类型的第一个元素
    - `last-of-type`：父元素下指定类型的最后一个元素
    - `nth-of-type(n)`：父元素下的指定类型的元素的第n个元素
    - `nth-last-of-type`：父元素下的倒数第几个指定类型的子元素
    - `first-child`：父元素下的第一个子元素、
    - `last-child`：父元素下的最后一个子元素
    - `only-child`：父元素下的唯一的子元素
    - `only-of-type`：选择父元素下指定类型的唯一子元素
    - `E > F` E的第一代子元素中是F的
    - `E + F`E后面紧挨着的F兄弟节点
    - `E ~ F`E后面所有的兄弟节点


- **`Css3` 属性选择器**

  - `E[attr]`：属性名，不确定具体值
  - `E[attr='value']`：指定属性名，并指定对应属性值
  - `E[attr~="value"]`：指定属性名，其具有多个属性值空格隔开，并包含`value`值，意思就是在`class`属性中任意一个位置有`value`就可以，不必要第一个
  - `E[attr^="value"]`：指定属性名，属性值以`value`值开头
  - `E[attr$="value"]`：指定属性名，属性值以`value`值结束
  - `E[attr*="value"]`：指定了属性名，属性值中包含了`value`
  - `E[attr|="value"]`：指定属性名，属性值以`value`开头


- **`CSS3`伪类选择器**
- `:before`,`:after`在元素内容前面、后面添加内容(相当于行内元素)
    - **UI状态伪类选择器：**
    
  - `:enabled `选择启用状态元素
      - `:disabled` 选择禁用状态元素
      - `:checked `选择被选中的`input`元素（单选按钮或复选框）
      - `:default` 选择默认元素
      - `:valid`、`invalid` 根据输入验证选择有效或无效的`input`元素
      - `:in-range`、`out-of-range`选择指定范围之内或者之外受限的元素
      - `:required`、`optional `根据是否允许:`required`属性选择`input`元素
      - `:read-only`选择只读的元素
      - `read-write`选择非只读的元素
      - **动态伪类选择器：**
      
    - `:link `选择链接元素
        - `:visited` 选择用户以访问的元素
        - `:hover` 鼠标悬停其上的元素
        - `:active `鼠标点击时触发的事件
        - `:focus` 当前获取焦点的元素
    - **其他伪类选择器**：
        - `root`：选择文档的根目录、返回`html`
        - `:not(<选择器>) `对括号内选择器的选择取反
        - `:lang(<目标语言>)` 基于`lang`全局属性的元素
        - `:target` `url`片段标识符指向的元素
        - `:empty`选择内容为空的元素

## 文本
---

- **CSS文本属性复习**
    - **white-space**：对象内空格的处理方式
      - `nowrap` 控制文本不换行
		
      - `pre` 空白会被浏览器保留

      - `pre-line` 合并空白  保留换行符

      - `pre-wrap` 保留空白  正常换行

    - **direction**：文本流的方向
      - `ltr` 文本从左向右
      - `rtl`  文本从右往左

    - **unicode-bidi**：用于同一个页面里存在从不同方向读进的文本显示。与`direction`属性一起使用

- **CSS3新增文本属性**
    - `color:rgba()`;
    - `text-overflow`:是否使用一个省略标记（...）标示对象内文本的溢出
    - `text-align`:文本的对齐方式
    - `text-transform`:文字的大小写
    - `text-decoration`:文本的装饰线，复合属性
    - `text-shadow`:文本阴影
    - `text-fill-color`:文字填充颜色
    - `text-stroke`:复合属性。设置文字的描边
    - `tab-size`:制表符的长度
    - `word-wrap`:当前行超过指定容器的边界时是否断开转行
    - `word-break`:规定自动换行的处理方法
    - `font-face`


- **text-overflow**：是否使用一个省略标记（`...`）标示对象内文本的溢出
  
    - `clip`： 默认值 无省略号
    - `ellipsis`：当对象内文本溢出时显示省略标记（`...`）。
- **注意**：该属性需配合`over-flow:hidden`属性(超出处理)还有 `white-space:nowrap`(禁止换行)配合使用，否则无法看到效果
  
- **text-align**：文本的对齐方式

    - `left`:默认值 左对齐
    - `right`:右对齐
    - `center`:居中
    - `justify`： 内容两端对齐。
    - `start`:开始边界对齐
    - `end`:结束边界对齐

- **text-transform**：文字的大小写
  
    - **`css1`**
        - `none`：	默认值 无转换 
        - `capitalize`： 	将每个单词的第一个字母转换成大写 
        - `uppercase`：	转换成大写 
        - `lowercase`：	转换成小写
    - **`css3`**
        - `full-width`：	将左右字符设为全角形式。不支持
	    - `full-size-kana`：将所有小假名字符转换为普通假名。不支持
		- 例如：土耳其语
    
- **text-decoration**：文本的装饰线，复合属性(只火狐支持)
  
    - `text-decoration-line `：
         - 指定文本装饰的种类。相当于`CSS1`时的`text-decoration`属性
    - `text-decoration-style` ：
        - `指定文本装饰的样式。
    - `text-decoration-color`：
         - `指定文本装饰的颜色。
    - `blink`： 指定文字的装饰是闪烁。  `opera`和`firefox`
- `text-decoration` : `#F00 double overline`   `CSS3`实例
  
- **text-shadow**：文本阴影
  
    - 取值：`x ` `y`   `blur` `color`,......
        - `x  `  	横向偏移
        - `y `   	纵向偏移
        - `blur `     模糊距离(灰度)
    - `color`    阴影颜色
    
- **text-fill-color**：文字填充颜色

- **text-stroke**：复合属性。设置文字的描边
  
  - `text-stroke-width`:文字的描边厚度 
  - `text-stroke-color`:文字的描边颜色 
  
- **tab-size**：制表符的长度   
  
    - 默认值为`8`(一个`tab`键的空格字节长度)，在	`pre`标签之内才会有显示
    
- **word-wrap**：当前行超过指定容器的边界时是否断开转行

  - `normal`： 默认值
  - `break-word`：在长单词或 URL 地址内部进行换行。
  - 允许内容顶开或溢出指定的容器边界。 

- **break-word**：内容将在边界内换行。如果需要，单词内部允许断行
  
  
    - `normal`： 使用浏览器默认的换行规则
    - `break-all`：允许在单词内换行
    - `keep-all`：只能在半角空格或连字符处换行
    
- **font-face**


    - 自定义字体
    
    - ```css
        @font-face {
            font-family:'myFirstFamily'; // 字体名字
            src: url('./Christmas Day Personal Use.ttf'); // 字体路径
        }
        
        兼容
        @font-face {
        	font-family: 'diyfont';
        	src: url('diyfont.eot'); /* IE9+ */
        	src: url('diyfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
        		 url('diyfont.woff') format('woff'), /* chrome、firefox */
        		 url('diyfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
        		 url('diyfont.svg#fontname') format('svg'); /* iOS 4.1- */
        }
        
        http://www.w3cplus.com/content/css3-font-face
        ```
    
    - `format`: 此值指的是你自定义的字体的格式，主要用来帮助浏览器识别浏览器对`@font-face`的兼容问题，这里涉及到一个字体`format`的问题，因为不同的浏览器对字体格式支持是不一致的，浏览器自身也无法通过路径后缀来判断字体


## 背景
---

- **CSS背景属性复习**

  - `background`:
    - `background-color`:背景颜色
    - `background-image`:背景图片
    - `background-repeat`:背景重复
    - `background-position`:背景定位
  - `background-attachment`:背景固定(`scroll/fixed)`

- **CSS3新增背景属性**

- **bakground-size**：背景尺寸

  - 设置背景图片的大小，以长度值或百分值或百分比显示，还可以通过`cover`和`contain`来对图片进行伸缩
  - 语法：
    - **background-size**:` auto `| `<长度值>` | `<百分比> `| `cover` | `contain`
- 属性：
    - `auto`：默认值，不改变背景图片的原始高度和宽度
      - `<长度值>`: 成对出现如`200px` `50px`，将背景图片宽高一次设置为前面两个值，当设置一个值时，将其作为图片宽度值来等比缩放
      - `<百分比>`: `0%~100%`之间的任何值，将背景图片宽高依次设置为所在元素宽高乘以前面百分比得出的数值，当设置一个值时同上；
      - `cover`: 用一张图片铺满整个背景，如果比例不符，则截断图片
      - `contain`: 尽量让背景内，存在一整张图片

- 多背景

  - `background-image:url(1.jpg),url(2.jpg)`;

- **background-origin** ：背景区域定位

  - 背景图片的起始位置
  - 原来的背景图片是从`padding`区域开始引入的，可以使用这个属性来更改引入区域
  - `border-box`： 从`border`区域开始显示背景。 
  - `padding-box`： 从`padding`区域开始显示背景。 
  - `content-box`： 从`content`内容区域开始显示背景。

- **background-clip** ：背景绘制区域

  - 裁剪背景

    - `border-box`： 从`border`区域向外裁剪背景。 
    - `padding-box`： 从`padding`区域向外裁剪背景。 
    - `content-box`： 从`content`区域向外裁剪背景。 
    - 分别表示从边框、内边距和内容区域往外裁剪背景，`no-clip`表示不裁切和参数`border-box`显示同样的效果。`background-clip`默认值为`border-box`

  - `text`:背景填充文本

    - `background-clip: text`;

    - 从前景内容的形状作为裁剪区域向外裁剪，如此即可实现使用背景作为填充色之类的遮罩效果

    - 注意它是-webkit-独有的属性，且必须配合`-text-fill-color-`属性


```css
-webkit-background-clip: text;
-webkit-text-fill-color: transparent;
text-fill-color: -webkit-background-clip;
```

- **颜色渐变**
  - **线性渐变**：`linear-gradient`(起点/角度 半径，颜色 位置，...,)
      - 起点：`left/top/right/bottom/left top...... `默认`top`
      - 角度：逆时针方向 `0-360deg`（度），起点和角度一样
      - 半径：可以控制渐变圆的大小
      - 颜色 位置：`red 50%`, `blue 100%`(红色从50%渐变到100%为蓝色)
      - `repeating-linear-gradient`  线性渐变重复平铺
      - `IE`低版本渐变(滤镜)：
      - `filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff',endColorstr='#ff0000',GradientType='1');`
      
  - **径向渐变**：`radial-gradient`(起点(圆心位置) at 形状/半径/大小,  颜色1,  颜色2)
      - 起点：`left/top/right/bottom`或具体值/百分比
      - 形状：`ellipse`(椭圆)、`circle`(正圆)
      - 形状\半径\大小：具体数值或百分比，也可以是关键字（`closest-side`(最近端), `closest-corner`最近角), `farthest-side`(最远端), f`arthest-corner`(最远角), `contain`(包含) ,`cover`(覆盖)）;
      - 颜色 位置：`red 50%`, `blue 100%`(红色从50%渐变到100%为蓝色)



## 颜色
---

- **CSS颜色属性复习**
    - `color name `    颜色英文名称命名
    - `HEX`方式         十六进制方式
    - `rgb`方式           三原色配色方式

### rgba()颜色

- `RGB`是一种色彩标准，是由红`(R)`、绿`(G)`、蓝`(B)`的变化以及相互叠加来得到各式各样的颜色。`RGBA`是在`RGB`的基础上增加了控制`alpha`透明度的参数。

- 语法：`color: rgba(R, G, B, A)`

    - 以上`R`、`G`、`B`三个参数，正整数值的取值范围为：0 - 255。百分数值的取值范围为：0.0% - 100.0%。超出范围的数值将被截至其最接近的取值极限。并非所有浏览器都支持使用百分数值。`A`为透明度参数，取值在0~1之间，不可为负值。

- |名称|颜色|颜色|取值|
  |---|---|---|---|
  |r    |     red      |	  红色   |  0-255|
  |g     |   green   |  绿色  |  0-255|
  |b     |   blue    |   蓝色   |  0-255|
  |a      |  alpha    | 透明  |   0-1|

### HSL模式  HSLA 模式

- `H`： `Hue`(色调)。
    - 0(或360)表示红色，120表示绿色，240表示蓝色，也可取其他数值来指定颜色。取值为：`0 - 360` 
- `S`：` Saturation`(饱和度)。取值为：0.0% - 100.0% 
- `L`： `Lightness`(亮度)。取值为：0.0% - 100.0%
- `A`:    `alpha  `   透明度   0~1之间

- 语法:`HSLA(H,S,L,A)`

- HSL色轮

    - ![HSL色轮](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111706388.png)


- **透明颜色：`transparent`**
    - 实例：`border`实现三角箭头、风车等

- **透明度：**
	- `opacity`
	- 取值：`0-1`之间
	- 注：低版本的`IE`浏览器不兼容,需用IE浏览器的滤镜实现相同效果，`filter:alpha(opacity=50)`
	- 对于低版本的火狐浏览器需添加内核前缀，`-moz-opacity`


## 边框
---

### 圆角
---

- 边框圆角
    - 在` CSS2 `中添加圆角矩形需要技巧。我们必须为每个圆角使用不同的图片
    - 在 `CSS3 `中，创建圆角是非常容易的
    - 在` CSS3 `中，`border-radius `属性用于创建圆角
    
- **border-radius**：边框圆角写法
  
  - `border-radius: 2em 1em 4em / 0.5em 3em;`
  - 等价于
```css
border-top-left-radius: 2em 0.5em;
border-top-right-radius: 1em 3em;
border-bottom-right-radius: 4em 0.5em;
border-bottom-left-radius: 1em 3em;
```

### 边框系列-图片
---

- **border-image**：语法

|属性|	版本|	简介|
|---|---|---|
|`border-image`|	CSS3|	设置或检索对象的边框使用图像来填充|
|`border-image-source`| CSS3|设置或检索对象的边框是否用图像定义样式或图像来源路径|
|`border-image-slice`|	CSS3|	设置或检索对象的边框背景图的分割方式|
|`border-image-width`|	CSS3|	设置或检索对象的边框厚度|
|`border-image-outset`|	CSS3|	设置或检索对象的边框背景图的扩展|
|`border-image-repeat`|	CSS3|	设置或检索对象的边框图像的平铺方式|

- **`border-image-slice`**
  - 设置或检索对象的边框背景图的分割方式

![Paste_Image.png](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111706283.png)

- **`border-image-repeat`**
  - 用于指定边框背景图的重复方式
  - 取值：
    - `stretch`： 指定用拉伸方式来填充边框背景图。 *默认的
    - `repeat`： 指定用平铺方式来填充边框背景图。当图片碰到边界时，如果超过则被截断。 
    - `round`： 指定用平铺方式来填充边框背景图。图片会根据边框的尺寸动态调整图片的大小	直至正好可以铺满整个边框。写本文档时仅Firefox能看到该效果 

    
## 布局/盒模型

---

### columns

- 多列布局

- 为了能在`Web`页面中方便实现类似报纸、杂志那种多列排列的布局，`W3C`特意给`CSS3`增加了一个多列布局模块（`CSS Multi Column Layout Module`）。它主要应用在文本的多列布局方面，这种布局在报纸和杂志上都使用了几十年了，但要在Web页面上实现这样的效果还有有相当大的难度，庆幸的是，CSS3的多列布局可以轻松实现

- 语法

  - **columns:**

    - `columns` ：宽度 列数; 混合属性

      - 例如：`columns:200px 3`

    - `column-width`： 指的是每一列的宽度，根据容器宽度自适应

    - `column-count` ：指定规定的列数，唯一精准的是列数

      - *column-width和column-count两个不要一起使用，会混乱*

    - **column-gap**：列宽

      - 设置列与列之间的宽度，直接用数值表示即可
      - 用来设置列与列的间距，如果没有显示设置column-gap值时，其值大小会根据浏览器默认的font-size来决定
      - `column-width `= `(width - (n - 1) * font - size) / n`
        - `n`是几列

    - **column-rule**：列的边框 

      - `column-rule`: 宽度  线的类型  颜色
        - 例：`column-rule:1px solid #ccc`

      - 不占用任何空间位置，在列与列之间改变其宽度不会改变任何列的位置。
      - `column-rule-width `
        - 用来定义列边框的宽度，其默认值为`medium`
        - 接收浮点数，但是不接受负值
        - 属性值：`medium`、`thick`、`thin`
      - `column-rule-style`
        - 样式
        - 定义列边框样式，其默认值为“none”
        - `column-rule-style`：属性值与`border-style`属性值相同
        - 属性值：`none`、`hidden`、`dotted`、`dashed`、`solid`、`double`、`groove`、`ridge`、`inset`、`outset`
      - `column-rule-color` 颜色

    - **column-span**：`1` / `all`

      - 只可以跨`1`列或者所有列
      - 设置多列布局元素内的子元素，可以跨列，类似标题效果。即一个新闻标题要横跨所有内容列。
      - 注：此属性要在子元素上设置

### 盒模型

- 在`CSS`中盒模型分为两种，第一种是W3C的标准盒模型，另一种是IE6混杂模式的传统模型。他们都是对元素计算尺寸的模型。但他们的不同是计算的方式不同。
- **W3C标准盒模型**
  - `element`空间高度（盒子）= `width `+ `padding` + `border`
  - `width`为内容高度。即`width`不包括`padding`和`border`

  - ![标准盒子模型](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111707818.jpg)
- **IE6混杂模式盒模型**
  - 内容高度（盒子） = `width` - `padding` - `border`
  - `width`的数值就是`element`盒子的空间高度，`width`包括了`padding`和`border`
  - ![IE盒子模型](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111707578.jpg)

- **box-shadow**:`inset` `x` `y` `blur` `spread` `color`
  - `inset`：投影方式
  - `inset`：内投影
  - `outset`：外投影 默认(不能设置)
  - `x`、`y`：阴影偏移
  - `blur`：模糊半径（灰度）
  - `spread`：扩展阴影半径
  - 先扩展原有形状，再开始画阴影
  - `color`
- **box-reflect**：倒影
  - 方向 ` above | below | left | right;`
  - 距离
    - 渐变（可选）

### 弹性盒子

- 有主轴`（x）`侧轴 / 交叉轴`（y）`
- 给父级设置的`diaplay:flex`叫`flex`盒子，它里面的盒子叫做`flex`项目
- `display: flex`：给父级设置盒子属性
- `flex` 是一个复合属性，且必须配合父元素`display: flex`使用
- **以下六个属性是设置在项目（子元素）上的：**
  - **flex-grow** ：放大比例
    - 进行比例的分配，定义项目的放大比例，默认为0，即如果存在剩余空间，也放大
    - 根据所设置的比例分配盒子剩余的空间
  - **flex-shrink**：缩小比例
    - 定义了项目的缩小比例，默认为1，即如果空间不足，该项目将缩小
    - 设置元素的收缩比例——多出盒子的部分，按照比例的大小砍掉相应的大小，即比例越大，被砍得越大，默认值`1`
    - 缩减的宽度 = `(flex-shrink1 * width1) / (flex-shrink2 * width1 + flex-shrink2 * width2) * moveWidth`
  - **flex-basis**：伸缩基准值
    - 伸缩基准值，项目占据主轴空间
    - 定义了在分配多余空间之前，项目占据的主轴空间（`main size`），浏览器根据这个属性，计算主轴是否有多余空间，他的默认值为`auto`，即项目本来大小
    - 该属性设置元素的宽度或高度，当然`width`也可以用来设置元素宽度，如果元素上同时出现了`width`和`flex-basis`那么`flex-basis`会覆盖width的值
    - 子元素宽度尽可能按照`basis`来如果基准值相加大于容器宽度那么下面由下面公式分配宽度给子元素
    - `（flex-basis / (flex - basis 相加） * 容器的宽度)`
  - **flex**：是`flex-frow`，`flex-shrink`，`flex-basis`的简写
    - 默认值为：`flex:0 1 auto`
    - 常用简化写法
      - `flex:1`;  ——  `flex:1 1 0%`;
      - `flex:3`;  ——  `flex:3 1 0%`;
      - `flex:auto`; —— `flex: 1 1 auto`;
      - `flex:none`; —— `flex: 0 0 auto`;
    - `flexbox`布局和原来的布局是两个概念，部分`css`属性在`flexbox`盒子里面不起作用，`float`，`clear`，`column`，`vertical-align`等等
    - 建议使用这个属性，而不是单独写三个分离的属性，因为浏览器会推算相关值
    - 真实情况
      - `son1` = (`flex-shrink`) * `flex-basis`
      - `son2` = (`flex-shrink`) * `flex-basis`
      - `sonN` = (`flex-shrink`) * `flex-basis`
      - 加权值 = `son1` + `son2` + …… + `sonN`
      - 压缩的宽度 `w` = (子元素`flex` - `basis`值  * （`flex-shrink`) / 加权值) * 溢出值
      - 缩减值1：(`flex-basis1 * 1` / 加权值) * 溢出值
      - 缩减值2：(`flex-basis2 * 2` / 加权值) * 溢出值
      - 缩减值3：(`flex-basis3 * 3` / 加权值) * 溢出值
      - 最后`son1`、`son2`、`son3`的实际宽度为：
        - `flex-basis` - 缩减值 `n` = `son n` 真实宽度
  - **order**：排列顺序
    - `number`定义项目的排列顺序。数值越小，排列越靠前，默认为`0`
  - **align-self** ：单个项目对齐方式
    - `align-self`属性允许单个项目有与其他项目不一样的对齐方式，可覆盖`align-items`属性，默认值为`auto`，表示继承父元素的`align-items`属性，如果没有父元素，则等同于`stretch`
    - `auto`：自动排序
    - `flex-start`：最开始的位置排序
    - `flex-end`：最后的位置排序
    - `center`：中间排序
    - `baseline`：以第一行文字的基准线对齐
    - `stretch`：如果项目未设置高度或设置为`auto`，将占满整个父级容器的高度
- **以下六个属性设置在容器上**
  - **flex-direction**：决定主轴方向
    - 决定主轴的方向，即项目的排列方向
    - `row`：（默认值）主轴为水平方向，起点在左端
    - `row-reverse`：主轴为水平方向，起点在右端
    - `column`：主轴为垂直方向，起点在上沿
    - `column-reverse`：主轴为垂直方向，起点在下沿
  - **flex-wrap** 是否换行
    - 默认情况下，项目都排在一条线（又称“轴线”）上。`flex-wrap`属性定义，如果一条轴线排不下，如何换行。
    - `nowrap`：（默认）：不换行
    - `wrap`：换行，第一行在上方
    - `wrap-reverse`：换行，第一行在下方
  - **flex-flow**  
    - `flex-flow`属性是`flex-direction`属性和`flex-wrap`属性的简写形式，默认值为`row` `nowrap`
  - **justify-content**
    - 定义了项目在主轴上的对齐方式
    - `flex-start`：左对齐
    - `flex-end`：右对齐
    - `center`：居中
    - `space-between`：两端对齐，项目之间的间隔都相等
    - `space-around`：每个项目两侧的间隔相等。所以，项目之间的间隔比项目与边框的间隔大一倍
  - **align-items**
    - 定义项目在侧轴上的对齐方式
    - `flex-start`：交叉轴的起点对齐
    - `flex-end`：交叉轴的中点对齐
    - `center`：交叉轴的中点对齐
    - `baseline`：项目的第一行文字的基线对齐
    - `stretch`：（默认值）：如果项目未设置高度或设置为`auto`，将占满整个容器的高度
  - **align-content**
    - 定义了多根轴线的对齐方式，如果项目只有一根轴线，该属性不起作用
    - `flex-start`：与交叉轴的起点对齐
    - `flex-end`：与交叉轴的终点对齐
    - `center`：与交叉轴的中点对齐
    - `space-between`：与交叉轴两端对齐，轴线之间的间隔平均分布
    - `space-around`：每根轴线两侧的间隔都相等。所以轴线之间的间隔比轴线与边框的间隔大一倍
    - `stretch`：（默认值）：轴线沾满整个交叉轴


![flex布局语法篇小结](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111708239.png)

- 拓展阅读
  - [flex布局语法篇](http://www.ruanyifeng.com/blog/2015/07/flex-grammar.html)
  - [flex布局实例篇](http://www.ruanyifeng.com/blog/2015/07/flex-examples.html)

## 运动体系

---

### 过渡
---

- 过渡：给改变添加过程
    - 什么是过渡
    - 过渡效果由哪几部分组成
    - 过渡可以干些什么
    
- **transition**： 过渡属性
    - `transition: property duration timing-function delay`;
    - **transition-property**：过渡属性的名称
      
    

```
- `none `  没有过渡属性
- `all  `      所有属性都过渡(默认值)
- `property `   具体属性名称(`property1`,`property2`...)
```

- **transition-duration**：过渡属性花费的时间

    - `time `  秒或毫秒

- **transition-delay**：过渡效果延迟时间

- **transition-timing-function**：过渡效果速度曲线

    - `time `  秒或毫秒
    - `linear`:规定以相同速度开始至结束的过渡效果（等于 `cubic-bezier(0,0,1,1)`）。
    - `ease`:规定慢速开始，然后变快，然后慢速结束的过渡效果（`cubic-bezier(0.25,0.1,0.25,1)`）。
- `ease-in`:规定以慢速开始的过渡效果（等于 `cubic-bezier(0.42,0,1,1)`）。
    - `ease-out`	:规定以慢速结束的过渡效果（等于 `cubic-bezier(0,0,0.58,1)`）。
    - `ease-in-out` :规定以慢速开始和结束的过渡效果（等于 `cubic-bezier(0.42,0,0.58,1)`）。
    - `cubic-bezier(n,n,n,n)`:在 `cubic-bezier` 函数中定义自己的值。可能的值是 `0 `至 `1` 之间的数值。
- 过渡完成事件   
- ![过渡完成事件](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111708489.png)


```
- `Webkit`内核： 
	```javascript
		obj.addEventListener('webkitTransitionEnd',function(){})
	```

- 标准: 

	```javascript
		obj.addEventListener('transitionend',function(){})
	```
```

### 动画
---

- 什么是`CSS3` 动画？
  - 通过 `CSS3`，我们能够创建动画，这可以在许多网页中取代动画图片、`Flash` 动画以及 `JavaScript`
- `animation` 动画会按照`keyframes`关键帧里面指定的帧状态而过渡执行。0% —— 100% 代表动画的时间过渡
  
- **动画接口**


|属性  | 描述 |
|---|---|
| @keyframes|	规定动画。|
| animation	|所有动画属性的简写属性，除了 animation-play-state 属性。|
| animation-name	|规定 @keyframes 动画的名称。|
| animation-duration	|规定动画完成一个周期所花费的秒或毫秒。|
| animation-timing-function| 规定动画的速度曲线（速率）。 |
| animation-delay	|规定动画延迟时间|
| animation-iteration-count	|规定动画被播放的次数。 infinite（无限次）number（有限次）|
| animation-direction	|规定动画的方向。|
| animation-play-state| 规定动画是否正在运行或暂停。running（播放）paused（暂停） |
| animation-fill-mode	|规定对象动画时间之外的状态。|

- **animation-direction**:  方向
  - `normal`：0%-100%）
  - `reverse`：（100%-0%）
  - `alternate`：（奇数次正向，偶数次反向）
  - `alternate-reverse`：（奇数次反向，偶数次正向） 

- **animation-timing-function速度曲线**

  - |值 | 描述 |
  |---|---|
  |linear 	|动画从头到尾的速度是相同的。|
  |ease |	默认。动画以低速开始，然后加快，在结束前变慢。|
  |ease-in |	动画以低速开始。 |
  |ease-out |	动画以低速结束。 |
  |ease-in-out |	动画以低速开始和结束。 |
  |cubic-bezier(n,n,n,n) |	在 cubic-bezier 函数中自己的值。可能的值是从 0 到 1 的数值。 |

- **animation-fill-mide**:  定义在动画开始之前和结束之后发生的操作
  - `forwards`：动画在结束后停留在最后的关键帧的位置
  - `backwards`：会在向元素应用动画样式时迅速应用动画的初始帧，意思是是否立即使用关键帧（结合延迟1s来看）
  - `both`：元素动画同时拥有`forwards`和`backwards`效果
  - `none`：默认值，表示动画按照预期进行，完成最后一帧时，反转到初始处
- 在谷歌浏览器里面需要加上`-webkit-`
`IE6,7,8,9`不支持`css3`运动


### transform 2D转换
---

- **`Css3`平面转换方法**
  - `translate() `：移动
  - `rotate`：旋转
  - `scale()`：缩放
  - `skew()`：翻转
  - `matrix()	`：矩阵


- **transform:**
	- **rotate()**  旋转函数/方法 (deg)
    - 以x/y/z轴进行旋转，默认为z轴
	     - `deg`  度数
    - 用于旋转元素角度
    - 例：`rotate(30deg) ` 把元素顺时针旋转 30 度
	  - `rotatex()`，`rotatey()`，`rotatez()` ，`rotate3d(x, y, z, angle)`
    - `angle`是旋转角度
  - **skew(X,Y)** 倾斜函数 / 翻转方法 (deg) 
	     - `skewX()`
    - `skewY()`
    - 通过 `skew() `方法，元素翻转给定的角度
     - 例：`transform: skew(30deg,20deg);`
          - 把元素围绕 `X `轴把元素翻转` 30` 度，围绕 `Y` 轴翻转 `20 `度
  - **scale(X,Y)**：缩放函数 / 尺寸方法 (正数、负数和小数)
       - `scaleX()`
    - `scaleY()`
    - 方法用于改变元素尺寸
    - 例：`scale(2,4)` 
         - 把宽度转换为原始尺寸的 2 倍，把高度转换为原始高度的 4 倍
    - `scalex()`, `scaley()`, `scalez()`值是数字表示倍数，不加任何单位
    - `scale3d()` --> `scale3d(x, y, z)`
  - **translate(X,Y)** 位移函数 / 位置方法(px)
       - `translateX()`
    - `translateY()`
    - 用于移动元素位置
      - 例：`translate(50px,100px)`
    - 把元素从左侧移动 50 像素，从顶端移动 100 像素。
    - 其实有些类似于我们的相对定位
    - `translatex()`,` translatey()`, `translatez()`, `translate3d(x, y, z)`
  - **transform-origin**
    - 变换原点
    - 任何一个元素都有一个中心点，默认情况下，其中心点是居于元素x轴和y轴的50%处
    - 取值
      - 也可以使用像素值
      - `top` = `top` `center` = `center top` = `50% 0`
      - `right` = `right center` = `center right` = `100% | 100% 50%`
      - `bottom` = `bottom center` = `center bottom = 50% 100%`
      - `left` = `left center` = `center left = 0 | 0 50%`
      - `center` = `center center` = `50% | 50% 50%`
      - `top left` = `left top` = `0 0`
      - `right top` = `top right` = `100% 0`
      - `bottom right` = `right bottom` = `100% 100%`
      - `bottom left` = `left bottom` = `0 100%`

### transform 3D转换

---

- **`Css3`立体转换**
- **transform-style：**
    - *transform-style属性需要设置在父元素中，高于任何嵌套的变形元素，设置了transform-style的元素，就不能防止子元素溢出设置overflow:hidden，否则会导致preserve-3d失效*
    - **flat**：默认，子元素将不保留其`3D`位置
    - **preserve-3d**：子元素保留其`3D`位置
       - 建立`3D`空间（指定元素的子元素展示的场景是在`3D`场景还是平面(投影)场景）
       - `perspective` 视角（指定观察者与z=0平面的距离，从而让元素及子元素看起来有3D透视位置效果
         值：集体的带单位数值）
       - `Perspective- origin` 视角基点 / 视觉中心点
          - 值：取值类似于变换基准
          - 默认值为50% 50%
- **backface-visibility：**
    - 在元素运动的过程中，能否展示元素的背面
    - `visible`：可见
    - `hidden`：隐藏

## 媒体查询

### 简介

- **模拟移动端meta**
- *<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,use-scalable=no">*
  - `name='viewport'`：视口大小
  - `content="width=device-width"` ：`width`视口宽度等于设备的宽度
  - `initial-scale=1.0`：占的比例大小，1.0就是不放不缩
  - `minimum-scale = 1.0`：代表最小能缩到1.0
  - `maximum-scale = 1.0`：代表最大能缩到1.0
  - `use-scalable=no`：不允许用户进行缩放
- **为什么有媒体查询**

  - 移动端的快速普及完全颠覆了`Web`涉及领域
  - 用户不再仅在传统桌面系统上查看`Web`内容，他们越来越多地使用具有各种尺寸的智能电话、平板电脑和其他设备
  - `Web`设计人员的挑战是确保他们的网站不仅是在大屏幕上看起来不错，在小型的电话以及介于它们之间的各种设备上看起来不错
- **什么是媒体查询**

  - 媒体查询是向不同设备提供不同样式的一种方式，它为每种类型的用户提供了最佳的体验
  - `CSS2`：`media type`
    - `media type`（媒体类型）是`css2`中一个非常有用的属性，通过`media type`我们可以对不同的设备指定特定的样式，从而实现更丰富的界面
  - `CSS3`：`media query`
    - `media query`是`CSS3`对`media type`的增强，事实上我们可以将media query看成是`media type+css`属性（媒体特征`Media features`）判断

### **如何使用媒体查询**

- 媒体查询的引用方法

  - **link**标签


```css
<link rel='stylesheet' media='screen and (max-width:800px)' href='index.css'> 

媒体类型（Media Type）：all（全部）、screen（屏幕）、print（页面打印或打印预览模式）

媒体特性（Media features）：width（渲染区宽度）、device-width（设备宽度）
```

- `Media Query`是`CSS3`对`Media Type`的增强版，其实可以将`Media Query`堪称`Media Type`（判断条件）+ `CSS`（符合条件的样式规则）

- **@import**

  - **@media**

    - `@media screen and (max-width:800px) and (min-width:600px) {}`

### **媒体类型（Media Type）**

| 类型       | 解释                                   |
| ---------- | -------------------------------------- |
| all        | 所有设备                               |
| braille    | 盲文                                   |
| embossed   | 盲文打印                               |
| handheld   | 手持设备                               |
| print      | 文档打印或打印预览模式                 |
| projection | 项目演示，比如幻灯                     |
| screen     | 彩色电脑屏幕                           |
| speech     | 演讲                                   |
| tty        | 固定字母间距的网络媒体，比如电传打字机 |
| tv         | 电视                                   |



### **媒体特性（Media features）**

| 属性                | 值                     | Min/Max | 描述                     |
| ------------------- | ---------------------- | ------- | ------------------------ |
| color               | 整数                   | yes     | 每种色彩的字节数         |
| color-index         | 整数                   | yes     | 色彩表中的色彩数         |
| device-aspect-ratio | 整数/整数              | yes     | 宽高比例                 |
| device-height       | length                 | yes     | 设备屏幕的输出高度       |
| device-width        | length                 | yes     | 设备屏幕的输出宽度       |
| grid                | 整数                   | no      | 是否基于格栅的设备       |
| height              | length                 | yes     | 渲染界面的高度           |
| monochrome          | 整数                   | yes     | 单色帧缓冲器中每像素字节 |
| resolution          | 分辨率（dpi/dpcm）     | yes     | 分辨率                   |
| scan                | Progresslve interlaced | no      | tv媒体类型的扫描方式     |
| width               | length                 | yes     | 渲染界面的宽度           |
| orientation         | Portrait/landscape     | no      | 横屏或竖屏               |

### 其他   

- **逻辑操作符**

  - 合并多个媒体属性 `and`
  - `@media screen and (min-width:600px) and (max-width:1000px)`
  - 合并多个媒体属性或合并媒体属性与媒体类型，一个基本的媒体查询，即一个媒体属性与默认指定的screen媒体类型

- **指定备用功能**

  - 逗号 ,
  - `@media screen and (min-width:769px), print and (min-width:6in)`
  - 没有`or`关键字可用于指定备用的媒体功能。相反，可以将备用功能以逗号分隔列表的形式列出这才会将样式应用到宽度超过769像素的屏幕或使用至少6英寸宽的纸张的打印设备

- **指定否定条件**

  - `not`
  - `@media not screen and (monochrome)`
  - 要指定否定条件，可以在媒体声明中添加关键字not，不能再单个条件前使用not。该关键字必须位于声明的开头，而且它会否定整个声明。所以，上面的示例会应用于除单色屏幕外的所有设备

- **向早期浏览器隐藏媒体查询**

  - `only`
  - `media='only screen and (min-width:401px) and (max-width:600px)'`
  - 媒体查询规范还提供了关键字`only`，它用于向早期浏览器隐藏媒体查询。类似于`not`，该关键字必须位于声明的开头
  - 早期浏览器应该将以下语句`media=‘screen and (min-width:40px) and (max-width:600px)’ `解释为` media='screen'; `换句话说，他应该将样式规则应用于所有屏幕设备，即使他不知道媒体查询的含义
  - 无法识别媒体查询的浏览器要求获得逗号分隔的媒体类型列表，规范要求，它们应该在第一个不是连字符的非数字字母字符之前截断每个值。所以，早期浏览器应该将上面的实例解释为：`media='only'`
  - 因为没有`only`这样的媒体类型，所以样式表被忽略

- **易混淆的宽度**

  - `device-width`/`heighta`	`width`/`height`
  - `device-width`/`height`是设备的宽度（比如电脑手机的宽度，不是浏览器的宽度）
  - `width/height是documentElement.clinetWidth`/`Height`即`viewport`的值

- **尺寸单位**

  - **px**

    - 相对长度单位，相对于显示器屏幕分辨率而言的
    - 特点
      - IE无法调整那些使用px作为单位的字体大小
      - 国外的大部分网站能够调整的原因在于其使用了`em`或`rem`作为字体单位
      - firefox能够调整`px`和`em`，`rem`

  - **em**

    - `em`的值并不是固定的

    - `em`会继承父级元素的字体大小


```javascript
注意：任意浏览器的默认字体高都是16px。所有未经调整的浏览器都符合: 1em=16px。那么12px=0.75em,10px=0.625em。为了简化font-size的换算，需要在css中的body选择器中声明Font-size=62.5%，这就使em值变为 16px*62.5%=10px, 这样12px=1.2em, 10px=1em, 也就是说只需要将你的原来的px数值除以10，然后换上em作为单位就行了。

所以我们在写CSS的时候，需要注意两点：

1. body选择器中声明Font-size=62.5%；
2. 将你的原来的px数值除以10，然后换上em作为单位；
3. 重新计算那些被放大的字体的em数值。避免字体大小的重复声明。

也就是避免1.2 * 1.2= 1.44的现象。比如说你在#content中声明了字体大小为1.2em，那么在声明p的字体大小时就只能是1em，而不是1.2em, 因为此em非彼em，它因继承#content的字体高而变为了1em=12px。      
```

- `1em` = `1 * font-size` = `1 * 16px`

- `font-size`默认的是`16`像素

- **rem**

  - 相对单位，相对的只是`HTML`根元素的字体大小

  - `font size of the root element `（根元素的字体大小)

  - `rem`是一种相对长度单位。相对于根元素(即`html`元素)`font-size`计算值的倍数。

  - 和`em`不同的是`rem`总是相对于根元素(如:`root`{})，而不像em一样使用级联的方式来计算尺寸。这种相对单位使用起来更简单。

  - `rem`支持`IE9`及以上，意思是相对于根元素`html`（网页），不会像`em`那样，依赖于父元素的字体大小，而造成混乱。使用起来安全了很多。

  - **注意：** *选择使用什么字体单位主要由你的项目来决定，如果你的用户群都使用最新版的浏览器，那推荐使用rem，如果要考虑兼容性，那就使用px,或者两者同时使用。*


```javascript
html {
	font-size: 10px;
}

.wrap {
	font-size: 1.5rem;
	// 这个时候，.wrap这个元素里面的字体大小就是1.5 * 10px，也就是1.5rem了
}
```


## 附录一 像素单位

- **物理像素和设备独立像素**

  - 一个物理像素是显示器（手机屏幕）上最小的物理显示单元，在操作系统的调度下，每一个设备像素都有自己的颜色值和亮度值

  - 设备独立像素（也叫目睹无关像素），可以认为是计算机坐标系统的一个点，这个点代表一个可以由程序使用的虚拟像素（`css`像素），然后由相关系统转换为物理像素

  - 设备像素比（`device pixel ratio`）设备像素比（简称`dpr`）定义了物理像素和设备独立像素的对应关系，它的值可以按如下的公式得到 *设备像素值 = 物理像素 / 设备独立像素* `js`中可以通过`window.devicePixelRatio`

  - `dpr`在一些屏幕上是2：1的比例，所以像素值在不同屏幕上的占比是不同的


```
1.设备宽高为375*667，可以理解为设备独立像素（或css像素）
2.dpr为2，根据上面的计算公式，其物理像素就应该 2 ，为750*1334.

1css像素在PC端显示器需要用（1*1）个栅格点表示 在iPhone6中则需要4（2*2）个

也就是在不同的屏幕上（普通屏幕 vs retina屏幕），css像素所呈现的大小（物理尺寸）是一致的，不同的是一个css像素所对象的物理像素个数是不一致

在普通的屏幕下，1个css像素对应的1个物理像素 为1:1 。在retina屏幕下，1个css像素对应4个物理像素 1:4
```



- **位图像素**

- 1个位图像素是栅格图像（如：`png`，`jpg`，`gif`等）最小的数据单元，每一个位图像素都包括着一些资深的现实信息（如：显示位置，颜色值，透明度等）

- 在普通屏幕下是没有问题的，但是在`retina`屏幕下就会出现位图像素点不够，从而导致图片模糊的情况


```
对于dpr=2的，1个位图像素对应4个物理像素，由于单个位图像素不以再进一步分割，所以只能就近取色，从而导致图片模糊

解决办法，使用分辨率大两倍的图片，如200*300 img 标签，就需要提供400*600的图片.由此一来位图像素点的个数是原来的4倍，在retina屏幕下，位图像素点个数就可以物理像素点个数形成1:1 的比例，图片自然就清晰了。

如果普通屏幕下，也用了两倍的图片，会怎么样，很明显，在普通屏幕下，200*300(css pixel)img标签，所对应的物理像素个数就是200*300个，而两倍图片的位图像素个数则是200*300*4，所以就出现了一个像物理像素点对应4个为图像素点，所以它的取色也只能通过——定的算法（显示结果就是一张只有原图像素总数四分之一，我们称这个过程叫做downsampling），肉眼看上去这个图片不会模糊，但是会觉得图片缺少一些锐利度，或者是有点色差（还是可以接受的）

```



## 附录二 浏览器渲染原理

1. 处理`HTML` 生成`DOM`树
2. 处理`CSS `生成`CSSDOM`树
3. 将两个数合并成`render`树
4. 对`render`树进行布局计算
5. 将`render`树中的每一个节点绘制在屏幕上

```
细化分析：
1.浏览器把获取到的html代码解析成1个Dom树，html中的每个tag都是Dom树中的1个节点，根节点就是我们常用的document对象(<html> tag)，当然这里包含用js动态创建的dom节点

2浏览器把所有样式(主要包括css和浏览器的默认样式设置)解析成样式结构体，在解析的过程中会去掉浏览器不能识别的样式，生成CSSDOM树

3.DOM tree和CSSDOM tree 合并成 render tree，render tree中每个node都有自己的style，而且render tree不包含隐藏的节点(比如display:none的节点，还有无样式head节点)，因为这些节点不会用于呈现，而且不会影响呈现的，注意 visibility:hidden隐藏的元素还是会包含到render tree中的，因为visibility:hidden 会影响布局(layout)，会占有空间。

4.render tree构建完毕之后根据样式计算布局，布局阶段的输出结果称为 “盒模型”（box model）。盒模型精确表达了窗口中每个元素的位置和大小，而且所有的相对的度量单位都被转化成了屏幕上的绝对像素位置 (根据css2的标准，render tree中的每个节点都称为box(Box dimensions----盒子模型)，box所有属性：width,height,margin,padding,left,top,border等。)

5.将这些信息渲染为屏幕上每个真实的像素点了。这个阶段称为“绘制”，或者“栅格化”（rasterizing）。
```

![](https://cdn.jsdelivr.net/gh/Luckiiest/noteImage@master/202111111709570.png)

- 重绘、重排

  - 重排，我们在计算它们在当前设备中准确的位置和尺寸。这正是布局阶段要做的工作，该阶段在英语中也成为“回流”（`reflow`），当`render tree`中的一部分（或全部）因为元素的规模尺寸，布局，隐藏等改变而需要重新构建。也会回流（其实我觉得叫重新布局更简单明了一些）。每个页面至少需要一次回流，就是在页面第一次加载的时候

  - 重绘（`repaints`）当`render tree`中的一些元素需要更新属性，而这些属性只是影响元素的外观，风格，而不会影响布局的，比如`background-color`,则就叫重绘

  - 重绘，重排会影响性能

    - 在`chrome`中有一个`Performance`面板，它可以计算从开始到绘制完成花费了多少时间
    - 蓝色：网络通信和`HTML`解析
    - 黄色：`JavaScript`执行
    - 紫色：样式计算和布局，即重排
    - 绿色：重绘

  - 触发重排的方法：

    - 以下这些属性和方法需要返回最新的布局信息，重新计算渲染树，就会造成回流，触发重排以返回正确的值，建议将她们合并到一起操作，可以减少回流次数，这些属性包括：

    - `offsetTop`/`Left`、`offsetWidth`/`Height`、`scrollTop`/`Left`/`Width`/`Height`、`clientTop`/`Left`/`Width`/`Height`、`getComputedStyle()`、`currentStyle`

    - 提高网页性能，就是要降低“重排”和重绘的频率和成本，尽量少触发重新渲染。DOM变动和样式变动，都会触发重新渲染。但是，浏览器已经很智能了，会尽量把所有的变动集中在一起，排成一个队列，然后一次性执行，尽量避免多次重新渲染


```js
div.style.color='red'
div.style.background="yellow"
div.style.left='10px'
div.style.width='20px'

浏览器最低触发一次重排和重绘

一般来说，样式的写操作之后，如果有上面那些属性的读操作，都会引发浏览器立即重排，这种重排，不会形成之前队列优化

div.style.color = ‘red’;
var height = div.offseHeight;
div.style.height = height + ‘px’;

Bad：
div.style.left = div.offsetLeft + ‘px’;
div.style.top = div.offsetTop + ‘px’;
重排重绘两次
Good:
Var left = div.offsetLeft + ‘px’;
Var top = div.offsetTop + ‘px’;

div.style.left = left;
div.style.top = top;
放到队列，一起执行重排重绘一次

我们来测试一下js动态添加10000个li 不同颜色而且设置宽度 所耗费render painting 的时间吧
```

- 理论上的结局优化方法

  - 说到的`DOM`的多个读写操作，应该放在一起，不要两个读操作之间，加入一个写操作
  - 离线操作`DOM`如使用隐藏元素 `document.createDocumentFragment()`/ `cloneNode() `
  - 修改样式的时候添加类名，或一次性添加到`dom.style.cssText`上等
  - 以上都是理论上的加速方法

## 附录三 css3响应式布局

---

- 媒体类型
  -  `*all` 所有媒体
  -  `braille` 盲文触觉设备
  -  `embossed` 盲文打印机
  -  `*print` 手持设备 
  -  `projection` 打印预览
  -  `*screen` 彩屏设备
  -  `speech` '听觉'类似的媒体类型
  -  `tty `不适用像素的设备
  -  `tv ` 电视

- 关键字
  -  `and `
  -  `not  `    `not`关键字是用来排除某种制定的媒体类型
  -  `only`     `only`用来定某种特定的媒体类型

- 媒体特性
  -  `(max-width:600px) `
  -  `(max-device-width: 480px) ` 	设备输出宽度
  -  `(orientation:portrait)`  		竖屏
  -  `(orientation:landscape)`		横屏
  -  `(-webkit-min-device-pixel-ratio: 2)` 像素比
  -  `devicePixelRatio` 			设备像素比 
  -  `window.devicePixelRatio = 物理像素 / dips`

- 样式引入

```css
<link rel="stylesheet" href="css/index.css" media="print" />
```
```css
 @import url("css/demo.css") screen;
 @media screen{    }
```

```css
<link rel=”stylesheet” media=”all and
 (orientation:portrait)” href=”portrait.css”>
```
```css
<link rel=”stylesheet” media=”all
 and (orientation:landscape)”href=”landscape.css”>
```
```css
@media screen and (min-width:360px) and (max-width:500px) {}
```
```css
<link rel="stylesheet" type="text/css" 
href="indexA.css"  media="screen and (min-width: 800px)">
```
```css
<link rel="stylesheet" type="text/css" 
href="indexB.css" media="screen and (min-width: 600px) and (max-width: 800px)">
```
```css
<link rel="stylesheet" type="text/css" 
href="indexC.css"    media="screen and (max-width: 600px)">
```