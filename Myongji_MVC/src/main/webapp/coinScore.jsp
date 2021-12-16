<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 페이지</title>
<link rel="stylesheet" href="mycss.css">
<style type="text/css">
#bg{
	background-color:#191919;
	width: 100%;
	height: 100%;
	color:white;
	text-align: center;
} 
#score{
	border: 1px solid pink;
	width: 400px;
	height: 400px;
	position: absolute;
	top: 120px;
	left: 35%;
	text-align:center;
}
#nn{
	font-size: 300%;
}
#main{
	width: 300px;
	height:30px;
	background: purple;
	border-color:purple;
	color: white;
}
</style>
</head>
<body id="bg">
<div id="score">
		<h1 id="ss">SCORE</h1>
		<h1 id="nn">${score.score}</h1>
		<h2>최고의 실력이네요~ 가수인가요?</h2><br><br>
		<a href="coinMain.jsp">
			<span id="main">메인으로</span>
		</a>
		<a href="logout.jsp" id="logout">로그아웃</a> 
</div>
</body>
</html>