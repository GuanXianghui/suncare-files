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
</head>
<body>
<div id="body-wrapper">
<div id="sidebar">
    <div id="sidebar-wrapper">
        <h1 id="sidebar-title"><a href="#">申成-文件系统</a></h1>
        <img id="logo" src="images/suncare-files-logo.png" alt="Simpla Admin logo"/>
        <div id="profile-links"> Hello, <a href="http://www.suncarechina.com" target="_blank">申成</a>欢迎您！<br/>
            <br/>
            <a href="javascript: logOut()" title="Sign Out">退出</a></div>
        <ul id="main-nav">
            <%--<li><a href="http://www.865171.cn/" class="nav-top-item no-submenu"> Dashboard </a></li>--%>
            <li><a href="#" class="nav-top-item current"> 用户管理 </a>
                <ul>
                    <li><a href="#">查看用户</a></li>
                    <li><a class="current" href="#">重置密码</a></li>
                    <li><a href="#">创建用户</a></li>
                    <li><a href="#">删除用户</a></li>
                </ul>
            </li>
            <li><a href="#" class="nav-top-item"> Pages </a>
                <ul>
                    <li><a href="#">Create a new Page</a></li>
                    <li><a href="#">Manage Pages</a></li>
                </ul>
            </li>
            <li><a href="#" class="nav-top-item"> Image Gallery </a>
                <ul>
                    <li><a href="#">Upload Images</a></li>
                    <li><a href="#">Manage Galleries</a></li>
                    <li><a href="#">Manage Albums</a></li>
                    <li><a href="#">Gallery Settings</a></li>
                </ul>
            </li>
            <li><a href="#" class="nav-top-item"> Events Calendar </a>
                <ul>
                    <li><a href="#">Calendar Overview</a></li>
                    <li><a href="#">Add a new Event</a></li>
                    <li><a href="#">Calendar Settings</a></li>
                </ul>
            </li>
            <li><a href="#" class="nav-top-item"> Settings </a>
                <ul>
                    <li><a href="#">General</a></li>
                    <li><a href="#">Design</a></li>
                    <li><a href="#">Your Profile</a></li>
                    <li><a href="#">Users and Permissions</a></li>
                </ul>
            </li>
        </ul>
        <!-- End #main-nav -->
        <div id="messages" style="display: none">
            <!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
            <h3>3 Messages</h3>

            <p><strong>17th May 2009</strong> by Admin<br/>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet
                congue.
                <small><a href="#" class="remove-link" title="Remove message">Remove</a></small>
            </p>
            <p><strong>2nd May 2009</strong> by Jane Doe<br/>
                Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis,
                tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est.
                <small><a href="#" class="remove-link" title="Remove message">Remove</a></small>
            </p>
            <p><strong>25th April 2009</strong> by Admin<br/>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet
                congue.
                <small><a href="#" class="remove-link" title="Remove message">Remove</a></small>
            </p>
            <form action="#" method="post">
                <h4>New Message</h4>
                <fieldset>
                    <textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
                </fieldset>
                <fieldset>
                    <select name="dropdown" class="small-input">
                        <option value="option1">Send to...</option>
                        <option value="option2">Everyone</option>
                        <option value="option3">Admin</option>
                        <option value="option4">Jane Doe</option>
                    </select>
                    <input class="button" type="submit" value="Send"/>
                </fieldset>
            </form>
        </div>
        <!-- End #messages -->
    </div>
</div>
<!-- End #sidebar -->
<div id="main-content">
<!-- Main Content Section with everything -->
<noscript>
    <!-- Show a notification if the user has disabled javascript -->
    <div class="notification error png_bg">
        <div> Javascript is disabled or is not supported by your browser. Please <a href="http://browsehappy.com/"
                                                                                    title="Upgrade to a better browser">upgrade</a>
            your browser or <a href="http://www.google.com/support/bin/answer.py?answer=23852"
                               title="Enable Javascript in your browser">enable</a> Javascript to navigate the interface
            properly.
            Download From <a href="http://www.exet.tk">exet.tk</a></div>
    </div>
</noscript>
<!-- Page Head -->
<h2>Welcome www.865171.cn</h2>

