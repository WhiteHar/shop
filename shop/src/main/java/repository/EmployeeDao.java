package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Employee;

public class EmployeeDao {
	public Employee login(Employee employee) throws Exception{
		Employee loginEmployee = null;
		String sql = "SELECT employee_id, employee_name FROM employee WHERE employee_id=? AND employee_pass=PASSWORD(?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DBUtil dbUtil = new DBUtil();
		try {
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, employee.getId());
			stmt.setString(2, employee.getPass());
			// 디버깅
			System.out.println("loginEmployee method stmt : " + stmt);
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
			// 디버깅
			System.out.println("EmployeeDao.java stmt : " + stmt);
			row = stmt.executeUpdate();
		}finally {
			if(stmt!=null) {stmt.close();}
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
			stmt.setString(1, employee1.getId());
			stmt.setString(2, employee1.getPass());
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
	
	public int insertEmployee(Connection conn, Employee paramEmployee) throws Exception {
		int row = 0;	//리턴값
		String sql = "INSERT INTO employee (employee_id, employee_pass, employee_name, update_date, create_date) VALUES (?,PASSWORD(?),?,NOW(),NOW())";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paramEmployee.getId());
			stmt.setString(2, paramEmployee.getPass());
			stmt.setString(3, paramEmployee.getName());
			// 디버깅
			System.out.println("EmployeeDao.java insertEmployee stmt : " + stmt);
			
			row = stmt.executeUpdate();
		} finally {
			if(stmt != null) { stmt.close(); }
		}
		return row;
	}
	
	public Employee selectEmployeeByIdAndPw(Connection conn, Employee employee) throws Exception {
		Employee loginEmployee = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT employee_id employeeId, employee_name employeeName FROM employee WHERE employee_id = ? and employee_pass = PASSWORD(?) and active = 'Y'";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee.getId());
			stmt.setString(2, employee.getPass());
			// 디버깅
			System.out.println("loginEmployee method stmt : " + stmt);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				loginEmployee = new Employee();
				loginEmployee.setId(rs.getString("employeeId"));
				loginEmployee.setName(rs.getString("employeeName"));
				// 디버깅
				System.out.println("loginEmployee method employeeId : " + loginEmployee.getId());
				System.out.println("loginEmployee method employeeName : " + loginEmployee.getId());
			}
		} finally {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
		}
		
		
		return loginEmployee;
	}
	
	public int updateActiveById(Connection conn, String employeeId, String active) throws Exception {
		int row = 0;
		String sql = "UPDATE employee SET active = ?, update_date = now() WHERE employee_id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, active);
			stmt.setString(2, employeeId);
			// 디버깅
			System.out.println("EmployeeDao updateActiveById stmt : " + stmt);

			row = stmt.executeUpdate();
		} finally {
			if(stmt != null) { stmt.close(); }
		}
		
		return row;
	}
		

	public int lastPage(Connection conn) throws Exception {
		int lastPage = 0;
		String sql = "SELECT COUNT(*) count FROM employee";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			// 디버깅
			System.out.println("EmployeeDao lastPage stmt : " + stmt);
			rs = stmt.executeQuery();
			if(rs.next()) {
				lastPage = rs.getInt("count");
			}
		} finally {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
		}
				
		return lastPage;
	}
	
	public List<Employee> selectEmployeeList(Connection conn, final int rowPerPage, final int beginRow) throws Exception {
		List<Employee> list = new ArrayList<Employee>();
		String sql = "SELECT employee_id employeeId, employee_name employeeName, create_date createDate, update_date updateDate, active FROM employee limit ?,?";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			// 디버깅
			System.out.println("EmployeeDao selectEmployeeList stmt : " + stmt);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getString("employeeId"));
				employee.setName(rs.getString("employeeName"));
				employee.setCreate_date(rs.getString("createDate"));
				employee.setUpdate_date(rs.getString("updateDate"));
				employee.setActive(rs.getString("active"));
				// list에 담기
				list.add(employee);
			}
		} finally {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
		}
		
		return list;
	}	
	
	
}
