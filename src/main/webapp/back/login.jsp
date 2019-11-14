
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>91大申网</title>
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

    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script src="../fdm/layer/layer.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>


<script type="text/javascript">
    $(function() {
        $("#btn").click(function (){
            //获取用户名和密码
            var username =$("#username").val();
            var password =$("#password").val();
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
                        console.log("data"+data.status);
                        if(data.status){
                            window.location.href="${pageContext.request.contextPath}/back/index.jsp";
                        }else{
                            layer.alert(data.msg,{icon: 5});
                        }
                    }
                })
            }

        });
    });


</script>
<body>

    <div class="container">
        <div class="login-box">
                <div class="title"><h3>Flat Admin</h3></div>
                <div class="progress hidden" id="login-progress">
                          <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                            Log In...
                          </div>
                        </div>
                    <div class="alert alert-success hidden" id="login-message" role="alert">
                                        <i class="fa fa-check"></i> Login Success. Please wait for loading.
                                    </div>
                <div class="box">

                        
                        <div class="control">
                            <div class="label">Email Address</div>
                            <input type="text" class="form-control" id="username" />
                        </div>
                        <div class="control">
                            <div class="label">Password</div>
                            <input type="password" class="form-control" id="password" />
                        </div>
                        <div class="login-button">
                            <input type="submit" id="btn" class="btn btn-orange" value="Login"></button>
                        </div>
                </div>
                <div class="info-box">
                   <span class="text-left"><a href="register.html">Create new account</a></span>
                   <span class="text-right"><a href="#">Forgot password?</a></span>
                   <div class="clear-both"></div>
                </div>
        </div>
    </div>
    <script type="text/javascript">

    </script>
</body>

</html>
