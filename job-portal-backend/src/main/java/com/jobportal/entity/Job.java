package com.jobportal.entity;

import com.jobportal.enums.ExperienceLevel;
import com.jobportal.enums.JobStatus;
import com.jobportal.enums.JobType;
import com.jobportal.enums.WorkMode;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, unique = true, length = 220)
    private String slug;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String requirements;

    @Column(columnDefinition = "TEXT")
    private String benefits;

    @Column(nullable = false)
    private Integer quantity = 1;

    @Column(precision = 15, scale = 2)
    private BigDecimal minSalary;

    @Column(precision = 15, scale = 2)
    private BigDecimal maxSalary;

    @Column(length = 10)
    private String currency = "VND";

    @Column(nullable = false)
    private Boolean salaryNegotiable = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private WorkMode workMode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ExperienceLevel experienceLevel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private JobStatus status = JobStatus.DRAFT;

    private LocalDate deadline;

    private LocalDate publishedAt;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(nullable = false)
    private Integer applicationCount = 0;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}