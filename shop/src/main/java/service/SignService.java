package service;

import java.sql.Connection;
import java.sql.SQLException;

import repository.DBUtil;
import repository.SignDao;

public class SignService {
	private DBUtil dbUtil;
	private SignDao signDao;
	// return
	// true : 사용 가능한 아이디
	// false : 사용 불가한 아이디
	public boolean idCheck(String id) {
		boolean result = false;
		Connection conn = null;
		
		System.out.println("SignService");
		this.signDao = new SignDao();
		this.dbUtil = new DBUtil();
		
		try {
			conn = new DBUtil().getConnection();
			System.out.println("SignService.java idCheck conn : " + conn);
			conn.setAutoCommit(false);
			// idcheck 실행 시 null(중복없음)확인 시 사용가능
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
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
}
