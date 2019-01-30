/**
 * 发送数据
 * @todo AJAX同步请求发送
 * @param sendurl 发送消息的路径
 * @param data 发送消息的数据
 * @return 服务器返回的数据
 */
function requestSend(sendurl, data){
    var res;
    $.ajax({
        url:sendurl,
        type:'post',
        async:false,
        data:data,
        dataType:'json',
        error:function(resData){
            console.log(resData);
        },
        success:function(resData){
            console.log(resData);
            res = resData;
        }
    });
    return res;
}
/**
 * @TODO 错误消息弹出框
 * @param Mess 错误信息
 *
 */
function alerterror(Mess){
    swal("警告", Mess, "error");
}
/**
 * @TODO 错误消息弹出框
 * @param Mess 错误信息
 *
 */
function alertsucc(Mess){
    swal("提示", Mess, "success");
}



/**
 * function
 * @author ZLei
 * @date 2017/9/18
 * @param feedback 请求状态信息
 * @return boolean true:请求成功, false:请求失败
 * @todo
 */
function loadResult(feedback, msg) {
	var REQUEST_SUCCESS = 10000;
    if(feedback == REQUEST_SUCCESS){
        return true;
    }else{
        alerterror(msg);
        return false;
    }
}

/**
 * function
 * @author ZLei
 * @date 2017/9/18
 * @param 请求状态
 * @return 请求错误信息
 * @todo
 */
function loadErrorMsg(feedback) {
    if(feedback == 10001){ // 登录失败
        return "登录失败,请重试";
    }else if(feedback == 10002){
        return "获取子菜单出错";
    }else if(feedback == 10003){
        return "参数错误";
    }else if(feedback == 10004){
        return "没有权利";
    }else if(feedback == 10005){
        return "用户已存在";
    }else if(feedback == 10006){
        return "用户不存在";
    }else if(feedback == 10007){
        return "用户不能修改";
    }else if(feedback == 10008){
        return "旧密码输入错误";
    }else if(feedback == 10009){
        return "两次密码输入不一致";
    }
    return "";
}