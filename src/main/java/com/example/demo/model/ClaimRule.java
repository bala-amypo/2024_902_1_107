package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    private double weight;

    public ClaimRule() {}

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
