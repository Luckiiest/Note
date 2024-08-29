# RabbitMQ

## 消息队列相关概念

### 什么是消息队列

MQ(message queue)，从字面意思上看，本质是个队列，FIFO 先入先出，只不过队列中存放的内容是 message 而已，还是一种跨进程的通信机制，用于上下游传递消息。在互联网架构中，MQ 是一种非常常 见的上下游「逻辑解耦 + 物理解耦」的消息通信服务。使用了 MQ 之后，消息发送上游只需要依赖 MQ，不用依赖其他服务。

消息队列是实现**应用程序**和**应用程序**之间**通信**的中间件产品

![image-20240525161717700](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251617836.png)

**消息队列底层实现的两大主流方式**

- 由于消息队列执行的是跨应用的信息传递，所以制定**底层通信标准**非常必要

- 目前主流的消息队列通信协议标准包括：

  - AMQP(**A**dvanced**M**essage**Q**ueuing**P**rotocol)：**通用**协议，IBM公司研发

  - JMS(**J**ava**M**essage**S**ervice)：**专门**为**Java**语言服务，SUN公司研发，一组由Java接口组成

    的Java标准

- AMQP与JMS对比

| 功能           | AMQP                                                         | JMS                                                          |
| -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 七层网络模型   | 传输层与会话层                                               | 应用层                                                       |
| 消息模型       | 支持多种消息模型，包括点对点（P2P）和发布/订阅（Pub/Sub）    | 支持点对点和发布/订阅两种消息模型                            |
| 编程语言和平台 | 多种编程语言和平台，包括Java、C++、Python                    | 主要针对Java平台，因此在其他编程语言和平台上支持较少         |
| 可靠性         | 提供了强大的消息可靠性保证，包括消息持久化、事务性消息和消息确认机制 | 支持消息持久化和事务性消息，但具体实现取决于消息传递系统的提供者 |
| 传输协议       | 使用二进制协议进行消息传递，提供了高效、可靠的消息投递机制   | 使用一种面向文本的协议（如HTTP、TCP），消息的传输效率较低    |
| 拓展性和兼容性 | 具有很好的拓展性和兼容性，可以在不同的消息代理之间交互操作   | 在Java环境中有较好的拓展性和兼容性，但在与非Java环境集成时受到限制 |

### 为什么要用MQ

1. 流量消峰

   举个例子，如果订单系统最多能处理一万次订单，这个处理能力应付正常时段的下单时绰绰有余，正常时段我们下单一秒后就能返回结果。但是在高峰期，如果有两万次下单操作系统是处理不了的，只能限制订单超过一万后不允许用户下单。使用消息队列做缓冲，我们可以取消这个限制，把一秒内下的订单分 散成一段时间来处理，这时有些用户可能在下单十几秒后才能收到下单成功的操作，但是比不能下单的体验要好。

2. 应用解耦

   以电商应用为例，应用中有订单系统、库存系统、物流系统、支付系统。用户创建订单后，如果耦合调用库存系统、物流系统、支付系统，任何一个子系统出了故障，都会造成下单操作异常。当转变成基于消息队列的方式后，系统间调用的问题会减少很多，比如物流系统因为发生故障，需要几分钟来修复。在这几分钟的时间里，物流系统要处理的内存被缓存在消息队列中，用户的下单操作可以正常完成。当物流系统恢复后，继续处理订单信息即可，中单用户感受不到物流系统的故障，提升系统的可用性。

![image](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251030888.webp)

### MQ的分类

- **ActiveMQ**

  优点：单机吞吐量万级，时效性 ms 级，可用性高，基于主从架构实现高可用性，消息可靠性较 低的概率丢失数据

  缺点：官方社区现在对 ActiveMQ 5.x 维护越来越少，高吞吐量场景较少使用

- **Kafka**

  大数据的杀手锏，谈到大数据领域内的消息传输，则绕不开 Kafka，这款为大数据而生的消息中间件，以其百万级 TPS 的吞吐量名声大噪，迅速成为大数据领域的宠儿，在数据采集、传输、存储的过程中发挥着举足轻重的作用。目前已经被 LinkedIn，Uber，Twitter，Netflix 等大公司所采纳。

  优点: 性能卓越，单机写入 TPS 约在百万条/秒，最大的优点，就是吞吐量高。时效性 ms 级可用性非常高，kafka 是分布式的，一个数据多个副本，少数机器宕机，不会丢失数据，不会导致不可用,消费者采用 Pull 方式获取消息，消息有序，通过控制能够保证所有消息被消费且仅被消费一次；有优秀的第三方Kafka Web 管理界面 Kafka-Manager；在日志领域比较成熟，被多家公司和多个开源项目使用；功能支持：功能 较为简单，主要支持简单的 MQ 功能，在大数据领域的实时计算以及日志采集被大规模使用

  缺点：Kafka 单机超过 64 个队列/分区，Load 会发生明显的飙高现象，队列越多，load 越高，发送消息响应时间变长，使用短轮询方式，实时性取决于轮询间隔时间，消费失败不支持重试；支持消息顺序，但是一台代理宕机后，就会产生消息乱序，社区更新较慢

- **RocketMQ**

  RocketMQ 出自阿里巴巴的开源产品，用 Java 语言实现，在设计时参考了 Kafka，并做出了自己的一些改进。被阿里巴巴广泛应用在订单，交易，充值，流计算，消息推送，日志流式处理，binglog 分发等场景。

  优点：单机吞吐量十万级，可用性非常高，分布式架构,消息可以做到 0 丢失,MQ 功能较为完善，还是分布式的，扩展性好,支持 10 亿级别的消息堆积，不会因为堆积导致性能下降，源码是 java 我们可以自己阅读源码，定制自己公司的 MQ

  缺点：支持的客户端语言不多，目前是 java 及 c++，其中 c++ 不成熟；社区活跃度一般,没有在 MQ 核心中去实现 JMS 等接口,有些系统要迁移需要修改大量代码

- **RabbitMQ**

  2007 年发布，是一个在AMQP(高级消息队列协议)基础上完成的，可复用的企业消息系统，是当前最主流的消息中间件之一。

  优点：由于 erlang 语言的高并发特性，性能较好；吞吐量到万级，MQ 功能比较完备,健壮、稳定、易用、跨平台、支持多种语言 如：Python、Ruby、.NET、Java、JMS、C、PHP、ActionScript、XMPP、STOMP 等，支持 AJAX 文档齐全；开源提供的管理界面非常棒，用起来很好用,社区活跃度高；更新频率相当高

  缺点：商业版需要收费,学习成本较高

- **对比**

|                | RabbitMQ                                                     | ActiveMQ                                             | RocketMQ                                                     | Kafka                                                 |
| -------------- | ------------------------------------------------------------ | ---------------------------------------------------- | ------------------------------------------------------------ | ----------------------------------------------------- |
| 研发团队       | Rabbit（公司）                                               | Apache（社区）                                       | 阿里巴巴（公司）                                             | Apache（社区）                                        |
| 开发语言       | Erlang                                                       | Java                                                 | Java                                                         | Scala&Java                                            |
| 核心机制       | 基于AMQP的消息队列模型，使用生产者-消费者模式，将消息发布到队列中，然后被消费者订阅和处理 | 基于JMS的消息传递模型，支持点对点模型的发布-订阅模型 | 分布式的消息模型，采用主题(Topic)和标型签(Tag)的方式进行消息的分类和过滤 | 分布式流平台，通过发布-订阅模型进行高吞吐量的消息处理 |
| 协议支持       | XMPP，STOMP，SMTP                                            | XMPP、STOMP、OpenWire、REST                          | 自定义协议                                                   | 自定义协议、社区封装了HTTP协议支持                    |
| 客户端支持语音 | 官方支持Erlang、Java、Ruby等社区产出多种API，几乎支持所有语言 | Java、C/C++、 Python、PHP、Perl、.NET等              | Java、C++不成熟                                              | 官方支持Java 社区产出多种API，如PHP、Python等         |
| 可用性         | 镜像队列、仲裁队列                                           | 主从复制                                             | 主从复制                                                     | 分区和副本                                            |
| 单机吞吐量     | 每秒十万左右级别                                             | 每秒数万级                                           | 每秒十万+级(双十一)                                          | 每秒百万级                                            |
| 消息延迟       | 微秒级                                                       | 毫秒级                                               | 毫秒级                                                       | 毫秒以内                                              |
| 消息确认       | 完整的消息确认机制                                           |                                                      | 内置消息表，消息保存到数据库实现持久化                       |                                                       |
| 功能特性       | 并发能力强，性能极好，延时低，社区活跃，管理界面丰富         | 老牌产品、成熟度高、文档丰富                         | MQ功能比较完备、扩展性佳                                     | 只支持主要的MQ功能、毕竟是专门为大数据领域服务的      |

### MQ的选择

- **Kafka**

  Kafka 主要特点是基于 Pull 的模式来处理消息消费，追求高吞吐量，一开始的目的就是用于日志收集和传输，适合产生大量数据的互联网服务的数据收集业务。大型公司建议可以选用，如果有日志采集功能，肯定是首选 kafka 了。

- **RocketMQ**

  天生为金融互联网领域而生，对于可靠性要求很高的场景，尤其是电商里面的订单扣款，以及业务削峰，在大量交易涌入时，后端可能无法及时处理的情况。RoketMQ 在稳定性上可能更值得信赖，这些业务场景在阿里双 11 已经经历了多次考验，如果你的业务有上述并发场景，建议可以选择 RocketMQ。

- **RabbitMQ**

  结合 erlang 语言本身的并发优势，性能好时效性微秒级，社区活跃度也比较高，管理界面用起来十分 方便，如果你的数据量没有那么大，中小型公司优先选择功能比较完备的 RabbitMQ。	

## RabbitMQ介绍

### RabbitMQ概念

RabbitMQ是一款基RabbitMQ是一款基于AMQP、由Erlang语言开发的消息队列产品，2007年Rabbit技术公司发布了它的1.0版本于AMQP、由Erlang语言开发的消息队列产品，2007年Rabbit技术公司发布了它的1.0版本

RabbitMQ 是一个消息中间件：它接受并转发消息。你可以把它当做一个快递站点，当你要发送一个包裹时，你把你的包裹放到快递站，快递员最终会把你的快递送到收件人那里，按照这种逻辑 RabbitMQ 是 一个快递站，一个快递员帮你传递快件。RabbitMQ 与快递站的主要区别在于，它不处理快件而是接收，存储和转发消息数据。

### 四大核心概念

![image-20240525164220254](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251642872.png)

生产者：产生数据发送消息的程序

交换机：是 RabbitMQ 非常重要的一个部件，一方面它接收来自生产者的消息，另一方面它将消息 推送到队列中。交换机必须确切知道如何处理它接收到的消息，是将这些消息推送到特定队列还是推送到多个队列，亦或者是把消息丢弃，这个得有交换机类型决定

队列：是 RabbitMQ 内部使用的一种数据结构，尽管消息流经 RabbitMQ 和应用程序，但它们只能存储在队列中。队列仅受主机的内存和磁盘限制的约束，本质上是一个大的消息缓冲区。许多生产者可以将消息发送到一个队列，许多消费者可以尝试从一个队列接收数据。这就是我们使用队列的方式

消费者：消费与接收具有相似的含义。消费者大多时候是一个等待接收消息的程序。请注意生产者，消费者和消息中间件很多时候并不在同一机器上。同一个应用程序既可以是生产者又是可以是消费者。

### RabbitMQ特性

![image.dso2q1lbc5s](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251036001.webp)

### 名词介绍

![image-20240525164220254](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251642872.png)

`Broker`：接收和分发消息的应用，RabbitMQ Server 就是 Message Broker

`Virtual host`：出于多租户和安全因素设计的，把 AMQP 的基本组件划分到一个虚拟的分组中，类似于网络中的 namespace 概念。当多个不同的用户使用同一个 RabbitMQ server 提供的服务时，可以划分出多个 vhost，每个用户在自己的 vhost 创建 exchange／queue 等

`Connection`：publisher／consumer 和 broker 之间的 TCP 连接

`Channel`：如果每一次访问 RabbitMQ 都建立一个 Connection，在消息量大的时候建立 TCP Connection 的开销将是巨大的，效率也较低。Channel 是在 connection 内部建立的逻辑连接，如果应用程序支持多线程，通常每个 thread 创建单独的 channel 进行通讯，AMQP method 包含了 channel id 帮助客 户端和 message broker 识别 channel，所以 channel 之间是完全隔离的。Channel 作为轻量级的 Connection 极大减少了操作系统建立 TCP connection 的开销

`Exchange`：message 到达 broker 的第一站，根据分发规则，匹配查询表中的 routing key，分发 消息到 queue 中去。常用的类型有：direct (point-to-point)，topic (publish-subscribe) and fanout (multicast)

`Queue`：消息最终被送到这里等待 consumer 取走

`Binding`：exchange 和 queue 之间的虚拟连接，binding 中可以包含 routing key，Binding 信息被保 存到 exchange 中的查询表中，用于 message 的分发依据

## RabbitMQ安装

### 下载

