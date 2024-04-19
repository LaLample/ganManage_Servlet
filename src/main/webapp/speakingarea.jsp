<%--
  Created by IntelliJ IDEA.
  User: Charon
  Date: 2023/6/19
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>评论区</title>
    <script src="jq/jquery-3.3.1.min.js"></script>
    <style>
        body{
            background: url("photo/06.jpg" ) no-repeat;background-size: 100%;
        }
        #start{
            font-size: 50px;
            color:red;
            margin-left: 550px;
            margin-top: 30px;
        }
        #table2{
            border: 1px solid crimson;
            background: aliceblue;
            height: 150px;
            width: 800px;
            text-align: center;
            line-height: 1;
            margin-top:100px;
            margin-left: 300px;
            box-sizing: border-box;
            text-align: center;
            /*padding-left: 100px;*/
        }
        #submit{
            margin-left: 250px;
            height: 30px;
            width: 80px;
        }
    </style>
    <script>
        $(function (){
            $("#submit").click(function (){
                // alert("abbb")
                $("#table2").find("tr").remove();
                var body="";
                var t1="";

                $.post("speakingareaservlet",$("#speakingareaform").serialize(),function (data){
                    // alert("aaa")
                    body=data.speakarea;
                    for(i=0;i<body.length;i++){
                        var t="";
                        t="<tr id='check'>";
                        t+="<td align='center'>"+body[i].id+"</td>";
                        t+="<td align='center'>"+ body[i].usernames+"</td>";
                        t+="<td align='center'>"+body[i].speaking+"</td>";
                        t+="</tr>"
                        t1+=t;
                    }





                    var FirstLine=" <tr id='FirstLine'><th>"+"id"+"</th>"+"<th>"+"用户名"+"</th>"+"<th>"+"评论"+"</th>"+ "</tr>";
                    $("#table2").append(FirstLine);
                    $("#table2").append(t1);
                })
            })
        })
    </script>

</head>
<body>
<div id="start">欢迎来到评论区</div>
<form action="speakingareaservlet" name="speakingareaform" id="speakingareaform"></form>
<div id="submits"><input type="submit" id="submit" value="打开评论区"></div>
<table cellpadding = 5 cellspacing = 1 width = 620 id = "table2" class="table2"  border = "1">
</table >
</body>
</html>
