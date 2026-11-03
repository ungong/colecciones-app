//StoryArcIssue.java (Relación entre StoryArc y Issue)

package com.colecciones.comics.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "story_arc_issue")
public class StoryArcIssue {
    @EmbeddedId
    private StoryArcIssueId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("arcId")
    @JoinColumn(name = "arc_id", referencedColumnName = "arc_id", nullable = false)
    private StoryArc storyArc;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("issueId")
    @JoinColumn(name = "issue_id", referencedColumnName = "issue_id", nullable = false)
    private Issue issue;

    @Column(name = "reading_order")
    private Integer readingOrder;
}