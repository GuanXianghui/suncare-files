package com.gxx.file.entities;

/**
 * �û�ʵ��
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 18:21
 */
public class User {
    int id;
    String name;
    String password;

    /**
     * ����ʱʹ��
     * @param name
     * @param password
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * ��ѯʱʹ��
     * @param id
     * @param name
     * @param password
     */
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
