package com.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.micol.prj.common.Command;
import com.micol.prj.member.service.MemberService;
import com.micol.prj.member.serviceImpl.MemberServiceImpl;
import com.micol.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse res) {
		MemberService memberDAO=new MemberServiceImpl();
		HttpSession session=req.getSession();
		MemberVO vo=new MemberVO();
		vo.setId(req.getParameter("id"));
		vo.setPassword(req.getParameter("password"));
		vo =memberDAO.memberSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			req.setAttribute("msg", vo.getName()+"님 환영합니다.");
		}else {
			req.setAttribute("msg", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "member/memberLoginResult";
	}

}
