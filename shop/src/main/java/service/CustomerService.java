package service;

import java.sql.Connection;
import java.sql.SQLException;

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
			
			CustomerDao customerDao = new CustomerDao();
			if(customerDao.deleteCustomer(conn, paramCustomer)!=1) {
				throw new Exception();
			}
			OutIdDao OutIdDao = new OutIdDao();
			if(OutIdDao.insertOutId(conn, paranCustomer.getCustomerId())!=1) {
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
			
		}
	}
}
