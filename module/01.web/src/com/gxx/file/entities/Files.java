package com.gxx.file.entities;

/**
 * 文档实体
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 18:21
 */
public class Files {
    int id;
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
     * 新增时使用
     *
     * @param name
     * @param fileNum
     * @param projectName
     * @param doorSeries
     * @param glassType
     * @param wind
     * @param air
     * @param water
     * @param temperature
     * @param voice
     * @param sun
     * @param perspective
     * @param dewPoint
     */
    public Files(String name, String fileNum, String projectName, String doorSeries, String glassType, String wind,
                 String air, String water, String temperature, String voice, String sun, String perspective,
                 String dewPoint) {
        this.name = name;
        this.fileNum = fileNum;
        this.projectName = projectName;
        this.doorSeries = doorSeries;
        this.glassType = glassType;
        this.wind = wind;
        this.air = air;
        this.water = water;
        this.temperature = temperature;
        this.voice = voice;
        this.sun = sun;
        this.perspective = perspective;
        this.dewPoint = dewPoint;
    }

    /**
     * 查询时使用
     *
     * @param id
     * @param name
     * @param fileNum
     * @param projectName
     * @param doorSeries
     * @param glassType
     * @param wind
     * @param air
     * @param water
     * @param temperature
     * @param voice
     * @param sun
     * @param perspective
     * @param dewPoint
     */
    public Files(int id, String name, String fileNum, String projectName, String doorSeries, String glassType,
                 String wind, String air, String water, String temperature, String voice, String sun, String perspective, String dewPoint) {
        this.id = id;
        this.name = name;
        this.fileNum = fileNum;
        this.projectName = projectName;
        this.doorSeries = doorSeries;
        this.glassType = glassType;
        this.wind = wind;
        this.air = air;
        this.water = water;
        this.temperature = temperature;
        this.voice = voice;
        this.sun = sun;
        this.perspective = perspective;
        this.dewPoint = dewPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
