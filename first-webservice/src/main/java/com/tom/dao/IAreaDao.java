package com.tom.dao;

import com.tom.entity.Area;

import java.util.List;

public interface IAreaDao {

    //查找区域列表
    List<Area> findAreas(long cityId);
}