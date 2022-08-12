package repository;

import java.sql.*;
import vo.*;

public class SignDao {
	public String idCheck(Connection conn, String id) throws Exception {
		String ckId = null;
		System.out.println("signDao");
		String sql = "SELECT FROM(	SELECT customer_id id FROM customer UNION SELECT employee_id id FROM employee UNION SELECT out_id id FROM out_id) t WHERE t.id = ?";
		/*
		 SELECT 
		 FROM(	SELECT customer_id id FROM customer
		  		UNION
		  		SELECT employee_id id FROM employee
		  		UNION
		  		SELECT out_id id FROM out_id) t
		  WHERE t.id = ?
		  -> null일 때 사용 가능한 아이디
		  
		  if(rs != null){
		  	rs.close();
		  }
		  */
		
		// null이면 사용 가능
		// null이 아니면 사용 불가
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				ckId = rs.getString("t.id");
			}
		}finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
		}
				
		// rs생성
		// if(rs!=null){
		// rs.close(); }
		System.out.println(ckId);
		return ckId;
	}
}
