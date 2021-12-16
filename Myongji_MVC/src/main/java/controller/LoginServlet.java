package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import vo.Member;

@WebServlet("/login") 
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookieArray = request.getCookies(); //쿠키는 여러 개이므로 배열로 참조변수 받음
		String uid = "";
		String passwd = "";
		
		
		if(cookieArray != null) { //재 방문이면
			for (int i=0;i<cookieArray.length;i++) {
				if(cookieArray[i].getName().contentEquals("uid")) { //쿠키 이름 찾기
					uid = cookieArray[i].getValue(); //쿠키 값 get하기
				}else if(cookieArray[i].getName().equals("passwd")) { 
					passwd = cookieArray[i].getValue();
				}
				
			}
			
			LoginService loginService = new LoginService(); 
			Member loginMember = loginService.getLoginMember(uid,passwd); //로그인 정보 담기
			
			if(loginMember != null) { //ID,PW 일치
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
				request.setAttribute("loginMember", loginMember); 
				dispatcher.forward(request, response);
			}else { //ID,PW 불일치
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp"); 
				dispatcher.forward(request, response);
			}
		}else {  //첫 방문이면
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String passwd = request.getParameter("passwd");
		String useCookie = request.getParameter("useCookie"); //쿠키 자동로그인(체크박스)
		
		
		LoginService loginService = new LoginService();
		Member loginMember = loginService.getLoginMember(uid,passwd);
		
		if(useCookie != null) { //첫 방문이면 쿠키 생성
			Cookie idCookie = new Cookie("uid",uid);
			idCookie.setMaxAge(60*60*24); 
			
			Cookie passwdCookie = new Cookie("passwd",passwd);
			passwdCookie.setMaxAge(60*60*24);
			
			response.addCookie(idCookie); 
			response.addCookie(passwdCookie);
			
		}
		if(loginMember != null) { //로그인 성공
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("loginMember", loginMember);
			dispatcher.forward(request, response);
		}else { //로그인 실패
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp"); 
			dispatcher.forward(request, response);
		}
	}
}