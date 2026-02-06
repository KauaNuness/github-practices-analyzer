package com.kauanunes.github_practices_analyzer.domain.heuristics;

import com.kauanunes.github_practices_analyzer.shared.AnalysisContext;
import org.springframework.stereotype.Component;

@Component
public class CommitBehaviorHeuristic implements Heuristic {

    @Override
    public void analyze(AnalysisContext context) {

        if (!context.metrics().hasCommitHistoryMetrics()) {
            return;
        }

        double avgDays = context.metrics().getAverageDaysBetweenCommits();

        if (avgDays > 21) {
            context.recommend(
                    "Commits muito espaçados",
                    "O intervalo médio entre commits indica ciclos longos de desenvolvimento.",
                    "Considere dividir entregas em mudanças menores e mais frequentes."
            );
        } else {
            context.strength(
                    "Boa cadência de commits",
                    "Os commits são frequentes e bem distribuídos ao longo do tempo."
            );
        }
    }
}
