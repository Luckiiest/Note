---
title: MySql
date: 2022-05-08 15:35:53
tags:
  - Mysql
categories:
  - Sql
---

# SQl

## 数据库概述及数据准备

### 数据库介绍

- 数据库定义

  - 理解：存放数据的仓库（增、删、改、查）
  - 定义：数据库（`Datebase` 简称`DB`）是一个软件产品
  - 数据库按照数据结构组织、存储和管理数据的，建立在计算机存储设备上的仓库。

- 数据库特点

  - 数据共享
  - 数据一致性和可维护性
  - 安全性
  - 完整性
  - 并发控制
  - 数据恢复

### 常见的数据库管理系统

- **Oracle** 甲骨文
  - `Oracle`他是世界上第一个商品化的关系型数据库管理系统
  - 传统行业、政府部分用`Oracle`居多
- **MySQL**
  - 小型的关系型数据库管理系统，开发者瑞典`Mysql AB`公司
  - 现属于`Oracle`旗下产品（收购）。
  - 特点：体积小、速度快、总体拥有成本低、开放源码
  - 互联网公司用`MySQL`居多
- **DB2**
  - 美国`IBM`公司开发的一款关系型数据库管理系统，`DB2`有很多版本，
    可以运行在掌上产品到大型机不同的终端机器上
- **Sybase**
  - 美国`Sysbase`公司推出的一款关系型数据库
  - 是一种基于`UNIX`或`WindowsNT`平台上客户端/服务器环境下的大型数据库
- **Access**：微软发布的关系型数据库管理系统，把数据库引擎的图形用户界面
  和开发工具结合在一起的数据库管理系统。
- **MS SqlServer**：支持标准`sql`的数据库管理系统
  - 微软推出的一款关系型数据库管理系统，运行在`Windows NT`平台上支持客户端/服务器模式的数据库，采用标准的`SQL`语言。

### sql、DB、DBMS 分别是什么

- **DB**：`DataBase`（数据库，数据库实际上在硬盘上以文件的形式存在）

- **DBMS**：`DataBase Management System`（数据库管理系统，常见的有，`MySQL` `Oracle` `DB2` `Sybase` `SqlServer`

- **SQL**：结构化查询语言，是一门标准通用的语言，标准的`sql`适用于所有的数据库产品，`sql`属于高级语言，sql 语句再执行的时候，实际上内部也会先进行编译，然后再执行`sql`，`sql`语句的编译由 DBMS 完成

  > DBMS 负责执行 sql 语句，通过执行 sql 语句来操作 DB 当中的数据
  >
  > DBMS - （执行）-> SQL - （操作） -> DB

### SQL 概述

- `SQL`，一般发音为`sequel`，`SQL`的全称`Structured Query Language`，`SQL`用来和数据库打交道，完成和数据库的通信，`SQL`是一套标准。但是每一个数据都有自己的特性别的数据库没有，当使用这个数据库特性相关的功能，这时`SQL`语句可能就不是标准了，（90%以上的`SQL`都是通用的）

### 什么是数据库

- 数据库，通常是一个或工组文件，保存了一些符合特定规格的数据数据库对应的英语单词是`DataBase`, 简称:DB,数据库软件称为数据库管理系统(DBMS)， 全称为`DataBase Management System`,如: `Oracle`、`SQL Server`、`MySq|`、`Sybase`、`informix`、 `DB2`、`interbase`、`PostgreSql`。

### MySQl 概述

- `MySQL`最初是由`MySQL AB`公司开发的-套关系型数据库管理系统( `RDBMS Relational`
  `Database Mangerment System`)。。
- `MySQL`不仅是最流行的开源数据库，而且是业界成长最快的数据库，每天有超过 7 万次的
  下载量，其应用范围从大型企业到专有的嵌入应用系统。
- `MySQL` AB 是由两个瑞典人和一个芬兰人: `David Axmark`、`Allan Larsson` 和`Michael "Monty`"`Widenius`在瑞典创办的。。
  在 2008 年初，`Sun Microsystems`收购了`MySQL AB`公司。在 2009 年，`Oracle` 收购了`Sun`公司，使`MySQL`并入`Oracle`的数据库产品线。

### 表

> 表（table）：是数据库最基本的组成单元，数据库是用来存储数据的，数据库中有很多表，每一个表都是一个独立的单元，表也是一个结构化的文件，由行和列组成，行称为数据戒记录，列称为字段， 字段又包含：字段名称、字段类型、长度、约束。

- 表：`table`

  - `table`是数据库的基本组成单元，所有的数据都以表格的形式组织，目的是可读性强

  - 一个表包括行和列：


```mysql
学号（int) 	姓名(varchar)		年龄(int)
-----------------------------------------
110			  张三			   20
120			  李四			   21
```

- 行：被称为数据 / 记录
- 列：被称为字段（`column`）
  - 每一个字段都应该包括哪些属性？
    - 字段名、数据类型、相关的类型

### SQL 语句的分类

- `SQL`语句包括增删改查，那么究竟怎么分类？
- **DQL（数据查询语言）**：查询语句，凡是`select`语句都是`DQL`
- **DML（数据操作语言）**：`insert`、`delete`、`update`，对表当中的数据进行增删改
- **DDL（数据定义语言）**：`create`、`drop`、`alter`，对表结构的增删改
- **TCL（事务控制语言）**：`commit`提交事务，`rollback`回滚事务（`TCL`中的`T`是`Transaction`）
- **DCL（数据控制语言）**：`qrant`授权、`revoke`撤销权限等

### 导入演示数据

- 一、登录`mysql`数据库管理系统

  - `dos`命令窗口
    - **mysql -u root -p**

- 二、查看有哪些数据库

  - **show databases**;（这个不是`SQL`语句，是`MySQL`的命令）


```mysql
自带的数据库
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sakila             |
| sys                |
| world              |
+--------------------+
```

- 三、创建属于我们自己的数据库

  - **create database 数据库名称;**（这个不是`SQL`语句，属于`MySQL`的命令)
  - `bjpowernode`是数据库名字

- 四、使用`bjpowernode`数据库
- **use 数据库名称;**（这个不是`SQL`语句，属于`MySQL`的命令）
- 五、查看当前使用的数据库中有那些表格
- **show tables;**（这个不是`SQL`语句，属于`MySQL`的命令）
- 六、初始化数据

  - https://github.com/HAODEabcd/Note/blob/master/SQL/bjpowernode.sql 文件地址

  - **source D:././././bjpowernode.sql**

  - 注意：数据初始化完成之后，有三张表


```mysql
+----------------------------+
| Tables_in_bjpowernode      |
+----------------------------+
| dept						 |
| emp               		 |
| salqrade			 		 |
+----------------------------+
```

- **sql 脚本**

  - `bjpowernode.sql`，这个文件以`sql`结尾，这样的文件被称为"`sql`脚本"。什么是`sql`脚本？
  - 当一个文件的扩展名是`.sql`，并且该文件中编写了大量的`sql`语句，我们成这样的文件为`sql`脚本
  - 直接使用 source 命令可以执行`sql`脚本
  - `sql`脚本中的数据量太大的时候，无法打开，请使用`source`命令完成初始化
  - `sql`脚本有很多，每一个都不一样，我这个仅仅是练习使用

