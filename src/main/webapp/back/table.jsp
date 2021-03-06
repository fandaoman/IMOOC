<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flat Admin - Bootstrap Themes</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="css/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <%--<script type="text/javascript" src="js/bootstrap/bootstrap-3.3.7/bootstrap.min.js"></script>--%>
    <%--<script type="text/javascript" src="js/bootstrap.min.js"></script>--%>

    <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap-3.3.7/bootstrap.js"></script>
    <script type="text/javascript" src="js/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap-table-zh-CN.js"></script>
    <!--引入bootstrap封装的方法-->
    <script type="text/javascript" src="../fdm/layer/layer.js"></script>
    <script type="text/javascript" src="js/bootStrapUtils.js"></script>
    <%--<script type="text/javascript" src="js/table.js"></script>--%>
    <script type="text/javascript">
        $(function () {
            //双色球数据展示
            $('#tableLottery').bootstrapTable({
                url: '${pageContext.request.contextPath}/lottery/findAll',         //请求后台的URL（*）
                method: 'post',
                //toolbar: '#toolbar',    //工具按钮用哪个容器
                striped: true,      //是否显示行间隔色
                cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,     //是否显示分页（*）
                sortable: false,      //是否启用排序
                sortOrder: "asc",     //排序方式
                pageNumber:1,      //初始化加载第一页，默认第一页
                pageSize: 5,      //每页的记录行数（*）
                pageList: [5, 10, 20, 50],  //可供选择的每页的行数（*）
                queryParamsType:'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort// 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
                //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
                sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
                //search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                //showColumns: true,     //是否显示所有的列
                //showRefresh: true,     //是否显示刷新按钮
                minimumCountColumns: 2,    //最少允许的列数
                clickToSelect: true,    //是否启用点击选中行
                searchOnEnterKey: true,
                columns: [
                    /*{
                        title: '序号',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var pageSize=$('#tableLottery').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
                            var pageNumber=$('#tableLottery').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
                           /!* console.log("--pageSize--"+pageSize);
                            console.log("--pageNumber--"+pageNumber);
                            console.log("--index--"+index);*!/
                            return pageSize * (pageNumber - 1) + index + 1;//返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
                        }
                    },*/
                    {field: 'id', title: '期数'},
                    {field: 'redNumberOne', title: '红1',
                        formatter: function (value, row, index) {
                            return "<span style='color: red'>"+value+"</span>";
                        }},
                    {field: 'redNumberTwo', title: '红2',
                        formatter: function (value, row, index) {
                            return "<span style='color: red'>"+value+"</span>";
                        }},
                    {field: 'redNumberThree', title: '红3',
                        formatter: function (value, row, index) {
                            return "<span style='color: red'>"+value+"</span>";
                        }},
                    {field: 'redNumberThour', title: '红4',
                        formatter: function (value, row, index) {
                            return "<span style='color: red'>"+value+"</span>";
                        }},
                    {field: 'redNumberFive', title: '红5',
                        formatter: function (value, row, index) {
                            return "<span style='color: red'>"+value+"</span>";
                        }},
                    {field: 'redNumberSix', title: '红6',
                        formatter: function (value, row, index) {
                            return "<span style='color: red'>"+value+"</span>";
                        }},
                    {field: 'blueOne', title: '蓝1',
                        formatter: function (value, row, index) {
                            return "<span style='color: blue'>"+value+"</span>";
                        }}
                ]
            });

            //批量上传
            $("#exportLottery").click(function () {
                layer.open({
                    type: 1,
                    title: ["请选择Excel",'font-size:16px'],
                    area: ['600px','150px'],
                    btn:['确定','取消'],
                    content:  $("#EDITUSER"),//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                    yes:function(){
                        //定义一个字符串数组，存放参数返回后台
                        var formData = new FormData();
                        formData.append('file', document.getElementById('excelLottery').files[0]);
                        $.ajax({
                            url: "${pageContext.request.contextPath}/lottery/insertExcel",
                            datatype: "text",
                            type:"post",
                            contentType: false, // 不使用默认请求头类型 application/x-www-form-urlencoded; charset=UTF-8
                            processData: false, // 不序列化
                            data: formData,
                            success:function (data) {
                                console.log("成功");
                            }
                        });
                    },
                    no:function(){
                        //点击取消时，关闭layer弹出框
                        layer.closeAll();
                    }
                });
            });

            /*根据所选的近几期预测*/
            $("#forcastLottery").click(function () {
                /*获取选择的最近几期*/
                var num=$("#num").val();
                var reg = /^[1-9]\d*$/;
                var flag=reg.test(num);
                if(flag || num==null || num.length<=0){
                    $.ajax({
                        url: "${pageContext.request.contextPath}/lottery/forcast",
                        type:"post",
                        dataType:"json",
                        data: {"num":num},
                        success:function (data) {
                            console.log("成功"+data);
                        }
                });
                }else{
                    layer.tips("请输入正整数或空值",$("#num"),{tips:[2, '#ff9800']});
                }
            });

            $("#insertOne").click(function () {
                layer.open({
                    type: 1,
                    title: ["请输入本期中奖号码",'font-size:16px'],
                    area: ['600px','150px'],
                    btn:['确定','取消'],
                    content:  $("#insertLottery"),//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                    yes:function(){
                        /*获取球的数值*/
                        var id=$("#ballId").val();
                        var red1=$("#red1").val();var red2=$("#red2").val();var red3=$("#red3").val();
                        var red4=$("#red4").val();var red5=$("#red5").val();var red6=$("#red6").val();
                        var blue=$("#blue1").val();
                        if(id.trim()===""){
                            layer.tips("请输入本期期数",$("#ballId"),{tips:[3, '#ff9800']});
                        }else if(red1.trim()===""){
                            layer.tips("请输入第一个红球的号码",$("#red1"),{tips:[3, '#ff9800']});
                        }else if(red2.trim()===""){
                            layer.tips("请输入第二个红球的号码",$("#red2"),{tips:[3, '#ff9800']});
                        }else if(red3.trim()===""){
                            layer.tips("请输入第三个红球的号码",$("#red3"),{tips:[3, '#ff9800']});
                        }else if(red4.trim()===""){
                            layer.tips("请输入第四个红球的号码",$("#red4"),{tips:[3, '#ff9800']});
                        }else if(red5.trim()===""){
                            layer.tips("请输入第五个红球的号码",$("#red5"),{tips:[3, '#ff9800']});
                        }else if(red6.trim()===""){
                            layer.tips("请输入第二个红球的号码",$("#red6"),{tips:[3, '#ff9800']});
                        }else if(blue.trim()===""){
                            layer.tips("请输入蓝球的号码",$("#blue1"),{tips:[3, '#ff9800']});
                        }else{
                            alert("开始导入"+red1)
                            var formData = new FormData();
                            var param={
                                "ballId":id,
                                "red1":red1,"red2":red2,"red3":red3,
                                "red4":red4,"red5":red5,"red6":red6,
                                "blue":blue,
                            };
                            formData.append("param",param);
                            $.ajax({
                                url: "${pageContext.request.contextPath}/lottery/insertone",
                                type:"post",
                                dataType:"json",
                                data: formData,
                                success:function (data) {
                                    console.log("成功"+data);
                                }
                            });
                        }

                    },
                    no:function(){
                        //点击取消时，关闭layer弹出框
                        $("#red1").text("");$("#red2").text("");$("#red3").text("");
                        $("#red4").val("");$("#red5").val("");$("#red6").val("");
                        $("#blue1").val("");
                        layer.closeAll();
                    }
                });
            });
        })

    </script>
