<%--
  Created by IntelliJ IDEA.
  User: loadi_000
  Date: 2016/5/5
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>

    <meta content="text/html;charset=utf-8" >

    <%--<!-- 新 Bootstrap 核心 CSS 文件 -->--%>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="./js/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="./js/bootstrap.min.js"></script>

    <style type="text/css">
        body {
            font-family: "Microsoft YaHei", sans-serif;
            background-color: #eee;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/loginServletHibernate" method="post">
        <h2 class="form-signin-heading">登陆</h2>
        <div class="form-group">
            <label>邮箱</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="***@***.com">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="密码填这里">
        </div>
        <div class="form-group">
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="remember"> 记住我
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block">登陆</button>
    </form>
</div>
</body>
</html>
