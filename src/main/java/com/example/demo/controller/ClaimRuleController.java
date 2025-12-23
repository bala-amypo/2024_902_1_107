package com.example.demo.controller;

import com.example.demo.entity.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Claim Rules", description = "Claim rule management endpoints")
public class ClaimRuleController {
    
    private final ClaimRuleService claimRuleService;
    
    public ClaimRuleController(ClaimRuleService claimRuleService) {
        this.claimRuleService = claimRuleService;
    }
    
    @PostMapping
    public ResponseEntity<ClaimRule> addRule(@RequestBody ClaimRule rule) {
        ClaimRule savedRule = claimRuleService.addRule(rule);
        return ResponseEntity.ok(savedRule);
    }
    
    @GetMapping
    public ResponseEntity<List<ClaimRule>> getAllRules() {
        List<ClaimRule> rules = claimRuleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
}