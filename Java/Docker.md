# Docker

## Docker简介

一款产品从开发到上线，从操作系统，到运行环境，再到应用配置。作为开发+运维之间的协作我们需要关心很多东西，这也是很多互联网公司都不得不面对的问题，特别是各种版本的迭代之后，不同版本环境的兼容，对运维人员都是考验 , 这个时候 docker 横空出世，是因为它对此给出了一个标准化的解决方案。 
环境配置如此麻烦，换一台机器，就要重来一次，费力费时。很多人想到，能不能从根本上解决问题，软件可以带环境安装？也就是说，安装的时候，把原始环境一模一样地复制过来。开发人员利用 docker 可以消除协作编码时“在我的机器上可正常工作”的问题。

![image-20230717092203083](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051704214.png)



* docker官网地址：https://www.docker.com/

![image-20230420092507794](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051704102.png)   

* docker 是一个开源的应用容器引擎，基于 Go 语言开发。docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。容器是完全使用沙箱机制，相互之间不会有任何接口（类似 iPhone 的 app）,更重要的是容器性能开销极低。
* docker的主要目标是“Build，Ship and Run Any App,Anywhere”，也就是通过对应用组件的封装、分发、部署、运行等生命周期的管理，使用户的APP（可以是一个WEB应用或数据库应用等等）及其运行环境能够做到“一次封装，到处运行”。
* 总之一句话：只需要一次配置好环境，换到别的机子上就可以一键部署好，大大简化了操作 

### docker的优势

docker的优势包括：

1、可移植性：docker容器可以在任何支持docker的环境中运行，包括本地开发环境、测试环境和生产环境，从而提高了应用程序的可移植性。

2、可伸缩性：docker容器可以根据负载的变化进行快速扩展和收缩，从而更好地满足应用程序的需求。

3、隔离性：docker容器提供了隔离的运行环境，从而使得不同容器中运行的应用程序互相隔离，避免了应用程序之间的干扰。



### 容器与虚拟机的区别

#### 容器发展简史

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404031507103.png)

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404031507034.png)

#### 传统虚拟机技术

虚拟机（virtual machine）就是带环境安装的一种解决方案。

它可以在一种操作系统里面运行另一种操作系统，比如在Windows10系统里面运行Linux系统CentOS7。应用程序对此毫无感知，因为虚拟机看上去跟真实系统一模一样，而对于底层系统来说，虚拟机就是一个普通文件，不需要了就删掉，对其他部分毫无影响。这类虚拟机完美的运行了另一套系统，能够使应用程序，操作系统和硬件三者之间的逻辑不变。 

| Win10 | VMWare | Centos7 | 各种cpu、内存网络额配置+各种软件 | 虚拟机实例 |
| ----- | ------ | ------- | -------------------------------- | -------- 

![image-20240403152957349](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404031530211.png)

虚拟机的缺点：

- 资源占用多

- 冗余步

- 骤多

- 启动慢

#### 容器虚拟化技术

由于前面虚拟机存在某些缺点，Linux发展出了另一种虚拟化技术：

Linux容器(Linux Containers，缩写为 LXC)

Linux容器是与系统其他部分隔离开的一系列进程，从另一个镜像运行，并由该镜像提供支持进程所需的全部文件。容器提供的镜像包含了应用的所有依赖项，因而在从开发到测试再到生产的整个过程中，它都具有可移植性和一致性。

Linux 容器不是模拟一个完整的操作系统而是对进程进行隔离。有了容器，就可以将软件运行所需的所有资源打包到一个隔离的容器中。容器与虚拟机不同，不需要捆绑一整套操作系统，只需要软件工作所需的库资源和设置。系统因此而变得高效轻量并保证部署在任何环境中的软件都能始终如一地运行。

#### 对比

![image-20240605173211555](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051732835.png)

**隔离性**：在于隔离性上面，由于vm对操作系统也进行了虚拟化，隔离的更加彻底。而docker共享宿主机的操作系统，隔离性较差。

**运行效率**：由于vm的隔离操作，导致生成虚拟机的速率大大低于容器docker生成的速度，因为docker直接利用宿主机的系统内核。它们的启动速度是在数量级上的差距。

**资源利用率**：在资源利用率上虚拟机由于隔离更彻底，因此利用率也会相对较低。

经典名句：虚拟机已死，容器才是未来

### docker架构

* docker是一个客户端-服务器（C/S）架构程序。docker客户端只需要向docker服务器或者守护进程发出请求，服务器或者守护进程将完成所有工作并返回结果。docker提供了一个命令行工具docker以及一整套RESTful API。你可以在同一台宿主机上运行docker守护进程和客户端，也可以从本地的docker客户端连接到运行在另一台宿主机上的远程docker守护进程。

* docker的架构图如下所示：

![image-20230717092740969](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051737900.png)  

![image-20230717092822959](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051737734.png)

### Registry（注册中心）

docker用Registry来保存用户构建的镜像。Registry分为公共和私有两种。docker公司运营公共的Registry叫做**docker Hub**。用户可以在Docker Hub注册账号，分享并保存自己的镜像（说明：在docker Hub下载镜像很慢，可以自己构建私有的Registry）。

访问docker Hub搜索Redis镜像

https://hub-stage.docker.com/

![image-20230420095756720](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051740367.png)  

一般都会选择官方的的子镜像仓库：

![image-20230420095905091](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051740928.png)  

在子镜像仓库中会存在很多的版本的镜像。

### docker的安装与卸载

