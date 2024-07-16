package com.ardy.models.penulis;

public class Model {
    // TODO EDIT
    public Integer id;
    public String kode;
    public String nama;
    public String tanggalLahir;
    public String biografi;
    public String kewarganegaraan;
    public String penghargaan;

    public Model(String kode, String nama, String tanggalLahir, String biografi, String kewarganegaraan, String penghargaan) {
        this.kode = kode;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.biografi = biografi;
        this.kewarganegaraan = kewarganegaraan;
        this.penghargaan = penghargaan;
    }
    //
}
