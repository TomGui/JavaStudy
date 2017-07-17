package com.tom.admin;

import com.tom.dto.AdminLoginInput;
import com.tom.entity.Administrator;
import com.tom.service.IAdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IAdministratorService administratorService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, Model model, @Validated @ModelAttribute("adminLoginInput") AdminLoginInput adminLoginInput,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            model.addAttribute("allErrors", allErrors);
            return "login";
        }

        Administrator administrator = administratorService.findAdministrator(adminLoginInput);
        if (administrator == null) {
            return "login";
        }

        session.setAttribute("currentLoginUser", administrator);
        return "redirect:/administrator/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
