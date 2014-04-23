package com.gxx.file;

import com.gxx.file.dao.FilesDao;
import com.gxx.file.dao.FilesPhotoDao;
import com.gxx.file.entities.Files;
import com.gxx.file.entities.FilesPhoto;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.FileUtil;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * �ϴ��ĵ���ƬAction
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class UploadFilesPhotoAction extends BaseAction {
    /**
     * �ĵ�id
     */
    String filesId;
    /**
     * �ĵ���Ƭ����
     */
    String photoDesc;
    /**
     * �ĵ���Ƭ
     */
    File photo1;
    File photo2;
    File photo3;
    File photo4;
    File photo5;
    File photo6;
    File photo7;
    File photo8;
    File photo9;
    File photo10;
    File photo11;
    File photo12;
    File photo13;
    File photo14;
    File photo15;

    /**
     * ���
     * @return
     */
    public String execute() throws Exception {
        logger.info("filesId=" + filesId + ",photoDesc=" + photoDesc + ",photo1=" + photo1 + ",photo2=" + photo2
                + ",photo3=" + photo3 + ",photo4=" + photo4 + ",photo5=" + photo5 + ",photo6=" + photo6
                + ",photo7=" + photo7 + ",photo8=" + photo8 + ",photo9=" + photo9 + ",photo10=" + photo10
                + ",photo11=" + photo11 + ",photo12=" + photo12 + ",photo13=" + photo13 + ",photo14=" + photo14
                + ",photo15=" + photo15);
        //���ļ�Ϊ��
        if(null == photo1 && null == photo2 && null == photo3 && null == photo4 && null == photo5 && null == photo6
                && null == photo7 && null == photo8 && null == photo9 && null == photo10 && null == photo11
                && null == photo12 && null == photo13 && null == photo14 && null == photo15)
        {
            message = "������δ�յ�ͼƬ!";
            return ERROR;
        }

        List<File> photos = new ArrayList<File>();
        photos.add(photo1);
        photos.add(photo2);
        photos.add(photo3);
        photos.add(photo4);
        photos.add(photo5);
        photos.add(photo6);
        photos.add(photo7);
        photos.add(photo8);
        photos.add(photo9);
        photos.add(photo10);
        photos.add(photo11);
        photos.add(photo12);
        photos.add(photo13);
        photos.add(photo14);
        photos.add(photo15);

        //�ĵ�id
        int filesIdInt = Integer.parseInt(filesId);
        //�ϴ���Ƭ����
        int count = 0;
        for(int i=0;i<15;i++){
            File photo = photos.get(i);
            //Ϊ�ղ���
            if(photo == null){
                continue;
            }
            count ++;
            //�µ�ͼƬ����
            String photoName = getUser().getId() + "_" + new Date().getTime() + "_" + (i+1) + ".jpg";
            //�����ڵ��ļ���
            String dir = ServletActionContext.getServletContext().getRealPath("upload/files/photo") + "/" + date + "/";
            //��������ڸ�Ŀ¼ ����Ŀ¼
            FileUtil.makeDir(dir);
            //�������ϵ�·��
            String photoPath = dir + photoName;
            //ҳ������λ�� ���·��
            String photoPagePath = "upload/files/photo/" + date + "/" + photoName;
            //�������ϵ�·����Ӧ���ļ�
            File imageFile = new File(photoPath);
            //�����ļ�
            FileUtil.copy(photo, imageFile);

            //λ����Ӱid
            int indexId = FilesPhotoDao.getMaxIndexIdByFilesId(filesIdInt) + 1;
            //�ĵ���Ƭ
            FilesPhoto filesPhoto = new FilesPhoto(filesIdInt, photoDesc, photoPagePath, indexId);
            //�����ĵ���Ƭ
            FilesPhotoDao.insertFilesPhoto(filesPhoto);
        }
        //�ĵ�
        Files files = FilesDao.getFilesById(filesIdInt);
        //����������־
        BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_UPLOAD_FILES_PHOTO,
                "���ĵ�[" + files.getName() + "]�ϴ�" + count + "���ĵ���Ƭ", date, time, getIp());

        //���ؽ��
        message = "�ϴ��ĵ���Ƭ�ɹ���";
        return SUCCESS;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    public File getPhoto1() {
        return photo1;
    }

    public void setPhoto1(File photo1) {
        this.photo1 = photo1;
    }

    public File getPhoto2() {
        return photo2;
    }

    public void setPhoto2(File photo2) {
        this.photo2 = photo2;
    }

    public File getPhoto3() {
        return photo3;
    }

    public void setPhoto3(File photo3) {
        this.photo3 = photo3;
    }

    public File getPhoto4() {
        return photo4;
    }

    public void setPhoto4(File photo4) {
        this.photo4 = photo4;
    }

    public File getPhoto5() {
        return photo5;
    }

    public void setPhoto5(File photo5) {
        this.photo5 = photo5;
    }

    public File getPhoto6() {
        return photo6;
    }

    public void setPhoto6(File photo6) {
        this.photo6 = photo6;
    }

    public File getPhoto7() {
        return photo7;
    }

    public void setPhoto7(File photo7) {
        this.photo7 = photo7;
    }

    public File getPhoto8() {
        return photo8;
    }

    public void setPhoto8(File photo8) {
        this.photo8 = photo8;
    }

    public File getPhoto9() {
        return photo9;
    }

    public void setPhoto9(File photo9) {
        this.photo9 = photo9;
    }

    public File getPhoto10() {
        return photo10;
    }

    public void setPhoto10(File photo10) {
        this.photo10 = photo10;
    }

    public File getPhoto11() {
        return photo11;
    }

    public void setPhoto11(File photo11) {
        this.photo11 = photo11;
    }

    public File getPhoto12() {
        return photo12;
    }

    public void setPhoto12(File photo12) {
        this.photo12 = photo12;
    }

    public File getPhoto13() {
        return photo13;
    }

    public void setPhoto13(File photo13) {
        this.photo13 = photo13;
    }

    public File getPhoto14() {
        return photo14;
    }

    public void setPhoto14(File photo14) {
        this.photo14 = photo14;
    }

    public File getPhoto15() {
        return photo15;
    }

    public void setPhoto15(File photo15) {
        this.photo15 = photo15;
    }
}
