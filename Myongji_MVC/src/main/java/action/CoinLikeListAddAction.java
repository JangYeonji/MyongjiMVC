package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinLikeListAddService;
import vo.ActionForward;
import vo.Music;

public class CoinLikeListAddAction implements Action { 

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CoinLikeListAddService coinLikeListAddService = new CoinLikeListAddService(); //서비스 객체 생성
		int mid = Integer.parseInt(request.getParameter("mid")); //좋아요한 노래의 id 파라미터로 받아서 likes에 저장
		Music likeMusic = coinLikeListAddService.selectMusic(mid); //좋아요 한 노래의 id를 넘겨서 좋아요 항목에 추가하는 메소드 호출
		coinLikeListAddService.addLike(request,likeMusic);
		ActionForward forward = new ActionForward("coinLikeList.coin", true); //장바구니 목록보기 요청 
		return forward;
		
	}
	
}