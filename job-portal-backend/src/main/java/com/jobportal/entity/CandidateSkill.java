package com.jobportal.entity;

import com.jobportal.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
    name = "candidate_skills",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_candidate_skill",
            columnNames = {"candidate_profile_id", "skill_id"}
        )
    }
)
public class CandidateSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidate_profile_id", nullable = false)
    private CandidateProfile candidateProfile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private SkillLevel skillLevel;

    @Column(nullable = false)
    private Integer yearsExperience = 0;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}