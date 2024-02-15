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
		String id = req.getParameter("id");
		String[] hobbyList = req.getParameterValues("hobby");
		String hobby= "";
		for(int i=0; i<hobbyList.length; i++) {
			hobby+=hobbyList[i]+",";
		}
		hobby = hobby.substring(0,hobby.length()-1);
		String job = req.getParameter("job");
		int age = Integer.parseInt(req.getParameter("age"));
		String info = req.getParameter("info");
		
		UserDAO.getInstance().updateUser(id,hobby, job, age, info);
		
		return "<script>alert('정보수정 완료');location.href='"+ctx+"/main.do'</script>";
	}

}
