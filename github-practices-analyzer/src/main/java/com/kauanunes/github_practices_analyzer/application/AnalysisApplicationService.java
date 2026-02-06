package com.kauanunes.github_practices_analyzer.application;

import com.kauanunes.github_practices_analyzer.domain.heuristics.Heuristic;
import com.kauanunes.github_practices_analyzer.domain.model.AnalysisReport;
import com.kauanunes.github_practices_analyzer.infrastructure.github.GitHubClient;
import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import com.kauanunes.github_practices_analyzer.shared.MetricCalculator;
import org.springframework.stereotype.Service;

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

    public AnalysisReport analyze(String username) {

        var repos = gitHubClient.getRepositories(username)
                .collectList()
                .block();

        if (repos == null || repos.isEmpty()) {
            return AnalysisReport.empty(); //importante
        }

        var metrics = MetricCalculator.calculate(repos);
        var context = new AnalysisContext(metrics);

        heuristics.forEach(h -> h.analyze(context));

        return context.build();
    }
}
