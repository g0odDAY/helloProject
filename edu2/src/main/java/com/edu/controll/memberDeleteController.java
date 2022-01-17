package com.edu.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;

public class memberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 조회된 아이디를 삭제하고 ->memberDeleteOutput.jsp
		String id=req.getParameter("id");
		MemberDAO dao=new MemberDAO();
		dao.deleteMember(id);
		req.getRequestDispatcher("memberResult/memberDeleteOutput.jsp").forward(req, res);
	}

}
