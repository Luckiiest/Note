# HTML5

## HTML5结构
---

- `HTML5` 是新一代的 `HTML`
- `DTD`声明改变	`<!DOCTYPE html>`
    - 新的结构标签			


![一些总结--from-dunitian](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/1.png)

### 常用的一些新的结构标签
---

![结构标签](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/2.png)

![多媒体交互标签](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/3.png)


![特殊样式标签](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/4.png)


![兼容性不是很好的标签](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/5.png)

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

![传统的布局](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/body.jpg)

![实例-from-dunitian](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/jia.png)

![草图--from-dunitian](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/kuang.png)

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
    - `type = "email" ` 限制用户输入必须为`Email`类型
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

## 视频/音频
---

- 视频音频格式的简单介绍
  - 常见的视频格式
    - 视频的组成部分：画面、音频、编码格式
    - 视频编码：H.264、Theora、VP8(google开源)
  - 常见的音频格式
    - 视频编码：ACC、MP3、Vorbis

- **`HTML5`支持的格式**
---

- `HTML5`能在完全脱离插件的情况下播放音视频,但是不是所有格式都支持。
- **支持的视频格式：**
    - `Ogg=`带有`Theora`视频编码`+Vorbis`音频编码的`Ogg`文件
    - `MEPG4=`带有H.264视频编码`+AAC`音频编码的`MPEG4`文件
    - `WebM=`带有`VP8`视频编码`+Vorbis`音频编码的`WebM`格式

### `Video`的使用
---

- **单独用法**
  - `<video src="文件地址" controls="controls"></video>`
- **带提示用法**

```html
< video src="文件地址" controls="controls">
	您的浏览器暂不支持video标签。播放视频
</ video >
```

- **兼容用法**

```html
< video  controls="controls"  width="300">
	<source src="move.ogg" type="video/ogg" >
	<source src="move.mp4" type="video/mp4" >
	您的浏览器暂不支持video标签。播放视频
</ video >
```

- **`Video`的常见属性**

|属性|	值|	描述|
|---|---|---|
|Autoplay|	Autoplay|	视频就绪自动播放|
|controls|	controls|	向用户显示播放控件|
|Width|	Pixels(像素)|	设置播放器宽度|
|Height|	Pixels(像素)|	设置播放器高度|
|Loop|	Loop|	播放完是否继续播放该视频，循环播放|
|Preload	|load{auto,meta,none}|	规定是否预加载视频。|
|Src	|url	|视频url地址|
|Poster|	Imgurl	|加载等待的画面图片|
|Autobuffer|	Autobuffer	|设置为浏览器缓冲方式，不设置autoply才有效|

- **`Video`的`API`方法**

|方法|	属性|	事件|
|---|---|---|
|play()|	currentSrc|	play|
|pause()|	currentTime|	pause|
|load()|	videoWidth|	progress|
|canPlayType()|	videoHeight|	error|

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

- ```javascript
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

- ```javascript
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

  - ```javascript
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
  - ![](https://cdn.jsdelivr.net/gh/HAODEabcd/Note@master/Web/H5C3/text.jpg)

### 线段样式

- `lineCap`：端点样式
  - `butt`(默认值),`round`(圆角),`square`(高度多出线宽一半)
- `lineJoin`：边界连接点样式
  - 属性：`miter`(默认值),`round`(圆角),`bevel`(斜角)

- ![样式](https://cdn.jsdelivr.net/gh/HAODEabcd/Note@master/Web/H5C3/line.jpg)

- `ctx.miterLimit;`
  - 当`lineJoin`是`miter`时，用于控制斜接部分的长度
  - 如果斜接长度超过 `miterLimit` 的值，变成`bevel`
  - 注:实际运算是大于`limit*lineWidth/2`的值，了解就好

### 裁剪

- `ctx.clip()`：当前路径外的区域不再绘制

- ```javascript
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

- ```js
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

- ```js
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

- ```js
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

- ```javascript
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

