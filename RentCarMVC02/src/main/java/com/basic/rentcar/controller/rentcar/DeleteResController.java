package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;

public class DeleteResController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int reserve_seq = Integer.parseInt(req.getParameter("reserve_seq"));
		int no = Integer.parseInt(req.getParameter("no"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		String ctx = req.getContextPath();
		
		RentCarDAO.getInstance().updateQty(qty, no);
		ReservationDAO.getInstance().deleteResevation(reserve_seq);
		
		return "re:"+ctx+"/userReserveList.do";
	}

}
