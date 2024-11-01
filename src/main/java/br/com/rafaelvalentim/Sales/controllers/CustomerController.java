package br.com.rafaelvalentim.Sales.controllers;

import br.com.rafaelvalentim.Sales.dtos.CustomerCreateDto;
import br.com.rafaelvalentim.Sales.entities.Customer;
import br.com.rafaelvalentim.Sales.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreateDto customerCreateDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerCreateDto));
    }
}
