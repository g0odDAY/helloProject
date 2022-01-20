package com.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.web.BulletinAddController;
import com.edu.web.BulletinDeleteController;
import com.edu.web.BulletinFormController;
import com.edu.web.BulletinListController;
import com.edu.web.BulletinSelectController;
import com.edu.web.BulletinUpdateController;
import com.edu.web.LogOutController;
import com.edu.web.LoginController;
import com.edu.web.LoginFormController;
import com.edu.web.MainController;
import com.edu.web.NoticeAddController;
import com.edu.web.NoticeDeleteController;
import com.edu.web.NoticeFormController;
import com.edu.web.NoticeListController;
import com.edu.web.NoticeSelectController;
import com.edu.web.NoticeUpdateController;
import com.edu.web.ReplyDeleteController;
import com.edu.web.ReplyRegisterController;
import com.edu.web.ReplySelectController;



public class FrontController extends HttpServlet{
	Map<String,Controller> map=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String,Controller>();
	map.put("/main.do", new MainController());
	//게시판 컨트롤
	map.put("/bulletinList.do", new BulletinListController());
	map.put("/bulletinForm.do", new BulletinFormController());
	map.put("/bulletinAdd.do",new BulletinAddController());
	map.put("/bulletinUpdate.do", new BulletinUpdateController());
	map.put("/bulletinSelect.do", new BulletinSelectController());
	map.put("/bulletinDelete.do", new BulletinDeleteController());
	//공지사항
	map.put("/noticeList.do", new NoticeListController());
	map.put("/noticeForm.do", new NoticeFormController());
	map.put("/noticeAdd.do", new NoticeAddController());
	map.put("/noticeSelect.do", new NoticeSelectController());
	map.put("/noticeUpdate.do",new NoticeUpdateController());
	map.put("/noticeDelete.do", new NoticeDeleteController());
	
	//댓글
	map.put("/replySelect.do", new ReplySelectController());
	map.put("/replyRegister.do", new ReplyRegisterController());
	map.put("/replyDelete.do", new ReplyDeleteController());
	
	//회원
	map.put("/loginForm.do", new LoginFormController());
	map.put("/login.do", new LoginController());
	map.put("/logOut.do", new LogOutController());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String uri=req.getRequestURI(); // /edu2/memberList.do
		String context = req.getContextPath();// /edu2
		String path = uri.substring(context.length());
		Controller control = map.get(path);
		control.execute(req, resp);
	}
	
}
