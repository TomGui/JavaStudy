package com.tom.admin;

import com.tom.dto.AdminLoginInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @Validated @ModelAttribute("adminLoginInput") AdminLoginInput adminLoginInput,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            model.addAttribute("allErrors", allErrors);
            return "login";
        }
        return "index";
    }
}
