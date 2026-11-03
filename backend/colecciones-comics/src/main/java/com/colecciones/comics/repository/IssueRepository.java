package com.colecciones.comics.repository;

import com.colecciones.comics.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByVolumeId(Long volumeId);
    List<Issue> findByTitleContaining(String title);
}