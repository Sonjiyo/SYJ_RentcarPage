package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;

public class DeleteRentcarController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		String ctx = req.getContextPath();
		
		RentCarDAO.getInstance().deleteRentcar(no);
		ReservationDAO.getInstance().deleteResevationRentcar(no);
		
		return "re:"+ctx+"/adminCarList.do";
	}

}
