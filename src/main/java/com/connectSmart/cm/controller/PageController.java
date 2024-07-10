package com.connectSmart.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page controller");
        model.addAttribute("projectName","ConnectSmart" );
        model.addAttribute("youtube","Learn with Durgesh" );
        model.addAttribute("gitRepo", "https://github.com/krishnanandgupta07/ConnectSmart.git");

        return "home";
    }

    //route
    @RequestMapping("/about")
    public String aboutPage(Model model)
    {
        model.addAttribute("isLogin", true);
        System.out.println("For About Page");
        return "about";
    }

    //service
    @RequestMapping("/services")
    public String servicesPage()
    {
        System.out.println("For Services page");
        return "services";
    }

    //contact page
    @GetMapping("/contact")
    public String contactPage()
    {
        return new String("contact") ;
    }
    //login page
    @GetMapping("/login")
    public String login()
    {
        return new String("login");
    }

    //register
    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

}
