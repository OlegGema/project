package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;
import ua.com.owu.service.ProductService;
import ua.com.owu.service.UserService;
import ua.com.owu.validator.ProductValidator;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

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
//        model.addAttribute("newProduct",new Product());
        return "addProductPage";
    }

    @RequestMapping(value = "/admin/createNewProduct",method = RequestMethod.POST)
    public String newProduct(@RequestParam("productName")String productName,
                             @RequestParam("productType")String productType,
                             @RequestParam("productPhoto")MultipartFile multipartFile,
                             @RequestParam("productPrice")int productPrice,
                             @RequestParam("productDescription")String productDescription)throws IOException{

        String path=System.getProperty("user.home") + File.separator+"productImages\\";
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



//    @RequestMapping(value = "createNewProduct",method = RequestMethod.POST)
//    public String newProduct(@ModelAttribute("newProduct")@Valid Product product, BindingResult result,
//                             @RequestParam("productPhoto")MultipartFile file) throws IOException {
//
//        if (result.hasErrors()){
//            return "addProductPage";
//        }
//
//        String path=System.getProperty("user.home")+ File.separator+"productImages\\";
//        file.transferTo(new File(path+file.getOriginalFilename()));
//        String photo="\\productPhoto\\"+file.getOriginalFilename();
//        product.setProductPhoto(photo);
//        productService.save(product);
//        return "addProductPage";
//    }

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

//    @InitBinder
//    public void bind(WebDataBinder webDataBinder){
//        try {
//            webDataBinder.addValidators(productValidator);
//        }catch (IllegalStateException e){
//            System.out.println("error");
//        }
//    }


}
