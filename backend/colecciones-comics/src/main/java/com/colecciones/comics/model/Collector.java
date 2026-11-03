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
@Table(name = "collector")
public class Collector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collector_id")
    private Long collectorId;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    // Relación con CollectionItem (1 Collector -> N CollectionItems)
    @OneToMany(mappedBy = "collector", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollectionItem> collectionItems = new ArrayList<>();
}