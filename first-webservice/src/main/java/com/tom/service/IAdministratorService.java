package com.tom.service;

import com.tom.dto.AdminLoginInput;
import com.tom.entity.Administrator;

public interface IAdministratorService {
    Administrator findAdministrator(AdminLoginInput input);
}