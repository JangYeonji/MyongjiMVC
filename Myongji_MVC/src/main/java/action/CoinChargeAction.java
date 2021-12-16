package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CoinChargeService;
import svc.MoneyDownService;
import vo.ActionForward;
import vo.Coin;
import vo.Member;

public class CoinChargeAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uid = request.getParameter("uid");
		CoinChargeService coinChargeService = new CoinChargeService(); //코인 충전
		Member loginMember = coinChargeService.getMoney(uid);
		request.setAttribute("loginMember", loginMember);
		
		ActionForward forward = new ActionForward("coinMain.jsp",false);
		return forward;
	}
}
