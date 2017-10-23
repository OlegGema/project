package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;
import ua.com.owu.service.BusketService;
import ua.com.owu.service.ItemService;
import ua.com.owu.service.ProductService;
import ua.com.owu.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class BusketController {
    @Autowired
    BusketService busketService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    ItemService itemService;



    @GetMapping("/userPage/add-{id}")
    public String  addProduct(@PathVariable("id")int id, Principal principal){

        User user = userService.findByName(principal.getName());
        Busket busket = user.getBusket();
        Product product = productService.findOne(id);


        Item item=new Item();
//        item.setBusket(busket);
        System.out.println(busket);
        item.setProduct(product);
        System.out.println(product);
        item.setQuantity(1);

        itemService.save(item);

        busket.getItems().add(item);
        busketService.add(busket);

//        busket.getProducts().add(product);
//
//
//        busketService.add(busket);
        return "redirect:/userPage/products";
    }

    @GetMapping("/userPage/userBusket-{id}")
    public String userBusket(@PathVariable("id")int id,Model model,Principal principal){
////        User user = userService.findByName(principal.getName());
//        User user = userService.findOne(id);
//        Busket busket=user.getBusket();
//        model.addAttribute("user",user);
//        model.addAttribute("busket",busket.getProducts());
        return "userBusket";
    }

    @GetMapping("delete-{id}")
    public String delete(@PathVariable("id")int id){
        busketService.delete(id);
        return "userBusket";

    }
}
