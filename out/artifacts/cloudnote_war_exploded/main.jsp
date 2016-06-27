<%--
  Created by IntelliJ IDEA.
  User: loadi_000
  Date: 2016/5/8
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>云笔记</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="./js/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="./js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/main.css">

</head>
<body>
<div id="full-window" class="bg-danger">
    <div id="main-content" class="bg-info">
        <div id="topbg" class="bg-primary">
            <div id="top-left" class="bg-primary">
                <img id="top-left-logo" src="./img/cloud.ico">
            </div>
            <div id="top-center">
                <div>
                <a class="btn btn-default" role="button" style="position:absolute;left:5px;top: 10px;"
                   href="http://tieba.reloading.cn"
                   target="_blank">贴吧</a>
                </div>


                <div width="50px" height="50px" style="position:absolute;left:190px;top: 15px;">
                    <p>你好：${user.userName}</p>
                </div>
                <div width="50px" height="50px" style="position:absolute;left:300px;top: 10px;">
                    <a class="btn btn-default" role="button"
                   href="${pageContext.request.contextPath}/logoutServlet"
                   >注销</a>
                </div>
            </div>
            <div id="top-right" class="bg-primary">
                <div width="50px" height="50px">
                    <img id="top-right-logo" src="./img/twitter.png">
                </div>
                <div  height="50px">
                    <a class="btn btn-default" role="button" style="position:absolute;left:75px;top: 10px;"
                       href="${pageContext.request.contextPath}/userUpdate.jsp"
                       target="_blank">修改用户信息</a>
                </div>
            </div>
        </div>
        <div id="leftframe" class="bg-info">
            <div id="createbutton" class="bg-primary">
                <div class="buttoncontent ">
                    <a class="btn btn-success " href="#" role="button">新建</a>
                    <a class="btn btn-success " href="#" role="button">上传</a>
                </div>
            </div>
            <div id="leftlist" class="btn-primary">
                <div class="buttoncontent">
                    <ul>
                        <li style="width: 100px;"><a class="btn btn-default btn-block" role="button">1</a></li>
                        <li><a class="btn btn-default btn-block" role="button">2</a></li>
                        <li><a class="btn btn-default btn-block" role="button">3</a></li>
                    </ul>
                </div>
            </div>
            <div id="leftfile" class="btn-primary">
                <div class="buttoncontent">
                    <a class="btn btn-default" role="button" href="http://tieba.reloading.cn" target="_blank">文件库</a>
                </div>
            </div>
        </div>
    </div>
    <div id="note">
        <iframe id="noteframe" src="./note.jsp">
            <p>Your browser does not support iframes.</p>
        </iframe>
    </div>
</div>
</body>
</html>
