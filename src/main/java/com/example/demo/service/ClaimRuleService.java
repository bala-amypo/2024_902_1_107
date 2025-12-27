package com.example.demo.service;

import com.example.demo.model.DamageClaim;
import java.util.List;

public interface ClaimService {
    DamageClaim getClaim(Long id);
    DamageClaim evaluateClaim(Long id);
    List<DamageClaim> findAll();
}
