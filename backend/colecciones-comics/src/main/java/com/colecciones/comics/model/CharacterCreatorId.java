//CharacterCreatorId.java (Clave compuesta para character_creator)

package com.colecciones.comics.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CharacterCreatorId implements Serializable {
    private Long characterId;
    private Long creatorId;
}