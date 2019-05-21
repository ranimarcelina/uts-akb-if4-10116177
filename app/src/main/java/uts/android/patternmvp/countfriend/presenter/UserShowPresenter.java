package uts.android.patternmvp.countfriend.presenter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import uts.android.patternmvp.countfriend.R;
import uts.android.patternmvp.countfriend.bean.UserBean;
import uts.android.patternmvp.countfriend.model.IUserModel;
import uts.android.patternmvp.countfriend.model.UserModel;
import uts.android.patternmvp.countfriend.view.IUserShowView;
import uts.android.patternmvp.countfriend.view.adpter.MyArrayAdapter;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class UserShowPresenter {
    private IUserModel mUserModel;
    private IUserShowView mUserShowView;

    private Context context;
    private ArrayAdapter arrayAdapter;

    public UserShowPresenter(IUserShowView view, Context context) {
        this.context = context;
        mUserShowView = view;
        mUserModel = UserModel.getInstance(context);
    }

    public List<UserBean> getAllUser() {
        return mUserModel.getCacheList();
    }

    public ArrayAdapter getArrayAdapter() {
        arrayAdapter = new MyArrayAdapter(context, R.layout.lv_item, getAllUser());
        return arrayAdapter;
    }

    public void updateUserInfo() {
        arrayAdapter.notifyDataSetChanged();
    }

    public void del(int position) {
        mUserModel.deleteUser(position);
    }
}
