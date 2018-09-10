<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<div class="list-group">
		<a href="#" class="list-group-item active">最新文章</a>
		<!-- 这里初始化文章列表 -->
		<c:forEach items="${articleList.list}" var="article">
			<div class="list-group-item">
			<h4>
				<a href="/MyBlog/showArticle/${article.id}">${article.title}</a>
			</h4>
			<br> <span><fmt:formatDate value="${article.time}" type="both"/> &nbsp;&nbsp;|</span> <a
				href="${pageContext.request.contextPath}/index/sort/${article.sort}">${article.sort}</a>&nbsp;&nbsp;|
			<span>阅读次数: ${article.visit}</span> <br> <br> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${article.content}</span>
			<br> <br> <br> <a
				href="/MyBlog/showArticle/${article.id}">阅读全文</a> <br>
		</div>
		</c:forEach>
		
		<div class="center">
		<ul class="pagination">
			<c:if test="${articleList.currentPage!=1}"><li><a href="#" onclick="show2('articleList',${articleList.currentPage-1})">«</a></li></c:if>
			<c:forEach var="i" begin="1" end="${articleList.totalPage}">
				<li><a <c:if test="${articleList.currentPage==i}"> class="active" </c:if> href="#" onclick="show2('articleList',${i})">${i}</a></li>
			</c:forEach>
			<c:if test="${articleList.currentPage!=articleList.totalPage&&articleList.totalPage!=0}"><li><a href="#" onclick="show2('articleList',${articleList.currentPage+1})">»</a></li></c:if>
		</ul>
	</div>
		<!-- 初始化文章列表完成 -->
	</div>
</body>
</html>