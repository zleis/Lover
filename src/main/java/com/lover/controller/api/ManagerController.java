package com.lover.controller.api;

import com.lover.entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/manager")
public class ManagerController {
    @RequestMapping("/login")
    public void login(Manager manager){
        System.out.println("manager Login");
    }
}
