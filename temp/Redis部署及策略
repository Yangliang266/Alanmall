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
