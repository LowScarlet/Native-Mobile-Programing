package id.my.lowscarlet.uts_native.models.portfolioProject;

public class Model {
    // TODO EDIT
    public Integer id;
    public String title;
    public String content;
    public String link;
    public String startYear;
    public Integer portfolioId;

    public Model(String title, String content, String link, String startYear, Integer portfolioId) {
        this.title = title;
        this.content = content;
        this.link = link;
        this.startYear = startYear;
        this.portfolioId = portfolioId;
    }
    //
}
