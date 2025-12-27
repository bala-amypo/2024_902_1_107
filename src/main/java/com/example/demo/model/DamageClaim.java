package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

public class DamageClaim {

    private Long id;
    private Parcel parcel;
    private String claimDescription;
    private String status;
    private Double score;
    private Set<ClaimRule> appliedRules;

    public DamageClaim() {
        this.status = "PENDING";                 // REQUIRED
        this.appliedRules = new HashSet<>();     // REQUIRED
        this.score = null;                       // MUST BE NULL
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Parcel getParcel() { return parcel; }
    public void setParcel(Parcel parcel) { this.parcel = parcel; }

    public String getClaimDescription() { return claimDescription; }
    public void setClaimDescription(String claimDescription) { this.claimDescription = claimDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Set<ClaimRule> getAppliedRules() { return appliedRules; }
}
