//IssueCreatorId.java (Clave compuesta para issue_creator)

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
public class IssueCreatorId implements Serializable {
    private Long issueId;
    private Long creatorId;
    private CreatorRole role; // Incluimos el rol como parte de la clave compuesta
}