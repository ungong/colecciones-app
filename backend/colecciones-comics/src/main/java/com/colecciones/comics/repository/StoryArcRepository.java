package com.colecciones.comics.repository;

import com.colecciones.comics.model.StoryArc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoryArcRepository extends JpaRepository<StoryArc, Long> {
    Optional<StoryArc> findByTitle(String title);
}
