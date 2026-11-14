package com.jobportal.entity;

import com.jobportal.enums.ApplicationStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "application_status_histories")
public class ApplicationStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private ApplicationStatus oldStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ApplicationStatus newStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by")
    private User changedBy;

    @Column(columnDefinition = "TEXT")
    private String note;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime changedAt;
}