- **下载RabbitMQ**

[RabbitMQ最新版下载地址](https://github.com/rabbitmq/rabbitmq-server/releases)

选择以 `noarch.rpm` 结尾的安装包

![image-20240525110058276](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251101836.png)

- **下载Erlang**

RabbitMQ 是采用 Erlang 语言开发的，所以系统环境必须提供 Erlang 环境，需要先安装 Erlang。

`Erlang` 和 `RabbitMQ` 版本对照：[点击跳转](https://www.rabbitmq.com/which-erlang.html)

![image-20240525110326006](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251103523.png)

版本选择

CentOs 7.x 版本需要e17。

CentOs 8.x 版本需要e18。包括 Red Hat 8,modern Fedora 版本。

### 安装

**传输**

将在 Windows 或 Mac 下载好的安装包传输到 Linux 中。

首先在 Linux 的 `/usr/local` 目录下创建一个文件夹 `rabbitmq`。请根据需求自定义路径

```sh
mkdir /usr/local/rabbitmq
```

#### 安装Erlang

进入 `/usr/local/rabbitmq` 目录，解压安装 Erlang

```sh
cd /usr/local/rabbitmq
rpm -ivh erlang-3.12.14-1.el8.noarch.rpm
```

安装完成后输入指令查看到版本号，代表成功

```sh
erl -v
```

#### 安装RabbitMQ

在 `RabiitMQ` 安装过程中需要依赖 `socat` 插件，首先安装该插件

```sh
yum install socat -y
```

解压 `RabbitMQ` 安装包

```sh
rpm -ivh rabbitmq-server-3.8.8-1.el7.noarch.rpm	
```

`i` 代表 install

`vh` 代表显示安装进度过程

**启动**

```sh
# 启动服务
systemctl start rabbitmq-server
# 查看服务状态
systemctl status rabbitmq-server
```

启动 `RabbitMQ` 服务后，查看该服务状态，显示绿色的 `active` 则表示服务安装并启动成功

**其他指令：**

```sh
# 开机自启动
systemctl enable rabbitmq-server
# 停止服务
systemctl stop rabbitmq-server
# 重启服务
systemctl restart rabbitmq-server
```

#### 管理界面及授权操作

> 默认端口
>
> RabbitMQ 的默认访问端口是 15672
>
> 如果 Linux 有防火墙，记得开放 15672 端口，否则 Windows 无法访问

默认情况下，RabbiMQ 没有安装 Web 端的客户端软件，需要安装才可以生效

```sh
rabbitmq-plugins enable rabbitmq_management
```

安装完毕以后，重启服务

```sh
systemctl restart rabbitmq-server
```

通过 `http://ip:15672` 访问，ip 为 Linux 的 ip。`rabbitmq` 有一个默认的账号密码 `guest`，但是登录该账号密码会出现权限问题

默认的账号密码仅限于本机 localhost 进行访问，所以需要添加一个远程登录的用户

```sh
# 创建账号和密码
rabbitmqctl add_user 用户名 密码

# 设置用户角色
rabbitmqctl set_user_tags 用户名 角色

# 为用户添加资源权限，添加配置、写、读权限
# set_permissions [-p <vhostpath>] <user> <conf> <write> <read>
rabbitmqctl set_permissions -p "/" y ".*" ".*" ".*"
# Make sure to add code blocks to your code group
```

角色固定有四种级别：

- `administrator`：可以登录控制台、查看所有信息、并对rabbitmq进行管理
- `monToring`：监控者；登录控制台，查看所有信息
- `policymaker`：策略制定者；登录控制台指定策略
- `managment`：普通管理员；登录控制

添加用户和权限后，再次访问 `http://ip:15672` 登录，输入添加好的用户名和密码，即可进入后台

**其他指令**

```sh
# 修改密码
rabbitmqctl change_ password 用户名 新密码

# 删除用户
rabbitmqctl delete_user 用户名

# 查看用户清单
rabbitmqctl list_user
```

#### Docker安装RabbitMQ

```sh
# 拉取镜像
docker pull rabbitmq:3.13-management

# -d 参数：后台运行 Docker 容器
# --name 参数：设置容器名称
# -p 参数：映射端口号，格式是“宿主机端口号:容器内端口号”。5672供客户端程序访问，15672供后台管理界面访问
# -v 参数：卷映射目录
# -e 参数：设置容器内的环境变量，这里我们设置了登录RabbitMQ管理后台的默认用户和密码
docker run -d \
--name rabbitmq \
-p 5672:5672 \
-p 15672:15672 \
-v rabbitmq-plugin:/plugins \
-e RABBITMQ_DEFAULT_USER=用户名 \
-e RABBITMQ_DEFAULT_PASS=密码 \
rabbitmq:3.13-management
```

## 工作模式

> RabbitMQ有多种工作模式，其中分别是Heelo World、Work Queues、Publish/Subscribe、Routing、Topics、Remote procedure call(RPC)、Publisher Confirms

### 封装工具类

```java
public class ConnectionUtil {
    // 主机名称
    public static final String HOST_ADDRESS = "192.168.116.33";

    public static Connection getConnection() throws IOException, TimeoutException {
        // 定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置服务地址
        factory.setHost(HOST_ADDRESS);
        // 设置端口
        factory.setPort(5672);
        // 设置账号信息、用户信息、密码、vhost
        factory.setUsername("guest");
        factory.setPassword("123456");
        factory.setVirtualHost("/");

        // 通过工厂获取连接
        Connection connection = factory.newConnection();

        return connection;
    }
}
```

### Hello World

> 生产者只有一个，发送一个消息，消费者只有一个，消息只能被这个消费者消费，所以成为简单模式

![image-20240525174336453](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251743024.png)

用 Java 编写两个程序。发送单个消息的生产者和接收消息并打印出来的消费者

在下图中，“ P” 是我们的生产者，“ C” 是我们的消费者。中间的框是一个队列 RabbitMQ 代表使用者保留的消息缓冲区

1. 创建消息发送端（生产者）
2. 创建消息接收端（消费者）

3. 添加依赖

```xml
<dependencies>
    <dependency>
        <groupId>com.rabbitmq</groupId>
        <artifactId>amqp-client</artifactId>
        <version>5.20.0</version>
    </dependency>
</dependencies>
```

#### 发送消息

创建生产者类

```java
public class Producer {  
    public static void main(String[] args) throws Exception {  
        // 创建连接工厂  
        ConnectionFactory connectionFactory = new ConnectionFactory(); 
        // 设置主机地址  
        connectionFactory.setHost("192.168.116.33");  
        // 设置连接端口号：默认为 5672
        connectionFactory.setPort(5672);
        // 虚拟主机名称：默认为 /
        connectionFactory.setVirtualHost("/");
        // 设置连接用户名；默认为guest  
        connectionFactory.setUsername("guest");
        // 设置连接密码；默认为guest  
        connectionFactory.setPassword("123456");
        // 创建连接  
        Connection connection = connectionFactory.newConnection(); 
        // 创建频道  
        Channel channel = connection.createChannel();  
  
        // 声明（创建）队列  
        // queue      参数1：队列名称  
        // durable    参数2：是否定义持久化队列，当 MQ 重启之后还在  
        // exclusive  参数3：是否独占本次连接。若独占，只能有一个消费者监听这个队列且 Connection 关闭时删除这个队列  
        // autoDelete 参数4：是否在不使用的时候自动删除队列，也就是在没有Consumer时自动删除  
        // arguments  参数5：队列其它参数  
        channel.queueDeclare("simple_queue", true, false, false, null);  
  
        // 要发送的信息  
        String message = "你好；小兔子！";  
  
      	// 发布消息到指定队列
        // 参数1：交换机名称,如果没有指定则使用默认Default Exchange  
        // 参数2：路由key,简单模式可以传递队列名称  
        // 参数3：配置信息  
        // 参数4：消息内容  
        channel.basicPublish("", "simple_queue", null, message.getBytes());  
  
        System.out.println("已发送消息：" + message);  
  
        // 关闭资源  
        channel.close();  
        connection.close();  
    }  
}
```

当生产者发送消息的时候，消息队列中就会存储一条消息

![image-20240525175302128](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251753474.png)

#### 接收消息

创建消费者类

```java
public class Consumer {
    public static void main(String[] args) throws Exception {
        // 1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2. 设置参数
        factory.setHost("192.168.116.33");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("123456");
        // 3. 创建连接 Connection
        Connection connection = factory.newConnection();
        // 4. 创建Channel
        Channel channel = connection.createChannel();

        // 5. 创建队列
        // 如果没有一个名字叫simple_queue的队列，则会创建该队列，如果有则不会创建
        // 参数1. queue：队列名称
        // 参数2. durable：是否持久化。如果持久化，则当MQ重启之后还在
        // 参数3. exclusive：是否独占false。共享消费为true，
        // 参数4. autoDelete：是否自动删除。当没有Consumer时，自动删除掉
        // 参数5. arguments：其它参数。
        channel.queueDeclare("simple_queue", true, false, false, null);

        // 接收消息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 回调方法,当收到消息后，会自动执行该方法
            // 参数1. consumerTag：标识
            // 参数2. envelope：获取一些信息，交换机，路由key...
            // 参数3. properties：配置信息
            // 参数4. body：数据
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("consumerTag：" + consumerTag);
                System.out.println("Exchange：" + envelope.getExchange());
                System.out.println("RoutingKey：" + envelope.getRoutingKey());
                System.out.println("properties：" + properties);
                System.out.println("body：" + new String(body));

            }
        };
        // 参数1. queue：队列名称
        // 参数2. autoAck：是否自动确认，类似咱们发短信，发送成功会收到一个确认消息
        // 参数3. callback：回调对象
        // 消费者类似一个监听程序，主要是用来监听消息
        channel.basicConsume("simple_queue", true, consumer);
    }
}
```

当消费者消费消息时候，消息队列中的消息都被删除了

![image-20240525175635922](D:\priv\project\笔记\assets\image-20240525175635922.png)

### Work Queues

> Work Queues 是工作队列（又称任务队列）的主要思想是避免立即执行资源密集型任务，而不得不等待它完成。相反我们安排任务在之后执行。我们把任务封装为消息并将其发送到队列。在后台运行的工作进程将弹出任务并最终执行作业。当有多个工作线程时，这些工作线程将一起处理这些任务。
>
> 多个消费者监听同一个队列，则各个消费者之间对同一个消息是竞争关系。
>
> Work Queues工作模式适用于任务较重或任务较多的情况，多消费者分摊任务可以提高消息处理的效率

![image-20240525181559255](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251816768.png)

#### 生产者

```java
public class Producer {
    // 队列名称
    public static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        // 创建频道
        Channel channel = connection.createChannel();
        // 创建队列
        // 参数列表：队列名称，是否持久化，是否消费共享，是否自动删除，配置信息
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        for (int i = 0; i < 10; i++) {
            String body = "hello rabbitmq ~ work queues : " + i;
            // 发布消息到指定队列
            // 参数列表：交换机名称（没有则为默认交换机），队列名称，参数配置，消息内容
            channel.basicPublish("", QUEUE_NAME, null, body.getBytes());
        }
    }
}
```

![image-20240525190659308](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251907692.png)

#### 消费者

```java
public class Consumer {
    public static String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 创建消息队列
        // 参数列表：队列名称，是否持久化，是否消费共享，是否自动删除，配置信息
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        // 接收消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer 1 body:" + new String(body));
            }
        };

        // 监听消息
        // 参数列表：队列名称，是否自动确认，回调对象
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
```

多个消费者就会轮询消息，他们是竞争者

![image-20240525190951663](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251918172.png)

### Publish/Subscribe

> 生产者不是把消息直接发送到队列，而是发送到交换机
>
> 交换机接收消息，而如何处理消息取决于交换机的类型

**交换机有如下3中常见类型：**

- Fanout：广播，将消息发送给所有绑定到交换机的队列
- Direct：定向，把消息符合指定routing key的队列
- Topic：通配符，把消息交给符合routing pattern（路由模式）的队列

Exchange（交换机）只负责转发消息，不具备存储消息的能力，因此如果没有任何队列与Exchange绑定，或者没有符合路由规则的队列，那么消息就会丢失

![image-20240525191807404](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405251918706.png)

组件之间关系

- 生产者把消息发送到交换机
- 队列直接和交换机绑定

工作机制

- 把消息发送到交换机上，就会以广播的形式发送给所以已绑定队列

理解概念

- Publish：发布，把消息发送到交换机上
- Subscribe：订阅，把队列和交换机进行绑定，就形成了一种订阅关系

#### 生产者

```java
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = ConnectionUtil.getConnection();

        // 获取频道
        Channel channel = connection.createChannel();

        // 交换机名称
        String exchangeName = "test_fanout";

        // 创建交换机
        // 参数1：exchangeName：交换机名称
        // 参数2：type：交换机类型
        //          DIRECT("direct") 定向
        //          FANOUT("fanout") 扇形（广播），发送消息到每一个与之绑定队列
        //          TOPIC("topic") 通配符的方式
        //          HEADERS("headers")：参数匹配
        // 参数3：durable: 是否持久化
        // 参数4：autoDelete：是否自动删除
        // 参数5：internal：内部使用，一般false
        // 参数6：arguments：其他参数
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT, true, false, false, null);

        // 创建队列
        String queue1Name = "test_fanout_queue1";
        String queue2Name = "test_fanout_queue2";
        // 参数1：队列名称
        // 参数2：是否持久化
        // 参数3：是否独占队列（仅限于此连接），则为 true
        // 参数4：是否自动删除队列，则为 true（服务器将在不再使用时将其删除）
        // 参数5：arguments：其他参数列表
        channel.queueDeclare(queue1Name, true, false, false, null);
        channel.queueDeclare(queue2Name, true, false, false, null);

        // 绑定队列和交换机
        // 参数1：queueName：队列名称
        // 参数2：exchangeName：交换机名称
        // 参数3：路由键，绑定规则
        // 如果交换机的类型为fanout，routingKey设置为""
        channel.queueBind(queue1Name, exchangeName, "");
        channel.queueBind(queue2Name, exchangeName, "");

        String body = "日志信息：张三调用了findAll方法...日志级别：info...";

        // 参数列表：交换机名称，路由健，参数配置，消息正文
        channel.basicPublish(exchangeName, "", null, body.getBytes());

        channel.close();
        connection.close();
    }
}
```

![image-20240525211528254](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252115529.png)

#### 消费者

```java
public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 队列名称
        String queueName = "test_fanout_queue1";

        // 创建队列
        // 参数1：queue–队列的名称
        // 参数2：durable –如果我们声明的是持久队列（该队列将在服务器重新启动后继续存在），则为 true
        // 参数3：exclusive –如果我们声明独占队列（仅限于此连接），则为 true
        // 参数4：autoDelete –如果我们声明自动删除队列，则为 true（服务器将在不再使用时将其删除）
        // 参数5：arguments –队列的其他属性（构造参数）
        channel.queueDeclare(queueName, true, false, false, null);

        // 接收消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body:" + new String(body));
                System.out.println("队列1 消费者1 将日志信息打印到控制台....");
            }
        };

        // 监听队列
        channel.basicConsume(queueName, true, consumer);
    }
}
```

![image-20240525211431910](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252115712.png)

### Routing

通过==路由绑定==的方式，把交换机和队列关联起来

交换机和队列通过路由键进行绑定

生产者发送消息时不仅要制定交换机，还要指定路由键

交换机接收到消息会发送到路由键绑定的队列

在编码上与Publish/Subscribe发布与订阅模式的区别：

- 交换机类型为Direct
- 队列绑定交换机的时候需要制定`routing key`.

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252205245.png)

#### 生产者

```java
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 交换器名称
        String exchangeName = "test_direct";

        /*
        参数1：exchange – 交换器的名称
        参数2：type – 交换类型
        参数3：durable – 如果我们声明的是持久交换（交换将在服务器重新启动后继续存在），则为 true（交换将在服务器重新启动后继续存在）
        参数4：autoDelete – 如果服务器在不再使用时应删除 Exchange 则为 true
        参数5：internal – 如果交换是内部的，即不能由客户端直接发布，则为 true。
        参数6：arguments – 交易所的其他属性（构造参数）
         */
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, false, null);

        String queue1Name = "test_direct_queue1";
        String queue2Name = "test_direct_queue2";
        /*
         queue – 队列的名称
         exchange – 交换器的名称
         routingKey – 用于绑定的路由键
         */
        // 队列1绑定error
        channel.queueBind(queue1Name, exchangeName, "error");
        // 队列2绑定error,info,warning
        channel.queueBind(queue2Name, exchangeName, "error");
        channel.queueBind(queue2Name, exchangeName, "info");
        channel.queueBind(queue2Name, exchangeName, "warning");

        String message = "日志信息：张三调用了delete方法.错误了,日志级别warning";

        // 发送消息
        channel.basicPublish(exchangeName, "error", null, message.getBytes());
        System.out.println(message);

        // 释放资源
        channel.close();
        connection.close();
    }
}
```

#### 消费者

```java
public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 队列名称
        String queueName = "test_direct_queue1";

        // 创建队列
        // 参数1：queue–队列的名称
        // 参数2：durable –如果我们声明的是持久队列（该队列将在服务器重新启动后继续存在），则为 true
        // 参数3：exclusive –如果我们声明独占队列（仅限于此连接），则为 true
        // 参数4：autoDelete –如果我们声明自动删除队列，则为 true（服务器将在不再使用时将其删除）
        // 参数5：arguments –队列的其他属性（构造参数）
        channel.queueDeclare(queueName, true, false, false, null);

        // 接收消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body：" + new String(body));
                System.out.println("Consumer1 将日志信息打印到控制台.....");
            }
        };

        // 监听队列
        channel.basicConsume(queueName, true, consumer);
    }
}
```

### Topics

Topic类型与Direct相比，都是可以根据Routing Key把消息路由到不同的队列。只不过Topic类型Exchange可以让队列在绑定Routing key的时候使用通配符

Routing Key一般都是由一个或多个单词组成，多个单词之间以“`.`”分割，例如：`item.insert`

通配符规则

- `#`：匹配零个或多个词
- `*`：匹配一个词

![image-20240525220315201](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252203325.png)

![image-20240525220332429](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252203457.png)

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252206264.png)

