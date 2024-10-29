package br.com.rafaelvalentim.Sales.repositories;


import org.springframework.data.repository.CrudRepository;
import br.com.rafaelvalentim.Sales.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
