//CollectionItem.java (Elemento de la colección)
package com.colecciones.comics.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collection_item")
public class CollectionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_item_id")
    private Long collectionItemId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CollectionStatus status;

    @Column(name = "quantity", columnDefinition = "INT DEFAULT 1")
    private int quantity = 1;

    // Relación con Collector (N CollectionItems -> 1 Collector)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collector_id", referencedColumnName = "collector_id", nullable = false)
    private Collector collector;

    // Relación con Edition (N CollectionItems -> 1 Edition)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition_id", referencedColumnName = "edition_id", nullable = false)
    private Edition edition;
}