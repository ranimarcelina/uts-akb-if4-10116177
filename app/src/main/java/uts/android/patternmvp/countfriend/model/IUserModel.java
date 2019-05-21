package uts.android.patternmvp.countfriend.model;

import java.util.List;

import uts.android.patternmvp.countfriend.bean.UserBean;

public interface IUserModel {

    void insertUser(String nim, String nama, String kelas, String telepon, String email, String sosmed);
    void deleteUser(int position);
    void updateUser(int position, UserBean user);

    UserBean get(int position);

    List<UserBean> getAll();

    List<UserBean> getCacheList();
}
