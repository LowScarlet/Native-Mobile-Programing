package id.my.lowscarlet.uts_native.models.portfolioWork;

public class Model {
    // TODO EDIT
    public Integer id;
    public String name;
    public String description;
    public Boolean isActive;
    public Integer companyId;
    public Integer portfolioId;

    public Model(String name, String description, Boolean isActive, Integer companyId, Integer portfolioId) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.companyId = companyId;
        this.portfolioId = portfolioId;
    }
//
}
