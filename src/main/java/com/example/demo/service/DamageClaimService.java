package com.example.demo.service;

import com.example.demo.model.DamageClaim;
import org.springframework.stereotype.Service;

@Service
public class DamageClaimService {

    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        return claim;
    }

    public DamageClaim evaluateClaim(Long claimId) {
        return null;
    }

    public DamageClaim getClaim(Long claimId) {
        return null;
    }
}
