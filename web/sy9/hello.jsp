<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Hello</title></head>
<body>
<img src="images/head.jpg">
My name is Fuck.What is yours?
<form action="" method="post">
    <input type="text" name="username" size="25">
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
<%! String username ="Fuck";%>
<%@include file="response.jsp"%>
</body>
</html>