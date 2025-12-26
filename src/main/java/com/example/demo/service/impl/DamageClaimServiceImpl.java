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

    private final DamageClaimRepository damageClaimRepository;
    private final ParcelRepository parcelRepository;
    private final ClaimRuleRepository claimRuleRepository;

    public DamageClaimServiceImpl(
            DamageClaimRepository damageClaimRepository,
            ParcelRepository parcelRepository,
            ClaimRuleRepository claimRuleRepository) {

        this.damageClaimRepository = damageClaimRepository;
        this.parcelRepository = parcelRepository;
        this.claimRuleRepository = claimRuleRepository;
    }

    // ================= CREATE CLAIM =================
    @Override
    public DamageClaim createClaim(Long parcelId, DamageClaim claim) {

        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus("PENDING");

        List<ClaimRule> rules = claimRuleRepository.findAll();

        double score = RuleEngineUtil.computeScore(
                claim.getClaimDescription(), rules);

        claim.setScore(score);

        rules.forEach(rule ->
                claim.getAppliedRules().add(rule.getKeyword()));

        if (score > 5) {
            claim.setStatus("APPROVED");
        } else {
            claim.setStatus("REJECTED");
        }

        return damageClaimRepository.save(claim);
    }

    // ================= GET CLAIM BY ID =================
    @Override
    public DamageClaim getClaim(Long id) {
        return damageClaimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Damage claim not found"));
    }

    // ================= GET ALL CLAIMS =================
    @Override
    public List<DamageClaim> getAllClaims() {
        return damageClaimRepository.findAll();
    }
}
