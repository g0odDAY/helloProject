package com.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.micol.prj.command.LogOut;
import com.micol.prj.command.Login;
import com.micol.prj.command.LoginForm;
import com.micol.prj.command.MainCommand;
import com.micol.prj.common.Command;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String,Command> map=new HashMap<String,Command>();   

    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("/main.do",new MainCommand());
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/logOut.do", new LogOut());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		String contextPath=request.getContextPath();
		String page=uri.substring(contextPath.length());
		Command command=map.get(page);
		String viewPage = command.exec(request, response);
		System.out.println("viewPage : "+viewPage);
		if(viewPage != null && !viewPage.endsWith(".do")) {
			viewPage="WEB-INF/views/"+viewPage+".jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
