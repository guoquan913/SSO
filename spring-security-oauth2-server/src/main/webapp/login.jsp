<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">

		<h1>OAuth2服务器首页</h1>


		<div class="form-horizontal">
			<form action="login.do" method="post" role="form">
				<!-- <input type="hidden" name="grant_type" value="password">
				<input type="hidden" name="client_id" value="restapp">
				<input type="hidden" name="client_secret" value="restapp"> -->
				<fieldset>
					<legend>
						<h2>登入</h2>
					</legend>
					<%
						Exception exception = (Exception)session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
					%>
					<div class="error <%=exception==null?"hide":""%>">
						登陆失败:<br> 
						<%
							if(exception instanceof org.springframework.security.authentication.BadCredentialsException){
								out.println("用户名密码不匹配！");
							}
						%>
						${session['SPRING_SECURITY_LAST_EXCEPTION'].message}
					</div>
					<div class="form-group">
						<label for="username">用户名:</label> <input id="username" class="form-control" type='text' name='username' value="dongtian" />
					</div>
					<div class="form-group">
						<label for="password">密码:</label> <input id="password" class="form-control" type="password" name='password' value="dongtian" />
					</div>
					<button class="btn btn-primary" type="submit">登入</button>
				</fieldset>
			</form>

		</div>

		<div class="footer"></div>

	</div>


</body>
</html>
