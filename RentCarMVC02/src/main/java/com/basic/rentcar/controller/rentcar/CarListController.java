package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class CarListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		
		if(req.getParameter("category")==null || req.getParameter("category").equals("all")) {
			list =  RentCarDAO.getInstance().getRentCarList();

		}else {
			int category = Integer.parseInt(req.getParameter("category"));
			req.setAttribute("category", category);
			list =  RentCarDAO.getInstance().getCategoryRentCarList(category);
		}
		
		req.setAttribute("size", list.size());
		req.setAttribute("list", list);
		req.setAttribute("content", "rentcar/rentCarList.jsp");
		return "main";
	}

}
