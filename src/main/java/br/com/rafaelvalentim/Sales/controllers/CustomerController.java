package br.com.rafaelvalentim.Sales.controllers;

import br.com.rafaelvalentim.Sales.dtos.CustomerCreateDto;
import br.com.rafaelvalentim.Sales.entities.Customer;
import br.com.rafaelvalentim.Sales.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @PreAuthorize(("isAuthenticated()"))
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreateDto customerCreateDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerCreateDto));
    }
}
