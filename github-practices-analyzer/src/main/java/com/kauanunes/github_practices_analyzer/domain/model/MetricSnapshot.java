package com.kauanunes.github_practices_analyzer.domain.model;

public class MetricSnapshot {

    private final int totalRepositories;
    private final int repositoriesWithReadme;
    private final double repositoryAbandonmentRate;
    private final Double averageDaysBetweenCommits;

    public MetricSnapshot(
            int totalRepositories,
            int repositoriesWithReadme,
            double repositoryAbandonmentRate,
            Double averageDaysBetweenCommits
    ) {
        this.totalRepositories = totalRepositories;
        this.repositoriesWithReadme = repositoriesWithReadme;
        this.repositoryAbandonmentRate = repositoryAbandonmentRate;
        this.averageDaysBetweenCommits = averageDaysBetweenCommits;
    }

    public int getTotalRepositories() {
        return totalRepositories;
    }

    public int getRepositoriesWithReadme() {
        return repositoriesWithReadme;
    }

    public double getRepositoryAbandonmentRate() {
        return repositoryAbandonmentRate;
    }

    public double getAverageDaysBetweenCommits() {
        return averageDaysBetweenCommits;
    }

    public boolean hasRepositories() {
        return totalRepositories > 0;
    }

    public boolean hasCommitHistoryMetrics() {
        return averageDaysBetweenCommits != null;
    }
}
