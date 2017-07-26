package com.tom.admin;

import com.tom.dto.AdministratorSearchInput;
import com.tom.dto.OutputBase;
import com.tom.entity.Administrator;
import com.tom.service.IAdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    @Resource
    private IAdministratorService administratorService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "views/AdministratorManage";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, AdministratorSearchInput administratorSearchInput) {
        List<Administrator> list = administratorService.getPageList(administratorSearchInput);
        int totalRows = administratorService.getTotalRows(administratorSearchInput);
        model.addAttribute("items", list);
        model.addAttribute("currentPage", administratorSearchInput.getPageIndex());
        model.addAttribute("totalRows", totalRows);
        model.addAttribute("totalPages", totalRows / administratorSearchInput.getPageSize());
        return "views/AdministratorList";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public OutputBase Delete(long id) {
        return OutputBase.Success("删除成功");
    }
}
