package br.com.rafaelvalentim.Sales.services;

import br.com.rafaelvalentim.Sales.dtos.CustomerCreateDto;
import br.com.rafaelvalentim.Sales.entities.Customer;
import br.com.rafaelvalentim.Sales.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerCreateDto customerCreateDto) {
        Customer customer = new Customer()
                .setName(customerCreateDto.getName())
                .setDocument(customerCreateDto.getDocument());
        return customerRepository.save(customer);
    }
}
