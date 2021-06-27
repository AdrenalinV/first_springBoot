package ru.geekbrains.first_springBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.first_springBoot.models.Product;
import ru.geekbrains.first_springBoot.services.ProductsService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService products;

    @Autowired
    public ProductsController(ProductsService products) {
        this.products = products;
    }

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = this.products.getAll();
        model.addAttribute("products", products);
        return "all_products";

    }
}
