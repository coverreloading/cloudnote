<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script language="JavaScript" type="text/javascript">
    function check(){
        open("/helloweb/register.jsp","register");
    }
</script>
<p><img alt="Here is a logo."src="images/head.jpg"/> </p>
<form action="login.do" method="post" name="login">
    <p>用户名<input type="text" name="username" size="13"/>
        密码<input type="password"name="password"size="13"/>
        <input type="submit"name="submit" value="登录">
        <input type="button" name="register" value="注册" onclick="check();">
    </p>
</form>