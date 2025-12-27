package com.example.demo.service;

import com.example.demo.model.DamageClaim;
import java.util.List;

public interface ClaimService {

    DamageClaim fileClaim(long parcelId, DamageClaim claim);

    DamageClaim evaluateClaim(long claimId);

    DamageClaim getClaim(long id);

    List<DamageClaim> findAll();
}
