package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;

public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepo;
    private final DamageClaimRepository claimRepo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimServiceImpl(ParcelRepository p, DamageClaimRepository c, ClaimRuleRepository r) {
        this.parcelRepo = p;
        this.claimRepo = c;
        this.ruleRepo = r;
    }

    public DamageClaim create(String trackingNumber, double amount) {
        Parcel parcel = parcelRepo.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new ResourceNotFoundException("parcel not found"));

        return claimRepo.save(new DamageClaim(parcel, amount));
    }
}
