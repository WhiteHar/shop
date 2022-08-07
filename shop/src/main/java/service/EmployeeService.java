package service;
import java.sql.*;
import repository.DBUtil;
import repository.EmployeeDao;
import repository.OutIdDao;
import vo.Employee;

public class EmployeeService {
	public boolean removeEmployee(Employee paramEmployee) {
		Connection conn = null;
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			// delete
			EmployeeDao employeeDao = new EmployeeDao();
			if(employeeDao.deleteEmployee(conn, paramEmployee)!=1) {
				throw new Exception();
			}
			OutIdDao outIdDao = new OutIdDao();
			if(outIdDao.insertOutId(conn, paramEmployee.getId())!=1) {
				throw new Exception();
			}
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			return false;
			
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	
	
	public Employee login(Employee employee) throws Exception{
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee1 = employeeDao.login(employee);
		return employee1;
	}
}
