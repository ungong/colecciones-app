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
@Table(name = "issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Long issueId;

    @Column(name = "issue_number", nullable = false, length = 30)
    private String issueNumber;

    @Column(name = "title", length = 300)
    private String title;

    // Relación con Volume (N Issues -> 1 Volume)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volume_id", referencedColumnName = "volume_id", nullable = false)
    private Volume volume;

    // Relación con Edition (1 Issue -> N Editions)
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edition> editions = new ArrayList<>();

    // Relación con Character (1 Issue -> N Characters via IssueCharacter)
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IssueCharacter> issueCharacters = new ArrayList<>();

    // Relación con Creator (1 Issue -> N Creators via IssueCreator)
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IssueCreator> issueCreators = new ArrayList<>();

    // Relación con StoryArc (1 Issue -> N StoryArcs via StoryArcIssue)
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryArcIssue> storyArcIssues = new ArrayList<>();
}