package com.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.micol.prj.common.Command;

public class LogOut implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse res) {
		HttpSession s=req.getSession();
		String name=(String)s.getAttribute("name");
		String author = (String) s.getAttribute("author");
		String id= (String) s.getAttribute("id");
		System.out.println(name+id+author);
		req.setAttribute("msg", name+"님 로그아웃되엇습니다.");
		s.invalidate();
		return "member/memberLogout";
	}

}
