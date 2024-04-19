<%--
  Created by IntelliJ IDEA.
  User: Charon
  Date: 2023/6/19
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>发送评论</title>
    <!--    <script src="/jq/jquery-3.3.1.min.js"></script>-->

    <script src="jq/jquery-3.3.1.min.js"></script>
    <script>
        //将表单内容提交到selvet当中
        $(function (){
            $("#speakingform").submit(function (){
                // alert("aaaaaaa")
                //ajax的异步请求

                $.post("speakingservlet",/*serialize方法用来将数据转为jquery格式：k：v*/$(this).serialize(),function (data){
                    //处理服务器响应的数据

                    if(data.flag){
                        //成功
                        alert("评论成功！")
                        location.href="speakingarea.jsp"

                    }
                    else{//注册失败！，给errorMsg添加提示信息\
                        alert("删除失败：请重新检查游戏名")
                        $("errorMsg").html(data.errorMsg);
                    }
                    //         return false;
                } )
                return false
            })
        })
    </script>
    <style>
        body{
            background: url("/photo/09.jpg")  no-repeat; background-size:100% ;
        }
        td{
            color: darkgray;

        }
        caption{
            color: black;
            font-size:30px;
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
        #Gamesname{
            height: 20px;
            width:150px;
        }
        #name{
            font-size: 20px;
            color:black;
        }
        #dl{
            height:30px;
            width: 50px;

        }

    </style>


    <!--    <script src="../../webapp/jq/jquery-3.3.1.min.js"></script>-->
    <!--    <script src="../../webapp/jq/jquery-3.3.1.min.js"></script>-->


</head>
<body>

<div class="out">
    <form  id="speakingform" action="/speakingservlet">
        <table >
            <i><caption> 游戏评论</caption></i>
            <tr>
                <td id="name">请输入评论内容：</td>
                <td><input type="text" id="speaking" name="speaking" placeholder="请输入评论内容"></td>
            </tr>
            <tr>
                <td >
                    <button  class="btn btn-default" type="submit" name="delete" id="dl">评论</button>

                </td>

            </tr>


        </table>

    </form>
</div>



</body>
</html>