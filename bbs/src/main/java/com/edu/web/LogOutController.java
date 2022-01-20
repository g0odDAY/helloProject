package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;

public class LogOutController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s=req.getSession();
		s.invalidate();//session 속성값을초기화
		String path="layout/home.tiles";
		HttpUtil.forward(req, res, path);
	}

}