- 六、删除数据库：**drop database 数据库名称;**

### 查看表结构

```
+-----------------------+
| Tables_in_bjpowernode |
+-----------------------+
| dept                  |	(部门表)
| emp                   |	(员工表)
| salgrade              |	(工资等级表)
+-----------------------+
```

- 查看表结构
  - **desc 数据库中表的名称;**
  - `desc` `dept / emp / salgrade`;
- 查看表中的数据
  - **select \* from 数据库中表的名称;**
  - `select * from emp;`

## 常用命令

- 查看**mysql**版本

  - `mysql -Version`
  - `select version()`

- 创建数据库

  - `create database 数据库名称`

- 查询当前使用的数据库

  - `select database()`
  - 查询数据库版本 `select version()`

- 终止一条语句

  - `\c` 可以终止一条语句

- 退出**MySQL**

  - `exit` 退出`mysql`

## 查看演示数据的表结构

- 查看数据库
  - `show databases;`
- 使用数据库

  - `use 数据库名称;`

- 查看当前使用的数据库
  - `select database();`
- 查看数据库中的表
  - `show tables;`
- 查看其他数据库中的表

  - `show tables from 数据库名称;`

- 查看表结构
  - `desc 表名称;`
- 查看表的创建语句
  - `show create table 表名称;`

## DQL（数据查询语言）

### 简单的查询

- **select 字段名 1，字段名 2，字段名 3，......from 表名;**
- `select ename,sal from emp;`
- 提示：
  - 任何一条`sql`语句都以";"（分号）结尾
  - `sql`语句不区分大小写
  - 字段可以参与数学运算
    - `select ename,sal * 12 from emp`
  - 查完之后列可以重命名
    - `select 字段1，字段2 as 更改后的列名 from emp;`
    - `select ename,sal * 12 as yearsal from emp;`
    - `as`关键字可以省略
  - 标准`sql`语句中，要求用字符串使用单引号括起来-
- 查询所有数据
  - `select * from emp;`
  - 实际开发中不建议使用，效率较低

### 条件查询

**语法格式**

```mysql
select
	字段，字段……
from
	数据库中的数据表名称
where
	条件;

执行顺序：先from，然后where，最后select
```

| 运算符         | 作用                                                                                                        |
| -------------- | ----------------------------------------------------------------------------------------------------------- |
| `=`            | 等于                                                                                                        |
| `<>`或`!=`     | 不等于                                                                                                      |
| `<`            | 小于                                                                                                        |
| `<=`           | 小于等于                                                                                                    |
| `>`            | 大于                                                                                                        |
| `>=`           | 大于等于                                                                                                    |
| `between…and…` | 两个值之间，等同于 `x >= 1 and x <= 3`                                                                      |
| `is null`      | 为`null`（`is not null` 不为空）                                                                            |
| `and`          | 并且                                                                                                        |
| `or`           | 或者                                                                                                        |
| `in`           | 包含，相当于多个`or`（就是在这个几个值当中寻找），`in(条件1，条件……)`，`in`里面的条件就是精确的值，不是范围 |
| `not in`       | 不包含，不在这几个值当中                                                                                    |
| `not`          | `not`可以取非，主要用作`js`或`in`中                                                                         |
| `like`         | `like`称为模糊查询，要掌握两个符号，`%`和`_`，`%`代表任意多个字符，`_`代表任意一个字符                      |

> 在数据库中 NULL 不是一个值，代表什么也没有，为空，空不是一个值，不能用等号衡量，必须使用 is null 或者 is not null
>
> 当运算符优先级不确定的时候加小括号
>
> 模糊查询中，要掌握两个特殊符号，一个是`%`一个是`_`

### 排序

- `order by`

- 例：`select 字段 from 表名 order by 字段`

- 默认是升序

- `asc`表示升序，`desc`表示降序

- 升序
  - `select 字段 from 表名 order by 字段`
  - `select 字段 from 表名 order by 字段 asc`
- 降序

  - `select 字段 from 表名 order by 字段 desc`

- 多个字段排序

> 两个字段进行排序，如果前面那个字段可以正常排序，就不执行后面的那个字段排序，如果前面的那个字段无法进行排序，就执行后面的那个字段排序
>
> 越靠前的字段越能起到主导作用，只有当前面的字段无法排序时，才会启用后面的字段

- `select 字段 from 表名 order by 字段 desc ， 字段 asc`

- 条件排序


```mysql
 执行顺序
select
	*(字段)			3
from
	表名				1
where
	条件				2
order by
	字段				4
```

### （分组/聚合/多行、单行处理）函数

#### **分组函数/多行函数**

- 多行处理函数就是多行最后得出一个结果

- `count()` 计数

  - `count(*)` 不是统计某个字段中数据的个数，而是统计的总记录条数（和某个字段无关）
  - `count(字段)`表示统计的这个字段中不为 NULL 的数据总数量
  - `count(字段)`

- `sun()` 求和

  - `sum(字段)`

- `avg()` 平均值

  - `avg(字段)`

- `max()` 最大值

  - `max(字段)`

- `min()` 最小值

  - `min(字段)`


```mysql
select sum(字段) from 表   ----> 求和
select max(字段) from 表   ----> 最大值
select min(字段) from 表	----> 最小值
select count(字段) from 表	   ----> 计数
select avg(字段) from 表	   ----> 计数
```

> 所有的分组函数都是对“某一组”数据进行操作的。
>
> 分组函数也叫多行处理函数，多行处理函数的特点，输入多行，最终输出一行。
>
> 分组函数自动忽略 NULL。
>
> 数据库中数学表达式中有 NULL，进行数学运算，最后都是 NULL，没有值
>
> 分组函数不可直接使用在 where 子句当中，因为 group by 是在 where 之后才会执行

#### 单行处理函数

- 单行处理函数的特点是输入一行，输出一行
- `ifnull()` 可能为`NULL`的数据，都被当作什么处理
  - `ifnull(字段,0)`：如果这个字段是`NULL`，那么当成`0`处理
- `Lower()`：转换小写
- `upper()`：转换大写
- `substr()`：取子串（被截取的字符串的起始下标，截取的长度）
  - `substr(字段，被截取的字符串的起始下标，截取的长度)`
- `length()`：取长度
- `trim()`：去空格
- `str_to_date()`：将字符串转换为日期
- `format()`：设置千分位
- `round()`：四舍五入
  - `round(数字，小数点后保留的位数)`
- `rand()`：生成随机数
  - 生成的`0-1`的随机数

### 分组查询

- `group by` ：按照某个字段或者多个字段进行分组
  - `select 字段 from 表名 group by 字段`
  - 一个字段分组：`group by 字段`
  - 多个字段分组：`group by 字段，字段`
- `having`：是对分组之后的数据进行再次过滤
  - `heaving`是在`group by`之后完成过滤
  - `where`实在`group by`之前完成过滤
  - 能够在`where`在过滤的数据不要放到`having`中进行过滤，否则影响`SQL`语句的执行效率

