//IssueCharacter.java (Relación entre Issue y Character)

package com.colecciones.comics.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issue_character")
public class IssueCharacter {
    @EmbeddedId
    private IssueCharacterId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("issueId") // Mapea issueId de IssueCharacterId a issue.issue_id
    @JoinColumn(name = "issue_id", referencedColumnName = "issue_id", nullable = false)
    private Issue issue;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("characterId") // Mapea characterId de IssueCharacterId a character.character_id
    @JoinColumn(name = "character_id", referencedColumnName = "character_id", nullable = false)
    private Character character;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private CharacterRole role;
}