![](https://cdn.jsdelivr.net/gh/HAODEabcd/Note@master/Web/H5C3/ten.jpg)

### 如何解决canvas高分屏模糊问题

- 在分辨率比较高的屏幕，例如`ip6/6s/mac`等机器上，因为`canvs`绘制的是位图，所以会导致模糊，解决方法是根据屏幕分辨率修改`canvas`样式代码中的宽和高与`canvas`的`width`和`height`属性的比例


- 扩展阅读
	- [canvas学习之API整理笔记（一）](http://luckykun.com/work/2016-09-01/canvas-study01.html)
	- [HTML5 API大盘点](http://jartto.wang/2016/07/25/make-an-inventory-of-html5-api/)


## SVG绘图
---

- **svg是什么**
  - 矢量图
  - 与`canvas`的区别
  
- **svg的引入方式**

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

- **`circle`:圆形**
    - 圆心坐标  `cx`,`cy`
    - 半径  `r`
    - `fill`   `stroke `  `stroke-width`     `stlye`样式 
    - `fill = "none/transparent" `
- **ellipse:椭圆**
    - `cx`属性定义的椭圆中心的x坐标
    - `cy`属性定义的椭圆中心的y坐标
    - `rx`属性定义的水平半径
    - `ry`属性定义的垂直半径
- **rect : 矩形**
    - `width`  `height ` 宽高   
    - 坐标 ` x`,` y` 
    - 圆角  `rx`,`ry`
- **`line `:线条**
    - `x1`,`y1`,`x2`,`y2`
    - `stroke-opacity`  透明  `fill-opacity`

- **polyline:折线**
  - `points`:点坐标（`x1 y1 x2 y2...`）或(`x1,y1,x2,y2....`)	
- **polygon:多边形**
  - 折线闭合  `fill-rule:evenodd/nonzero`;
- **path: 路劲**
    - `d`属性
    - `M(起始坐标)`,`L(结束坐标)`,`H(水平线)`,`V(垂直线)`,`A(圆弧)`,`Z(闭合路劲)`
        - `C`,`S`,`Q`,`T` 贝塞尔曲线
        - 大写为绝对坐标(具体的坐标位置)
        - 小写为相对坐标(相对起始坐标点的具体长度)
    - A命令
        - `x`半径 `y`半径 角度  弧长(0 小弧 1大弧)  方向(0逆时针 1顺时针)
        - 终点`(x y)`

- **C命令：三次贝塞尔曲线**
  - `(x1,y1,x2,y2,x,y)`    `x1`,`y1 `控制点一    `x2`,`y2 `控制点二   ` x`,`y `结束点
- **S命令：平滑贝塞尔曲线(自动对称一个控制点)**
  - `(x2,y2,x,y) `  `x2`,`y2`控制点    x,y结束点
- **Q命令：二次贝塞尔曲线**
  - `(x1,y1,x,y)`   x1,y1控制点  x,y结束点
- **T命令：一次贝塞尔曲线**
  - `(x,y)`结束点

- **`g`标签:组合元素  设置元素公共属性**
    - 共用属性
    - `transform = "translate(0,0)"`

- **`text`标签**
    - `x`, `y`, `text-anchor`(对齐start end middle)	`font-size `

- **`image` 标签**
    - `x`, `y`, `width`  `height `
    - `xlink:href`(图片地址)


## 地理信息与本地存储
---

### 地理位置
---

- 经度  :   南北极的连接线
- 纬度  :   东西连接的线

- 位置信息从何而来
    - `IP`地址
    - `GPS`全球定位系统
    - `Wi-Fi`无线网络
    - 基站

- `avigator.geolocation`
  - 单次定位请求  ：`getCurrentPosition`(请求成功,请求失败,数据收集方式)
  - **请求成功函数**
    - 经度 :  `coords.longitude`
    - 纬度 :  `coords.latitude`
    - 准确度 :  `coords.accuracy`
    - 海拔 : ` coords.altitude`
    - 海拔准确度 :  `coords.altitudeAcuracy`
    - 行进方向 :  `coords.heading`
    - 地面速度 :  `coords.speed`
    - 请求的时间: `new Date(position.timestamp)`

  - **请求失败函数**
    - 失败编号  ：`code`
      - 0  :  不包括其他错误编号中的错误
      - 1  :  用户拒绝浏览器获取位置信息
      - 2  :  尝试获取用户信息，但失败了
      - 3  :   设置了`timeout`值，获取位置超时了
  - **数据收集 :  json的形式**
      - `enableHighAcuracy`  :  更精确的查找，默认`false`
      - `timeout ` :  获取位置允许最长时间，默认`infinity`
      - `maximumAge` :  位置可以缓存的最大时间，默认`0`

  - **多次定位请求***  : ` watchPosition`
      - 移动设备有用，位置改变才会触发
      - 配置参数：`frequency` 更新的频率
      - 关闭更新请求  :  `clearWatch`


- **examp01 getCurrentPosition**

```html
<button id="btn">请求位置信息</button>
<div id="box"></div>
```
```javascript
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

```css
#container {
    width:600px; 
    height: 300px;
    margin:40px auto;
    border:1px solid red;
} 
```
```html
<div id="container"></div>  
<script type="text/javascript" 
src="http://webapi.amap.com/maps?v=1.3&key=278b7b8b4728ba302b7e566fc2a97b36">
</script>
```
```javascript
var map = new AMap.Map('container');
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
```
```html
<div id="container"></div> 
<div id="box">
	<input type="text" id="city" placeholder="请输入城市...">
	<input type="button" value="搜索" id="btn">
</div>
<script type="text/javascript" 
src="http://webapi.amap.com/maps?v=1.3&key=278b7b8b4728ba302b7e566fc2a97b36">
</script>
```
```javascript
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
```

[在线演示](http://codepen.io/poetries/pen/xgGwaZ)

### 本地存储
---

- **`Storage`**
    - `sessionStorage`
        - `session`临时回话，从页面打开到页面关闭的时间段
        - 窗口的临时存储，页面关闭，本地存储消失
    - `localStorage`
        - 永久存储（可以手动删除数据）
    
- **`Storage`的特点**
    - 存储量限制 ( 5M )
    - 客户端完成，不会请求服务器处理
    - `sessionStorage`数据是不共享、 `localStorage`共享
    
- **`Storage API`**
    - `setItem()`:
        - 设置数据，(`key`,`value`)类型，类型都是字符串
        - 可以用获取属性的形式操作
    - `getItem():`
        - 获取数据，通过`key`来获取到相应的`value`
    - `removeItem()`:
        - 删除数据，通过key来删除相应的`value`
    - `clear()`:
        - 删除全部存储的值
    
- **存储事件:**
    - 当数据有修改或删除的情况下，就会触发`storage`事件
    - 在对数据进行改变的窗口对象上是不会触发的`
    - `Key` : 修改或删除的`key`值，如果调用`clear()`,`key`为`null`
    - `newValue`  :  新设置的值，如果调用`removeStorage()`,`key`为`null`
    - `oldValue` :  调用改变前的`value`值
    - `storageArea` : 当前的`storage`对象
    - `url` :  触发该脚本变化的文档的url
    - 注：`session`同窗口才可以,例子：`iframe`操作

## HTML5新增JS方法
---


![H5在JavaScript中新增的方法一览](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/14.png)


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
  - `onhashchange` ：改变hash值来管理
  - `history`  ：
    - 服务器下运行
      - `pushState` :  三个参数 ：数据  标题(都没实现)  地址(可选)
      - `onpopstate`事件 :  读取数据   `event.state`



## HTML5拖拽事件
---

- 图片自带拖拽功能
- 其他元素可设置`draggable`属性
- **`draggable ：true`**
    - 拖拽元素(被拖拽元素对象)事件 :  
        - `ondragstart` : 拖拽前触发 
        - `ondrag` :拖拽前、拖拽结束之间，连续触发
        - `ondragend` :拖拽结束触发
    - 目标元素(拖拽元素被拖到的对象)事件 :  
        - `ondragenter` :进入目标元素触发
        - `ondragover `:进入目标、离开目标之间，连续触发
        - `ondragleave` :离开目标元素触发
        - `ondrop` :在目标元素上释放鼠标触发
            - 需要在`ondragover`事件里面阻止默认事件

- **拖拽兼容问题**
  - 火狐浏览器下需设置`dataTransfer`对象才可以拖拽除图片外的其他标签
    - `dataTransfer`对象
    - `setData()` : 设置数据 `key`和`value`(必须是字符串)
    - `getData()` : 获取数据，根据`key`值，获取对应的`value`
    - `effectAllowed` : 设置光标样式(`none`, `copy`, `copyLink`, `copyMove`, `link`, `linkMove`,` move`, `all` 和` uninitialized`)
	
    - `setDragImage` ：三个参数（指定的元素，坐标`X`，坐标`Y`）
    - `files`： 获取外部拖拽的文件，返回一个`filesList`列表
        - `filesList`下有个`type`属性，返回文件的类型
- **读取文件信息**
    - `FileReader`(读取文件信息)
        - `readAsDataURL`
    - 参数为要读取的文件对象
        - `onload`当读取文件成功完成的时候触发此事件
        - `this. result` 获取读取的文件数据

- **examp01 拖拽案例**

```html
<div id="drap" draggable="true"></div>
<div id="box"></div>
```
```css
#drap {
	width: 100px;
	height: 100px;
	background: red;
}
#box {
	width: 500px;
	height: 500px;
	border: 2px solid blue;
	margin: 50px auto;
}
```
```javascript
//被拖拽元素事件
drap.ondragstart = function(ev){ // 拖拽前
	var ev = ev || window.event;

	//火狐浏览器下需设置dataTransfer对象才可以拖拽除图片外的其他标签
	ev.dataTransfer.setData("key","poetries");

	//effectAllowed : 设置光标样式(none, copy, copyLink, copyMove, link, linkMove,move, all 和uninitialized)
	ev.dataTransfer.effectAllowed = "copy";

	//设置被拖拽的小元素 setDragImage ：三个参数（指定的元素，坐标X，坐标Y）
	ev.dataTransfer.setDragImage(pic,25,25);

	this.style.background = "green";
}

drap.ondrag = function(){ // 拖拽过程中
	this.innerText = "被拖拽中...";
}

drap.ondragend = function(){ // 拖拽结束
	this.style.background = "red";
	this.innerHTML = "";
}

//目标元素事件
box.ondragenter = function(){ //进入目标元素触发
	this.innerHTML = "可将文件拖放到这里!";
}
box.ondragover = function(ev){ //进入目标、离开目标之间，连续触发
	var ev = ev || window.event;
	ev.preventDefault(); 
	this.style.background = "pink";
}
box.ondragleave = function(){ //离开目标元素触发
	this.innerHTML = "";
	this.style.background = "none";
}
box.ondrop = function(ev){//在目标元素上释放鼠标触发
	//alert("拖放结束")
	this.innerHTML = ev.dataTransfer.getData("key");
}
```

[在线演示](http://codepen.io/poetries/pen/Ndqaxx)

- **example02 拖拽相册**

```html
<h1>请拖拽图片到红框中</h1>
<div id="box"><span>可以将文件拖放到这里！！</span></div>
<div id="dustbin">垃圾回收站</div>
```

```css
#box{
	position:relative;
	width:500px;
	height:500px;
	border:2px solid red;
	margin:100px auto 0px;
	
}
#box span{
	position:absolute;
	left:0;
	top:0;
	right:0;
	bottom:0;
	height:50px;
	width:192px;
	margin:auto;
	display:none;
}
img{
	width:100px;height:100px;
}
#dustbin{
	width:200px;
	height:100px;
	background:#000;
	color:#fff;
	font-size:40px;
	text-align:center;
	line-height:100px;
	margin:auto;
}
```

```javascript
var box = document.getElementById("box");
var dusTbin = document.getElementById("dustbin");
var span = box.getElementsByTagName("span")[0];
//目标元素事件
var img = '';
box.ondragenter = function(){//进入目标元素触发
	span.style.display = "block";
}
box.ondragover = function(ev){//在目标元素上连续触发
	var ev = ev||window.event;
	ev.preventDefault();//阻止默认事件
	span.style.display = "block";
}
box.ondragleave = function(){//离开目标元素
	span.style.display = "none";
}
box.ondrop = function(ev){//在目标元素上面释放鼠标触发
	//alert("拖拽结束！！");
	var ev = ev||window.event;
	ev.preventDefault();//阻止默认事件
	span.style.display = "none";
	var file = ev.dataTransfer.files;
	//alert(file[0].type);
	for (var i=0; i<file.length ;i++ )
	{
		if (file[i].type.indexOf("image")!=-1)
		{
			var read = new FileReader();//新建一个读取文件对象
			read.readAsDataURL(file[i]);//读取文件
			read.onload = function(){//读取文件成功之后调用什么函数
				var img = document.createElement("img");
				//alert(this.result);
				img.src = this.result;
				box.appendChild(img);
				//获取img节点 实现删除功能
				var oImg = document.getElementsByTagName("img");
				if (oImg)
				{
					for (var j=0;j<oImg.length ;j++ )
					{
						oImg[j].ondragstart = function(ev){
							ev.dataTransfer.setData("data",ev.target.innerHTML);
							img = ev.target;
						}
						oImg[j].ondragend = function(ev){
							ev.dataTransfer.clearData("data");//清楚数据
							img = null;
						}
					}

				}
				//实现删除功能(移除img节点)
				dusTbin.ondragover = function(ev){
					ev.preventDefault();
				}
				dusTbin.ondrop = function(){
					if (img)
					{
						img.parentNode.removeChild(img);
					}
				}
			}
		}else{
			alert("请上传图片！");
		}
		
	}
	
}
```

[在线演示](http://codepen.io/poetries/pen/Ndqagr)


- **example03 拖拽排序**

```html
<div class="wrap" id="wrap">
  <ul id="box">
    <li style="background:#f3f" draggable="true">1</li>
    <li style="background:#ff6" draggable="true">2</li>
    <li style="background:#c60" draggable="true">3</li>
    <li style="background:#903" draggable="true">4</li>
    <li style="background:#0f6" draggable="true">5</li>
    <li style="background:#636" draggable="true">6</li>
    <li style="background:#36f" draggable="true">7</li>
    <li style="background:#033" draggable="true">8</li>
  </ul>
</div>
```

```css
.wrap{
  width:500px;
  height:500px;
  margin:50px auto;
}
ul li{
  list-style:none;
  width:500px;
  height:50px;
  color:#fff;
  text-align:center;
  line-height:50px;
  font-size:40px;
  font-weight:bold;
}
```
```javascript
var oUl = document.getElementById("box");
var oLi = oUl.getElementsByTagName("li");
var curr = 0;
function sort(){
  for (var i = 0;i < oLi.length;i++) {
    oLi[i].index = i;
    oLi[i].ondragstart = function(ev){
      var ev = ev || window.event;
      ev.dataTransfer.setData("data",this.innerHTML);
      //this.innerHTML = "被拖拽中...";
      curr = this.index;
    }

    oLi[i].ondragenter = function(){
      for(var i = 0;i < oLi.length;i++){
        oLi[i].style.border = "none";
      }
      if(curr != this.index){
        this.style.border = "2px solid #000";
      }
    }
    oLi[i].ondragover = function(e){
      var e = e || window.event;
      e.preventDefault();
    }
    oLi[i].ondrop = function(ev){ //鼠标释放的时候
      //oUl.insertBefore(oLi[curr],this);//insertBefore(新节点，目标节点)
      inserAfter(oLi[curr],this);
      this.style.border = "none";
      //oLi[curr].innerHTML = ev.DataTransfer.getData("data");
      sort();
    }
  }
}
sort();

function inserAfter(newItem,targerItem){
  var parentItem = targerItem.parentNode;
  if(parentItem.lastChild == targerItem){
    parentItem.appendChild(newItem);
  }else {
    parentItem.insertBefore(newItem,targerItem.nextSibling);
  }
}
```

[在线演示](http://codepen.io/poetries/pen/XpbEOW)

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
  - [HTML5标签速查表](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/15.png)
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

    - ```css
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

    - ![HSL色轮](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/11.png)


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

![Paste_Image.png](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/12.png)

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

  - ![标准盒子模型](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/w3c.jpg)
- **IE6混杂模式盒模型**
  - 内容高度（盒子） = `width` - `padding` - `border`
  - `width`的数值就是`element`盒子的空间高度，`width`包括了`padding`和`border`
  - ![IE盒子模型](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/ie.jpg)

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


![flex布局语法篇小结](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/10.png)

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
      
      	- `none `  没有过渡属性
      	- `all  `      所有属性都过渡(默认值)
      	- `property `   具体属性名称(`property1`,`property2`...)
      
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
    -  过渡完成事件   
	
- ![过渡完成事件](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/13.png)
	
		- `Webkit`内核： 
			```javascript
				obj.addEventListener('webkitTransitionEnd',function(){})
			```
		
		- 标准: 
		
			```javascript
				obj.addEventListener('transitionend',function(){})
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

    - ```css
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

    - ```javascript
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

    - ```javascript
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

  - ```
    1.设备宽高为375*667，可以理解为设备独立像素（或css像素）
    2.dpr为2，根据上面的计算公式，其物理像素就应该 2 ，为750*1334.
    
    1css像素在PC端显示器需要用（1*1）个栅格点表示 在iPhone6中则需要4（2*2）个
    
    也就是在不同的屏幕上（普通屏幕 vs retina屏幕），css像素所呈现的大小（物理尺寸）是一致的，不同的是一个css像素所对象的物理像素个数是不一致
    
    在普通的屏幕下，1个css像素对应的1个物理像素 为1:1 。在retina屏幕下，1个css像素对应4个物理像素 1:4
    ```

    

  - **位图像素**

  - 1个位图像素是栅格图像（如：`png`，`jpg`，`gif`等）最小的数据单元，每一个位图像素都包括着一些资深的现实信息（如：显示位置，颜色值，透明度等）

  - 在普通屏幕下是没有问题的，但是在`retina`屏幕下就会出现位图像素点不够，从而导致图片模糊的情况

  - ```
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

![](https://raw.sevencdn.com/HAODEabcd/Note/master/Web/H5C3/Tree.png)

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

    - ```js
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