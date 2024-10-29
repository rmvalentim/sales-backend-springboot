package br.com.rafaelvalentim.Sales.repositories;

import br.com.rafaelvalentim.Sales.entities.ItemGroup;
import org.springframework.data.repository.CrudRepository;

public interface ItemGroupRepository extends CrudRepository<ItemGroup, Integer> {
}