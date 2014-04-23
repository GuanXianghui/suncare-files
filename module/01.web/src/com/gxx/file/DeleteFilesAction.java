package com.gxx.file;

import com.gxx.file.dao.FilesDao;
import com.gxx.file.entities.Files;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.TokenUtil;

/**
 * ɾ���ĵ�Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class DeleteFilesAction extends BaseAction {
    /**
     * �ĵ�ID
     */
    String filesId;

    /**
     * ���
     * @return
     */
    public String execute() throws Exception {
        logger.info("filesId:" + filesId);
        String resp;
        //�û�id
        int filesIdInt;
        try{
            filesIdInt = Integer.parseInt(filesId);
        } catch (Exception e) {
            resp = "{isSuccess:false,message:'�ĵ�ID�Ƿ���',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            write(resp);
            return null;
        }

        //����id���ĵ�
        Files deleteFiles = FilesDao.getFilesById(filesIdInt);
        if(null == deleteFiles){
            resp = "{isSuccess:false,message:'�����ڸ��ĵ�id=" + filesIdInt + "��',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
        } else {
            FilesDao.deleteFiles(deleteFiles);
            resp = "{isSuccess:true,message:'ɾ���ɹ���',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            //����������־
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_DELETE_FILES,
                    "ɾ���ĵ�[" + deleteFiles.getName() + "]", date, time, getIp());
        }
        write(resp);
        return null;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }
}