> 分组函数一般都会和 group by 联合使用，这也是它被称为分组函数的原因，并且任何一个分组函数都是在 group by 语句执行结束之后才会执行
>
> 当一条 sql 语句中没有 group by 的话，整张表的数据会自成一组
>
> 当一条 sql 语句有 group by 时，select 后面只可以有参加分组的字段和分组函数字段

### 完整的 DQL 语句

```mysql
语句			执行顺序

select			5
	...
from			1
	...
where			2
	...
group by		3
	...
having			4
	...
order by		6
	...

书写顺序不可以颠倒，它可以缺少某个，但是不可以颠倒顺序
```

### 关于查询结果的去重

- **distinct**
  - 例：`select distinct 字段 from 表 where ... `
  - `distinct`只可以出现在所有字段的最前面
  - `distinct`出现在最前面是为了后面所有字段联合起来去重

### 连接查询

#### 概述

- 什么是连接查询
  - 在实际开发中，大部分都不是从单表中查询数据，一般都是多张表联合查询，取出结果，在实际开发中，一般一个业务都会对应多张表，比如，学生和班级，起码两张表，如果存在一张表，数据会存在大量的冗余。

#### 分类

- 分局语法出现的年代来划分，包括

  - **SQL92**（一些老的`DBA`可能还在使用这种语法，`DBA`：`DataBase Administerator`，数据库管理员）
  - **SQL99**（比较新的语法）

- 根据表的连接方式来划分，包括
  - 内连接：
    - 等值连接
    - 非等值连接
    - 自连接
  - 外连接
    - 左外连接（左连接）
    - 右外连接（右连接）
  - 全连接

#### 笛卡尔积现象/别名

- 笛卡尔乘积现象

  - 若两张表迚行连接查询的时候没有仸何条件限制，最终的查询结果总数是两张表记录 的乘积，该现在称为笛卡尔积现象。
  - 避免笛卡尔积现象
    - 避免笛卡尔积现象，不会减少记录的匹配次数，只是显示的是有效记录，并不会提高执行效率
    - 例如：`select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno;`
      - `SQL92`语法

- 别名
  - `select 表别名.字段，表别名.字段 from 表名 表别名(生成的)，表名 表别名(生成的)`
  - 例如：`select e.ename,d.dname from emp e,dept d;`
  - 可读性好
  - 执行效率高

#### 内连接

##### 等值连接

> 内连接之等值连接：最大的特点是：连接条件是等量关系

- 示例：查询员工的名称和员工所对应的部门名称


```mysql
emp是员工表，dept是部门表，e.name和d.name是emphe dept两个表的

SQL92:
	select
		e.name,d.dname
	from
		emp e,dept d
	where
		e.deptno = d.deptno

SQL99:
	select
		e.ename,d.dname
	from
		emp e
	join
		dept d
	on
		e.deptno = d.deptno;
```


  	select e.ename,d.dname from emp e inner join dept d on e.deptno = d.deptno;

  注：inner可忽略
  ```

- ```mysql
  join on的语法

  ...
  	A
  inner join
  	B
  on
  	连接条件
  where
  	...

  99的语法结构更加清晰，表与表的连接条件和where的条件分离了，inner可以省略，带着inner可以看出来是内连接
  ```

##### 非等值连接

> 内连接之非等值连接：最大的特点是：连接条件中的关系是非等量关系

- 找出每个员工的工资等级，要求显示员工名，工资、工资等级


```mysql
select
	e.ename,e.sal,s.grade
from
	emp e
join
	salgrade s
on
	e.sal
between
	s.losal
and
	s.hisal

e.ename是名字，e.sal是工资,s.grade是等级
emp 是员工表
salgrade 是薪资等级表
```

##### 自连接

> 自连接：最大的特点是：一张表看做两张表，自己连接自己

- 找出每个员工的上级领导，要求显示员工名和对应的领导名


```mysql
select
	a.ename as '员工表',b.ename as '领导表'
from
	emp a
inner join
	emp b
on
	a.mgr = b.empno;
```

#### 外连接

- 什么是外连接，和内连接有什么区别？
  - 内连接
    - 假设`A`和 B 表进行连接，使用内连接的话，凡是`A`表和`B`表能够匹配上的记录查询出来，这就是内连接，`AB`两张表没有主副之分
  - 外连接
    - 假设`A`和`B`表进行连接，使用外连接的话，`AB`两张表中有一张是主表，一张表是副表，主要查询主表中的数据，捎带着查询副表，当副表中的数据没有和主表中的数据匹配上，副表自动模拟出`NULL`与之匹配
    - 朱标的数据无条件的全部查询出来
- 左外连接：表示左边的这张表是主表

- 右外连接：表示右边的这张表是主表

- 左连接有右连接的写法，右连接也会有对应的左连接的写法

- 语法


```mysql
join on的语法

...
	A
left/right outer join
	B
on
	连接条件
where
	...

outer可以省略，区分内外连接主要不是inner和outer这两个单词，带着两个单词可读性强，外连接使用较多
```

- 例：找出所有员工的上级领导


```mysql
左外连接
select
	a.ename as '员工',b.ename as '领导'
from
	emp a
left join
	emp b
on
	a.mgr = b.empno;
```


~~~sql
右外连接
select
a.ename as '员工',b.ename as '领导'
from
	emp b
right join
	emp a
on
	a.mgr = b.empno;

a是主表，b是副表，left代表左外连接，right代表右外连接
```
~~~

- 找到那个部门没有员工


```mysql
select
	d.*
from
	emp e
right join
	dept d
on
	e.deptno = d.deptno
where
	e.empno is null;
```

- 三个表连接

  - 找出每一个员工的部门名称、工资等级、以及上级领导


```mysql
select
	e.ename as '员工',d.dname,s.grade,el.ename '领导'
from
	emp e
join
	dept d
on
	e.deptno = d.deptno
join
	salgrade s
on
	e.sal between s.losal and s.hisal
left join
	emp e1
on
	e.mgr = e1.empno;
```

### 子查询

- 什么是子查询？子查询都可以出现在哪里？

  - `select`语句当中嵌套`select`语句，被嵌套的`select`语句是子查询

  - 子查询可以出现在哪里？


```mysql
select
	..(select).
from
	..(select).
where
	..(select).
```

#### where 后面子查询

- 案例：在`emp`表中找出高于平均工资的员工信息


```mysql
select * from emp where sal > avg(sal); // 错误，where后面不能有分组函数

第一步:找出平均薪资，结果就是平均薪资
select avg(sal) from emp;
第二步：where过滤
where sal > 第一步的结果
合并：
select * from emp where sal > (select avg(sal) from emp);
```

#### from 后面子查询

- 案例：找出每个部门平均薪水的薪资等级


```mysql
第一步：找出每个部门平均薪水（按照部门编号分组，求sal的平均值）
select deptno,avg(sal) as avgsal from emp group by deptno;
第二步：将以上的查询结果当作临时表t，让t表和薪资等级表连接
select
	t.*,s.grade
from
	(select deptno,avg(sal) as avgsal from emp group by deptno) t
join
	salgrade s
on
	t.avgsal between s.losal and s.hisal;
```

