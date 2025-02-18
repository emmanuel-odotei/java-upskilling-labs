package com.amalitech.lab_2_ecommerce.controller;

import com.amalitech.lab_2_ecommerce.entity.ProductEntity;
import com.amalitech.lab_2_ecommerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProduct(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/add/product")
    public String addProduct(@ModelAttribute("products") ProductEntity product,  Model model) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
