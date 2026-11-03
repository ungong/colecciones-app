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
@Table(name = "series")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private Long seriesId;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    // Relación con Publisher (N Series -> 1 Publisher)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id", nullable = false)
    private Publisher publisher;

    // Relación con Universe (N Series -> 1 Universe)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "universe_id", referencedColumnName = "universe_id")
    private Universe universe;

    // Relación con Volume (1 Series -> N Volumes)
    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Volume> volumes = new ArrayList<>();
}