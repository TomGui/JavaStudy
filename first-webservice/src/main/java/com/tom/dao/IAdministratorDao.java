package com.tom.dao;

import com.tom.dto.AdminLoginInput;
import com.tom.entity.Administrator;

public interface IAdministratorDao {
    Administrator findAdministrator(AdminLoginInput input);
}