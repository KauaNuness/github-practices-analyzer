package com.kauanunes.github_practices_analyzer.domain.model;

public record MetricSnapshot(
        int totalRepositories,
        int repositoriesWithReadme,
        double abandonmentRate,
        Double avgDaysBetweenUpdates
) {

    public double readmeCoverage() {
        if (totalRepositories == 0) return 0;
        return (double) repositoriesWithReadme / totalRepositories;
    }

    public boolean hasCommitHistoryMetrics() {
        return avgDaysBetweenUpdates != null;
    }
}
