package com.example.demo.service.impl;

import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.service.ClaimRuleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimRuleServiceImpl implements ClaimRuleService {

    private final ClaimRuleRepository claimRuleRepository;

    public ClaimRuleServiceImpl(ClaimRuleRepository claimRuleRepository) {
        this.claimRuleRepository = claimRuleRepository;
    }

    @Override
    public ClaimRule addRule(ClaimRule rule) {
        return claimRuleRepository.save(rule);
    }

    @Override
    public ClaimRule getRule(Long id) {
        return claimRuleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("ClaimRule not found with id " + id));
    }

    @Override
    public List<ClaimRule> getAllRules() {
        return claimRuleRepository.findAll();
    }
}
