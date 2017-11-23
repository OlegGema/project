package ua.com.owu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ua.com.owu.entity.Busket;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;
import ua.com.owu.validator.UserValidator;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserValidator userValidator;


    @RequestMapping(value = "registration",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("newUser")@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "registration";
        }
        user.setAvatar("\\avatar\\default.png");
        user.setBusket(new Busket());
        userService.save(user);
        return "index";
    }

    @RequestMapping(value = "/userPage",method = RequestMethod.GET)
    public String toUserPage(Principal principal, Model model){
        User user = userService.findByName(principal.getName());
        model.addAttribute("user",user);

        return "userPage";
    }

    @GetMapping("/admin/listOfUsers")
    public String listOfUsers(Model model){
        model.addAttribute("allUsers",userService.findAll());
        return "allUsers";
    }


    @GetMapping("userChange")
    public String toUserChange(Principal principal,Model model){
        model.addAttribute("user",userService.findByName(principal.getName()));
        return "userChangePage";
    }

    @RequestMapping(value = "changeUserName-{id}",method = RequestMethod.POST)
    public String newUserName(@PathVariable("id")int id,@RequestParam("username") String username,Model model,Principal principal){
        if (userService.findByName(username)!=null){
            String massage="name already used";
            model.addAttribute("massage",massage);
            return "redirect:userChange";
        }
        userService.setNewName(username,id);
        model.addAttribute("user",userService.findByName(username));
        return "userPage";
    }

    @RequestMapping(value = "changeEmail-{id}",method = RequestMethod.POST)
    public String newEmail(@PathVariable("id")int id,@RequestParam("email")String email,Model model){
        User user = userService.findOne(id);
        userService.setNewEmail(email,id);
        model.addAttribute("user",user);
        return "redirect:userPage";
    }

    @RequestMapping(value = "changeAvatar-{id}",method = RequestMethod.POST)
    public String newAvatar(@PathVariable("id")int id, @RequestParam("avatar")MultipartFile multipartFile, Model model) throws IOException {
        User user = userService.findOne(id);
        String path=System.getProperty("user.home")+ File.separator+"images\\";
        multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        String photo="\\avatar\\"+multipartFile.getOriginalFilename();
        userService.setNewAvatar(photo,id);
        model.addAttribute("user",user);
        return "redirect:userPage";
    }

    @RequestMapping(value = "/admin/listOfUsers/banUser-{id}" ,method = RequestMethod.POST)
    public String banUser( @RequestParam("enabled") boolean enabled,@PathVariable("id") int id){
        userService.setNewEnable(enabled,id);
        return "redirect:/admin/listOfUsers";
    }


    @InitBinder("newUser")
    public void bind(WebDataBinder webDataBinder){
            webDataBinder.addValidators(userValidator);

    }
}
