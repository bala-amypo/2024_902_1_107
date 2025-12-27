package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getExpression() { return expression; }
    public double getWeight() { return weight; }
}
