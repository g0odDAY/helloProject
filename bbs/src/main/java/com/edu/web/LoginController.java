package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.MemberService;
import com.edu.serviceImpl.MemberDAO;
import com.edu.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="member/home.tiles";
		String id=req.getParameter("userId");
		String pw=req.getParameter("userPw");
		MemberService service = new MemberDAO();
		MemberVO member=service.login(id, pw);
		//로그인 성공하면 home페이지로 실패하면 login페이지로
		if(member == null) {
			path="loginForm.do";
			
		}else {
			HttpSession session=req.getSession(true);
			session.setAttribute("sessionId", member.getId());
			session.setAttribute("sessionName", member.getName());
			session.setAttribute("sessionMail", member.getMail());
			
		}
		
		HttpUtil.forward(req, res, path);
	}

}
