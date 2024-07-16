package net.hafis.models.barang;

public class Model {
    // TODO EDIT
    public Integer id;
    public String nama;
    public String deskripsi;
    public String kategoriId;
    public String lokasiId;

    public Model(String nama, String deskripsi, String kategoriId, String lokasiId) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.kategoriId = kategoriId;
        this.lokasiId = lokasiId;
    }
//
}
