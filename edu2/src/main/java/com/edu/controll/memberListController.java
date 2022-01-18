package com.edu.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;
import com.edu.model.MemberVO;

public class memberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// res.sendRedirect("./member/memberList.jsp");
		/*String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		req.getRequestDispatcher("member/memberList.jsp").forward(req, res);*/
		/// 전체조회 수정 밑에 내용들
				MemberDAO dao = new MemberDAO();
				List<MemberVO> list = dao.getMemberList();
				
				req.setAttribute("memberList", list); //속성 추가.
				req.getRequestDispatcher("memberResult/memberListOutput.jsp").forward(req, res);

	}

}
