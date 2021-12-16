<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노래선택 페이지</title>
<link rel="stylesheet" href="mycss.css">
<style type="text/css">

#bg{
	width: 100%;
	height: 100%;
	position: relative;
	text-align: center;
	color: white;
	background-color:#191919; 
} 
#one, #two, #title, #singer {
	float:left;
}
#one{
	width: 500px;
	height: 500px;
	border: 1px solid black;
	margin-left: 20%;
}
#title{
	position: absolute;
	width: 250px;
	height: 500px;
	border: 1px solid pink;
}
#singer{
	position: absolute;
	text-align: center;
	border: 1px solid blue;
	margin-left: 250px;
	width: 250px;
	height: 500px;
}
#two{
	width: 250px;
	height: 500px;
	border: 1px solid yellow;
}
.sub{
	width: 200px;
	height: 30px;
	background: purple;
	border-color:purple;
	color: white;
}
.bt{
	width: 15px;
	height: 15px;
}
</style>
</head>
<body id="bg">
<h1>인기차트</h1>

<div id="one">
	<div id="title">
		<h2>노래제목</h2>
		<div>
			<c:forEach var="musicList" items="${musicList}" >
				<a href="music.coin?mid=${musicList.mid}"> <!-- 무엇을 선택했는지 파라미터 아이디를 갖고감 -->
					${musicList.title} <br><br>
				</a>
			</c:forEach>
			<c:if test="${musicList==null}">
				<div class="div_empty">
				등록된 노래가 없습니다. 노래 불가
				</div>
			</c:if>
			
		</div><br>
	</div>
	
	<div id="singer">
		<h2>가수</h2>
		<div>
			<c:forEach var="musicList" items="${musicList}" >
				<a href="music.coin?mid=${musicList.mid}">
					${musicList.singer} <br><br>
				</a>
			</c:forEach>
		</div>
	</div>
</div>

<div id="two">
	<h2>좋아요</h2>
		<c:forEach var="musicList" items="${musicList}" >
			<a href="likeListAdd.coin?mid=${musicList.mid}">♡</a> <br><br>
		</c:forEach>
</div>


</body>
</html>