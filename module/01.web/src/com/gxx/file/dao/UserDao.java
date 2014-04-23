package com.gxx.file.dao;

import com.gxx.file.entities.User;
import com.gxx.file.interfaces.BaseInterface;
import com.gxx.file.utils.BaseUtil;
import com.gxx.file.utils.PropertyUtil;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * �û�ʵ�������
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 20:22
 */
public class UserDao {
    /**
     * ��ѯ�����û�
     *
     * @return
     * @throws Exception
     */
    public static List<User> queryAllUsers() throws Exception {
        List<User> list = new ArrayList<User>();
        String sql = "SELECT id,name,password FROM user order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ���������������ԣ�");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                User user = new User(id, name, password);
                list.add(user);
            }
            return list;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * ��������ģ����ѯ�û�
     *
     * @param name
     * @param pageNum
     * @return
     * @throws Exception
     */
    public static List<User> queryUsersByLikeName(String name, int pageNum) throws Exception {
        //�û��б�ÿҳ��С
        int pageSize = Integer.parseInt(PropertyUtil.getInstance().getProperty(BaseInterface.USER_PAGE_SIZE));
        //�û�����
        List<User> list = new ArrayList<User>();
        //sql���
        String sql = "SELECT id,name,password FROM user";
        //���name�ǿմ���Ϊ����
        if(StringUtils.isNotBlank(name)){
            sql += " WHERE name LIKE '%" + name + "%'";
        }
        sql += " ORDER BY id LIMIT " + ((pageNum-1) * pageSize) + "," + pageSize;
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ���������������ԣ�");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String newName = rs.getString("name");
                String password = rs.getString("password");
                User user = new User(id, newName, password);
                list.add(user);
            }
            return list;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * ��������ģ����ѯ�û�����
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static int countUsersByLikeName(String name) throws Exception {
        //���
        int count = 0;
        //sql���
        String sql = "SELECT count(1) count_num FROM user";
        //���name�ǿմ���Ϊ����
        if(StringUtils.isNotBlank(name)){
            sql += " WHERE name LIKE '%" + name + "%'";
        }
        sql += " ORDER BY id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ���������������ԣ�");
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
     * ����id���û�
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static User getUserById(int id) throws Exception {
        String sql = "SELECT name,password FROM user WHERE id=" + id + " order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ���������������ԣ�");
            }
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                User user = new User(id, name, password);
                return user;
            }
            return null;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * �����������û�
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static User getUserByName(String name) throws Exception {
        String sql = "SELECT id,password FROM user WHERE name='" + name + "' order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ���������������ԣ�");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                User user = new User(id, name, password);
                return user;
            }
            return null;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * �и������Ƿ��Ѵ���
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static boolean isNameExist(String name) throws Exception {
        User user = getUserByName(name);
        return user != null;
    }

    /**
     * �����û�
     *
     * @param user
     * @throws Exception
     */
    public static void insertUser(User user) throws Exception {
        String sql = "insert into user" +
                "(id,name,password)" +
                "values" +
                "(null,'" + user.getName() + "','" + user.getPassword() + "')";
        DB.executeUpdate(sql);
    }

    /**
     * �����û�����
     *
     * @param user
     * @throws Exception
     */
    public static void updateUserPassword(User user) throws Exception {
        String sql = "update user set password='" + user.getPassword() + "' where id=" + user.getId();
        DB.executeUpdate(sql);
    }

    /**
     * ɾ���û�
     *
     * @param user
     * @throws Exception
     */
    public static void deleteUser(User user) throws Exception {
        String sql = "delete from user where id=" + user.getId();
        DB.executeUpdate(sql);
    }
}