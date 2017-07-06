package com.tom.controller;

import com.tom.entity.Area;
import com.tom.service.IAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {
    @Resource
    private IAreaService areaService;

    @ResponseBody
    @RequestMapping("/list")
    public List<Area> list() throws Exception {
        return areaService.findAreas(190);
    }
}
