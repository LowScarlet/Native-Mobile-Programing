package net.taufik.models.itemPesanan;

public class Model {
    // TODO EDIT
    public Integer id;
    public String catatan;
    public Integer kuantitas;
    public Integer pesananId;
    public Integer menuId;

    public Model(String catatan, Integer kuantitas, Integer pesananId, Integer menuId) {
        this.catatan = catatan;
        this.kuantitas = kuantitas;
        this.pesananId = pesananId;
        this.menuId = menuId;
    }
    //
}
