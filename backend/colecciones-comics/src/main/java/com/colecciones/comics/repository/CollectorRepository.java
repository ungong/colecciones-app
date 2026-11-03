package com.colecciones.comics.repository;

import com.colecciones.comics.model.Collector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectorRepository extends JpaRepository<Collector, Long> {
    Optional<Collector> findByUsername(String username);
}