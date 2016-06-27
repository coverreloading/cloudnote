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
    <script src="js/mySummernote.js"></script>


    <style>
        @import url('http://cdn.gbtags.com/twitter-bootstrap/3.2.0/css/bootstrap.css');
        @import url('http://cdn.gbtags.com/font-awesome/4.1.0/css/font-awesome.min.css');
        @import url('css/summernote.css');
    </style>
</head>
<body>
<div class="container-fluid">

    <div class="input-group">
        <div class="input-group-addon">笔记名</div>
        <input type="text" class="form-control" id="noteName" placeholder="笔记名" value="${chooseNote.noteName}" onblur="get()">
    </div>
    <div id="summernote" onblur="get()">云笔记</div>
    <form id="_form" method="post" action="/updateNoteServlet">
        <input id="noteContent2" type="hidden" name="noteContent" />
        <input id="noteName2" type="hidden" name="noteName" />
        <button type="submit" class="btn btn-success" onclick="get()" >保存</button>
    </form>
    <span id="successMessage" hidden="hidden">保存成功</span>
    <span id="failMessage" hidden="hidden" style="color: #ff0000;">保存失败</span>

</div>
<script>
    $(document).ready(function () {
        $('#summernote').summernote();
        $('#summernote').summernote({
            airPopover: [
                ['color', ['color']],
                ['font', ['bold', 'underline', 'clear']],
                ['para', ['ul', 'paragraph']],
                ['table', ['table']],
                ['insert', ['link', 'picture']]
            ]
        });
        $('#summernote').summernote({
            height: 300,
            minHeight: 600,
            maxHeight: 700,
            focus: false
        });
        //赋值
        $('#summernote').code('${chooseNote.content}');
    });
</script>
</body>
</html>