#### 生产者

```java
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 交换机名称
        String exchangeName = "test_topic";
        /*
        参数1：exchange – 交易所的名称
        参数2：type – 交换类型
        参数3：durable – 如果我们声明的是持久交换（交换将在服务器重新启动后继续存在），则为 true（交换将在服务器重新启动后继续存在）
        参数4：autoDelete – 如果服务器在不再使用时应删除 Exchange 则为 true
        参数5：internal – 如果交换是内部的，即不能由客户端直接发布，则为 true。
        参数6：arguments – 交易所的其他属性（构造参数）
        * */
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, false, false, null);

        String queue1Name = "test_topic_queue1";
        String queue2Name = "test_topic_queue2";

        // 绑定队列和交换机
        // 参数1. queue：队列名称
        // 参数2. exchange：交换机名称
        // 参数3. routingKey：路由键,绑定规则
        //      如果交换机的类型为fanout ,routingKey设置为""
        //      routing key 常用格式：系统的名称.日志的级别。
        // 需求： 所有error级别的日志存入数据库,所有order系统的日志存入数据库
        channel.queueBind(queue1Name, exchangeName, "#.error");
        channel.queueBind(queue1Name, exchangeName, "order.*");
        channel.queueBind(queue2Name, exchangeName, "*.*");

        // 分别发送消息到队列：order.info、goods.info、goods.error
        String body = "[所在系统：order][日志级别：info][日志内容：订单生成，保存成功]";
        channel.basicPublish(exchangeName, "order.info", null, body.getBytes());

        body = "[所在系统：goods][日志级别：info][日志内容：商品发布成功]";
        channel.basicPublish(exchangeName, "goods.info", null, body.getBytes());

        body = "[所在系统：goods][日志级别：error][日志内容：商品发布失败]";
        channel.basicPublish(exchangeName, "goods.error", null, body.getBytes());

        channel.close();
        connection.close();
    }
}
```

![image-20240525224410340](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252244547.png)

#### 消费者

```java
public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 队列名称
        String QUEUE_NAME = "test_topic_queue1";


        /*
        参数1：queue – 队列的名称
        参数2：durable – 如果我们声明的是持久队列（该队列将在服务器重新启动后继续存在），则为 true
        参数3：exclusive – 如果我们声明独占队列（仅限于此连接），则为 true
        参数4：autoDelete – 如果我们声明自动删除队列，则为 true（服务器将在不再使用时将其删除）
        参数5：arguments – 队列的其他属性（构造参数）
        * */
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        // 接收消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body：" + new String(body));
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
```

两个队列在同一个交换机上且通配符匹配规则相同

![image-20240525224823660](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405252248851.png)

### 其他模式

- **RPC**

远程过程调用，本质上是同步调用，和我们使用OpenFeign调用远程接口一样

所以这不是典型的消息队列工作方式

- **Publisher Confirms**

发送端消息确认

## Rabbit整合SpringBoot

### 消费者

1. 创建消费者module（SpringBoot项目）
2. 配置POM依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

3. 全局配置

```yaml
spring:
  rabbitmq:
    host: 192.168.116.33
    port: 5672
    username: guest
    password: 123456
    virtual-host: /
logging:
  level:
    com.atguigu.mq.listener.MyMessageListener: info
```

#### 注解模式

监听器（消费者接收消息）（注解模式 `@RabbitListener` 进行创建交换机和队列且进行绑定）

```java
@Component
@Slf4j
public class MyMessageListener {
    // 交换机名称
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    // 路由健
    public static final String ROUTING_KEY = "order";
    // 队列名称
    public static final String QUEUE_NAME = "queue.order";

    // 监听 + 在RabbitMQ服务上创建交换机，队列
    // bindings：指定交换器和队列之间的绑定关系，指定当前方法要监听的队列，如果RabbitMQ服务器上没有这里指定的交换器和队列，那么框架底层的代码会创建它们
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = QUEUE_NAME, durable = "true"),
            exchange = @Exchange(value = EXCHANGE_DIRECT,type = "direct"),
            key = {ROUTING_KEY}))
    public void processMessage(String dataString, Message message, Channel channel) {
        log.info(dataString);
    }
}
```

#### 配置模式

监听器（消费者接收消息）（配置模式进行创建交换机和队列且进行绑定）

1. 使用`RabbitConfig`配置类，创建交换机和队列

```java
@Configuration
public class RabbitMQConfig {
    // 交换机名称
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    // 路由健
    public static final String ROUTING_KEY = "order";
    // 队列名称
    public static final String QUEUE_NAME = "queue.order1";

    // 自定义消息转换器
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // 定义direct类型交换器
    @Bean
    public Exchange routing_Exchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT)
                              .build();
    }

    // 定义队列
    @Bean
    public Queue routing_Queue() {
        return new Queue(QUEUE_NAME);
    }

    // 将消息队列与交换器进行绑定
    @Bean
    public Binding bindingMessage() {
        return BindingBuilder.bind(routing_Queue())
                             .to(routing_Exchange())
                             .with(ROUTING_KEY)
                             .noargs();
    }
}
```

2. 此时直接使用`@RabbitListener`注解指定队列名称接收消息

```java
@Component
@Slf4j
public class MyMessageListener {
 		// 队列名称
    public static final String QUEUE_NAME = "queue.order";
    // 监听
    @RabbitListener(queues = QUEUE_NAME)
    public void processMessage(String dataString, Message message, Channel channel) {
        log.info(dataString);
    }
}
```

#### 界面配置

进入 15672 端口的界面

直接在图形界面进行创建交换机和队列

然后将交换机和队列进行绑定

1. 创建交换机

![image-20240526122015418](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405261220856.png)

2. 创建队列

![image-20240526122310831](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405261223363.png)

3. 绑定交换机和队列，并指定路由键

![image-20240526122452301](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405261224516.png)

4. 此时可以直接使用`@RabbitListener`注解指定队列名称接收消息

```java
@Component
@Slf4j
public class MyMessageListener {
 		// 队列名称
    public static final String QUEUE_NAME = "queue.order";
    // 监听
    @RabbitListener(queues = QUEUE_NAME)
    public void processMessage(String dataString, Message message, Channel channel) {
        log.info(dataString);
    }
}
```

### 生产者

1. 创建生产者module（SpringBoot项目）
2. 配置POM依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
    </dependency>
</dependencies>
```

3. 全局配置

```yaml
spring: 
  rabbitmq: 
    host: 192.168.116.33
    port: 5672 
    username: guest 
    password: 123456 
    virtual-host: /
```

4. 生产者测试程序

```java
@SpringBootTest
public class ProducerTest {
    // 交换机名称
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    // 路由健
    public static final String ROUTING_KEY = "order";

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
      	// 消息转发，通过交换机和路由键进行指定转发
        rabbitTemplate.convertAndSend(
          EXCHANGE_DIRECT, 
          ROUTING_KEY, 
          "Hello World");
    }
}
```

## 可靠性投递

故障1：

- 消息没有发送到消息队列上。

- 后果：消费者拿不到消息，业务功能缺失，数据错误
- 解决思路A：在生产者端进行确认，具体操作中我们会分别针对交换机和队列来确认，如果没有成功发送到消息队列服务器上，那就可以尝试重新发送
- 解决思路B：为目标交换机指定备份交换机，当目标交换机投递失败时，把消息投递至备份交换机 

故障2：

- 消息成功存入消息队列，但是消息队列服务器宕机了原本保存在内存中的消息也丢失了，即使服务器重新启动，消息也找不回来了。
- 后果：消费者拿不到消息，业务功能缺失，数据错误
- 解决思路：消息持久化到硬盘上，哪怕服务器重启也不会导致消息丢失

故障3：

- 消息成功存入消息队列，但是消费端出现问题，例如：宕机、抛异常等等
- 后果：业务功能缺失，数据错误
- 解决思路：
  - 消费端消费消息成功，给服务器返回`ACK`信息，然后消息队列删除该消息
  - 消费端消费消息失败，给服务器端返回`NACK`信息，同时把消息恢复为待消费的状态，这样就可以再次取回消息，重试一次（当然，这就需要消费端接口支持幂等性）

### 生产者端消息确认

#### 环境准备

1. 创建Module `confirm-producer`
2. 配置POM依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

3. 全局配置

```yaml
spring:
  rabbitmq:
    host: 192.168.116.33
    port: 5672
    username: guest
    password: 123456
    virtual-host: /
    publisher-confirm-type: CORRELATED # 交换机的确认
    publisher-returns: true # 队列的确认
