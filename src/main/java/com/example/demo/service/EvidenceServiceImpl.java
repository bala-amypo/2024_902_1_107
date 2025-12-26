package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.service.EvidenceService;

public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepo;
    private final DamageClaimRepository claimRepo;

    public EvidenceServiceImpl(EvidenceRepository e, DamageClaimRepository c) {
        this.evidenceRepo = e;
        this.claimRepo = c;
    }

    public long count(Long claimId) {
        return evidenceRepo.countByClaim_Id(claimId);
    }
}
