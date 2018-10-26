<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>JSp</title>
	</head>
	<body>
    <c:import url="./menu.jsp"></c:import>
	<c:import url="./logo.jsp"></c:import>
	<table>
		<c:forEach items="${costs }" var="c">
		<tr>
			<td>${c.costId }</td>
			<td>${c.name }</td>
			<td>${c.password }</td>
			
		</tr>
		</c:forEach>
	</table>
		
		
	</body>
</html>