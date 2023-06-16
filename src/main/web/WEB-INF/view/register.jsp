<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 月下川
  Date: 2023/3/31
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="<c:url value="/css/register.css"/>">
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="../../js/register.js"></script>
</head>
<body>
<form id="registerform" >
    <h3 >注册</h3>
    <div class="container" id="information">
        <input type="text" name="username" id="username" placeholder="用户名"><br>
        <input type="password" name="password" id="password" placeholder="密码"><br>
        <input type="text" name="email" id="email" placeholder="电子邮箱"><br>
        <input type="date" name="birthday" id="date"><br>
        <input type="button" id="register" value="注册">
    </div>
    <div class="footer">
        <a href="<c:url value="/login"/>">返回登陆界面</a>
    </div>
</form >
</body>
</html>
