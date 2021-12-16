<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노래 부르는 페이지</title>
<link rel="stylesheet" href="mycss.css">
<style type="text/css">
#bg{
	background-color:#191919;
	width: 100%;
	height: 100%;
	color:white;
	text-align: center;
} 
#title{
	font-size: 200%;
}
#singer{
}
#lyrics{
	width: 500px;
	height: 500px;
}
#aa{
	font-size: 150%;
}
</style>
</head>
<body id="bg">
	<h1 id="title">${music.title}</h1><!-- coinMusicAction.java에서   "request.setAttribute("music", music);" 해서 EL사용 가능 -->
	<h3 id="singer">${music.singer }</h3>
	<div><img src="image/${music.lyrics}" id="lyrics"/></div>
	<a href="score.coin?mid=${music.mid}">
		<h3 id="aa">점수보기</h3>
	</a>
</body>
</html>