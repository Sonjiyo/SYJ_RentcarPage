package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;
import com.basic.rentcar.vo.Reservation;

public class UserReserveListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("log");
		ArrayList<Reservation> list = ReservationDAO.getInstance().getUserReserveList(id);
		ArrayList<Rentcar> carList = new ArrayList<Rentcar>();
		for(int i=0; i<list.size(); i++) {
			carList.add(RentCarDAO.getInstance().getOneRentCar(list.get(i).getNo()));
		}
		
		req.setAttribute("list", list);
		req.setAttribute("carList", carList);
		req.setAttribute("size", list.size());;
		
		req.setAttribute("content", "rentcar/userReserveList.jsp");
		return "main";
	}

}
