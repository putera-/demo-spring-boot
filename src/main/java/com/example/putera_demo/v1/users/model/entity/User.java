package com.example.putera_demo.v1.users.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Boolean verified;

    @Column(nullable = true)
    private String avatar;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @PrePersist
    protected void onCreate() {
        LocalDateTime createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        LocalDateTime updatedAt = LocalDateTime.now();
    }
}