
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>91大申网</title>

    <link rel="stylesheet" href="fdm/css/user/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="fdm/css/user/style.css">

    <script src="fdm/js/user/jquery-3.4.1.js"></script>
    <script src="fdm/js/user/jquery-3.4.1.min.js"></script>
    <script src="fdm/js/user/index.js"></script>
    <script src="fdm/layer/layer.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#btn").click(function (){
                //获取用户名和密码
                var username =$("#name").val();
                var password =$("#pass").val();
                if(username.trim().length<=0 || password.trim().length<=0){
                    layer.alert("用户名或密码为空",{icon: 5});
                }else{
                    $.ajax({
                        url: "${pageContext.request.contextPath}/user/login",
                        datatype: "json",
                        async: false, //请求是否异步，默认为异步
                        data: {"username":username,"password":password},
                        type: "post",
                        success:function(data){
                            if(data.status){
                                window.location.href="${pageContext.request.contextPath}/index.jsp";
                            }else{
                                layer.alert(data.msg,{icon: 5});
                                $("#pass").test("");
                            }
                        }
                    })
                }

            });
        });


    </script>
</head>
<body>

<div class="materialContainer">

        <div class="box">
            <div class="title">登录</div>
            <div class="input">
                <label for="name">用户名</label>
                <input type="text" name="username" id="name">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="pass">密码</label>
                <input type="password" name="password" id="pass">
                <span class="spin"></span>
            </div>
            <div style="height:20px;color:red;font-size:15px; z-index:999" id="notice"></div>
            <div class="button login">
                <button type="submit" id="btn" >
                    <span>登录</span>
                    <i class="fa fa-check"></i>
                </button>
            </div>
            <a href="javascript:" class="pass-forgot">忘记密码？</a>
        </div>


    <form method="post" action="/user/redister" id="redister">

        <div class="overbox">
            <div class="material-button alt-2">
                <span class="shape"></span>
            </div>
            <div class="title">注册</div>
            <div class="input">
                <label for="regname">用户名</label>
                <input type="text" name="username" id="regname">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="regpass">密码</label>
                <input type="password" name="password" id="regpass">
                <span class="spin"></span>
            </div>
            <div class="input">
                <label for="reregpass">确认密码</label>
                <input type="password" name="reregpass" id="reregpass">
                <span class="spin"></span>
            </div>
            <div class="button">
                <button type="submit">
                    <span>注册</span>
                </button>
            </div>
        </div>
    </form>



</div>



</body>
</html>