* docker 从 17.03 版本之后分为 CE（Community Edition: 社区版） 和 EE（Enterprise Edition: 企业版），CE版本是免费的，EE版本是收费的。本次我们使用社区版。

docker的安装和卸载可以参考官方文档：https://docs.docker.com/engine/install/centos/

#### 卸载docker

```shell
sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
```

#### 安装docker

* 第一步 检查系统版本

  注意：这里建议安装在CentOS7.x以上的版本，在CentOS6.x的版本中，安装前需要安装其他很多的环境，而且Docker很多补丁不支持更新。

```shell
# 确定是CentOS7.x及其以上版本
cat /etc/redhat-release
```

* 第二步 检查环境，安装gcc和g++

```shell
yum -y install gcc
yum -y install gcc-c++
```

* 第三步 安装必要的一些系统工具

```shell
yum install -y yum-utils device-mapper-persistent-data lvm2
```

* 第四步 添加软件源信息（设置阿里云镜像地址，提高下载速度）

```shell
# 官网
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
#阿里云
yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```

* 第五步 更新yum软件包索引并安装Docker-CE

```shell
yum makecache fast

yum install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

### Docker的基本组成

#### 镜像(image)

Docker 镜像（Image）就是一个只读的模板。镜像可以用来创建 Docker 容器，一个镜像可以创建很多容器。

它也相当于是一个root文件系统。比如官方镜像 centos:7 就包含了完整的一套 centos:7 最小系统的 root 文件系统。

相当于容器的“源代码”，docker镜像文件类似于Java的类模板，而docker容器实例类似于java中new出来的实例对象。

#### 容器(container)

1. 从面向对象角度

Docker 利用容器（Container）独立运行的一个或一组应用，应用程序或服务运行在容器里面，容器就类似于一个虚拟化的运行环境，容器是用镜像创建的运行实例。就像是Java中的类和实例对象一样，镜像是静态的定义，容器是镜像运行时的实体。容器为镜像提供了一个标准的和隔离的运行环境，它可以被启动、开始、停止、删除。每个容器都是相互隔离的、保证安全的平台

2. 从镜像容器角度

*可以把容器看做是一个简易版的 Linux 环境*（包括root用户权限、进程空间、用户空间和网络空间等）和运行在其中的应用程序。

#### 仓库(repository)

仓库（Repository）是集中存放镜像文件的场所。

类似于

Maven仓库，存放各种jar包的地方；

github仓库，存放各种git项目的地方；

Docker公司提供的官方registry被称为Docker Hub，存放各种镜像模板的地方。

仓库分为公开仓库（Public）和私有仓库（Private）两种形式。

最大的公开仓库是 Docker Hub(https://hub.docker.com/)，

存放了数量庞大的镜像供用户下载。国内的公开仓库包括阿里云 、网易云等

#### 总结

需要正确的理解仓库/镜像/容器这几个概念:

Docker 本身是一个容器运行载体或称之为管理引擎。我们把应用程序和配置依赖打包好形成一个可交付的运行环境，这个打包好的运行环境就是image镜像文件。只有通过这个镜像文件才能生成Docker容器实例(类似Java中new出来一个对象)。

image文件可以看作是容器的模板。Docker 根据 image 文件生成容器的实例。同一个 image 文件，可以生成多个同时运行的容器实例。

- 镜像文件：image 文件生成的容器实例，本身也是一个文件，称为镜像文件。

- 容器实例：一个容器运行一种服务，当我们需要的时候，就可以通过docker客户端创建一个对应的运行实例，也就是我们的容器

- 仓库：就是放一堆镜像的地方，我们可以把镜像发布到仓库中，需要的时候再从仓库中拉下来就可以了。

### 配置镜像加速器

docker的使用过程中，需要从远程仓库下载镜像，但是默认为国外网站，所以在下载时可能会出现下载连接超时导致下载失败，因此需要为其配置镜像加速器，以提高下载速度。目前使用的镜像加速器有很多，比如阿里云，网易云等等。

1. 国内配置的镜像地址

```
1.Docker中国区官方镜像
https://registry.docker-cn.com

2.网易
http://hub-mirror.c.163.com
 
