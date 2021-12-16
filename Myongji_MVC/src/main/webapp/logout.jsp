<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<%
	Cookie[] useCookie = request.getCookies();
	
	if(useCookie != null) { 
		for(int i=0;i<useCookie.length;i++){
			useCookie[i].setMaxAge(0); //쿠키 없애기
			response.addCookie(useCookie[i]); 
			
		}
	}
	response.sendRedirect("coinMain.jsp");
%>
</body>
</html>