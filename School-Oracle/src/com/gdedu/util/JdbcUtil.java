package com.gdedu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *
 * ��Ŀ���ƣ�School-Oracle �����ƣ�JdbcUtil �������� �����ˣ�ASUS ����ʱ�䣺2017��7��9�� ����9:54:11
 * �޸��ˣ�ASUS �޸�ʱ�䣺2017��7��9�� ����9:54:11 �޸ı�ע��
 * 
 * @version
 *
 */
public class JdbcUtil {
	/*private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:MLDN";
	private static String userName = "school";
	private static String password = "school";

	//����������ֻ��Ҫһ��
	static{
		try {
			
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static Connection getConnection() throws SQLException {
		ComboPooledDataSource ds=new ComboPooledDataSource("school");
		//Connection conn = null;
		//conn = DriverManager.getConnection(url, userName, password);
		//return conn;
		return ds.getConnection();
	}

	private static void freeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void freeStatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void freeResultSet(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void free(Connection conn,Statement statement,ResultSet rs){
		if (conn!=null) {
			freeConnection(conn);
		}
		if (statement!=null) {
			freeStatement(statement);
		}
		if (rs!=null) {
			freeResultSet(rs);
		}
	}
}
