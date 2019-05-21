package uts.android.patternmvp.countfriend.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

import butterknife.OnClick;
import uts.android.patternmvp.countfriend.R;
import uts.android.patternmvp.countfriend.presenter.UserShowPresenter;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class UserShowActivity extends AppCompatActivity implements IUserShowView {

    UserShowPresenter presenter;

    @BindView(R.id.lv_item)
    ListView userinfoLv;

    @OnClick(R.id.ib_add)

    void addUser() {
        toAddActivity();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_show);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setLogo(R.drawable.logo);
            actionBar.setTitle("Contact List");
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        presenter = new UserShowPresenter(this, this);
        userinfoLv.setAdapter(presenter.getArrayAdapter());
        userinfoLv.setOnItemClickListener(new MyOnItemClickListener());
    }

    @Override
    public void showUserInfo() {
        presenter.updateUserInfo();
    }

    @Override
    public void toAddActivity() {
        Intent i = new Intent(UserShowActivity.this, UserAddActivity.class);
        startActivity(i);
    }

    @Override
    public void toEditActivity(int position) {
        Intent i = new Intent(UserShowActivity.this, UserAddActivity.class);
        i.putExtra("isUpdate", true);
        i.putExtra("position", position);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showUserInfo();
    }

    class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            AlertDialog.Builder adBuilder = new AlertDialog.Builder(UserShowActivity.this);
            adBuilder
                    .setMessage("Please select an operation")
                    .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            presenter.del(position);
                            presenter.updateUserInfo();
                        }
                    })
                    .setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            toEditActivity(position);
                        }
                    })
                    .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();

        }
    }
}
