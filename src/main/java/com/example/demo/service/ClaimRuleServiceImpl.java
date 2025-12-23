package com.example.demo.service;

import com.example.demo.entity.ClaimRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ClaimRuleRepository;
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
        if (rule.getWeight() <= 0) {
            throw new BadRequestException("Weight must be positive");
        }
        
        return claimRuleRepository.save(rule);
    }
    
    @Override
    public List<ClaimRule> getAllRules() {
        return claimRuleRepository.findAll();
    }
}