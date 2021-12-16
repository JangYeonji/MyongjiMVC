<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좋아요 목록 페이지</title>
<style type="text/css">
#listForm {
   width: 640px;
   border: 1px red solid;
   margin: auto;
}
h2 {
   text-align: center;
}

table {
   width: 550px;
   margin: auto;
}

.tr_top {
   background-color: lime;
}
.div_empty {
   text-align: center;
   background-color:
}
.td_command {
   text-align: right;
}
#todayImageList{
   text-align: center;
}
#productImage{
   width:150px;
   height:150px;
   border:none;
}
#cartImage{
   width:70px;
   height:70px;
   border:none;
}
#select{
	text-align: right;
}
#commandList{
	text-align: center;
}
#upImage{
	width: 15px;
}
#downImage{
	width: 15px;
}
</style>
<script>
	function checkAll(theForm){ //체크 함수
		if(theForm.remove.length == undefined){
			theForm.remove.checked = theForm.allCheck.checked; 
		}else{
			for(var i=0;i<theForm.remove.length;i++){
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}
</script>
</head>
<body>
<section id="listForm">
	<c:if test="${likeList!=null}">
  	<h2>좋아요 목록</h2>
	<form method="post" action="likeListRemove.coin"> <!-- 삭제 누르면 여기로 -->
      <table>
        
        <tr class = "tr_top">
        	<td><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(this.form)"/> </td> 
        	<td>노래 번호</td>
        	<td>노래 가수</td>
        	<td>노래 제목</td>
        </tr>

        <c:forEach var="list" items="${likeList}">  
        <tr>
        	<td><input type="checkbox" id="remove" name="remove" value="${list.title}"/></td>
        	<td>${list.mid}</td> 
        	<td>${list.singer}</td>
        	<td>${list.title}</td>
         </tr>
        </c:forEach>
      
      	<tr>
        	<td colspan="4" style="text-align:center;"><input type="submit" value="삭제" /></td>
		</tr>
      
      </table>
	</form>
	</c:if>
	
	<c:if test="${likeList == null }">
    	<section class="div_empty">
     	좋아하는 곡이 없습니다.
    	</section>
	</c:if>
   
   <nav id="commandList">
   		<a href="select.coin">노래 선택하기</a>
   		<a href="coinMain.jsp">메인으로</a>
   </nav>
   
</section>
</body>
</html> 