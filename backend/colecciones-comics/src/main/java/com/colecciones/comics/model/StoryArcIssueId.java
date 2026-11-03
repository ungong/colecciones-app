//StoryArcIssueId.java (Clave compuesta para story_arc_issue)

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
public class StoryArcIssueId implements Serializable {
    private Long arcId;
    private Long issueId;
}
