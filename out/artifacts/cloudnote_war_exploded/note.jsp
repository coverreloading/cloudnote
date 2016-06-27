<%--
  Created by IntelliJ IDEA.
  User: loadi_000
  Date: 2016/5/13
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
<%--http://summernote.org/examples/#example--%>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/summernote.min.js"></script>

    <style>
        @import url('http://cdn.gbtags.com/twitter-bootstrap/3.2.0/css/bootstrap.css');
        @import url('http://cdn.gbtags.com/font-awesome/4.1.0/css/font-awesome.min.css');
        @import url('css/summernote.css');
    </style>
</head>
<body>
<div class="container-fluid">


    <div id="editor">
    </div>
    <a class="btn btn-success " href="#" role="button" ">保存</a>

</div>

<script type="text/javascript">
    $('#editor').summernote();
</script>
</body>
</html>
