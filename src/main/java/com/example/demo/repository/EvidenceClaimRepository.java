package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Evidence;

@Repository
public interface EvidenceClaimRepository extends JpaRepository<Evidence, Long> {
}
