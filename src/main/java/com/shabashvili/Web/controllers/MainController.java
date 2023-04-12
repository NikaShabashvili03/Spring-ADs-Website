package com.shabashvili.Web.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "ZD stranica");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About us");
        return "about";
    }

}
