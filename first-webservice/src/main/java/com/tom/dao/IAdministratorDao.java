package com.tom.dao;

import com.tom.dto.AdminLoginInput;
import com.tom.dto.AdministratorSearchInput;
import com.tom.entity.Administrator;

import java.util.List;

public interface IAdministratorDao {
    Administrator findAdministrator(AdminLoginInput input);

    List<Administrator> getPageList(AdministratorSearchInput administratorSearchInput);

    int getTotalRows(AdministratorSearchInput administratorSearchInput);
}