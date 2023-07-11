package com.ecommerce.Ecommerce.Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminHome()
    {
        return "adminHome";
    }

}
