package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String text, List<ClaimRule> rules) {
        double score = 0.0;

        if (text == null || rules == null) {
            return score;
        }

        for (ClaimRule rule : rules) {
            if (rule.getKeyword() != null && text.contains(rule.getKeyword())) {
                score += rule.getWeight();
            }
        }
        return score;
    }
}
