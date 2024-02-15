package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.util.DBUtil;
import com.basic.rentcar.vo.Rentcar;

public class RentCarDAO {
	private RentCarDAO() {}
	
	
	private static RentCarDAO instance;

	public static RentCarDAO getInstance() {
		if(instance==null) instance = new RentCarDAO();
		return instance;
	}
	
	public ArrayList<Rentcar> getRentCarList(){
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from rentcar";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no =rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				Rentcar r = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return list;
	}
	
	public ArrayList<Rentcar> getCategoryRentCarList(int cate){
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from rentcar where category=?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cate);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no =rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");

				Rentcar r = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return list;
	}
	

	public Rentcar getOneRentCar(int num) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from rentcar where no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while(rs.next()) {
				int no =rs.getInt("no");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				int price = rs.getInt("price");
				int usepeople = rs.getInt("usepeople");
				int total_qty = rs.getInt("total_qty");
				String company = rs.getString("company");
				String img = rs.getString("img");
				String info = rs.getString("info");
				
				Rentcar r = new Rentcar(no, name, category, price, usepeople, total_qty, company, img, info);
				return r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		return null;
	}
	
	public void updateQty(int qty, int no) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "update rentcar set total_qty = total_qty +? where no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qty);
			ps.setInt(2, no);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
	}

}
