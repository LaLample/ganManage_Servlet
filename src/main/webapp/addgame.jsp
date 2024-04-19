<%--
  Created by IntelliJ IDEA.
  User: Charon
  Date: 2023/6/19
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加游戏</title>
    <script src="jq/jquery-3.3.1.min.js"></script>
    <script>

        $(function (){
            $("#addgameform").submit(function (){
                // alert("aaaaaa")

                $.post("addgamesservlet",/*serialize方法用来将数据转为jquery格式：k：v*/$(this).serialize(),function (data){

                    if(data.flag){

                        alert("添加成功！")
                    }
                    else{//注册失败！，给errorMsg添加提示信息\
                        alert("添加失败：游戏已存在")
                        $("errorMsg").html(data.errorMsg);
                    }

                })
                return false
            })
        })

    </script>





    <style>

        body{
            background: url("/photo/08.jpg" ) no-repeat;background-size: 100%;
        }
        #addgameform{
            /*border: 1px solid crimson;*/
            /*background: aliceblue;*/
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
        #gamesname{
            width: 300px;
            height: 30px;

        }
        #price{
            width: 300px;
            height: 30px;
        }
    </style>
</head>
<body>
<form id="addgameform" action="/addgamesservlet">
    <table id="addgametable">
        <tr>
            <td><input type="text" placeholder="请输入需要添加的游戏名" id="gamesname" name="gamesname"></td>
        </tr>
        <tr>
            <td>
                <input type="text" placeholder="请输入需要相应的价格" id="price" name="price">
            </td>
        </tr>
        <tr>
            <td><button type="submit" id="btn" class="btn" name="btn">添加</button></td>
        </tr>
    </table>

</form>
</body>
</html>