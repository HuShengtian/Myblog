<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>登录 | MyBlog</title>
 	<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->  
    <link rel="stylesheet" href="css/public.css"> 
    <link rel="stylesheet" href="css/login.css">  
</head>
<body>  
	<div class="container">
		<form action="login.do" method="post">

			<h1>
				<a href="http://localhost:8080/Blog/index.jsp">MyBlog</a>
			</h1>
			<div>${msg }</div>
			<label for="input" class="sr-only">用户名</label> 
			
			<input id="input" class="form-control" placeholder="用户名" name="userName" required="" type="text">
			
			<label for="inputPassword" class="sr-only">密码</label>
			
			<input id="inputPassword" class="form-control" placeholder="密码" name="userPassword" required="" type="password">

			<button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">登录</button>

			<a class="visitor" href="${pageContext.request.contextPath}/index">访客登录</a>
		</form>
	</div>

	<div id="footer">
		<a target="_blank" href="https://github.com/yamoo1206">
		<img src="img/github.png" class="img-circle" width="22px" height="22px">GitHub</a>
		by yamoo.		
	</div>
	<!-- footer -->

</body></html>