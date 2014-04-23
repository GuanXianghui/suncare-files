/**
 * 查询文档
 */
function queryFiles() {
    var name = $("#name").val();
    var fileNum = $("#fileNum").val();
    var projectName = $("#projectName").val();
    var doorSeries = $("#doorSeries").val();
    var glassType = $("#glassType").val();
    var wind = $("#wind").val();
    var air = $("#air").val();
    var water = $("#water").val();
    var temperature = $("#temperature").val();
    var voice = $("#voice").val();
    var sun = $("#sun").val();
    var perspective = $("#perspective").val();
    var dewPoint = $("#dewPoint").val();

    // 判断字符串是否含有非法字符
    var result = checkStr(name, SYMBOL_ARRAY_1);
    if (result["isSuccess"] == false) {
        showAttention("用户名包含非法字符:" + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(fileNum, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("报告编号包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(projectName, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("工程名称包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(doorSeries, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("门窗系列包含非法字符："  + result["symbol"]);
        return;
    }

    // 判断字符串是否含有非法字符
    result = checkStr(glassType, SYMBOL_ARRAY_1);
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
    result = checkStr(dewPoint, SYMBOL_ARRAY_1);
    if(result["isSuccess"] == false) {
        showAttention("露点测试包含非法字符："  + result["symbol"]);
        return;
    }

    $("#filesName").val(name);
    $("#filesFileNum").val(fileNum);
    $("#filesProjectName").val(projectName);
    $("#filesDoorSeries").val(doorSeries);
    $("#filesGlassType").val(glassType);
    $("#filesWind").val(wind);
    $("#filesAir").val(air);
    $("#filesWater").val(water);
    $("#filesTemperature").val(temperature);
    $("#filesVoice").val(voice);
    $("#filesSun").val(sun);
    $("#filesPerspective").val(perspective);
    $("#filesDewPoint").val(dewPoint);
    document.forms["filesForm"].submit();
}

/**
 * 跳到某一页
 *
 * @param pageNum
 */
function jump2page(pageNum) {
    $("#pageNum").val(pageNum);
    document.forms["filesForm"].submit();
}

/**
 * 删除文档
 *
 * @param filesId
 */
function deleteFiles(filesId){
    if(!confirm("您确定要删除文档吗？")){
        return;
    }
    //删除用户
    var SUCCESS_STR = "success";//成功编码
    $.ajax({
        type:"post",
        async:false,
        url:baseUrl + "deleteFiles.do",
        data:"filesId=" + filesId + "&token=" + token,
        success:function (data, textStatus) {
            if ((SUCCESS_STR == textStatus) && (null != data)) {
                data = eval("(" + data + ")");
                //判是否成功
                if (false == data["isSuccess"]) {
                    showError(data["message"]);
                } else {
                    //成功 跳到当前
                    jump2page(pageNum);
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