logging:
  level:
    com.atguigu.mq.config.MQProducerAckConfig: info
```

#### 配置类

在这里我们为什么要创建这个配置类呢？首先，我们需要声明回调函数来接收RabbitMQ服务器返回的确认信息：

| 方法名            | 方法功能                 | 所属接口        | 接口所属类     |
| ----------------- | ------------------------ | --------------- | -------------- |
| confirm()         | 确认消息是否发送到交换机 | ConfirmCallback | RabbitTemplate |
| returnedMessage() | 确认消息是否发送到队列   | ReturnsCallback | RabbitTemplate |

然后，就是对RabbitTemplate的功能进行增强，因为回调函数所在对象必须设置到RabbitTemplate对象中才能生效。

原本RabbitTemplate对象并没有生产者端消息确认的功能，要给它设置对应的组件才可以。

而设置对应的组件，需要调用RabbitTemplate对象下面两个方法：

| 设置组件调用的方法   | 所需对象类型            |
| -------------------- | ----------------------- |
| setConfirmCallback() | ConfirmCallback接口类型 |
| setReturnCallback()  | ReturnCallback接口类型  |

##### 相关API

1. **`ConfirmCallback`**接口

这是RabbitTemplate内部的一个接口，源代码如下：

```java
/**
* A callback for publisher confirmations.
*
*/
@FunctionalInterface
public interface ConfirmCallback {
  /**
  * Confirmation callback.
  * @param correlationData correlation data for the callback.
  * @param ack true for ack, false for nack
  * @param cause An optional cause, for nack, when available, otherwise null.
  */
  void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause);
}
```

生产者端发送消息之后，回调confirm()方法

`ack`参数值为true：表示消息成功发送到了交换机

`ack`参数值为false：表示消息没有发送到交换机

2. **`ReturnCallback`**接口

同样也RabbitTemplate内部的一个接口，源代码如下：

```java
/**
* A callback for returned messages.
*
* @since 2.3
*/
@FunctionalInterface
public interface ReturnsCallback {
  /**
  * Returned message callback.
  * @param returned the returned message and metadata.
  */
  void returnedMessage(ReturnedMessage returned);
}
```

注意：接口中的returnedMessage()方法仅在消息没有发送到队列时调用

ReturnedMessage类中主要属性含义如下：

| 属性名     | 类型                                  | 含义                         |
| ---------- | ------------------------------------- | ---------------------------- |
| message    | org.springframework.amqp.core.Message | 消息以及消息相关数据         |
| replyCode  | int                                   | 应答码，类似于HTTP响应状态码 |
| replyText  | String                                | 应答码说明                   |
| exchange   | String                                | 交换机名称                   |
| routingKey | String                                | 路由键名称                   |

##### 实现配置类

1. 添加 `@Component` 加入IOC容器中
2. 自身实现 `ConfirmCallback`、`ReturnCallback` 两个接口，通过this指针将配置类的对象设置到RabbitTemplate中
3. 为了保证`init()`方法在应用启动时被调用，使用 `@PostConstruct` 注解修饰这个方法
4. **`@PostContruct`**

*`@PostConstruct`注解是Java中的一个标准注解，它用于指定在对象创建之后立即执行的方法。当使用依赖注入（如Spring框架）或者其他方式创建对象时，`@PostConstruct`注解可以确保在对象完全初始化之后，执行相应的方法。*

*使用`@PostConstruct`注解的方法必须满足以下条件：*

- *方法不能有任何参数*

- *方法必须是非静态的*

- *方法不能返回任何值*

*当容器实例化一个带有`@PostConstruct`注解的Bean时，它会在调用构造函数之后，并在依赖注入完成之前调用被`@PostConstruct`注解标记的方法。这样，我们可以在该方法中进行一些初始化操作，比如读取配置文件、建立数据库连接等。*

5. 需要提前创建交换机和队列，并使用路由键对其进行绑定

配置类：

```java
@Configuration
@Slf4j
public class RabbitConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // 消息发送到交换机成功或失败都会返回
         if (ack) {
            log.info("消息发送到交换机成功！数据：" + correlationData);
            log.info("消息发送到交换机成功！ack：" + ack);
            log.info("消息发送到交换机成功！cause：" + cause);
        } else {
            log.info("消息发送到交换机失败！数据：" + correlationData);
            log.info("消息发送到交换机失败！ack：" + ack);
            log.info("消息发送到交换机失败！cause：" + cause);
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        // 只有消息发送到队列失败才会返回
        log.info("消息主体: " + new String(returned.getMessage()
                                                   .getBody()));
        log.info("应答码: " + returned.getReplyCode());
        log.info("描述：" + returned.getReplyText());
        log.info("消息使用的交换器 exchange : " + returned.getExchange());
        log.info("消息使用的路由键 routing : " + returned.getRoutingKey());
    }
}
```

生产者发送消息

```java
@SpringBootTest
public class RabbitTest {
    public static final String EXCHANGE_NAME = "exchange.direct.order";
    public static final String ROUTING_KEY = "order";
  
    @Resource
    private RabbitTemplate rabbitTemplate;
  
    @Test
    public void test() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, "hello world");
    }
}
```

### 备份交换机

注意：备份交换机一定要选择fanout类型，因为原交换机转入备份交换机时并不会指定路由键

![image-20240526155430801](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405261554311.png)

1. 创建一个交换机和备份交换机
   1. 主交换机：`exchange.direct.order`
   2. 备份交换机：`exchange.direct.order.backup`，建立备份交换机的时候需要配置 `Alternate exchange`
2. 创建交换机和备份交换机所需要的队列
   1. 主交换机队列：`queue.order`
   2. 备份交换机队列：`queue.order.backup`
3. 将他们分别进行交换机和队列进行绑定

#### 配置类方式

在主交换机创建方法中使用 `.alternate` 来绑定备份交换机

绑定备份交换机后，如果主交换机出现错误则会自动转向备份交换机

```java
@Configuration
public class RabbitMQConfig {
    // 交换机名称
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    // 路由健
    public static final String ROUTING_KEY = "order";
    // 队列名称
    public static final String QUEUE_NAME = "queue.order";

    // 备份交换机
    public static final String EXCHANGE_DIRECT_BACKUP = "exchange.direct.order.backup";
    // 备份交换机队列
    public static final String QUEUE_NAME_BACKUP = "queue.order.backup";

    //// 自定义消息转换器
    //@Bean
    //public MessageConverter messageConverter() {
    //    return new Jackson2JsonMessageConverter();
    //}

    // 定义direct类型主交换器
    @Bean
    public DirectExchange routing_Exchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT)
                              // 定义备份交换机
                              .alternate(EXCHANGE_DIRECT_BACKUP)
                              .build();
    }

    // 定义fanout类型备份交换器
    @Bean
    public Exchange fanout_Exchange_Backup() {
        return ExchangeBuilder.fanoutExchange(EXCHANGE_DIRECT_BACKUP)
                              .build();
    }

    // 定义队列
    @Bean
    public Queue routing_Queue() {
        return new Queue(QUEUE_NAME);
    }

    // 定义备份交换机队列
    @Bean
    public Queue fanout_Queue_backup() {
        return new Queue(QUEUE_NAME_BACKUP);
    }

    // 将消息队列与主交换器进行绑定
    @Bean
    public Binding bindingMessage() {
        return BindingBuilder.bind(routing_Queue())
                             .to(routing_Exchange())
                             .with(ROUTING_KEY);
    }

    // 将备份消息队列和备份交换机进行绑定
    @Bean
    public Binding bindingMessage_backup() {
        return BindingBuilder.bind(fanout_Queue_backup())
                             .to(fanout_Exchange_Backup());
    }
}
```

消费者监听队列，并根据配置类创建交换机和队列

```java
@Component
@Slf4j
public class MyMessageListener {
 		// 队列名称
    public static final String QUEUE_NAME = "queue.order";
    // 监听
    @RabbitListener(queues = QUEUE_NAME)
    public void processMessage(String dataString, Message message, Channel channel) {
        log.info(dataString);
    }
}
```

然后在测试中测试生产者发送消息

```java
@SpringBootTest
public class RabbitTest {
    public static final String EXCHANGE_NAME = "exchange.direct.order";
    public static final String ROUTING_KEY = "order";

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, "hello world");
    }
}
```

#### 注解方式

```java
@Component
@Slf4j
public class MyMessageListener {
    // 交换机名称
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    // 备份交换机
    public static final String EXCHANGE_DIRECT_BACKUP = "exchange.direct.order.backup";
    // 路由键
    public static final String ROUTING_KEY = "order";
    // 队列名称
    public static final String QUEUE_NAME = "queue.order";
    // 备份交换机队列
    public static final String QUEUE_NAME_BACKUP = "queue.order_backup";

    @RabbitListener(bindings = {
      @QueueBinding(
        value = @Queue(value = QUEUE_NAME, durable = "true"),
        exchange = @Exchange(
          value = EXCHANGE_DIRECT,
          type = "direct",
          arguments = {
            @Argument(value = "alternate-exchange", EXCHANGE_DIRECT_BACKUP)
          }),
        key = {ROUTING_KEY}
      ),
      @QueueBinding(
        value = @Queue(value = QUEUE_NAME_BACKUP, durable = "true"),
        exchange = @Exchange(value = EXCHANGE_DIRECT_BACKUP, type = "fanout"),
        key = {""}
      )
    })
    public void processMessage(String dataString, Message message, Channel channel) {
        log.info(dataString);
    }
}
```

#### 界面配置方式

在界面分别创建两个交换机，创建主交换机的时候绑定备份交换机

![image-20240526162812392](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405261628505.png)

分别创建两个交换机的队列 `queue.direct.order` 、`queue.direct.order.backup`

备份交换机需要是fanout类型的，并进行绑定对应的交换机

![image-20240526163315251](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405261633665.png)

### 交换机和队列持久化

在RabbitMQ中默认创建队列和交换机就是持久化的

1. 在使用配置类持久化的时候只需要增加一个durable就可以选择是否持久化，如果不加则就是默认持久化

```java
// 定义direct类型主交换器
@Bean
public Exchange routing_Exchange() {
  return ExchangeBuilder.directExchange(EXCHANGE_DIRECT)
    // 持久化
    .durable(true)
    // 定义备份交换机
    .withArgument("alternate-exchange", EXCHANGE_DIRECT_BACKUP)
    .build();
}


// 定义队列
@Bean
public Queue routing_Queue() {
/*
  参数1：name – 队列的名称。
  参数1：durable – 如果我们声明的是持久队列（该队列将在服务器重新启动后继续存在），则为 true
  参数1：exclusive – 如果我们声明的是独占队列（该队列将仅由声明者的连接使用），则为 true
  参数1：autoDelete – 如果服务器在不再使用队列时应删除队列，则为 true
*/
  return new Queue(QUEUE_NAME, true, false, false);
}
```

2. 注解方式

```java
@RabbitListener(bindings = {
   @QueueBinding(
    	// 是否持久化，默认持久化
       value = @Queue(value = QUEUE_NAME, durable = "true"),
       exchange = @Exchange(
           value = EXCHANGE_DIRECT,
           type = "direct",
         	// 是否持久化，默认持久化
           durable = "true"
       ),
       key = {ROUTING_KEY}
   ),
})
public void psubConsumerEmail(Message message) {
    byte[] body = message.getBody();
    String s = new String(body);
    System.out.println("接收到消息:" + s);
}
```

### 消费端消息确认

ACK是acknowledge的缩写，表示已确认

默认情况下，消费端取回消息后，默认会自动返回ACK确认消息，所以在前面的测试中消息被消费端消费之后，RabbitMQ得到ACK确认信息就会删除消息

但实际开发中，消费端根据消息队列投递的消息执行对应的业务，未必都能执行成功，如果希望能够多次重试，那么默认设定就不满足要求了

所以还是要修改成手动确认

#### 环境配置

1. 新建Module `confirm-consumer` springboot项目
2. POM依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

3. 全局配置

```yaml
spring:
  rabbitmq:
    host: 192.168.116.33
    port: 5672
    username: guest
    password: 123456
    virtual-host: /
    listener:
      simple:
        acknowledge-mode: manual # 把消息确认模式改为手动确认