3.中国科技大学
https://docker.mirrors.ustc.edu.cn
```

2. 阿里云镜像地址

阿里云镜像加速器的使用步骤：

1、注册和登录

2、进入管理后台

3、搜索**容器镜像服务**

4、查看示例代码进行配置即可

https://promotion.aliyun.com/ntms/act/kubernetes.html

注册一个阿里云账户: 然后点击 控制台->镜像容器服务->获取加速器地址

![image-20240412161816510](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404121618970.png)

3. 配置过程

* 创建文件daemon.json

```shell
vim  /etc/docker/daemon.json
```

* 文件中添加如下内容

```json
// 在阿里云镜像加速器下面
{ 
  "registry-mirrors":["https://registry.docker-cn.com"] 
}
```

* 重启docker生效


```
systemctl restart docker 
systemctl daemon-realod
```

### 底层原理

- run的运行过程

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404121634642.png)

- 为什么Docker比虚拟机快

(1)docker有着比虚拟机更少的抽象层

  由于docker不需要Hypervisor(虚拟机)实现硬件资源虚拟化,运行在docker容器上的程序直接使用的都是实际物理机的硬件资源。因此在CPU、内存利用率上docker将会在效率上有明显优势。

(2)docker利用的是宿主机的内核,而不需要加载操作系统OS内核

  当新建一个容器时,docker不需要和虚拟机一样重新加载一个操作系统内核。进而避免引寻、加载操作系统内核返回等比较费时费资源的过程,当新建一个虚拟机时,虚拟机软件需要加载OS,返回新建过程是分钟级别的。而docker由于直接利用宿主机的操作系统,则省略了返回过程,因此新建一个docker容器只需要几秒钟。

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404121639848.png)

## Docker常用命令

### 帮助启动类命令

启动docker: `systemctl start docker`

停止docker: `systemctl stop docker`

重启docker: `systemctl restart docker`

查看docker状态: `systemctl status docker`

开机启动: `systemctl enable docker`

查看docker概要信息: `docker info`

查看docker总体帮助文档: `docker --help`

查看docker命令帮助文档: `docker 具体命令 --help`

### 镜像命令

- **`docker images`**
  - OPTIONS 说明:
    - -a: 列出本地所有的镜像(含历史映射层)
    - -q: 只显示镜像ID
  - 列出本地主机上的镜像
  - ![image-20240412173624542](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404121737474.png)
  
  - 各个选项说明:
  
    - REPOSITORY：表示镜像的仓库源 
  
    - TAG：镜像的标签版本号 
  
    - IMAGE ID：镜像ID 
  
    - CREATED：镜像创建时间 
  
    - SIZE：镜像大小
  
  - 同一仓库源可以有多个 TAG版本，代表这个仓库源的不同个版本，我们使用 REPOSITORY:TAG 来定义不同的镜像。
  
  - 如果你不指定一个镜像的版本标签，例如你只使用 ubuntu，docker 将默认使用 ubuntu:latest 镜像
  
- **`docker search`**

  - 查找某个镜像
  - `docker search [OPTIONS] 镜像名字`

  - OPTIONS说明:
    - --limit: 只列出N个镜像,默认25个
    - `docker search --limit 5 redis`
  - ![image-20240412174914009](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404121749463.png)

- **`docker pull`**
  - 下载镜像
  - `docker pull 镜像名字:TAG`
  - `docker pull 镜像名字`
    - 没有TAG就是最新版 laster

- **`docker system df`**
  - 查看镜像/容器/数据卷所占的空间

- **`docker rmi 镜像ID`**
  - 删除镜像
  - 删除单个
    - `docker rmi -f 镜像ID|镜像名称`
  - 删除多个
    - `docker rmi -f 镜像名1:TAG 镜像名2:TAG`
  - 删除全部
    - `docker rmi -f $(docker images -qa)`
- docker的虚悬镜像是什么
  - 仓库名、标签都是`<none>`的镜像，俗称虚悬镜像dangling image
  - ![image-20240412180653298](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404121806430.png)

### 容器命令

> 有镜像才可以创建容器

- **新建+启动容器**

  - `docker run [OPTIONS] IMAGE[COMMAND][ARG...]`

  - OPTIONS说明:
    - 有的是一个-号,有的是--号
    - --name="容器新名字"：为容器指定一个名称
    - -d：后台运行容器并返回容器ID，也即启动守护式容器（后台运行）
    - -i：以交互模式运行容器，通常与 -t 同时使用
    - -t：为容器重新分配一个伪输入终端，通常与-i 同时使用，也即启动交互式容器（前台有伪终端，等待交互）
    - -d：指定容器运行于前台还是后台，默认为false
    - -P：随机端口映射
    - -p：指定端口映射 8080:80
    
  - 启动交互式容器
    - `docker run -it ubuntu /bin/bash`
    - 相当于重新打开一个终端，进行运行另一个系统
    - ![image-20240412210956301](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404122110451.png)

  - 守护式容器

    - `docker run -d redis:6.0.8/bin/bash`

    - 我们希望 docker 的服务是在后台运行的,可以过 -d 指定容器的后台运行模式。

    - 很重要的要说明的一点: 

      有一些镜像，Docker容器后台运行,就必须有一个前台进程.

      容器运行的命令如果不是那些一直挂起的命令（比如运行top，tail），就是会自动退出的。

      这个是docker的机制问题,比如你的web容器,我们以nginx为例，正常情况下,

      我们配置启动服务只需要启动响应的service即可。例如service nginx start

      但是,这样做,nginx为后台进程模式运行,就导致docker前台没有运行的应用,

      这样的容器后台启动后,会立即自杀因为他觉得他没事可做了.

      所以，最佳的解决方案是,将你要运行的程序以前台进程的形式运行

- **列出当前所有正在运行的容器**
  - `docker ps [OPTIONS]`
  - OPTIONS说明
    - -a：列出当前所有正在运行的容器 + 历史上运行时的
    - -l：显示最近创建的容器
    - -n：显示最近n个创建的容器
    - -q：静默模式，只显示容器编号
  
- **退出容器：**
  - `exit`：run进去容器，exit退出，容器停止
  - `ctrl+p+q`：run进去容器，ctrl+p+q退出，容器不停止
  
- **启动已停止运行的容器**
  - `docker start 容器ID|容器名`
  
- **重启容器**
  - `docker restart 容器ID|容器名`
  
- **停止容器**
  - `docker stop 容器ID|容器名`
  
- **强制停止容器**
  - `docker kill 容器ID|容器名`
  
- **删除已停止的容器**
  - `docker rm 容器ID`
  - `docker rm -f $(docker ps -a -q)`
  - `docker ps -a -q | xargs docker rm`
  
- **查看容器日志**
  - `docker logs 容器ID`
  
- **查看容器内运行的进程**
  - `docker top 容器ID`
  
- **查看容器内部细节**
  
  - `docker inspect 容器ID`
  
- **进入正在运行的容器，并以命令行交互**
  - `docker exec -it 容器ID bashShell`
  - 重新进入：`docker attach 容器ID`
  - attach：直接进入容器启动命令的终端，不会启动新的进程，使用exit退出，会导致容器的停止
  - exec：是在容器中打开了新的终端，并且可以启动新的进程，用exit退出，不会导致容器的停止
  
- **从容器内拷贝文件到主机上**
  
  - 容器->主机
  - `docker cp 容器ID:容器内路径 目的主机路径`
  
- **导入和导出容器**
  - export：导入容器的内容留作为一个tar归档文件[对应import命令]
  - import：从tar包中的内容创建一个新的文件系统在导入为镜像[对应export]
  - `docker export 容器ID > 文件名.tar`
  - `cat 文件名.tar | docker import -镜像用户/镜像名:镜像版本号`

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131121143.png)

## Docker镜像

### 简介

- 镜像

  - 是一种轻量级、可执行的独立软件包，它包含运行某个软件所需的所有内容，我们把应用程序和配置依赖打包好形成一个可交付的运行环境(包括代码、运行时需要的库、环境变量和配置文件等)，这个打包好的运行环境就是image镜像文件。

  - 只有通过这个镜像文件才能生成Docker容器实例(类似Java中new出来一个对象)。

- 分层的镜像
  - 以我们的pull为例，在下载的过程中我们可以看到docker的镜像好像是在一层一层的在下载
  - ![image-20240413112701256](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131127928.png)

- UnionFS(联合文件系统)

  - UnionFS（联合文件系统）：Union文件系统（UnionFS）是一种分层、轻量级并且高性能的文件系统，它支持对文件系统的修改作为一次提交来一层层的叠加，同时可以将不同目录挂载到同一个虚拟文件系统下(unite several directories into a single virtual filesystem)。Union 文件系统是 Docker 镜像的基础。镜像可以通过分层来进行继承，基于基础镜像（没有父镜像），可以制作各种具体的应用镜像。
  - 特性：一次同时加载多个文件系统，但从外面看起来，只能看到一个文件系统，联合加载会把各层文件系统叠加起来，这样最终的文件系统会包含所有底层的文件和目录

- Docker镜像加载原理

  - docker的镜像实际上是由一层一层的文件系统组成，这种层级的文件系统UnionFS
  - bootfs(boot file system)主要包含bootloader和kermel，bootloader主要是引导加载kernel，Linux刚启动时会加载bootfs文件系统，在Docker镜像的最底层时引导文件系统bootfs。这一层与我们典型的Linux/Unix系统是一样的，包含boot加载器和内核。当boot加载完成之后整个内核都在内存中了，此时内存的使用权已由bootfs转交给内核，此时系统也会卸载bootfs
  - rootfs(root file system)，在bootfs之上，包含的就是典型Linux系统中的/dev，/proc，/bin，/etc等标准目录和文件。rootfs就是各种不同的操作系统发行版，比如Ubuntu，Centos等等
  - ![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131134243.png)

  - 平时我们安装进虚拟机的CentOS都是好几个G，为什么docker这里才200M？？
  - 对于一个精简的OS，rootfs可以很小，只需要包括最基本的命令、工具和程序库就可以了，因为底层直接用Host的kernel，自己只需要提供 rootfs 就行了。由此可见对于不同的linux发行版, bootfs基本是一致的, rootfs会有差别, 因此不同的发行版可以公用bootfs。

- 为什么Docker镜像要采用这种分层结构呢
  - 镜像分层最大的一个好处就是共享资源，方便复制迁移，就是为了复用。
  - 比如说有多个镜像都从相同的 base 镜像构建而来，那么 Docker Host 只需在磁盘上保存一份 base 镜像；
  - 同时内存中也只需加载一份 base 镜像，就可以为所有容器服务了。而且镜像的每一层都可以被共享。

### 理解

> Docker镜像层都是只读的，容器层是可写的
>
> 当容器启动时，一个新的可写层被加载到镜像的顶部。
>
> 这一层通常被称作“容器层”，“容器层”之下的都叫“镜像层”。

所有对容器的改动 - 无论添加、删除、还是修改文件都只会发生在容器层中。只有容器层是可写的，容器层下面的所有镜像层都是只读的。

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131524971.png)

Docker中的镜像分层，支持通过扩展现有镜像，创建新的镜像。类似Java继承于一个Base基础类，自己再按需扩展。

新镜像是从 base 镜像一层一层叠加生成的。每安装一个软件，就在现有镜像的基础上增加一层

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131532171.png)

### commit操作

`docker commit` 提交容器副本使之成为一个新的镜像

`docker commit -m="提交的描述信息" -a="作者" 容器ID 要创建的目标镜像名:TAG`



## 本地镜像发布

### 本地镜像发布到阿里云

![img](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131544848.png)

https://promotion.aliyun.com/ntms/act/kubernetes.html

1. 选择控制台, 进入容器镜像服务
2. 选择个人实例

![image-20240413161959619](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131620866.png)

3. 命名空间

![image-20240413162049982](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131620218.png)

4. 镜像仓库

![image-20240413162134802](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131621388.png)

然后单击镜像仓库,查看基本信息,通过脚本来实现阿里云镜像仓库的推送和下载

![image-20240413162437453](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202404131624976.png)

### 本地镜像发布到私有库

Docker Registry是官方提供的工具，可以用于构建私有镜像仓库

1. 下载镜像

`docker pull registry`

2. 运行私有库Registry,相当于本地有一个Docker Hub

   - `-v /主机映射备份目录/:/tmp/registry`：是用于将主机上的目录与容器内的目录进行挂载，通过这种挂载方式，可以在主机和容器之间共享文件和目录，实现数据的持久化和共享

   - 默认情况，仓库被创建在容器的/var/lib/registry目录下，建议自行用容器卷映射，方便于宿主机联调
   - `--privileged=true`：扩大容器的权限解决挂载目录没有权限的问题

`docker run -d -p 主机端口:容器映射端口 -v /主机映射备份目录/:/容器内目录 --privileged=true registry`

3. curl验证私服库上有什么镜像

`curl -XGET http://主机IP:端口号/v2/_catalog`

