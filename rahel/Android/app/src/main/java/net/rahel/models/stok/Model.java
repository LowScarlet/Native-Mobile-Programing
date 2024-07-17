package net.rahel.models.stok;

public class Model {
    public Integer id;
    public Integer jumlah;
    public Integer kategoriId;

    public Model(Integer jumlah, Integer kategoriId) {
        this.jumlah = jumlah;
        this.kategoriId = kategoriId;
    }
}
