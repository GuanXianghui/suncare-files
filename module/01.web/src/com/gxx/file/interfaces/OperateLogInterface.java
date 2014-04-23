package com.gxx.file.interfaces;

/**
 * ������־�ӿ�
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 13:16
 */
public interface OperateLogInterface extends BaseInterface {
    /**
     * 1:��½ 2:�˳� 3:�½��û� 4:ɾ���û� 5:�½��ĵ� 6:ɾ���ĵ�
     * 7:�޸��ĵ� 8:�ϴ�ͼƬ 9:����ͼƬ 10:����ͼƬ 11:�޸�ͼƬ 12:ɾ��ͼƬ
     */
    public static final int TYPE_LOG_IN = 1;
    public static final int TYPE_LOG_OUT = 2;
    public static final int TYPE_CREATE_USER = 3;
    public static final int TYPE_DELETE_USER = 4;
    public static final int TYPE_CREATE_FILES = 5;
    public static final int TYPE_DELETE_FILES = 6;
    public static final int TYPE_UPDATE_FILES = 7;
    public static final int TYPE_UPLOAD_FILES_PHOTO = 8;
    public static final int TYPE_MOVE_LEFT_FILES_PHOTO = 9;
    public static final int TYPE_MOVE_RIGHT_FILES_PHOTO = 10;
    public static final int TYPE_UPDATE_FILES_PHOTO = 11;
    public static final int TYPE_DELETE_FILES_PHOTO = 12;
}
