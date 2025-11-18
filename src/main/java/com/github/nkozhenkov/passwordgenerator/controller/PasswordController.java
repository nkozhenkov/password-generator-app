package com.github.nkozhenkov.passwordgenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PasswordController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
