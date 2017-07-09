package com.tom.controller;

import com.tom.dto.AddBloodSugarInput;
import com.tom.entity.BloodSugar;
import com.tom.service.IBloodSugarService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/bloodSugar")
public class BloodSugarController {
    @Resource
    private IBloodSugarService bloodSugarService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String Add(@RequestBody @Validated AddBloodSugarInput addBloodSugarInput, BindingResult bindingResult)
            throws Exception {
        if (bindingResult.hasErrors()) {
            String errorMsg = "";
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                errorMsg += objectError.getDefaultMessage() + ",";
            }
            return errorMsg;
        }

        BloodSugar bloodSugar = new BloodSugar();
        bloodSugar.setId(System.currentTimeMillis());
        bloodSugar.setPatientId(addBloodSugarInput.getPatientId());
        bloodSugar.setValue(addBloodSugarInput.getValue());
        bloodSugar.setMeasureType(addBloodSugarInput.getMeasureType());
        bloodSugar.setNormal(true);
        bloodSugar.setDataSource(addBloodSugarInput.getDataSource());
        bloodSugar.setAddDoctorId(addBloodSugarInput.getAddDoctorId());
        bloodSugar.setAddTime(new Timestamp(System.currentTimeMillis()));
        if (bloodSugarService.add(bloodSugar) > 0) {
            return "添加成功";
        }
        return "添加失败";
    }
}
