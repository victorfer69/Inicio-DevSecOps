package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Lopez", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra Garcia", "alegarcia", "contrasena456"),
            new Customer(789, "Laura Sanchez", "lauras", "contrasena789"),
            new Customer(234, "Carlos Martinez", "carlosm", "contrasena234")
    ));

    @GetMapping(path = "/clientes")
    public List<Customer> getCustomers(){
        return customers;
    }

    @GetMapping(path = "/clientes/{name}")
    public Customer getCustomer(@PathVariable String name){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getUsername().equals(name)){
                return customers.get(i);
            }
        }
        return null;
    }

    @PostMapping(path = "/clientes")
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    @PutMapping(path = "/clientes")
    public Customer putCliente(@RequestBody Customer customer){
        for(Customer c : customers){
            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return customer;
            }
        }
        return null;
    }

    @DeleteMapping(path = "/clientes/{id}")
    public Customer deleteCliente(@PathVariable int id){
        for(Customer c : customers){
            if (c.getID() == id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

}
