package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import vo.Goods;

public class GoodsDao {
	public int insertGoods(Connection conn, Goods goods) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement("INSERT blahblah");
		stmt.executeUpdate();
		if(stmt!=null) {
			stmt.close();
		}
		return 0;
	}
	
	
	
	
	
	
	public List<Goods> selectGoodsListByPage(int rowPerPage, int beginRow){
		/*
		 SELECT goods_no goodsNo
		 From goods
		 ORDER BY goods_no DESC
		 LIMIT ?, ?
		 */
		
		/*
		 while(rs.next){
		 	Map<String, Object> m = new HashMap<String, Object>()
		 	m.put("goodsNo", rs.getInt("goodsNo"));
		 }
		 
		 쿼리에서 where 조건이 없다면 반환 타입 List<Map<String, Object>> list
		 */
		return null; 
	}
}
