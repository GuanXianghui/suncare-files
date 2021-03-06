package com.gxx.file.dao;

import com.gxx.file.entities.OperateLog;
import com.gxx.file.interfaces.BaseInterface;
import com.gxx.file.utils.PropertyUtil;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作日志实体操作类
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 20:22
 */
public class OperateLogDao {
    /**
     * 根据条件模糊查询操作日志
     *
     * @param userName
     * @param type
     * @param date
     * @param pageNum
     * @return
     * @throws Exception
     */
    public static List<OperateLog> queryOperateLogsByLike(String userName, int type, String date, int pageNum) throws Exception {
        //操作日志列表每页大小
        int pageSize = Integer.parseInt(PropertyUtil.getInstance().getProperty(BaseInterface.OPERATE_LOG_PAGE_SIZE));
        //操作日志集合
        List<OperateLog> list = new ArrayList<OperateLog>();
        //sql语句
        String sql = "SELECT id,user_name,type,content,date,time,ip FROM operate_log WHERE 1=1";
        //如果userName非空带上为条件
        if(StringUtils.isNotBlank(userName)){
            sql += " AND user_name LIKE '%" + userName + "%'";
        }
        //如果type>0带上为条件
        if(type > 0){
            sql += " AND type=" + type;
        }
        //如果date非空带上为条件
        if(StringUtils.isNotBlank(date)){
            sql += " AND date='" + date + "'";
        }
        sql += " ORDER BY id DESC LIMIT " + ((pageNum-1) * pageSize) + "," + pageSize;
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("数据库操作出错，请重试！");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String userName2 = rs.getString("user_name");
                int type2 = rs.getInt("type");
                String content = rs.getString("content");
                String date2 = rs.getString("date");
                String time = rs.getString("time");
                String ip = rs.getString("ip");
                OperateLog operateLog = new OperateLog(id, userName2, type2, content, date2, time, ip);
                list.add(operateLog);
            }
            return list;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * 根据条件模糊查询操作日志数量
     *
     * @param userName
     * @param type
     * @param date
     * @return
     * @throws Exception
     */
    public static int countOperateLogsByLike(String userName, int type, String date) throws Exception {
        //结果
        int count = 0;
        //sql语句
        String sql = "SELECT count(1) count_num FROM operate_log WHERE 1=1";
        //如果userName非空带上为条件
        if(StringUtils.isNotBlank(userName)){
            sql += " AND user_name LIKE '%" + userName + "%'";
        }
        //如果type>0带上为条件
        if(type > 0){
            sql += " AND type=" + type;
        }
        //如果date非空带上为条件
        if(StringUtils.isNotBlank(date)){
            sql += " AND date='" + date + "'";
        }
        sql += " ORDER BY id DESC";
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
     * 根据id查操作日志
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static OperateLog getOperateLogById(int id) throws Exception {
        String sql = "SELECT id,user_name,type,content,date,time,ip FROM operate_log WHERE id=" + id + " order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("数据库操作出错，请重试！");
            }
            while (rs.next()) {
                String userName = rs.getString("user_name");
                int type = rs.getInt("type");
                String content = rs.getString("content");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String ip = rs.getString("ip");
                OperateLog operateLog = new OperateLog(id, userName, type, content, date, time, ip);
                return operateLog;
            }
            return null;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * 新增操作日志
     *
     * @param operateLog
     * @throws Exception
     */
    public static void insertOperateLog(OperateLog operateLog) throws Exception {
        String sql = "insert into operate_log" +
                "(id,user_name,type,content,date,time,ip)" +
                "values" +
                "(null,'" + operateLog.getUserName() + "'," + operateLog.getType() + ",'" + operateLog.getContent() +
                "','" + operateLog.getDate() + "','" + operateLog.getTime() + "','" + operateLog.getIp() + "')";
        DB.executeUpdate(sql);
    }
}