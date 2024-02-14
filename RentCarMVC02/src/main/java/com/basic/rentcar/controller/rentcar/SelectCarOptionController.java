package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class SelectCarOptionController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("content", "rentcar/carOption.jsp");
		return "main";
	}

}
