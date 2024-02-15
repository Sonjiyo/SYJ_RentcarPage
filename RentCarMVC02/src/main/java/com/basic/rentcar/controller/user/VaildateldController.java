package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class VaildateldController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String passData = UserDAO.getInstance().idCheck(id) ? "notValid" : "valid";
		
		resp.getWriter().print(passData);
		
		return null;
	}

}
