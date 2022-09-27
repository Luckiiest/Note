---
title: Touch
date: 2021-11-08 15:35:53
tags: 
  - Touch
categories:
  - JavaScript
---

# [移动端 js touch事件](https://www.cnblogs.com/fengfan/p/4506555.html)

随着智能手机和平板电脑的普及, 越来越多的人用移动设备浏览网页，我们平时在`pc`浏览器上用的鼠标事件，比如：`click`, `mouseover`等， 已经无法满足移动设备触摸屏的特点，触摸时代的到来，离不开那些触摸事件。

### 触摸事件包含4个接口。

**TouchEvent**

- 代表当触摸行为在平面上变化的时候发生的事件.

**Touch**

- 代表用户手指与触摸平面间的一个接触点.

**TouchList**

- 代表一系列的`Touch`; 一般在用户多个手指同时接触触控平面时使用这个接口.

**DocumentTouch**

- 包含了一些创建 `Touch`对象与`TouchList`对象的便捷方法.

- （参考于 https://developer.mozilla.org/zh-CN/docs/Web/API/Touch_events ）

- `TouchEvent`接口可以响应基本触摸事件（如单个手指点击），它包含了一些具体的事件， 

### 事件类型

- `touchstart` : 触摸开始（手指放在触摸屏上）

- `touchmove` : 拖动（手指在触摸屏上移动）

- `touchend`: 触摸结束（手指从触摸屏上移开）

- `touchenter` ：移动的手指进入一个`dom`元素。

- `touchleave` ：移动的手指离开一个`dom`元素。

- 还有一个`touchcancel`，是在拖动中断时候触发。

### 事件属性

- `altKey ` : 该属性返回一个布尔值，表示在指定的事件发生时，`Alt` 键是否处于按下状态， `event.altKey=true|false|1|0`
- `type` : 触摸时触发的事件类型，比如`touchstart`
- **每个触摸事件都包括了三个触摸属性列表：**
- `touches`：当前位于屏幕上的所有手指触摸点的一个列表。
- `targetTouches`：当前元素对象上所有触摸点的列表。
- `changedTouches`：涉及当前事件的触摸点的列表。
- 它们都是一个数组，每个元素代表一个触摸点。
- 每个触摸点对应的Touch都有三对重要的属性，`clientX/clientY`、`pageX/pageY`、`screenX/screenY`。