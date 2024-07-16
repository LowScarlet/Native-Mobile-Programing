package com.ardy.models.peminjaman;

public class Model {
    // TODO EDIT
    public Integer id;
    public String tanggalPinjam;
    public String tanggalKembali;
    public String tanggalJatuhTempo;
    public String status;
    public Float denda;
    public Integer bukuId;

    public Model(String tanggalPinjam, String tanggalKembali, String tanggalJatuhTempo, String status, Float denda, Integer bukuId) {
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.status = status;
        this.denda = denda;
        this.bukuId = bukuId;
    }
//
}
