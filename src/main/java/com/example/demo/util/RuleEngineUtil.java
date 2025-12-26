package com.example.demo.util;

import com.example.demo.entity.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String description, List<ClaimRule> rules) {

        if (description == null || rules == null) return 0.0;

        double score = 0.0;
        String text = description.toLowerCase();

        for (ClaimRule rule : rules) {
            if (rule.getKeyword() != null &&
                text.contains(rule.getKeyword().toLowerCase())) {
                score += rule.getWeight();
            }
        }
        return Math.min(score, 1.0);
    }
}
