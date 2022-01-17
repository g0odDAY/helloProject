package com.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controll.LoginController;
import com.edu.controll.commentAddController;
import com.edu.controll.commentGetController;
import com.edu.controll.commentListController;
import com.edu.controll.commentUpdateController;
import com.edu.controll.memberDeleteController;
import com.edu.controll.memberInsertController;
import com.edu.controll.memberListAllController;
import com.edu.controll.memberListController;
import com.edu.controll.memberSearchController;
import com.edu.controll.memberUpdateController;

public class FrontController extends HttpServlet{
	Map<String,Controller> map=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String,Controller>();
		
		//url 패턴 - 컨트롤러
		map.put("/memberList.do", new memberListController());
		map.put("/memberInsert.do",new memberInsertController());
		map.put("/memberSearch.do", new memberSearchController());
		map.put("/memberDelete.do", new memberDeleteController());
		map.put("/memberUpdate.do",new memberUpdateController());
		map.put("/memberListAll.do", new memberListAllController());
		//댓글관련
		map.put("/commentAdd.do", new commentAddController());
		map.put("/commentList.do", new commentListController());
		map.put("/commentGet.do",new commentGetController());
		map.put("/commentUpdate.do",new commentUpdateController());
		
		//로그인 관련
		map.put("/login.do", new LoginController());
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
