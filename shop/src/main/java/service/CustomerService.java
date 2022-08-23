package service;

import java.sql.*;

import repository.CustomerDao;
import repository.DBUtil;
import repository.OutIdDao;
import vo.Customer;

public class CustomerService {
	
	public boolean removeCustomer(Customer paramCustomer ) {
		Connection conn = null;
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false); 	//executeUpdate() 실행 시 자동 커밋을 막음
			
			// delete
			CustomerDao customerDao = new CustomerDao();
			
			if(customerDao.deleteCustomer(conn, paramCustomer)!=1) {
				System.out.println("delete failed");
				throw new Exception();
			}else { 
				System.out.println("delete success");
				}
			
			OutIdDao OutIdDao = new OutIdDao();
			
			if(OutIdDao.insertOutId(conn, paramCustomer.getId())!=1) {
				System.out.println("insert failed");
				throw new Exception();
			}else {
				System.out.println("insert success");
			}
			
			OutIdDao outIdDao = new OutIdDao();
			if(outIdDao.insertOutId(conn, paramCustomer.getId())!= 1) {
				System.out.println("CustomerService removeCustomer : insert 실패");
				throw new Exception();
			} else {
				System.out.println("CustomerService removeCustomer : insert 성공");
			}
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();	// console에 예외메시지 출력
			try {
				conn.rollback();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;	//탈퇴 실패
			
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	
	public Customer login(Customer paramCustomer) throws Exception{
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.login(paramCustomer);
	
		return customer;
	}
	
	public boolean addCustomer(Customer paramCustomer) {
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			// 디버깅
			System.out.println("CustomerService.java addCustomer conn : " + conn);
			conn.setAutoCommit(false);
			
			CustomerDao customerDao = new CustomerDao();
			
			// 디버깅
			if(customerDao.insertCustomer(conn, paramCustomer) == 1) {
				System.out.println("insert success");
			} else {
				System.out.println("insert failed");
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
			// 자원해제
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public Customer getCustomerByIdAndPw(Customer paramCustomer) {
		// 객체 초기화
		Connection conn = null;
		Customer customer = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			// 디버깅
			System.out.println("CustomerService.java getCustomerByIdAndPw conn : " + conn);
			conn.setAutoCommit(false);
			
			CustomerDao customerDao = new CustomerDao();
			customer = customerDao.selectCustomerByIdAndPw(conn, paramCustomer);
			
			// 되었다면 commit
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
		
		return customer;
	}
	
	
	
}
