package net.rahel.models.pengembalian;

public class Model {
    public Integer id;
    public String waktuPengembalian;
    public Float harga;
    public Integer pencatatanId;
    public Integer stokId;
    public Integer metodePembayaranId;
    public Integer petugasId;

    public Model(String waktuPengembalian, Float harga, Integer pencatatanId, Integer stokId, Integer metodePembayaranId, Integer petugasId) {
        this.waktuPengembalian = waktuPengembalian;
        this.harga = harga;
        this.pencatatanId = pencatatanId;
        this.stokId = stokId;
        this.metodePembayaranId = metodePembayaranId;
        this.petugasId = petugasId;
    }
}
