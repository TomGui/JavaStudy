package com.tom.controller;

import com.tom.entity.Area;
import com.tom.service.IAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/area")
public class AreaController {
    @Resource
    private IAreaService areaService;

    @ResponseBody
    @RequestMapping("/list")
    public String list() throws Exception {
        Area area = areaService.findAreas(190).get(0);
        return area.getName();
    }
}
