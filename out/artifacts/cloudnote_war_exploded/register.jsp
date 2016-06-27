<%--
  Created by IntelliJ IDEA.
  User: loadi_000
  Date: 2016/5/5
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>注册</title>

    <meta content="text/html;charset=utf-8" >

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <%--<link rel="stylesheet" href="./css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="./js/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="./js/bootstrap.min.js"></script>

    <script src="./js/main.js"></script>


    <style type="text/css">
        body{
            font-family: "Microsoft YaHei", sans-serif;
            background-color: #eee ;
        }
    </style>
</head>
<body >
<div class="container">
    <form action="${pageContext.request.contextPath}/registerServletHibernate" method="post">
        <h2  class="form-signin-heading">注册</h2>
        <div class="form-group">
            <label >用户名</label>
            <input type="text" class="form-control" id="user-name" name="user-name" placeholder="昵称">
        </div>
        <div class="form-group">
            <label >邮箱</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="***@***.com">
        </div>
        <div class="form-group">
            <label id="password_check1" >密码</label>
            <input type="password" class="form-control"  id="form-password" name="password" placeholder="密码填这里" onblur="pwdRequired()">
            <span class="pwdMessage" ><font color="red">(   ´_ゝ｀   )您可能是输错密码的受害者</font></span>
        </div>
        <div class="form-group">
            <label id="password_check2">确认密码</label>
            <input type="password" class="form-control" id="form-repeat-password" placeholder="还得再输入一次"onblur="pwdRequired()">
            <span class="pwdMessage" ><font color="red">(   ´_ゝ｀   )您可能是输错密码的受害者</font></span>
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block" id="submitbutton" >Submit</button>
    </form>
</div>
</body>
</html>
