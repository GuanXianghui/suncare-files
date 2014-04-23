<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <title>申成-文件系统</title>
    <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="scripts/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="scripts/simpla.jquery.configuration.js"></script>
    <script type="text/javascript" src="scripts/facebox.js"></script>
    <script type="text/javascript" src="scripts/jquery.wysiwyg.js"></script>
    <script type="text/javascript" src="scripts/jquery.datePicker.js"></script>
    <script type="text/javascript" src="scripts/jquery.date.js"></script>
    <script type="text/javascript" src="scripts/base.js"></script>
    <script type="text/javascript" src="scripts/createFiles.js"></script>
</head>
<body>
<div id="body-wrapper">
<div id="sidebar">
    <div id="sidebar-wrapper">
        <h1 id="sidebar-title"><a href="#">申成-文件系统</a></h1>
        <img id="logo" src="images/suncare-files-logo.png" alt="Simpla Admin logo"/>

        <div id="profile-links"> Hello, [<%=user.getName()%>], <a href="http://www.suncarechina.com" target="_blank">申成</a>欢迎您！<br/>
            <br/>
            <a href="javascript: logOut()" title="Sign Out">退出</a></div>
        <ul id="main-nav">
            <li><a href="#" class="nav-top-item"> 用户管理 </a>
                <ul>
                    <li><a href="<%=baseUrl%>main.jsp">用户查询</a></li>
                    <%if(isSuperMan){%>
                    <li><a href="<%=baseUrl%>createUser.jsp">新增用户</a></li>
                    <%}%>
                    <li><a href="<%=baseUrl%>updatePassword.jsp">修改密码</a></li>
                </ul>
            </li>
            <li><a href="#" class="nav-top-item current"> 文档管理 </a>
                <ul>
                    <li><a href="<%=baseUrl%>files.jsp">查看文档</a></li>
                    <%if(isSuperMan){%>
                    <li><a href="<%=baseUrl%>createFiles.jsp" class="current">新建文档</a></li>
                    <%}%>
                </ul>
            </li>
            <li><a href="#" class="nav-top-item"> 日志 </a>
                <ul>
                    <li><a href="<%=baseUrl%>operateLog.jsp">查看日志</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div id="main-content">
<div class="content-box">
<div class="content-box-header">
    <h3>新增文档</h3>
    <ul class="content-box-tabs">
        <li><a href="#tab1" class="default-tab">Forms</a></li>
    </ul>
    <div class="clear"></div>
</div>
<div class="content-box-content">
<div class="tab-content default-tab" id="tab1">
    <div id="message_id" class="notification information png_bg" style="display: none;">
        <a href="#" class="close">
            <img src="images/icons/cross_grey_small.png" title="关闭" alt="关闭"/>
        </a>
        <div id="message_id_content"> 提示信息！ </div>
    </div>
    <form>
        <fieldset>
            <table>
                <tr>
                    <td>文档名称</td>
                    <td><input class="text-input medium-input" type="text" id="name" name="name"/></td>
                </tr>
                <tr>
                    <td>报告编号</td>
                    <td><input class="text-input medium-input" type="text" id="file_num" name="file_num"/></td>
                </tr>
                <tr>
                    <td>工程名称</td>
                    <td><input class="text-input medium-input" type="text" id="project_name" name="project_name"/></td>
                </tr>
                <tr>
                    <td>门窗系列</td>
                    <td><input class="text-input medium-input" type="text" id="door_series" name="door_series"/></td>
                </tr>
                <tr>
                    <td>玻璃规格</td>
                    <td><input class="text-input medium-input" type="text" id="glass_type" name="glass_type"/></td>
                </tr>
                <tr>
                    <td>抗风压性能</td>
                    <td><input class="text-input medium-input" type="text" id="wind" name="wind"/></td>
                </tr>
                <tr>
                    <td>气密性</td>
                    <td><input class="text-input medium-input" type="text" id="air" name="air"/></td>
                </tr>
                <tr>
                    <td>水密性</td>
                    <td><input class="text-input medium-input" type="text" id="water" name="water"/></td>
                </tr>
                <tr>
                    <td>保温性</td>
                    <td><input class="text-input medium-input" type="text" id="temperature" name="temperature"/></td>
                </tr>
                <tr>
                    <td>隔声性</td>
                    <td><input class="text-input medium-input" type="text" id="voice" name="voice"/></td>
                </tr>
                <tr>
                    <td>遮阳系数</td>
                    <td><input class="text-input medium-input" type="text" id="sun" name="sun"/></td>
                </tr>
                <tr>
                    <td>可见光透射比</td>
                    <td><input class="text-input medium-input" type="text" id="perspective" name="perspective"/></td>
                </tr>
                <tr>
                    <td>露点测试</td>
                    <td><input class="text-input medium-input" type="text" id="dew_point" name="dew_point"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="button" type="button" onclick="createFiles();" value="新建" />
                    </td>
                </tr>
            </table>
        </fieldset>
        <div class="clear"></div>
    </form>
</div>
</div>
</div>
<div id="footer">
    <small>
        &#169; Copyright 2014 Suncare | Powered by 关向辉
    </small>
</div>
</div>
</div>
</body>
</html>