<%--
  Created by IntelliJ IDEA.
  User: Charon
  Date: 2023/6/19
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>查询游戏</title>
    <script src="jq/jquery-3.3.1.min.js"></script>
    <script>

        $(function (){
            $("#checkgameform").submit(function (){
                // alert("aaaaaa")

                $.post("checkgamesservlet",/*serialize方法用来将数据转为jquery格式：k：v*/$(this).serialize(),function (data){
                    var g="";
                    if(data.flag){
                        alert("查询成功！")
                        $("#table2").find("tr").remove();
                        g=data.ga;
                        var t="<tr id='check'>"+"<td align='center'>"+g.gamesname +"</td>"+"<td align='center'>"+g.price+"</td>"+"</tr>";
                        var FirstLine=" <tr id='FirstLine'>"+"<th>"+"游戏名"+"</th>"+"<th>"+"价格"+"</th>"+ "</tr>";
                        $("#table2").append(FirstLine);
                        $("#table2").append(t);
                    }
                    else{//注册失败！，给errorMsg添加提示信息\
                        alert("查询失败：请检查游戏名")
                        $("errorMsg").html(data.errorMsg);
                    }

                })
                return false
            })
        })

    </script>





    <style>

        body{
            background: url("/photo/07.jpg" ) no-repeat;background-size: 100%;
        }
        #checkgameform{
            /*border: 1px solid crimson;*/
            /*background: aliceblue;*/
            height: 100px;
            width: 500px;
            text-align: center;
            line-height: 3;
            margin-top:100px;
            margin-left: 500px;
            box-sizing: border-box;
            padding-left: 100px;
        }
        #table2{
            border: 1px solid crimson;
            background: aliceblue;
            line-height: 3;
            text-align: center;
            margin-top:1px;
            margin-left: 480px;
            box-sizing: border-box;
        }
        #gamesname{
            width: 300px;
            height: 30px;

        }
    </style>
</head>
<body>
<form id="checkgameform" action="/checkgamesservlet">
    <table id="checkgametable">
        <tr>
            <td><input type="text" placeholder="请输入需要查询的游戏名" id="gamesname" name="gamesname"></td>
        </tr>
        <tr>
            <td><button type="submit" id="btn" class="btn" name="btn">查询</button></td>
        </tr>
    </table>


</form>
<table cellpadding = 5 cellspacing = 1 width = 620 id = "table2" class="table2"  border = "1"> </table>
</body>
</html>
