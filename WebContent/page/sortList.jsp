<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function openTag(e){
		$(e).children().removeClass("glyphicon glyphicon-chevron-right");
		$(e).children().addClass("glyphicon glyphicon-chevron-down");
		$(e).next().slideDown(1000);
		$(e).attr({"onclick":"closeTag(this)"});
	} 
	function closeTag(e){
		$(e).children().removeClass("glyphicon glyphicon-chevron-down");
		$(e).children().addClass("glyphicon glyphicon-chevron-right");
		$(e).next().slideUp(1000);
		$(e).attr({"onclick":"openTag(this)"});
	}
	
</script>
</head>
<body>
	<br>
	<br>
	<div class="list-group">

		<a href="#" class="list-group-item active">分类</a>
		<!-- 这里初始化标签 -->
		<c:forEach items="${sortList}" var="sort">
			<div class="tags_name" id="tag_name"
				style="text-align: left; background-color: white; border-bottom: solid 1px #CDCDCD; font-size: 25px; color: #767474"
				onclick="openTag(this)">
				<!-- 标签名字 -->
				<span class="glyphicon glyphicon-chevron-right"></span>&nbsp;
				&nbsp;${sort.sortName}
			</div>
			<div style="display: none;">
				<!-- 标签信息 -->
				<ul class="list-group">
					<c:forEach items="${sort.articles}" var="article">
						<li class="list-group-item">
							<div>
								<div>
									<div  style="font-size: 25px;">
										<a href="/MyBlog/showArticle/${article.id}">${article.title}</a>
									</div>
									<div class="c_right">
										<img src="${pageContext.request.contextPath}/img/time.png">
										<fmt:formatDate value="${article.time}" type="both"/> &nbsp;&nbsp; <span class="visit"><img
											src="${pageContext.request.contextPath}/img/visit.png">
											${article.visit} </span>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
	</div>
</body>
</html>