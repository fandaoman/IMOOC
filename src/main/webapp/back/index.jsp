<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>十里承欢</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Free Flat Admin Bootstrap Themes">
    <meta name="author" content="Charuwit Nodthaisong">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="css/awesome-bootstrap-checkbox.css">
    <link rel="stylesheet" type="text/css" href="css/select2.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/theme.css">

    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/Chart.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="../fdm/layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#edit").click(function (){
                layer.open({
                    type: 1,
                    title: ["编辑信息",'font-size:16px'],
                    area: ['1018px','500px'],
                    /*offset: '10px',*/
                    content:  $("#EDITUSER")//捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                });
            });
        });



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
                <a href="index.jsp" class="active">
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
                <a href="table.html">
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
    <div class="tlinks">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
    <div class="content-container wrap">
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
                        <%--用户信息展示模块--%>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Emily Hart  ${user.realname}<span class="caret"></span></a>
                            <ul class="dropdown-menu user-info">
                                <li class="dropdown-title-bar">
                                    <img src="images/profile.jpg" class="profile-img">
                                </li>
                                <li>
                                    <div class="navbar-login">
                                        <h4 class="user-name" id="realname">Emily Hart</h4>
                                        <p>emily_hart@email.com</p>
                                        <div class="btn-group margin-bottom-2x" role="group">
                                            <button type="button" class="btn btn-default" id="edit"><i class="fa fa-user" ></i> Profile</button>
                                            <button type="button" class="btn btn-default" id="logout"><i class="fa fa-sign-out"></i> Logout</button>
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
                    <span class="page-title red"><h2>Dashboard</h2></span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">

                    <ol class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li class="active">Dashboard</a>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block red">
                            <div class="block-content">
                                <span class="banner-icon fa-stack fa-3x">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-inbox fa-stack-1x fa-inverse"></i>
                                </span>
                                <div class="banner-content">
                                    <div class="title">50</div>
                                    <div class="sub-title">视频总数</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>

                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block yellow">
                            <div class="block-content">
                                <span class="fa-stack fa-3x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-comments fa-stack-1x fa-inverse"></i>
                            </span>
                                <div class="banner-content">
                                    <div class="title">23</div>
                                    <div class="sub-title">留言</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block green">
                            <div class="block-content">
                                <span class="fa-stack fa-3x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-tags fa-stack-1x fa-inverse"></i>
                            </span>
                                <div class="banner-content">
                                    <div class="title">280</div>
                                    <div class="sub-title">访问人数</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>

                        </div>
                    </a>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                    <a href="#">
                        <div class="banner-block blue">
                            <div class="block-content">
                                <span class="fa-stack fa-3x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-share-alt fa-stack-1x fa-inverse"></i>
                            </span>
                                <div class="banner-content">
                                    <div class="title">16￥</div>
                                    <div class="sub-title">累计收入</div>
                                </div>
                                <div class="clear-both"></div>
                            </div>

                        </div>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="banner-block white">
                        <div class="block-content">
                            <div class="block-title">Orders</div>
                            <canvas id="dashboard-order-chart" style="padding:10px 30px 10px 10px;"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="banner-block white">
                        <div class="block-content">
                            <div class="block-title">Stats</div>
                            <div class="row">
                                <div class="col-md-9">
                                    <canvas id="dashboard-stat-chart" style="padding:10px 30px 10px 10px;"></canvas>
                                </div>

                                <div class="col-md-3">
                                    <div id="dashboard-stat-chart-legend" class="pie-legend"></div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-comments-o"></i> Last Message</h3>
                        </div>
                        <div class="panel-body no-padding">
                            <ul class="message-list">
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">12 min ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>

                                    </li>
                                </a>
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">15 min ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>
                                    </li>
                                </a>
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">2 hour ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>
                                    </li>
                                </a>
                                <a href="#">
                                    <li>
                                        <img src="images/profile.jpg" class="profile-img pull-left">
                                        <div class="message-block">
                                            <div><span class="username">Tui2Tone</span> <span class="message-datetime">1 day ago</span>
                                            </div>
                                            <div class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.</div>
                                        </div>
                                    </li>
                                </a>
                                <a href="#" id="message-load-more">
                                    <li class="text-center load-more">
                                        <i class="fa fa-refresh"></i> load more..
                                    </li>
                                </a>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-users"></i> New Users</h3>
                        </div>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                <tr>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="footer">
            <span><i class="fa fa-copyright"></i> Tui2Tone Labs, 2015 / More Templates <a href="http://www.91.com/" target="_blank" title="91之家">91之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></span>
    </footer>

    <div class="content details-div" id="EDITUSER" style="display: none;position: absolute;">
        <div class="container-fluid" >
            <table class="table-data details-tables" style="width: 1350px;margin-left: -15px;" id="detailsMsg">
                <tr>
                    <td>22222</td>
                    <td>22222</td>
                    <td>22222</td>
                </tr>
                <tr>
                    <td>22222</td>
                    <td>22222</td>
                    <td>22222</td>
                </tr>
                <tr>
                    <td>22222</td>
                    <td>22222</td>
                    <td>22222</td>
                </tr>
                <tr>
                    <td>22222</td>
                    <td>22222</td>
                    <td>22222</td>
                </tr>
                <tr>
                    <td>22222</td>
                    <td>22222</td>
                    <td>22222</td>
                </tr>
            </table>
        </div>
    </div>
</body>



</html>
