 package com.hemu.mvcapp.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.hemu.mvcapp.db.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	public void testGetConnection() throws SQLException {
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
