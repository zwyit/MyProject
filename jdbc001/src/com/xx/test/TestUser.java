package com.xx.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUser {
	//jdbcʵ���û�����
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		//1��ע�����ݿ�����
		Class.forName("oracle.jdbc.OracleDriver");
		//2����ȡ���ݿ�����  url�����ݿ�����ӵ�ַ ,user�����ݿ����֣�password�����ݿ�����
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		//3������������Statement
		Statement stmt=conn.createStatement();
		//4��ִ��sql (insert,delete,update)������executeUpdate()����
		int result=stmt.executeUpdate("insert into t_user values(1,'����','8888888',18)");
		//5���ر���Դ,  ��ʹ���ȹر�
		stmt.close();
		conn.close();
	}
}
