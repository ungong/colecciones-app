//CharacterCreator.java (Relación entre Character y Creator)

package com.colecciones.comics.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "character_creator")
public class CharacterCreator {
    @EmbeddedId
    private CharacterCreatorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("characterId")
    @JoinColumn(name = "character_id", referencedColumnName = "character_id", nullable = false)
    private Character character;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("creatorId")
    @JoinColumn(name = "creator_id", referencedColumnName = "creator_id", nullable = false)
    private Creator creator;

    @Column(name = "contribution", length = 100)
    private String contribution;
}