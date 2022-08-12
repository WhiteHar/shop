package repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {
	// 5-2) 주문 상세보기
	public Map<String, Object> selectOrdersOne(Connection conn, int ordersNo){
		Map<String, Object> map = null;
		/*
		SELECT
		o.	,
		g.	,
		c.	,
		FROM orders o INNER JOIN goods g
		ON o.goods_no = g.goods_no
			INNER JOIN customer c
		WHERE  ON o.customer_Id = c.customer_id
		


		 */
		
		
		return map;
	}
	
	
	
	
	// 5-1) 전체 주문 목록(관리자)
	public List<Map<String, Object>> selectOrdersList(Connection conn, int rowPerPage, int beginRow){
		List<Map<String, Object>> list = new ArrayList<>();	// 다형성
		
		/*
		 SELECT
		 o.	,
		 g.	,
		 FROM orders o INNER JOIN goods g
		 ON o.goods_no = g.goods_no
		 ORDER BY create_date DESC
		 
		 */
		
		
		return list;
		
	}
}
