package org.edu.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		out.print("<h2>요청정보</h2>");
		out.print("<h3>요청 컨텐트"+req.getContentType()+"</h3>");
		out.print("<h3>요청 방식"+req.getMethod()+"</h3>");
		out.print("<h3>요청 url:"+req.getRequestURI()+"</h3>");
		out.print("<h3>요청세선:"+req.getSession()+"</h3>");
		res.sendRedirect("index.jsp");//**

	}

}
