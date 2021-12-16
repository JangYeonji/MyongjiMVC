package svc;

import static db.JdbcUtil.*; 
import java.sql.Connection;
import java.util.ArrayList;

import dao.MusicDAO;
import vo.Music;
public class CoinSelectService {

	public ArrayList<Music> getMusicList() {
		
		Connection con = getConnection();  //객체가 없을 수 있는 건 JdbcUtil에서  import static으로 선언했기 때문 
		
		MusicDAO musicDAO = MusicDAO.getInstance(); //한번 생성해서 여러번 씀
		musicDAO.setConnection(con);		
		ArrayList<Music> musicList = musicDAO.selectMusicList();
		close(con); 
		return musicList; //CoinSelectAction.java으로 돌아감
	}
	
}