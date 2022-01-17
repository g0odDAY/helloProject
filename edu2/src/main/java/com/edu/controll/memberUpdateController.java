package com.edu.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;
import com.edu.model.MemberVO;

public class memberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String passwd=req.getParameter("passwd");
		String name=req.getParameter("name");
		String mail=req.getParameter("mail");
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setMail(mail);
		vo.setName(name);
		
		MemberDAO dao= new MemberDAO();
		dao.updateMember(vo);
		
		req.getRequestDispatcher("memberResult/memberUpdateOutput.jsp").forward(req, res);
	}

}
