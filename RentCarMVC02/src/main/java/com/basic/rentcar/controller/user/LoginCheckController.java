package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class LoginCheckController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ctx = req.getContextPath();
		if(req.getParameter("id")==null) {
			req.setAttribute("content", "user/login.jsp");
			return "main";
		}
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(UserDAO.getInstance().loginCheck(id, pw)) {
			HttpSession session = req.getSession();
			session.setAttribute("log", id);
			return "<script>console.log('로그인 성공');location.href='"+ctx+"/main.do';</script>";			
		}else {
			return "<script>console.log('로그인 실패');location.href='"+ctx+"/main.do';</script>";					
		}
	}
	
}
