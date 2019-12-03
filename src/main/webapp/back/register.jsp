
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Flat Admin - Bootstrap Themes</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">
    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../fdm/layer/layer.js"></script>

    <script type="text/javascript">
        $(function() {
            $("#register").click(function (){
                //获取表单值
                var username=$("#username").val();
                var password=$("#password").val();
                var realname=$("#realname").val();
                var email=$("#email").val();
                var againpwd=$("#againPwd").val();
                //首先确认两次密码是否输入一致
                if (password === againpwd){
                    $.ajax({
                        url: '${pageContext.request.contextPath}/user/register',
                        datatype: "json",
                        type:"post",
                        data:{"username":username,"password":password,"email":email,"realname":realname},
                        contentType: false, // 不使用默认请求头类型 application/x-www-form-urlencoded; charset=UTF-8
                        processData: false, // 不序列化
                        success:function (data) {
                            alert(username);
                            if(data.status){
                                window.location.href="${pageContext.request.contextPath}/back/login.jsp";
                            }else{
                                layer.alert("<span style='color: #0c0c0c'>+data.msg+</span>",{icon: 5});
                            }
                        }
                    });
                }else{
                    layer.alert("<span style='color: #0c0c0c'>"+"密码输入不一致，请确认密码"+"</span>",{icon:5});
                }

            });
        });
    </script>
</head>

<body>

    <div class="container">
        <div class="login-box">
                <div class="title"><h3><i class="fa fa-pencil-square-o"></i> Create new account</h3></div>
                
                    <div class="progress hidden" id="login-progress">
                      <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                        Creating new account...
                      </div>
                    </div>
                    <div class="alert alert-success hidden" id="login-message" role="alert">
                                        Create Success. Please wait for loading.
                                    </div>
                <div class="box">


                    <div class="control">
                        <div class="label">昵称</div>
                        <input type="text" class="form-control" id="username" />
                    </div>
                    <div class="control">
                        <div class="label">姓名</div>
                        <input type="text" class="form-control" id="realname" />
                    </div>
                    <div class="control">
                        <div class="label">邮箱</div>
                        <input type="text" class="form-control" id="email" />
                    </div>
                    <div class="control">
                        <div class="label">密码</div>
                        <input type="password" class="form-control" id="password" />
                    </div>
                    <div class="control">
                        <div class="label">确认密码</div>
                        <input type="password" class="form-control" id="againPwd" />
                    </div>
                    <div class="login-button">
                        <input type="submit" class="btn btn-orange" id="register" value="Register"></button>
                    </div>
                </div>
                <div class="info-box">
                   <span class="text-left"><a href="login.jsp">Already have account. Log in.</a></span>
                   <div class="clear-both"></div>
                </div>
        </div>
    </div>

</body>

</html>
