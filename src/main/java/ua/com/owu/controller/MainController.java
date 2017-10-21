package ua.com.owu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.entity.User;



@Controller
public class MainController {



    @GetMapping("/")
    public String toIndex(){
        return "index";
    }
    @GetMapping("registration")
    public String toRegistration(Model model){
        model.addAttribute("newUser",new User());
        return "registration";
    }


    @GetMapping("login")
    public String toLogin(Model model){
        return "loginPage";
    }


    @GetMapping("admin")
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/logoutPage")
    public String logout(){
        return "redirect:/";
    }

    @GetMapping("/403")
    public String page403(){
        return "403";
    }













}
