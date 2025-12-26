package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    private double weight;

    public ClaimRule() {}

    public ClaimRule(Long id, String keyword, double weight) {
        this.id = id;
        this.keyword = keyword;
        this.weight = weight;
    }

    public Long getId() { return id; }

    public String getKeyword() { return keyword; }

    public double getWeight() { return weight; }

    public void setKeyword(String keyword) { this.keyword = keyword; }

    public void setWeight(double weight) { this.weight = weight; }
}
