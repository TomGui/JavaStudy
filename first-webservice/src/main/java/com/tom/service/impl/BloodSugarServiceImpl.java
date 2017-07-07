package com.tom.service.impl;

import com.tom.dao.IBloodSugarDao;
import com.tom.entity.BloodSugar;
import com.tom.service.IBloodSugarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("bloodSugarService")
public class BloodSugarServiceImpl implements IBloodSugarService {
    @Resource
    private IBloodSugarDao bloodSugarDao;

    public int add(BloodSugar bloodSugar) {
        return bloodSugarDao.add(bloodSugar);
    }
}
