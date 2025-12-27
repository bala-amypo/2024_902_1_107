package com.example.demo.service;

import com.example.demo.model.DamageClaim;
import java.util.List;

public interface DamageClaimService extends ClaimService {
    DamageClaim fileClaim(Long parcelId, DamageClaim claim);
}
