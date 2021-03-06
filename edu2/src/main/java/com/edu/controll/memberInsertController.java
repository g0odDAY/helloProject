package com.edu.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;
import com.edu.model.MemberVO;

public class memberInsertController implements Controller {

	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//사용자가 입력한값을 읽고 디비에 반영. 결과를 결과페이지에 전송
		String id=req.getParameter("id");
		String passwd=req.getParameter("passwd");
		String name=req.getParameter("name");
		String mail=req.getParameter("mail");
		
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		vo.setMail(mail);
		MemberDAO dao = new MemberDAO();
		dao.insertMember(vo);
		req.setAttribute("member",vo);//요청정보에 vo속성에
		req.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(req, res);
		
	}

}
