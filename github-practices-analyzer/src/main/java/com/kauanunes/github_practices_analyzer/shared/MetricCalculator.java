package com.kauanunes.github_practices_analyzer.shared;

import com.kauanunes.github_practices_analyzer.domain.model.MetricSnapshot;
import com.kauanunes.github_practices_analyzer.infrastructure.github.dto.GitHubRepoDto;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class MetricCalculator {

    private MetricCalculator(){}

    public static MetricSnapshot calculare(List<GitHubRepoDto> repos) {

        int total = repos.size();
        int withReadme = (int) repos.stream()
                .filter(r -> r.getDescription() != null && !r.getDescription().isBlank())
                .count();

        double abandonmentRate = repos.stream()
                .filter(r -> Duration.between(
                        r.getUpdatedAt(), Instant.now()).toDays() > 100)
                .count()/(double) Math.max(total, 1);

        return MetricSnapshot.builder()
                .totalRepositories(total)
                .repositoriesWithReadme(withReadme)
                .repositoryAbandonmentRate(abandonmentRate)
                .averageCommitsPerWeek(0.0) // evolui depois
                .averageDaysBetweenCommits(30.0) // placeholder calculável
                .meaningfulCommitMessages(false)
                .build();
    }

}
