package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Music;

public class CoinLikeListRemoveService {
	
	public void likeListRemove(HttpServletRequest request, String[] likeArray) { //다중선택 목록 가져옴
		
		HttpSession session = request.getSession();
		ArrayList<Music> likeList = (ArrayList<Music>)session.getAttribute("likeList"); //좋아요 목록 가져옴
	
		for (int i = 0; i < likeArray.length; i++) { //좋아요 목록 안에서 실행
			for (int j = 0; j < likeList.size(); j++) { 
				if(likeList.get(j).getTitle().equals(likeArray[i])){ //삭제할 항목의 mid 별로  같은 kind값을 가진 장바구니 항목 삭제
					likeList.remove(likeList.get(j));
				}
			}
		}
	}
}