package com.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReplySelectController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/json;charset=utf-8");
		res.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		BulletinService service=new BulletinDAO();
		List<ReplyVO> rList=service.selectReplyList(Integer.parseInt(id));
		Gson gson=new GsonBuilder().create();
		res.getWriter().println(gson.toJson(rList));
		
	}

}
