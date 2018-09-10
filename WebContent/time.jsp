<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时间轴 | MyBlog</title>

<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="page/signin.html" rel="stylesheet">

<!-- 引入页面公共样式 -->
<link type="text/css" rel="stylesheet" href="css/public.css">
<!-- 引入本页面的特殊样式 -->
<link type="text/css" rel="stylesheet" href="css/axis.css">

</head>
<body>
	<div class="head_line"></div>

	<div class="container" id="main">

		<div id="header"></div>

		<div class="row c_center">
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2>
						<a href="http://localhost:5224/Blog/index.jsp">MyBlog</a>
					</h2>
					<h5 class="text-muted">Winner Winner Chicken Dinner!</h5>
				</div>

				<div class="c_center" id="person_info">
					<img src="img/header.jpg" alt="what?" class="img-circle" width="130" height="130">
					<h5 class="text-muted">Chicken Dinner Again!</h5>
				</div>

				<div id="list">
					<table class="table table-hover c_center">
						<tbody><tr>
							<td><a href="http://localhost:5224/Blog/index.jsp"><span class="glyphicon glyphicon-home"></span>
								&nbsp;&nbsp;首页</a></td>
						</tr>
						<tr>	
							<td><a href="http://localhost:5224/Blog/SortServlet?get=all"><span class="glyphicon glyphicon-list"></span>
								&nbsp;&nbsp;分类</a></td>
						</tr>
						<tr>
							<td><a href="http://localhost:5224/Blog/TagsServlet?get=all"><span class="glyphicon glyphicon-tags"></span>
								&nbsp;&nbsp;标签</a></td>
						</tr>						
						<tr>
							<td class="active"><a href="http://localhost:5224/Blog/AxisServlet"><span class="glyphicon glyphicon-book"></span>
								&nbsp;&nbsp;时间轴</a></td>
						</tr>
						<tr>
							<td><a href="http://localhost:5224/Blog/page/about.html"><span class="glyphicon glyphicon-user"></span>
								&nbsp;&nbsp;关于</a></td>
						</tr>
					</tbody></table>
				</div>
				<!-- list -->
				<br>
			</div>
			<div class="col-md-2" id="center_content"></div>
			
			<div class="col-md-7 " id="axis_div">
				<!-- 这里初始化时间轴 -->		
				
					
						
							<div class="longline_div">
								<div> 2018</div>
							</div>
						
						
					
				
					
						
						
							<div class="line_div">
								<div>
									<a href="http://localhost:5224/Blog/ArticleServlet?id=12">&nbsp;&nbsp;8-13
									&nbsp;&nbsp;&nbsp;&nbsp;测试
									</a>
								</div>
							</div>
						
					
				
					
						
						
							<div class="line_div">
								<div>
									<a href="http://localhost:5224/Blog/ArticleServlet?id=11">&nbsp;&nbsp;8-13
									&nbsp;&nbsp;&nbsp;&nbsp;测试文件
									</a>
								</div>
							</div>
						
					
				
					
						
						
							<div class="line_div">
								<div>
									<a href="http://localhost:5224/Blog/ArticleServlet?id=10">&nbsp;&nbsp;8-12
									&nbsp;&nbsp;&nbsp;&nbsp;123123
									</a>
								</div>
							</div>
						
					
				
				<!-- 初始化结束 -->
			</div>
			
		</div>
		
		<div class="foot_line"></div>
	</div>	
	<!-- container -->
	<div id="footer">
		<a href="#">&nbsp;&nbsp;MyBlog</a>
	</div>
	<!-- footer -->

</body></html>