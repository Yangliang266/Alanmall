## Alanmall

> Distributed ecological technology - Written by yliang 2020/9/8 | 禁止商业用途，转载请注明

> 具体代码 点击上方**View code**一览。

> 整体环境部署完毕，部分功能未开发，持续更新，以下为更新，bug修正日志



**Version 0.9.8  |  2020/9/24**

1. **流程图思路**

 <img src="https://raw.githubusercontent.com/YangLiang-SoftWise/images/master/img/login verify.png" alt="login verify" style="zoom: 20%;" />



2. **实现功能: 登录验证**

3. **Code组成**

   1. 前端

      1. main.js

         > 过滤 ['/home', '/goods', '/login', '/register', '/product', '/thanks', '/search', '/refreshsearch', '/refreshgoods'] 

      2. login.vue

         > username，password，kapatcha 登录信息

   2. 后端

      1. user-service

         1. KaptchaServiceImp

            1. getKaptchaCode

               > 获取 imgcode

            2. validateKaptcha 

               > 验证 imgcode

         2. UserLoginServiceImp

            1. login

               > 验证unm,upaw,ukatc生成token

            2. validToken

               > 解析token

      2. user-sdk

         1. TokenIntercepter

            > 拦截token，通过validToken 解析判断

         2. @Anoymous注解

            > 未被标记的handerMethod 需token验证

      3. alanmall-user

         1. KaptchaController

            1. getKaptchaCode

               > 根据获取的imgcode，放入cookie

            2. validatakaptchaCode

               > redis库与request code compare

         2. LoginController

            1. login

               > 根据生成的token，放入cookie



## card系统重构

1. **分布式搭建**

   1. **user 服务 - user 后端控制**

      1. 登录控制

      2. 个人信息

      3. 付款个人地址       

   2. **shopping 服务 - shopping 后端控制**

      1. 商品选择
      2. 商品购买
      3. <span style='color:red'>具体实现 todo</span>

   3. **casher 业务 - cahser 后端控制**

      1. 付款方式
      2. <span style='color:red'>具体实现 todo</span>

   4. **card 服务 - card 后端控制**

      1. card 生成前置流程
      2. card 生成后置流程
      3. card 报表流程
      4. <span style='color:red'>具体实现 todo</span>

   5. **<span style='color:red'>ToDo 后续待开发</span>**

      

2. **技术选型**

   1. dubbo 远程通信RPC框架
   2. zookeeper 注册中心
   3. redis 数据缓存
   4. rabbitmq 消息队列
   5. mysql 关系型数据库
   6. mongoDB 非关系型数据库
   7. vuejs 前端控制
   8. Nginx 网关限制




### 部署前准备

#### 部署文件清单

在开始着手部署前，我们需要先明确部署类别，规划并准备好部署文件以及版本号等，把这些先列一个清单出来。

| 序号 | 类别       | 文件                              | 版本号 |
| :--- | :--------- | :-------------------------------- | :----- |
| 1    | JDK        | jdk-8u65-linux-x64.rpm            | 1.8    |
| 2    | Redis      | redis-3.0.6.tar.gz                | 3.0.6  |
| 3    | ZooKeeper  | zookeeper-3.4.6.tar.gz            | 3.4.6  |
| 4    | Nginx      | nginx-1.10.1-1.el6.ngx.x86_64.rpm | 1.10.1 |
| 5    | Keepalived | keepalived-1.1.15.tar.gz          | 1.1.15 |
| 6    | MongoDB    | mongodb-linux-x86_64-3.4.2.tgz    | 3.4.2  |

#### 部署架构图

