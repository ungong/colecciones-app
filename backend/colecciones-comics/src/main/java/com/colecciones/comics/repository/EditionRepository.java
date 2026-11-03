package com.colecciones.comics.repository;

import com.colecciones.comics.model.Edition;
import com.colecciones.comics.model.EditionFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Long> {
    List<Edition> findByIssueId(Long issueId);
    List<Edition> findByFormat(EditionFormat format);
    List<Edition> findByPublisherId(Long publisherId);
    List<Edition> findByIsbn(String isbn);
}