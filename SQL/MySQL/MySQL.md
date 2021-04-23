### SQl

#### 数据库概述及数据准备

##### 数据库介绍

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

##### 常见的数据库管理系统

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

##### sql、DB、DBMS分别是什么

- **DB**：`DataBase`（数据库，数据库实际上在硬盘上以文件的形式存在）

- **DBMS**：`DataBase Management System`（数据库管理系统，常见的有，`MySQL` `Oracle` `DB2` `Sybase` `SqlServer`

- **SQL**：结构化查询语言，是一门标准通用的语言，标准的`sql`适用于所有的数据库产品，`sql`属于高级语言，sql语句再执行的时候，实际上内部也会先进行编译，然后再执行`sql`，`sql`语句的编译由DBMS完成

  > DBMS负责执行sql语句，通过执行sql语句来操作DB当中的数据
  >
  > DBMS - （执行）-> SQL - （操作） -> DB

##### SQL概述

- `SQL`，一般发音为`sequel`，`SQL`的全称`Structured Query Language`，`SQL`用来和数据库打交道，完成和数据库的通信，`SQL`是一套标准。但是每一个数据都有自己的特性别的数据库没有，当使用这个数据库特性相关的功能，这时`SQL`语句可能就不是标准了，（90%以上的`SQL`都是通用的）

##### 什么是数据库

- 数据库，通常是一个或工组文件，保存了一些符合特定规格的数据数据库对应的英语单词是`DataBase`, 简称:DB,数据库软件称为数据库管理系统(DBMS)， 全称为`DataBase Management System`,如: `Oracle`、`SQL Server`、`MySq|`、`Sybase`、`informix`、 `DB2`、`interbase`、`PostgreSql`。

##### MySQl概述

- `MySQL`最初是由`MySQL AB`公司开发的-套关系型数据库管理系统( `RDBMS Relational`
  `Database Mangerment System`)。。
- `MySQL`不仅是最流行的开源数据库，而且是业界成长最快的数据库，每天有超过7万次的
  下载量，其应用范围从大型企业到专有的嵌入应用系统。
- `MySQL` AB是由两个瑞典人和一个芬兰人: `David Axmark`、`Allan Larsson` 和`Michael "Monty`"`Widenius`在瑞典创办的。。
  在2008年初，`Sun Microsystems`收购了`MySQL AB`公司。在2009年，`Oracle` 收购了`Sun`公司，使`MySQL`并入`Oracle`的数据库产品线。

##### 表

- 什么是表？

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

##### SQL语句的分类

- `SQL`语句包括增删改查，那么究竟怎么分类？
- **DQL（数据查询语言）**：查询语句，凡是`select`语句都是`DQL`
- **DML（数据操作语言）**：`insert`、`delete`、`update`，对表当中的数据进行增删改
- **DDL（数据定义语言）**：`create`、`drop`、`alter`，对表结构的增删改
- **TCL（事务控制语言）**：`commit`提交事务，`rollback`回滚事务（`TCL`中的`T`是`Transaction`）
- **DCL（数据控制语言）**：`qrant`授权、`revoke`撤销权限等

##### 导入演示数据

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

##### 查看表结构

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

#### 常用命令

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

#### 查看演示数据的表结构

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

#### 简单的查询（DQL）

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

#### 条件查询

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

#### 排序

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

#### （分组/聚合/多行、单行处理）函数

##### **分组函数/多行函数**

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

##### 单行处理函数

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

#### 分组查询

- `group by` ：按照某个字段或者某个字段进行分组
  - `select 字段 from 表名 group by 字段`
  - `group by 字段名称`
- `having`：是对分组之后的数据进行再次过滤
  - `heaving`是在`group by`之后完成过滤
  - `where`实在`group by`之前完成过滤
  - 能够在`where`在过滤的数据不要放到`having`中进行过滤，否则影响`SQL`语句的执行效率

> 分组函数一般都会和group by联合使用，这也是它被称为分组函数的原因，并且任何一个分组函数都是在group by语句执行结束之后才会执行
>
> 当一条sql语句中没有group by的话，整张表的数据会自成一组