package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue
    private Long id;

    private String claimDescription;
    private String status = "PENDING";
    private Double score;

    @ManyToOne
    private Parcel parcel;

    @ManyToMany
    private Set<ClaimRule> appliedRules = new HashSet<>();

    // getters & setters
}
