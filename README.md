# UserDemo
Spring boot,Redis,Mybatis,lombok
服务为阿里云ECS服务器，Redis为阿里云Redis，数据库为阿里云MySql，放在docker上运行
====================centOs 7装机===========================

#阿里云ECS连接阿里云Redis
wget http://www.boutell.com/rinetd/http/rinetd.tar.gz&&tar -xvf rinetd.tar.gz&&cd rinetd
sed -i 's/1/65535/g' rinetd.c
mkdir /usr/man&&make&&make install
vi /etc/rinetd.conf(输入以下2行)
0.0.0.0 6379 Redis的链接地址 6379
logfile /var/log/rinetd.log
rinetd
echo rinetd >>/etc/rc.local(开机启动)
redis-cli -h 1.1.1.1 -a Redis的实例ID:Redis密码

#jdk1.7安装
yum -y list java*
yum -y install java-1.7.0-openjdk*
java -version

#lrzsz安装文件上传下载xshll需要设置xshall==》ZMODEM==》下载路径
yum -y list lrzsz*
yum install lrzsz

#安装tomcat7
wget http://mirror.bit.edu.cn/apache/tomcat/tomcat-7/v7.0.78/bin/apache-tomcat-7.0.78.tar.gz
tar -xzvf apache-tomcat-7.0.78.tar.gz
vi /root/apache-tomcat-7.0.78/conf/server.xml（修改端口）
sh /root/apache-tomcat-7.0.78/bin/startup.sh(启动)
(停止直接杀死进程)

#docker安装
yum -y install docker
systemctl start docker.service
