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

### sql、DB、DBMS分别是什么

- **DB**：`DataBase`（数据库，数据库实际上在硬盘上以文件的形式存在）

- **DBMS**：`DataBase Management System`（数据库管理系统，常见的有，`MySQL` `Oracle` `DB2` `Sybase` `SqlServer`

- **SQL**：结构化查询语言，是一门标准通用的语言，标准的`sql`适用于所有的数据库产品，`sql`属于高级语言，sql语句再执行的时候，实际上内部也会先进行编译，然后再执行`sql`，`sql`语句的编译由DBMS完成

  > DBMS负责执行sql语句，通过执行sql语句来操作DB当中的数据
  >
  > DBMS - （执行）-> SQL - （操作） -> DB

### SQL概述

- `SQL`，一般发音为`sequel`，`SQL`的全称`Structured Query Language`，`SQL`用来和数据库打交道，完成和数据库的通信，`SQL`是一套标准。但是每一个数据都有自己的特性别的数据库没有，当使用这个数据库特性相关的功能，这时`SQL`语句可能就不是标准了，（90%以上的`SQL`都是通用的）

### 什么是数据库

- 数据库，通常是一个或工组文件，保存了一些符合特定规格的数据数据库对应的英语单词是`DataBase`, 简称:DB,数据库软件称为数据库管理系统(DBMS)， 全称为`DataBase Management System`,如: `Oracle`、`SQL Server`、`MySq|`、`Sybase`、`informix`、 `DB2`、`interbase`、`PostgreSql`。

### MySQl概述

- `MySQL`最初是由`MySQL AB`公司开发的-套关系型数据库管理系统( `RDBMS Relational`
  `Database Mangerment System`)。。
- `MySQL`不仅是最流行的开源数据库，而且是业界成长最快的数据库，每天有超过7万次的
  下载量，其应用范围从大型企业到专有的嵌入应用系统。
- `MySQL` AB是由两个瑞典人和一个芬兰人: `David Axmark`、`Allan Larsson` 和`Michael "Monty`"`Widenius`在瑞典创办的。。
  在2008年初，`Sun Microsystems`收购了`MySQL AB`公司。在2009年，`Oracle` 收购了`Sun`公司，使`MySQL`并入`Oracle`的数据库产品线。

### 表

>  表（table）：是数据库最基本的组成单元，数据库是用来存储数据的，数据库中有很多表，每一个表都是一个独立的单元，表也是一个结构化的文件，由行和列组成，行称为数据戒记录，列称为字段， 字段又包含：字段名称、字段类型、长度、约束。

- 表：`table`

  - `table`是数据库的基本组成单元，所有的数据都以表格的形式组织，目的是可读性强

  - 一个表包括行和列：

    - ```mysql
      学号（int) 	姓名(varchar)		年龄(int)
      -----------------------------------------
      110			  张三			   20
      120			  李四			   21
      ```

    - 行：被称为数据 / 记录
    - 列：被称为字段（`column`）
      - 每一个字段都应该包括哪些属性？
        - 字段名、数据类型、相关的类型

### SQL语句的分类

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

  - ```mysql
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

    - ```mysql
      +----------------------------+
      | Tables_in_bjpowernode      |
      +----------------------------+
      | dept						 |
      | emp               		 |
      | salqrade			 		 |
      +----------------------------+
      ```

  - **sql脚本**

    - `bjpowernode.sql`，这个文件以`sql`结尾，这样的文件被称为"`sql`脚本"。什么是`sql`脚本？
    - 当一个文件的扩展名是`.sql`，并且该文件中编写了大量的`sql`语句，我们成这样的文件为`sql`脚本
    - 直接使用source命令可以执行`sql`脚本
    - `sql`脚本中的数据量太大的时候，无法打开，请使用`source`命令完成初始化
    - `sql`脚本有很多，每一个都不一样，我这个仅仅是练习使用

- 六、删除数据库：**drop database 数据库名称;**

### 查看表结构

- ```
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
  - **select * from 数据库中表的名称;**
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

- **select 字段名1，字段名2，字段名3，......from 表名;**
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

