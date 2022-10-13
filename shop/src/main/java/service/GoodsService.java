package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import repository.DBUtil;
import repository.GoodsDao;
import vo.Goods;
import vo.GoodsImg;

public class GoodsService {
	private GoodsDao goodsDao;
	private DBUtil dbUtil;
	
	public Map<String, Object> getGoodsAndImgOne(int goodsNo) {
		Map<String, Object> map = null;
		
		this.dbUtil = new DBUtil();
		this.goodsDao = new GoodsDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			// 디버깅
			System.out.println("GoodsService.java getGoodsAndImgOne conn : " + conn);
			
			map = this.goodsDao.selectGoodsAndImgOne(conn, goodsNo);
			// 디버깅
			System.out.println("GoodsService.java getGoodsAndImgOne map : " + map.toString());
		
		} catch (Exception e) {
			
		} finally {
			// DB 자원해제
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return map;
	}
	
	
	
	
	public void addGoods(Goods goods, GoodsImg goodsImg) {
		Connection conn = null;
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			goodsDao = new GoodsDao();

			int goodsNo = goodsDao.insertGoods(conn, goods); // goodsNo가 AI로 자동생성되어 DB입력
			
			if(goodsNo !=0) {
				//goodsImg.setGoodsno(goodsNo);
					throw new Exception();	//이미지 입력 실패 시 강제로 롤백(catch절로 이동)
				}
		
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public List<Goods> getGoodsListByPage(int rowPerPage, int currentPage){
		List<Goods> list = null;
		this.goodsDao = new GoodsDao();
		Connection conn = null;
		
		
		int beginRow = 0;
		// 수정필요 list = goodsDao.selectGoodsListByPage(conn, rowPerPage, beginRow);
		return list;
	}
	
}
