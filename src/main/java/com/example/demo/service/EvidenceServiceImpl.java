package com.example.demo.service.impl;

import com.example.demo.entity.Evidence;
import com.example.demo.repository.EvidenceClaimRepository;
import com.example.demo.service.EvidenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceClaimRepository evidenceRepository;

    public EvidenceServiceImpl(EvidenceClaimRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @Override
    public Evidence uploadEvidence(Long claimId, Evidence evidence) {
        // simple save (claim mapping can be added later)
        return evidenceRepository.save(evidence);
    }

    @Override
    public List<Evidence> getEvidenceForClaim(Long claimId) {
        // temporary: return all evidence
        return evidenceRepository.findAll();
    }
}
