package com.kauanunes.github_practices_analyzer.domain.model;

import com.kauanunes.github_practices_analyzer.shared.SimpleItem;

import java.util.List;

public record AnalysisReport(
        List<SimpleItem> strengths,
        List<Recommendation> recommendations
) {}
