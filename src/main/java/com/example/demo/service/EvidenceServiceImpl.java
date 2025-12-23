package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Evidence;
import com.example.demo.repository.EvidenceRepository;

import java.util.List;

@Service
public class EvidenceServiceImpl {

    private final EvidenceRepository evidenceRepository;

    @Autowired
    public EvidenceServiceImpl(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    public Evidence saveEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    public List<Evidence> getAllEvidence() {
        return evidenceRepository.findAll();
    }
}
