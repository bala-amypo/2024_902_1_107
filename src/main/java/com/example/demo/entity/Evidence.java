package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "claim_id")
    private DamageClaim claim;
    
    private String evidenceType;
    private String filePath;
    private String description;
    private LocalDateTime uploadedAt;
    
    @PrePersist
    protected void onCreate() {
        uploadedAt = LocalDateTime.now();
    }
    
    public Evidence() {}
    
    public Evidence(DamageClaim claim, String evidenceType, String filePath, String description) {
        this.claim = claim;
        this.evidenceType = evidenceType;
        this.filePath = filePath;
        this.description = description;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public DamageClaim getClaim() { return claim; }
    public void setClaim(DamageClaim claim) { this.claim = claim; }
    
    public String getEvidenceType() { return evidenceType; }
    public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }
    
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
}