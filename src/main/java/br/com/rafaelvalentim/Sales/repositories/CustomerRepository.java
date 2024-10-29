package br.com.rafaelvalentim.Sales.repositories;

import br.com.rafaelvalentim.Sales.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
