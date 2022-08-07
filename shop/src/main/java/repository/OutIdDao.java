package repository;

import java.sql.*;

public class OutIdDao {
	public int insertOutId(Connection conn, String customerId) throws Exception{
		String sql = "INSERT INTO outid(out_id, out_date) VALUE(?,NOW())";
		int row = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customerId);
			row = stmt.executeUpdate();
		}finally {
			stmt.close();
		}
		return row;
	}
}