```

#### 相关API

- `deliveryTag`：交付标签机制，唯一标识，一个64位整数，消息往消费端投递时，会携带交付标签

![image-20240526210424914](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405262104923.png)

消费端把消息处理结果ACK、NACK、Reject等返回给Broker之后，Broker需要对对应的消息执行后续操作，例如删除消息、重新排队或标记为死信等等。那么Broker就必须知道它现在要操作的消息具体是哪一条。而deliveryTag作为消息的唯一标识就很好的满足了这个需求。

**basicAck方法** 

- 方法功能：给Broker返回ACK确认信息，表示消息已经在消费端成功消费，这样Broker就可以把消息删除了

| 参数名称         | 含义                                                         |
| ---------------- | ------------------------------------------------------------ |
| long deliveryTag | Broker给每一条进入队列的消息都设定一个唯一标识               |
| boolean multiple | 取值为true：为小于、等于deliveryTag的消息批量返回ACK信息<br/>取值为false：仅为指定的deliveryTag返回ACK信息 |

**basicNack方法**

- 方法功能：给Broker返回NACK信息，表示消息在消费端消费失败，此时Broker的后续操作取决于参数requeue的值

| 参数名称         | 含义                                                         |
| ---------------- | ------------------------------------------------------------ |
| long deliveryTag | Broker给每一条进入队列的消息都设定一个唯一标识               |
| boolean multiple | 取值为true：为小于、等于deliveryTag的消息批量返回ACK信息<br/>取值为false：仅为指定的deliveryTag返回ACK信息 |
| boolean requeue  | 取值为true：Broker将消息重新放回队列，接下来会重新投递给消费端<br/>取值为false：Broker将消息标记为已消费，不会放回队列 |

**basicReject方法**

- 方法功能：根据指定的deliveryTag，对该消息表示拒绝

| 参数名称         | 含义                                                         |
| ---------------- | ------------------------------------------------------------ |
| long deliveryTag | Broker给每一条进入队列的消息都设定一个唯一标识               |
| boolean requeue  | 取值为true：Broker将消息重新放回队列，接下来会重新投递给消费端<br/>取值为false：Broker将消息标记为已消费，不会放回队列 |

- basicNack()和basicReject()有啥区别？
  - basicNack()有批量操作
  - basicReject()没有批量操作

#### 配置代码

```java
@Component
@Slf4j
public class MyMessageListener {
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    public static final String ROUTING_KEY = "order";
    public static final String QUEUE_NAME = "queue.order";

    // 修饰监听方法
    @RabbitListener(
      // 设置绑定关系
      bindings = @QueueBinding(
        // 配置队列信息：durable 设置为 true 表示队列持久化；autoDelete 设置为 false 表示关闭自动删除
        value = @Queue(value = QUEUE_NAME, durable = "true", autoDelete = "false"),
        // 配置交换机信息：durable 设置为 true 表示队列持久化；autoDelete 设置为 false 表示关闭自动删除
        exchange = @Exchange(value = EXCHANGE_DIRECT, durable = "true", autoDelete = "false"),
        // 配置路由键信息
        key = {ROUTING_KEY}))
    //@RabbitListener(queues = {QUEUE_NAME})
    public void processMessage(String dataString, Message message, Channel channel) throws IOException {
        // 获取当前消息的deliveryTag，唯一标识
        long deliveryTag = message.getMessageProperties()
                                  .getDeliveryTag();
        try {
            // 核心操作
            log.info("消费端 消息内容：" + dataString);
            // 核心操作成功，返回ACK确认信息
            // 参数1：deliveryTag, 唯一标识
            // 参数2：是否批量处理
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {

            // 获取当前消息是否是重复投递的
            //  redelivered 为 true，说明是重复投递
            //  redelivered 为 false，说明是第一次投递
            Boolean redelivered = message.getMessageProperties()
                                         .getRedelivered();

            // 核心操作失败，返回NACK信息
            // 参数1：deliveryTag, 唯一标识
            // 参数2：是否批量处理
            // 参数3：控制消息是否重新放回队列
            if (redelivered) {
                // 如果是已经重复投递过的，则说明此前已经重试过一次了，则 requeue设置为false，表示不重复放回队列
                channel.basicNack(deliveryTag, false, false);
            } else {
                // 如果是第一次投递，则 requeue设置为true，表示重复放回队列，再投递第一次
                channel.basicNack(deliveryTag, false, true);
            }

            // reject 表示拒绝
            // 辨析：basicReject() 和 basicNack() 方法区别
            // basicNack能控制是否批量操作
            // basicReject() 不能控制是否批量操作
            // channel.basicReject(deliveryTag, true)

            throw new RuntimeException(e);
        }
    }
}
```

要点1：把消息确认模式改为<span style="color:blue;font-weight:bold;">手动确认</span>

要点2：调用Channel对象的方法返回信息

- ACK：Acknowledgement，表示消息处理成功
- NACK：Negative Acknowledgement，表示消息处理失败
- Reject：拒绝，同样表示消息处理失败

要点3：后续操作

- requeue为true：重新放回队列，重新投递，再次尝试
- requeue为false：不放回队列，不重新投递

要点4：deliveryTag 消息的唯一标识，查找具体某一条消息的依据

![image-20240526211659723](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405262117174.png)

## 消息端限流

![image-20240526214319694](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405262143735.png)

![image-20240526214336006](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405262143435.png)

### 环境配置

全局配置，在消费者端进行全局配置

```yaml
spring:
  rabbitmq:
    host: 192.168.116.33
    port: 5672
    username: guest
    password: 123456
    virtual-host: /
    listener:
      simple:
        acknowledge-mode: manual
        prefetch: 1 # 设置每次最多从消息队列服务器取回多少消息
```

### 实现代码

- 生产者发送100个消息
- 对照两种情况：
  - 消费端没有设置prefetch参数：100个消息被全部取回
  - 消费端设置prefetch参数为1：100个消息慢慢取回

1. 生产者代码

```java
@SpringBootTest
public class RabbitTest {
    // 交换机名称
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    // 路由健
    public static final String ROUTING_KEY = "order";

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend(
                EXCHANGE_DIRECT,
                ROUTING_KEY,
                "Hello world" + i
            );
        }
    }
}
```

2. 消费者代码

```java
@Component
@Slf4j
public class MyMessageListener {
    public static final String EXCHANGE_DIRECT = "exchange.direct.order";
    public static final String ROUTING_KEY = "order";
    public static final String QUEUE_NAME = "queue.order";
 
  @RabbitListener(queues = {QUEUE_NAME})
    public void processMessageTestPrefetch(String dataString, Message message, Channel channel) throws IOException, InterruptedException {
        long deliveryTag = message.getMessageProperties()
          .getDeliveryTag();

        log.info("消费端 消息内容：" + dataString);
        TimeUnit.SECONDS.sleep(1);
        channel.basicAck(deliveryTag, false);
    }
}
```

然后查看rabbitmq界面消息的接收情况

![image-20240526220428421](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405262204466.png)

## 消息超时

> 给消息设定一个过期时间，超过这个时间没有被取走的消息就会被删除
>
> 我们可以从两个层面来给消息设定过期时间：
>
> - 队列层面：在队列层面设定消息的过期时间，并不是队列的过期时间。意思是这个队列中的消息全部使用同一个过期时间。 
> - 消息本身：给具体的某个消息设定过期时间 
>
> 如果两个层面都做了设置，那么哪个时间短，哪个生效

### 队列层面

1. 配置类形式

```java
// 定义队列
@Bean
public Queue routing_Queue() {
    Map args = new HashMap();
  	// 设置队列过期时间，单位：ms，如果5秒内不进行接收消息就会自动删除
    args.put("x-message-ttl", 5000);
    /*
    参数1：name – 队列的名称。
    参数2：durable – 如果我们声明的是持久队列（该队列将在服务器重新启动后继续存在），则为 true
    参数3：exclusive – 如果我们声明的是独占队列（该队列将仅由声明者的连接使用），则为 true
    参数4：autoDelete – 如果服务器在不再使用队列时应删除队列，则为 true
    */
    return new Queue(QUEUE_NAME, true, false, false, args);
}
```

2. 注解形式，和配置类相同
3. 界面形式

表示如果6秒呢不进行接收消息就会删除整个队列消息

![image-20240526223538781](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405262235629.png)

### 消息本身

```java
@SpringBootTest
public class RabbitTest {
    // 交换机名称
    private static final String EXCHANGE_TIMEOUT = "exchange.test.timeout";
    // 路由健
    private static final String ROUTING_KEY_TIMEOUT = "routing.key.test.timeout";
  
  	@Test
    public void SendMessageTimeout() {
        // 创建消息后置处理对象
        MessagePostProcessor postProcessor = message -> {
            // 设置消息最大过期时间，单位：ms
            message.getMessageProperties()
              		 // 表示消息如果超过5秒不接受就会自动删除
                   .setExpiration("50000");
            return message;
        };
        rabbitTemplate.convertAndSend(
            EXCHANGE_TIMEOUT, 
            ROUTING_KEY_TIMEOUT, 
            "tset timeout");
		}
}
```

## 死信

> 当一个消息无法被消费，它就变成了死信。

死信产生的原因大致有下面三种：

- 拒绝：消费者拒接消息，`basicNack()`/`basicReject()`，并且不把消息重新放入原目标队列，requeue=false
- 溢出：队列中消息数量到达限制。比如队列最大只能存储10条消息，且现在已经存储了10条，此时如果再发送一条消息进来，根据先进先出原则，队列中最早的消息会变成死信
- 超时：消息到达超时时间未被消费

死信的处理方式大致有下面三种：

- 丢弃：对不重要的消息直接丢弃，不做处理
- 入库：把死信写入数据库，日后处理
- 监听：消息变成死信后进入死信队列，我们专门设置消费端监听死信队列，做后续处理（通常采用）

### 相关准备

> 创建完成之后将各自交换机与队列进行绑定

**创建死信交换机和队列**

- 死信交换机：`exchange.dead.letter.video`
- 死信队列：`queue.dead.letter.video`

- 死信路由键：`routing.key.dead.letter.video`

**创建正常交换机和队列**

- 正常交换机：`exchange.normal.video`
- 正常队列：`queue.normal.video`
- 正常路由键：`routing.key.normal.video`

创建正常队列的时候添加以下参数，对应死信交换机和队列

![image-20240528113949424](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405281140172.png)

**Java代码常量**

```java
// 正常交换机
public static final String EXCHANGE_NORMAL = "exchange.normal.video";  
// 死信交换机
public static final String EXCHANGE_DEAD_LETTER = "exchange.dead.letter.video";  

// 正常路由键
public static final String ROUTING_KEY_NORMAL = "routing.key.normal.video";  
// 死信路由键
public static final String ROUTING_KEY_DEAD_LETTER = "routing.key.dead.letter.video";  

// 正常队列
public static final String QUEUE_NORMAL = "queue.normal.video";  
// 死信队列
public static final String QUEUE_DEAD_LETTER = "queue.dead.letter.video";
```

### 消费端拒收消息

1. 发送消息的代码

```java
@Test  
public void testSendMessageButReject() {  
    rabbitTemplate  
      .convertAndSend(  
        EXCHANGE_NORMAL,  
        ROUTING_KEY_NORMAL,  
        "测试死信情况1：消息被拒绝");  
}
```

2. 监听正常队列的代码

```java
@RabbitListener(queues = {QUEUE_NORMAL})
public void processMessageNormal(Message message, Channel channel) throws IOException {
    // 监听正常队列，但是拒绝消息
    log.info("★[normal]消息接收到，但我拒绝。");
    channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
}
```

3. 监听死信队列的代码

```java
@RabbitListener(queues = {QUEUE_DEAD_LETTER})
public void processMessageDead(String dataString, Message message, Channel channel) throws IOException {  
    // 监听死信队列  
    log.info("★[dead letter]dataString = " + dataString);
    log.info("★[dead letter]我是死信监听方法，我接收到了死信消息");
    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
}
```

### 消息数量超过队列容纳极限

1. 发送消息的代码

```java
@Test  
public void testSendMultiMessage() {  
    for (int i = 0; i < 20; i++) {  
        rabbitTemplate.convertAndSend(  
                EXCHANGE_NORMAL,  
                ROUTING_KEY_NORMAL,  
                "测试死信情况2：消息数量超过队列的最大容量" + i);  
    }  
}
```

2. 接收消息的代码

```java
@RabbitListener(queues = {QUEUE_NORMAL})
public void processMessageNormal(Message message, Channel channel) throws IOException {
    // 监听正常队列
    log.info("★[normal]消息接收到。");
    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
}
```

3. 由于发出的20个，但是我们创建队列时候最大容量为10，所以最先进去的10个就进死信队列了

### 消息超时未消费

1. 发送消息代码

```java
@Test
public void testSendMessageTimeout() {
    rabbitTemplate
            .convertAndSend(
                    EXCHANGE_NORMAL,
                    ROUTING_KEY_NORMAL,
                    "测试死信情况3：消息超时");
}
```

2. 发送消息之后，不要启动消费端，等待消息过了超时时间之后就会自动进入死信队列，由于一开始创建队列，超时时间为10s，等待10s过后就会进入死信队列

## 延迟队列

> 延时队列,队列内部是有序的，最重要的特性就体现在它的延时属性上，延时队列中的元素是希望 在指定时间到了以后或之前取出和处理，简单来说，延时队列就是用来存放需要在指定时间被处理的 元素的队列。

方案1：借助消息超时时间+死信队列

![image-20240528165611839](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405281656616.png)

方案2：给RabbitMQ安装插件

- 官网地址：https://github.com/rabbitmq/rabbitmq-delayed-message-exchange
- 延迟极限：最多两天

### 插件安装

1. 确定卷映射目录

```sh
docker inspect rabbitmq
```

2. 找到Mounts

```sh
"Mounts": [
  {
    "Type": "volume",
    "Name": "rabbitmq-plugin",
    "Source": "/var/lib/docker/volumes/rabbitmq-plugin/_data",
    "Destination": "/plugins",
    "Driver": "local",
    "Mode": "z",
    "RW": true,
    "Propagation": ""
  },
  {
    "Type": "volume",
    "Name": "cca7bc3012f5b76bd6c47a49ca6911184f9076f5f6263b41f4b9434a7f269b11",
    "Source": "/var/lib/docker/volumes/cca7bc3012f5b76bd6c47a49ca6911184f9076f5f6263b41f4b9434a7f269b11/_data",
    "Destination": "/var/lib/rabbitmq",
    "Driver": "local",
    "Mode": "",
    "RW": true,
    "Propagation": ""
  }
]
```

和容器内/plugins目录对应的宿主机目录是：/var/lib/docker/volumes/rabbitmq-plugin/_data

3. 下载延迟插件

官方文档说明页地址：https://www.rabbitmq.com/community-plugins.html

下载插件安装文件：

```sh
wget https://github.com/rabbitmq/rabbitmq-delayed-message-exchange/releases/download/v3.13.0/rabbitmq_delayed_message_exchange-3.13.0.ez
mv rabbitmq_delayed_message_exchange-3.13.0.ez /var/lib/docker/volumes/rabbitmq-plugin/_data
```

4. 启用插件

```sh
# 登录进入容器内部
docker exec -it rabbitmq /bin/bash

