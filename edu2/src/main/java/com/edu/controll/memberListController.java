package com.edu.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;

public class memberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// res.sendRedirect("./member/memberList.jsp");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.getRequestDispatcher("member/memberList.jsp").forward(req, res);
	}

}