- 案例：找出每个部门平均的薪水等级


```mysql
先找薪水等级，把薪水等级平均

第一步：找出每个员工的薪水等级
select
	e.ename,e.sal,e.deptno,s.grade
from
	emp e
join
	salgrade s
on
	e.sal between s.losal and s.hisal;
第二部：基于以上结果，继续按照deptno分组，求grade平均值
select
	e.deptno,avg(s.grade)
from
	emp e
join
	salgrade s
on
	e.sal between s.losal and s.hisal
group by
	e.deptno;
```

#### select 后面嵌套子查询

- 找出每个员工所在的部门名称，要求显示员工名和部门名


```mysql
select
	e.ename,e.deptno,
	(select d.dname from dept d where e.deptno = d.deptno) as dname
from
	emp e;
```

## limit、union

### union

- 可以将查询结果相加，两张不相干的表中的数据拼接在一起显示

- `union`上下拼接的时候显示的列数要一样

- 案例：找出工作岗位是 SALESMAN 和 MANAGER 的员工？


```mysql
第一种：
select ename,job from emp where job = 'SALESMAN' or job = 'MANAGER';

第二种：使用in
select ename,job from emp where job in('SALESMAN','MANAGER');

第三种：union
select ename,job from emp where job = 'SALESMAN'
union
select ename,job from emp where job = 'MANAGER';
```

### limit

- `limit`是`mysql`特有的，其他数据库没有，不通用（`oracle`中有一个相同的机制，叫`rownum`）

- `limit`取结果集中的部分数据，这是它的作用

- 语法机制：


```mysq
limit startIndex,length
	startIndex 表示起始位置，默认从0开始，不写就是从0开始
	length 表示取几个
```

- 案例：取出工资前五名的员工


```mysql
select e.ename,e.sal from emp e order by sal desc limit 0,5;
```

- 案例：找出工资排名在第 4 到第 9 的员工


```mysql
select e.ename,e.sal from emp e order by sal desc limit 3,6;
3表示，起始位置，6代表取6个
```

- `limit`是`SQL`语句最后执行的一个环节


```mysql
select
	...
from
	...
where
	...
group by
	...
having
	...
order by
	...
limit
	...
```

- 分页显示采用`limit`

  - 每页显示三条记录：


```mysql
第一页：0，3
第二页：3，3
第二页：6，3
第二页：9，3
第二页：12，3
```

- 每页显示`pageSize`条记录

  - 第`pageNo`页：`（pageNo - 1) * pageSize`，`pageSize`

## 数据类型

| 数据类型  | 占用字节数             | 描述                                                         |
| --------- | ---------------------- | ------------------------------------------------------------ |
| `char`    | `char(n)`              | 定长字符串，存储空间大小固定使用`char(2)`来表示类型或状态    |
| `varchar` | `varchar(n)`           | 变长字符串，存储空间等于实际数据空间，只包含英文字符的字符串 |
| `int`     | 4 个字节               | 整型                                                         |
| `bigint`  | 8 个字节               | 长整型                                                       |
| `float`   | `float(有效位数)`      | 数值型                                                       |
| `double`  | `double(有效数字位数)` | 数值型                                                       |
| `date`    | 8 字节                 | 日期和时间                                                   |
| `BLOB`    |                        | `Binary Large Object`（二进制大对象）                        |
| `CLOB`    |                        | `Character Large Object`（字符大对象）                       |
| 其他...   |                        |                                                              |

- **varchar** ：可变长度字符串

  - `varchar(3)`表示存储的数据长度不能超过 3 个字符长度

- **char**：定长字符串
  - `char(3)`表示存储的数据长度 ch 不能超过 3 个的字符长度
- **int**：整数型
  - `int(3)`表示最大可以存储 999
- **bigint**：长整型
  - 对应`long`类型
- **float**：浮点型单精度
  - `float(7,2)`表示 7 个有效数字，2 个有效小数位
- **double**：浮点双精度

  - `double(7,2)`表示 7 个有效数字，2 个有效小数位

- **date**：日期类型
  - 实际开发中，常用字符串代替日期类型
- **BLOB**：二进制大对象（`Binary Large Object`）

  - 专门存储图片、视频、声音等数据
  - 数据库存储图片很常见，但存储大视频很少见，一般都是存储视频地址

- **CLOB**：字符串大对象（`Character Large Object`）

  - 存储超大文本，可存储`4G+`的字符串

- **varchar 与 char 对比**
  - 都是字符串
  - `varchar`比较智能，可以根据实际数据长度分配空间，比较节省空间；但在分配的时候需要相关判断，效率低
  - `char`不需要动态分配空间，所以执行效率高，但是可能会导致空间浪费
  - 若字段中的数据不具备伸缩性，建议采用`char`类型存储
  - 若字段中的数据具有很强的伸缩性，建议采用`varchar`类型存储

## DDL（数据定义语言）

### 创建表

- 语法：


```mysql
create table 表名(
    字段名1 数据类型 约束,
	字段名2 数据类型 约束,
    字段名3 数据类型 约束,
   	......
);
```

- 表名在数据库中一般建议以：`t_`或`tbl_`开始

- 案例：创建学生表

  - 学生信息包括：

    - 学号、姓名、性别、班级编号、生日
    - 学号：`bigint`
    - 姓名：`varchar`
    - 性别：`char`
    - 班级编号：`int`
    - 生日：`char`


```mysql
create table t_student(
	no bigint,
    name varchar(255),
    sex char(1),
    classno varchar(255),
    birth char(10)
);
```

### 删除表

- 语法：


```mysql
drop table if exists 表名;	// 当这个表存在的话删除
```

### 修改表结构

```mysql
删除列
alter table 【表名字】 drop 【列名称】

增加列
alter table 【表名字】 add 【列名称】 数据类型 not NULL comment '注释说明'

修改列的类型信息
alter table 【表名字】 change 【列名称】【新列名称（这里可以用和原来列同名即可）】 数据类型 not NULL  comment '注释说明'

重命名列
alter table 【表名字】 change 【列名称】【新列名称】 数据类型 not NULL  COMMENT '注释说明'

重命名表
alter table 【表名字】 rename 【表新名字】

删除表中主键
alter table 【表名字】 drop primary key

添加主键
加主关键字的索引
alter table tablename add primary key(id);
alter table sj_resource_charges add constraint PK_SJ_RESOURCE_CHARGES primary key (resid,resfromid)

添加索引
alter table tablename add index 索引名 (字段名1[，字段名2 …]);
alter table tablename add index emp_name (name);
alter table sj_resource_charges add index index_name (name);

添加唯一限制条件索引
alter table sj_resource_charges add unique emp_name2(cardnumber);

删除索引
alter table tablename drop index emp_name;

查看某个数据表的索引
show index from 表名;

MySQL创建、删除、重建和查看索引命令总结如下：

创建索引（primary key，index，unique）
alter table tbl_name add index index_name (column list);
alter table tbl_name add unique index_name (column list);
alter table tbl_name add primary key index_name (column list);

删除索引（primary key，index，unique）
alter table tbl_name drop index index_name (column list);
alter table tbl_name drop unique index_name (column list);
alter table tbl_name drop primary key index_name (column list);

重建索引
rename table tbl_name quick;

查看某个数据表的索引
show index from tbl_name;
```

