package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EvidenceService;

import java.util.List;

public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepo;
    private final DamageClaimRepository claimRepo;

    public EvidenceServiceImpl(EvidenceRepository evidenceRepo,
                               DamageClaimRepository claimRepo) {
        this.evidenceRepo = evidenceRepo;
        this.claimRepo = claimRepo;
    }

    @Override
    public Evidence uploadEvidence(Long claimId, Evidence e) {
        DamageClaim c = claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        e.setClaim(c);
        return evidenceRepo.save(e);
    }

    @Override
    public List<Evidence> getEvidenceForClaim(Long claimId) {
        return evidenceRepo.findByClaim_Id(claimId);
    }
}
