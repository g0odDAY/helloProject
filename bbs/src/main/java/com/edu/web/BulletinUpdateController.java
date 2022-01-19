package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.BulletinVO;

public class BulletinUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		BulletinVO vo=new BulletinVO();
		vo.setBbsId(Integer.parseInt(id));
		vo.setBbsTitle(title);
		vo.setBbsContent(content);
		BulletinService service= new BulletinDAO();
		service.update(vo);
		res.sendRedirect("bulletinList.do");
	}

}
