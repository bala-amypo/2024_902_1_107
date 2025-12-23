package com.example.demo.repository;

import com.example.demo.entity.ClaimRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRuleRepository extends JpaRepository<ClaimRule, Long> {
}