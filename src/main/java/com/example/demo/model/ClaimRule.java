package com.example.demo.model;

public class ClaimRule {

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
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}
