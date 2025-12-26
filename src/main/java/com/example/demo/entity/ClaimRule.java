package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weight;

    public ClaimRule() {}

    public ClaimRule(double weight) {
        this.weight = weight;
    }

    public Long getId() { return id; }
    public double getWeight() { return weight; }

    public void setId(Long id) { this.id = id; }
    public void setWeight(double weight) { this.weight = weight; }
}
