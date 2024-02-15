package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class UpdateUserController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ctx = req.getContextPath();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("log");
		String[] hobbyList = req.getParameterValues("hobby");
		String hobby= "";
		for(String h : hobbyList) {
			hobby+=h+",";
		}
		hobby = hobby.substring(hobby.length()-1);
		String job = req.getParameter("job");
		int age = Integer.parseInt(req.getParameter("age"));
		String info = req.getParameter("info");
		
		UserDAO.getInstance().updateUser(id,hobby, job, age, info);
		
		return "<script>alert('정보수정 완료');location.href='"+ctx+"/main.do'</script>";
	}

}
