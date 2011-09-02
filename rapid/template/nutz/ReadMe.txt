代码生成后的提示:

1. src/conf文件夹应当设置为源文件夹
2. 检查conf/ioc/dao.js文件,确保参数正确,尤其是validationQuery

3. 以下jar是必须的,均可以在lib文件夹找到
nutz-1.b.39-jdk6.jar  #建议一直使用最新版
lombok.jar            #非常好用的工具包,免去生成Getter/Setter的烦劳
commons-dbcp-1.4.jar   #Apache DBCP数据库连接池
commons-pool-1.5.4.jar #DBCP依赖的jar
当然,还有你的JDBC驱动

lombok是需要安装的
双击lombok.jar会启动安装界面
或执行 java -jar lombok.jar来启动安装界面