<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${articleInfo.article.title}| MyBlog</title>
<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<!-- 引入本页面的特殊样式 -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/article.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/comment.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/paging.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/js/article.js"></script>
<script type="text/javascript">
</script>
</head>
<body style="background:#eee;" onload="showComment(1)" > <!-- onload="showComment(${articleInfo.article.id})" -->
	<div class="head_line"></div>
	<div class="container" id="main">
		<div class="head">
			<div id="title">
				<h2>
					<a href="/MyBlog/index">MyBlog</a>
				</h2>
			</div>
		</div>

		<div id="article">

			<div id="a_head ">
				<h3>${articleInfo.article.title}</h3>
				<br>
				<div>
					<h5>
						<span>分类:</span> <a href="${pageContext.request.contextPath}/index/sort/${articleInfo.article.sort}">${articleInfo.article.sort}</a>
					 作者:${articleInfo.article.author}
					</h5>
				</div>
				<div class="r_div">
					<h5>
						<span class="glyphicon glyphicon-eye-open">&nbsp;<b>${articleInfo.article.visit}</b>&nbsp;</span>						
						 <span class="glyphicon glyphicon-heart" id="love1">&nbsp;<b id="love">${articleInfo.article.star}</b>&nbsp;</span> 
						 <span class="glyphicon glyphicon-comment">&nbsp;<b id="addComment">${articleInfo.article.comment}</b>&nbsp; </span>
					</h5>
				</div>
				<div id="tag">
					标签:
					<c:forEach items="${articleInfo.tags}" var="tag">
						<a href="${pageContext.request.contextPath}/index/tag/${tag.tag}">${tag.tag}&nbsp;</a>
					</c:forEach>
				</div>
			</div>
		</div>
			<div class="line"></div>
			<div id="a_content">
			<!-- 引入 show.jsp 显示文章内容 ${article.content}-->
			<jsp:include page="show.jsp"/>
			</div>
			<div>
				<div class="f_div">
					<span class="glyphicon glyphicon-chevron-left"></span>	
					<c:choose>				
					<c:when test="${articleInfo.previous!=null}">
						<a href="${articleInfo.previous.id}">上一篇:&nbsp;${articleInfo.previous.title}</a>
					</c:when>			
					<c:otherwise>
							&nbsp;没有更多的文章了
					</c:otherwise>	
					</c:choose>			
				</div>				
				<div class="r_div">	
				<c:choose>
					<c:when test="${articleInfo.next!=null}">
						<a href="${articleInfo.next.id}">下一篇:&nbsp;${articleInfo.next.title}</a>
					</c:when>			
					<c:otherwise>
							&nbsp;没有更多的文章了
					</c:otherwise>	
				</c:choose>		
					<span class="glyphicon glyphicon-chevron-right"></span>
				</div>
				
				<div>			
				<span class="btn btn-default" style="color:#d9534f;" onclick="love_article(${articleInfo.article.id})" id="loveClick">点赞</span>
				</div>						
				<br>
			</div>
			
			<div class="line"  id="com"></div>
			
			<!-- 评论 -->					
			<div class="comment"> 
			
			<div class="r_div">
			<a href="#comment"><span class="glyphicon glyphicon-pencil">&nbsp;写评论....</span></a>
			</div>
					
			<div id="showComment"><p align="center"><b>评论加载中...</b></p></div>
				
			</div>
			<!-- 这里可以扩展子评论 -->			
			
				
			<!-- 写评论 -->
			<div id="comment">
			
			<form id="submitForm" action="${pageContext.request.contextPath}/addComment" method="post">
			<input style="display: none;" class="form-control" id="articleId" name="articleId" value="${articleInfo.article.id}" type="text">
			<input style="width:30%" class="form-control" name="nickname" value="热心网友" type="text">
			<br>							
			<textarea style="resize:none; width:100%; height:180px;" name="content"></textarea>
			<br>
			<br>			
			<input class="btn btn-default" value="评论" type="button" onclick="submitForm()">	
			<br>						
			</form>			
			</div>
			<!--  -->    			
			<div class="line"></div>
	</div>
	<div id="footer">	
	<a href="/MyBlog/index">MyBlog首页&nbsp;&nbsp;</a>|
	<a href="#">&nbsp;&nbsp;返回顶部</a>
	</div>
	<!-- footer -->

</body></html>