package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepo;
    private final DamageClaimRepository claimRepo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimServiceImpl(
            ParcelRepository parcelRepo,
            DamageClaimRepository claimRepo,
            ClaimRuleRepository ruleRepo) {
        this.parcelRepo = parcelRepo;
        this.claimRepo = claimRepo;
        this.ruleRepo = ruleRepo;
    }

    @Override
    public DamageClaim fileClaim(long parcelId, DamageClaim c) {
        Parcel p = parcelRepo.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        c.setParcel(p);
        c.setStatus("PENDING");
        return claimRepo.save(c);
    }

    @Override
    public DamageClaim evaluateClaim(long claimId) {
        DamageClaim c = claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        double score = RuleEngineUtil.computeScore(
                c.getClaimDescription(),
                ruleRepo.findAll()
        );

        c.setScore(score);
        c.setStatus(score > 0.9 ? "APPROVED" : "REJECTED");
        return claimRepo.save(c);
    }

    @Override
    public DamageClaim getClaim(long claimId) {
        return claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}
