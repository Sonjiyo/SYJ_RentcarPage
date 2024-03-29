package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontController.Controller;

public class MainController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String content = req.getParameter("content");
		if(content==null) content = "parts/mainContent.jsp";
		
		req.setAttribute("content", content);
		
		return "main";
	}

}
