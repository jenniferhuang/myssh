<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/employee.do?flag=addEmp" method="post">
<table>
<tr><th>name：</th><th><input type="text" name="name"/></th></tr>
<tr><th>pwd：</th><th><input type="password" name="pwd"/></th></tr>
<tr><th>grade：</th><th><input type="text" name="grade"/></th></tr>
<tr><th>email：</th><th><input type="text" name="email"/></th></tr>
<tr><th>department</th><th>
<select name="dept_id">
<c:forEach items="${depts}" var="department">
<option value="${department.dept_id}">${department.name }</option>
</c:forEach>
</select>
</th></tr>
<tr><th><input type="submit" value="提交"/></th><th><input type="reset" value="重置"/></th></tr>
</table>


</form>
</body>
</html>