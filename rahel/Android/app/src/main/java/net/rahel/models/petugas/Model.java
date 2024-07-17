package net.rahel.models.petugas;

public class Model {
    public Integer id;
    public String nama;
    public String alamat;
    public String nomorHp;

    public Model(String nama, String alamat, String nomorHp) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorHp = nomorHp;
    }
}
