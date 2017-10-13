<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/SSM-Test2/src/main/resources/jquery-1.10.2.full.js"></script>
<script type="text/javascript">
function report_sel(){
	window.location.href="report";
	
}
</script>
</head>
<body>
<style>
    table,table tr th, table tr td { border:1px solid #0094ff; }
    table { width: 100%; min-height: 20px; line-height: 20px; text-align: center; border-collapse: collapse; font-size:13px;}   
</style>
	<table>
	 	<colgroup>
	 		<col width="4%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 		<col width="6%" />
	 	</colgroup>
	 	<tbody>
			<tr>
				<th>测试者</th>
				<th>第一轮本金</th>
				<th>第一轮投资</th>
				<th>第二轮本金</th>
				<th>第二轮投资</th>
				<th>第三轮本金</th>
				<th>第三轮投资</th>
				<th>第四轮本金</th>
				<th>第四轮投资</th>
				<th>第五轮本金</th>
				<th>第五轮投资</th>
				<th>第六轮本金</th>
				<th>第六轮投资</th>
				<th>最终本金</th>
			</tr>
			<c:forEach items="${item}" varStatus="i" var="item">  
			<tr>
				<td>${item.id1 }</td>
				<td>${item.capital1}</td>
				<td>${item.invest1}</td>
				<td>${item.capital2}</td>
				<td>${item.invest2}</td>
				<td>${item.capital3}</td>
				<td>${item.invest3}</td>
				<td>${item.capital4}</td>
				<td>${item.invest4}</td>
				<td>${item.capital5}</td>
				<td>${item.invest5}</td>
				<td>${item.capital6}</td>
				<td>${item.invest6}</td>
				<td>${item.capital7}</td>
			</tr>
			</c:forEach> 
		</tbody>
	</table>
	<div>
   		<input type = "submit" id= "btn_report" onclick="report_sel();" value="查询">
   	</div>
</body>
</html>