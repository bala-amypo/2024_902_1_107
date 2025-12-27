package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String text, List<ClaimRule> rules) {

        if (text == null || rules == null || rules.isEmpty()) return 0.0;

        double score = 0.0;
        String lower = text.toLowerCase();

        for (ClaimRule r : rules) {

            if (r.getExpression() == null) continue;

            if (r.getExpression().equalsIgnoreCase("always")) {
                score += r.getWeight();
            }
            else if (r.getExpression().startsWith("description_contains:")) {
                String key = r.getExpression().split(":")[1].toLowerCase();
                if (lower.contains(key)) score += r.getWeight();
            }
        }
        return score;
    }
}
