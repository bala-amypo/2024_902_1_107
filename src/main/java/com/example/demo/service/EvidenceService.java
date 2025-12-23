package com.example.demo.service;

import com.example.demo.entity.Evidence;
import java.util.List;

public interface EvidenceService {
    Evidence saveEvidence(Evidence evidence);
    List<Evidence> getAllEvidence();
}
