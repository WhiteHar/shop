package repository;
import java.sql.*;

import vo.Customer;

public class CustomerDao {
	public Customer login(Customer customer) throws Exception{
		Customer loginCustomer = null;
		String sql = "SELECT customer_id, cusstomer_name FROM customer WHERE customer_id=? AND customer_pass=PASSWORD(?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPass());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				loginCustomer = new Customer();
				loginCustomer.setId(rs.getString("customer_id"));
				loginCustomer.setName(rs.getString("customer_name"));
			}
			
		}finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}
		return loginCustomer;
	}
}