## DML（数据操作语言）

### insert 语句插入数据

- 语法格式

  - **插入单行数据**


```mysq
insert into 表名
	(字段名1,字段名2,字段名3,....)
values
	(值1,值2,值3,......);

insert into values(值1,值2,值3,......); 	//这样就只能对应列的数量写
```

- **插入多行数据**


```mysql
insert into 表名
	(字段名1,字段名2,字段名3,....)
values
	(值1,值2,值3,......),
	(值1,值2,值3,......),
	(值1,值2,值3,......);
```

- 要求：字段的数量和值的数量相同，并且数据类型要对应相同
- 可以只插入指定字段，其他字段如果没有数据，则为`NULL`
- `into`可以省略的

- 案例：


```mysql
插入单行数据
insert into t_student
	(no,name,sex,classno,birth)
values
	(1,'zhangsan','m','gaosanyiban','1999-01-22');

插入多行数据
insert into t_student
	(no,name,sex,classno,birth)
values
	(2,'lsi','m','gaosanyiban','1999-01-22'),
	(3,'wangwu','m','gaosanyiban','1999-01-22'),
	(4,'zhaoliu','m','gaosanyiban','1999-01-22'),
	(5,'shenqi','m','gaosanyiban','1999-01-22');
```

- 注意：
  - 当一条`insert`语句执行成功之后，表格当中必然会多一行记录。
  - 即使多的这一行记录当中某些字段是`NULL`，后期也没有办法在执行
  - `insert`插入数据了，只能使用`update`进行更新了

### 表的复制及批量插入

- 表的复制


```mysql
create table 表名 as select语句;   // 将查询结果当作表创建出
```

- 批量插入


```mysql
insert into 表名 select语句
```

- 注意：这里有表结构的影响，不同的表结构不可以随便插入

### update 修改表的数据

```mysql
update 表名 set 字段名1=值1，字段名2=值2... where 条件;
```

- 注意：没有条件整张表将全部更新

### delete 删除数据

```mysql
detele from 表名 where 条件;
```

- 注意：没有条件全部删除

- 怎么删除大表中的数据（数据量特别大的表）


```mysql
truncate table 表名
```

- 表被截断，不可回滚，永久丢失

- 删之前，慎重！

## 约束（Constraint）

- 什么是约束？常见的约束有哪些？
  - 在创建表的时候，可以给表的字段添加响应的约束，添加约束的目的是为了保证表的数据的合法性、有效性、完整性
  - 常见的约束
    - 非空约束（**not null**）：约束的字段不能为`NULL`
    - 唯一约束（**unique**）：约束的字段不能重复
    - 主键约束（**primary key**）：约束的字段不能为`NULL`，也不能重复（简称`PK`）
    - 外键约束（**foreign key**）：（简称`FK`）
    - 检查约束（**check**）
      - 注意：`Oracle`数据空有`check`约束，但`mysql`没有

### 非空约束

- **not null**


```mysql
create table t_user(
	id int,
    username varchar(255) not null, -- 这样username这列就必须填写值，不可以为空（NULL）
    password varchar(255)
);
```

### 唯一约束

- **unique**

  - 唯一约束修饰的字段具有唯一性，不能重复，但可以为`NULL`


```mysql
给一个字段加唯一约束
create table t_user(
	id int unique, -- id这列就是唯一了，不可以填写重复的值，可以为NULL
    username varchar(255),
);

表级约束：给多个字段加唯一约束
create table t_user(
	id int,
    username varchar(255),
    usercode varchar(255),
    unique(username,usercode)
);

列级约束：给多个字段加唯一约束（2）
create table t_user(
	id int,
    username varchar(255) unique,
    usercode varchar(255) unique
)

表级约束中的unique(字段1，字段...)表示的是多个字段联合建立一个约束，只要多个字段连接起来重复才是重复，单独一个字段重复，是不重复
列级约束在字段后面加unique是给单独这一个字段加唯一约束，这个字段有重复的就不可以
```

### 主键约束

- **primary key**

  - 主键特点：不能为`NULL`，也不能重复
  - 一张表的主键约束只能有**1**个（重点）


```mysql
列级主键约束
create table t_user(
	id int primary key,
    username varchar(255),
    email varchar(255)
)
insert into t_user(id,username,email) values(1,'zs','zs@123.com')

表级主键约束
create table t_user(
	id int,
    username varchar(255),
    email varchar(255),
    primary key(id) -- 和标记unique约束一样
)
insert into t_user(id,username,email) values(1,'zs','zs@123.com')

复合主键约束
create table t_user(
    id int,
    username varchar(255),
    password varchar(255),
    primary key(id,username)
)
```

- 相关术语：
  - 主键约束（`primary key`）
  - 主键字段（`id`字段添加`primary key`之后，`id`叫做主键字段）
  - 主键值（`id`字段中的每一个值都是主键值）
- 主键有什么作用呢？

  - 表的设计三范式有要求，第一范式中就要求任何一张表都应该有主键
  - 主键的作用：主键值是这行记录在这张表当中的唯一标识。（就像身份证号一样）

- 主键分类
  - 根据主键字段的字段数量来划分
    - 单一主键（常用，推荐）
    - 复合主键（多个字段联合起来添加一个主键约束）（不建议用，违反三范式）
  - 根据主键性质来划分
    - 自然主键
    - 业务主键（主键值和系统的业务挂钩）（银行卡的卡号、身份证号作为主键）（不推荐用）
      - 最好不要拿着和业务挂钩的字段作为主键，因为以后的业务一旦发生改变的时候，主键值也需要随着发生变化，但有的时候没有办法变化，因为变化会导致主键值重复
- 主键值自增

  - **auto_increment**


```mysql
create table t_user(
	id int primary key auto_increment, -- 在primary key后面加上auto_increment就是自增了
    username varchar(255),
)
```

- `Oracle`当中也提供了一个自增机制，叫做：序列（`sequence`）对象

### 外键约束

- 相关术语：

  - 外键约束（`foreign key`）
  - 外键字段：添加有外键约束的字段
  - 外键值：外键字段中的每一个值

- 业务背景（请设计数据库表，用来维护学生和班级的信息？）

  - 第一种方案：一张表存储所有数据（冗余）


```mysql
no(pk)		name	 classno	  classname
---------------------------------------------------
1			zs1		   101		  亦庄二中高三1班
2			zs2		   101		  亦庄二中高三1班
3			zs3		   102		  亦庄二中高三2班
4			zs4		   102		  亦庄二中高三2班
5			zs5		   102		  亦庄二中高三2班
```

- 第二种方案：两张表（班级表，学生表）


```mysql
-- t_class 班级表表
classno		classname
--------------------------------
101			亦庄二中高三1班
102			亦庄二中高三2班

-- t_student 学生表
sno			sname		 classno(该字段添加外键约束fk)
--------------------------------------------------------
1			zs1			 101
2			zs2			 101
3			zs3			 102
4			zs4			 102
5			zs5			 102
```