4. 将新镜像xxxx:TAG修改成符合私服规范的TAG

`docker tag 镜像:TAG 主机IP:端口号/Repository:TAG`

5. 修改配置文件使之支持http

```shell
vim /etc/docker/daemon.json
{
  "insecure-registries": ["主机IP:端口号"]
}
```

6. push推送到私服

`docker push 主机IP:端口号/镜像名称`

7. pull到本地运行

`docker pull 主机IP:端口号/镜像名称`

## Docker容器数据卷

### 简介

> 将docker容器内的数据保存进宿主机的磁盘中

运行一个带有容器卷存储功能的容器实例：

`docker run -it --privileged=true -v /宿主机绝对路径目录:/容器内目录 镜像名`

将运用与运行的环境打包镜像，run后形成容器实例运行 ，但是我们对数据的要求希望是持久化的

Docker容器产生的数据，如果不备份，那么当容器实例删除后，容器内的数据自然也就没有了。

为了能保存数据在docker中我们使用卷。

特点：

1：数据卷可在容器之间共享或重用数据

2：卷中的更改可以直接实时生效

3：数据卷中的更改不会包含在镜像的更新中

4：数据卷的生命周期一直持续到没有容器使用它为止

### 案例

- 宿主机vs容器之间映射添加容器卷
  - `docker run -it --privileged=true -v /宿主机绝对路径目录:/容器内目录 镜像名`
  - 查看数据卷是否挂载成功：`docker inspect 容器ID`
  - 容器和宿主机之间数据共享：【docker修改，主机同步获得】、【主机修改，docker同步获得】、【docker容器stop，主机修改，docker容器重启看数据是否同步】。
