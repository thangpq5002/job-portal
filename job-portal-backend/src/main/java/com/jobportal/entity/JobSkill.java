package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "job_skills",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_job_skill",
            columnNames = {"job_id", "skill_id"}
        )
    }
)
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(nullable = false)
    private Boolean isRequired = true;
}