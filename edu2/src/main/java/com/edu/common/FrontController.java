package com.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controll.commentAddController;
import com.edu.controll.commentGetController;
import com.edu.controll.commentListController;
import com.edu.controll.commentUpdateController;
import com.edu.controll.memberInsertController;
import com.edu.controll.memberListController;

public class FrontController extends HttpServlet{
	Map<String,Controller> map=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String,Controller>();
		
		//url 패턴 - 컨트롤러
		map.put("/memberList.do", new memberListController());
		map.put("/memberInsert.do",new memberInsertController());
		//map.put("/memberList.do", new memberListController());
		//댓글관련
		map.put("/commentAdd.do", new commentAddController());
		map.put("/commentList.do", new commentListController());
		map.put("/commentGet.do",new commentGetController());
		map.put("/commentUpdate.do",new commentUpdateController());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI(); // /edu2/memberList.do
		String context = req.getContextPath();// /edu2
		String path = uri.substring(context.length());
		Controller control = map.get(path);
		control.execute(req, resp);
	}
	
}
