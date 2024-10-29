package br.com.rafaelvalentim.Sales.repositories;

import br.com.rafaelvalentim.Sales.entities.OrderLine;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine, Integer> {
}
