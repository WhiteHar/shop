package service;

import java.sql.Connection;
import java.sql.SQLException;

import repository.DBUtil;
import repository.SignDao;

public class SignService {
	private SignDao signDao;
	// return
	// true : 사용 가능한 아이디
	// false : 사용 불가한 아이디
	public boolean idCheck(String id) {
		boolean result = false;
		Connection conn = null;
		System.out.println("SignService");
		
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(result);
			this.signDao = new SignDao();
			if(signDao.idCheck(conn, id)==null) {
				result = true;
			}
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
}
