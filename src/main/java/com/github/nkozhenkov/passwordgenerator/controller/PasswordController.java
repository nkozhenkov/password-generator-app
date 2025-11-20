package com.github.nkozhenkov.passwordgenerator.controller;

import com.github.nkozhenkov.passwordgenerator.service.PasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/generate")
    public String generatePassword(
            @RequestParam int length,
            @RequestParam(required = false) boolean uppercase,
            @RequestParam(required = false) boolean lowercase,
            @RequestParam(required = false) boolean numbers,
            @RequestParam(required = false) boolean symbols,
            Model model) {

        String password = passwordService.generatePassword(length, uppercase, lowercase, numbers, symbols);

        model.addAttribute("generatedPassword", password);

        return "home";

    }

}
