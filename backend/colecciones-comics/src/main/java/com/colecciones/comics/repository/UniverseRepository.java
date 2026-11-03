package com.colecciones.comics.repository;

import com.colecciones.comics.model.Universe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniverseRepository extends JpaRepository<Universe, Long> {
    Optional<Universe> findByName(String name);
}