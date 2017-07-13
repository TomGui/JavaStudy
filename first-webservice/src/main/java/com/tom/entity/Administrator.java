package com.tom.entity;

import java.sql.Timestamp;

public class Administrator {
    // 管理员Id
    private long id;

    // 登录名
    private String loginName;

    // 密码
    private String password;

    // 医院Id
    private Long hospitalId;

    // 是否超级管理员
    private boolean isSuperManager;

    // 用户描述
    private String userDesc;

    // 新增时间
    private Timestamp addTime;

    // 更新时间
    private Timestamp updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public boolean isSuperManager() {
        return isSuperManager;
    }

    public void setSuperManager(boolean superManager) {
        isSuperManager = superManager;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
