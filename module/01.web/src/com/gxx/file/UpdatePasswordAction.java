package com.gxx.file;

import com.gxx.file.dao.UserDao;
import com.gxx.file.utils.TokenUtil;

/**
 * �޸�����Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class UpdatePasswordAction extends BaseAction {
    /**
     * ����
     */
    String password;

    /**
     * ���
     * @return
     */
    public String execute() throws Exception {
        logger.info("password:" + password);
        //�޸�����
        getUser().setPassword(password);
        UserDao.updateUserPassword(getUser());
        String resp = "{isSuccess:true,message:'�޸�����ɹ���',hasNewToken:true,token:'" +
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
