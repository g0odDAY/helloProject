package com.edu.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;
import com.edu.model.MemberVO;

public class memberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// id검색결과
	String id =	req.getParameter("id");
	MemberDAO dao=new MemberDAO();
	MemberVO vo=dao.getMember(id);
	req.setAttribute("member", vo);
	String job=req.getParameter("job");
	String path="";
	if(job.equals("delete")) {
		path="memberView/memberDelete.jsp";
	}else if(job.equals("update")){
		path="memberView/memberUpdate.jsp";
	}else if(job.equals("search")){
		path="memberResult/memberSearchOutput.jsp";
	}
	
	req.getRequestDispatcher(path).forward(req, res);
	}

}
