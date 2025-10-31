package com.Practica.practicaSpringBoot.service;
import com.Practica.practicaSpringBoot.domain.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


public class ProductsServiceImpl {
    ArrayList<Product> products = new ArrayList<>();

    public ProductsServiceImpl () {
        products.add(new Product(1, "Laptop" , 799.99, 10 ));
        products.add(new Product(2, "Smartpohone", 499.99 , 25));
        products.add(new Product(3, "Tablet", 299.99, 15));
        products.add(new Product(4, "Smartwatch", 199.99, 30));
    }

    public List<Product> getProducts() {
        return products;
    }

}
