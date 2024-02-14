package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Reservation;

public class UserReserveListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("log");
		ArrayList<Reservation> list = ReservationDAO.getInstance().getUserReserveList(id);
		
		req.setAttribute("list", list);
		
		req.setAttribute("content", "rentcar/userReserveList.jsp");
		return "main";
	}

}
