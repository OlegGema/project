package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.Product;

import ua.com.owu.service.ProductService;
import ua.com.owu.service.UserService;
import ua.com.owu.validator.ProductValidator;


import java.io.File;
import java.io.IOException;
import java.security.Principal;


@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductValidator productValidator;

    @GetMapping("/admin/addProduct")
    public String toProductPage(Model model){

        return "addProductPage";
    }

    @RequestMapping(value = "/admin/createNewProduct",method = RequestMethod.POST)
    public String newProduct(@RequestParam("productName")String productName,
                             @RequestParam("productType")String productType,
                             @RequestParam("productPhoto")MultipartFile multipartFile,
                             @RequestParam("productPrice")int productPrice,
                             @RequestParam("productDescription")String productDescription)throws IOException{

        String path="D:\\java\\Maven\\Project\\src\\main\\webapp\\static\\productImages\\";
        multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));


        Product product=new Product();
        product.setProductName(productName);
        product.setProductType(productType);
        product.setProductPhoto("\\productPhoto\\"+multipartFile.getOriginalFilename());
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        productService.save(product);
        return "redirect:/admin/addProduct";

    }



    @GetMapping("/admin/products/delete-{id}")
    public String delProd(@PathVariable("id")int id){
        productService.deleteProd(id);
        return "redirect:/userPage/products";
    }

    @GetMapping("/admin/products/product-{id}")
    public String productPage(@PathVariable("id")int id,Model model,Principal principal){


        model.addAttribute("user",userService.findByName(principal.getName()));
        model.addAttribute("product",productService.findOne(id));
        return "productPage";
    }


    @GetMapping("/userPage/products")
    public String listOfProducts(Model model, Principal principal){
        model.addAttribute("user",userService.findByName(principal.getName()));
        model.addAttribute("products",productService.findAll());
        return "products";
    }

    @GetMapping("product-{id}")
    public String productPage(@PathVariable("id")int id,Model model){
        model.addAttribute("product",productService.findOne(id));
        return "productPage";

    }

    @RequestMapping( value = "/admin/changeProdName-{id}",method = RequestMethod.POST)
    public String changeProdName(@PathVariable("id")int id,@RequestParam("productName")String name){
        Product product=productService.findOne(id);
        product.setProductName(name);
        productService.save(product);
        return "redirect:/admin/products/product-{id}";
    }

    @RequestMapping(value = "/admin/changeProdType-{id}" ,method = RequestMethod.POST)
    public String changeProdType(@PathVariable("id")int id,@RequestParam("productType")String type){
        Product product=productService.findOne(id);
        product.setProductType(type);
        productService.save(product);
        return "redirect:/admin/products/product-{id}";
    }

    @RequestMapping(value = "/admin/changeProdPrice-{id}",method = RequestMethod.POST)
    public String changeProdPrice(@PathVariable("id")int id,@RequestParam("productPrice")int price){
        Product product=productService.findOne(id);
        product.setProductPrice(price);
        productService.save(product);
        return "redirect:/admin/products/product-{id}";
    }

    @RequestMapping(value = "/admin/changeProdPhoto-{id}",method = RequestMethod.POST)
    public String changeProdPhoto(@PathVariable("id")int id,@RequestParam("productPhoto") MultipartFile multipartFile) throws IOException {
        Product product=productService.findOne(id);
        String path="D:\\java\\Maven\\Project\\src\\main\\webapp\\static\\productImages\\";
        multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        String photo="\\productPhoto\\"+multipartFile.getOriginalFilename();
        product.setProductPhoto(photo);
        productService.save(product);
        return "redirect:/admin/products/product-{id}";
    }



}
