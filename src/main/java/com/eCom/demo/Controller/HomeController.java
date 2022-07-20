package com.eCom.demo.Controller;

import com.eCom.demo.Global.GlobalData;
import com.eCom.demo.Service.CategoryService;
import com.eCom.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    public CategoryService cservice;

    @Autowired
    public ProductService pservice;

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", cservice.getAllCategory());
        model.addAttribute("products", pservice.getAllProduct());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable("id") long id){
        model.addAttribute("categories", cservice.getAllCategory());
        model.addAttribute("products", pservice.GetAllProductsByCategoryId(id));
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String ViewProduct(Model model, @PathVariable("id") long id) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("product", pservice.GetProductById(id).get());
        return "viewProduct";
    }
}
