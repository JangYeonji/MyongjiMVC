package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Music;
import dao.MusicDAO;

public class CoinLikeListAddService {

	public Music selectMusic(int mid) { //파라미터 값으로 전송된 id값을 가지고 있는 노래 정보 얻어오는 메소드 (정보는 DAO에)
		Connection con = getConnection();
		MusicDAO musicDAO = MusicDAO.getInstance();
		musicDAO.setConnection(con);	
		Music music = musicDAO.selectMusic(mid); //coin에 정보가 담겨있음
		close(con);
		return music;
	}

	public void addLike(HttpServletRequest request, Music likeMusic) { //노래 coin 정보 가져옴
		HttpSession session = request.getSession(); //요청한 클라이언트의 세션 객체 get
		ArrayList<Music> likeList = (ArrayList<Music>)session.getAttribute("likeList"); //세션에 저장되어 있는 목록 얻어옴
		
		if(likeList == null){ //요청 처음인 경우, Array객체 생성하여 세션 영역에 공유
			likeList = new ArrayList<Music>(); //LikeList 생성
			session.setAttribute("likeList", likeList); //LikeList에 노래 coin 정보 등록
		}
		
		boolean isNewList = true; //지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 저장할 변수
		
		for(int i=0;i<likeList.size();i++) {
			if(likeMusic.getTitle().equals(likeList.get(i).getTitle())) {
				isNewList = false;
				break;
			}
		}
		
		if(isNewList) { //목록 추가 요청한 노래가 존재하지 않으면 저장
			Music list = new Music(); //리스트 생성
			list.setMid(likeMusic.getMid());
			list.setSinger(likeMusic.getSinger());
			list.setTitle(likeMusic.getTitle());
			list.setLyrics(likeMusic.getLyrics());
			likeList.add(list); //리스트를 LikeList에 추가
		}
	}

}