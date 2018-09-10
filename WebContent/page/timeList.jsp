<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${YearList}" var="year">
		<div class="longline_div">
			<div>${year.year}年</div>
		</div>
		<c:forEach items="${year.months}" var="month">
			<div class="midline_div">
				<div>${month.month}月</div>
			</div>
			<c:forEach items="${month.articles}" var="article">
				<div class="line_div">
					<div>
						<a href="/MyBlog/showArticle/${article.id}">&nbsp;&nbsp;<fmt:formatDate
								value="${article.time}" type="date" dateStyle="full" />
							&nbsp;&nbsp;&nbsp;&nbsp;${article.title}
						</a>
					</div>
				</div>
			</c:forEach>
		</c:forEach>
	</c:forEach>


</body>
</html>