<p id="page-intro">What would you like to do?</p>
<ul class="shortcut-buttons-set">
    <li><a class="shortcut-button" href="#"><span> <img src="images/icons/pencil_48.png" alt="icon"/><br/>
        Write an Article </span></a></li>
    <li><a class="shortcut-button" href="#"><span> <img src="images/icons/paper_content_pencil_48.png" alt="icon"/><br/>
        Create a New Page </span></a></li>
    <li><a class="shortcut-button" href="#"><span> <img src="images/icons/image_add_48.png" alt="icon"/><br/>
        Upload an Image </span></a></li>
    <li><a class="shortcut-button" href="#"><span> <img src="images/icons/clock_48.png" alt="icon"/><br/>
        Add an Event </span></a></li>
    <li><a class="shortcut-button" href="#messages" rel="modal"><span> <img src="images/icons/comment_48.png"
                                                                            alt="icon"/><br/>
        Open Modal </span></a></li>
</ul>
<!-- End .shortcut-buttons-set -->
<div class="clear"></div>
<!-- End .clear -->
<div class="content-box">
<!-- Start Content Box -->
<div class="content-box-header">
    <h3>Content box</h3>
    <ul class="content-box-tabs">
        <li><a href="#tab1" class="default-tab">Table</a></li>
        <!-- href must be unique and match the id of target div -->
        <li><a href="#tab2">Forms</a></li>
    </ul>
    <div class="clear"></div>
</div>
<!-- End .content-box-header -->
<div class="content-box-content">
<div class="tab-content default-tab" id="tab1">
    <!-- This is the target div. id must match the href of this div's tab -->
    <div class="notification attention png_bg"><a href="#" class="close"><img
            src="images/icons/cross_grey_small.png" title="Close this notification" alt="close"/></a>

        <div> This is a Content Box. You can put whatever you want in it. By the way, you can close this
            notification with the top-right cross.
        </div>
    </div>
    <table>
        <thead>
        <tr>
            <th>
                <input class="check-all" type="checkbox"/>
            </th>
            <th>Column 1</th>
            <th>Column 2</th>
            <th>Column 3</th>
            <th>Column 4</th>
            <th>Column 5</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <td colspan="6">
                <div class="bulk-actions align-left">
                    <select name="dropdown">
                        <option value="option1">Choose an action...</option>
                        <option value="option2">Edit</option>
                        <option value="option3">Delete</option>
                    </select>
                    <a class="button" href="#">Apply to selected</a></div>
                <div class="pagination"><a href="#" title="First Page">&laquo; First</a><a href="#"
                                                                                           title="Previous Page">&laquo;
                    Previous</a> <a href="#" class="number" title="1">1</a> <a href="#" class="number"
                                                                               title="2">2</a> <a href="#"
                                                                                                  class="number current"
                                                                                                  title="3">3</a> <a
                        href="#" class="number" title="4">4</a> <a href="#" title="Next Page">Next &raquo;</a><a
                        href="#" title="Last Page">Last &raquo;</a></div>
                <!-- End .pagination -->
                <div class="clear"></div>
            </td>
        </tr>
        </tfoot>
        <tbody>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
                <!-- Icons -->
                <a href="#" title="Edit"><img src="images/icons/pencil.png" alt="Edit"/></a> <a href="#"
                                                                                                title="Delete"><img
                    src="images/icons/cross.png" alt="Delete"/></a> <a href="#" title="Edit Meta"><img
                    src="images/icons/hammer_screwdriver.png" alt="Edit Meta"/></a></td>
        </tr>
        </tbody>
    </table>
