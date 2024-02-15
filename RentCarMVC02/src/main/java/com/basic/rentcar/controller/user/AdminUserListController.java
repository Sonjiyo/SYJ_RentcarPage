package com.basic.rentcar.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.User;

public class AdminUserListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<User> list = UserDAO.getInstance().getUserList();
		
		req.setAttribute("list", list);
		req.setAttribute("content", "user/admin.jsp");
		return "main";
	}

}
