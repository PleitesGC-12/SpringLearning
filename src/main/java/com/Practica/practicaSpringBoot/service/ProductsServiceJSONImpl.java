package com.Practica.practicaSpringBoot.service;

import com.Practica.practicaSpringBoot.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper; // La biblioteca jackson requiere un constructor por defecto
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary // Sirve para darle prioridad a este servicio, para evitar el error de que se encontraron dos bean de servicios
@Service
public class ProductsServiceJSONImpl implements ProductService{

    // Vamos a deserializar el json para que quede guardado como una lista en memoria
    @Override
    public List<Product> getProducts() {
        List<Product> products;

        try {
            products = new ObjectMapper().
                    readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});
            return products;

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
