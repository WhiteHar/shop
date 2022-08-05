package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignDao {
	public String idCheck(Connection conn, String id) {
		String ckId = null;
		String sql = /*
		 SELECT 
		 FROM(	SELECT customer_id id FROM customer
		  		UNION
		  		SELECT employee_id id FROM employee
		  		UNION
		  		SELECT out_id id FROM out_id) t
		  WHERE t.id = ?
		  -> null일 때 사용 가능한 아이디
		  */
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
				
		// rs생성
		// if(rs!=null){
		// rs.close(); }
		return ckId;
	}
}
