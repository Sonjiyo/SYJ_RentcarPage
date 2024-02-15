package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.User;

public class JoinUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getParameter("id")==null) {
			req.setAttribute("content", "user/join.jsp");
			return "main";
		}
		String ctx = req.getContextPath();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String[] hobbyList = req.getParameterValues("hobby");
		String hobby= "";
		for(int i=0; i<hobbyList.length; i++) {
			hobby+=hobbyList[i]+",";
		}
		System.out.println(hobby);
		hobby = hobby.substring(0,hobby.length()-1);
		String job = req.getParameter("job");
		int age = Integer.parseInt(req.getParameter("age"));
		String info = req.getParameter("info");
		
		User user = new User(0, id, pw, email, tel, hobby, job, age, info);
		UserDAO.getInstance().joinUser(user);
		
		return "<script>alert('회원가입 완료');location.href='"+ctx+"/main.do'</script>";
	}

}
