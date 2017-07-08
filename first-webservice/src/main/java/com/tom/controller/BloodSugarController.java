package com.tom.controller;

import com.tom.dto.AddBloodSugarInput;
import com.tom.entity.BloodSugar;
import com.tom.service.IBloodSugarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Controller
@RequestMapping("/bloodSugar")
public class BloodSugarController {
    @Resource
    private IBloodSugarService bloodSugarService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int Add(@RequestBody AddBloodSugarInput addBloodSugarInput) throws Exception {
        BloodSugar bloodSugar = new BloodSugar();
        bloodSugar.setId(System.currentTimeMillis());
        bloodSugar.setPatientId(addBloodSugarInput.getPatientId());
        bloodSugar.setValue(addBloodSugarInput.getValue());
        bloodSugar.setMeasureType(addBloodSugarInput.getMeasureType());
        bloodSugar.setNormal(true);
        bloodSugar.setDataSource(addBloodSugarInput.getDataSource());
        bloodSugar.setAddDoctorId(addBloodSugarInput.getAddDoctorId());
        bloodSugar.setAddTime(new Timestamp(System.currentTimeMillis()));
        return bloodSugarService.add(bloodSugar);
    }
}
