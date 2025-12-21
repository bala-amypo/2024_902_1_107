package com.example.demo.service;

import com.example.demo.model.ClaimRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimRuleService {

    public ClaimRule addRule(ClaimRule rule) {
        return rule;
    }

    public List<ClaimRule> getAllRules() {
        return List.of();
    }
}
