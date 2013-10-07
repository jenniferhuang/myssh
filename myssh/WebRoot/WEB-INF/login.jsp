<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" >
 function goConfirm(){
   var id=document.form1.id.value;
   var pw=document.form1.pwd.value;
   if(id==""||id==0){
     window.alert("id不能为空");
     return false;
   }
   if(pw==""){
    window.alert("pwd不能为空");
    return false;
   }
	    
 }
</script>

<title>登录页面</title>
</head>
<body>


<form name="form1"  action="${pageContext.request.contextPath}/login.do?flag=login" method="post"  onsubmit="return goConfirm()">
<table>
<tr><td>id：</td><td><input type="text" name="id" id="id"/></td></tr>
<tr><td>pw：</td><td><input type="password" name="pwd" id="pwd"/></td></tr>
<tr><td><input type="submit" value="提交" /></td><td><input type="reset" value="重置"/></td></tr>
</table>
</form>


</body>
</html>