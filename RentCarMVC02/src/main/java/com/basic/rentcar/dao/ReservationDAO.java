package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.util.DBUtil;
import com.basic.rentcar.vo.Reservation;

public class ReservationDAO {
	private ReservationDAO() {}
	
	private static ReservationDAO instance;

	public static ReservationDAO getInstance() {
		if(instance==null) instance = new ReservationDAO();
		return instance;
	}
	
	public ArrayList<Reservation> getUserReserveList(String userId){
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "select * from carreserve where id=?;";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int reserve_seq =rs.getInt("reserve_seq");
				int no = rs.getInt("no");
				String id = rs.getString("id");
				int qty = rs.getInt("qty");
				int dday = rs.getInt("dday");
				String rday = rs.getString("rday");
				int usein = rs.getInt("usein");
				int usewifi = rs.getInt("usewifi");
				int usenavi = rs.getInt("usenavi");
				int useseat = rs.getInt("useseat");
				int totalPrice = rs.getInt("totalPrice");

				Reservation r = new Reservation(reserve_seq, no, id, qty, dday, rday, usein, usewifi, usenavi, useseat, totalPrice);
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return list;
	}
	
	public void inputReservation(Reservation re){
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBUtil.getConnection();
		String sql = "INSERT INTO carreserve VALUES (null,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, re.getNo());
			ps.setString(2, re.getId());
			ps.setInt(3, re.getQty());
			ps.setInt(4, re.getDday());
			ps.setString(5, re.getRday());
			ps.setInt(6, re.getUsein());
			ps.setInt(7, re.getUsewifi());
			ps.setInt(8, re.getUsenavi());
			ps.setInt(9, re.getUseseat());
			ps.setInt(10, re.getTotalPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
	}
}
