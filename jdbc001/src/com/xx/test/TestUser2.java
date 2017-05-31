package com.xx.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUser2 {
	//jdbc异常处理
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			//1.注册数据库驱动
			Class.forName("oracle.jdbc.OracleDriver");
			//2.获取数据库连接
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			//3.创建语句对象
			stmt=conn.createStatement();
			//4.sql语句
			stmt.executeUpdate("insert into t_user values(2,'李四','789098',34)");
			//5.关闭连接
			stmt.close();
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				if(null!=stmt){
					stmt.close();
				}
				if(null!=conn){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
