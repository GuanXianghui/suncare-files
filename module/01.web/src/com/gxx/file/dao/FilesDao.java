package com.gxx.file.dao;

import com.gxx.file.entities.Files;
import com.gxx.file.entities.User;
import com.gxx.file.interfaces.BaseInterface;
import com.gxx.file.utils.PropertyUtil;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 文档实体操作类
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 20:22
 */
public class FilesDao {
    /**
     * 查询所有文档
     *
     * @return
     * @throws Exception
     */
    public static List<Files> queryAllFiles() throws Exception {
        List<Files> list = new ArrayList<Files>();
        String sql = "SELECT id,name,file_num,project_name,door_series,glass_type,wind,air,water," +
                "temperature,voice,sun,perspective,dew_point FROM files order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("数据库操作出错，请重试！");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String fileNum = rs.getString("file_num");
                String projectName = rs.getString("project_name");
                String doorSeries = rs.getString("door_series");
                String glassType = rs.getString("glass_type");
                String wind = rs.getString("wind");
                String air = rs.getString("air");
                String water = rs.getString("water");
                String temperature = rs.getString("temperature");
                String voice = rs.getString("voice");
                String sun = rs.getString("sun");
                String perspective = rs.getString("perspective");
                String dewPoint = rs.getString("dew_point");
                Files files = new Files(id, name, fileNum, projectName, doorSeries, glassType, wind, air, water,
                        temperature, voice, sun, perspective, dewPoint);
                list.add(files);
            }
            return list;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * 根据名字，各个列模糊查询文档
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
     * @param pageNum
     * @return
     * @throws Exception
     */
    public static List<Files> queryFilesByLikeColumns(String name, String fileNum, String projectName,
                                                      String doorSeries, String glassType, String wind, String air,
                                                      String water, String temperature, String voice, String sun,
                                                      String perspective, String dewPoint, int pageNum) throws Exception {
        //用户列表每页大小
        int pageSize = Integer.parseInt(PropertyUtil.getInstance().getProperty(BaseInterface.FILES_PAGE_SIZE));
        List<Files> list = new ArrayList<Files>();
        String sql = "SELECT id,name,file_num,project_name,door_series,glass_type,wind,air,water," +
                "temperature,voice,sun,perspective,dew_point FROM files WHERE 1=1";
        //如果name非空带上为条件
        if(StringUtils.isNotBlank(name)){
            sql += " AND name LIKE '%" + name + "%'";
        }
        //如果fileNum非空带上为条件
        if(StringUtils.isNotBlank(fileNum)){
            sql += " AND file_num LIKE '%" + fileNum + "%'";
        }
        //如果projectName非空带上为条件
        if(StringUtils.isNotBlank(projectName)){
            sql += " AND project_name LIKE '%" + projectName + "%'";
        }
        //如果doorSeries非空带上为条件
        if(StringUtils.isNotBlank(doorSeries)){
            sql += " AND door_series LIKE '%" + doorSeries + "%'";
        }
        //如果glassType非空带上为条件
        if(StringUtils.isNotBlank(glassType)){
            sql += " AND glass_type LIKE '%" + glassType + "%'";
        }
        //如果wind非空带上为条件
        if(StringUtils.isNotBlank(wind)){
            sql += " AND wind LIKE '%" + wind + "%'";
        }
        //如果air非空带上为条件
        if(StringUtils.isNotBlank(air)){
            sql += " AND air LIKE '%" + air + "%'";
        }
        //如果water非空带上为条件
        if(StringUtils.isNotBlank(water)){
            sql += " AND water LIKE '%" + water + "%'";
        }
        //如果temperature非空带上为条件
        if(StringUtils.isNotBlank(temperature)){
            sql += " AND temperature LIKE '%" + temperature + "%'";
        }
        //如果voice非空带上为条件
        if(StringUtils.isNotBlank(voice)){
            sql += " AND voice LIKE '%" + voice + "%'";
        }
        //如果sun非空带上为条件
        if(StringUtils.isNotBlank(sun)){
            sql += " AND sun LIKE '%" + sun + "%'";
        }
        //如果perspective非空带上为条件
        if(StringUtils.isNotBlank(perspective)){
            sql += " AND perspective LIKE '%" + perspective + "%'";
        }
        //如果dewPoint非空带上为条件
        if(StringUtils.isNotBlank(dewPoint)){
            sql += " AND dew_point LIKE '%" + dewPoint + "%'";
        }
        sql += " order by id limit " + ((pageNum-1) * pageSize) + "," + pageSize;
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("数据库操作出错，请重试！");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String name2 = rs.getString("name");
                String fileNum2 = rs.getString("file_num");
                String projectName2 = rs.getString("project_name");
                String doorSeries2 = rs.getString("door_series");
                String glassType2 = rs.getString("glass_type");
                String wind2 = rs.getString("wind");
                String air2 = rs.getString("air");
                String water2 = rs.getString("water");
                String temperature2 = rs.getString("temperature");
                String voice2 = rs.getString("voice");
                String sun2 = rs.getString("sun");
                String perspective2 = rs.getString("perspective");
                String dewPoint2 = rs.getString("dew_point");
                Files files = new Files(id, name2, fileNum2, projectName2, doorSeries2, glassType2, wind2, air2, water2,
                        temperature2, voice2, sun2, perspective2, dewPoint2);
                list.add(files);
            }
            return list;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * 根据名字，各个列模糊查询文档数量
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
     * @return
     * @throws Exception
     */
    public static int countFilesByLikeColumns(String name, String fileNum, String projectName, String doorSeries,
                                              String glassType, String wind, String air, String water,
                                              String temperature, String voice, String sun, String perspective,
                                              String dewPoint) throws Exception {
        //结果
        int count = 0;
        //sql语句
        String sql = "SELECT count(1) count_num FROM files WHERE 1=1";
        //如果name非空带上为条件
        if(StringUtils.isNotBlank(name)){
            sql += " AND name LIKE '%" + name + "%'";
        }
        //如果fileNum非空带上为条件
        if(StringUtils.isNotBlank(fileNum)){
            sql += " AND file_num LIKE '%" + fileNum + "%'";
        }
        //如果projectName非空带上为条件
        if(StringUtils.isNotBlank(projectName)){
            sql += " AND project_name LIKE '%" + projectName + "%'";
        }
        //如果doorSeries非空带上为条件
        if(StringUtils.isNotBlank(doorSeries)){
            sql += " AND door_series LIKE '%" + doorSeries + "%'";
        }
        //如果glassType非空带上为条件
        if(StringUtils.isNotBlank(glassType)){
            sql += " AND glass_type LIKE '%" + glassType + "%'";
        }
        //如果wind非空带上为条件
        if(StringUtils.isNotBlank(wind)){
            sql += " AND wind LIKE '%" + wind + "%'";
        }
        //如果air非空带上为条件
        if(StringUtils.isNotBlank(air)){
            sql += " AND air LIKE '%" + air + "%'";
        }
        //如果water非空带上为条件
        if(StringUtils.isNotBlank(water)){
            sql += " AND water LIKE '%" + water + "%'";
        }
        //如果temperature非空带上为条件
        if(StringUtils.isNotBlank(temperature)){
            sql += " AND temperature LIKE '%" + temperature + "%'";
        }
        //如果voice非空带上为条件
        if(StringUtils.isNotBlank(voice)){
            sql += " AND voice LIKE '%" + voice + "%'";
        }
        //如果sun非空带上为条件
        if(StringUtils.isNotBlank(sun)){
            sql += " AND sun LIKE '%" + sun + "%'";
        }
        //如果perspective非空带上为条件
        if(StringUtils.isNotBlank(perspective)){
            sql += " AND perspective LIKE '%" + perspective + "%'";
        }
        //如果dewPoint非空带上为条件
        if(StringUtils.isNotBlank(dewPoint)){
            sql += " AND dew_point LIKE '%" + dewPoint + "%'";
        }

        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("数据库操作出错，请重试！");
            }
            while (rs.next()) {
                count = rs.getInt("count_num");
            }
            return count;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * 根据id查文档
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static Files getFilesById(int id) throws Exception {
        String sql = "SELECT id,name,file_num,project_name,door_series,glass_type,wind,air,water," +
                "temperature,voice,sun,perspective,dew_point FROM files WHERE id=" + id + " order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("数据库操作出错，请重试！");
            }
            while (rs.next()) {
                String name = rs.getString("name");
                String fileNum = rs.getString("file_num");
                String projectName = rs.getString("project_name");
                String doorSeries = rs.getString("door_series");
                String glassType = rs.getString("glass_type");
                String wind = rs.getString("wind");
                String air = rs.getString("air");
                String water = rs.getString("water");
                String temperature = rs.getString("temperature");
                String voice = rs.getString("voice");
                String sun = rs.getString("sun");
                String perspective = rs.getString("perspective");
                String dewPoint = rs.getString("dew_point");
                Files files = new Files(id, name, fileNum, projectName, doorSeries, glassType, wind, air, water,
                        temperature, voice, sun, perspective, dewPoint);
                return files;
            }
            return null;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * 根据姓名查文档
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static Files getFilesByName(String name) throws Exception {
        String sql = "SELECT id,name,file_num,project_name,door_series,glass_type,wind,air,water," +
                "temperature,voice,sun,perspective,dew_point FROM files WHERE name='" + name + "' order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("数据库操作出错，请重试！");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String fileNum = rs.getString("file_num");
                String projectName = rs.getString("project_name");
                String doorSeries = rs.getString("door_series");
                String glassType = rs.getString("glass_type");
                String wind = rs.getString("wind");
                String air = rs.getString("air");
                String water = rs.getString("water");
                String temperature = rs.getString("temperature");
                String voice = rs.getString("voice");
                String sun = rs.getString("sun");
                String perspective = rs.getString("perspective");
                String dewPoint = rs.getString("dew_point");
                Files files = new Files(id, name, fileNum, projectName, doorSeries, glassType, wind, air, water,
                        temperature, voice, sun, perspective, dewPoint);
                return files;
            }
            return null;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * 判该名字是否已存在
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static boolean isNameExist(String name) throws Exception {
        Files files = getFilesByName(name);
        return files != null;
    }