| 运算符         | 作用                                                         |
| -------------- | ------------------------------------------------------------ |
| `=`            | 等于                                                         |
| `<>`或`!=`     | 不等于                                                       |
| `<`            | 小于                                                         |
| `<=`           | 小于等于                                                     |
| `>`            | 大于                                                         |
| `>=`           | 大于等于                                                     |
| `between…and…` | 两个值之间，等同于 `x >= 1 and x <= 3`                       |
| `is null`      | 为`null`（`is not null` 不为空）                             |
| `and`          | 并且                                                         |
| `or`           | 或者                                                         |
| `in`           | 包含，相当于多个`or`（就是在这个几个值当中寻找），`in(条件1，条件……)`，`in`里面的条件就是精确的值，不是范围 |
| `not in`       | 不包含，不在这几个值当中                                     |
| `not`          | `not`可以取非，主要用作`js`或`in`中                          |
| `like`         | `like`称为模糊查询，要掌握两个符号，`%`和`_`，`%`代表任意多个字符，`_`代表任意一个字符 |

> 在数据库中NULL不是一个值，代表什么也没有，为空，空不是一个值，不能用等号衡量，必须使用 is null 或者 is not null
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

  - ```mysql
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
  - `count(字段)`表示统计的这个字段中不为NULL的数据总数量
  - `count(字段)`

- `sun()` 求和

  - `sum(字段)`

- `avg()` 平均值

  - `avg(字段)`

- `max()` 最大值

  -  `max(字段)`

- `min()` 最小值

  - `min(字段)`

- ```mysql
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
> 分组函数自动忽略NULL。
>
> 数据库中数学表达式中有NULL，进行数学运算，最后都是NULL，没有值
>
> 分组函数不可直接使用在where子句当中，因为group by是在where之后才会执行

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

> 分组函数一般都会和group by联合使用，这也是它被称为分组函数的原因，并且任何一个分组函数都是在group by语句执行结束之后才会执行
>
> 当一条sql语句中没有group by的话，整张表的数据会自成一组
>
> 当一条sql语句有group by时，select后面只可以有参加分组的字段和分组函数字段

### 完整的DQL语句

- ```mysql
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
  - `select  表别名.字段，表别名.字段 from 表名 表别名(生成的)，表名 表别名(生成的)`
  - 例如：`select e.ename,d.dname from emp e,dept d;`
  - 可读性好
  - 执行效率高

#### 内连接

##### 等值连接

>  内连接之等值连接：最大的特点是：连接条件是等量关系

- 示例：查询员工的名称和员工所对应的部门名称

- ```mysql 
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

- ```mysql
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

- ```mysql
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
    - 假设`A`和B表进行连接，使用内连接的话，凡是`A`表和`B`表能够匹配上的记录查询出来，这就是内连接，`AB`两张表没有主副之分
  - 外连接
    - 假设`A`和`B`表进行连接，使用外连接的话，`AB`两张表中有一张是主表，一张表是副表，主要查询主表中的数据，捎带着查询副表，当副表中的数据没有和主表中的数据匹配上，副表自动模拟出`NULL`与之匹配
    - 朱标的数据无条件的全部查询出来
  
- 左外连接：表示左边的这张表是主表

- 右外连接：表示右边的这张表是主表

- 左连接有右连接的写法，右连接也会有对应的左连接的写法

- 语法

  - ```mysql
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

  - ```mysql
    左外连接
    select
    	a.ename as '员工',b.ename as '领导'
    from
    	emp a
    left join
    	emp b
    on 
    	a.mgr = b.empno;
    	
    
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

 - 找到那个部门没有员工
  
  - ```mysql
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

  - ```mysql
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

    - ```mysql
      select
      	..(select).
      from
      	..(select).
      where
      	..(select).
      ```

#### where后面子查询

- 案例：在`emp`表中找出高于平均工资的员工信息

- ```mysql
  select * from emp where sal > avg(sal); // 错误，where后面不能有分组函数
  
  第一步:找出平均薪资，结果就是平均薪资
  select avg(sal) from emp;
  第二步：where过滤
  where sal > 第一步的结果
  合并：
  select * from emp where sal > (select avg(sal) from emp);
  ```

