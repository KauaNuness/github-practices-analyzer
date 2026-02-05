package com.kauanunes.github_practices_analyzer.domain.model;

public record Recommendation(
        String title,
        String context,
        String suggestion
) {
}
