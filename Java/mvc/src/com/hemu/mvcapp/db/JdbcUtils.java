package com.hemu.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @author hemu
 * JDBC 操作的工具类
 */
public class JdbcUtils {
	
	/**
	 * 释放数据库链接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static DataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource("mvcapp");
	}

	/**
	 * 获取链接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
