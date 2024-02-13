package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontController.Controller;

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
		String hobby = req.getParameter("hobby");
		String job = req.getParameter("job");
		int age = Integer.parseInt(req.getParameter("age"));
		String info = req.getParameter("info");
		
		return "<script>console.log('회원가입 완료');location.href='"+ctx+"/main.do'</script>";
	}

}
