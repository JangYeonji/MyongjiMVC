package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;
import action.*;

@WebServlet("*.coin") //웹 애플리케이션의 대표 컨트롤러
public class CoinFrontController extends HttpServlet {
	//요청이 doGet이든 doPost이든 동일하게 작동하는 법
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String command = request.getServletPath();	//URL로 웹애플리케이션 다음의 ServletPath를 판별
				
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/select.coin")){ //노래 선택하기
			action = new CoinSelectAction(); 
			try {
				forward = action.execute(request, response);  //서브컨트롤러로 연결하는 역할
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/music.coin")){ //노래 부르는 중
			action = new CoinMusicAction(); 
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/score.coin")){ //노래 점수
			action = new CoinScoreAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/likeListAdd.coin")){ //좋아요 추가
			action = new CoinLikeListAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/coinLikeList.coin")){ //좋아요 목록 
			action = new CoinLikeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/likeListRemove.coin")){ //좋아요 삭제
			action = new CoinLikeRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/downMoney.coin")){ //코인 감소
			action = new MoneyDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/charge.coin")){ //코인 충전
			action = new CoinChargeAction(); 
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(forward !=null){ 
			if(forward.isRedirect()){  //ActionForward
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
	}
	
}