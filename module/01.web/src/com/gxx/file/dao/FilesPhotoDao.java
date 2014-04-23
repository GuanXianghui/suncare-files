package com.gxx.file.dao;

import com.gxx.file.entities.Files;
import com.gxx.file.entities.FilesPhoto;
import com.gxx.file.interfaces.BaseInterface;
import com.gxx.file.utils.PropertyUtil;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * �ĵ���Ƭʵ�������
 *
 * @author Gxx
 * @module oa
 * @datetime 14-3-29 20:22
 */
public class FilesPhotoDao {
    /**
     * �����ĵ�id���ĵ���Ƭ
     *
     * @return
     * @throws Exception
     */
    public static List<FilesPhoto> queryFilesPhotos(int filesId) throws Exception {
        List<FilesPhoto> list = new ArrayList<FilesPhoto>();
        String sql = "SELECT id,photo_desc,photo,index_id FROM files_photo WHERE files_id=" + filesId +
                " order by index_id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ�������������ԣ�");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String photoDesc = rs.getString("photo_desc");
                String photo = rs.getString("photo");
                int indexId = rs.getInt("index_id");
                FilesPhoto filesPhoto = new FilesPhoto(id, filesId, photoDesc, photo, indexId);
                list.add(filesPhoto);
            }
            return list;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * ����id���ĵ���Ƭ
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static FilesPhoto getFilesPhotoById(int id) throws Exception {
        String sql = "SELECT files_id,photo_desc,photo,index_id FROM files_photo WHERE id=" + id + " order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ�������������ԣ�");
            }
            while (rs.next()) {
                int filesId = rs.getInt("files_id");
                String photoDesc = rs.getString("photo_desc");
                String photo = rs.getString("photo");
                int indexId = rs.getInt("index_id");
                FilesPhoto filesPhoto = new FilesPhoto(id, filesId, photoDesc, photo, indexId);
                return filesPhoto;
            }
            return null;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * �����ĵ�id��λ������id���ĵ���Ƭ
     *
     * @param filesId
     * @param indexId
     * @return
     * @throws Exception
     */
    public static FilesPhoto getFilesPhotoByFilesIdAndIndexID(int filesId, int indexId) throws Exception {
        String sql = "SELECT id,photo_desc,photo FROM files_photo WHERE files_id=" + filesId +
                " AND index_id=" + indexId + " order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ�������������ԣ�");
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String photoDesc = rs.getString("photo_desc");
                String photo = rs.getString("photo");
                FilesPhoto filesPhoto = new FilesPhoto(id, filesId, photoDesc, photo, indexId);
                return filesPhoto;
            }
            return null;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * �����ĵ�id������index_id
     *
     * @param filesId
     * @return
     * @throws Exception
     */
    public static int getMaxIndexIdByFilesId(int filesId) throws Exception {
        String sql = "SELECT max(index_id) max_index_id FROM files_photo WHERE files_id=" + filesId + " order by id";
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ�������������ԣ�");
            }
            int maxIndexId = 0;
            while (rs.next()) {
                maxIndexId = rs.getInt("max_index_id");
            }
            return maxIndexId;
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }
    }

    /**
     * �õ�����Ǹ��ĵ�ͼƬ
     * @param filesPhoto
     * @return
     */
    public static FilesPhoto getLeftOne(FilesPhoto filesPhoto) throws Exception{
        int maxIndexId = 0;
        String sql = "SELECT MAX(index_id) max_index_id FROM files_photo WHERE files_id=" + filesPhoto.getFilesId() +
                " AND index_id<" + filesPhoto.getIndexId();
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ�������������ԣ�");
            }
            while (rs.next()) {
                maxIndexId = rs.getInt("max_index_id");
            }
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }

        // ˵��û�������ĵ�ͼƬ
        if(maxIndexId == 0) {
            return null;
        }

        return getFilesPhotoByFilesIdAndIndexID(filesPhoto.getFilesId(), maxIndexId);
    }

    /**
     * �õ��ұ��Ǹ��ĵ�ͼƬ
     * @param filesPhoto
     * @return
     */
    public static FilesPhoto getRightOne(FilesPhoto filesPhoto) throws Exception{
        int minIndexId = 0;
        String sql = "SELECT MIN(index_id) min_index_id FROM files_photo WHERE files_id=" + filesPhoto.getFilesId() +
                " AND index_id>" + filesPhoto.getIndexId();
        Connection c = DB.getConn();
        Statement stmt = DB.createStatement(c);
        ResultSet rs = DB.executeQuery(c, stmt, sql);
        try {
            if (rs == null) {
                throw new RuntimeException("���ݿ�������������ԣ�");
            }
            while (rs.next()) {
                minIndexId = rs.getInt("min_index_id");
            }
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(c);
        }

        // ˵��û���Ҳ���ĵ�ͼƬ
        if(minIndexId == 0) {
            return null;
        }

        return getFilesPhotoByFilesIdAndIndexID(filesPhoto.getFilesId(), minIndexId);
    }

    /**
     * �����ĵ���Ƭ
     *
     * @param filesPhoto
     * @throws Exception
     */
    public static void insertFilesPhoto(FilesPhoto filesPhoto) throws Exception {
        String sql = "insert into files_photo" +
                "(id,files_id,photo_desc,photo,index_id)" +
                "values" +
                "(null," + filesPhoto.getFilesId() + ",'" + filesPhoto.getPhotoDesc() + "','" +
                filesPhoto.getPhoto() + "'," + filesPhoto.getIndexId() + ")";
        DB.executeUpdate(sql);
    }

    /**
     * �����ĵ���Ƭ
     *
     * @param filesPhoto
     * @throws Exception
     */
    public static void updateFilesPhoto(FilesPhoto filesPhoto) throws Exception {
        String sql = "update files_photo set photo_desc='" + filesPhoto.getPhotoDesc() + "',index_id=" +
                filesPhoto.getIndexId() + " where id=" + filesPhoto.getId();
        DB.executeUpdate(sql);
    }

    /**
     * ɾ���ĵ���Ƭ
     *
     * @param filesPhoto
     * @throws Exception
     */
    public static void deleteFilesPhoto(FilesPhoto filesPhoto) throws Exception {
        String sql = "delete from files_photo where id=" + filesPhoto.getId();
        DB.executeUpdate(sql);
    }
}
