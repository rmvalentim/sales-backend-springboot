package br.com.rafaelvalentim.Sales.repositories;

import br.com.rafaelvalentim.Sales.entities.Role;
import br.com.rafaelvalentim.Sales.entities.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
