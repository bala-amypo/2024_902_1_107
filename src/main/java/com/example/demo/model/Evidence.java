package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Evidence {

    @Id
    @GeneratedValue
    private Long id;

    private String fileUrl;

    private LocalDateTime uploadedAt = LocalDateTime.now();

    @ManyToOne
    private DamageClaim claim;

    // getters & setters
}
