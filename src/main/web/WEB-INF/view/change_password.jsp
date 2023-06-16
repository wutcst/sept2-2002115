<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 月下川
  Date: 2023/3/31
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="<c:url value="/css/change_password.css"/>">
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="../../js/change_password.js"></script>
</head>
<body>
<form id="change_passswordform" >
    <h3 >修改密码</h3>
    <div class="container" id="information">
        <input type="text" name="username" id="username" placeholder="用户名"><br>
        <input type="password" name="password" id="password" placeholder="新密码"><br>
        <input type="password" name="password_check" id="password_check" placeholder="确认密码"><br>
        <input type="button" id="change_password" value="确认">
    </div>
    <div class="footer">
        <a href="<c:url value="/login"/>">返回登陆界面</a>
    </div>
</form >

</body>
</html>
