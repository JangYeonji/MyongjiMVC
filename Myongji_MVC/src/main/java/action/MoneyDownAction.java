package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinScoreService;
import svc.MoneyDownService;
import vo.ActionForward;
import vo.Coin;
import vo.Member;

public class MoneyDownAction implements Action { 

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String uid = request.getParameter("uid");
		MoneyDownService moneyDownService = new MoneyDownService();
		Member loginMember = moneyDownService.getMoney(uid);
		request.setAttribute("loginMember", loginMember);
		
		ActionForward forward = new ActionForward("select.coin",false); //코인 차감하고 노래 부를 수 있도록
		return forward;
	}
	
}