# rabbitmq-plugins命令所在目录已经配置到$PATH环境变量中了，可以直接调用
rabbitmq-plugins enable rabbitmq_delayed_message_exchange

# 退出Docker容器
exit

# 重启Docker容器
docker restart rabbitmq
```

4. 确认是否安装成功

在界面中Overview中，找到当前机器的Nodes，进去之后点击Advanced，就可以查看安装的插件

![image-20240528165528947](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405281655132.png)

### 实现

1. 生产者发送消息

```java
@Test
public void testSendDelayMessage() {
  
  // 创建消息后置处理器
  MessagePostProcessor postProcessor = message -> {
    // 设置消息过期时间
    // x-delay 必须基于 x-delayed-message-exchange
    message.getMessageProperties()
      .setHeader("x-delay", "10000");
    return message;
  };
  
  String message = "测试基于插件的延迟消息 [" + new SimpleDateFormat("hh:mm:ss").format(new Date()) + "]";
  
  rabbitTemplate.convertAndSend(
    EXCHANGE_DELAY,
    ROUTING_KEY_DELAY,
    message,
    postProcessor);
}
```

2. 消费者接收消息

```java
@Component  
@Slf4j
public class MyDelayMessageListener {  
  
    public static final String EXCHANGE_DELAY = "exchange.delay.video";
    public static final String ROUTING_KEY_DELAY = "routing.key.delay.video";
    public static final String QUEUE_DELAY = "queue.delay.video";
  
    @RabbitListener(bindings = @QueueBinding(  
        value = @Queue(value = QUEUE_DELAY, durable = "true", autoDelete = "false"),  
        exchange = @Exchange(  
          value = EXCHANGE_DELAY,   
          durable = "true",   
          autoDelete = "false",   
          type = "x-delayed-message",   
          arguments = @Argument(name = "x-delayed-type", value = "direct")),  
        key = {ROUTING_KEY_DELAY}  
    ))  
    public void process(String dataString, Message message, Channel channel) throws IOException {  
        log.info("[生产者]" + dataString);  
        log.info("[消费者]" + new SimpleDateFormat("hh:mm:ss").format(new Date())); 
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);  
    }  
}
```

## 事务消息

![image-20240528172706806](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405281727693.png)

在生产者端使用事务消息和消费端没有关系 

在生产者端使用事务消息仅仅是控制事务内的消息是否发送

提交事务就把事务内所有消息都发送到交换机 

回滚事务则事务内任何消息都不会被发送

**相关配置**

```java
@Configuration
@Data
public class RabbitConfig {

    @Bean
    public RabbitTransactionManager transactionManager(CachingConnectionFactory connectionFactory) {
        return new RabbitTransactionManager(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }
}
```

**测试代码**

```java
public static final String EXCHANGE_NAME = "exchange.tx.dragon";
public static final String ROUTING_KEY = "routing.key.tx.dragon";

@Resource
private RabbitTemplate rabbitTemplate;

@Test
@Transactional
@Rollback(value = true)
public void testSendMessageInTx() {
  // 1、发送第一条消息
  rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, "I am a dragon(tx msg ~~~01)");

  // 2、抛出异常
  log.info("do bad:" + 10 / 0);

  // 3、发送第二条消息
  rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, "I am a dragon(tx msg ~~~02)");
}
```

## 惰性队列

使用惰性队列的主要原因之一是支持非常长的队列

由于各种原因，排队可能会变得很长：

- 消费者离线/崩溃/停机进行维护

- 突然出现消息进入高峰，生产者的速度超过了消费者
- 消费者比正常情况慢

创建队列时，在Durability这里有两个选项可以选择

- Durable：持久化队列，消息会持久化到硬盘上
- Transient：临时队列，不做持久化操作，broker重启后消息会丢失

未设置惰性模式时队列的持久化机制

![image-20240528180012558](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405281800485.png)

设置惰性模式时队列的持久化机制

![image-20240528180131538](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405281801295.png)

![image-20240528182619899](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405281826102.png)

队列可以创建为`默认`或`惰性`模式，模式指定方式是：

- 使用队列策略（建议）
- 设置`queue.declare`参数

如果策略和队列参数同时指定，那么队列参数有更高优先级。如果队列模式是在声明时通过可选参数指定的，那么只能通过删除队列再重新创建来修改。

**基于策略设定**

```sh
# 登录Docker容器
docker exec -it rabbitmq /bin/bash

# 运行rabbitmqctl命令
rabbitmqctl set_policy Lazy "^lazy-queue$" '{"queue-mode":"lazy"}' --apply-to queues
```

命令解读：

- rabbitmqctl命令所在目录是：/opt/rabbitmq/sbin，该目录已配置到Path环境变量
- set_policy是子命令，表示设置策略
- Lazy是当前要设置的策略名称，是我们自己自定义的，不是系统定义的
- "^lazy-queue$"是用正则表达式限定的队列名称，凡是名称符合这个正则表达式的队列都会应用这里的设置
- '{"queue-mode":"lazy"}'是一个JSON格式的参数设置指定了队列的模式为"lazy"
- –-apply-to参数指定该策略将应用于队列（queues）级别

- 命令执行后，所有名称符合正则表达式的队列都会应用指定策略，包括未来新创建的队列

如果需要修改队列模式可以执行如下命令（不必删除队列再重建）：

```shell
rabbitmqctl set_policy Lazy "^lazy-queue$" '{"queue-mode":"default"}' --apply-to queues
```

**在声明队列时使用参数设定**

- 参数名称：x-queue-mode
- 可用参数值：
  - default
  - lazy
- 不设置就是取值为default

Java代码原生API设置方式：

```java
Map<String, Object> args = new HashMap<String, Object>();
args.put("x-queue-mode", "lazy");
channel.queueDeclare("myqueue", false, false, false, args);
```

Java代码注解设置方式：

```java
@Queue(value = QUEUE_NAME, 
       durable = "true", 
       autoDelete = "false", 
       arguments = {
         @Argument(name = "x-queue-mode", value = "lazy")
       })
```

### 生产者代码

```java
@SpringBootTest
public class RabbitMQTest {

    public static final String EXCHANGE_LAZY_NAME = "exchange.atguigu.lazy";
    public static final String ROUTING_LAZY_KEY = "routing.key.atguigu.lazy";

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        rabbitTemplate.convertAndSend(EXCHANGE_LAZY_NAME, ROUTING_LAZY_KEY, "I am a message for test lazy queue.");
    }
}
```

### 消费者代码

```java
@Component
@Slf4j
public class MyLazyMessageProcessor {

    public static final String EXCHANGE_LAZY_NAME = "exchange.atguigu.lazy";
    public static final String ROUTING_LAZY_KEY = "routing.key.atguigu.lazy";
    public static final String QUEUE_LAZY_NAME = "queue.atguigu.lazy";

    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = QUEUE_LAZY_NAME, 
                       durable = "true", 
                       autoDelete = "false", 
                       arguments = {
                         @Argument(name = "x-queue-mode", value = "lazy")
                       }),
        exchange = @Exchange(value = EXCHANGE_LAZY_NAME, 
                             durable = "true", 
                             autoDelete = "false"),
        key = {ROUTING_LAZY_KEY}
    ))
    public void processMessageLazy(String data, Message message, Channel channel) {
        log.info("消费端接收到消息：" + data);
    }
}
```

## 优先级队列

**机制说明**

- 默认情况：基于队列先进先出的特性，通常来说，先入队的先投递

- 设置优先级之后：优先级高的消息更大几率先投递

- 关键参数：`x-max-priority`

**消息的优先级设置**

- RabbitMQ允许我们使用一个正整数给消息设定优先级
- 消息的优先级数值取值范围：1~255
- RabbitMQ官网建议在1~5之间设置消息的优先级（优先级越高，占用CPU、内存等资源越多）

**队列的优先级设置**

- 队列在声明时可以指定参数：`x-max-priority`
- 默认值：0 此时消息即使设置优先级也无效
- 指定一个正整数值：消息的优先级数值不能超过这个值

### 相关准备

1. 创建交换机 `exchange.test.priority`
2. 创建队列：`queue.test.priority`，创建队列的时候添加参数 `x-max-priority`
3. 路由键：`routing.key.test.priority`
4. 将队列绑定交换机

### 生产者

```java
@SpringBootTest
public class RabbitMQTest {
    public static final String EXCHANGE_PRIORITY = "exchange.test.priority";
    public static final String ROUTING_KEY_PRIORITY = "routing.key.test.priority";

    @Resource
    private RabbitTemplate rabbitTemplate;
  
    
  	MessagePostProcessor messagePostProcessor = message -> {
      message.getMessageProperties()
        // 设置优先级,优先级越高越先投递
        .setPriority(1);
      return message;
    };

    @Test
    public void testSendMessage() {
        rabbitTemplate.convertAndSend(EXCHANGE_PRIORITY, ROUTING_KEY_PRIORITY, "I am a message with priority 1.", messagePostProcessor);
    }
}
```

### 消费端

```java
public static final String QUEUE_PRIORITY = "queue.test.priority";

@RabbitListener(queues = {QUEUE_PRIORITY})
public void processPriorityMessage(String data, Message message, Channel channel) throws IOException {
  log.info(data);
  channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
}
```

## 集群篇

### 安装

CentOS发行版的版本≥CentOS 8 Stream

镜像下载地址：

https://mirrors.163.com/centos/8-stream/isos/x86_64/CentOS-Stream-8-20240318.0-x86_64-dvd1.iso

#### 安装Erlang

以下内容来自官方文档：https://www.rabbitmq.com/docs/install-rpm

1. 创建yum库配置文件

```sh
vim /etc/yum.repos.d/rabbitmq.repo
```

```properties
# In /etc/yum.repos.d/rabbitmq.repo

##
## Zero dependency Erlang RPM
##

[modern-erlang]
name=modern-erlang-el8
# uses a Cloudsmith mirror @ yum.novemberain.com in addition to its Cloudsmith upstream.
# Unlike Cloudsmith, the mirror does not have any traffic quotas
baseurl=https://yum1.novemberain.com/erlang/el/8/$basearch
        https://yum2.novemberain.com/erlang/el/8/$basearch
        https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-erlang/rpm/el/8/$basearch
repo_gpgcheck=1
enabled=1
gpgkey=https://github.com/rabbitmq/signing-keys/releases/download/3.0/clouds
mith.rabbitmq-erlang.E495BB49CC4BBE5B.key
gpgcheck=1
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
pkg_gpgcheck=1
autorefresh=1
type=rpm-md

[modern-erlang-noarch]
name=modern-erlang-el8-noarch
# uses a Cloudsmith mirror @ yum.novemberain.com.
# Unlike Cloudsmith, it does not have any traffic quotas
baseurl=https://yum1.novemberain.com/erlang/el/8/noarch
        https://yum2.novemberain.com/erlang/el/8/noarch
        https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-erlang/rpm/el/8/noarch
repo_gpgcheck=1
enabled=1
gpgkey=https://github.com/rabbitmq/signing-keys/releases/download/3.0/cloudsmith.rabbitmq-erlang.E495BB49CC4BBE5B.key
       https://github.com/rabbitmq/signing-keys/releases/download/3.0/rabbitmq-release-signing-key.asc
