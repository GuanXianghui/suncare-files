package com.gxx.file;

import com.gxx.file.dao.FilesDao;
import com.gxx.file.dao.FilesPhotoDao;
import com.gxx.file.entities.Files;
import com.gxx.file.entities.FilesPhoto;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 修改文档照片Action
 * 左移，右移，删除，修改
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class UpdateFilesPhotoAction extends BaseAction {

    /**
     * 修改文档图片类型
     */
    private static final String UPDATE_FILES_PHOTO_TYPE_MOVE_LEFT = "moveLeft";
    private static final String UPDATE_FILES_PHOTO_TYPE_MOVE_RIGHT = "moveRight";
    private static final String UPDATE_FILES_PHOTO_TYPE_DELETE_PHOTO = "deletePhoto";
    private static final String UPDATE_FILES_PHOTO_TYPE_UPDATE_PHOTO = "updatePhoto";

    /**
     * 文档图片id
     */
    String filesPhotoId;
    /**
     * 修改文档照片类型
     */
    String updateFilesPhotoType;
    /**
     * 文档照片描述
     */
    String photoDesc;
    /**
     * 文档id
     */
    String filesId;

    /**
     * 入口
     * @return
     */
    public String execute() throws Exception {
        logger.info("filesPhotoId=" + filesPhotoId + ",updateFilesPhotoType=" + updateFilesPhotoType +
                ",photoDesc=" + photoDesc);
        //查文档图片
        int filesPhotoIdInt = Integer.parseInt(filesPhotoId);
        FilesPhoto filesPhoto = FilesPhotoDao.getFilesPhotoById(filesPhotoIdInt);
        if(null == filesPhoto){
            message = "找不到该文档图片(id=" + filesPhotoIdInt + ")！";
            return ERROR;
        }
        filesId = StringUtils.EMPTY + filesPhoto.getFilesId();
        Files files = FilesDao.getFilesById(filesPhoto.getFilesId());
        //判修改文档照片类型
        if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_MOVE_LEFT)){
            FilesPhoto leftOne = FilesPhotoDao.getLeftOne(filesPhoto);
            if(leftOne != null){
                int leftIndexId = leftOne.getIndexId();
                leftOne.setIndexId(filesPhoto.getIndexId());
                FilesPhotoDao.updateFilesPhoto(leftOne);
                filesPhoto.setIndexId(leftIndexId);
                FilesPhotoDao.updateFilesPhoto(filesPhoto);
            }
            message = "左移成功！";
            //创建操作日志
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_MOVE_LEFT_FILES_PHOTO,
                    "对文档[" + files.getName() + "]左移文档照片", date, time, getIp());
        } else if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_MOVE_RIGHT)){
            FilesPhoto rightOne = FilesPhotoDao.getRightOne(filesPhoto);
            if(rightOne != null){
                int rightIndexId = rightOne.getIndexId();
                rightOne.setIndexId(filesPhoto.getIndexId());
                FilesPhotoDao.updateFilesPhoto(rightOne);
                filesPhoto.setIndexId(rightIndexId);
                FilesPhotoDao.updateFilesPhoto(filesPhoto);
            }
            message = "右移成功！";
            //创建操作日志
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_MOVE_RIGHT_FILES_PHOTO,
                    "对文档[" + files.getName() + "]右移文档照片", date, time, getIp());

        } else if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_DELETE_PHOTO)){
            FilesPhotoDao.deleteFilesPhoto(filesPhoto);
            message = "删除成功！";
            //创建操作日志
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_DELETE_FILES_PHOTO,
                    "对文档[" + files.getName() + "]删除文档照片", date, time, getIp());
        } else if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_UPDATE_PHOTO)){
            filesPhoto.setPhotoDesc(photoDesc);
            FilesPhotoDao.updateFilesPhoto(filesPhoto);
            message = "修改成功！";
            //创建操作日志
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_UPDATE_FILES_PHOTO,
                    "对文档[" + files.getName() + "]修改文档照片", date, time, getIp());
        } else {
            message = "无效的类型(" + updateFilesPhotoType + ")！";
            return ERROR;
        }
        //返回结果
        return SUCCESS;
    }

    public String getFilesPhotoId() {
        return filesPhotoId;
    }

    public void setFilesPhotoId(String filesPhotoId) {
        this.filesPhotoId = filesPhotoId;
    }

    public String getUpdateFilesPhotoType() {
        return updateFilesPhotoType;
    }

    public void setUpdateFilesPhotoType(String updateFilesPhotoType) {
        this.updateFilesPhotoType = updateFilesPhotoType;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }
}
