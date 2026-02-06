package com.kauanunes.github_practices_analyzer.shared;

import com.kauanunes.github_practices_analyzer.domain.model.MetricSnapshot;
import com.kauanunes.github_practices_analyzer.infrastructure.github.dto.GitHubRepoDto;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public final class MetricCalculator {

    private MetricCalculator() {}

    public static MetricSnapshot calculate(List<GitHubRepoDto> repos) {

        int total = repos.size();

        if (total == 0) {
            return new MetricSnapshot(0, 0, 0.0, null);
        }

        int withReadme = (int) repos.stream()
                .filter(r -> r.getDescription() != null && !r.getDescription().isBlank())
                .count();

        double abandonmentRate = repos.stream()
                .filter(r ->
                        Duration.between(r.getUpdatedAt(), Instant.now()).toDays() > 180
                )
                .count() / (double) total;

        // IMPORTANTE NÃO é commit frequency
        // É tempo médio desde última atualização
        double avgDaysSinceLastUpdate = repos.stream()
                .map(GitHubRepoDto::getUpdatedAt)
                .map(updatedAt -> Duration.between(updatedAt, Instant.now()).toDays())
                .mapToLong(Long::longValue)
                .average()
                .orElse(Double.NaN);

        return new MetricSnapshot(
                total,
                withReadme,
                abandonmentRate,
                avgDaysSinceLastUpdate
        );
    }
}
