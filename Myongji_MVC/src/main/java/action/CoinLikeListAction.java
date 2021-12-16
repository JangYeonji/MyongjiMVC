package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinLikeListAddService;
import svc.CoinLikeListService;
import vo.ActionForward;
import vo.Music;

public class CoinLikeListAction implements Action { 

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		CoinLikeListService coinLikeListService = new CoinLikeListService(); //서비스 객체 생성
		ArrayList<Music> likeList = coinLikeListService.getLikeList(request); //전체 장바구니 목록 호출
		
		request.setAttribute("likeList", likeList);
		ActionForward forward = new ActionForward("coinLikeList.jsp", false);  //장바구니 목록 페이지로 이동
		return forward;
		
	}
	
}