package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;

public class ReplyDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/json;charset=utf-8");
		res.setCharacterEncoding("utf-8");
		String id =req.getParameter("id");
		BulletinService service = new BulletinDAO();
		if(service.deleteReply(Integer.parseInt(id))) {
			res.getWriter().print("{\"retCode\":\"Success\"}");
		}else {
			res.getWriter().print("{\"retCode\":\"Fail\"}");
		}
	}

}
