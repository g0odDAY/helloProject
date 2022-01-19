package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.NoticeService;
import com.edu.serviceImpl.NoticeDAO;
import com.edu.vo.NoticeVO;

public class NoticeAddController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="noticeList.do";
		NoticeVO vo=new NoticeVO();
		vo.setNoticeTitle(req.getParameter("nTitle"));
		vo.setNoticeContent(req.getParameter("nContent"));
		NoticeService service=new NoticeDAO();
		service.insert(vo);
		HttpUtil.forward(req, res, path);
	}

}
