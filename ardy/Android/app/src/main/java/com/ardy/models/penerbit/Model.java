package com.ardy.models.penerbit;

public class Model {
    // TODO EDIT
    public Integer id;
    public String kode;
    public String nama;
    public String lokasi;
    public Integer tahunBerdiri;
    public String emailKontak;
    public String nomorTelepon;

    public Model(String kode, String nama, String lokasi, Integer tahunBerdiri, String emailKontak, String nomorTelepon) {
        this.kode = kode;
        this.nama = nama;
        this.lokasi = lokasi;
        this.tahunBerdiri = tahunBerdiri;
        this.emailKontak = emailKontak;
        this.nomorTelepon = nomorTelepon;
    }
    //
}
