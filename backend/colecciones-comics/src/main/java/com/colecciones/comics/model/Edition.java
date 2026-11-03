package com.colecciones.comics.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "edition")
public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edition_id")
    private Long editionId;

    @Column(name = "isbn", length = 50)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "format", nullable = false)
    private EditionFormat format;

    // Relación con Issue (N Editions -> 1 Issue)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id", referencedColumnName = "issue_id", nullable = false)
    private Issue issue;

    // Relación con Publisher (N Editions -> 1 Publisher)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id", nullable = false)
    private Publisher publisher;

    // Relación con CollectionItem (1 Edition -> N CollectionItems)
    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollectionItem> collectionItems = new ArrayList<>();
}