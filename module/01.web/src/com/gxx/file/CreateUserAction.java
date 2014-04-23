package com.gxx.file;

import com.gxx.file.dao.UserDao;
import com.gxx.file.entities.User;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.TokenUtil;

/**
 * 创建用户Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class CreateUserAction extends BaseAction {
    /**
     * 用户姓名
     */
    String name;

    /**
     * 入口
     * @return
     */
    public String execute() throws Exception {
        logger.info("name:" + name);
        String resp;
        if(UserDao.isNameExist(name)){
            resp = "{isSuccess:false,message:'该名字已存在！',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
        } else {
            //得到默认密码
            String defaultPassword = BaseUtil.generateDefaultPwd();
            User newUser = new User(name, defaultPassword);
            UserDao.insertUser(newUser);
            resp = "{isSuccess:true,message:'新增用户成功！',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            //创建操作日志
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_CREATE_USER,
                    "创建用户[" + name + "]", date, time, getIp());
        }
        write(resp);
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
