package com.kauanunes.github_practices_analyzer.shared;

import com.kauanunes.github_practices_analyzer.domain.model.MetricSnapshot;
import com.kauanunes.github_practices_analyzer.infrastructure.github.dto.GitHubRepoDto;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public final class MetricCalculator {

    private MetricCalculator() {
    }

    public static MetricSnapshot calculate(List<GitHubRepoDto> repos) {

        int totalRepositories = repos.size();

        int repositoriesWithReadme = (int) repos.stream()
                .filter(r -> r.getDescription() != null && !r.getDescription().isBlank())
                .count();

        double repositoryAbandonmentRate = repos.stream()
                .filter(r ->
                        Duration.between(r.getUpdatedAt(), Instant.now()).toDays() > 100
                )
                .count() / (double) Math.max(totalRepositories, 1);

        double averageCommitsPerWeek = 0.0;
        double averageDaysBetweenCommits = 30.0;
        double meaningfulCommitRatio = 0.0;

        return new MetricSnapshot(
                totalRepositories,
                repositoriesWithReadme,
                averageCommitsPerWeek,
                averageDaysBetweenCommits,
                repositoryAbandonmentRate,
                meaningfulCommitRatio
        );
    }
}