- 将以上表建表语句写出来：

  - `t_student`中的`classno`字段引用`t_class`表中的`classno`字段，此时，`t_student`叫做子表，`t_class`叫做副表

  - 顺序要求

    - 删除数据的时候，先删除子表，在删除父表
    - 添加数据的时候，先添加父表，在添加子表
    - 创建表的时候，先创建父表，在创建子表
    - 删除表的时候，先删除子表，在删除父表


```mysql
create table t_class(
	classno int,
    classname varchar(255),
    primary key(classno)
)

create table t_student(
	sno int,
    sname varchar(255),
    cno int,
    primary key(sno),
    foreign key(cno) references t_class(classno)
)
```

- 语法


```mysql
foreign key(需要外键字段) references 父表名(要引用的字段)
```

- 子表中的外键值需要引用父表的外键值，不可以和父表的外键值不一样

- 外键值可以为`NULL`

- 外键字段引用其他表的某个字段的时候，被引用的字段必须是主键吗？

  - 被引用的字段不一定是主键，但是至少要有`unique`唯一性

### 默认值约束

- 语法

- ```mysql
  <字段名> <数据类型> default <默认值>;
  ```

## 存储引擎

- 存储引擎是：`MySQL`特有的，其它数据库没有，存储引擎这个名字旨在`mysql`中存在（`Oracle`中有对应的机制，但是不叫存储引擎，叫存储方式)

### 存储引擎的本质

- `mysql`支持很多的存储引擎，每一个存储引擎都对应了一种不同的存储方式
- 每一个存储引擎都有自己的优缺点，需要在合适的时机选择合适的存储引擎
- 通过采用不同的技术将数据存储在文件或内存中；
- 每一种技术都有不同的存储机制，不同的存储机制提供不同的功能和能力
- 通过选择不同的技术，可以获得额外的速度或功能，改善我们的应用；

### 查看存储引擎

- **show engines\G**
- 在创建表时，可使用< ENGINES> 选项为 CREATE TABLE 诧句显示指定存储引擎
  - 例如：`create table table_name(no int)engine = myisam;`
- 如果创建表时没有指定存储引擎，则使用当前默认的存储引擎；
- 默认的存储引擎可在 `my.ini` 配置文件中使用 `default-storage-engin` 选项指定；
- 修改表的存储引擎使用：`alter table 表名 engine= 存储引擎名称;`
- 查看表使用的存储引擎，命令如下：
  - `show create table 表名\G;`
  - `show table status like '表名'\G;`

### 常见的存储引擎

#### MyISAM 存储引擎

```mysql
Engine: MyISAM
     Support: YES
     Comment: MyISAM storage engine
Transactions: NO 						-- 事务（TCL）
          XA: NO
  Savepoints: NO
```

- `MyISAM`不支持事务
- `MyISAM`是`MyISAM`最常用的，但不是默认的引擎
- 他管理的表具有以下特性
  - 每个表使用三个文件来存储所有的东西
    - 格式文件——存储表的结构（`mytable.frm`）
    - 数据文件——存储表的数据（`mytable.MYD`）
    - 索引文件——储存表的索引（`mytable.MYI`）
  - 灵活的`auto_increment`字段处理
  - 可被转换为压缩、制度来节省空间

#### InnoDB 引擎

- `InnoDB`存储引擎是`MySQL`的缺省引擎
- 它管理的表主要具有以下特征
  - 每个`InnoDB`表在数据库目录中以`.frm`格式文件表示
  - `InnoDB`表空间`tablespace`被用于存储表的内容
  - 提供一组用来记录事务性活动的日志文件
  - 用`commit`（提交）、`savepoint`及`rollback`（回滚）支持事务处理
  - 提供全`ACID`兼容
  - 在`MySQL`服务器崩溃后提供自动回复
  - 多版本（`MVCC`）和行级锁定
  - 支持外键及引用的完整性，包括级联删除和更新
  - 很安全，支持事务

#### MEMORY 存储引擎

- 使用`MEMORY`存储引擎的表，因为数据存储在内存中，且行的长度固定，所以使得`MEMORY`存储引擎 非常快；
- `MEMORY`存储引擎管理的表具有下列特征：
  - 在数据库目录内，每个表均以`.frm`格式文件表示
  - 表数据及索引被存储在内存中
  - 表级锁机制
  - 字段属性性能包含`TEXT`或`BLOB`字段
- `MEMORY`存储引擎以前被称为`HEAP`引擎

#### 选择合适的存储引擎

- `MyISAM`表最适合于大量的数据读而少量数据更新的混合操作。`MyISAM`表的另一种适用情形是使用压缩的只读表。
- 如果查询中包含较多的数据更新操作，应使用`InnoDB`。其行级锁机制和多版本的支持为数据读取和更新的混合提供了良好的并发机制。
- 使用`MEMORY`存储引擎存储非永丽需要的数据，或者是能够从基于磁盘的表中重新生成的数据。

## 事务（Transaction）

### 什么是事务

- 一个事务是一个完整的业务逻辑单元，不可再分
- 通常一个事务对应一个完整的业务；（如：银行转账业务）
- 而一个完整的业务需要批量的`DML`（`insert`、`update`、`delete`）语句共同完成；
- 事务只和`DML`语句有关系，或者说只有`DML`语句才有事务；
- 以上所描述的批量`DML`语句共有多少`DML`语句，这个和业务逻辑有关系，业务逻辑不同`DML`语句个数不同 ；
- 假设所有的业务都能使用`1`条`DML`语句搞定，还需要事务机制吗？不需要事务，但实际情况不是这样的，通常一个事务需要多条`DML`语句共同联合完成

### 事务的一些概念\SQL 语句

- **SQL**语句

  - **commit**：提交事务
  - **rollback**：回滚事务

- 概念

  - 开启事务（`start transaction`）
  - 结束事务（`end transaction`）
  - 提交事务（`commit transaction`）
  - 回滚事务（`rollback transaction`）

- 开始和结束的标志


```mysql
假设一个事儿，需要先执行一条insert，在执行一条update，最后执行一条detele，这个事才算完成

开启事务机制（开始）

执行insert语句-->insert....（这个执行成功之后，把这个执行记录到数据库的操作历史当中，并不会向文件中保存一条数据，不会真正修改硬盘上的数据）
执行一条update语句 --> update...（这个执行也是记录一下历史操作，不会真正的修改硬盘上的数据）
执行delete语句 --> delete...（这个执行也是记录以下历史操作【记录到缓存】，不会真正的修改硬盘上的数据）

提交事务或者回滚事务（结束）
```

- 开始的标志：任何一条`DML`语句执行，标志着事务的开始

- 结束的标志：

  - 提交（`commit`）、回滚（`rollback`）
    - 提交：成功的结束，将所有的`DML`语句操作记录和底层硬盘文件中数据进行一次同步
    - 回滚：失败的结束，将所有的`DML`语句操作记录全部清空

