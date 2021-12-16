package dao;

import static db.JdbcUtil.*;
import java.sql.*;

import vo.Coin;

public class CoinDAO { //Data Access Object. 실행시키고 결과를 가져옴
	//sql 실행하기 위해 밑에 과정
	Connection con; 
	private static CoinDAO boardDAO;
	
	private CoinDAO() {}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public static CoinDAO getInstance(){
		
		if(boardDAO ==null){
			boardDAO = new CoinDAO();
		}
		
		return boardDAO; 
	}
	
	public Coin viewScore(int mid) { //user당 코인 객체 하나
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		Coin score = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM coin WHERE mid=?"); 
			pstmt.setInt(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				score = new Coin( //vo.Coin에 필드값을 넣어서 Coin 객체 하나로 생성
						rs.getInt("cid")
						,rs.getString("uid")
						,rs.getInt("mid")
						,rs.getString("score")
						,rs.getString("likes"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return score;
	}
}