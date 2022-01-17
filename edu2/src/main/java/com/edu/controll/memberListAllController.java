package com.edu.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;
import com.edu.model.MemberVO;

public class memberListAllController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.getMemberList();
		req.setAttribute("list", list);
		RequestDispatcher rs=req.getRequestDispatcher("memberResult/memberListOutput.jsp");
		rs.forward(req, res);
	}

}
