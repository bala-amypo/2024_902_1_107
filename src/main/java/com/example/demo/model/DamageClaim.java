package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimDescription;

    private double score;

    private String status;

    @ManyToOne
    private Parcel parcel;

    @ElementCollection
    private List<String> appliedRules = new ArrayList<>();

    public DamageClaim() {}

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public double getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public List<String> getAppliedRules() {
        return appliedRules;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public void setAppliedRules(List<String> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
