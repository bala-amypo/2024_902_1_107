package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;

import java.util.List;

public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepo;
    private final DamageClaimRepository claimRepo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimServiceImpl(ParcelRepository parcelRepo,
                                  DamageClaimRepository claimRepo,
                                  ClaimRuleRepository ruleRepo) {
        this.parcelRepo = parcelRepo;
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim c) {
        Parcel p = parcelRepo.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        c.setParcel(p);
        c.setStatus("PENDING");
        return claimRepo.save(c);
    }

    @Override
    public DamageClaim evaluateClaim(Long id) {
        DamageClaim c = claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        List<ClaimRule> rules = ruleRepo.findAll();
        double score = RuleEngineUtil.computeScore(c.getClaimDescription(), rules);

        c.setScore(score);
        c.setStatus(score > 0.9 ? "APPROVED" : "REJECTED");
        return claimRepo.save(c);
    }

    @Override
    public DamageClaim getClaim(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}
