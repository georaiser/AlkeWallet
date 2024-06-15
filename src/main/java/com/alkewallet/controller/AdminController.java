package com.alkewallet.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import jakarta.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/adminWallet")
public class AdminController {
 
    @GetMapping    
    public String adminWallet(Model model) {
        //model.addAttribute("currentUser", userService.getCurrentUser()); 
        return "admin/adminWallet"; 
    }
}
