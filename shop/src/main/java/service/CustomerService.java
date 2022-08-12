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
				throw new Exception();
			}
			OutIdDao OutIdDao = new OutIdDao();
			if(OutIdDao.insertOutId(conn, paramCustomer.getId())!=1) {
				throw new Exception();
			}
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();	// console에 예외메시지 출력
			try {
				conn.rollback();
			}catch (SQLException e1) {
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
}
