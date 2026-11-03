//IssueCreator.java (Relación entre Issue y Creator)

package com.colecciones.comics.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issue_creator")
public class IssueCreator {
    @EmbeddedId
    private IssueCreatorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("issueId")
    @JoinColumn(name = "issue_id", referencedColumnName = "issue_id", nullable = false)
    private Issue issue;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("creatorId")
    @JoinColumn(name = "creator_id", referencedColumnName = "creator_id", nullable = false)
    private Creator creator;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, insertable = false, updatable = false)
    private CreatorRole role;
}
