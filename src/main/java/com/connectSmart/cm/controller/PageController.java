package com.connectSmart.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.connectSmart.cm.entity.User;
import com.connectSmart.cm.form.UserForm;
import com.connectSmart.cm.helper.MessageType;
import com.connectSmart.cm.helper.message;
import com.connectSmart.cm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {
    @Autowired
    private UserService userservice;

    // @GetMapping("/")
    // public String index(){
    //     return "redirect:/home";
    // }

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
    public String register(Model model)
    {
        UserForm userForm= new UserForm();
        //we can place default data also
        model.addAttribute("userForm", userForm);
        return "register";
    }


    //processing register
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session){
        //userform
        System.out.println(userForm);
        //validate the form
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        //userservice
        // User user= User.builder()
        //             .name(userForm.getName())
        //             .email(userForm.getEmail())
        //             .password(userForm.getPassword())
        //             .about(userForm.getAbout())
        //             .phoneNumber(userForm.getPhoneNumber())
        //             .profilePic("https://mir-s3-cdn-cf.behance.net/projects/404/078282175570811.Y3JvcCw4MDgsNjMyLDAsMA.png")
        //             .build();

        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://mir-s3-cdn-cf.behance.net/projects/404/078282175570811.Y3JvcCw4MDgsNjMyLDAsMA.png");

       User userSaved=userservice.saveUser(user);
       System.out.println("user saved");


        // add message
        message msg = message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message",msg);

        return "redirect:/register";
    }
}
