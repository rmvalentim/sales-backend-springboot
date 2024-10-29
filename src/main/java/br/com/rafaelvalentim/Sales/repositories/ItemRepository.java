package br.com.rafaelvalentim.Sales.repositories;

import br.com.rafaelvalentim.Sales.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}