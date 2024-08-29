# Nginx核心技术

## 简介

### 介绍

Nginx (engine x) 是一个高性能的HTTP和反向代理web服务器，同时也提供了IMAP/POP3/SMTP服务。Nginx是由伊戈尔·赛索耶夫为俄罗斯访问量第二的Rambler.ru站点（俄文：Рамблер）开发的，第一个公开版本0.1.0发布于2004年10月4日。

其将源代码以类BSD许可证的形式发布，因它的稳定性、丰富的功能集、简单的配置文件和低系统资源的消耗而闻名。2011年6月1日，nginx 1.0.4发布。

Nginx是一款轻量级的Web 服务器/反向代理服务器及电子邮件（IMAP/POP3）代理服务器，在BSD-like 协议下发行。其特点是占有内存少，并发能力强，事实上nginx的并发能力在同类型的网页服务器中表现较好



**主要功能：**

- 反向代理
- 实现集群和负载均衡
- 静态资源虚拟化

**Nginx的版本：**

- Nginx开源版 http://nginx.org/en/

  官方原始的Nginx版本

- Nginx plus商业版 https://www.nginx.com

  开箱即用，集成了大量功能

- Open Resty https://openresty.org/cn/

  OpenResty是一个基于Nginx与 Lua 的高性能 Web 平台，其内部集成了大量精良的 Lua 库、第三方模块以及大多数的依赖项。**更适用于需要大量二次开发的场景，有极强的扩展性**

