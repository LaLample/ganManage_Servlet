<%--
  Created by IntelliJ IDEA.
  User: Charon
  Date: 2023/6/19
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎来到游戏管理系统</title>
</head>
<style>
    body{
        background: url("/photo/05.jpg " ) no-repeat;background-size: 100%  ;
    }
    table{
        margin-left: 350px;
        margin-top: 245px;
    }

</style>
<body>
<table>
    <tr>
        <td><a href="gamebase.jsp"><img src="photo/06.jpg" width="200px" height="300px"></a></td>
        <td><a href="checkgames.jsp"><img src="photo/07.jpg" width="200px" height="300px"></a></td>
        <td><a href="addgame.jsp"><img src="photo/10.jpg" width="200px" height="300px"></a></td>
        <td><a href="deletegames.jsp"><img src="photo/03.jpg" width="200px" height="300px"></a></td>
    </tr>
    <td> <font  color="black" size="5"><i>游戏库</i></font></td>
    <td> <font  color="black" size="5"><i>查询游戏</i></font></td>
    <td> <font  color="black" size="5"><i>修改游戏</i></font></td>
    <td> <font  color="black" size="5"><i>删除游戏</i></font></td>


</table>

</body>
</html>
