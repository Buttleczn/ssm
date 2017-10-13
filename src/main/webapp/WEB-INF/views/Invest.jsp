<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invest.jsp</title>
<script src="/SSM-Test2/src/main/resources/jquery-1.10.2.full.js"></script>
<script type="text/javascript">
function confirm(){
	var cap_money = document.getElementById("capital").innerHTML;
	var inv_money = document.getElementById("invest").value;
	var turn = document.getElementById("turn").innerHTML;
	var id = document.getElementById("id").innerHTML;
	if(inv_money == ""){
		alert("投资金额不能为空");
		return;
	}else if(parseInt(inv_money)>parseInt(cap_money)){
		alert("投资金额不能大于本金");
		return;
	}
	window.location.href="confirm?id="+id+"&turn="+turn+"&capital="+cap_money+"&invest="+inv_money;
}
function next(){
	var turn = document.getElementById("turn").innerHTML;
	var id = document.getElementById("id").innerHTML;
	window.location.href="next?id="+id+"&turn="+turn;
}
</script>
</head>
<body>
<% HttpSession s = request.getSession(); %>
	<div>
		<span>第</span>
		<span id="turn"><%=s.getAttribute("turn") %></span>
		<span>轮</span>
	</div>
	<div>
		<span>测试人:</span>
		<span id="id"><%=s.getAttribute("id") %></span>
	</div>
   	<div>
   		<span>本金:</span>
   		<span id="capital"><%=s.getAttribute("capital") %></span>
   	</div>
   	<div>
   		<span> 我要投资</span>
   		<input type="text" id="invest" onkeyup="value=value.replace(/[^(\d)]/g,'')">
   	</div>
   	<div>
   		<span id="comment" style="color:#F00"><%=s.getAttribute("comment") %></span>
   	</div>
   	<input type="submit" id="confirm" value="确认" onclick="confirm()">  
   	<input type="submit" id="next" value="下一轮" onclick="next()">
</body>
</html>