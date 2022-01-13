package org.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	// 요청 url 실제 실행할 서블릿등록
	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		list = new HashMap<String, Controller>();
		list.put("/home.do", new HomeController());
		list.put("/login.do", new loginController());
		list.put("/memberList.do", new memberListController());
		list.put("/requestInfo.do", new RequestInfoController());
		
		//게시글 관련
		list.put("/commentServ.do",new CommentController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String uri=req.getRequestURI();//localhost/edu/home.do
		
		String contextPath= req.getContextPath();//최상위 경로 edu가져옴
		String path=uri.substring(contextPath.length());
		Controller control = list.get(path);
		
		System.out.println("url:"+uri+",context:"+contextPath+",path:"+path);
		try {
			control.execute(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * @Override public void destroy() { // TODO Auto-generated method stub
	 * //super.destroy(); System.out.println("destroy"); }
	 */
}
