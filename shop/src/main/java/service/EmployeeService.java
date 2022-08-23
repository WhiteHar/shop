package service;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import repository.DBUtil;
import repository.EmployeeDao;
import repository.OutIdDao;
import vo.Employee;

public class EmployeeService {
	private DBUtil dbUtil;
	private EmployeeDao employeeDao;
	
	public boolean removeEmployee(Employee paramEmployee) {
		Connection conn = null;
		
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			
			// delete
			EmployeeDao employeeDao = new EmployeeDao();
			if(employeeDao.deleteEmployee(conn, paramEmployee)!=1) {
				System.out.println("delete failed");
				throw new Exception();
			}else {
				System.out.println("delete success");
			}
			OutIdDao outIdDao = new OutIdDao();
			
			if(outIdDao.insertOutId(conn, paramEmployee.getId())!=1) {
				System.out.println("insert failed");
				throw new Exception();
			}else {
				System.out.println("insert success");
			}
			
			conn.commit();	
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			return false;
			
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
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
	
	public boolean addEmployee(Employee paramEmployee) {
		Connection conn = null;
		
		try {
			conn = dbUtil.getConnection();
			// 디버깅
			System.out.println("EmployeeService.java addEmployee conn : " + conn);
			conn.setAutoCommit(false);
			
			EmployeeDao employeeDao = new EmployeeDao();
			int row = employeeDao.insertEmployee(conn, paramEmployee);
			
			// 디버깅
			if(row == 1) {
				System.out.println("insert success");
			} else {
				System.out.println(" insert failed");
				throw new Exception();
			}
			
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public Employee getEmployeeByIdAndPw(Employee paramEmployee) {
		Connection conn = null;
		Employee employee = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			System.out.println("EmployeeService.java getEmployeeByIdAndPw conn : " + conn);
			conn.setAutoCommit(false);
			
			EmployeeDao employeeDao = new EmployeeDao();
			employee = employeeDao.selectEmployeeByIdAndPw(conn, paramEmployee);
			
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return employee;
	}
	
	public boolean modifyActiveById(String employeeId, String active) {
		// conn 초기화
		Connection conn = null;
		
		try {
			dbUtil = new DBUtil();
			conn = this.dbUtil.getConnection();
			// 디버깅
			System.out.println("EmployeeService.java modifyActiveById conn : " + conn);
			conn.setAutoCommit(false);
			
			this.employeeDao = new EmployeeDao();
			int row = this.employeeDao.updateActiveById(conn, employeeId, active);
			
			if(row == 0) {
				System.out.println("EmployeeService.java modifyActiveById : update 실패");
				throw new Exception();
			}
			
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			// 실패 시 롤백
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
		return true;
	}
	
	public int lastPage() {
		int lastPage = 0;
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			// 디버깅
			System.out.println("EmployeeService.java lastPage conn : " + conn);
			conn.setAutoCommit(false);
			
			this.employeeDao = new EmployeeDao();
			lastPage = this.employeeDao.lastPage(conn);
			if(lastPage == 0) {
				// lastPage가 없다면
				throw new Exception();
			}
			
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
			
		return lastPage;
	}

	public List<Employee> getEmployeeList(final int rowPerPage, final int currentPage) {
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		int beginRow = (currentPage - 1) * rowPerPage;
		
		
		try {
			this.dbUtil = new DBUtil();
			conn = this.dbUtil.getConnection();
			// 디버깅
			System.out.println("EmployeeService.java getEmployeeList conn : " + conn);
			conn.setAutoCommit(false);
			
			this.employeeDao = new EmployeeDao();
			list = this.employeeDao.selectEmployeeList(conn, rowPerPage, beginRow);
			if(list == null) {
				// 리스트 없을 경우
				throw new Exception();
			}
			
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			// 실패 시 롤백
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
}
