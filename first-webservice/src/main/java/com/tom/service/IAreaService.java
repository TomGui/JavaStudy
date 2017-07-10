package com.tom.service;

import com.tom.entity.Area;

public interface IAreaService {
    //查找区域列表
    Area findArea(long cityId);
}