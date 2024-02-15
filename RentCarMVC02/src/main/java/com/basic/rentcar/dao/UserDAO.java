package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.util.DBUtil;
import com.basic.rentcar.vo.User;

public class UserDAO {
	private UserDAO() {}
	
	
	private static UserDAO instance;

	public static UserDAO getInstance() {
		if(instance==null) instance = new UserDAO();
		return instance;
	}
	
	public ArrayList<User> getUserList(){
		ArrayList<User> list = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from member";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num =rs.getInt("no");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String hobby = rs.getString("hobby");
				String job = rs.getString("job");
				int age = rs.getInt("age");
				String info = rs.getString("info");

				User u = new User(num, id, pw, email, tel, hobby, job, age, info);
				
				list.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return list;
	}
	
	public boolean loginCheck(String id, String pw) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from member where id=? and pw=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		
		return false;
	}
	
	public void joinUser(User user) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO member VALUES (null,?,?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPw());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getHobby());
			ps.setString(6, user.getJob());
			ps.setInt(7, user.getAge());
			ps.setString(8, user.getInfo());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
	}
	
	public boolean idCheck(String id) {
		ArrayList<User> list = getUserList();
		boolean check = false;
		for(User u : list) {
			if(u.getId().equals(id)) check = true;
		}
		return check;
	}
	
	public User getOneUser(String id) {
		ArrayList<User> list = getUserList();
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) return list.get(i);
		}
		return null;
	}
}
