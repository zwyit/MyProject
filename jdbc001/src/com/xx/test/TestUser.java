package com.xx.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUser {
	//jdbc实现用户新增
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		//1、注册数据库驱动
		Class.forName("oracle.jdbc.OracleDriver");
		//2、获取数据库连接  url：数据库的连接地址 ,user：数据库名字，password：数据库密码
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		//3、创建语句对象Statement
		Statement stmt=conn.createStatement();
		//4、执行sql (insert,delete,update)都调用executeUpdate()方法
		int result=stmt.executeUpdate("insert into t_user values(1,'张三','8888888',18)");
		//5、关闭资源,  后使用先关闭
		stmt.close();
		conn.close();
	}
}
