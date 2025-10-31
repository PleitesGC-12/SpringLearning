package com.Practica.practicaSpringBoot.controllers;

import com.Practica.practicaSpringBoot.domain.Product;
import com.Practica.practicaSpringBoot.service.ProductsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductsServiceImpl productService = new ProductsServiceImpl();

    @GetMapping
    public List<Product> getProducts() {
        List<Product> products = productService.getProducts();
        return products;
    }
}