    /**
     * 新增文档
     *
     * @param files
     * @throws Exception
     */
    public static void insertFiles(Files files) throws Exception {
        String sql = "insert into files" +
                "(id,name,file_num,project_name,door_series,glass_type,wind,air,water," +
                "temperature,voice,sun,perspective,dew_point)" +
                "values" +
                "(null,'" + files.getName() + "','" + files.getFileNum() + "','" + files.getProjectName() + "','" +
                files.getDoorSeries() + "','" + files.getGlassType() + "','" + files.getWind() + "','" +
                files.getAir() + "','" + files.getWater() + "','" + files.getTemperature() + "','" +
                files.getVoice() + "','" + files.getSun() + "','" + files.getPerspective() + "','" +
                files.getDewPoint()+ "')";
        DB.executeUpdate(sql);
    }

    /**
     * 更新文档
     *
     * @param files
     * @throws Exception
     */
    public static void updateFiles(Files files) throws Exception {
        String sql = "update files set name='" + files.getName() + "',file_num='" + files.getFileNum() +
                "',project_name='" + files.getProjectName() + "',door_series='" + files.getDoorSeries() +
                "',glass_type='" + files.getGlassType() + "',wind='" + files.getWind() +
                "',air='" + files.getAir() + "',water='" + files.getWater() +
                "',temperature='" + files.getTemperature() + "',voice='" + files.getVoice() +
                "',sun='" + files.getSun() + "',perspective='" + files.getPerspective() +
                "',dew_point='" + files.getDewPoint() + "' where id=" + files.getId();
        DB.executeUpdate(sql);
    }

    /**
     * 删除文档
     *
     * @param files
     * @throws Exception
     */
    public static void deleteFiles(Files files) throws Exception {
        String sql = "delete from files where id=" + files.getId();
        DB.executeUpdate(sql);
    }
}
