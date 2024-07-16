package id.my.lowscarlet.uts_native.models.portfolioDetail;

public class Model {
    // TODO EDIT
    public Integer id;
    public String fullName;
    public String about;
    public String website;
    public String phone;
    public String email;
    public Integer portfolioId;

    public Model(String fullName, String about, String website, String phone, String email, Integer portfolioId) {
        this.fullName = fullName;
        this.about = about;
        this.website = website;
        this.phone = phone;
        this.email = email;
        this.portfolioId = portfolioId;
    }
//
}
