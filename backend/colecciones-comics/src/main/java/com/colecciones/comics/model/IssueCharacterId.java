//IssueCharacterId.java (Clave compuesta para issue_character)

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
public class IssueCharacterId implements Serializable {
    private Long issueId;
    private Long characterId;
}