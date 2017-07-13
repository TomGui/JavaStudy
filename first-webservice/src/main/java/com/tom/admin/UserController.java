package com.tom.admin;

import com.tom.dto.AdminLoginInput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(AdminLoginInput adminLoginInput) {
        return "";
    }
}
