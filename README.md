# test-mybatis
基本原理
应用程序找 MyBatis 要数据
MyBatis 从数据库中找来数据
1.通过 mybatis-config.xml 定位哪个数据库
2.通过 Student.xml 执行对应的 sql 语句
3.基于 Student.xml 把返回的数据库封装在 Student 对象中
4.把多个 Student 对象装载一个 Student 集合中
返回一个 Student 集合
