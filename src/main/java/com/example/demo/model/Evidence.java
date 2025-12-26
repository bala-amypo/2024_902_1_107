package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @ManyToOne
    private DamageClaim claim;

    public Evidence() {}

    public Evidence(Long id, String fileName, DamageClaim claim) {
        this.id = id;
        this.fileName = fileName;
        this.claim = claim;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public DamageClaim getClaim() { return claim; }
    public void setClaim(DamageClaim claim) { this.claim = claim; }
}
