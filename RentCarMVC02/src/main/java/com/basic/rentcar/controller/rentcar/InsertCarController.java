package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertCarController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		String saveDirectory = req.getServletContext().getRealPath("/img");

		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(req, saveDirPath.toString(), 5 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());			
		}catch(Exception e) {
			req.setAttribute("content", "rentcar/insertRentcar.jsp");
			return "main";
		}
		
		if(multi.getParameter("name")==null) {
			System.out.println("d");
			req.setAttribute("content", "rentcar/insertRentcar.jsp");
			return "main";
		}
		String sFileName = null;
		if (multi.getFilesystemName("img") != null) {
			sFileName = multi.getFilesystemName("img");
		}

		String name = multi.getParameter("name");
		int category = Integer.parseInt(multi.getParameter("category"));
		int price = Integer.parseInt(multi.getParameter("price"));
		int usepeople = Integer.parseInt(multi.getParameter("usepeople"));
		int total_qty = Integer.parseInt(multi.getParameter("total_qty"));
		String company = multi.getParameter("company");
		String info = multi.getParameter("info");
	
		
		Rentcar vo = new Rentcar(0, name, category, price, usepeople, total_qty, company, sFileName, info);

		RentCarDAO.getInstance().insertRentcar(vo);
		return "<script>alert('차량등록 완료');location.href='"+ctx+"/adminCarList.do'</script>";
	}

}
