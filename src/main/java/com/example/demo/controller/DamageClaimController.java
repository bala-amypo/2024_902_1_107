package com.example.demo.controller;

import com.example.demo.entity.DamageClaim;
import com.example.demo.service.DamageClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Damage Claims", description = "Damage claim management endpoints")
public class DamageClaimController {
    
    private final DamageClaimService damageClaimService;
    
    public DamageClaimController(DamageClaimService damageClaimService) {
        this.damageClaimService = damageClaimService;
    }
    
    @PostMapping("/file/{parcelId}")
    public ResponseEntity<DamageClaim> fileClaim(@PathVariable Long parcelId, @RequestBody DamageClaim claim) {
        DamageClaim filedClaim = damageClaimService.fileClaim(parcelId, claim);
        return ResponseEntity.ok(filedClaim);
    }
    
    @PutMapping("/evaluate/{claimId}")
    public ResponseEntity<DamageClaim> evaluateClaim(@PathVariable Long claimId) {
        DamageClaim evaluatedClaim = damageClaimService.evaluateClaim(claimId);
        return ResponseEntity.ok(evaluatedClaim);
    }
    
    @GetMapping("/{claimId}")
    public ResponseEntity<DamageClaim> getClaim(@PathVariable Long claimId) {
        DamageClaim claim = damageClaimService.getClaim(claimId);
        return ResponseEntity.ok(claim);
    }
}