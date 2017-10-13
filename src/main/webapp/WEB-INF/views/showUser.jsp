<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
<% HttpSession s = request.getSession(); %>
	<span>测试已全部结束，测试者:<%=s.getAttribute("id") %>的最终本金为<%=s.getAttribute("capital") %>元</span>
</body>
</html>