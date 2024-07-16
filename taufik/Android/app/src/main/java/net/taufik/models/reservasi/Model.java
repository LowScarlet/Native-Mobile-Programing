package net.taufik.models.reservasi;

public class Model {
    // TODO EDIT
    public Integer id;
    public String catatan;
    public String tanggal;
    public String waktu;
    public Integer konsumenId;
    public Integer mejaId;

    public Model(String catatan, String tanggal, String waktu, Integer konsumenId, Integer mejaId) {
        this.catatan = catatan;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.konsumenId = konsumenId;
        this.mejaId = mejaId;
    }
    //
}
