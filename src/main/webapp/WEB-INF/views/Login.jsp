<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/SSM-Test2/src/main/resources/jquery-1.10.2.full.js"></script>
<script type="text/javascript">
function test_login(){
	var id = document.getElementById("id").value;
	var pwd= document.getElementById("password").value;
	window.location.href="login?id="+id+"&password="+pwd;
}
</script>
</head>
<body>
	<div>
		<span>用户名:</span>
		<input type="text" id="id">
	</div>
	<div>
		<span>密码:</span>
		<input type="text" id="password">
	</div>
	<div>
   		<input type = "submit" id= "login" onclick="test_login();" value="登陆">
   	</div>
</body>
</html>