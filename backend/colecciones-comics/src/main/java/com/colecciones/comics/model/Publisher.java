//Publisher.java (Editorial)

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
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "name", nullable = false, unique = true, length = 200)
    private String name;

    @Column(name = "country", length = 100)
    private String country;

    // Relación con Universe (1 Publisher -> N Universes)
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Universe> universes = new ArrayList<>();

    // Relación con Series (1 Publisher -> N Series)
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Series> series = new ArrayList<>();

    // Relación con Edition (1 Publisher -> N Editions)
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edition> editions = new ArrayList<>();
}
