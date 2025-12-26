package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    // ================= ADD EVIDENCE =================
    @PostMapping("/{claimId}")
    public Evidence addEvidence(
            @PathVariable Long claimId,
            @RequestBody Evidence evidence) {

        return evidenceService.addEvidence(claimId, evidence);
    }

    // ================= GET EVIDENCE BY CLAIM =================
    @GetMapping("/{claimId}")
    public List<Evidence> getEvidenceByClaim(
            @PathVariable Long claimId) {

        return evidenceService.getEvidenceByClaim(claimId);
    }
}
