package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Evidence;
import com.example.demo.repository.EvidenceClaimRepository;

import java.util.List;

@Service
public class EvidenceServiceImpl {

    private final EvidenceClaimRepository evidenceClaimRepository;

    @Autowired
    public EvidenceServiceImpl(EvidenceClaimRepository evidenceClaimRepository) {
        this.evidenceClaimRepository = evidenceClaimRepository;
    }

    public Evidence saveEvidence(Evidence evidence) {
        return evidenceClaimRepository.save(evidence);
    }

    public List<Evidence> getAllEvidence() {
        return evidenceClaimRepository.findAll();
    }
}
