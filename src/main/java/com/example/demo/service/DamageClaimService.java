package com.example.demo.service;

import com.example.demo.model.DamageClaim;
import java.util.List;

public interface DamageClaimService {

    DamageClaim createClaim(Long parcelId, DamageClaim claim);

    List<DamageClaim> getAllClaims();
}