</head>

<body class="flat-blue sidebar-collapse">
    <div class="sidebar">
        <div class="menu-control toggle-sidebar">
            <a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i> Flat Admin</a>
            <i class="fa fa-bars navicon"></i>
        </div>
        <ul class="menu">
            <li class="submenu">
                <a href="index.jsp">
                    <div>
                        <i class="menu-icon fa fa-th-large"></i>
                        <span class="menu-title">Dashboard</span>
                    </div>
                </a>
            </li>
            <li class="submenu">
                <a href="element.html">
                    <div>
                        <i class="menu-icon fa fa-desktop"></i>
                        <span class="menu-title">UI Elements</span>
                    </div>
                </a>
            </li>
            <li class="submenu">
                <a href="table.jsp" class="active">
                    <div>
                        <i class="menu-icon fa fa-table"></i>
                        <span class="menu-title">Table</span>
                    </div>
                </a>
            </li>
            <li class="submenu">
                <a href="form.jsp">
                    <div>
                        <i class="menu-icon fa fa-file-text-o"></i>
                        <span class="menu-title">Form</span>
                    </div>
                </a>
            </li>

            <li class="submenu dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                    <div>
                        <i class="menu-icon fa fa-slack"></i>
                        <span class="menu-title">Page Example</span>
                    </div>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="login.jsp">
                            <div>
                                <i class="menu-icon fa fa-sign-in"></i>
                                <span class="menu-sub-title">Login</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="register.jsp">
                            <div>
                                <i class="menu-icon fa fa-pencil-square-o"></i>
                                <span class="menu-sub-title">Register</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="submenu dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                    <div>
                        <i class="menu-icon fa fa-magic"></i>
                        <span class="menu-title">Custom Elements</span>
                    </div>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="custom-dashboard.html">
                            <div>
                                <i class="menu-icon fa fa-bar-chart"></i>
                                <span class="menu-sub-title">Dashboard</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="content-container">
        <nav class="navbar navbar-default">
            <div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"><i class="fa fa-bar-chart"></i> Flat Admin</a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa fa-comments"></i> 0</a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-title-bar">
                                    Notification ( 0 )
                                </li>
                                <li class="message">
                                    No new notification
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown notification-alert">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-exclamation-circle"></i> 3</a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-title-bar">
                                    Notification ( 3 )
                                </li>
                                <li>
                                    <ul class="notification-list">
                                        <li>
                                            <a href="#">
                                                <div class="noti-icon noti-alert">
                                                    <i class="fa fa-exclamation-circle fa-2x"></i>
                                                </div>
                                                <div class="noti-message">1 new registration</div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="noti-icon noti-success">
                                                    <i class="fa fa-check fa-2x"></i>
                                                </div>
                                                <div class="noti-message">3 new orders</div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="noti-icon noti-primary">
                                                    <i class="fa fa-comments fa-2x"></i>
                                                </div>
                                                <div class="noti-message">2 customers messages</div>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Emily Hart <span class="caret"></span></a>
                            <ul class="dropdown-menu user-info">
                                <li class="dropdown-title-bar">
                                    <img src="images/profile.jpg" class="profile-img">
                                </li>
                                <li>
                                    <div class="navbar-login">
                                        <h4 class="user-name">Emily Hart</h4>
                                        <p>emily_hart@email.com</p>
                                        <div class="btn-group margin-bottom-2x" role="group">
                                            <button type="button" class="btn btn-default"><i class="fa fa-user"></i> Profile</button>
                                            <button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> Logout</button>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title red"><h3>Table</h3></span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>General Table</h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="content-block">
                        <div class="block-title" style="width: 25%">双色球</div>
                        <div class="block-title"  style="width: 75%;float: right;margin-top: -49px;cursor: pointer">
                            <button id="insertOne" style="margin-left: 115px;" >导入</button>
                            <input id="num" style="width: 90px;" />
                            <button id="forcastLottery" style="margin-left: -6px;">预测本期号码</button>
                            <button id="exportLottery" style="float: right;">批量导入</button>
                        </div>

                        <div class="block-content">

                            <div class="block-title" style="width: 100%;">
                                预测结果展示区
                            </div>


                        </div>
                        <div class="block-content">
                            <table class="table table-hover" id="tableLottery">
                            </table>
                        </div>
                    </div>
                    <div class="content details-div" id="EDITUSER" style="display: none;position: absolute;">
                        <div style="width: 100%;height: 100%;float: left;">
                            <div id="drop_area">
                                <input type="file" id="excelLottery" >
                            </div>
                        </div>
                    </div>

                    <div class="content details-div" id="insertLottery" style="display: none;position: absolute;">
                        <div style="width: 100%;height: 100%;float: left;">
                            <div style="margin-top: 25px;">
                                <input type="text" style="width: 60px;" id="ballId">
                                <input type="text" style="width: 60px;" id="red1">
                                <input type="text" style="width: 60px;" id="red2">
                                <input type="text" style="width: 60px;" id="red3">
                                <input type="text" style="width: 60px;" id="red4">
                                <input type="text" style="width: 60px;" id="red5">
                                <input type="text" style="width: 60px;" id="red6">
                                <input type="text" style="width: 60px;" id="blue1">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">体彩</div>
                        <div class="block-content">
                            <table class="table table-hover table-bordered">
                                <h3>体彩 模块待开发</h3>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">快三</div>
                        <div class="block-content">
                            <table class="table table-hover table-striped">
                                <h3>快三 模块待开发</h3>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">大乐透</div>
                        <div class="block-content">
                            <table class="table table-hover table-bordered table-striped">
                                <h3>大乐透 模块待开发</h3>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>Table with Pagination</h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Table</div>
                        <div class="block-content">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Username</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td>@fat</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                </tbody>
                            </table>
                            <nav class="table-pagination">
                                <ul class="pagination">
                                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a>
                                    </li>
                                    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li><a href="#">2</a>
                                    </li>
                                    <li><a href="#">3</a>
                                    </li>
                                    <li><a href="#">4</a>
                                    </li>
                                    <li><a href="#">5</a>
                                    </li>
                                    <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <span class="page-title"><h4>Datatable</h4></span>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="content-block">
                        <div class="block-title">Datatable</div>
                        <div class="block-content">
                            <table id="example" class="table table-striped" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Position</th>
                                        <th>Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>Salary</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Tiger Nixon</td>
                                        <td>System Architect</td>
                                        <td>Edinburgh</td>
                                        <td>61</td>
                                        <td>2011/04/25</td>
                                        <td>$320,800</td>
                                    </tr>
                                    <tr>
                                        <td>Garrett Winters</td>
                                        <td>Accountant</td>
                                        <td>Tokyo</td>
                                        <td>63</td>
                                        <td>2011/07/25</td>
                                        <td>$170,750</td>
                                    </tr>
                                    <tr>
                                        <td>Ashton Cox</td>
                                        <td>Junior Technical Author</td>
                                        <td>San Francisco</td>
                                        <td>66</td>
                                        <td>2009/01/12</td>
                                        <td>$86,000</td>
                                    </tr>
                                    <tr>
                                        <td>Cedric Kelly</td>
                                        <td>Senior Javascript Developer</td>
                                        <td>Edinburgh</td>
                                        <td>22</td>
                                        <td>2012/03/29</td>
                                        <td>$433,060</td>
                                    </tr>
                                    <tr>
                                        <td>Airi Satou</td>
                                        <td>Accountant</td>
                                        <td>Tokyo</td>
                                        <td>33</td>
                                        <td>2008/11/28</td>
                                        <td>$162,700</td>
                                    </tr>
                                    <tr>
                                        <td>Brielle Williamson</td>
                                        <td>Integration Specialist</td>
                                        <td>New York</td>
                                        <td>61</td>
                                        <td>2012/12/02</td>
                                        <td>$372,000</td>
                                    </tr>
                                    <tr>
                                        <td>Herrod Chandler</td>
                                        <td>Sales Assistant</td>
                                        <td>San Francisco</td>
                                        <td>59</td>
                                        <td>2012/08/06</td>
                                        <td>$137,500</td>
                                    </tr>
                                    <tr>
                                        <td>Rhona Davidson</td>
                                        <td>Integration Specialist</td>
                                        <td>Tokyo</td>
                                        <td>55</td>
                                        <td>2010/10/14</td>
                                        <td>$327,900</td>
                                    </tr>
                                    <tr>
                                        <td>Colleen Hurst</td>
                                        <td>Javascript Developer</td>
                                        <td>San Francisco</td>
                                        <td>39</td>
                                        <td>2009/09/15</td>
                                        <td>$205,500</td>
                                    </tr>
                                    <tr>
                                        <td>Sonya Frost</td>
                                        <td>Software Engineer</td>
                                        <td>Edinburgh</td>
                                        <td>23</td>
                                        <td>2008/12/13</td>
                                        <td>$103,600</td>
                                    </tr>
                                    <tr>
                                        <td>Jena Gaines</td>
                                        <td>Office Manager</td>
                                        <td>London</td>
                                        <td>30</td>
                                        <td>2008/12/19</td>
                                        <td>$90,560</td>
                                    </tr>
                                    <tr>
                                        <td>Quinn Flynn</td>
                                        <td>Support Lead</td>
                                        <td>Edinburgh</td>
                                        <td>22</td>
                                        <td>2013/03/03</td>
                                        <td>$342,000</td>
                                    </tr>
                                    <tr>
                                        <td>Charde Marshall</td>
                                        <td>Regional Director</td>
                                        <td>San Francisco</td>
                                        <td>36</td>
                                        <td>2008/10/16</td>
                                        <td>$470,600</td>
                                    </tr>
                                    <tr>
                                        <td>Haley Kennedy</td>
                                        <td>Senior Marketing Designer</td>
                                        <td>London</td>
                                        <td>43</td>
                                        <td>2012/12/18</td>
                                        <td>$313,500</td>
                                    </tr>
                                    <tr>
                                        <td>Tatyana Fitzpatrick</td>
                                        <td>Regional Director</td>
                                        <td>London</td>
                                        <td>19</td>
                                        <td>2010/03/17</td>
                                        <td>$385,750</td>
                                    </tr>
                                    <tr>
                                        <td>Michael Silva</td>
                                        <td>Marketing Designer</td>
                                        <td>London</td>
                                        <td>66</td>
                                        <td>2012/11/27</td>
                                        <td>$198,500</td>
                                    </tr>
                                    <tr>
                                        <td>Paul Byrd</td>
                                        <td>Chief Financial Officer (CFO)</td>
                                        <td>New York</td>
                                        <td>64</td>
                                        <td>2010/06/09</td>
                                        <td>$725,000</td>
                                    </tr>
                                    <tr>
                                        <td>Gloria Little</td>
                                        <td>Systems Administrator</td>
                                        <td>New York</td>
                                        <td>59</td>
                                        <td>2009/04/10</td>
                                        <td>$237,500</td>
                                    </tr>
                                    <tr>
                                        <td>Bradley Greer</td>
                                        <td>Software Engineer</td>
                                        <td>London</td>
                                        <td>41</td>
                                        <td>2012/10/13</td>
                                        <td>$132,000</td>
                                    </tr>
                                    <tr>
                                        <td>Dai Rios</td>
                                        <td>Personnel Lead</td>
                                        <td>Edinburgh</td>
                                        <td>35</td>
                                        <td>2012/09/26</td>
                                        <td>$217,500</td>
                                    </tr>
                                    <tr>
                                        <td>Jenette Caldwell</td>
                                        <td>Development Lead</td>
                                        <td>New York</td>
                                        <td>30</td>
                                        <td>2011/09/03</td>
                                        <td>$345,000</td>
                                    </tr>
                                    <tr>
                                        <td>Yuri Berry</td>
                                        <td>Chief Marketing Officer (CMO)</td>
                                        <td>New York</td>
                                        <td>40</td>
                                        <td>2009/06/25</td>
                                        <td>$675,000</td>
                                    </tr>
                                    <tr>
                                        <td>Caesar Vance</td>
                                        <td>Pre-Sales Support</td>
                                        <td>New York</td>
                                        <td>21</td>
                                        <td>2011/12/12</td>
                                        <td>$106,450</td>
                                    </tr>
                                    <tr>
                                        <td>Doris Wilder</td>
                                        <td>Sales Assistant</td>
                                        <td>Sidney</td>
                                        <td>23</td>
                                        <td>2010/09/20</td>
                                        <td>$85,600</td>
                                    </tr>
                                    <tr>
                                        <td>Angelica Ramos</td>
                                        <td>Chief Executive Officer (CEO)</td>
                                        <td>London</td>
                                        <td>47</td>
                                        <td>2009/10/09</td>
                                        <td>$1,200,000</td>
                                    </tr>
                                    <tr>
                                        <td>Gavin Joyce</td>
                                        <td>Developer</td>
                                        <td>Edinburgh</td>
                                        <td>42</td>
                                        <td>2010/12/22</td>
                                        <td>$92,575</td>
                                    </tr>
                                    <tr>
                                        <td>Jennifer Chang</td>
                                        <td>Regional Director</td>
                                        <td>Singapore</td>
                                        <td>28</td>
                                        <td>2010/11/14</td>
                                        <td>$357,650</td>
                                    </tr>
                                    <tr>
                                        <td>Brenden Wagner</td>
                                        <td>Software Engineer</td>
                                        <td>San Francisco</td>
                                        <td>28</td>
                                        <td>2011/06/07</td>
                                        <td>$206,850</td>
                                    </tr>
                                    <tr>
                                        <td>Fiona Green</td>
                                        <td>Chief Operating Officer (COO)</td>
                                        <td>San Francisco</td>
                                        <td>48</td>
                                        <td>2010/03/11</td>
                                        <td>$850,000</td>
                                    </tr>
                                    <tr>
                                        <td>Shou Itou</td>
                                        <td>Regional Marketing</td>
                                        <td>Tokyo</td>
                                        <td>20</td>
                                        <td>2011/08/14</td>
                                        <td>$163,000</td>
                                    </tr>
                                    <tr>
                                        <td>Michelle House</td>
                                        <td>Integration Specialist</td>
                                        <td>Sidney</td>
                                        <td>37</td>
                                        <td>2011/06/02</td>
                                        <td>$95,400</td>
                                    </tr>
                                    <tr>
                                        <td>Suki Burks</td>
                                        <td>Developer</td>
                                        <td>London</td>
                                        <td>53</td>
                                        <td>2009/10/22</td>
                                        <td>$114,500</td>
                                    </tr>
                                    <tr>
                                        <td>Prescott Bartlett</td>
                                        <td>Technical Author</td>
                                        <td>London</td>
                                        <td>27</td>
                                        <td>2011/05/07</td>
                                        <td>$145,000</td>
                                    </tr>
                                    <tr>
                                        <td>Gavin Cortez</td>
                                        <td>Team Leader</td>
                                        <td>San Francisco</td>
                                        <td>22</td>
                                        <td>2008/10/26</td>
                                        <td>$235,500</td>
                                    </tr>
                                    <tr>
                                        <td>Martena Mccray</td>
                                        <td>Post-Sales support</td>
                                        <td>Edinburgh</td>
                                        <td>46</td>
                                        <td>2011/03/09</td>
                                        <td>$324,050</td>
                                    </tr>
                                    <tr>
                                        <td>Unity Butler</td>
                                        <td>Marketing Designer</td>
                                        <td>San Francisco</td>
                                        <td>47</td>
                                        <td>2009/12/09</td>
                                        <td>$85,675</td>
                                    </tr>
                                    <tr>
                                        <td>Howard Hatfield</td>
                                        <td>Office Manager</td>
                                        <td>San Francisco</td>
                                        <td>51</td>
                                        <td>2008/12/16</td>
                                        <td>$164,500</td>
                                    </tr>
                                    <tr>
                                        <td>Hope Fuentes</td>
                                        <td>Secretary</td>
                                        <td>San Francisco</td>
                                        <td>41</td>
                                        <td>2010/02/12</td>
                                        <td>$109,850</td>
                                    </tr>
                                    <tr>
                                        <td>Vivian Harrell</td>
                                        <td>Financial Controller</td>
                                        <td>San Francisco</td>
                                        <td>62</td>
                                        <td>2009/02/14</td>
                                        <td>$452,500</td>
                                    </tr>
                                    <tr>
                                        <td>Timothy Mooney</td>
                                        <td>Office Manager</td>
                                        <td>London</td>
                                        <td>37</td>
                                        <td>2008/12/11</td>
                                        <td>$136,200</td>
                                    </tr>
                                    <tr>
                                        <td>Jackson Bradshaw</td>
                                        <td>Director</td>
                                        <td>New York</td>
                                        <td>65</td>
                                        <td>2008/09/26</td>
                                        <td>$645,750</td>
                                    </tr>
                                    <tr>
                                        <td>Olivia Liang</td>
                                        <td>Support Engineer</td>
                                        <td>Singapore</td>
                                        <td>64</td>
                                        <td>2011/02/03</td>
                                        <td>$234,500</td>
                                    </tr>
                                    <tr>
                                        <td>Bruno Nash</td>
                                        <td>Software Engineer</td>
                                        <td>London</td>
                                        <td>38</td>
                                        <td>2011/05/03</td>
                                        <td>$163,500</td>
                                    </tr>
                                    <tr>
                                        <td>Sakura Yamamoto</td>
                                        <td>Support Engineer</td>
                                        <td>Tokyo</td>
                                        <td>37</td>
                                        <td>2009/08/19</td>
                                        <td>$139,575</td>
                                    </tr>
                                    <tr>
                                        <td>Thor Walton</td>
                                        <td>Developer</td>
                                        <td>New York</td>
                                        <td>61</td>
                                        <td>2013/08/11</td>
                                        <td>$98,540</td>
                                    </tr>
                                    <tr>
                                        <td>Finn Camacho</td>
                                        <td>Support Engineer</td>
                                        <td>San Francisco</td>
                                        <td>47</td>
                                        <td>2009/07/07</td>
                                        <td>$87,500</td>
                                    </tr>
                                    <tr>
                                        <td>Serge Baldwin</td>
                                        <td>Data Coordinator</td>
                                        <td>Singapore</td>
                                        <td>64</td>
                                        <td>2012/04/09</td>
                                        <td>$138,575</td>
                                    </tr>
                                    <tr>
                                        <td>Zenaida Frank</td>
                                        <td>Software Engineer</td>
                                        <td>New York</td>
                                        <td>63</td>
                                        <td>2010/01/04</td>
                                        <td>$125,250</td>
                                    </tr>
                                    <tr>
                                        <td>Zorita Serrano</td>
                                        <td>Software Engineer</td>
                                        <td>San Francisco</td>
                                        <td>56</td>
                                        <td>2012/06/01</td>
                                        <td>$115,000</td>
                                    </tr>
                                    <tr>
                                        <td>Jennifer Acosta</td>
                                        <td>Junior Javascript Developer</td>
                                        <td>Edinburgh</td>
                                        <td>43</td>
                                        <td>2013/02/01</td>
                                        <td>$75,650</td>
                                    </tr>
                                    <tr>
                                        <td>Cara Stevens</td>
                                        <td>Sales Assistant</td>
                                        <td>New York</td>
                                        <td>46</td>
                                        <td>2011/12/06</td>
                                        <td>$145,600</td>
                                    </tr>
                                    <tr>
                                        <td>Hermione Butler</td>
                                        <td>Regional Director</td>
                                        <td>London</td>
                                        <td>47</td>
                                        <td>2011/03/21</td>
                                        <td>$356,250</td>
                                    </tr>
                                    <tr>
                                        <td>Lael Greer</td>
                                        <td>Systems Administrator</td>
                                        <td>London</td>
                                        <td>21</td>
                                        <td>2009/02/27</td>
                                        <td>$103,500</td>
                                    </tr>
                                    <tr>
                                        <td>Jonas Alexander</td>
                                        <td>Developer</td>
                                        <td>San Francisco</td>
                                        <td>30</td>
                                        <td>2010/07/14</td>
                                        <td>$86,500</td>
                                    </tr>
                                    <tr>
                                        <td>Shad Decker</td>
                                        <td>Regional Director</td>
                                        <td>Edinburgh</td>
                                        <td>51</td>
                                        <td>2008/11/13</td>
                                        <td>$183,000</td>
                                    </tr>
                                    <tr>
                                        <td>Michael Bruce</td>
                                        <td>Javascript Developer</td>
                                        <td>Singapore</td>
                                        <td>29</td>
                                        <td>2011/06/27</td>
                                        <td>$183,000</td>
                                    </tr>
                                    <tr>
                                        <td>Donna Snider</td>
                                        <td>Customer Support</td>
                                        <td>New York</td>
                                        <td>27</td>
                                        <td>2011/01/25</td>
                                        <td>$112,000</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer">
            <span><i class="fa fa-copyright"></i> Tui2Tone Labs, 2015 / More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></span>
    </footer>
    <script type="text/javascript">
    $(function() {
        $('#example').DataTable();
    });
    </script>
</body>

</html>
