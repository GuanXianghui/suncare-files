/**
 * onload事件
 */
$(document).ready(function(){
    if(EMPTY != message){
        showInformation(message);
    }
    <!-- 图片放大缩小控件 -->
    initializeGrid();
});

<!-- 图片放大缩小控件 -->
function initializeGrid() {
    $("#grid_slider").slider({
        value: 50,
        max: 100,
        min: 10,
        slide: function(event, ui) {
            $('ul#grid li').css('font-size',ui.value+"px");
        }
    });

    $("ul#grid li img").each(function() {
        var width = $(this).width() / 100 + "em";
        var height = $(this).height() / 100 + "em";
        $(this).css("width",width);
        $(this).css("height",height);
    });

}

/**
 * 修改文档
 */
function updateFiles(){
    var name = $("#name").val();
    var file_num = $("#file_num").val();
    var project_name = $("#project_name").val();
    var door_series = $("#door_series").val();
    var glass_type = $("#glass_type").val();
    var wind = $("#wind").val();
    var air = $("#air").val();
    var water = $("#water").val();
    var temperature = $("#temperature").val();
    var voice = $("#voice").val();
    var sun = $("#sun").val();
    var perspective = $("#perspective").val();
    var dew_point = $("#dew_point").val();
    if(name == EMPTY){
        showAttention("请输入文档名称");
        return;
    }
    // 判断字符串是否含有非法字符
    var result = checkStr(name, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("文档名称包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(file_num, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("报告编号包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(project_name, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("工程名称包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(door_series, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("门窗系列包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(glass_type, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("玻璃规格包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(wind, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("抗风压性能包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(air, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("气密性包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(water, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("水密性包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(temperature, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("保温性包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(voice, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("隔声性包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(sun, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("遮阳系数包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(perspective, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("可见光透射比包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(dew_point, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("露点测试包含非法字符："  + result["symbol"]);
        return;
    }

    //创建用户
    var SUCCESS_STR = "success";//成功编码
    $.ajax({
        type:"post",
        async:false,
        url:baseUrl + "updateFiles.do",
        data:"filesId=" + filesId + "&name=" + filterStr(name) + "&fileNum=" + filterStr(file_num) +
            "&projectName=" + filterStr(project_name) + "&doorSeries=" + filterStr(door_series) +
            "&glassType=" + filterStr(glass_type) + "&wind=" + filterStr(wind) + "&air=" + filterStr(air) +
            "&water=" + filterStr(water) + "&temperature=" + filterStr(temperature) + "&voice=" + filterStr(voice) +
            "&sun=" + filterStr(sun) + "&perspective=" + filterStr(perspective) + "&dewPoint=" + filterStr(dew_point) +
            "&token=" + token,
        success:function (data, textStatus) {
            if ((SUCCESS_STR == textStatus) && (null != data)) {
                data = eval("(" + data + ")");
                //判是否成功
                if (false == data["isSuccess"]) {
                    showError(data["message"]);
                } else {
                    //成功
                    showSuccess(data["message"]);
                }
                //判是否有新token
                if (data["hasNewToken"]) {
                    token = data["token"];
                }
            } else {
                showAttention("服务器连接异常，请稍后再试！");
            }
        },
        error:function (data, textStatus) {
            showAttention("服务器连接异常，请稍后再试！");
        }
    });
}

/**
 * 上传文档照片
 */
function uploadFilesPhoto(){
    document.forms["uploadFilesPhotoFrom"].action = baseUrl + "uploadFilesPhoto.do?token=" + token;
    document.forms["uploadFilesPhotoFrom"].submit();
}

/**
 * 选择照片
 * @param t
 */
function chooseImg(t, imgId){
    $(".img_class").css("border", "");
    t.style.border = "2px solid green";
    $("#big_img").attr("src", t.src);
    $("#big_img_div").css("display", "block");
    $("#photo_desc").html(t.name);
    $("#filesPhotoDesc").val(t.name);
    $("#filesPhotoId").val(imgId);
}

//控制条初始位置
var initLeft = null;
//图片初始大小
var initImgWidth = 450;

/**
 * 鼠标按下
 */
function mouseDown(){
    //位置为空返回
    var left = $(".ui-slider-handle")[0].style.left;
    if(left == undefined || left == EMPTY){
        return;
    }
    //当前位置
    var leftFloat = parseFloat(left.substr(0, left.indexOf("px")));
    //初始化初始位置
    if(initLeft == null){
        initLeft = leftFloat;
    }
    var width = initImgWidth + leftFloat - initLeft;
    if(width < 0){
        width = 0;
    }
    $("#big_img").css("width", width +  "px");
}

/**
 * 鼠标移动
 */
function mouseMove(){
    mouseDown();
}

/**
 * 按键按下去
 */
function keyDown(){
    mouseDown();
}

//修改文档图片类型
var UPDATE_FILES_PHOTO_TYPE_MOVE_LEFT = "moveLeft";
var UPDATE_FILES_PHOTO_TYPE_MOVE_RIGHT = "moveRight";
var UPDATE_FILES_PHOTO_TYPE_DELETE_PHOTO = "deletePhoto";
var UPDATE_FILES_PHOTO_TYPE_UPDATE_PHOTO = "updatePhoto";

/**
 * 左移
 */
function moveLeft(){
    $("#filesPhotoToken").val(token);
    $("#updateFilesPhotoType").val(UPDATE_FILES_PHOTO_TYPE_MOVE_LEFT);
    document.forms["updateFilesPhotoForm"].submit();
}

/**
 * 右移
 */
function moveRight(){
    $("#filesPhotoToken").val(token);
    $("#updateFilesPhotoType").val(UPDATE_FILES_PHOTO_TYPE_MOVE_RIGHT);
    document.forms["updateFilesPhotoForm"].submit();
}

/**
 * 删除
 */
function deletePhoto(){
    if(!confirm("您确定要删除照片吗？")){
        return;
    }
    $("#filesPhotoToken").val(token);
    $("#updateFilesPhotoType").val(UPDATE_FILES_PHOTO_TYPE_DELETE_PHOTO);
    document.forms["updateFilesPhotoForm"].submit();
}

/**
 * 修改
 */
function updatePhoto(){
    $("#filesPhotoToken").val(token);
    $("#updateFilesPhotoType").val(UPDATE_FILES_PHOTO_TYPE_UPDATE_PHOTO);
    document.forms["updateFilesPhotoForm"].submit();
}

//初始图片个数
var photoCount = 5;
//最多图片个数
var photoMaxNum = 15;

/**
 * 添加图片
 */
function addFilesPhoto(){
    if(photoCount >= photoMaxNum){
        showAttentionMessage("message_id2", "限制最多上传" + photoMaxNum + "张图");
        return;
    }
    photoCount += 1;
    var addContent = "<p><span>照片</span>&nbsp;&nbsp;<input type=\"file\" name=\"photo" + photoCount + "\"></p>";
    $("#photos").append(addContent);
}