package com.forum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final public class CopyOfConnectionUtil {

	/**
	 * 
	 */
	private CopyOfConnectionUtil() {
	}

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:aviso");
		return con;
	}

	public static Connection getConnectionFromDB2()
			throws ClassNotFoundException, SQLException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:aviso-pre");
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
	
	public static ResultSet executeQuery(Connection connection,String query)
			throws ClassNotFoundException, SQLException {
		Statement st = null;
		ResultSet executeQuery = null;
		try {
			st = connection.createStatement();
			executeQuery = st.executeQuery(query);
		} finally {
			 /*if(st !=null){
				 st.close(); 
			 }*/
		}
		return executeQuery;
	}
	
	public static Boolean executeInsert(String query)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement st = null;
		Boolean executeQuery = null;
		try {
			connection = getConnection();
			st = connection.createStatement();
			executeQuery = st.execute(query);
		} finally {
			 if(connection !=null){ connection.close(); } if(st !=null){
			 st.close(); }
		}
		return executeQuery;
	}
	
	public static Boolean executeInsert(Connection connection,String query)
			throws ClassNotFoundException, SQLException {
		Statement st = null;
		Boolean executeQuery = null;
		try {
			connection = getConnection();
			st = connection.createStatement();
			executeQuery = st.execute(query);
		} finally {
			/*
			 * if(connection !=null){ connection.close(); }*/ 
			 /*if(st !=null){
			 st.close(); }*/
		}
		
		return executeQuery;
	}

	public static ResultSet executeQueryFromDB2(String query)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement st = null;
		ResultSet executeQuery = null;

		try {
			connection = getConnectionFromDB2();
			st = connection.createStatement();
			executeQuery = st.executeQuery(query);
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (st != null) {
				st.close();
			}
		}
		return executeQuery;
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
}
