<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页 | MyBlog</title>
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/paging.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/axis.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/show.js"></script>
<script type="text/javascript">
</script>
</head>
<body onload="show('${type}/${value}')">
	<div class="head_line"></div>
	<div class="container" id="main">

		<div id="header"></div>

		<div class="row c_center">
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2>
						<a href="${pageContext.request.contextPath}/login.jsp">MyBlog</a>
					</h2>
					<h5 class="text-muted">Nothing is impossible!</h5>
				</div>

				<div class="c_center" id="person_info">
					<img src="${pageContext.request.contextPath}/img/01head.jpg" alt="丢失了我的头像?" class="img-circle"
						width="130" height="130">
					<h4 class="text-muted">Rudy</h4>
					<h5 class="text-muted">Tata，nice to meet you again</h5>
				</div>

				<div class="c_center">
					<!-- 这里初始化侧边栏的4个标签 -->
					<div class="inline " onclick="show('articleList')">
						<a href="#">${indexInfo.articleCount}<br>文章
						</a>
					</div>
					<div class="inline " onclick="show('sortList')">
						<a href="#"><span>
								${indexInfo.sortCount} </span><br>分类</a>
					</div>
					<div class="inline " onclick="show('tagList')">
						<a href="#"><span>${indexInfo.tagCount}</span><br>标签</a>
					</div>
				</div>
				<div id="list">
					<table class="table table-hover c_center">
						<tbody>
							<tr class="active" id="articleList" onclick="show('articleList')">
								<td><a href="#"><span
										class="glyphicon glyphicon-home"></span> &nbsp;&nbsp;首页</a></td>
							</tr>
							<tr id="sortList" onclick="show('sortList')">
								<td><a
									href="#"><span
										class="glyphicon glyphicon-list"></span> &nbsp;&nbsp;分类</a></td>
							</tr>
							<tr id="tagList" onclick="show('tagList')">
								<td><a
									href="#"><span
										class="glyphicon glyphicon-tags"></span> &nbsp;&nbsp;标签</a></td>
							</tr>
							<tr id="timeList" onclick="show('timeList')">
								<td><a href="#"><span
										class="glyphicon glyphicon-book"></span> &nbsp;&nbsp;时间轴</a></td>
							</tr>
							<tr id="about" onclick="show('about')">
								<td><a href="#"><span
										class="glyphicon glyphicon-user"></span> &nbsp;&nbsp;关于</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- list -->
				<br>

				<div class="sort">
					<div class="list-group">
						<span class="list-group-item active">分类</span>
						<!-- 这里初始化分类 -->
						<c:forEach items="${indexInfo.sortList}" var="sort">
							<a href="${pageContext.request.contextPath}/index/sort/${sort.sortName}"
							class="list-group-item">${sort.sortName}&nbsp;&nbsp;&nbsp;&nbsp; (${sort.sortCount})</a>
						</c:forEach>
						<!-- 初始化结束 -->
					</div>
				</div>
				<!-- sort -->
				<div class="visit">
					<div class="list-group">
						<span class="list-group-item active">阅读排行</span>
						<!-- 这里初始化阅读排行 -->
						<c:forEach items="${indexInfo.articles}" var="article">
							<a href="/MyBlog/showArticle/${article.id}"
							class="list-group-item">${article.title}&nbsp;&nbsp; <span
							class="c_right">(${article.visit})</span></a>
						</c:forEach>
						

						<!-- 初始化结束 -->
					</div>
				</div>
				<!-- visit-->


				<div id="tag">
					<div class="list-group">
						<span class="list-group-item active">标签</span> <br>

							<!-- 这里初始化标签 -->
						<c:forEach items="${indexInfo.tags}" var="tag">
							<span class="label label-info"><a
							href="${pageContext.request.contextPath}/index/tag/${tag.tag}">
								&nbsp;${tag.tag}&nbsp;</a></span>
						</c:forEach>

						<!-- 初始化标签完成 -->
					</div>
				</div>
				<!-- tag -->
				<!-- admin here -->
				<c:if test="${user!=null}">
					<a href="${pageContext.request.contextPath}/newArticle"> <span
					class="glyphicon glyphicon-plus">&nbsp;&nbsp;写新文章&nbsp;&nbsp;</span>
					</a> <a href="${pageContext.request.contextPath}/admin"> <span
					class="glyphicon glyphicon glyphicon-user">&nbsp;&nbsp;管理更多&nbsp;&nbsp;</span>
				</a>
				</c:if>
				
				<!--  -->
			</div>
			<div class="col-md-2" id="center_content"></div>
			<div class="col-md-7 " id="right_Content">
				<b>加载中...</b>
			</div>
		</div>
		<div class="foot_line"></div>
	</div>
	<!-- container -->
	<div id="footer">
		<div>
			<a href="https://github.com/yamoo1206"><img
				src="${pageContext.request.contextPath}/img/github.png"
				class="img-circle" width="20px" height="20px">&nbsp;&nbsp;GitHub</a>
			&nbsp;| <a href="#">&nbsp;&nbsp;MyBlog</a> <br> copyright © 2018
		</div>

		<div class="r_div">
			<a href="#"><input class="btn btn-default" value="返回顶部"
				style="width: 50%;"></a>
			<h6>被访问了 2 次</h6>
			<h6>你是第 2个访问者</h6>
		</div>

	</div>
	<!-- footer -->

</body>
</html>