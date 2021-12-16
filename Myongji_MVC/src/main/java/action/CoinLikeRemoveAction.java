package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinLikeListRemoveService;
import svc.CoinMusicService;
import vo.ActionForward;
import vo.Music;

public class CoinLikeRemoveAction implements Action { 

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String[] likeArray = request.getParameterValues("remove"); //다중선택한 체크박스 가져옴
		CoinLikeListRemoveService coinLikeListRemoveService = new CoinLikeListRemoveService();
		coinLikeListRemoveService.likeListRemove(request,likeArray);
		ActionForward forward = new ActionForward("coinLikeList.coin",true);
		return forward;
		
		
	}
	
}