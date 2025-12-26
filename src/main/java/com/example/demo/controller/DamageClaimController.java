package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class DamageClaimController {

    private final DamageClaimService claimService;

    public DamageClaimController(DamageClaimService claimService) {
        this.claimService = claimService;
    }

    // ================= FILE A CLAIM =================
    @PostMapping("/file/{parcelId}")
    public DamageClaim fileClaim(
            @PathVariable Long parcelId,
            @RequestBody DamageClaim claim) {

        return claimService.createClaim(parcelId, claim);
    }

    // ================= GET CLAIM BY ID =================
    @GetMapping("/{id}")
    public DamageClaim getClaim(@PathVariable Long id) {
        return claimService.getClaim(id);
    }

    // ================= GET ALL CLAIMS =================
    @GetMapping
    public List<DamageClaim> getAllClaims() {
        return claimService.getAllClaims();
    }
}
