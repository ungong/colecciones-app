package com.colecciones.comics.repository;

import com.colecciones.comics.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findByPublisherId(Long publisherId);
    List<Series> findByUniverseId(Long universeId);
    Optional<Series> findByTitle(String title);
}