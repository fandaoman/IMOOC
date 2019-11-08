$(function() {
    $("#btn").click(function (){
        alert("1111111111");
        //获取用户名和密码
        var username =$("#name").val();
        var password =$("#pass").val();
        console.log("username"+username);
        $.ajax({
            url: "${pageContext.request.contextPath}/user/login",
            datatype: "json",
            async: true, //请求是否异步，默认为异步
            data: {"username":username,"password":password},
            type: "post",
            success:function(data){
                if(data){
                    location.href="${pageContext.request.contextPath}/index.jsp";
                }else{
                    location.href="${pageContext.request.contextPath}/error.jsp";
                }
            }
        })
    });
});