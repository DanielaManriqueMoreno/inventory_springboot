package com.daniela.product_api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index() {
        return "index"; // Vista pública
    }
    
    @GetMapping("/login")
    public String login() {
        return "login"; // Vista publica
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Authentication auth) {
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            return "redirect:/admin/panel";
        } else {
            return "redirect:/user/porfile";
        }
    }
    
    @GetMapping("/admin/panel")
    public String adminPanel() {
        return "admin";// Vista solo para admin
    }
    
    @GetMapping("/user/profile")    
    public String userProfile() {
        return "user"; // Vista para user 
    }
}
