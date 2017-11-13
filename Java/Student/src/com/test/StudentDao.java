package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public List<Student> getAll(){
		List<Student> Students = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultSet = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///dbtest";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection =  DriverManager.getConnection(url, user, password);
			
			String sql = "select * from Student";
			preparedstatement = connection.prepareStatement(sql);
			
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				Student student = new Student(id, name);
				Students.add(student);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return Students;
	}
	
	public void deleteStudentById( int id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///dbtest";
			String user = "root";
			String password = "root";
			Class.forName(driverClass);
			connection =  DriverManager.getConnection(url, user, password);
			
			String sql = "delete from Student where id = ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