#### from后面子查询

- 案例：找出每个部门平均薪水的薪资等级

- ```mysql
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

- ```mysql
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

#### select后面嵌套子查询

- 找出每个员工所在的部门名称，要求显示员工名和部门名

- ```mysql
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

- 案例：找出工作岗位是SALESMAN和MANAGER的员工？
  - ```mysql
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

  - ```mysq
    limit startIndex,length
    	startIndex 表示起始位置，默认从0开始，不写就是从0开始
    	length 表示取几个
    ```

- 案例：取出工资前五名的员工

  - ```mysql
    select e.ename,e.sal from emp e order by sal desc limit 0,5;
    ```

- 案例：找出工资排名在第4到第9的员工

  - ```mysql
    select e.ename,e.sal from emp e order by sal desc limit 3,6;
    3表示，起始位置，6代表取6个
    ```

- `limit`是`SQL`语句最后执行的一个环节

  - ```mysql
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

    - ```mysql
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
| `int`     | 4个字节                | 整型                                                         |
| `bigint`  | 8个字节                | 长整型                                                       |
| `float`   | `float(有效位数)`      | 数值型                                                       |
| `double`  | `double(有效数字位数)` | 数值型                                                       |
| `date`    | 8字节                  | 日期和时间                                                   |
| `BLOB`    |                        | `Binary Large Object`（二进制大对象）                        |
| `CLOB`    |                        | `Character Large Object`（字符大对象）                       |
| 其他...   |                        |                                                              |

- **varchar** ：可变长度字符串
  - `varchar(3)`表示存储的数据长度不能超过3个字符长度

- **char**：定长字符串
  - `char(3)`表示存储的数据长度ch不能超过3个的字符长度
- **int**：整数型
  - `int(3)`表示最大可以存储999
- **bigint**：长整型
  - 对应`long`类型
- **float**：浮点型单精度
  - `float(7,2)`表示7个有效数字，2个有效小数位
- **double**：浮点双精度
  - `double(7,2)`表示7个有效数字，2个有效小数位

- **date**：日期类型
  - 实际开发中，常用字符串代替日期类型
- **BLOB**：二进制大对象（`Binary Large Object`）
  - 专门存储图片、视频、声音等数据
  - 数据库存储图片很常见，但存储大视频很少见，一般都是存储视频地址

- **CLOB**：字符串大对象（`Character Large Object`）
  - 存储超大文本，可存储`4G+`的字符串

- **varchar与char对比**
  - 都是字符串
  - `varchar`比较智能，可以根据实际数据长度分配空间，比较节省空间；但在分配的时候需要相关判断，效率低
  - `char`不需要动态分配空间，所以执行效率高，但是可能会导致空间浪费
  - 若字段中的数据不具备伸缩性，建议采用`char`类型存储
  - 若字段中的数据具有很强的伸缩性，建议采用`varchar`类型存储

## DDL（数据定义语言）

### 创建表

- 语法：

  - ```mysql
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

  - ```mysql
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

- ```mysql
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

    - ```mysq
      insert into 表名
      	(字段名1,字段名2,字段名3,....)
      values
      	(值1,值2,值3,......);
      
      insert into values(值1,值2,值3,......); 	//这样就只能对应列的数量写
      ```

  - **插入多行数据**

    - ```mysql
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

  - ```mysql
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
  - ```mysql
    create table 表名 as select语句;   // 将查询结果当作表创建出
    ```

- 批量插入

  - ```mysql
    insert into 表名 select语句
    ```

  - 注意：这里有表结构的影响，不同的表结构不可以随便插入

### update修改表的数据

- ```mysql
  update 表名 set 字段名1=值1，字段名2=值2... where 条件;
  ```

- 注意：没有条件整张表将全部更新

### delete删除数据

- ```mysql
  detele from 表名 where 条件;
  ```

- 注意：没有条件全部删除

- 怎么删除大表（数据量特别大的表）

  - ```mysql
    truncate table 表名
    ```

  - 表被截断，不可回滚，永久丢失

  - 删之前，慎重！