package com.Practica.practicaSpringBoot.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Las clases controladoras son aquellas que se encargan de gestionar
las solicitudes http que llegan de parte del cliente */


@RestController
public class HelloWorldRestController {

    @GetMapping({"/hello", "/hw", "hola"}) // La ruta siempre empieza con un slash /
    public String helloWorld() {
        return "Hello World"; // Al hacer una solicitud get se devuelve este mensaje
    }
}
