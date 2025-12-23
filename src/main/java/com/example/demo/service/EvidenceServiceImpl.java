package com.example.demo.service.impl;

import com.example.demo.entity.Evidence;
import com.example.demo.repository.EvidenceClaimRepository;
import com.example.demo.service.EvidenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 VERY IMPORTANT
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceClaimRepository evidenceRepository;

    public EvidenceServiceImpl(EvidenceClaimRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @Override
    public Evidence saveEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override
    public List<Evidence> getAllEvidence() {
        return evidenceRepository.findAll();
    }
}
