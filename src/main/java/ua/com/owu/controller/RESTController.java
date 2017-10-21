package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;
import ua.com.owu.service.ProductService;
import ua.com.owu.service.UserService;

import java.util.List;

@RestController
public class RESTController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;


    @GetMapping("/show")
    public List<Product> show(){
        return productService.findAll();
    }

    @GetMapping("/admin/banUser-{id}")
    public void banUser(@PathVariable("id")int id, @RequestAttribute("enable")boolean enabled){
        userService.setNewEnable(enabled,id);

    }

    @GetMapping("/userPage/delProduct-${product.id}")
    public void delProd(@PathVariable("id")int id){
        productService.deleteProd(id);
    }
}
