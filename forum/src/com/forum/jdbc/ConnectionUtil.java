package com.forum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;

import com.forum.utils.HibernateUtil;

final public class ConnectionUtil {

	public static Session getSession() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		return session;
	}

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "forum", "forum");
		return con;
	}

	public static ResultSet executeQuery(String query)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement st = null;
		ResultSet executeQuery = null;

		try {
			connection = getConnection();
			st = connection.createStatement();
			executeQuery = st.executeQuery(query);
		} finally {
			/*
			 * if(connection !=null){ connection.close(); } if(st !=null){
			 * st.close(); }
			 */
		}
		return executeQuery;
	}

	public static void closeResultSet(Connection connection, ResultSet rs) {
		try {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {

				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeResultSet(Connection connection, ResultSet rs,
			Statement st) {
		try {
			if (rs != null) {

				rs.close();

			}
			if (connection != null) {
				connection.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	void getScreenData() {
		Session session = null;
		ScreenDataMapping screenConfigData = null;
		try {
			session = ConnectionUtil.getSession();
			session.beginTransaction();
			screenConfigData = (ScreenDataMapping) session.createCriteria(
					ScreenDataMapping.class).uniqueResult();

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
}
