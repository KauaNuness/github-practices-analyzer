package com.kauanunes.github_practices_analyzer.shared;

import com.kauanunes.github_practices_analyzer.domain.model.MetricSnapshot;
import com.kauanunes.github_practices_analyzer.infrastructure.github.dto.GitHubRepoDto;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
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

        List<Instant> updates = repos.stream()
                .map(GitHubRepoDto::getUpdatedAt)
                .sorted(Comparator.reverseOrder())
                .toList();

        Double avgDaysBetweenUpdates = null;

        if (updates.size() > 1) {
            long totalDays = 0;
            for (int i = 0; i < updates.size() - 1; i++) {
                totalDays += Duration.between(updates.get(i + 1), updates.get(i)).toDays();
            }
            avgDaysBetweenUpdates = totalDays / (double) (updates.size() - 1);
        }

        return new MetricSnapshot(
                total,
                withReadme,
                abandonmentRate,
                avgDaysBetweenUpdates
        );
    }
}
