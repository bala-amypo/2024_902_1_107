package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DamageClaim claim;

    public Evidence() {}

    public Evidence(DamageClaim claim) {
        this.claim = claim;
    }

    public Long getId() { return id; }
    public DamageClaim getClaim() { return claim; }

    public void setId(Long id) { this.id = id; }
    public void setClaim(DamageClaim claim) { this.claim = claim; }
}
