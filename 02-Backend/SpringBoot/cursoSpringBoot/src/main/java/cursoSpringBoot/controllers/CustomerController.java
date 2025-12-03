package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123, "Gerardo Lopez", "gerardol", "contrasena123"),
            new Customer(456, "Alejandra Garcia", "alegarcia", "contrasena456"),
            new Customer(789, "Laura Sanchez", "lauras", "contrasena789"),
            new Customer(234, "Carlos Martinez", "carlosm", "contrasena234")
    ));

    @RequestMapping(method = RequestMethod.GET)
    // @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customers);
        // return customers;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    // @GetMapping(path = "/{name}")
    public ResponseEntity<?> getCustomer(@PathVariable String name){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getUsername().equals(name)){
                return ResponseEntity.ok(customers.get(i));
                //return customers.get(i);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el nombre: " + name);
        //return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    // @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customer){
        customers.add(customer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(customer.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(customer);
        //return ResponseEntity.created(location).build();
        //return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente: " + customer.getUsername());
        //return customer;
    }

    @RequestMapping(method = RequestMethod.PUT)
    // @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer customer){
        for(Customer c : customers){
            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
                //return ResponseEntity.ok("Cliente modificado correctamente: " + customer.getID());
                //return customer;
            }
        }

        return ResponseEntity.notFound().build();
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + customer.getID());
        //return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id){
        for(Customer c : customers){
            if (c.getID() == id){
                customers.remove(c);

                return ResponseEntity.noContent().build();
                //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente eliminado: " + c.getID());
                //return c;
            }
        }

        return ResponseEntity.notFound().build();
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + id);
        //return null;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    // @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity.ok("Cliente modificado: " + c.getUsername());
                //return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + customer.getID());
        //return null;
    }

}
