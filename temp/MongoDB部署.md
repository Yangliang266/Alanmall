### MongoDB 部署

1. 官网下载 mongodb-linux-x86_64-rhel70-3.4.2.tgz。

> https://www.mongodb.com/download-center?jmp=nav#community

2. 解压 mongodb-linux-x86_64-rhel70-3.4.2.tgz。

```
tar -zxvf mongodb-linux-x86_64-rhel70-3.4.2.tgz
```

3. 将 mongodb-linux-x86_64-rhel70-3.4.2 重命名 mongodb3.4.2。

4. 创建数据和日志目录：

```
cd /mongodb3.4.2
mkdir data
mkdir log
```

5. 在 log 文件夹下创建 mongodb.log 文件：

```
vi mongodb.log
```

6. 创建启动配置文件 mongodb.config：

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

7. 启动 MongoDB：

```
./mongod --config mongodb.config
```

8. 查看 MongoDB 进程：

```
ps -ef | grep mongod
```

9. 检查端口是否已被启动：

```
netstat -lanp | grep 27017
```

10. 将 MongoDB 服务加入到自启动文件中：

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

