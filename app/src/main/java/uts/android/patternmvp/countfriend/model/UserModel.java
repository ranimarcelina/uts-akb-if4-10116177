package uts.android.patternmvp.countfriend.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import uts.android.patternmvp.countfriend.bean.UserBean;
import uts.android.patternmvp.countfriend.db.DbOpenHelper;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class UserModel implements IUserModel {

    private static UserModel instanse;

    private DbOpenHelper helper;
    private List<UserBean> userInfos;

    public static UserModel getInstance(Context context) {
        if (instanse == null) {
            instanse = new UserModel(context);
        }
        return instanse;
    }

    public static UserModel getInstance() {
        return instanse;
    }

    private UserModel(Context context) {
        helper = new DbOpenHelper(context);
        userInfos = getAll();
    }

    @Override
    public void insertUser(String nim, String nama, String kelas, String telepon, String email, String sosmed) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into contact (nim, nama, kelas, telepon, email, sosmed) values (?,?,?,?,?,?)", new String[]{nim, nama, kelas, telepon, email, sosmed});
        db.close();
        userInfos.add(new UserBean(nim, nama, kelas, telepon, email, sosmed));
    }

    @Override
    public void deleteUser(int position) {
        UserBean user = userInfos.get(position);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from contact where telepon = ?", new String[]{user.getTelepon()});
        db.close();
        userInfos.remove(position);
    }

    @Override
    public void updateUser(int position, UserBean bean) {
        UserBean user = userInfos.get(position);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update contact set nim = ?, nama = ?, kelas = ?, email = ?, sosmed = ? where telepon = ?",
                new String[]{ bean.getNim(), bean.getNama(), bean.getKelas(), bean.getTelepon(), bean.getEmail(), bean.getSosmed(), user.getTelepon()});
        db.close();
        userInfos.set(position, bean);
    }

    @Override
    public UserBean get(int position) {
        return userInfos.get(position);
    }

    @Override
    public List<UserBean> getAll() {
        List<UserBean> users = new ArrayList<>();
        UserBean userInfo = null;
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from contact", null);
        while (true) {
            if (!cursor.moveToNext()) {
                break;
            }
            userInfo = new UserBean(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
            users.add(userInfo);
        }
        return users;
    }

    @Override
    public List<UserBean> getCacheList() {
        return userInfos;
    }


}
