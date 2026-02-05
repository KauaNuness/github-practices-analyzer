package com.kauanunes.github_practices_analyzer.application;

import com.kauanunes.github_practices_analyzer.domain.heuristics.Heuristic;
import com.kauanunes.github_practices_analyzer.domain.model.AnalysisReport;
import com.kauanunes.github_practices_analyzer.domain.model.MetricSnapshot;
import com.kauanunes.github_practices_analyzer.infrastructure.github.GitHubClient;
import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import com.kauanunes.github_practices_analyzer.shared.MetricCalculator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AnalysisApplicationService {

    private final GitHubClient gitHubClient;
    private final List<Heuristic> heuristics;

    public AnalysisApplicationService(
            GitHubClient gitHubClient,
            List<Heuristic> heuristics
    ) {
        this.gitHubClient = gitHubClient;
        this.heuristics = heuristics;
    }

    public Mono<AnalysisReport> analyze(String username) {

        return gitHubClient.getRepositories(username)
                .collectList()
                .map(repos -> {
                    MetricSnapshot metrics = MetricCalculator.calculate(repos);
                    AnalysisContext context = new AnalysisContext(metrics);
                    heuristics.forEach(h -> h.analyze(context));
                    return context.build();
                });
    }
}
