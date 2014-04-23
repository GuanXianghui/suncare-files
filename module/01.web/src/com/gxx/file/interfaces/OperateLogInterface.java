package com.gxx.file.interfaces;

/**
 * 操作日志接口
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 13:16
 */
public interface OperateLogInterface extends BaseInterface {
    /**
     * 1:登陆 2:退出 3:新建用户 4:删除用户 5:新建文档 6:删除文档
     * 7:修改文档 8:上传图片 9:左移图片 10:右移图片 11:修改图片 12:删除图片
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
