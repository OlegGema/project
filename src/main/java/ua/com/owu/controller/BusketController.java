package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;
import ua.com.owu.service.BusketService;
import ua.com.owu.service.ItemService;
import ua.com.owu.service.ProductService;
import ua.com.owu.service.UserService;

import java.security.Principal;
import java.util.Iterator;
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



    @RequestMapping(value = "/userPage/add-{id}" ,method = RequestMethod.POST)
    public String  addProduct(@PathVariable("id")int id, @RequestParam("quantity")int quantity, Principal principal){



        User user = userService.findByName(principal.getName());
        Busket busket = user.getBusket();
        Product product = productService.findOne(id);

        List<Item> items = busket.getItems();
        Iterator<Item> iterator = items.iterator();

        int numberOfItem=0;

        if (items.isEmpty()){
            System.out.println("first if");
            Item newItem=new Item();
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            itemService.save(newItem);
            busket.getItems().add(newItem);
            busketService.add(busket);
        }else {

            while (iterator.hasNext()) {
                Item currentItem = iterator.next();
                if (currentItem.getProduct().getId()==id) {
                    System.out.println("second if");
                    System.out.println("id of current item "+currentItem.getProduct().getId());
                    System.out.println("id of product "+id);
                    System.out.println(currentItem.getQuantity());
//
                    numberOfItem=currentItem.getItemId();



                }
            }
            if (numberOfItem!=0){
                itemService.updateQuantity(itemService.findOne(numberOfItem).getQuantity()+quantity, numberOfItem);
            }else {
                Item newItem=new Item();
                newItem.setProduct(product);
                newItem.setQuantity(quantity);
                itemService.save(newItem);
                busket.getItems().add(newItem);
                busketService.add(busket);
            }

        }


        return "redirect:/userPage/products";
    }

    @GetMapping("/userPage/userBusket-{id}")
    public String userBusket(@PathVariable("id")int id,Model model){
        User user = userService.findOne(id);
        Busket busket=user.getBusket();





        model.addAttribute("user",user);
        model.addAttribute("busket",busket.getItems());
        return "userBusket";
    }

    @GetMapping("/userPage/delete-{itemId}")
    public String delete(@PathVariable("itemId")int id){
        itemService.delete(id);
        System.out.println(id);
        return "redirect:/userPage";

    }
}
