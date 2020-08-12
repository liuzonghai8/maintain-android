package com.example.maintain.data.code;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "t_code")
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

    //设备型号 [YH 0 、HCM 1 、ATM&CRS响应码 2 、ITM响应码 3]
    @ColumnInfo(name = "device_type")
    private Integer deviceType;


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

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }
}
