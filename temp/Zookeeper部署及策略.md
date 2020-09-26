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