- Tengine https://tengine.taobao.org/

  由淘宝网发起的Web服务器项目。它在[Nginx](http://nginx.org/)的基础上，针对大访问量网站的需求，添加了很多高级功能和特性。Tengine的性能和稳定性已经在大型的网站如[淘宝网](http://www.taobao.com/)，[天猫商城](http://www.tmall.com/)等得到了很好的检验。相比于Open Resty，扩展性不够强，但是能够满足绝多数使用场景

### 什么是代理

**正向代理**

正向代理可以理解为「客户端」的代理

![image-20220919121907145](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181046254.png)

**反向代理**

反向代理可以理解为「服务器」的代理

![image-20220919122008649](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181048011.png)

### 安装部署

下载源代码手动编译安装(推荐)，下载Nginx包：[官网下载地址](http://nginx.org/en/download.html)

快捷安装：https://oneinstack.com/

**解压Nginx包，并安装**

```shell
tar -zxvf  nginx-1.21.6.tar.gz #解压到当前目录

cd nginx-1.21.6 #进入解压后的文件夹
```

**安装依赖库**

```shell
#安装C编译器
yum install -y gcc
#安装pcre库PVEL
yum install -y pcre pcre-devel
#安装zlib
yum install -y zlib zlib-devel
```

**编译安装**

在linux进行安装，进入nginx目录下

```shell
./configure --prefix=/usr/local/nginx
make
make install
```

**启动Nginx**

进入安装好的目录 `/usr/local/nginx/sbin`

```shell
./nginx 启动
```

**关于防火墙**

```shell
# 关闭防火墙（一般不关闭，而是开放需要的端口）
systemctl stop firewalld

# 开放端口，例子：firewall-cmd --zone=public --add-port=80/tcp --permanent
firewall-cmd --zone=public --add-port=端口号/协议 --permanent

# 修改后，重启防火墙才会生效
firewall-cmd --reload

#禁止防火墙开机启动：
systemctl disable firewalld.service

# 补充：--zone参数为防火墙规则应用的区域
# 区域包括：
#	public：用于公共网络，例如 Internet。
#	internal：用于内部网络，例如公司内部网络。
#	external：用于外部网络，例如连接到互联网的网络。
#	work：用于工作场所网络。
#	home：用于家庭网络。

# 获取当前系统的区域
firewall-cmd --get-default-zone
```

**注册成系统服务**

注册为系统服务后，可以以系统服务的方式启动nginx

1. 创建服务脚本

`vim /usr/lib/systemd/system/nginx.service`

```shell
[Unit] 
Description=nginx # 服务描述
After=network.target remote-fs.target nss-lookup.target 
#指定你的服务应该在哪些系统目标（target）之后启动
# network.target：网络服务的就绪状态
# remote-fs.target ：远程文件系统的就绪状态（等待远程文件系统挂载完成）
# nss-lookup.target ： Name Service Switch (NSS) 查询的就绪状态（等待 DNS 解析和其他命名服务的就绪状态，如果服务需要进行名称解析需要设置这个）

[Service]
Type=forking 
# Nginx是一个master进程，fork出多个worker进程，所以类型是forking
# simple（服务在启动后会立即进入运行状态，而且不会在后台分叉（fork）出其他子进程。当服务的主进程退出时，系统认为服务已经停止）
# forking（适用于那些启动后立即生成子进程并退出主进程的服务）
# oneshot 适用于只需在启动时执行一次操作的服，服务在启动时执行完成后就停止。这种类型的服务通常用于执行某种初始化任务或者数据加载
# notify 适用于通过向 systemd 发送通知来指示服务已经启动完毕的服务
# dbus 在服务启动完成后，它需要发送一个特定的通知给 systemd，以告知服务已经准备就绪

PIDFile=/usr/local/nginx/logs/nginx.pid
ExecStartPre=/usr/local/nginx/sbin/nginx -t -c /usr/local/nginx/conf/nginx.conf
ExecStart=/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf # 服务启动时要执行的命令或脚本
ExecReload=/usr/local/nginx/sbin/nginx -s reload # 重新加载
ExecStop=/usr/local/nginx/sbin/nginx -s stop # 停止
ExecQuit=/usr/local/nginx/sbin/nginx -s quit  # 退出
PrivateTmp=true 
   
[Install]   
WantedBy=multi-user.target  # 多用户
```

```shell
# systemctl enable xxx服务名 # 自启动服务
systemctl enable nginx.service
# systemctl status xxx服务名 # 服务运行状态
systemctl status nginx.service

# systemctl start xxx服务名 # 开启服务
systemctl start nginx.service
# systemctl reload xxx服务名 # 重新加载服务
systemctl reload nginx.service
```

### Nginx常用命令

```shell
./nginx -s stop # 快速停止（正在进行的请求会直接被中断，很少使用）
./nginx -s quit # 处理完已接受的请求后，才会停止（优雅关机）
./nginx -s reload # 重新加载配置

./nginx -c xxx.conf # 配置nginx使用的配置文件地址（默认为conf/nginx.conf ）

./nginx -t # 检查nginx配置是否正确
./nginx -v # nginx版本号
```

```shell
./nginx -V # nginx详细信息，nginx版本号+编译使用的gcc版本号+编译配置
# 这里可以看到默认的 

# pid文件地址: --pid-path=/var/run/nginx/nginx.pid
# 错误日志地址：--eror-log-path=/var/log/nginx/error.log
# 请求日志地址：--http-log-path=/var/log/nginx/access.log（每一个请求就记录一个日志）
```

### 目录结构

Nginx一般安装在`/usr/local/nginx`目录下（安装时--prefix可指定安装目录）

![image-20240518110200472](D:\priv\project\笔记\assets\image-20240518110200472.png)

```
conf #配置文件
	｜-nginx.conf # 主配置文件
	｜-其他配置文件 # 可通过那个include关键字，引入到了nginx.conf生效
	
html #静态页面

logs（默认不是放在这里，可以在配置文件中修改为这里）
	｜-access.log #访问日志(每次访问都会记录)
	｜-error.log #错误日志
	｜-nginx.pid #进程号
	
sbin
	｜-nginx #主进程文件
	
*_temp #运行时，生成临时文件
```

## Nginx进程模型

一个Master：监听请求，并分配worker进程处理

默认一个worker进程（可以在配置文件中修改worker数量）：处理客户端请求



![image-20240517180249467](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/image-20240517180249467.png)

每个worker之间彼此独立，每一个worker处理多个请求

![image-20240212001002289](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181107684.png)

### worker的抢占机制

多个worker进程争抢一个锁，获取锁的进程进行响应

![image-20240212001442729](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181108158.png)

### worker事件处理机制

传统HTTP服务器是同步处理，当多个客户端请求时，如果Client1的请求被阻塞，Master会fork新的worker进程处理

但是Nginx采用的是异步非阻塞方式，如果Client1的请求被阻塞，worker会取处理下一个请求，不会阻塞当前worker进程。所以Nginx的一个worker进程可以并发处理大量请求

![image-20240212001752869](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181119249.png)

## Nginx配置

[Nginx配置文章](https://www.toutiao.com/article/7325692601267978789/?app=news_article&timestamp=1707783232&use_new_style=1&req_id=202402130813514EACD35B30C764DC86C1&group_id=7325692601267978789&share_token=3DDBA935-E652-4FCF-9792-E4FED2D9C0CA&tt_from=weixin&utm_source=weixin&utm_medium=toutiao_ios&utm_campaign=client_share&wxshare_count=1&source=m_redirect)

[Nginx配置生成工具](https://www.digitalocean.com/community/tools/nginx?global.app.lang=zhCN)

每次修改配置文件，一定要重载才能生效

```nginx
systemctl reload nginx # 以系统服务的方式启动nginx
```

### nginx.conf配置文件

```nginx
# master进程会启动worker进程，该选项设置在系统中显示启动该进程的用户名（一般不改动，默认nobody）
# user nobody

# 启动的worker进程数
worker_processes  1; 

# 错误日志放置的路径 notice、info是错误日志的级别，比如：info就是日志级别大于info才生成日志
# 默认地址为/var/log/nginx/error.log ，可通过nginx -V返回的--eror-log-path字段获取实际值
#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

# pid文件存放路径,默认：/var/run/nginx/nginx.pid，可通过nginx -V返回的--pid-path字段获取实际值
#pid        logs/nginx.pid;

# 配置事件处理方式、worker最大连接数
events {
	use epoll; # 使用epoll事件处理机制（默认值）
    worker_connections  1024; # 每个worker进程处理的最大连接数
}

# http模块配置
http {
    include       mime.types; #include是引入关键字，这里引入了mime.types这个配置文件的内容（同在conf目录下，mime.types是用来定义，请求返回的content-type）
    default_type  application/octet-stream; #mime.types未定义的数据类型，使用默认格式application/octet-stream
    
    # 访问日志格式
    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

	# 访问日志地址，默认：/var/log/nginx/access.log，可通过nginx -V返回的--http-log-path字段获取实际值
    #access_log  logs/access.log  main;

	# 详见下文，数据零拷贝
    sendfile        on; 
    #tcp_nopush     on;
    
     # TCP链接超时时间,单位秒
    keepalive_timeout  65;
	
    # 压缩相关，详见下文
    gzip on; # 开启压缩，压缩后发送给客户端
		
    # 虚拟机主机，详见下文
    server {
        //xxx
    }
}
```

### sendfile配置

打开sendfile，用户请求的数据不用再加载到nginx的内存中，而是直接发送，零拷贝

高负载的场景下，使用 sendfile 功能可以降低 CPU 和内存的占用，提升服务器性能

```nginx
http{
	sendfile: on # off
}

# 或者指定某个server开启
server {
    location / {
        sendfile off;
        ...
    }
}
```

![image-20240517192803827](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/image-20240517192803827.png)

### gzip配置

```nginx
http{
  	gzip on; # 开启压缩，压缩后发送给客户端
	gzip_min_length 1;# 设置最小压缩下限。1就是小于1字节的文件不压缩
    gzip_comp_level 3 # 压缩级别0-9，值越大文件就压缩的越小，相应的会损耗更多性能
    gzip_type text/plain application/javascript image/* # 指定哪些 MIME 类型，开启压缩（不写默认全部），可以使用通配符 image/* 就是所有图片。具体哪些类型可以看conf/mime.types文件
}
```

nginx 中的 gzip 压缩分为动态压缩、静态压缩

- **动态压缩**：服务器给客户端返回响应时，消耗自身的资源进行实时压缩，保证客户端拿到 gzip 格式的文件
- gzip on开启的就是动态压缩，gzip_comp_level设置的级别高，可能会造成CPU占用过高（文章：[简单一招竟把nginx服务器性能提升50倍](https://www.toutiao.com/article/7329343713828897280/?app=news_article&timestamp=1707783801&use_new_style=1&req_id=202402130823202F9A6100389685E57A11&group_id=7329343713828897280&share_token=F2E89DA7-CC1F-4AAC-9BCC-A82B8020A9D6&tt_from=weixin&utm_source=weixin&utm_medium=toutiao_ios&utm_campaign=client_share&wxshare_count=1&source=m_redirect)）
- **静态压缩**：直接将预先压缩过的 .gz 文件返回给客户端，不再实时压缩文件，如果找不到 .gz 文件，会使用对应的原始文件
- 该功能需要模块： `ngx_http_gzip_static_module`（默认不会被构建）
- 我们可以通过下面命令查看，当前安装的是否包含该模块

```nginx
./nginx -V
```

如果不包含，则需要重新编译

```nginx
./configure --with-http_gzip_static_module # 指定编译配置，这个参数安装模块`ngx_http_gzip_static_module`
make # 编译
make install # 安装
```

包含该模块，则可以启用下面配置

```nginx
http{
	gzip_static  on;
	gzip_proxied expired no-cache no-store private auth;
}
```

### server配置

虚拟主机配置（可以启用多个），多个server字段，会根据请求的域名+端口从前向后匹配

用户访问域名：`www.testnginx.com`（注意：需要解析到当前Nginx的这台机器），请求会匹配到下面的配置中

（本地测试时可以直接修改host，建立域名与Nginx所在机器IP的映射）

（server_name设置为localhost，即表示匹配任何打到这台机器的请求）

**区域配置功能**

| 区域     | 职责                                                 |
| -------- | ---------------------------------------------------- |
| 全局块   | 配置和Nginx运行相关的全局配置                        |
| events块 | 配置和网络链接相关的配置                             |
| http块   | 配置代理、缓存、日志记录、虚拟主机等配置             |
| server块 | 配置虚拟主机的相关参数，一个http块可以有多个server块 |
| location | 配置请求的路由，以及各种页面的处理情况               |

```nginx
http {
    #....其他属性
    # server 规则可以有多个，每个对应 一个域名+端口的组合
    server {
        access_log logs/test.testnginx.com-access.log # 访问日志字段也可以设置在Server中，命中该Server的请求日志都在这里
        listen       80; # 端口
        server_name  test.testnginx.com; # 域名，可以有多个值，用空格分隔。支持通配符，例如：*.example.org 。
    	# server_name  test.testnginx.com default_server; #default_server表示当Nginx接收的请求没有能匹配上的server，就命中设置了default_server

        # 域名+端口 匹配上了，就会走这里的映射（映射规则可以有多个）
        # 【类型1】
        # / 路径的映射配置，这个映射比较特殊，无论用户请求的是什么路径，只要没有被更具体的 location 块匹配到，就都会命中/。
        # 即 test.testnginx.com:80 会命中这里
        location / {  
            # root指定当前这个server的根路径为 html/pro
            # （注意root字段如果是相对路径很特殊：是相对于nginx的安装目录，即这里html与conf目录同级）
            root   html/test;  
            # 当命中/路径时的首页，nginx会在root目录下找index.html、index.htm并返回
            index  index.html index.htm; 
        }

        # 【类型2】
        # 一般请求用root
        # test.testnginx.com:80/abc、test.testnginx.com:80/abc/1 都会命中这条规则
        # 例如： test.testnginx.com:80/abc/ 会返回首页，即index字段（root目录下查找index指定的文件）
        # 例如： test.testnginx.com:80/abc/1/index.html 返回的是机器上的home/abc/1/index.html 
        # (实际机器路径为：root+【请求命中路径-全部路径结尾，例如：/abc/1/index.html】)
        location /abc {  
            root   /home; 
            index  index.html index.htm; 
        }

        # 【类型3】
        # 一般静态文件会用alias
        # /images/ 路径的映射配置，即 test.testnginx.com:80/images/xx会命中这里，实际请求路径为：/var/www/images/xxx。对比root字段，如果下面的alias替换为root字段，则实际请求路径为/var/www/images/images/xxx，这显然是错误的
        # 注意尾斜杠，test.testnginx.com:80/images不能命中
        location /images/ {
            # alias设置请求的别名，用于替换文件系统路径。
            alias /var/www/images/;
        }
        # 反向代理，proxy_pass将请求代理到指定的后端服务器。
        location /api/ {
        	proxy_pass http://backend_server;
        }

        # 服务器错误码为500 502 503 504，转到"域名/50x.html"
        error_page   500 502 503 504  /50x.html;

        # 【类型4】使用=代表精确匹配
        #  只有访问 test.testnginx.com:80/50x.html才能命中这条规则
        location = /50x.html {
            root  html;
        }

        # 【类型5】使用正则匹配
        #  '~',例子：location ~ { xxx }，表示匹配所有路径
        #  '~（空格）正则' ，例子：~ \.(png|gif) 匹配png、gif的路径
        #  '~*（空格）正则'，不区分大小写，例子：~ *\.(png|gif) 匹配png、PNG、gif、GIF等路径
        #  '^~（空格）字符串' ，表示匹配以字符串开头的请求，例子：^~ /test，即 test.testnginx.com:80/test/xxx可以命中
        location ~*\.(png|gif) { #因为忽略大小写，所以 test.testnginx.com:80/a.PNG 可以命中规则
            root   /home;
        }
    }

    server {
    # xxxx
    }
}
```

**server配置在单独文件维护**

新建配置文件`textnginx.conf`，在server配置放在一个独立文件维护

```nginx
server {
   # xxxx
}

server {
   # xxxx
}
```

在http中引入server配置

```nginx
http{
	include hedaodao.conf
}
```

**不同域名，映射到同一静态页面**

- 可以写多个，用空格分开
- 使用通配符（*）
- 使用正则表达式（https://blog.csdn.net/yangyelin/article/details/112976539）

```nginx
http{ 		
    server {
        listen    80;
        # "\."是转译"."
        server_name  *.hedaodao.ltd  ~^[0-9]+\.testnginx\.com$; 

        location / { 
            root   html/test; 
            index  index.html index.htm;
    	} 
    }
}
```

**Nginx内置变量**

https://cloud.tencent.com/developer/article/1955568?areaSource=102001.13&traceId=9kl0z2u4sa7AShSUHYJi4

### ServerName匹配规则

在nginx.conf中配置主机和域名的匹配规则

**完整匹配**：

```nginx
server {
    server_name  vod.mmban.com www1.mmban.com;
}
```

**通配符匹配：**

```nginx
server {
    server_name  *.mmban.com;
}
```

**通配符结束匹配：**

```nginx
server{
    server_name vod.*;
}
```

**正则匹配：**

```nginx
server{
    server_name ~^[0-9]+\.mmban\.com$;
}
```

### Localtion匹配规则

1. `/` 通用匹配，任何请求都会匹配到
2. `=` 精准匹配，不是以指定模式开头
3. `~` 正则匹配，区分大小写
4. `~*` 正则匹配，不区分大小写
5. `^~` 非正则匹配，匹配以指定模式开头的location

```nginx
server {
    location / { 
        root   html/test; 
        index  index.html index.htm;
    } 
}
```

**location匹配顺序**

- 多个正则location直接按书写顺序匹配，成功后就不会继续往后面匹配

- 普通（非正则）location会一直往下，直到找到匹配度最高的（最大前缀匹配）

- 当普通location与正则location同时存在，如果正则匹配成功,则不会再执行普通匹配

- 所有类型location存在时，`“=”匹配 > “^~”匹配 > 正则匹配 > 普通`（最大前缀匹配）

## 反向代理与负载均衡

**反向代理**：这种代理方式叫做，隧道代理。有性能瓶颈，因为所有的数据都经过Nginx，所以Nginx服务器的性能至关重要

![image-20220502173846436](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181505996.png)

**负载均衡**：把请求，按照一定算法规则，分配给多台业务服务器（即使其中一个坏了/维护升级，还有其他服务器可以继续提供服务）

![image-20220502174023144](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181506275.png)

### L4/L7负载均衡

**L4负载均衡**

在传输层（第四层）上工作的。它基于 IP 地址和端口号来进行负载均衡，不考虑传输的具体内容，仅通过查看传入数据包的目标 IP 地址和端口号，并根据预定义的规则将其转发到后端服务器上。

四层负载均衡器的主要优点是性能高，因为它只关注传输层的信息，不需要解析应用层协议的数据。常见的四层负载均衡器：

- F5硬负载均衡（硬件，价格昂贵）
- LVS四层负载均衡
- Haproxy四层负载均衡
- Nginx四层负载均衡（Nginx 1.9版本后才支持，用得少Nginx一般用做七层负载均衡）

**L7负载均衡**

在应用层（第七层）上工作的。它不仅考虑了传输层的信息（如 IP 地址和端口号），还分析了传输的应用层数据，例如 HTTP 请求的 URL、Cookie、报头等信息。基于这些信息，七层负载均衡器可以做出更精细的决策，并根据具体的应用需求将流量分发到不同的后端服务器上。

七层负载均衡器在传输层和应用层之间工作，因此它比四层负载均衡器更智能，可以实现更复杂的负载均衡策略。常见的七层负载均衡器：

- Nginx七层负载均衡
- Haproxy七层负载均衡
- apache七层负载均衡（并发到达百万级别，性能会大幅下降）

### DNS地域负载均衡

用户请求`www.imooc.com`，DNS根据用户地域返回不同机房的IP地址

![image-20240214134149333](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181510906.png)

### Nginx负载均衡

#### 负载均衡配置

**反向代理单个服务器**

启用proxy_pass，root和index字段就会失效

配置单个则proxy_pass后的地址必须写完整 `http://xxx `、`https://xxx`

注意：目标服务器如果是https的，需要特殊配置

当请求命中了这条规则，会被转发到目标服务器地址

```nginx
http{ 		
    server {
        listen       80;
        server_name  localhost;
        location / { 
            proxy_pass http://xxx; # 参数是 http://server_name
            #proxy_pass http://www.baidu.com #当访问localhost:80的时候就会反向代理跳转到到百度的网址
        }
    }
}

# 路径 + 参数会被一起转发
# 假设Nginx本地机器的地址为：http://www.xxx.com
# 请求 http://www.xxx.com/test?a=1
# 则会反向代理到 proxy_pass地址/test?a=1
```

重写需求：例如只有api前缀的才转发到后台服务器，但是接口并不包含api路径

```nginx
location / { 
   rewrite ^/api/(.*)  $1 
   proxy_pass http://xxx; # 参数是 http://server_name
}

# 请求 http://www.xxx.com/api/test?a=1
# 正则匹配将api给重写了 proxy_pass地址/test?a=1
```

**反向代理集群**

上面Nginx接到请求后，会转发到一个目标地址。可以设置多个，实现负载集群

请求会代理到`192.168.116.34:80`和`192.168.116.35:80`这两个服务

每次访问随机分配到两个地址（后面讲到，因为默认权重相等）

这两个ip为自己本地nginx服务器，用于测试nginx负载集群负载均衡

```nginx
http{
    # upstream 用于定义一组可用于负载均衡的后端服务器。这允许 Nginx 作为反向代理将请求分发给多个后端服务器，以提高性能和可用性。
	upstream test_server{ # 参数是server_name
		server 192.168.116.33:80; #如果是80端口，可以省略不写
		server 192.168.116.34:80;
	}
	server {
        listen       80;
        server_name  localhost;
        location / { 
            proxy_pass http://test_server;
        }
    }
}
```

#### 负载均衡策略

1. **设置权重**

多个请求，Nginx会根据权重分配

```nginx
upstream test_server{ 
    server 192.168.116.33:80 weight 10;
    server 192.168.116.34:80 weight 10;
}
```

2. **关闭，暂停服务**

为什么使用down关闭，而不是直接删除？请看ip_hash部分

```nginx
upstream test_server{ 
    server 192.168.116.33:80 weight down;
    server 192.168.116.34:80 weight ;
}
```

3. **慢启动**

注意：商业版才有这个配置

```nginx
upstream test_server{
    # Nginx会在60的时间内，慢慢分配流量从0到正常值
    server 192.168.116.33:80 slow_start=60s;
    server 192.168.116.34:80;
}
```

4. **备用机**

backup的这个机器正常是不会被访问到，如果`192.168.116.33:80`出现故障，无法提供服务，才会自动启用

```nginx
upstream test_server{
    server 192.168.116.33:80;
    server 192.168.116.34:80 backup;
}
```

5. **失败重试**

```nginx
upstream test_server{
    # 失败次数超过max_fail后，Nginx在fail_timeout时间内将不会转发任何请求给这个服务，超过fail_timeout后会在尝试一次。成功则恢复转发，否则仍然等待fail_timeout时间，之后再次尝试
    server 192.168.116.33:80 max_fail=2 fail_timeout=10s;
    server 192.168.116.34:80;
}
```

#### 负载均衡算法

1. **ip_hash**

对用户的ip进行计算：`Hash(IP)%upstream_node_count`，返回要使用机器的索引

每一个用户会固定分配到一台机器，防止在A机器上创建Session的用户，后续被分配到其他机器，导致Session失效

开启ip_hash后，如果想要移除一台server，必须使用down配置。如果直接删除，会导致upstream_node_count变化，使得所有用户访问的访问的机器发生变化

缺点：

- 增加服务节点会导致upstream_node_count变化，进而导致所有用户访问的机器变化
- 某个用户短时间发起大量请求，会打到一台固定的机器，导致这台机器性能大幅下降，而其他机器可能还是空闲，会发生服务倾斜

```nginx
upstream test_server{
    # 开启ip_hash，
    ip_hash;
    server 192.168.116.33:80;
    server 192.168.116.34:80;
}
```

2. **一致性哈希算法（Consistent Hashing）**

一致性哈希算法解决了使用ip_hash，在新增、删除服务节点时，所有用户访问节点发生变化的问题

hash函数返回值的范围是[0,2^32-1]

节点IP计算哈希，用户IP计算哈希，用户分配的节点是其右侧的第一个节点

增加、减少服务节点，只会影响一小部分用户，而不是全部

![image-20240214195506727](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181706707.png)

```nginx
# consistent不加使用的就是普通hash算法
upstream test_server{
    hash $request_uri consistent; # 基于请求的uri做一致性哈希
    hash $remote_addr consistent; # 基于请求的全部32为IPv4地址做一致性哈希（ip_hash只对IPv4的前24位做哈希）
    hash $cookie_xxx consistent; # 基于请求cookie中的xxx字段做一致性哈希
    
    server 192.168.116.33:80;
    server 192.168.116.34:80;
}
```

3. **least_conn**

尽可能将请求转发到当前连接数最少的后端服务器

```nginx
upstream test_server{
    least_conn;
    server 192.168.174.133:80;
    server 192.168.174.134:80;
}
```

下面例子，开启least_conn，Nginx会优先转发到Tomcat3

![image-20240214201248332](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181708876.png)

4. **url_hash**：据用户访问的url定向转发请求

5. **fair**：根据后端服务器响应时间转发请求

#### Nginx负载高可用方案

##### 背景

如下图，如果只有一个Nginx作为网关，一旦出现故障会导致全部服务不可用

![image-20240215121007981](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181712989.png)

高可用方案：

![image-20220503174125433](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181712688.png)

注意：Nginx主备机器配置要基本一致，如果配置相差较大，在切换时大量流量进入备用机，容易造成宕机

**VRRP协议**

keepalived是基于VRRP（Virtual Router Redundancy Protocol）协议的

VRRP可以将多个Nginx网关机器分为 master、backup两种类型，并生成一个Virtual IP（虚拟IP）

每台机器上的keepalived会相互通信，根据其他机器上的keepalived进程是否存在，判断服务器状态，如果默认的Master停止了，就会在剩下的Backup机器中，竞选出一台Nginx服务器作为Master

由Master服务器使用这个Virtual IP，用户访问时，访问的是Virtual IP

##### keepalived下载安装

源码安装[官网下载地址](https://www.keepalived.org/download.html)

```sh
# 解压到当前目录
tar -zxvf  keepalived-2.2.8.tar.gz
# 安装编译环境
yum install -y gcc openssl-devel libnl3 libnl3-devel
cd keepalived-2.2.8/
# 指定编译配置
# --prefix指定安装路径，
# --sysconf指定keepalived配置文件位置（必须指定为/etc目录，否则报错）
./configure --prefix=/usr/local/keepalived --sysconf=/etc 
# 安装
make && make install
# 配置文件在目录/etc/keepalived，新建或者把keepalived.conf.sample改成keepalived.conf文件
cd /etc/keepalived
mv keepalived.conf.sample keepalived.conf
```

**注册为系统服务**

```sh
#拷贝配置文件到/etc/keepalived目录下
cp /usr/local/keepalived/etc/keepalived/keepalived.conf /etc/keepalived/
#拷贝keepalived脚本到/etc/sysconfig/ 目录
cp /usr/local/keepalived/etc/sysconfig/keepalived /etc/sysconfig/
#建立软连接
ln -s /usr/local/keepalived/sbin/keepalived /sbin/
#添加到开机启动
chkconfig keepalived on
#查看服务状况
systemctl status keepalived

systemctl daemon-reload
systemctl start keepalived.service
```

如果提示报这个错，一般就是etc/keepalived目录下没有配置文件keepalived.conf

![image-20240218190011663](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181715665.png)

##### keepalived配置项

配置文件在`/etc/keepalived/keepalived.conf`

默认配置文件

```shell
! Configuration File for keepalived

global_defs {
   # 邮件通知地址列表，用于发送关于keepalived状态变化的通知
   notification_email {
     acassen@firewall.loc
     failover@firewall.loc
     sysadmin@firewall.loc
   }
   # 发件人邮件地址
   notification_email_from Alexandre.Cassen@firewall.loc
   # 指定用于发送邮件的SMTP服务器地址
   smtp_server 192.168.200.1
   # 设置连接SMTP服务器的超时时间（秒）
   smtp_connect_timeout 30
   # 为这个keepalived实例设置一个唯一标识符
   router_id LVS_DEVEL
   # vrrp配置，通常不太需要修改
   vrrp_skip_check_adv_addr
   vrrp_strict
   vrrp_garp_interval 0
   vrrp_gna_interval 0
}

# 定义一个VRRP实例，用于管理IP地址的冗余
vrrp_instance VI_1 {
    state MASTER # 初始状态设为MASTER
    interface eth0 # 使用的网络接口
    virtual_router_id 51 # 虚拟路由器的ID，需要在所有节点中唯一
    priority 100 # 节点的优先级，数字越大越可能成为MASTER
    advert_int 1 # VRRP广告间隔（秒）
    # 分组认证
    authentication {
        auth_type PASS # 认证类型
        auth_pass 1111 # 认证密码
    }
    virtual_ipaddress {
        192.168.116.16 # 虚拟IP地址列表
        192.168.116.17
        192.168.116.18
    }
}

# 定义一个虚拟服务器，处理指定端口的流量
virtual_server 192.168.200.100 443 {
    delay_loop 6 # 健康检查间隔（秒）
    lb_algo rr # 负载均衡算法，轮询（round-robin）
    lb_kind NAT # 负载均衡类型，网络地址转换（NAT）
    persistence_timeout 50 # 会话保持时间（秒）
    protocol TCP # 使用的协议

    # 定义一个真实服务器
    real_server 192.168.201.100 443 {
        weight 1 # 服务器权重
        SSL_GET {
            url {
              path / # 检查的路径
              digest ff20ad2481f97b1754ef3e12ecd3a9cc # 页面内容的摘要，用于验证页面正确性
            }
            url {
              path /mrtg/
              digest 9b3a0c85a887a256d6939da88aabd8cd
            }
            connect_timeout 3 # 连接超时时间（秒）
            retry 3 # 重试次数
            delay_before_retry 3 # 重试间隔（秒）
        }
    }
}

# 其他虚拟服务器和真实服务器的配置类似，设置了不同的检查路径和服务器
virtual_server 10.10.10.2 1358 {
    delay_loop 6
    lb_algo rr
    lb_kind NAT
    persistence_timeout 50
    protocol TCP

	# 指定备用服务器，当所有正常服务器都不可用时使用
    sorry_server 192.168.200.200 1358 

    # 定义多个真实服务器和健康检查配置
    real_server 192.168.200.2 1358 {
        weight 1 # 这个服务器的权重，用于负载均衡计算，权重越高分配的客户端越多
        HTTP_GET {
            # 定义健康检查使用的HTTP GET请求
            url {
              path /testurl/test.jsp # 检查的具体URL路径
              digest 640205b7b0fc66c1ea91c463fac6334d # 用于验证页面内容的MD5摘要
            }
            url {
              path /testurl2/test.jsp # 另一个URL路径
              digest 640205b7b0fc66c1ea91c463fac6334d # 相应的页面内容MD5摘要
            }
            url {
              path /testurl3/test.jsp # 第三个URL路径
              digest 640205b7b0fc66c1ea91c463fac6334d # 页面内容MD5摘要
            }
            connect_timeout 3 # 连接超时时间（秒）
            retry 3 # 如果健康检查失败，重试的次数
            delay_before_retry 3 # 重试之间的延迟时间（秒）
        }
    }
    real_server 192.168.200.3 1358 {
        weight 1 # 这个服务器的权重，用于负载均衡计算
        HTTP_GET {
            # 健康检查配置，类似上面的服务器
            url {
              path /testurl/test.jsp # 检查的URL路径
              digest 640205b7b0fc66c1ea91c463fac6334c # 页面内容的MD5摘要
            }
            url {
              path /testurl2/test.jsp # 第二个URL路径
              digest 640205b7b0fc66c1ea91c463fac6334c # 对应的MD5摘要
            }
            connect_timeout 3 # 连接超时时间（秒）
            retry 3 # 健康检查失败时的重试次数
            delay_before_retry 3 # 重试间的延迟时间（秒）
        }
    }
}

# 更多虚拟服务器和真实服务器配置...
```

- `authentication`、`virtual_router_id`、`virtual_ipaddress`这几个一样的机器，才算是同一个组里。这个组才会选出一个作为Master机器

##### 双机主备方案

这里我们设置两台机器，分别下载好keepalived，然后进行配置

机器一：

```shell
! Configuration File for keepalived

global_defs {
   router_id lb1 # 路由id，可以随意取，但是要保证每个配置了keepalive的机器不重复就行
}

# 节点名可以随意取，但要保证主、备节点之间保持一致即可
vrrp_instance testnginx {
		# 当前节点为Master，一个集群只能有一个Master，其他写BACKUP
    state MASTER 
    # ip addr查看下网卡名，替换ens33
    interface ens33 
    # 保证主、备节点之间保持一致即可
    virtual_router_id 51
    # 当前节点竞争成为Master的优先级
    priority 100 
    # 主、备节点之间同步检查的时间间隔（单位秒）
    advert_int 1 
    # 认证授权的密码，主、备节点之间秘密保持一致才能一起工作
    authentication {
        auth_type PASS # 指定了认证类型为密码（PASS）
        auth_pass 1111 # 设置了认证密码，这里设置的密码是"1111"
    }
    # 虚拟IP（Virtual IP）
    virtual_ipaddress {
        192.168.116.200
    }
}
```

机器二：

```sh
! Configuration File for keepalived

global_defs {
   router_id lb1 # 路由id，可以随意取，但是要保证每个配置了keepalive的机器不重复就行
}

# 节点名可以随意取，但要保证主、备节点之间保持一致即可
vrrp_instance testnginx {
	# 当前节点为Master，一个集群只能有一个Master，其他写BACKUP
    state BACKUP 
    # ip addr查看下网卡名，替换ens33
    interface ens33 
    # 保证主、备节点之间保持一致即可
    virtual_router_id 51
    # 当前节点竞争成为Master的优先级
    priority 50 
    # 主、备节点之间同步检查的时间间隔（单位秒）
    advert_int 1 
    # 认证授权的密码，主、备节点之间秘密保持一致才能一起工作
    authentication {
        auth_type PASS # 指定了认证类型为密码（PASS）
        auth_pass 1111 # 设置了认证密码，这里设置的密码是"1111"
    }
    # 虚拟IP（Virtual IP）
    virtual_ipaddress {
        192.168.116.200
    }
}
```

启动keepalived

```sh
# 启动
keepalived
# 判断是否成功启动
ps aux | grep keepalived
```

机器一：对比启动前、启动后，发现ens33网卡，多了一个ip地址，这个就是Virtual IP （ip addr命令）

![image-20240218141544435](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181719928.png)

![](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181719928.png)

关闭机器一的keepalived，就会发现Virtual IP切换到机器二了

```sh
kill -9 进程号 # ps aux|grep keepalived 即可获取进程号
# 如果注册为系统服务了,则可以通过系统服务关闭
systemctl stop keepalived.service
```

##### 双机热备方案

上面的配置，如果不出现故障的情况下，一直是机器一在工作，机器二白白浪费了

可以使用**双主热备**方案：

![image-20240224222229833](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181721843.png)

**DNS负载**

在腾讯云购买域名后，可以在**记录管理**中配置该域名解析到多个IP。这里需要解析到两个虚拟IP(需要是公网IP)

![](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181724929.png)

补充：表格字段含义

```
主机记录（Host Record）： 主机记录是指要解析的域名的一部分，通常是域名的前缀部分，例如www、mail等

记录类型（Record Type）： 记录类型指定了DNS记录的类型，用于指定DNS记录的用途和含义。常见的DNS记录类型包括：	
	A记录：将域名解析为IPv4地址
	AAAA记录：将域名解析为IPv6地址
	CNAME记录：将域名指向另一个域名（别名记录）
	MX记录：指定邮件交换服务器的地址
	TXT记录：存储文本信息等
	
记录值（Record Value）： 记录值是与主机记录关联的数据，具体取决于记录类型。例如，如果是A记录，则记录值是一个IPv4地址；如果是CNAME记录，则记录值是另一个域名
```

例子

虽然主机记录可以自定义，但是一般情况下，还是网址用www、邮箱用mail

```
主机记录：www
记录类型：A
记录值：192.0.2.1

用户访问www.example.com时，DNS服务器将返回IPv4地址192.0.2.1给用户

主机记录：site
记录类型：A
记录值：192.0.2.1

用户访问site.example.com时，DNS服务器将返回IPv4地址192.0.2.1给用户
```

在**负载均衡**中可以设置请求该域名后，按什么比例分配请求。下图中是**均等负载**，可以在**修改**中调整

![image-20240224222625793](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181725717.png)

**Nginx配置**

其实就是机器一有两个配置，机器二有两个配置，互相组成两个Virtual IP

机器一：

```sh
! Configuration File for keepalived

global_defs {
   router_id lb2 
}

# 虚拟IP：192.168.200.161
vrrp_instance hedaodao-1 {
    state MASTER 
    interface ens33 
    virtual_router_id 51
    priority 50
    advert_int 1 
    authentication {
        auth_type PASS
        auth_pass 1111
    }
    virtual_ipaddress {
        192.168.200.161 #虚拟IP
    }
}


# 虚拟IP：192.168.200.162
vrrp_instance hedaodao-2 {
    state BACKUP 
    interface ens33 
    virtual_router_id 52
    priority 50
    advert_int 1 
    authentication {
        auth_type PASS
        auth_pass 1111
    }
    virtual_ipaddress {
        192.168.200.162 #虚拟IP
    }
}
```

机器二：

```sh
hedaodao-1 这个配置
state:BACKUP
virtual_router_id:51

hedaodao-2 这个配置
state:MASTER
virtual_router_id:52
```

### LVS负载均衡

####  介绍

LVS的设置相对复杂，本章节仅仅是对其原理的了解

[官网](http://www.linuxvirtualserver.org/index.html)

LVS（Linux Virtual Server ), 目前已被集成到Linux内核的IPVS模块中，该模块会虚拟出一个Virtual IP（虚拟IP）

LVS属于四层负载均衡

如果LVS的分配的每个Server功能都是一致的，这些Server就是一个集群

![image-20240218224231326](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181728639.png)

与Nginx的区别

- LVS是属于四层负载均衡，只基于IP+端口做负载均衡。而Nginx还要做应用层的解析，相比之下LVS的并发性能更高（Nginx属于七层负载均衡）
- 流量非常大的时候，单台Nginx可能会承受不了压力。可以使用性能更高的LVS分配请求到Nginx集群
- Nginx接收请求来回，LVS可以只接收不响应，性能更高。如下图

![image-20240218225018030](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181728571.png)

- LVS会生成一个Virtual IP，用户请求这个Virtual IP，LVS会分配给集群中的机器处理

#### 三种模式

1. **NAT模式（网络地址转换）**

并发性能比后两种差

![image-20240218230320439](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181730224.png)

2. **TUN模式（隧道模式）**

每个Server必须有网卡，可以直接将请求结果，直接返回给用户

缺点是Server会暴露在公网中，DR模式解决了这个问题

![image-20240218225918879](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181730925.png)

3. **DR模式**（最佳模式）

Router持有一个Virtual IP，分发响应内容

![image-20240218230141389](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181731341.png)

```sh
systemctl stop NetworkManager
systemctl disable NetworkManager

# LVS配置
cd /etc/sysconfig/network-scripts/
cp ifcfg-ens33 ifcfg-ens33:1
vim ifcfg-ens33:1 
# 修改为静态IP
# DEVICE=ens33:1 //配置文件名保持一致
# IPADDR
# NETMASK
# NETWORK
service network restart 
yum install ipvsadm
ipvsadm -Ln

# Nginx 171 （手动增加Virtual IP）
cd /etc/sysconfig/network-scripts/
cp ifcfg-lo ifcfg-lo:1
vim ifcfg-lo:1 
# DEVICE=lo:1  # 配置文件名保持一致
# IPADDR=192.168.1.150 # Virtual IP
# NETMASK=255.255.255.255
# NETWORK=127.0.0.0
service network restart # ip addr，lo下面会多一个 inet 192.168.1.150
yum install ipvsadm
ipvsadm -Ln

# Nginx 172 （手动增加Virtual IP） 
# 与 171 流程一致
```

#### LVS高可用方案

在DR模式的基础上实现高可用，与Nginx一样也是采用keepalived实现

![image-20240225002754751](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181731469.png)

### Keepalived + LVS + Nginx

![image-20240225004546741](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181734692.png)

## Nginx缓存

![image-20240214202651085](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181734014.png)

### Nginx指定浏览器缓存（强缓存）

```nginx
http{
  server{
    listen       80;
    server_name  localhost;
    location /img{
      alias /home/images/;
      # 单位s m h d
      expires off; # 默认值，关闭缓存，即Nginx不返回Cache-Control。浏览器会使用协商缓存机制（其他expires的值都会让响应头返回Cache-Control字段，属于强缓存通知浏览器缓存方式）
      expires 20s;  # 失效时间，这里是前端缓存20s后失效 。浏览器截图如下
      expires @22h30m # 指定时间失效，这里是22点30分失效
      expires epoch; # 将响应的过期时间设置为 UNIX 时间戳的起始时间，这个配置通常用于确保浏览器不缓存特定的资源，以便及时获取更新的内容
      expires max; # 返回的max-age字段，设置为一个极大的值
    }
  }
}
```

![image-20240214211425750](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181736133.png)

关于强缓存的问题：强缓存只根据有效时间来判断是否重新请求数据，可能会导致客户端数据更新不及时（静态资源在有效期内被更新，前端不会重新请求）

打包工具每次buid都会给css、js文件名加一个哈希值，如果文件内容变化了，强缓存就会失效

但是对于html文件，文件名一直为index.html

解决方案：[前端静态资源更新不及时的解决方案](https://zhuanlan.zhihu.com/p/372497796?utm_id=0)

```nginx
location ~ \.(html)$ {  
    add_header Cache-Control no-cache;  
    # 协商缓存 no-cache  |   不缓存 no-store
}
```

### 上游服务缓存到Nginx

Nginx作为中间人，浏览器通过Nginx与业务服务器协商，Nginx会缓存协商结果

```nginx
http{
	# 设置缓存目录
	# keys_zone `内存`区域名称、大小，用于存储缓存键值对的元数据信息（名mycache，大小5m）
	# max_size  `磁盘`存储空间，如果超过，Nginx会按照LRU（最近最少使用）策略淘汰一些旧的缓存数据
	# inactive   超过inactive指定时间内，资源没有被访问，则自动清理缓存
	# use_temp_path off关闭临时目录
	proxy_cache_path /usr/local/nginx/upstream_cache keys_zone=mycache:5m max_size=1g inactive=30s use_temp_path=off;
	
	server{
		# 在server中指定使用缓存名
		proxy_cache mycache
		# 上游服务器，返回状态码200、304（协商缓存），8小时内如果有相同的请求，Nginx就直接返回缓存的响应内容，而不会向后端服务器发起请求
		proxy_cache_valid 200 304 8h
	}
}
```

### 补充

强缓存是服务端通过设置失效时间，强行控制浏览器缓存。一旦资源变化，不能即使更新

协商缓存是客户端发起资源请求，服务端对比上次资源的Etag、Last-modified，如果发生改变就返回最新的资源；如果未改变返回304，浏览器会直接采用本地缓存

## 动静分离

- 静 ：前端项目（静态资源）
- 动：接口服务

![image-20240518204626539](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405182046673.png)

例子：

用户访问网站的时候，会从tomcat中将静态文件一起从服务器中通过网络传输传输过来，由于tomcat性能略低与nginx，不如将静态文件直接放在nginx，在nginx.conf配置静态文件的访问路径直接通过nginx直接返回给静态文件给用户

在nginx的html目录下存放服务的静态文件（css,js,image）

![image-20240518204934420](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405182049131.png)

```nginx
server {
    listen       80;
    server_name  localhost;
    
    location / {
         # 进行反向代理
         proxy_pass http://192.168.116.34:8080/dida/;
    }

    # 访问代理的网站的时候进行正则表达式匹配静态文件的路径，直接通过nginx传输静态文件
    location ~*/(js|css|image) {
         root   html;
         index  index.html index.htm;
    }

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   html;
    }
}
```

## URLRewrite

rewrite需要写正则比较复杂，所以目前使用return的比较多

**return**

把Http重定向为Https

```nginx
server {
    listen       80;
    server_name  www.baidu.com;

    location / { 
        return 302 https://www.baidu.com$request_uri 
        # 302是状态码
        # $request_uri是路径和参数 ，例如：/xxx/xx?xx=xx
    }
}
```

**rewrite**

```nginx
server {
    listen       80;
    server_name  www.baidu.com;

    location / { 
       # 使用正则匹配 数字.html 就会重定向到index.html，并将该数字作为pageNum参数传递
       rewrite ^/([0-9]+).html$  /index.html?pageNum=$1 break;
       proxy_pass http://192.168.116.34:8080/dida/;
    }
}
```

```sh
rewrite是URL重写的关键指令，根据regex（正则表达式）部分内容，重定向到replacement，结尼是flag标记。

rewrite    <regex>   <replacement>  [flag];
关键字		 正则	     替代内容     	  flagt标记

正则：正则表达式语句进行规则匹配
替代内容：将正则匹配的内容替换成replacement

flag标记说明：
last  #本条规则匹配完成后，继续向下匹配新的1ocation URI规则
break #本条规则匹配完成即终止，不再匹配后面的任何规则
redirect #返回302临重定向，游览器地址会显示跳转后的URL地址
permanent #返回301永久重定向，测览器地址栏会显示跳转后的URL地址
```

## Nginx网关服务器

![image-20220503121135171](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405181457998.png)

企业中，无论是前端页面、静态资源、接口，都是通过Nginx进行访问（使用proxy_pass），这时候这台Nginx服务器就成为了网关服务器（承担入口的功能）

### 应用服务器设置

所以，我们启动应用服务器的防火墙，设置其只能接受这台Nginx服务器的请求

**添加rich规则**，指定端口和ip访问

```sh
firewall-cmd --permanent --add-rich-rule="rule family="ipv4" source address="192.168.116.33" port protocol="tcp" port="8080" accept" 
#这里的192.168.174.135是网关 服务器地址
```

**移除rich规则**

```sh
firewall-cmd --permanent --remove-rich-rule="rule family="ipv4" source address="192.168.116.33" port port="8080" protocol="tcp" accept"
```

重启，移除和添加规则都要重启才能生效

```sh
firewall-cmd --reload
```

**查看所有规则**

```sh
firewall-cmd --list-all #所有开启的规则
```

**配置负载均衡和URLRewrite同时实现**

```nginx
upstream test_server{ # 参数是server_name
    server 192.168.116.35=8 weight=5 down; #如果是80端口，可以省略不写
    server 192.168.116.34:8080/dida weight=1 backup;
}
server {
	listen       80;
    server_name  localhost;

    location / {
        # 进行重写URL
        rewrite ^/([0-9]+).html$	/index.html?pageNum=$1 break;
        proxy_pass http://test_server;
        #root   html;
        #index  index.html index.htm;
    }

    location ~*/(js|css|image) {
         root   html;
         index  index.html index.htm;
    }

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   html;
    }
}
```

### 浏览器跨域

浏览器中网页地址与请求地址不同域，会出现跨域问题

Nginx作为网关，外部所有请求都通过Nginx服务器转发到内部

通常后端接口，可以在响应头中增加 `Access-Control-Allow-Origin`字段，并将值设置为前端域名，解决跨域问题。但是静态资源出现跨域就必须在Nginx中配置了

```nginx
server {
    listen       80;
    server_name  localhost;

    # 为当前的server配置跨域配置
    # 允许跨域的请求，*表示所有
    add_header 'Access-Control-Allow-Origin' *;

    # 允许携带cookie请求
    add_header 'Access-Control-Allow-Credentials' 'true';

    # 允许跨域请求的方法：GET,POST,OPTIONS,PUT
    add_header 'Access-Control-Allow-Methods' 'GET,POST,OPTIONS,PUT';

    # 允许请求时携带的头部信息，*表示所有
    add_header 'Access-Control-Allow-Headers' *;

    # 允许发送按段获取资源的请求
    add_header 'Access-Control-Expose-Headers' 'Content-Length,Content-Range';

    location /fpath {
        root   /home;
        index  index.html;
        # post请求如果出现跨域，必须放在这具体请求的路径里面才行
        # 在发送Post跨域请求前，会以Options方式发送预检请求，服务器接受时才会正式请求
       if ($request_method = 'OPTIONS') { # nginx配置中=表示比较，不是赋值
         add_header 'Access-Control-Max-Age' 1728000;
         add_header 'Content-Type' 'text/plain; charset=utf-8';
         add_header 'Content-Length' 0;
         # 对于Options方式的请求返回204，表示接受跨域请求
         return 204;
        }
    }
}
```

## 防盗链

当我们请求到一个页面后，这个页面一般会再去请求其中的静态资源，这时候请求头中，会有一个refer字段，表示当前这个请求的来源，我们可以限制指定来源的请求才返回，否则就不返回，这样可以节省资源

![image-20220503162830153](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405182303979.png)

```sh
valid_referers none | blocked | server_names
```

设置有效的refer值

- **none**：检测 Referer头域不存在的情况，意味着没有Referer信息的请求将会被接受
- **server_name**：校验`Referer `地址是否为`server_name`（`server_name`可以使用通配符），请求头中`Referer`中为`server_name`会被接受

- **blocked**：如果请求的`Referer`既不是空的，也不是来自于`server_name`的域名，那么这个请求将被阻止。

例子：这里设置nginx服务器中的img目录下的图片`Referer `必须为http:192.168.116.33才能访问

```nginx
server {
    listen       80;
    server_name  localhost;

    location /img{
        # valid_referers none *.xxx.com blocked;
        # none: 表示可以直接通过图片地址访问图片，不携带Referer
        # 
        valid_referers 192.168.116.33
        # 注意：if后有个空格，不写就会报错
        if ($invalid_referer){#无效的
            return 403; #返回状态码403
        }
        root html;
        index  index.html index.htm;
    }
}
```

如果引用这张图片的页面且refer并没有被设置，图片无法加载出来

如果直接访问图片地址，因为没有refer字段指向来源，会直接显示Nginx的页面

![image-20220503153401325](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405182319964.png)

**设置盗链图片**

将提示图片放在html/img/x.png，访问设置防盗链图片时，就返回这x.png张图

```nginx
location /img{
    valid_referers http:192.168.174/133;
    if ($invalid_referer){ #无效的
        # 进行重写，将没有refer的图片重写返回img下的x.png 
        rewrite ^/  /img/x.png break;
    }
    root html;
    index  index.html index.htm;
}
```

## 日志切割

Nginx长期运行会产生大量日志，如果不开启日志切割，出现问题很难通过日志排查

```nginx
# 默认的日志路径
# 错误日志地址：--eror-log-path=/var/log/nginx/error.log
# 请求日志地址：--http-log-path=/var/log/nginx/access.log（每一个请求就记录一个日志）
```

需要借助crontabs设置定时任务

安装 crontabs

```shell
yum install crontabs
```

设置定时任务

```sh
crontabs -l # 查看全部定时任务
crontabs -e # 添加定时任务（打开一个文件）
```

添加任务

`cut_log.sh`自己写的切割脚本

```nginx
# 每隔1分钟执行一次
* */1 * * *  /usr/local/nginx/sbin/cut_log.sh 
# * * * * * command，分别表示分钟、小时、日期、月份、星期几，后面是要执行的命令
# /1 表示每隔一个单位执行,即每小时执行一次
```

```shell
#!/bin/bash
LOG_PATH="/usr/local/nginx/logs"
RECORD_TIME=${date -d "yesterday" +%Y-%m-%d+%H:%M}
PID=/usr/local/nginx/logs/nginx.pid
mv ${LOG_PATH}/access.log ${LOG_PATH}/access.${RECORD_TIME}.log
mv ${LOG_PATH}/error.log ${LOG_PATH}/error.${RECORD_TIME}.log
# 向Nginx主进程发送信号，用于重新打开日志文件
kill -USR1 `cat $PID`
```

重启crontabs

```sh
service cornd restart
```

## 目录浏览

类似https://mirrors.aliyun.com/centos/?spm=a2c6h.13651104.d-2001.7.168c320cQeQxjL的功能

![image-20240519154058078](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191541818.png)

```nginx
http{ 		
    server {
        listen       80;
        server_name  www.hedaodao.com

        # ！！！注意：root目录下不能有index.html文件，否则不生效
        autoindex on # 开启模块浏览(只能在root目录下浏览)
        autoindex_exact_size off # 显示文件大小时，是否带单位（默认并不带，off带单位）

        location / { 
            root /web
        } 
    }
}
```

## HTTP证书配置

### HTTP与HTTPS

[HTTPS](https://www.cloudflare.com/learning/ssl/what-is-https/) 是支持[加密](https://www.cloudflare.com/learning/ssl/what-is-encryption/)和验证的 [HTTP](https://www.cloudflare.com/learning/ddos/glossary/hypertext-transfer-protocol-http/)。两种协议的唯一区别是HTTPS 使用 [TLS](https://www.cloudflare.com/learning/ssl/transport-layer-security-tls/) ([SSL](https://www.cloudflare.com/learning/ssl/what-is-ssl/)) 来加密普通的 HTTP 请求和响应，并对这些请求和响应进行数字签名。因此，HTTPS 比 HTTP 安全得多。使用 HTTP 的网站的 URL 中带有 http://，而使用 HTTPS 的网站则带有 https://。

![http-vs-https](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191620684.png)

#### 不安全的HTTP

HTTP协议没有任何的[加密](https://so.csdn.net/so/search?q=加密&spm=1001.2101.3001.7020)以及身份验证的机制，非常容易遭到窃听、劫持、篡改等。不安全的原因主要包含以下三个方面：

- 通信使用明文，内容可能被窃听。
- 不验证通信方的身份，因此有可能遭到伪装。
- 无法验证报文的完整性，所以有可能被篡改。

传统的HTTP请求过程都是明文传输的，所谓的明文指的是没有经过加密的信息，如果HTTP请求和响应被黑客拦截，并且里面含有密码等敏感数据的话，会非常危险。

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191618553.png)

说明：由于HTTP本身不具备加密的功能，所以也无法做到对通信整体进行加密，HTTP报文使用明文方式发送。

#### 安全的HTTPS

为了解决这个问题，Netscape 公司制定了HTTPS协议，HTTPS可以将数据加密传输，也就是传输的是密文，即便黑客在传输过程中拦截到数据也无法破译，这就保证了网络通信的安全。**HTTPS就是 披着 TLS/SSL 的HTTP。**

**加密算法：**

- 明文： 明文指的是未被加密过的原始数据。
- 密文：明文被某种加密算法加密之后，会变成密文，从而确保原始数据的安全。密文也可以被解密，得到原始的明文。
- 密钥：密钥是一种参数，它是在明文转换为密文或将密文转换为明文的算法中输入的参数。密钥分为对称密钥与非对称密钥，分别应用在对称加密和非对称加密上。

**对称加密：**

对称加密又叫做私钥加密，即信息的发送方和接收方使用同一个密钥去加密和解密数据。对称加密的特点是算法公开、加密和解密速度快，适合于对大数据量进行加密，常见的对称加密算法有DES、3DES、TDEA、Blowfish、RC5和IDEA。

- 其加密过程如下：明文 + 加密算法 + 私钥 => 密文

- 解密过程如下： 密文 + 解密算法 + 私钥 => 明文

对称加密中用到的密钥叫做私钥，私钥表示个人私有的密钥，即该密钥不能被泄露。其加密过程中的私钥与解密过程中用到的私钥是同一个密钥，这也是称加密之所以称之为“对称”的原因。由于对称加密的算法是公开的，所以一旦私钥被泄露，那么密文就很容易被破解，所以对称加密的缺点是密钥安全管理困难。

**非对称加密：**

非对称加密也叫做公钥加密。非对称加密与对称加密相比，其安全性更好。对称加密的通信双方使用相同的密钥，如果一方的密钥遭泄露，那么整个通信就会被破解。而非对称加密使用一对密钥，即公钥和私钥，且二者成对出现。私钥被自己保存，不能对外泄露。公钥指的是公共的密钥，任何人都可以获得该密钥。用公钥或私钥中的任何一个进行加密，用另一个进行解密。

- 被公钥加密过的密文只能被私钥解密，过程如下：
  明文 + 加密算法 + 公钥 => 密文， 密文 + 解密算法 + 私钥 => 明文
- 被私钥加密过的密文只能被公钥解密，过程如下：
  明文 + 加密算法 + 私钥 => 密文， 密文 + 解密算法 + 公钥 => 明文

由于加密和解密使用了两个不同的密钥，这就是非对称加密“非对称”的原因。
非对称加密的缺点是加密和解密花费时间长、速度慢，只适合对少量数据进行加密。
在非对称加密中使用的主要算法有：RSA、Elgamal、Rabin、D-H、ECC（椭圆曲线加密算法）等。

![37c2323ffcf676f98b738dcbfb137b5](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191624338.png)

**后续的问题**

- 怎样保证公开密钥的有效性 
  - 你也许会想到，怎么保证客户端收到的公开密钥是合法的，不是伪造的，证书很好的完成了这个任务。证书由权威的第三方机构颁发，并且对公开密钥做了签名。
- https的缺点 
  - https保证了通信的安全，但带来了加密解密消耗计算机cpu资源的问题 ，不过，有专门的https加解密硬件服务器

#### CA机构

**什么是证书？**

它是用来证明某某东西确实是某某东西的东西（是不是像绕口令？）。通俗地说，证书就好比例子里面的公章。通过公章，可以证明该介绍信确实是对应的公司发出的。

理论上，人人都可以找个证书工具，自己做一个证书。那如何防止坏人自己制作证书出来骗人捏？请看后续 CA 的介绍。

**什么是CA？**

CA是Certificate Authority的缩写，也叫“证书授权中心”。

它是负责管理和签发证书的第三方机构，就好比例子里面的中介——C 公司。一般来说，CA必须是所有行业和所有公众都信任的、认可的。因此它必须具有足够的权威性。就好比A、B两公司都必须信任C公司，才会找 C 公司作为公章的中介。

**什么是CA证书？**

CA 证书，顾名思义，就是CA颁发的证书。

前面已经说了，人人都可以找工具制作证书。但是你一个小破孩制作出来的证书是没啥用处的。因为你不是权威的CA机关，你自己搞的证书不具有权威性。

这就好比某个坏人自己刻了一个公章，盖到介绍信上。但是别人一看，不是受信任的中介公司的公章，就不予理睬。坏蛋的阴谋就不能得逞啦。

![image-20240519170958910](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191725696.png)

**https连接过程**

服务器端需要认证的通信过程

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191731775.png)

总结：

1. 服务器向CA机构获取证书（假设这个证书伪造不了），当浏览器首次请求服务器的时候，服务器返回证书给浏览器。（证书包含：公钥+申请者与颁发者的相关信息+签名）

2. 浏览器得到证书后，开始验证证书的相关信息，证书有效（没过期等）。（验证过程，比较复杂，详见上文）。

3. 验证完证书后，如果证书有效，客户端是生成一个随机数，然后用证书中的公钥进行加密，加密后，发送给服务器，服务器用私钥进行解密，得到随机数。之后双方便开始用该随机数作为钥匙，对要传递的数据进行加密、解密。

### Nginx HTTP基本身份认证

在某些情况下，我们希望对服务器上的一些资源进行限制，例如服务器`/`路径下的所有资源，必须先进行身份验证然后才能访问资源。

对于这个需求我们可以通过 **HTTP Basic authentication** 协议来完成，Nginx使用`ngx_http_auth_basic_module`模块支持HTTP基本身份验证功能 。

**HTTP基本身份验证：**

`RFC 7235` 定义了一个HTTP身份验证框架，服务器可以用来针对客户端的请求发送`challenge`（质询信息），客户端则可以用来提供身份验证凭证。

质询与应答的工作流程如下：

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191743866.png)

身份验证框架中**最常用的HTTP认证方案是 "HTTP Basic authentication"**（RFC 7617）。 该方案中规定使用"用户的ID/密码"作为凭证信息，并且使用 `base64`算法进行编码。

由于用户 ID 与密码是是以明文的形式在网络中进行传输的（`base64` 可逆），所以基本验证方案并不安全，建议配合 `HTTPS`协议使用。

**配置步骤：**

1. 配置nginx

```nginx
cat /usr/local/nginx/conf/nginx.conf

http{ 		
    server {
        listen       80;
        server_name  www.demo.com;

    	location / { 
            root   html/test; 
            index  index.html index.htm;
            # 浏览器Http认证弹窗，提示的内容（很多浏览器都不再显示这个字段了）
            auth_basic "authentication"
            # 开启Http认证（路径为新建的那个文件）
            # 使用 auth_basic_user_file 指令, 指定帐密文件位置。
            auth_basic_user_file /etc/nginx/htpasswd
        } 
    }
}
```

**创建htppasswd帐密文件：**

格式每行一个账户：

```用户名:密码
用户名:密码
用户名:密码
```

可以使用 `Apache` 的 `htpasswd`命令创建的密码文件：

```sh
# 文件名为 htpasswd、帐号为 admin、密码为 admin.pass
htpasswd -bdc htpasswd 用户名 密码
```

如果没有 `htpasswd`命令，也可以使用 `openssl passwd` 命令代替：

```sh
echo  -n 'admin:' >> htpasswd
openssl passwd -apr1 admin.pass >> /etc/nginx/htpasswd
```

也可以通过在工具生成：https://tools.wujingquan.com/htpasswd/

重启nginx服务

```sh
nginx -t && nginx reload
```

**验证：**

访问`Nginx`，弹出认证：

![image-20240519175401185](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405191754148.png)

### 在线证书申请

**流程：**

1. 购买服务器
2. 购买域名，并解析到这个主机
3. 购买证书，绑定到域名上，并且把证书文件安装到服务器，并在Nginx上配置好
4. 这样就可以直接访问域名访问了

申请SSL证书，在阿里云中申请一个免费的SSL证书

**下载证书文件**

![image-20240519202858779](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405192029778.png)

下载后，解压，有两个文件 `xxx.key` (私钥) 和 `xxx.pem`（证书）

![image-20240519203117174](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405192031702.png)

**ssl模块**

ssl配置依赖于[ngx_http_ssl_module](https://nginx.org/en/docs/http/ngx_http_ssl_module.html)模块

```sh
# 查看是否有 --with-http_ssl_module 表示
./nginx -V
```

没有需要重新编译安装

```sh
./configure --prefix=/usr/local/nginx --with-http_ssl_module # 指定编译选项
make # 编译
make install # 安装编译结果--with-http_ssl_module
```

**配置**

将两个文件上传到Nginx目录中，记住放置的位置。

我这里直接放在nginx.conf配置文件所在的目录（`/usr/local/nginx/conf`），所以写的都是相对路径

注意：ssl配置可以放在http模块（所有server都开启ssl）、server模块（当前server开启）

```nginx
http{
	server {
		listen 443 ssl;
		server_name www.demo.com;
	
	    # 这里是证书路径
		ss1_certificate  xxx.pem; 
		# 这里是私钥路径
		ss1_certificate_key  xxx.key  
		# 配置完后，访问域名就可以使用https了
		location / {
		   # xxx
		}
	}
	
	# 如果通过http访问，重定向到https
	server {
		listen 80;
		server_name localhost;
		
		location / {
           #$request_uri是路径+参数，例如：/xxx/xx?xx=xx
		   return https://$server_name.com$request_uri
		}
	}
}
```

# Nginx高级

## 扩容

1. 单机垂直扩容：硬件资源增加
2. 水平扩展：集群化
3. 细粒度拆分：分布式
   1. 数据分区
   2. 上有服务SOA化（原生支持水平/垂直扩容）
   3. 入口细分
      1. 浏览器
      2. 移动端原生App（物联网）
      3. H5内嵌式应用

4. 数据异构化
   1. 多级缓存
      1. 客户端缓存
      2. CDN缓存
      3. 异地多活
      4. Nginx缓存
5. 服务异步化
   1. 拆分请求
   2. 消息中间件

扩容原则

1. 无状态原则
2. 弹性原则

### 单机垂直扩容：硬件资源增加

- 云服务器资源增加
- 整机：IBM、浪潮、DELL、HP等
- CPU/主机：更新到主流
- 网卡：10G/40G网卡
- 磁盘：SAS（SCSI）HDD（机械）、HHD（混合）、 STAT SSD、PCI-e SSD、MVMe SSD
- MVMe SSD
  - SSD
    - 多副本机制
    - 系统盘/热点数据/数据库存储
  - HDD
    - 冷数据存储

### 水平扩展：集群化

#### 会话管理

##### Nginx高级负载均衡

1. `ip_hash、`

2. 其他Hash

   - hash：`$cookie_jessionid`

   - hash：`$request_uri`

3. 使用lua逻辑定向分发

4. Redis + SpringSession

**ip_hash维持会话特点以及配置**

同一个ip永远会被分配到同一个Server上，主要用来解决Session不一致的问题，但该策略也有弊端，weight权重无效，所以该方案会导致某个Server压力可能过大，请求分配不均匀问题。

- 在nginx版本1.3.1之前，不能在ip_hash中使用权重（weight）。
- ip_hash不能与backup同时使用
- 此策略适合有状态服务，比如session。
- 当有服务器需要剔除，必须手动down掉。

```nginx
http {
    upstream myApiTest {
      ip_hash;   #开启ip_hash策略
      server localhost:9001;
      server localhost:9002;
    }
    server {
      listen        8080;
      server_name   localhost;    #监听地址
      location / {
        proxy_pass http://myApiTest;
      }
    }
}
```

**$cookie_jessionid**

根据服务器端下发的`jessionid`来确保会话的保持

服务器下发了 `cookie JSESSIONID` 并且多次请求这个都不会改变 因为nginx 根据 JSESSIONID 它进行hash 每次都负载到同一台后端服务器, 因为这个后端服务器已经存在了 这个session 所以不会再次创建

```nginx
http {
    upstream myApiTest {
    	# 指定hash 方式是 cookie_jessionid nginx自带的方式
    	hash $cookie_jsessionid;
      server localhost:9001;
      server localhost:9002;
    }
    server {
      listen        8080;
      server_name   localhost;    #监听地址
      location / {
        proxy_pass http://myApiTest;
      }
    }
}
```

![image-20240521143953738](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405211440041.png)

**$request_uri**

根据用户请求的地址进行hash，以此判断选择服务器进行会话

```nginx
http {
    upstream myApiTest {
    	# 指定hash 方式是 cookie_jessionid nginx自带的方式
    	hash $request_uri;
      server localhost:9001;
      server localhost:9002;
    }
    server {
      listen        8080;
      server_name   localhost;    #监听地址
      location / {
        proxy_pass http://myApiTest;
      }
    }
}
```

##### 使用sticky模块进行Nginx负载均衡

参考：http://nginx.org/en/docs/http/ngx_http_upstream_module.html#sticky

tengine中有session_sticky模块我们通过第三方的方式安装在开源版本中

sticky是第三方模块，需要重新编译Nginx，可以对Nginx这种静态文件服务器使用基于cookie的负载均衡

###### 下载模块

项目官网

https://bitbucket.org/nginx-goodies/nginx-sticky-module-ng/src/master/

另一个版本

https://github.com/bymaximus/nginx-sticky-module-ng

下载

```sh
# 进入模块下载的目录
cd /usr/local/
# 使用wget下载模块，也可以进行上传
wget https://bitbucket.org/nginx-goodies/nginx-sticky-module-ng/get/c78b7dd79d0d099e359c5c4394d13c9317b9348f.tar.gz
# 进行解压
tar -zxvf c78b7dd79d0d099e359c5c4394d13c9317b9348f.tar.gz
# 此时查看解压后的文件,就会出现 nginx-goodies-nginx-sticky-module-ng-c78b7dd79d0d
# 改个名称
mv nginx-goodies-nginx-sticky-module-ng-c78b7dd79d0d nginx-sticky
```

###### 编译安装

使用nginx安装包重新编译nginx

```sh
# 进入nginx安装包
cd /usr/local/nginx1.22.1/
# 进入源码目录后，进行重新编译到/usr/local/nginx
./configure --prefix=/usr/local/nginx --add-module=/usr/local/nginx-sticky
# 执行make
make
# 如果报错是缺少模块，则打开nginx-sticky中的ngx_http_sticky_misc.c文件
# 在文件宏定义下添加 
# #include <openssl/sha.h>
# #include <openssl/md5.h>
# 备份之前的可执行程序
mv /usr/local/nginx/sbin/nginx /usr/local/nginx/sbin/nginx.old
# 将编译好的nginx可执行程序替换到原来的可执行程序中
cp objs/nginx /usr/local/nginx/sbin/
# 进行升级检测
make upgrade
# 检查程序是否包含新模块
cd /usr/local/nginx/sbin/
./nginx -V
```

**nginx.conf 配置sticky**

```nginx
upstream httpget{ 
  # name:sticky的名称，expires:和过期时间
  sticky name=route expires=6h;
  server 192.168.116.36;
  server 192.168.116.37;
}
```

![image-20240521161838198](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202405211623399.png)

**工作原理**

1. 客户端首次发起访问请求，nginx接收后，发现请求头没有cookie，则以[轮询](https://so.csdn.net/so/search?q=轮询&spm=1001.2101.3001.7020)方式将请求分发给后端服务器。

2. 后端服务器处理完请求，将响应数据返回给nginx。

3. 此时nginx生成带route的cookie，返回给客户端。route的值与后端服务器对应，可能是明文，也可能是md5、[sha1](https://so.csdn.net/so/search?q=sha1&spm=1001.2101.3001.7020)等Hash值

4. 客户端接收请求，并保存带route的cookie。

5. 当客户端下一次发送请求时，会带上route，nginx根据接收到的cookie中的route值，转发给对应的后端服务器。

#### KeepAlive

客户端发起http请求前需要先与服务端建立[TCP连接](https://so.csdn.net/so/search?q=TCP连接&spm=1001.2101.3001.7020)，每次TCP连接都需要三次握手来确定，三次交互不仅会增加消费时间，还会增加网络流量。http请求是请求应答式，如果能知道每个请求头与响应体的长度，就可以在一个连接上执行多个请求，这个就是所谓的长连接。

keepalive是HTTP/1.1协议中的一个特性，它允许客户端和服务器之间的TCP连接在一个[HTTP请求](https://so.csdn.net/so/search?q=HTTP请求&spm=1001.2101.3001.7020)/响应周期结束后保持打开状态，以便在后续的请求中重复使用。这样可以减少TCP连接的建立和关闭次数，从而提高性能。

keepalive是tcp层长连接探活机制；keep-alive是应用层http协议使用，在其头部Connection字段中的一个值，只是代表客户端与服务之间需要保持长连接，可以理解为通过此字段来告诉nginx此连接需要维持长连接，处理完别直接关闭连接。

**应用场景**

1. 什么时候使用keepAlive

明显的预知用户会在当前连接上有下一步操作
复用连接，有效减少握手次数，尤其是https建立一次连接开销会更大

2. 什么时候不用？

访问内联资源一般用缓存，不需要keepalive，长时间的tcp连接容易导致系统资源无效占用

**支持keep alive长连接**

当使用nginx作为反向代理时，为了支持长连接，需要做到两点：

1. 从client到nginx的连接是长连接
2. 从nginx到server的连接是长连接

从HTTP协议的角度看，nginx在这个过程中，对于客户端它扮演着HTTP服务器端的角色。而对于真正的服务器端（在nginx的术语中称为upstream）nginx又扮演着HTTP客户端的角色。

##### 保持和Client的长连接

为了在client和nginx之间保持上连接，有两个要求：

1. client发送的HTTP请求要求keep alive
2. nginx设置上支持keep alive

**HTTP配置**

默认情况下，nginx已经自动开启了对client连接的keep alive支持。一般场景可以直接使用，但是对于一些比较特殊的场景，还是有必要调整个别参数。

需要修改nginx的配置文件(在nginx安装目录下的conf/nginx.conf)

```nginx
http {
  keepalive_timeout  120s 120s; #超过这个时间 没有活动，会让keepalive失效 
  keepalive_requests 10000; #一个tcp复用中 可以并发接收的请求个数
  keepalive_time 1h; #一个tcp连接总时长，超过之后 强制失效
  send_timeout: 60; # 默认60s，准备过程中若有耗时操作，超过 send_timeout 强制断开连接
}
```

- `keepalive_timeout`

```
Syntax:    keepalive_timeout timeout [header_timeout];
Default:    keepalive_timeout 75s;
Context:    http, server, location
```

第一个参数设置keep-alive客户端连接在服务器端保持开启的超时值。值为0会禁用keep-alive客户端连接。

第二个参数在响应的header域中设置一个值“Keep-Alive: timeout=time”。这两个参数可以不一样。

- `keepalive_request`

keepalive_requests指令用于设置一个keep-alive连接上可以服务的请求的最大数量。当最大请求数量达到时，连接被关闭。默认是100。

这个参数的真实含义，是指一个keep alive建立之后，nginx就会为这个连接设置一个计数器，记录这个keep alive的长连接上已经接收并处理的客户端请求的数量。如果达到这个参数设置的最大值时，则nginx会强行关闭这个长连接，逼迫客户端不得不重新建立新的长连接。

这个参数往往被大多数人忽略，因为大多数情况下当QPS(每秒请求数)不是很高时，默认值100凑合够用。但是，对于一些QPS比较高（比如超过10000QPS，甚至达到30000,50000甚至更高) 的场景，默认的100就显得太低。

简单计算一下，QPS=10000时，客户端每秒发送10000个请求(通常建立有多个长连接)，每个连接只能最多跑100次请求，意味着平均每秒钟就会有100个长连接因此被nginx关闭。同样意味着为了保持QPS，客户端不得不每秒中重新新建100个连接。因此，如果用netstat命令看客户端机器，就会发现有大量的TIME_WAIT的socket连接(即使此时keep alive已经在client和nginx之间生效)。

因此对于QPS较高的场景，非常有必要加大这个参数，以避免出现大量连接被生成再抛弃的情况，减少TIME_WAIT。

- `send_timeout`

用于设置发送响应数据的超时时间。如果在指定的时间内未能发送完整的响应数据，Nginx会中断连接并向客户端返回一个错误。这个指令通常用于控制Nginx服务器向客户端发送数据的响应时间。

- `keepalive_time`

用于设置客户端与服务器之间的连接保持时间。它定义了在没有活动数据交换时，Nginx服务器保持连接的时间。一旦超过这个时间，连接可能会被关闭。通过设置 `keepalive_timeout`，可以控制Nginx服务器保持连接的时间，以提高性能和资源利用率。

**保持和Server的长连接**

为了让nginx和server（nginx称为upstream）之间保持长连接，典型设置如下：

```nginx
http {
    upstream  BACKEND {
        server 127.0.0.1:8000;
        server 127.0.0.1:8001;
        server 127.0.0.1:8002;
        keepalive 300; # 空闲连接数   
        keepalive_timeout  120s; # 与上游空闲时间
        keepalive_requests 100; # 与上游请求处理最大次数
    }
    server{
        listen 8080;
        location /{
            proxy_pass http://BACKEND;
      			# 设置为 1.1 表示使用 HTTP/1.1 协议。HTTP/1.1 是目前广泛使用的 HTTP 协议版本，支持持久连接和管道化请求，能够提高网络性能和效率。
            proxy_http_version 1.1;
      			#  将 Connection 头部设置为空字符串，意味着告诉 Nginx 在转发请求时不要包含 Connection 头部。这样做的目的可能是为了避免代理服务器在转发请求时修改 Connection 头部，或者是为了遵循 HTTP/1.1 协议中的规范，其中 Connection 头部的取值可以影响持久连接的行为。
            proxy_set_header Connection "";
        }
    }
}
```

***upstream*** 中的配置

1. `keepalive`：限制nginx某个worker最多空闲连接数，此处不会限制worker与上游服务长连接的总数;
2. `keepalive_timeout`：nginx与上游长连接最大空闲时间，默认值为60s；
3. `keepalive_requests`：nginx与上游长连接最大交互请求的次数，默认值为100；

***server*** 中的配置

1. `proxy_http_version`：指定了向后端代理服务器发送请求时所使用的 HTTP 协议版本。
2. `proxy_set_header`：用于设置向后端代理服务器发送的 HTTP 头部信息。
