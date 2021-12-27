package com.edu.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String fn=request.getParameter("first_name");
		String ln=request.getParameter("last_name");
		String em=request.getParameter("email");
		String ji=request.getParameter("job_id");
		String hd=request.getParameter("hire_date");
		String sa=request.getParameter("salary");
		
		
		
		
		EmpDAO dao=new EmpDAO();
		EmployeeVO vo = new EmployeeVO();
		vo.setFirstName(fn);
		vo.setLastName(ln);
		vo.setEmail(em);
		vo.setJobId(ji);
		vo.setHireDate(hd);
		vo.setSalary(Integer.parseInt(sa));
		
		dao.insertEmp(vo);
		
		response.getWriter().print("<h2>처리완료</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
