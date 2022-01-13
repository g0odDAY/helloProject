package org.edu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().print("<h3>Login</h3>");
	}

}
