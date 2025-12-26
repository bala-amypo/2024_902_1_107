package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class EvidenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DamageClaimEntity claim;

    private String evidenceType;

    private String fileUrl;

    private LocalDateTime uploadedAt;

    // Default constructor
    public EvidenceEntity() {
    }

    // Auto timestamp
    @PrePersist
    public void onUpload() {
        this.uploadedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public DamageClaimEntity getClaim() {
        return claim;
    }

    public void setClaim(DamageClaimEntity claim) {
        this.claim = claim;
    }

    public String getEvidenceType() {
        return evidenceType;
    }

    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }
}
