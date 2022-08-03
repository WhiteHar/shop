package dao;

public class CustomerDao {

	
	
	
	
	
	
	
	finally {
		if(rs!=null) {rs.close();}
		if(stmt!=null) {stmt.close();}
		if(conn!=null) {conn.close();}
	}
}
