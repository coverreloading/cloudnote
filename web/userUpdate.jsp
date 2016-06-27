<%--
  Created by IntelliJ IDEA.
  User: loadi_000
  Date: 2016/5/5
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
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
        <form action="${pageContext.request.contextPath}/userUpdateServletHibernate" method="post">
            <h2 class="form-signin-heading">修改用户信息</h2>
            <div class="form-group">
                <label>用户名</label>
                <input type="text" class="form-control" id="user-name" name="userName" value="${user.userName}"onblur="updateCheck()">
            </div>
            <div class="form-group">
                <label>邮箱</label>
                    <%--${requestScope["user"]}--%>
                    ${ user.email }
            </div>
            <div class="form-group">
                <label>年龄</label>
                <input type="text" class="form-control" id="age" name="age" value="${user.age}" onblur="updateCheck()">
            </div>
            <div class="form-group">
                <label>性别</label><br>
                <input type="radio" name="sex" value="男">男<br>
                <input type="radio" name="sex" value="女" >女
                <input type="radio" name="sex" value="不男不女" checked="checked">不男不女


                <%--<input type="text" class="form-control" id="sex" name="sex" placeholder="${user.sex}"onchange="updateCheck()">--%>
            </div>
            <div class="form-group">
                <label>手机</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone} "onblur="updateCheck()">
            </div>
            <button type="submit" class="btn btn-lg btn-primary btn-block" id="submitbutton" disabled="true"  >Submit</button>
        </form>
    </c:if>
</div>
</body>
</html>
