package net.rahel.models.metodePembayaran;

public class Model {
    public Integer id;
    public String tipe;
    public String keterangan;

    public Model(String tipe, String keterangan) {
        this.tipe = tipe;
        this.keterangan = keterangan;
    }
}
