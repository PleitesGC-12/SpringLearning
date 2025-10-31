package com.Practica.practicaSpringBoot.controllers;
import com.Practica.practicaSpringBoot.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
// Establece una ruta base comun para todos los metodos de controlador
@RequestMapping("/clients") // Para eso borramos la parte del endpoint que establezca la ruta y solo dejamos la anotacion correspondiente
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Pleites", "gp412", "password123"),
            new Customer(456, "Alejandra Ortiz", "ale123", "siuuuu"),
            new Customer(789, "Monica Ramirez" , "monica99", "nouuuuu"),
            new Customer(91011, "Patricia Perez" , "patySii", "ohsiii")
    ));

    // @GetMapping("/clients") -- Como usamos RequestMapping quitamos esto
    @GetMapping
    public List<Customer> getCustomer() {
        return customers;
    }

    // @GetMapping("/clients/{username}") En este caso eliminamos la ruta pero dejamos el parametro
    @GetMapping("/{username}")
    public Customer getClient(@PathVariable String username) {
        for (Customer c : customers) {

            if (c.getUserName().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }
    // Agregamos post porque queremos agregar nuevos elementos a la base de datos
    /* Usamos requestbody para permitirnos recibir la informacion para agregar al nuevo cliente
    Esta informacion vendra en formato JSON */
    // @PostMapping("/clients") quitamos esto porque usamos RequestMapping
    @PostMapping
    public Customer postClient(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

   //  @PutMapping("/clients") // Actualiza la informacion ya existente
    @PutMapping
    public Customer putClient(@RequestBody Customer customer) { // Como pasamos la informacion por JSON usamos RequestBody
        for (Customer c: customers) {
            // Comparamos el customer dentro de la lista con el que le estemos pasando
            if (c.getId() == customer.getId()) {
                // Pedimos cada atributo de un customer
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null; // Luego vamos a corregir esto porque es mala practica
    }

    // En este caso el usuario debe proporcionar el id del usuario a eliminar
    // Esto se logra pasandolo como parametro por medio de la URL
    // @DeleteMapping("/clients/{id}")
    @DeleteMapping("/{id}")
    public Customer deleteClient(@PathVariable int id) {
        for (Customer c : customers) {

           if (c.getId() == id) {
               customers.remove(c); // La variable c contiene el cliente a eliminar
               return c;
           }
        }
        return null;
    }

    // Vamos a recibir un JSON para agregar la informacion a modificar
    // No recibimos parametro web para el id ya que lo vamos a especificar en el JSON
    //@PatchMapping("/clients")
    @PatchMapping
    public Customer patchClient(@RequestBody Customer customer) {
        for (Customer c: customers) {
            if (c.getId() == customer.getId()) {

                if (customer.getName() != null) { // Si trae informacion
                    c.setName(customer.getName());
                }

                if (customer.getUserName() != null) {
                    c.setUserName(customer.getUserName());
                }

                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }


}




