package service;

import java.sql.Connection;

import repository.SignDao;

public class SignService {
	private SignDao signDao;
	// return
	// true : 사용 가능한 아이디
	// false : 사용 불가한 아이디
	public boolean idCheck(String id) {
		this.signDao = new SignDao();
		Connection conn = null;
		
		try {
			if(signDao.idCheck(null, id) == null) {
				rs = true;
			}
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			
			
			// conn --
		}
		signDao.idCheck(null, id);
	}
}
