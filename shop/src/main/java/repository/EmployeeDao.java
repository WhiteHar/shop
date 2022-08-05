package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Employee;

public class EmployeeDao {
	public Employee login(Employee employee) throws Exception{
		Employee loginEmployee = null;
		String sql = "SELECT employee_id, employee_name FROM employee WHERE employee_id=? AND employee_pass=PASSWORD(?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, employee.getId());
			stmt.setString(2, employee.getPass());
			
			if(rs.next()) {
				loginEmployee = new Employee();
				loginEmployee.setId(rs.getString("employee_id"));
				loginEmployee.setName(rs.getString("employee_name"));
			}
		}finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}
		return loginEmployee;
	}
}
