package com.Lab.Information.System.LIS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Admin {

    @RequestMapping(value = "/admin", method = {RequestMethod.GET})
    public String adminIndex(){
        return "Admin-Index.html";
    }
}
