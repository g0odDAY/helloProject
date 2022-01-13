package org.edu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class memberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String method = req.getMethod();
		String result="";
		if(method.equals("GET")) {
			result=doGet();
		}else if(method.equals("POST")) {
			result=doPost();
		}
		// [{"id":1,"name":"hong"},{"id":1,"name":"hong"},{"id":1,"name":"hong"}]
		String id = req.getParameter("id");
		String name=req.getParameter("name");
		String score=req.getParameter("score");
		res.setContentType("text/json;charset=utf-8");
		String json=" [{\"id\":1,\"name\":\"hong\"},{\"id\":2,\"name\":\"park\"},{\"id\":3,\"name\":\"cha\"},{\"id\":"+id+",\"name\":\""+name+"\"},{\"id\":5,\"name\":\""+result+"\"}]";
		res.getWriter().print(json);
	}
	
	public String doGet() {
		return "Get방식 호출";
	}
	public String doPost() {
		return "Post방식 호출";
	}

}
