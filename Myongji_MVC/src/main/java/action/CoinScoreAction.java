package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinScoreService;
import vo.ActionForward;
import vo.Coin;

public class CoinScoreAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		int mid = Integer.parseInt(request.getParameter("mid"));  //선택한 노래 id
		CoinScoreService coinScoreService = new CoinScoreService();
		Coin score = coinScoreService.getCoinScore(mid);  //사용자가 선택한 노래 점수 정보를 가져옴
		request.setAttribute("score", score); 
		
		ActionForward forward = new ActionForward("coinScore.jsp", false);
		return forward;
		
		
	}
}
