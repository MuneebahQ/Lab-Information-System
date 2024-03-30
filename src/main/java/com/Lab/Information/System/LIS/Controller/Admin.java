package com.Lab.Information.System.LIS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin {

    @GetMapping("/admin")
    public String adminIndex(){
        return "Admin-Index.html";
    }
}
