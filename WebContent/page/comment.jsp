<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
</head>
<body>
	
		<c:forEach items="${commentList.list}" var="comment">
			<div class="f_div">	
			<img src="${pageContext.request.contextPath}/img/comment.jpg" class="img-circle" width="50" height="50">
			&nbsp;&nbsp;			
			<span style="color: #428bca">${comment.nickname }</span>					
			<span>&nbsp;&nbsp;${comment.time}</span>
			</div>			
			<div id="c_content" class="c_left">						
			<p>${comment.content}</p>			
			</div>			
			<div class="r_div">			
			<a><span class="glyphicon glyphicon-thumbs-up" id="love_${comment.id}" onclick="loveComment(${comment.id})"><span id="l_${comment.id}">${comment.star}</span></span></a>
			&nbsp;
			<a><span class="glyphicon glyphicon-thumbs-down" id="diss_${comment.id}" onclick="dissComment(${comment.id})"><span id="d_${comment.id}">${comment.diss}</span></span></a>
			&nbsp;		
			<c:if test="${user!=null}">
					<span class="btn btn-default" style="color:red;" onclick="deletecm(${comment.id})">删除</span>
				</c:if>
			
			<!-- admin here -->				
			</div>			
			<div class="line"></div>
		</c:forEach>	
		<c:if test="${commentList.totalPage==0}"><b>暂无评论</b></c:if>	
	<div class="center">
		<ul class="pagination">
			<c:if test="${commentList.currentPage!=1}"><li><a href="#com" onclick="showComment(${commentList.currentPage-1})">«</a></li></c:if>
			<c:forEach var="i" begin="1" end="${commentList.totalPage}">
				<li><a <c:if test="${commentList.currentPage==i}"> class="active" </c:if> href="#com" onclick="showComment(${i})">${i}</a></li>
			</c:forEach>
			<c:if test="${commentList.currentPage!=commentList.totalPage&&commentList.totalPage!=0}"><li><a href="#com" onclick="showComment(${commentList.currentPage+1})">»</a></li></c:if>
		</ul>
	</div>
</body>
</html>