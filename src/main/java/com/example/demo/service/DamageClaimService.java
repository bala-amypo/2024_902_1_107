package com.example.demo.service;

import com.example.demo.model.DamageClaim;

public interface DamageClaimService {
    DamageClaim create(String trackingNumber, double amount);
}
