package com.tom.service.impl;

import com.tom.dao.IAdministratorDao;
import com.tom.dto.AdminLoginInput;
import com.tom.dto.AdministratorSearchInput;
import com.tom.entity.Administrator;
import com.tom.service.IAdministratorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("administratorService")
public class AdministratorServiceImpl implements IAdministratorService {
    @Resource
    private IAdministratorDao administratorDao;

    //查找区域列表
    public Administrator findAdministrator(AdminLoginInput input) {
        return administratorDao.findAdministrator(input);
    }

//    public List<Administrator> getPageList(AdministratorSearchInput administratorSearchInput) {
//        return administratorDao.getPageList(administratorSearchInput);
//    }

}