- **重点**

  - 在事务进行过程中，未结束之前，`DML`语句是不会修改底层数据库文件中的数据
  - 只是将历史操作记录以下，在内存中完成记录
  - 只有在事务结束的，而且是成功结束的时候才会修改底层硬盘文件中的数据

### 事务四个特性（ACID）

- 事务可以保证多个操作原子性，要么全成功，要么全失败。对于数据库来说，事务保证批量的`DML`要么全成功，要么全失败。

- **A**：原子性（`Atomicity`）：最小单元，不可再分
- **C**：一致性（`Consistency`）：事务要求所有的`DML`语句操作的时候，必须保证同时成功或失败
- **I**：隔离性（`lsolation`）：一个事务不会影响其他事务的运行，事务**A**与事务**B**之间具有隔离
- **D**：持久性（`Durability`）：在事务完成之后，该事务对数据库所作的更改将持续地保存在数据库中，并不会被回滚，事务才算成功的结束

### 事务的隔离性

- 事务特性`ACID`之一：隔离性（`isolation`）

  #### 隔离级别

  - 第一级别：读未提交（`read uncommitted`）
    - 对方事务还没有提交，我们当前事务可以读取到对方未提交的数据
    - 读未提交存在脏读（`Dirty Read`）现象：表示读到了脏的数据。
  - 第二级别：读已提交（`read committed`）
    - 对方事务提交之后的数据我方可以读取到
    - 读已提交存在的问题是：不可重复读
    - 这种隔离级别，解决了脏读现象，但是出现了不可重复读
  - 第三级别：可重复读（`repeatable read`）
    - 对方提交之后的数据都读取不到
    - 这种隔离级别，解决了不可重复读问题
    - 这种隔离级别可以避免“脏读和丌可重复读”，达到“重复读取”
    - 这种隔离级别存在的问题是：读取到的数据是幻象
  - 第四级别：串行化
    - 事务`A`和事务`B`，事务 A 在操作数据库表中数据的时候，事务`B`叧能排队等待
    - 解决了所有问题
    - 存在的问题：效率低，需要事务排队

- `Oracle`数据库默认的级别是第二级别（读已提交）

- `MySQL`数据库默认的级别是第三级别（可重复读）

#### 查看隔离级别

- 查看当前会话的隔离级别
  - `select @@tx_isolation;`
  - `select @@session.tx_isolation;`
- 查看当前全局隔离级别
  - `select @@global.tx_isolation;`

#### 设置服务器缺省隔离级别

- 第一种：修改该`my.ini`配置文件

  - 在`my.ini`文件中的`[mysqlid]`下面添加


```mysql
-------------------------my.ini------------------------------
[mysqld]
transaction-isolation = isolation-level
--------------------------my.ini-------------------------------
```

- `isolation-level`可选项为：

  - `read-uncommitted`
  - `read-committed`
  - `repeatable-read`
  - `serializable`

- 第二种：通过命令方式设置事务隔离级别

  - `set transaction isolaction level isolation-level;`
  - `isolation-level`可选值
    - `read uncommitted`
    - `read committed`
    - `repeatable read`
    - `serializable`

- 设置隔离级别作用的范围

  - 事务隔离级别的作用范围分为两种：会话级、全局级
    - 会话级（`session`）：叧对当前会话有效
    - 全局级（`global`）：对所有会话有效
  - 使用方法如下
    - 会话级：
      - `set transaction isolation level <isolation-level>;`
      - `set session transaction isolation level <isolation-level>;`
    - 全局级:
      - `set global transaction isolation level <isolation-level>;`

- 隔离级别不一致性问题的关系

  | 隔离级别 | 脏读   | 不可重复读 | 幻象读 |
  | -------- | ------ | ---------- | ------ |
  | 读未提交 | 可能   | 可能       | 可能   |
  | 读已提交 | 不可能 | 可能       | 可能   |
  | 可重复读 | 不可能 | 不可能     | 可能   |
  | 串行化   | 不可能 | 不可能     | 不可能 |

### 演示事务

- `mysql`事务默认情况下是自动提交的
  - 什么是自动提交？只要执行任意一条`DML`语句则提交一次
- 怎么关闭自动提交

  - `start transaction`

- 演示：自动提交


```mysql
drop table if exists t_user;
create table t_user(
	id int primary key auto_increment,
    username varchar(255)
);

insert into t_user(username) values('zs');
mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | zs       |
+----+----------+
1 row in set (0.00 sec)

mysql> rollback; -- 回滚
Query OK, 0 rows affected (0.00 sec)

mysql> select * from t_usre;
+----+----------+
| id | username |
+----+----------+
|  1 | zs       |
+----+----------+
1 row in set (0.00 sec)

-- 回滚没有管用，说明commit（提交）是自动的
```

- 演示：关闭自动提交


```mysql
select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | zs       |
+----+----------+
1 row in set (0.00 sec)

mysql> start transaction; -- 开启事务
Query OK, 0 rows affected (0.00 sec)

mysql> insert into t_user(username) values('ls');
Query OK, 1 row affected (0.04 sec)

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | zs       |
|  2 | ls       |
+----+----------+
2 rows in set (0.00 sec)

mysql> rollback; -- 回滚，清空历史记录，结束事务
Query OK, 0 rows affected (0.04 sec)

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | zs       |
+----+----------+
1 row in set (0.00 sec)

-- 回滚成功，说明自动提交关闭了
```

- 演示：提交事务


```mysql
mysql> start transaction; -- 开始事务
Query OK, 0 rows affected (0.00 sec)

mysql> insert into t_user(username) values('wangwu');
Query OK, 1 row affected (0.05 sec)

mysql> insert into t_user(username) values('rose');
Query OK, 1 row affected (0.00 sec)

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | zs       |
|  3 | wangwu   |
|  4 | rose     |
+----+----------+
3 rows in set (0.00 sec)

mysql> commit; -- 提交，结束事务
Query OK, 0 rows affected (0.04 sec)

mysql> select * from t_user;
+----+----------+
| id | username |
+----+----------+
|  1 | zs       |
|  3 | wangwu   |
|  4 | rose     |
+----+----------+
3 rows in set (0.00 sec)

-- 提交成功，没有错误
```

- 演示四个级别

## 索引

- 什么是索引，有什么用？

  - 相当于一本书的目录，通过目录可以快速的找到对应的资源。
  - 在数据方面，查询一张表的时候有两种检索方式
    - 第一种方式：全表扫描
    - 第二种方式：根据索引检索？（效率很高）
  - 索引为什么可以提高检索效率？
    - 其实最根本的原理是缩小了扫描的范围
    - 索引虽然可以提高检索效率，但是不可以随意添加索引，因为索引也是数据库当中的对象，也需要数据库不断的维护。是有维护成本的。比如，表中的数据经常被修改，这样就不适合添加索引，因为数据一旦被修改，索引需要重新排序，进行维护。
  - 添加索引是给某一个字段，或者说某些字段添加索引
    - `select ename,sal from emp where ename='SMITH';`
    - 当`ename`字段上没有添加索引的时候，以上`sql`语句会进行全表扫描，扫描`ename`字段中所有的值。
    - 当`ename`字段中添加索引的时候，以上`sql`语句会根据索引扫描，快速定位

