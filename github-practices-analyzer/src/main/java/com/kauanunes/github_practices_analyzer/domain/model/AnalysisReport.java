package com.kauanunes.github_practices_analyzer.domain.model;

import java.util.List;

public record AnalysisReport(
        List<Strength> strengths,
        List<Recommendation> recommendations

) {
}
