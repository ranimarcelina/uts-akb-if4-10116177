package uts.android.patternmvp.countfriend.bean;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class UserBean {
    private String nim;
    private String nama;
    private String kelas;
    private String telepon;
    private String email;
    private String sosmed;

    public UserBean(String nim, String nama, String kelas, String telepon, String email, String sosmed) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telepon = telepon;
        this.email = email;
        this.sosmed = sosmed;
    }

    public UserBean() {

    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public void setKelas(String kelas){
        this.kelas = kelas;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getEmail() {
        return email;
    }

    public String getSosmed() {
        return sosmed;
    }
}
