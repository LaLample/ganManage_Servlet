<%--
  Created by IntelliJ IDEA.
  User: Charon
  Date: 2023/6/19
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <!--    <script src="/jq/jquery-3.3.1.min.js"></script>-->

    <script src="jq/jquery-3.3.1.min.js"></script>
    <script>
        //将表单内容提交到selvet当中
        $(function (){
            $("#registform").submit(function (){

                //ajax的异步请求
                $.post("registservlet",/*serialize方法用来将数据转为jquery格式：k：v*/$(this).serialize(),function (data){
                    //处理服务器响应的数据

                    if(data.flag){
                        //注册成功，跳转成功页面
                        alert("注册成功！")
                        location.href="login.html";
                    }
                    else{//注册失败！，给errorMsg添加提示信息\
                        alert("注册失败：用户名已存在")
                        $("errorMsg").html(data.errorMsg);
                    }
                    //         return false;
                })
                return false
            })
        })
    </script>
    <style>
        body{
            background: url("/photo/01.jpg")  no-repeat; background-size:100% ;
        }
        td{
            color: darkgray;

        }
        caption{
            color: black;
            font-size:20px;
        }
        .out{
            border: 1px solid crimson;
            background: aliceblue;
            height: 300px;
            width: 500px;
            text-align: center;
            line-height: 3;
            margin-top:250px;
            margin-left: 500px;
            box-sizing: border-box;
            text-align: center;
            padding-left: 100px;

        }
        a{
            font-size: 2px;
            color: brown;
            padding-right:100px;
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



    <!--    <script src="../../webapp/jq/jquery-3.3.1.min.js"></script>-->
    <!--    <script src="../../webapp/jq/jquery-3.3.1.min.js"></script>-->


</head>
<body>

<div class="out">
    <form  id="registform" action="registservlet">
        <table >
            <caption> 用户注册</caption>
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="username" name="username" placeholder="请输入用户名"></td>
            </tr>
            <tr>
                <td>请输入密码：</td>
                <td><input type="password" id="password" name="password" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td >
                    <button  class="btn btn-default" type="submit" name="regist" id="zc">注册</button>
                </td>
                <td> <a href="login.jsp" >已有账号？立即登录 </a></td>

            </tr>


        </table>

    </form>
</div>



</body>
</html>
