package com.gdedu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *
 * 项目名称：School-Oracle 类名称：JdbcUtil 类描述： 创建人：ASUS 创建时间：2017年7月9日 上午9:54:11
 * 修改人：ASUS 修改时间：2017年7月9日 上午9:54:11 修改备注：
 * 
 * @version
 *
 */
public class JdbcUtil {
	/*private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:MLDN";
	private static String userName = "school";
	private static String password = "school";

	//加载驱动，只需要一次
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
