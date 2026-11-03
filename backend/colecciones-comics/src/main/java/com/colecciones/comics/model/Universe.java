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
@Table(name = "universe")
public class Universe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "universe_id")
    private Long universeId;

    @Column(name = "name", nullable = false, unique = true, length = 150)
    private String name;

    // Relación con Publisher (N Universes -> 1 Publisher)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    // Relación con Series (1 Universe -> N Series)
    @OneToMany(mappedBy = "universe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Series> series = new ArrayList<>();
}