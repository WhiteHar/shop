package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.Goods;

public class GoodsDao {
	public int allCount(Connection conn) throws Exception{
		int allCount = 0;
		String sql = "SELECT count(*) count FROM goods";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(sql);
			// 디버깅
			System.out.println("GoodsDao.java lastPage stmt : " + stmt);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				allCount = rs.getInt("count");
			}
			
		} finally {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
		}
		return allCount;
		
	}
	
	public int insertGoods(Connection conn, Goods goods) throws SQLException{
		return 0;
	}

	
	public List<Goods> selectGoodsListByPage(Connection conn, int rowPerPage, int beginRow) throws Exception{
		List<Goods> list = new ArrayList<Goods>();
		/*
		 SELECT goods_no goodsNo
		 From goods
		 ORDER BY goods_no DESC
		 LIMIT ?, ?
		 */
		
		String sql = "SELECT goods_no goodsNo From goods\r\n ORDER BY goods_no DESC LIMIT ?, ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			// 디버깅
			System.out.println("GoodsDao.java selectGoodsListByPage stmt : " + stmt);
			
			rs = stmt.executeQuery();
			/*
			 while(rs.next){
			 	Map<String, Object> m = new HashMap<String, Object>()
			 	m.put("goodsNo", rs.getInt("goodsNo"));
			 }
			 
			 쿼리에서 where 조건이 없다면 반환 타입 List<Map<String, Object>> list
			 */
			while(rs.next()) {
				Goods goods = new Goods();
				goods.setGoodsNo(rs.getInt("goodsNo"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsPrice(rs.getInt("goodsPrice"));
				goods.setUpdateDate(rs.getString("updateDate"));
				goods.setCreateDate(rs.getString("createDate"));
				goods.setSoldOut(rs.getString("soldOut"));
				// 디버깅
				System.out.println("GoodsDao.java selectGoodsListByPage goods : " + goods.toString());
				
				// list에 담기
				list.add(goods);
			}
			
		} finally {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
		}
		
		return list;
	}
	
	public Map<String, Object> selectGoodsAndImgOne(Connection conn, int goodsNo) throws Exception{
		Map<String, Object> map = null;
		
		String sql = "SELECT g.goods_no goodsNo, g.goods_name goodsName, g.goods_price goodsPrice, g.update_date updateDate, g.create_date createDate, g.sold_out soldOut, gi.filename filename, gi.origin_filename originFilename, gi.content_type contentType FROM goods g INNER JOIN goods_img gi ON g.goods_no = gi.goods_no WHERE g.goods_no = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		/*
			SELECT FROM goods g INNER JOIN goods_img gi ON g.goods_no = gi.goods_no WHERE g.goods_no = ?
		 
			
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("goodsNo", rs.getInt("goodsNo"));
			}
		 */
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, goodsNo);
			// 디버깅
			System.out.println("GoodsDao.java selectGoodsAndImgOne stmt : " + stmt);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				map = new HashMap<String, Object>();
				// map에 담기
				map.put("goodsNo", rs.getInt("goodsNo"));
				map.put("goodsName", rs.getString("goodsName"));
				map.put("goodsPrice", rs.getInt("goodsPrice"));
				map.put("updateDate", rs.getString("updateDate"));
				map.put("createDate", rs.getString("createDate"));
				map.put("soldOut", rs.getString("soldOut"));
				map.put("filename", rs.getString("filename"));
				map.put("originFilename", rs.getString("originFilename"));
				map.put("contentType", rs.getString("contentType"));
			}
			
		} finally {
			if(rs != null) { rs.close(); }
			if(stmt != null) { stmt.close(); }
		}
		
		return map;
	}
	
	
}
