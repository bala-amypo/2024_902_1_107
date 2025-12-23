package com.example.demo.repository;

import com.example.demo.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceClaimRepository extends JpaRepository<Evidence, Long> {
}
