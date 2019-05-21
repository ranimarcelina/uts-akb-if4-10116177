package uts.android.patternmvp.countfriend.presenter;

import uts.android.patternmvp.countfriend.bean.UserBean;
import uts.android.patternmvp.countfriend.model.IUserModel;
import uts.android.patternmvp.countfriend.model.UserModel;
import uts.android.patternmvp.countfriend.view.IUserAddView;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class UserAddPresenter {
    private IUserAddView mUserAddView;
    private IUserModel mUserModel;

    public UserAddPresenter(IUserAddView view) {
        mUserAddView = view;
        mUserModel = UserModel.getInstance();
    }

    public void insertUser(){
        mUserModel.insertUser(mUserAddView.getNim(), mUserAddView.getNama(),mUserAddView.getKelas(), mUserAddView.getTelepon(),mUserAddView.getEmail(), mUserAddView.getSosmed());
    }

    public UserBean getUser(int position) {
        return mUserModel.get(position);
    }

    public void updateUser() {
        UserBean bean = new UserBean();
        bean.setNim(mUserAddView.getNim());
        bean.setNama(mUserAddView.getNama());
        bean.setKelas(mUserAddView.getKelas());
        bean.setTelepon(mUserAddView.getTelepon());
        bean.setEmail(mUserAddView.getEmail());
        bean.setSosmed(mUserAddView.getSosmed());
        mUserModel.updateUser(mUserAddView.getUpdatePos(), bean);
    }

    public void showCurrent() {
        UserBean bean = mUserModel.get(mUserAddView.getUpdatePos());
        mUserAddView.setNim(bean.getNim());
        mUserAddView.setNama(bean.getNama());
        mUserAddView.setKelas(bean.getKelas());
        mUserAddView.setTelepon(bean.getTelepon());
        mUserAddView.setEmail(bean.getEmail());
        mUserAddView.setSosmed(bean.getSosmed());
    }
}
