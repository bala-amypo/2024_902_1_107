package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double evaluateScore(String text, List<ClaimRule> rules) {
        double score = 0;

        for (ClaimRule rule : rules) {
            if (text != null && text.contains(rule.getKeyword())) {
                score += rule.getWeight();
            }
        }
        return score;
    }
}
