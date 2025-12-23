package com.example.demo.util;

import com.example.demo.entity.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
    
    public static double computeScore(String description, List<ClaimRule> rules) {
        double totalScore = 0.0;
        
        if (description == null || rules == null) {
            return totalScore;
        }
        
        String lowerDescription = description.toLowerCase();
        
        for (ClaimRule rule : rules) {
            if (rule.getKeyword() != null && 
                lowerDescription.contains(rule.getKeyword().toLowerCase())) {
                totalScore += rule.getWeight();
            }
        }
        
        return totalScore;
    }
}