<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>expression</title>
</head>
<body>
<%!
    int anInt = 3;
    boolean aBool = true;
    Integer anIntobj = new Integer(3);
    Float aFloatObj = new Float(8.6);
%>
<%= 500+ 380 %><br>
<%= anInt*3.5/100-500 %><br>
<%= aBool %><br>
<%= Math.random() %><br>
<%= aFloatObj %><br>
</body>
</html>
