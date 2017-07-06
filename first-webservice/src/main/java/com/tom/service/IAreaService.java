package com.tom.service;

import com.tom.entity.Area;

import java.util.List;

public interface IAreaService {
    //查找区域列表
    List<Area> findAreas(long cityId);
}