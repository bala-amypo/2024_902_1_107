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

    @ElementCollection
    private List<String> appliedRules = new ArrayList<>();

    public DamageClaim() {}

    public Long getId() {
        return id;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public double getScore() {
        return score;
    }

    public List<String> getAppliedRules() {
        return appliedRules;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setAppliedRules(List<String> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
