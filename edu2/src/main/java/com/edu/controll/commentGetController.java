package com.edu.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.CommentDAO;
import com.edu.model.CommentVO;

public class commentGetController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		CommentDAO dao=new CommentDAO();		
		CommentVO vo=dao.selectOne(id);
		
		req.setAttribute("comment", vo);
		req.getRequestDispatcher("comment/commentDetail.jsp").forward(req, res);
		
	}

}
