package com.edu.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;
import com.edu.emp.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/InsertEmployeeServlet")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InsertEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String eid= request.getParameter("employee_id");
		String fName=request.getParameter("first_name");
		String lName=request.getParameter("last_name");
		String hireDate=request.getParameter("hire_date");
		String email=request.getParameter("email");
		String salary=request.getParameter("salary");
		//emplist.html 페이지 Ajax(현제 페이지)호출
		// 사용자가 입력한 값
		EmployeeVO vo=new EmployeeVO();
		vo.setEmployeeId(Integer.parseInt(eid));
		vo.setFirstName(fName);
		vo.setLastName(lName);
		vo.setHireDate(hireDate);
		vo.setEmail(email);
		vo.setSalary(Integer.parseInt(salary));
		vo.setJobId("IT_PROG");
		EmpDAO dao = new EmpDAO();
		dao.insertEmployee(vo);
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));
	}

}
