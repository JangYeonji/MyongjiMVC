package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinMusicService;
import vo.ActionForward;
import vo.Music;

public class CoinMusicAction implements Action { 

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int mid = Integer.parseInt(request.getParameter("mid")); //선택한 노래 id
		CoinMusicService coinMusicService = new CoinMusicService();
		Music music = coinMusicService.getCoinMusic(mid); //선택한 노래 정보를 가져옴
		request.setAttribute("music", music); 
		
		ActionForward forward = new ActionForward("coinMusic.jsp", false);
		return forward;
		
		
	}
	
}