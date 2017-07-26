package com.tom.dto;

public class AdministratorSearchInput extends SearchBase {
    // 登录名
    private String loginName;

    // 医院Id
    private long hospitalId;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId) {
        this.hospitalId = hospitalId;
    }
}
