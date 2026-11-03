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
@Table(name = "volume")
public class Volume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volume_id")
    private Long volumeId;

    @Column(name = "volume_number", nullable = false)
    private int volumeNumber;

    // Relación con Series (N Volumes -> 1 Series)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", referencedColumnName = "series_id", nullable = false)
    private Series series;

    // Relación con Issue (1 Volume -> N Issues)
    @OneToMany(mappedBy = "volume", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Issue> issues = new ArrayList<>();
}