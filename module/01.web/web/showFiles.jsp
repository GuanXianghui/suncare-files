<%@ page import="com.gxx.file.entities.Files" %>
<%@ page import="com.gxx.file.dao.FilesDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gxx.file.entities.FilesPhoto" %>
<%@ page import="com.gxx.file.dao.FilesPhotoDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%
    //文档id
    int filesId;
    try{
        filesId = Integer.parseInt(StringUtils.trimToEmpty(request.getParameter("filesId")));
    } catch (Exception e){
        //非法跳转
        response.sendRedirect(baseUrl + "files.jsp");
        return;
    }
    Files files = FilesDao.getFilesById(filesId);
    if(null == files){
        //找不到文档
        response.sendRedirect(baseUrl + "files.jsp");
        return;
    }
%>
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
    <script type="text/javascript" src="scripts/updateFiles.js"></script>
    <!-- 图片放大缩小控件 -->
    <link rel="stylesheet" href="css/jquery-ui-personalized.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="scripts/jquery-ui-personalized-1.5.3.min.js"></script>
    <script type="text/javascript">
        //文档id
        var filesId = <%=filesId%>;
    </script>
</head>
<body onmousedown="mouseDown()" onmousemove="mouseMove()" onkeydown="keyDown()">
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
                    <li><a href="<%=baseUrl%>files.jsp" class="current">查看文档</a></li>
                    <%if(isSuperMan){%>
                    <li><a href="<%=baseUrl%>createFiles.jsp">新建文档</a></li>
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
    <h3>查看文档</h3>
    <ul class="content-box-tabs">
        <li><a href="#tab1" class="default-tab">信息</a></li>
        <li><a href="#tab2">看图</a></li>
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
                        <td><input class="text-input medium-input" type="text" id="name" name="name"
                                   value="<%=files.getName()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>报告编号</td>
                        <td><input class="text-input medium-input" type="text" id="file_num" name="file_num"
                                   value="<%=files.getFileNum()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>工程名称</td>
                        <td><input class="text-input medium-input" type="text" id="project_name" name="project_name"
                                   value="<%=files.getProjectName()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>门窗系列</td>
                        <td><input class="text-input medium-input" type="text" id="door_series" name="door_series"
                                   value="<%=files.getDoorSeries()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>玻璃规格</td>
                        <td><input class="text-input medium-input" type="text" id="glass_type" name="glass_type"
                                   value="<%=files.getGlassType()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>抗风压性能</td>
                        <td><input class="text-input medium-input" type="text" id="wind" name="wind"
                                   value="<%=files.getWind()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>气密性</td>
                        <td><input class="text-input medium-input" type="text" id="air" name="air"
                                   value="<%=files.getAir()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>水密性</td>
                        <td><input class="text-input medium-input" type="text" id="water" name="water"
                                   value="<%=files.getWater()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>保温性</td>
                        <td><input class="text-input medium-input" type="text" id="temperature" name="temperature"
                                   value="<%=files.getTemperature()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>隔声性</td>
                        <td><input class="text-input medium-input" type="text" id="voice" name="voice"
                                   value="<%=files.getVoice()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>遮阳系数</td>
                        <td><input class="text-input medium-input" type="text" id="sun" name="sun"
                                   value="<%=files.getSun()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>可见光透射比</td>
                        <td><input class="text-input medium-input" type="text" id="perspective" name="perspective"
                                   value="<%=files.getPerspective()%>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>露点测试</td>
                        <td><input class="text-input medium-input" type="text" id="dew_point" name="dew_point"
                                   value="<%=files.getDewPoint()%>" disabled="disabled"/></td>
                    </tr>
                </table>
            </fieldset>
            <div class="clear"></div>
        </form>
    </div>
    <div class="tab-content" id="tab2">
        <div id="message_id2" class="notification information png_bg" style="display: none;">
            <a href="#" class="close">
                <img src="images/icons/cross_grey_small.png" title="关闭" alt="关闭"/>
            </a>
            <div id="message_id2_content"> 提示信息！ </div>
        </div>
        <div>
            <%
                List<FilesPhoto> filesPhotoList = FilesPhotoDao.queryFilesPhotos(filesId);
                for (int i = 0; i < filesPhotoList.size(); i++) {
                    FilesPhoto filesPhoto = filesPhotoList.get(i);
            %>
            <img onclick="chooseImg(this, <%=filesPhoto.getId()%>)" class="img_class" src="<%=baseUrl+filesPhoto.getPhoto()%>"
                 alt="<%=filesPhoto.getPhotoDesc()%>" name="<%=filesPhoto.getPhotoDesc()%>"
                 style="cursor: pointer; width: 54px; height: 54px;"/>
            <%
                }
            %>
        </div>
        <!-- 图片放大缩小控件 -->
        <div id="big_img_div" align="center" style="display: none; overflow: auto;">
            <div id="grid_slider">
                <div class='ui-slider-handle'></div>
            </div>
            <div id="photo_desc" align="center">
            </div>
            <ul id="grid">
                <img id="big_img" width="450px" src="" alt="Dead Sea"/>
            </ul>
        </div>
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