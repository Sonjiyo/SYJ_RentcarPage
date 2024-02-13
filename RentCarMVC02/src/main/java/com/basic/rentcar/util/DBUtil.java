package com.basic.rentcar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	
	private DBUtil() {}
	private static DBUtil instance;
	
	public static DBUtil getInstance() {
		if(instance==null) instance = new DBUtil();
		return instance;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		String URL = "jdbc:mysql://localhost:3306/rentcarDB01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void dbClose(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
