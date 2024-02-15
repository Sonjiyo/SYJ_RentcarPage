package com.basic.rentcar.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Reservation;

public class DeleteUserController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("id");

		String ctx = req.getContextPath();
		
		UserDAO.getInstance().deleteUser(id);
		ArrayList<Reservation> list = ReservationDAO.getInstance().getUserReserveList(id);
		for(Reservation r : list) {
			RentCarDAO.getInstance().updateQty(r.getQty(), r.getNo());
			ReservationDAO.getInstance().deleteResevation(r.getReserve_seq());
		}
		
		if(!((String)session.getAttribute("log")).equals("admin")) {
			session.setAttribute("log", null);			
		}
		
		return "<script>alert('회원탈퇴 완료');location.href='"+ctx+"/main.do'</script>";
	}

}
