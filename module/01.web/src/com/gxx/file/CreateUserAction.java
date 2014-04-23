package com.gxx.file;

import com.gxx.file.dao.UserDao;
import com.gxx.file.entities.User;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.TokenUtil;

/**
 * �����û�Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class CreateUserAction extends BaseAction {
    /**
     * �û�����
     */
    String name;

    /**
     * ���
     * @return
     */
    public String execute() throws Exception {
        logger.info("name:" + name);
        String resp;
        if(UserDao.isNameExist(name)){
            resp = "{isSuccess:false,message:'�������Ѵ��ڣ�',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
        } else {
            //�õ�Ĭ������
            String defaultPassword = BaseUtil.generateDefaultPwd();
            User newUser = new User(name, defaultPassword);
            UserDao.insertUser(newUser);
            resp = "{isSuccess:true,message:'�����û��ɹ���',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            //����������־
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_CREATE_USER,
                    "�����û�[" + name + "]", date, time, getIp());
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
