<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>员工列表</title>
</head>
<body>
<CENTER>
<h1>员工列表</h1>

<table border="1" align="center" >
<tr><th>id</th><th>name</th><th>grade</th><th>email</th><th>hiredate</th><th>department</th><th>修改员工</th><th>删除员工</th></tr>
<c:forEach begin="0" items="${emps}" var="emp">
<tr>
<td>${emp.id}</td><td>${emp.name}</td><td>${emp.grade}</td><td>${emp.email}</td><td>${emp.hiredate}</td><td>${emp.department.name }</td>
<td><a href="">修改员工</a></td><td><a href="">删除员工</a></td>
</tr>
</c:forEach>
</table>

<c:forEach begin="1" end="${pageCount}" var="i">
<a href="${pageContext.request.contextPath}/employee.do?flag=empList&pageSize=${pageSize }&pageNow=${i}">${i }</a>
</c:forEach>

总记录数：${rowCount}


</CENTER>
</body>
</html>