package net.raja.models.pengantaran;

public class Model {
    // TODO EDIT
    public Integer id;
    public String tanggal;
    public String status;
    public Integer karyawanId;
    public Integer pemesananId;

    public Model(String tanggal, String status, Integer karyawanId, Integer pemesananId) {
        this.tanggal = tanggal;
        this.status = status;
        this.karyawanId = karyawanId;
        this.pemesananId = pemesananId;
    }
//
}