gpgcheck=1
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
pkg_gpgcheck=1
autorefresh=1
type=rpm-md

[modern-erlang-source]
name=modern-erlang-el8-source
# uses a Cloudsmith mirror @ yum.novemberain.com.
# Unlike Cloudsmith, it does not have any traffic quotas
baseurl=https://yum1.novemberain.com/erlang/el/8/SRPMS
        https://yum2.novemberain.com/erlang/el/8/SRPMS
        https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-erlang/rpm/el/8/SRPMS
repo_gpgcheck=1
enabled=1
gpgkey=https://github.com/rabbitmq/signing-keys/releases/download/3.0/cloudsmith.rabbitmq-erlang.E495BB49CC4BBE5B.key
       https://github.com/rabbitmq/signing-keys/releases/download/3.0/rabbitmq-release-signing-key.asc
gpgcheck=1
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
pkg_gpgcheck=1
autorefresh=1


##
## RabbitMQ Server
##

[rabbitmq-el8]
name=rabbitmq-el8
baseurl=https://yum2.novemberain.com/rabbitmq/el/8/$basearch
        https://yum1.novemberain.com/rabbitmq/el/8/$basearch
        https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-server/rpm/el/8/$basearch
repo_gpgcheck=1
enabled=1
# Cloudsmith's repository key and RabbitMQ package signing key
gpgkey=https://github.com/rabbitmq/signing-keys/releases/download/3.0/cloudsmith.rabbitmq-server.9F4587F226208342.key
       https://github.com/rabbitmq/signing-keys/releases/download/3.0/rabbitmq-release-signing-key.asc
gpgcheck=1
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
pkg_gpgcheck=1
autorefresh=1
type=rpm-md

[rabbitmq-el8-noarch]
name=rabbitmq-el8-noarch
baseurl=https://yum2.novemberain.com/rabbitmq/el/8/noarch
        https://yum1.novemberain.com/rabbitmq/el/8/noarch
        https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-server/rpm/el/8/noarch
repo_gpgcheck=1
enabled=1
# Cloudsmith's repository key and RabbitMQ package signing key
gpgkey=https://github.com/rabbitmq/signing-keys/releases/download/3.0/cloudsmith.rabbitmq-server.9F4587F226208342.key
       https://github.com/rabbitmq/signing-keys/releases/download/3.0/rabbitmq-release-signing-key.asc
gpgcheck=1
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
pkg_gpgcheck=1
autorefresh=1
type=rpm-md

[rabbitmq-el8-source]
name=rabbitmq-el8-source
baseurl=https://yum2.novemberain.com/rabbitmq/el/8/SRPMS
        https://yum1.novemberain.com/rabbitmq/el/8/SRPMS
        https://dl.cloudsmith.io/public/rabbitmq/rabbitmq-server/rpm/el/8/SRPMS
repo_gpgcheck=1
enabled=1
gpgkey=https://github.com/rabbitmq/signing-keys/releases/download/3.0/cloudsmith.rabbitmq-server.9F4587F226208342.key
gpgcheck=0
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
pkg_gpgcheck=1
autorefresh=1
type=rpm-md
```

2. 更新yum库

```sh
yum update -y --nobest # --nobest表示所需安装包即使不是最佳选择也接受
```

3. 安装Erlang

```sh
yum install -y erlang
```

#### 安装RabbitMQ

1. 安装RabbitMQ

```sh
# 导入GPG密钥
rpm --import 'https://github.com/rabbitmq/signing-keys/releases/download/3.0/rabbitmq-release-signing-key.asc'
rpm --import 'https://github.com/rabbitmq/signing-keys/releases/download/3.0/cloudsmith.rabbitmq-erlang.E495BB49CC4BBE5B.key'
rpm --import 'https://github.com/rabbitmq/signing-keys/releases/download/3.0/cloudsmith.rabbitmq-server.9F4587F226208342.key'

# 下载 RPM 包
wget https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.13.0/rabbitmq-server-3.13.0-1.el8.noarch.rpm

# 安装
rpm -ivh rabbitmq-server-3.13.0-1.el8.noarch.rpm
```

2. RabbitMQ基础配置

```sh
# 启用管理界面插件
rabbitmq-plugins enable rabbitmq_management

# 启动 RabbitMQ 服务：
systemctl start rabbitmq-server

# 将 RabbitMQ 服务设置为开机自动启动
systemctl enable rabbitmq-server

# 新增登录账号密码
rabbitmqctl add_user long 123456

# 设置登录账号权限
rabbitmqctl set_user_tags long administrator
rabbitmqctl set_permissions -p / long ".*" ".*" ".*"

# 配置所有稳定功能 flag 启用
rabbitmqctl enable_feature_flag all

# 重启RabbitMQ服务生效
systemctl restart rabbitmq-server
```

3. 删除yum配置

```sh
rm -rf /etc/yum.repos.d/rabbitmq.repo
```

### 配置虚拟机

通过克隆操作，一共准备三台VMWare虚拟机

| 集群节点名称 | 虚拟机 IP 地址  |
| ------------ | --------------- |
| node01       | 192.168.200.100 |
| node02       | 192.168.200.150 |
| node03       | 192.168.200.200 |

**更改IP地址**

在CentOS 7中，可以使用`nmcli`命令行工具修改IP地址。以下是具体步骤：

1. 查看网络连接信息：

```shell
nmcli con show
```

2. 停止指定的网络连接（将`<connection_name>`替换为实际的网络连接名称）：

```shell
nmcli con down <connection_name>
```

3. 修改IP地址（将`<connection_name>`替换为实际的网络连接名称，将`<new_ip_address>`替换为新的IP地址，将`<subnet_mask>`替换为子网掩码，将`<gateway>`替换为网关）：

```shell
# <new_ip_address>/<subnet_mask>这里是 CIDR 表示法
nmcli con mod <connection_name> ipv4.addresses <new_ip_address>/<subnet_mask>
nmcli con mod <connection_name> ipv4.gateway <gateway>
nmcli con mod <connection_name> ipv4.method manual
```

4. 启动网络连接：

```shell
nmcli con up <connection_name>
```

5. 验证新的IP地址是否生效：

```shell
ip addr show
```

**修改主机名称**

主机名称会被RabbitMQ作为集群中的节点名称，后面会用到，所以需要设置一下。<br/>修改方式如下：

```shell
vim /etc/hostname
```

### 集群节点彼此发现

#### node01

1. 设置IP地址到主机名称的映射

```sh
vim /etc/hostnames
```

```
192.168.116.100 node01
192.168.116.150 node02
192.168.116.200 node03
```

2. 查看当前RabbitMQ节点的Cookie值并记录

```sh
cat /var/lib/rabbitmq/.erlang.cookie 
```

3. 重置节点应用

```sh
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl start_app
```

#### node02

1. 设置IP地址到主机名称的映射

```sh
vim /etc/hostnames
```

```
192.168.116.100 node01
192.168.116.150 node02
192.168.116.200 node03
```

2. 将当前RabbitMQ节点的Cookie值修改为node01的Cookie值

```sh
vim /var/lib/rabbitmq/.erlang.cookie 
```

3. 重置节点应用

```sh
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster rabbit@node01
rabbitmqctl start_app
```

#### node03

1. 设置IP地址到主机名称的映射

```sh
vim /etc/hostnames
```

```
192.168.116.100 node01
192.168.116.150 node02
192.168.116.200 node03
```

2. 将当前RabbitMQ节点的Cookie值修改为node01的Cookie值

```sh
vim /var/lib/rabbitmq/.erlang.cookie 
```

3. 重置节点应用

```sh
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster rabbit@node01
rabbitmqctl start_app
```

4. 查看集群状态

```sh
rabbitmqctl cluster_status
```

5. 踢出节点

```sh
rabbitmqctl forget_cluster_node rabbit@node02
```

### 负载均衡

#### Management UI

![image-20240604112539480](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406041125470.png)

1. 安装HAProxy

```sh
yum install -y haproxy
haproxy -v
systemctl start haproxy
systemctl enable haproxy
```

2. 修改配置文件

```sh
vim /etc/haproxy/haproxy.cfg
```

添加以下内容

```
frontend rabbitmq_ui_frontend
bind 192.168.116.100:22222
mode http
default_backend rabbitmq_ui_backend

backend rabbitmq_ui_backend
mode http
balance roundrobin
option httpchk GET /
server rabbitmq_ui1 192.168.116.100:15672 check
server rabbitmq_ui2 192.168.116.150:15672 check
server rabbitmq_ui3 192.168.116.200:15672 check
```

设置SELinux策略，允许HAProxy拥有权限连接任意端口：

```sh
setsebool -P haproxy_connect_any=1
```

重启HAProxy

```sh
systemctl restart haproxy
```

#### 核心功能

![image-20240604113439051](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406041134706.png)

1. 修改配置文件

```sh
vim /etc/haproxy/haproxy.cfg
```

添加以下内容

```
frontend rabbitmq_frontend
bind 192.168.116.100:11111
mode tcp
default_backend rabbitmq_backend

backend rabbitmq_backend
mode tcp
balance roundrobin
server rabbitmq1 192.168.116.100:5672 check
server rabbitmq2 192.168.116.150:5672 check
server rabbitmq3 192.168.116.200:5672 check
```

重启haproxy

```
systemctl restart haproxy
```



#### 测试

1. 创建组件

- 交换机：exchange.cluster.test
- 队列：queue.cluster.test
- 路由键：routing.key.cluster.test

##### 生产者端

[1]配置POM

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

[2]配置YAML

```yaml
spring:
  rabbitmq:
    host: 192.168.116.100
    port: 11111
    username: long
    password: 123456
    virtual-host: /
    publisher-confirm-type: CORRELATED # 交换机的确认
    publisher-returns: true # 队列的确认
logging:
  level:
    com.atguigu.mq.config.MQProducerAckConfig: info
```

[3]配置类

```java
@Configuration
@Slf4j
public class MQProducerAckConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("消息发送到交换机成功！数据：" + correlationData);
        } else {
            log.info("消息发送到交换机失败！数据：" + correlationData + " 原因：" + cause);
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.info("消息主体: " + new String(returned.getMessage().getBody()));
        log.info("应答码: " + returned.getReplyCode());
        log.info("描述：" + returned.getReplyText());
        log.info("消息使用的交换器 exchange : " + returned.getExchange());
        log.info("消息使用的路由键 routing : " + returned.getRoutingKey());
    }
}
```

[4] Junit测试类

```java
@SpringBootTest
public class RabbitMQTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE_CLUSTER_TEST = "exchange.cluster.test";
    public static final String ROUTING_KEY_CLUSTER_TEST = "routing.key.cluster.test";

    @Test
    public void testSendMessage() {
        rabbitTemplate.convertAndSend(EXCHANGE_CLUSTER_TEST, ROUTING_KEY_CLUSTER_TEST, "message test cluster~~~");
    }
}
```

##### 消费者端

[1]配置POM

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.5</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

[2]配置YAML

```yaml
spring:
  rabbitmq:
    host: 192.168.116.100
    port: 11111
    username: long
    password: 123456
    virtual-host: /
    listener:
      simple:
        acknowledge-mode: manual
logging:
  level:
    com.atguigu.mq.listener.MyProcessor: info
