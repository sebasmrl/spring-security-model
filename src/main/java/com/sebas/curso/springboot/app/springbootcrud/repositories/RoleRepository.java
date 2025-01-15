package com.sebas.curso.springboot.app.springbootcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sebas.curso.springboot.app.springbootcrud.entities.Role;
import java.util.Optional;



public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String name);
}
