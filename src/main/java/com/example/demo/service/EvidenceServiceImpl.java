package com.example.demo.service;

import com.example.demo.entity.Evidence;
import com.example.demo.entity.DamageClaim;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EvidenceRepository;
import com.example.demo.repository.DamageClaimRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    
    private final EvidenceRepository evidenceRepository;
    private final DamageClaimRepository damageClaimRepository;
    
    public EvidenceServiceImpl(EvidenceRepository evidenceRepository, 
                               DamageClaimRepository damageClaimRepository) {
        this.evidenceRepository = evidenceRepository;
        this.damageClaimRepository = damageClaimRepository;
    }
    
    @Override
    public Evidence uploadEvidence(Long claimId, Evidence evidence) {
        DamageClaim claim = damageClaimRepository.findById(claimId)
            .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
        
        evidence.setClaim(claim);
        return evidenceRepository.save(evidence);
    }
    
    @Override
    public List<Evidence> getEvidenceForClaim(Long claimId) {
        return evidenceRepository.findByClaim_Id(claimId);
    }
}