```

[3]监听器

```java
@Component
@Slf4j
public class MyProcessor {
    @RabbitListener(queues = {"queue.cluster.test"})
    public void processNormalQueueMessage(String data, Message message, Channel channel) 
        throws IOException {
        log.info("消费端：" + data);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
```

### 仲裁队列

RabbitMQ从3.8.0版本开始加入仲裁队列功能，它是镜像队列的替代方案。它有队列[复制的](https://so.csdn.net/so/search?q=复制的&spm=1001.2101.3001.7020)能力，保障数据的高可用和安全性。使用仲裁队列可以在 RabbitMQ 节点间进行队列数据的复制，在一个节点宕机时队列仍然可以提供服务。

![image-20240604160014796](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406041600183.png)

特性：

1. 仲裁队列用 Raft 算法实现了持久的、复制的 FIFO 队列，更加专注于数据安全。
   1. 不会出现mirror queue出现的那样，两个节点件同一queue的数量落差很大的情况。
   2. Quorum队列中的消息要有集群中多半节点同意后，才会写到队列。这种队列类似于RocketMQ当中的Ledger集群，这种方式可以保证消息在集群内部不会丢失。
2. Quorum queue到特定负载后，就不会继续接受新消息了。保持自身的平衡。

#### 创建仲裁队列

1. **创建交换机**

和仲裁队列绑定的交换机没有特殊，我们还是创建一个direct交换机即可

交换机名称：`exchange.quorum.test`

2. **创建仲裁队列**

队列名称：`queue.quorum.test`

Type：`Quorum`

3. **绑定交换机**

路由键：`routing.key.quorum.test`

#### 常规测试

像使用经典队列一样发送消息、消费消息

1. 生产者端

```java
public static final String EXCHANGE_QUORUM_TEST = "exchange.quorum.test";
public static final String ROUTING_KEY_QUORUM_TEST = "routing.key.quorum.test";

@Test
public void testSendMessageToQuorum() {
    rabbitTemplate.convertAndSend(EXCHANGE_QUORUM_TEST, ROUTING_KEY_QUORUM_TEST, "message test quorum ~~~");
}
```

2. 消费者端

```java
public static final String QUEUE_QUORUM_TEST = "queue.quorum.test";

@RabbitListener(queues = {QUEUE_QUORUM_TEST})
public void quorumMessageProcess(String data, Message message, Channel channel) throws IOException {
    log.info("消费端：" + data);
    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
}
```

#### 高可用测试

1. 停止某个节点的rabbit应用

```sh
# 停止rabbit应用
rabbitmqctl stop_app
```

2. 再次测试发送消息，接收消息

### 流式队列



#### 启用插件

> <span style="color:blue;font-weight:bolder;">说明</span>：只有启用了Stream插件，才能使用流式队列的完整功能

在集群每个节点中依次执行如下操作：

```shell
# 启用Stream插件
rabbitmq-plugins enable rabbitmq_stream

# 重启rabbit应用
rabbitmqctl stop_app
rabbitmqctl start_app

# 查看插件状态
rabbitmq-plugins list
```

#### 负载均衡

在文件/etc/haproxy/haproxy.cfg末尾追加：

```sh
vim /etc/haproxy/haproxy.cfg
```

```text
frontend rabbitmq_stream_frontend
bind 192.168.116.100:33333
mode tcp
default_backend rabbitmq_stream_backend

backend rabbitmq_stream_backend
mode tcp
balance roundrobin
server rabbitmq1 192.168.116.100:5552 check
server rabbitmq2 192.168.116.150:5552 check
server rabbitmq3 192.168.116.200:5552 check
```

#### Java代码

##### 引入依赖

Stream 专属 Java 客户端官方网址：https://github.com/rabbitmq/rabbitmq-stream-java-client

Stream 专属 Java 客户端官方文档网址：https://rabbitmq.github.io/rabbitmq-stream-java-client/stable/htmlsingle/

```xml
<dependencies>
    <dependency>
        <groupId>com.rabbitmq</groupId>
        <artifactId>stream-client</artifactId>
        <version>0.15.0</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.30</version>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.2.3</version>
    </dependency>
</dependencies>
```

##### 创建Stream

>  <span style="color:blue;font-weight:bolder;">说明</span>：不需要创建交换机

**代码方式创建**

```java
Environment environment = Environment.builder()
        .host("192.168.116.100")
        .port(33333)
        .username("long")
        .password("123456")
        .build();

environment.streamCreator().stream("stream.atguigu.test2").create();

environment.close();
```

**ManagementUI创建**

![image-20240326143811226](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406041731211.png)

##### 生产者端程序

**内部机制说明**

1. 官方文档

> Internally, the `Environment` will query the broker to find out about the topology of the stream and will create or re-use a connection to publish to the leader node of the stream.

翻译：

> 在内部，Environment将查询broker以了解流的拓扑结构，并将创建或重用连接以发布到流的 leader 节点。

2. 解析

- 在 Environment 中封装的连接信息仅负责连接到 broker
- Producer 在构建对象时会访问 broker 拉取集群中 Leader 的连接信息
- 将来实际访问的是集群中的 Leader 节点
- Leader 的连接信息格式是：节点名称:端口号

![Snipaste_2024-06-04_17-33-45](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406041734858.png)

3. 配置

为了让本机的应用程序知道 Leader 节点名称对应的 IP 地址，我们需要在本地配置 hosts 文件，建立从节点名称到 IP 地址的映射关系

**示例代码**

```java
Environment environment = Environment.builder()
        .host("192.168.116.100")
        .port(33333)
        .username("long")
        .password("123456")
        .build();

Producer producer = environment.producerBuilder()
        .stream("stream.queue.test")
        .build();

byte[] messagePayload = "hello rabbit stream".getBytes(StandardCharsets.UTF_8);

CountDownLatch countDownLatch = new CountDownLatch(1);

producer.send(
        producer.messageBuilder().addData(messagePayload).build(),
        confirmationStatus -> {
            if (confirmationStatus.isConfirmed()) {
                System.out.println("[生产者端]the message made it to the broker");
            } else {
                System.out.println("[生产者端]the message did not make it to the broker");
            }

            countDownLatch.countDown();
        });

countDownLatch.await();

producer.close();

environment.close();
```

##### 消费端程序

```java
Environment environment = Environment.builder()
        .host("192.168.116.100")
        .port(33333)
        .username("long")
        .password("123456")
        .build();

environment.consumerBuilder()
        .stream("stream.queue.test")
        .name("stream.queue.test.consumer")
        .autoTrackingStrategy()
        .builder()
        .messageHandler((offset, message) -> {
            byte[] bodyAsBinary = message.getBodyAsBinary();
            String messageContent = new String(bodyAsBinary);
            System.out.println("[消费者端]messageContent = " + messageContent + " Offset=" + offset.offset());
        })
        .build();
```

#### 指定偏移量消费

**偏移量**

![图片1](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406041734787.png)

**官方文档说明**

> The offset is the place in the stream where the consumer starts consuming from. The possible values for the offset parameter are the following:
>
> - OffsetSpecification.<span style="color:blue;font-weight:bolder;">first()</span>: starting from the first available offset. If the stream has not been [truncated](https://rabbitmq.github.io/rabbitmq-stream-java-client/stable/htmlsingle/#limiting-the-size-of-a-stream), this means the beginning of the stream (offset 0).
> - OffsetSpecification.<span style="color:blue;font-weight:bolder;">last()</span>: starting from the end of the stream and returning the last [chunk](https://rabbitmq.github.io/rabbitmq-stream-java-client/stable/htmlsingle/#chunk-definition) of messages immediately (if the stream is not empty).
> - OffsetSpecification.<span style="color:blue;font-weight:bolder;">next()</span>: starting from the next offset to be written. Contrary to `OffsetSpecification.last()`, consuming with `OffsetSpecification.next()` will not return anything if no-one is publishing to the stream. The broker will start sending messages to the consumer when messages are published to the stream.
> - OffsetSpecification.<span style="color:blue;font-weight:bolder;">offset(offset)</span>: starting from the specified offset. 0 means consuming from the beginning of the stream (first messages). The client can also specify any number, for example the offset where it left off in a previous incarnation of the application.
> - OffsetSpecification.<span style="color:blue;font-weight:bolder;">timestamp(timestamp)</span>: starting from the messages stored after the specified timestamp. Note consumers can receive messages published a bit before the specified timestamp. Application code can filter out those messages if necessary.

**指定Offset消费**

```java
Environment environment = Environment.builder()
        .host("192.168.200.100")
        .port(33333)
        .username("atguigu")
        .password("123456")
        .build();

CountDownLatch countDownLatch = new CountDownLatch(1);

Consumer consumer = environment.consumerBuilder()
        .stream("stream.atguigu.test")
        .offset(OffsetSpecification.first())
        .messageHandler((offset, message) -> {
            byte[] bodyAsBinary = message.getBodyAsBinary();
            String messageContent = new String(bodyAsBinary);
            System.out.println("[消费者端]messageContent = " + messageContent);
            countDownLatch.countDown();
        })
        .build();

countDownLatch.await();

consumer.close();
```

**对比**

- autoTrackingStrategy 方式：始终监听Stream中的新消息（狗狗看家，忠于职守）
- 指定偏移量方式：针对指定偏移量的消息消费之后就停止（狗狗叼飞盘，叼回来就完）

## Federation插件

> Federation插件的设计目标是使RabbitMQ在不同的Broker节点之间进行消息传递而无须建立集群。
>
> 它可以在不同的管理域中的Broker或集群间传递消息，这些管理域可能设置了不同的用户和vhost，也可能运行在不同版本的RabbitMQ和Erlang上。Federation基于AMQP 0-9-1协议在不同的Broker之间进行通信，并且设计成能够容忍不稳定的网络连接情况。

### Federation交换机

- 各节点操作：启用联邦插件
- 下游操作：
  - 添加上游连接端点
  - 创建控制策略

#### 准备工作

为了执行相关测试，我们使用Docker创建两个RabbitMQ实例。

特别提示：由于Federation机制的最大特点就是跨集群同步数据，所以这两个Docker容器中的RabbitMQ实例不加入集群！！！是两个独立的broker实例。

```sh
docker run -d \
--name rabbitmq-shenzhen \
-p 51000:5672 \
-p 52000:15672 \
-v rabbitmq-plugin:/plugins \
-e RABBITMQ_DEFAULT_USER=guest \
-e RABBITMQ_DEFAULT_PASS=123456 \
rabbitmq:3.13-management

docker run -d \
--name rabbitmq-shanghai \
-p 61000:5672 \
-p 62000:15672 \
-v rabbitmq-plugin:/plugins \
-e RABBITMQ_DEFAULT_USER=guest \
-e RABBITMQ_DEFAULT_PASS=123456 \
rabbitmq:3.13-management
```

#### 启用联邦插件

在上游、下游节点中都需要开启。

Docker容器中的RabbitMQ已经开启了rabbitmq_federation，还需要开启rabbitmq_federation_management

```sh
# 运行docker容器后进入rabbit-server中， 开启插件
# docker exec -it rabbitmq-shanghai /bin/bash
# docker exec -it rabbitmq-shenzhen /bin/bash
rabbitmq-plugins enable rabbitmq_federation
rabbitmq-plugins enable rabbitmq_federation_management
```

rabbitmq_federation_management插件启用后会在Management UI的Admin选项卡下看到：

![image-20240604181951481](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406041819778.png)

#### 添加上游连接端点

需要区分上游下游端点，rabbitmq_shanghai（端口号:62000）作为下游端点，rabbitmq_shenzhen(52000)作为上游端点

在下游端点确认上游端点

![image-20240604203338890](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406042041275.png)

#### 创建控制策略

在下游端点中进行创建

![](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406042041275.png)

#### 测试

**测试计划**

- 普通交换机和联邦交换机名称要一致
- 交换机名称要能够和策略正则表达式匹配上
- 发送消息时，两边使用的路由键也要一致
- 队列名称不要求一致

![image-20240604204355057](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406042043640.png)

**创建组件**

| 所在机房             | 交换机名称              | 路由键                | 队列名称              |
| -------------------- | ----------------------- | --------------------- | --------------------- |
| shenzhen机房（上游） | federated.exchange.demo | routing.key.demo.test | queue.normal.shenzhen |
| shanghai机房（下游） | federated.exchange.demo | routing.key.demo.test | queue.normal.shanghai |

创建组件后可以查看一下联邦状态，连接成功的联邦状态如下：在下游节点查看联邦状态

![image-20240604204956771](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406042050475.png)

**测试，此时测试上游端点发送给交换机消息，同时查看下游端点的队列是否收到消息**

### Federation队列

Federation队列和Federation交换机的最核心区别就是：

- Federation Police作用在交换机上，就是Federation交换机
- Federation Police作用在队列上，就是Federation队列

#### 创建控制策略

在下游端点62000端口添加控制策略

![image-20240604214453631](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406042145001.png)

#### 测试

1. 测试计划

上游节点和下游节点中队列名称是相同的，只是下游队列中的节点附加了联邦策略而已

| 所在机房             | 交换机                   | 路由键                      | 队列           |
| -------------------- | ------------------------ | --------------------------- | -------------- |
| shenzhen机房（上游） | exchange.normal.shenzhen | routing.key.normal.shenzhen | fed.queue.demo |
| shanghai机房（下游） | ——                       | ——                          | fed.queue.demo |

2. 创建组件

上游节点都是常规操作，此处省略。重点需要关注的是下游节点的联邦队列创建时需要指定相关参数：

创建组件后可以查看一下联邦状态，连接成功的联邦状态如下：在下游Polices中查看联邦状态

![image-20240604215646918](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406042156844.png)

3. 执行测试

在上游节点向交换机发布消息：

但此时发现下游节点中联邦队列并没有接收到消息，这是为什么呢？这里就体现出了联邦队列和联邦交换机工作逻辑的区别。

对联邦队列来说，如果没有监听联邦队列的消费端程序，它是不会到上游去拉取消息的！

如果有消费端监听联邦队列，那么首先消费联邦队列自身的消息；如果联邦队列为空，<span style="color:blue;">**这时候才**</span>会到上游队列节点中拉取消息。

所以现在的测试效果需要消费端程序配合才能看到

## Shovel

Shovel和Federation的主要区别：

- Shovel更简洁一些 

- Federation更倾向于跨集群使用，而Shovel是否跨集群都可以

- Shovel源队列中的消息经过数据转移后相当于被消费了

**配置Shovel**

![image-20240604221750765](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406042217180.png)

**测试**

| 节点         | 交换机               | 路由键               | 队列                       |
| ------------ | -------------------- | -------------------- | -------------------------- |
| shenzhen节点 | exchange.shovel.test | exchange.shovel.test | queue.shovel.demo.shenzhen |
| shanghai节点 | ——                   | ——                   | queue.shovel.demo.shanghai |

此时在shenzhen节点，发送消息，但是shenzhen节点中的shovel队列没有存储消息，而是转移到了shanghai节点的shovel队列中
