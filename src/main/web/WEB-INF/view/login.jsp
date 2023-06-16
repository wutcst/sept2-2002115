<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 月下川
  Date: 2023/3/31
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../../css/login.css">
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<%--    <style type="text/css">--%>

<%--        form{--%>
<%--            padding: 0;--%>
<%--            margin: 0;--%>
<%--            border-radius: 5px;--%>
<%--            left: 50%;--%>
<%--            transform: translateX(-50%);--%>
<%--            /*border: none;*/--%>
<%--            width: 650px;--%>
<%--            height: 300px;--%>
<%--            position: absolute;--%>
<%--            background-color: #f5f5f5;--%>
<%--        }--%>
<%--        a{--%>
<%--            text-decoration: none;--%>
<%--        }--%>
<%--        div>span{--%>
<%--            margin-left:20px;;--%>
<%--        }--%>
<%--        input{--%>
<%--            position: relative;--%>
<%--            margin-bottom: 25px;--%>
<%--            width: 210px;--%>
<%--            height: 36px;--%>
<%--        }--%>
<%--        .footer{--%>
<%--            width: 100%;--%>
<%--            height: 50px;--%>
<%--            position: absolute;--%>
<%--            background-color: gray;--%>
<%--            bottom: 0px;--%>

<%--        }--%>
<%--        .container{--%>
<%--            float: left;--%>
<%--        }--%>
<%--        .in_footer{--%>
<%--            float: left;--%>
<%--            margin-top: 15px;--%>
<%--            width: 50%;--%>
<%--            text-align: center ;--%>
<%--            color: white;--%>
<%--        }--%>
<%--        .select_login_QQ{--%>
<%--            border-radius: 3px;--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            color: white;--%>
<%--            width: 225px;--%>
<%--            height: 40px;--%>
<%--            background-color:dodgerblue;--%>
<%--        }--%>
<%--        .select_login_Wechat{--%>
<%--            border-radius: 3px;--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            color: white;--%>
<%--            width: 225px;--%>
<%--            height: 40px;--%>
<%--            background-color: limegreen;--%>
<%--        }--%>
<%--        .select_login_Pay{--%>
<%--            border-radius: 3px;--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            color: black;--%>
<%--            width: 225px;--%>
<%--            height: 40px;--%>
<%--            background-color: #e5e5e5;--%>
<%--        }--%>
<%--        .icon{--%>
<%--            position: relative;--%>
<%--            left: 4px;--%>
<%--        }--%>
<%--        #select_login{--%>
<%--            margin-left: 40px;--%>
<%--        }--%>
<%--        #information{--%>
<%--            width: 210px;--%>
<%--        }--%>
<%--        #or{--%>
<%--            width: 130px;--%>
<%--        }--%>
<%--        #or_picture{--%>
<%--            position: relative;--%>
<%--            top: 50px;--%>
<%--            left: 36px;--%>
<%--        }--%>
<%--        #information{--%>
<%--            display: flex;--%>
<%--            flex-flow: column wrap;--%>
<%--            align-items: center;--%>
<%--        }--%>
<%--        #tip{--%>
<%--            display: none;--%>
<%--        }--%>
<%--        @media (max-width:650px){--%>
<%--            form{--%>
<%--                display: flex;--%>
<%--                flex-flow: column wrap;--%>
<%--                width: 300px;--%>
<%--                height: 550px;--%>
<%--            }--%>
<%--            #or{--%>
<%--                display: none;--%>
<%--            }--%>
<%--            #information{--%>
<%--                align-self: center;--%>
<%--                margin-top: 30px;--%>
<%--            }--%>
<%--            #tip{--%>
<%--                display: block;--%>
<%--                margin-top: 30px;--%>
<%--                color: gray;--%>
<%--            }--%>
<%--            .footer{--%>
<%--                height: 54px;--%>
<%--            }--%>
<%--            .in_footer{--%>
<%--                margin-top: 0;--%>
<%--                width: 100%;--%>
<%--                height: 50%;--%>
<%--            }--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<form id="loginForm" >
    <h3 align="center">登录</h3>
    <div class="container" id="information">
        <input type="text" id="username" placeholder="用户名" required><br>
        <input type="password" id="password" placeholder="密码" required><br>
        <input type="button" id="btn" value="登录">
    </div>
    <div class="footer">
        <a href="/register">
            <div class="in_footer">
                注册
            </div>
        </a>
        <a href="/change_password">
            <div class="in_footer">
                忘记密码
            </div>
        </a>
    </div>
</form>
<script src="<c:url value="/js/login.js"/>"></script>
</body>
</html>
