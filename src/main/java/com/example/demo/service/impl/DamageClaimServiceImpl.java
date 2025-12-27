package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository claimRepo;
    private final ParcelRepository parcelRepo;

    public DamageClaimServiceImpl(DamageClaimRepository claimRepo,
                                  ParcelRepository parcelRepo) {
        this.claimRepo = claimRepo;
        this.parcelRepo = parcelRepo;
    }

    @Override
    public DamageClaim createClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepo.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        claim.setParcel(parcel);
        return claimRepo.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long claimId) {
        return claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    @Override
    public List<DamageClaim> getAllClaims() {
        return claimRepo.findAll();
    }
}
