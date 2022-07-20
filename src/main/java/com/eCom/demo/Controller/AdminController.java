package com.eCom.demo.Controller;

import com.eCom.demo.Dto.productDto;
import com.eCom.demo.Model.Category;
import com.eCom.demo.Model.Products;
import com.eCom.demo.Service.CategoryService;
import com.eCom.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    // Category Section

    @Autowired
    private CategoryService cservice;

    @GetMapping("/admin/categories")
    public String GetCategoriesPage(Model model){
        model.addAttribute("categories", cservice.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String GetCategoriesAddPage(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String PostCategoriesAddPage(@ModelAttribute ("category") Category category){
        cservice.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String DeleteCategory(@PathVariable("id") long id){
        cservice.removeCategory(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String UpdateCategory(@PathVariable("id") long id, Model model){
        Optional<Category> category = cservice.GetCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }
        else {
            return "404";
        }
    }

    // Product Section Start from here.

    @Autowired
    public ProductService pservice;

    @GetMapping("/admin/products")
    public String GetProducts(Model model){
        model.addAttribute("products", pservice.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String GetProductsAdd(Model model){
        model.addAttribute("productDTO", new productDto());
        model.addAttribute("categories", cservice.getAllCategory());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String PostProduct(
            @ModelAttribute("productDTO") productDto productDTO,
            @RequestParam("productImage")MultipartFile multipartFile,
            @RequestParam("imgName") String imageName
            ) throws IOException {

        Products products = new Products();
        products.setId(productDTO.getId());
        products.setName(productDTO.getName());
        products.setCategory(cservice.GetCategoryById(productDTO.getCategoryId()).get());
        products.setPrice(productDTO.getPrice());
        products.setWeight(productDTO.getWeight());
        products.setDescription(productDTO.getDescription());
        String imgUUID;
        if(!multipartFile.isEmpty()){
            imgUUID = multipartFile.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imgUUID);
            Files.write(fileNameAndPath, multipartFile.getBytes());
            System.out.println(fileNameAndPath.toAbsolutePath());
        } else {
            imgUUID = imageName;
        }
        products.setImageName(imgUUID);
        pservice.addProduct(products);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String DeleteProduct(@PathVariable("id") long id){
        pservice.removeProduct(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String UpdateProduct(@PathVariable("id") long id, Model model){
        Products product = pservice.GetProductById(id).get();
        productDto productDto = new productDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategoryId((int) product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setWeight(product.getWeight());
        productDto.setDescription(product.getDescription());
        productDto.setImageName(product.getImageName());

        model.addAttribute("categories", cservice.getAllCategory());
        model.addAttribute("productDTO", productDto);
        return "productsAdd";
    }
}
