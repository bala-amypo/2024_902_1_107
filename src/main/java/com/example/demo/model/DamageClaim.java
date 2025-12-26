package com.example.demo.entity;

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

    @ManyToMany
    private List<ClaimRule> appliedRules = new ArrayList<>();

    public DamageClaim() {}

    public Long getId() { return id; }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<ClaimRule> getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(List<ClaimRule> appliedRules) {
        this.appliedRules = appliedRules;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
