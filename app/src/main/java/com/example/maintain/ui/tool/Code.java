package com.example.maintain.ui.tool;

public class Code {
    private int id;
    private String codeName;
    private String analysis;

    public Code(int id, String codeName, String analysis, String advise) {
        this.id = id;
        this.codeName = codeName;
        this.analysis = analysis;
        this.advise = advise;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    private String advise;

    public int getId() {
        return id;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getAnalysis() {
        return analysis;
    }

    public String getAdvise() {
        return advise;
    }
}
