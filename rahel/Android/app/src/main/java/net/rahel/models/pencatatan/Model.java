package net.rahel.models.pencatatan;

public class Model {
    public Integer id;
    public String nama;
    public String nomorHp;
    public Integer jumlah;
    public String mulaiSewa;
    public Integer petugasId;
    public Integer lokasiId;
    public Integer stokId;

    public Model(String nama, String nomorHp, Integer jumlah, String mulaiSewa, Integer petugasId, Integer lokasiId, Integer stokId) {
        this.nama = nama;
        this.nomorHp = nomorHp;
        this.jumlah = jumlah;
        this.mulaiSewa = mulaiSewa;
        this.petugasId = petugasId;
        this.lokasiId = lokasiId;
        this.stokId = stokId;
    }
}
