/**
 * 创建文档
 */
function createFiles(){
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
        url:baseUrl + "createFiles.do",
        data:"name=" + filterStr(name) + "&fileNum=" + filterStr(file_num) + "&projectName=" +
            filterStr(project_name) + "&doorSeries=" + filterStr(door_series) + "&glassType=" +
            filterStr(glass_type) + "&wind=" + filterStr(wind) + "&air=" + filterStr(air) + "&water=" +
            filterStr(water) + "&temperature=" + filterStr(temperature) + "&voice=" + filterStr(voice) + "&sun=" +
            filterStr(sun) + "&perspective=" + filterStr(perspective) + "&dewPoint=" + filterStr(dew_point) +
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