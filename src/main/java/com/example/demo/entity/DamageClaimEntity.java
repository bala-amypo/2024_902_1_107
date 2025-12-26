package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "damage_claims")
public class DamageClaimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ParcelEntity parcel;

    private String claimDescription;

    private LocalDateTime filedAt;

    private String status = "PENDING";

    private Double score;

    @ManyToMany
    private Set<ClaimRuleEntity> appliedRules = new HashSet<>();

    // Default constructor
    public DamageClaimEntity() {
    }

    // Auto timestamp
    @PrePersist
    public void onCreate() {
        this.filedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParcelEntity getParcel() {
        return parcel;
    }

    public void setParcel(ParcelEntity parcel) {
        this.parcel = parcel;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public LocalDateTime getFiledAt() {
        return filedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Set<ClaimRuleEntity> getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(Set<ClaimRuleEntity> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