- 读写规则映射添加说明
  - 读写默认： 
    - 默认就是rw
    - `docker run -it --privileged=true -v /宿主机绝对路径目录:/容器内目录:rw 镜像名`
  - 只读：容器实例内部被限制，只能读取不能写
    - read only
    - `docker run -it --privileged=true -v /宿主机绝对路径目录:/容器内目录:ro 镜像名`

- 卷的继承和共享
  - 容器1完成和宿主机的映射
    - `docker run -it --privileged=true -v /宿主机绝对路径目录:/容器内目录 --name 容器1名称 ubuntu`
  - 容器2继承容器1的卷规则
    - `docker run -it --privileged=true --volumes-from 父容器名称|父类ID --name 容器2名称 ubuntu`

## Portainer工具

### 安装与启动

上述对容器和镜像的管理都是基于docker客户端的命令来完成，不太方便。为了方便的对docker中的一些对象(镜像、容器、数据卷...)来进行管理，可以使用Portainer来完成。Portainer是一个**可视化**的容器镜像的图形管理**工具**，利用Portainer可以轻松构建，管理和维护docker环境。



Portainer安装：

```shell
# 搜索portainer
docker search portainer

# 拉取镜像
docker pull portainer/portainer

#创建并启动容器,注意需要做一个docker.sock文件的映射，Docker中的Linux域套接字文件，后期portainer会通过这个文件和docker的守护进程进行通讯，管理docker的相关对象
# --restart=always: 表示随着docker服务的启动而启动 
docker run -d -p 9000:9000 --name=portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock portainer/portainer
```

访问：ip:9000   第一次登陆需要设置登陆密码，密码不得少于8位

![image-20230420174124176](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051643921.png) 

选择portainer需要管理的环境（本地还是远程）

![image-20230420174219226](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051643492.png) 

Portainer的首页

![image-20230420174325520](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051644312.png) 

### 镜像管理

选择docker服务，进入到如下页面

![image-20210304194927327](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051644263.png) 

点击镜像页签，对镜像进行相关管理

![image-20210304195150136](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051644317.png) 

### 容器管理

在首页选择docker服务，进入到如下页面

![image-20210304195512501](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051644993.png) 

 点击容器页签，对容器进行相关管理

![image-20230420174914650](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051644704.png) 

创建容器

![image-20230420175300245](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051644076.png) 

数据卷挂载：需要先创建数据卷，然后在下方选择volumes完成数据卷的挂载。



## Spring Boot项目部署

本章节主要讲解的就是如何把一个Spring Boot项目使用docker进行部署，以减少整个项目的维护成本。

### dockerfile

#### dockerfile简介

前面我们所使用的镜像都是别人构建好的，但是别人构建好的镜像不一定能满足我们的需求。为了满足我们自己的某一些需求，此时我们就需要构建自己的镜像，怎么构建？使用dockerfile。

dockerfile就是一个**文本文件**，在这个文本文件中可以使用docker所提供的一些指令来指定我们构建镜像的细节，后期就可以使用这个dockerfile文件来构建自己的镜像。

dockerfile文件内容一般分为4部分：

1、基础镜像信息(必选)

