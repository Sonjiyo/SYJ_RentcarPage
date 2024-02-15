package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class RentcarInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		
		Rentcar vo = RentCarDAO.getInstance().getOneRentCar(no);
		req.setAttribute("vo", vo);
		
		req.setAttribute("content", "rentcar/updateCarInfo.jsp");
		return "main";
	}

}
