package com.example.maintain.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Code {
    @PrimaryKey(autoGenerate = true)
    private int id;

    //故障码
    @ColumnInfo(name = "code_name")
    private String codeName;
    //解析
    private String analysis;
    //建议
    private String advise;


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
