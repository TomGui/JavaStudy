package com.tom.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class BloodSugar implements Serializable {
    // 主键
    private long id;

    // 患者Id
    private long patientId;

    // 血糖值
    private BigDecimal value;

    // 测量类型（1：空腹血糖，2：饭后两小时血糖，3：随机血糖）
    private int measureType;

    // 测量结果（即血糖值）是否正常
    private Boolean isNormal;

    // 数据来源（1：微信录入，2：后台录入，3：医护端录入）
    private int dataSource;

    // 录入医生Id
    private Long addDoctorId;

    // 新增时间
    private Timestamp addTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getMeasureType() {
        return measureType;
    }

    public void setMeasureType(int measureType) {
        this.measureType = measureType;
    }

    public Boolean getNormal() {
        return isNormal;
    }

    public void setNormal(Boolean normal) {
        this.isNormal = normal;
    }

    public int getDataSource() {
        return dataSource;
    }

    public void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }

    public Long getAddDoctorId() {
        return addDoctorId;
    }

    public void setAddDoctorId(Long addDoctorId) {
        this.addDoctorId = addDoctorId;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }
}
