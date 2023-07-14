package com.ecommerce.Ecommerce.Application.controller;

//import com.ecommerce.Ecommerce.Application.dto.ProductDTO;
import com.ecommerce.Ecommerce.Application.model.Category;
import com.ecommerce.Ecommerce.Application.model.Product;
import com.ecommerce.Ecommerce.Application.service.CategoryService;
import com.ecommerce.Ecommerce.Application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@Controller
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/ProductImages";

    @GetMapping("/admin")
    public String adminHome()
    {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model)
    {
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model)
    {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category)
    {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deletCat(@PathVariable int id)
    {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
        //return "delted successfully";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model)
    {
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent())
        {
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }
        else
        {
            return "404";
        }

    }

    @GetMapping("/admin/products")
    public String getProducts(Model model)
    {
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String getProductAdd(Model model)
    {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String postProductAdd(@ModelAttribute("product") Product product,
                                 @RequestParam("productImage") MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException {
        String imageUid;

        if(!file.isEmpty())
        {
            imageUid = file.getOriginalFilename();
            Path fileNamePath = Paths.get(uploadDir,imageUid);
            Files.write(fileNamePath,file.getBytes());
        }
        else
        {
            imageUid = imgName;
        }

        product.setImageName(imageUid);

        productService.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String productDelete(@PathVariable int id)
    {
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProducts(@PathVariable Integer id,Model model)
    {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productsAdd";
    }

}
