package com.Practica.practicaSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping ({"/greet/{name}" , "/hi/{name}" })// Recibiendo un parametro dinamico desde la URL
    // Se le dice a la aplicacion que el parametro viene desde una URL
    // @PathVariable es muy util cuando se quiere acceder a valores dinamicos de una URL
    // para usarlos dentro de una aplicacion SpringBootl
    public String greeting(@PathVariable String name) {
        return "Hola " + name;
    }
}
