package com.example.demo.service;

import com.example.demo.model.Evidence;
import java.util.List;

public interface EvidenceService {

    Evidence uploadEvidence(long claimId, Evidence evidence);

    Evidence uploadVideo(long claimId);

    List<Evidence> getEvidenceForClaim(long claimId);
}
