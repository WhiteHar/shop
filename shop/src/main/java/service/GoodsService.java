package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import repository.DBUtil;
import repository.GoodsDao;
import repository.GoodsImgDao;
import vo.Goods;
import vo.GoodsImg;

public class GoodsService {
	private GoodsDao goodsDao;
	private GoodsImgDao goodsImgDao;
	
	public void addGoods(Goods goods, GoodsImg goodsImg) {
		Connection conn = null;
		try {
			conn = new DBUtil().getConnection();
			conn.setAutoCommit(false);
			goodsDao = new GoodsDao();
			goodsImgDao = new GoodsImgDao();
			int goodsNo = goodsDao.insertGoods(conn, goods); // goodsNo가 AI로 자동생성되어 DB입력
			
			if(goodsNo !=0) {
				//goodsImg.setGoodsno(goodsNo);
				of(goodsImgDao.insertGoodsImg(conn,goodsImg)==0){	// GoodsImgDao.java 파일 수정하기
					throws new Exception();	//이미지 입력 실패 시 강제로 롤백(catch절로 이동)
				}
			}
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.rollback();
			}catch(SQLException e) {
				// TODO auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public List<Goods> getGoodsListByPage(int rowPerPage, int currentPage){
		List<Goods> list = null;
		this.goodsDao = new GoodsDao();
		Connection conn = null;
		
		
		int beginRow = 0;
		list = goodsDao.selectGoodsListByPage(conn, rowPerPage, beginRow);
		return list;
	}
	
}
