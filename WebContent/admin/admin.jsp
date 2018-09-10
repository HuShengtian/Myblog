<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理 | MyBlog</title>
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="page/signin.html" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/public.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css">

<script src="${pageContext.request.contextPath}/js/admin.js"></script>

</head>
<body>
	<div class="head_line"></div>
	<div class="container" id="main">

		<div id="header">
			<div>
				<h2>
					<a href="/MyBlog/index">MyBlog-管理</a>
				</h2>
				<h5 class="text-muted">有点粗糙 但能用就行</h5>
			</div>
		</div>

		<div class="admin_div">
			<h4 class="btn btn-default">统计</h4>
			<h5>被访问了 2 次</h5>
			<h5>一共有 2个访问者</h5>

		</div>
		<div class="admin_div">
			<h4 class="btn btn-default">管理日志</h4>

			<c:forEach items="${articleList}" var="article">
				<div class="list-group-item">
					<span>${article.title }</span>
					<div class="r_div">
						<span>2018-08-13 </span> <a
							href="${pageContext.request.contextPath}/showUpdateArticle/${article.id}">
							<button class="btn btn-default">
								&nbsp;<span class="glyphicon glyphicon-pencil"
									style="color: #5bc0de">编辑</span>&nbsp;
							</button>
						</a> <a
							href="${pageContext.request.contextPath}/delArticle/${article.id}">
							<button class="btn btn-default">
								&nbsp; <span class="glyphicon glyphicon-trash"
									style="color: #d9534f"> 删除</span>&nbsp;
							</button>
						</a>
					</div>
				</div>
			</c:forEach>



		</div>

		<div class="admin_div">
			<h4 class="btn btn-default">管理分类</h4>
			<h5 style="color: #d9534f">删除分类会删除所有的文章</h5>
			<c:forEach items="${sortList}" var="sort">
				<div class="list-group-item">
					<input class="sort" value="${sort.sortName}" disabled="disabled"
						style="border: 0px;" type="text">
					<div class="r_div">
						<button class="btn btn-default" onclick="upSort(this)">
							&nbsp;<span class="glyphicon glyphicon-pencil"
								style="color: #5bc0de" >编辑</span>&nbsp;
						</button>
						<a href="${pageContext.request.contextPath}/delSort/${sort.sortName}">
						<button class="btn btn-default">
							&nbsp;<span class="glyphicon glyphicon-trash"
								style="color: #d9534f">删除</span>&nbsp;
						</button>
						</a>
					</div>
				</div>
			</c:forEach>


		</div>

		<div class="admin_div">
			<h4 class="btn btn-default">管理标签</h4>
			<c:forEach items="${tagList}" var="tag">
				<div class="list-group-item">
					<input class="tags" value="${tag.tag }" disabled="disabled"
						style="border: 0px" type="text">
					<div class="r_div">
						<button class="btn btn-default" onclick="upTag(this)">
							&nbsp;<span class="glyphicon glyphicon-pencil"
								style="color: #5bc0de">编辑</span>&nbsp;
						</button>
						<a href="${pageContext.request.contextPath}/delTag/${tag.tag }" >
						<button class="btn btn-default">
							&nbsp;<span class="glyphicon glyphicon-trash"
								style="color: #d9534f">删除</span>&nbsp;
						</button>
						</a>
					</div>
				</div>

			</c:forEach>


		</div>






		<div class="foot_line"></div>
	</div>
	<!-- container -->



</body>
</html>