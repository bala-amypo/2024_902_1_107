package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Damage Claims")
public class DamageClaimController {

    private final DamageClaimService damageClaimService;

    public DamageClaimController(DamageClaimService damageClaimService) {
        this.damageClaimService = damageClaimService;
    }

    @PostMapping("/file/{parcelId}")
    public DamageClaim file(@PathVariable Long parcelId,
                            @RequestBody DamageClaim claim) {
        return damageClaimService.fileClaim(parcelId, claim);
    }

    @PutMapping("/evaluate/{claimId}")
    public DamageClaim evaluate(@PathVariable Long claimId) {
        return damageClaimService.evaluateClaim(claimId);
    }

    @GetMapping("/{claimId}")
    public DamageClaim get(@PathVariable Long claimId) {
        return damageClaimService.getClaim(claimId);
    }
}
