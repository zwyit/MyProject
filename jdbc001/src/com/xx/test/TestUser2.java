package com.xx.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUser2 {
	//jdbc�쳣����
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			//1.ע�����ݿ�����
			Class.forName("oracle.jdbc.OracleDriver");
			//2.��ȡ���ݿ�����
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			//3.����������
			stmt=conn.createStatement();
			//4.sql���
			stmt.executeUpdate("insert into t_user values(2,'����','789098',34)");
			//5.�ر�����
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
