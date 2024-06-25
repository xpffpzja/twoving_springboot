package com.himedia.twoving.controller;

import com.himedia.twoving.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    AdminService as;

    @GetMapping("/admin")
    //@GetMapping("/")
    public String admin() {
        return "admin/adminLoginForm";
    }
}
