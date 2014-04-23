package com.gxx.file;

import com.gxx.file.dao.UserDao;
import com.gxx.file.utils.TokenUtil;

/**
 * 修改密码Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class UpdatePasswordAction extends BaseAction {
    /**
     * 密码
     */
    String password;

    /**
     * 入口
     * @return
     */
    public String execute() throws Exception {
        logger.info("password:" + password);
        //修改密码
        getUser().setPassword(password);
        UserDao.updateUserPassword(getUser());
        String resp = "{isSuccess:true,message:'修改密码成功！',hasNewToken:true,token:'" +
                TokenUtil.createToken(request) + "'}";
        write(resp);
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
