package com.gxx.file;

import com.gxx.file.dao.UserDao;
import com.gxx.file.entities.User;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.TokenUtil;

/**
 * ��������Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class ResetPasswordAction extends BaseAction {
    /**
     * �û�ID
     */
    String userId;

    /**
     * ���
     * @return
     */
    public String execute() throws Exception {
        logger.info("userId:" + userId);
        String resp;
        //�û�id
        int userIdInt;
        try{
            userIdInt = Integer.parseInt(userId);
        } catch (Exception e) {
            resp = "{isSuccess:false,message:'�û�ID�Ƿ���',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            write(resp);
            return null;
        }
        //��ѯ�û�
        User resetUser = UserDao.getUserById(Integer.parseInt(userId));
        if(null == resetUser){
            resp = "{isSuccess:false,message:'�����ڸ��û�id=" + userId + "��',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
        } else {
            resetUser.setPassword(BaseUtil.generateDefaultPwd());
            UserDao.updateUserPassword(resetUser);
            resp = "{isSuccess:true,message:'��������ɹ���',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
        }
        write(resp);
        return null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
