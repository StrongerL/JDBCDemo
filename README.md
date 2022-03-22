这个是一个使用JDBC的示例。

## 流程

1. 导入maven依赖

   ```xml
   <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.12</version>
   </dependency>
   ```

2. 加载驱动类

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver");
   ```

3. 获取连接

   ```java
   Connection connection = DriverManager.getConnection(url, username, password);
   ```

4. 操作数据库

   使用`PreparedStatement`或者`Statement`对数据库进行增删改查等操作。

5. 关闭连接

   ```java
   connection.close();
   ```

   

## 项目结构

```
src
├─ main
│    ├─ java
│    │    ├─ DBUtil.java           // 用于获取数据库连接
│    │    ├─ Goddess.java          // 实体类
│    │    ├─ GoddessDao.java       // 操作数据库的类
│    │    └─ Main.java             // 客户端
│    └─ resources
│           └─ DB.sql              // 数据库脚本
└─ test
       └─ java
```



## 参考资料

- https://www.runoob.com/w3cnote/jdbc-use-guide.html