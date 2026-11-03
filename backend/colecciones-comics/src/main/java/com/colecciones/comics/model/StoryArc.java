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
@Table(name = "story_arc")
public class StoryArc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arc_id")
    private Long arcId;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    // Relación con Issue (1 StoryArc -> N Issues via StoryArcIssue)
    @OneToMany(mappedBy = "storyArc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryArcIssue> storyArcIssues = new ArrayList<>();
}