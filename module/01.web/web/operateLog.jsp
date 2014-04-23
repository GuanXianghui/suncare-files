<%@ page import="java.util.List" %>
<%@ page import="com.gxx.file.dao.FilesDao" %>
<%@ page import="com.gxx.file.entities.Files" %>
<%@ page import="com.gxx.file.dao.OperateLogDao" %>
<%@ page import="com.gxx.file.entities.OperateLog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%
    //用户姓名
    String userName = StringUtils.trimToEmpty(request.getParameter("userName"));
    //操作类型
    String typeStr = StringUtils.trimToEmpty(request.getParameter("type"));
    //操作类型
    int type;
    try {
        type = Integer.parseInt(typeStr);
    } catch (Exception e) {
        type = 0;
    }
    //日期
    String date = StringUtils.trimToEmpty(request.getParameter("date"));

    //当前页数
    String pageStr = StringUtils.trimToEmpty(request.getParameter("pageNum"));
    //当前页数
    int pageNum;
    try {
        pageNum = Integer.parseInt(pageStr);
    } catch (Exception e) {
        pageNum = 1;
    }

    //操作日志列表每页大小
    int pageSize = Integer.parseInt(PropertyUtil.getInstance().getProperty(BaseInterface.OPERATE_LOG_PAGE_SIZE));
    //操作日志总数
    int count = OperateLogDao.countOperateLogsByLike(userName, type, date);
    //是否为空
    boolean isEmpty = count == 0;
    //总页数
    int pageCount = (count - 1) / pageSize + 1;
    //删除最后一条，可能会少掉一页
    if(pageNum > pageCount){
        pageNum = pageCount;
    }
    //操作日志列表
    List<OperateLog> operateLogs = OperateLogDao.queryOperateLogsByLike(userName, type, date, pageNum);
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
    <script type="text/javascript" src="scripts/operateLog.js"></script>
    <script type="text/javascript">
        //当前页数
        var pageNum = <%=pageNum%>;
    </script>
</head>
<body>
<div id="body-wrapper">
    <div id="sidebar">
        <div id="sidebar-wrapper">
            <h1 id="sidebar-title"><a href="#">申成-文件系统</a></h1>
            <img id="logo" src="images/suncare-files-logo.png" alt="Simpla Admin logo"/>

            <div id="profile-links"> Hello, [<%=user.getName()%>], <a href="http://www.suncarechina.com"
                                                                      target="_blank">申成</a>欢迎您！<br/>
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
                <li><a href="#" class="nav-top-item"> 文档管理 </a>
                    <ul>
                        <li><a href="<%=baseUrl%>files.jsp">查看文档</a></li>
                        <%if(isSuperMan){%>
                        <li><a href="<%=baseUrl%>createFiles.jsp">新建文档</a></li>
                        <%}%>
                    </ul>
                </li>
                <li><a href="#" class="nav-top-item current"> 日志 </a>
                    <ul>
                        <li><a href="<%=baseUrl%>operateLog.jsp" class="current">查看日志</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div id="main-content">
        <form action="<%=baseUrl%>operateLog.jsp" name="operateLogForm" method="post" style="display: none;">
            <input type="hidden" name="userName" id="operateLogUserName" value="<%=userName%>">
            <input type="hidden" name="type" id="operateLogType" value="<%=type%>">
            <input type="hidden" name="date" id="operateLogDate" value="<%=date%>">
            <input type="hidden" name="pageNum" id="pageNum" value="1">
        </form>
        <form>
            <span>用户姓名</span>&nbsp;&nbsp;<input class="text-input" type="text" id="userName"/>
            <span>操作类型</span>&nbsp;&nbsp;
            <select class="small-input" id="type">
                <option value="">全部</option>
                <option value="1">登陆</option>
                <option value="2">退出</option>
                <option value="3">新建用户</option>
                <option value="4">删除用户</option>
                <option value="5">新建文档</option>
                <option value="6">删除文档</option>
                <option value="7">修改文档</option>
                <option value="8">上传图片</option>
                <option value="9">左移图片</option>
                <option value="10">右移图片</option>
                <option value="11">修改图片</option>
                <option value="12">删除图片</option>
            </select>
            <span>日期</span>&nbsp;&nbsp;<input class="text-input" type="text" id="date"/>
            <input class="button" type="button" onclick="queryOperateLogs();" value="查询"/>
            <br/>
            <br/>
        </form>
        <div class="content-box">
            <div class="content-box-header">
                <h3>操作日志列表</h3>
                <ul class="content-box-tabs">
                    <li><a href="#tab1" class="default-tab">Table</a></li>
                </ul>
                <div class="clear"></div>
            </div>
            <div class="content-box-content">
                <div class="tab-content default-tab" id="tab1">
                    <div id="message_id" class="notification information png_bg" style="display: none;">
                        <a href="#" class="close">
                            <img src="images/icons/cross_grey_small.png" title="关闭" alt="关闭"/>
                        </a>

                        <div id="message_id_content"> 提示信息！</div>
                    </div>
                    <table>
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>用户姓名</th>
                            <th>操作类型</th>
                            <th>内容</th>
                            <th>日期</th>
                            <th>时间</th>
                            <th>IP</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <td colspan="7">
                                <div class="pagination">
                                    <a href="javascript: jump2page(1)" title="首页">&laquo; 首页</a>
                                    <%
                                        if(pageNum > 1){
                                    %>
                                    <a href="javascript: jump2page(<%=pageNum-1%>)" title="上一页">&laquo; 上一页</a>
                                    <%
                                        }
                                    %>
                                    <%
                                        //显示前2页，本页，后2页
                                        for(int i=pageNum-2;i<pageNum+3;i++){
                                            if(i >= 1 && i <= pageCount){
                                    %>
                                    <a href="javascript: jump2page(<%=i%>)" class="number<%=(i==pageNum)?" current":""%>" title="<%=i%>"><%=i%></a>
                                    <%
                                            }
                                        }
                                    %>
                                    <%
                                        if(pageNum < pageCount){
                                    %>
                                    <a href="javascript: jump2page(<%=pageNum+1%>)" title="下一页">下一页 &raquo;</a>
                                    <%
                                        }
                                    %>
                                    <a href="javascript: jump2page(<%=pageCount%>)" title="尾页">尾页 &raquo;</a>
                                </div>
                                <div class="clear"></div>
                            </td>
                        </tr>
                        </tfoot>
                        <tbody>
                        <%
                            //判是否为空
                            if (isEmpty) {
                        %>
                        <tr>
                            <td colspan="7">
                                没找到符合条件的操作日志
                            </td>
                        </tr>
                        <%
                        } else {//非空
                            for (OperateLog tempOperateLog : operateLogs) {
                        %>
                        <tr>
                            <td><%=tempOperateLog.getId()%></td>
                            <td><%=tempOperateLog.getUserName()%></td>
                            <td><%=tempOperateLog.getTypeDesc()%></td>
                            <td><%=tempOperateLog.getContent()%></td>
                            <td><%=tempOperateLog.getDate()%></td>
                            <td><%=tempOperateLog.getTime()%></td>
                            <td><%=tempOperateLog.getIp()%></td>
                        </tr>
                        <%
                                }
                            }
                        %>

                        </tbody>
                    </table>
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
