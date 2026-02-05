package com.kauanunes.github_practices_analyzer.shared;

import com.kauanunes.github_practices_analyzer.domain.model.AnalysisReport;
import com.kauanunes.github_practices_analyzer.domain.model.MetricSnapshot;
import com.kauanunes.github_practices_analyzer.domain.model.Recommendation;
import com.kauanunes.github_practices_analyzer.domain.model.Strength;

import java.util.ArrayList;
import java.util.List;

public class AnalysisContext {

    private final MetricSnapshot metrics;
    private final List<Strength> strengths = new ArrayList<>();
    private final List<Recommendation> recommendations = new ArrayList<>();

    public AnalysisContext(MetricSnapshot metrics) {
        this.metrics = metrics;
    }
    public MetricSnapshot metrics() {
        return metrics;
    }

    public void strength(Strength strength) {
        strengths.add(strength);
    }

    public void recommend(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public AnalysisReport build() {
        return new AnalysisReport(strengths, recommendations);
    }

}
