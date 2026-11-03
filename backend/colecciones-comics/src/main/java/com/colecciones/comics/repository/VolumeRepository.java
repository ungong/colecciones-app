package com.colecciones.comics.repository;

import com.colecciones.comics.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {
    List<Volume> findBySeriesId(Long seriesId);
}