2、维护者信息(可选)

3、镜像操作指令(可选)

4、容器启动时执行的指令(可选)

常用命令

|    指令    | 用法                                   | 作用                                                         |
| :--------: | :------------------------------------- | :----------------------------------------------------------- |
|    FROM    | FROM  image_name:tag                   | 指定一个构建镜像的基础源镜像，如果本地没有就会从公共库中拉取，没有指定镜像的标签会使用默认的latest标签，可以出现多次，如果需要在一个dockerfile中构建多个镜像。 |
| MAINTAINER | MAINTAINER user_name                   | 描述镜像的创建者，名称和邮箱                                 |
|    RUN     | RUN "command" "param1" "param2"        | 用来执行一些命令，可以写多条                                 |
|    ENV     | ENV key value                          | 设置容器的环境变量，可以写多条。                             |
|    ADD     | ADD source_dir/file                    | 将宿主机的文件复制到容器内，如果是压缩文件，则复制后自动解压 |
| ENTRYPOINT | ENTRYPOINT "command" "param1" "param2" | 用来指定容器启动时所执行的命令                               |

#### 入门案例

需求：使用dockerfile来构建一个包含Jdk17的centos7镜像

分析：

1、基础的镜像的应该选择centos:7

2、在自己所构建的镜像中需要包含Jdk17，就需要把Jdk17添加到centos:7的基础镜像中

3、为了方便的去使用自己构建的镜像中的Jdk17，就需要去配置环境变量

4、因为Jdk17仅仅是一个开发工具，并不是一个服务进程，因此在启动容器的时候可以不指定任何的执行命令

实现步骤：

1、将Jdk17的安装包上传到linux服务器的指定目录下

2、在Jdk17所在的目录下创建一个dockerfile文件

3、使用docker build命令构建镜像

4、使用docker images查看镜像构建情况

5、使用自己所构建的镜像创建容器，测试Jdk17的安装情况



代码实现

```shell
# 1、创建目录
mkdir –p /usr/local/dockerfilejdk17
cd /usr/local/dockerfilejdk17
  
# 2、下载jdk-17_linux-x64_bin.tar.gz并上传到服务器（虚拟机）中的/usr/local/dockerfilejdk17目录
# 3、在/usr/local/dockerfilejdk17目录下创建dockerfile文件，文件内容如下：
vim dockerfile

FROM centos:7
MAINTAINER atguigu
RUN mkdir -p /usr/local/java
ADD jdk-17_linux-x64_bin.tar.gz /usr/local/java/
ENV JAVA_HOME=/usr/local/java/jdk-17.0.8
ENV PATH=$PATH:$JAVA_HOME/bin

# 4、执行命令构建镜像；不要忘了后面的那个 .
docker build -t centos7-jdk17 .

# 5、查看镜像是否建立完成
docker images

# 6、创建容器
docker run -it --name atguigu-centos centos7-jdk17 /bin/bash
```

### 案例介绍与需求分析

需求：将提供的Spring Boot项目使用容器化进行部署

分析：

1、Spring Boot项目中使用到了Mysql环境，因此需要先使用docker部署mysql环境

2、要将Spring Boot项目使用docker容器进行部署，就需要将Spring Boot项目构建成一个docker镜像

实现步骤：

1、使用docker部署mysql

2、使用dockerfile构建Spring Boot镜像

* 将Spring Boot打包成一个Jar包
* 把Jar包上传到Linux服务器上
* 编写dockerfile文件
* 构建Spring Boot镜像

3、创建容器进行测试

### docker部署Mysql

使用docker部署Mysql步骤如下所示：

```shell
# 创建容器。 -e: 设置环境变量	--privileged=true 开启root用户权限
docker run -di --name=mysql -p --restart=always 3306:3306 -v mysql_data:/var/lib/mysql -v mysql_conf:/etc/mysql --privileged=true -e MYSQL_ROOT_PASSWORD=123456 mysql:8.0.30

# 进入容器
docker exec -it mysql /bin/bash
mysql -uroot -p								# 登录mysql
```



问题：如果sqlyog出现2058的异常

~~~
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
~~~

并创建对一个的数据库和数据库表

创建数据库：docker

创建表：

```sql
CREATE TABLE `tb_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

添加测试数据

~~~sql
INSERT INTO `tb_school` VALUES (1, '尚硅谷-北京校区', '北京市昌平区宏福科技园2号楼3层');
INSERT INTO `tb_school` VALUES (2, '尚硅谷-上海校区', '上海市松江区谷阳北路166号大江商厦3层');
INSERT INTO `tb_school` VALUES (3, '尚硅谷-深圳校区', '深圳市宝安区西部硅谷大厦B座C区一层');
INSERT INTO `tb_school` VALUES (4, '尚硅谷-西安校区', '西安市雁塔区和发智能大厦B座3层');
INSERT INTO `tb_school` VALUES (5, '尚硅谷-成都校区', '成都市成华区北辰星拱青创园综合楼3层');
INSERT INTO `tb_school` VALUES (6, '尚硅谷-武汉校区', '武汉市东湖高新区东湖网谷6号楼4层');
~~~

### dockerfile构建镜像

#### 项目打包

具体步骤：

1、在idea中部署资料\基础项目\ebuy-docker项目，并启动项目访问：http://localhost:8081/

2、执行mvn package命令进行项目打包

3、上传jar包到linux服务器上

#### dockerfile文件

dockerfile文件的内容如下所示：

