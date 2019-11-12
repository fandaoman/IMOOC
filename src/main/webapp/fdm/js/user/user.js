$(function() {
    $("#btn").click(function (){
        //获取用户名和密码
        var username =$("#name").val();
        var password =$("#pass").val();
        alert("000000");
        alert("username  :"+username);

        alert("password  ："+password);
        /*if(username.trim().length<=0 || password.trim().length<=0){
            //alert("用户名或密码不能为空");

            //$("#notice").text("用户名或密码不能为空");
           layer.alert("用户名或密码不能为空",{icon: 5}) ;
        }else{*/
        $.ajax({
            url: "/user/login",
            datatype: "json",
            async: true, //请求是否异步，默认为异步
            data: {"username":username,"password":password},
            type: "post",
            success:function(data){
                if(data){
                    alert("7777");
                    location.href="../error.jsp";
                }else{
                    alert("9999");
                    layer.alert(data.message,{icon: 5});
                    location.href="../index.jsp";
                }
            }
        })
    });
});
