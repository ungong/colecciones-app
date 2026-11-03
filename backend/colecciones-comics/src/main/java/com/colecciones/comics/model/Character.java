package com.colecciones.comics.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long characterId;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "alter_ego", length = 200)
    private String alterEgo;

    // Relación con Issue (1 Character -> N Issues via IssueCharacter)
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IssueCharacter> issueCharacters = new ArrayList<>();

    // Relación con CharacterCreator (1 Character -> N CharacterCreators)
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterCreator> characterCreators = new ArrayList<>();

    // Relación con CollectionItem (opcional, si un personaje está asociado a una colección)
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IssueCharacter> appearances = new ArrayList<>();
}