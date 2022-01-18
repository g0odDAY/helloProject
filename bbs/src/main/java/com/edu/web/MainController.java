package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;

public class MainController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String welcom="반갑습니다,";
		req.setAttribute("msg", welcom);
		req.getRequestDispatcher("member/memberList.tiles").forward(req, res);
	}

}
