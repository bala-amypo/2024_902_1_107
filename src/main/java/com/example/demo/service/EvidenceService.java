package com.example.demo.service;

import com.example.demo.model.Evidence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceService {

    public Evidence uploadEvidence(Long claimId, Evidence evidence) {
        return evidence;
    }

    public List<Evidence> getEvidenceForClaim(Long claimId) {
        return List.of();
    }
}
