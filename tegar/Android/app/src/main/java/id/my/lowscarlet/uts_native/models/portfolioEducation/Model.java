package id.my.lowscarlet.uts_native.models.portfolioEducation;

public class Model {
    // TODO EDIT
    public Integer id;
    public Float score;
    public Integer startYear;
    public Integer endYear;
    public Boolean isActive;
    public Integer portfolioId;
    public Integer institutionId;
    public Integer departmentId;

    public Model(Float score, Integer startYear, Integer endYear, Boolean isActive, Integer portfolioId, Integer institutionId, Integer departmentId) {
        this.score = score;
        this.startYear = startYear;
        this.endYear = endYear;
        this.isActive = isActive;
        this.portfolioId = portfolioId;
        this.institutionId = institutionId;
        this.departmentId = departmentId;
    }
//
}
