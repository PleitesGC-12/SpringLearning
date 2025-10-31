package com.Practica.practicaSpringBoot.controllers;

import com.Practica.practicaSpringBoot.model.Product;
import com.Practica.practicaSpringBoot.service.ProductService;
import com.Practica.practicaSpringBoot.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    /* Inyeccion por constructor funciona
    Creamos un campo de tipo interfaz

    private final ProductService productsService;


    // Aplicamos la inyeccion de dependencia por medio de constructor
    @Autowired
    public ProductController(ProductService productsService) {
        this.productsService = productsService;
    }

     */
    @Autowired
    private ProductService productsService;

    @GetMapping
    public List<Product> getProducts() {
        return productsService.getProducts();
    }
}
