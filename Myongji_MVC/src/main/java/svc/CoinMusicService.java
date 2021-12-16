package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import vo.Music;
import dao.CoinDAO;
import dao.MusicDAO;
public class CoinMusicService {

	public Music getCoinMusic(int mid) {
		Connection con = getConnection(); 
		MusicDAO musicDAO = MusicDAO.getInstance(); 
		musicDAO.setConnection(con);	
		
		Music music = musicDAO.selectMusic(mid);
		close(con);
		
		return music;
	}

}