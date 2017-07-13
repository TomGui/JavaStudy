package com.tom.dto;

import javax.validation.constraints.NotNull;

public class AdminLoginInput {
    // 登录名
    @NotNull(message = "{adminLoginInput.loginName.isNull}")
    private String loginName;

    // 密码
    @NotNull(message = "{adminLoginInput.password.isNull}")
    private String password;

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
}
