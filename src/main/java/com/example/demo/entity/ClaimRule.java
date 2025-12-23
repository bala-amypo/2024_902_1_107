package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "claim_rules")
public class ClaimRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String keyword;
    private Double weight;
    
    public ClaimRule() {}
    
    public ClaimRule(String keyword, Double weight) {
        this.keyword = keyword;
        this.weight = weight;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
    
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
}