package com.gxx.file;

import com.gxx.file.dao.FilesDao;
import com.gxx.file.entities.Files;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.TokenUtil;

/**
 * 删除文档Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class DeleteFilesAction extends BaseAction {
    /**
     * 文档ID
     */
    String filesId;

    /**
     * 入口
     * @return
     */
    public String execute() throws Exception {
        logger.info("filesId:" + filesId);
        String resp;
        //用户id
        int filesIdInt;
        try{
            filesIdInt = Integer.parseInt(filesId);
        } catch (Exception e) {
            resp = "{isSuccess:false,message:'文档ID非法！',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            write(resp);
            return null;
        }

        //根据id查文档
        Files deleteFiles = FilesDao.getFilesById(filesIdInt);
        if(null == deleteFiles){
            resp = "{isSuccess:false,message:'不存在该文档id=" + filesIdInt + "！',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
        } else {
            FilesDao.deleteFiles(deleteFiles);
            resp = "{isSuccess:true,message:'删除成功！',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            //创建操作日志
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_DELETE_FILES,
                    "删除文档[" + deleteFiles.getName() + "]", date, time, getIp());
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
