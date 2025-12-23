package com.example.demo.controller;

import com.example.demo.entity.Evidence;
import com.example.demo.service.EvidenceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@Tag(name = "Evidence", description = "Evidence management endpoints")
public class EvidenceController {
    
    private final EvidenceService evidenceService;
    
    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }
    
    @PostMapping("/upload/{claimId}")
    public ResponseEntity<Evidence> uploadEvidence(@PathVariable Long claimId, @RequestBody Evidence evidence) {
        Evidence uploadedEvidence = evidenceService.uploadEvidence(claimId, evidence);
        return ResponseEntity.ok(uploadedEvidence);
    }
    
    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<Evidence>> getEvidenceForClaim(@PathVariable Long claimId) {
        List<Evidence> evidence = evidenceService.getEvidenceForClaim(claimId);
        return ResponseEntity.ok(evidence);
    }
}