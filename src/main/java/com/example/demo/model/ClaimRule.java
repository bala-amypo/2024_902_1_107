package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClaimRule {

    @Id
    @GeneratedValue
    private Long id;

    private String ruleName;
    private String expression;
    private double weight;

    public ClaimRule() {}

    public ClaimRule(String ruleName, String expression, double weight) {
        this.ruleName = ruleName;
        this.expression = expression;
        this.weight = weight;
    }

    // getters & setters
}
