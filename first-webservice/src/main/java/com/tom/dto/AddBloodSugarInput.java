package com.tom.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AddBloodSugarInput {
    // 患者Id
    private long patientId;

    // 血糖值
    @NotNull(message = "{addBloodSugarInput.value.isNull}")
    private BigDecimal value;

    // 测量类型（1：空腹血糖，2：饭后两小时血糖，3：随机血糖）
    @Range(min = 1, max = 3, message = "{addBloodSugarInput.measureType.error}")
    private int measureType;

    // 数据来源（1：微信录入，2：后台录入，3：医护端录入）
    @Range(min = 1, max = 3, message = "{addBloodSugarInput.dataSource.error}")
    private int dataSource;

    // 录入医生Id
    private Long addDoctorId;

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
}
