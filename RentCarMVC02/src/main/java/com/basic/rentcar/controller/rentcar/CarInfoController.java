package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class CarInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("no"));
		
		Rentcar rentcar = RentCarDAO.getInstance().getOneRentCar(num);
		HttpSession session = req.getSession();
		session.setAttribute("vo", rentcar);
		req.setAttribute("content", "rentcar/rentcarInfo.jsp");
		return "main";
	}

}