```shell
FROM centos7-jdk17
MAINTAINER atguigu

# 声明容器内主进程所对应的端口
EXPOSE 8081
ADD ebuy-docker-1.0-SNAPSHOT.jar /ebuy-docker-1.0-SNAPSHOT.jar

# 相当于windows中的cd命令
WORKDIR /      
ENTRYPOINT ["java" , "-jar" , "ebuy-docker-1.0-SNAPSHOT.jar"]
```

目录结构如下所示：

![image-20230424104219638](D:\priv\project\Note\Java\assets\image-20230424104219638.png) 

#### 构建镜像

命令如下所示： 

```shell
docker build -t ebuy-docker:v1.0 .
```

执行效果如下所示：

![image-20230717113801147](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051644318.png) 

### 创建容器

命令如下所示：

```shell
docker run -d --name ebuy-docker -p 8081:8081 ebuy-docker:v1.0
```

访问测试: http://192.168.6.131:8081

## Maven的docker插件

刚才的构建过程是手动镜像构建的过程。使用Maven的docker插件可以实现镜像的自动化部署。

步骤：

1、在pom.xml文件中添加Maven的docker插件

2、开启docker服务端的远程访问

3、在工程的根目录下创建dockerfile文件

4、使用maven的打包命令进行打包

5、创建容器并访问

实操：

1、在pom.xml文件中添加Maven的docker插件

```xml
<plugin>
                
    <groupId>com.spotify</groupId>
    <artifactId>docker-maven-plugin</artifactId>
    <version>1.2.2</version>

    <!--将插件绑定在某个phase执行-->
    <executions>
        <execution>
            <id>build-image</id>
            <!--将插件绑定在package这个phase(阶段)上。也就是说，用户只需执行mvn package，就会自动执行mvn docker:build-->
            <phase>package</phase>
            <goals>
                <goal>build</goal>
            </goals>
        </execution>
    </executions>

    <configuration>

        <!--指定生成的镜像名-->
        <imageName>${project.artifactId}</imageName>

        <!--指定标签,也就是版本号,可以自定义-->
        <imageTags>
            <imageTag>v2.0</imageTag>
        </imageTags>
        
        <!--指定远程 docker api地址 也就是服务器ip+docker的端口号-->
        <dockerHost>http://192.168.6.131:2375</dockerHost>

        <!-- 指定 dockerfile 路径-->
        <dockerDirectory>${project.basedir}</dockerDirectory>
        
        <!-- 是否跳过docker构建 -->
         <skipDockerBuild>false</skipDockerBuild>
     

    </configuration>

</plugin>
```

2、docker服务端开启远程访问

```shell
#修改该文件
vim /lib/systemd/system/docker.service

#找到ExecStart行，修改成如下内容
ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2375 -H fd:// --containerd=/run/containerd/containerd.sock

systemctl daemon-reload				#重启守护进程
systemctl restart docker			#重启docker
```

说明：2375端口是Docker的API端口，它允许开发者通过RESTful API进行容器和镜像的管理



3、编写dockerfile文件

注意：

1、该文件的位置必须是和pom.xml处于同一个目录

2、关闭防火墙

```shell
FROM centos7-jdk17
MAINTAINER atguigu
EXPOSE 8081
ADD target/ebuy-docker-1.0-SNAPSHOT.jar /ebuy-docker-1.0-SNAPSHOT.jar

WORKDIR /
ENTRYPOINT ["java" , "-jar" , "ebuy-docker-1.0-SNAPSHOT.jar"]
```

4、执行maven的打包命令

```shell
mvn clean package -DskipTests								# 打包跳过测试
mvn clean package -DskipTests -DskipdockerBuild				# 打包跳过测试的同时提高构建
```

5、创建容器并进行访问

```shell
docker run -d --name ebuy-docker -p 8082:8081 ebuy-docker:latest
```

## docker compose

### docker compose简介

1、Docker Compose是一个工具，用于定义和运行多容器应用程序的工具；

2、Docker Compose通过yml文件定义多容器的docker应用；

3、Docker Compose通过一条命令根据yml文件的定义去创建或管理多容器；

如下图所示：

![image-20230424160221537](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645679.png) 

Docker Compose 是用来做Docker 的多容器控制，有了 Docker Compose 你可以把所有繁复的 Docker 操作全都一条命令，自动化的完成。

官网地址：https://docs.docker.com/compose/install/linux/

### 下载与安装

下载与安装：

* 在安装docker时候已经完成了安装，直接查看版本号，查看是否安装成功

```shell
# 创建指定目录存储docker compose
mkdir -p /usr/local/lib/docker/cli-plugins

# 下载并移动（该指令如果执行不好使，多执行几次，或者多开几种终端再执行几次）
curl -SL https://github.com/docker/compose/releases/download/v2.14.2/docker-compose-linux-x86_64 -o /usr/local/lib/docker/cli-plugins/docker-compose

# 给docker-compose文件赋予可执行权限
sudo chmod +x /usr/local/lib/docker/cli-plugins/docker-compose

# 查看docker compose的版本
docker compose version
```

### 入门案例

需求：使用docker compose部署redis

docker-compose.yml文件的内容如下所示：

```yml
services:
  redis:
    image: redis:7.0.10
    container_name: redis
    ports:
      - "6379:6379"
    volumes:
      - redis-data:/data
volumes:
  redis-data: {}
```

docker compose相关命令：  

```shell
# 启动容器(如果不存在容器就创建、存在则修改)
docker compose -f docker-compose.yml up -d

# 删除所有容器
docker compose -f docker-compose.yml down

# 停止所有容器
docker compose -f docker-compose.yml stop

# 启动所有容器
docker compose -f docker-compose.yml start

# 重启所有容器
docker compose -f docker-compose.yml restart
```

