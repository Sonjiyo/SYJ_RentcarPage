package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;
import com.basic.rentcar.vo.Reservation;

public class ReservateCarController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		int qty = Integer.parseInt(req.getParameter("cnt"));
		
		int no = ((Rentcar) session.getAttribute("vo")).getNo();
		int price = ((Rentcar) session.getAttribute("vo")).getPrice();
		System.out.println(no);
		String id = (String)session.getAttribute("log");
		
		int dday = Integer.parseInt(req.getParameter("dday"));
		String rday = req.getParameter("rday");
		int usein = req.getParameter("usein") !=null ? 1 : 0;
		int usewifi = req.getParameter("usewifi") !=null ? 1 : 0;
		int usenavi = req.getParameter("usenavi") !=null ? 1 : 0;
		int useseat = req.getParameter("useseat") !=null ? 1 : 0;

		int totalPrice = qty*(price*dday+(usein==1 ? 10000*qty : 0)
					+(usewifi==1 ? 10000*qty : 0)+(useseat==1 ? 10000*qty : 0));
		int optionPrice = (usein==1 ? 10000*qty : 0)+(usewifi==1 ? 10000*qty : 0)+(useseat==1 ? 10000*qty : 0);
		
		Reservation re = new Reservation(0, no, id, qty, dday, rday, usein, usewifi, usenavi, useseat, totalPrice);
		ReservationDAO.getInstance().inputReservation(re);
		
		RentCarDAO.getInstance().updateQty((qty*-1), no);
		
		req.setAttribute("optionPrice", optionPrice);
		req.setAttribute("reservation", re);
		
		req.setAttribute("content", "rentcar/reserveCarView.jsp");
		return "main";
	}

}
