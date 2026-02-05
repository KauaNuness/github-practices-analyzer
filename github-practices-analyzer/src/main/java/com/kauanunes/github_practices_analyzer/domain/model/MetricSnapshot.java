package com.kauanunes.github_practices_analyzer.domain.model;

public class MetricSnapshot {

    private final int totalRepositories;
    private final int repositoriesWithReadme;
    private final double averageCommitsPerWeek;
    private final double averageDaysBetweenCommits;
    private final double repositoryAbandonmentRate;
    private final double meaningfulCommitRatio;

    public MetricSnapshot(
            int totalRepositories,
            int repositoriesWithReadme,
            double averageCommitsPerWeek,
            double averageDaysBetweenCommits,
            double repositoryAbandonmentRate,
            double meaningfulCommitRatio
    ) {
        this.totalRepositories = totalRepositories;
        this.repositoriesWithReadme = repositoriesWithReadme;
        this.averageCommitsPerWeek = averageCommitsPerWeek;
        this.averageDaysBetweenCommits = averageDaysBetweenCommits;
        this.repositoryAbandonmentRate = repositoryAbandonmentRate;
        this.meaningfulCommitRatio = meaningfulCommitRatio;
    }

    public int getTotalRepositories() {
        return totalRepositories;
    }

    public int getRepositoriesWithReadme() {
        return repositoriesWithReadme;
    }

    public double getAverageCommitsPerWeek() {
        return averageCommitsPerWeek;
    }

    public double getAverageDaysBetweenCommits() {
        return averageDaysBetweenCommits;
    }

    public double getRepositoryAbandonmentRate() {
        return repositoryAbandonmentRate;
    }

    public double getMeaningfulCommitRatio() {
        return meaningfulCommitRatio;
    }
}