- 怎么创建索引对象？怎么删除索引对象？

  - 创建索引对象：`create index 索引名称 on 表名(字段);`
  - 删除索引对象：`drop index 索引名称 on 表名;`

- 什么时候考虑给字段添加索引？（满足什么条件）

  - 数据量庞大（根据客户的需求，根据线上的环境）
  - 该字段很少的`DML`字段（因为字段进行修改操作，索引也需要维护）
  - 该字段经常出现在`where`子句中（经常根据那个字段查询）
  - **注意**：主键和具有`unique`约束的字段自动会添加索引
    - 根据主键查询效率较高，尽量根据主键检索

- 查看`sql`语句的执行计划

  - `explain select语句`

- 索引底层采用的数据结构是`B + True`

- 索引的实现原理

  - 通过`B True`缩小扫描范围，底层索引进行了排序，分区，索引会携带数据在表中的“物理地址”，最终通过索引检索到数据之后，获取到关联的物理地址，通过物理地址定位表中的数据，效率是最高的


```mysql
select ename from emp where ename = 'smith';
通过索引转换为
select ename from emp where 物理地址 = 'xxx';
```

- 索引的分类？
  - 单一索引：给单个字段添加索引
  - 复合索引：给多个字段联合起来添加 1 个索引
  - 主键索引：主键上会自动添加索引
  - 唯一索引：有`unique`约束的字段上会自动添加索引
  - .....
- 索引什么时候会失效？
  - 模糊查询的时候，第一个字符使用的是`%`，这个时候索引是失效的

## 视图（view）

- 什么是视图？

  - 站在不同的角度去看到数据（同一张表的数据，通过不同的角度去看待）

- 创建、删除视图

  - 创建视图
    - `create view 视图名称 as select 字段,字段... from 表名;`
  - 删除视图
    - `drop view 视图名称;`
  - 注意：只有`DQL`语句才能以视图的方式创建出来，可以对视图进行`CRUD`操作

- 对视图进行增删改查，会影响到原表数据。（通过视图影响原表数据，不是直接操作的原表）

- 视图的操作


```mysql
create table emp_bak as select * from emp;
ccreate view myview as select ename,empno,sal from emp_bak; // 建立视图
update myview set ename='hehe',sal=1 where empno='7369'; // 通过视图修改原表数据
delete from myview where empno = 7369; // 通过视图删除原表数据
```

- 视图的作用？

  - 视图可以隐藏表的实现细节，保密级别较高的系统，数据库只对提供相关的视图，只对视图进行`CRUD`

## DBA 命令

### 新建用户

- `create user 用户名 identified by '密码';`

- 实例：


```mysql
create user username identified by '123';
可以登录但是只可以看见一个库information_schema
```

### 授权

#### 命令详解

```mysql
示例：grant all privileges on dbname.tbname to 'username'@'login ip' identified by 'password' with grant option;

1) dbname=* 表示所有数据库
2) tbname=* 表示所有表
3) login ip=% 表示任何ip
4) password 为空，表示不需要密码即可登录
5) with grant option; 表示该用户还可以授权给其他用户
```

- 细粒度授权
  - 首先以 root 用户进入`mysql`
  - 然后键入命令：`grant select,insert,update,delete on *.* to p361 @localhost Identified by "123";`
  - 如果希望该用户能够在任何机器上登陆`mysql`，则将`localhost`改为 `"%"`
- 粗粒度授权
  - 我们测试用户一般使用该命令授权：
    - `GRANT ALL PRIVILEGES ON *.* TO 'p361'@'%' Identified by "123";`
  - 注意：用以上命令授权的用户丌能给其它用户授权,如果想让该用户可以授权,用以下命令:
    - `GRANT ALL privileges ON *.* TO 'p361'@'%' Identified by "123" WITH GRANT OPTION;`
- 用户权限`privileges`包括：
  - `alter`：修改数据库的表
  - `create`：创建新的数据库戒表
  - `delete`：删除表数据
  - `drop`：删除数据库/表
  - `index`：创建/删除索引
  - `insert`：添加表数据
  - `select`：查询表数据
  - `update`：更新表数据
  - `all`：允许任何操作
  - `usage`：叧允许登录

### 回收授权

- 命令详解


```mysql
回收授权
revoke privileges on dbname[.tbname] from username;
revoke all privileges on *.* from p361;

use mysql
select * from user
迚入 mysql库中
修改密码;
update user set password = password('qwe') where user = 'p646';
刷新权限;
flush privileges
```

### 导入导出

- 将数据库当中所有的数据导出

  - `mysqldump 数据库名称>要导出的sql文件的路径 -uroot -p密码`
  - `mysqldump bjpowernode>D:\bjpowernode.sql -uroot -p333`

- 导出数据库中某个表的数据

  - `mysqldump 数据库名称 表名>要导出的sql文件的路径 -uroot -p密码`
  - `mysqldump bjpowernode emp>D:\bjpowernode.sql -uroot -p333`

- 导入数据


```mysql
create databases 数据库名称;
use 数据库名称;
source sql文件所在的路径地址
```

## 数据库设计三范式

- 什么是设计范式？

  - 设计表的依据，按照三范式设计的表不会出现数据冗余

- 三范式都是那些？

  - 第一范式：任何一张表都应该有主键，并且每一个字段原子性不可再分

  - 第二范式：建立在第一范式的基础之上，所有非主键字段完全依赖主键，不能产生部份依赖


```mysql
多对多？ 三张表 关系表，两个外键

t_student 学生表
sno(pk)		sname
---------------------
1			张三
2			李四
3			王五

t_teacher 讲师表
tno(pk)		tname
---------------------
1			王老师
2			张老师
3			李老师

t_student_teacher_relation 学生关系讲师表
id(pk)		sno(fk)		tno(fk)
---------------------------------
1			1			3
2			1			1
3			2			2
4			2			3
5			3			1
6			3			3
```

- 第三范式：建立在第二范式之上，所有非主键字段直接依赖主键，不能产生传递依赖


```mysql
一对多？ 两张表 多的表加外键

班级t_class
cno(pk)		cname
------------------
1			班级1
2			班级2

学生t_student
sno(pk)		sname		classno(fk)
------------------------------------
101			张1			1
102			张2			1
103			张3			2
104			张4			2
105			张5			2
```

- 提醒：在实际的开发中，以满足客户的需求为主，有的时候会拿冗余换执行速度

- 一对一怎么设计？


```mysql
第一种方案：主键共享
t_user_login  用户登录表
id(pk)		username	  password
------------------------------------
1			zs			  123
2			ls			  456

t_user_detail  用户详细信息表
id(pk+fk)	realname	tel		...
------------------------------------
2			李四		 12345
1			张三		 87998
```

```mysql
第二种方案：外键唯一
t_user_login  用户登录表
id(pk)		username	  password
------------------------------------
1			zs			  123
2			ls			  456

t_user_detail  用户详细信息表
id(pk)	realname	  tel		userid(fk+unique)	...
--------------------------------------------------------
2			李四		 12345	   2
1			张三		 87998	   1
```
