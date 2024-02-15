package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.User;

public class UserInfoController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String log = (String)session.getAttribute("log");
		
		User user = UserDAO.getInstance().getOneUser(log);
		req.setAttribute("vo", user);
		
		req.setAttribute("content", "user/userInfo.jsp");
		return "main";
	}

}
