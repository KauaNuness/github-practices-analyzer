package com.kauanunes.github_practices_analyzer.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetricSnapshot {

    private int totalRepositories;
    private int repositoriesWithReadme;
    private double averageCommitsPerWeek;
    private double averageDaysBetweenCommits;
    private double repositoryAbandonmentRate;
    private boolean meaningfulCommitMessages;

}
