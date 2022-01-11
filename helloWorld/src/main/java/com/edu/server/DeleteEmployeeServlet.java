package com.edu.server;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.emp.EmpDAO;


@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String delID=request.getParameter("emp_id");
		String result="";
		EmpDAO dao = new EmpDAO();
		try {
			if(dao.deleteEmployee(delID)) {
				//{"retCode":"Success","retVal":"정상적으로 처리됨"}
				result="{\"retCode\":\"Success\",\"retVal\":\"정상적으로 처리됨\"}";
			}else {
				//{"retCode":"fail","retVal":"조회된 데이터가 없습니다."}
				result ="{\"retCode\":\"fail\",\"retVal\":\"조회된 데이터가 없습니다.\"}";
			}
			
		} catch (SQLException e) {
			// {"retCode":"Fail","retVal":"errorMsg"}
			e.printStackTrace();
			result="{\"retCode\":\"Fail\",\"retVal\":\"errorMsg\"}";
		}
		response.getWriter().println(result);
	}

}
