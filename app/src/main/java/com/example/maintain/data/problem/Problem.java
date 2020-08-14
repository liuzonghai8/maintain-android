package com.example.maintain.data.problem;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "t_problem")
public class Problem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    //问题
    @ColumnInfo(name = "problem_name")
    private String problemName;

    //建议
    private String advise;

    //问题类型（应用：0，硬件：1，系统：2,业务 3）
    @ColumnInfo(name = "problem_type")
    private int problemType;

    public int getId() {
        return id;
    }

    public String getProblemName() {
        return problemName;
    }

    public String getAdvise() {
        return advise;
    }

    public int getProblemType() {
        return problemType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public void setProblemType(int problemType) {
        this.problemType = problemType;
    }
}