</div>
<!-- End #tab1 -->
<div class="tab-content" id="tab2">
    <form action="#" method="post">
        <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <p>
                <label>Small form input</label>
                <input class="text-input small-input" type="text" id="small-input" name="small-input"/>
                <span class="input-notification success png_bg">Successful message</span>
                <!-- Classes for input-notification: success, error, information, attention -->
                <br/>
                <small>A small description of the field</small>
            </p>
            <p>
                <label>Medium form input</label>
                <input class="text-input medium-input datepicker" type="text" id="medium-input"
                       name="medium-input"/>
                <span class="input-notification error png_bg">Error message</span></p>

            <p>
                <label>Large form input</label>
                <input class="text-input large-input" type="text" id="large-input" name="large-input"/>
            </p>

            <p>
                <label>Checkboxes</label>
                <input type="checkbox" name="checkbox1"/>
                This is a checkbox
                <input type="checkbox" name="checkbox2"/>
                And this is another checkbox </p>

            <p>
                <label>Radio buttons</label>
                <input type="radio" name="radio1"/>
                This is a radio button<br/>
                <input type="radio" name="radio2"/>
                This is another radio button </p>

            <p>
                <label>This is a drop down list</label>
                <select name="dropdown" class="small-input">
                    <option value="option1">Option 1</option>
                    <option value="option2">Option 2</option>
                    <option value="option3">Option 3</option>
                    <option value="option4">Option 4</option>
                </select>
            </p>
            <p>
                <label>Textarea with WYSIWYG</label>
                <textarea class="text-input textarea wysiwyg" id="textarea" name="textfield" cols="79"
                          rows="15"></textarea>
            </p>

            <p>
                <input class="button" type="submit" value="Submit"/>
            </p>
        </fieldset>
        <div class="clear"></div>
        <!-- End .clear -->
    </form>
</div>
<!-- End #tab2 -->
</div>
<!-- End .content-box-content -->
</div>
<!-- End .content-box -->
<div class="content-box column-left">
    <div class="content-box-header">
        <h3>Content box left</h3>
    </div>
    <!-- End .content-box-header -->
    <div class="content-box-content">
        <div class="tab-content default-tab">
            <h4>Maecenas dignissim</h4>

            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in porta lectus. Maecenas dignissim enim
                quis ipsum mattis aliquet. Maecenas id velit et elit gravida bibendum. Duis nec rutrum lorem. Donec
                egestas metus a risus euismod ultricies. Maecenas lacinia orci at neque commodo commodo. </p>
        </div>
        <!-- End #tab3 -->
    </div>
    <!-- End .content-box-content -->
</div>
<!-- End .content-box -->
<div class="content-box column-right closed-box">
    <div class="content-box-header">
        <!-- Add the class "closed" to the Content box header to have it closed by default -->
        <h3>Content box right</h3>
    </div>
    <!-- End .content-box-header -->
    <div class="content-box-content">
        <div class="tab-content default-tab">
            <h4>This box is closed by default</h4>

            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed in porta lectus. Maecenas dignissim enim
                quis ipsum mattis aliquet. Maecenas id velit et elit gravida bibendum. Duis nec rutrum lorem. Donec
                egestas metus a risus euismod ultricies. Maecenas lacinia orci at neque commodo commodo. </p>
        </div>
        <!-- End #tab3 -->
    </div>
    <!-- End .content-box-content -->
</div>
<!-- End .content-box -->
<div class="clear"></div>
<!-- Start Notifications -->
<div class="notification attention png_bg"><a href="#" class="close"><img src="images/icons/cross_grey_small.png"
                                                                          title="Close this notification" alt="close"/></a>

    <div> Attention notification. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vulputate, sapien quis
        fermentum luctus, libero.
    </div>
</div>
<div class="notification information png_bg"><a href="#" class="close"><img src="images/icons/cross_grey_small.png"
                                                                            title="Close this notification"
                                                                            alt="close"/></a>

    <div> Information notification. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vulputate, sapien
        quis fermentum luctus, libero.
    </div>
</div>
<div class="notification success png_bg"><a href="#" class="close"><img src="images/icons/cross_grey_small.png"
                                                                        title="Close this notification"
                                                                        alt="close"/></a>

    <div> Success notification. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vulputate, sapien quis
        fermentum luctus, libero.
    </div>
</div>
<div class="notification error png_bg"><a href="#" class="close"><img src="images/icons/cross_grey_small.png"
                                                                      title="Close this notification" alt="close"/></a>

    <div> Error notification. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vulputate, sapien quis
        fermentum luctus, libero.
    </div>
</div>
<!-- End Notifications -->
<div id="footer">
    <small>
        <!-- Remove this notice or replace it with whatever you want -->
        &#169; Copyright 2010 Your Company | Powered by <a href="http://www.865171.cn">admin templates</a> | <a
            href="#">Top</a></small>
</div>
<!-- End #footer -->
</div>
<!-- End #main-content -->
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
