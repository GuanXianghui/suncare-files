package com.gxx.file;

import com.gxx.file.dao.FilesDao;
import com.gxx.file.entities.Files;
import com.gxx.file.interfaces.OperateLogInterface;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.TokenUtil;
import org.apache.commons.lang.StringUtils;

/**
 * �޸��ĵ�Action
 *
 * @author Gxx
 * @module oa
 * @datetime 14-4-18 15:22
 */
public class UpdateFilesAction extends BaseAction {
    /**
     * �ĵ�id
     */
    String filesId;
    String name;
    String fileNum;
    String projectName;
    String doorSeries;
    String glassType;
    String wind;
    String air;
    String water;
    String temperature;
    String voice;
    String sun;
    String perspective;
    String dewPoint;

    /**
     * ���
     * @return
     */
    public String execute() throws Exception {
        logger.info("filesId:" + filesId + ",name=" + name + ",fileNum=" + fileNum + ",projectName=" +
                projectName + ",doorSeries=" + doorSeries + ",glassType=" + glassType + ",wind=" + wind +
                ",air=" + air + ",water=" + water + ",temperature=" + temperature + ",voice=" + voice +
                ",sun=" + sun + ",perspective=" + perspective + ",dewPoint=" + dewPoint);
        //���ؽ��
        String resp;
        //�ĵ�id
        int filesIdInt;
        try{
            filesIdInt = Integer.parseInt(filesId);
        } catch (Exception e){
            resp = "{isSuccess:false,message:'�ĵ�id���Ϸ���',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            write(resp);
            return null;
        }
        //��ѯ�ĵ�
        Files files = FilesDao.getFilesById(filesIdInt);
        if(null == files){
            resp = "{isSuccess:false,message:'�ĵ�id�����ڣ�',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            write(resp);
            return null;
        }

        if(!StringUtils.equals(files.getName(),name) && FilesDao.isNameExist(name)){
            resp = "{isSuccess:false,message:'���ĵ������Ѵ��ڣ�',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
        } else {
            files.setName(name);
            files.setFileNum(fileNum);
            files.setProjectName(projectName);
            files.setDoorSeries(doorSeries);
            files.setGlassType(glassType);
            files.setWind(wind);
            files.setAir(air);
            files.setWater(water);
            files.setTemperature(temperature);
            files.setVoice(voice);
            files.setSun(sun);
            files.setPerspective(perspective);
            files.setDewPoint(dewPoint);
            FilesDao.updateFiles(files);
            resp = "{isSuccess:true,message:'�޸��ĵ��ɹ���',hasNewToken:true,token:'" +
                    TokenUtil.createToken(request) + "'}";
            //����������־
            BaseUtil.createOperateLog(getUser().getName(), OperateLogInterface.TYPE_UPDATE_FILES,
                    "�޸��ĵ�[" + name + "]", date, time, getIp());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDoorSeries() {
        return doorSeries;
    }

    public void setDoorSeries(String doorSeries) {
        this.doorSeries = doorSeries;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getPerspective() {
        return perspective;
    }

    public void setPerspective(String perspective) {
        this.perspective = perspective;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }
}
