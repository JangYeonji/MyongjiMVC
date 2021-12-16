<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="mycss.css">
<style type="text/css">

#bg{
	background-color:#191919; 
	width: 100%;
	height: 100%;
	position: relative;
} 
#loginform{
	border: 1px solid pink;
	width: 400px;
	height: 400px;
	position: absolute;
	top: 120px;
	left: 35%;
	text-align:center;
}
h1{
	font-size:300%;
	color: white;
}
#one, #two {
	width: 200px;
	height: 30px;
}
#three, #five{
	color: white;
}
#three_1{
	width: 15px;
	height: 15px;
}
#four{
	width: 200px;
	height: 30px;
	background: white;
	border-color:white;
}
#five{
	font-size:70%;
}
</style>
</head>
<body id="bg">
<div id="loginform">
	<h1>COIN KARA</h1>
	<form method="post">
		<input id="one" type="text" name="uid" placeholder="ID"> <br><br> <%-- placeholder: input에 미리 작성해놓은 문자 --%>
		<input id="two" type="password" name="passwd" placeholder="Password"> <br><br>
		<input id="four" type="submit" value="Login"> <br><br> <%-- post 방식 --%>
		<span id="three">로그인 상태 유지(1일) <input type = "checkbox" name = "useCookie" id = "three_1"/></span><br><br><br> <%-- 자동로그인 쿠키 --%>
		<span id="five">---수민연지순기---</span>
	</form>
</div>
</body>
</html>