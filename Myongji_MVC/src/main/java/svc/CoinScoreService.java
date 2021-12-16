package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import vo.Coin;
import dao.CoinDAO;
public class CoinScoreService {

	public Coin getCoinScore(int mid) {
		Connection con = getConnection();
		CoinDAO coinDAO = CoinDAO.getInstance();
		coinDAO.setConnection(con);	
		
		Coin score = coinDAO.viewScore(mid); //노래 점수에 대한 정보를 select 해오는걸 DAO에서 함
		close(con);
		
		return score;
	}

}