package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Customer;

public class CustomerDao {
	public Customer login(Customer customer) throws Exception{
		Customer loginCustomer = null;
		DBUtil dbUtil = new DBUtil();
		String sql = "SELECT customer_id customerId, customer_name FROM customer WHERE customer_id=? AND customer_pass=PASSWORD(?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPass());			
			rs = stmt.executeQuery();
			
			// 디버깅
			System.out.println("loginCustomer method stmt: "+stmt);
			if(rs.next()) {
				loginCustomer = new Customer();
				loginCustomer.setId(rs.getString("customerid"));
				loginCustomer.setName(rs.getString("customerName"));
				// 디버깅
				System.out.println("loginCustomer method customerId : " + loginCustomer.getId());
				System.out.println("loginCustomer method customerName : " + loginCustomer.getName());
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
			// 디버깅
			System.out.println("CustomerDao.java stmt : " + stmt);
			row = stmt.executeUpdate();
		}finally {
			if(stmt!=null) {stmt.close();}
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
	
	public int insertCustomer(Connection conn, Customer paramCustomer) throws Exception {
		int row = 0;
		String sql = "INSERT INTO customer (customer_id, customer_pass, customer_name, customer_address, customer_telephone, update_date, create_date) VALUES (?,PASSWORD(?),?,?,?,NOW(),NOW())";
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			// stmt setter
			stmt.setString(1, paramCustomer.getId());
			stmt.setString(2, paramCustomer.getPass());
			stmt.setString(3, paramCustomer.getName());
			stmt.setString(4, paramCustomer.getAddress());
			stmt.setString(5, paramCustomer.getPhone());
			// 디버깅
			System.out.println("CustomerDao.java insertCustomer stmt : " + stmt);
			
			row = stmt.executeUpdate();
		} finally {
			if(stmt != null) { stmt.close(); }
		}
		
		return row;
	}
	
	
	public Customer selectCustomerByIdAndPw(Connection conn, Customer customer) throws Exception {
		Customer loginCustomer = null;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT customer_id customerId, customer_name customerName FROM customer WHERE customer_id = ? and customer_pass = PASSWORD(?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPass());
			// 디버깅
			System.out.println("CustomerDao.java selectCustomerByIdAndPw stmt : " + stmt);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				loginCustomer = new Customer();
				loginCustomer.setId(rs.getString("customerId"));
				loginCustomer.setName(rs.getString("customerName"));
				// 디버깅
				System.out.println("CustomerDao.java selectCustomerByIdAndPw customerId : " + loginCustomer.getId());
				System.out.println("CustomerDao.java selectCustomerByIdAndPw customerName : " + loginCustomer.getName());
			}
		} finally {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
		}
		
		return loginCustomer;
	}
}
