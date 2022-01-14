package com.example.password.Entity;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Repository extends CrudRepository<Entity, Long> {

    Optional<Entity> findByName(String name);

}
