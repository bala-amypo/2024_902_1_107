package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "claim_rules")
public class ClaimRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String conditionExpression;

    private Double weight;

    // Default constructor
    public ClaimRuleEntity() {
    }

    // Parameterized constructor
    public ClaimRuleEntity(String ruleName, String conditionExpression, Double weight) {
        this.ruleName = ruleName;
        this.conditionExpression = conditionExpression;
        this.weight = weight;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
