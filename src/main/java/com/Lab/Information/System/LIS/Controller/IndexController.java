package com.Lab.Information.System.LIS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/LIS")
public class IndexController {

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public String index(){
        return "Admin-Index.html";
    }
}

