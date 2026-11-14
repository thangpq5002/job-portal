package com.jobportal.entity;

import com.jobportal.enums.ApplicationStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
    name = "applications",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_candidate_job_application",
            columnNames = {"candidate_profile_id", "job_id"}
        )
    }
)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidate_profile_id", nullable = false)
    private CandidateProfile candidateProfile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column(columnDefinition = "TEXT")
    private String coverLetter;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @Column(columnDefinition = "TEXT")
    private String recruiterNote;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime appliedAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}