package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.Evidence;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.EvidenceRepository;
import com.example.demo.service.EvidenceService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepo;
    private final DamageClaimRepository claimRepo;

    public EvidenceServiceImpl(
            EvidenceRepository evidenceRepo,
            DamageClaimRepository claimRepo) {
        this.evidenceRepo = evidenceRepo;
        this.claimRepo = claimRepo;
    }

    @Override
    public Evidence uploadEvidence(long claimId, Evidence e) {
        DamageClaim c = claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        e.setClaim(c);
        return evidenceRepo.save(e);
    }

    @Override
    public List<Evidence> getEvidenceForClaim(long claimId) {
        return evidenceRepo.findByClaim_Id(claimId);
    }

    
}
