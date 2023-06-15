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
    <div id="message">

    </div>
    <div id="screen">
        <div id="east" class="direction"></div>
        <div id="west" class="direction"></div>
        <div id="south" class="direction"></div>
        <div id="north" class="direction"></div>
        <div id="TV" class="object"></div>
        <div id="seat" class="object"></div>
        <div id="cup" class="object"></div>
        <div id="wine" class="object"></div>
        <div id="microscope" class="object"></div>
        <div id="computer" class="object"></div>
        <div id="desk" class="object"></div>
        <div id="book" class="object"></div>
        <div id="pen" class="object"></div>
        <div id="player">

        </div>
    </div>
    <div id="control">
        <button id="help">帮助</button>
    </div>
    <div id="object_table">
        <table>
            <thead>
                <tr>
                    <th class="name">物品</th>
                    <th class="weight">重量</th>
                    <th class="operation">操作</th>
                </tr>
            </thead>
            <tbody id="object_items">

            </tbody>
        </table>
    </div>
</body>
</html>
