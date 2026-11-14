package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    // APPLICATION, JOB, SYSTEM...
    @Column(length = 50)
    private String type;

    // Ví dụ: APPLICATION, JOB, COMMENT
    @Column(length = 50)
    private String referenceType;

    // ID của đối tượng liên quan
    private Long referenceId;

    @Column(nullable = false)
    private Boolean isRead = false;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}