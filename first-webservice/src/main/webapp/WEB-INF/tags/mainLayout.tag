<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="caterpillar" tagdir="/WEB-INF/tags" %>
<%@tag pageEncoding="UTF-8" %>
<%@tag trimDirectiveWhitespaces="true" %>
<%@tag body-content="scriptless" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<c:set var="rootpath" value="${ pageContext.request.contextPath}" scope="request"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>家庭医生后台</title>
    <meta content="" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="Preview page of Metronic Admin Theme #2 for echart demos" name="description"/>
    <link href="${pageContext.request.contextPath}/assets/pages/css/profile.min.css" rel="stylesheet"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
    <!--图片上传-->
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css"
          rel="stylesheet"/>
    <!--sweetalert-->
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-sweetalert/sweetalert.css"
          rel="stylesheet"/>
    <!--时间选择-->
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css"
          rel="stylesheet" type="text/css"/>
    <!--富文本编辑器-->
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-summernote/summernote.css"
          rel="stylesheet" type="text/css"/>
    <!--日历（和echarts有冲突）-->
    <link href="${pageContext.request.contextPath}/assets/global/plugins/fullcalendar/fullcalendar.min.css"
          rel="stylesheet" type="text/css"/>
    <!--博客样式-->
    <link href="${pageContext.request.contextPath}/assets/pages/css/blog.min.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <style>
        .profile-sidebar {
            width: 100%;
        }

        .float-left {
            float: left;
        }

        .float-right {
            float: right;
        }

        .margin-none {
            margin: 0;
        }

        .margin-top-6 {
            margin-top: 6px;
        }

        .profile-userpic img {
            width: 30%;
        }

        .portlet > .portlet-title > .nav-tabs > li > a {
            color: #9f9f9f;
        }

        /* tab panel 不显示Echarts 图表问题 */
        /* bootstrap hack: fix content width inside hidden tabs */
        .tab-content > .tab-pane,
        .pill-content > .pill-pane {
            display: block; /* undo display:none */
            height: 0; /* height:0 is also invisible */
            overflow-y: hidden; /* no-overflow */
        }

        .tab-content > .active,
        .pill-content > .active {
            height: auto; /* let the content decide it */
        }

        .table-state ul li:nth-child(1) {
            background-color: #ed9e2d;
        }

        .table-state ul li:nth-child(2) {
            background-color: #5cb85c;
        }

        .table-state ul li {
            display: inline-block;
            width: 20%;
            text-align: center;
            color: white;
        }

        .table-state ul {
            margin-bottom: 0;
        }

        .mt {
            margin-bottom: 20px;
        }

        .mt-img {
            margin: 20px 0 10px !important;
        }

        .mt-img img {
            max-width: 50px;
        }

        .mt-stats p {
            margin: 0;
        }

        .mt-widget-1 .mt-body .mt-stats {
            margin: 15px 0 0 !important;
        }

        .mt-widget-1 {
            background-color: white;
        }

        .toolbar {
            margin-top: 9px;
        }

        .mt-sweetalert {
            margin: 0;
        }

        .portlet {
            margin-bottom: 5px;
        }

        .dashboard-stat-v2-new {
            margin-top: 15px;
            display: block !important;
            text-decoration: none !important;
        }

        .dashboard-stat-v2-new .card-icon img {
            width: 80px;
        }

        .dashboard-stat-v2-new .card-title {
            margin-top: 15px;
            text-decoration: none;
            margin-bottom: 5px;
        }

        .dashboard-stat-v2-new .card-title span {
            color: white;
        }

        .dashboard-stat-v2-new .card-desc p {
            margin: 0;
            color: white;
        }

        .dashboard-stat-v2-new .card-desc {
            margin: 0;
            text-decoration: none;
        }

        .page-quick-sidebar-wrapper-new {
            width: 500px;
            right: -500px;
        }

        .page-quick-sidebar-wrapper-new .tab-pane {
            min-width: 500px;
        }

        .page-quick-sidebar-open .page-quick-sidebar-toggler > i:before {
            content: "\e082";
        }

        .page-quick-sidebar-title {
            padding: 30px 30px 30px 15px;
        }

        .page-quick-sidebar-title .portlet.light {
            background-color: inherit;
        }

        .page-quick-sidebar-title .portlet.light img {
            width: 100px;
        }

        .page-quick-sidebar-title .form-group {
            margin-bottom: 0;
        }

        .xunList {
            padding: 15px;
            border-radius: 8px !important;
            background-color: white;
            margin: 15px 20px 20px 20px;
            height: calc(100% - 65px) !important;
        }

        .xunList .panel {
            background-color: inherit;
            border: 0;
            border-bottom: 0.5px solid rgb(235, 235, 235);
            color: black;
        }

        .xunList .panel-danger {
            border-left: 5px solid rgb(237, 107, 117);
        }

        .xunList .panel-primary {
            border-left: 5px solid rgb(51, 122, 183);
        }

        .xunList .panel-group {
            margin-bottom: 0;
        }

        .xunList .panel-heading {
            background-color: inherit !important;
        }

        .xunList .accordion .panel .panel-title .accordion-toggle {
            padding: 10px !important;
        }

        .xunList .panel-title {
            font-weight: 500;
            color: black !important;
        }

        .xunList .panel-body p {
            margin: 5px 0 !important;
            font-size: 12px;
            color: #6a6a6a;
        }

        .xunList .panel-body h6 {
            font-size: 14px;
            font-weight: 500;
        }

        .xunList .s, .xunList .o, .xunList .a, .xunList .p {
            border-bottom: 0;
            padding: 3px 6px;
            margin-bottom: 0;
            margin-left: -7px;
            color: #fff;
        }

        .xunList .s {
            background-color: rgba(255, 84, 95, 0.51);
        }

        .xunList .o {
            background-color: rgba(53, 152, 220, 0.51);
        }

        .xunList .a {
            background-color: rgba(196, 159, 71, 0.51);
        }

        .xunList .p {
            background-color: rgba(142, 68, 173, 0.51);
        }

        .fdImg {
            margin-left: 21%;
        }

        .fdImg img {
            width: 50px !important;
            margin-top: 5px !important;
        }

        .fd-label {
        }

        .fd-input {
            display: none;
        }

        .fd .form-group {
            min-height: 34px;
        }

        .servicePackage .mt-card-desc b {
            color: red;
            margin-right: 15px;
        }

        .onlineConsulting .mt-head-user-img {
            margin: 62px 32px 18px 35px !important;
        }

        .onlineConsulting .mt-head-user-info {
            margin: 75px 0 0 -9px !important;
        }

        .onlineConsulting .mt-widget-2 {
            background-color: white;
        }

        .onlineConsulting .replyColor {
            background-color: #b4b4b4;
        }

        .onlineConsulting .notReplyColor {
            background-color: #259453;
        }

        .onlineConsulting .mt-head-label {
            right: 0 !important;
            width: 100%;
            text-align: left;
            line-height: 2.3em;
            color: #ffffff;
            padding: 0 8px 0 15px;
        }

        .onlineConsulting .mt-head-label button {
            float: right;
        }

        .onlineConsulting .mt-body-description {
            text-align: left;
        }

        .onlineConsulting .mt-body {
            padding: 155px 20px 0 20px;
            text-align: left;
        }

        .onlineConsulting .mt-body-description {
            padding: 0 !important;
            margin: 10px 0 20px 0;
            font-size: 16px !important;
        }

        .onlineConsulting .mt-body-img {
            display: inline-block;
            margin-right: 9px;
            margin-bottom: 15px;
            width: 70px;
            height: 70px;
            background: no-repeat center center;
            background-size: cover;
        }

        .onlineConsulting #onlineConsultingImg .modal-body {
            padding: 0;
        }

        .onlineConsulting .modalImg {
            width: 100%;
        }

        .onlineConsulting .col-md-4 {
            margin-bottom: 30px;
        }

        .onlineConsulting .mt-body-reply {
            width: 100%;
            margin-top: 0 !important;
            padding-top: 15px !important;
            color: #fa773b !important;
            border-top: 1px solid #dedede;
            margin-bottom: 5px;
        }

        .onlineConsulting .mt-body-reply-time {
            font-size: 12px;
            color: #bcbcbc;
        }

        .page-quick-sidebar-wrapper .page-quick-sidebar .nav-tabs > li > a {
            padding: 15px 15px 8px;
        }

        .page-quick-sidebar-title {
            padding: 20px;
        }

        .slimScrollDiv .col-md-12 .col-md-6 {
            padding: 0 15px;
        }

        .slimScrollDiv .col-md-12 .col-md-6:nth-child(2n) {
        }

        .slimScrollDiv .input-group {
            width: 50%;
            float: left;
        }

        .slimScrollDiv textarea {
            max-width: 100%;
        }

        .modal .slimScrollDiv h4 {
            margin: 20px 0 20px 15px !important;
        }

        .slimScrollDiv .input-group-addon {
            min-width: 76px;
        }

        .baseInfo .profile-sidebar-portlet {
            padding-top: 0 !important;
        }

        .baseInfo .portlet-title {
            padding: 10px 15px 0 15px !important;
            border: 0;
        }

        .feeds li .col2 {
            float: left;
            width: 500px;
            margin-left: -500px;
        }

        .baseInfo .profile-usermenu .tag {
            margin: 5px 0 5px 5px !important;
            display: inline-block;
        }

        .baseInfo .profile-usermenu .tagA {
            display: inline-block;
            width: 100%;
            padding: 10px 15px;
        }

        .baseInfo .profile-usermenu .tagA:hover {
            display: inline-block;
            width: 100%;
            padding: 10px 15px;
        }

        .qyxyModal .blog-single-desc p {
            margin-bottom: 0 !important;
            font-size: 14px !important;
            line-height: 1.8em !important;
        }

        .qyxyModal .blog-single-head-title {
            font-size: 18px;
            font-weight: 600;
            color: #4e5a64;
            margin: 0 0 40px;
            display: inline-block;
        }

        .qyxyModal .blog-single-img {
            width: 500px;
            float: right;
            line-height: 100px;
            text-align: right;
        }

        .qyxyModal .blog-single-head {
            text-align: center;
        }

        .qyxyModal .blog-single-head img {
            width: 50px;
            margin-right: 5px;
        }

        .qyxyModal .blog-single-img p {
            font-size: 14px;
            display: inline;
            vertical-align: middle;
            text-align: right;
        }

        .qyxyModal .blog-single-img img {
            width: 150px !important;
        }

        .signCanvas .modal-dialog {
            width: 100%;
            margin: 0;
        }

        .signCanvas .modal-body {
            padding: 0
        }

        .signCanvas canvas {
            background-color: #eeeeee;
            width: 100%;
            height: 50%
        }

        .signCanvas {
        }

        .signCanvas {
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/common.js"></script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid">
<div class="page-header navbar navbar-fixed-top">
    <div class="page-header-inner ">
        <div class="page-logo">
            <a href="${pageContext.request.contextPath}/user/login">
                <img src="${pageContext.request.contextPath}/images/logo.png" alt="logo" class="logo-default"/>
            </a>
            <div class="menu-toggler sidebar-toggler">
            </div>
        </div>
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
           data-target=".navbar-collapse">
        </a>
        <div class="page-top">
            <div class="top-menu">
                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown dropdown-user">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                           data-close-others="true" aria-expanded="false">
                            <img alt="" class="img-circle" src="${pageContext.request.contextPath}/images/医生.png">
                            <span class="username username-hide-on-mobile">@currentLoginUser.LoginName</span>
                            <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-default">
                            <li>
                                <a href="${pageContext.request.contextPath}/user/login">
                                    <i class="icon-key"></i> 退出登录
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<div class="page-container">
    <div class="page-sidebar-wrapper">
        <div class="page-sidebar navbar-collapse collapse">
            <ul class="page-sidebar-menu  page-header-fixed page-sidebar-menu-hover-submenu " data-keep-expanded="false"
                data-auto-scroll="true" data-slide-speed="200">
                <li class="nav-item" id="doctornav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-user"></i>
                        <span class="title">医生</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="patientnav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-users"></i>
                        <span class="title">签约居民</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="carebednav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-drawer"></i>
                        <span class="title">家庭病床</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="teamnav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-layers"></i>
                        <span class="title">团队</span>
                        <span class="selected"></span>
                    </a>
                </li>
                @if (!currentLoginUser.IsSuperManager)
                {
                <li class="nav-item" id="examinationstatisticsnav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login">
                        <i class="icon-bar-chart"></i>
                        <span class="title">考核统计</span>
                        <span class="selected"></span>
                    </a>
                </li>
                }
                <li class="nav-item" id="servicepackagenav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-bag"></i>
                        <span class="title">服务包</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="consultnav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-doc"></i>
                        <span class="title">在线咨询</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="informationnav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-pencil"></i>
                        <span class="title">资讯</span>
                        <span class="selected"></span>
                    </a>
                </li>
                @if (currentLoginUser.IsSuperManager)
                {
                <li class="nav-item" id="citynav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-pointer"></i>
                        <span class="title">城市</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="areanav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-social-dribbble"></i>
                        <span class="title">地区</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="hospitalnav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-bar-chart"></i>
                        <span class="title">医院</span>
                        <span class="selected"></span>
                    </a>
                </li>
                <li class="nav-item" id="systemnav">
                    <a href="javascript:;" class="nav-link nav-toggle"
                       action="${pageContext.request.contextPath}/user/login"
                       onclick="$.index.sidebarClick(this)">
                        <i class="icon-settings"></i>
                        <span class="title">系统</span>
                        <span class="selected"></span>
                    </a>
                </li>
                }
            </ul>
        </div>
    </div>
    <div class="page-content-wrapper">
        <div class="page-content">
            <jsp:doBody></jsp:doBody>
        </div>
    </div>
    <a href="javascript:;" class="page-quick-sidebar-toggler">
        <i class="icon-login"></i>
    </a>
</div>
<script src="${pageContext.request.contextPath}/js/layout.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.bs_pagination.js"></script>
<script src="${pageContext.request.contextPath}/js/en.min.js"></script>
<script>

    $.index = {
        sidebarClick: function (e) {
            window.location = $(e).attr("action");
        },

        sidebarItemClick: function (e) {
            window.location = $(e).attr("action");
        },

        pageJump: function (e) {
            window.location = $(e).attr("action");
        },

        signsItemClick: function (e) {
            $(".signs").removeClass("active");
            $(e).addClass("active");
            $("#signs").load($(e).attr("action"));
            $("#signs_title").html($(e).attr("data-title"));
        }
    }
</script>
</body>
</html>