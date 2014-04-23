package com.gxx.file.entities;

/**
 * �ĵ���Ƭʵ��
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 18:21
 */
public class FilesPhoto {
    int id;
    int filesId;
    String photoDesc;
    String photo;
    int indexId;

    /**
     * ����ʱʹ��
     *
     * @param filesId
     * @param photoDesc
     * @param photo
     * @param indexId
     */
    public FilesPhoto(int filesId, String photoDesc, String photo, int indexId) {
        this.filesId = filesId;
        this.photoDesc = photoDesc;
        this.photo = photo;
        this.indexId = indexId;
    }

    /**
     * ��ѯʱʹ��
     *
     * @param id
     * @param filesId
     * @param photoDesc
     * @param photo
     * @param indexId
     */
    public FilesPhoto(int id, int filesId, String photoDesc, String photo, int indexId) {
        this.id = id;
        this.filesId = filesId;
        this.photoDesc = photoDesc;
        this.photo = photo;
        this.indexId = indexId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilesId() {
        return filesId;
    }

    public void setFilesId(int filesId) {
        this.filesId = filesId;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getIndexId() {
        return indexId;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }
}
