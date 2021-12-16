<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" href="mycss.css">
<style type="text/css">
#bg{
	background-color:#191919;
	width: 100%;
	height: 100%;
	position: relative;
} 
#zero{
	text-align: center;
	color: pink;
	padding-top:30px;
	font-size:200%;
}
#logout{
	font-size:50%;
}
#one, #two, #three, #four{
	float: left;
	width: 200px;
	height: 70px;
	border: 1px solid black;
	margin-top: 3%;
	text-align: center;
	line-height: 70px;
	text-size: 300%;
	color:white;
}
#one{
	margin-left: 20%;
}
#five{
	position: absolute;
	top: 170px;
	left: 37%;
	color:white;
}
#six{
	position: absolute;
	top: 250px;
	left: 33%;
	color:white;
}
</style>
</head>
<body id="bg">
<div id="zero">
	&nbsp;&nbsp;&nbsp;
	${loginMember.name }님 
	&nbsp;&nbsp;&nbsp;♡&nbsp;&nbsp;
	${loginMember.money}원 사용가능
	<a href="logout.jsp" id="logout">로그아웃</a> 
</div>

<div id="one"><a href="downMoney.coin?uid=${loginMember.uid}">노래선택</a></div>
<div id="two"><a href="charge.coin?uid=${loginMember.uid}">코인충전</a></div>
<div id="three"><a href="coinLikeList.coin">좋아요</a></div>
<div id="four"><a href="#">파일 업로드</a></div><br><br>
<div id="five">
	<h1 id="today">!! 한 곡당 100원 차감 !!</h1>
	<h1>!! 한 번 충전시 200원 충전 !!</h1>
	
</div>

</body>
</html>