package com.gxx.file.entities;

import com.gxx.file.interfaces.OperateLogInterface;
import org.apache.commons.lang.StringUtils;

/**
 * ������־ʵ��
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 18:21
 */
public class OperateLog implements OperateLogInterface {
    int id;
    String userName;
    int type;
    String content;
    String date;
    String time;
    String ip;

    /**
     * ����ʱʹ��
     * @param userName
     * @param type
     * @param content
     * @param date
     * @param time
     * @param ip
     */
    public OperateLog(String userName, int type, String content, String date, String time, String ip) {
        this.userName = userName;
        this.type = type;
        this.content = content;
        this.date = date;
        this.time = time;
        this.ip = ip;
    }

    /**
     * ��ѯʱʹ��
     * @param id
     * @param userName
     * @param type
     * @param content
     * @param date
     * @param time
     * @param ip
     */
    public OperateLog(int id, String userName, int type, String content, String date, String time, String ip) {
        this.id = id;
        this.userName = userName;
        this.type = type;
        this.content = content;
        this.date = date;
        this.time = time;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * ���ز�����������
     *
     * @return
     */
    public String getTypeDesc(){
        String typeDesc = StringUtils.EMPTY;
        if(type == TYPE_LOG_IN){
            typeDesc = "��½";
        } else if(type == TYPE_LOG_OUT){
            typeDesc = "�˳�";
        } else if(type == TYPE_CREATE_USER){
            typeDesc = "�½��û�";
        } else if(type == TYPE_DELETE_USER){
            typeDesc = "ɾ���û�";
        } else if(type == TYPE_CREATE_FILES){
            typeDesc = "�½��ĵ�";
        } else if(type == TYPE_DELETE_FILES){
            typeDesc = "ɾ���ĵ�";
        } else if(type == TYPE_UPDATE_FILES){
            typeDesc = "�޸��ĵ�";
        } else if(type == TYPE_UPLOAD_FILES_PHOTO){
            typeDesc = "�ϴ�ͼƬ";
        } else if(type == TYPE_MOVE_LEFT_FILES_PHOTO){
            typeDesc = "����ͼƬ";
        } else if(type == TYPE_MOVE_RIGHT_FILES_PHOTO){
            typeDesc = "����ͼƬ";
        } else if(type == TYPE_UPDATE_FILES_PHOTO){
            typeDesc = "�޸�ͼƬ";
        } else if(type == TYPE_DELETE_FILES_PHOTO){
            typeDesc = "ɾ��ͼƬ";
        }
        return typeDesc;
    }
}
