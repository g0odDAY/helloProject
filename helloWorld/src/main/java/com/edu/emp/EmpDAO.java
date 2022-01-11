package com.edu.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;

public class EmpDAO extends DAO {
	
	//전제 리스트
	public List<EmployeeVO> getEmpList(){
		List<EmployeeVO> list=new ArrayList<EmployeeVO>();
		String sql="select * from emp_temp order by 1";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EmployeeVO emp=new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date").substring(0,10));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
		
	}
	//한건 조회.
	public EmployeeVO getEmployee(int eid) {
		String sql="select * from emp_temp where employee_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, eid);
			rs=pstmt.executeQuery();//executeQuery결과값 조회
			if(rs.next()) {
				EmployeeVO emp=new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return null;
	}
	public void insertEmployee(EmployeeVO vo) {
		String sql="insert into emp_temp"
				+ "(employee_id,first_name,last_name,hire_date,email,salary,job_id)"
				+ " values(?,?,?,?,?,?,?)";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmployeeId());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getLastName());
			pstmt.setString(4, vo.getHireDate());
			pstmt.setString(5, vo.getEmail());
			pstmt.setInt(6, vo.getSalary());
			pstmt.setString(7, "IT_PROG");
			int r=pstmt.executeUpdate();
			System.out.println(r+"건 입력됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//한건 입력
	public void insertEmp(EmployeeVO vo) {
		String sql="insert into emp_temp(employee_id,first_name,last_name,email,job_id,hire_date,salary)"
				+ "values(employees_seq.nextval,?,?,?,?,?,?)";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFirstName());
			
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getJobId());
			pstmt.setString(5, vo.getHireDate());
			pstmt.setInt(6, vo.getSalary());
			
			int r=pstmt.executeUpdate();
			System.out.println(r+"건입력");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	public void updateEmp(EmployeeVO vo) {
		// TODO Auto-generated method stub
		String sql="update emp_temp set salary=?,job_id=?,email=? where employee_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSalary());
			pstmt.setString(2, vo.getJobId());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getEmployeeId());
			int r=pstmt.executeUpdate();
			System.out.println(r+"건수정");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	public void deleteEmp(int i) {
		// TODO Auto-generated method stub
		String sql="delete from emp_temp where employee_id=?";
		connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,i);
			
			int r=pstmt.executeUpdate();
			System.out.println(r+"건삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public boolean deleteEmployee(String empId) throws SQLException {
		String sql="delete from emp_temp where employee_id=?";
		connect();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, empId);
		int r = pstmt.executeUpdate();
		System.out.println(r+"건삭제완료");
		
		
		if(r>0) {
			return true;
		}else {
			return false;
		}
	}
}
