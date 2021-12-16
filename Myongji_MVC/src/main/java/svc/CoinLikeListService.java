package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MusicDAO;
import vo.Music;

public class CoinLikeListService {

	public ArrayList<Music> getLikeList(HttpServletRequest request) {
		HttpSession session = request.getSession(); 
		ArrayList<Music> likeList = (ArrayList<Music>)session.getAttribute("likeList"); //좋아요 목록 가져옴
		return likeList; //목록 return
	}
}