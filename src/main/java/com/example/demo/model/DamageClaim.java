package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Parcel parcel;

    private String claimDescription;

    private LocalDateTime filedAt;

    private String status = "PENDING";

    private Double score = 0.0;

    @ManyToMany
    private List<ClaimRule> appliedRules;

    @PrePersist
    public void onCreate() {
        filedAt = LocalDateTime.now();
    }

    
}
