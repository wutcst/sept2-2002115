<%--
  Created by IntelliJ IDEA.
  User: 月下川
  Date: 2023/6/1
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="../../js/Game.js"></script>
    <link rel="stylesheet" href="../../css/Game.css">
</head>
<body style='overflow:Scroll;overflow-x:hidden' >
    <div id="text-aera">

    </div>
    <div id="screen">
        <div id="player">

        </div>
    </div>
    <div id="control">
        <input type="text" id="direction" placeholder="请输入方向">
        <button id="go">移动</button>
        <button id="help">帮助</button>
        <button id="quit" >退出</button>
    </div>

</body>
</html>
