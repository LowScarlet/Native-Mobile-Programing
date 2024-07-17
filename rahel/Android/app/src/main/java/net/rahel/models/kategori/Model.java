package net.rahel.models.kategori;

public class Model {
    public Integer id;
    public String nama;
    public Integer kapasitas;

    public Model(String nama, Integer kapasitas) {
        this.nama = nama;
        this.kapasitas = kapasitas;
    }
}
