package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.NoticeService;
import com.edu.serviceImpl.NoticeDAO;
import com.edu.vo.NoticeVO;

public class NoticeUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String path="notice/noticeList.tiles";
		String id=req.getParameter("id");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		NoticeVO vo=new NoticeVO();
		vo.setNoticeId(id);
		vo.setNoticeTitle(title);
		vo.setNoticeContent(content);
		NoticeService service=new NoticeDAO();
		service.update(vo);
		res.sendRedirect("noticeList.do");
	}

}
