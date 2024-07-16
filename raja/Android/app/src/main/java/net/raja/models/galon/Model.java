package net.raja.models.galon;

public class Model {
    // TODO EDIT
    public Integer id;
    public String nama;
    public Float harga;
    public Integer stok;
    public Integer pemasokId;

    public Model(String nama, Float harga, Integer stok, Integer pemasokId) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.pemasokId = pemasokId;
    }
//
}
