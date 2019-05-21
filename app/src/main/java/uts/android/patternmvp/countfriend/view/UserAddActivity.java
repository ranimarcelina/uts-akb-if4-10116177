package uts.android.patternmvp.countfriend.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.EditText;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uts.android.patternmvp.countfriend.R;
import uts.android.patternmvp.countfriend.presenter.UserAddPresenter;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class UserAddActivity extends AppCompatActivity implements IUserAddView {
     private UserAddPresenter presenter;
     private AlertDialog.Builder adBuilder;
     private boolean isUpdate;
     private int updatePos;

     @BindView(R.id.et_nim)
     EditText nimEt;
     @BindView(R.id.et_name)
     EditText nameEt;
     @BindView(R.id.et_kelas)
     EditText kelasEt;
     @BindView(R.id.et_phone)
     EditText phoneEt;
     @BindView(R.id.et_email)
     EditText emailEt;
     @BindView(R.id.et_sosmed)
     EditText sosmedEt;

     @OnClick(R.id.bt_save)
    void saveUser() {
         if (!check()) return;
         if (isUpdate) {
             adBuilder
                     .setPositiveButton("Confirmation", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             presenter.updateUser();
                             finish();
                         }
                     })
                     .show();
         } else {
             adBuilder
                     .setPositiveButton("Confirmation", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             presenter.insertUser();
                             finish();
                         }
                     })
                     .show();
         }

     }

    private boolean check() {
        String nim = getNim();
        String nama = getNama();
        String kelas = getKelas();
        String telepon = getTelepon();
        String email = getEmail();
        String sosmed = getSosmed();

        if (TextUtils.isEmpty(nim)) {
            setNimEtError();
            return false;
        }

        if (TextUtils.isEmpty(nama)) {
            setNameEtError();
            return false;
        }

        if (TextUtils.isEmpty(kelas)) {
            setKelasEtError();
            return false;
        }

        if (TextUtils.isEmpty(telepon)) {
            setPhoneEtError();
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            setEmailEtError();
            return false;
        }

        if (TextUtils.isEmpty(sosmed)) {
            setSosmedEtError();
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add");
        actionBar.setDisplayHomeAsUpEnabled(true);
        presenter = new UserAddPresenter(this);

        Intent intent = getIntent();
        isUpdate = intent.getBooleanExtra("isUpdate", false);
        if (isUpdate) {
            actionBar.setTitle("Edit");
            updatePos = intent.getIntExtra("position", 0);
            presenter.showCurrent();
        }

        createDialog();
    }

    private void createDialog() {
        adBuilder = new AlertDialog.Builder(UserAddActivity.this);
        adBuilder
                .setMessage("Save?")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getNim() {
        return nimEt.getText().toString();
    }

    @Override
    public String getNama() {
        return nameEt.getText().toString();
    }

    @Override
    public String getKelas() {
        return kelasEt.getText().toString();
    }

    @Override
    public String getTelepon() {
        return phoneEt.getText().toString();
    }

    @Override
    public String getEmail() {
        return emailEt.getText().toString();
    }

    @Override
    public String getSosmed() {
        return sosmedEt.getText().toString();
    }

    @Override
    public void setNimEtError() {
        nimEt.setError("Can not be empty！");
    }

    @Override
    public void setNameEtError() {
         nameEt.setError("Can not be empty！");
    }

    @Override
    public void setKelasEtError() {
        kelasEt.setError("Can not be empty！");
    }

    @Override
    public void setPhoneEtError() {
         phoneEt.setError("Can not be empty！");
    }

    @Override
    public void setEmailEtError() {
        emailEt.setError("Can not be empty！");
    }

    @Override
    public void setSosmedEtError() {
        sosmedEt.setError("Can not be empty！");
    }

    @Override
    public void setNim(String nim) { nimEt.setText(nim);
    }

    @Override
    public void setNama(String nama) { nameEt.setText(nama);
    }

    @Override
    public void setKelas(String kelas) { kelasEt.setText(kelas);
    }

    @Override
    public void setTelepon(String telepon) { phoneEt.setText(telepon);
    }

    @Override
    public void setEmail(String email) { emailEt.setText(email);
    }

    @Override
    public void setSosmed(String sosmed) { sosmedEt.setText(sosmed);
    }

    @Override
    public int getUpdatePos() {
         return updatePos;
    }

}