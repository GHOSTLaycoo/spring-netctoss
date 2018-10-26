<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
	<head>
		<mate></mate>
		<title></title>
	</head>
	<body>
	<form action="login.do" method="post">
		<p>姓名<input type="text" name="adminCode" value="${param.adminCode }"/></p>
		<p>密码<input type="password" name="password" value="${param.password }"/></p>
		<p>验证码<input type="text" name="code"/></p>
		<p><img src="createImg.do" onclick="this.setAttribute('src','createImg.do?x='+Math.random());" alt="验证码"/></p>
		<p><input type="submit" value="登陆"></p>
		<p><span>${login_failed }</span></p>
		</form>
	</body>
</html>