package net.raja.models.pemesanan;

public class Model {
    // TODO EDIT
    public Integer id;
    public String tanggal;
    public String status;
    public Integer jumlah;
    public Integer pelangganId;
    public Integer galonId;

    public Model(String tanggal, String status, Integer jumlah, Integer pelangganId, Integer galonId) {
        this.tanggal = tanggal;
        this.status = status;
        this.jumlah = jumlah;
        this.pelangganId = pelangganId;
        this.galonId = galonId;
    }
//
}
