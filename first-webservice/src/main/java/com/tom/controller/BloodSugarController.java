package com.tom.controller;

import com.tom.entity.BloodSugar;
import com.tom.service.IBloodSugarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Controller
@RequestMapping("/bloodSugar")
public class BloodSugarController {
    @Resource
    private IBloodSugarService bloodSugarService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int Add() throws Exception {
        BloodSugar bloodSugar = new BloodSugar();
        bloodSugar.setId(System.currentTimeMillis());
        bloodSugar.setPatientId(new Long("4626087571456"));
        bloodSugar.setValue(new BigDecimal("15.6"));
        bloodSugar.setMeasureType(1);
        bloodSugar.setNormal(true);
        bloodSugar.setDataSource(1);
        bloodSugar.setAddTime(new Timestamp(System.currentTimeMillis()));
        return bloodSugarService.add(bloodSugar);
    }
}
