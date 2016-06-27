<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改用户信息</title>

    <meta content="text/html;charset=utf-8">

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="./js/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="./js/bootstrap.min.js"></script>

    <script src="./js/main.js"></script>


    <style type="text/css">
        body {
            font-family: "Microsoft YaHei", sans-serif;
            background-color: #eee;
        }
    </style>
</head>
<body>
<div class="container">
    <c:if test="${empty user}">
        <h2 class="form-signin-heading">无信息</h2>
        <a class="btn btn-default" role="button"
           href="login.jsp">登陆</a>
        <a class="btn btn-default" role="button"
           href="register.jsp">注册</a>
    </c:if>
    <c:if test="${not empty user}">
        <h2 class="form-signin-heading">云笔记</h2>
        <a class="btn btn-default" role="button"href="main.jsp">云笔记</a>
    </c:if>
</div>
</body>
</html>
