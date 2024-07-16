package net.taufik.models.pesanan;

public class Model {
    // TODO EDIT
    public Integer id;
    public String catatan;
    public String tanggal;
    public Integer jumlahTotal;
    public Integer konsumenId;

    public Model(String catatan, String tanggal, Integer jumlahTotal, Integer konsumenId) {
        this.catatan = catatan;
        this.tanggal = tanggal;
        this.jumlahTotal = jumlahTotal;
        this.konsumenId = konsumenId;
        }
    //
}
