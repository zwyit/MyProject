package com.zwy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JDBCTest {
	public static void main(String[] args) throws Exception {
		//1.ע������
//		DriverManager.registerDriver(new Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2.�������
		String url="jdbc:mysql://localhost:3306/day07";
		//����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
		String user="root";
		String password="root";
		Connection conn=DriverManager.getConnection(url, user, password);
		//3.��÷���sql�Ķ���
		Statement stmt=conn.createStatement();
		String sql="select * from user";
		ResultSet rs=stmt.executeQuery(sql);
		//������
		while(rs.next()){
			int id=rs.getInt("id");
			String name = rs.getString("username");
			String pwd = rs.getString("password");
			System.out.println(id+"--"+name+"--"+pwd);
		}
		//�ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
}
