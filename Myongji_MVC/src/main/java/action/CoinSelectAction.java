package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinScoreService;
import svc.CoinSelectService;
import svc.LoginService;
import svc.MoneyDownService;
import vo.ActionForward;
import vo.Coin;
import vo.Member;
import vo.Music;

public class CoinSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CoinSelectService coinSelectService = new CoinSelectService();
		ArrayList<Music> musicList = coinSelectService.getMusicList(); //노래목록을 가져옴
		request.setAttribute("musicList", musicList); //노래정보를 담은 ArrayList
		
		ActionForward forward = new ActionForward("coinList.jsp", false); //request단위로 위의 정보를 HttpServletRequest 객체에 공유함
		return forward;
	}
	
}