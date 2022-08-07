package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	
	// 탈퇴
	public int deleteCustomer(Connection conn, Customer paramCustomer) throws Exception{
		String sql = "DELET FROM customer WHERE customer_id=? AND customer_pass = PASSWORD(?)";
		int row = 0;
		PreparedStatement stmt = null;
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, paramCustomer.getId());
			stmt.setString(2, paramCustomer.getPass());
			row = stmt.executeUpdate();
		}finally {
			stmt.close();
		}
		return row;
	}
	
	
	public Customer selectCustomerOne(String customerId) throws Exception{
		Customer customer1 = null;
		String sql = "SELECT customer_id, customer_pass, customer_name, customer_adress, customer_telephone, create_date FROM customer WHERE customer_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, customerId);
			rs =  stmt.executeQuery();
			
			if(rs.next()) {
				customer1 = new Customer();
				customer1.setId(rs.getString("customer_id"));
				customer1.setName(rs.getString("customer_name"));
				customer1.setAddress(rs.getString("customer_adress"));		
				customer1.setPhone(rs.getString("customer_telephone"));
				customer1.setCreate_date(rs.getString("create_date"));
			}
		}finally {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			if(conn!=null) {conn.close();}
		}
		return customer1;
	}
	
}
