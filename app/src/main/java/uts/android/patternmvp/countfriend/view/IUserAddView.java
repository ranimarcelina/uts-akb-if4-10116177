package uts.android.patternmvp.countfriend.view;

public interface IUserAddView {
    String getNim();
    String getNama();
    String getKelas();
    String getTelepon();
    String getEmail();
    String getSosmed();

    void setNimEtError();
    void setNameEtError();
    void setKelasEtError();
    void setPhoneEtError();
    void setEmailEtError();
    void setSosmedEtError();

    void setNim(String nim);
    void setNama(String nama);
    void setKelas(String kelas);
    void setTelepon(String telepon);
    void setEmail(String email);
    void setSosmed(String sosmed);

    int getUpdatePos();


}
