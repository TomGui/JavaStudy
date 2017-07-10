package com.tom.dao;

import com.tom.entity.Area;

import java.util.List;

public interface IAreaDao {

    //查找区域
    Area findArea(long cityId);
}