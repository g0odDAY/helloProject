package com.edu.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.CommentDAO;
import com.edu.model.CommentVO;

public class commentUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String name=req.getParameter("name");
		String content=req.getParameter("content");
		//사용자의 변경값을 읽어와서 vo에 저장.
		CommentVO vo = new CommentVO(Integer.parseInt(id),name,content);
		CommentDAO dao = new CommentDAO();
		dao.updateComment(vo);
		//전체 리스트->commentList페이지로 전달.
		List<CommentVO> list= dao.selectAll();
		
		req.setAttribute("commentList", list);
		RequestDispatcher rs = req.getRequestDispatcher("comment/commentList.jsp");
		rs.forward(req, res);
	}

}
