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
@Table(name = "creator")
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "full_name", nullable = false, length = 250)
    private String fullName;

    // Relación con IssueCreator (1 Creator -> N IssueCreator)
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IssueCreator> issueCreators = new ArrayList<>();

    // Relación con CharacterCreator (1 Creator -> N CharacterCreator)
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterCreator> characterCreators = new ArrayList<>();
}