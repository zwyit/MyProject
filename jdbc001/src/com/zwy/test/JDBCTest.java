package com.zwy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCTest {
	public static void main(String[] args) throws Exception {
		//1.注册驱动
//		DriverManager.registerDriver(new Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接
		String url="jdbc:mysql://localhost:3306/day07";
		//连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		String user="root";
		String password="root";
		Connection conn=DriverManager.getConnection(url, user, password);
		//3.获得发送sql的对象
		Statement stmt=conn.createStatement();
		String sql="select * from user";
		ResultSet rs=stmt.executeQuery(sql);
		//处理结果
		while(rs.next()){
			int id=rs.getInt("id");
			String name = rs.getString("username");
			String pwd = rs.getString("password");
			System.out.println(id+"--"+name+"--"+pwd);
		}
		//释放资源
		rs.close();
		stmt.close();
		conn.close();
	}
}
