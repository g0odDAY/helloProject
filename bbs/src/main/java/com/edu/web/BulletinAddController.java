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

public class BulletinAddController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="bulletinList.do";
		BulletinVO vo=new BulletinVO();
		vo.setBbsWriter(req.getParameter("writer"));
		vo.setBbsContent(req.getParameter("content"));
		vo.setBbsTitle(req.getParameter("title"));
		vo.setBbsImage(req.getParameter("image"));
		
		BulletinService service=new BulletinDAO();
		service.insert(vo);
		HttpUtil.forward(req, res, path);
		
	}

}
