<%@ page contentType="text/html;charset=UTF-8" pageEncoding ="UTF-8" %>
<html>
<head>
    <title>compute area of a circle</title>
</head>
<body>
<%
    String s=  request.getParameter("radius");
    if(s==null)
        s="0";
    r=Double.parseDouble(s);
%>
<form action = "area.jsp" method="post">
    请输入圆的半径:
    <input type="text" name="radius" size="5"/>
    <input type="submit" value="提交"/>
</form>
半径为<%= r %> 的圆的面积为:<%=area(r) %>
<%!
    double r =0;
    double area(double r){
        return r *r* Math.PI;
    }
%>
</body>
</html>
