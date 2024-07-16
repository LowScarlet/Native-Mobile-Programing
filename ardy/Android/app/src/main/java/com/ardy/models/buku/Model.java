package com.ardy.models.buku;

public class Model {
    // TODO EDIT
    public Integer id;
    public String kode;
    public String judul;
    public Integer tahunTerbit;
    public Integer halaman;
    public String deskripsi;
    public String bahasa;
    public Integer penulisId;
    public Integer kategoriId;
    public Integer penerbitId;

    public Model(String kode, String judul, Integer tahunTerbit, Integer halaman, String deskripsi, String bahasa, Integer penulisId, Integer kategoriId, Integer penerbitId) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.halaman = halaman;
        this.deskripsi = deskripsi;
        this.bahasa = bahasa;
        this.penulisId = penulisId;
        this.kategoriId = kategoriId;
        this.penerbitId = penerbitId;
    }

    //
}
