<%--
  Created by IntelliJ IDEA.
  User: Charon
  Date: 2023/6/19
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="jq/jquery-3.3.1.min.js"></script>
    <script>
        //1.给登录按钮绑定单击时间
        $(function (){
            $("#dl").click(function (){
                //2.点击登录按钮后发送一个ajax请求进行提交表单数据
                $.post("loginservlet",$("#loginform").serialize(),function (data){
                    if(data.flag){
                        //登录成功
                        alert("登录成功！")
                        location.href="system.jsp";
                    }else{
                        //登陆失败
                        alert("登录失败！用户名或密码错误")
                        $("#errorMsg").html(data.errorMsg);
                    }
                })
            })
        })



        //3.处理响应结果



    </script>
    <style>
        #out{
            border-radius:10px;
            border:1px solid aliceblue;
            background: aliceblue;
            width: 500px;
            height: 300px;
            text-align: center;
            margin-top: 250px;
            margin-left: 500px;
            box-sizing: border-box;
            padding-left: 100px;
            line-height: 3;

        }
        body{
            background: url("/photo/02.jpg ") no-repeat; background-size:100%;
        }
        caption{
            color: black;
            font-size: 20px;
        }
        a{
            font-size: 2px;
            color: brown;
            padding-right:10px;
        }
        td{
            color: darkgray;
        }
        #zc{
            background: yellow;
            size: 70px;
            width: 70px;
        }
        table
        {
            width: 450px;
            margin-right: 550px;
            margin-top: 65px ;
            margin-left: auto;
            border-collapse:   separate;   border-spacing:   20px;

        }
    </style>

</head>
<body>
<!-- 提示错误信息-->
<div id="errorMsg" class="alert alert-danger">  </div>
<div id="out">
    <form id="loginform" name="loginform" action="loginservlet">
        <table>
            <caption>用户登录</caption>
            <tr>
                <td >用户名：</td>
                <td><input type="text" placeholder="请输入用户名" name="username"></td>
            </tr>
            <tr>
                <td> 密码：</td>
                <td> <input type="password" placeholder="请输入密码" name="password"></td>
            </tr>
            <tr>
                <td>
                    <button  class="btn btn-default" type="submit" name="login" id="dl" >登录</button>
                </td>
                <td><a href="zhuce1.jsp">还没有账号？立即注册</a> </td>
            </tr>

        </table>
    </form>


</div>

</body>
</html>
