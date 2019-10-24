package com.anp.gestion_facturation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * DemoController
 */

@Controller
public class AppMainController {

    @GetMapping("/")
    public String sayHello(Model theModel) {
        return "Home";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

}