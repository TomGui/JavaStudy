package com.tom.service.impl;

import com.tom.dao.IAreaDao;
import com.tom.entity.Area;
import com.tom.service.IAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements IAreaService {
    @Resource
    private IAreaDao areaDao;

    //查找区域列表
    public Area findArea(long cityId) {
        return areaDao.findArea(cityId);
    }
}