package com.gxx.file;

import com.gxx.file.dao.FilesDao;
import com.gxx.file.dao.FilesPhotoDao;
import com.gxx.file.entities.Files;
import com.gxx.file.entities.FilesPhoto;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import org.apache.commons.lang.StringUtils;

/**
 * �޸��ĵ���ƬAction
 * ���ƣ����ƣ�ɾ�����޸�
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class UpdateFilesPhotoAction extends BaseAction {

    /**
     * �޸��ĵ�ͼƬ����
     */
    private static final String UPDATE_FILES_PHOTO_TYPE_MOVE_LEFT = "moveLeft";
    private static final String UPDATE_FILES_PHOTO_TYPE_MOVE_RIGHT = "moveRight";
    private static final String UPDATE_FILES_PHOTO_TYPE_DELETE_PHOTO = "deletePhoto";
    private static final String UPDATE_FILES_PHOTO_TYPE_UPDATE_PHOTO = "updatePhoto";

    /**
     * �ĵ�ͼƬid
     */
    String filesPhotoId;
    /**
     * �޸��ĵ���Ƭ����
     */
    String updateFilesPhotoType;
    /**
     * �ĵ���Ƭ����
     */
    String photoDesc;
    /**
     * �ĵ�id
     */
    String filesId;

    /**
     * ���
     * @return
     */
    public String execute() throws Exception {
        logger.info("filesPhotoId=" + filesPhotoId + ",updateFilesPhotoType=" + updateFilesPhotoType +
                ",photoDesc=" + photoDesc);
        //���ĵ�ͼƬ
        int filesPhotoIdInt = Integer.parseInt(filesPhotoId);
        FilesPhoto filesPhoto = FilesPhotoDao.getFilesPhotoById(filesPhotoIdInt);
        if(null == filesPhoto){
            message = "�Ҳ������ĵ�ͼƬ(id=" + filesPhotoIdInt + ")��";
            return ERROR;
        }
        filesId = StringUtils.EMPTY + filesPhoto.getFilesId();
        Files files = FilesDao.getFilesById(filesPhoto.getFilesId());
        //���޸��ĵ���Ƭ����
        if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_MOVE_LEFT)){
            FilesPhoto leftOne = FilesPhotoDao.getLeftOne(filesPhoto);
            if(leftOne != null){
                int leftIndexId = leftOne.getIndexId();
                leftOne.setIndexId(filesPhoto.getIndexId());
                FilesPhotoDao.updateFilesPhoto(leftOne);
                filesPhoto.setIndexId(leftIndexId);
                FilesPhotoDao.updateFilesPhoto(filesPhoto);
            }
            message = "���Ƴɹ���";
            //����������־
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_MOVE_LEFT_FILES_PHOTO,
                    "���ĵ�[" + files.getName() + "]�����ĵ���Ƭ", date, time, getIp());
        } else if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_MOVE_RIGHT)){
            FilesPhoto rightOne = FilesPhotoDao.getRightOne(filesPhoto);
            if(rightOne != null){
                int rightIndexId = rightOne.getIndexId();
                rightOne.setIndexId(filesPhoto.getIndexId());
                FilesPhotoDao.updateFilesPhoto(rightOne);
                filesPhoto.setIndexId(rightIndexId);
                FilesPhotoDao.updateFilesPhoto(filesPhoto);
            }
            message = "���Ƴɹ���";
            //����������־
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_MOVE_RIGHT_FILES_PHOTO,
                    "���ĵ�[" + files.getName() + "]�����ĵ���Ƭ", date, time, getIp());

        } else if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_DELETE_PHOTO)){
            FilesPhotoDao.deleteFilesPhoto(filesPhoto);
            message = "ɾ���ɹ���";
            //����������־
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_DELETE_FILES_PHOTO,
                    "���ĵ�[" + files.getName() + "]ɾ���ĵ���Ƭ", date, time, getIp());
        } else if(StringUtils.equals(updateFilesPhotoType, UPDATE_FILES_PHOTO_TYPE_UPDATE_PHOTO)){
            filesPhoto.setPhotoDesc(photoDesc);
            FilesPhotoDao.updateFilesPhoto(filesPhoto);
            message = "�޸ĳɹ���";
            //����������־
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_UPDATE_FILES_PHOTO,
                    "���ĵ�[" + files.getName() + "]�޸��ĵ���Ƭ", date, time, getIp());
        } else {
            message = "��Ч������(" + updateFilesPhotoType + ")��";
            return ERROR;
        }
        //���ؽ��
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
