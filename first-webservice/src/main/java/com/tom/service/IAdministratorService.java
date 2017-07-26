package com.tom.service;

import com.tom.dto.AdminLoginInput;
import com.tom.dto.AdministratorSearchInput;
import com.tom.entity.Administrator;

import java.util.List;

public interface IAdministratorService {
    Administrator findAdministrator(AdminLoginInput input);

//    List<Administrator> getPageList(AdministratorSearchInput administratorSearchInput);
}