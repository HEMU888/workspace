package com.hemu.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hemu.mvcapp.db.JdbcUtils;

public class DAO<T> {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public DAO() {
		Type superClass = getClass().getGenericSuperclass();
		
		if (superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)superClass;
			Type [] typeArgs = parameterizedType.getActualTypeArguments();
			if(typeArgs != null &&typeArgs.length > 0) {
				if(typeArgs[0] instanceof Class) {
					clazz = (Class<T>)typeArgs[0];
				}
			}
		}
	}
	
	/**
	 * 返回某一个字段的值
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql, Object ...args) {
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return (E)queryRunner.query(connection, sql, new ScalarHandler<E>(), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
			System.out.println("success!");
		}
		return null;
	}
	 
	/**
	 * 返回T对应的List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object ...args) {
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
			System.out.println("success!");
		}
		
		return null;
	}
	/**
	 * 返回对应的T的一个实例类的对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object ...args) {
		Connection connection = null;
		
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
			System.out.println("success!");
		}
		
		return null;
	}
	
	
	/**
	 * 封装INSERT,DELETE,UPDATE操作
	 * @param sql ：SQL语句
	 * @param args ： 参数
	 */
	public void update(String sql, Object ...args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
			System.out.println("success!");
		}
	}
}
