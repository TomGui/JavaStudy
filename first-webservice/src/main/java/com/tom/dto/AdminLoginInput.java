package com.tom.dto;

import com.tom.util.MD5Util;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class AdminLoginInput {
    // 登录名
    @NotBlank(message = "{adminLoginInput.loginName.isNull}")
    @NotNull(message = "{adminLoginInput.loginName.isNull}")
    private String loginName;

    // 密码
    @NotBlank(message = "{adminLoginInput.password.isNull}")
    @NotNull(message = "{adminLoginInput.password.isNull}")
    private String password;

    private boolean rememberMe;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return MD5Util.MD5Encode(password, "UTF-8");
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
