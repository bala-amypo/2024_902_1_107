package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.service.ClaimRuleService;

public class ClaimRuleServiceImpl implements ClaimRuleService {

    private final ClaimRuleRepository repo;

    public ClaimRuleServiceImpl(ClaimRuleRepository repo) {
        this.repo = repo;
    }

    public ClaimRule save(ClaimRule rule) {
        if (rule.getWeight() < 0) {
            throw new BadRequestException("weight >= 0");
        }
        return repo.save(rule);
    }
}
