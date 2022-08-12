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
			rs = stmt.executeQuery();
			
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
	
	
	
	public int deleteEmployee(Connection conn, Employee paramEmployee) throws Exception{
		String sql = "DELETE FROM employee WHERE employee_id= ? AND employee_pass=PASSWORD(?)";
		int row = 0;
		PreparedStatement stmt = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramEmployee.getId());
			stmt.setString(2, paramEmployee.getPass());
			row = stmt.executeUpdate();
		}finally {
			stmt.close();
		}
		return row;
	}
		
	
	
	public Employee selectEmployeeOne(String EmployeeId) throws Exception{
		Employee employee1 = null;
		String sql = "SELECT employee_id, employee_pass, employee_name, create_Date FROM employee WHERE employee_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, EmployeeId);
			rs = stmt.executeQuery();
		
			if(rs.next()) {
				employee1 = new Employee();
				employee1.setId(rs.getString("employee_id"));
				employee1.setName(rs.getString("employee_name"));
				employee1.setCreate_date(rs.getString("create_date"));
			}
		}finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}
		return employee1;
	
		
	}
	
}