docker compose文件中其他的常见指令参考官方文档：https://docs.docker.com/compose/compose-file/05-services/

### 编排Spring Boot项目

需求：使用docker compose部署第六章的spring boot项目

docker-compose.yml文件的内容如下所示：

```yaml
services:
  mysql:
    container_name: mysql
    image: mysql:8.0.30
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql
      - mysql_conf:/etc/mysql
    privileged: true
    environment:
      - "MYSQL_ROOT_PASSWORD=1234"
  ebuy:
    container_name: ebuy
    image: ebuy-docker
    ports:
      - "8081:8081"
volumes:
  mysql_data: {}
  mysql_conf: {}
```



## Docker镜像仓库

###  镜像仓库简介

镜像仓库作用：存储镜像，可以通过镜像仓库实现镜像的共享

镜像仓库的使用流程：

![image-20230424164001006](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645006.png) 

镜像仓库分类：

1、公有镜像仓库：可以理解成云仓库、公有仓库，是由某个组织、公司维护的仓库，对互联网开放，所有人共享。如官方的仓库docker hub。

2、私有镜像仓库：不对外开放。一般情况下只在公司内网中使用，用于加快镜像拉取速度、维护公司资产。

私有镜像仓库种类：

1、Registry是Docker自带的镜像仓库，部署运行非常简洁，非常适合在测试时使用。

2、Harbor

### Harbor简介

Harbor是VMware公司开源的企业级DockerRegistry项目，其目标是帮助用户迅速搭建一个企业级的Dockerregistry服务。它以Docker公司开源的registry为基础，提供了管理UI，基于角色的访问控制(Role Based Access Control)，AD/LDAP集成、以及审计日志(Auditlogging) 等企业用户需求的功能，同时还原生支持中文。

### 下载与安装

Harbor被部署为多个Docker容器，因此可以部署在任何支持Docker的Linux服务器上，且需要Docker和Docker Compose才能安装。

#### 下载

下载地址：https://github.com/goharbor/harbor/releases

![image-20230424165240085](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645450.png) 

这里我们下载在线安装包：

```
wget https://github.com/goharbor/harbor/releases/download/v2.8.0/harbor-online-installer-v2.8.0.tgz
```

#### 安装

具体步骤如下所示：

**1、解压并修改配置文件**

```
tar -zxvf harbor-online-installer-v2.8.0.tgz     # 解压tgz包
cp harbor.yml.tmpl harbor.yml                    # 创建一个配置文件
vim harbor.yml                                   # 修改配置文件
```

配置的文件的修改如下所示：

![image-20230725123018878](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645540.png)



**2、启动Harbor**

```shell
# 1、 进入到Harbor的解压目录
# 2、执行安装脚本
sh install.sh
#注意：该执行依赖docker-compose,必须先安装docker-compose

```

![image-20230725114808111](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645319.png)

![image-20230725122551186](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645782.png)

注意：如果安装的时候报错了，可以给docker配置多个镜像地址：

```json
// 编辑文件
vim /etc/docker/daemon.json

// 文件内容
{
  "registry-mirrors": ["https://registry.docker-cn.com","http://hub-mirror.c.163.com","http://f1361db2.m.daocloud.io","https://mirror.ccs.tencentyun.com","https://ujry6exw.mirror.aliyuncs.com"]
}
```

**3、启动关闭命令**

```
docker compose -f docker-compose.yml up -d            启动 Harbor
docker compose -f docker-compose.yml stop             关闭 Harbor
```

**4、访问Harbor**

* 访问地址：http://192.168.136.131/

![image-20230725114929808](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645390.png)

* 用户名/密码：admin/Harbor12345

![image-20230725115003967](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645117.png)



### Harbor使用

#### 上传镜像

需求：将本地的ebuy-docker镜像上传到Harbor中

实现步骤：

1、在Harbor上创建一个项目

![image-20230424171918223](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645358.png) 

2、docker添加安全访问权限

```shell
# 编辑/etc/docker/daemon.json文件
vim /etc/docker/daemon.json

# 添加安全访问权限
{
  "insecure-registries":["http://192.168.6.131"]
}

# 重启Docker
systemctl restart docker
```

3、推送docker镜像到该项目中

```shell
docker login -u admin -p Harbor12345 192.168.6.131         			 # 登录到Harbor
docker tag ebuy-docker 192.168.6.131/ebuy-docker/ebuy-docker:latest    # 给镜像重新打一个标签
docker push 192.168.6.131/ebuy-docker/ebuy-docker:latest               # 推送镜像到Harbor中
```

推送完毕以后，在ebuy-docker项目中会自动创建一个ebuy-docker的镜像仓库：

![image-20230424172715032](https://gcore.jsdelivr.net/gh/Luckiiest/noteImage@master/202406051645191.png) 

#### 拉取镜像

命令操作如下所示：

```shell
docker login -u admin -p Harbor12345 192.168.6.131         # 登录到Harbor
docker pull 192.168.136.142/ebuy-docker/ebuy-docker:latest   # 拉取镜像
```

注意：

~~~
# The initial password of Harbor admin
# It only works in first time to install harbor
# Remember Change the admin password from UI after launching Harbor.
harbor_admin_password: Harbor12345
译文：
#海港管理员的初始密码
#它只适用于第一次安装港口
#记住在启动Harbos后从UI更改admin密码。
~~~

