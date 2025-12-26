package com.example.demo.util;

import com.example.demo.model.ClaimRule;

import java.util.List;

public class RuleEngineUtil {

    /**
     * Computes a score for a damage claim based on description keywords
     * and configured claim rules.
     *
     * @param description claim description text
     * @param rules list of rules
     * @return score between 0.0 and 1.0
     */
    public static double computeScore(String description, List<ClaimRule> rules) {

        if (description == null || description.isBlank() || rules == null || rules.isEmpty()) {
            return 0.0;
        }

        String lowerDesc = description.toLowerCase();
        double totalScore = 0.0;

        for (ClaimRule rule : rules) {

            if (rule.getKeyword() == null) {
                continue;
            }

            if (lowerDesc.contains(rule.getKeyword().toLowerCase())) {
                totalScore += rule.getWeight();
            }
        }

        // Cap score at 1.0 (important for APPROVED test cases)
        return Math.min(totalScore, 1.0);
    }
}