![在这里插入图片描述](https://images.gitbook.cn/e24662a0-14d3-11ea-997c-eb06189b4682)

#### 服务器资源准备、检查及预装

按照微服务设计规划预估所需服务器数量，这里以 Linux 虚拟机为例，从物理机分配资源。


拿到服务器资源后，我们也首先列出服务器资源清单，包含主机名、IP 地址、CPU、内存、磁盘、IO、网络等配置，初步判断一下是否满足需求。然后再依次进行以下操作。

**1. 服务器连接检查**

使用 SecureCRT 或者 XShell 连接 Linux 虚拟机，检查是否能连通，需要注意的是在开发和测试环境可以用 root，要上生产环境时一定要用其它用户，把权限细分。然后检查防火墙，ZooKeeper、Dubbo、Redis、ActiveMQ、业务服务等所用到的端口，必须开放。

查看防火墙状态命令：

```
firewall-cmd --list-all
```

关掉防火墙命令：

```
systemctl stop firewalld.service 
systemctl disable firewalld.service。
```

再检查一下操作系统内核版本，这一步很关键，有些软件对操作系统版本是有要求的。

```
uname -a
```

硬盘信息：

```
df -Th
```

内存用率：

```
free -m 
```

**2. 预装依赖软件 JDK**

查看 Linux 上 open JDK 的安装：

```
rpm -qa|grep java
```

卸载 Open JDK：

```
rpm -e --nodeps 上一步骤列出的open jdk的rpm名称
```

安装 JDK：

```
rpm -ivh jdk-8u65-linux-x64.rpm
```

安装过程中按 y 确认安装即可。

修改 etc/profile，增加 JDK 环境变量：

```
export JAVA_HOME=/usr/java/jdk1.8.0_65（jdk路径）
export PATH=$ JAVA_HOME/bin:$ PATH
export CLASSPATH=$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
```

启用环境变量：

```
source /etc/profile
```

测试 JDK 是否安装成功：

```
 java -version
```

**3. 设置主机映射关系**

```
vi /etc/hosts
```

**4. 设置 Linux 默认的最大文件描述符**

在 /etc/rc.local 加入：

```
ulimit -SHn 100000
```

在 /etc/security/limits.conf 加入：

```
* hard nofile 100000
* soft nofile 100000
```

### 网关部署及策略

#### Nginx 部署

这里我使用的是 NPM 包，是 Nginx 的安装包，还有一种 tar 包，是 Nginx 的源码包，部署上的区别在于，安装后 Nginx 文件的路径不一样。NPM 的安装包安装后路径在 /etc/nginx 下；而 tar 包安装的在 /usr/local/nginx。相关命令也不一样。

例如重启命令，前者是：

```
nginx -s reload 
```

而后者是：

```
/usr/local/nginx/sbin/nginx -s reload。
```

上传文件安装包 nginx-1.10.1-1.el6.ngx.x86_64.rpm 到 Linux 服务器上。

安装 Nginx，执行命令：

```
rpm -ivh nginx-1.10.1-1.el6.ngx.x86_64.rpm
```

启动 Nginx：

```
nginx
```

查看 Nginx，输入 http://ip/，ip 为机器的 ip。查看 Nginx 是否启动成功，如果成功，提示欢迎界面；或者 XShell 中输入命令：

```
ps-ef|grep nginx
```

如下图显示表示 Nginx 安装成功。

![在这里插入图片描述](https://images.gitbook.cn/54285b40-11c2-11ea-a00d-0ff621026e86)

#### Keepalived 双机热备部署

**痛点**：如果使用单台 Nginx 服务器，一旦服务器出现单点故障，整个业务系统就无法使用，风险大。

**部署方案**：使用两台 Nginx 服务器做双机热备，一台 Nginx 服务器作主服务器，另外一台 Nginx 服务器作热备服务器。一旦主服务器宕机，热备服务器就会接管主服务器进行业务服务。两台 Nginx 服务器使用 Keepalived 来做双机热备管理，Keepalived 软件会使用一个虚拟地址（VIP）来作为入口点。部署图如下所示：

双机热备的方案示例：

![在这里插入图片描述](https://images.gitbook.cn/c00503e0-1271-11ea-84a5-39a66e614e2e)

**前提要求**：

- 两台 AP 服务器指向的 Web 页面必须一样，配置的端口也一样，而且两台服务器 IP 地址必须都在同一网段上。
- 一个虚拟 IP 地址，必须没有被使用过而且和上述两个服务器 IP 地址在同一网段上。下表描述一个简单示例：

| 虚拟 IP        | 10.192.11.103 |
| :------------- | :------------ |
| Nginx 主服务器 | 10.192.11.101 |
| Nginx 备服务器 | 10.192.11.102 |

**安装步骤**：

\1. 将解压后的 Keepalive 源码目录（keepalived-1.1.15）上传到两台服务器。

\2. 安装 gcc 等编译需要的软件库（要求网络能连接外网进行更新，如果已安装，可跳过此步骤）。

```
yum -y install gcc pcre-devel zlib-devel 
```

openssl-devel 需要单独安装，openssl-devel 依赖 krb5-devel，需要连接互联网安装。

```
yum install krb5-devel

rpm -ivh openssl-devel-1.0.1e-48.el6_8.1.x86_64.rpm
```

\3. 安装 popt 编译库（要求网络能连接外网进行更新，如果已安装，可跳过此步骤）。

```
yum install popt-devel -y
```

\4. 进入 Keepalived 目录进行编译安装，查看编译命令成功，不能出现错误提示。

```
cd /keepalived-1.1.15
chmod 777 -R *.*
./configure --prefix=/usr/local/keepalived
make && make install
```

\5. 复制 Keepalived 配置文件，并制作 Keepalived 服务。

```
cp -r /OAS/keepalived-1.1.15/keepalived/etc/keepalived /etc
cp /usr/local/keepalived/sbin/keepalived  /usr/sbin/
cp /usr/local/keepalived/etc/sysconfig/keepalived  /etc/sysconfig/
cp /usr/local/keepalived/etc/rc.d/init.d/keepalived  /etc/init.d/
```

\6. 新建 Nginx 检测脚本 nginxcheck.sh 并存放在指定目录，本例使用：/nginxcheck.sh。

```
nginxPidNum=ps -C nginx --no-header |wc -l
keepalivedPidNum=ps -C keepalived --no-header |wc -l
if [[ $nginxPidNum -eq 0 ]];
then
killall keepalived
fi
```

注：需要设置 nginxcheck.sh 有执行权限。

```
chmod 777 /nginxcheck.sh
```

\7. 按下例分别修改主、备服务器 /etc/keepalived/keepalived.conf。

**主服务器** /etc/keepalived/keepalived.conf 内容参考：

```
vrrp_scriptchk_http_port {
script ""/mpjava/nginxcheck.sh""   #nginx检测脚本目录
interval 2
weight 2
}

vrrp_instance VI_1 {
state MASTER #主服务器必须设置为MASTER
interface eth0 #与服务器的网卡接口必须一致
virtual_router_id 51 #主、备服务器的id必须一致
priority 100#主服务器的priority必须大于备份服务器的priority
advert_int 1#服务器的advert_int必须一致
authentication {
auth_type PASS
auth_pass XXX#服务器的密码必须一致
}
virtual_ipaddress {
10.192.11.103  #虚拟IP地址，和服务器必须在同一网段并且没有使用
}
}
```

**备服务器** /etc/keepalived/keepalived.conf 内容参考：

```
vrrp_scriptchk_http_port {
script ""/mpjava/nginxcheck.sh""   #nginx检测脚本目录
interval 2
weight 2
}

vrrp_instance VI_1 {
state BACKUP #主服务器必须设置为MASTER
interface eth0   #与服务器的网卡接口必须一致
virtual_router_id 51 #主、备服务器的id必须一致
priority 50  #备份服务器的priority必须小于主服务器的priority
advert_int 1#服务器的advert_int必须一致
authentication {
auth_type PASS
auth_pass XXX   #服务器的密码必须一致
}
virtual_ipaddress {
10.192.11.103 #虚拟IP地址，和服务器必须在同一网段并且没有使用
}
}
```

\8. 分别在主、备服务器上启动 Keepalived 服务：

```
 service keepalived restart
```

添加自启动：

```
chkconfig --add keepalived
chkconfig --level 345 keepalived on
```

\9. 修改启动顺序：

```
vi /etc/init.d/keepalived
```

- 原配置：`# chkconfig: - 21 79`
- 修改为：`# chkconfig: - 98 79`

注：用 cat /etc/init.d/nginx，保证 Keepalived 启动顺序号是大于 Nginx 启动的。

\10. 测试和验证：

```
ping 10.192.11.103   // 测试虚拟IP是否启动
```

在能访问虚拟 IP 的机器上输入 `http://<虚拟IP>:<Nginx启动端口号>/`，查看网页是否显示。端口默认 80。

**验证**：

- 关闭 rt01，访问 VIP，可以成功打开 Nginx 页面。
- 关闭 rt02，访问 VIP，地址不通。
- 开启 rt01，访问 VIP，可以再次成功打开 Nginx 页面。

### MongoDB 部署

\1. 官网下载 mongodb-linux-x86_64-rhel70-3.4.2.tgz。

> https://www.mongodb.com/download-center?jmp=nav#community

\2. 解压 mongodb-linux-x86_64-rhel70-3.4.2.tgz。

```
tar -zxvf mongodb-linux-x86_64-rhel70-3.4.2.tgz
```

\3. 将 mongodb-linux-x86_64-rhel70-3.4.2 重命名 mongodb3.4.2。

\4. 创建数据和日志目录：

```
cd /mongodb3.4.2
mkdir data
mkdir log
```

\5. 在 log 文件夹下创建 mongodb.log 文件：

```
vi mongodb.log
```

\6. 创建启动配置文件 mongodb.config：

```
cd bin
vi mongodb.config
dbpath=/mongodb3.4.2/data
logpath=/mongodb3.4.2/log/mongodb.log
fork=true
logappend=true
bind_ip=10.1.1.65
port=27017
```

\7. 启动 MongoDB：

```
./mongod --config mongodb.config
```

\8. 查看 MongoDB 进程：

```
ps -ef | grep mongod
```

\9. 检查端口是否已被启动：

```
netstat -lanp | grep 27017
```

\10. 将 MongoDB 服务加入到自启动文件中：

```
vi /etc/rc.local 
```

在文件末尾追加如下命令：

```
/mongodb3.4.2/bin/mongod --config mongodb.conf
```

保存并退出：

```
:wq
```

### Redis 部署及策略

#### Redis 单点部署步骤

**1. 安装 Redis 缓存服务**

上传 redis-3.0.6 到指定部署的服务器路径，修改配置文件 redis-3.0.6/redis.conf，设置 redis 密码：

```
requirepass   abcd1234 
```

启动服务：

```
src/redis-server redis.conf &
```

**2. 检测缓存服务是否运行**

使用远程登录工具、登录到缓存服务器、在命令行终端输入下列命令：

```
ps -ef|grep redis
```

检查是否有 6379 端口处于 LISTEN 状态。若出现表明缓存服务安装成功。

```
netstat -an | grep 6379
```

#### Redis 集群闭环部署（Redis-Cluster 三主三从）

##### **前提**

- 集群的机器上必须安装了 Redis 服务，并且能正常运行，参考第一步 Redis 单点部署步骤。
- 集群机器上必须安装 Ruby 系统服务：

```
  yum -y install ruby
```

- 集群机器上必须安装 Rubygems 系统服务，并且启用了 Redis 支持：

```
  yum install rubygems
  gem install redis  -v 3.3.5
```

部署示意图：（本例装在 10.192.11.105、10.192.11.106、10.192.11.107，以 105 作为集群执行机器）

![在这里插入图片描述](https://images.gitbook.cn/89f94500-11bc-11ea-a203-6d4bec4d13eb)

部署图中有 10.192.11.105、10.192.11.106、10.192.11.107 三台服务器。每台服务器上安装两个 Redis 服务，监听端口分别为 6379 和 6380 端口。如上图所示，每台服务器的 6379 和另外一台机器上的 6380 的服务为主从关系（A 主–B 从，B 主–C 从，C 主–A 从）。

##### **安装步骤**

**1. 修改配置**

复制 Redis 目录 redis.conf 为 redis6379.conf 和 redis6380.conf，按以下内容进行调整。每台缓存服务器上配置文件除了 IP 配置为自己的 IP，其他都一样。

![在这里插入图片描述](https://images.gitbook.cn/17791e50-14d3-11ea-8852-07d124018ab6)

修改集群映射关系：

```
"masters.sort! { |a,b| b.info[:host] <=> a.info[:host] }
interleaved.sort! { |a,b| a.info[:host] <=> b.info[:host] }"
```

**2. 启动 Redis 服务**

在每台服务器上分别启动 Redis 主从服务（需要先进入 / OAS/redis-3.0.6 / 路径）。

```
src/redis-server redis6379.conf &
src/redis-server redis6380.conf &
```

启动完成后，执行 `ps -ef |grep redis` 能看到进程正常如下：

![在这里插入图片描述](https://images.gitbook.cn/b58cd150-11bc-11ea-a40a-4fd3d05ae4dc)

**3. 修改集群服务器的登录密码**

运行 `gem env` 命令，找到 gem 的安装目录：INSTALLATION DIRECTORY 这一项，在其下找到 redisgem 的安装目录：

```
cd  /usr/local/share/gems/gems/redis-3.3.5/lib/redis/
vi  /usr/local/share/gems/gems/redis-3.3.5/lib/redis/client.rb
```

找到 `:password` 项，将其修改为 Redis 的登录密码，保存并退出。

![在这里插入图片描述](https://images.gitbook.cn/c0e30a10-11bc-11ea-a203-6d4bec4d13eb)

注：只需要在集群服务器上做此操作。

**4. 启动 Redis 集群**

进入 redis-3.0.6 目录，使用以下命令启动 Redis 集群：

```
src/redis-trib.rb  create --replicas 1 10.192.11.105:6379 10.192.11.106:6379 10.192.11.107:6379 10.192.11.105:6380 10.192.11.106:6380 10.192.11.107:6380
```

注：集群启动顺序按照“主 - 主 - 主 - 从 - 从 - 从”的顺序，并且 Redis 5.0 以上的版本集群启动命令已经变了，不再使用 redis-trib.rb 来启动集群，而是直接从客户端（redis-cli ）启动：

```
./redis-cli --cluster create 10.192.11.105:6379 10.192.11.106:6379 10.192.11.107:6379 10.192.11.105:6380 10.192.11.106:6380 10.192.11.107:6380 1 -a abcd1234
```

启动时要注意主从映射关系即主从 IP 映射关系应该是 A-B B-C C-A 模式。如是 A-A B-C C-B 这样的集群是失败的。如果映射关系不对，还可以通过命令手动修改映射关系。主要用到的命令如下：

登录命令：

```
src/redis-cli -c -h 172.18.21.1 -p 6379
```

提示符为：

```
172.18.21.1:6379> 
```

需要进行密码验证：

```
172.18.21.1:6379> auth abcd1234 
```

- cluster info：打印集群的信息。
- cluster nodes：列出集群当前已知的所有节点（node），以及这些节点的相关信息。

```
cluster meet < ip > < port > ：将 ip 和 port 所指定的节点添加到集群当中，让它成为集群的一份子。

cluster forget <node_id> ：从集群中移除 node_id 指定的节点。

cluster replicate <node_id> ：将当前节点设置为 node_id 指定的节点的从节点。
```

**5. 检查**

在启动集群的服务器上，使用以下命令检查集群是否启动：

```
/redis-3.0.6/src/redis-cli -h 172.18.21.1 -a abcd1234 -c cluster info
```

检查是否集群信息是否和安装的一致，如下图所示：

![在这里插入图片描述](https://images.gitbook.cn/d404a720-11bc-11ea-a00d-0ff621026e86)

表示安装成功。

**6. 开机自启动**

```
vi /etc/rc.d/rc.local
```

添加内容 /mpjava/redis-3.0.6/autostartup.sh，自启动脚本如下可参考或者直接使用。

```
#!/bin/sh
redisprocount=0
shpath=$(cd 'dirname $ 0‘;pwd)
runlogdir=${shpath}"/autorunlog.log"
#清除运行日志
clearlog(){
echo "" >${runlogdir}
}
#写日志 $1 要写的日志信息
log(){
loginfo=$1
timestr=’date "+%Y-%m-%d %H:%M:%S  "‘
echo ${timestr}${loginfo} >>${runlogdir}
}
errorlog(){
loginfo=$1
timestr=’date "+%Y-%m-%d %H:%M:%S  ERROR!!!!!!!!!!ERROR!!!!!!!"‘
echo $ {timestr}${loginfo} >>${runlogdir}
}
checkport(){
num=’echo -n "\n"|telnet 172.18.21.1 $1|grep Connected|wc -l‘
if [ $num -eq 1 ]; then
log $ 1"端口能正常访问"
redisprocount=$[redisprocount+1]
else
 errorlog $1"端口无法访问"
fi
}
#检查redis进程
checkredisproc(){
redisprocount=0
checkport 6379
checkport 6380
#process=’ps -ef|grep redis|grep -v grep|awk '{print $2}'‘
#redisprocount=0
#for i in $process
#do
#  log "查到REDIS进程 ID为："$i
#  redisprocount=$[redisprocount+1]
#done
}
log "===================开始运行脚本文件"
log "系统重启 启动REDIS进程"
sleep 30s
ipinfo=’/sbin/ifconfig -a|grep inet|grep -v 127.0.0.1|grep -v inet6|awk '{print $2}'|tr -d "addr:"‘
log ${ipinfo}
cd ${shpath}
src/redis-server redis6379.conf &
src/redis-server redis6380.conf &
sleep 5s
checkredisproc
for ((i=0;i<4;i++))
do
 if [ $ redisprocount -eq 2 ]; then
 log "REDIS启动正常";
 break;
else
 errorlog "REDIS没有正常启动 30秒后重确认";
 sleep 30s;
tmp=$(checkredisproc)
 fi
done
log "===================运行脚本文件结束"
```

### ZooKeeper 部署及策略

#### ZooKeeper 服务的安装

注：ZooKeeper 集群必须是奇数台（本环境为 3）。

\1. 创建目录：

```
cd /OAS
mkdir z346
```

\2. 在 z346 实例目录下创建 data、dataLog：

```
mkdir data
mkdir dataLog
```

\3. 把 ZooKeeper 加入到环境变量中：

```
echo -e "# append zk_env\nexport PATH=$PATH:/OAS/z346/zookeeper-3.4.6/bin" >> /etc/profile
source /etc/profile
```

\4. 在 data 目录下创建 myid 文件，填入服务实例的顺序。

例如本服务器是第 1 台服务器，则在 myid 中填入 1，依次类推。

\5. 将 zookeeper-3.4.6.tar.gz 解压到 z346 目录下面 (/OAS/z346)。

\6. 将 / OAS/z346/zookeeper-3.4.6/conf/zoo_sample.cfg 文件复制为 zoo.cfg 文件。

\7. 按照下面的说明，编辑 zoo.cfg 文件，并保存。

```
# The number of milliseconds of each tick
tickTime=2000
# The number of ticks that the initial
# synchronization phase can take
initLimit=10
# The number of ticks that can pass between
# sending a request and getting an acknowledgement
syncLimit=5
# the directory where the snapshot is stored.
dataDir=/OAS/z346/data
dataLogDir=/OAS/z346/dataLog
maxClientCnxns=300
# the port at which the clients will connect
clientPort=2181
server.1=10.192.11.108:2888:3888
server.2=10.192.11.109:2888:3888
server.3=10.192.11.110:2888:3888
```

其他两台根据实际情况修改内容。

注意：

- dataDir 目录为本 ZooKeeper 实例的 data 目录；
- dataLogDir 目录为本 ZooKeeper 实例的 dataLogDir 目录；
- clientPort 为客户端连接端口，保持为 2181 不改变；
- server.1 中的 1 为实例顺序，根据 ZooKeeper 实例序号，ip、port 保持为 127.0.0.1:2888:3888。

\8. 从 myid 中的 1~3 顺序，分别输入下面命令，执行 bin/zkServer.sh，启动 ZooKeeper。

```
./zkServer.sh start
```

\9. 多个 ZooKeeper 实例的安装，参照 1~8 步骤进行，只是实例序号（myid）不一样。

\10. 查看是否存在 ZooKeeper 进程，QuorumPeerMain 即为进程名：

```
# jps
29242 Jps
26285 QuorumPeerMain
```

#### 验证

执行下面命令检查 ZooKeeper 状态：

```
/OAS/z346/zookeeper-3.4.6/bin/zkServer.sh status
```

myid 1：

![在这里插入图片描述](https://images.gitbook.cn/06809550-11be-11ea-a40a-4fd3d05ae4dc)

myid 2：

![在这里插入图片描述](https://images.gitbook.cn/0baf07a0-11be-11ea-84a5-39a66e614e2e)

myid 3：

![在这里插入图片描述](https://images.gitbook.cn/172c2950-11be-11ea-ba77-6758615dd5f2)

#### 开机自启动

```
vi /etc/rc.d/rc.local
```

添加内容：

```
/OAS/z346/zookeeper-3.4.6/bin/zkServer.sh start
```

