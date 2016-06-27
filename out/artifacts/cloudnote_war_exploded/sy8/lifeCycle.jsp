<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%!
    int count =0;
    public void jspInit(){
        System.out.println("jspInt...");
    }
    public void jspDestroy(){
        System.out.println("jspDestroy...");
    }
%>
<html>
<head>
    <title>jspInit and jspDestroy</title>
</head>
<body>
    <% count++; %>
    覆盖jspInit()和jspDestroy()!<br>
    该页面被访问 <%=count %> 次
</body>
</html>
